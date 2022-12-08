package com.drb.pages;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DrbEditProfilePage extends DrbCreateProfilePage

{  
	@FindBy(xpath="//a[@href='/editform']")
	WebElement edit_prof_button;

	@FindBy(xpath="//button[@type='submit']")
	WebElement update_prof_button;
	
	public DrbEditProfilePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

WebDriver driver;
	
	public void clickEdtProfileBtn()
	{
	//	edit_prof_button=driver.findElement(By.cssSelector("body > app-root > app-profile > div > div > div.profile-page > div > div > div.container > div > a:nth-child(3"));
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/editform']")));
		edit_prof_button.click();
	}

	public String clickUpdateProfile() throws InterruptedException
	{
	//	update_prof_button = driver.findElement(By.className("btn btn-success"));
	//	update_prof_button.click();
		
		try { ((Locatable) update_prof_button).getCoordinates().inViewPort();
		update_prof_button.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        update_prof_button.click();
	     }
		 Thread.sleep(1000);
		 String actual=driver.switchTo().alert().getText();
		 driver.switchTo().alert().accept();
		 return actual;
		
	}
	
}