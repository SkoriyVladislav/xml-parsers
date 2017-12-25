package by.epam.tr.dal.dao.impl;

import by.epam.tr.dal.dao.DeviceDAO;
import by.epam.tr.dal.parser.dom.DOM;
import by.epam.tr.dal.parser.sax.SAX;
import by.epam.tr.dal.parser.stax.StAX;
import by.epam.tr.device.Device;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DeviceDAOImpl implements DeviceDAO {

    @Override
    public List<Device> createDevicesList(String url, String type) {
        List<Device> list = new ArrayList<>();

        URL fileURL = DeviceDAOImpl.class.getClassLoader().getResource(url);
        URI fileURI = null;
        try {
            fileURI = fileURL.toURI();
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            return null;
        }
        File file = new File(fileURI);

        switch (type) {
            case "SAX":

                list = SAX.parse(file);
                break;

            case "StAX":
                list = StAX.parse(file);
                break;

            case "DOM":
                list = DOM.parse(file);
                break;

        }

        return list;
    }
}
