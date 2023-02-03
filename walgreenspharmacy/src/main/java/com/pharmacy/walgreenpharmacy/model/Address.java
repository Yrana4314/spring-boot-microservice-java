package com.pharmacy.walgreenpharmacy.model;

import jakarta.persistence.*;
import lombok.*;

//Annotations for All arguments Constructor 

@NoArgsConstructor	//Annotation for No Arguments Constructor
	
@ToString
@Table
@Entity(name= "address_tbl")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	private Long id;

	//street address
	@Setter
	@Getter
	private String street;
	
	//city
	@Getter
	@Setter
	private String city;
	
	//state or provience
	@Getter
	@Setter
	private String state;
	
	//zipcode
	@Getter
	@Setter
	private Long zipcode;
	
	@OneToOne(mappedBy = "address")
    private Walgreens walgreen;
	
	public Address(String street,String city, String state,Long zipcode) {
		
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}

}
