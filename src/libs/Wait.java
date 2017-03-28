package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;
	private int timeout=10;
	
	//构造函数（new后面使用）
	public Wait(WebDriver driver){
		this.driver=driver;
	}
	
	//等待元素出现
	public void waitForElementPresent(String locator){
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		
	}

	//等待元素能操作
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		
	}
	
	//休眠一段时间
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
