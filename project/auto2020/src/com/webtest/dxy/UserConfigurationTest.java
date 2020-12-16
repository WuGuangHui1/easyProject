package com.webtest.dxy;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.demo.Admin_Login;
import com.webtest.freemarker.GenerateReporter;

/** 
 * @author ������
 * �û������ģ�� �û�����  ��ע�ͣ��ù�������������ɣ���
 *
 */
@Listeners(GenerateReporter.class)
public class UserConfigurationTest extends Admin_Login {
//	@BeforeClass
//	public void openUrl() {
//		webtest.open("http://localhost:8033//admin.php");
//		//��¼
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("class=login-btn");
//	}

	/** �û����� - ΢�Ű�*/
	@Test(description = "��ȷ��ʾ��΢�Ű󶨡�����", priority = 2)
	public void test_wechatInfo() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("΢�Ű�");
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�Ƿ�΢�Ű�"), "ҳ����ʾʧ��");
	}

	@Test(description = "���-����", dependsOnMethods = "test_wechatInfo", priority = 3)
	public void test_unbundl() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button");
		Thread.sleep(1000);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// �ڶ���ȷ�ϵ�����Ϣ
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "���ʧ��");
	}

	/** �û����� - ��������*/
	@Test(description = "��ȷ��ʾ���û����á�����", priority = 4)
	public void test_userBasicConfigu() throws InterruptedException {
		// ��ˢ�´��ڽ��棬ʹ�ø������ڵ����⣺���뱣�ֵ�ǰ���ڽ���Ϊ���ԵĽ��棬�����������в��Թ���
//		driver.navigate().refresh();
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("��������");
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[4]/ul/li[3]");
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�û�����"), "ҳ����ʾʧ��");
	}

	@Test(description = "ע������", dependsOnMethods = "test_userBasicConfigu", priority = 5)
	public void test_register() throws InterruptedException {
		webtest.click("xpath=//*[@id='id_REG_SWITCH_mobile']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='id_EMAIL_VERIFY_TYPE_1']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='id_MOBILE_VERIFY_TYPE_1']");
		// ʵ��Ԫ����ק����
		Actions action = new Actions(driver);
		WebElement source = webtest.getElementByXpath(
				"/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[1]/div[8]/div/div[1]/div[2]/div/ol/li/div");
		// WebElement target = webtest.getElementByXpath("//*[@id='nestable_list_2']");
		WebElement target = webtest.getElementByXpath(
				"/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[1]/div[8]/div/div[2]/div[2]/div/ol/li[1]/div");

		action.dragAndDrop(source, target).perform();
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�������óɹ��� ҳ�漴���Զ���ת~");
	}

	@Test(description = "��¼����", dependsOnMethods = "test_userBasicConfigu", priority = 6)
	public void test_login() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[2]/a");
		Thread.sleep(1000);
		// ��ȡԪ�ص�����ֵ�����жϣ�����ֻ���û�б���ѡ �ٽ��й�ѡ������
		WebElement element = webtest.getElementByXpath(
				"/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/div[2]/input");
		String values = element.getAttribute("value");
		System.out.println(values);
		if (!values.contains("mobile")) {
			webtest.click("xpath=//*[@id='id_LOGIN_SWITCH_mobile']");
		}
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/div[3]/input",
				"@126.com");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�������óɹ��� ҳ�漴���Զ���ת~");
	}

	@Test(description = "������֤ģ��", dependsOnMethods = "test_userBasicConfigu", priority = 7)
	public void test_emailVerify() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[3]/a");
		Thread.sleep(3000);
		driver.switchTo().frame("ueditor_0");
		webtest.typeAndClear("xpath=/html/body", "Changed11:������֤��Ϊ{$verify}��֤�룬�˺�Ϊ{$account}��");
		Thread.sleep(3000);
		// �л��ص�������
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�������óɹ��� ҳ�漴���Զ���ת~");
	}

	@Test(description = "���伤��ģ��", dependsOnMethods = "test_userBasicConfigu", priority = 8)
	public void test_emailActivation() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[4]/a");
		Thread.sleep(3000);
		driver.switchTo().frame("ueditor_1");
		webtest.typeAndClear("xpath=/html/body", "Changed:����{$title}�ļ�������Ϊ��������븴�����ӣ�{$url}��������򿪡�");
		Thread.sleep(3000);
		// �л��ص�������
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�������óɹ��� ҳ�漴���Զ���ת~");
	}

	@Test(description = "��������", dependsOnMethods = "test_userBasicConfigu", priority = 9)
	public void test_smsConfigu() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[5]/a");
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[5]/div[2]/input",
				"40");
		Thread.sleep(1500);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[5]/div[4]/input",
				"123456");
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�������óɹ��� ҳ�漴���Զ���ת~");
	}

	@Test(description = "��������", dependsOnMethods = "test_userBasicConfigu", priority = 10)
	public void test_basicConfigu() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[6]/a");
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[6]/div[3]/input",
				"6");
		Thread.sleep(1500);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[6]/div[5]/input",
				"4");
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�������óɹ��� ҳ�漴���Զ���ת~");
	}

	/** �û����� - Ȩ�������*/
	@Test(description = "��ȷ��ʾ��Ȩ�޹�����Ϣ����", priority = 0)
	public void test_authorityManage() throws InterruptedException {
		// ��ˢ�´��ڽ��棬ʹ�ø������ڵ����⣺���뱣�ֵ�ǰ���ڽ���Ϊ���ԵĽ��棬�����������в��Թ���
		driver.navigate().refresh();
		Thread.sleep(3000);
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("Ȩ�������");
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[4]/ul/li[5]/a");
//		subMenu.click();
		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("Ȩ�޹���"), "ҳ����ʾʧ��");
	}

	@Test(description = "����Ȩ�޹�����", dependsOnMethods = "test_authorityManage", priority = 1)
	public void test_addAuthorityManage() throws InterruptedException {
		webtest.click("xpath=//*[@id='add-group']");
		Thread.sleep(1000);
		webtest.typeAndClear("xpath=//*[@id='auth-title']", "����Ա11");
		Thread.sleep(1000);
		webtest.typeAndClear("xpath=//*[@id='auth-description']", "����Ȩ��");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[2]/form/div[4]/button[1]");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�����ɹ���");
	}
}
