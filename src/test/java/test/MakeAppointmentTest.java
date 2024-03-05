package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AppointmentPage;
import pageObjects.LoginPage;
import resources.Base;
import utilities.CalendarUtil;
import utilities.Util;

public class MakeAppointmentTest extends Base {

	public static WebDriver driver;
	Logger log;

	@BeforeMethod
	public void LaunchBrowser() throws Exception {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "CredentialsSupplierFirstRow", dataProviderClass = Util.class)
	public void loginTest(String username, String password) throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.username().sendKeys(username);
		loginpage.password().sendKeys(password);
		loginpage.loginButton().click();

		AppointmentPage appointmentPage = new AppointmentPage(driver);

		Select dropdown = new Select(appointmentPage.dropDownMenu());
		dropdown.selectByIndex(2);
		Thread.sleep(5000);
		appointmentPage.readmission().click();

		appointmentPage.medicare().click();
		Thread.sleep(5000);
		appointmentPage.medicaid().click();
		Thread.sleep(5000);
		appointmentPage.none().click();
		Thread.sleep(5000);

		CalendarUtil.selectDate("17", "December", "2024", driver);
		
		Thread.sleep(5000);
		appointmentPage.comment().click();
		appointmentPage.comment().sendKeys("This is an automated testing");
		Thread.sleep(3000);
		appointmentPage.bookAppointment().click();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
