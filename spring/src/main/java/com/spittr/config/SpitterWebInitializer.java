package com.spittr.config;

import com.spittr.listener.Context;
import com.spittr.listener.Session;
import com.spittr.servlet.CustomServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class, DataConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setInitParameter("initRegParam","Tempest keep blah blah blah");

        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement("/tmp/spittr/uploads", 2097152, 4194304, 0);

        registration.setMultipartConfig(multipartConfigElement);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        servletContext.addListener(new Context());
        servletContext.addListener(new Session());

        ServletRegistration.Dynamic mySevlet =
                servletContext.addServlet("myServlet", CustomServlet.class);

        mySevlet.addMapping("/custom");
        mySevlet.setInitParameter("paramx","Your personal init parameter");
    }

}


