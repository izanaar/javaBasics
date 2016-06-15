package com.spittr;

import com.spittr.config.splitted.RootConf;
import com.spittr.model.SimpleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    private static Logger logger = LoggerFactory.getLogger("TestContext");

    public static void main(String[] args) {
        ApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(RootConf.class);

        SimpleBean bean = (SimpleBean) annotationContext.getBean("firstBean");
        logger.info("First bean: {}", bean);

        logger.info("All SimpleBean instances in annotation-driven config:");
        Arrays.stream(annotationContext.getBeanNamesForType(SimpleBean.class))
                .forEach(logger::info);

        ApplicationContext xmlContext =
                new ClassPathXmlApplicationContext("mainXmlConf.xml");


        logger.info("All SimpleBean instances in xml-driven config:");
        Arrays.stream(xmlContext.getBeanNamesForType(SimpleBean.class))
                .forEach(logger::info);
    }
}
