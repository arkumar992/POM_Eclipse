package pagespack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepack.BasePack;

public class Worklistpage extends BasePack{
	
	@FindBy(xpath="//span[text()='Employee Concern']")
	WebElement employconcern;
	
	
	@FindBy(xpath="//span[text()='Global Helpdesk']")
	WebElement GHD;
	
				
			
	public Worklistpage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public boolean verifyEmployconcern() {
		
		return employconcern.isDisplayed();
	}
	
	public String verifyGHD() {
		
		return GHD.getText();
	}

}
