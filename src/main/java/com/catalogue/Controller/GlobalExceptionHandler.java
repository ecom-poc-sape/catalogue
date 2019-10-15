package com.catalogue.Controller;

import java.net.ConnectException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
 
	@ExceptionHandler(ConnectException.class)
	public String handleSQLException(HttpServletRequest request, ConnectException ex){
		System.out.println("---ConnectException While connecting to Inventory---");
		return "errorfromadvice";
	}
}
