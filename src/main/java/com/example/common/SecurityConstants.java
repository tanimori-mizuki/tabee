package com.example.common;

/**
 * セキュリティの設定で使用する定数群をまとめたクラス
 * 
 * @author masashi.nose
 *
 */
public class SecurityConstants {
	public static final String SECRET_KEY = "tabee&I&Y&H&A";
	public static final long EXPIRATION_TIME = 28_800_000; //8h
	public static final String TOKEN_PREFIX = "BEARER ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGNUP_URL = "/register";
	public static final String LOGIN_URL= "/login";
	public static final String LOGIN_ID= "email"; //default:username
	public static final String PASSWORD= "password"; //default:password

}
