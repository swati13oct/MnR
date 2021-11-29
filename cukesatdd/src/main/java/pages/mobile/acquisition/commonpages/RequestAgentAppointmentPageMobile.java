/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class RequestAgentAppointmentPageMobile extends UhcDriver{
	
	@FindBy(css = "#firstNameTxt")
	private WebElement firstName;

	@FindBy(css = "#lastNameTxt")
	private WebElement lastName;

	@FindBy(css = "#postcodeTxt")
	private WebElement zipCodeInput;

	@FindBy(xpath = "//*[contains(text(),'Get Started')]/parent::button")
	private WebElement getStartedBtn;

	@FindBy(xpath = "//button[contains(@class,'form-control')]//*[contains(text(),'SEARCH')]")
	private WebElement searchBtn;

	@FindBy(css = "#selectedState")
	private WebElement state;
	
	@FindBy(css = "div[class^='description'] > p")
	private WebElement viewRepresentativePage;

	@FindBy(css = "div[class^='card agent']:nth-of-type(1) h4")
	private WebElement firstAgentName;
	

	
	
	public RequestAgentAppointmentPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, zipCodeInput, 60);
		validateNew(getStartedBtn);
		
	}
	
	public boolean submitAgentAppointmentByZip(Map<String, String> personalDetails) {
		sendkeys(zipCodeInput, personalDetails.get("Zipcode"));
		getStartedBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstAgentName, 60);
		if (firstAgentName.isDisplayed()) {
			validateNew(viewRepresentativePage);
			return true;
		}

		return false;
	}
	
	public boolean submitAgentAppointment(Map<String, String> personalDetails) {
		if (personalDetails.get("Zipcode") == "" || personalDetails.get("Zipcode") == null) {
			sendkeysMobile(firstName, personalDetails.get("First Name"));
			sendkeysMobile(lastName, personalDetails.get("Last Name"));
			selectFromDropDownByText(driver, state, personalDetails.get("State"));
			jsClickNew(searchBtn);
		} else {
			sendkeysMobile(zipCodeInput, personalDetails.get("Zipcode"));
			jsClickNew(getStartedBtn);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstAgentName, 60);
		if (firstAgentName.isDisplayed()) {
			validateNew(viewRepresentativePage);
			return true;
		}

		return false;
	}
	

}
