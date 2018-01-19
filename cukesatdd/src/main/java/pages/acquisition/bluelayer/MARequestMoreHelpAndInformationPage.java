package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class MARequestMoreHelpAndInformationPage extends UhcDriver {
	

	@Override
	public void openAndValidate(){
		start(MA_REQUEST_MORE_HELP_AND_INFORMATION_URL);
	
	

}
	@FindBy(id="PO7link")
	
	private WebElement MArequestmorehelpandinformationpageproviderlink;

	private static String MA_REQUEST_MORE_HELP_AND_INFORMATION_URL= MRConstants.MA_REQUEST_MORE_HELP_AND_INFORMATION_URL;

	public MARequestMoreHelpAndInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
}

	public Rallytool_Page MArequestmorehelpandinformationpageproviderclick() {
		
		validate(MArequestmorehelpandinformationpageproviderlink);
		
		//MArequestmorehelpandinformationpageproviderlink.click();
		
		switchToNewTab(MArequestmorehelpandinformationpageproviderlink);
		
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		// TODO Auto-generated method stub
		return null;
	}
}
		
	
	

