package com.tibco.ebx.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tibco.ebx.driver.DriverInitialization;
import com.tibco.ebx.framework.CommonMethods;
import com.tibco.ebx.pageClasses.CredentialsPage;
import com.tibco.ebx.pageClasses.FacilitiesPerspectiveHomePage;
import com.tibco.ebx.pageClasses.HomePage;
import com.tibco.ebx.pageClasses.LoginPage;
import com.tibco.ebx.pageClasses.pgSite_Perspective;

public class Site_Search_SLP_PDI extends DriverInitialization {

	//pgSite_Perspective siteps = new pgSite_Perspective();
	
	@Test(enabled = true, priority = 2, description = "This is to Validate the search functionality")
	public void searchfieldValidation() throws InterruptedException {
		
		CommonMethods.launchAzureURL();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		CredentialsPage credentialsPage = new CredentialsPage();
		FacilitiesPerspectiveHomePage fphp = new FacilitiesPerspectiveHomePage();
		pgSite_Perspective siteps = new pgSite_Perspective();
		credentialsPage.enterUserName();
		credentialsPage.clickOnNextButton();
		credentialsPage.enterPassword();
		credentialsPage.clickOnSignIn();
		credentialsPage.clickOnStaySignIn();
		Thread.sleep(5000);
		credentialsPage.enableSite_reader_Link();
		credentialsPage.clickOnSite_ReaderLink();
		Thread.sleep(5000);
		credentialsPage.selectVersion();
		String secretKey=credentialsPage.getUserName();
		credentialsPage.clickOnShowSecretValue();
		String secretValue=credentialsPage.getSecretValue();

		
		CommonMethods.launchURL();
		loginPage.enterUserName(secretKey);
		loginPage.clickOnNextButton();
		loginPage.enterPassword(secretValue);
		loginPage.clickOnSigninButton();
		homePage.clickOnTibcoUAT();
		CommonMethods.switchWindow();	
		fphp.getTile();
	
		Thread.sleep(10000);
		

		fphp.clickOnSitePerspectiveIcon();
		fphp.clickOnSelectSitePerspectiveIcon();
		fphp.clickOnAllSites();
		Thread.sleep(10000);
		fphp.clickOnSitesOption();
		Thread.sleep(10000);
		siteps.searchval();
		siteps.openStatus();
		siteps.closeStatus();
	
	}
	
}