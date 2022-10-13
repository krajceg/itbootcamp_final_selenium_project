package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest{
	
	@Test(priority = 10)
	public void visitsTheProfilePage() throws InterruptedException {
		String email = "admin@admin.com";
		String password = "12345";
		
		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		Thread.sleep(1000);
		driver.get(baseUrl + "/profile");	
		Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "URL should contain '/profile'");
		navPage.getLogoutBtn().click();
	}
	
	@Test(priority = 20)
	public void checksInputTypes() throws InterruptedException {
		String email = "admin@admin.com";
		String password = "12345";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String attrDisabled = (String) js.executeScript("return arguments[0].getAttribute('disabled');", myProfilePage.getEmailInput());
		
		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		navPage.getProfileLink().click();
		
		Assert.assertEquals(myProfilePage.getEmailInput().getAttribute("type"), "email", "Email type should be 'email'");
		Assert.assertEquals(attrDisabled, "disabled");
		
		Assert.assertEquals(myProfilePage.getNameInput().getAttribute("type"), "text", "Name type should be 'text'");
		Assert.assertEquals(myProfilePage.getCityInput().getAttribute("type"), "text", "City type should be 'text'");
		Assert.assertEquals(myProfilePage.getCountryInput().getAttribute("type"), "text", "Country type should be 'text'");
		
		Assert.assertEquals(myProfilePage.getTwitterInput().getAttribute("type"), "url", "Twitter type should be 'url'");
		Assert.assertEquals(myProfilePage.getGitHubInput().getAttribute("type"), "url", "GitHub type should be 'url'");
		
		Assert.assertEquals(myProfilePage.getPhoneInput().getAttribute("type"), "tel",  "Phone type should be 'tel'");
		navPage.getLogoutBtn().click();
	}
	
	@Test(priority = 30)
	public void editsProfile() throws InterruptedException {
		String email = "admin@admin.com";
		String password = "12345";
		String name = "Svetolik Kljajic";
		String phone = "+38161283223";
		String city = "Bucaramanga";
		String country = "Spain";
		String twitter = "https://twitter.com/profile/milan1232";
		String gitHub = "https://github.com/krajceg";
		
		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(email);
		loginPage.getPasswordInput().sendKeys(password);
		loginPage.getLoginButton().click();
		navPage.getProfileLink().click();
		
		Thread.sleep(1000);
		myProfilePage.getNameInput().sendKeys(Keys.CONTROL + "a");
		myProfilePage.getNameInput().sendKeys(Keys.DELETE);
		myProfilePage.getNameInput().sendKeys(name);
		
		myProfilePage.getPhoneInput().sendKeys(Keys.CONTROL + "a");
		myProfilePage.getPhoneInput().sendKeys(Keys.DELETE);
		myProfilePage.getPhoneInput().sendKeys(phone);
		
		myProfilePage.getCityInput().sendKeys(Keys.CONTROL + "a");
		myProfilePage.getCityInput().sendKeys(Keys.DELETE);
		myProfilePage.getCityInput().sendKeys(city);
		myProfilePage.getCityInput().sendKeys(Keys.ENTER);
		
		myProfilePage.getCountryInput().sendKeys(Keys.CONTROL + "a");
		myProfilePage.getCountryInput().sendKeys(Keys.DELETE);
		myProfilePage.getCountryInput().sendKeys(country);
		
		myProfilePage.getTwitterInput().sendKeys(Keys.CONTROL + "a");
		myProfilePage.getTwitterInput().sendKeys(Keys.DELETE);
		myProfilePage.getTwitterInput().sendKeys(twitter);
		
		myProfilePage.getGitHubInput().sendKeys(Keys.CONTROL + "a");
		myProfilePage.getGitHubInput().sendKeys(Keys.DELETE);
		myProfilePage.getGitHubInput().sendKeys(gitHub);
		
		Thread.sleep(1500);
		myProfilePage.getSaveBtn().click();
		Thread.sleep(1000);
		Assert.assertTrue(messagePopUpPage.getSuccessfullySavedPopUp().isDisplayed(), "Successfully saved changes pop up should be visible");
		Assert.assertTrue(messagePopUpPage.getSuccessfullySavedPopUp().getText().contains("Profile saved successfuly"), "Profile saved "
				+ "successfully");
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getEmailInput());
		String nameValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getNameInput());
		String phoneValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getPhoneInput());
		String cityValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getCityInput());
		String countryValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getCountryInput());
		String twitterValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getTwitterInput());
		String gitHubValue = (String) js.executeScript("return arguments[0].value;", myProfilePage.getGitHubInput());

		Assert.assertEquals(emailValue, email);
		Assert.assertEquals(nameValue, name);
		Assert.assertEquals(phoneValue, phone);
		Assert.assertEquals(cityValue, city);
		Assert.assertEquals(countryValue, country);
		Assert.assertEquals(twitterValue, twitter);
		Assert.assertEquals(gitHubValue, gitHub);
		
		Thread.sleep(2000);
	}
}
