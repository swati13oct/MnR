package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.acquisition.uhcretiree.Rallytool_Page;

public class MAPlansAndGrievances extends GlobalWebElements {
	
	@Override
	public void openAndValidate() {
		start(MA_PLANS_AND_GRIEVANCES);
		

	}

	
	private static String MA_PLANS_AND_GRIEVANCES = MRConstants.MA_PLANS_AND_GRIEVANCES_URL;
	
	
	@FindBy(xpath="//*[@id='PO7link']")
	private WebElement providerlink;

	public MAPlansAndGrievances(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	public Rallytool_Page MAproviderclick() {
		
		validate(providerlink);
		
		providerlink.click();
		
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			if (getTitle().equalsIgnoreCase(
					"Enter Zip")) {
		return new Rallytool_Page(driver);
		}
	
		// TODO Auto-generated method stub
		return null;
	}
	
}