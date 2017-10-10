package com.interswitch.techquest.paycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.interswitch.techquest.auth.Interswitch;
import com.interswitch.techquest.paycode.dto.BulkPaycodeRequest;
import com.interswitch.techquest.paycode.dto.BulkPaycodeResponse;
import com.interswitch.techquest.paycode.dto.Entries;
import com.interswitch.techquest.paycode.dto.PaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;

public class Paycode {

	private Interswitch interswitch;
	static String publicCertPath = "E:\\jboss\\jboss-fuse-6.2.1.redhat-084\\etc\\paymentgateway.crt";
	
	public enum CHANNEL{
		ATM, POS;
	}
	
	public enum TRAN_TYPE{
		WITHDRWAL, PAYMENT;
	}

    public Paycode(String clientId, String clientSecret) {
        this(clientId, clientSecret, Interswitch.ENV_SANDBOX);
    }

    public Paycode(String clientId, String clientSecret, String env) {
        if (clientId == null) {
            throw new IllegalArgumentException("CliendId is empty");
        }
        if (clientSecret == null) {
            throw new IllegalArgumentException("CliendSecret is empty");
        }

        if (env == null) {
            env = Interswitch.SANDBOX_BASE_URL;
        }

        interswitch = new Interswitch(clientId, clientSecret, env);
    }
    
    public static void main(String[] args)
    {
    	/*
    	 * 
		String pan = "5060990580000217499";//"0000000000000000";
		String expDate = "2004";
		String cvv2 = "111";
		String pin = "1111";		
		String amount = "2000000";
		String ttid = "809";
		String msisdn = "2348124888436";
		String paymentMethodIdentifier = "E192F3F3B3BA4596BC9704C44EA801BC";
		String payWithMobileChannel = "ATM";
		String tokenLifeTimeInMinutes = "1440";
		String oneTimePin = "1234";
    	 */
    }
    
    /**
     * Generate Paycode By PAN
     * @return
     * @throws Exception 
     */
//    public PaycodeResponse generateByPAN(String msisdn, String ttid, String paymentMethodIdentifier, String pan, String expDate, String cvv, String pin, String amt, String fep, String tranType, String pwmChannel, String tokenLifeInMin, String oneTimePin) throws Exception
    public PaycodeResponse generateByPAN(PaycodeRequest request) throws Exception
    {
    	String msisdn = request.getMsisdn();
    	String ttid = request.getTtid();
    	String paymentMethodIdentifier = request.getPaymentMethodIdentifier();
    	String pan = request.getPan();
    	String expDate = request.getExpDate();
    	String cvv = request.getCvv(); 
    	String pin = request.getPin();
    	String amt = request.getAmt();
    	String fep = request.getFep();
    	String tranType = request.getTranType();
    	String pwmChannel = request.getPwmChannel();
    	String tokenLifeInMin = request.getTokenLifeInMin();
    	String oneTimePin = request.getOneTimePin();
//    	String beneficiaryMsisdn =;
    	
    	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
		additionalSecureData.put("msisdn",msisdn);
		additionalSecureData.put("ttid", ttid);
		additionalSecureData.put("cardName", "default");
		HashMap<String, String> secureParameters = interswitch.getSecureData(pan, expDate, cvv, pin, additionalSecureData, publicCertPath);
		String pinData = secureParameters.get(Constants.PINBLOCK);
		String secureData = secureParameters.get(Constants.SECURE);
		String macData =  secureParameters.get(Constants.MACDATA);
		
		JSONObject json = new JSONObject();
		json.put("amount", amt);
		json.put("ttid", ttid);
		json.put("paymentMethodIdentifier", paymentMethodIdentifier);
		json.put("payWithMobileChannel", pwmChannel);
		json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
		json.put("oneTimePin", oneTimePin);
		json.put("pinData", pinData);
		json.put("secure", secureData);
		String jsonData = json.toString();
		
    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("frontEndPartnerId", fep);
		String resourceUrl = Constants.PWM_BASE_URL + msisdn +"/tokens";
		
        HashMap<String, String> response = interswitch.send(resourceUrl, Constants.POST, "", extraHeaders);
        String responseCode = response.get(Interswitch.RESPONSE_CODE);
        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
        Gson g = new Gson();
        PaycodeResponse resp = g.fromJson(msg, PaycodeResponse.class);
        return resp;    	
    }
    
    
//    /**
//     * Generate Paycode By Account Number
//     * @return
//     * @throws Exception 
//     */
//    public PaycodeResponse generateByAccount(String msisdn, String ttid, String amt, String tranType, String pwmChannel, String tokenLifeInMin, String oneTimePin) throws Exception
//    {
//    	/*
//    	 * 
//		String pan = "5060990580000217499";//"0000000000000000";
//		String expDate = "2004";
//		String cvv2 = "111";
//		String pin = "1111";		
//		String amount = "2000000";
//		String ttid = "809";
//		String msisdn = "2348124888436";
//		String paymentMethodIdentifier = "E192F3F3B3BA4596BC9704C44EA801BC";
//		String payWithMobileChannel = "ATM";
//		String tokenLifeTimeInMinutes = "1440";
//		String oneTimePin = "1234";
//    	 */
//    	
//    	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
//		additionalSecureData.put("msisdn",msisdn);
//		additionalSecureData.put("ttid", ttid);
//		additionalSecureData.put("cardName", "default");
//		HashMap<String, String> secureParameters = interswitch.getSecureData(pan, expDate, cvv, pin, additionalSecureData, publicCertPath);
//		String pinData = secureParameters.get(Constants.PINBLOCK);
//		String secureData = secureParameters.get(Constants.SECURE);
//		String macData =  secureParameters.get(Constants.MACDATA);
//		
//		JSONObject json = new JSONObject();
//		json.put("amount", amt);
//		json.put("ttid", ttid);
//		json.put("paymentMethodIdentifier", paymentMethodIdentifier);
//		json.put("payWithMobileChannel", pwmChannel);
//		json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
//		json.put("oneTimePin", oneTimePin);
//		json.put("pinData", pinData);
//		json.put("secure", secureData);
//		String jsonData = json.toString();
//		
//    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
//		extraHeaders.put("frontEndPartnerId", fep);
//		String resourceUrl = Constants.PWM_BASE_URL + msisdn +"/tokens";
//		
//        HashMap<String, String> response = interswitch.send(resourceUrl, Constants.POST, "", extraHeaders);
//        String responseCode = response.get(Interswitch.RESPONSE_CODE);
//        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
//        Gson g = new Gson();
//        PaycodeResponse resp = g.fromJson(msg, PaycodeResponse.class);
//        return resp;    	
//    }

    
    /**
     * Generate Bulk Paycode
     * @return
     * @throws Exception 
     */
    public BulkPaycodeResponse generateBulk(BulkPaycodeRequest bulkRequest) throws Exception {
    	
    	String msisdn = bulkRequest.getMsisdn();
    	String ttid = bulkRequest.getTtid();
    	String paymentMethodIdentifier = bulkRequest.getPaymentMethodIdentifier();
    	String pan = bulkRequest.getPan();
    	String expDate = bulkRequest.getExpDate();
    	String cvv = bulkRequest.getCvv(); 
    	String pin = bulkRequest.getPin();
    	String amt = bulkRequest.getDefaultAmt();
    	String fep = bulkRequest.getFep();
    	String tranType = bulkRequest.getDefaultTranType();
    	String pwmChannel = bulkRequest.getDefaultPwmChannel();
    	String tokenLifeInMin = bulkRequest.getDefaultTokenLifeInMin();
    	String oneTimePin = bulkRequest.getDefaultOneTimePin();
    	PaycodeRequest[] requests = bulkRequest.getPaycodeRequests();
    	
    	
    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
		Random random = new Random();
		extraHeaders.put("frontEndPartnerId", fep);
    	HashMap<String, String> addition =  new HashMap<String, String>();
		addition.put("type", "bulk");
    	int batchSize = Integer.parseInt(bulkRequest.getBatchSize()); 
    	Entries[] entries =  new Entries[batchSize];
    	int i = 0;
    	for(PaycodeRequest request : requests)
    	{
    		entries[i]= new Entries();
    		entries[i].setAmount(request.getAmt());
    		entries[i].setBeneficiaryNumber(request.getBeneficiaryMsisdn());
    		entries[i].setOneTimePin(request.getOneTimePin());
    		i++;
    	}
    	
    	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
		ArrayList<Entries> list =  new ArrayList<Entries>();
		additionalSecureData.put("msisdn",msisdn);
		additionalSecureData.put("ttid", ttid);
		additionalSecureData.put("cardName", "default");
		additionalSecureData.put("amt", amt);
		list.addAll(Arrays.asList(entries));
		
		HashMap<String, String> secureParameters = interswitch.getSecureData(pan, expDate, cvv, pin, additionalSecureData, publicCertPath);
		String pinBlock = secureParameters.get(Constants.PINBLOCK);
		String secureData = secureParameters.get(Constants.SECURE);
		String macData = secureParameters.get(Constants.MACDATA);
		String referenceId =  " ";
		do {
			referenceId =  String.valueOf(random.nextInt(999999999));
		}while(referenceId.startsWith("0"));
		String resourceUrl = Constants.PWM_BULK_BASE_URL +"tokens";
		
		JSONObject json = new JSONObject();
		json.put("additionalInfo", addition);
		json.put("amount", amt);
		json.put("batchSize", batchSize);
		json.put("channel", pwmChannel);
		json.put("defaultOneTimePin", oneTimePin);
		json.put("entries", list);
		json.put("macData", macData);
		json.put("paymentMethodIdentifier", paymentMethodIdentifier);
		json.put("pinBlock", pinBlock);
		json.put("referenceId", referenceId);
		json.put("secure", secureData);
		json.put("subscriberId", msisdn);
		json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
		json.put("ttid", ttid);
		json.put("macData", macData);
		String jsonData = json.toString();
				
        HashMap<String, String> response = interswitch.send(resourceUrl, Constants.POST, jsonData, extraHeaders);
        String responseCode = response.get(Interswitch.RESPONSE_CODE);
        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
        Gson g = new Gson();
        BulkPaycodeResponse resp = g.fromJson(msg, BulkPaycodeResponse.class);
        return resp;    	
        
    }

}
