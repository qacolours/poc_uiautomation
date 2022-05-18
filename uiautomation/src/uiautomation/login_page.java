package uiautomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class login_page {
	
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='contact-form-action']//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
	WebElement login_button;
	
	@FindBy(xpath="//div[@class='author-bio']/h4[@class='author__title']/strong[1]")
	WebElement username;
	
	
	public login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	@Test (priority = 3,enabled = false)
	public void getExcelData() throws Exception {
		
		String ExcelFilePath = "D:/Selenium/WebDriver/AutomatingMakeMyTrip/uiautomation/resources/object_repository/object_repository.xlsx";
		
		File oFile = new File(ExcelFilePath);
		FileInputStream oFileIS = new FileInputStream(oFile);
		Workbook oWB = null;
		
		if (ExcelFilePath.contains(".xls")) {
			oWB = new HSSFWorkbook(oFileIS);
		} else if (ExcelFilePath.contains(".xlsx")) {
			oWB = new XSSFWorkbook(oFileIS);
		} else {
			System.out.println("The file format does not exist");
		}
		
		Sheet oSheet = oWB.getSheet("login_page");
		
		String user_email = oSheet.getRow(1).getCell(0).getStringCellValue();
		String user_password = oSheet.getRow(1).getCell(1).getStringCellValue();
		
		email.sendKeys(user_email);
		password.sendKeys(user_password);
		login_button.click();
		
		oSheet.getRow(1).createCell(2).setCellValue("Passed");
		
		oFileIS.close();
		
		FileOutputStream oFileOS = new FileOutputStream(oFile);
		oWB.write(oFileOS);
		oFileOS.close();
		
	}*/
	
	
	public void loginToApplication(WebDriver driver,Logger log,ExtentTest ex_test) {
		
		email.sendKeys("user@phptravels.com");
		log.info("email provided as user@phptravels.com successfully");
		ex_test.log(LogStatus.PASS, "email provided as user@phptravels.com successfully");
		
		password.sendKeys("demouser");
		log.info("password provided successfully");
		ex_test.log(LogStatus.PASS, "password provided successfully");
		
		login_button.click();
		log.info("Login button clicked successfully");
		ex_test.log(LogStatus.PASS, "Login button clicked successfully");
	}
	
	/*
	@Test (priority = 2,enabled = false)
	public void validateLogin_phptravels(WebDriver driver) throws Exception {
		String s_username = username.getText();
		
		if (s_username.equalsIgnoreCase("Demo")) {
			System.out.println("Validation Passed");
		} else {
			System.out.println("Validation Failed");
		}
	}*/
	
	public void closeApplication(WebDriver driver,Logger log,ExtentTest ex_test) {
		driver.close();
	}

}
