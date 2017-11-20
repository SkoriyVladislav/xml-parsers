package by.epam.tr.service.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    void executeAction(HttpServletRequest request, HttpServletResponse response, String url, String type) throws IOException;
}
