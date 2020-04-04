package testcasespages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepack.BasePack;
import pagespack.HomePage;
import pagespack.Loginpage;
import pagespack.Worklistpage;

public class WorklistPageTest extends BasePack {

	Loginpage loginpage;
	HomePage homePage;
	Worklistpage workltpage;
	public WorklistPageTest()
	{
		super();		
	}
	
@BeforeMethod
	
	public void setup()
	{
		initi();
		
		loginpage = new Loginpage();		
		homePage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		workltpage = new Worklistpage();
		workltpage = homePage.clickworklist();
		
	}
	
@Test(priority =1)

public void verifyEmConcer()
{
	
Assert.assertTrue(workltpage.verifyEmployconcern(),"Emplyee concert not avilable");

	
}

@Test(priority =2)

public void verifyGHDD() {
	String text = workltpage.verifyGHD();
	Assert.assertEquals(text, "Global Helpdesk","Not Matched GHD");
	
}



@AfterMethod

public void down() {
	
	driver.quit();

}



}
