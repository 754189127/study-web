package com.study.common;

public class SystemException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1404520460271605365L;

	public SystemException(String message){
		super(message);
	}
	
	public SystemException(String message,Throwable target){
		super(message,target);
	}
}
