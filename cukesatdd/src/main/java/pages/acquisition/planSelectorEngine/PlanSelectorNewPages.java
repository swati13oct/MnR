/**
 * 
 */
package pages.acquisition.planSelectorEngine;

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

import com.itextpdf.text.log.SysoCounter;

import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import acceptancetests.vbfacquisition_deprecated.enrollinplan.oleCommonConstants;
import acceptancetests.vbfacquisition_deprecated.vpp.VPPCommonConstants;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.ulayer.PageTitleConstants;

public class PlanSelectorNewPages extends UhcDriver {

	public PlanSelectorNewPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	/*
	 * @FindBy(xpath = "//div[@id='widget_0tdroCAgSEGuqWNwLbf7xA']/div/a") private
	 * WebElement getStartedBtn;
	 */

	@FindBy(xpath = "//*[contains(@class,'get-started-banner')]//button[contains(text(),'Get Started')]")
	private WebElement getStartedBtn;
	
	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]//button[contains(text(),'Get Started')]")
	private WebElement getStartedBtn1;

	// @FindBy(css = "#widget_0tdroCAgSEGuqWNwLbf7xA > div > a")
	// private WebElement getStartedBtn;

	@FindBy(id = "zip-code")
	private WebElement zipCode;
	
	@FindBy(id = "zipInfo")
	private WebElement countyInfo;

	@FindBy(id = "MultipleCounty")
	private WebElement PRECounty;
	
	@FindBy(css = "#MultipleCounty > option:nth-child(1)")
	private WebElement PRECountyInnerText;

	@FindBy(xpath = "//*[@id='CoverageType_Idontknow_Option_7_Lable']/following-sibling ::label")
	private WebElement TypeOfCoverageOption;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;
	
	@FindBy(id = "custom-radio-group")
	private WebElement coverageTitle;
	
	@FindBy(id = "errorMessage")
	private WebElement errorMessage;

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
	@FindBy(xpath = "(//a[@id='ui-active-menuitem'])[1]")
	private WebElement PrescriptionAutoResultsOld;

	@FindBy(xpath = "//ul[contains(@class,'ui-autocomplete')]/li[contains(@class,'ui-menu-item')]/a[contains(@class,'ui-corner-all')]")
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
	
	@FindBy(xpath = "//*[@class='progress-bar-title']/h1")
	private WebElement zipcodePageTilte;
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/h1")
	private WebElement pageStepsNumberName;
	
	@FindBy(xpath = "//*[@class='progress-bar-info']/section")
	private WebElement pageProgressPercentage;
	
	@FindBy(xpath = "//*[@class='all-fields-marked-wi']")
	private WebElement pageRequiredInfo;
	
	@FindBy(xpath = "//*[@class='all-fields-marked-wi']/sup")
	private WebElement pageRequiredInfoMark;
	
	@FindBy(xpath = "//*[@for='zip-code']")
	private WebElement zipcodePageQuestion;
	
	@FindBy(xpath = "//*[@for='zip-code']/sup")
	private WebElement zipcodePageQuestionMark;
	
	@FindBy(xpath = "//*[@class='mt-4']/label[2]")
	private WebElement zipcodeTextLabel;
	
	@FindBy(xpath = "//*[@for='MultipleCounty']")
	private WebElement zipcodePageCountyQuestion;
	
	@FindBy(xpath = "//*[@for='MultipleCounty']/sup")
	private WebElement zipcodePageCountyQuestionMark;
	
	public String planNameExpected = null;

	
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
		waitforElementVisibilityInTime(getStartedBtn, 30);

	}

	public void quizStartAndRunQuestionnaire(String zipcode) throws InterruptedException {

		// switchToNewIframe(iframePst);
		// waitTillElementClickableInTime(getStartedBtn, 30);
		//AcquisitionHomePage.clickIfElementPresentInTime(driver, proactiveChatExitBtn,5);
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcode);
		validate(countyInfo);
		continueBtn.click();
		waitforElementNew(coverageTitle);
		Assert.assertTrue(coverageTitle.getText().contains("What type of coverage are you looking for?"));
	
	}

	public void quizStartAndRunQuestionnaireWithCounty(String zip_code, String County) throws Exception {
		
		Thread.sleep(20000);
		driver.switchTo().defaultContent();
//		switchToNewIframe(iframePst);
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
		zipcodePagemultiCounty();
		waitforElementVisibilityInTime(PRECounty, 45);
		selectFromDropDownByText(driver, PRECounty, County);
		continueBtn.click();
		waitforElementNew(coverageTitle);
		Assert.assertTrue(coverageTitle.getText().contains("What type of coverage are you looking for?"));
		waitforElementVisibilityInTime(previousBtn, 45);
		previousBtn.click();
		waitforElementNew(zipcodePageTilte);
		Assert.assertTrue(zipcodePageTilte.getText().contains("Get help finding a plan"));
	}
	
	public void zipcodePage() {
		boolean hidden;
		System.out.println("Validating ZipcodePage Elements");
		waitforElementNew(zipcodePageTilte);
		Assert.assertTrue(zipcodePageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		waitforElementNew(pageRequiredInfo);
		Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		waitforElementNew(pageRequiredInfoMark);
		Assert.assertTrue(pageRequiredInfoMark.getText().contains("*"));
		waitforElementNew(zipcodePageQuestion);
		Assert.assertTrue(zipcodePageQuestion.getText().contains("What is your Zip Code?"));
		waitforElementNew(zipcodePageQuestionMark);
		Assert.assertTrue(zipcodePageQuestionMark.getText().contains("*"));
		hidden = (driver.findElement(By.xpath("//*[@id='zip-code']")).getAttribute("placeholder") == "Enter ZIP Code") ? true : false;
		System.out.println("Value of Enter Zipcode field is : "+ hidden +" in Zip Code page");
		System.out.println((hidden != true) ? "Ener Zip Code Text is displayed" : "Ener Zip Code Text not displaying");
		
	}
	
	public void zipcodePagemultiCounty() {
			waitforElementVisibilityInTime(zipcodeTextLabel, 45);
			Assert.assertTrue(zipcodeTextLabel.getText().contains("Plans are specific to your area"));
			waitforElementNew(zipcodePageCountyQuestion);
			Assert.assertTrue(zipcodePageCountyQuestion.getText().contains("Please select your County? *"));
			waitforElementNew(zipcodePageCountyQuestionMark);
			Assert.assertTrue(zipcodePageCountyQuestionMark.getText().contains("*"));
			waitforElementVisibilityInTime(PRECounty, 45);
			Assert.assertTrue(PRECountyInnerText.getText().contains("Select County "));
	}
	
	public void getStartedAndRunInvalidzipcode(String zipcodeid) throws InterruptedException {

		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zipcodeid);
		continueBtn.click();
		waitforElementNew(errorMessage);
		int size = zipcodeid.length();
		System.out.println("ZipCode Size is :"+size);
		if(size<5 && size!=0) {
			Assert.assertTrue(errorMessage.getText().contains("Please enter complete five digits for zip code"));
		}else if(size==0)	{
			Assert.assertTrue(errorMessage.getText().contains("Please enter a valid zip code"));
		}else{
			Assert.assertTrue(errorMessage.getText().contains("Please enter valid zipcode."));
		}	
	}
	
public void getStartedAndRunzipcodeWithCounty(String zip_code, String County) throws Exception {
		
		waitTillElementClickableInTime(getStartedBtn, 45);
		waitTillElementClickableInTime(getStartedBtn1, 45);
		getStartedBtn.click();
		zipcodePage();
		waitforElementVisibilityInTime(zipCode, 45);
		sendkeys(zipCode, zip_code);
		Thread.sleep(2000);
		zipcodePagemultiCounty();
		continueBtn.click();
		waitforElementNew(errorMessage);
		Assert.assertTrue(errorMessage.getText().contains("Please select County"));
	}

	public void NextQuestion() throws InterruptedException {
		NoneOption.click();
		NextQuestionButton.click();
		waitforElementNew(NextQuestion);
		Assert.assertTrue(QuestionsCounter.getText().contains("2 of"), "Questionaaire 2nd question was not started ");
	}
	
	@FindBy(xpath = "//h1[contains(@class,'text-display')]")
	private WebElement landingpageHeader;
	
	@FindBy(xpath = "//*[@class='get-started-banner']//img[@class='mb-3 mb-0-lg']")
	private WebElement landingpageAnimationImage;
	
	@FindBy(xpath = "//*[@class='get-started-main-inner']//img[@class='mb-3 mb-0-lg']")
	private WebElement landingpageImage;
	
	@FindBy(xpath = "//*[@class='get-started-banner']//p")
	private WebElement landingpageText;
		
	@FindBy(className = "get-started-main-inner")
	private WebElement landingpageMainInner;
	
	@FindBy(xpath = "//*[contains(@class,'get-started-main-inner')]//div[@class='get-started-main-title how-does-this-work']")
	private WebElement landingpageInnerTitle;
	
	@FindBy(xpath = "//*[@class='get-started-list']/li]")
	public WebElement landingpageTracker;
	
	@FindBy(xpath = "//*[@class='get-started-main-inner']//div[contains(@class,'it-may-help-to-have')]")
	public WebElement landingpageLabel;
	
	public void landingpage() {
		System.out.println("Validating Title: ");
		String ExpectedTitle = "Get help finding an insurance plan";
		validate(landingpageHeader, 30);
		String ActualTitle = landingpageHeader.getText();
		System.out.println(ActualTitle.equalsIgnoreCase(ExpectedTitle));
		System.out.println("Validating Animation Images: ");
		validate(landingpageAnimationImage, 30);
		System.out.println("Validating Text: ");
		validate(landingpageText, 30);
		String ExpectedText = " Answer a few simple questions and get personalized plan recommendations in about 10 minutes. ";
		String ActualText = landingpageText.getText();
		System.out.println(ActualText.equalsIgnoreCase(ExpectedText));
		validate(getStartedBtn, 30);
		validate(landingpageMainInner, 30);
		System.out.println("Validating Title in Inner Section: ");
		validate(landingpageInnerTitle, 30);
		String ExpectedText1 = "How does this work?";
		String ActualText1 = landingpageInnerTitle.getText();
		System.out.println(ActualText1.equalsIgnoreCase(ExpectedText1));
		for(int i=1; i<=3; i++) {
			String landingpageTracker = (driver.findElement(By.xpath("//*[@class='get-started-list']/li[" +i+ "]"))).getText();
			System.out.println(landingpageTracker);
			String landingpageTextPoints = (driver.findElement(By.xpath("//*[@class='get-started-main-inner']//*[@class='your-medicare-id-car mt-2']/li[" +i+ "]/span"))).getText();
			System.out.println(landingpageTextPoints);
		}
		validate(landingpageImage, 30);
		String landingpageLabelText = landingpageLabel.getText();
		System.out.println(landingpageLabelText.contains("It may help to have the following information before getting started:"));
		waitTillElementClickableInTime(getStartedBtn1, 45);
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
		sendkeys(PrescriptionBox_1, "Adci");

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
