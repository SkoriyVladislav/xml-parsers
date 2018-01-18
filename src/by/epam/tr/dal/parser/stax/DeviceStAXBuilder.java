package by.epam.tr.dal.parser.stax;

import by.epam.tr.device.Address;
import by.epam.tr.device.Device;
import by.epam.tr.resources.DeviceTagName;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DeviceStAXBuilder {
    List<Device> devices = new ArrayList<>();
    Device device = null;
    String elementName = null;
    DeviceStAXBuilder deviceStAXBuilder = new DeviceStAXBuilder();

    private void initDevice(Device device, String elementName, DeviceTagName deviceTagName) {
        switch (deviceTagName) {
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
    }

    public List<Device> buildDevices(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (DeviceTagName.valueOf(reader.getLocalName().toUpperCase())) {
                        case DEVICE:
                            device = new Device();
                            device.setId(Integer.parseInt(reader.getAttributeValue(0)));
                            break;
                        case ADDRESS:
                            Address address = new Address();
                            String type = reader.getAttributeValue((0));
                            if (type == null) {
                                type = DeviceTagName.DEFAULT_TYPE.getValue();
                            }
                            address.setType(type);
                            device.setAddress(address);
                            break;
                        case DEVICES:
                            devices = new ArrayList<>();
                            break;
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
                        default:
                            deviceStAXBuilder.initDevice(device, elementName, DeviceTagName.valueOf(reader.getLocalName().toUpperCase()));
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
