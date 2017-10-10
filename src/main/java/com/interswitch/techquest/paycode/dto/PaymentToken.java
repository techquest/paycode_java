package com.interswitch.techquest.paycode.dto;

public class PaymentToken {

	 String phoneNumber;
	 String payCode;
	 String smsStatus;
	 String expiry;
	 String surcharge;
	 String errorMessage;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public String getSmsStatus() {
		return smsStatus;
	}
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getSurcharge() {
		return surcharge;
	}
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	 
	 
     
}
