package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[contains(text(), 'External links')]//parent::h2")
	WebElement externalLink;
	
	@FindBy(xpath = "(//div[@class='navbox']//span[contains(text(), 'O')])[1]")
	WebElement oxygenLink;
	
	
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyExternalLink() {
		boolean flag = externalLink.isDisplayed();
		Assert.assertTrue(flag);
	}
	
	public OxygenPage clickOnOxygen() {
		oxygenLink.click();
		return new OxygenPage();
	}
	
	

}
