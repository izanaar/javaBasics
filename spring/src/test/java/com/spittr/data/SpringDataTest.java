package com.spittr.data;

import com.spittr.config.data.SpringDataConfig;
import com.spittr.data.entities.Translation;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataConfig.class)
public class SpringDataTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void notNull() throws Exception {
        Translation translation = new Translation("Tempest keep blah blah blah", "ru", "en");
        entityManager.persist(translation);

    }
}
