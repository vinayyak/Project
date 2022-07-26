package com.vinni.service.implement;

import com.vinni.entity.City;
import com.vinni.repository.CityRepository;
import com.vinni.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@Slf4j
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> findCitiesByState(Long stateNo) {
        log.info("Starting to find all the Cities by State");
        List<City> cityList = cityRepository.findAllByState_StateNo(stateNo);
        log.info("Finished finding all the cities by State, Total record(s): {}", cityList.size());
        return cityList;
    }

}
