package com.interswitch.techquest.paycode.sample;

import com.interswitch.techquest.auth.Interswitch;
import com.interswitch.techquest.paycode.Paycode;

public class BaseSample {

	 /**
     * Sample Development Credentials

    /**
     * Sample Sandbox Credentials
     */

//    private final static String clientId = "IKIA9614B82064D632E9B6418DF358A6A4AEA84D7218";
//	private final static String clientSecret = "XCTiBtLy1G9chAnyg0z3BcaFK4cVpwDg/GTw2EmjTZ8=";
	
    private final static String clientId = "IKIAF6C068791F465D2A2AA1A3FE88343B9951BAC9C3";
    private final static String clientSecret = "FTbMeBD7MtkGBQJw1XoM74NaikuPL13Sxko1zb0DMjI=";

    protected static Paycode paycode = new Paycode(clientId, clientSecret, Interswitch.ENV_SANDBOX);
    
}
