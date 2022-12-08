package com.drb.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrbSignUpPage{
	WebDriver driver;
public DrbSignUpPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

@FindBy(xpath="//a[@href='/login']")
private WebElement signup;

@FindBy(xpath="//a[@href='/signup']")
private WebElement signuplnk;

@FindBy(css="input[placeholder='Username']")
private WebElement username;

@FindBy(css="input[placeholder='Phone Number']")
private WebElement phone;

@FindBy(css="input[placeholder='Mail']")
private WebElement emailid;

@FindBy(css="input[placeholder='Password']")
private WebElement passwd;

@FindBy(css="input[placeholder='Confirm Password']")
private WebElement cpasswd;

@FindBy(xpath="//form/button")
private WebElement register;

	public void clickSignUp()
	{
	
	 try { ((Locatable) signup).getCoordinates().inViewPort();
	 signup.click();
     }
    catch(Exception e)
    {
 	new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
 	signup.click();
    }
		
		}
	
	public void clickSignupLink() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", signuplnk);
		Thread.sleep(2000);
		signuplnk.click();
	}
	

	public void setUserName(String name)
	{

		username.sendKeys(name);
	}

	
	public void setPhoneNumber(String phonenumber)
	{
		
		phone.sendKeys(phonenumber);
	}

	
	public void setMailId(String email)
	{
			
		emailid.sendKeys(email);
	}

	
	public void setPassword(String pass)
	{
	
		passwd.sendKeys(pass);
		
	}
	

	public void setConfirmPassword(String cpass) {
	
		cpasswd.sendKeys(cpass);
		
	}

	
	public void clickRegister() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", register);
		register.click();		
	}
	
	public boolean isInvalidSignUp()
	{
		  boolean invalid = register.isSelected();
			return invalid;
		}
	
	}
	
	 
