package com.izanaar.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/request_info"})
public class RequestInfo extends HttpServlet {

    private final String LAST_VISIT_COOKIE_NAME = "last-visit";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("Request information:");
        writer.println("Content-type: " + req.getContentType());
        writer.println("Protocol: " + req.getProtocol());
        writer.println("Server: " + req.getServerName() + ":" + req.getServerPort());
        writer.println();

        Enumeration<String> e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = req.getHeader(name);
            writer.println(name + " = " + value);
        }

        writer.println();
        writer.println(getLastVisitDate(req, writer));



        Cookie cookie = new Cookie(LAST_VISIT_COOKIE_NAME, LocalDateTime.now().toString());
        resp.addCookie(cookie);
    }

    private String getLastVisitDate(HttpServletRequest req, PrintWriter writer) {
        Cookie[] cookies = req.getCookies();

        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(LAST_VISIT_COOKIE_NAME))
                .findAny().map(cookie -> "Haven't been there since " + cookie.getValue())
                .orElse("Haven't been there since ever");
    }

}
