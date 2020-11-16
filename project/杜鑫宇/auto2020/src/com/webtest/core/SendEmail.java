package com.webtest.core;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.webtest.utils.ReadProperties;

//使用javamail发送邮件
public class SendEmail {
	public void send_mail(String content) throws IOException {
		//构建Properties对象,已经在ReadProperties类中 实现
		Properties prop = new Properties();
		//协议
		String protocol = ReadProperties.getPropertyValue("mail.transport.protocol");
		prop.put("mail.transport.protocol", protocol);
		//设置发送的服务器地址，邮箱里显示的SMTP服务器地址
		String address_server = ReadProperties.getPropertyValue("mail.smtp.host");
		prop.put("mail.smtp.host", address_server);
		//权限
		String auth_use = ReadProperties.getPropertyValue("mail.smtp.auth");
		prop.put("mail.smtp.auth", auth_use);
		String sender = ReadProperties.getPropertyValue("sender");
		String to_mail = ReadProperties.getPropertyValue("tomail");
		String auth_code = ReadProperties.getPropertyValue("auth_code");
		// 1、构造Session对象（邮件会话对象），设置服务器，授权码，需要Properties对象
		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, auth_code);
			}

		});

		// 2、创建邮件，创建Message对象，子类 MimeMessage
		// 设置发件人、收件人、主题、正文
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to_mail));
			message.setSubject("hello,mars_tester");
			message.setContent(content, "text/html;charset=utf-8");
//			message.setText(content);
			// 3、发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
