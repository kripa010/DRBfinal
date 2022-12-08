package com.drb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrbLogoutPage {
	WebDriver driver;
	@FindBy(xpath="//a[@class='logout btn']")
	WebElement logout;
	@FindBy(xpath="//a[@href='/login']")
	 WebElement signup;
	public DrbLogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickLogout() throws InterruptedException {
		Thread.sleep(100);
		logout.click();
			
	}
	public boolean isValid() {
		// TODO Auto-generated method stub
		return signup.isDisplayed();
	}

}
