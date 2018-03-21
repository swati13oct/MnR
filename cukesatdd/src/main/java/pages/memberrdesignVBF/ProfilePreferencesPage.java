/**
 * 
 */
package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author akapoo18
 *
 */
public class ProfilePreferencesPage extends UhcDriver {

	@FindBy(className = "atdd-profile-planname")
	private WebElement planName;

	@FindBy(className = "atdd-profile-membername")
	private WebElement memberName;

	@FindBy(className = "atdd-profile-membernumber")
	private WebElement memberId;

	@FindBy(xpath = "//span[contains(text(),'Username')]")
	private WebElement Username;

	@FindBy(xpath = "//span[contains(text(),'Username')]/following-sibling::span")

	private WebElement Usernametext;
	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Passwordtext;

	@FindBy(id = "Artwork")
	private WebElement EditButton;

	@FindBy(id = "mail-preferences-selector")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	@FindBy(id = "save-prefs-btn")
	private WebElement savePreferencesButton;

	@FindBy(partialLinkText = "PREFERENCES")
	private WebElement EditPreferenceButton;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement GoGreenHeader;

	@FindBy(className = "atdd-goGreensubHeader")
	private WebElement GoGreenText;

	public ProfilePreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, planName, 30);
		openAndValidate();
	}

	public void openAndValidate() {
		validateNew(EditPreferenceButton);
	}

	/***
	 * 
	 */
	public void validatePlanNameMemberidNameAcountProfile() {

		validateNew(planName);

		System.out.println("Plan name is " + planName.getText());
		validateNew(memberId);
		validateNew(memberName);
		// ValidateAccount Profile
		validateNew(Username);
		validateNew(Usernametext);
		validateNew(Password);
		validateNew(Passwordtext);
		validateNew(EditButton);

	}

	/***
	 * 
	 */
	public void validatePlanName() {
		CommonUtility.waitForPageLoadNew(driver, planNameGoGreen, 60);
		validateNew(planNameGoGreen);

	}

	/***
	 * 
	 */
	public void validatecommunicationpreferencesheader() {

		validateNew(communicationPreferences);
		if (communicationPreferences.isDisplayed()) {
			String cp = communicationPreferences.getText();

			System.out.println(cp);
			Assert.assertTrue(cp.equalsIgnoreCase("Communication Preferences"));
		}

	}

	/***
	 * 
	 */
	public void validateBacktoPNPlink() {

		validateNew(backLink1);
	}

	/***
	 * 
	 */
	public void validateNoteSection() {

		validateNew(NoteSection);
	}

	/***
	 * 
	 */
	public void validateSavePreferences() {
		validateNew(savePreferencesButton);
	}

	/***
	 * 
	 */
	public void validateGoGreenHeader() {
		validateNew(GoGreenHeader);
		validateNew(GoGreenText);
	}

	/***
	 * 
	 */
	public void clickEditPreferencesButton() {
		validateNew(EditPreferenceButton);
		EditPreferenceButton.click();
	}

}
