package com.webtest.smoketest.testcases.dxy;

import static org.testng.Assert.assertTrue;

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
import com.webtest.utils.dxy.DataActionUtil;

/**
 * @author 杜鑫宇
 * 用户与身份模块 标签与资料 （注释：更改用例执行顺序后，该功能项用例已完成并通过整合测试！）
 */
@Listeners(GenerateReporter.class)
public class LabelsandInfoTest extends BaseTest {
	@BeforeClass
	public void openUrl() {
		webtest.open("http://localhost:8033//admin.php");
		// 登录
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
	}

	/** 标签与资料 - 扩展资料 */
	@Test(description = "正确显示‘扩展信息分组列表’界面", priority = 5)
	public void test_showGroupInfo() throws InterruptedException {
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/a");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
		Thread.sleep(3000);
		WebElement subMenu = webtest.getElementByText("扩展资料");
		subMenu.click();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("扩展信息分组列表"), "页面显示失败");
	}

	@Test(description = "新增-扩展信息分组", dependsOnMethods = "test_showGroupInfo", priority = 6)
	public void test_addGroupInfo() throws InterruptedException {
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[4]/div/a[1]");
		Thread.sleep(1000);
		webtest.type("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"新增分组" + DataActionUtil.getRandomString(3));
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		new WebDriverWait(driver, 6).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("扩展信息分组列表"), "页面显示失败");
	}

	/** 标签与资料 - 用户标签列表 */
	@Test(description = "正确显示‘用户标签管理’界面", priority = 1)
	public void test_showGroupLabel() throws InterruptedException {
		driver.navigate().refresh();
		// 先悬停在子菜单上,然后再操作子菜单的选项
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
		assertTrue(webtest.isTextPresent("用户标签管理"), "页面显示失败");
	}

	@Test(description = "新增-用户标签管理", dependsOnMethods = "test_showGroupLabel", priority = 2)
	public void test_addGroupLabel() throws InterruptedException {
//		driver.navigate().refresh();
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div[1]/div[1]/a[1]");
		Thread.sleep(1000);
		webtest.typeAndClear(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[2]/input",
				"新增分类的标题：" + DataActionUtil.getRandomString(5));
		Thread.sleep(1000);
		// 状态 选择“未审核”
		webtest.click("xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/select");
		Thread.sleep(1500);
		webtest.click(
				"xpath=/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/div/div/form/div[4]/select/option[4]");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		// 定位 弹窗元素，获取弹窗内文本信息内容
		WebElement content = webtest.getElementByXpath("//*[@id='toast-container']/div/div");
		String text = content.getText();
		System.out.println(text);
		Thread.sleep(2000);
		if (text != null) {
			System.out.println("新增操作成功！");
		}
	}

	/** 标签与资料 - 用户扩展资料列表 */
	@Test(description = "正确显示‘用户扩展资料列表’界面", priority = 3)
	public void test_showLabelInfo() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		// 先悬停在子菜单上,然后再操作子菜单的选项
		WebElement parentMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]");
		Actions action = new Actions(driver);
		action.moveToElement(parentMenu).perform();
//		WebElement subMenu = webtest.getElementByText("用户扩展资料列表");
		WebElement subMenu = webtest.getElementByXpath("/html/body/header/nav/div/ul[1]/li[2]/ul/li/div/div/div[5]/ul/li[4]/a");
//		subMenu.click();
//		Thread.sleep(3000);
		action.moveToElement(subMenu).click().perform();
		Thread.sleep(3000);
		assertTrue(webtest.isTextPresent("用户扩展资料列表"), "页面显示失败");
	}

	@Test(description = "搜索", dependsOnMethods = "test_showLabelInfo", priority = 4)
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
		assertTrue(webtest.isTextPresent("共 1 条记录"), "搜索失败");
	}
}
