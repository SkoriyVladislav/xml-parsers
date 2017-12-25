package by.epam.tr.dal.parser.stax;

import by.epam.tr.device.Address;
import by.epam.tr.device.Device;
import by.epam.tr.resources.DeviceTagName;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAX {
    public static List<Device> parse(File file) {
        List<Device> devices = null;
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream(file);

            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            devices = process(reader);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
            return null;
        }
        return devices;
    }

    private static List<Device> process(XMLStreamReader reader) throws  XMLStreamException {
        List<Device> devices = new ArrayList<>();
        Device device = null;
        String elementName = null;

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if (DeviceTagName.DEVICE.getValue().equals(reader.getLocalName())) {
                        device = new Device();
                        device.setId(Integer.parseInt(reader.getAttributeValue(0)));
                    }
                    if (DeviceTagName.DEVICES.getValue().equals(reader.getLocalName())) {
                        devices = new ArrayList<>();
                    }
                    if (DeviceTagName.ADDRESS.getValue().equals(reader.getLocalName())) {
                        Address address = new Address();
                        String type = reader.getAttributeValue((0));
                        if (type == null) {
                            type = DeviceTagName.DEFAULT_TYPE.getValue();
                        }
                        address.setType(type);
                        device.setAddress(address);
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    elementName = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (DeviceTagName.valueOf(reader.getLocalName().toUpperCase())) {
                        case DEVICE:
                            devices.add(device);
                            break;
                        case NAME:
                            device.setName(elementName);
                            break;
                        case PRICE:
                            device.setPrice(Double.parseDouble(elementName));
                            break;
                        case ORIGIN:
                            device.setOrigin(elementName);
                            break;
                        case COUNTRY:
                            device.getAddress().setCountry(elementName);
                            break;
                        case CITY:
                            device.getAddress().setCity(elementName);
                            break;
                        case STREET:
                            device.getAddress().setStreet(elementName);
                            break;
                        case CRITICAL:
                            device.setCritical(Boolean.getBoolean(elementName));
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    devices = new ArrayList<>();
                    break;
            }
        }
        return devices;
    }
}
