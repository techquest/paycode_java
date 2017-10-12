package com.interswitch.techquest.paycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.interswitch.techquest.auth.Interswitch;
import com.interswitch.techquest.paycode.dto.BankAccountPaycodeRequest;
import com.interswitch.techquest.paycode.dto.BulkPaycodeRequest;
import com.interswitch.techquest.paycode.dto.BulkPaycodeResponse;
import com.interswitch.techquest.paycode.dto.EWalletPaycodeRequest;
import com.interswitch.techquest.paycode.dto.EWalletPaymentMethodResponse;
import com.interswitch.techquest.paycode.dto.Entries;
import com.interswitch.techquest.paycode.dto.PaycodeRequest;
import com.interswitch.techquest.paycode.dto.PaycodeResponse;
import com.interswitch.techquest.paycode.dto.VirtualAccountPaycodeRequest;

public class Paycode {

	private Interswitch interswitch;
	
	
	public enum CHANNEL{
		ATM, POS, Web;
	}
	
	public enum TRAN_TYPE{
		Withdrawal, Payment;
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
    	
    }
    
    public EWalletPaymentMethodResponse getEWalletPaymentMethod(String accessToken) throws Exception
    {
    	HashMap<String, String> response = interswitch.sendWithAccessToken(Constants.GET_EWALLET_PAYMENT_METHOD_BASE_URL, Constants.GET, "", accessToken);
    	String responseCode = response.get(Interswitch.RESPONSE_CODE);
        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
        Gson g = new Gson();
        EWalletPaymentMethodResponse resp = g.fromJson(msg, EWalletPaymentMethodResponse.class);
        return resp;    	
    }
    
    
    public PaycodeResponse generateByEWallet(String accessToken, EWalletPaycodeRequest request) throws Exception
    {
//    	Jwt jwt = JwtHelper.decode(accessToken);
//    	String claims = jwt.getClaims();
//		HashMap<String,Object> claimsMap = new ObjectMapper().readValue(claims, HashMap.class);
//		String msisdn = String.valueOf(claimsMap.get(Constants.MOBILE_NO));
    	String msisdn = request.getMsisdn();    	
    	String ttid = request.getTtid();
    	String paymentMethodIdentifier = request.getPaymentMethodIdentifier();
    	String expDate = request.getExpDate();
    	String cvv = request.getCvv(); 
    	String pin = request.getPin();
    	String amt = request.getAmt();
    	String fep = request.getFep();
    	String tranType = request.getTranType();
    	String pwmChannel = request.getPwmChannel();
    	String tokenLifeInMin = request.getTokenLifeInMin();
    	String oneTimePin = request.getOneTimePin();
    	int macVer = 12;
    	
    	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
		additionalSecureData.put("msisdn",msisdn);
		additionalSecureData.put("ttid", ttid);
		additionalSecureData.put("cardName", "default");
		HashMap<String, String> secureParameters = interswitch.getSecureData(null, expDate, cvv, pin, additionalSecureData, Constants.CERT_PATH, macVer);
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
		json.put("transactionType", tranType);
		String jsonData = json.toString();
		
    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("FrontEndPartnerId", fep);
		String resourceUrl = Constants.PWM_BASE_URL + msisdn +"/tokens";
		
//        HashMap<String, String> response = interswitch.sendWithAccessToken(resourceUrl, Constants.POST, jsonData, accessToken, extraHeaders);
        HashMap<String, String> response = interswitch.sendWithInterswitchAuth(resourceUrl, Constants.POST, jsonData, extraHeaders);
        
        String responseCode = response.get(Interswitch.RESPONSE_CODE);
        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
        Gson g = new Gson();
        PaycodeResponse resp = g.fromJson(msg, PaycodeResponse.class);
        return resp;    	
    }
    
    
//    /**
//     * Generate Paycode By Bank Account Number
//     * @return
//     * @throws Exception 
//     */
    public PaycodeResponse generateByBankAccount(BankAccountPaycodeRequest request) throws Exception
    {
    	String msisdn = request.getMsisdn();
    	String ttid = request.getTtid();
    	String amt = request.getAmt();
    	String fep = request.getFep();
    	String tranType = request.getTranType();
    	String pwmChannel = request.getPwmChannel();
    	String tokenLifeInMin = request.getTokenLifeInMin();
    	String paymentMethodTypeCode = request.getPaymentMethodTypeCode();
    	String paymentMethodCode = request.getPaymentMethodCode();
    	String providerToken = request.getProviderToken();
    	String accountNo = request.getAccountNo();
    	String accountType = request.getAccountType();
    	String transactionRef = request.getTransactionRef();
    	String autoEnroll = request.getAutoEnroll();
    	String oneTimePin = request.getOneTimePin();
    	
    	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
		additionalSecureData.put("msisdn",msisdn);
		additionalSecureData.put("ttid", ttid);
		additionalSecureData.put("cardName", "default");
		
		JSONObject json = new JSONObject();
		json.put("amount", amt);
		json.put("ttid", ttid);
		json.put("payWithMobileChannel", pwmChannel);
		json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
		json.put("paymentMethodTypeCode", paymentMethodTypeCode);
		json.put("paymentMethodCode", paymentMethodCode);
		json.put("providerToken", providerToken);
		json.put("accountNo", accountNo);
		json.put("accountType", accountType);
		json.put("transactionRef", transactionRef);
		json.put("autoEnroll", autoEnroll);
		json.put("transactionType", tranType);
		json.put("oneTimePin", oneTimePin);
		
		String jsonData = json.toString();
		
    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
//		extraHeaders.put("FrontEndPartnerId", fep);
		
		String resourceUrl = Constants.PWM_BASE_URL + msisdn +"/tokens";
		
        HashMap<String, String> response = interswitch.sendWithInterswitchAuth(resourceUrl, Constants.POST, jsonData, extraHeaders);
        String responseCode = response.get(Interswitch.RESPONSE_CODE);
        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
        Gson g = new Gson();
        PaycodeResponse resp = g.fromJson(msg, PaycodeResponse.class);
        return resp;  
    	  	
    }
    
    

//  /**
//   * Generate Paycode By Virtual Account Number
//   * @return
//   * @throws Exception 
//   */
  public PaycodeResponse generateByVirtualAccount(VirtualAccountPaycodeRequest request) throws Exception
  {
  	String msisdn = request.getMsisdn();
  	String ttid = request.getTtid();
  	String amt = request.getAmt();
  	String fep = request.getFep();
  	String tranType = request.getTranType();
  	String pwmChannel = request.getPwmChannel();
  	String tokenLifeInMin = request.getTokenLifeInMin();
  	String paymentMethodTypeCode = request.getPaymentMethodTypeCode();
  	String paymentMethodCode = request.getPaymentMethodCode();
  	String providerToken = request.getProviderToken();
  	String transactionRef = request.getTransactionRef();
  	String autoEnroll = request.getAutoEnroll();
  	String oneTimePin = request.getOneTimePin();
  	String codeGenerationChannel = request.getCodeGenerationChannel();
  	
  	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
	additionalSecureData.put("msisdn",msisdn);
	additionalSecureData.put("ttid", ttid);
	additionalSecureData.put("cardName", "default");
		
	JSONObject json = new JSONObject();
	json.put("amount", amt);
	json.put("ttid", ttid);
	json.put("payWithMobileChannel", pwmChannel);
	json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
	json.put("paymentMethodTypeCode", paymentMethodTypeCode);
	json.put("paymentMethodCode", paymentMethodCode);
	json.put("providerToken", providerToken);
	json.put("transactionRef", transactionRef);
	json.put("autoEnroll", autoEnroll);
	json.put("transactionType", tranType);
	json.put("oneTimePin", oneTimePin);
	json.put("codeGenerationChannel", codeGenerationChannel);
	String jsonData = json.toString();
		
  	HashMap<String, String> extraHeaders = new HashMap<String, String>();
  	extraHeaders.put("FrontEndPartnerId", fep);
  	String resourceUrl = Constants.PWM_BASE_URL + msisdn +"/tokens";
		
      HashMap<String, String> response = interswitch.sendWithInterswitchAuth(resourceUrl, Constants.POST, jsonData, extraHeaders);
      String responseCode = response.get(Interswitch.RESPONSE_CODE);
      String msg = response.get(Interswitch.RESPONSE_MESSAGE);
      Gson g = new Gson();
      PaycodeResponse resp = g.fromJson(msg, PaycodeResponse.class);
      return resp;  
  	  	
  }

    
    /**
     * Generate Bulk Paycode
     * @return
     * @throws Exception 
     */
    public BulkPaycodeResponse generateBulk(BulkPaycodeRequest bulkRequest) throws Exception {
    	
    	String msisdn = bulkRequest.getMsisdn();
    	String ttid = bulkRequest.getTtid();
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
    	int macVer = 12;
    	
    	
    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
		Random random = new Random();
		extraHeaders.put("FrontEndPartnerId", fep);
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
		
		HashMap<String, String> secureParameters = interswitch.getSecureData(pan, expDate, cvv, pin, additionalSecureData, Constants.CERT_PATH, macVer);
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
		json.put("pinBlock", pinBlock);
		json.put("referenceId", referenceId);
		json.put("secure", secureData);
		json.put("subscriberId", msisdn);
		json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
		json.put("ttid", ttid);
		json.put("macData", macData);
		json.put("transactionType", tranType);
		String jsonData = json.toString();
				
        HashMap<String, String> response = interswitch.sendWithInterswitchAuth(resourceUrl, Constants.POST, jsonData, extraHeaders);
        String responseCode = response.get(Interswitch.RESPONSE_CODE);
        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
        Gson g = new Gson();
        BulkPaycodeResponse resp = g.fromJson(msg, BulkPaycodeResponse.class);
        return resp;    	
        
    }


    
//    /**
//     * Generate Paycode By PAN
//     * @return
//     * @throws Exception 
//     */
//    public PaycodeResponse generateByPAN(PANPaycodeRequest request) throws Exception
//    {
//    	String msisdn = request.getMsisdn();
//    	String ttid = request.getTtid();
//    	String pan = request.getPan();
//    	String expDate = request.getExpDate();
//    	String cvv = request.getCvv(); 
//    	String pin = request.getPin();
//    	String amt = request.getAmt();
//    	String fep = request.getFep();
//    	String tranType = request.getTranType();
//    	String pwmChannel = request.getPwmChannel();
//    	String tokenLifeInMin = request.getTokenLifeInMin();
//    	String oneTimePin = request.getOneTimePin();
//    	
//    	HashMap<String,String> additionalSecureData = new HashMap<String, String>();
//		additionalSecureData.put("msisdn",msisdn);
//		additionalSecureData.put("ttid", ttid);
//		additionalSecureData.put("cardName", "default");
//		HashMap<String, String> secureParameters = interswitch.getSecureData(pan, expDate, cvv, pin, additionalSecureData, Constants.CERT_PATH);
//		String pinData = secureParameters.get(Constants.PINBLOCK);
//		String secureData = secureParameters.get(Constants.SECURE);
//		String macData =  secureParameters.get(Constants.MACDATA);
//		
//		JSONObject json = new JSONObject();
//		json.put("amount", amt);
//		json.put("ttid", ttid);
//		json.put("payWithMobileChannel", pwmChannel);
//		json.put("tokenLifeTimeInMinutes", tokenLifeInMin);
//		json.put("oneTimePin", oneTimePin);
//		json.put("pinData", pinData);
//		json.put("secure", secureData);
//		json.put("transactionType", tranType);
//		String jsonData = json.toString();
//		
//    	HashMap<String, String> extraHeaders = new HashMap<String, String>();
//		extraHeaders.put("FrontEndPartnerId", fep);
//		String resourceUrl = Constants.PWM_BASE_URL + msisdn +"/tokens";
//		
//        HashMap<String, String> response = interswitch.sendWithInterswitchAuth(resourceUrl, Constants.POST, jsonData, extraHeaders);
//        String responseCode = response.get(Interswitch.RESPONSE_CODE);
//        String msg = response.get(Interswitch.RESPONSE_MESSAGE);
//        Gson g = new Gson();
//        PaycodeResponse resp = g.fromJson(msg, PaycodeResponse.class);
//        return resp;    	
//    }
    
    
}
