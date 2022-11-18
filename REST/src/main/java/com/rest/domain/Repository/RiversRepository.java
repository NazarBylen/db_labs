package com.rest.domain.Repository;

import com.rest.domain.domain.Rivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface RiversRepository extends JpaRepository<Rivers, Integer> {
    @Procedure
    Integer CreateNewRiver(String newRiversName);
}
