package com.devstaff.exam.farmcollector.entities;

import com.devstaff.exam.farmcollector.dto.CropDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Crop")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cropId;

    private String name;
    private String description;

    public CropDTO cropDTO() {
        return new CropDTO(
                cropId,
                name,
                description);

    }
}
