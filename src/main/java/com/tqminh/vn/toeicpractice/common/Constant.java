package com.tqminh.vn.toeicpractice.common;

public class Constant {
	
	public final static String JSON_ACCOUNT= "com.tqminh.vn.toeicpractice.model.Account";
	
	public final static String JSON_QUESTION= "com.tqminh.vn.toeicpractice.model.Question";
	
	public final static String JSON_RESULT= "h.vn.toeicpractice.model.Result";
	
	public static class NativeQuery {
		
		public static final String FIND_ACCOUNT_BY_USER_NAME_AND_PASSWORD = "";
		
	}
	
	public static class Notification {
		
		public final static String CAN_NOT_FIND_USER= "Can't find the user. Please recheck username and password or register a new account.";
		
		public final static String REGISTERED_SUCCESS= "Sign Up Success";
		
		public final static String REGISTRATION_FAILED= "Registration faile";
	}
}
