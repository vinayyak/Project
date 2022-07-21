package com.vinni.service.implement;

import com.vinni.entity.Sales;
import com.vinni.entity.State;
import com.vinni.repository.SalesRepository;
import com.vinni.repository.StateRepository;
import com.vinni.service.StateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@Slf4j
@AllArgsConstructor
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;

    @Override
    public List<State> retrieveAllStates() {
        log.info("Starting to find all the States");
        List<State> total = stateRepository.retrieveAllStates();
        log.info("Finished finding all the States, Total record(s): {}", total.size());
        return total;
    }
}
