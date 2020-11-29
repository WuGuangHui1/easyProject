package com.smoketest.testcases.controller;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.smoketest.testcases.model.DataActionUtil;
import com.webtest.core.BaseTest;
import com.webtest.freemarker.GenerateReporter;

@Listeners(GenerateReporter.class)
public class IdentityManagementTest extends BaseTest {
	// �û������ģ�� ��ݹ��� ��ע�ͣ��ù�������������ɣ���ͨ��������Ĳ���
	@BeforeClass
	public void openUrl() {
		webtest.open("http://localhost:8033//admin.php");
		// ��¼
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
	}

	// ��ݹ���������б�
	@Test(description = "��ȷ��ʾ������б�����", priority = 0)
	public void test_correct_display() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("����б�");
		Thread.sleep(3000);
//		subMenu.click();
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("����б� "), "ҳ����ʾʧ��");
	}

	@Test(description = "����", priority = 1)
	public void test_addIdentity() throws InterruptedException {
		// ��� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a[1]");
		Thread.sleep(1000);
		// �����
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[1]/input",
				"����ͷ��" + DataActionUtil.getRandomString(8));
		// Ӣ�ı�ʶ
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[2]/input",
				"new_" + DataActionUtil.getRandomString(4));
		// ���� ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[4]/select");
		Thread.sleep(3000);
		// ����ѡ�����01
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[4]/select/option[2]");
		// ��Ҫ��� ����
		webtest.click("xpath=//*[@id='id_audit_1']");
		// ���� ��һ��
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/button");
		// ȷ����ʾ��
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		// �����ж�
		if (text.contains("ֻ������ĸ���»������")) {
			Assert.assertEquals(text, "�������ʧ�ܣ���ݱ�ʶֻ������ĸ���»�����ɡ�", "��������ʧ��");
		} else if (text.contains("�Ѿ�����")) {
			Assert.assertEquals(text, "�������ʧ�ܣ���ݱ�ʶ�Ѿ����ڡ�", "��������ʧ��");
		} else if (text.contains("�ɹ�")) {
			Assert.assertEquals(text, "������ݳɹ� ҳ�漴���Զ���ת~", "��������ʧ��");
			System.out.println("���������ɹ�");
		} else {
			System.out.println("��������ʧ��");
		}
		Thread.sleep(2000);
	}

	@Test(description = "����", priority = 2)
	public void test_startUsing() throws InterruptedException {
		// ��ΪҪ��һ�����н���һϵ�з������������ԣ�����ҳ��֮��Ҫ�����л�����
		this.driver.navigate().back();
		Thread.sleep(1500);
		this.driver.navigate().back();
		Thread.sleep(1500);
		// ���� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		Thread.sleep(1500);
		// ȷ����ʾ��
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3500);
		// �����ж��Ƿ�ѡ
		if (text.contains("��ѡ")) {
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
			// ȷ����ʾ��
			driver.switchTo().alert().accept();
			// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
			Thread.sleep(1000);
			WebElement content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			String text2 = content2.getText();
			System.out.println(text2);
			if (text2.contains("ϵͳĬ�����")) {
				Thread.sleep(3500);
				// �ٴι�ѡidΪ1��ϵͳ�û����Դ�ȡ����ѡ����- -
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
				Thread.sleep(1000);
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[2]/td[1]/input");
				Thread.sleep(1000);
				webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
				// ȷ����ʾ��
				driver.switchTo().alert().accept();
				// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
				Thread.sleep(1000);
				WebElement content3 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
				String text3 = content3.getText();
				System.out.println(text3);
				Assert.assertEquals(text3, "���óɹ� ҳ�漴���Զ���ת~", "���ò���ʧ��");// ���Խ�if��任��whileѭ�������������������������ж�
			}
		} else if (text.contains("���óɹ�")) {
			Assert.assertEquals(text, "���óɹ� ҳ�漴���Զ���ת~", "���ò���ʧ��");
		} else {
			System.out.println("ҳ��������������²�����");
		}
		Thread.sleep(2500);
	}

	@Test(description = "����", priority = 3)
	public void test_disable() throws InterruptedException {
		// ���� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		Thread.sleep(1500);
		// ȷ����ʾ��
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3500);
		// �����ж��Ƿ�ѡ
		if (text.contains("��ѡ")) {
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
			// ȷ����ʾ��
			driver.switchTo().alert().accept();
			// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
			Thread.sleep(1000);
			WebElement content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			String text2 = content2.getText();
			System.out.println(text2);
			if (text2.contains("ϵͳĬ�����")) {
				Thread.sleep(3500);
				// �ٴι�ѡidΪ1��ϵͳ�û����Դ�ȡ����ѡ����- -
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
				Thread.sleep(1000);
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[2]/td[1]/input");
				Thread.sleep(1000);
				webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
				// ȷ����ʾ��
				driver.switchTo().alert().accept();
				// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
				Thread.sleep(1000);
				WebElement content3 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
				String text3 = content3.getText();
				System.out.println(text3);
				if (text3.contains("������û�")) {
					Thread.sleep(3500);
					// �ٴι�ѡ���Դ�ȡ����һ���Ĺ�ѡ����- -
					webtest.click(
							"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[2]/td[1]/input");
					Thread.sleep(1000);
					webtest.click(
							"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
					Thread.sleep(1000);
					webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
					Thread.sleep(1000);
					// ȷ����ʾ��
					driver.switchTo().alert().accept();
					// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
					Thread.sleep(1000);
					WebElement content4 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
					String text4 = content4.getText();
					System.out.println(text4);
					Assert.assertEquals(text4, "���óɹ� ҳ�漴���Զ���ת~", "���ò���ʧ��");
				} else {
					System.out.println("ҳ��������������²�����");
				}
			} else if (text.contains("���óɹ�")) {
				Assert.assertEquals(text, "���óɹ� ҳ�漴���Զ���ת~", "���ò���ʧ��");
			} else {
				System.out.println("ҳ��������������²�����");
			}
		}
	}

//	@Test(description = "ɾ��", priority = 4)
	// �������Ը���������ִ�У�������ͬһ������һͬ���Ա���org.openqa.selenium.UnhandledAlertException:
	// Dismissed user prompt dialog: ȷ��ɾ����ݣ�ɾ���󲻿ɻָ���:
	public void test_delete() throws InterruptedException, AWTException {
		WebElement content2;
		String text2;
		// ���� ɾ��
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[3]");
		Thread.sleep(1500);
		// ȷ����ʾ��
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3500);
		// �����ж��Ƿ�ѡ
		if (text.contains("��ѡ")) {
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
			Thread.sleep(1000);
			// ���ڸ�Ԫ�أ�ǰ��������������
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[3]");
			Thread.sleep(2000);
			// ȷ����ʾ��
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			// �ٴ�ȷ����ʾ��
			driver.switchTo().alert().accept();
			Thread.sleep(1300);
			// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
			content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			text2 = content2.getText();
			Thread.sleep(2500);
			System.out.println(text2);
		} else {
			text2 = null;
		}
		Assert.assertEquals(text2, "ɾ���ɹ��� ҳ�漴���Զ���ת~", "ɾ������ʧ��");
	}

	// ��ݹ�������ݷ���
	@Test(description = "��ȷ��ʾ����ݷ��顯����", priority = 5)
	public void test_correct_displaylist() throws InterruptedException {
		// ��ˢ�´��ڽ���
		driver.navigate().refresh();//ʹ�ø������ڵ����⣺���뱣�ֵ�ǰ���ڽ���Ϊ���ԵĽ��棬�����������в��Թ���
		Thread.sleep(3000);
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("��ݷ���");
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[3]/ul/li[3]");
//		subMenu.click();
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("��ݷ���"), "ҳ����ʾʧ��");
	}

	@Test(description = "��������", dependsOnMethods = "test_correct_displaylist", priority = 6)
	public void test_addGroup() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a");
		Thread.sleep(1500);
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"��������" + DataActionUtil.getRandomString(3));
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/span/span[1]/span/ul/li/input");
		Thread.sleep(2000);
//		webtest.click("xpath=//*[@id='select2-roles[]-t2-result-oo5f-2']");��������ѡ���idֵ�仯������ֱ����id��λ��ʹ��������Զ�λ��ʽ
		webtest.click("xpath=/html/body/span/span/span/ul/li[2]");// li�б��1��ʼ
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1500);
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
		Assert.assertEquals(texts, "��������ɹ��� ҳ�漴���Զ���ת~", "�����������ʧ��");
	}

	// ��ݹ������û���ݹ����б�
	@Test(description = "��ȷ��ʾ������û��б�����", priority = 7)
	public void test_correct_displayIDlist() throws InterruptedException {
		driver.navigate().refresh();
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("�û���ݹ����б�");
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[3]/ul/li[4]");
		Thread.sleep(3000);
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("����û��б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "Ǩ���û�-����", dependsOnMethods = "test_correct_displayIDlist", priority = 8)
	public void test_migrateUsers() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[3]");
		Thread.sleep(2000);
		webtest.click("xpath=/html/body/div[4]/div/div/div[2]/form/div[1]/span[2]/select");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[4]/div/div/div[2]/form/div[1]/span[2]/select/option[1]");
		Thread.sleep(1500);
		webtest.click("xpath=/html/body/div[4]/div/div/div[2]/form/div[2]/a[1]");
		Thread.sleep(1000);
		// ���ܶ�λ������Ԫ�أ���ȡ�������ı���Ϣ����
//		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
//		String texts = content.getText();
	}

	@Test(description = "����-����", dependsOnMethods = "test_correct_displayIDlist", priority = 9)
	public void test_restart() throws InterruptedException {
		// ��ѡ�б���
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
		// ���� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		// ȷ����ʾ��
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
		// ���û�в��������ݣ��Ƚ��� �л����
		if (texts.contains("û�пɲ�������")) {
			Thread.sleep(2000);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/div/form/div[1]/div[2]/select");
			Thread.sleep(1500);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/div/form/div[1]/div[2]/select/option[2]");
			Thread.sleep(2000);
			// ��ѡ�б���
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
			// ���� ����
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
			// ȷ����ʾ��
			driver.switchTo().alert().accept();
			// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
			Thread.sleep(1000);
			WebElement content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			texts = content2.getText();
			System.out.println(texts);
		}
		Assert.assertEquals(texts, "���óɹ� ҳ�漴���Զ���ת~", "���ò���ʧ��");
	}

	@Test(description = "����-����", dependsOnMethods = "test_correct_displayIDlist", priority = 10)
	public void test_disableUsing() throws InterruptedException {
		// ��ѡ�б���
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
		// ���� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		// ȷ����ʾ��
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
		if (texts.contains("�ɹ�")) {
			Assert.assertEquals(texts, "���óɹ� ҳ�漴���Զ���ת~", "���ò���ʧ��");
		} else if (texts.contains("���ܱ�����")) {
			Assert.assertEquals(texts, "idΪ{$_ERROR_ID_s}������û�ֻӵ�и���ݣ����ܱ����ã�", "���ò���ʧ��");
		} else {
			System.out.println("ҳ��������������²�����");
		}
	}

	@Test(description = "��ʼ��û��ݵ��û�", dependsOnMethods = "test_correct_displayIDlist", priority = 11)
	public void test_initUserId() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a");
		Thread.sleep(1500);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
	}

}
