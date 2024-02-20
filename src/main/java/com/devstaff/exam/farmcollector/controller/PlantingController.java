package com.devstaff.exam.farmcollector.controller;

import com.devstaff.exam.farmcollector.dto.CropDTO;
import com.devstaff.exam.farmcollector.dto.FarmDTO;
import com.devstaff.exam.farmcollector.dto.FarmerDTO;
import com.devstaff.exam.farmcollector.dto.HarvestedResponseDTO;
import com.devstaff.exam.farmcollector.dto.PlantingRequestDTO;
import com.devstaff.exam.farmcollector.dto.PlantingResponseDTO;
import com.devstaff.exam.farmcollector.service.PlantingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/farm-collector")
public class PlantingController {

    @Autowired
    PlantingService plantingService;

    @PostMapping(value = "/api/v1/planting")
    public ResponseEntity<PlantingResponseDTO> plant(@RequestBody PlantingRequestDTO plantingRequestDTO) {
        return ResponseEntity.ok(plantingService.plant(plantingRequestDTO));
    }

    @GetMapping(value = "/api/v1/harvest-per-season")
    public ResponseEntity<HarvestedResponseDTO>  getHarvestedForSeason(@RequestParam String season) {
        return ResponseEntity.ok(plantingService.getHarvestedForSeason(season));
    }

    @GetMapping(value = "/api/v1/harvest-per-farm")
    public ResponseEntity<HarvestedResponseDTO>  getHarvestedForFarm(@RequestParam String farm) {
        return ResponseEntity.ok(plantingService.getHarvestedForFarm(farm));
    }

    @GetMapping(value = "/api/v1/harvest-season-report")
    public ResponseEntity<HarvestedResponseDTO>  getSeasonReport() {
        return ResponseEntity.ok(plantingService.getSeasonReport());
    }
}
