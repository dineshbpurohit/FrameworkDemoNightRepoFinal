package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import resources.Base;

public class LoginTest extends Base{
	public WebDriver driver;
	Logger log;
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
	    driver.get(prop.getProperty("Url"));
	    log.debug("Navigated To Application URL");
		
	}
	
	@Test(dataProvider="getLoginData")
	public void login(String username,String password,String expected) throws IOException, InterruptedException
	{
	    //driver = initializeDriver();
		//driver.get(prop.getProperty("Url"));
		
		LandingPage landing = new LandingPage(driver);
		
		landing.myAccount().click();
		log.debug("Click on My Account dropdown");
		landing.loginOption().click();
		log.debug("Click on Login option");
		
		LoginPage loginPage = new LoginPage(driver);
		//loginPage.emailAddress().sendKeys(prop.getProperty("email"));
		loginPage.emailAddress().sendKeys(username);
		//loginPage.password().sendKeys(prop.getProperty("password"));
		log.debug("Entered Email address");
		loginPage.password().sendKeys(password);
		log.debug("Entered Password");
		loginPage.loginButton().click();
		log.debug("Click on Login Button");
		
		
		MyAccountPage map = new MyAccountPage(driver);
		String actual=null;
		//Assert.assertTrue(map.editAccountinfo().isDisplayed());
		//map.editAccountinfo().isDisplayed();
		try{
			if(map.editAccountinfo().isDisplayed())
		   {
			log.debug("Login is Successful");	
			actual="Success";
		   }
		}catch(Exception e)
		{
			log.debug("Login is Failed");
			actual="Failure";
		}
		Assert.assertEquals(actual, expected);
		log.info("Login test got passed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.info("Browser got closed");
	}
   
	@DataProvider
	public Object[][] getLoginData()
	{
	Object[][] data = {{"dinesh@yopmail.com","Welcome@11","Success"},{"phaniatw@gmail.com","atw@123","Failure"}};
	return data;
	}
}
