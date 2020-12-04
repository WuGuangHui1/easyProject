package com.webtest.listen;

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

public class MailUtil {
	public  void mail(String text) throws IOException {
		String sender=ReadProperties.getPropertyValue("sender");
		String auth_code=ReadProperties.getPropertyValue("auth_code");

		String address=ReadProperties.getPropertyValue("tomail");
		String[] to=address.split(",");
		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		Session session=Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}
			
		});
		
		Message message=new MimeMessage(session);
		try {
			
			message.setFrom(new InternetAddress(sender));
		
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[0]));
			message.setSubject("test");
			
			
			message.setContent(text, "text/html;charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}