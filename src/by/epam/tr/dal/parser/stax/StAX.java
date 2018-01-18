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
import java.util.List;

public class StAX {

    public static List<Device> parse(File file) {
        List<Device> devices;
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
        DeviceStAXBuilder deviceStAXBuilder = new DeviceStAXBuilder();
        return deviceStAXBuilder.buildDevices(reader);
    }
}
