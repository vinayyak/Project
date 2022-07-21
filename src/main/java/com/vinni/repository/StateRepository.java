package com.vinni.repository;

import com.vinni.entity.City;
import com.vinni.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query("SELECT st FROM State st")
    List<State> retrieveAllStates();
}
