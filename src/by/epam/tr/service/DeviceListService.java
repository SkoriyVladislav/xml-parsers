package by.epam.tr.service;

import by.epam.tr.device.Device;

import java.util.List;

public interface DeviceListService {
    List<Device> createListUser(String url, String type);
}
