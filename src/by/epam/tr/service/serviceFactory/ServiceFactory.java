package by.epam.tr.service.serviceFactory;

import by.epam.tr.service.serviceFactory.impl.DeviceListServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final DeviceListService deviceListService = new DeviceListServiceImpl();

    private ServiceFactory() {

    }

    public DeviceListService getUserService() {
        return deviceListService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}
