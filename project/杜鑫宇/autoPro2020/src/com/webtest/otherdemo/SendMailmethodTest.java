package com.webtest.otherdemo;

import java.io.IOException;

import com.webtest.core.dxy.SendEmail;


public class SendMailmethodTest {

	public static void main(String[] args) throws IOException {
		SendEmail send = new SendEmail();
		send.send_mail("�����ı�");
		System.out.println("���ͳɹ���");
	}

}
