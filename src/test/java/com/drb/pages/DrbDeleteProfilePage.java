package com.drb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DrbDeleteProfilePage {
	WebDriver driver;
	@FindBy(xpath="//a[@href='/profilehome']")
    WebElement myprofile;
	@FindBy(linkText="Delete Profile")
    WebElement dltprofile;
	public String deleteProfile() throws InterruptedException
	{  Thread.sleep(1000);
		myprofile.click();
		Thread.sleep(1000);
		dltprofile.click();
		String actual=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return actual;
	}

	public DrbDeleteProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
