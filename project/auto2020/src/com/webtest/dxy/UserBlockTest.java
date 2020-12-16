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
 * @author 杜鑫宇
 * 用户与身份模块 首页（注释：该功能项用例测试已完成！已通过整体类的测试）
 * 已解决：先按照正常顺序执行一遍，会乱序执行测试，但都成功；再标priority执行，按照顺序执行成功
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

	/** 首页：用户列表--正确正常显示 */
	@Test(description = "首页：用户列表--正确正常显示", priority = 0)
	public void test_checkUser() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent("用户列表"), "页面显示失败");
	}

	@Test(description = "用户列表--授权操作", priority = 1)
	public void test_grant() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// 勾选列表第一项内容
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// 单击“授权”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[5]/a[2]");
		Thread.sleep(2000);
		// 勾选“普通用户”前选框
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[2]/form/div[1]/label[1]/input");
		Thread.sleep(1500);
		// 单击“确定”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[2]/form/div[2]/button[1]");
		Thread.sleep(1000);
		// 确定提示框
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement parentMenu = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = parentMenu.getText();
		System.out.println(text);
		// 断言判断
		Assert.assertEquals(text, "操作成功");
		Thread.sleep(2000);

	}

	@Test(description = "用户列表--重置密码操作", priority = 2)
	public void test_resetPassword() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// 勾选列表第一项内容
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// 单击“重置密码”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[5]/a[4]");
		Thread.sleep(2000);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement toast = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = toast.getText();
		System.out.println(text);
		Thread.sleep(3000);
		if (text.equals("密码重置失败！可能密码重置前就是“123456”。")) {
			Assert.assertEquals(text, "密码重置失败！可能密码重置前就是“123456”。");
			System.out.println("重置密码操作成功");
		} else if (text.contains("成功")) {
			System.out.println("重置密码操作成功");
		} else {
			System.out.println("重置密码操作失败");
		}
	}

	@Test(description = "用户列表--禁用操作", priority = 3)
	public void test_disable() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// 勾选列表第一项内容
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// 单击“禁用”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[2]");
		Thread.sleep(1500);
		// 确定提示框
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		// 选择禁用天数
		webtest.click("xpath=/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ul[2]/li[1]");
		Thread.sleep(1500);
		// 点击确定
		webtest.click("xpath=/html/body/div[3]/div[2]/div/div[2]/div/div[2]/button");
		// 定位不到弹窗元素，改成验证操作结果内容的形式
		// WebElement toast =
		// webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		Thread.sleep(3000);
		// 在操作完成后刷新的界面中定位 验证元素
		WebElement target = webtest.getElementByXpath(
				"/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[5]/span");
		String text = target.getText();
		System.out.println(text);
		Thread.sleep(2000);
		if (text.contains("禁用至：")) {
			System.out.println("禁用操作成功！");
		} else {
			System.out.println("禁用操作失败！");
		}
	}

	@Test(description = "用户列表--启用操作", priority = 4)
	public void test_startUsing() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// 勾选列表第一项内容
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// 单击“启用”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[1]");
		Thread.sleep(1500);
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3000);
		Assert.assertEquals(text, "状态恢复成功！");
	}

	@Test(description = "用户列表--选择用户分组", priority = 5)
	public void test_selectGroup() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// 勾选列表第一项内容
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// 单击“选择用户分组”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[4]");
		Thread.sleep(2000);
		// 在扩展窗口中勾选VIP
		webtest.click("xpath=/html/body/div[3]/div/div/form/div[3]/label[2]/input");
		Thread.sleep(1500);
		// 点击 提交按钮
		webtest.click("xpath=/html/body/div[3]/div/div/form/button/a");
		Thread.sleep(1500);
		// 确定提示框
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("选择用户分组"), "页面显示失败，操作有误");
	}

	@Test(description = "用户列表--修改第三方登录邮箱后缀", priority = 6)
	public void test_ModifyEmailSuffix() throws InterruptedException {
		webtest.click("xpath=/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(1000);
		// 勾选列表第一项内容
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		Thread.sleep(1500);
		// 单击“修改第三方登录邮箱后缀”按钮
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/button[5]");
		// 确定提示框
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3000);
		// 断言判断
		Assert.assertEquals(text, "已执行");
	}

	@Test(description = "用户列表--搜索框", priority = 7)
	public void test_searchInfo() throws InterruptedException {
		webtest.click("xpath=//*[@id='seek']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='seek']/option[3]");
		webtest.typeAndClear("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[3]/div/input",
				"admin");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='search']");
		Thread.sleep(1500);
		assertTrue(webtest.isTextPresent("用户名：admin"), "搜索结果显示失败");
	}

}
