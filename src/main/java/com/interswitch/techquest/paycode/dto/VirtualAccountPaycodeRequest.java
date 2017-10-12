package com.interswitch.techquest.paycode.dto;

public class VirtualAccountPaycodeRequest extends PaycodeRequest{


	protected String msisdn;
	private String paymentMethodTypeCode;
	private String paymentMethodCode;
	private String providerToken;
	private String transactionRef;
	private String autoEnroll;
	
	
	/***
	 * Use this constructor when creating Paycode request to generate from a Bank Account
	 * @param msisdn
	 * @param accountNo
	 * @param accountType
	 * @param paymentMethodTypeCode
	 * @param paymentMethodCode
	 * @param providerToken
	 * @param transactionRef
	 * @param autoEnroll
	 * @param ttid
	 * @param amt
	 * @param fep
	 * @param tranType
	 * @param pwmChannel
	 * @param tokenLifeInMin
	 * @param oneTimePin
	 */
	public VirtualAccountPaycodeRequest(String msisdn, String paymentMethodTypeCode, String paymentMethodCode, String providerToken, String transactionRef, String autoEnroll,
			String ttid, String amt, String fep, String tranType, String pwmChannel, String codeGenerationChannel, String tokenLifeInMin, String oneTimePin)
	{		
		super(ttid, amt, fep, tranType, pwmChannel, codeGenerationChannel, tokenLifeInMin, oneTimePin);
		this.msisdn = msisdn;
		this.paymentMethodTypeCode = paymentMethodTypeCode; 
		this.paymentMethodCode = paymentMethodCode;
		this.providerToken = providerToken;
		this.transactionRef = transactionRef;
		this.autoEnroll = autoEnroll;
	}

	

	public String getMsisdn() {
		return msisdn;
	}



	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}



	public String getPaymentMethodTypeCode() {
		return paymentMethodTypeCode;
	}


	public void setPaymentMethodTypeCode(String paymentMethodTypeCode) {
		this.paymentMethodTypeCode = paymentMethodTypeCode;
	}


	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}


	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}


	public String getProviderToken() {
		return providerToken;
	}


	public void setProviderToken(String providerToken) {
		this.providerToken = providerToken;
	}

	public String getTransactionRef() {
		return transactionRef;
	}


	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}


	public String getAutoEnroll() {
		return autoEnroll;
	}


	public void setAutoEnroll(String autoEnroll) {
		this.autoEnroll = autoEnroll;
	}
	
	
	
	
}
