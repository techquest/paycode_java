package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.auth.Interswitch;
import com.interswitch.techquest.paycode.Paycode;

public class BaseSample {

	 /**
     * Sample Development Credentials

    /**
     * Sample Sandbox Credentials
     */

    private final static String clientId = "IKIAD8CEC8152D8E720E2CC7961C8EBBCD391A0DA0B6";
    private final static String clientSecret = "79EsDAYDw1mPiLre/z5RiqfH0XgMd8n2uKkThJ9YyA4=";

    static Paycode paycode = new Paycode(clientId, clientSecret, Interswitch.ENV_SANDBOX);
    
}
