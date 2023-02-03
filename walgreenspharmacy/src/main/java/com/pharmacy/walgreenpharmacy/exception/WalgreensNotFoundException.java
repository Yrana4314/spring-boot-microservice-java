package com.pharmacy.walgreenpharmacy.exception;

import lombok.*;
import java.io.*;
@Getter
public class WalgreensNotFoundException extends RuntimeException{
	private String message;
	
	private int code;
	
	public WalgreensNotFoundException(String message, int code) {
		super(message);
		this.message = message;
		this.code = code;
	}

}
