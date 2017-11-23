package by.epam.tr.service.impl;

import by.epam.tr.dal.dao.DAOFactory;
import by.epam.tr.dal.dao.DeviceDAO;
import by.epam.tr.device.Device;
import by.epam.tr.service.DeviceListService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeviceListServiceImpl implements DeviceListService {

    @Override
    public void createListUser(HttpServletRequest request, HttpServletResponse response, String url, String type) throws IOException {


        DAOFactory factory = DAOFactory.getInstance();
        DeviceDAO deviceDAO = factory.getDeviceDAO();
        List<Device> list = deviceDAO.createListUser(url, type);
        request.getSession().setAttribute("devices", list);
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
