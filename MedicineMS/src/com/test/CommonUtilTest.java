package com.test;

import org.apache.catalina.util.MD5Encoder;
import org.junit.Test;

import com.util.HashUtil;

import sun.security.provider.MD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;  

public class CommonUtilTest {
	
	/* *
	 * π˛œ£¬Î π”√≤‚ ‘
	 * */
//	@Test
	public void test(){
		MD5 md5 = new MD5();
		System.out.println(md5.toString());
		MD5Encoder  md5Encoder = new MD5Encoder();
		System.out.println(md5Encoder.toString());
		System.out.println(md5Encoder.hashCode());
//		System.out.println(md5Encoder.encode(null));
		byte bytes[] = {23,56,89,90};  
		System.out.println("xx:"+md5Encoder.encode(bytes));
		
		System.out.println("*******************************");
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			System.out.println(mDigest.digest());
			System.out.println(mDigest.digest(bytes));
			System.out.println(mDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test1(){
		System.out.println(HashUtil.getDecHash("xxx"));
		System.out.println(HashUtil.getDecHash("325478256896"));
		System.out.println(HashUtil.getHexHash(new Date().toString()));
	}
}
