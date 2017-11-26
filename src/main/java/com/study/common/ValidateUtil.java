package com.study.common;

public class ValidateUtil {
	public static String throwIfBlank(String message,String target){
		if(target==null || target.trim().length()==0){
			throw new SystemException(message);
		}
		return message;
	}
	
	public static String $(String message,String target){
		return throwIfBlank(message, target);
	}
}
