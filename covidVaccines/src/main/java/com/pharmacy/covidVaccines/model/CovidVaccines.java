package com.pharmacy.covidVaccines.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CovidVaccines{
        //@GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String vaccineType;  //pfizer,moderna,johnson
        private String doseType; //I,II,III(booster)

        public CovidVaccines(String vaccineType,String doseType){
                this.vaccineType = vaccineType;
                this.doseType = doseType;
        }
}