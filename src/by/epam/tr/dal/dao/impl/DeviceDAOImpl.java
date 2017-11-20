package by.epam.tr.dal.dao.impl;

import by.epam.tr.dal.dao.DeviceDAO;
import by.epam.tr.dal.sax.SAX;
import by.epam.tr.dal.stax.StAX;
import by.epam.tr.device.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceDAOImpl implements DeviceDAO {

    @Override
    public List<Device> createListUser(String url, String type) {
        List<Device> list = new ArrayList<>();

        switch (type) {
            case "SAX":
                list = SAX.parse(url);
                break;

            case "StAX":
                list = StAX.parse(url);
                break;

        }

        return list;
    }
}
