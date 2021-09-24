package com.pureItegratoin.assessment.assessment.service;

import com.pureItegratoin.assessment.assessment.data.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BreedService {

    private BreedRepository breedRepository;

    @Autowired
    public BreedService(BreedRepository breedRepository){
        this.breedRepository = breedRepository;
    }

    public Map<String, List<String>> getAllBreeds(){
        return breedRepository.findAllBreeds();
    }
}
