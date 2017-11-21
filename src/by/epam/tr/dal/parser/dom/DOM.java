package by.epam.tr.dal.parser.dom;

import by.epam.tr.device.Device;
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
            NodeList deviceNodes = doc.getElementsByTagName("device");
            list = new ArrayList<>();
            for (int i = 0; i < deviceNodes.getLength(); i++) {
                list.add(getDevice(deviceNodes.item(i)));
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (org.xml.sax.SAXException ex) {
            ex.printStackTrace();
        }

        list.get(0).setType("DOM");
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
