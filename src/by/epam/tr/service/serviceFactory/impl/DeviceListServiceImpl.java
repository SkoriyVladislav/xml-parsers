package by.epam.tr.service.serviceFactory.impl;

import by.epam.tr.service.serviceFactory.DeviceListService;
import by.epam.tr.service.command.Action;
import by.epam.tr.service.command.impl.SaxAction;
import by.epam.tr.service.command.impl.StaxAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
