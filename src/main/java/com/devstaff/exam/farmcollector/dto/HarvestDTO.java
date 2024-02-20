package com.devstaff.exam.farmcollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDTO {
    private String crop;
    private String farm;
    private String farmer;
    private String season;
    private double actualAmountHarvested;
}
