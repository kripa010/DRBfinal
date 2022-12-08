package com.drb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DrbLoginPage
{
	WebDriver driver;
	@FindBy(xpath="//a[@href='/login']")
	 WebElement signup;
	@FindBy(name="Username")
	 WebElement username;
	@FindBy(name="pass")
	 WebElement password;
	@FindBy(className="label-checkbox100")
	 WebElement rem;
	@FindBy(className="login100-form-btn")
	 WebElement login;
	@FindBy(xpath="//a[@class='logout btn']")
	WebElement logout;
	public DrbLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickSignUp() throws InterruptedException
	{  Thread.sleep(1000);
		signup.click();
	}
	public void setUserName(String userName) throws InterruptedException
	
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
	
	username.clear();
		username.sendKeys(userName);
		
		 
	}
	public void setPassword(String pass) throws InterruptedException
	{
		password.clear();
		password.sendKeys(pass);
		  //Thread.sleep(200);
	}
	public void clickRememberMe()
	{  
		rem.click();
	}
	public void loginClick()
	{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("login100-form-btn")));
		login.click();
	}
	public boolean isValidLogIn() throws InterruptedException {
		// TODO Auto-generated method stub
		 Thread.sleep(1000);
		  boolean valid =logout.isDisplayed();
		return valid;
	}
	
	public boolean isInvalidLogIn() {
		// TODO Auto-generated method stub
		 
		  boolean valid =login.isDisplayed();
		return valid;
	}
}
