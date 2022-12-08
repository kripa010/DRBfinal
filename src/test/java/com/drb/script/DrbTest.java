package com.drb.script;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.drb.pages.DrbCreateProfilePage;
import com.drb.pages.DrbDeleteProfilePage;
import com.drb.pages.DrbDownloadPage;
import com.drb.pages.DrbEditProfilePage;
import com.drb.pages.DrbLoginPage;
import com.drb.pages.DrbLogoutPage;
import com.drb.pages.DrbSignUpPage;
import com.drb.utilities.ExcelUtilities;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.Assert;
public class DrbTest extends DrbBase{
   	 DrbLoginPage dlin;
	 DrbSignUpPage dsignup;
	 DrbCreateProfilePage dcrtprf;
	 DrbEditProfilePage dedtprf;
	 DrbDeleteProfilePage drbdlt;
	 DrbLogoutPage dlout;
	 DrbDownloadPage  drbdwnld;
	
		 
@BeforeMethod
public void init()
{    
	dsignup=new DrbSignUpPage(driver);
	dsignup=new DrbSignUpPage(driver);
	dcrtprf=new DrbCreateProfilePage(driver);
	drbdlt=new DrbDeleteProfilePage(driver);
	drbdwnld =new DrbDownloadPage(driver);
	dedtprf=new DrbEditProfilePage(driver);
	dlin=new DrbLoginPage(driver);
	dlout=new DrbLogoutPage(driver);
		
		
	
}

public void logIn() throws IOException, InterruptedException
{
	
	String userName=ExcelUtilities.getcelldata("LogIn", 0, 1);
	  String pass=ExcelUtilities.getcelldata("LogIn", 1, 1);
	  dlin.clickSignUp();
	  dlin.setUserName(userName);
	  dlin.setPassword(pass);
	  dlin.clickRememberMe();
	  dlin.loginClick();
}

public void signUp() throws IOException, InterruptedException
{ String username=ExcelUtilities.getcelldata("SignUp", 0, 1);
	String phone=ExcelUtilities.getcelldata("SignUp", 1, 1);
	String email=ExcelUtilities.getcelldata("SignUp", 2, 1);
	String pass=ExcelUtilities.getcelldata("SignUp", 3, 1);
	String cpass=ExcelUtilities.getcelldata("SignUp", 4, 1);
	dsignup.clickSignUp();
	dsignup.clickSignupLink();
	dsignup.setUserName(username);
	dsignup.setPhoneNumber(phone);
	dsignup.setMailId(email);
	dsignup.setPassword(pass);
	dsignup.setConfirmPassword(cpass);
	dsignup.clickRegister(); 
 }
 
  @Test
  //VALID SIGNUP 
  public  void validSignUp() throws IOException, InterruptedException
  {	  signUp();  
      String expected="New user added";
	  String actual=driver.switchTo().alert().getText();
	  Assert.assertEquals(actual, expected);
	  driver.switchTo().alert().accept(); 
  }
  
  @Test
  //INVALID SIGNUP
  public  void invalidSignUp() throws IOException, InterruptedException
  {	   String username=ExcelUtilities.getcelldata("SignUp", 0, 2);
	  String phone=ExcelUtilities.getcelldata("SignUp", 1, 2);
	  String email=ExcelUtilities.getcelldata("SignUp", 2, 2);
	  String pass=ExcelUtilities.getcelldata("SignUp", 3, 2);
	  String cpass=ExcelUtilities.getcelldata("SignUp", 4, 2);
      dsignup.clickSignUp();
	  dsignup.clickSignupLink();
	  dsignup.setUserName(username);
	  dsignup.setPhoneNumber(phone);
	  dsignup.setMailId(email);
	  dsignup.setPassword(pass);
	  dsignup.setConfirmPassword(cpass);
	  dsignup.clickRegister(); 
  	  boolean actual=dsignup.isInvalidSignUp();
  	  Assert.assertFalse(actual);
  	  Thread.sleep(1000);  
  }
  
  @Test
  //INVALID SIGNUP WITH EXISTING USERNAME
  public  void inValidSignUpWithExisting() throws IOException, InterruptedException
  {	  signUp();
      driver.switchTo().alert().accept();
      Thread.sleep(1000);
	  signUp();
	  String actual=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  String expected="User already Exists";
	  Assert.assertEquals(actual, expected);
	 
	 
  }
  
  @Test
  //VALID LOGIN
  public void validlogin() throws IOException, InterruptedException
  {   
	 logIn();
	  boolean valid=dlin.isValidLogIn();
	  Assert.assertTrue(valid);
	  dlout.clickLogout();
  }
 
  @Test
  //LOGIN WITH INVALID USERNAME, PASSWORD
  public void inValidlogin1() throws IOException, InterruptedException
  {
	  String userName=ExcelUtilities.getcelldata("LogIn", 0, 2);
	  String pass=ExcelUtilities.getcelldata("LogIn", 1, 2);
	  dlin.clickSignUp();
	  Thread.sleep(1000);
	  dlin.setUserName(userName);
	  dlin.setPassword(pass);
	  dlin.clickRememberMe();
	  dlin.loginClick();
	  boolean valid=dlin.isInvalidLogIn();
	  Assert.assertTrue(valid);
  }
  

  @Test
  //CREATE PROFILE WITH ALL VALID MANDATORY FIELDS
  public void validCreateProfile() throws IOException, InterruptedException
  {
	  
  	  String name=ExcelUtilities.getcelldata("CreateProfile", 1, 1);
  	  String dob=ExcelUtilities.getcelldata("CreateProfile", 2, 1);
  	  String gender=ExcelUtilities.getcelldata("CreateProfile", 3, 1);
  	  String email=ExcelUtilities.getcelldata("CreateProfile", 4, 1);
  	  String phone=ExcelUtilities.getcelldata("CreateProfile", 5, 1);
  	  String schoolstrm=ExcelUtilities.getcelldata("CreateProfile", 6, 1);
  	  String percentage=ExcelUtilities.getcelldata("CreateProfile", 7, 1);
  	  String school=ExcelUtilities.getcelldata("CreateProfile", 8, 1);
   	  String year=ExcelUtilities.getcelldata("CreateProfile", 9, 1);
   	  String skills=ExcelUtilities.getcelldata("CreateProfile", 10, 1);
   	  String lang=ExcelUtilities.getcelldata("CreateProfile", 11, 1);
   	  String describe=ExcelUtilities.getcelldata("CreateProfile", 12, 1);
   	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata("CreateProfile", 13, 1);
      logIn();
   	  dcrtprf.clickMyProfile();
   	  dcrtprf.clickCrtProfile();
   	  dcrtprf.setPersonalDetails(name, dob, gender, email, phone);
   	  dcrtprf.setSchoolDetails(schoolstrm, percentage, school, year);
   	  dcrtprf.setSkills(skills);
   	  dcrtprf.setLanguage(lang);
   	  dcrtprf.setDescribe(describe);
   	  dcrtprf.setImage(img);
   	  dcrtprf.acceptCheck();
   	  String actual=dcrtprf.clickCreateProfile();
	  String expected="Profile created";
	  Assert.assertEquals(actual, expected);
	 
  
}
  
  @Test
//CREATE PROFILE WITH ALL VALID FIELDS
public void validAllCreateProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata("CreateProfile", 16, 1);
	  String dob=ExcelUtilities.getcelldata("CreateProfile", 17, 1);
	  String gender=ExcelUtilities.getcelldata("CreateProfile", 18, 1);
	  String email=ExcelUtilities.getcelldata("CreateProfile", 19, 1);
	  String phone=ExcelUtilities.getcelldata("CreateProfile", 20, 1);
	  String schoolstrm=ExcelUtilities.getcelldata("CreateProfile", 21, 1);
	  String percentage=ExcelUtilities.getcelldata("CreateProfile", 22, 1);
	  String school=ExcelUtilities.getcelldata("CreateProfile", 23, 1);
 	  String year=ExcelUtilities.getcelldata("CreateProfile", 24, 1);
 	  String higersec=ExcelUtilities.getcelldata("CreateProfile", 25, 1);
 	  String higersecPercentage=ExcelUtilities.getcelldata("CreateProfile", 26, 1);
 	  String higersecSchool=ExcelUtilities.getcelldata("CreateProfile", 27, 1);
 	  String higersecYear=ExcelUtilities.getcelldata("CreateProfile", 28, 1);
 	  String graduation=ExcelUtilities.getcelldata("CreateProfile", 29, 1);
 	  String gradStream=ExcelUtilities.getcelldata("CreateProfile", 30, 1);
 	  String gradPercentage=ExcelUtilities.getcelldata("CreateProfile", 31, 1);
 	  String gradInstitute=ExcelUtilities.getcelldata("CreateProfile", 32, 1);
 	  String gradYear=ExcelUtilities.getcelldata("CreateProfile", 33, 1);
  	  String project=ExcelUtilities.getcelldata("CreateProfile", 39, 1);
 	  String projectDesc=ExcelUtilities.getcelldata("CreateProfile", 40, 1);
 	  String additionalCourse=ExcelUtilities.getcelldata("CreateProfile", 41, 1);
 	  String courseName=ExcelUtilities.getcelldata("CreateProfile", 42, 1);
 	  String coursePercentage=ExcelUtilities.getcelldata("CreateProfile", 43, 1);
 	  String jobTitle=ExcelUtilities.getcelldata("CreateProfile", 44, 1);
 	  String from=ExcelUtilities.getcelldata("CreateProfile", 45, 1);
 	  String to=ExcelUtilities.getcelldata("CreateProfile", 46, 1);
 	  String skills=ExcelUtilities.getcelldata("CreateProfile", 47, 1);
 	  String lang=ExcelUtilities.getcelldata("CreateProfile", 48, 1);
 	  String programLang=ExcelUtilities.getcelldata("CreateProfile", 49, 1);
 	  String  achievements=ExcelUtilities.getcelldata("CreateProfile", 50, 1);
 	  String describe=ExcelUtilities.getcelldata("CreateProfile", 51, 1);
 	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata("CreateProfile", 52, 1);
 	   logIn();
	  dcrtprf.clickMyProfile();
 	  dcrtprf.clickCrtProfile();
 	  dcrtprf.setPersonalDetails(name,dob,gender,email,phone);
 	  dcrtprf.setSchoolDetails(schoolstrm, percentage, school, year);
 	  dcrtprf.setHigherSecondaryDetails(higersec,higersecPercentage,higersecSchool,higersecYear);
 	  dcrtprf.setGraduationDetails(graduation,gradStream,gradPercentage,gradInstitute,gradYear);
	  dcrtprf.setProjectDetails(project,projectDesc);
	  Thread.sleep(500);
	  dcrtprf.setSkills(skills);
	  Thread.sleep(500);
 	  dcrtprf.setLanguage(lang);
 	  dcrtprf.setAchievements(achievements);
 	  dcrtprf.setDescribe(describe);
 	  dcrtprf.setImage(img);
 	  dcrtprf.acceptCheck();
 	  String actual=dcrtprf.clickCreateProfile();
	  String expected="Profile created";
	  Assert.assertEquals(actual, expected);
	 
 	 
}
 @Test
//EDIT PROFILE WITH ALL VALID MANDATORY FIELDS
public void validEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata("EditProfile", 1, 1);
	  String dob=ExcelUtilities.getcelldata("EditProfile", 2, 1);
	  String gender=ExcelUtilities.getcelldata("EditProfile", 3, 1);
	  String email=ExcelUtilities.getcelldata("EditProfile", 4, 1);
	  String phone=ExcelUtilities.getcelldata("EditProfile", 5, 1);
	  String schoolstrm=ExcelUtilities.getcelldata("EditProfile", 6, 1);
	  String percentage=ExcelUtilities.getcelldata("EditProfile", 7, 1);
	  String school=ExcelUtilities.getcelldata("EditProfile", 8, 1);
	  String year=ExcelUtilities.getcelldata("EditProfile", 9, 1);
	  String skills=ExcelUtilities.getcelldata("EditProfile", 10, 1);
	  String lang=ExcelUtilities.getcelldata("EditProfile", 11, 1);
	  String describe=ExcelUtilities.getcelldata("EditProfile", 12, 1);
	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata("EditProfile", 13, 1);
	  logIn();
	  dedtprf.clickMyProfile();
    dedtprf.clickEdtProfileBtn();
	   dedtprf.setPersonalDetails(name, dob, gender, email, phone);
	  dedtprf.setSchoolDetails(schoolstrm, percentage, school, year);
	  dedtprf.setSkills(skills);
	  dedtprf.setLanguage(lang);
	  dedtprf.setDescribe(describe);
	  dedtprf.setImage(img);
	  dedtprf.acceptCheck();
	  String actual=dedtprf.clickUpdateProfile();
	  String expected="Profile Updated";
	  Assert.assertEquals(actual, expected);
}




@Test
//EDIT PROFILE WITH INVALID FIELDS
public void invalidEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata("EditProfile", 1, 2);                
	  String dob=ExcelUtilities.getcelldata("EditProfile", 2, 2);
	  String gender=ExcelUtilities.getcelldata("EditProfile", 3, 2);
	  String email=ExcelUtilities.getcelldata("EditProfile", 4, 2);
	  String phone=ExcelUtilities.getcelldata("EditProfile", 5, 2);
	  String schoolstrm=ExcelUtilities.getcelldata("EditProfile", 6, 2);
	  String percentage=ExcelUtilities.getcelldata("EditProfile", 7, 2);
	  String school=ExcelUtilities.getcelldata("EditProfile", 8, 2);
	  String year=ExcelUtilities.getcelldata("EditProfile", 9, 2);
	  String skills=ExcelUtilities.getcelldata("EditProfile", 10, 2);
	  String lang=ExcelUtilities.getcelldata("EditProfile", 11, 2);
	  String describe=ExcelUtilities.getcelldata("EditProfile", 12, 2);
	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata("EditProfile", 13, 2);
	  logIn();
	  dedtprf.clickMyProfile();
	  dedtprf.clickEdtProfileBtn();
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
	  String actual= dedtprf.clickUpdateProfile();
    String expected ="Enter valid data";
	  Assert.assertEquals(actual,expected);
}

@Test
//EDIT PROFILE WITH ALL VALID FIELDS
public void validAllEditProfile() throws IOException, InterruptedException
{
	  
	  String name=ExcelUtilities.getcelldata("EditProfile", 16, 1);
	  String dob=ExcelUtilities.getcelldata("EditProfile", 17, 1);
	  String gender=ExcelUtilities.getcelldata("EditProfile", 18, 1);
	  String email=ExcelUtilities.getcelldata("EditProfile", 19, 1);
	  String phone=ExcelUtilities.getcelldata("EditProfile", 20, 1);
	  String schoolstrm=ExcelUtilities.getcelldata("EditProfile", 21, 1);
	  String percentage=ExcelUtilities.getcelldata("EditProfile", 22, 1);
	  String school=ExcelUtilities.getcelldata("EditProfile", 23, 1);
	  String year=ExcelUtilities.getcelldata("EditProfile", 24, 1);
	  String higersec=ExcelUtilities.getcelldata("EditProfile", 25, 1);
	  String higersecPercentage=ExcelUtilities.getcelldata("EditProfile", 26, 1);
	  String higersecSchool=ExcelUtilities.getcelldata("EditProfile", 27, 1);
	  String higersecYear=ExcelUtilities.getcelldata("EditProfile", 28, 1);
	  String graduation=ExcelUtilities.getcelldata("EditProfile", 29, 1);
	  String gradStream=ExcelUtilities.getcelldata("EditProfile", 30, 1);
	  String gradPercentage=ExcelUtilities.getcelldata("EditProfile", 31, 1);
	  String gradInstitute=ExcelUtilities.getcelldata("EditProfile", 32, 1);
	  String gradYear=ExcelUtilities.getcelldata("EditProfile", 33, 1);
	  String postgrad=ExcelUtilities.getcelldata("EditProfile", 34, 1);
	  String postgradStream=ExcelUtilities.getcelldata("EditProfile", 35, 1);
	  String postgradPercentage=ExcelUtilities.getcelldata("EditProfile", 36, 1);
	  String postgradInstitute=ExcelUtilities.getcelldata("EditProfile", 37, 1);
	  String postgradYear=ExcelUtilities.getcelldata("EditProfile", 38, 1);
	  String project=ExcelUtilities.getcelldata("EditProfile", 39, 1);
	  String projectDesc=ExcelUtilities.getcelldata("EditProfile", 40, 1);
	  String additionalCourse=ExcelUtilities.getcelldata("EditProfile", 41, 1);
	  String courseName=ExcelUtilities.getcelldata("EditProfile", 42, 1);
	  String coursePercentage=ExcelUtilities.getcelldata("EditProfile", 43, 1);
	  String jobTitle=ExcelUtilities.getcelldata("EditProfile", 44, 1);
	  String from=ExcelUtilities.getcelldata("EditProfile", 45, 1);
	  String to=ExcelUtilities.getcelldata("EditProfile", 46, 1);
	  String skills=ExcelUtilities.getcelldata("EditProfile", 47, 1);
	  String lang=ExcelUtilities.getcelldata("EditProfile", 48, 1);
	  String programLang=ExcelUtilities.getcelldata("EditProfile", 49, 1);
	  String  achievements=ExcelUtilities.getcelldata("EditProfile", 50, 1);
	  String describe=ExcelUtilities.getcelldata("EditProfile", 51, 1);
	  String img=System.getProperty("user.dir")+"\\"+ExcelUtilities.getcelldata("EditProfile", 52, 1);
	  logIn();
	  dedtprf.clickMyProfile();
	  dedtprf.clickEdtProfileBtn();
	  dedtprf.setPersonalDetails(name,dob,gender,email,phone);
	  dedtprf.setSchoolDetails(schoolstrm, percentage, school, year);
	  dedtprf.setHigherSecondaryDetails(higersec,higersecPercentage,higersecSchool,higersecYear);
	  dedtprf.setGraduationDetails(graduation,gradStream,gradPercentage,gradInstitute,gradYear);
	  dedtprf.setProjectDetails(project,projectDesc);
	  Thread.sleep(500);
	  dedtprf.setSkills(skills);
	  Thread.sleep(500);
	  dedtprf.setLanguage(lang);
	  dedtprf.setAchievements(achievements);
	  dedtprf.setDescribe(describe);
	  dedtprf.setImage(img);
	  dedtprf.acceptCheck();
	  String actual=dedtprf.clickUpdateProfile();
	  String expected="Profile Updated";
	  Assert.assertEquals(actual, expected);
	  
}


@Test
//DOWNLOAD TEMPLATE1
public void downloadTemplate1() throws IOException, InterruptedException
{
	  
	  logIn();
	  drbdwnld.clickTemplateBtn();
	  Thread.sleep(500);
	  drbdwnld.clickTemplate1();
	  Thread.sleep(1000);
	  drbdwnld.clickDownloadResume1();
	  String expected="Download Started";
	  String actual=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  assertTrue(actual.equals(expected));
	
}
@Test
//DOWNLOAD TEMPLATE2
public void downloadTemplate2() throws IOException, InterruptedException
{
	  logIn();
	  drbdwnld.clickTemplateBtn();
	  Thread.sleep(500);
	  drbdwnld.clickTemplate2();
	  Thread.sleep(1000);
	  drbdwnld.clickDownloadResume2();
	  String expected="Download started";
	  String actual=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  assertTrue(actual.equals(expected));
	 
}

@Test
//DOWNLOAD TEMPLATE3
public void downloadTemplate3() throws IOException, InterruptedException
{
	  logIn();
	  drbdwnld.clickTemplateBtn();
	  Thread.sleep(500);
	  drbdwnld.clickTemplate3();
	  Thread.sleep(1000);
	  drbdwnld.clickDownloadResume3();
    String expected="Download Started";
	  String actual=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  assertTrue(actual.equals(expected));
}

	

  @Test
  //DELETE PROFILE
  public void deleteProfile() throws IOException, InterruptedException
  {
	 logIn();
     String actual= drbdlt.deleteProfile();
     String expected="Are you sure ,you want to delete your profile?";
     Assert.assertEquals(actual, expected);
	  
  }

  @Test
  //LOGOUT
  public void logOut() throws IOException, InterruptedException
  {
	  logIn();
	  Thread.sleep(1000);
	  dlout.clickLogout();
	  boolean valid=dlout.isValid();
	  Assert.assertTrue(valid);
  }
}

