package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.paycode.Paycode;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;

public class GeneratePaycodeByAccount  extends BaseSample {

    public static void main(String[] args) {

        try {
        	
        	String pan = "5060990580000217499";
    		String expDate = "2004";
    		String cvv = "111";
    		String pin = "1111";    		
    		String amt = "2000000"; // Minor denomination. This is same as 20,000
    		String ttid = "809";
    		String fep = "445";
    		String msisdn = "2348124888436";
    		String paymentMethodIdentifier = "E192F3F3B3BA4596BC9704C44EA801BC"; // Do we need this?
    		String pwmChannel = Paycode.CHANNEL.ATM.name();
    		String tranType = Paycode.TRAN_TYPE.WITHDRWAL.name();
    		String tokenLifeInMin = "1440";
    		String oneTimePin = "1234";
    		
//            PaycodeResponse paycodeResponse = paycode.generateByPAN(msisdn, ttid, paymentMethodIdentifier, pan, expDate, cvv, pin, amt, fep, tranType, pwmChannel, tokenLifeInMin, oneTimePin);
//            String paycodeToken = paycodeResponse.getPayWithMobileToken();
//            String subscriber = paycodeResponse.getSubscriberId();
//            String expire = paycodeResponse.getTokenLifeTimeInMinutes();
//
//            System.out.println("Paycode: " + paycodeToken);
//            System.out.println("Subscriber: " + subscriber);
//            System.out.println("Expire: " + expire);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
