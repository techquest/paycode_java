package com.interswitch.techquest.paycode.dto;

public class PaycodeResponse extends StatusError{
	
	
	private String subscriberId;
	private String payWithMobileToken;
	private String tokenLifeTimeInMinutes;
	
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getPayWithMobileToken() {
		return payWithMobileToken;
	}
	public void setPayWithMobileToken(String payWithMobileToken) {
		this.payWithMobileToken = payWithMobileToken;
	}
	public String getTokenLifeTimeInMinutes() {
		return tokenLifeTimeInMinutes;
	}
	public void setTokenLifeTimeInMinutes(String tokenLifeTimeInMinutes) {
		this.tokenLifeTimeInMinutes = tokenLifeTimeInMinutes;
	}
	
	
	

}
