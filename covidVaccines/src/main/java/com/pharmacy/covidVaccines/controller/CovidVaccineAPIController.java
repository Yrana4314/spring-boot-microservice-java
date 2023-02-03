package com.pharmacy.covidVaccines.controller;

import com.pharmacy.covidVaccines.model.CovidVaccines;
import com.pharmacy.covidVaccines.model.dto.CovidVaccinesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class CovidVaccineAPIController{

    @GetMapping(value = "/vaccine")
    public ResponseEntity<String> getVaccinesInfo(){
        String vaccineInfo = "First Dose of moderna, booster of pfizer and first Johnson&Johnson are available";
        return ResponseEntity.status(HttpStatus.OK).body(vaccineInfo);
        //return ResponseEntity.status(HttpStatus.CREATED).body(createdWalgreens);
    }
    @PostMapping(value = "/vaccine")
    public ResponseEntity<CovidVaccines> createVaccines(@RequestBody CovidVaccinesDTO covidVaccinesdto){
        CovidVaccines covidvaccine = new CovidVaccines(covidVaccinesdto.getVaccineType(),covidVaccinesdto.getDoseType());
        return ResponseEntity.status(HttpStatus.CREATED).body(covidvaccine);
    }
    @GetMapping(value = "/vaccine/list")
    public ResponseEntity<String> getAllVaccinesInfo(){
        String vaccineInfo = "Pfizer(I,II & booster), moderna(I,II,booster) and Johnson&Johnson(onlyI and booster)";
        return ResponseEntity.status(HttpStatus.OK).body(vaccineInfo);
        //return ResponseEntity.status(HttpStatus.CREATED).body(createdWalgreens);
    }
    /*
    @GetMapping(value = "/vaccine/{id}")
    public ResponseEntity<CovidVaccines> getCovidVaccinesById(@PathVariable (value = "id") Long id){

    }

     */
}