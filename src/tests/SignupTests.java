package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
	
	@Test(priority = 10)
	public void visitsTheSignupPage() {
		navPage.getSignUpBtn().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL should countain '/signup'");
	}
	
	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSignUpBtn().click();
		Assert.assertEquals(signupPage.getNameInput().getAttribute("type"), ("text"), "Name input should be type 'text'");
		Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), ("email"), "Email input should be type 'email'");
		Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), ("password"), "Password input should be type 'password'");
		Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), ("password"), "Confirm password input should be type "
				+ "'password'");
	}
	
	@Test(priority = 30)
	public void displaysErrorsWhenUserAlreadyExists() {
		String name = "Another User";
		String email = "admin@admin.com";
		String password = "12345";
		String confirmPassword = "12345";
		
		navPage.getSignUpBtn().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL should countain '/signup'");
		
		signupPage.getNameInput().sendKeys(name);
		signupPage.getEmailInput().sendKeys(email);
		signupPage.getPasswordInput().sendKeys(password);
		signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
		signupPage.getSignMeUpButton().click();
		
		messagePopUpPage.waitForUserPopUpToBeVisible();
		Assert.assertTrue(messagePopUpPage.getElementWithTextMessage().getText().contains("E-mail already exists"), "Status message should be "
				+ "'E-mail already exists'");
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL should countain '/signup'");	
	}
	
	@Test(priority = 40)
	public void signup() throws InterruptedException {
		String name = "Svetolik Kljajic";
		String email = "svetolik.kljajic@itbootcamp.rs";
		String password = "12345";
		String confirmPassword = "12345";
		
		navPage.getSignUpBtn().click();
		
		signupPage.getNameInput().sendKeys(name);
		signupPage.getEmailInput().sendKeys(email);
		signupPage.getPasswordInput().sendKeys(password);
		signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
		signupPage.getSignMeUpButton().click();
		driver.get(baseUrl + "/home");
		Assert.assertTrue(messagePopUpPage.getElementWithVerifyAccountMessage().getText().contains("IMPORTANT: Verify your account"), "Status message "
				+ "should be 'IMPORTANT: Verify your account'");
		
		messagePopUpPage.getPopUpCloseBtn().click();
		navPage.getLogoutBtn().click();
	}
	
}
