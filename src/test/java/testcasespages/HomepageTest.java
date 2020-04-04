package testcasespages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepack.BasePack;
import pagespack.HomePage;
import pagespack.Loginpage;
import utilitypack.TestUtil;

public class HomepageTest extends BasePack  {
	
Loginpage loginpage;
HomePage homePage;
	
	public HomepageTest()
	{
		super();
		
	}
	
	@BeforeMethod()
	
	public void setup()
	{
		initi();
		loginpage =new Loginpage();
		homePage =loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@Test(priority = 3)
	
	public void homePagetitlevali() {
		
		String hompageti = homePage.homepagtitle();
		Assert.assertEquals(hompageti, "Ultimatix: Digitally Connected","Home page title not matched");
	}
	
	@Test(priority = 2)
	
	public void usernameTest() {
		
		Assert.assertTrue(homePage.userName());
		
	}
	
	@DataProvider
	
	public Object[] getData() {
		
	Object data[]=	TestUtil.getTestData("search");
		
	return data;
	
	}
	
	
	@Test(dataProvider = "getData")
	
	public void searchpageTest(String fname, String lname, String ini){
	
		homePage.searchName(fname, lname, ini);
	}
	
	@AfterMethod
	
	public void down() {
		
		driver.quit();

	}

}
