package com.salman.roomieBudgetTracker.service;

import com.salman.roomieBudgetTracker.entity.States;
import com.salman.roomieBudgetTracker.repository.StatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatesService {

    private final StatesRepository statesRepository;

    public StatesService(StatesRepository statesRepository) {
        this.statesRepository = statesRepository;
    }

    public List<States> getAll(){
        return statesRepository.findAll();
    }
}
