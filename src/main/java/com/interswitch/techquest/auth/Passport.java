package com.interswitch.techquest.auth;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Passport {
	public static HashMap<String, String> getClientAccessToken(String clientId, String clientSecret, String passportBaseUrl) throws Exception {

        HashMap<String, String> responseMap = new HashMap<String, String>();

        try {
            
            String accesToken = null;
            URL obj = new URL(passportBaseUrl);
            
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.10.20", 8080));

            System.setProperty("http.maxRedirects", "100");
            java.net.CookieManager cm = new java.net.CookieManager();
            java.net.CookieHandler.setDefault(cm);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection(proxy);
            con.setRequestMethod("POST");
            String basicAuthCipher = clientId + ":" + clientSecret;
            String basicAuth = new String(Base64.getEncoder().encode(basicAuthCipher.getBytes()));

            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("Authorization", "Basic " + basicAuth);
            String request = "grant_type=client_credentials";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(request);
            wr.flush();
            wr.close();

            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } catch (Exception ex) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> map = new HashMap<String, String>();
                map = mapper.readValue(response.toString(), new TypeReference<Map<String, String>>() {
                });

                accesToken = map.get("access_token");
                System.out.println(accesToken);
            }

            
        } catch (Exception exp) {

            System.out.println(exp.getMessage());
            throw exp;
        }

        return responseMap;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        getClientAccessToken("IKIA2EFBE1EF63D1BBE2AF6E59100B98E1D3043F477A","uAk0Amg6NQwQPcnb9BTJzxvMS6Vz22octQglQ1rfrMA=","https://qa.interswitchng.com/passport/oauth/token");
//        getClientAccessToken("IKIAF3D3F2D20F5136DEF5A125036C7E4B83380B0F20","fpeoQ4ImZvmdIEILyxeS3AdbOrjxVjPXl4ggfO3CQIA=","https://qa.interswitchng.com/passport/oauth/token");
//        getClientAccessToken("IKIA23E2E222D5CA9B08D235817E0A8E6F5434940469","R0v2Yp7uDQalLX2u5mapKgH+cbES1v8uagfs44WrYzM=","http://172.25.20.91:6060/passport/oauth/token");

        		
    }
    
}
