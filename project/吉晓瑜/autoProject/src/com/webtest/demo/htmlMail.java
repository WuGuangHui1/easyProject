package com.webtest.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.utils.MailUtil;
import com.webtest.utils.ReadProperties;
import com.webtest.utils.ZipUtils;

public class htmlMail {
	

	public static void main(String[] args) throws IOException {
		String zipPath = ReadProperties.getPropertyValue("tozip_path");
		testMail(zipPath);
	}
//	@Test
    public static void testMail(String zip) throws IOException {
    	String test_html_path = ReadProperties.getPropertyValue("test_html_path");
    	
		FileOutputStream fos1 = new FileOutputStream(new File(zip));
		ZipUtils.toZip(test_html_path, fos1, true);
		MailUtil send = new MailUtil();
		send.sendMailUtil(zip);

    }

	
	

}
