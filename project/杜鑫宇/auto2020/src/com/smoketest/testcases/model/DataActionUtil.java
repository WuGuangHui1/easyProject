package com.smoketest.testcases.model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;

public class DataActionUtil {
	// length用户要求产生字符串的长度
	public static String getRandomString(int length) {
//			String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(52);// str中有52个字符
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
		// 把text写到剪贴板
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text), null);

		// 模拟键盘的CTRL+V操作
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);// 按下键盘Ctrl键
			robot.keyPress(KeyEvent.VK_V);// 按下键盘V键

			robot.keyRelease(KeyEvent.VK_CONTROL);// 放开键盘Ctrl键
			robot.keyRelease(KeyEvent.VK_V);// 放开键盘V键
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
