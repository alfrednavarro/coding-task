package com.devstaff.exam.farmcollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlantingRequestDTO {
    private Long plantingRequestId;
    private FarmerDTO farmer;
    private CropDTO crop;
    private FarmDTO farm;
    private SeasonDTO season;
}
