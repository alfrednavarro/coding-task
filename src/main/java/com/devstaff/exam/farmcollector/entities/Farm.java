package com.devstaff.exam.farmcollector.entities;

import com.devstaff.exam.farmcollector.dto.FarmDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmId;

    private String name;
    private double area;
    private String areaUnit;
    private double actualAmountHarvested;
    private double expectedAmountHarvested;
    private String amountUnit;

    public FarmDTO farmDTO() {
        return new FarmDTO(
                farmId,
                name,
                area,
                areaUnit,
                actualAmountHarvested,
                expectedAmountHarvested,
                amountUnit);
    }
}
