package com.izanaar.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    private final String name = "MY_TEST_COOKIE";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Cookie> cookieOptional = getCookieValue(req);
        if (cookieOptional.isPresent()) {
            Cookie cookie = cookieOptional.get();
            Date creationDate = new Date(Long.parseLong(cookie.getValue()));

            req.setAttribute("cookieStatus", "Cookie was created at: " + creationDate.toString());
            cookie.setValue(String.valueOf(new Date().getTime()));
            cookie.setMaxAge(5);
            resp.addCookie(cookie);
        } else {
            req.setAttribute("cookieStatus", "Cookie does not exist. Creating new one");
            Cookie cookie = new Cookie(name, String.valueOf(new Date().getTime()));
            cookie.setMaxAge(5);
            resp.addCookie(cookie);
        }

        req.getRequestDispatcher("/WEB-INF/pages/cookie/cookie.jsp").forward(req,resp);
    }

    private Optional<Cookie> getCookieValue(HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals(name))
                .findAny();
    }
}
