package com.devstaff.exam.farmcollector.entities;

import com.devstaff.exam.farmcollector.dto.PlantingResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "planting")
public class Planting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long plantingId;

    @ManyToOne
    @JoinColumn(name = "farmerId", nullable = false)
    Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "cropId", nullable = false)
    Crop crop;

    @ManyToOne
    @JoinColumn(name = "farmId", nullable = false)
    Farm farm;

    @ManyToOne
    @JoinColumn(name = "seasonId", nullable = false)
    Season season;

    public PlantingResponseDTO plantingResponseDTO() {
        return new PlantingResponseDTO(
                plantingId,
                farmer.farmerDTO(),
                crop.cropDTO(),
                farm.farmDTO(),
                season.seasonDTO());
    }
}
