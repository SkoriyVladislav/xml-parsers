package by.epam.tr;

import by.epam.tr.dal.sax.SAX;
import by.epam.tr.dal.stax.StAX;

public class main {
    public static void main(String... agr) {
        String url = "src/by/epam/tr/resources/devices.xml";
        System.out.println(SAX.parse(url));
        System.out.println(StAX.parse(url));
    }
}
