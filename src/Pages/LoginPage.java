package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='un']")
	private WebElement username;
	
	@FindBy(xpath="html/body/form/fieldset[2]/input")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='µÇÂ¼']")
	private WebElement logbtn;
	
	@FindBy(xpath="//span[@id='topUserName']")
	private WebElement testid;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openUrl(String url){
		driver.get(url);
	}
	
	public void setUsername(String name){
		username.sendKeys(name);
	}
	
	public void setPassword(String mima){
		password.sendKeys(mima);
	}
	
	public void prssLogbtn(){
		logbtn.click();
	}
	
	public  WebElement yanzheng(){
		return testid;
	}
	
	

}
