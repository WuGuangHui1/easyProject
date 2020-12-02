package com.webtest.demo;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class whyTest extends Admin_Login{

	//1、添加到常用操作
	@Test(priority=1)
	public void why1test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("class=icon-plus");
	}
	//2、能否正常刷新页面
	@Test(priority=2)
	public void why2test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//button[@class='btn btn-default ajax-post btn btn-default']");
		webtest.alertAccept();
		webtest.pause(2000);
	}
	//3、能否选中全列
	@Test(priority=3)
	public void why3test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	//4、能否取消全选
	@Test(priority=4)
	public void why4test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("class=check-all");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	//5、能否选中单个一行
	@Test(priority=5)
	public void why5test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//6、能否取消选中某一行
	@Test(priority=6)
	public void why6test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//7、能否查看图标大图
	@Test(priority=7)
	public void why7test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[9]/div/a/img");
		webtest.pause(2000);
	}
	//8、能否查看详细信息
	@Test(priority=8)
	public void why8test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.doubleClick("xpath=//td[text()='Common_system【默认】']");
		webtest.click("xpath=/html/body/div[5]/span/a");
		webtest.pause(2000);
	}
	
	//9、能否添加到常用操作
	@Test(priority=9)
	public void why9test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.click("class=icon-plus");
		
	}
	//10、能否正常刷新
	@Test(priority=10)
	public void why10test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.click("xpath=//button[@class='btn btn-default ajax-post btn btn-default']");
		webtest.alertAccept();
		
	}
	//11、能否选中全列
	@Test(priority=11)
	public void why11test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	//12、能否取消全选
	@Test(priority=12)
	public void why12test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	//13、能否选中单个一行
	@Test(priority=13)
	public void why13test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//14、能否取消选中某一行
	@Test(priority=14)
	public void why14test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//15、能否查看详细信息
	@Test(priority=15)
	public void why15test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话模板");
		webtest.doubleClick("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[9]");
		webtest.pause(2000);
	}
	//16、能否选择模板
	@Test(priority=16)
	public void why16test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话设置");
		webtest.click("class=form-control");
		webtest.click("xpath=//option[value='session1'");
		webtest.click("xpath=//button[@type='submit']");
		//webtest.alertAccept();
		webtest.pause(1000);
	}
	//17、点击返回能否返回之前的页面
	@Test(priority=17)
	public void why17test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话设置");
		webtest.click("xpath=//button[@class='btn btn-return']");
		webtest.pause(2000);
	}
	//18、能否正确添加模板
	@Test(priority=18)
	public void why18test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//a[text()='添加模板']");
		webtest.type("name=title", "1");
		webtest.type("name=name","1");
		webtest.click("id=id_zhannei_1");
		webtest.click("id=id_sms_1");
		webtest.click("id_email_1");
		webtest.click("xpath=//select[@name='status']");
		webtest.click("xpath=//button[@type='submit']");
		webtest.pause(2000);
	}
	//20、 能否将文本加粗!!!!

	@Test(priority=20)
	public void why20test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("id=edui157_body");
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//21、能否设为斜体
	@Test(priority=21)
	public void why21test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
		webtest.click("xpath=//*[@id=\"edui158_body\"]/div");//点击斜体按钮
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
		
	}
	
	//22、能否设置下划线
	@Test(priority=22)
	public void why22test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("xpath=//*[@id=\"edui159_body\"]/div");
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	
	//23、能否设置字号
	@Test(priority=23)
	public void why23test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		webtest.click("id=edui160_button_body");
		webtest.click("xpath=//div[text()='16px'");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//24、能否设置颜色
	@Test(priority=24)
	public void why24test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		webtest.click("xpath=//*[@id=\"edui171_state\"]/div/div[3]");
		webtest.pause(2000);
		webtest.click("xpath=//*[@id=\"edui172\"]/table/tbody/tr[6]/td[10]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.pause(2000);
        driver.switchTo().defaultContent();
        webtest.type("xpath=xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.click("xpath=//*[@id=\"edui171_button_body\"]/div[1]");
		webtest.click("id=submit");
		webtest.alertAccept();
		webtest.pause(2000);
	}
	//25、能否居左对齐
	@Test(priority=25)
	public void why25test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
	    webtest.type("xpath=xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.click("xpath=//*[@id=\"edui174_body\"]/div[1]");
		driver.switchTo().defaultContent();
		webtest.pause(2000);
	}
	//26、设置字体
	@Test(priority=26)
	public void why26test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
		webtest.click("xpath=//*[@id=\"edui175_button_body\"]");
		webtest.click("xpath=//*[@id=\"edui179\"]/div/div");
		webtest.pause(2000);
	}
	//27、添加BaiDu地图  无法添加
	@Test(priority=27)
	public void why27test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.click("xpath=//*[@id=\"edui193_body\"]/div[1]");
		webtest.pause(2000);
		
	}
	//28、添加表情
	@Test(priority=28)
	public void why28test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		webtest.click("xpath=//body[@class='view']");
		webtest.click("xpath=//div[@class='edui-box edui-icon edui-default'");
		driver.switchTo().frame("edui194_iframe");
		webtest.click("xpath=//*[@id=\"tab0\"]/table/tbody/tr[2]/td[4]/span/img");
		webtest.pause(2000);
		driver.switchTo().defaultContent();
		
	}
	
	//30、设置代码语言
	@Test(priority=30)
	public void why30test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=消息模板");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.click("xpath=//*[@id=\"edui201_button_body\"]");
		webtest.click("xpath=//*[@id=\"edui205\"]/div/div");
		webtest.pause(2000);
	}
	//31、数据备份
	@Test(priority=31)
	public void why31test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=备份数据库");
		webtest.click("id=export");
		webtest.pause(2000);
	}
	//32、优化表
	@Test(priority=32)
	public void why32test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=备份数据库");
		webtest.click("id=optimize");
		webtest.pause(2000);
	}
	//33、修护表
	@Test(priority=33)
	public void why33test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=备份数据库");
		webtest.click("id=repair");
		webtest.pause(2000);
		
	}
	//34、能否还原已经备份的数据库！！！
	@Test(priority=34)
	public void why34test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=还原数据库");
		webtest.pause(2000);
		
	}
	//35、能否删除已经备份的数据库!!!
	@Test(priority=35)
	public void why35test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=还原数据库");
		webtest.pause(2000);
		
	}
	//36、能否更改网站的首页URL
	@Test(priority=36)
	public void why36test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.type("xpath=//input[@class='text input-large form-contro']", "http://localhost:8989/");
		webtest.pause(2000);
	}
	
	//37、内容配置能否更改空白说明
	@Test(priority=37)
	public void why37test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='内容配置']");
		webtest.type("xpath=//textarea[@class='form-control']","abcd");
		webtest.pause(2000);
		webtest.click("xpath=//button[@type='submit']");
		//webtest.alertAccept();
		webtest.pause(2000);
		
	}
	
	//38、能否修改后台每页记录数
	@Test(priority=38)
	public void why38test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='内容配置']");
		webtest.typeAndClear("xpath=//input[@class=text input-small form-control']", "10");
		webtest.pause(2000);
		webtest.click("xpath=//button[@class='btn submit-btn ajax-post'");
		//webtest.alertAccept();
		webtest.pause(2000);
	}
	//39、用户配置能否修改保留用户名和昵称
	@Test(priority=39)
	public void why39test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//*[@id=\"main\"]/div/div[3]/ul/li[3]/a");
		webtest.typeAndClear("xpath=//*[@id=\"main\"]/div/div[4]/div/form/div[1]/div/input", "11112223");
		webtest.click("xpath=//*[@id=\"main\"]/div/div[4]/div/form/div[3]/div/button[1]");
		webtest.pause(2000);
	}
	//41、能否将文本加粗
	@Test(priority=41)
	public void why41test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		driver.switchTo().frame("ueditor_0");
		//webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.pause(2000);
        driver.switchTo().defaultContent();
        webtest.click("xpath=//*[@id=\"edui5_body\"]/div");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//42、能否将文本设置为斜体
	@Test(priority=42)
	public void why42test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		driver.switchTo().frame("ueditor_0");
		//webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("xpath=//*[@id=\"edui6_body\"]/div");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
		
	}
	
	//43、能否给文字加上下划线
	@Test(priority=43)
	public void why43test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//*[@id=\"main\"]/div/div[3]/ul/li[3]/a");
		driver.switchTo().frame("ueditor_0");
		//webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("xpath=//*[@id=\"edui7_body\"]/div");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
		
	}
	//45、能否设置正确字号
	@Test(priority=45)
	public void why45test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		driver.switchTo().frame("ueditor_0");
		//webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("xpath=//*[@id=\"edui8_button_body\"]");
        webtest.click("xpath=//*[@id=\"edui16\"]/div/div");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//46、能否设置文字颜色
	@Test(priority=46)
	public void why46test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.pause(2000);
        driver.switchTo().defaultContent();
        webtest.click("xpath=//div[@class='edui-box edui-arrow edui-default']");
        webtest.click("xpath=//a[@title='ffff00']");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//47、能否设置字体
	@Test(priority=47)
	public void why47test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//*[@id=\"main\"]/div/div[3]/ul/li[3]/a");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.pause(2000);
        driver.switchTo().defaultContent();
        webtest.click("xpath=//div[@class='edui-box edui-arrow edui-default']");
        webtest.click("xpath=//div[text()='楷体']");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//44、能否设置背景色
	@Test(priority=44)
	public void why44test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.pause(2000);
        driver.switchTo().defaultContent();
        webtest.click("xpath=//div[@class='edui-box edui-arrow edui-default']");
        webtest.click("xpath=//a[@title='92d050']");
        webtest.click("xpath=//button[@type='submit']");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//48、能否使用表情
	@Test(priority=48)
	public void why48test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		webtest.click("xpath=//div[@class='edui-box edui-icon edui-default']");
		driver.switchTo().frame("edui77_iframe");
		webtest.click("xpath=//img[@title='大笑']");
		driver.switchTo().defaultContent();
		webtest.click("xpath=//button[@type='submit']");
	    webtest.alertAccept();
	    webtest.pause(2000);
	    
		
	}
	
	//50、能否选择代码语言
	@Test(priority=50)
	public void why50test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=网站设置");
		webtest.click("xpath=//a[text()='用户配置']");
		webtest.click("id=edui46_button_body");
		webtest.click("id=edui50");
		webtest.click("xpath=//button[@type='submit']");
	   // webtest.alertAccept();
	    webtest.pause(3000);
	}
	
	//52、用户导航能否选择不同模块
	@Test(priority=52)
	public void why52test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=用户导航");
		webtest.click("name=nav[1][modu1][]");
		webtest.click("value=Home/index/index");
		webtest.click("id=submit");
		//webtest.alertAccept();
		webtest.pause(2000);
	}
	//53、用户导航能否设置在新窗口打开
	@Test(priority=53)
	public void why53test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=用户导航");
		webtest.click("class=target");
		webtest.click("id=submit]");
		//webtest.alertAccept();
		webtest.pause(2000);
		
	}
	
	
	//54能否更改自动更新提示为关闭
		@Test(priority=54)
		public void wwhy36test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=网站设置");
			webtest.click("class=form-control");
			webtest.click("xpath=//option[text()='关闭']");
			webtest.pause(2000);
		}
		//
}
