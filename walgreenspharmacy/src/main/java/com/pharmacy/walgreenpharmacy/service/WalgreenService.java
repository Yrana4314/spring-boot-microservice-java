package com.pharmacy.walgreenpharmacy.service;


import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pharmacy.walgreenpharmacy.exception.WalgreensNotFoundException;
import com.pharmacy.walgreenpharmacy.model.Address;
import com.pharmacy.walgreenpharmacy.model.Walgreens;
import com.pharmacy.walgreenpharmacy.model.dto.AddressDTO;
import com.pharmacy.walgreenpharmacy.model.dto.WalgreensDTO;
import com.pharmacy.walgreenpharmacy.repository.WalgreensRepository;
@Service
public class WalgreenService {
	
	@Autowired
	WalgreensRepository walgreensRepository;
	
	public Iterable<Walgreens> getWalgreensList(){
		return walgreensRepository.findAll();
	}
	
	public Walgreens getWalgreensDetail(Long walgreensId) {
		Optional<Walgreens> optionalWalgreens = walgreensRepository.findById(walgreensId);
		
		if(optionalWalgreens.isPresent()) {
			return optionalWalgreens.get();
		}else {
			throw new WalgreensNotFoundException(String.format("GetWalgreensDetail- The walgreens with id %d is not present", walgreensId),404);
		}
	}
	public Walgreens createWalgreens(WalgreensDTO walgreensDTO) {
		AddressDTO addressDTO = walgreensDTO.getAddressdto();
		Address address = new Address(addressDTO.getStreet(),addressDTO.getCity(),addressDTO.getState(),addressDTO.getZipcode());
		Walgreens walgreens = new Walgreens(walgreensDTO.getName(),walgreensDTO.getPhones(),walgreensDTO.getLat(),walgreensDTO.getLon(),address,walgreensDTO.isCovidVaccines(),LocalDateTime.now());
		return walgreensRepository.save(walgreens);
		
	}
	public Walgreens updateWalgreens(Long walgreensId,WalgreensDTO walgreensDTO) {
		Optional<Walgreens> optionalWalgreens = walgreensRepository.findById(walgreensId);
		
		if(optionalWalgreens.isPresent()) {
			//code to update
			Walgreens walgreensToUpdate = optionalWalgreens.get();
			walgreensToUpdate.setName(walgreensDTO.getName());
			walgreensToUpdate.setLat(walgreensDTO.getLat());
			walgreensToUpdate.setLon(walgreensDTO.getLon());
			//walgreensToUpdate.setAddress(walgreensDTO.getAddressdto());
			walgreensToUpdate.setHasCovidVaccines(walgreensDTO.isCovidVaccines());
			return walgreensRepository.save(walgreensToUpdate);
		}else{
			throw new WalgreensNotFoundException(String.format("UpdateWalgreens-The walgreens with id %d is not present", walgreensId),404);
		}
		
	}
	public void deleteWalgreens(Long walgreensId) {
		Optional<Walgreens> optionalWalgreens  = walgreensRepository.findById(walgreensId);
		
		try {
			walgreensRepository.deleteById(walgreensId);
		}catch(EmptyResultDataAccessException ex){
			throw new WalgreensNotFoundException(String.format("DeleteWalgreens- The walgreens with id %d is not present", walgreensId),404);
		}
		
	}
	

}
