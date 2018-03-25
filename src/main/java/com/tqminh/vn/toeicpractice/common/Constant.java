package com.tqminh.vn.toeicpractice.common;

public class Constant {
	
	public final static String JSON_ACCOUNT= "com.tqminh.vn.toeicpractice.model.Account";
	
	public final static String JSON_MULTIPLE_CHOICE_QUESTION= "com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion";
	
	public final static String JSON_PHOTO_QUESTION= "com.tqminh.vn.toeicpractice.model.PhotoQuestion";
	
	public final static String JSON_RESULT= "com.tqminh.vn.toeicpractice.model.Result";
	
	public static class NativeQuery {
		
		public static final String FIND_ACCOUNT_BY_USER_NAME_AND_PASSWORD = "SELECT * FROM account_wrapper WHERE account -> 'userName' = ?1 AND account -> 'password' = ?2";
		
		public static final String FIND_QUESTION_BY_INDEX = "SELECT * FROM question_wrapper WHERE id = ?1";
		
		public static final String COUNT_MCQUESTION_BY_ID = "SELECT COUNT(id) FROM mcquestion_wrapper";
		
	}
	
	public static class Notification {
		
		public final static String CAN_NOT_FIND_USER= "Can't find the user. Please recheck username and password or register a new account.";
		
		public final static String REGISTERED_SUCCESS= "Sign Up Success";
		
		public final static String REGISTRATION_FAILED= "Registration faile";
	}
	
	public static class Page {
		
		public final static String LOGIN_PAGE= "login";
		
		public final static String REGISTER_PAGE= "register";
		
		public final static String QUESTION_PAGE= "question";
		
	}
	
	public static class Admin {
		
		public final static String USER_NAME= "admin";
		
		public final static String PASSWORD= "admin";
	}
}
