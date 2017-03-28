package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.By;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.GetStartedPage;
import pages.acquisition.ulayer.AddDrugPage;
import atdd.framework.UhcDriver;


public class GetStartedPage extends UhcDriver {
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;
	
	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[4]/div/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr/td[3]/div/div[2]/div/div/p/a")
	WebElement enterDrugLink;
	
	@FindBy(xpath="//iframe[@src='/health-plans/dce.html#/estimate-drug-costs']")
	WebElement dceToolFrame;

	public GetStartedPage(WebDriver driver) {
		 super(driver);
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

	@Override
	public void openAndValidate() {
		validate(getStartedLink);
		
	}
	
	public AddDrugPage navigateToDCE(){
		enterDrugLink.click();
		getStartedLink.click();
		return new AddDrugPage(driver);
		
	}
		  
	public AddDrugPage clicksOnGetStarted() {
		driver.switchTo().frame(dceToolFrame);
		getStartedLink.click();
		return new AddDrugPage(driver);
	}	 

}
