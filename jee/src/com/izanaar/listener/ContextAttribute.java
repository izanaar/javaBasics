package com.izanaar.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextAttribute implements ServletContextAttributeListener{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        logger.trace("A new attribute has been added to the servlet {} context: {}-{}",
                servletContextAttributeEvent.getServletContext().getServletContextName(),
                servletContextAttributeEvent.getName(), servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }
}
