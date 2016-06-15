package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.data.entities.campaign.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long>{
}
