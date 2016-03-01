package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
public class EstimateDrugCostPage extends UhcDriver {
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;
	
	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[4]/div/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr/td[3]/div/div[2]/div/div/p/a")
	WebElement enterDrugLink;

	public EstimateDrugCostPage(WebDriver driver) {
		super(driver);
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
	
	public AddDrugPage navigateToDCE(){
		enterDrugLink.click();
		getStartedLink.click();
		return new AddDrugPage(driver);
		
	}
	
	@Override
	public void openAndValidate() {
		

	}

}
