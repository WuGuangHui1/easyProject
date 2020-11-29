package com.smoketest.testcases.model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

public class DataActionUtil {
	// length�û�Ҫ������ַ����ĳ���
	public static String getRandomString(int length) {
//			String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(52);// str����52���ַ�
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * ģ��ճ���ı�
	 * 
	 * @param text �ı�����
	 */
	public static void paste(String text) {
		// ��textд��������
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);

		// ģ����̵�CTRL+V����
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);// ���¼���Ctrl��
			robot.keyPress(KeyEvent.VK_V);// ���¼���V��

			robot.keyRelease(KeyEvent.VK_CONTROL);// �ſ�����Ctrl��
			robot.keyRelease(KeyEvent.VK_V);// �ſ�����V��
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
