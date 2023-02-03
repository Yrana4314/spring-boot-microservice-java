package com.pharmacy.walgreenpharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.pharmacy.walgreenpharmacy.model.Address;
import com.pharmacy.walgreenpharmacy.model.Walgreens;
import com.pharmacy.walgreenpharmacy.model.dto.AddressDTO;
import com.pharmacy.walgreenpharmacy.model.dto.WalgreensDTO;
import com.pharmacy.walgreenpharmacy.service.WalgreenService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/api/v1")
public class WalgreensAPIController {
	@Autowired
	WalgreenService walgreenservice;
	
	
	
	//Needs to use @PathVariable way to ask specific walgreens details
	//localhost:8080/api/v1/walgreen/abc12345   <- abc12345 is id in url
	@Operation(summary = "Get a Walgreen by its id")
	@GetMapping(value = "/walgreen/{id}")
	public ResponseEntity<Walgreens> getWalgreendDetails(@Valid @PathVariable(value = "id") Long id){
		//System.out.println("ID => "+id);
		Walgreens walgreen = walgreenservice.getWalgreensDetail(id);
		return ResponseEntity.status(HttpStatus.OK).body(walgreen);
	}
	//post mapping 
	
	@Operation(summary = "Create a Walgreen ")
	@PostMapping(value = "/walgreen")
	public ResponseEntity<Walgreens> createWalgreens( @RequestBody WalgreensDTO walgreensdto){
		//System.out.println(walgreensdto);
		Walgreens createdWalgreens = walgreenservice.createWalgreens(walgreensdto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdWalgreens);
	}
	
	//TO UPDATE/DELETE WE NEED TO USE @PathVariable and @RequestBody because it needs to be specified which Walgreens OR ambulance obj is being updated/Deleted by new one
	//to update walgreen pharmacy PATH VARIABLE IS REQUIRD
	//localhost:8080/api/v1/walgreen/abc12345   <- abc12345 is id in url
	
	@Operation(summary="Update a walgreens Info")
	
	@PutMapping(value = "/walgreen/{id}")
	public ResponseEntity<Walgreens> updateWalgreen(@PathVariable(value = "id") Long id,@Valid  @RequestBody WalgreensDTO walgreendsdto){
		System.out.println("ID => "+id);
		Walgreens updateWalgreens = walgreenservice.updateWalgreens(id, walgreendsdto);
		return ResponseEntity.status(HttpStatus.OK).body(updateWalgreens);

	}
	
	//To Delete walgreens
	//By using PathVariable
	//localhost:8080/api/v1/walgreen/abc12345   <- abc12345 is id in url
	
	@Operation(summary = "delete a walgreen")
	
	@DeleteMapping(value = "/walgreen/{id}")
	//public ResponseEntity<String> deleteWalgreen(@PathVariable String id) {	}	if mapping value Id matches path variable Id USE THIS CONVENTION
	public ResponseEntity<String> deleteWalgreen(@PathVariable(value = "id") Long walgreensId){
		
		System.out.println(walgreensId);
		walgreenservice.deleteWalgreens(walgreensId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//RequestParam WITH REQUIRED REQUISTPARAM "FALSE"
	//REQUESTPARAM IS MOSTLY USED FOR FILTERATION
	
	
	@Operation(summary="Get walgreens list")
	@GetMapping(value = "/walgreen/list")
	public ResponseEntity<Iterable<Walgreens>> walgreenList(@RequestParam(value = "city",required = false)String cityName,@RequestParam(value = "lat",required = false) Double lat,@RequestParam(value = "lon",required = false) Double lon){
		Iterable<Walgreens> walgreensList = walgreenservice.getWalgreensList();
		return ResponseEntity.status(HttpStatus.OK).body(walgreensList);
	}
	
	

}
