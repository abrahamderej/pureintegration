package com.pureItegratoin.assessment.assessment.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class BreedRepository {

    @Value("classpath:data/apidata.json")
    private Resource resource;

    Map<String, List<String>> listMap;

    public BreedRepository(){
        listMap = new TreeMap<>();
    }

    @PostConstruct
    public void init(){
        try {
            InputStream inputStream = resource.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            listMap = objectMapper.readValue(inputStream, TreeMap.class);

        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
            ioException.printStackTrace();
        }
    }

    public Map<String, List<String>> findAllBreeds(){
        return listMap;
    }
}
