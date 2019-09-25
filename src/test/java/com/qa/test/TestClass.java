package com.qa.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.OxygenPage;

public class TestClass extends TestBase{
	
	HomePage homePage;
	OxygenPage oxygenPage;
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		homePage =  new HomePage();
		oxygenPage = new OxygenPage();
	}
	
	@Test(priority = 1)
	public void test() {
		delay();
		homePage.verifyExternalLink();
	}
	
	@Test (priority = 2)
	public void test2() throws IOException {
		delay();
		oxygenPage =	homePage.clickOnOxygen();
		oxygenPage.verifyFeaturedArticle();
		oxygenPage.takeScreenShot();
		oxygenPage.getAllReferences();
		oxygenPage.cickOnSearch();
		oxygenPage.enterSearchDetails();
		oxygenPage.selectPlutonium();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
