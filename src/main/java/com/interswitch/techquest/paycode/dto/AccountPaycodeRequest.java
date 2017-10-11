package com.interswitch.techquest.paycode.dto;

public class AccountPaycodeRequest extends PaycodeRequest{


	protected String msisdn;
	private String paymentMethodTypeCode;
	private String paymentMethodCode;
	private String providerToken;
	private String accountNo;
	private String accountType;
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
	public AccountPaycodeRequest(String msisdn, String accountNo, String accountType, String paymentMethodTypeCode, String paymentMethodCode, String providerToken, String transactionRef, String autoEnroll,
			String ttid, String amt, String fep, String tranType, String pwmChannel, String tokenLifeInMin, String oneTimePin)
	{		
		super(ttid, amt, fep, tranType, pwmChannel, tokenLifeInMin, oneTimePin);
		this.msisdn = msisdn;
		this.accountNo = accountNo;
		this.accountType = accountType;
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


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
