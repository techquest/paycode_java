package com.interswitch.techquest.auth.helpers;

public class Entries {
	
	private String oneTimePin;
	private String amount;
	private String beneficiaryNumber;
	public String getOneTimePin() {
		return oneTimePin;
	}
	public void setOneTimePin(String oneTimePin) {
		this.oneTimePin = oneTimePin;
	}
	public String getBeneficiaryNumber() {
		return beneficiaryNumber;
	}
	public void setBeneficiaryNumber(String beneficiaryNumber) {
		this.beneficiaryNumber = beneficiaryNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
