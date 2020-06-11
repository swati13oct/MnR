package pages.acquisition.bluelayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.acquisition.uhcretiree.Rallytool_Page;

public class MAResourcesAndPlanMaterialsTabpage extends UhcDriver {
	@Override
	public void openAndValidate(){
		start(MA_RESOURCES_AND_PLAN_TAB_URL);
	
	

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
		validate(marequestmorehelpandinformationpageproviderlink);
		
		marequestmorehelpandinformationpageproviderlink.click();
		
	switchToNewTab();
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		
		// TODO Auto-generated method stub
		return null;
	}
}

