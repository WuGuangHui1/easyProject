package com.webtest.smoketest.testcases.dxy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;


/**
 * 
 * @author 杜鑫宇
 *
 */

public class DataActionUtil {
	public static String getRandomString(int length) {
//			String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(52);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 模拟粘贴文本
	 * 
	 * @param text 文本内容
	 */
	public static void paste(String text) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);

		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
