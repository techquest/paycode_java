package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.paycode.Paycode;
import com.interswitch.techquest.paycode.dto.AccountPaycodeRequest;
import com.interswitch.techquest.paycode.dto.Error;
import com.interswitch.techquest.paycode.dto.PANPaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;

public class GeneratePaycodeByAccount  extends BaseSample {

    public static void main(String[] args) {

        try {
        	
        	String accountNo = "0001122322";
        	String accountType = "Savings";
        	String paymentMethodTypeCode = "VMP";
        	String paymentMethodCode = "WEMA";
        	String providerToken = "3214253";
        	String transactionRef = "15051";
        	String autoEnroll = "false";
    		String amt = "2000000"; // Minor denomination. This is same as 20,000
    		String ttid = "809";
    		String fep = "445";
    		String msisdn = "2348124888436";
    		String pwmChannel = Paycode.CHANNEL.WEB.name();
    		String tranType = Paycode.TRAN_TYPE.WITHDRWAL.name();
    		String tokenLifeInMin = "1440";
    		String oneTimePin = "1234";

    		AccountPaycodeRequest paycodeRequest = new AccountPaycodeRequest(msisdn, accountNo, accountType, paymentMethodTypeCode, paymentMethodCode, providerToken, transactionRef, autoEnroll, ttid, amt, fep, tranType, pwmChannel, tokenLifeInMin, oneTimePin);
    		PaycodeResponse paycodeResponse = paycode.generateByAccount(paycodeRequest);
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
