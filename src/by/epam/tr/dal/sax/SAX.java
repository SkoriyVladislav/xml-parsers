package by.epam.tr.dal.sax;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAX {
    public static void parse(String link) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        DeviceSaxHandler handler = new DeviceSaxHandler();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.parse(new InputSource(link));
    }
}
