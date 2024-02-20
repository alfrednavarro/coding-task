package com.devstaff.exam.farmcollector.repository;

import com.devstaff.exam.farmcollector.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
