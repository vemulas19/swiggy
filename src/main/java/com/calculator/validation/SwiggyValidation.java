package com.calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwiggyValidation {

	public static boolean isValidMail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
	}
	
	public static boolean isValidMobile(String s) 
    { 
        Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}"); 
        return p.matcher(s).matches();
    } 
}
