package com.pharmacy.walgreenpharmacy.model.dto;

import java.util.List;
import lombok.*;

import com.pharmacy.walgreenpharmacy.model.Address;

import jakarta.validation.constraints.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class WalgreensDTO {
	// unique id numbers
		//private String id;
		
		//name of the walgreens' franchise owner
		@NotNull
		@NotEmpty(message = "Name cannot be empty")
		private String name;
		
		
		//contact phone numbers
		@NotEmpty
		private List<String> phones;
		
		//latitude
		@Max(10)
		private double lat;
		
		//longitudes
		@Max(10)
		private double lon;
		
		//address
		private AddressDTO addressdto;
		
		//Is covid vaccine available
		private boolean covidVaccines;
		

}
