package com.webtest.utils;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class MailUtil {
	public void sendMailUtil(String zipPath) throws IOException {
		String sender = ReadProperties.getPropertyValue("sender");
		String auth_code = ReadProperties.getPropertyValue("auth_code");
		String to = ReadProperties.getPropertyValue("tomail");
		String[] tos = to.split(",");
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.auth", true);

//		1,构造Session对象(邮件会话对象）设置服务器,收取那嘛，需要properties对象

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto- generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});
//		2、 创建邮件，创建Message对象， 子类MimeMessage
		// 设置发件人、收件人、主题、正文

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			for (int i = 0; i < tos.length; i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[i]));
			}
			message.setSubject("2018011979 吉晓瑜给您发送一条测试报告");
//			MimeBodyPart attachment = null;
			// 创建消息部分
			final BodyPart messageBodyPart = new MimeBodyPart();
			// 消息
			messageBodyPart.setContent("2018011979 吉晓瑜给您发送一条测试报告", "text/html;charset=UTF-8");
			// 创建多重消息
			final Multipart multipart = new MimeMultipart();
			// 设置文本消息部分
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachment = new MimeBodyPart();
			// 根据附件文件创建文件数据源

			final DataSource ds = new FileDataSource(zipPath);
			attachment.setDataHandler(new DataHandler(ds));
			// 为附件设置文件名
			attachment.setFileName(ds.getName());
			multipart.addBodyPart(attachment);

			// 发送完整消息
			message.setContent(multipart);
//				3,发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
