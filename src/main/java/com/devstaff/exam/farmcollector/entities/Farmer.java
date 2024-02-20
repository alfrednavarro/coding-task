package com.devstaff.exam.farmcollector.entities;

import com.devstaff.exam.farmcollector.dto.FarmDTO;
import com.devstaff.exam.farmcollector.dto.FarmerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Farmer")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmerId;

    private String name;

    public FarmerDTO farmerDTO() {
        return new FarmerDTO (
                farmerId,
                name);
    }
}
