package com.yc.uglygroup.sendmsg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg {
	private String code = ""; // 验证码
	
	/**
	 * 发送验证码的方法
	 * @param utel
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public String sendCode(String utel) throws UnsupportedEncodingException, IOException{
		code();
		if (code != "") {
			HttpClient client = new HttpClient();
			PostMethod postMethod = new PostMethod("http://gbk.sms.webchinese.cn");
			postMethod.addRequestHeader("Content-type",
					"application/x-www-form-urlencoded;charset=gbk"); // 在头文件中设置转码
			NameValuePair[] data = { new NameValuePair("Uid", "zlp199923"), // 中国网建sms平台注册的用户名
					 new NameValuePair("Key", "d41d8cd98f00b204e980"), // 中国网建sms平台注册的用户密钥
					 new NameValuePair("smsMob", utel), // 将要发送到的手机号码
					 new NameValuePair("smsText", "尊敬的用户，您好，您的验证码为:" + code + ",若非本人操作,请忽略此短信...")}; // 将要发送到的短信内容
			postMethod.setRequestBody(data);
			
			client.executeMethod(postMethod);
			Header[] headers = postMethod.getRequestHeaders();
			int statusCode = postMethod.getStatusCode();
			System.out.println("statusCode" + statusCode);
			
			for (Header header : headers) {
				System.out.println(header.toString());
			}
			
			String msg = new String(postMethod.getResponseBodyAsString().getBytes("gbk"));
			System.out.println("msg:" + msg); // 打印返回消息状态
			
			postMethod.releaseConnection();
		}
		
		
		return code;
	}
	
	/**
	 * 生成验证码的方法
	 * @return
	 */
	public void code(){
		Random random = new Random();
		for (int i = 0; i <= 5; ++ i) {
			code = code + random.nextInt(10);
		}
		System.out.println(code);
	}
}
