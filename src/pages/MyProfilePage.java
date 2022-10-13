package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MyProfilePage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getEmailInput() {
		return this.driver.findElement(By.name("email"));
	}
	
	public WebElement getNameInput() {
		return this.driver.findElement(By.xpath("//input[@name='name']"));
	}
	
	public WebElement getPhoneInput() {
		return this.driver.findElement(By.id("phone"));
	}
	
	public WebElement getCityInput() {
		return this.driver.findElement(By.id("city"));
	}
	
	public WebElement getCountryInput() {
		return this.driver.findElement(By.id("country"));
	}
	
	public WebElement getTwitterInput() {
		return this.driver.findElement(By.id("urlTwitter"));
	}
	
	public WebElement getGitHubInput() {
		return this.driver.findElement(By.id("urlGitHub"));
	}
	
	public WebElement getSaveBtn() {
		return this.driver.findElement(By.xpath("//button[@type='submit']"));
	}
}
