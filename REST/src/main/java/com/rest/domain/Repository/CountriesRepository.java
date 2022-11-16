package com.rest.domain.Repository;

import com.rest.domain.domain.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {
    @Procedure
    @Query(value = "CALL CreateBunchOfCountries(@a);", nativeQuery = true)
    Integer CreateBunchOfCountries();

    @Procedure
    @Query(value = "CALL CreateDatabasesUsingCursors();", nativeQuery = true)
    void CreateDatabasesUsingCursors();
}
