package by.epam.tr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DeviceListService {
    void createDevicesList(HttpServletRequest request, HttpServletResponse response, String url, String type) throws IOException;
}
