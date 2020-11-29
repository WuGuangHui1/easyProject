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
	// 用户与身份模块 身份管理 （注释：该功能项用例已完成！已通过整体类的测试
	@BeforeClass
	public void openUrl() {
		webtest.open("http://localhost:8033//admin.php");
		// 登录
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
	}

	// 身份管理——身份列表
	@Test(description = "正确显示‘身份列表’界面", priority = 0)
	public void test_correct_display() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("身份列表");
		Thread.sleep(3000);
//		subMenu.click();
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("身份列表 "), "页面显示失败");
	}

	@Test(description = "新增", priority = 1)
	public void test_addIdentity() throws InterruptedException {
		// 点击 新增
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a[1]");
		Thread.sleep(1000);
		// 身份名
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[1]/input",
				"新增头衔" + DataActionUtil.getRandomString(8));
		// 英文标识
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[2]/input",
				"new_" + DataActionUtil.getRandomString(4));
		// 单击 下拉框
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[4]/select");
		Thread.sleep(3000);
		// 单击选择分组01
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/div[4]/select/option[2]");
		// 需要审核 开启
		webtest.click("xpath=//*[@id='id_audit_1']");
		// 单击 下一步
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div/div[2]/div/form/button");
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		// 断言判断
		if (text.contains("只能由字母和下滑线组成")) {
			Assert.assertEquals(text, "新增身份失败！身份标识只能由字母和下滑线组成。", "新增操作失败");
		} else if (text.contains("已经存在")) {
			Assert.assertEquals(text, "新增身份失败！身份标识已经存在。", "新增操作失败");
		} else if (text.contains("成功")) {
			Assert.assertEquals(text, "新增身份成功 页面即将自动跳转~", "新增操作失败");
			System.out.println("新增操作成功");
		} else {
			System.out.println("新增操作失败");
		}
		Thread.sleep(2000);
	}

	@Test(description = "启用", priority = 2)
	public void test_startUsing() throws InterruptedException {
		// 因为要在一个类中进行一系列方法的连续测试，所以页面之间要进行切换连接
		this.driver.navigate().back();
		Thread.sleep(1500);
		this.driver.navigate().back();
		Thread.sleep(1500);
		// 单击 启用
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		Thread.sleep(1500);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3500);
		// 断言判断是否勾选
		if (text.contains("勾选")) {
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
			// 确定提示框
			driver.switchTo().alert().accept();
			// 定位 弹窗元素，获取弹窗内文本信息内容
			Thread.sleep(1000);
			WebElement content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			String text2 = content2.getText();
			System.out.println(text2);
			if (text2.contains("系统默认身份")) {
				Thread.sleep(3500);
				// 再次勾选id为1的系统用户，以此取消勾选操作- -
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
				Thread.sleep(1000);
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[2]/td[1]/input");
				Thread.sleep(1000);
				webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
				// 确定提示框
				driver.switchTo().alert().accept();
				// 定位 弹窗元素，获取弹窗内文本信息内容
				Thread.sleep(1000);
				WebElement content3 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
				String text3 = content3.getText();
				System.out.println(text3);
				Assert.assertEquals(text3, "设置成功 页面即将自动跳转~", "启用操作失败");// 可以将if语句换成while循环进行满足设置启动条件的判断
			}
		} else if (text.contains("设置成功")) {
			Assert.assertEquals(text, "设置成功 页面即将自动跳转~", "启用操作失败");
		} else {
			System.out.println("页面出错啦！请重新操作。");
		}
		Thread.sleep(2500);
	}

	@Test(description = "禁用", priority = 3)
	public void test_disable() throws InterruptedException {
		// 单击 禁用
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		Thread.sleep(1500);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3500);
		// 断言判断是否勾选
		if (text.contains("勾选")) {
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
			// 确定提示框
			driver.switchTo().alert().accept();
			// 定位 弹窗元素，获取弹窗内文本信息内容
			Thread.sleep(1000);
			WebElement content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			String text2 = content2.getText();
			System.out.println(text2);
			if (text2.contains("系统默认身份")) {
				Thread.sleep(3500);
				// 再次勾选id为1的系统用户，以此取消勾选操作- -
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[1]/td[1]/input");
				Thread.sleep(1000);
				webtest.click(
						"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[2]/td[1]/input");
				Thread.sleep(1000);
				webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
				// 确定提示框
				driver.switchTo().alert().accept();
				// 定位 弹窗元素，获取弹窗内文本信息内容
				Thread.sleep(1000);
				WebElement content3 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
				String text3 = content3.getText();
				System.out.println(text3);
				if (text3.contains("单身份用户")) {
					Thread.sleep(3500);
					// 再次勾选，以此取消上一步的勾选操作- -
					webtest.click(
							"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[2]/td[1]/input");
					Thread.sleep(1000);
					webtest.click(
							"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
					Thread.sleep(1000);
					webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
					Thread.sleep(1000);
					// 确定提示框
					driver.switchTo().alert().accept();
					// 定位 弹窗元素，获取弹窗内文本信息内容
					Thread.sleep(1000);
					WebElement content4 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
					String text4 = content4.getText();
					System.out.println(text4);
					Assert.assertEquals(text4, "设置成功 页面即将自动跳转~", "禁用操作失败");
				} else {
					System.out.println("页面出错啦！请重新操作。");
				}
			} else if (text.contains("设置成功")) {
				Assert.assertEquals(text, "设置成功 页面即将自动跳转~", "禁用操作失败");
			} else {
				System.out.println("页面出错啦！请重新操作。");
			}
		}
	}

//	@Test(description = "删除", priority = 4)
	// 单独测试该用例可以执行，整合在同一个类中一同测试报错：org.openqa.selenium.UnhandledAlertException:
	// Dismissed user prompt dialog: 确认删除身份？删除后不可恢复！:
	public void test_delete() throws InterruptedException, AWTException {
		WebElement content2;
		String text2;
		// 单击 删除
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[3]");
		Thread.sleep(1500);
		// 确定提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(3500);
		// 断言判断是否勾选
		if (text.contains("勾选")) {
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
			Thread.sleep(1000);
			// 存在该元素，前边你有新增操作
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[3]");
			Thread.sleep(2000);
			// 确定提示框
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			// 再次确定提示框
			driver.switchTo().alert().accept();
			Thread.sleep(1300);
			// 定位 弹窗元素，获取弹窗内文本信息内容
			content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			text2 = content2.getText();
			Thread.sleep(2500);
			System.out.println(text2);
		} else {
			text2 = null;
		}
		Assert.assertEquals(text2, "删除成功！ 页面即将自动跳转~", "删除操作失败");
	}

	// 身份管理——身份分组
	@Test(description = "正确显示‘身份分组’界面", priority = 5)
	public void test_correct_displaylist() throws InterruptedException {
		// 先刷新窗口界面
		driver.navigate().refresh();//使用该语句存在的问题：必须保持当前窗口界面为测试的界面，才能正常进行测试过程
		Thread.sleep(3000);
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("身份分组");
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[3]/ul/li[3]");
//		subMenu.click();
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("身份分组"), "页面显示失败");
	}

	@Test(description = "新增分组", dependsOnMethods = "test_correct_displaylist", priority = 6)
	public void test_addGroup() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a");
		Thread.sleep(1500);
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"新增分组" + DataActionUtil.getRandomString(3));
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/span/span[1]/span/ul/li/input");
		Thread.sleep(2000);
//		webtest.click("xpath=//*[@id='select2-roles[]-t2-result-oo5f-2']");下拉框中选项的id值变化，不可直接用id定位，使用下面绝对定位方式
		webtest.click("xpath=/html/body/span/span/span/ul/li[2]");// li列表从1开始
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1500);
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
		Assert.assertEquals(texts, "新增分组成功！ 页面即将自动跳转~", "新增分组操作失败");
	}

	// 身份管理——用户身份归属列表
	@Test(description = "正确显示‘身份用户列表’界面", priority = 7)
	public void test_correct_displayIDlist() throws InterruptedException {
		driver.navigate().refresh();
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
//		WebElement subMenu = webtest.getElementByText("用户身份归属列表");
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[3]/ul/li[4]");
		Thread.sleep(3000);
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("身份用户列表"), "页面显示失败");
	}

	@Test(description = "迁移用户-操作", dependsOnMethods = "test_correct_displayIDlist", priority = 8)
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
		// 不能定位到弹窗元素，获取弹窗内文本信息内容
//		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
//		String texts = content.getText();
	}

	@Test(description = "启用-操作", dependsOnMethods = "test_correct_displayIDlist", priority = 9)
	public void test_restart() throws InterruptedException {
		// 勾选列表项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
		// 单击 启用
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
		// 确认提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
		// 如果没有操作的数据，先进行 切换身份
		if (texts.contains("没有可操作数据")) {
			Thread.sleep(2000);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/div/form/div[1]/div[2]/select");
			Thread.sleep(1500);
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/div/form/div[1]/div[2]/select/option[2]");
			Thread.sleep(2000);
			// 勾选列表项
			webtest.click(
					"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
			// 单击 启用
			webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[1]");
			// 确认提示框
			driver.switchTo().alert().accept();
			// 定位 弹窗元素，获取弹窗内文本信息内容
			Thread.sleep(1000);
			WebElement content2 = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
			texts = content2.getText();
			System.out.println(texts);
		}
		Assert.assertEquals(texts, "设置成功 页面即将自动跳转~", "启用操作失败");
	}

	@Test(description = "禁用-操作", dependsOnMethods = "test_correct_displayIDlist", priority = 10)
	public void test_disableUsing() throws InterruptedException {
		// 勾选列表项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr/td[1]/input");
		// 单击 禁用
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/button[2]");
		// 确认提示框
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
		if (texts.contains("成功")) {
			Assert.assertEquals(texts, "设置成功 页面即将自动跳转~", "禁用操作失败");
		} else if (texts.contains("不能被禁用")) {
			Assert.assertEquals(texts, "id为{$_ERROR_ID_s}的身份用户只拥有该身份，不能被禁用！", "禁用操作失败");
		} else {
			System.out.println("页面出错啦！请重新操作。");
		}
	}

	@Test(description = "初始化没身份的用户", dependsOnMethods = "test_correct_displayIDlist", priority = 11)
	public void test_initUserId() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a");
		Thread.sleep(1500);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		System.out.println(texts);
	}

}
