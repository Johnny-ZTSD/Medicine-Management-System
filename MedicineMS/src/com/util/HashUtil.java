package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import org.apache.catalina.util.MD5Encoder;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.testbean;

import sun.security.provider.MD5;

public class HashUtil {
	public static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/* *
	 * ͨ��md5�㷨��ȡʮ�����ƹ�ϣ��
	 * input���ַ���
	 * output:ʮ�������ַ���
	 * */
	public static String getHexHash(String string) {
		String hashcode = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			hashcode = toHexString(mDigest.digest(string.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("**********��ϣ���ȡʧ��**********");
			e.printStackTrace();
		}
		
		return hashcode;
	}
	
	/* *
	 * ͨ��md5�㷨��ȡ��ϣ���ַ�����
	 * input���ַ���
	 * output:�ֽ�����
	 * */
	public static byte[] getHashBytes(String string) {
		byte[] hashcode = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			hashcode = mDigest.digest(string.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("**********��ϣ���ȡʧ��**********");
			e.printStackTrace();
		}
		return hashcode;
	}
	
	/* *
	 * ͨ��md5�㷨��ȡʮ���ƹ�ϣ���ַ���
	 * input���ַ���
	 * output:ʮ�����ַ���
	 * */
	public static String getDecHash(String string) {
		String hashcode = null;
		try {
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			hashcode =mDigest.digest(string.getBytes()).toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("**********��ϣ���ȡʧ��**********");
			e.printStackTrace();
		}
		
		return hashcode;
	}
	
	
	public static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
			sb.append(hexChar[b[i] & 0x0f]);
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
	    //ʮ������
		String str1;
		String str2;
		Date date = new Date();
		for(int i=0;i<3;i++){
			 str1 = HashUtil.getHexHash(new Date().toString());
			 str2 = UUID.randomUUID().toString();
			
			System.out.print("length:"+str1.length());
			System.out.println("\tcontent:"+str1);
			System.out.println("*********************************************************");
			System.out.print("length:"+str2.length());
			System.out.println("\tUUID:"+str2);
		}
		
//	    System.out.println(HashUtil.getDecHash(String.valueOf(date.getTime())));
	    String str3 = UUID.randomUUID().toString().replaceAll("-", "");
//		System.out.println(str3.substring(0,10));
	} 
}
