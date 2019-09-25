package com.qa.pages;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class OxygenPage extends TestBase{
	
	
	@FindBy(id = "searchInput")
	WebElement searchInput;
	
	
	@FindBy(xpath = "//li[@id='cite_note-1']//parent::ol/li")
	WebElement referencesLink;
	
	public OxygenPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyFeaturedArticle() {
	String title = driver.getTitle();
	Assert.assertEquals("Oxygen - Wikipedia", title);
	}
	
	public void takeScreenShot() throws IOException
	{
		WebElement ele = driver.findElement(By.xpath("//table[@class='infobox']//td"));

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("C:\\Users\\raghuveer.mh\\Desktop\\Documents\\GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
	}
	
	public void getAllReferences() {
		List<WebElement> list =driver.findElements(By.xpath("//li[@id='cite_note-1']//parent::ol/li"));	
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
		}
	}
	
	public void cickOnSearch() {
		searchInput.click();
	}
	
	public void enterSearchDetails() {
		System.out.println("**************");
		searchInput.sendKeys("pluto");
		delay();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'suggestions-results']"));
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());		
		}
	}
	
	public void selectPlutonium() {
		delay();
		driver.findElement(By.xpath("//div[@class = 'suggestions-results']//a[@title = 'Plutonium']")).click();
	}
	
	
	

}
