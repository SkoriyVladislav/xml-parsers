package by.epam.tr;

import by.epam.tr.dal.sax.SAX;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

public class main {
    public static void main(String... agr) {
        try {
            System.out.println(SAX.parse("devices.xml"));
        }catch (IOException | SAXException e) {
            e.printStackTrace();
            System.out.println("Exept");
        }
    }
}
