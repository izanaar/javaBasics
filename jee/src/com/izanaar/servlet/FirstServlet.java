package com.izanaar.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;


public class FirstServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta = ((float) (gc.getTimeInMillis() - Long.parseLong(timeJsp))) / 1_000;
        request.setAttribute("res", delta);
        request.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        logger.debug("FirstServlet has been initialized.");
        logger.debug("The application is running on {}", getServletContext().getServerInfo());
        logger.debug("The name of application: {}", getServletContext().getServletContextName());
        getServletContext().setAttribute("creation-time", new Date().toString());
    }
}
