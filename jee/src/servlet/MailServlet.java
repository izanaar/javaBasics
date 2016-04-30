package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(urlPatterns = {"/send_mail"},
        initParams = {
                @WebInitParam(name = "config-path", value = "/config/mail.properties")
        })
public class MailServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String host, port, name, password;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();

        String path = getInitParameter("config-path");


        try {
            properties.load(getServletContext().getResourceAsStream(path));
            host = properties.getProperty("mail.smtp.host");
            port = properties.getProperty("mail.smtp.port");
            name = properties.getProperty("mail.user.name");
            password = properties.getProperty("mail.user.password");

            logger.trace("Mail properties have been initialized.");

        } catch (Exception e) {
            logger.error("Couldn't load properties. Exception: {}", e.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("sender", name);
        req.getRequestDispatcher("/WEB-INF/pages/mailSending.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
