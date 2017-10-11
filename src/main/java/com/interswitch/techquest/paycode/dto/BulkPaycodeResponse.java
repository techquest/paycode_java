package com.interswitch.techquest.paycode.dto;

public class BulkPaycodeResponse extends StatusError{

	private String numberOfEntries;
	private PaymentToken[] paymentTokens;
	
	public String getNumberOfEntries() {
		return numberOfEntries;
	}
	public void setNumberOfEntries(String numberOfEntries) {
		this.numberOfEntries = numberOfEntries;
	}
	public PaymentToken[] getPaymentTokens() {
		return paymentTokens;
	}
	public void setPaymentTokens(PaymentToken[] paymentTokens) {
		this.paymentTokens = paymentTokens;
	}
	
	
}
