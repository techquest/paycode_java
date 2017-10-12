package com.interswitch.techquest.paycode.dto;

public class PANPaycodeRequest extends PaycodeRequest{


	protected String msisdn;
	protected String pan;
	protected String expDate;
	protected String cvv; 
	protected String pin;
	
	
	/***
	 * Use this constructor when creating Paycode request to generate from a PAN
	 * @param msisdn
	 * @param ttid
	 * @param pan
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
	public PANPaycodeRequest(String msisdn, String ttid, String pan, String expDate, String cvv, String pin, String amt, String fep, String tranType, String pwmChannel, String codeGenerationChannel, String tokenLifeInMin, String oneTimePin)
	{
		super(ttid, amt, fep, tranType, pwmChannel, codeGenerationChannel, tokenLifeInMin, oneTimePin);
		this.msisdn = msisdn; 
		this.pan = pan;
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
	
	
	
}
