package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;



public class FirstServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getRemoteUser());
        GregorianCalendar gc = new GregorianCalendar();
        String timeJsp = request.getParameter("time");
        float delta = ((float)(gc.getTimeInMillis() - Long.parseLong(timeJsp)))/1_000;
        request.setAttribute("res", delta);
        request.getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("FirstServlet has been initialized.");
        System.out.println("Context param: " + getServletContext().getInitParameter("cparam"));
    }
}
