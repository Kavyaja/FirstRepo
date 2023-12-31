package com.kavyaja.restapi.messenger3.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorcode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	
public ErrorMessage(String errorMessage, int errorCode, String documentation) {
	super();
	this.errorMessage=errorMessage;
	this.errorcode=errorcode;
	this.documentation=documentation;		
	}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

public int getErrorcode() {
	return errorcode;
}

public void setErrorcode(int errorcode) {
	this.errorcode = errorcode;
}

public String getDocumentation() {
	return documentation;
}

public void setDocumentation(String documentation) {
	this.documentation = documentation;
}

	

}
