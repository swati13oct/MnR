package pages.vbfacquisition_deprecated.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import pages.vbfacquisition_deprecated.uhcretiree.Rallytool_Page;

public class MARightsAndResponsibilitiesPage extends GlobalWebElements {
	
	@Override
	public void openAndValidate() {
		start(MA_RIGHTS_AND_RESPONSIBILITIES_PAGE);
		

	}

	
	private static String MA_RIGHTS_AND_RESPONSIBILITIES_PAGE = MRConstants.MA_RIGHTS_AND_RESPONSIBILITIES_PAGE_URL;
	
	
	@FindBy(xpath=".//*[@id='PO7link']")
	private WebElement providerlink;

	public MARightsAndResponsibilitiesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	public Rallytool_Page MAEnrollmentproviderclick() {
		
		validate(providerlink);
		providerlink.click();
		switchToNewTab();
		if (getTitle().equalsIgnoreCase(
				"Enter Zip")) {
	return new Rallytool_Page(driver);
	}
		
		// TODO Auto-generated method stub
		return null;
	}
	
}	