package com.devstaff.exam.farmcollector.controller;

import com.devstaff.exam.farmcollector.dto.HarvestedResponseDTO;
import com.devstaff.exam.farmcollector.dto.PlantingRequestDTO;
import com.devstaff.exam.farmcollector.dto.PlantingResponseDTO;
import com.devstaff.exam.farmcollector.service.PlantingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/farm-collector")
public class PlantingController {

    @Autowired
    PlantingService plantingService;

    /**
     * Api to create Planting information
     * @param plantingRequestDTO
     * @return
     */
    @PostMapping(value = "/api/v1/planting")
    public ResponseEntity<PlantingResponseDTO> plant(@RequestBody PlantingRequestDTO plantingRequestDTO) {
        return ResponseEntity.ok(plantingService.plant(plantingRequestDTO));
    }

    /**
     * Api to get harvests for a season.
     * @param season
     * @return
     */
    @GetMapping(value = "/api/v1/harvest-per-season")
    public ResponseEntity<HarvestedResponseDTO> getHarvestedForSeason(@RequestParam String season) {
        return ResponseEntity.ok(plantingService.getHarvestedForSeason(season));
    }

    /**
     * Api to get harvest for a farm
     * @param farm
     * @return
     */
    @GetMapping(value = "/api/v1/harvest-per-farm")
    public ResponseEntity<HarvestedResponseDTO> getHarvestedForFarm(@RequestParam String farm) {
        return ResponseEntity.ok(plantingService.getHarvestedForFarm(farm));
    }

    /**
     * Api to get season report.
     * @return
     */
    @GetMapping(value = "/api/v1/harvest-season-report")
    public ResponseEntity<HarvestedResponseDTO> getSeasonReport() {
        return ResponseEntity.ok(plantingService.getSeasonReport());
    }
}
