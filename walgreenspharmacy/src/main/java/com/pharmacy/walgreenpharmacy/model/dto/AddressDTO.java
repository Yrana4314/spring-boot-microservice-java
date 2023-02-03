package com.pharmacy.walgreenpharmacy.model.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//DTO => Data Transfer Object
public class AddressDTO {
	    
	    //street address
		private String street="6070 linden";
		
		//city
		private String city="queens";
		
		//state or provience
		private String state="NY";
		
		//zipcode
		private Long zipcode=11385L;

}
