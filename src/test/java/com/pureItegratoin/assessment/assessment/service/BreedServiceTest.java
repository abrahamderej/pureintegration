package com.pureItegratoin.assessment.assessment.service;


import com.pureItegratoin.assessment.assessment.data.BreedRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BreedServiceTest {
    @InjectMocks
    BreedService breedService;
    @Mock
    BreedRepository breedRepository;

    @Test
    public void testGetAll(){
        Map<String, List<String>> stringListMap = new TreeMap<>();
        List<String> list = new ArrayList<>();
        list.add("american"); list.add("australian");
        stringListMap.put("terrier",list);

        Mockito.when(breedRepository.findAllBreeds()).thenReturn(stringListMap);
        Map<String, List<String>> listMap = breedService.getAllBreeds();
        Assertions.assertThat(stringListMap.get("terrier")).isEqualTo(listMap.get("terrier"));
    }

}
