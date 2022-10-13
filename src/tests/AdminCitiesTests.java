package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
	
	@Test(priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
		String adminEmail = "admin@admin.com";
		String adminPassword = "12345";
		
		navPage.getLoginBtn().click();
		loginPage.getEmailInput().sendKeys(adminEmail);
		loginPage.getPasswordInput().sendKeys(adminPassword);
		loginPage.getLoginButton().click();
		
		navPage.getAdminBtn().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"), "URL should countain '/admin/cities'");
	}
	
	@Test(priority = 20)
	public void checksInputTypesForCrediteEditNewCity() {
		navPage.getAdminBtn().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForNewEditDialogToBeVisible();
		
		Assert.assertEquals(citiesPage.getNewEditDialogInput().getAttribute("type"), ("text"), "Dialog input should be type text");	
	}
	
	@Test(priority = 30)
	public void createNewCity() throws InterruptedException {
		String city = "Svetolik Kljajic's city";
		navPage.getAdminBtn().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForNewEditDialogToBeVisible();
		citiesPage.getNewEditDialogInput().sendKeys(city);
		citiesPage.getNewEditDialogSaveBtn().click();
		
		messagePopUpPage.waitForPopUpToBeDisplayed();
		Assert.assertTrue(messagePopUpPage.getElementWithNewEditPopUpMessage().getText().contains("Saved successfully"), "Pop up message "
				+ "should be 'Saved successfully'");
	}
	
	@Test(priority = 40)
	public void editCity() throws InterruptedException {
		String oldCityName = "Svetolik Kljajic's city";
		String newCityName = "Svetolik Kljajic's city Edited";
		
		navPage.getAdminBtn().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getSearchInput().sendKeys(oldCityName);
		citiesPage.waitForTableRowsToBe(1);
		citiesPage.getEditBtnByRow(1).click();
		
		citiesPage.getNewEditDialogInput().sendKeys(Keys.CONTROL + "a");
		citiesPage.getNewEditDialogInput().sendKeys(Keys.DELETE);
		
		citiesPage.getNewEditDialogInput().sendKeys(newCityName);
		citiesPage.getNewEditDialogSaveBtn().click();
		
		messagePopUpPage.waitForPopUpToBeDisplayed();
		Assert.assertTrue(messagePopUpPage.getElementWithNewEditPopUpMessage().getText().contains("Saved successfully"), "Pop up message "
				+ "should be 'Saved successfully'");
	}
	
	@Test(priority = 50)
	public void searchCity() {
		String cityName = "Svetolik Kljajic's city Edited";
		navPage.getAdminBtn().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getSearchInput().sendKeys(cityName);
		citiesPage.waitForTableRowsToBe(1);
		
		Assert.assertEquals(citiesPage.getCell(1, 2).getText(), cityName);
	}
	
	@Test(priority = 60)
	public void deleteCity() {
		String cityName = "Svetolik Kljajic's city Edited";
		navPage.getAdminBtn().click();
		new Actions(driver).moveToElement(navPage.getCitiesLink()).click().perform();
		citiesPage.getSearchInput().sendKeys(cityName);
		citiesPage.waitForTableRowsToBe(1);
		
		Assert.assertEquals(citiesPage.getCell(1, 2).getText(), cityName);
		
		citiesPage.getDeleteBtnByRow(1).click();
		messagePopUpPage.waitForWarningPopUp();
		
		citiesPage.getDeleteDialogDeleteBtn().click();
		Assert.assertTrue(messagePopUpPage.getSuccessfullyDeletedPopUp().getText().contains("Deleted successfully"), "Pop up message shoud "
				+ "countain 'Deleted successfully'");
		
	}

}
