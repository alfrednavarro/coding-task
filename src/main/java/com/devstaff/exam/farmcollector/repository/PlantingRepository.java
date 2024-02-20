package com.devstaff.exam.farmcollector.repository;

import com.devstaff.exam.farmcollector.entities.Planting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantingRepository extends JpaRepository<Planting, Long> {

}
