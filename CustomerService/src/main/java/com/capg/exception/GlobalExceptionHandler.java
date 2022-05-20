package com.capg.exception;
/*

  import org.springframework.beans.factory.annotation.Value; import
  org.springframework.http.HttpStatus; import
 org.springframework.http.ResponseEntity; import
 org.springframework.web.bind.annotation.ControllerAdvice; import
  org.springframework.web.bind.annotation.ExceptionHandler;
  
  @ControllerAdvice public class GlobalExceptionHandler {
  
  // Duplication of data exception
  
  @Value(value="${data.exception.msg}") 
  private String msg;
  
  @ExceptionHandler(value = CustomerAlreadyExistException.class) 
  public ResponseEntity<String> CustomerAlreadyExistException(CustomerAlreadyExistException dap){
	  return new ResponseEntity<String>(msg, HttpStatus.CONFLICT); }
  
 
  }
  
*/