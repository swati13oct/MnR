package pages.mobile.acquisition.dceredesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumFluentWait;
import pages.acquisition.dceredesign.DrugSummaryPage;
import pages.acquisition.dceredesign.TellUsAboutDrug;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile;

public class BuildYourDrugListMobile extends UhcDriver {

	@FindBy(css = "#drugsearchmobile")
	public WebElement EnterDrugNameTxt;

	@FindBy(xpath = "//button[@id='addDrug']")
	public WebElement addMyDrugsBtn;

	@FindBy(css = "#adddrug")
	public WebElement addDrugButton;

	@FindBy(css = "#previousButton")
	public WebElement getStartedButton;

	@FindBy(xpath = "//span[@class='uhc-button__text' and text()='Search']")
	public WebElement SearchBtn;

	@FindBy(xpath = "//*[@id=\"drug-label\"]")
	public WebElement enterDrugTitle;

	@FindBy(xpath = "//button[(@id= 'previousButton')]")
	public WebElement PreviousBtn;

	@FindBy(xpath = "//*[(@id= 'drugError')]")
	public WebElement BlankDrugError;
	@FindBy(xpath = "//*[@id='Lipitor']/div")
	public WebElement selectdrug;

	@FindBy(xpath = "//*[(@id= 'err_2') or contains(@class, 'errtext')]")
	public WebElement NoDrugError;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'Back')]")
	public WebElement DrugSearchBackClick;

	@FindBy(xpath = "//uhc-autocomplete//*[contains(@class, 'autocomplete-container')]")
	public WebElement AutoCompleteList;

	@FindBy(xpath = "//uhc-menu-item")
	public List<WebElement> AutoCompleteitems;

	// @FindBy(xpath = "//*[@id='drugPopHeading']")
	@FindBy(id = "modal-label")
	public WebElement TellUsABoutHeader;

	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement TellUsABoutCloseBtn;

	// uhc-menu-item
	@FindBy(xpath = "(//button[text()='Select'])[1]")
	public WebElement selectBtn;

	@FindBy(xpath = "//button//*[contains(text(),'Add to drug List')]")
	public WebElement addToDrugList;

	// span[contains(text(),'Add to drug List')]

	/*
	 * @FindBy(xpath = "(//button//span[contains(text(),'Review Drug Costs')])[1]")
	 * public WebElement reviewDrugCost;
	 */

	@FindBy(xpath = "//div[contains(@class,'lg-center')]/button[contains(@dtmname,'review drug')]")
	public WebElement reviewDrugCostButtonFooter;

	@FindBy(xpath = "//button[contains(@class,'uhc-button') and contains(@dtmname,'review drug costs')]")
	public WebElement reviewDrugCostButtonHeader;

	@FindBy(css = "#zip-code")
	public WebElement zipCodeTxtbox;

	@FindBy(xpath = "(//button[contains(@class,'uhc-button')]//*[contains(text(),'Return to Compare')])[2]")
	public WebElement returnToCompareBtn;

	public BuildYourDrugListMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(addDrugButton);
		validateNew(getStartedButton);
	}

	public void validateNoDrug_ErrorMsg() {
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);
		if (validateNew(BlankDrugError) && BlankDrugError.getText().contains("enter at least 4 characters ")) {
			System.out.println("Error Message displayed for Blank Drug search : " + BlankDrugError.getText());
		} else
			Assertion.fail("Error Message displayed for Blank Drug search : " + BlankDrugError.getText());
	}

	public void addDrugs() {
		validateNew(EnterDrugNameTxt);

	}

	// @FindBy(xpath = "//span[contains(text(),'Build Your Drug List')]")
	@FindBy(xpath = "//h2[contains(text(),'Add Drug')]")
	public WebElement addYourDrugHeader;

	public void addDrugs(String drugName) throws InterruptedException {

		jsClickNew(addDrugButton);

		sendkeysMobile(EnterDrugNameTxt, drugName);

		// jsClickNew(addYourDrugHeader);

		scrollToView(SearchBtn);
		// SearchBtn.click();
		jsClickNew(SearchBtn);
		pageloadcomplete();
		/*
		 * WebElement SelectDrug = driver .findElement(By.
		 * xpath("//uhc-list-item//button[contains(@aria-label, 'Select " + drugName +
		 * "')]"));
		 */

		WebElement SelectDrug = driver

				.findElement(By.xpath("//p[normalize-space()='" + drugName + "']/following-sibling::button"));

		jsClickNew(SelectDrug);
		Thread.sleep(2000);
		//
		// iosScroll(addToDrugList);
		jsClickNew(addToDrugList);

	}

	public DrugSummaryPageMobile navigateToDrugSummay() {
		validateNew(reviewDrugCostButtonHeader);
		jsClickNew(reviewDrugCostButtonHeader);
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, reviewDrugCostPageHeading, 20);
		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		} else {
			Assertion.fail("Drug Summary Page is not loaded");
			return null;
		}

	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPageMobile verifyReviewDrugCostPage() {
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		} else {
			Assertion.fail("Review drug cost page not displayed");
			return null;
		}
	}

	@FindBy(xpath = "//a[contains(text(),'Add Drugs')]")
	private WebElement addrugs;

	public DrugCostEstimatorPageMobile addDrug() {

		jsClickNew(addrugs);
		if (currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPageMobile(driver);
		return null;
	}

	@FindBy(xpath = "//label[@id='drug-label']")
	public WebElement enterDrugNameTitle;

	public void validateDrugNotFound_ErrorMsg() {
		validateNew(EnterDrugNameTxt);
		EnterDrugNameTxt.sendKeys("not");
		jsClickNew(enterDrugNameTitle);
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);

		waitforElementVisibilityInTime(NoDrugError, 5);
		if (validateNew(NoDrugError) && NoDrugError.getText().trim().contains("No drugs were found")) {
			System.out.println("Error Message displayed for No Drug Found : " + NoDrugError.getText());
		} else
			Assertion.fail("Error Message displayed for No Drug Found : " + NoDrugError.getText());
	}

	public void ValidateDrugAutocomplete(String partialDrug) {

		jsClickNew(DrugSearchBackClick);
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
		validateNew(EnterDrugNameTxt);
		EnterDrugNameTxt.clear();
		EnterDrugNameTxt.sendKeys(partialDrug);
		validateNew(AutoCompleteList);
		System.out.println("Drug Auto complete lis COunt : " + AutoCompleteitems.size());
		if (validateNew(AutoCompleteList) && AutoCompleteitems.size() <= 5) {
			System.out.println("Drug Autocomplete Validated - less than or 5 drugs displayed for autocomplete");
		} else
			Assertion.fail("Drug Autocomplete NOT Validated");

	}

	public void clickOnRemoveButton(String drug) {
		WebElement removeLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Remove " + drug + "')]"));
		jsClickNew(removeLink);

	}

	public TellUsAboutDrugMobile SelectDrugfromList(String drugName) {
		validateNew(AutoCompleteList);
		WebElement Drug = driver.findElement(By.xpath("//*[@id='" + drugName + "']"));
		jsClickNew(Drug);
		CommonUtility.waitForPageLoadNew(driver, TellUsABoutHeader, 20);
		if (validateNew(TellUsABoutHeader) && validateNew(TellUsABoutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	public ZipCodeAndPlanYearCapturePageMobile navigateToZipEntryPage() {
		// pageloadcomplete();
		// iosScroll(reviewDrugCost);
		jsClickNew(reviewDrugCostButtonFooter);
		// CommonUtility.waitForPageLoadNew(driver, zipCodeTxtbox, 20);
		if (validateNew(zipCodeTxtbox)) {
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		} else {
			Assertion.fail("Zip Code Entry Page is NOT Displayed");
			return null;
		}

	}

	public TellUsAboutDrugMobile SearchaddDrugs(String drugName) throws InterruptedException {

		jsClickNew(addDrugButton);
		CommonUtility.waitForPageLoad(driver, EnterDrugNameTxt, 20);

		validateNew(EnterDrugNameTxt);
		sendkeysMobile(EnterDrugNameTxt, drugName);

		// jsClickNew(addYourDrugHeader);

		jsClickNew(SearchBtn);

		// CommonUtility.waitForPageLoad(driver, DrugSearchBackClick, 20);

		WebElement SelectDrug = driver
				.findElement(By.xpath("//p[normalize-space()='" + drugName + "']/following-sibling::button"));

		validateNew(SelectDrug);
		jsClickNew(SelectDrug);
		pageloadcomplete();

		threadsleep(2000);
		// waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		// CommonUtility.waitForPageLoadNew(driver, TellUsABoutHeader, 30);
		if (validateNew(TellUsABoutHeader) && validateNew(TellUsABoutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	@FindBy(xpath = "//*[contains(@id,'changePharmacyLink')]")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[normalize-space()='Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	public DrugDetailsPageMobile navigateToDrugDetailsPage() {
		validateNew(reviewDrugCostButtonFooter);
		jsClickNew(reviewDrugCostButtonFooter);
//		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 20);
		if (validateNew(DrugDetails_ChangePharmacyLnk)) {
			return new DrugDetailsPageMobile(driver);
		} else {
			Assertion.fail("Drug Details is NOT Displayed");
			return null;
		}
	}

	@FindBy(xpath = "//uhc-modal[contains(@modalheader, 'Drug List Limit')]")
	public WebElement DrugListModal_Header;

	@FindBy(xpath = "//*[contains(@class, 'uhc-modal__close')]")
	public WebElement DrugListModal_Close;

	@FindBy(xpath = "//button[contains(text(), 'Got it')]")
	public WebElement DrugListModal_GotItBtn;

	@FindBy(xpath = "//div[contains(text(), '25 drugs')]")
	public WebElement DrugListModal_Message;

	public void SearchValidate_DrugCountError(String drugName) {
		validateNew(EnterDrugNameTxt);
		EnterDrugNameTxt.sendKeys(drugName);
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);

		if (validateNew(DrugListModal_Header) && validateNew(DrugListModal_Close)
				&& validateNew(DrugListModal_GotItBtn)) {
			jsClickNew(DrugListModal_GotItBtn);
			System.out.println("Got It button Clicked to close modal");
			Assertion.assertTrue(
					"Drug List limit Modal and message are Displayed as Expected : " + DrugListModal_Message, true);
		} else
			Assertion.fail("Drug List Modal and Message NOT Displayed!!!");

	}

	public void ValidateAddedDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		int i;
		String currentDrug;
		int DrugCount_Total = DrugListItems.length - 1;
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		System.out.println("Total Added Drug Count : " + DrugCount_Total);
		for (i = 1; i <= DrugCount_Total; i++) {
			currentDrug = DrugListItems[i];
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver
					.findElement(By.xpath("//uhc-list-item//h4[contains(text(), '" + currentDrug + "')]"));
			WebElement DrugEditBtn = driver.findElement(
					By.xpath("//uhc-list-item//button[contains(@aria-label, 'Edit') and contains(@aria-label, '"
							+ currentDrug + "')]"));
			WebElement DrugRemoveBtn = driver.findElement(
					By.xpath("//uhc-list-item//button[contains(@aria-label, 'Remove') and contains(@aria-label, '"
							+ currentDrug + "')]"));

			if (validateNew(DrugName) && validateNew(DrugEditBtn) && validateNew(DrugRemoveBtn)) {
				Assertion.assertTrue("Validated Drug List for Drug : " + currentDrug, true);
			} else
				Assertion.fail("Drug List Validation FAILED for Drug : " + currentDrug);
		}
	}

	public void deleteDrug(String deleteDrug) {
		System.out.println("Drug to be removed : " + deleteDrug);
		WebElement removeLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Remove " + deleteDrug + "')]"));
		jsClickNew(removeLink);

	}

	@FindBy(xpath = "//h3[contains(text(), 'You might also take')]")
	public WebElement DrugRecommendationHeader;

	@FindBy(xpath = "//h3[contains(text(), 'You might also take')]//parent::div//following-sibling::ul//li//*")
	public List<WebElement> DrugRecommendationDrugList;

	public void validateDrugRecommendationSection(String druglist) {
		if (validate(DrugRecommendationHeader) && DrugRecommendationDrugList.size() > 0
				&& DrugRecommendationDrugList.size() <= 5) {
			System.out.println("Drug Recommendation section Displayed for Drugs Added");
			System.out.println("Drug Recommendation Displays " + DrugRecommendationDrugList.size() + " No of Drugs");
			System.out.println("Checking that Drug Recommendation does not display any added drug");

			String[] DrugListItems = druglist.split("&");
			int i;
			String currentDrug;
			// int DrugCount_Total = DrugListItems.length-1; //Commenting because null is
			// handled when drugs are added to druglist array, thus array will only have
			// drug names.
			int DrugCount_Total = DrugListItems.length;
			System.out.println("Total Added Drug Count : " + DrugCount_Total);
			// for(i=1; i<=DrugCount_Total; i++) { //Druglist array does not have null and
			// only has drug names, hence starting from 0 to array length - 1.
			for (i = 0; i < DrugCount_Total; i++) {
				currentDrug = DrugListItems[i];
				for (WebElement CurrentDrugRecommendation : DrugRecommendationDrugList) {
					if (currentDrug.contains(CurrentDrugRecommendation.getText())
							&& CurrentDrugRecommendation.getText().contains(currentDrug)) {
						System.out.println("Current cabinet Drug Name : " + currentDrug);
						System.out
								.println("Current recommendations Drug Name : " + CurrentDrugRecommendation.getText());
						Assertion.fail(currentDrug + " is also Displayed in Drug Recommendations - Validation FAILED");
					}
				}
				System.out.println(
						currentDrug + " is NOT Displayed in Drug Recommendations - Validation PASSED for Drug");
			}
			System.out.println("Drug Recommendations List : ");
			for (WebElement CurrentDrugRecommendation : DrugRecommendationDrugList) {
				System.out.println(CurrentDrugRecommendation.getText());
			}
			System.out.println("Drug Cabinet is NOT displayed in Drug Recommendation  - Validation PASSED");
		} else {
			System.out.println(" ***************** Drug Recommendations section is not displayed *****************");

		}

	}

	public ComparePlansPageMobile returnToPlanComparePage() {

		validateNew(returnToCompareBtn);
		// returnToCompareBtn.click();
		jsClickNew(returnToCompareBtn);
		return new ComparePlansPageMobile(driver);
	}

	public TellUsAboutDrugMobile EditDrug(String drugName) {
		WebElement removeLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Edit " + drugName + "')]"));
		jsClickNew(removeLink);
		CommonUtility.waitForPageLoadNew(driver, TellUsABoutHeader, 20);
		if (validateNew(TellUsABoutHeader) && validateNew(TellUsABoutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	public void validateDetailsForDrug(String drugName, String drugQuantity, String drugFrequency,
			String drugSupplyLen) {
		System.out.println("Current Added Drug Name : " + drugName);
		WebElement DrugName = driver.findElement(By.xpath("//uhc-list-item//h4[contains(text(), '" + drugName + "')]"));
		WebElement DrugDetailsText = driver.findElement(By.xpath("//uhc-list-item//h4[contains(text(), '" + drugName
				+ "')]//following-sibling::p[contains(text(), 'per') and contains(text(), 'refill')]"));
		String DrugText = DrugDetailsText.getText();
		System.out.println("Drug Text : " + DrugText);
		if (validateNew(DrugName) && validateNew(DrugDetailsText) && DrugText.contains(drugQuantity)
				&& DrugText.contains(drugFrequency) && DrugText.contains(drugSupplyLen)) {
			System.out.println(
					"Drug List Drug Quantity, Frequency and Supply Length Validation PASSED for Drug : " + drugName);
			System.out.println("Displayed Drug Details Text: " + DrugText);
		} else
			Assertion.fail(
					"Drug List Drug Quantity, Frequency and Supply Length Validation FAILED for Drug : " + drugName);
	}

	@FindBy(xpath = "//*[text()='Add Drug']")
	public WebElement AddDrugBtn;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	public boolean ClickAddDrugRecommended(String drugName) {
		try {
			WebElement RecommendedDrug = driver
					.findElement(By.xpath("//button[contains(@dtmname, '" + drugName + "')]"));

			validateNew(RecommendedDrug);
			jsClickNew(RecommendedDrug);
			waitForPageLoadSafari();
			// CommonUtility.waitForPageLoad(driver, DrugSearchBackClick, 20);
			WebElement SelectDrug = driver.findElement(
					By.xpath("(//uhc-list-item//button[contains(@aria-label, 'Select " + drugName + "')])[1]"));
			System.out.println("Drug Search results page is displayed");
			validateNew(SelectDrug);
			jsClickNew(SelectDrug);
			threadsleep(2000);
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, TellUsABoutHeader, 20);
			if (validateNew(TellUsABoutHeader) && validateNew(TellUsABoutCloseBtn)) {
				validateNew(AddDrugBtn);
				jsClickNew(AddDrugBtn);
				waitForPageLoadSafari();
				CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
				if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
					Assertion.assertTrue("Naviagted to Build Drug List Page", true);
					return true;
				}
				Assertion.fail("Did not Navigate to Build Drug List Page");
			} else {
				Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Drug Recommendation is not displayed");
			return false;
		}
		return false;
	}

	public void validateDrugRecommendationSectionNOTdisplayed(String druglist) {
		if (!validate(DrugRecommendationHeader) && DrugRecommendationDrugList.isEmpty()) {
			System.out.println("Validation PASSED : Drug Recommendation NOT displayed when 25 Drugs added to cabinet ");
		} else
			Assertion.fail("Validation FAILED : Drug Recommendation displayed when 25 Drugs added to cabinet");
	}

	public TellUsAboutDrugMobile clickOnEditButton(String drug) {

		WebElement editLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Edit " + drug + "')]"));
		jsClickNew(editLink);

		return new TellUsAboutDrugMobile(driver);

	}
	
	public void clickReviewDrugCostBtn() {
		jsClickNew(reviewDrugCostButtonFooter);
	}
}
