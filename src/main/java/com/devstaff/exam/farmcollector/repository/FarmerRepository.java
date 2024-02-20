package com.devstaff.exam.farmcollector.repository;

import com.devstaff.exam.farmcollector.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
