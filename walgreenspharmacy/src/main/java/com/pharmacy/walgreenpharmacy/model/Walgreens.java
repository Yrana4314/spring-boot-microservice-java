package com.pharmacy.walgreenpharmacy.model;
import java.time.LocalDateTime;
import java.util.*;

import com.pharmacy.walgreenpharmacy.model.dto.AddressDTO;

import jakarta.persistence.*;
import lombok.*;



@NoArgsConstructor
@Getter
@Table
@Entity(name = "walgreens_tbl")
public class Walgreens {
	// unique id numbers
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//name of the walgreens' franchise owner
	@Setter
	private String name;
	
	//contact phone numbers
	@Setter
	@ElementCollection
	@CollectionTable(name = "phone",joinColumns = @JoinColumn(name = "id"))
	@Column(name = "phone")
	private List<String> phones;
	
	//latitude
	@Setter
	private double lat;
	
	//longitudes
	@Setter
	private double lon;
	
	//address
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
   
	private Address address;
	
	//Is Open
	@Setter
	@Column(name="has_covid_Vaccine")
	private boolean hasCovidVaccines;
	
	//created time and date
	@Column(name = "created_on")
	private LocalDateTime createdOn;
	
	public Walgreens(String name, List<String> phones, double lat,double lon,Address address,boolean covidVaccines,LocalDateTime createdOn) {
		this.name = name;
		this.phones = phones;
		this.lat=lat;
		this.lon = lon;
		this.address = address;
		this.hasCovidVaccines = covidVaccines;
		this.createdOn = createdOn;
	}
	

}
