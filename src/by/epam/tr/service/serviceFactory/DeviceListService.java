package by.epam.tr.service.serviceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DeviceListService {
    void createListUser(HttpServletRequest request, HttpServletResponse response, String url, String type) throws IOException;
}
