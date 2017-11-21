package by.epam.tr.dao;

import by.epam.tr.dao.impl.DeviceDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final DeviceDAO entityDAO = new DeviceDAOImpl();

    private DAOFactory() {
    }

    public DeviceDAO getDeviceDAO() {
        return entityDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
