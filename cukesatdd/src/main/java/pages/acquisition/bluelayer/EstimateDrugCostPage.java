package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EstimateDrugCostPage {
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;

	private WebDriver driver;

	public EstimateDrugCostPage(WebDriver driver) {
		 this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	}

	public EnterZipCodePage getStarted() {
		getStartedLink.click();
		if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®"))
		{
			return new EnterZipCodePage(driver);
		}
		else
			return null;
		
	}

}
