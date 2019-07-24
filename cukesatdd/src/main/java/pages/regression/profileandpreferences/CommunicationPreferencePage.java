package pages.regression.profileandpreferences;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import acceptancetests.util.CommonUtility;
import pages.memberrdesignVBF.GoGreenPage;
import pages.regression.claims.ClaimsSummaryPage;

public class CommunicationPreferencePage extends CommunicationPreferenceWebElements {

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
	}

	@Override
	public void openAndValidate() {
		validateNew(profAndPrefLink);
	}

	public ProfileandPreferencesPage clickProfAndPrefLink() {
		profAndPrefLink.click();
		if (driver.getTitle().equalsIgnoreCase("Profile"))
			return new ProfileandPreferencesPage(driver);
		return null;
	}

	public boolean validatePageNonEPMP() {

		CommonUtility.waitForPageLoadNew(driver, planNameGoGreen, 40);
		if (validateNew(planNameGoGreen) && validateNew(communicationPreferences)&&validateNew(backLink1)&&validateNew(NoteSection)&&validateNew(GoGreenHeader)&&
				validateNew(GoGreenText))
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
		driver.switchTo().defaultContent(); //note: make sure not on iframe first
		CommonUtility.waitForPageLoad(driver, iframeEPMP, 15);
		System.out.println("validating frame");
		validateNew(iframeEPMP);
		System.out.println("frame validated");
		driver.switchTo().frame(iframeEPMP);
		System.out.println("switched to frame");
		if (!validate(paperlessOptionActive)) {
			paperlessOptionInactive.click();
			CommonUtility.waitForPageLoad(driver, gopaperlessbutton, 5);
		}

		if (validateNew(gopaperlessbutton) && !(gopaperlessbutton.isSelected())) {
			gopaperlessbutton.click();
			if (validateNew(agreeCheckBox)) {
				agreeCheckBox.click();
				System.out.println("agree button verified and clicked");
			}
			savePrefButton.click();
			System.out.println("paperless button clicked and saved");
			return true;
		} else if (validateNew(mailButton) && !(mailButton.isSelected())) {
			mailButton.click();
			savePrefButton.click();
			System.out.println("mail button clicked and saved");
			return true;
		} else
			return false;
	}

	/** Validate the communications page for ship members */
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
		int count = 1;
		while (count < 10) {
			System.out.println("Count is: " + count);
			if (iframeEPMPCheck.size() > 0)
				break;
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
		}
		if (iframeEPMPCheck.size() > 0)
			return true;
		else
			return false;
	}

	public void switchToFrameOnPreferences() {
		driver.switchTo().frame(iframeEPMP);
		System.out.println("switched to frame");
	}

	public void switchTabForComboMember(int index) {
		driver.switchTo().defaultContent();
		tabsForComboMember.get(index).click();
	}

	public String getComboTabPlanType(int tabNum) {
		return tabsForComboMember.get(tabNum).getText();
	}

	/** Validates the preferences for the SHIP members */
	public void validateCommunicationPreferencesForShip(String planName) {
		Assert.assertTrue("PROBLEM - unable to locate claimsLabel", validateNew(claimsLabel));
		Assert.assertTrue("PROBLEM - unable to locate planDocumentsLabel", validateNew(planDocumentsLabel));
		Assert.assertEquals("PROBLEM planName not as expected.  Expected='"+planName+"' | Actual='"+shipPlanName.getText().trim()+"'", 
				planName, shipPlanName.getText().trim());
	}

	/** Validates the headers on Go green page */
	public void validateheader() {
		CommonUtility.waitForPageLoad(driver, gogreenleaf, 7);
		validateNew(gogreenleaf);
		validateNew(goggreenheader);
	}

	/** Validate planName for non-ship */
	public void validatePlanName(String planName) {
		String planNameOnProfilePage=planName;
		validateNew(planNameGoGreen);
		String planNameOnPreferencesPage=planNameGoGreen.getText();
		Assert.assertTrue("PROBLEM - planName on Profile page is not same as on Preference page. "
				+ "Profie='"+planNameOnProfilePage+"' | Preference='"+planNameOnPreferencesPage+"'", 
				planNameOnProfilePage.equalsIgnoreCase(planNameOnPreferencesPage));
	}

	/** Validate planName for ship */
	public void validatePlanNameForShip(String planName) {
		String planNameOnProfilePage=planName;
		validateNew(shipPlanName);
		String planNameOnPreferencesPage=shipPlanName.getText();
		Assert.assertTrue("PROBLEM - planName on Profile page is not same as on Preference page. "
				+ "Profie='"+planNameOnProfilePage+"' | Preference='"+planNameOnPreferencesPage+"'", 
				planNameOnProfilePage.equalsIgnoreCase(planNameOnPreferencesPage));
	}

	/** Validates the Go green button in Communication Preferences section */
	public GoGreenPage validategogreenbutton() {
		CommonUtility.waitForPageLoad(driver, iframeForFederalMembers, 20);
		validateNew(iframeForFederalMembers);
		driver.switchTo().frame(0);

		//note: if options are collapsed, need to expand first
		if (!validate(paperlessOptionActive)) {
			paperlessOptionInactive.click();
			CommonUtility.waitForPageLoad(driver, gopaperlessbutton, 5);
		}
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
		if (getTitle().equalsIgnoreCase("Preferences")) 
			return new GoGreenPage(driver);
		return null;
	}

	/** Validates the I have read checkbox on Go green page */
	public void validateCheckbox() {
		if (iHavereadCheckbox.isDisplayed())
			iHavereadCheckbox.click();
	}

	/** Validates the save preferences functionality on Go green page */
	public void validateSavePreferences() {
		validateNew(savePreferencesButton);
		if (iHavereadCheckbox.isSelected()) {
			savePreferencesButton.click();
			CommonUtility.waitForPageLoad(driver, EditPreferenceButton, 5);
			Assert.assertTrue("PROBLEM - EditPreferenceButton is not displayed",EditPreferenceButton.isDisplayed());
		}
	}

	/**
	 * Validates the presence of Back to Profile and Preferences links on Go green page
	 * @return 
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
		if(delivery.replaceAll("\"", "").equalsIgnoreCase("electronic delivery"))
			delivery = "EMAIL";
		else
			delivery = "US MAIL";
		WebElement deliveryWebElement = driver.findElement(By.xpath("//div[@id='mail-preferences-selector-SHIP']"
				+ "//legend[text()='"+preference.replaceAll("\"", "")+"']/following::input[@value='"+delivery+"']/ancestor::div[1]/label"));
		jsClickNew(deliveryWebElement);
		return new CommunicationPreferencePage(driver);
	}

	public ProfileandPreferencesPage validateBacktoPNPlinkForShip() {
		validateNew(backLink1);  //validating back link on the top
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight/2)");
		System.out.println("scrolling down");
		validateNew(backLink2);  //validating back link at the bottom
		backLink2.click();
		CommonUtility.waitForPageLoad(driver, headingTxt, 5);
		if (driver.getCurrentUrl().contains("profile"))
			return new ProfileandPreferencesPage(driver);
		return null;
	}

	public void validateUpdatePreferencesForShip() {
		boolean claimsOnlineDeliverySelected =false;
		boolean planDocumentsOnlineDeliverySelected=false;
		System.out.println(claimsMailDelivery.isSelected()); 
		//Validating for Claims 
		if(claimsMailDelivery.isSelected()){
			System.out.println("Mail delivery was selected for claims, selecting Online delivery now");
			jsClickNew(claimsOnlineDelivery);
			claimsOnlineDeliverySelected=true;
		} else {
			System.out.println("Online delivery was selected for claims, selecting Mail now");
			jsClickNew(claimsMailDelivery);
		}
		//validating for Plan Documents
		if(planDocumentsMailDelivery.isSelected()){
			System.out.println("Mail delivery was selected for plan Documents, selecting Online delivery now");
			jsClickNew(planDocumentsOnlineDelivery);
			planDocumentsOnlineDeliverySelected=true;
		} else {
			System.out.println("Online delivery was selected for Plan Documents, selecting Mail now");
			jsClickNew(planDocumentsMailDelivery);
		}
		jsClickNew(iHavereadCheckboxForShip);
		jsClickNew(savePrefButtonSHIP);
		if(modalPopupWindow.size()>0) {
			boolean isYesSelected=modalPopupWindowYesButton.isSelected();
			if(isYesSelected) {
				validateNew(modalPopupWindowSubmitButton);
				modalPopupWindowSubmitButton.click();
			} else {
				modalPopupWindowYesButton.click();
				modalPopupWindowSubmitButton.click();
			}
		}

		waitforElementVisibilityInTime(EditPreferenceButton, 30);
		//Checking the preferences saved
		EditPreferenceButton.click();
		waitforElementVisibilityInTime(savePrefButtonSHIP, 10);
		//validating the saved preferences
		Assert.assertTrue("PROBLEM - saved preferences are not as expected",
				(claimsOnlineDelivery.isSelected())==(claimsOnlineDeliverySelected) 
				&& (planDocumentsOnlineDelivery.isSelected())==(planDocumentsOnlineDeliverySelected));
	}

	public void validateIframeForAShipMember() {
		Assert.assertFalse(iframeEPMPCheck.size()>0);
	}

	public void validateEmailUpdateOnIframe() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(50);
		String emailAddress = "alisha_kapoor" + randomNumber + "@optum.com";
		validateNew(emailEditButtonOnIframe);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(emailEditButtonOnIframe));

		emailEditButtonOnIframe.click();
		validateNew(newEmailTextfield);
		newEmailTextfield.clear();
		validateNew(saveButtonOnEmailUpdatePopup);
		validateNew(cancelButtonOnEmailUpdatePopup);
		newEmailTextfield.sendKeys(emailAddress);
		saveButtonOnEmailUpdatePopup.click();
		CommonUtility.waitForPageLoad(driver, emailUpdateSuccTxt, 20);
		//to close the popup
		cancelButtonOnEmailUpdatePopup.click();
		CommonUtility.waitForPageLoad(driver, updatedEmailAfterSave, 5);
		validateNew(updatedEmailAfterSave);
		Assert.assertTrue("PROBLEM - not getting expected Email.  Expected='"+emailAddress+"' | Actual='"+updatedEmailAfterSave.getText()+"'", 
				updatedEmailAfterSave.getText().contains(emailAddress));
	}

	/** Validates the Note section on Go green page */
	public void validateNoteSection() {
		driver.switchTo().defaultContent(); //note: switch out of iframe if necessary
		validateNew(NoteSection);
		String noteContentActual = NoteSection.getText();
		String noteContentExpected = "Note: it may take up to two mail cycles for your updated delivery preferences to take effect. Your mailing cycle-the length of time between documents-varies by document. When the paper mailings stop, you will receive an email notification alerting you that a new document has been posted to your online account.";
		Assert.assertTrue("PROBLEM - not getting expected Note. Expected='"+noteContentExpected+"' | Actual='"+noteContentActual+"'", 
				noteContentActual.contains(noteContentExpected));
	}

	public void clickCheckBoxShip() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Yes, I want online delivery of my plan documents.' checkbox", 
				validate(agreeRequiredNoticeCheckBox));
		agreeRequiredNoticeCheckBox.click();
	}

	public void clickSaveBtnShip() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Save' button", 
				validate(btnSavePrefSHIP));
		btnSavePrefSHIP.click();
	}

	public void validatePopUp() {
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, submitBtnForWelcomeKitYES, 5);
		Assert.assertTrue("PROBLEM - unable to locate the 'No' radio option on popup after clicking 'Save' button", 
				validate(welcomeKitNo));
		Assert.assertTrue("PROBLEM - unable to locate the 'Yes' radio option on popup after clicking 'Save' button", 
				validate(welcomeKitYES));
		welcomeKitYES.click();
		Assert.assertTrue("PROBLEM - unable to locate the 'submit' button on the popup", 
				validate(submitBtnForWelcomeKitYES));
		submitBtnForWelcomeKitYES.click();
	}

	public void validateSuccessText() {
		CommonUtility.waitForPageLoad(driver, shipSuccMsg, 5);
		Assert.assertTrue("PROBLEM - unable to locate success message after submit", validate(shipSuccMsg));		
	}

	public void editPrefAgain() {
		Assert.assertTrue("PROBLEM - unable to locate the 'EDIT PREFERENCES' link", validate(EditPreferenceButton));
		EditPreferenceButton.click();
	}

	public void resetToMail() {
		selectPreferences("US MAIL","Plan Documents");
		Assert.assertTrue("PROBLEM - unable to locate the 'Yes, I want online delivery of my plan documents.' checkbox", 
				validate(agreeRequiredNoticeCheckBox));
		agreeRequiredNoticeCheckBox.click();
		Assert.assertTrue("PROBLEM - unable to locate the 'Save' button", validate(btnSavePrefSHIP));
		btnSavePrefSHIP.click();
		Assert.assertTrue("PROBLEM - unable to locate success message after submit", validate(shipSuccMsg));		
	}

	public void validatePreferencesPage(){
		validateNew(iframeForFederalMembers);
		validateNew(backLink1);
	}

	public ClaimsSummaryPage navigateToClaimsPage(){
		claimsTab.click();

		if(validateNew(claimsHeader))
			return new ClaimsSummaryPage(driver);
		return null;
	}

	public void validateSegmentId(String planType, String memberType, String expectedSegmentId) {
		CommonUtility.waitForPageLoad(driver, headingTxt, 10);
		String lookForPlanCategory="";
		boolean isComboUser=false;
		if (memberType.toUpperCase().contains("COMBO"))
			isComboUser=true;
		if (planType.equalsIgnoreCase("SHIP"))
			lookForPlanCategory="MEDICARE SUPPLEMENT";
		else if (planType.equalsIgnoreCase("SSUP")) 
			lookForPlanCategory="SSP";
		else if (planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) 
			lookForPlanCategory="MAPD";
		else 
			lookForPlanCategory=planType;

		String consumerDetails=getConsumerDetailsFromlocalStorage();
		String actualSegmentId=getSegmentIdInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetails);
		Assert.assertTrue("PROBLEM - not getting expected SegmentId for plan '"+planType+"'. "
				+ "Expected='"+expectedSegmentId+"' | Actual='"+actualSegmentId+"'", 
				expectedSegmentId.equals(actualSegmentId));
	}

	public String getConsumerDetailsFromlocalStorage() {
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		return consumerDetails;
	}

	public String getSegmentIdInConsumerDetails(boolean isComboUser, String lookForPlanCategory, String consumerDetails) {
		String actualSegmentId=null;
		try {
			JSONObject jsonObj = new JSONObject(consumerDetails);
			JSONArray arr =jsonObj.getJSONArray("planProfiles");
			if (isComboUser) 
				Assert.assertTrue("PROBLEM - test data expect this user to be a combo user "
						+ "but the localStorage.consumerDetails has only one planProfiles.  "
						+ "Please double check and correct test data", arr.length()>1);
			for (int i = 0; i < arr.length(); i++) {
				String actualPlanCategory = arr.getJSONObject(i).getString("planCategory");
				//note: need to locate the right plan for segmentId validation
				if (lookForPlanCategory.equals(actualPlanCategory)) {
					actualSegmentId = arr.getJSONObject(i).getString("segmentId");
				}
			}
			Assert.assertTrue("PROBLEM - unable to locate segmentId from localStorage.consumerDetails", 
					actualSegmentId!=null);
		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return actualSegmentId;
	}
}


