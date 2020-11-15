package com.webtest.listen;

import java.io.File;
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
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

import com.webtest.utils.ReadProperties;

public class MailUtil1 {
	public  void mail(String text) throws IOException {
		String sender="w_w944@126.com";
//		
		String auth_code="BPYYCUHHIIDUDNTS";
		String address=ReadProperties.getPropertyValue("tomail");
		String[] to=address.split(",");
		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		File f = new File("E:\\index1.html");
		
		


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
			message.setSubject("�������Ĳ��Ա���");
			
			// ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
            Multipart multipart = new MimeMultipart();
            
            // ����ʼ�����
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(text, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);
            // ��Ӹ���������
            BodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(f);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
                
             // ���������Ľ���ļ�������ķ�������ʵ��MimeUtility.encodeWord�Ϳ��Ժܷ���ĸ㶨
             // �������Ҫ��ͨ�������Base64�����ת�����Ա�֤������ĸ����������ڷ���ʱ����������
             //sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
             //messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");
                
             //MimeUtility.encodeWord���Ա����ļ�������
            attachmentBodyPart.setFileName(MimeUtility.encodeWord(f.getName()));
            multipart.addBodyPart(attachmentBodyPart);
            // ��multipart����ŵ�message��
            message.setContent(multipart);
            // �����ʼ�
            message.saveChanges();
		//	message.setText(text);
			Transport.send(message);
			System.out.println("***********");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}