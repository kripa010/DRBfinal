package com.drb.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DrbDownloadPage 
{
	WebDriver driver;
	@FindBy(xpath="//a[@routerlink='templatehome']")
	WebElement templatebutton;
	@FindBy(xpath="//div[1]/div[1]/a/figure/figcaption")
	WebElement template1;
	@FindBy(linkText="Download Resume")
	//div[2]/div/div[5]/div/a[1]
	WebElement download1;
	@FindBy(xpath="//div[2]/div[1]/a/figure/figcaption")
	WebElement template2;
	@FindBy(xpath="//app-threetemp/section/button[1]")
	WebElement download2;
	@FindBy(xpath="//div[1]/div[2]/a/figure/figcaption")
	WebElement template3;
	@FindBy(xpath="//app-twotemp/section/button[1]")
	WebElement download3;
	
	public DrbDownloadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickTemplateBtn() throws InterruptedException 
	{  Thread.sleep(500);
	   templatebutton.click();
	  
	}
	
	public void clickTemplate1() 
	{
	   template1.click();
		
	}
	public void clickTemplate2() 
	{
	   template2.click();
		
	}
	public void clickTemplate3() 
	{
	   template3.click();
		
	}
	
	public void clickDownloadResume1() throws InterruptedException
	{
		Thread.sleep(500);
		try { ((Locatable) download1).getCoordinates().inViewPort();
		download1.click();
        }
       catch(Exception e)
       {
    	new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    	download1.click();
       }
       
    } 
	public void clickDownloadResume2() throws InterruptedException
	{
		Thread.sleep(500);
		try { ((Locatable) download2).getCoordinates().inViewPort();
		download2.click();
        }
       catch(Exception e)
       {
    	new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    	download2.click();
    } 
	}
	public void clickDownloadResume3() throws InterruptedException
	{
		try { ((Locatable) download3).getCoordinates().inViewPort();
		download3.click();
        }
       catch(Exception e)
       {
    	new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    	download3.click();
    } 
}
}