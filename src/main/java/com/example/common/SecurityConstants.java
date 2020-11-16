package com.example.common;

public class SecurityConstants {
	public static final String SECRET = "tabee&I&Y&H&A";
	public static final long EXPIRATION_TIME = 28_800_000; //8hours
	public static final String TOKEN_PREFIX = "BEARER ";
	public static final String HEADER_STRING = "Authorization";
	public static final String REGISTER_URL = "/user/register";
	public static final String LOGIN_URL = "/login";
	public static final String LOGIN_ID = "email"; 		//default:username
	public static final String PASSWORD = "password";   //default:password
			

}
