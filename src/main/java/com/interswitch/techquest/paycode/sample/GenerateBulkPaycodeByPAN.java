package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.paycode.Paycode;
import com.interswitch.techquest.paycode.dto.BulkPaycodeRequest;
import com.interswitch.techquest.paycode.dto.BulkPaycodeResponse;
import com.interswitch.techquest.paycode.dto.PaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;
import com.interswitch.techquest.paycode.dto.PaymentToken;

public class GenerateBulkPaycodeByPAN  extends BaseSample {

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
    		String oneTimePin = "1234";
    		String defaultAmt = "2000000";
    		String defaultPwmChannel = Paycode.CHANNEL.ATM.name();
    		String defaultTranType = Paycode.TRAN_TYPE.WITHDRWAL.name();
    		String defaultTokenLifeInMin = "1440";
    		String defaultOneTimePin = "1234";
    		String beneficiaryMsisdn = "2348124888436";
    		String batchSize = "2";
    		
    		PaycodeRequest[] paycodeRequests = new PaycodeRequest[2];
    		PaycodeRequest paycodeRequest1 = new PaycodeRequest(amt, beneficiaryMsisdn, oneTimePin);
    		PaycodeRequest paycodeRequest2 = new PaycodeRequest(amt, beneficiaryMsisdn, oneTimePin);
    		
    		paycodeRequests[0] = paycodeRequest1;
    		paycodeRequests[1] = paycodeRequest2;
    		BulkPaycodeRequest bulkPaycodeRequest = new BulkPaycodeRequest(batchSize, paymentMethodIdentifier, beneficiaryMsisdn, ttid, pan, expDate, cvv, pin, fep, defaultTranType, defaultPwmChannel, defaultOneTimePin, defaultAmt, defaultTokenLifeInMin, paycodeRequests);
    		BulkPaycodeResponse bulkPaycodeResponse = paycode.generateBulk(bulkPaycodeRequest);
    		String entries = bulkPaycodeResponse.getNumberOfEntries();
    		PaymentToken[] paymentTokens = bulkPaycodeResponse.getPaymentTokens();
    		
    		for(PaymentToken paymentToken : paymentTokens)
    		{
    			 String paycodeToken = paymentToken.getPayCode();
    			 String subscriber = paymentToken.getPhoneNumber();
    			 String expire = paymentToken.getExpiry();
    			 
    			 System.out.println("Paycode: " + paycodeToken);
    			 System.out.println("Subscriber: " + subscriber);
    			 System.out.println("Expire: " + expire);
    		}
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
