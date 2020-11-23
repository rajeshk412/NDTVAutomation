package com.home.msite.exception;

public class ApplicationException extends Exception
{
	String message;
	public String getMessageName() {
		return message;
	}
	public void setMessageName(String messageName) {
		this.message = messageName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	String methodName;
	
	public ApplicationException()
	{
		
	}
	
	public ApplicationException(String methodName, String message)
	{
		super(message);
		this.methodName=methodName;
		this.message=message;
		
	}

}
