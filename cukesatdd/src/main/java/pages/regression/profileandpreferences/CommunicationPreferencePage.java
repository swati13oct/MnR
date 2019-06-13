package pages.regression.profileandpreferences;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.GoGreenPage;


public class CommunicationPreferencePage extends UhcDriver {

	@FindBy(xpath = ".//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	private WebElement profAndPrefLink;

	@FindBy(id = "savePaperlessSettings")
	private WebElement savePrefButton;
	
	@FindBy(id="save-prefs-btn-SHIP")
	private WebElement savePrefButtonSHIP;

	@FindBy(xpath = ".//iframe[@class='preferences']")  
	private WebElement iframeEPMP;

	//@FindBy(xpath = "//div[@class='tile-block paperless']/div[3]//div[@class='row']/div[1]//div[@class='control__indicator input-options']")
	//@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/ui-view/div/div/div/div[2]/div/div/div[3]/fieldset/div[2]/div/div[1]/fieldset/label/div")
	@FindBy(xpath = "//*[@id='Required_documents']/fieldset/div[2]/div/div[1]/label/div")
	private WebElement paperlessRadioBtn;

	//@FindBy(xpath = "//div[@class='tile-block paperless']/div[3]//div[@class='row']/div[2]//div[@class='control__indicator input-options']")
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/ui-view/div/div/div/div[2]/div/div/div[3]/fieldset/div[2]/div/div[2]/fieldset/label/div")
	private WebElement mailRadioBtn;

	//@FindBy(xpath = "//div[@class='tile-block paperless']//div[@class='row consent-row']//div[@class='control__indicator red-color-status']")
	@FindBy(xpath = "//input[@type='checkbox' and @name='paperlessConsent']/../div[2]")
	private WebElement agreeCheckBox;

	@FindBy(id = "IPerceptionsEmbed")
	private WebElement iPerceptionPopUp;

	@FindBy(className = "atdd-go-green-img")
	private WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement goggreenheader;

	@FindBy(xpath = "//*[@class='control control-checkbox consent-checkbox']")
	private WebElement iHavereadCheckbox;
	
	@FindBy(xpath = "//div[@class='otherPages SHIP']//label[@for='requiredplan']")
	private WebElement iHavereadCheckboxForShip;

	@FindBy(xpath ="//div[@class='otherPages SHIP']//legend[text()='Claims']/following::input[1]")
	private WebElement onlineDeliveryRadioButton;

	@FindBy(xpath ="//div[@class='otherPages SHIP']//legend[text()='Claims']/following::input[2]")
	private WebElement mailRadioButton;

	@FindBy(xpath = "//*[@id='Claims2']/following-sibling::label")
	private WebElement onlineDelivery;

	@FindBy(xpath = "//*[@id='Claims12']/following-sibling::label")
	private WebElement mailLabel;

	@FindBy(xpath = "//*[@id='preferenceEPMP']//h3")
	private WebElement planNameGoGreen;

	@FindBy(className = "h4 margin-none atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(xpath = "//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	private WebElement backLink1;

	@FindBy(xpath = "//*[@id='preferenceEPMP']//div[2]//a[contains(text(),'Profile & Preferences')]")
	private WebElement backLink2;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;
	
	@FindBy(xpath = "//*[@id='savePaperlessSettings']")
	private WebElement savePreferencesButton;
	
	@FindBy(id="PlanBenefits0")
	private WebElement onlineDeliveryPlanDocuments;
	
	@FindBy(id="PlanBenefits10")
	private WebElement mailDeliveryPlanDocuments;

	@FindBy(xpath = "//div[@class='otherPages SHIP']//a[text()='Edit Preferences']")
	private WebElement EditPreferenceButton;
	
	@FindBy(partialLinkText = "BACK TO ACCOUNT PROFILE")
	private WebElement backToAccountProfile;

	@FindBy(xpath = "//*[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//iframe[@class='preferences']")
	private List<WebElement> iframeEPMPCheck;
	
	@FindBy(xpath = "//div[@class='otherPages SHIP']//legend[text()='Claims']")
	private WebElement claimsLabel;

	@FindBy(xpath = "//div[@class='otherPages SHIP']//legend[text()='Plan Documents']")
	private WebElement planDocumentsLabel;
    
	@FindBy(xpath = "//a[@class='atdd-editpreferences ng-scope']")
	private WebElement editPrefLink;
	
	@FindBy(xpath = "//div[@id='Required_documents']/fieldset/div[2]/div/div[1]/label/div")
	private WebElement gopaperlessbutton;

	@FindBy(xpath = "//div[@id='Required_documents']/fieldset/div[2]/div/div[2]/fieldset/label/div")
	private WebElement mailButton;
	
	@FindBy(xpath = ".//*[@id='communicationAddress' or @id='communicationAddressCardHeight']/div[3]/a")
	private WebElement editPreferencesLink;
	
	@FindBy(xpath = "//*[@id='communicationAddressCardHeight' or @id='communicationAddress']")
	private List<WebElement> communicationPreferncessection;
	
	@FindBy(css="div#mail-preferences-selector-SHIP h3")
	private WebElement shipPlanName;
	
	@FindBy(css="div#mail-preferences-selector-SHIP input#requiredplan")
	private WebElement agreeRequiredNoticeCheckBox;
	
	@FindBy(id="save-prefs-btn-SHIP")
	private WebElement btnSavePrefSHIP;
	
	@FindBy(css="div#savePreferencesPopUpContent input#savepreferyes")
	private WebElement welcomeKitYES;
	
	@FindBy(xpath = "//div[@class='otherPages SHIP']//button[@class='btn save-prefs-btn']")
	private WebElement savePreferencesButtonShip;
	
	@FindBy(className="savePreferModal")
	private List<WebElement> modalPopupWindow;
	
	@FindBy(id="savepreferyes")
	private WebElement modalPopupWindowYesButton;
	
	@FindBy(xpath="//[@id='savePreferencesPopUpContent']//button[1]")
	private WebElement modalPopupWindowSubmitButton;
	
	
	
	public CommunicationPreferencePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (validate(iPerceptionPopUp)) {
				System.out.println("Iperception popup found");
				driver.navigate().refresh();
			}

		} catch (Exception e) {
			System.out.println("Iperception popup NOT Present");

		}
		// openAndValidate();
	}

	public ProfileandPreferencesPage clickProfAndPrefLink() {
		profAndPrefLink.click();
		if (driver.getTitle().equalsIgnoreCase("Profile"))
			return new ProfileandPreferencesPage(driver);
		return null;
	}

	@Override
	public void openAndValidate() {
		validateNew(profAndPrefLink);

	}

	public boolean validatePage() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CommonUtility.waitForPageLoad(driver, iframeEPMP, 15);
		System.out.println("validating frame");
		validateNew(iframeEPMP);
		System.out.println("frame validated");
		driver.switchTo().frame(iframeEPMP);
		System.out.println("switched to frame");

		if (validateNew(savePrefButton))
			return true;
		else
			return false;
	}
	
	public boolean validatePageForShip() {
		CommonUtility.waitForPageLoad(driver, claimsLabel, 15);
		validate(claimsLabel);
		validate(planDocumentsLabel);
		if (validateNew(savePrefButtonSHIP))
			return true;
		else
			return false;
	}

	public boolean changeAndVerifyOnlinePreference() {
		if (validateNew(paperlessRadioBtn) && !(paperlessRadioBtn.isSelected())) {
			paperlessRadioBtn.click();
			if (validateNew(agreeCheckBox)) {
				agreeCheckBox.click();
				System.out.println("agree button verified and clicked");
			}
			savePrefButton.click();
			System.out.println("paperless button clicked and saved");
			return true;
		} else if (validateNew(mailRadioBtn) && !(mailRadioBtn.isSelected())) {
			mailRadioBtn.click();
			savePrefButton.click();
			System.out.println("mail button clicked and saved");
			return true;
		} else
			return false;
	}
	
	

	/**
	 * Validate the communications page for ship members
	 */
	public void validateGoGreenSectionForShip() {

		validateNew(gogreenleaf);
		validateNew(goggreenheader);
		validateNew(onlineDeliveryRadioButton);
		validateNew(mailRadioButton);
		validateNew(claimsLabel);
		validateNew(planDocumentsLabel);
		validateNew(savePrefButtonSHIP);
		validateNew(iHavereadCheckboxForShip);
		
	}
	
	
	

	public boolean validateifEPMPIframeIsPresent() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (iframeEPMPCheck.size() > 0)
			return true;
		else
			return false;
	}

	public void switchToFrameOnPreferences() {

		driver.switchTo().frame(iframeEPMP);
		System.out.println("switched to frame");
		// TODO Auto-generated method stub

	}

	public void switchTabForComboMember() {

		driver.switchTo().defaultContent();
		tabsForComboMember.get(1).click();

		// TODO Auto-generated method stub

	}
/**
	 * @author bnaveen4
	 * Validates the preferences for the SHIP members
	 */
	public void validateCommunicationPreferencesForShip(String planName) {

		Assert.assertTrue(validateNew(claimsLabel));
		Assert.assertTrue(validateNew(planDocumentsLabel));
		Assert.assertEquals(planName, shipPlanName.getText().trim());
		
	}

	/**
	 * @toDo : Validates the headers on Go green page
	 */

	public void validateheader() {
		
	
		CommonUtility.waitForPageLoad(driver, gogreenleaf, 7);
		validateNew(gogreenleaf);
		validateNew(goggreenheader);

	}
	
	/***
	 * 
	 */
	public void validatePlanName(String planName) {
	
		String planNameOnProfilePage=planName;
		validateNew(planNameGoGreen);
        String planNameOnPreferencesPage=planNameGoGreen.getText();
         Assert.assertTrue(planNameOnProfilePage.equalsIgnoreCase(planNameOnPreferencesPage));
 
	}
	
	public void validatePlanNameForShip(String planName) {
		
		String planNameOnProfilePage=planName;
		validateNew(shipPlanName);
        String planNameOnPreferencesPage=shipPlanName.getText();
         Assert.assertTrue(planNameOnProfilePage.equalsIgnoreCase(planNameOnPreferencesPage));
 
	}
	/**
	 * @toDo : Validates the Go green button in Communication Preferences
	 *       section
	 */

	public GoGreenPage validategogreenbutton() {

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(0);
		if (gopaperlessbutton.isSelected()) {
				mailButton.click();
				savePreferencesButton.click();
				gopaperlessbutton.click();
				savePreferencesButton.click();
		} else {
			gopaperlessbutton.click();
			savePreferencesButton.click();
			
		}

		System.out.println("Title is " + driver.getTitle());
		if (getTitle().equalsIgnoreCase("Preferences")) {
			return new GoGreenPage(driver);
		}
		return null;
	}


	/**
	 * @toDo : Validates the I have read checkbox on Go green page
	 */
	public void validateCheckbox() {
		// TODO Auto-generated method stub

		if (iHavereadCheckbox.isDisplayed()) {
			iHavereadCheckbox.click();
		}
	}

	/**
	 * @toDo : Validates the save preferences functionality on Go green page
	 */
	public void validateSavePreferences() {
		// TODO Auto-generated method stub
		validateNew(savePreferencesButton);
		if (iHavereadCheckbox.isSelected()) {
			savePreferencesButton.click();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Assert.assertTrue(EditPreferenceButton.isDisplayed());

		}

	}
	
	/**
	 * @return 
	 * @toDo : Validates the presence of Back to Profile and Preferences links
	 *       on Go green page
	 */

	public ProfileandPreferencesPage validateBacktoPNPlink() {
		driver.switchTo().defaultContent();
		validateNew(backLink1);
		///validating back link on the top
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight/2)");
		System.out.println("scrolling down");
		validateNew(backLink2);
		backLink2.click();

		if (driver.getCurrentUrl().contains("profile")) {
			return new ProfileandPreferencesPage(driver);
		} 
		return null;
	
	}
	
	
	
	public CommunicationPreferencePage selectPreferences(String delivery,String preference) {
		
		if(delivery.replaceAll("\"", "").equalsIgnoreCase("electronic delivery")) {
			delivery = "EMAIL";
		}else {
			delivery = "US MAIL";
		}
		
		WebElement deliveryWebElement = driver.findElement(By.xpath("//div[@id='mail-preferences-selector-SHIP']"
				+ "//legend[text()='"+preference.replaceAll("\"", "")+"']/following::input[@value='"+delivery+"']/ancestor::div[1]/label"));
		
		jsClickNew(deliveryWebElement);
		
		return new CommunicationPreferencePage(driver);
		}

	public ProfileandPreferencesPage validateBacktoPNPlinkForShip() {
		//validating back link on the top
		validateNew(backLink1);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight/2)");
		System.out.println("scrolling down");
		//validating back link at the bottom
		validateNew(backLink2);
		backLink2.click();

		if (driver.getCurrentUrl().contains("profile")) {
			return new ProfileandPreferencesPage(driver);
		} 
		return null;
	}

	public void validateUpdatePreferencesForShip() {
		
        jsClickNew(onlineDeliveryPlanDocuments);
		
		iHavereadCheckboxForShip.click();
		savePrefButtonSHIP.click();
		if(modalPopupWindow.size()>0)
		{
			boolean isYesSelected=modalPopupWindowYesButton.isSelected();
			if(isYesSelected)
			{
				modalPopupWindowSubmitButton.click();
			}
			else
			{
				modalPopupWindowYesButton.click();
				modalPopupWindowSubmitButton.click();
			}
		}
			
		waitforElementVisibilityInTime(EditPreferenceButton, 30);
		//Reverting the prefereneces saved
		EditPreferenceButton.click();
		waitforElementVisibilityInTime(savePrefButtonSHIP, 10);
		jsClickNew(mailDeliveryPlanDocuments);
		validateNew(iHavereadCheckboxForShip);
		iHavereadCheckboxForShip.click();
		savePreferencesButtonShip.click();
		waitforElementVisibilityInTime(EditPreferenceButton, 20);
		validateNew(EditPreferenceButton);
		
	}
}
	

