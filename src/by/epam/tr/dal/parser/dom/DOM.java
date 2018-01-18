package by.epam.tr.dal.parser.dom;

import by.epam.tr.device.Address;
import by.epam.tr.device.Device;
import by.epam.tr.resources.DeviceTagName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
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
            NodeList deviceNodes = doc.getElementsByTagName(DeviceTagName.DEVICE.getValue());
            list = new ArrayList<>();
            for (int i = 0; i < deviceNodes.getLength(); i++) {
                list.add(getDevice(deviceNodes.item(i)));
            }
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
            return null;
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (org.xml.sax.SAXException ex) {
            ex.printStackTrace();
            return null;
        }
        return list;
    }

    private static Device getDevice(Node node) throws XMLStreamException {
        Device device = new Device();
        device.setAddress(new Address());
        DeviceDOMBuilder deviceDOMBuilder = new DeviceDOMBuilder();
        return deviceDOMBuilder.buildDevice(node, device);
    }
}
