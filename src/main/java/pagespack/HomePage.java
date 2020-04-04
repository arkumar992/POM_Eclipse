package pagespack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepack.BasePack;

public class HomePage extends BasePack{
	
	@FindBy(xpath="//div[text()='Arun Kumar S R']")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[text()='Worklist']")
	@CacheLookup
	WebElement worklist;
	
	@FindBy(xpath="//a[text()='Business 4.0']")
	WebElement business;
	
	@FindBy(id="es_search")
	@CacheLookup
	WebElement search;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String homepagtitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean userName() {
		
		return usernameLabel.isDisplayed();
	}
	
	public Worklistpage clickworklist()
	{
		worklist.click();
		return new Worklistpage();
	}
	
	public BusinessPage clickbusiness()
	{
		business.click();
		return new BusinessPage();
	}
	
	
	public void searchName(String fname, String lname , String ini) {
		
		search.sendKeys(fname);
		search.sendKeys(lname);
		search.sendKeys(ini);
		
	}
	
	
	
	

}
