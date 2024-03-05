package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage {
	
	WebDriver driver;
	 public AppointmentPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	
	 @FindBy(xpath="//section[@id='appointment']/div/div/div/h2")
		private WebElement appointment;
	 
	 public WebElement appointment() {
		 return appointment;
	 }
	 @FindBy(id="combo_facility")
		private WebElement dropDownMenu;
	 
	 public WebElement dropDownMenu() {
		 return dropDownMenu;
	 }
	 @FindBy(xpath="//select[@id='combo_facility']/option[2]")
		private WebElement selectOption;
	 
	 public WebElement selectOption() {
		 return selectOption;
	 }
	 @FindBy(xpath="//input[@id='chk_hospotal_readmission']")
		private WebElement readmission;
	 
	 public WebElement readmission() {
		 return readmission;
	 }
	 @FindBy(xpath="//input[@id='radio_program_medicare']")
		private WebElement medicare ;
	 
	 public WebElement medicare() {
		 return medicare;
	 }
	 
	 @FindBy(xpath="//input[@id='radio_program_medicaid']")
		private WebElement medicaid ;
	 
	 public WebElement medicaid() {
		 return medicaid;
	 }
	 
	 @FindBy(xpath="//input[@id='radio_program_none']")
		private WebElement none ;
	 
	 public WebElement none() {
		 return none;
	 }
	 
	 @FindBy(id="txt_visit_date")
		private WebElement calendar ;
	 
	 public WebElement calendar() {
		 return calendar;
	 }
	 
	 @FindBy(className="datepicker-switch")
		private WebElement currentDate ;
	 
	 public WebElement currentDate() {
		 return currentDate;
	 }
	 
	 @FindBy(xpath="//th[@class='next']")
		private WebElement nextButton ;
	 
	 public WebElement nextButton() {
		 return nextButton;
	 }
	 
	 private String expDate="//td[contains(text(),'%replaceable%')]";
	 
	  
	 public String date(String date1) {
		 String newxapth=expDate.replace("%replaceable%", date1);
		 return newxapth;
	 }	 

	 @FindBy(xpath="//button[@id='btn-book-appointment']")
		private WebElement bookAppointment ;
	 
	 public WebElement bookAppointment() {
		 return bookAppointment;
	 }
	 
	 @FindBy(xpath="//textarea[@id='txt_comment']")
		private WebElement comment ;
	 
	 public WebElement comment() {
		 return comment;
	 }
}
