package by.epam.tr.dal.sax;

import by.epam.tr.device.Device;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class DeviceSaxHandler extends DefaultHandler {
    private List<Device> list = new ArrayList<>();
    private Device device = null;
    private StringBuilder text;

    public List<Device> getDeviceList() {
        return list;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        text = new StringBuilder();
        if (qName == "device") {
            device = new Device();
            device.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    public void endElement(String uri, String localName, String qName) {
        DeviceTagName tagName = DeviceTagName.valueOf(qName.toUpperCase().replace(":","_"));
        switch (tagName) {
            case NAME:
                device.setName(text.toString());
                break;
            case TYPE:
                device.setType(text.toString());
                break;
            case PRICE:
                device.setPrice(Double.parseDouble(text.toString()));
                break;
            case ORIGIN:
                device.setOrigin(text.toString());
                break;
            case CRITICAL:
                device.setCritical(Boolean.getBoolean(text.toString()));
                break;
            case DEVICE:
                list.add(device);
                device = null;
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.err.println("WARNING: line " +  e.getLineNumber() + "MESSAGE: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.err.println("ERROR: line " +  e.getLineNumber() + "MESSAGE: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.err.println("FATAL: line " +  e.getLineNumber() + "MESSAGE: " + e.getMessage());
        throw (e);
    }
}
