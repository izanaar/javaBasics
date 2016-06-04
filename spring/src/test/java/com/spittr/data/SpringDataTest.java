package com.spittr.data;

import com.spittr.config.data.DataSourcesConfig;
import com.spittr.config.data.SpringDataConfig;
import com.spittr.data.entities.Translation;
import com.spittr.data.jpa.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfig.class, DataSourcesConfig.class})
@ActiveProfiles("jpa-h2")
public class SpringDataTest {

    @Autowired
    private EntityManagerFactory managerFactory;

    @Autowired
    private TranslationJpRepository translationJpRepository;

    @Autowired
    private com.spittr.data.jpa.TranslationRepository translationRepository;

    @Test
    public void withEntityManagerFactory() throws Exception {
        Translation translation = new Translation("Tempest keep blah blah blah", "ru", "en");

        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(translation);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        translation = entityManager.find(Translation.class, 5L);
        entityManager.getTransaction().commit();

        System.out.println(translation);
    }

    @Test
    public void testLoadWithRepository() throws Exception {
        assertNotNull(translationJpRepository);
        System.out.println(translationJpRepository.find(5L));
    }

    @Test
    public void testLoadWithJpaRepository() throws Exception {
        assertNotNull(translationRepository);
        System.out.println(translationRepository.findOne(5L));
        translationRepository.findTranslationsToEnglish().forEach(System.out::println);
    }
}
