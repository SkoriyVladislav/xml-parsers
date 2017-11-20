package by.epam.tr.service.impl;

import by.epam.tr.dal.dao.DAOFactory;
import by.epam.tr.dal.dao.DeviceDAO;
import by.epam.tr.dal.sax.SAX;
import by.epam.tr.dal.stax.StAX;
import by.epam.tr.device.Device;
import by.epam.tr.service.DeviceListService;
import by.epam.tr.service.command.Action;
import by.epam.tr.service.command.impl.SaxAction;
import by.epam.tr.service.command.impl.StaxAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeviceListServiceImpl implements DeviceListService {

    @Override
    public void createListUser(HttpServletRequest request, HttpServletResponse response, String url, String type) throws IOException {

        Action action = null;

        switch (type) {
            case "SAX":
                action = new SaxAction();
                break;

            case "StAX":
                action = new StaxAction();
                break;

        }

        action.executeAction(request, response, url, type);
    }
}
