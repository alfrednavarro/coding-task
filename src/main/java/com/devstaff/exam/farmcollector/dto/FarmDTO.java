package com.devstaff.exam.farmcollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmDTO {
    private Long farmId;
    private String name;
    private double area;
    private String areaUnit;
    private double actualAmountHarvested;
    private double expectedAmountHarvested;
    private String amountUnit;
}
