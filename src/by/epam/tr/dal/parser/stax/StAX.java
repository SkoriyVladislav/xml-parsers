package by.epam.tr.dal.parser.stax;

import by.epam.tr.device.Device;

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
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }

        devices.get(0).setType("StAX");
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
                    if ("device".equals(reader.getLocalName())) {
                        device = new Device();
                        device.setId(Integer.parseInt(reader.getAttributeValue(0)));
                    }
                    if ("devices".equals(reader.getLocalName())) {
                        devices = new ArrayList<>();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    elementName = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "device":
                            devices.add(device);
                            break;
                        case "name":
                            device.setName(elementName);
                            break;
                        case "price":
                            device.setPrice(Double.parseDouble(elementName));
                            break;
                        case "origin":
                            device.setOrigin(elementName);
                            break;
                        case "type":
                            device.setType(elementName);
                            break;
                        case "critical":
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
