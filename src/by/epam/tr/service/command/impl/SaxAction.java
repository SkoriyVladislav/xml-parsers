package by.epam.tr.service.command.impl;

import by.epam.tr.dao.DAOFactory;
import by.epam.tr.dao.DeviceDAO;
import by.epam.tr.service.command.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaxAction implements Action {

    @Override
    public void executeAction(HttpServletRequest req, HttpServletResponse resp, String url, String type) throws IOException {
        DAOFactory factory = DAOFactory.getInstance();
        DeviceDAO deviceDAO = factory.getDeviceDAO();
        req.setAttribute("devices", deviceDAO.createListUser(url, type));
        try {
            req.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }




}
