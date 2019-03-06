package pages.regression.profileandpreferences;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class CommunicationPreferencePage extends UhcDriver {

	@FindBy(xpath = ".//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	private WebElement profAndPrefLink;

	@FindBy(id = "savePaperlessSettings")
	private WebElement savePrefButton;

	@FindBy(xpath = ".//iframe[@class='preferences']")  
	private WebElement iframeEPMP;

	//@FindBy(xpath = "//div[@class='tile-block paperless']/div[3]//div[@class='row']/div[1]//div[@class='control__indicator input-options']")
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/ui-view/div/div/div/div[2]/div/div/div[3]/fieldset/div[2]/div/div[1]/fieldset/label/div")
	private WebElement paperlessRadioBtn;

	//@FindBy(xpath = "//div[@class='tile-block paperless']/div[3]//div[@class='row']/div[2]//div[@class='control__indicator input-options']")
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/ui-view/div/div/div/div[2]/div/div/div[3]/fieldset/div[2]/div/div[2]/fieldset/label/div")
	private WebElement mailRadioBtn;

	//@FindBy(xpath = "//div[@class='tile-block paperless']//div[@class='row consent-row']//div[@class='control__indicator red-color-status']")
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div/div/ui-view/div/div/div/div[2]/div/div/div[5]/div[1]/label/div[2]")
	private WebElement agreeCheckBox;

	@FindBy(id = "IPerceptionsEmbed")
	private WebElement iPerceptionPopUp;

	@FindBy(className = "atdd-go-green-img")
	private WebElement gogreenleaf;

	@FindBy(className = "atdd-goGreenHeader")
	private WebElement goggreenheader;

	@FindBy(id = "requiredplan")
	private WebElement iHavereadCheckbox;

	//@FindBy(xpath ="//div[@id='mail-preferences-selector-SHIP']//*[@id='preferences-form0']/div/div[1]/div[2]/div[2]/div/fieldset/div[1]/div/label")
	@FindBy(xpath ="//div[@class='otherPages SHIP']//input[@aria-label='Online Delivery']")
	private WebElement onlineDeliveryRadioButton;

	//@FindBy(id = "Claims12")
	@FindBy(xpath ="//div[@class='otherPages SHIP']//input[@aria-label='Mail']")
	private WebElement mailRadioButton;

	@FindBy(xpath = "//*[@id='Claims2']/following-sibling::label")
	private WebElement onlineDelivery;

	@FindBy(xpath = "//*[@id='Claims12']/following-sibling::label")
	private WebElement mailLabel;

	@FindBy(className = "atdd-plan-name")
	private WebElement planNameGoGreen;

	@FindBy(className = "h4 margin-none atdd-section-heading")
	private WebElement communicationPreferences;

	@FindBy(className = "atdd-banklink-prefernce")
	private WebElement backLink1;

	@FindBy(className = "atdd-notes")
	private WebElement NoteSection;

	//@FindBy(id = "save-prefs-btn-SHIP")
	//@FindBy(xpath = "//*[@id='savePaperlessSettings']")
	@FindBy(xpath = "//div[@class='otherPages SHIP']//button[@class='btn save-prefs-btn']")
	private WebElement savePreferencesButton;

	@FindBy(partialLinkText = "PREFERENCES")
	private WebElement EditPreferenceButton;

	@FindBy(xpath = "//*[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//iframe[@class='preferences']")
	private List<WebElement> iframeEPMPCheck;

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

	public void validateGoGreenSectionForShip() {

		validateNew(gogreenleaf);
		validateNew(goggreenheader);
		validateNew(onlineDeliveryRadioButton);
		validateNew(mailRadioButton);
		boolean flag1 = onlineDeliveryRadioButton.isSelected();
		System.out.println("Value of Online delivery flag is" + flag1);
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag1 = true) {
			validateNew(mailLabel);
			mailLabel.click();
		} else {
			validateNew(onlineDelivery);
			onlineDelivery.click();
		}
*/	
		validateNew(savePreferencesButton);
		savePreferencesButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
		if (EditPreferenceButton.isDisplayed()) {
			EditPreferenceButton.click();
			boolean flag2 = onlineDeliveryRadioButton.isSelected();
			if (!flag1 == flag2)
				Assert.assertTrue(true);

		} else {
			Assert.assertFalse(true);

		}*/
		validateNew(backLink1);

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
	

}
