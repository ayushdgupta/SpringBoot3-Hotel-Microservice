package com.guptaji.microservice.HotelMicroservice.service;

import com.guptaji.microservice.HotelMicroservice.entity.Hotel;

import java.util.List;

public interface HotelService {

  Hotel saveHotel(Hotel hotel);

  List<Hotel> getAllHotel();

  Hotel getHotelById(int id);
}
