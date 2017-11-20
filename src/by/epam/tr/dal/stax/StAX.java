package by.epam.tr.dal.stax;

import by.epam.tr.resources.DeviceTagName;
import by.epam.tr.device.Device;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StAX {
    public static List<Device> parse(String url) {
        List<Device> devices = null;
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream(url);

            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            devices = process(reader);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
            System.exit(0);
        }

        return devices;
    }

    private static List<Device> process(XMLStreamReader reader) throws  XMLStreamException {
        List<Device> devices = new ArrayList<>();
        Device device = null;
        String elementName = null;

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                    switch (elementName) {
                        case "DEVICE":
                            device = new Device();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null,"id"));
                            device.setId(id);
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if(text.isEmpty()) {
                        break;
                    }

                    switch (elementName) {
                        case "NAME":
                            device.setName(text);
                            break;
                        case "TYPE":
                            device.setType(text);
                            break;
                        case "PRICE":
                            device.setPrice(Double.parseDouble(text));
                            break;
                        case "ORIGIN":
                            device.setOrigin(text);
                            break;
                        case "CRITICAL":
                            device.setCritical(Boolean.getBoolean(text));
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = reader.getLocalName();
                    switch (elementName) {
                        case "DEVICE":
                            devices.add(device);
                            break;
                    }
            }
        }
        return devices;
    }
}
