package by.epam.tr.service.command.impl;

import by.epam.tr.service.command.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaxAction implements Action {

    @Override
    public void executeAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BookService service = new BookServiceImpl();
        req.setAttribute("books", service.parseSax());
        try {
            req.getRequestDispatcher("/saxPage.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }




}
