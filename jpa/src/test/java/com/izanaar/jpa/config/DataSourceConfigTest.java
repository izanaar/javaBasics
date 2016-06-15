package com.izanaar.jpa.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
@ActiveProfiles("h2")
public class DataSourceConfigTest {

    @Autowired
    private DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testH2DataSourceBean() throws Exception {
        assertNotNull(dataSource);
        assertTrue(dataSource instanceof EmbeddedDatabase);
        logger.error("Data source config test passed.");
    }
}