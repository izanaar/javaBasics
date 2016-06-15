package com.izanaar.jpa.service;

import com.izanaar.jpa.data.entities.campaign.Campaign;
import com.izanaar.jpa.data.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public void saveCampaign(Campaign campaign){
        campaignRepository.save(campaign);
    }

    public Campaign getCampaign(Long id){
        return campaignRepository.getOne(id);
    }

}
