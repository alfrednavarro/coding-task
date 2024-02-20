package com.devstaff.exam.farmcollector.repository;

import com.devstaff.exam.farmcollector.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
