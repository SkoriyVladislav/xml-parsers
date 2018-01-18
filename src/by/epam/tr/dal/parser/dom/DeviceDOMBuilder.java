package by.epam.tr.dal.parser.dom;

import by.epam.tr.device.Device;
import by.epam.tr.resources.DeviceTagName;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.stream.XMLStreamException;

public class DeviceDOMBuilder{
    public Device buildDevice(Node node, Device device) throws XMLStreamException {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            device.setName(getTagValue(DeviceTagName.NAME.getValue(), element));
            device.getAddress().setCountry(getTagValue(DeviceTagName.COUNTRY.getValue(), element));
            device.getAddress().setCity(getTagValue(DeviceTagName.CITY.getValue(), element));
            device.getAddress().setStreet(getTagValue(DeviceTagName.STREET.getValue(), element));
            device.getAddress().setType(element.getAttribute(DeviceTagName.TYPE.getValue()));
            device.setPrice(Double.parseDouble(getTagValue(DeviceTagName.PRICE.getValue(), element)));
            device.setOrigin(getTagValue(DeviceTagName.ORIGIN.getValue(), element));
            device.setCritical(Boolean.getBoolean(getTagValue(DeviceTagName.CRITICAL.getValue(), element)));
        }
        return device;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
