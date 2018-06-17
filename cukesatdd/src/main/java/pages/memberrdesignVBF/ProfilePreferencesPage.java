/**
 * 
 */
package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
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
	
	@FindBy(xpath = "//*[contains(@class,'atdd-profile-membernumber')]/parent::p")
	private WebElement memberIdText;
	
	@FindBy(xpath = "//*[contains(@class,'atdd-profile-membername')]/parent::p")
	private WebElement memberNameText;
	
	@FindBy(xpath = "//*[contains(text(),'Username')]")
	private WebElement Username;

	@FindBy(xpath = "//*[contains(text(),'Username')]/parent::*/following-sibling::*/p")
	private WebElement Usernametext;
	
	@FindBy(xpath = ".//*[@id='password']/div/div/span[1]")
	private WebElement Password;

	@FindBy(xpath = ".//*[@id='password']/div/div/span[2]")
	private WebElement Passwordtext;

	@FindBy(className = "edit-btn-email")
	private WebElement EditButtonEmail;

	@FindBy(className = "atdd-plan-name")
	private WebElement planNameGoGreen;

	@FindBy(className = "atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	@FindBy(xpath = "//button[@id='save-prefs-btn-FEDERAL-INDIVIDUAL']/span")
	private WebElement savePreferencesButtonInd;
	
	@FindBy(xpath = "//button[@id='save-prefs-btn-FEDERAL-GROUP']/span[text()='Save Preferences']")
	private WebElement savePreferencesButtonGrp;
	
	@FindBy(partialLinkText = "PREFERENCES")
	private WebElement EditPreferenceButton;

	@FindBy(xpath = "//h2[contains(@class,'atdd-goGreenHeader')]")
	private WebElement GoGreenHeader;

	@FindBy(xpath = "//p[@class='atdd-goGreensubHeader']/following-sibling::p[text()][1]")
	private WebElement GoGreenText;
	
    @FindBy(id = "hsidPwdLink")
    private WebElement hsidPasswordLink;
    
    @FindBy(xpath = "//*[@id='header']/h1/a")
    private WebElement breadCrumbToNavigateBack;
    
    @FindBy(id = "hsidRecLink")
    private WebElement hsidAccountLink;
    
    @FindBy(id = "profileemailaddress")
    private WebElement emailAddress;
    


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
		validateNew(memberIdText);
		validateNew(memberName);
		validateNew(memberNameText);
		// ValidateAccount Profile
		validateNew(EditButtonEmail);

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
		if(CommonStepDefinition.getMemberAttributeMap().get("Member Type").contains("GroupRetireeMapd"))
		validateNew(savePreferencesButtonGrp);
		else
			validateNew(savePreferencesButtonInd);
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
	
    public void validateHealthSafeIdLink() throws InterruptedException {
        validateNew(hsidPasswordLink);
        if("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)){
        hsidPasswordLink.click();

        CommonUtility.checkPageIsReadyNew(driver);
        CommonUtility.waitForPageLoadNew(driver, breadCrumbToNavigateBack, 60);
        System.out.println("PageTitle "+driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("HealthSafe ID"));
        }
        else{
        	System.out.println("Skkiing the functionality as HSID is not supported");
        }
        

}

public void validateBreadCrumb() throws InterruptedException {
        // TODO Auto-generated method stub
	Assert.assertTrue(breadCrumbToNavigateBack.isDisplayed());
	Assert.assertTrue(Username.isDisplayed());
	Assert.assertTrue(Usernametext.isDisplayed());        
}

@SuppressWarnings("deprecation")
public void validateBreadCrumbClick() {
        // TODO Auto-generated method stub
        breadCrumbToNavigateBack.click();
        RallyDashboardPage.checkModelPopup(driver);
        CommonUtility.waitForPageLoadNew(driver,hsidPasswordLink, 50);
        Assert.assertTrue(driver.getTitle().contains("Profile"));
}



}
