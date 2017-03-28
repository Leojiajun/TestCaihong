package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	private WebDriver driver;
	
	@FindBy(xpath="html/body/div[1]/div[2]/aside/section/ul/li[3]/a/span[1]")
	private WebElement pdcmanage;
	
	@FindBy(xpath=".//*[@id='productionPlanNavLink']")
	private WebElement pdcplan;
	
	@FindBy(xpath="html/body/div[1]/div[3]/section[2]/div/div[1]/ul/li/ul/li[5]/a")
	private WebElement wuhan;
	
	@FindBy(xpath="html/body/div[1]/div[3]/section[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/a[1]/span")
	private WebElement newone;
	
	@FindBy(xpath="html/body/div[3]/div/div/div/div[3]/div/form/div/div[1]/label")
	private WebElement test;
	
	public ProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void pressPmanage(){
		pdcmanage.click();
	}
	public void pressPplan(){
		pdcplan.click();
	}
	public void presswuhan(){
		wuhan.click();
	}
	public void pressnew(){
		newone.click();
	}
	public WebElement yanzheng(){
		return test;
	}
}
