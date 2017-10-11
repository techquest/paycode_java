package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.paycode.Paycode;
import com.interswitch.techquest.paycode.dto.EWalletPaycodeRequest;
import com.interswitch.techquest.paycode.dto.EWalletPaymentMethodResponse;
import com.interswitch.techquest.paycode.dto.Error;
import com.interswitch.techquest.paycode.dto.PaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;
import com.interswitch.techquest.paycode.dto.PaymentMethod;

public class GeneratePaycodeByEWallet  extends BaseSample {

    public static void main(String[] args) {

        try {
        	
    		String expDate = "2004";
    		String cvv = "111";
    		String pin = "1111";    		
    		String amt = "2000000"; // Minor denomination. This is same as 20,000
    		String ttid = "809";
    		String fep = "445";
    		String pwmChannel = Paycode.CHANNEL.ATM.name();
    		String tranType = Paycode.TRAN_TYPE.WITHDRWAL.name();
    		String tokenLifeInMin = "1440";
    		String oneTimePin = "1234";
    		String accessToken = ""; // Get user access token from Interswitch Passport (https://sandbox.interswitchng.com/passport/oauth/authorize) or https://saturn.interswitchng.com/passport/oauth/authorize.
    		
    		EWalletPaymentMethodResponse eWalletPaymentMethodResponse = paycode.getEWalletPaymentMethod(accessToken);
    		if(eWalletPaymentMethodResponse != null && eWalletPaymentMethodResponse.getErrors() == null)
    		{
    			PaymentMethod paymentMethod = eWalletPaymentMethodResponse.getPaymentMethods()[0];
    			String paymentMethodIdentifier =  paymentMethod.getToken(); //"E192F3F3B3BA4596BC9704C44EA801BC"; 
    			
    			EWalletPaycodeRequest paycodeRequest = new EWalletPaycodeRequest(ttid, paymentMethodIdentifier, expDate, cvv, pin, amt, fep, tranType, pwmChannel, tokenLifeInMin, oneTimePin);
    			PaycodeResponse paycodeResponse = paycode.generateByEWallet(accessToken, paycodeRequest);
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
    		}
    		else
    		{
    			Error[] errors = eWalletPaymentMethodResponse.getErrors();
    			Error error = errors[0];
    			System.out.println("Error Msg: " + error.getMessage());
    		}
    		          
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
