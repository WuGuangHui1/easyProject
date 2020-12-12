package com.webtest.smoketest.testcases.dxy;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.dxy.BaseTest;
import com.webtest.freemarker.dxy.GenerateReporter;

/** 
 * @author 杜鑫宇
 * 用户与身份模块 用户配置  （注释：该功能项用例已完成！）
 *
 */
@Listeners(GenerateReporter.class)
public class UserConfigurationTest extends BaseTest {
	@BeforeClass
	public void openUrl() {
		webtest.open("http://localhost:8033//admin.php");
		//登录
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
	}

	/** 用户配置 - 微信绑定*/
	@Test(description = "正确显示‘微信绑定’界面", priority = 2)
	public void test_wechatInfo() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("微信绑定");
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("是否微信绑定"), "页面显示失败");
	}

	@Test(description = "解绑-操作", dependsOnMethods = "test_wechatInfo", priority = 3)
	public void test_unbundl() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button");
		Thread.sleep(1000);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 第二次确认弹窗信息
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "解绑失败");
	}

	/** 用户配置 - 基础配置*/
	@Test(description = "正确显示‘用户配置’界面", priority = 4)
	public void test_userBasicConfigu() throws InterruptedException {
		// 先刷新窗口界面，使用该语句存在的问题：必须保持当前窗口界面为测试的界面，才能正常进行测试过程
//		driver.navigate().refresh();
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("基础配置");
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[4]/ul/li[3]");
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("用户配置"), "页面显示失败");
	}

	@Test(description = "注册配置", dependsOnMethods = "test_userBasicConfigu", priority = 5)
	public void test_register() throws InterruptedException {
		webtest.click("xpath=//*[@id='id_REG_SWITCH_mobile']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='id_EMAIL_VERIFY_TYPE_1']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='id_MOBILE_VERIFY_TYPE_1']");
		// 实现元素拖拽操作
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
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "保存配置成功。 页面即将自动跳转~");
	}

	@Test(description = "登录配置", dependsOnMethods = "test_userBasicConfigu", priority = 6)
	public void test_login() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[2]/a");
		Thread.sleep(1000);
		// 获取元素的属性值进行判断，如果手机项没有被勾选 再进行勾选操作！
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
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "保存配置成功。 页面即将自动跳转~");
	}

	@Test(description = "邮箱验证模版", dependsOnMethods = "test_userBasicConfigu", priority = 7)
	public void test_emailVerify() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[3]/a");
		Thread.sleep(3000);
		driver.switchTo().frame("ueditor_0");
		webtest.typeAndClear("xpath=/html/body", "Changed11：​您的验证码为{$verify}验证码，账号为{$account}。");
		Thread.sleep(3000);
		// 切换回到主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "保存配置成功。 页面即将自动跳转~");
	}

	@Test(description = "邮箱激活模版", dependsOnMethods = "test_userBasicConfigu", priority = 8)
	public void test_emailActivation() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/ul/li[4]/a");
		Thread.sleep(3000);
		driver.switchTo().frame("ueditor_1");
		webtest.typeAndClear("xpath=/html/body", "Changed:您在{$title}的激活链接为激活，或者请复制链接：{$url}到浏览器打开。");
		Thread.sleep(3000);
		// 切换回到主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "保存配置成功。 页面即将自动跳转~");
	}

	@Test(description = "短信配置", dependsOnMethods = "test_userBasicConfigu", priority = 9)
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
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "保存配置成功。 页面即将自动跳转~");
	}

	@Test(description = "基础配置", dependsOnMethods = "test_userBasicConfigu", priority = 10)
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
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "保存配置成功。 页面即将自动跳转~");
	}

	/** 用户配置 - 权限组管理*/
	@Test(description = "正确显示‘权限管理’信息界面", priority = 0)
	public void test_authorityManage() throws InterruptedException {
		// 先刷新窗口界面，使用该语句存在的问题：必须保持当前窗口界面为测试的界面，才能正常进行测试过程
		driver.navigate().refresh();
		Thread.sleep(3000);
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("权限组管理");
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[4]/ul/li[5]/a");
//		subMenu.click();
		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("权限管理"), "页面显示失败");
	}

	@Test(description = "新增权限管理项", dependsOnMethods = "test_authorityManage", priority = 1)
	public void test_addAuthorityManage() throws InterruptedException {
		webtest.click("xpath=//*[@id='add-group']");
		Thread.sleep(1000);
		webtest.typeAndClear("xpath=//*[@id='auth-title']", "管理员11");
		Thread.sleep(1000);
		webtest.typeAndClear("xpath=//*[@id='auth-description']", "新增权限");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[2]/form/div[4]/button[1]");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "操作成功！");
	}
}
