package com.example.countrytest.service;

import com.example.countrytest.model.Country;
import com.example.countrytest.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    final
    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public  List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(long id) {
        return countryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Country not found")
        );
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public Country update(Country country, long id) {
        return countryRepository.save(country);
    }

    public void  deleteCountryById(long id) {
        countryRepository.deleteById(id);
    }


}
