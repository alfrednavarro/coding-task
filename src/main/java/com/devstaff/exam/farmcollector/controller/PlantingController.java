package com.devstaff.exam.farmcollector.controller;

import com.devstaff.exam.farmcollector.dto.CropDTO;
import com.devstaff.exam.farmcollector.dto.FarmDTO;
import com.devstaff.exam.farmcollector.dto.FarmerDTO;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/farm-collector")
public class PlantingController {

    @Autowired
    PlantingService plantingService;

    @PostMapping(value = "/v1/planting")
    public ResponseEntity<PlantingResponseDTO> plant(@RequestBody PlantingRequestDTO plantingRequestDTO) {
        return ResponseEntity.ok(plantingService.plant(plantingRequestDTO));
    }

//    @GetMapping(value = "/v1/planting/{id}")
//    public ResponseEntity<PlantingRequestDTO>  plant(@PathVariable("id") long id) {
//
//        return ResponseEntity.ok();
//
//    }
}
