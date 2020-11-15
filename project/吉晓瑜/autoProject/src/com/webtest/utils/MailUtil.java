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

//		1,����Session����(�ʼ��Ự�������÷�����,��ȡ�����Ҫproperties����

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto- generated method stub
				return new PasswordAuthentication(sender, auth_code);
			}

		});
//		2�� �����ʼ�������Message���� ����MimeMessage
		// ���÷����ˡ��ռ��ˡ����⡢����

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sender));
			for (int i = 0; i < tos.length; i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(tos[i]));
			}
			message.setSubject("2018011979 ����褸�������һ�����Ա���");
//			MimeBodyPart attachment = null;
			// ������Ϣ����
			final BodyPart messageBodyPart = new MimeBodyPart();
			// ��Ϣ
			messageBodyPart.setContent("2018011979 ����褸�������һ�����Ա���", "text/html;charset=UTF-8");
			// ����������Ϣ
			final Multipart multipart = new MimeMultipart();
			// �����ı���Ϣ����
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachment = new MimeBodyPart();
			// ���ݸ����ļ������ļ�����Դ

			final DataSource ds = new FileDataSource(zipPath);
			attachment.setDataHandler(new DataHandler(ds));
			// Ϊ���������ļ���
			attachment.setFileName(ds.getName());
			multipart.addBodyPart(attachment);

			// ����������Ϣ
			message.setContent(multipart);
//				3,�����ʼ�
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
