package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.config.RootConfig;
import com.izanaar.jpa.data.entities.campaign.Campaign;
import com.izanaar.jpa.data.entities.enums.CampaignType;
import com.izanaar.jpa.data.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles("mySql")
public class CampaignRepositoryTest {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;



    @Test
    public void testRepoInitialized() throws Exception {
        assertNotNull(campaignRepository);
        assertNotNull(userRepository);
        User user = new User();
        user.setLogin("testUser");
        user.setLogin("testPass");
        userRepository.save(user);
    }


    @Test
    public void testSaveCampaign() throws Exception {
        User owner = userRepository.findOne(1L);

        Campaign campaign = new Campaign();
        campaign.setOwner(owner);
        campaign.setCampaignId("CCID442");
        campaign.setCampaignType(CampaignType.YANDEX);
        campaignRepository.save(campaign);
    }
}