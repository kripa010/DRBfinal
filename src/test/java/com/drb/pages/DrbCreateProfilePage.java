package com.drb.pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class DrbCreateProfilePage
{   WebDriver driver;
	@FindBy(xpath="//a[@href='/profilehome']")
    WebElement myprof;
	@FindBy(xpath="//button[contains(@class,'btn-get')]")
    WebElement crtprfbtn;
	@FindBy(name="name")
    WebElement fulname;
	@FindBy(id="date")
    WebElement dob;
	@FindBy(id="gender")
	List<WebElement> gend;
	@FindBy(id="email_id")
    WebElement email;
	@FindBy(id="phone")
    WebElement phone;
	@FindBy(id="edu_title")
    WebElement strm;
	@FindBy(id="edu_school")
    WebElement school;
	@FindBy(id="edu_desc")
    WebElement percentage;
	@FindBy(id="edu_year")
    WebElement year;
	@FindBy(xpath="//p[@formgroupname='higherschools']//select[@formcontrolname='edu_title']")
    WebElement higherSecStrm;
	@FindBy(xpath="//p[@formgroupname='higherschools']//input[@formcontrolname='edu_desc']")
    WebElement higherSecPercentage;
	@FindBy(xpath="//p[@formgroupname='higherschools']//input[@formcontrolname='edu_school']")
    WebElement higherSecSchool;
	@FindBy(xpath="//p[@formgroupname='higherschools']//input[@formcontrolname='edu_year']")
    WebElement higherSecYear;
	@FindBy(xpath="//p[@formgroupname='graduations']//select[@formcontrolname='edu_title']")
	 WebElement graduation;
	@FindBy(xpath="//p[@formgroupname='graduations']//select[@formcontrolname='edu_stream']")
    WebElement graduationStream;
	@FindBy(xpath="//p[@formgroupname='graduations']//input[@formcontrolname='edu_desc']")
    WebElement gradPercentage;
	@FindBy(xpath="//p[@formgroupname='graduations']//input[@placeholder='Institution Name']")
    WebElement gradInstitute;
	@FindBy(xpath="//p[@formgroupname='graduations']//input[@formcontrolname='edu_year']")
    WebElement gradYear;
	@FindBy(xpath="//table[@formarrayname='skills']//button[@class='btn btn-primary']")
    WebElement addSkillBtn;
	@FindBy(xpath="//input[contains(@formcontrolname,'skills')]")
    WebElement skill;
	@FindBy(xpath="//table[@formarrayname='languages']//button[@class='btn btn-primary']")
    WebElement languageAdd;
	@FindBy(xpath="//input[contains(@formcontrolname,'languages')]")
    WebElement language;
	@FindBy(id="yourself")
    WebElement descr;
	@FindBy(xpath="//table[@formarrayname=\"projects\"]//button[@class=\"btn btn-primary\"]")
    WebElement projectAdd;
	@FindBy(xpath="//input[@formcontrolname='title']")
    WebElement projectTitle;
	@FindBy(xpath="//input[@formcontrolname='desc']")
    WebElement projectDescription;
	@FindBy(xpath="//table[@formarrayname='achievements']//button[@class='btn btn-primary']")
    WebElement achievementAdd;
	@FindBy(xpath="//input[@formcontrolname='achievements']")
    WebElement achievement;
	@FindBy(xpath="//input[@type='file']")
    WebElement img;
	@FindBy(xpath="//input[@type='checkbox']")
    WebElement acceptchk;
	@FindBy(xpath="//button[@type='submit']")
    WebElement crtprfsubmit;
	public DrbCreateProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMyProfile()
	{	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/profilehome']")));
		myprof.click();
	}

	public void clickCrtProfile()
	{
		crtprfbtn.click();
	}

	public void setName(String name2)
	{
		fulname.clear();
		fulname.sendKeys(name2);
	}

	public void clickGender(String gender)
	{
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
		dob.sendKeys(dateofbirth);
	}

	public void setEmail(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
	}

	public void setPhone(String phonenum)
	{
		phone.clear();
		phone.sendKeys(phonenum);
	}

	public void setSchoolStream(String schoolstrm)
	{
		Select sel=new Select(strm);
		sel.selectByValue(schoolstrm);
	}

	public void setYear(String yr)
	{
	year.clear();
	year.sendKeys(yr);
		
	}

	public void setSkills(String skills) throws InterruptedException
	{ 	
	  try { ((Locatable) addSkillBtn).getCoordinates().inViewPort();
        addSkillBtn.click();
        }
       catch(Exception e)
       {
    	new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    	addSkillBtn.click();
       }
	  try { ((Locatable) skill).getCoordinates().inViewPort();
	  skill.clear();
		skill.sendKeys(skills);
      }
     catch(Exception e)
     {
  	new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
  	skill.clear();
	skill.sendKeys(skills);
     }  
	  
	}

	public void setLanguage(String lang) throws InterruptedException
	{
		
	    try { ((Locatable) languageAdd).getCoordinates().inViewPort();
	        languageAdd.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        languageAdd.click();
	       }
	       Thread.sleep(500);
	       language.sendKeys(lang);
	}

	public void setDescribe(String describe)
	{
		descr.clear();
		descr.sendKeys(describe);
	}

	public void setImage(String imagelnk) throws InterruptedException
	{   Thread.sleep(1000);    
		img.sendKeys(imagelnk);
	}

	public void acceptCheck() throws InterruptedException
	{
		
		try { ((Locatable) acceptchk).getCoordinates().inViewPort();
		 acceptchk.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        
	        acceptchk.click();
	       }
	}

	public String clickCreateProfile() throws InterruptedException {
		Thread.sleep(2000);
		try { ((Locatable) crtprfsubmit).getCoordinates().inViewPort();
		crtprfsubmit.click();
	        }
	       catch(Exception e)
	       {
	        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
	        crtprfsubmit.click();
	       }
		 String actual=driver.switchTo().alert().getText();
		 driver.switchTo().alert().accept();
		 return actual;
	}

	public void setPercent(String percent)
	{
		percentage.clear();
		percentage.sendKeys(percent);
	}
	

	public void setSchool(String schoolname)
	{
		school.clear();
		school.sendKeys(schoolname);
	}

	public void higherSecondaryStream(String highersec)
	{   
	    Select sel=new Select(higherSecStrm);
		sel.selectByValue(highersec);
		
	}

	public void setHighersecPercentage(String higersecPercent)
	{
		higherSecPercentage.clear();
		higherSecPercentage.sendKeys(higersecPercent);
		
	}

	public void setHighersecSchool(String higersecSchool)
	{
		higherSecSchool.sendKeys(higersecSchool);
	}

	public void setHighersecYear(String higersecYear)
	{
		higherSecYear.sendKeys(higersecYear);
		
	}

	public void setGraduationStream(String gradStream)
	{
		Select sel=new Select(graduationStream);
		sel.selectByValue(gradStream);
	}

	public void setGraduation(String grad) {
		Select sel=new Select(graduation);
		sel.selectByValue(grad);
		
	}

	public void setGraduationPercentage(String gradPercent) {
		
		gradPercentage.sendKeys(gradPercent);
	}

	public void setGraduationInstitute(String gradInst)
	{
		gradInstitute.sendKeys(gradInst);
	}

	public void setGraduationYear(String gradYr)
	{
		gradYear.sendKeys(gradYr);
	}

	public void setProjectDetails(String project, String projectDesc)
	{
		try { ((Locatable) projectAdd).getCoordinates().inViewPort();
		projectAdd.click();
        }
       catch(Exception e)
        {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        projectAdd.click();
         }
		projectTitle.sendKeys(project);
		projectDescription.sendKeys(projectDesc);
		
	}

	public void setAchievements(String achievements)
	{
		try
		{ ((Locatable) achievementAdd).getCoordinates().inViewPort();
		achievementAdd.click();
		}
		catch(Exception e)
		{
			new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
			achievementAdd.click();
		}
		achievement.sendKeys(achievements);
				
	}

	public void setPersonalDetails(String name2, String dob2, String gender, String email2, String phone2)
	{
	  setName(name2);
	  setDob(dob2);
	  clickGender(gender);
	  setEmail(email2);
	  setPhone(phone2);
			
	}

	public void setSchoolDetails(String schoolstrm, String percentage2, String school2, String year2)
	{
		  setSchoolStream(schoolstrm);
	 	  setPercent(percentage2);
	 	  setSchool(school2);
	 	  setYear(year2);
		
	}

	public void setHigherSecondaryDetails(String higersec, String higersecPercentage, String higersecSchool,
			String higersecYear) 
	{
		 higherSecondaryStream(higersec);
		 setHighersecPercentage(higersecPercentage);
		 setHighersecSchool(higersecSchool);
		 setHighersecYear(higersecYear);
		
	}

	public void setGraduationDetails(String graduation2, String gradStream, String gradPercentage2,
			String gradInstitute2, String gradYear2)
	{
		setGraduation(graduation2);
	 	setGraduationStream(gradStream);
		setGraduationPercentage(gradPercentage2);
		setGraduationInstitute(gradInstitute2);
		setGraduationYear(gradYear2);
		
	}
		
}
