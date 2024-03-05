package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AppointmentPage;
import pageObjects.LoginPage;
import resources.Base;
import utilities.Util;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	
	@BeforeMethod
	public void LaunchBrowser()throws Exception {
		driver= initializeBrowser();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider = "CredentialsSupplier", dataProviderClass = Util.class)
    public void loginTest(String username,String password) {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.username().sendKeys(username);
		loginpage.password().sendKeys(password);
		loginpage.loginButton().click();
		
		AppointmentPage appointmentPage=new AppointmentPage(driver);
		
		String actualResult=null;
		String expectedResult="SuccessFull";
		try {
			if (appointmentPage.appointment().isDisplayed()) {
				log.debug("User got logged in");
				actualResult = "SuccessFull";
				System.out.println("Successfull");
			}
			

		} catch (Exception e) {
			log.debug("User didn't log in");
			actualResult = "failure";
			System.out.println("Failure");

		}
         
		if(actualResult.equals(expectedResult)) {
			
			log.info("Login Test got passed");
        	 System.out.println("Login Test got passed");
			
		}else {
			
			log.error("Login Test got failed");
			System.out.println("Login Test got failed");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
    	
    }


