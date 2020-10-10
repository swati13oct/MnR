package pages.mobile.acquisition.dceredesign;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.Document;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumFluentWait;
import pages.mobile.acquisition.ulayer.ComparePlansPageMobile;

public class BuildYourDrugListMobile extends UhcDriver {

	@FindBy(xpath = "//input[@id='drugsearch']")
	public WebElement EnterDrugNameTxt;

	@FindBy(xpath = "//button[(@id= 'search')]")
	public WebElement SearchBtn;

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

	@FindBy(xpath = "//body/div[@id='site-wrapper']/div[3]/div[1]/div[1]/div[1]/app-root[1]/app-builddrug[1]/div[1]/div[8]/div[1]/div[1]/button[2]/span[1]")
	public WebElement reviewDrugCost;

	@FindBy(xpath = "//input[@id='zip-code']")
	public WebElement zipCodeTxtbox;

	@FindBy(xpath = "(//button[contains(@class,'uhc-button')]//*[contains(text(),'Return to Compare')])[2]")
	public WebElement returnToCompareBtn;

	public BuildYourDrugListMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		// openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(EnterDrugNameTxt);
		validateNew(SearchBtn);
		validateNew(PreviousBtn);
	}

	public void validateNoDrug_ErrorMsg() {
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);
		if (validateNew(BlankDrugError) && BlankDrugError.getText().contains("enter at least 4 characters ")) {
			System.out.println("Error Message displayed for Blank Drug search : " + BlankDrugError.getText());
		} else
			Assert.fail("Error Message displayed for Blank Drug search : " + BlankDrugError.getText());
	}
	
	

	public void addDrugs() {
		validateNew(EnterDrugNameTxt);
		
	}

	public void addDrugs(String drugName) throws InterruptedException {
		// validate(EnterDrugNameTxt);
	
		//waitforElement(EnterDrugNameTxt);
	
//		EnterDrugNameTxt.click();
//		jsClickNew(EnterDrugNameTxt);
		//EnterDrugNameTxt.sendKeys(drugName);
		sendkeys(EnterDrugNameTxt, drugName);

		Thread.sleep(5000);
		WebElement drugname = driver.findElement(By.xpath("//*[contains(@id,'" + drugName + "')]/div"));

		jsClickNew(drugname);
		/*
		 * if(validate(SearchBtn)) SearchBtn.click(); if(validate(selectBtn))
		 * selectBtn.click();
		 */
		validateNew(addToDrugList);
		Thread.sleep(2000);
		jsClickMobile(addToDrugList);

		// addToDrugList.click();
		// reviewDrugCost.click();
	}

	



	public void clickReviewDrugCostBtn() {
		// reviewDrugCost.click();
		jsClickMobile(reviewDrugCost);
	}

	public void validateDrugNotFound_ErrorMsg() {
		validateNew(EnterDrugNameTxt);
		EnterDrugNameTxt.sendKeys("india");
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);
		if (validateNew(NoDrugError) && NoDrugError.getText().contains("No drugs were found ")) {
			System.out.println("Error Message displayed for No Drug Found : " + NoDrugError.getText());
		} else
			Assert.fail("Error Message displayed for No Drug Found : " + NoDrugError.getText());
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
			Assert.fail("Drug Autocomplete NOT Validated");

	}

	public TellUsAboutDrugMobile SelectDrugfromList(String drugName) {
		validateNew(AutoCompleteList);
		WebElement Drug = driver.findElement(By.xpath("//uhc-menu-item[@id='" + drugName + "']"));
		jsClickNew(Drug);
		CommonUtility.waitForPageLoadNew(driver, TellUsABoutHeader, 20);
		if (validateNew(TellUsABoutHeader) && validateNew(TellUsABoutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assert.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	public ZipCodeAndPlanYearCapturePageMobile navigateToZipEntryPage() {
		validateNew(reviewDrugCost);
		jsClickNew(reviewDrugCost);
		CommonUtility.waitForPageLoadNew(driver, zipCodeTxtbox, 20);
		if (validateNew(zipCodeTxtbox)) {
			return new ZipCodeAndPlanYearCapturePageMobile(driver);
		} else {
			Assert.fail("Zip Code Entry Page is NOT Displayed");
			return null;
		}

	}

	public TellUsAboutDrugMobile SearchaddDrugs(String drugName) {
		validateNew(EnterDrugNameTxt);
		EnterDrugNameTxt.sendKeys(drugName);
		validateNew(SearchBtn);
		jsClickNew(SearchBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement SelectDrug = driver
				.findElement(By.xpath("//uhc-list-item//button[contains(@aria-label, 'Select " + drugName + "')]"));
		validateNew(SelectDrug);
		jsClickNew(SelectDrug);
		CommonUtility.waitForPageLoadNew(driver, TellUsABoutHeader, 20);
		if (validateNew(TellUsABoutHeader) && validateNew(TellUsABoutCloseBtn)) {
			return new TellUsAboutDrugMobile(driver);
		} else {
			Assert.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
	}

	@FindBy(xpath = "//a[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	public DrugDetailsPageMobile navigateToDrugDetailsPage() {
		validateNew(reviewDrugCost);
		jsClickNew(reviewDrugCost);
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 20);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(DrugDetails_DrugCostsHeading)) {
			return new DrugDetailsPageMobile(driver);
		} else {
			Assert.fail("Drug Details is NOT Displayed");
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
			Assert.assertTrue("Drug List limit Modal and message are Displayed as Expected : " + DrugListModal_Message,
					true);
		} else
			Assert.fail("Drug List Modal and Message NOT Displayed!!!");

	}

	public void ValidateAddedDrugsList(String druglist) {
		String[] DrugListItems = druglist.split("&");
		System.out.println("Added Drug Count : " + DrugListItems.length);
		for (String currentDrug : DrugListItems) {
			System.out.println("Current Added Drug Name : " + currentDrug);
			WebElement DrugName = driver
					.findElement(By.xpath("//uhc-list-item//h4[contains(text(), '" + currentDrug + "')]"));
			WebElement DrugEditBtn = driver.findElement(
					By.xpath("//uhc-list-item//button[contains(@aria-label, 'Edit " + currentDrug + "')]"));
			WebElement DrugRemoveBtn = driver.findElement(
					By.xpath("//uhc-list-item//button[contains(@aria-label, 'Remove " + currentDrug + "')]"));

			if (validateNew(DrugName) && validateNew(DrugEditBtn) && validateNew(DrugRemoveBtn)) {
				Assert.assertTrue("Validated Drug List for Drug : " + currentDrug, true);
			} else
				Assert.fail("Drug List Validation FAILED for Drug : " + currentDrug);
		}
	}

	public ComparePlansPageMobile returnToPlanComparePage() {

		validateNew(returnToCompareBtn);
		returnToCompareBtn.click();
		return new ComparePlansPageMobile(driver);
	}

}
