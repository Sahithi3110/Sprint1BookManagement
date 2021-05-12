package com.cg.bookstore.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookExceptionController extends ResponseEntityExceptionHandler{
	
  @ExceptionHandler(value = { NoBookException.class})
  public ResponseEntity<Object> handleBookException(NoBookException ex, WebRequest request)
  {
      String bodyOfResponse = ex.getLocalizedMessage();
	  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
   }

}
