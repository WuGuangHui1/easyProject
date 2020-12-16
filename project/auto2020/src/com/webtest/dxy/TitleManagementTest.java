package com.webtest.dxy;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.demo.Admin_Login;
import com.webtest.freemarker.GenerateReporter;

/** 
 * 
 * @author ������
 * �û������ģ�� ͷ�ι��� ��ע�ͣ��ù�����������������ɣ���ͨ��������Ĳ��ԣ�
 */
@Listeners(GenerateReporter.class)
public class TitleManagementTest extends Admin_Login {

//	@BeforeClass
//	public void openUrl() {
//		webtest.open("http://localhost:8033//admin.php");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("class=login-btn");
//	}

	/** ͷ�ι������鿴�û� */
	@Test(description = "��ȷ��ʾ���û��б�����", priority = 0)
	public void test_usersList() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("�鿴�û�");
		// action.moveToElement(subMenu).click().perform();�Ử������Ӫ��������Բ��ܲ������ַ�ʽ
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�û��б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "������ͷ��", dependsOnMethods = "test_usersList", priority = 1)
	public void test_relatedTitle() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[2]/td[1]/input");
		// ��λ���ǹ�ѡ��Ĺ�����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[2]/td[5]/a[2]");
		Thread.sleep(1000);
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/input",
				"��������" + DataActionUtil.getRandomString(4));
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		Thread.sleep(2000);
		System.out.println(texts);
		if (texts != null) {
			System.out.println("������ͷ�ι���ʵ��");
		}
	}

	@Test(description = "�û�ͷ���б�", dependsOnMethods = "test_usersList", priority = 2)
	public void test_showDetailTitles() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		// ��λ���ǹ�ѡ��Ĺ�����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[2]/td[5]/a[1]");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("��ͷ���б�"), "ҳ����ʾʧ��");
		Thread.sleep(1000);
	}

	@Test(description = "�����û��б���Ϣ", dependsOnMethods = "test_usersList", priority = 3)
	public void test_searchUserInfo() throws InterruptedException {
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/input", "admin");
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='search']");
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("�ǳ�"), "ҳ����ʾʧ��");
		assertTrue(webtest.isTextPresent("admin"), "ҳ����ʾʧ��");
		assertTrue(webtest.isTextPresent("1"), "ҳ����ʾʧ��");
		Thread.sleep(1000);
	}

	/** ͷ�ι�����������û�ͷ�� */
//	@Test(description = "��ȷ��ʾͷ���б���Ϣ����", priority = 4)
	/** org.openqa.selenium.WebDriverException: TypeError: rect is undefined */
	public void test_showUserInfo() throws InterruptedException {
		// ��ˢ�´��ڽ���
		// ʹ�ø������ڵ����⣺���뱣�ֵ�ǰ���ڽ���Ϊ���ԵĽ��棬�����������в��Թ���
		driver.navigate().refresh();
		Thread.sleep(1000);
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByText("�û������");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[2]/ul/li[3]");
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("����˵�ͷ���б�"), "ҳ����ʾʧ��");
	}

//	@Test(description = "���ͨ��", dependsOnMethods = "test_showUserInfo", priority = 5)
	public void test_allow() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		Thread.sleep(2000);
		System.out.println(texts);
		if (content != null) {
			System.out.println("ҳ�������ʾ��Ϣ");
		}
	}

//	@Test(description = "��˲�ͨ��", dependsOnMethods = "test_showUserInfo", priority = 6)
	public void test_disallow() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		Thread.sleep(3000);
		System.out.println(texts);
		if (content != null) {
			System.out.println("ҳ�������ʾ��Ϣ");
		}
	}

	/** ͷ�ι����������ص�ͷ������ */
	@Test(description = "��ȷ��ʾ�����ص�ͷ�������б����", priority = 7)
	public void test_applyTitle() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]");
		// Element could not be scrolled into view
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[2]/ul/li[4]");
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�����ص�ͷ�������б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "���ͨ������", dependsOnMethods = "test_applyTitle", priority = 8)
	public void test_allowAction() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		Thread.sleep(5500);
		System.out.println(texts);
		if (content != null) {
			System.out.println("ҳ�������ʾ��Ϣ,��ť����ʹ��");
		}
	}

	/** ͷ�ι�����ͷ���б� */
	@Test(description = "��ȷ��ʾͷ����Ϣ", priority = 9)
	public void test_showTitleInfo() throws InterruptedException {
		// ��ˢ�´��ڽ��棬ʹ�ø������ڵ����⣺���뱣�ֵ�ǰ���ڽ���Ϊ���ԵĽ��棬�����������в��Թ���
		driver.navigate().refresh();
		/*
		 * org.openqa.selenium.WebDriverException: TypeError: rect is undefined Build
		 * info: version: '3.141.59'
		 */
		Thread.sleep(1000);
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByText("�û������");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[2]/ul/li[5]");
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("ͷ���б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "����ͷ��", dependsOnMethods = "test_showTitleInfo", priority = 10)
	public void test_addTitle() throws InterruptedException, AWTException {
		// ��� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a");
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"����ͷ��" + DataActionUtil.getRandomString(4));
		// ���� ѡ��ͼƬ(ͼƬ�ϴ�)
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/div/div[1]/div[2]/label");
		// s2.jpg
		Thread.sleep(1000);
		DataActionUtil.paste("F:\\Demo\\jpg\\s3.jpg");
		Thread.sleep(2000);
		Robot r = new Robot();
		// ����enter��
		r.keyPress(KeyEvent.VK_ENTER);
		// �ſ�enter��
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		// selenium�и�Ԫ��������ԵĲ���
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/input",
				"����ͷ�Σ�" + DataActionUtil.getRandomString(2));
		Thread.sleep(1500);
		// ����ͷ����ɫѡ����
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[5]/div/div/div[1]");
		Thread.sleep(1500);
		// ѡ����ɫ
		webtest.click("xpath=//*[@id='66ffff']");
		Thread.sleep(1500);
		// ����ͷ�α�ǩ������ɫ
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[6]/div/div/div[1]");
		Thread.sleep(1500);
		// ѡ����ɫ
		// id��λ����������Ұ�ڣ�������·��
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[6]/div/div/div[2]/div[3]");
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "��ӳɹ� ҳ�漴���Զ���ת~", "����ͷ�β���ʧ��");
	}

	@Test(description = "ɾ��ͷ��", dependsOnMethods = "test_showTitleInfo", priority = 11)
	public void test_deleteTitle() throws InterruptedException {
		// ��ѡ�б���
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
		Thread.sleep(1000);
		// ���� �б����Ӧ��ɾ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[17]/a[2]");
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("ͷ���б�"), "ɾ������ʧ��");
		Thread.sleep(1000);
		System.out.println("�ɹ�ɾ��ͷ��");
	}

	@Test(description = "�༭ͷ��", dependsOnMethods = "test_showTitleInfo", priority = 12)
	public void test_editTitle() throws InterruptedException {
		// ��ѡ�б���
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
		Thread.sleep(1000);
		// ���� �б����Ӧ�ı༭����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[17]/a[1]");
		Thread.sleep(2000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input", "�༭��ͷ�Σ�");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�༭�ɹ� ҳ�漴���Զ���ת~", "�༭ͷ�β���ʧ��");
	}

	@Test(description = "ǰ̨�Ƿ������", dependsOnMethods = "test_showTitleInfo", priority = 13)
	public void test_ifFrontApply() throws InterruptedException {
		// ��ѡ�б���
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
		Thread.sleep(1000);
		// ���� ǰ̨�Ƿ������һ���еĳ�����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[15]/a");
		Thread.sleep(2000);
		String info = driver.getWindowHandle();
		System.out.println(info);
		Assert.assertEquals(info, "8", "����ʧ��");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("ͷ���б�"), "ǰ̨�Ƿ�������������ʧ��");
	}
}
