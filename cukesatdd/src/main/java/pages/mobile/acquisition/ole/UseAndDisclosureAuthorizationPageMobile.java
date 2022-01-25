/**
 * 
 */
package pages.mobile.acquisition.ole;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.SpecialElectionPeriodPage;

/**
 * @author pdas101
 *
 */
public class UseAndDisclosureAuthorizationPageMobile extends UhcDriver {

	@FindBy(xpath = "//*[@for='disclosureHealth']")
	private WebElement disclosureBox;
	
	//@FindBy(css = "#providerName")
	@FindBy(xpath = "//input[@id='providerName']")
	private WebElement ProviderName;
	
	//@FindBy(css = "#providerStreetAddress")
	@FindBy(xpath= "//input[@id='providerStreetAddress']")
	private WebElement ProviderStreetAddress;
	
//	@FindBy(css = "#providerCity")
	@FindBy(xpath = "//input[@id='providerCity']")
	private WebElement ProviderCity;	

	//@FindBy(css = "#state")
	@FindBy(xpath = "//select[@id='state']")
	private WebElement StateDropDown;
	
	
//	@FindBy(css = "#providerZip")
	@FindBy(xpath = "//input[@id='providerZip']")
	private WebElement ZipCode;
	
	//@FindBy(css = "#providePhoneNumber")
	@FindBy(xpath = "//input[@id='providePhoneNumber']")
	private WebElement ProvidePhoneNumber;
	
	@FindBy(css = "#ole-form-back-button")
	private WebElement BackButton;
	
	@FindBy(css = "#ole-form-next-button")
	private WebElement NextButton;
	
	@FindBy(css = "#ole-form-cancel-button")
	private WebElement CancelEnrolButton;
	

	public UseAndDisclosureAuthorizationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, disclosureBox, 30);
	}

	public SpecialElectionPeriodPageMobile Validate_and_Enter_Details_for_YourProvide_Section(
			Map<String, String> MedicareDetailsMap) {
		String Providername = MedicareDetailsMap.get("Provider Name");
		String ProviderAddress = MedicareDetailsMap.get("Provider Street Address");
		String Providercity = MedicareDetailsMap.get("City");
		String ProviderZip = MedicareDetailsMap.get("Zip");
		String ProviderNumber = MedicareDetailsMap.get("Provider Phone Number");
		String Mailing_State = MedicareDetailsMap.get("Mailing_State");
		
		sendkeysMobile(ProviderName, Providername);
		sendkeysMobile(ProviderStreetAddress, ProviderAddress);
		sendkeysMobile(ProviderCity, Providercity);
		sendKeysByCharacter(ProvidePhoneNumber, ProviderNumber);
		sendkeysMobile(ZipCode, ProviderZip);
		StateDropDown.click();
		selectFromDropDownByValue(StateDropDown, Mailing_State);
//		mobileSelectOption(StateDropDown, Mailing_State, true);

		if (disclosureBox.isDisplayed()) {
			scrollToView(disclosureBox);
			jsClickNew(disclosureBox);
			// disclosureBox.click();
			System.out.println("Disclosure is displayed and clicked");

			validate(NextButton);
			scrollToView(NextButton);
			jsClickNew(NextButton);
			// NextButton.click();
		} else {
			System.out.println("Disclosure is not displayed");
		}
//		return new PersonalInformationPageMobile(driver);
		return new SpecialElectionPeriodPageMobile(driver);

	}
}