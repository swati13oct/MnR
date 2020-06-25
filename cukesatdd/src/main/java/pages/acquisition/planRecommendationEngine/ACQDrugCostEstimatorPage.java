/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ACQDrugCostEstimatorPage extends UhcDriver {

	public ACQDrugCostEstimatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);
	
	public static ArrayList<String> DCEDrugsList = new ArrayList<String>();

	String page = "Drug Cost Estimator";

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Werally page Elements

	// --- From here Common for all page starts ---
	@FindBy(css = "#add-drug .card-body")
	private WebElement AddDrugButton;

	@FindBy(css = "#drug-search-input")
	private WebElement drugsearchinput;
	
	@FindBy(id = "drug-search-button")
	public WebElement searchButton;

	@FindBy(id = "drugDosageStrengthId")
	public List<WebElement> drugNamesList;
	
	@FindBy(xpath = "//input[starts-with(@id,'drugs-')]/parent::div[contains(@class,'radio-block')]/label")
	public WebElement drugList;
	
	@FindBy(id = "drug-alt-search-button")
	public WebElement druglistcontinueButton;
	
	@FindBy(id = "drug-dosage-button")
	public WebElement continueButton;
	
	
	@FindBy(xpath = "//*[contains(@id,'dosage')]//select")  
	public WebElement dosageDropdown;
	
	@FindBy(id = "quantity")
	public WebElement quantityField;
	
	@FindBy(id = "frequency")
	public WebElement selectYourFrequencyDropdown;
	
	@FindBy(id="save-drug-button")
	public WebElement savedrugbutton;
	
	@FindBy(css="div.display-block.margin-extra-small label")
	public WebElement genericOptn;
	
	@FindBy(id = "pharmacyTabId")
	public WebElement step2;

	@FindBy(id = "drugsTabId")
	public WebElement step1;
	
	@FindBy(id = "costsTabId")
	public WebElement step3;
	
	@FindBy(id = "drugcosts")
	private WebElement step3Info;
	
	@FindBy(xpath = "//*[@id='drugcontainer_0']/div/section/p/span[2]")
	public WebElement drugQtyDosage;
	
	@FindBy(id = "drug-cost-card-acq")
	private WebElement drugCostCard;
	
	@FindBy(id = "pharInfoId-0")
	public WebElement firstPharmacyName;
	
	@FindBy(xpath = ".//*[@id='select-pharmacy-button' or @id='select-pharmacy-button-0']")
	public WebElement select_btn_first;
	
	@FindBy(xpath = "//div[contains(@class,'pharmacy-list')]//div[contains(@class,'selected')]//address/span")
	public WebElement selectedPharmacyName;
	
	@FindBy(xpath = "//div[@class='loading-dialog'][not (contains(@style,'display: none;'))]")
	public List<WebElement> loadingBlock;
	
	@FindBy(id = "returnLink")
	public WebElement returnLink;
	
	public void AddDruginDCE() {
		System.out.println("Adding Drugs in DCE Page");
		validate(AddDrugButton, 30);
		AddDrugButton.click();
	}
	
	public boolean isDrugPresent(String drugName) {
		boolean isPresent = false;

		// List<WebElement> drugNamesList =
		// driver.findElements(By.id("drugDosageStrengthId"));

		for (WebElement drugNames : drugNamesList) {
			System.out.println("drug name: " + drugNames.getText());
			if (drugName.equalsIgnoreCase(drugNames.getText().trim())) {
				isPresent = true;
			}
		}
		return isPresent;
	}
	
	public void addDrug(String drug)  {
		AddDruginDCE();
		searchDrugWithoutAutoComplete(drug);
		
	}
	
	public void searchDrugWithoutAutoComplete(String DrugName) {

		sendkeys(drugsearchinput, DrugName.toLowerCase());
		searchButton.click();
		CommonUtility.waitForPageLoadNew(driver, drugList, 30);
		druglistcontinueButton.click();

	}
	
	public void selectDosage(String dosage) {
		selectFromDropDownByText(driver, dosageDropdown, dosage);
	}
	
	public void selectQnty(String qnty){
		sendkeysNew(quantityField, qnty);
	}

	public void selectFrequency(String frquency){
		selectFromDropDownByText(driver, selectYourFrequencyDropdown, frquency);
		continueButton.click();
	}
	
	public void continueAddDrugDetailsModWithSaving(){
		scrollToView(savedrugbutton);
		savedrugbutton.click();
		}
	
	public void continueAddDrugDetailsModNoSaving() {
		genericOptn.click();
		validateNew(savedrugbutton);
		savedrugbutton.click();
		}
	
	public ArrayList<String> validateAddedDrug(String drug) {
		DCEDrugsList = new ArrayList<String>();
		WebElement drugHeading = driver.findElement(By.xpath("//*[contains(@id,'drugDosageStrengthId_')]"));
		Assert.assertTrue(drugHeading.getText().contains(drug.toUpperCase()),"Drug name is not match");
		DCEDrugsList.add(drugHeading.getText().trim() + " " +drugQtyDosage.getText().trim().replace("Quantity\n", ""));
		Collections.sort(DCEDrugsList);
		System.out.println("DCEDrugsList Content is : "+DCEDrugsList);
		return DCEDrugsList;
	}
	
	public void navigateToStep2() {
		validateNew(step2);
		step2.click();
	}
	
	public void select_first_pharmacy(){
		String firstPharmacyText = firstPharmacyName.getText().trim();
		validateNew(select_btn_first);
		System.out.println("first pharmacy");
		jsClickNew(select_btn_first);
		threadsleep(5000);
		validateNew(selectedPharmacyName);
		String selectedPharmacyText = selectedPharmacyName.getText().trim();
		Assert.assertTrue(firstPharmacyText.contains(selectedPharmacyText),"Selected Pharmacy name not matches");
	}
	
	public void navigateToStep3() {

		if (!(loadingBlock.isEmpty())) {
			waitforElementDisapper(By.className("loading-dialog"), 60);
		}
		validateNew(step3);
		jsClickNew(step3);
	}
	
	public boolean validateDrugOnStep3(String drug) {
		System.out.println(step3Info.getText());
		if (step3Info.getText().contains(drug.toUpperCase()) && validateNew(drugCostCard))
			return true;
		return false;

	}
	
	public void clickReturnToSummaryLink() {
		validateNew(returnLink, 20);
		jsClickNew(returnLink);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			System.out.println("Page navigated from DCE");
		}

	}

}
