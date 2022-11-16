package com.rest.domain.Service;

import com.rest.domain.Repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CountriesService implements CountriesServiceInterface {
    public CountriesRepository repository;

    @Autowired
    public CountriesService(@Qualifier("countriesRepository") CountriesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Integer createBunchOfCountries() {
        return repository.CreateBunchOfCountries();
    }

    @Override
    public void CreateDatabasesUsingCursors() {
        repository.CreateDatabasesUsingCursors();
    }
}
