package com.interswitch.techquest.paycode.dto;

public class BulkPaycodeRequest {

	public BulkPaycodeRequest(String batchSize, String paymentMethodIdentifier, String msisdn, String ttid, 
			String pan, String expDate, String cvv, String pin, String fep, String defaultTranType, String defaultPwmChannel, 
			String defaultOneTimePin, String defaultAmt, String defaultTokenLifeInMin, PaycodeRequest[] paycodeRequests)
	{
		this.batchSize = batchSize;
		this.paymentMethodIdentifier = paymentMethodIdentifier;
		this.msisdn = msisdn;
		this.ttid = ttid;
		this.pan = pan;
		this.expDate = expDate;
		this.cvv = cvv;
		this.pin = pin;
		this.fep = fep;
		this.defaultTranType = defaultTranType; 
		this.defaultPwmChannel = defaultPwmChannel;
		this.defaultOneTimePin = defaultOneTimePin;
		this.defaultAmt = defaultAmt;
		this.defaultTokenLifeInMin = defaultTokenLifeInMin;
		this.paycodeRequests = paycodeRequests;
	}
	
	String batchSize;
	String paymentMethodIdentifier;
	String msisdn;
	String ttid;
	String pan;
	String expDate;
	String cvv; 
	String pin;
	String fep;
	String defaultTranType;
	String defaultPwmChannel;
	String defaultOneTimePin;
	String defaultAmt;
	String defaultTokenLifeInMin;
	
	PaycodeRequest[] paycodeRequests;
	
	public String getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(String batchSize) {
		this.batchSize = batchSize;
	}
	public String getDefaultOneTimePin() {
		return defaultOneTimePin;
	}
	public void setDefaultOneTimePin(String defaultOneTimePin) {
		this.defaultOneTimePin = defaultOneTimePin;
	}
	public String getPaymentMethodIdentifier() {
		return paymentMethodIdentifier;
	}
	public void setPaymentMethodIdentifier(String paymentMethodIdentifier) {
		this.paymentMethodIdentifier = paymentMethodIdentifier;
	}
	
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public String getTtid() {
		return ttid;
	}
	public void setTtid(String ttid) {
		this.ttid = ttid;
	}
	public PaycodeRequest[] getPaycodeRequests() {
		return paycodeRequests;
	}
	public void setPaycodeRequests(PaycodeRequest[] paycodeRequests) {
		this.paycodeRequests = paycodeRequests;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getFep() {
		return fep;
	}
	public void setFep(String fep) {
		this.fep = fep;
	}
	public String getDefaultTranType() {
		return defaultTranType;
	}
	public void setDefaultTranType(String defaultTranType) {
		this.defaultTranType = defaultTranType;
	}
	public String getDefaultPwmChannel() {
		return defaultPwmChannel;
	}
	public void setDefaultPwmChannel(String defaultPwmChannel) {
		this.defaultPwmChannel = defaultPwmChannel;
	}
	public String getDefaultAmt() {
		return defaultAmt;
	}
	public void setDefaultAmt(String defaultAmt) {
		this.defaultAmt = defaultAmt;
	}
	public String getDefaultTokenLifeInMin() {
		return defaultTokenLifeInMin;
	}
	public void setDefaultTokenLifeInMin(String defaultTokenLifeInMin) {
		this.defaultTokenLifeInMin = defaultTokenLifeInMin;
	}
	
	
	
}
