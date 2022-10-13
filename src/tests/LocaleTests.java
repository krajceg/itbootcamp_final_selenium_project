package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
	
	@Test(priority = 10)
	public void setLocaleToES() {
		navPage.getLanguageBtn().click();
		new Actions(driver).moveToElement(navPage.getEsLanguageBtn()).click().perform();
		Assert.assertTrue(navPage.getHeaderOne().getText().contains("Página de aterrizaje"), 
				"Header should contain 'Página de aterrizaje'");
	}
	
	@Test(priority = 20)
	public void setLocaleToEn() {
		navPage.getLanguageBtn().click();
		new Actions(driver).moveToElement(navPage.getEnLanguageBtn()).click().perform();
		Assert.assertTrue(navPage.getHeaderOne().getText().contains("Landing"), 
				"Header should contain 'Landing'");	
	}
	
	@Test(priority = 30)
	public void setLocaleToCn() {
		navPage.getLanguageBtn().click();
		new Actions(driver).moveToElement(navPage.getCnLanguageBtn()).click().perform();
		Assert.assertTrue(navPage.getHeaderOne().getText().contains("首页"), 
				"Header should contain '首页'");	
	}
	
	@Test(priority = 40)
	public void setLocaleToFr() {
		navPage.getLanguageBtn().click();
		new Actions(driver).moveToElement(navPage.getFrLanguageBtn()).click().perform();
		Assert.assertTrue(navPage.getHeaderOne().getText().contains("Page d'atterrissage"), 
				"Header should contain 'Page d'atterrissage'");	
	}
}
