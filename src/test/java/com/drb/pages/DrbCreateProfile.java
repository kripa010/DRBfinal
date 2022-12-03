package com.drb.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class DrbCreateProfile
{   WebDriver driver;
    WebElement myprof,crtprfbtn,name,gend,male,female,dob,email,phone,projectTitle,year,skill,percentage,school,gradInstitute,achievement,projectAdd,achievementAdd,projectDescription,language,gradYear,gradPercentage,descr,img,graduation,graduationStream,higherSecPercentage,acceptchk,crtprfsubmit,higherSecStrm,higherSecSchool,higherSecYear;
	public DrbCreateProfile(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickMyProfile()
	{	
		myprof=driver.findElement(By.cssSelector("#navbar-wd > ul > li:nth-child(6) > a"));	
		myprof.click();
	}

	public void clickCrtProfile()
	{
		crtprfbtn=driver.findElement(By.cssSelector("#heroCarousel > div > div > div > div > button"));
		crtprfbtn.click();
	}

	public void setName(String fulname)
	{
		name=driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys(fulname);
	}

	public void clickGender(String gender)
	{
		
		List<WebElement> gend=driver.findElements(By.id("gender"));
		if(gender.equals("male"))
		{
			gend.get(0).click();
		}
		else if(gender.equals("female"))
		{
			gend.get(1).click();
		}
		 
		
	}
	public void setDob(String dateofbirth)
	{
		dob=driver.findElement(By.id("date"));
		dob.sendKeys(dateofbirth);
	}

	public void setEmail(String emailid)
	{
		email=driver.findElement(By.id("email_id"));
		email.clear();
		email.sendKeys(emailid);
	}

	public void setPhone(String phonenum)
	{
		phone=driver.findElement(By.id("phone"));
		phone.clear();
		phone.sendKeys(phonenum);
	}

	public void setSchoolStream(String schoolstrm)
	{
		WebElement strm=driver.findElement(By.id("edu_title"));
		Select sel=new Select(strm);
		sel.selectByValue(schoolstrm);
	}

	public void setYear(String yr)
	{
	year=driver.findElement(By.id("edu_year"));
	year.clear();
	year.sendKeys(yr);
		
	}

	public void setSkills(String skills) throws InterruptedException
	{ 	Thread.sleep(1000);
		
		//driver.findElement(By.cssSelector("body > app-root > app-sampleform > div > form > table.table.table-bordered.ng-untouched.ng-pristine.ng-invalid > tr:nth-child(1) > th:nth-child(2) > button")).click();
		//WebElement add=driver.findElement(By.xpath("//body/app-root[1]/app-sampleform[1]/div[1]/form[1]/table[4]/tr[1]/th[2]/button[1]"));
		//List<WebElement> add=driver.findElements(By.tagName("button"));
		//add.get(4).click();
		//Actions a = new Actions(driver);
		//a.moveToElement(add.get(3)).click().perform();
		//WebDriverWait wait = new WebDriverWait(driver,);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-sampleform/div/form/table[4]/tr[1]/th[2]/button")));
        WebElement m = driver.findElement(By.cssSelector("table.table:nth-child(16) > tr:nth-child(1) > th:nth-child(2) > button"));
       try { ((Locatable) m).getCoordinates().inViewPort();
        m.click();
        }
       catch(Exception e)
       {

    	   
    	new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        m.click();
       }
//        Point p=m.getLocation();
//        Actions a=new Actions(driver);
//        a.moveToElement(m).moveByOffset(p.x,p.y).click().perform();
		
       
        skill=driver.findElement(By.xpath("//input[contains(@formcontrolname,'skills')]"));
        skill.clear();
		skill.sendKeys(skills);
	}

	public void setLanguage(String lang) throws InterruptedException
	{
		Thread.sleep(1000);
		 WebElement add = driver.findElement(By.cssSelector("body > app-root > app-sampleform > div > form > table:nth-child(17) > tr > th:nth-child(2) > button"));
	       try { ((Locatable) add).getCoordinates().inViewPort();
	        add.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        add.click();
	       }
	       Thread.sleep(500);
	    language=driver.findElement(By.xpath("//input[contains(@formcontrolname,'languages')]"));
		language.sendKeys(lang);
	}

	public void setDescribe(String describe)
	{
		descr=driver.findElement(By.id("yourself"));
		descr.clear();
		descr.sendKeys(describe);
	}

	public void setImage(String imagelnk) throws InterruptedException
	{   Thread.sleep(1000);    
		img=driver.findElement(By.xpath("//input[@type='file']"));
		img.sendKeys(imagelnk);
	}

	public void acceptCheck() throws InterruptedException
	{
		Thread.sleep(1000);
		acceptchk=driver.findElement(By.xpath("//input[@type='checkbox']"));
		 try { ((Locatable) acceptchk).getCoordinates().inViewPort();
		 acceptchk.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        
	        acceptchk.click();
	       }
	}

	public void clickCreateProfile() throws InterruptedException {
		Thread.sleep(2000);
		crtprfsubmit=driver.findElement(By.cssSelector("body > app-root > app-sampleform > div > form > button"));
		try { ((Locatable) crtprfsubmit).getCoordinates().inViewPort();
		crtprfsubmit.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        crtprfsubmit.click();
	       }
		String actual=driver.switchTo().alert().getText();
		String expected="Profile created";
		Assert.assertEquals(actual, expected);
		driver.switchTo().alert().accept();
	}

	public void setPercent(String percent)
	{
		percentage=driver.findElement(By.id("edu_desc"));
		percentage.clear();
		percentage.sendKeys(percent);
	}
	

	public void setSchool(String schoolname)
	{
		school=driver.findElement(By.id("edu_school"));
		school.clear();
		school.sendKeys(schoolname);
	}

	public void higherSecondaryStream(String highersec) throws InterruptedException
	{   
	    higherSecStrm= driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[8]/select"));
	    Thread.sleep(1000);
		Select sel=new Select(higherSecStrm);
		sel.selectByValue(highersec);
		
	}

	public void setHighersecPercentage(String higersecPercent)
	{
		higherSecPercentage=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[8]/input[1]"));
		higherSecPercentage.clear();
		higherSecPercentage.sendKeys(higersecPercent);
		
	}

	public void setHighersecSchool(String higersecSchool)
	{
		higherSecSchool=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[8]/input[2]"));
		higherSecSchool.sendKeys(higersecSchool);
	}

	public void setHighersecYear(String higersecYear)
	{
		higherSecYear=	driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[8]/input[3]"));
		higherSecYear.sendKeys(higersecYear);
		
	}

	public void setGraduationStream(String gradStream)
	{
		graduationStream=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[9]/select[2]"));
		Select sel=new Select(graduationStream);
		sel.selectByValue(gradStream);
	}

	public void setGraduation(String grad) {
		graduation=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[9]/select[1]"));
		Select sel=new Select(graduation);
		sel.selectByValue(grad);
		
	}

	public void setGraduationPercentage(String gradPercent) {
		
		gradPercentage=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[9]/input[1]"));
		gradPercentage.sendKeys(gradPercent);
	}

	public void setGraduationInstitute(String gradInst)
	{
		gradInstitute=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[9]/input[2]"));
		gradInstitute.sendKeys(gradInst);
	}

	public void setGraduationYear(String gradYr)
	{
		gradYear=driver.findElement(By.xpath("/html/body/app-root/app-sampleform/div/form/p[9]/input[3]"));
		gradYear.sendKeys(gradYr);
	}

	public void setProjectDetails(String project, String projectDesc) {
		projectAdd=driver.findElement(By.cssSelector("body > app-root > app-sampleform > div > form > table:nth-child(13) > tr:nth-child(1) > th:nth-child(2) > button"));
		try { ((Locatable) projectAdd).getCoordinates().inViewPort();
		projectAdd.click();
        }
       catch(Exception e)
        {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        projectAdd.click();
         }
		projectTitle=driver.findElement(By.xpath("//input[@formcontrolname='title']"));
		projectTitle.sendKeys(project);
		projectDescription=driver.findElement(By.xpath("//input[@formcontrolname='desc']"));
		projectDescription.sendKeys(projectDesc);
		
	}

	public void setAchievements(String achievements)
	{
		achievementAdd=driver.findElement(By.cssSelector("body > app-root > app-sampleform > div > form > table:nth-child(19) > tr > th:nth-child(2) > button"));
		try
		{ ((Locatable) achievementAdd).getCoordinates().inViewPort();
		achievementAdd.click();
		}
		catch(Exception e)
		{
			new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
			achievementAdd.click();
		}
		achievement=driver.findElement(By.xpath("//input[@formcontrolname='achievements']"));
		achievement.sendKeys(achievements);
				
	}
	
	
}
