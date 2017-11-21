package by.epam.tr.service.sax;

import by.epam.tr.device.Device;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.text.Document;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class SAX {
    public static List<Device> parse(File link){
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DeviceSaxHandler handler = new DeviceSaxHandler();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);
            /*URL fileURL = SAX.class.getClassLoader().getResource(link);
            URI fileURI = null;
            try {
                fileURI = fileURL.toURI();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
            File file = new File(fileURI);*/
            reader.parse(new InputSource(new InputStreamReader(new FileInputStream(link))));
            return handler.getDeviceList();
        }catch (IOException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
