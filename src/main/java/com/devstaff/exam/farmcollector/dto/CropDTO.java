package com.devstaff.exam.farmcollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDTO {
    private Long cropId;
    private String name;
    private String description;
}
