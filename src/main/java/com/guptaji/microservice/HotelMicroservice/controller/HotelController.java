package com.guptaji.microservice.HotelMicroservice.controller;

import com.guptaji.microservice.HotelMicroservice.entity.Hotel;
import com.guptaji.microservice.HotelMicroservice.service.impl.HotelServiceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

  Logger LOG = LogManager.getLogger(HotelController.class);

  @Autowired private HotelServiceImpl hotelService;

  @PostMapping
  public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
    LOG.info("Hit createHotel API");
    Hotel savedHotel = hotelService.saveHotel(hotel);
    return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getHotelById(@PathVariable("id") int hotelId) {
    LOG.info("Hit getHotelById API");
    Hotel hotel = hotelService.getHotelById(hotelId);
    return new ResponseEntity<>(hotel, HttpStatus.FOUND);
  }

  @GetMapping
  public ResponseEntity<?> getAllHotels() {
    LOG.info("Hit getAllHotels API");
    List<Hotel> hotelList = hotelService.getAllHotel();
    return new ResponseEntity<>(hotelList, HttpStatus.OK);
  }
}
