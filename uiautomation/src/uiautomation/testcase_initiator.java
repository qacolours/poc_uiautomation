package uiautomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testcase_initiator {
	
	static ExtentReports reports;
	static ExtentTest ex_test;
	Properties oprop;
	InputStream inputstrm;
	OutputStream outputstrm;
	
	utility_functions oUF = new utility_functions();
	
	@BeforeClass
	public void start_test() throws Exception {
		reports = new ExtentReports(oUF.getProperty("extent_report_path"), true);
		ex_test = reports.startTest("TestCase_Login");
	}
	
	@Test
	public void first_tc() throws Exception {
		WebDriver driver;
		
		Logger log = Logger.getLogger(login_page.class.getName());
		PropertyConfigurator.configure(oUF.getProperty("log4j_properties_file"));
		
		log.info("Test execution started");
		ex_test.log(LogStatus.PASS, "Test execution started");
		
		//oUF.setProperty("browser","chrome");
		//System.setProperty("webdriver.chrome.driver", oUF.getProperty("chromedriverpath"));
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		log.info("Chrome has been launched successfully");
		ex_test.log(LogStatus.PASS, "Chrome has been launched successfully");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.phptravels.net/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000));
		
		log.info("Browser navigated to https://www.phptravels.net/login page");
		ex_test.log(LogStatus.PASS, "Browser navigated to https://www.phptravels.net/login page");
		
		login_page o_login = new login_page(driver);
		
		o_login.loginToApplication(driver,log,ex_test);
		o_login.closeApplication(driver, log,ex_test);
	}
	
	@AfterClass
	public void end_test() throws Exception {
		reports.endTest(ex_test);
		reports.flush();
	}
	
}
