package com.vinni.controller;

import com.vinni.entity.City;
import com.vinni.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/states/{stateNo}/cities")
@RestController
@AllArgsConstructor
@Slf4j
public class CityController {

    private final CityService cityService;

    @ResponseBody
    @GetMapping("/all")
    public List<String> findAllByState(@PathVariable Long stateNo) {
        List<City> cityList = cityService.findCitiesByState(stateNo);
        log.info("========= All cities of State No {}: {}",
                stateNo,
                cityList.stream().map(City::getCityName).collect(Collectors.joining(", ")));

        return cityList.stream().map(City::getCityName).collect(Collectors.toList());
    }
}
