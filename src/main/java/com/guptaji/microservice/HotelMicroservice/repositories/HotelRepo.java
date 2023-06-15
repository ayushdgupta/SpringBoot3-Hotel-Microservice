package com.guptaji.microservice.HotelMicroservice.repositories;

import com.guptaji.microservice.HotelMicroservice.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {}
