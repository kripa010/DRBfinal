package com.drb.script;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.drb.pages.DrbCreateProfile;
import com.drb.pages.DrbDeleteProfile;
import com.drb.pages.DrbDownload;
import com.drb.pages.DrbEditProfile;
import com.drb.pages.DrbLogin;
import com.drb.pages.DrbLogout;
import com.drb.pages.DrbSignUp;
import com.drb.utilities.ExcelUtilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class DrbTest extends DrbTestBase{
	DrbLogin dlin;
	 DrbSignUp dsignup;
	 DrbCreateProfile dcrtprf;
	 DrbEditProfile dedtprf;
//  public void loginValidate(String userName,String pass)
//  {
//	  dlin=new DrbLogin(driver);
//	  dlin.clickSignUp();
//	  dlin.setUserName(userName);
//	  dlin.setPassword(pass);
//	  dlin.clickRememberMe();
//	  dlin.loginClick();
//	  String title="http://167.71.226.96/login";
//	  String actualTitle=driver.getCurrentUrl();
//	  AssertJUnit.assertEquals(actualTitle, title);
//  }
  @Test(priority=2)
  public void validlogin() throws IOException, InterruptedException
  {   
	  String userName=ExcelUtilities.getcelldata(0, 0, 1);
	  String pass=ExcelUtilities.getcelldata(0, 1, 1);
	  dlin=new DrbLogin(driver);
	  dlin.clickSignUp();
	  dlin.setUserName(userName);
	  dlin.setPassword(pass);
	  dlin.clickRememberMe();
	  dlin.loginClick();
	  Thread.sleep(500);
	  String title="http://167.71.226.96/";
	  String actualTitle=driver.getCurrentUrl();
	  System.out.println(actualTitle);
	  Assert.assertEquals(actualTitle, title);
	  
  }
  @Test
  public void inValidlogin1() throws IOException, InterruptedException
  {
	  String userName=ExcelUtilities.getcelldata(0, 0, 2);
	  String pass=ExcelUtilities.getcelldata(0, 1, 2);
	  dlin=new DrbLogin(driver);
	  dlin.clickSignUp();
	  dlin.setUserName(userName);
	  dlin.setPassword(pass);
	  dlin.clickRememberMe();
	  dlin.loginClick();
	  WebElement loginButton =driver.findElement(By.className("login100-form-btn"));
	  boolean actual=loginButton.isSelected();
	  System.out.println(actual);
	  Assert.assertFalse(actual);
//	  Thread.sleep(1000);
//	  String title="http://167.71.226.96/";
//	  String actualTitle=driver.getCurrentUrl();
//	  System.out.println(actualTitle);
//	  AssertJUnit.assertEquals(actualTitle, title);
  }
  
  @Test
  public  void validSignUp() throws IOException, InterruptedException
  {	  String username=ExcelUtilities.getcelldata(1, 0, 1);
  	  String phone=ExcelUtilities.getcelldata(1, 1, 1);
  	  String email=ExcelUtilities.getcelldata(1, 2, 1);
  	  String pass=ExcelUtilities.getcelldata(1, 3, 1);
  	  String cpass=ExcelUtilities.getcelldata(1, 4, 1);
	  dsignup=new DrbSignUp(driver);
	 // dsignup.clickSignUp();
	 // dsignup.clickSignupLink();
	  driver.navigate().to("http://167.71.226.96/signup");
	  dsignup.setUserName(username);
	  dsignup.setPhoneNumber(phone);
	  dsignup.setMailId(ExcelUtilities.getcelldata(1, 2, 1));
	  dsignup.setPassword(ExcelUtilities.getcelldata(1, 3, 1));
	  dsignup.setConfirmPassword(ExcelUtilities.getcelldata(1, 4, 1));
	  dsignup.clickRegister();
	  String expected="New user added";
	  String actual=driver.switchTo().alert().getText();
	  Assert.assertEquals(actual, expected);
	  driver.switchTo().alert().accept();
	 
  }
  @Test(priority=1)
  public  void inValidSignUpWithExisting() throws IOException, InterruptedException
  {	  validSignUp();
  	  String username=ExcelUtilities.getcelldata(1, 0, 1);
	  String phone=ExcelUtilities.getcelldata(1, 1, 1);
	  String email=ExcelUtilities.getcelldata(1, 2, 1);
	  String pass=ExcelUtilities.getcelldata(1, 3, 1);
	  String cpass=ExcelUtilities.getcelldata(1, 4, 1);
	  dsignup=new DrbSignUp(driver);
	 // dsignup.clickSignUp();
	 // dsignup.clickSignupLink();
	  driver.navigate().to("http://167.71.226.96/signup");
	  dsignup.setUserName(username);
	  dsignup.setPhoneNumber(phone);
	  dsignup.setMailId(ExcelUtilities.getcelldata(1, 2, 1));
	  dsignup.setPassword(ExcelUtilities.getcelldata(1, 3, 1));
	  dsignup.setConfirmPassword(ExcelUtilities.getcelldata(1, 4, 1));
	  dsignup.clickRegister();
	  String expected="User already Exists";
	  String actual=driver.switchTo().alert().getText();
	  Assert.assertEquals(actual, expected);
	  driver.switchTo().alert().accept();
	 
  }
  @Test(priority=3)
  public void validCreateProfile() throws IOException, InterruptedException
  {
	  
  	  String name=ExcelUtilities.getcelldata(2, 1, 1);
  	  String dob=ExcelUtilities.getcelldata(2, 2, 1);
  	  String gender=ExcelUtilities.getcelldata(2, 3, 1);
  	  String email=ExcelUtilities.getcelldata(2, 4, 1);
  	  String phone=ExcelUtilities.getcelldata(2, 5, 1);
  	  String schoolstrm=ExcelUtilities.getcelldata(2, 6, 1);
  	  String percentage=ExcelUtilities.getcelldata(2, 7, 1);
  	  String school=ExcelUtilities.getcelldata(2, 8, 1);
   	  String year=ExcelUtilities.getcelldata(2, 9, 1);
   	  String skills=ExcelUtilities.getcelldata(2, 10, 1);
   	  String lang=ExcelUtilities.getcelldata(2, 11, 1);
   	  String describe=ExcelUtilities.getcelldata(2, 12, 1);
   	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(2, 13, 1);
   	  dcrtprf=new DrbCreateProfile(driver);
   	  validlogin();
   	  dcrtprf.clickMyProfile();
   	  dcrtprf.clickCrtProfile();
   	  dcrtprf.setName(name);
   	  dcrtprf.setDob(dob);
   	  dcrtprf.clickGender(gender);
   	  dcrtprf.setEmail(email);
   	  dcrtprf.setPhone(phone);
   	  dcrtprf.setSchoolStream(schoolstrm);
   	  dcrtprf.setPercent(percentage);
   	  dcrtprf.setSchool(school);
   	  dcrtprf.setYear(year);
   	  
   	  dcrtprf.setSkills(skills);
   	  dcrtprf.setLanguage(lang);
   	  dcrtprf.setDescribe(describe);
   	  dcrtprf.setImage(img);
   	  dcrtprf.acceptCheck();
   	  dcrtprf.clickCreateProfile();
  
}
  @Test(priority=5)
  public void logOut() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbLogout dlout=new DrbLogout(driver);
	  Thread.sleep(1000);
	  dlout.clickLogout();
	  
  }
  @Test(priority=7)
  public void deleteProfile() throws IOException, InterruptedException
  {
	  validlogin();
//	  validSignUp();
//	  validCreateProfile();
	  DrbDeleteProfile drbdlt=new DrbDeleteProfile(driver);
	//  Thread.sleep(1000);
	  drbdlt.deleteProfile();
	 
	  
  }
  @Test(priority=6)
  public void downloadTemplate1() throws IOException, InterruptedException
  {
	  validlogin();
	  DrbDownload  drbdwnld =new DrbDownload(driver);
	  drbdwnld.clickTemplateBtn();
	  drbdwnld.clickTemplate();
	  drbdwnld.clickDownloadResume();
	
  }
  
    @Test(priority=4)
    public void validEditProfile() throws IOException, InterruptedException
  {
	  
  	  String name=ExcelUtilities.getcelldata(3, 1, 1);
  	  String dob=ExcelUtilities.getcelldata(3, 2, 1);
  	  String gender=ExcelUtilities.getcelldata(3, 3, 1);
  	  String email=ExcelUtilities.getcelldata(3, 4, 1);
  	  String phone=ExcelUtilities.getcelldata(3, 5, 1);
  	  String schoolstrm=ExcelUtilities.getcelldata(3, 6, 1);
  	  String percentage=ExcelUtilities.getcelldata(3, 7, 1);
  	  String school=ExcelUtilities.getcelldata(3, 8, 1);
   	  String year=ExcelUtilities.getcelldata(3, 9, 1);
   	  String skills=ExcelUtilities.getcelldata(3, 10, 1);
   	  String lang=ExcelUtilities.getcelldata(3, 11, 1);
   	  String describe=ExcelUtilities.getcelldata(3, 12, 1);
   	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(3, 13, 1);
   	  dedtprf=new DrbEditProfile(driver);
   	  validlogin();
   	  dedtprf.clickMyProfile();
   	  dedtprf.clickEditProfilebtn();
   	  dedtprf.setName(name);
   	  dedtprf.setDob(dob);
   	  dedtprf.clickGender(gender);
   	  dedtprf.setEmail(email);
   	  dedtprf.setPhone(phone);
   	  dedtprf.setSchoolStream(schoolstrm);
   	  dedtprf.setPercent(percentage);
   	  dedtprf.setSchool(school);
   	  dedtprf.setYear(year);
   	  dedtprf.setSkills(skills);
   	  dedtprf.setLanguage(lang);
   	  dedtprf.setDescribe(describe);
   	  dedtprf.setImage(img);
   	  dedtprf.acceptCheck();
   	  dedtprf.clickUpdateProfile();
   	
}
   

@Test
public void validAllCreateProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata(2, 16, 1);
	  String dob=ExcelUtilities.getcelldata(2, 17, 1);
	  String gender=ExcelUtilities.getcelldata(2, 18, 1);
	  String email=ExcelUtilities.getcelldata(2, 19, 1);
	  String phone=ExcelUtilities.getcelldata(2, 20, 1);
	  String schoolstrm=ExcelUtilities.getcelldata(2, 21, 1);
	  String percentage=ExcelUtilities.getcelldata(2, 22, 1);
	  String school=ExcelUtilities.getcelldata(2, 23, 1);
 	  String year=ExcelUtilities.getcelldata(2, 24, 1);
 	  String higersec=ExcelUtilities.getcelldata(2, 25, 1);
 	  String higersecPercentage=ExcelUtilities.getcelldata(2, 26, 1);
 	  String higersecSchool=ExcelUtilities.getcelldata(2, 27, 1);
 	  String higersecYear=ExcelUtilities.getcelldata(2, 28, 1);
 	  String graduation=ExcelUtilities.getcelldata(2, 29, 1);
 	  String gradStream=ExcelUtilities.getcelldata(2, 30, 1);
 	  String gradPercentage=ExcelUtilities.getcelldata(2, 31, 1);
 	  String gradInstitute=ExcelUtilities.getcelldata(2, 32, 1);
 	  String gradYear=ExcelUtilities.getcelldata(2, 33, 1);
 	  String postgrad=ExcelUtilities.getcelldata(2, 34, 1);
 	  String postgradStream=ExcelUtilities.getcelldata(2, 35, 1);
 	  String postgradPercentage=ExcelUtilities.getcelldata(2, 36, 1);
 	  String postgradInstitute=ExcelUtilities.getcelldata(2, 37, 1);
 	  String postgradYear=ExcelUtilities.getcelldata(2, 38, 1);
 	  String project=ExcelUtilities.getcelldata(2, 39, 1);
 	  String projectDesc=ExcelUtilities.getcelldata(2, 40, 1);
 	  String additionalCourse=ExcelUtilities.getcelldata(2, 41, 1);
 	  String courseName=ExcelUtilities.getcelldata(2, 42, 1);
 	  String coursePercentage=ExcelUtilities.getcelldata(2, 43, 1);
 	  String jobTitle=ExcelUtilities.getcelldata(2, 44, 1);
 	  String from=ExcelUtilities.getcelldata(2, 45, 1);
 	  String to=ExcelUtilities.getcelldata(2, 46, 1);
 	  String skills=ExcelUtilities.getcelldata(2, 47, 1);
 	  String lang=ExcelUtilities.getcelldata(2, 48, 1);
 	  String programLang=ExcelUtilities.getcelldata(2, 49, 1);
 	  String  achievements=ExcelUtilities.getcelldata(2, 50, 1);
 	  String describe=ExcelUtilities.getcelldata(2, 51, 1);
 	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(2, 52, 1);
 	  dcrtprf=new DrbCreateProfile(driver);
 	  validlogin();
 	  dcrtprf.clickMyProfile();
 	  dcrtprf.clickCrtProfile();
 	  dcrtprf.setName(name);
 	  dcrtprf.setDob(dob);
 	  dcrtprf.clickGender(gender);
 	  dcrtprf.setEmail(email);
 	  dcrtprf.setPhone(phone);
 	  dcrtprf.setSchoolStream(schoolstrm);
 	  dcrtprf.setPercent(percentage);
 	  dcrtprf.setSchool(school);
 	  dcrtprf.setYear(year);
 	  dcrtprf.higherSecondaryStream(higersec);
 	  dcrtprf.setHighersecPercentage(higersecPercentage);
      dcrtprf.setHighersecSchool(higersecSchool);
 	  dcrtprf.setHighersecYear(higersecYear);
 	  dcrtprf.setGraduation(graduation);
 	  dcrtprf.setGraduationStream(gradStream);
	  dcrtprf.setGraduationPercentage(gradPercentage);
	  dcrtprf.setGraduationInstitute(gradInstitute);
	  dcrtprf.setGraduationYear(gradYear);
//	  dcrtprf.setPostGraduationStream(postgradStream);
//	  dcrtprf.setPostGraduationPercentage(postgradPercentage);
//	  dcrtprf.setPostGraduationInstitute(postgradInstitute);
//	  dcrtprf.sePosttGraduationYear(postgradYear);
	  dcrtprf.setProjectDetails(project,projectDesc);
	  
//	  dcrtprf.seAdditionalCourse(additionalCourse);
//	  dcrtprf.setCourseName(courseName);
//	  dcrtprf.setCoursePercentage(coursePercentage);
//	  dcrtprf.setJobTitle(jobTitle);
//	  dcrtprf.setFromDate(from);
//	  dcrtprf.setToDate(to);
	  dcrtprf.setSkills(skills);
 	  dcrtprf.setLanguage(lang);
// 	  dcrtprf.setProgrammimgLanguages(programLang);
 	  dcrtprf.setAchievements(achievements);
 	  dcrtprf.setDescribe(describe);
 	  dcrtprf.setImage(img);
 	  dcrtprf.acceptCheck();
 	  dcrtprf.clickCreateProfile();
 	 
}
//INVALID EDITPROFILE mandatory
@Test
public void invalidEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata(3, 1, 2);                
	  String dob=ExcelUtilities.getcelldata(3, 2, 2);
	  String gender=ExcelUtilities.getcelldata(3, 3, 2);
	  String email=ExcelUtilities.getcelldata(3, 4, 2);
	  String phone=ExcelUtilities.getcelldata(3, 5, 2);
	  String schoolstrm=ExcelUtilities.getcelldata(3, 6, 2);
	  String percentage=ExcelUtilities.getcelldata(3, 7, 2);
	  String school=ExcelUtilities.getcelldata(3, 8, 2);
 	  String year=ExcelUtilities.getcelldata(3, 9, 2);
 	  String skills=ExcelUtilities.getcelldata(3, 10, 2);
 	  String lang=ExcelUtilities.getcelldata(3, 11, 2);
 	  String describe=ExcelUtilities.getcelldata(3, 12, 2);
 	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(3, 13, 2);
 	  dedtprf=new DrbEditProfile(driver);

 	  validlogin();

 	 dedtprf.clickMyProfile();
  	  dedtprf.clickEditProfilebtn();
 	   dedtprf.setName(name);
 	  dedtprf.setDob(dob);
 	  dedtprf.clickGender(gender);
 	  dedtprf.setEmail(email);
 	  dedtprf.setPhone(phone);
 	  dedtprf.setSchoolStream(schoolstrm);
 	  dedtprf.setPercent(percentage);
 	  dedtprf.setSchool(school);
 	  dedtprf.setYear(year);
 	  
 	  dedtprf.setSkills(skills);


 	  dedtprf.setLanguage(lang);
 	  dedtprf.setDescribe(describe);
 	  dedtprf.setImage(img);
 	  dedtprf.acceptCheck();

 	  dedtprf.clickUpdateProfile();	

	  String expected ="Enter valid data";
	  String actual =driver.switchTo().alert().getText();
		Assert.assertEquals(actual,expected);
		driver.switchTo().alert().accept();
 
	  Thread.sleep(1000);         
}



@Test
public void validAllEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata(3, 16, 1);
	  String dob=ExcelUtilities.getcelldata(3, 17, 1);
	  String gender=ExcelUtilities.getcelldata(3, 18, 1);
	  String email=ExcelUtilities.getcelldata(3, 19, 1);
	  String phone=ExcelUtilities.getcelldata(3, 20, 1);
	  String schoolstrm=ExcelUtilities.getcelldata(3, 21, 1);
	  String percentage=ExcelUtilities.getcelldata(3, 22, 1);
	  String school=ExcelUtilities.getcelldata(3, 23, 1);
	  String year=ExcelUtilities.getcelldata(3, 24, 1);
	  String higersec=ExcelUtilities.getcelldata(3, 25, 1);
	  String higersecPercentage=ExcelUtilities.getcelldata(3, 26, 1);
	  String higersecSchool=ExcelUtilities.getcelldata(3, 27, 1);
	  String higersecYear=ExcelUtilities.getcelldata(3, 28, 1);
	  String graduation=ExcelUtilities.getcelldata(3, 29, 1);
	  String gradStream=ExcelUtilities.getcelldata(3, 30, 1);
	  String gradPercentage=ExcelUtilities.getcelldata(3, 31, 1);
	  String gradInstitute=ExcelUtilities.getcelldata(3, 32, 1);
	  String gradYear=ExcelUtilities.getcelldata(3, 33, 1);
	  String postgrad=ExcelUtilities.getcelldata(3, 34, 1);
	  String postgradStream=ExcelUtilities.getcelldata(3, 35, 1);
	  String postgradPercentage=ExcelUtilities.getcelldata(3, 36, 1);
	  String postgradInstitute=ExcelUtilities.getcelldata(3, 37, 1);
	  String postgradYear=ExcelUtilities.getcelldata(3, 38, 1);
	  String project=ExcelUtilities.getcelldata(3, 39, 1);
	  String projectDesc=ExcelUtilities.getcelldata(3, 40, 1);
	  String additionalCourse=ExcelUtilities.getcelldata(3, 41, 1);
	  String courseName=ExcelUtilities.getcelldata(3, 42, 1);
	  String coursePercentage=ExcelUtilities.getcelldata(3, 43, 1);
	  String jobTitle=ExcelUtilities.getcelldata(3, 44, 1);
	  String from=ExcelUtilities.getcelldata(3, 45, 1);
	  String to=ExcelUtilities.getcelldata(3, 46, 1);
	  String skills=ExcelUtilities.getcelldata(3, 47, 1);
	  String lang=ExcelUtilities.getcelldata(3, 48, 1);
	  String programLang=ExcelUtilities.getcelldata(3, 49, 1);
	  String  achievements=ExcelUtilities.getcelldata(3, 50, 1);
	  String describe=ExcelUtilities.getcelldata(3, 51, 1);
	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata(3, 52, 1);

	  dedtprf=new DrbEditProfile(driver);

	  validlogin();
	  dedtprf.clickMyProfile();
	  dedtprf.clickEditProfilebtn();
	  dedtprf.setName(name);
	  dedtprf.setDob(dob);
	  dedtprf.clickGender(gender);
	  dedtprf.setEmail(email);
	  dedtprf.setPhone(phone);
	  dedtprf.setSchoolStream(schoolstrm);
	  dedtprf.setPercent(percentage);
	  dedtprf.setSchool(school);
	  dedtprf.setYear(year);
	  dedtprf.higherSecondaryStream(higersec);
	  dedtprf.setHighersecPercentage(higersecPercentage);
      dedtprf.setHighersecSchool(higersecSchool);
	  dedtprf.setHighersecYear(higersecYear);
	  dedtprf.setGraduation(graduation);
	  dedtprf.setGraduationStream(gradStream);
	  dedtprf.setGraduationPercentage(gradPercentage);
	  dedtprf.setGraduationInstitute(gradInstitute);
	  dedtprf.setGraduationYear(gradYear);
//	  dedtprf.setPostGraduationStream(postgradStream);
//	  dedtprf.setPostGraduationPercentage(postgradPercentage);
//	  dedtprf.setPostGraduationInstitute(postgradInstitute);
//	  dedtprf.sePosttGraduationYear(postgradYear);
	  dedtprf.setProjectDetails(project,projectDesc);
	  
//	  dedtprf.seAdditionalCourse(additionalCourse);
//	  dedtprf.setCourseName(courseName);
//	  dedtprf.setCoursePercentage(coursePercentage);
//	  dedtprf.setJobTitle(jobTitle);
//	  dedtprf.setFromDate(from);
//	  dedtprf.setToDate(to);
	  dedtprf.setSkills(skills);
	  dedtprf.setLanguage(lang);
//	  dedttprf.setProgrammimgLanguages(programLang);
	  dedtprf.setAchievements(achievements);
	  dedtprf.setDescribe(describe);
	  dedtprf.setImage(img);
	  dedtprf.acceptCheck();
	  dedtprf.clickUpdateProfile();
	
	  Thread.sleep(1000);
}
@Test
public  void invalidSignUp() throws IOException, InterruptedException
{	  String username=ExcelUtilities.getcelldata(1, 0, 2);
	  String phone=ExcelUtilities.getcelldata(1, 1, 2);
	  String email=ExcelUtilities.getcelldata(1, 2, 2);
	  String pass=ExcelUtilities.getcelldata(1, 3, 2);
	  String cpass=ExcelUtilities.getcelldata(1, 4, 2);
	  dsignup=new DrbSignUp(driver);
	 // dsignup.clickSignUp();
	 // dsignup.clickSignupLink();
	  driver.navigate().to("http://167.71.226.96/signup");
	  dsignup.setUserName(username);
	  dsignup.setPhoneNumber(phone);
	  dsignup.setMailId(ExcelUtilities.getcelldata(1, 2, 2));
	  dsignup.setPassword(ExcelUtilities.getcelldata(1, 3, 2));
	  dsignup.setConfirmPassword(ExcelUtilities.getcelldata(1, 4, 2));
	  dsignup.clickRegister();
	  
	  WebElement registerButton=driver.findElement(By.cssSelector("body > app-root > app-signup > div > div > form > button > span"));
		
	  boolean actual=registerButton.isSelected();
	  System.out.println(actual);
	  Assert.assertFalse(actual);
	  Thread.sleep(1000);  
}

}

