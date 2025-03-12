package com.example.countrytest.restcontroller;

import com.example.countrytest.model.Country;
import com.example.countrytest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/country/")
public class CountryRestController {

    @Autowired
    CountryService countryService;

    @GetMapping("get")
    public ResponseEntity<List<Country>> findAll() {
        List<Country> countryList = countryService.findAll();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@RequestBody Country country) {
        Country savedCountry = countryService.save(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> findById(@PathVariable long id) {
        Country country = countryService.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Country> update(@RequestBody Country country ,@PathVariable long id) {
        Country savedCountry = countryService.save(country);
        return new ResponseEntity<>(savedCountry, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<String>deleteCountryById(@PathVariable long id) {
         countryService.deleteCountryById(id);
         return new ResponseEntity<>("Country deleted", HttpStatus.OK);
    }
}
