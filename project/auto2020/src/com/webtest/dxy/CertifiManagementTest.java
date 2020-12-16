package com.webtest.dxy;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;
import com.webtest.freemarker.GenerateReporter;


/**
 * @author ������
 * �û������ģ�� ��֤����ע�ͣ��ù�����������������ɣ���ͨ��������Ĳ��ԣ�
 * �ѽ����dependsOnMethods��priority�᲻���ͻ��û�г�ͻ���ܰ���priority˳������
 */
@Listeners(GenerateReporter.class)
public class CertifiManagementTest extends Admin_Login {
//	@BeforeClass
//	public void openUrl() {
//		webtest.open("http://localhost:8033//admin.php");
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("class=login-btn");
//	}

	/** ��֤��������֤���� */
	@Test(description = "��ȷ��ʾ'��֤����'�б����", priority = 0)
	public void test_correct_display() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[1]/ul/li[2]/a");
		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("��֤�����б� "), "ҳ����ʾʧ��");
	}

	@Test(description = "'����'��֤����", dependsOnMethods = "test_correct_display", priority = 1)
	public void test_setAuthCondition() throws InterruptedException {
		// ��ѡһ�в�������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		// �����֤�����е� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[17]/a");
		Thread.sleep(1500);
		// ��ע�������� ��0��ʾ�����ƣ�
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/input", "0");
		// ��˿������ ��0��ʾ�����ƣ�
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[5]/input", "0");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		// ȷ����ʾ��
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�༭�ɹ��� ҳ�漴���Զ���ת~");
	}

	@Test(description = "'����'��֤�ֶ�", dependsOnMethods = "test_correct_display", priority = 2)
	public void test_setAuthField() throws InterruptedException {
		// ��ѡһ�в�������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		// �����֤�����е� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[19]/a");
		Thread.sleep(1500);
		// ��ҵ����֯�� ���Ƿ�Ҫ��д����Ϣ�� ��
		webtest.click("xpath=//*[@id='id_company_name_1']");
		// ��ʵ���� ��
		webtest.click("xpath=//*[@id='id_name_1']");
		// ���֤��� ��
		webtest.click("xpath=//*[@id='id_id_num_1']");
		// ��ϵ��ʽ ��
		webtest.click("xpath=//*[@id='id_phone_1']");
		Thread.sleep(1000);
		// ֤������ѡ��Χ
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[9]/input", "���֤");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�༭�ɹ��� ҳ�漴���Զ���ת~");

	}

	@Test(description = "�����С��༭��", dependsOnMethods = "test_correct_display", priority = 3)
	public void test_edit() throws InterruptedException {
		// ��ѡһ�в�������
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		// �����֤�����е� ����
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[21]/a");
		// ���� ����֤�������ƣ�
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/input", "�༭������֤");
		Thread.sleep(2000);
		// ��֤С��ʾ
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/input",
				"С��ʾ����ʵ��ݣ����ڱ���ʶ ����Ȩ������߿��Ŷ�");
		Thread.sleep(3500);
		// �����ӽ���, ˫�����е���iframe��ǩ��Id��name����λ//*[@id="ueditor_0"]
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=/html/body");
		webtest.type("xpath=/html/body", "<br/>" + "7.��Ϣ������ʵ");
		Thread.sleep(3000);
		// �л��ص�������
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "�༭�ɹ��� ҳ�漴���Զ���ת~");
	}

	/** ��֤��������֤�û��б� */
	@Test(description = "��ȷ��ʾ'��֤�û��б�'����", priority = 4)
	public void test_correct_displayUserInfo() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[1]/ul/li[3]/a");
		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("��֤�û��б� "), "ҳ����ʾʧ��");
	}

	@Test(description = "ͨ�����", dependsOnMethods = "test_correct_displayUserInfo", priority = 5)
	public void test_approveSuccess() throws InterruptedException {
		// ��� ͨ����˰�ť
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		Thread.sleep(1500);
		// ȷ����ʾ��
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(5000);
		Assert.assertEquals(text, "û�пɲ������ݡ�");
	}

	@Test(description = "���ʧ��/����", dependsOnMethods = "test_approveSuccess", priority = 6)
	public void test_approveFailed() throws InterruptedException {
		// ��� ���ʧ��/���ð�ť
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "û�пɲ������ݡ�");
	}

}
