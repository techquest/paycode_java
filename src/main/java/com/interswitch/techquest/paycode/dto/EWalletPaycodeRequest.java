package com.interswitch.techquest.paycode.dto;

public class EWalletPaycodeRequest extends PaycodeRequest{


	protected String msisdn;
	String paymentMethodIdentifier;
	protected String expDate;
	protected String cvv; 
	protected String pin;
	
	
	
	
	
	
	/***
	 * Use this constructor when creating Paycode request to generate from an EWallet Payment Method
	 * @param ttid
	 * @param paymentMethodIdentifier
	 * @param expDate
	 * @param cvv
	 * @param pin
	 * @param amt
	 * @param fep
	 * @param tranType
	 * @param pwmChannel
	 * @param tokenLifeInMin
	 * @param oneTimePin
	 */
	public EWalletPaycodeRequest(String msisdn, String ttid, String paymentMethodIdentifier, String expDate, String cvv, String pin, String amt, String fep, String tranType, String pwmChannel, String codeGenerationChannel, String tokenLifeInMin, String oneTimePin)
	{
		super(ttid, amt, fep, tranType, pwmChannel, codeGenerationChannel, tokenLifeInMin, oneTimePin);
		this.msisdn = msisdn;
		this.ttid = ttid;
		this.paymentMethodIdentifier = paymentMethodIdentifier;
		this.expDate = expDate;
		this.cvv = cvv; 
		this.pin = pin;
	}





	public String getMsisdn() {
		return msisdn;
	}





	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}





	public String getPaymentMethodIdentifier() {
		return paymentMethodIdentifier;
	}





	public void setPaymentMethodIdentifier(String paymentMethodIdentifier) {
		this.paymentMethodIdentifier = paymentMethodIdentifier;
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
	
	
	
	
}
