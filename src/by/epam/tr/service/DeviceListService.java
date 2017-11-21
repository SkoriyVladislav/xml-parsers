package by.epam.tr.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DeviceListService {
    public static int ELEMENTONPAGE = 4;
    void createListUser(HttpServletRequest request, HttpServletResponse response, String url, String type) throws IOException;
}
