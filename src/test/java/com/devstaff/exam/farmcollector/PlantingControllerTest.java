package com.devstaff.exam.farmcollector;

import com.devstaff.exam.farmcollector.controller.PlantingController;
import com.devstaff.exam.farmcollector.dto.HarvestDTO;
import com.devstaff.exam.farmcollector.dto.HarvestedResponseDTO;
import com.devstaff.exam.farmcollector.service.PlantingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlantingControllerTest {

    @InjectMocks
    PlantingController plantingController;

    @Mock
    PlantingService plantingService;

    private HarvestedResponseDTO harvestedResponseDTO;
    @BeforeEach
    public void setup() {
        harvestedResponseDTO = new HarvestedResponseDTO();
        HarvestDTO harvestDTO = new HarvestDTO();
        harvestDTO.setCrop("Corn");
        harvestDTO.setFarm("MyFarm");
        harvestDTO.setSeason("summer");
        harvestDTO.setActualAmountHarvested(2100);
        harvestDTO.setFarmer("Alfred");
        harvestedResponseDTO.setHarvestInformation(Collections.singletonList(harvestDTO));
    }

    @Test
    public void getHarvestedForSeasonTest() {
        when(plantingService.getHarvestedForSeason(anyString())).thenReturn(harvestedResponseDTO);

        ResponseEntity<HarvestedResponseDTO> response = plantingController.getHarvestedForSeason("summer");

        Assertions.assertEquals(1, response.getBody().getHarvestInformation().size());
        Assertions.assertEquals("Corn", response.getBody().getHarvestInformation().get(0).getCrop());
        Assertions.assertEquals("MyFarm", response.getBody().getHarvestInformation().get(0).getFarm());
        Assertions.assertEquals("summer", response.getBody().getHarvestInformation().get(0).getSeason());
        Assertions.assertEquals(2100, response.getBody().getHarvestInformation().get(0).getActualAmountHarvested());
        Assertions.assertEquals("Alfred", response.getBody().getHarvestInformation().get(0).getFarmer());
    }

    @Test
    public void getHarvestedForFarmTest() {
        when(plantingService.getHarvestedForFarm(anyString())).thenReturn(harvestedResponseDTO);

        ResponseEntity<HarvestedResponseDTO> response = plantingController.getHarvestedForFarm("MyFarm");

        Assertions.assertEquals(1, response.getBody().getHarvestInformation().size());
        Assertions.assertEquals("Corn", response.getBody().getHarvestInformation().get(0).getCrop());
        Assertions.assertEquals("MyFarm", response.getBody().getHarvestInformation().get(0).getFarm());
        Assertions.assertEquals("summer", response.getBody().getHarvestInformation().get(0).getSeason());
        Assertions.assertEquals(2100, response.getBody().getHarvestInformation().get(0).getActualAmountHarvested());
        Assertions.assertEquals("Alfred", response.getBody().getHarvestInformation().get(0).getFarmer());
    }
}
