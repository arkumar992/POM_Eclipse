package testcasespages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepack.BasePack;
import pagespack.HomePage;
import pagespack.Loginpage;

public class LoginTest extends BasePack {
	
	Loginpage loginpage;
	HomePage homePage;
	public LoginTest()
	{
		super();		
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initi();
		loginpage =new Loginpage();
	}
	
	@Test(priority =2)
	
	public void loginpgtitletest()
	{
		String lgtitle= loginpage.loginpagtitle();
		Assert.assertEquals(lgtitle, "Ultimatix - Digitally Connected!");
	}
	
	@Test(priority =1)
	public void loginpg()
	{
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	

}
