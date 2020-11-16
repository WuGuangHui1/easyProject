package com.webtest.demo;

import java.io.IOException;

import com.webtest.core.SendEmail;

public class SendMailmethodTest {

	public static void main(String[] args) throws IOException {
		SendEmail send = new SendEmail();
		send.send_mail("测试文本");
		System.out.println("发送成功！");
	}

}
