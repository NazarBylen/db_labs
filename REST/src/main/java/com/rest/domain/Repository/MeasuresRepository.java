package com.rest.domain.Repository;

import com.rest.domain.domain.Measures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasuresRepository extends JpaRepository<Measures, Integer> {
    @Query(value = "CALL GetMaxMeasure(@a);", nativeQuery = true)
    Integer GetMaxMeasure();
}
