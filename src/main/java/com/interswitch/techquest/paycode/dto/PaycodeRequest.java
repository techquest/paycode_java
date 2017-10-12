package com.interswitch.techquest.paycode.dto;

public class PaycodeRequest {
	
	protected String ttid;
	protected String amt;
	protected String fep;
	protected String tranType;
	protected String pwmChannel;
	protected String tokenLifeInMin;
	protected String oneTimePin;
	protected String beneficiaryMsisdn;
	protected String codeGenerationChannel;
	
	
	public PaycodeRequest(String ttid, String amt, String fep, String tranType, String pwmChannel, String codeGenerationChannel, String tokenLifeInMin, String oneTimePin)
	{
		this.ttid = ttid;
		this.amt = amt;
		this.fep = fep;
		this.tranType = tranType;
		this.pwmChannel = pwmChannel;
		this.codeGenerationChannel = codeGenerationChannel;
		this.tokenLifeInMin = tokenLifeInMin;
		this.oneTimePin = oneTimePin;
	}

	
	/***
	 * Use this constructor when creating Paycode request to generate bulk Paycode
	 * @param amt
	 * @param beneficiaryMsisdn
	 * @param oneTimePin
	 */
	public PaycodeRequest(String amt, String beneficiaryMsisdn, String oneTimePin)
	{
		this.amt = amt;
		this.beneficiaryMsisdn = beneficiaryMsisdn;
		this.oneTimePin = oneTimePin;
	}
	


	public String getTtid() {
		return ttid;
	}



	public void setTtid(String ttid) {
		this.ttid = ttid;
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


	public String getCodeGenerationChannel() {
		return codeGenerationChannel;
	}


	public void setCodeGenerationChannel(String codeGenerationChannel) {
		this.codeGenerationChannel = codeGenerationChannel;
	}
	

	
	
	
	
}
