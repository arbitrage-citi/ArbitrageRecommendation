package com.citi.exception;

public class StockNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6513666078709813858L;
	private String exceptionMessage;
	
	
	public StockNotFoundException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}


	public String getExceptionMessage() {
		return exceptionMessage;
	}


	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}	
	

}
