package com.smoketest.testcases.controller;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.freemarker.GenerateReporter;

@Listeners(GenerateReporter.class)
public class CertifiManagementTest extends BaseTest {
	// 用户与身份模块 认证管理（注释：该功能项用例测试已完成！已解决：dependsOnMethods和priority会不会冲突？没有冲突，能按照priority顺序运行
	@BeforeClass
	public void openUrl() {
		webtest.open("http://localhost:8033//admin.php");
		// 登录
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
	}

	// 认证管理——认证类型
	@Test(description = "正确显示'认证类型'列表界面", priority=0)
	public void test_correct_display() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[1]/ul/li[2]/a");
		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("认证类型列表 "), "页面显示失败");
	}

	@Test(description = "'设置'认证条件", dependsOnMethods = "test_correct_display", priority=1)
	public void test_setAuthCondition() throws InterruptedException {
		// 勾选一行操作对象
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		// 点击认证条件中的 设置
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[17]/a");
		Thread.sleep(1500);
		// 关注人数大于 （0表示无限制）
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/input", "0");
		// 粉丝数大于 （0表示无限制）
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[5]/input", "0");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "编辑成功！ 页面即将自动跳转~");
	}

	@Test(description = "'设置'认证字段", dependsOnMethods = "test_correct_display", priority=2)
	public void test_setAuthField() throws InterruptedException {
		// 勾选一行操作对象
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		// 点击认证条件中的 设置
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[19]/a");
		Thread.sleep(1500);
		// 企业、组织名 （是否要填写该信息） 是
		webtest.click("xpath=//*[@id='id_company_name_1']");
		// 真实姓名 是
		webtest.click("xpath=//*[@id='id_name_1']");
		// 身份证编号 是
		webtest.click("xpath=//*[@id='id_id_num_1']");
		// 联系方式 是
		webtest.click("xpath=//*[@id='id_phone_1']");
		Thread.sleep(1000);
		// 证件类型选择范围
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[9]/input", "身份证");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "编辑成功！ 页面即将自动跳转~");

	}

	@Test(description = "操作中‘编辑’", dependsOnMethods = "test_correct_display", priority=3)
	public void test_edit() throws InterruptedException {
		// 勾选一行操作对象
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		// 点击认证条件中的 设置
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[21]/a");
		// 标题 （认证类型名称）
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/input", "编辑个人认证");
		Thread.sleep(2000);
		// 认证小提示
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/input",
				"小提示：真实身份，易于被辨识 更加权威，提高可信度");
		Thread.sleep(3000);
		// 进入子界面
		driver.switchTo().frame("ueditor_0");// 双引号中的用iframe标签的Id或name来定位
		webtest.click("xpath=/html/body");
		webtest.type("xpath=/html/body", "<br/>" + "7.信息必须真实");
		Thread.sleep(3000);
		// 切换回到主界面
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "编辑成功！ 页面即将自动跳转~");
	}

	// 认证管理——认证用户列表
	@Test(description = "正确显示'认证用户列表'界面", priority=4)
	public void test_correct_displayUserInfo() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[1]/ul/li[3]/a");
		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("认证用户列表 "), "页面显示失败");
	}

	@Test(description = "通过审核", dependsOnMethods = "test_correct_displayUserInfo", priority=5)
	public void test_approveSuccess() throws InterruptedException {
		// 点击 通过审核按钮
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		Thread.sleep(1500);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(5000);
		Assert.assertEquals(text, "没有可操作数据。");
	}
	
	@Test(description = "审核失败/禁用", dependsOnMethods = "test_approveSuccess", priority=6)
	public void test_approveFailed() throws InterruptedException {
		// 点击 审核失败/禁用按钮
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "没有可操作数据。");
	}

}
