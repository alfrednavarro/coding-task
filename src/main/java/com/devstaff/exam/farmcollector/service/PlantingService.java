package com.devstaff.exam.farmcollector.service;

import com.devstaff.exam.farmcollector.dto.PlantingRequestDTO;
import com.devstaff.exam.farmcollector.dto.PlantingResponseDTO;
import com.devstaff.exam.farmcollector.entities.Crop;
import com.devstaff.exam.farmcollector.entities.Farm;
import com.devstaff.exam.farmcollector.entities.Farmer;
import com.devstaff.exam.farmcollector.entities.Planting;
import com.devstaff.exam.farmcollector.entities.Season;
import com.devstaff.exam.farmcollector.repository.CropRepository;
import com.devstaff.exam.farmcollector.repository.FarmRepository;
import com.devstaff.exam.farmcollector.repository.FarmerRepository;
import com.devstaff.exam.farmcollector.repository.PlantingRepository;
import com.devstaff.exam.farmcollector.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantingService {

    @Autowired
    CropRepository cropRepository;

    @Autowired
    FarmerRepository farmerRepository;

    @Autowired
    FarmRepository farmRepository;

    @Autowired
    PlantingRepository plantingRepository;

    @Autowired
    SeasonRepository seasonRepository;

    public PlantingResponseDTO plant(PlantingRequestDTO plantingRequestDTO) {
        // Create Crop
        Crop crop = new Crop();
        crop.setName(plantingRequestDTO.getCrop().getName());
        crop.setDescription(plantingRequestDTO.getCrop().getDescription());
        crop = cropRepository.save(crop);

        // Create Farm
        Farm farm = new Farm();
        farm.setName(plantingRequestDTO.getFarm().getName());
        farm.setArea(plantingRequestDTO.getFarm().getArea());
        farm.setActualAmountHarvested(plantingRequestDTO.getFarm().getActualAmountHarvested());
        farm.setExpectedAmountHarvested(plantingRequestDTO.getFarm().getExpectedAmountHarvested());
        farm.setAreaUnit(plantingRequestDTO.getFarm().getAreaUnit());
        farm.setAmountUnit(plantingRequestDTO.getFarm().getAmountUnit());
        farm = farmRepository.save(farm);

        // Create Farmer
        Farmer farmer = new Farmer();
        farmer.setName(plantingRequestDTO.getFarmer().getName());
        farmerRepository.save(farmer);

        // Create Season
        Season season = new Season();
        season.setName(plantingRequestDTO.getSeason().getName());
        season = seasonRepository.save(season);


        // Planting
        Planting planting = new Planting();
        planting.setCrop(crop);
        planting.setSeason(season);
        planting.setFarmer(farmer);
        planting.setFarm(farm);
        plantingRepository.save(planting);



        return planting.plantingResponseDTO();
    }
}
