package pages.acquisition.ulayer;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.ElementData;
import atdd.framework.UhcDriver;

public class LocationSearchPage extends UhcDriver{
	
	@FindBy(className = "ZIPCodeBox")
	WebElement zipCodeField;

	@FindBy(linkText = "Continue")
	WebElement continueButton;

	public LocationSearchPage(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       openAndValidate();
	}

	public AddDrugPage enterLocation(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		if(null!=planYear)
		{
			ElementData elementData = new ElementData("xpath","//div[@class='marginBottom25']//span[.='"+planYear+"']");
			findElement(elementData).click();
		}
		continueButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	

}
