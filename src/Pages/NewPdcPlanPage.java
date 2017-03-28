package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPdcPlanPage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='DTE_Field_batchCode']")
	private WebElement pdcnumber;
	
	@FindBy(xpath="html/body/div[3]/div/div/div/div[4]/div[3]/button")
	private WebElement confirm;
	
	public NewPdcPlanPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void setPlanNumber(String num){
		pdcnumber.sendKeys(num);
	}
	
	public void pressconfirmbtn(){
		confirm.click();
	}
}
