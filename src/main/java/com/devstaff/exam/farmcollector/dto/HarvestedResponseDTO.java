package com.devstaff.exam.farmcollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestedResponseDTO {
    private Collection<HarvestDTO> harvestInformation;
}
