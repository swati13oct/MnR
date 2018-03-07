package pages.deprecated.acquisition.bluelayer;

/*@author snagpa4*/

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.deprecated.acquisition.uhcretiree.Rallytool_Page;

public class OurPlansMAHowToAppointARepresentativePage extends GlobalWebElements {
	
	@Override
	public void openAndValidate() {
		startNew(MA_HOW_TO_APPOINT_REPRESENTIVE_PAGE_URL);
		

	}

	
	private static String MA_HOW_TO_APPOINT_REPRESENTIVE_PAGE_URL = MRConstants.MA_HOW_TO_APPOINT_REPRESENTIVE_PAGE_URL;
	
	
	@FindBy(xpath="//*[@id='PO7link']")
	private WebElement providerlink;

	public OurPlansMAHowToAppointARepresentativePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}



	public Rallytool_Page MAPlanInformationproviderclick() {
		
		validateNew(providerlink);
		
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