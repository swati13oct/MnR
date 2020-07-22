package pages.mobile.acquisition.ulayer;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.ElementData;
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


	@Override
	public void openAndValidate() {
		validate(zipCodeField);
		validate(continueButton);
		
	}
	

}
