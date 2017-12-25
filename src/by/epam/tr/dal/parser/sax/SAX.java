package by.epam.tr.dal.parser.sax;

import by.epam.tr.device.Device;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.util.List;

public class SAX {
    public static List<Device> parse(File link){
        DeviceSaxHandler handler = null;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            handler = new DeviceSaxHandler();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            reader.parse(new InputSource(new InputStreamReader(new FileInputStream(link))));
        }catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (SAXException ex) {
            ex.printStackTrace();
            return null;
        }

        return handler.getDeviceList();
    }
}
