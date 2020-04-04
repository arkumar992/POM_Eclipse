package basepack;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilitypack.TestUtil;
import utilitypack.WebEventListener;

public class BasePack {

	public static WebDriver driver;
	public static Properties prop;
	public static  WebDriverWait wait;
	public static  EventFiringWebDriver e_driver;
	public static  WebEventListener eventListner;
	public BasePack()
	{
		
	try
	{
		prop = new Properties();
		
FileInputStream ip = new FileInputStream("/home/pixintdev/eclipse-workspace/TestPOM/src/main/java/properties/config.properties");
	prop.load(ip);
	}catch (Exception e) {
		e.printStackTrace();
	}
				
		
	}
	
	
	public static void initi()
	{
		System.setProperty("Webdriver.chrome.driver", "/home/pixintdev/Downloads/chromedriver");
		  driver = new ChromeDriver();
		  e_driver= new EventFiringWebDriver(driver);
		  eventListner = new WebEventListener();
		  e_driver.register(eventListner);
		  driver = e_driver;
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);  
		   
		  driver.get(prop.getProperty("url"));
		  driver.navigate().refresh();
		  
		  
		  
	}
	
}
