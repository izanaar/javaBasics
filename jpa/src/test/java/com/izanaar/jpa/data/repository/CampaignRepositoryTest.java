package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.config.RootConfig;
import com.izanaar.jpa.data.entities.Restaurant;
import com.izanaar.jpa.data.entities.campaign.AdvGroup;
import com.izanaar.jpa.data.entities.campaign.Campaign;
import com.izanaar.jpa.data.entities.enums.CampaignType;
import com.izanaar.jpa.data.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles("mySql")
public class CampaignRepositoryTest {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;



    @Test
    public void testRepoInitialized() throws Exception {
        assertNotNull(campaignRepository);
        assertNotNull(userRepository);
    }


    @Test
    public void testSaveCampaign() throws Exception {
        User owner = userRepository.findOne(1L);
        Restaurant restaurant = restaurantRepository.findOne(2L);

        Campaign campaign = new Campaign();
        campaign.setOwner(owner);
        campaign.setCampaignType(CampaignType.GOOGLE);

        AdvGroup group1 = new AdvGroup();
        group1.setCampaign(campaign);
        group1.setGroupId(44L);
        group1.setGroupName("Group 1");
        group1.setRestaurant(restaurant);

        AdvGroup group2 = new AdvGroup();
        group2.setCampaign(campaign);
        group2.setGroupId(55L);
        group2.setGroupName("Group 2");
        group2.setRestaurant(restaurant);

        campaign.setGroups(new ArrayList<>(Arrays.asList(group1, group2)));

        campaignRepository.save(campaign);

    }
}