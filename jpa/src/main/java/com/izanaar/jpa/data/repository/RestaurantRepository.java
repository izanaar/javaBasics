package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.data.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
