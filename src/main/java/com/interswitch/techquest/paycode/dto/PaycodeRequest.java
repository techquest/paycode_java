package com.interswitch.techquest.paycode.dto;

public class PaycodeRequest {

	public PaycodeRequest(String msisdn, String ttid, String paymentMethodIdentifier, String pan, String expDate, String cvv, String pin, String amt, String fep, String tranType, String pwmChannel, String tokenLifeInMin, String oneTimePin)
	{
		this.msisdn = msisdn;
		this.ttid = ttid;
		this.paymentMethodIdentifier = paymentMethodIdentifier;
		this.pan = pan;
		this.expDate = expDate;
		this.cvv = cvv; 
		this.pin = pin;
		this.amt = amt;
		this.fep = fep;
		this.tranType = tranType;
		this.pwmChannel = pwmChannel;
		this.tokenLifeInMin = tokenLifeInMin;
		this.oneTimePin = oneTimePin;
	}
	
	public PaycodeRequest(String amt, String beneficiaryMsisdn, String oneTimePin)
	{
		this.amt = amt;
		this.beneficiaryMsisdn = beneficiaryMsisdn;
		this.oneTimePin = oneTimePin;
	}
	
	
	String msisdn;
	String ttid;
	String paymentMethodIdentifier;
	String pan;
	String expDate;
	String cvv; 
	String pin;
	String amt;
	String fep;
	String tranType;
	String pwmChannel;
	String tokenLifeInMin;
	String oneTimePin;
	String beneficiaryMsisdn;
	
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
	public String getPaymentMethodIdentifier() {
		return paymentMethodIdentifier;
	}
	public void setPaymentMethodIdentifier(String paymentMethodIdentifier) {
		this.paymentMethodIdentifier = paymentMethodIdentifier;
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
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getFep() {
		return fep;
	}
	public void setFep(String fep) {
		this.fep = fep;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getPwmChannel() {
		return pwmChannel;
	}
	public void setPwmChannel(String pwmChannel) {
		this.pwmChannel = pwmChannel;
	}
	public String getTokenLifeInMin() {
		return tokenLifeInMin;
	}
	public void setTokenLifeInMin(String tokenLifeInMin) {
		this.tokenLifeInMin = tokenLifeInMin;
	}
	public String getOneTimePin() {
		return oneTimePin;
	}
	public void setOneTimePin(String oneTimePin) {
		this.oneTimePin = oneTimePin;
	}
	public String getBeneficiaryMsisdn() {
		return beneficiaryMsisdn;
	}
	public void setBeneficiaryMsisdn(String beneficiaryMsisdn) {
		this.beneficiaryMsisdn = beneficiaryMsisdn;
	}
	
	
	
	
//	String batchSize = "2";
//	HashMap<String, String> addition =  new HashMap<String, String>();
//	addition.put("type", "bulk");
//	String defaultOneTimePin = "1234";
//	String referenceId =  " ";
//	do {
//		referenceId =  String.valueOf(random.nextInt(999999999));
//	}while(referenceId.startsWith("0"));
//	
//	String resourceUrl = Constants.PWM_BULK_BASE_URL +"tokens";
//	
//	JSONObject json = new JSONObject();
//	json.put("additionalInfo", addition);
//	json.put("amount", amount);
//	json.put("batchSize", batchSize);
//	json.put("channel", payWithMobileChannel);
//	json.put("defaultOneTimePin", defaultOneTimePin);
//	json.put("entries", list);
//	json.put("macData", macData);
//	json.put("paymentMethodIdentifier", paymentMethodIdentifier);
//	json.put("pinBlock", pinBlock);
//	json.put("referenceId", referenceId);
//	json.put("secure", secureData);
//	json.put("subscriberId", msisdn);
//	json.put("tokenLifeTimeInMinutes", tokenLifeTimeInMinutes);
//	json.put("ttid", ttid);
//	json.put("macData", macData);
	
}
