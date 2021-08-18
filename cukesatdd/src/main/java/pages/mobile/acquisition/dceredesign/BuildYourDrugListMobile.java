package pages.mobile.acquisition.dceredesign;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.mobile.acquisition.commonpages.ComparePlansPageMobile;
import pages.mobile.acquisition.commonpages.DrugCostEstimatorPageMobile;

public class BuildYourDrugListMobile extends UhcDriver {

	@FindBy(css = "#drugsearchmobile")
	public WebElement EnterDrugNameTxt;

	@FindBy(xpath = "//button[@id='addDrug']")
	public WebElement addMyDrugsBtn;

	@FindBy(xpath = "//*[@id='adddrug']")
	public WebElement addDrugButton;

	@FindBy(css = "#previousButton")
	public WebElement getStartedButton;

	@FindBy(xpath = "//span[@class='uhc-button__text' and text()='Search']/parent::button")
	public WebElement SearchBtn;
	
	@FindBy(xpath = "//*[@id='modal-label']")
	public WebElement searchDrugHeader;
	
	@FindBy(xpath = "//*[@id=\"drug-label\"]")
	public WebElement enterDrugTitle;

	@FindBy(xpath = "//button[(@id= 'previousButton')]")
	public WebElement PreviousBtn;

	@FindBy(xpath = "//*[(@id= 'drugError')]")
	public WebElement BlankDrugError;

	@FindBy(xpath = "//*[@id='Lipitor']/div")
	public WebElement selectdrug;

	@FindBy(css = "div[class^='uhc-modal__content'] p#drugError")
	public WebElement NoDrugError;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'Back')]")
	public WebElement DrugSearchBackClick;

	@FindBy(css = "div[class^='uhc-modal__content'] div[class^='autocomplete-container']")
	public WebElement AutoCompleteList;

	@FindBy(css = "div[class^='uhc-modal__content'] #listPop > li")
	public List<WebElement> AutoCompleteitems;

	// @FindBy(xpath = "//*[@id='drugPopHeading']")
//	@FindBy(id = "modal-label")
	@FindBy(css = "div[class*='tellusyourdrugModal']  #modal-label")
	public WebElement TellUsAboutHeader;

	@FindBy(css = "div[class*='tellusyourdrugModal'] #cancelicon")
	public WebElement TellUsAboutCloseBtn;

	// uhc-menu-item
	@FindBy(xpath = "(//button[text()='Select'])[1]")
	public WebElement selectBtn;

	@FindBy(css = "button[dtmname$='add to drug list']")
	public WebElement addToDrugListButton;

	@FindBy(css = "app-uhc-header h2")
	public WebElement buildYourDrugListHeader;

	@FindBy(css = "div[class*='adddrugpopup'] #cancelicon")
	private WebElement addDrugModalCloseButton;

	@FindBy(css = "#previousButton + div > button[dtmname$='review drug costs']")
	public WebElement reviewDrugCostButtonFooter;

	@FindBy(css = "div[class*='d-block'] button[dtmname$='review drug costs']")
	public WebElement reviewDrugCostButtonHeader;

	@FindBy(css = "#zip-code")
	public WebElement zipCodeTxtbox;

	@FindBy(css = "#buildyourdruglist a[dtmname$='return to compare']")
	public WebElement returnToCompareBtn;

	@FindBy(css = "div[class*='d-block'] button[dtmname$='remove drug:yes']")
	private WebElement removeDrugYesButton;

	@FindBy(css = "div[class*='d-block'] button[dtmname$='remove drug:no']")
	private WebElement removeDrugNoButton;

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
		if (addDrugButton.isDisplayed()) {
			jsClickNew(addDrugButton);
		}

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
		CommonUtility.checkPageIsReadyNew(driver);
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
		jsClickNew(addToDrugListButton);

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

//	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	@FindBy(xpath = "//h2[contains(text(),'Review Drug Costs')]")
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

	public void validateDrugNotFound_ErrorMsg() {
		validateNew(EnterDrugNameTxt);
		sendkeysMobile(EnterDrugNameTxt, "india");
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);

		waitforElementVisibilityInTime(NoDrugError, 5);
		if (validateNew(NoDrugError) && NoDrugError.getText().trim().contains("Please enter at least 4 characters")) {

			System.out.println("Error Message displayed for No Drug Found : " + NoDrugError.getText());
		} else
			Assertion.fail("Error Message displayed for No Drug Found : " + NoDrugError.getText());
	}

	public void ValidateDrugAutocomplete(String partialDrug) {

//		jsClickNew(DrugSearchBackClick);
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
//		validateNew(EnterDrugNameTxt);
		sendkeysMobile(EnterDrugNameTxt, partialDrug);
		validateNew(AutoCompleteList);
		System.out.println("Drug Auto complete list count : " + AutoCompleteitems.size());
		if (validateNew(AutoCompleteList) && AutoCompleteitems.size() <= 5) {
			System.out.println("Drug Autocomplete Validated - less than or 5 drugs displayed for autocomplete");
		} else
			Assertion.fail("Drug Autocomplete NOT Validated");

	}

	public TellUsAboutDrugMobile SelectDrugfromList(String drugName) {
		validateNew(AutoCompleteList);
		WebElement Drug = driver
				.findElement(By.cssSelector("div[class^='uhc-modal__content'] [id='" + drugName + "']"));
		jsClickNew(Drug);
		CommonUtility.waitForPageLoadNew(driver, TellUsAboutHeader, 20);
		if (validateNew(TellUsAboutHeader) && validateNew(TellUsAboutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	public ZipCodeAndPlanYearCapturePageMobile navigateToZipEntryPage() {
		// CommonUtility.checkPageIsReadyNew(driver);
		// iosScroll(reviewDrugCost);
		scrollToView(reviewDrugCostButtonFooter);
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

		jsClickNew(SearchBtn);
		sleepBySec(5);
		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoad(driver, DrugSearchBackClick, 20);
		WebElement SelectDrug = driver
				.findElement(By.xpath("//p[normalize-space()='" + drugName + "']/following-sibling::button"));

		scrollToView(SelectDrug);

		jsClickNew(SelectDrug);
		CommonUtility.checkPageIsReadyNew(driver);

		threadsleep(2000);
		// waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		// CommonUtility.waitForPageLoadNew(driver, TellUsAboutHeader, 30);
		if (validateNew(TellUsAboutHeader) && validateNew(TellUsAboutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	public TellUsAboutDrugMobile SearchaddDrug(String drugName) throws InterruptedException {

		CommonUtility.checkPageIsReadyNew(driver);

		if (addDrugButton.isDisplayed()) {
			jsClickNew(addDrugButton);
		}

		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(EnterDrugNameTxt);
		sendkeysMobile(EnterDrugNameTxt, drugName);

		jsClickNew(SearchBtn);
		sleepBySec(5);
		waitForPageLoadSafari();
		// CommonUtility.waitForPageLoad(driver, DrugSearchBackClick, 20);
		
		waitforElementVisibilityInTime(searchDrugHeader, 20);

		List<WebElement> searchedDrugList = driver
				.findElements(By.cssSelector("div[class*='searchdrugpopup'] div > ul > li > p"));

		WebElement selectDrug = (WebElement) searchedDrugList.stream()
				.filter(listedDrug -> listedDrug.getText().contains(drugName))
				.map(listedDrug -> listedDrug.findElement(By.xpath("./following-sibling::button"))).findFirst().get();
		/*
		 * WebElement SelectDrug = driver
		 * .findElement(By.xpath("//p[normalize-space()='" + drugName
		 * +"']/following-sibling::button"));
		 */

		jsClickNew(selectDrug);

		threadsleep(6000);
		// waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, TellUsAboutHeader, 30);
		if (validateNew(TellUsAboutHeader)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	@FindBy(css = "button[id='changePharmacyLink'][class$='block']")
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

	@FindBy(xpath = "//div[starts-with(@class,'uhc-modal__header')]//h2[normalize-space()='Drug List Limit']")
	public WebElement DrugListModal_Header;

	@FindBy(css = "button#cancelicon")
	public WebElement DrugListModal_Close;

	@FindBy(xpath = "//button[contains(text(), 'Got it')]")
	public WebElement DrugListModal_GotItBtn;

	@FindBy(xpath = "//div[contains(text(), '25 drugs')]")
	public WebElement DrugListModal_Message;

	public void SearchValidate_DrugCountError(String drugName) {
		sendkeysMobile(EnterDrugNameTxt, drugName);
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
		// Get the name for all the drugs in a list
		List<WebElement> addedDrugList = driver
				.findElements(By.cssSelector("#buildyourdruglist uhc-list-item[class*='selectDrug'] h4"));
		List<String> addedDrugNames = addedDrugList.stream().map(drugName -> drugName.getText().trim())
				.collect(Collectors.toList());

		// Validate if the added drugs are the same as in druglist variable
		Stream.of(druglist.split("&")).forEach(drugName -> {
			boolean isDrugAdded = addedDrugNames.stream()
					.anyMatch(actualDrugName -> actualDrugName.toLowerCase().contains(drugName.toLowerCase()));
			System.out.println(drugName + " is present - " + isDrugAdded);
			Assertion.assertTrue(drugName + " is not displayed in list", isDrugAdded);
		});

		// Based on the drug name validate the edit and remove button for each drug
		addedDrugNames.forEach(addedDrug -> {
			String addedDrugName = addedDrug.split(" ")[0];
			System.out.println("Validating edit and remove buttons for " + addedDrugName);
			WebElement editDrugButton = driver
					.findElement(By.cssSelector("[aria-label^='Edit " + addedDrugName + "']"));
			WebElement removeDrugButton = driver
					.findElement(By.cssSelector("[aria-label^='Remove " + addedDrugName + "']"));
			Assertion.assertTrue("Edit button not displayed for " + addedDrug, validateNew(editDrugButton));
			Assertion.assertTrue("Remove button not displayed for " + addedDrug, validateNew(removeDrugButton));
		});

	}

	public void deleteDrug(String deleteDrug) {
		System.out.println("Drug to be removed : " + deleteDrug);
		WebElement removeLink = driver.findElement(By.cssSelector("button[aria-label^='Remove " + deleteDrug + "']"));
		jsClickNew(removeLink);

		validateNew(removeDrugYesButton, 10);
		jsClickNew(removeDrugYesButton);

	}

	@FindBy(xpath = "//h3[contains(text(), 'You might also take')]")
	public WebElement DrugRecommendationHeader;

	@FindBy(css = "button[id^='recommand_mobile']")
	public List<WebElement> DrugRecommendationDrugList;

	public void validateDrugRecommendationSection(String druglist) {
		jsClickNew(addDrugButton);
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
			jsClickNew(addDrugModalCloseButton);

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
		CommonUtility.waitForPageLoadNew(driver, TellUsAboutHeader, 20);
		if (validateNew(TellUsAboutHeader) && validateNew(TellUsAboutCloseBtn)) {
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

	public boolean ClickAddDrugRecommended(String drugName) {
		try {
			if (addDrugButton.isDisplayed()) {
				jsClickNew(addDrugButton);
			}

			CommonUtility.checkPageIsReadyNew(driver);
			validateNew(EnterDrugNameTxt);

			WebElement RecommendedDrug = driver.findElement(
					By.cssSelector("button[id^='recommand_mobile_" + drugName.replaceAll(" ", "_") + "']"));

			validateNew(RecommendedDrug);
			jsClickNew(RecommendedDrug);
			waitForPageLoadSafari();
			// CommonUtility.waitForPageLoad(driver, DrugSearchBackClick, 20);
			/*
			 * WebElement SelectDrug = driver.findElement(
			 * By.xpath("(//uhc-list-item//button[contains(@aria-label, 'Select " + drugName
			 * + "')])[1]")); System.out.println("Drug Search results page is displayed");
			 * validateNew(SelectDrug); jsClickNew(SelectDrug); threadsleep(2000);
			 */
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, TellUsAboutHeader, 20);
			if (validateNew(TellUsAboutHeader) && validateNew(TellUsAboutCloseBtn)) {
				validateNew(addToDrugListButton);
				jsClickNew(addToDrugListButton);
				waitForPageLoadSafari();
//				CommonUtility.waitForPageLoad(driver, buildYourDrugListHeader, 30);
				if (validateNew(buildYourDrugListHeader)) {
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

	public void clickOnRemoveButton(String drug) {
		WebElement removeLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Remove " + drug + "')]"));
		jsClickNew(removeLink);
		validateNew(removeDrugYesButton);
		jsClickNew(removeDrugYesButton);
	}

	public void validateBuildDrugListPageDisplayed() {
		validateNew(buildYourDrugListHeader);
		validateNew(reviewDrugCostButtonHeader);
		validateNew(addDrugButton);
	}

	@FindBy(xpath = "(//button//span[contains(text(),'Review Drug Costs')])[1]")
	public WebElement reviewDrugCost;

	public DrugSummaryPageMobile navigateToDrugSummaryPage() {
		/*
		 * validateNew(reviewDrugCost); jsClickNew(reviewDrugCost);
		 */

		validateNew(reviewDrugCostButtonHeader);
		jsClickNew(reviewDrugCostButtonHeader);

		waitForPageLoadSafari();
		threadsleep(2000);
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		} else {
			Assertion.fail("Drug Summary Page is not loaded");
			return null;
		}
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
