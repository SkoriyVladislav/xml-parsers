package by.epam.tr.dal.dao;

import by.epam.tr.dal.dao.impl.DeviceDAOImpl;

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
