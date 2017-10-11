package com.interswitch.techquest.paycode.dto;

public class EWalletPaymentMethodResponse extends StatusError{
	
	PaymentMethod[] paymentMethods;

	public PaymentMethod[] getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethod[] paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
	
	

}
