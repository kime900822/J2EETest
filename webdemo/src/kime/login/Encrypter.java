package kime.login;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class Encrypter {
	
	/**
	 * 将密码用MD5加密，并用base64编码，防止含有非可视字符
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static String md5Encrypter(String s) throws Exception{
		//获得支持MD5算法的MessageDigest
		MessageDigest md5=MessageDigest.getInstance("MD5");
		//获得base64Encode对象
		BASE64Encoder base64Encoder=new BASE64Encoder();
		return base64Encoder.encode(md5.digest(s.getBytes("UTF-8")));		
	}
	
	
}
