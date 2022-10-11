package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SignupPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getNameInput() {
		return this.driver.findElement(By.id("name"));
	}
	
	public WebElement getEmailInput() {
		return this.driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInput() {
		return this.driver.findElement(By.id("password"));
	}
	
	public WebElement getConfirmPasswordInput() {
		return this.driver.findElement(By.id("confirmPassword"));
	}
	
	public WebElement getSignMeUpButton() {
		return this.driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
}
