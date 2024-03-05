package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AppointmentPage;
import resources.Base;

public class CalendarUtil extends Base {

	public static WebDriver driver;

	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

	public static void selectDate(String exDay, String exMonth, String exYear, WebDriver driver) {

		AppointmentPage appointmentPage = new AppointmentPage(driver);

		appointmentPage.calendar().click();

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-switch")));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By) appointmentPage.currentDate()));

		if (exMonth.equalsIgnoreCase("February") && Integer.parseInt(exDay) > 29) {
			System.out.println("The entered date is wrong " + exDay + ":" + exMonth + ":" + exYear);
			return;
		}
		if (Integer.parseInt(exDay) > 31) {
			System.out.println("The entered date is wrong " + exDay + ":" + exMonth + ":" + exYear);
			return;

		}

		String currentDate = appointmentPage.currentDate().getText();
		while (!(getMonthYear(currentDate)[0].equals(exMonth.trim())
				&& getMonthYear(currentDate)[1].equals(exYear.trim()))) {

			appointmentPage.nextButton().click();
			currentDate = appointmentPage.currentDate().getText();
		}
		try {

			String xpath = appointmentPage.date(exDay);
			driver.findElement(By.xpath(xpath)).click();

		} catch (Exception e) {

		}

	}

}
