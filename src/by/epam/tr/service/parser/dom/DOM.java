package by.epam.tr.service.parser.dom;

import by.epam.tr.device.Device;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOM {
    public static List<Device> parse(File file) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        List<Device> list = null;
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            NodeList bookNodes = doc.getElementsByTagName("book");
            list = new ArrayList<>();
            for (int i = 0; i < bookNodes.getLength(); i++) {
                list.add(getDevice(bookNodes.item(i)));
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (org.xml.sax.SAXException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    private static Device getDevice(Node node) {
        Device device = new Device();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            device.setName(getTagValue("name", element));
            device.setType(getTagValue("type", element));
            device.setPrice(Double.parseDouble(getTagValue("price", element)));
            device.setOrigin(getTagValue("origin", element));
            device.setCritical(Boolean.getBoolean(getTagValue("critical", element)));
        }
        return device;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
