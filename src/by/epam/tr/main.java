package by.epam.tr;

import by.epam.tr.dal.sax.SAX;
import by.epam.tr.dal.stax.StAX;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

public class main {
    public static void main(String... agr) {
        String url = "src/by/epam/tr/resources/devices.xml";
        try {
            System.out.println(SAX.parse(url));
            System.out.println(StAX.parse(url));
        }catch (IOException | SAXException e) {
            e.printStackTrace();
            System.out.println("Exept");
        }
    }
}
