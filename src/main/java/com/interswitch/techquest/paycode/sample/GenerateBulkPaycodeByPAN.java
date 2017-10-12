package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.auth.Interswitch;
import com.interswitch.techquest.paycode.Paycode;
import com.interswitch.techquest.paycode.dto.BulkPaycodeRequest;
import com.interswitch.techquest.paycode.dto.BulkPaycodeResponse;
import com.interswitch.techquest.paycode.dto.Error;
import com.interswitch.techquest.paycode.dto.PaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;
import com.interswitch.techquest.paycode.dto.PaymentToken;

public class GenerateBulkPaycodeByPAN  extends BaseSample {

	private final static String clientId = "IKIAD8CEC8152D8E720E2CC7961C8EBBCD391A0DA0B6";
    private final static String clientSecret = "79EsDAYDw1mPiLre/z5RiqfH0XgMd8n2uKkThJ9YyA4=";
    protected static Paycode paycode = new Paycode(clientId, clientSecret, Interswitch.ENV_SANDBOX);
    
    public static void main(String[] args) {

        try {
        	
        	String pan = "5060990580000217499";
    		String expDate = "2004";
    		String cvv = "111";
    		String pin = "1111";    		
    		String amt = "2000000"; // Minor denomination. This is same as 20,000
    		String ttid = "809";
    		String fep = "WEMA";
    		String msisdn = "2348124888436";
    		String oneTimePin = "1234";
    		String defaultAmt = "4000000";
    		String defaultPwmChannel = Paycode.CHANNEL.ATM.name();
    		String defaultTranType = Paycode.TRAN_TYPE.Withdrawal.name();
    		String defaultTokenLifeInMin = "1440";
    		String defaultOneTimePin = "1234";
    		String beneficiaryMsisdn = "2348124888436";
    		String batchSize = "2";
    		
    		PaycodeRequest[] paycodeRequests = new PaycodeRequest[2];
    		PaycodeRequest paycodeRequest1 = new PaycodeRequest(amt, beneficiaryMsisdn, oneTimePin);
    		PaycodeRequest paycodeRequest2 = new PaycodeRequest(amt, beneficiaryMsisdn, oneTimePin);
    		
    		paycodeRequests[0] = paycodeRequest1;
    		paycodeRequests[1] = paycodeRequest2;
    		BulkPaycodeRequest bulkPaycodeRequest = new BulkPaycodeRequest(batchSize, msisdn, ttid, pan, expDate, cvv, pin, fep, defaultTranType, defaultPwmChannel, defaultOneTimePin, defaultAmt, defaultTokenLifeInMin, paycodeRequests);
    		BulkPaycodeResponse bulkPaycodeResponse = paycode.generateBulk(bulkPaycodeRequest);
    		
    		if(bulkPaycodeResponse != null && bulkPaycodeResponse.getErrors() == null)
    		{
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
    		}
    		else
    		{
    			Error[] errors = bulkPaycodeResponse.getErrors();
    			Error error = errors[0];
    			System.out.println("Error Msg: " + error.getMessage());
    		}
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
