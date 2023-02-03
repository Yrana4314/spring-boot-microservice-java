package com.pharmacy.walgreenpharmacy.exception;

import java.net.http.HttpHeaders;
import java.sql.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HttpExceptionHandler extends ResponseEntityExceptionHandler{
	

protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
	HashMap<String,Object> errorResponseMap = new HashMap<>();
	errorResponseMap.put("ststus", "error");
	errorResponseMap.put("message", ex.getMessage());
	errorResponseMap.put("timestamp", new Date(0));
	return ResponseEntity.status(status).body(errorResponseMap);
}
}
