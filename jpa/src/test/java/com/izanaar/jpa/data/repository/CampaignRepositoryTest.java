package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.config.RootConfig;
import com.izanaar.jpa.data.entities.Restaurant;
import com.izanaar.jpa.data.entities.User;
import com.izanaar.jpa.data.entities.campaign.AdvGroup;
import com.izanaar.jpa.data.entities.campaign.Advertisement;
import com.izanaar.jpa.data.entities.campaign.Campaign;
import com.izanaar.jpa.data.entities.enums.CampaignType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@ActiveProfiles("h2")
public class CampaignRepositoryTest {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AdvGroupRepository advGroupRepository;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Test
    public void testRepoInitialized() throws Exception {
        assertNotNull(campaignRepository);
        assertNotNull(userRepository);
    }


    @Test
    public void testSaveCampaign() throws Exception {
        User owner = userRepository.findOne(1L);
        Restaurant restaurant = new Restaurant("Blue oyster", "Pushkina Kolotushkina", 11L);

        restaurantRepository.save(restaurant);

        Campaign campaign = new Campaign();
        campaign.setOwner(owner);
        campaign.setCampaignType(CampaignType.GOOGLE);

        campaignRepository.save(campaign);

        AdvGroup group1 = new AdvGroup();
        group1.setCampaign(campaign);
        group1.setGroupId(44L);
        group1.setGroupName("Group 1");
        group1.setRestaurant(restaurant);

          advGroupRepository.save(group1);

        AdvGroup group2 = new AdvGroup();
        group2.setCampaign(campaign);
        group2.setGroupId(55L);
        group2.setGroupName("Group 2");
        group2.setRestaurant(restaurant);

        advGroupRepository.save(group2);

        campaign.setGroups(new ArrayList<>(Arrays.asList(group1, group2)));

        campaignRepository.save(campaign);

    }

    @Test
    public void getAdvGroup() throws Exception {
        AdvGroup group = advGroupRepository.findOne(4L);
        Campaign campaign = group.getCampaign();
        group.setGroupName("Group 1 XQ");
        advGroupRepository.save(group);
    }

    @Test
    public void testAddAdvertisement() throws Exception {
        AdvGroup group = advGroupRepository.findOne(4L);


        Advertisement advertisement = new Advertisement(group, 555L, "Some advertisement");
        advertisementRepository.save(advertisement);

/*        group.setAdvertisements(Collections.singletonList(advertisement));

        advGroupRepository.save(group);*/

    }


    @Test
    public void testGetAdvertisement() throws Exception {
        Advertisement advertisement = advertisementRepository.getOne(6L);
    }
}