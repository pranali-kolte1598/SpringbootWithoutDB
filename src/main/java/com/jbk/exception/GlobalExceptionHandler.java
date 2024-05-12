package com.jbk.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 
 @ExceptionHandler(ResourceAlreadyExitsException.class) 
 public  CustomExceptionResponse ResourceAlreadyExitsException (ResourceAlreadyExitsException ex,HttpServletRequest request) {
	 String msg=ex.getMessage();
	 
	 String timeStamp=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
	String path=request.getRequestURI();
	CustomExceptionResponse response=new CustomExceptionResponse(path,timeStamp,msg);
	 
	return response;
 
 }
 
 @ExceptionHandler(ResourceNotExitsException.class)
 public CustomExceptionResponse ResourceNotExitsException(ResourceNotExitsException ex,HttpServletRequest request) {
	 String msg=ex.getMessage();
	 
	 String timeStamp=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(Calendar.getInstance().getTime());
		String path=request.getRequestURI();
		CustomExceptionResponse response=new CustomExceptionResponse(path,timeStamp,msg);
		 
	 
	 
	 return response;
 }
	
}
