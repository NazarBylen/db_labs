package com.rest.domain.Repository;

import com.rest.domain.domain.Measures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasuresRepository extends JpaRepository<Measures, Integer> {
}
