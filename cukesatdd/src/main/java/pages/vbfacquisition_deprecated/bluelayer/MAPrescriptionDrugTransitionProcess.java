package pages.vbfacquisition_deprecated.bluelayer;

/*@author snagpa4*/

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.vbfacquisition_deprecated.uhcretiree.Rallytool_Page;

public class MAPrescriptionDrugTransitionProcess extends GlobalWebElements {
	
	@Override
	public void openAndValidate() {
		start(MA_PLAN_PRES_DRUGS_TRANSITION_PLANS_PAGE_URL);
		

	}

	
	private static String MA_PLAN_PRES_DRUGS_TRANSITION_PLANS_PAGE_URL = MRConstants.MA_PLAN_PRES_DRUGS_TRANSITION_PLANS_PAGE_URL;
	
	
	@FindBy(xpath="//*[@id='PO7link']")
	private WebElement providerlink;

	public MAPrescriptionDrugTransitionProcess(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}



	public Rallytool_Page MAPlanInformationproviderclick() {
		
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