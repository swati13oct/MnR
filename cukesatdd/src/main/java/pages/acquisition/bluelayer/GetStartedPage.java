package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;


public class GetStartedPage extends UhcDriver {
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;

	public GetStartedPage(WebDriver driver) {
		 super(driver);
		 switchToNewIframe("dceIframe");
	     PageFactory.initElements(driver, this);
	     openAndValidate();
	}

	public LocationSearchPage getStarted() {
		getStartedLink.click();
		if(currentUrl().contains("enterZipCode"))
		{
			return new LocationSearchPage(driver);
		}
		else
			return null;
		
	}
	
	public AddDrugPage clicksOnGetStarted() {
		getStartedLink.click();
		
		
	
		 if (currentUrl().contains("drugSearch")) {
			return new AddDrugPage(driver);
		}
		return null;
		  

		
		/*if(currentUrl().contains("#/manageDrugList"))
		{
			return new ManageDrugPage(driver);
		}
		else
			return null;*/
		
	}

	@Override
	public void openAndValidate() {
		validate(getStartedLink);
		
	}

}
