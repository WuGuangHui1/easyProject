package com.webtest.dxy;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
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
 * �û������ģ�� ��ҳ��ע�ͣ��ù�����������������ɣ���ͨ��������Ĳ��ԣ�
 * �ѽ�����Ȱ�������˳��ִ��һ�飬������ִ�в��ԣ������ɹ����ٱ�priorityִ�У�����˳��ִ�гɹ�
 */
@Listeners(GenerateReporter.class)
public class UserBlockTest extends Admin_Login {
//	@BeforeClass
//	public void openUrl() {
//		webtest.open("http://localhost:8033//admin.php");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("class=login-btn");
//	}

	/** ��ҳ���û��б�--��ȷ������ʾ */
	@Test(description = "��ҳ���û��б�--��ȷ������ʾ", priority = 0)
	public void test_checkUser() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("�û��б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "�û��б�--��Ȩ����", priority = 1)
	public void test_grant() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// ��ѡ�б��һ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// ��������Ȩ��
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[5]/a[2]");
		Thread.sleep(2000);
		// ��ѡ����ͨ�û���ǰѡ��
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[2]/form/div[1]/label[1]/input");
		Thread.sleep(1500);
		// ������ȷ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[2]/form/div[2]/button[1]");
		Thread.sleep(1000);
		// ȷ����ʾ��
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement parentMenu = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = parentMenu.getText();
		System.out.println(text);
		// �����ж�
		Assert.assertEquals(text, "�����ɹ�");
		Thread.sleep(2000);

	}

	@Test(description = "�û��б�--�����������", priority = 2)
	public void test_resetPassword() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// ��ѡ�б��һ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// �������������롱
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[5]/a[4]");
		Thread.sleep(2000);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement toast = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = toast.getText();
		System.out.println(text);
		Thread.sleep(3000);
		if (text.equals("��������ʧ�ܣ�������������ǰ���ǡ�123456����")) {
			Assert.assertEquals(text, "��������ʧ�ܣ�������������ǰ���ǡ�123456����");
			System.out.println("������������ɹ�");
		} else if (text.contains("�ɹ�")) {
			System.out.println("������������ɹ�");
		} else {
			System.out.println("�����������ʧ��");
		}
	}

	@Test(description = "�û��б�--���ò���", priority = 3)
	public void test_disable() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// ��ѡ�б��һ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// ���������á�
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[2]");
		Thread.sleep(1500);
		// ȷ����ʾ��
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		// ѡ���������
		webtest.click("xpath=/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ul[2]/li[1]");
		Thread.sleep(1500);
		// ���ȷ��
		webtest.click("xpath=/html/body/div[3]/div[2]/div/div[2]/div/div[2]/button");
		// ��λ��������Ԫ�أ��ĳ���֤����������ݵ���ʽ
		// WebElement toast =
		// webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		Thread.sleep(3000);
		// �ڲ�����ɺ�ˢ�µĽ����ж�λ ��֤Ԫ��
		WebElement target = webtest.getElementByXpath(
				"/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[5]/span");
		String text = target.getText();
		System.out.println(text);
		Thread.sleep(2000);
		if (text.contains("��������")) {
			System.out.println("���ò����ɹ���");
		} else {
			System.out.println("���ò���ʧ�ܣ�");
		}
	}

	@Test(description = "�û��б�--���ò���", priority = 4)
	public void test_startUsing() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// ��ѡ�б��һ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// ���������á�
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[1]");
		Thread.sleep(1500);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3000);
		Assert.assertEquals(text, "״̬�ָ��ɹ���");
	}

	@Test(description = "�û��б�--ѡ���û�����", priority = 5)
	public void test_selectGroup() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// ��ѡ�б��һ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// ������ѡ���û����顱
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[4]");
		Thread.sleep(2000);
		// ����չ�����й�ѡVIP
		webtest.click("xpath=/html/body/div[3]/div/div/form/div[3]/label[2]/input");
		Thread.sleep(1500);
		// ��� �ύ��ť
		webtest.click("xpath=/html/body/div[3]/div/div/form/button/a");
		Thread.sleep(1500);
		// ȷ����ʾ��
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("ѡ���û�����"), "ҳ����ʾʧ�ܣ���������");
	}

	@Test(description = "�û��б�--�޸ĵ�������¼�����׺", priority = 6)
	public void test_ModifyEmailSuffix() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// ��ѡ�б��һ������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// �������޸ĵ�������¼�����׺����ť
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[5]");
		// ȷ����ʾ��
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3000);
		// �����ж�
		Assert.assertEquals(text, "��ִ��");
	}

	@Test(description = "�û��б�--������", priority = 7)
	public void test_searchInfo() throws InterruptedException {
		webtest.click("xpath=//*[@id='seek']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='seek']/option[3]");
		webtest.typeAndClear("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[3]/div/input",
				"admin");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='search']");
		Thread.sleep(1500);
		assertTrue(webtest.isTextPresent("�û�����admin"), "���������ʾʧ��");
	}

}
