package pages.dashboard.formsandresources;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

public class FormsAndResourcesPage extends UhcDriver {

	/** The member signin link. */
	@FindBy(id = "fd_memberSignInButton")
	private WebElement memberSignInButton;

	/** userId */
	@FindBy(id = "loginPOPUPuser")
	private WebElement loginuserId;

	/** Password */
	@FindBy(id = "loginPOPUPpass")
	private WebElement loginpassword;

	/** Sign in button in login pop screen */
	@FindBy(className = "memSignPopup")
	private WebElement memberSignInPopup;

	/** Link to Form And resources page in Test Harness Page */
	@FindBy(linkText = "Go to Forms And Resources page")
	private WebElement linkToFormsAndResources;

	/** Medical button in EOB section - Forms And Resources page */
	@FindBy(id = "medicalEOB")
	private WebElement eobMedicalButton;

	/** Drug button in EOB section */
	@FindBy(id = "drugEOB")
	private WebElement eobDrugButton;
	
	/** Renew Magazine Section - Forms And Resources page */
	@FindBy(id = "renew-magazine-callout")
	private WebElement renewMagazineSection;
	
	/** My DocumentSection - Forms And Resources page */
	@FindBy(id = "my-document-callout")
	private WebElement myDocumentSection;
	
	

	public FormsAndResourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(MRConstants.UHCM_MEMBER_URL);

	}

	public void clickMemberSignIn() {
		memberSignInButton.click();

	}

	public void enterUserid(String userId) {
		sendkeys(loginuserId, userId);

	}

	public void enterPassword(String password) {
		sendkeys(loginpassword, password);

	}

	public void clickMemberSignInButton() {
		memberSignInPopup.click();

	}

	public void openTestHarnessPage() {
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	    driver.get(MRConstants.BLUE_LAYER_TEST_HARNESS_LINK);
	}

	public void clickonFormsAndResourcesLinkOnTestHarness() {
		linkToFormsAndResources.click();

	}

	public WebElement getEOBMedicaButton() {
		return eobMedicalButton;
	}

	public WebElement getEOBDrugButton() {
		return eobDrugButton;
	}
	
	public WebElement getRenewMagazineSection() {
		return renewMagazineSection;
	}
	
	public WebElement getMyDocumentSection() {
		return myDocumentSection;
	}
	
	
}
