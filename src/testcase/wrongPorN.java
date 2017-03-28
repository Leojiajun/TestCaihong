package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import libs.BrowserType;
import libs.Browsers;
import libs.Do;
import libs.ParseProperties;
import libs.Wait;

public class wrongPorN {
	private WebDriver driver;
	private ParseProperties data;
	private ParseProperties locator;
	private Wait wait;
	private Do du;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void startfirefox(@Optional("data") String da,@Optional("locl") String loc){
		data = new ParseProperties(System.getProperty("user.dir")+da);
		locator = new ParseProperties(System.getProperty("user.dir")+loc);
		Browsers browser = new Browsers(BrowserType.firefox);
		driver = browser.driver;
		wait = new Wait(driver);
		du = new Do(driver);	
	}
	@Test
	public void logInwpwd(){
		driver.get(data.getValue("caihongURL"));
		du.what("usernameEle").sendKeys(data.getValue("username"));
		du.what("passwordEle").sendKeys(data.getValue("Wpassword"));
		du.what("enterEle").click();
		wait.waitFor(3000);
		Assert.assertEquals(du.what("wpasswordEle").isDisplayed(), true);

	}
	
	@Test
	public void logInwusn(){
		du.what("usernameEle").clear();
		du.what("usernameEle").sendKeys(data.getValue("Wusername"));
		du.what("passwordEle").clear();
		du.what("passwordEle").sendKeys(data.getValue("password"));
		du.what("enterEle").click();
		wait.waitFor(3000);
		Assert.assertEquals(du.what("nomanEle").isDisplayed(), true);		
	}
	
	@Test
	public void logInNoUsn(){
		//driver.get(data.getValue("caihongURL"));
		du.what("usernameEle").clear();
		du.what("passwordEle").clear();
		du.what("passwordEle").sendKeys(data.getValue("password"));
		du.what("enterEle").click();
		wait.waitFor(3000);
		Assert.assertEquals(du.what("nousernameEle").isDisplayed(), true);
	}
}
