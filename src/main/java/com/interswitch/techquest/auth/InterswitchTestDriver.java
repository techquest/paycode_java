package com.interswitch.techquest.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONObject;

import com.interswitch.techquest.auth.helpers.Entries;
import com.interswitch.techquest.auth.utils.ConstantUtils;

public class InterswitchTestDriver {

	
	static Interswitch interswitchPwm = new Interswitch("IKIAD8CEC8152D8E720E2CC7961C8EBBCD391A0DA0B6", "79EsDAYDw1mPiLre/z5RiqfH0XgMd8n2uKkThJ9YyA4=",Interswitch.ENV_SANDBOX);
	static String publicCertPath = "E:\\jboss\\jboss-fuse-6.2.1.redhat-084\\etc\\paymentgateway.crt";
	public static void main(String[] args) throws Exception 
	{
		HashMap<String, String> paycodeResponse = new HashMap<String, String>();
		
		
//		paycodeResponse = generatePaycode();
		paycodeResponse = generateBulkPaycode();
		
		

		System.out.println("Auth data:" + paycodeResponse);
	}

	
	
	/**
	 * @return HashMap<String, String> interswitchResponse
	 * @throws Exception
	 */
	public static HashMap<String, String> generatePaycode()throws Exception 
	{
		HashMap<String, String> interswitchResponse;
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		extraHeaders.put("frontEndPartnerId", "455");
		String httpMethod = ConstantUtils.POST;
		
		String pan = "";//"0000000000000000";
		String expDate = "";
		String cvv2 = "";
		String pin = "1111";
		
		double amount = 100000;
		String ttid = "812";
		String msisdn = "2348090673520";
		String paymentMethodIdentifier = "FEED1FCDDBD14AA1822FD1B9254B4C43";
		String payWithMobileChannel = "ATM";
		String tokenLifeTimeInMinutes = "90";
		String oneTimePin = "1234";
		
		HashMap<String,String> additionalSecureData = new HashMap<String, String>();
		additionalSecureData.put("msisdn",msisdn);
		additionalSecureData.put("ttid", ttid);
		additionalSecureData.put("cardName", "default");
		
		
		HashMap<String, String> secureParameters = interswitchPwm.getSecureData(pan, expDate, cvv2, pin,additionalSecureData,publicCertPath);
		String pinData = secureParameters.get(ConstantUtils.PINBLOCK);
		String secureData = secureParameters.get(ConstantUtils.SECURE);
		
		String resourceUrl = ConstantUtils.PWM_BASE_URL +msisdn+"/tokens";
		
		JSONObject json = new JSONObject();
		json.put("amount", amount);
		json.put("ttid", ttid);
		json.put("paymentMethodIdentifier", paymentMethodIdentifier);
		json.put("payWithMobileChannel", payWithMobileChannel);
		json.put("tokenLifeTimeInMinutes", tokenLifeTimeInMinutes);
		json.put("oneTimePin", oneTimePin);
		json.put("pinData", pinData);
		json.put("secure", secureData);
		String jsonData = json.toString();
		
		interswitchResponse = interswitchPwm.send(resourceUrl, httpMethod, jsonData,extraHeaders);
		return interswitchResponse;
	}
	
	public static HashMap<String, String> generateBulkPaycode()throws Exception 
	{
		HashMap<String, String> interswitchResponse;
		HashMap<String, String> extraHeaders = new HashMap<String, String>();
		Random random = new Random();
		extraHeaders.put("frontEndPartnerId", "455");
		String httpMethod = ConstantUtils.POST;
		
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
		String batchSize = "2";
		HashMap<String, String> addition =  new HashMap<String, String>();
		addition.put("type", "bulk");
		Entries[] entries =  new Entries[2];
		entries[0]= new Entries();
		entries[1] =  new Entries();
		entries[0].setAmount("1000000");
		entries[0].setBeneficiaryNumber("2348124888436");
		entries[0].setOneTimePin("1234");
		entries[1].setAmount("1000000");
		entries[1].setBeneficiaryNumber("2348124888436");
		entries[1].setOneTimePin("1234");
		String defaultOneTimePin = "1234";
		HashMap<String,String> additionalSecureData = new HashMap<String, String>();
		ArrayList<Entries> list =  new ArrayList<Entries>();
		additionalSecureData.put("msisdn",msisdn);
		additionalSecureData.put("ttid", ttid);
		additionalSecureData.put("cardName", "default");
		additionalSecureData.put("amt", amount);
		list.add(entries[0]);
		list.add(entries[1]);
		
		HashMap<String, String> secureParameters = interswitchPwm.getSecureData(pan, expDate, cvv2, pin,additionalSecureData,publicCertPath);
		String pinBlock = secureParameters.get(ConstantUtils.PINBLOCK);
		String secureData = secureParameters.get(ConstantUtils.SECURE);
		String macData = secureParameters.get(ConstantUtils.MACDATA);
		String referenceId =  " ";
		do {
			referenceId =  String.valueOf(random.nextInt(999999999));
		}while(!referenceId.startsWith("0"));
		
		String resourceUrl = ConstantUtils.PWM_BULK_BASE_URL +"tokens";
		
		JSONObject json = new JSONObject();
		json.put("additionalInfo", addition);
		json.put("amount", amount);
		json.put("batchSize", batchSize);
		json.put("channel", payWithMobileChannel);
		json.put("defaultOneTimePin", defaultOneTimePin);
		json.put("entries", list);
		json.put("macData", macData);
		json.put("paymentMethodIdentifier", paymentMethodIdentifier);
		json.put("pinBlock", pinBlock);
		json.put("referenceId", referenceId);
		json.put("secure", secureData);
		json.put("subscriberId", msisdn);
		json.put("tokenLifeTimeInMinutes", tokenLifeTimeInMinutes);
		json.put("ttid", ttid);

		
		
		String jsonData = json.toString();
		
		interswitchResponse = interswitchPwm.send(resourceUrl, httpMethod, jsonData,extraHeaders);
		return interswitchResponse;
	}


}
