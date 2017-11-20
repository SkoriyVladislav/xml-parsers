package by.epam.tr.service.impl;

import by.epam.tr.dal.dao.DAOFactory;
import by.epam.tr.dal.dao.DeviceDAO;
import by.epam.tr.device.Device;
import by.epam.tr.service.DeviceListService;

import java.util.List;

public class DeviceListServiceImpl implements DeviceListService {

    @Override
    public List<Device> createListUser(String url, String type) {
        DAOFactory factory = DAOFactory.getInstance();
        DeviceDAO applianceDAO = factory.getUserDAO();

        List<Device> list = applianceDAO.createListUser(url, type);

        return list;
    }
}
