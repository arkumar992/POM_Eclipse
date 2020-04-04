package pagespack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basepack.BasePack;
import utilitypack.TestUtil;

public class Loginpage extends BasePack {
	
	//Pagefactory  - OR
	
	@FindBy(name = "form1")  //login page title : Ultimatix - Digitally Connected!
	
	WebElement username;
	
	@FindBy(id = "proceed-button")
	
	WebElement loginbutton;
	
	@FindBy(id = "password-btn")
	
	WebElement passwordbutton;
	
	
	@FindBy(id = "password-login")
	
	WebElement password;
	
	@FindBy(id = "form-submit")
	
	WebElement login;    //home page title : Ultimatix: Digitally Connected
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String loginpagtitle()
	{
		return driver.getTitle();
		
	}
	
	public HomePage login(String un, String pwd)
	{
		try{
		username.sendKeys(un);
		loginbutton.click();
		passwordbutton.click();
		TestUtil k= new TestUtil(password);
		
		
		//password =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-login")));
		password.sendKeys(pwd);
		login.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new HomePage();
			
		}
	
	

}
