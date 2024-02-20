package com.devstaff.exam.farmcollector.entities;

import com.devstaff.exam.farmcollector.dto.SeasonDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seasonId;

    private String name;

    public SeasonDTO seasonDTO() {
        return new SeasonDTO (
                    seasonId,
                    name
        );
    }
}
