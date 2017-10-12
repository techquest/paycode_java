package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.paycode.Paycode;
import com.interswitch.techquest.paycode.dto.BankAccountPaycodeRequest;
import com.interswitch.techquest.paycode.dto.Error;
import com.interswitch.techquest.paycode.dto.PANPaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;
import com.interswitch.techquest.paycode.dto.VirtualAccountPaycodeRequest;

public class GeneratePaycodeByVirtualAccount  extends BaseSample {

    public static void main(String[] args) {

        try {
        	
        	String paymentMethodTypeCode = "MMO";
        	String paymentMethodCode = "WEMA";
        	String providerToken = "3214253";
        	String transactionRef = "15051";
        	String autoEnroll = "false";
    		String amt = "2000000"; // Minor denomination. This is same as 20,000
    		String ttid = "809";
    		String fep = "WEMA";
    		String msisdn = "2348124888436";
    		String pwmChannel = Paycode.CHANNEL.ATM.name();
    		String codeGenerationChannel = Paycode.CHANNEL.Web.name();
    		String tranType = Paycode.TRAN_TYPE.Withdrawal.name();
    		String tokenLifeInMin = "1440";
    		String oneTimePin = "1234";

    		VirtualAccountPaycodeRequest paycodeRequest = new VirtualAccountPaycodeRequest(msisdn, paymentMethodTypeCode, paymentMethodCode, providerToken, transactionRef, autoEnroll, ttid, amt, fep, tranType, pwmChannel, codeGenerationChannel, tokenLifeInMin, oneTimePin);
    		PaycodeResponse paycodeResponse = paycode.generateByVirtualAccount(paycodeRequest);
    		if(paycodeResponse != null && paycodeResponse.getErrors() == null)
    		{
    			String paycodeToken = paycodeResponse.getPayWithMobileToken();
                String subscriber = paycodeResponse.getSubscriberId();
                String expire = paycodeResponse.getTokenLifeTimeInMinutes();

                System.out.println("Paycode: " + paycodeToken);
                System.out.println("Subscriber: " + subscriber);
                System.out.println("Expire: " + expire);
    		}
    		else
    		{
    			Error[] errors = paycodeResponse.getErrors();
    			Error error = errors[0];
    			System.out.println("Error Msg: " + error.getMessage());
    		}
                        
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
