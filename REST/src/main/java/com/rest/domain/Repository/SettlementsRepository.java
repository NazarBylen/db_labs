package com.rest.domain.Repository;

import com.rest.domain.domain.Settlements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementsRepository extends JpaRepository<Settlements, Integer> {
}
