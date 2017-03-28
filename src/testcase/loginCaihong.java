package testcase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NewPdcPlanPage;
import Pages.ProductPage;
import libs.BrowserType;
import libs.Browsers;
import libs.DBOp;
import libs.Do;
import libs.Wait;

public class loginCaihong {
	private WebDriver driver;
	private Do du;
	private Wait wait;
	private Browsers browser;
	
	@BeforeClass
	//初始化浏览器，启用火狐
	public void openFirefox(){
		Browsers browser = new Browsers(BrowserType.firefox);
		driver = browser.driver;
		wait =  new Wait(driver);
	}
	
	@Test
	public void Login(){
		LoginPage loginpage = new LoginPage(driver); //new一个登录页面
		loginpage.openUrl("http://192.168.8.7:8080/rainbow/pages/login.html");//打开地址
		loginpage.setUsername("wujiajun");//输入用户名
		loginpage.setPassword("111111");//输入密码
		loginpage.prssLogbtn();//点击登录
		wait.waitFor(5000);//等待5秒
		Assert.assertEquals(loginpage.yanzheng().isDisplayed(), true);//验证是否登录成功，出现某元素则返回true
	}
	
	@Test(dependsOnMethods = {"Login"})
	public void pdcManage(){
		ProductPage productpage = new ProductPage(driver);
		productpage.pressPmanage();//点击生产管理按钮
		wait.waitFor(3000);//等待3秒
		productpage.pressPplan();//点击生产计划按钮
		wait.waitFor(3000);
		productpage.presswuhan();//点击武汉分公司
		productpage.pressnew();//点击新建
		wait.waitFor(5000);//等待5秒
		Assert.assertEquals(productpage.yanzheng().isDisplayed(), true);//验证是否弹出页面成功，在弹出页上取一个元素，判断其是否出现

	
	}
	
	@Test(dependsOnMethods = {"pdcManage"})
	public void newPlan(){
		String Pnumber = null;
		WebElement dd1 = driver.findElement(By.xpath("html/body/div[1]/div[3]/section[2]/div/div[2]/div/div[2]/div/div[3]/div[2]/div"));
		String s1 = dd1.getText();
		int sub1 = Integer.valueOf(s1.substring(17, s1.length()-1).trim());//截取字符串中的一段数字作为int类型
		wait.waitFor(3000);

		NewPdcPlanPage nppp = new NewPdcPlanPage(driver);//new一个新建生产计划的的页面
		
		//获取当前时间，年月日秒来作为生产计划批次号，这样可以每个批次号都不一样
		SimpleDateFormat sdf = new SimpleDateFormat();
		String layout = "yyyyMMddHHmmss";
		sdf.applyPattern(layout);
		Calendar c1 = Calendar.getInstance();
		Pnumber = sdf.format(c1.getTime());
		
		nppp.setPlanNumber("WH"+Pnumber);//生产批次号输入“WH+时间（年月日秒）”
		
		//下拉选择
		WebElement ss = driver.findElement(By.xpath(".//select[@id='DTE_Field_workshopCode']"));
		Select sel = new Select(ss);
		sel.selectByValue("00002");
		
		nppp.pressconfirmbtn();//点击确定
		
		wait.waitFor(5000);
		WebElement dd2 = driver.findElement(By.xpath("html/body/div[1]/div[3]/section[2]/div/div[2]/div/div[2]/div/div[3]/div[2]/div"));
		String s2 = dd2.getText();
		int sub2 = Integer.valueOf(s2.substring(17, s2.length()-1).trim());//再次截取下面的字符串，将其中的数字作为int类型
		int a = sub2-sub1;//两次的数相减，这里需要等于1
		System.out.println("*********"+a);
		Assert.assertEquals(a==1, true);//判断等于1说明新建成功
	}
	
	@AfterClass
	public void release(){
		driver.quit();
	}
}
