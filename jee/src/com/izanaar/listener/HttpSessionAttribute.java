package com.izanaar.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class HttpSessionAttribute implements HttpSessionAttributeListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.trace("An attribute {} has been added to session {}.",
                httpSessionBindingEvent.getName(),httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.trace("An attribute {} has been removed from the session {}.",
                httpSessionBindingEvent.getName(),httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        logger.trace("An attribute {} has been replaced within session {}.",
                httpSessionBindingEvent.getName(),httpSessionBindingEvent.getSession().getId());
    }
}
