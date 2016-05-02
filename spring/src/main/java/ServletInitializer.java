import config.RootConfig;
import config.WebConfig;
import listener.Context;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import servlet.CustomServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setInitParameter("initRegParam","Tempest keep blah blah blah");

        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/spittr/uploads",
                        2097152, 4194304, 0));
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        servletContext.addListener(new Context());
       // servletContext.addListener(new Session());

        ServletRegistration.Dynamic mySevlet =
                servletContext.addServlet("myServlet", CustomServlet.class);
        mySevlet.addMapping("/custom");
        mySevlet.setInitParameter("paramx","Your personal init parameter");
    }

}


