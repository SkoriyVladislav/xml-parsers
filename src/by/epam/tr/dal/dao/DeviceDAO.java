package by.epam.tr.dal.dao;

import by.epam.tr.device.Device;
import java.util.List;

public interface DeviceDAO {
    List<Device> createDevicesList(String url, String type);
}
