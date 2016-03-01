package pages.acquisition.ulayer;

/*@author pagarwa5*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class LocationSearchPage extends UhcDriver{
	
	@FindBy(name = "zipcode")
	WebElement zipCodeField;

	@FindBy(linkText = "Continue")
	WebElement continueButton;
	
	/*@FindBy(xpath = "//div[@id='counties']//span[.='Continue']")
	WebElement countyContinueButton;*/

	public LocationSearchPage(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       openAndValidate();
	}

	public AddDrugPage enterLocation(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		if(null!=planYear)
		{
			String planYearXpath = "//div[@class='marginBottom25']//span[.='"+planYear+"']";
			driver.findElement(By.xpath(planYearXpath)).click();
			System.out.println("year");
		}
		continueButton.click();
		
		if(currentUrl().contains("drugSearch"))
		{
			return new AddDrugPage(driver);
		}
		else if(currentUrl().contains("enterZipCode"))
		{
			CountySelectionPage countySelectionPage = new CountySelectionPage(driver);
			AddDrugPage addDrugPage = countySelectionPage.selectCounty(county);
			return addDrugPage;
		}
		
		return null;
		
	}

	@Override
	public void openAndValidate() {
		validate(zipCodeField);
		validate(continueButton);
		
	}
	
	
	/*
	 * TODO: CodeMonkeys Team: Please check if this is required. Because a similar method is written above that does the same.
	 * 
	 * The method is using selenium operation for which we consume the wrapper methods written in UhcDriver
	 * 
	 * 
	 * */
	
	public AddDrugPage enterLoc(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		if(null!=planYear)
		{
			String planYearXpath = "//div[@class='marginBottom25']//span[.='"+planYear+"']";
			driver.findElement(By.xpath(planYearXpath)).click();
			System.out.println("year");
		}
		continueButton.click();
		
		if(currentUrl().contains("drugSearch"))
		{
			return new AddDrugPage(driver);
		}
		else if(currentUrl().contains("enterZipCode"))
		{
			CountySelectionPage countySelectionPage = new CountySelectionPage(driver);
			AddDrugPage addDrugPage = countySelectionPage.chooseCounty(county);
			return addDrugPage;
		}
		
		return null;
		
	}

}
