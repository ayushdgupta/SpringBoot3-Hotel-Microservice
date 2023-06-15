package com.guptaji.microservice.HotelMicroservice.service.impl;

import com.guptaji.microservice.HotelMicroservice.entity.Hotel;
import com.guptaji.microservice.HotelMicroservice.repositories.HotelRepo;
import com.guptaji.microservice.HotelMicroservice.service.HotelService;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

  Logger LOG = LogManager.getLogger(HotelServiceImpl.class);

  @Autowired private HotelRepo hotelRepo;

  @Override
  public Hotel saveHotel(Hotel hotel) {
    LOG.info("Hit saveHotel Service");
    Hotel savedHotel = hotelRepo.save(hotel);
    return savedHotel;
  }

  @Override
  public List<Hotel> getAllHotel() {
    LOG.info("Hit getAllHotel Service");
    List<Hotel> hotelList = hotelRepo.findAll();
    return hotelList;
  }

  @Override
  public Hotel getHotelById(int id) {
    LOG.info("Hit getHotelById Service");
    Hotel hotel =
        hotelRepo
            .findById(id)
            .orElseThrow(
                () -> new NoSuchElementException("No hotel present in DB for the id " + id));
    return hotel;
  }
}
