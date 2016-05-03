package com.izanaar.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletRequestAttribute implements ServletRequestAttributeListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        logger.trace("An attribute {} has been added to com.spittr.servlet request.", servletRequestAttributeEvent.getName());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        logger.trace("An attribute {} has been removed from the com.spittr.servlet request.", servletRequestAttributeEvent.getName());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        logger.trace("An attribute {} has been modified.", servletRequestAttributeEvent.getName());
    }
}
