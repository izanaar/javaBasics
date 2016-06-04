package com.spittr.data;

import com.spittr.config.data.DataSourcesConfig;
import com.spittr.config.data.SpringDataConfig;
import com.spittr.data.entities.Translation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfig.class, DataSourcesConfig.class})
@ActiveProfiles("jpa-h2")
public class SpringDataTest {

    @Autowired
    private EntityManagerFactory managerFactory;

    @Test
    public void notNull() throws Exception {
        Translation translation = new Translation("Tempest keep blah blah blah", "ru", "en");

        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(translation);
        entityManager.getTransaction().commit();

        long id = translation.getId();

        translation = null;

        entityManager.getTransaction().begin();
        translation = entityManager.find(Translation.class, 5L);
        entityManager.getTransaction().commit();

        System.out.println(translation);
    }
}
