package com.drb.script;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrbTestBase 
{
	
	WebDriver driver;
	public static Properties prop;
	public static void DrbTestBase() throws IOException
	{
		String confpath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
		prop=new Properties();
		FileInputStream	fis=new FileInputStream(confpath);
		prop.load(fis);
	}	
	
	@BeforeTest
	public void onSetup() throws IOException
	{
	  DrbTestBase();
	  String browsername=prop.getProperty("browser");
	  String url=prop.getProperty("url");
	  if(browsername.equals("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  else if (browsername.equals("edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver= new EdgeDriver();
	  }  
	  else if (browsername.equals("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver= new FirefoxDriver();
	  }  
	  driver.get(url);
	  driver.manage().window().maximize();
	  
	
	}
	@AfterTest
	public void teardown()
	{
	driver.close();	
	}
}
