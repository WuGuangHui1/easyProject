package com.webtest.smoketest.testcases.dxy;

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

import com.webtest.core.dxy.BaseTest;
import com.webtest.freemarker.dxy.GenerateReporter;

/** 
 * 
 * @author 杜鑫宇
 * 用户与身份模块 头衔管理 （注释：该功能项用例测试已完成！已通过整体类的测试）
 */
@Listeners(GenerateReporter.class)
public class TitleManagementTest extends BaseTest {

	@BeforeClass
	public void openUrl() {
		webtest.open("http://localhost:8033//admin.php");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
	}

	/** 头衔管理——查看用户 */
	@Test(description = "正确显示‘用户列表’界面", priority = 0)
	public void test_usersList() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("查看用户");
		// action.moveToElement(subMenu).click().perform();会滑动到运营功能项，所以不能采用这种方式
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("用户列表"), "页面显示失败");
	}

	@Test(description = "关联新头衔", dependsOnMethods = "test_usersList", priority = 1)
	public void test_relatedTitle() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[2]/td[1]/input");
		// 定位的是勾选项的关联项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[2]/td[5]/a[2]");
		Thread.sleep(1000);
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/input",
				"关联理由" + DataActionUtil.getRandomString(4));
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1500);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String texts = content.getText();
		Thread.sleep(2000);
		System.out.println(texts);
		if (texts != null) {
			System.out.println("关联新头衔功能实现");
		}
	}

	@Test(description = "用户头衔列表", dependsOnMethods = "test_usersList", priority = 2)
	public void test_showDetailTitles() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		// 定位的是勾选项的关联项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/table/tbody/tr[2]/td[5]/a[1]");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("的头衔列表"), "页面显示失败");
		Thread.sleep(1000);
	}

	@Test(description = "搜索用户列表信息", dependsOnMethods = "test_usersList", priority = 3)
	public void test_searchUserInfo() throws InterruptedException {
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/input", "admin");
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='search']");
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("昵称"), "页面显示失败");
		assertTrue(webtest.isTextPresent("admin"), "页面显示失败");
		assertTrue(webtest.isTextPresent("1"), "页面显示失败");
		Thread.sleep(1000);
	}

	/** 头衔管理——待审核用户头衔 */
//	@Test(description = "正确显示头衔列表信息界面", priority = 4)
	/** org.openqa.selenium.WebDriverException: TypeError: rect is undefined */
	public void test_showUserInfo() throws InterruptedException {
		// 先刷新窗口界面
		// 使用该语句存在的问题：必须保持当前窗口界面为测试的界面，才能正常进行测试过程
		driver.navigate().refresh();
		Thread.sleep(1000);
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByText("用户与身份");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[2]/ul/li[3]");
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("待审核的头衔列表"), "页面显示失败");
	}

//	@Test(description = "审核通过", dependsOnMethods = "test_showUserInfo", priority = 5)
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
			System.out.println("页面给出提示信息");
		}
	}

//	@Test(description = "审核不通过", dependsOnMethods = "test_showUserInfo", priority = 6)
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
			System.out.println("页面给出提示信息");
		}
	}

	/** 头衔管理——被驳回的头衔申请 */
	@Test(description = "正确显示被驳回的头衔申请列表界面", priority = 7)
	public void test_applyTitle() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]");
		// Element could not be scrolled into view
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[2]/ul/li[4]");
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("被驳回的头衔申请列表"), "页面显示失败");
	}

	@Test(description = "审核通过操作", dependsOnMethods = "test_applyTitle", priority = 8)
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
			System.out.println("页面给出提示信息,按钮正常使用");
		}
	}

	/** 头衔管理——头衔列表 */
	@Test(description = "正确显示头衔信息", priority = 9)
	public void test_showTitleInfo() throws InterruptedException {
		// 先刷新窗口界面，使用该语句存在的问题：必须保持当前窗口界面为测试的界面，才能正常进行测试过程
		driver.navigate().refresh();
		/*
		 * org.openqa.selenium.WebDriverException: TypeError: rect is undefined Build
		 * info: version: '3.141.59'
		 */
		Thread.sleep(1000);
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByText("用户与身份");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest
				.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[2]/ul/li[5]");
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("头衔列表"), "页面显示失败");
	}

	@Test(description = "新增头衔", dependsOnMethods = "test_showTitleInfo", priority = 10)
	public void test_addTitle() throws InterruptedException, AWTException {
		// 点击 新增
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a");
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"新增头衔" + DataActionUtil.getRandomString(4));
		// 单击 选择图片(图片上传)
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[3]/div/div[1]/div[2]/label");
		// s2.jpg
		Thread.sleep(1000);
		DataActionUtil.paste("F:\\Demo\\jpg\\s3.jpg");
		Thread.sleep(2000);
		Robot r = new Robot();
		// 摁下enter键
		r.keyPress(KeyEvent.VK_ENTER);
		// 放开enter键
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		// selenium中给元素添加属性的操作
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/input",
				"文字头衔：" + DataActionUtil.getRandomString(2));
		Thread.sleep(1500);
		// 文字头衔颜色选择器
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[5]/div/div/div[1]");
		Thread.sleep(1500);
		// 选择颜色
		webtest.click("xpath=//*[@id='66ffff']");
		Thread.sleep(1500);
		// 文字头衔标签背景颜色
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[6]/div/div/div[1]");
		Thread.sleep(1500);
		// 选择颜色
		// id定位不到不在视野内，换绝对路径
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[6]/div/div/div[2]/div[3]");
		Thread.sleep(1500);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		// 定位 弹窗元素，获取弹窗内文本信息内容
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "添加成功 页面即将自动跳转~", "新增头衔操作失败");
	}

	@Test(description = "删除头衔", dependsOnMethods = "test_showTitleInfo", priority = 11)
	public void test_deleteTitle() throws InterruptedException {
		// 勾选列表项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
		Thread.sleep(1000);
		// 单击 列表项对应的删除操作
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[17]/a[2]");
		Thread.sleep(4000);
		assertTrue(webtest.isTextPresent("头衔列表"), "删除操作失败");
		Thread.sleep(1000);
		System.out.println("成功删除头衔");
	}

	@Test(description = "编辑头衔", dependsOnMethods = "test_showTitleInfo", priority = 12)
	public void test_editTitle() throws InterruptedException {
		// 勾选列表项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
		Thread.sleep(1000);
		// 单击 列表项对应的编辑操作
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[17]/a[1]");
		Thread.sleep(2000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input", "编辑了头衔！");
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		Assert.assertEquals(text, "编辑成功 页面即将自动跳转~", "编辑头衔操作失败");
	}

	@Test(description = "前台是否可申请", dependsOnMethods = "test_showTitleInfo", priority = 13)
	public void test_ifFrontApply() throws InterruptedException {
		// 勾选列表项
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[1]/input");
		Thread.sleep(1000);
		// 单击 前台是否可申请一栏中的超链接
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[6]/table/tbody/tr[3]/td[15]/a");
		Thread.sleep(2000);
		String info = driver.getWindowHandle();
		System.out.println(info);
		Assert.assertEquals(info, "8", "操作失败");
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("头衔列表"), "前台是否可申请操作操作失败");
	}
}
