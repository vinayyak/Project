package com.vinni.repository;

import com.vinni.entity.StateCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateCityRepository extends JpaRepository<StateCity, Long> {

    @Query("SELECT sc FROM StateCity sc")
    List<StateCity> findAllStateCity();
}
