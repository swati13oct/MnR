/**
 * 
 */
package pages.acquisition.bluelayer;

import java.awt.Desktop.Action;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;

import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

public class PlanSelectorNewPage extends UhcDriver {

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	/*
	 * @FindBy(xpath = "//div[@id='widget_0tdroCAgSEGuqWNwLbf7xA']/div/a") private
	 * WebElement getStartedBtn;
	 */

	@FindBy(xpath = "//div[@id='aside-second']//a[contains(@class,'get-started-btn')]")
	private WebElement getStartedBtn;

	// @FindBy(css = "#widget_0tdroCAgSEGuqWNwLbf7xA > div > a")
	// private WebElement getStartedBtn;

	@FindBy(id = "DemographicsDataModel_ZipCode")
	private WebElement zipCode;

	@FindBy(id = "Counties")
	private WebElement PSTCounty;

	@FindBy(xpath = "//*[@id='CoverageType_Idontknow_Option_7_Lable']/following-sibling ::label")
	private WebElement TypeOfCoverageOption;

	@FindBy(xpath = "//div[@class='rightBlk']//a[contains(@class,'nextBtn') and contains(@class,'btn-primary')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//*[@id='control_control_0_4']/following-sibling::label")
	private WebElement NoneOption;

	@FindBy(xpath = "//*[@id='control_control_1_4']/following-sibling::label")
	private WebElement NonePreference;

	@FindBy(xpath = "(//*[@class='preferencenavigation pageNavigation']/a[2])[1]")
	private WebElement NextQuestionButton;

	@FindBy(id = "planPreferenceLegend_1")
	private WebElement NextQuestion;

	@FindBy(xpath = "//*[@class='planPreferenceQuestion']//div[@class='preferencenavigation pageNavigation']/a[2]")
	private WebElement NextQuestionButton2;

	@FindBy(xpath = "(//*[contains(text(), 'Medicare Advantage (Part C)')])[2]")
	private WebElement FinalResults;

	@FindBy(xpath = "//*[@class='skipToResultsLink']")
	private WebElement ResultsPageLink;

	@FindBy(id = "planPreferenceLegend_1")
	private WebElement PrescriptionBox;

	@FindBy(id = "DrugSearchBox_SearchtextBox")
	private WebElement PrescriptionBox_1;

	/*
	 * @FindBy(xpath =
	 * "//*[@id='41d4dd57-ca06-f737-8466-59563fb2d535']//li/a[@id='ui-active-menuitem']")
	 * private WebElement PrescriptionAutoResults;
	 */

	// @FindBy(id="ui-active-menuitem")
	@FindBy(xpath = "(//a[@class='ui-menu-item-wrapper'])[1]")
	private WebElement PrescriptionAutoResultsOld;

	@FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')]/li[contains(@class,'ui-menu-item')]/a[1]")
	private WebElement PrescriptionAutoResults;

	@FindBy(xpath = "//div[contains(@class,'addDrugRow')]/a[@id='Drugs_AddDrug']")
	private WebElement AddDrugPSTButton;

	@FindBy(xpath = "//*[@class='rightBlk']/a[2]")
	private WebElement DrugContinueButton;

	@FindBy(xpath = "//table[@id='pharmacyMainTable']/tbody/tr[@id='Pharmacy1']/td[contains(@class,'checkboxCol')]//input[starts-with(@id,'SelectedPharmacyID_')]/following-sibling::label")
	private WebElement PharmacyCheckBox;

	// a[@class='btn btn-primary next leftBlk nextBtn']
	@FindBy(xpath = "//div[@id='widget_B9pzC-bMU02tTlxiTpbchA']//div/a[@href='/PlanCompare/Consumer/Type3/2018/Compare/ComparePlans']")
	private WebElement skipToResultsLink;

	public JSONObject planselectoruhcJson;

	@FindBy(xpath = "(//div[@class='planList']/div[2]//a[@class='btn-primary EnrollPeriod'])[1]")
	private WebElement firstPlanDetailsBtn;

	@FindBy(xpath = "//a[@id='backToPlanSelectorTop']")
	private WebElement backToPlanOptionsTop;

	@FindBy(xpath = "(//*[@id='selectCounty']/p/a)[1]")
	private WebElement BackToPlanCounty;

	@FindBy(id = "backToPlanSelectorBottom")
	private WebElement backToPlanSelectorBottom;
	
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;
	
	@FindBy(xpath = "//div[contains(@class,'popup-modal')][contains(@class,'active')]/div[@class='modal-title']")
	private List<WebElement> countyModal1;

	@FindBy(xpath = "//*[@class='PlanPreferenceCollection']//div[@class='planPreferenceQuestion ']//h1")
	private WebElement PreferencesHeader;

	@FindBy(xpath = "(//div[contains(@class,'planList'[contains(@id,'List_')])]//a[starts-with(@id,'Enrollbtn_')])[1]")
	private WebElement PlanDetailsPageButton;

	@FindBy(xpath = "(//div[contains(@class,'planPreferenceQuestion')][not (contains(@class,'disabled'))]//span[starts-with(@id,QuestionsCounter_)])[1]")
	private WebElement QuestionsCounter;

	@FindBy(xpath = "//span[@id='planPreferenceLegend_1']/span[@id='Mandatory_1']")
	private WebElement MandatoryQuestion;

	@FindBy(xpath = "//div[@id='MyDrugsList']//div[@id='MyDrugsSection']//div[starts-with(@id,'drugItem_')]")
	private WebElement addedDrug;

	@FindBy(id = "providerLinkTest")
	private WebElement addDocAndProviders;

	@FindBy(xpath = "(//div[contains(@class,'planList'[contains(@id,'List_')])]//div[contains(@class,'plan-name')])[1]")
	private WebElement planNamePSTPage;

	@FindBy(xpath = "//div[contains(@class,'plan-summary-hero')]//*[@class='content']")
	private WebElement planNamePlanDetailsPage;

	@FindBy(xpath = "//div[@id='detailTabs']//div[contains(@class,'plan-detail-tabs')]//span[contains(@class,'title')][contains(text(),'Medical Benefits')]")
	private WebElement planDetailsMedicalBenefits;

	@FindBy(xpath = "(//table[contains(@class,'plan-detail-table')]/tbody/tr/td[string-length(text())>1][not (contains(@class,'ng-hide'))])[1]")
	private WebElement planDetailsMedicalBenefitsTableCol;

	@FindBy(xpath = "//a[contains(@class,'genericBtn')]")
	private WebElement addDosageInformation;
	
	public String planNameExpected = null;

	public PlanSelectorNewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
		waitforElementVisibilityInTime(getStartedBtn, 30);

	}

	public void quizStartAndRunQuestionnaire(String zip_code) throws InterruptedException {

		// switchToNewIframe(iframePst);
		// waitTillElementClickableInTime(getStartedBtn, 30);
		//AcquisitionHomePage.clickIfElementPresentInTime(driver, proactiveChatExitBtn,5);
		getStartedBtn.click();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		TypeOfCoverageOption.click();
		System.out.println("'I don't know option' radio button should be selected");
		continueBtn.click();
		waitforElementNew(PreferencesHeader);
		Assert.assertTrue(PreferencesHeader.getText().contains("Your Preferences"), "Questionaaire not started");
	}

	public void quizStartAndRunQuestionnaireWithCounty(String zip_code, String County) throws Exception {
		
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
		switchToNewIframe(iframePst);
		waitTillElementClickableInTime(getStartedBtn, 45);
		getStartedBtn.click();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
		waitforElementVisibilityInTime(PSTCounty, 45);
		selectFromDropDownByText(driver, PSTCounty, County);
		/*
		 * try { Thread.sleep(10000); Select drpCountry = new
		 * Select(driver.findElement(By.id("Counties")));
		 * System.out.println("county name is "+County);
		 * drpCountry.selectByVisibleText(County); } catch(Exception ex) {
		 * Thread.sleep(2000); Select drpCountry = new
		 * Select(driver.findElement(By.id("Counties")));
		 * drpCountry.selectByValue("48029"); }
		 */

		TypeOfCoverageOption.click();
		System.out.println("'I don't know option' radio button should be selected");
		continueBtn.click();
		waitforElementNew(PreferencesHeader);
		Assert.assertTrue(PreferencesHeader.getText().contains("Your Preferences"), "Questionaaire not started");

	}

	public void NextQuestion() throws InterruptedException {
		NoneOption.click();
		NextQuestionButton.click();
		waitforElementNew(NextQuestion);
		Assert.assertTrue(QuestionsCounter.getText().contains("2 of"), "Questionaaire 2nd question was not started ");
	}

	public boolean JumpLink() throws InterruptedException {
		validateNew(NonePreference);
		NonePreference.click();
		NextQuestionButton2.click();
		String thirdQuestion = "(//div[contains(@class,'planPreferenceQuestion')][not (contains(@class,'disabled'))]//span[starts-with(@id,QuestionsCounter_2)])[1]";
		CommonUtility.waitForPageLoadNew(driver, driver.findElement(By.xpath(thirdQuestion)), 30);
		for (int i = 3; i <= 7; i++) {

			System.out.println("Question #" + i);
			if (validateNonPresenceOfElement(MandatoryQuestion)
					&& QuestionsCounter.getText().contains(String.valueOf(i))) {

				NextQuestionButton2.click();
			} else {
				System.out.println("Mandatory question exits!!! Please fill appropriate response.");
				Assert.fail("Mandatory question exits!!! Please fill appropriate response.");
			}
			if (i != 7) {
				String nextQuestionXpath = "(//div[contains(@class,'planPreferenceQuestion')][not (contains(@class,'disabled'))]//span[starts-with(@id,QuestionsCounter_"
						+ i + ")])[1]";
				CommonUtility.waitForPageLoadNew(driver, driver.findElement(By.xpath(nextQuestionXpath)), 30);
			}
		}
		CommonUtility.waitForPageLoadNew(driver, PrescriptionBox_1, 30);
		sendkeys(PrescriptionBox_1, "exel");

		try {
			waitforElementVisibilityInTime(PrescriptionAutoResults, 30);
			PrescriptionAutoResults.click();
		} catch (Exception e) {
			waitforElementVisibilityInTime(PrescriptionAutoResultsOld, 30);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PrescriptionAutoResultsOld);
			System.out.println("second one worked");
		}
		try {
			waitforElementVisibilityInTime(addDosageInformation, 45);
			addDosageInformation.click();
		} catch (Exception e) {
			System.out.println("Drug is not generic.");
		}
		waitforElementVisibilityInTime(AddDrugPSTButton, 45);
		AddDrugPSTButton.click();
		waitforElementVisibilityInTime(addedDrug, 45);
		DrugContinueButton.click();
		waitforElementVisibilityInTime(PharmacyCheckBox, 45);
		PharmacyCheckBox.click();
		waitTillElementClickableInTime(DrugContinueButton, 30);
		DrugContinueButton.click();
		waitforElementVisibilityInTime(addDocAndProviders, 45);
		DrugContinueButton.click();
		waitforElementVisibilityInTime(FinalResults, 60);

		if (FinalResults.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean navigateToPlanDetails(String County) throws InterruptedException {
		validateNew(planNamePSTPage);
		planNameExpected = planNamePSTPage.getText().trim();
		validateNew(PlanDetailsPageButton);
		PlanDetailsPageButton.click();
		driver.switchTo().defaultContent();
		CommonUtility.checkPageIsReadyNew(driver);
		if(1==countyModal1.size()){
			CommonUtility.waitForPageLoad(driver, countyModal1.get(0), 45);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + County + "']")).click();
		}else
			System.out.println("No County popu displayed");

		int counter = 0;
		do {
			if (counter <= 9) {
				Thread.sleep(5000);
				System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
			} else {
				System.out.println("TimeOut!!! Plan Details page is not displayed");
				return false;
			}
			counter++;
		} while (!(driver.getCurrentUrl().endsWith("#/details")));
		waitforElementVisibilityInTime(planNamePlanDetailsPage, 30);
		if (planNamePlanDetailsPage.getText().trim().contains(planNameExpected))
			return true;
		else
			return false;
	}

	public void verifyBackToPlanOptionslink() throws InterruptedException {
		validateNew(planDetailsMedicalBenefits);
		Assert.assertTrue(validate(planDetailsMedicalBenefitsTableCol), "Medical benefits Table not displayed");
		validatetopbacktoplansOptionlink();

	}

	public void validatetopbacktoplansOptionlink() throws InterruptedException {

		try {
			BackToPlanCounty.click();
		} catch (Exception e) {
			System.out.println("No zipcode turned in again");
		}
		waitTillElementClickableInTime(backToPlanOptionsTop, 30);
		Assert.assertTrue(currentUrl().contains("userGroup=DST"), "User group not matches");
		backToPlanOptionsTop.click();
		System.out.println("Top Button clicked");
		Thread.sleep(3000);
		CommonUtility.checkPageIsReadyNew(driver);
		Assert.assertTrue(driver.getTitle().contentEquals(PageTitleConstants.BLAYER_PLAN_SELECTOR),
				"Navigation to plan selector page is not successful");
	}

	public void validatedownbacktoplansOptionslink() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1350)");
		Thread.sleep(1000);

		waitforElement(backToPlanSelectorBottom);
		Assert.assertTrue(currentUrl().contains("userGroup=DST"), "User group not matches");
		backToPlanSelectorBottom.click();
		if (driver.getTitle().contentEquals(PageTitleConstants.BLAYER_PLAN_SELECTOR)) {
			Assert.assertTrue(true);
		}

		else
			Assert.assertTrue(false);

	}

	public void browserBack() {

		driver.navigate().back();
	}
}
