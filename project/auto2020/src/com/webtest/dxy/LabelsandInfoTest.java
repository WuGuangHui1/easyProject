package com.webtest.dxy;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.demo.Admin_Login;
import com.webtest.freemarker.GenerateReporter;

/**
 * @author ������
 * �û������ģ�� ��ǩ������ ��ע�ͣ���������ִ��˳��󣬸ù�������������ɲ�ͨ�����ϲ��ԣ���
 */
@Listeners(GenerateReporter.class)
public class LabelsandInfoTest extends Admin_Login {
//	@BeforeClass
//	public void openUrl() {
//		webtest.open("http://localhost:8033//admin.php");
//		// ��¼
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "123456");
//		webtest.click("class=login-btn");
//	}

	/** ��ǩ������ - ��չ���� */
	@Test(description = "��ȷ��ʾ����չ��Ϣ�����б�����", priority = 5)
	public void test_showGroupInfo() throws InterruptedException {
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("��չ����");
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("��չ��Ϣ�����б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "����-��չ��Ϣ����", dependsOnMethods = "test_showGroupInfo", priority = 6)
	public void test_addGroupInfo() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a[1]");
		Thread.sleep(1000);
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"��������" + DataActionUtil.getRandomString(3));
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("��չ��Ϣ�����б�"), "ҳ����ʾʧ��");
	}

	/** ��ǩ������ - �û���ǩ�б� */
	@Test(description = "��ȷ��ʾ���û���ǩ��������", priority = 1)
	public void test_showGroupLabel() throws InterruptedException {
		driver.navigate().refresh();
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		Thread.sleep(2000);
		WebElement parentMenu = webtest.getElementByXpath("//ul[@class='nav navbar-nav top-menu']/li[2]/a");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[5]/ul/li[3]/a");
		Thread.sleep(2000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�û���ǩ����"), "ҳ����ʾʧ��");
	}

	@Test(description = "����-�û���ǩ����", dependsOnMethods = "test_showGroupLabel", priority = 2)
	public void test_addGroupLabel() throws InterruptedException {
//		driver.navigate().refresh();
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/div[1]/a[1]");
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"��������ı��⣺" + DataActionUtil.getRandomString(5));
		Thread.sleep(1000);
		// ״̬ ѡ��δ��ˡ�
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/select");
		Thread.sleep(1500);
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/select/option[4]");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// ��λ ����Ԫ�أ���ȡ�������ı���Ϣ����
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		if (text != null) {
			System.out.println("���������ɹ���");
		}
	}

	/** ��ǩ������ - �û���չ�����б� */
	@Test(description = "��ȷ��ʾ���û���չ�����б�����", priority = 3)
	public void test_showLabelInfo() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		// ����ͣ���Ӳ˵���,Ȼ���ٲ����Ӳ˵���ѡ��
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
//		WebElement subMenu = webtest.getElementByText("�û���չ�����б�");
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[5]/ul/li[4]/a");
//		subMenu.click();
//		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("�û���չ�����б�"), "ҳ����ʾʧ��");
	}

	@Test(description = "����", dependsOnMethods = "test_showLabelInfo", priority = 4)
	public void test_searchInfo() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button");
		Thread.sleep(1000);
		webtest.type(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/form/div/table/tbody/tr[1]/td[2]/input",
				"admin");
		Thread.sleep(1000);
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/form/div/table/tbody/tr[2]/td[2]/input");
		Thread.sleep(1500);
		assertTrue(webtest.isTextPresent("�� 1 ����¼"), "����ʧ��");
	}
}
