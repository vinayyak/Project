package com.vinni.service;

import com.vinni.entity.City;

import java.util.List;

public interface CityService {
    List<City> findCitiesByState(Long stateNo);
}
