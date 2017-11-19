package by.epam.tr.dal.sax;

import by.epam.tr.device.Device;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SAX {
    public static List<Device> parse(String link) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        DeviceSaxHandler handler = new DeviceSaxHandler();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.parse(new InputSource("src/by/epam/tr/resources/devices.xml"));

        return handler.getDeviceList();
    }
}
