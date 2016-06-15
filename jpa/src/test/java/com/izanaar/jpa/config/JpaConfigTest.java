package com.izanaar.jpa.config;

import com.izanaar.jpa.data.repository.CampaignRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class,DataSourceConfig.class})
@ActiveProfiles("h2")
public class JpaConfigTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    public void emInitTest() throws Exception {
        assertNotNull(entityManager);
    }

    @Test
    public void jpaRepoInitTest() throws Exception {
        assertNotNull(campaignRepository);
    }
}