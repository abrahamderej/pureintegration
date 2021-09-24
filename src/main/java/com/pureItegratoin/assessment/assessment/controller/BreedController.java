package com.pureItegratoin.assessment.assessment.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pureItegratoin.assessment.assessment.service.BreedService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/breeds")
public class BreedController {

    BreedService breedService;

    @Autowired
    public BreedController(BreedService breedService){
        this.breedService = breedService;
    }

    @GetMapping("/list/all")
    public ResponseEntity<?> getAllBreeds(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", breedService.getAllBreeds());
        jsonObject.put("status", "success");

        return  new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }

}
