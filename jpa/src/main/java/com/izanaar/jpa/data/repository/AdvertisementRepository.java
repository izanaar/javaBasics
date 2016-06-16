package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.data.entities.campaign.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
