package pages.deprecated.acquisition.bluelayer;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.deprecated.acquisition.uhcretiree.Rallytool_Page;
import pages.deprecated.acquisition.ulayer.AcquisitionHomePage;
import atdd.framework.UhcDriver;

public class MAResourcesAndPlanMaterialsTabpage extends UhcDriver {
	@Override
	public void openAndValidate(){
		startNew(MA_RESOURCES_AND_PLAN_TAB_URL);
	
	

}
	
	@FindBy(id="PO7link")
	
	private WebElement marequestmorehelpandinformationpageproviderlink;
	
	private static String MA_RESOURCES_AND_PLAN_TAB_URL= MRConstants.MA_RESOURCES_AND_PLAN_TAB_URL;
	
	public MAResourcesAndPlanMaterialsTabpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page marequestmorehelpandinformationpageclick() {
		validateNew(marequestmorehelpandinformationpageproviderlink);
		
		//marequestmorehelpandinformationpageproviderlink.click();
		
	switchToNewTabNew(marequestmorehelpandinformationpageproviderlink);
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		
		// TODO Auto-generated method stub
		return null;
	}
}

