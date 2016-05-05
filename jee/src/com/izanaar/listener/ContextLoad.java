package com.izanaar.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoad implements ServletContextListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.trace("Context has been initialized.");
        servletContextEvent.getServletContext().addListener(new Session());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.trace("Context has been destroyed.");
    }
}
