package com.pharmacy.walgreenpharmacy.controlleradvice;


import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pharmacy.walgreenpharmacy.exception.WalgreensNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(WalgreensNotFoundException.class)
	public ResponseEntity<HashMap<String,Object>> handleWalgreensNotFoundException(WalgreensNotFoundException ex){
		HashMap<String,Object> errorResponseMap = new HashMap<>();
		errorResponseMap.put("status", "error");
		errorResponseMap.put("message", ex.getMessage());
		errorResponseMap.put("timestamp", LocalDateTime.now());
		return ResponseEntity.status(ex.getCode()).body(errorResponseMap);
	}

}
