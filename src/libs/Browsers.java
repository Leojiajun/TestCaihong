package libs;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Browsers {

	public WebDriver driver =null;
	private FirefoxProfile firefoxprofile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	public Browsers(BrowserType browserstype){
		switch(browserstype){
			case firefox:
				File firebug =new File(projectpath+"/Tools/firebug@software.joehewitt.com.xpi");
				File fireXpath = new File(projectpath+"/Tools/FireXPath@pierre.tholence.com.xpi");
				firefoxprofile = new FirefoxProfile();
			try {
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(fireXpath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.17");
				firefoxprofile.setPreference("extensions.firebug.allPagesActivation", "on");
				
				driver = new FirefoxDriver(firefoxprofile);
				driver.manage().window().maximize();
				break;
			case chrome:
				System.setProperty("webdriver.chrome.driver", projectpath+"/Tools/chromedriver_x64.exe");
				//caps = DesiredCapabilities.chrome();
				//caps.setCapability("chrome.switches", Arrays.asList("--start--maximized--"));//最大化browser
				driver= new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case ie:
				System.setProperty("webdriver.ie.driver", projectpath+"/Tools/IEDriverServer.exe");
				caps =DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//避免安全性级别问题
				caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");//每次启用IE，自动清除cookie，记录
				caps.setCapability("ignoreZoomSetting", true);
				driver = new InternetExplorerDriver(caps);
				driver.manage().window().maximize();
				break;
						
			}
			
		}

}
