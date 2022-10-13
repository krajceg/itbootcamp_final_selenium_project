package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.MyProfilePage;
import pages.NavPage;
import pages.SignupPage;

public abstract class BasicTest {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	
	protected LoginPage loginPage;
	protected NavPage navPage;
	protected SignupPage signupPage;
	protected CitiesPage citiesPage;
	protected MessagePopUpPage messagePopUpPage;
	protected MyProfilePage myProfilePage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		loginPage = new LoginPage (driver, wait);
		navPage = new NavPage (driver, wait);
		signupPage = new SignupPage (driver, wait);
		citiesPage = new CitiesPage (driver, wait);
		messagePopUpPage = new MessagePopUpPage (driver, wait);
		myProfilePage = new MyProfilePage(driver, wait);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot srcShot = ((TakesScreenshot)driver);
			File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("src\\screenshots\\" +
			 result.getName() + ".png");
			FileHandler.copy(srcFile, destFile);
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
