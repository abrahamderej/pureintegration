package com.pureItegratoin.assessment.assessment.controller;

import com.pureItegratoin.assessment.assessment.service.BreedService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BreedController.class)
public class BreedControllerUnitTest {

    @MockBean
    private BreedService breedService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAll() throws Exception{
        Map<String, List<String>> stringListMap = new TreeMap<>();
        List<String> list = new ArrayList<>();
        list.add("american"); list.add("australian");
        stringListMap.put("terrier",list);

        Mockito.when(breedService.getAllBreeds()).thenReturn(stringListMap);


        mockMvc.perform(get("/api/breeds/list/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//
//                // Validate headers
//                .andExpect(header().string(HttpHeaders.LOCATION, "/rest/widget/1"))
//                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
//
//                // Validate the returned fields
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("Widget Name")))
//                .andExpect(jsonPath("$.description", is("Description")))
//                .andExpect(jsonPath("$.version", is(1)));
    }




}
