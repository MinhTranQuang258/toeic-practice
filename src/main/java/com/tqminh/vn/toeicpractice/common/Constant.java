package com.tqminh.vn.toeicpractice.common;

public class Constant {
	
	public final static String JSON_ACCOUNT= "com.tqminh.vn.toeicpractice.model.Account";
	
	public final static String JSON_MULTIPLE_CHOICE_QUESTION= "com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion";
	
	public final static String JSON_PHOTO_QUESTION= "com.tqminh.vn.toeicpractice.model.PhotoQuestion";
	
	public final static String JSON_RESULT= "com.tqminh.vn.toeicpractice.model.Result";
	
	public static class NativeQuery {
		
		public static final String FIND_ACCOUNT_BY_USER_NAME_AND_PASSWORD = "SELECT * FROM account_wrapper WHERE account ->> 'username' = ?1 AND account ->> 'password' = ?2";
		
		public static final String FIND_QUESTION_BY_INDEX = "SELECT * FROM mcquestion_wrapper WHERE id = ?1";
		
		public static final String COUNT_MCQUESTION_BY_ID = "SELECT COUNT(id) FROM mcquestion_wrapper";
		
		public static final String COUNT_PQUESTION_BY_ID = "SELECT COUNT(id) FROM pquestion_wrapper";
		
		public static final String COUNT_DUPLICATED_FOLDER= "SELECT COUNT(id) FROM pquestion_wrapper WHERE photo_question ->> 'folderName' = ?1";
		
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
		
		public final static String ADMIN_PAGE= "admin-question";
		
		public final static String ADMIN_EDIT_PAGE= "adminEdit";
		
		public final static String ADMIN_ADD_PAGE= "adminAdd";
		
	}
	
	public static class Admin {
		
		public final static String USER_NAME= "admin";
		
		public final static String PASSWORD= "admin";
	}
	
	public static class LimitIndex{
		
		public final static Integer MAX_MC_QUESTION_INDEX= 9;
		
		public final static Integer MAX_PHOTO_QUESTION_INDEX= 9;
		
		public final static Integer MIN_MC_QUESTION_INDEX= 0;
	
		public final static Integer MIN_PHOTO_QUESTION_INDEX= 0;
	}
	
	public static class QuestionLimit{
		
		public final static Integer MC_QUESTION_LIMIT= 9;
		
		public final static Integer P_QUESTION_LIMIT= 9;
	}
}
