package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	public NavPage (WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getHomeLink() {
		return this.driver.findElement(By.xpath("//a[@href='/']"));
	}
	
	public WebElement getAboutLink() {
		return this.driver.findElement(By.xpath("//a[@href='/about']"));
	}
	
	public WebElement getProfileLink() {
		return this.driver.findElement(By.xpath("//a[@href='/profile']"));
	}
	
	public WebElement getAdminBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class,'btnAdmin')]"));
	}
	
	public WebElement getCitiesLink() {
		return this.driver.findElement(By.xpath("//a[@href='/admin/cities']"));
	}
	
	public WebElement getUsersLink() {
		return this.driver.findElement(By.xpath("//a[@href='/admin/users']"));
	}
	
	public WebElement getSignUpBtn() {
		return this.driver.findElement(By.xpath("//a[@href='/signup']"));
	}
	
	public WebElement getLoginBtn() {
		return this.driver.findElement(By.xpath("//a[@href='/login']"));
	}
	
	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
	}
	
	public WebElement getLanguageBtn() {
		return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
	}
	
	public WebElement getEnLanguageBtn() {
		return this.driver.findElement(By.xpath("//div[text()='EN']"));
	}
	
	public WebElement getEsLanguageBtn() {
		return this.driver.findElement(By.xpath("//div[text()='FR']"));
	}
	
	public WebElement getFrLanguageBtn() {
		return this.driver.findElement(By.xpath("//div[text()='CN']"));
	}
	
	public WebElement getCnLanguageBtn() {
		return this.driver.findElement(By.xpath("//div[text()='UA']"));
	}
	
	public WebElement getUaLanguageBtn() {
		return this.driver.findElement(By.id("//*[@id='list-item-88']"));
	}
	
}
