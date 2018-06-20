package pages.memberrdesignVBF;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class DrugCostEstimatorPage extends UhcDriver {

	public DrugCostEstimatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		if (loadingImages.size() > 0) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
		}
	}

	private PageData savedrugpage;

	private JSONObject savedrugpageJson;

	@FindBy(id = "add-drug")
	public WebElement addDrug;

	@FindBy(xpath = "//p[contains(text(),'STEP2:')]/following-sibling::span[p[contains(text(),'PHARMACY')]]")
	public WebElement step2;

	@FindBy(xpath = "//p[contains(text(),'STEP1:')]/following-sibling::span[p[contains(text(),'DRUGS')]]")
	public WebElement step1;

	@FindBy(id = "pharmacy-form")
	public WebElement pharmacyform;

	@FindBy(id = "standard-type")
	public WebElement rbStandardNetwork;

	@FindBy(id = "saver-type")
	public WebElement rbPharmacySaver;

	@FindBy(id = "mail-service-type")
	public WebElement rbPreferredMailService;

	@FindBy(id = "retail-type")
	public WebElement rbPreferredRetail;

	@FindBy(className = "edit-drug")
	public WebElement editDrug;

	@FindBy(id = "drug-search-input")
	public WebElement drugsearchinput;

	@FindBy(xpath = "//h1[contains(text(),'Drug')][contains(text(),'Cost')][contains(text(),'Estimator')]")
	public WebElement validateIntroductoryText;

	@FindBy(id = "drug-alt-search-button")
	public WebElement continueButton;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")
	public WebElement SaveDrugPage;

	@FindBy(xpath = "//p[contains(text(),'STEP2:')]/following-sibling::span[p[contains(text(),'PHARMACY')]]")
	public WebElement step2PharmacyTab;

	@FindBy(id = "dce-pharmacy-radius")
	public WebElement milesSelection;

	@FindBy(id = "zipcode")
	public WebElement zipcodeInput;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div/div[2]/div[3]/a[1]")
	public WebElement SearchLink; // is it the same thing?

	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[1]/p")
	public WebElement StandardNetworkPharmaciesRadioButton;

	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[2]/div/p")
	public WebElement PharmacyNetworkPharmacyRadioButton;

	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[4]/p")
	public WebElement PreferredMailServicePharmacyRadioButton;

	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[2]/div/span[3]/div")
	public WebElement PreferredRetailSavingMsg;

	@FindBy(className = "tablePharmacy")
	public WebElement PharmacyList;

	@FindBy(xpath = "//span[contains(./text(),'Men')]")
	public WebElement PharmacyName;

	@FindBy(xpath = "//p[contains(text(), 'Summary')]")
	public WebElement SummaryHeader;

	@FindBy(xpath = "//div/p[contains(text(),'Enter your drugs to see your total drug costs')]")
	public WebElement Enter_drug_text;

	@FindBy(xpath = "//a[@href='#drugs-tab']/span/p")
	public WebElement drugTab;

	@FindBy(xpath = "//span[@class='msg-more-drugs ng-scope']/p")
	public WebElement mesgMoreDrugsOther;

	@FindBy(xpath = "//div[@class='drug-container ng-scope'][1]/p[@class='ng-binding ng-scope']")
	public WebElement drugndosage1;

	@FindBy(xpath = "//div[@class='drug-container ng-scope'][2]/p[@class='ng-binding ng-scope']")
	public WebElement drugndosage2;

	@FindBy(xpath = "//div[@class='drug-container ng-scope'][3]/p[@class='ng-binding ng-scope']")
	public WebElement drugndosage3;

	@FindBy(id = "zipcode-button")
	public WebElement btnSearch;

	@FindBy(id = "pharmacy-form")
	public WebElement pharmacy_form;

	@FindBy(id = "pharmacy-results")
	public WebElement pharmacyResults;

	@FindBy(xpath = "//div[@id='pharmacy-results']//span[contains(@class,'pharmacy-name')]")
	public List<WebElement> pharmacies;

	@FindBy(xpath = "//div[@id='pharmacy-results']//table[@class='pharmacy-list']/tbody/tr[not(contains(@class,'ng-hide'))]//a[starts-with(@id,'select-pharmacy-buttons_')]")
	public WebElement select_btn_first;

	@FindBy(id = "saverSavingSpan")
	public WebElement card_promo_blue_saver;

	@FindBy(id = "mailOrderSavingSpan")
	public WebElement card_promo_blue_mail;

	@FindBy(id = "retailSavingSpan")
	public WebElement card_promo_blue_retail;

	@FindBy(id = "saver-type")
	public WebElement pharmacy_saver_type;

	@FindBy(xpath = "//ul[@class='pharmacy-list']/li[1]/div//span[contains (text(), '  total annual drug cost')]")
	public WebElement text_total_annual_drug_cost;

	@FindBy(id = "retail-type")
	public WebElement pharmacy_retail_type;

	@FindBy(id = "standard-type")
	public WebElement pharmacy_standard_type;

	@FindBy(xpath = "//ul[@class='pharmacy-list']/li[1]")
	public WebElement first_pharmacy_record;

	@FindBy(id = "summary_totalCost")
	public WebElement summary_tot_cost;

	@FindBy(id = "total_annualcost")
	public WebElement left_rail_tot_cost;

	@FindBy(xpath = "//ul[@class='pharmacy-list']/li[1]//a[@class='btn btn--secondary select-pharmacy']")
	public WebElement first_pharmacy_select_btn;

	@FindBy(id = "mail-service-select")
	public WebElement mail_service_select_btn;

	@FindBy(id = "summary_savings")
	public WebElement summary_saving;

	@FindBy(id = "total_availablesavings")
	public WebElement left_rail_tot_saving;

	@FindBy(id = "total_drugsavings")
	public WebElement left_rail_drug_saving;

	@FindBy(id = "total_pharmacysavings")
	public WebElement left_rail_pharmacy_saving;

	@FindBy(xpath = "//p[contains(text(),'STEP 3:')]/following-sibling::span[p[contains(text(),'COST')]]")
	public WebElement step3;

	@FindBy(id = "total_annauldeductible")
	public WebElement left_rail_deductible;

	@FindBy(xpath = "//div[@id='drugdetails']/div[1]/div[1]//a[@class='delete-drug']")
	public WebElement first_delete_link;

	@FindBy(xpath = ".//*[@id='zipcode-button']")
	public WebElement btnZipCodeSearch;

	@FindBy(xpath = ".//*[@id='mail-service-select']")
	public WebElement btnMailServiceSelect;

	@FindBy(id = "mail-service-type")
	public WebElement lbPreferredMailService;

	@FindBy(xpath = ".//*[@id='pharmacyTabId']/a")
	public WebElement step2Pharmacy;

	@FindBy(xpath = ".//*[@id='total_drugsavings']/div[2]/a")
	public WebElement lkEditDrugsList;

	@FindBy(xpath = ".//*[@id='total_pharmacysavings']/div[2]/a")
	public WebElement lkEditPharmacyList;

	@FindBy(xpath = "//div[@class='pharmacy-container']")
	public WebElement pharmacyContainer;

	@FindBy(xpath = "//div[@id='learnmoreTiersId']/a")
	public WebElement learnmoreTiers;

	@FindBy(xpath = "//div[@id='learnmoreStagesId']/a")
	public WebElement learnmoreStages;

	@FindBy(id = "learnmoreStagesId")
	public WebElement stagesTexts;

	@FindBy(id = "learnmoreTiersId")
	public WebElement tierTexts;

	@FindBy(id = "selected-name")
	public WebElement SelectedName;

	@FindBy(xpath = "//div[@id='idLearnmoreAboutDelivery']/a")
	public WebElement learnMoreHomeDelivery;

	@FindBy(id = "collapseHomeDel")
	public WebElement homeDeliveryContent;

	@FindBy(className = "pharmacy-container")
	public WebElement selectedPharmacy;

	@FindBy(xpath = ".//*[@id='drugsTabId']/a")
	public WebElement step1DrugTab;

	@FindBy(className = "loading-dialog")
	public WebElement loadingImage;

	@FindBy(className = "loading-dialog")
	public List<WebElement> loadingImages;

	@FindBy(xpath = "//div[@id='IPEinvL']//area[@alt='no']")
	public List<WebElement> noThanksImage;

	@FindBy(id = "summary_totalCost")
	public WebElement totDrugCost_Summary;

	@FindBy(id = "total_annualcost")
	public WebElement totDrugCost_LeftRail;

	@FindBy(xpath = ".//*[@id='drugModal']/div/div/div[2]/div/section/div/button[2]")
	public WebElement deleteButton;

	@FindBy(xpath = "//div[@id='drugs-tab']//div[contains(@ng-repeat,'eachDrug')]")
	public List<WebElement> drugs;

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : savedrugpage.getExpectedData().keySet()) {
			WebElement element = findElement(savedrugpage.getExpectedData().get(key));
			validateNew(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		savedrugpageJson = jsonObject;

		System.out.println("savedrugpageJson----->" + savedrugpageJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		return(expectedDataMap.get(CommonConstants.DCEstimator));
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public AddNewDrugModal clickOnAddDrug() throws InterruptedException {
		validateNew(addDrug);
		addDrug.click();
		if ("drugcostestimatoracquisition".equalsIgnoreCase(driver.getTitle())
				|| "Overview".equalsIgnoreCase(driver.getTitle())
				|| "Drug Cost Estimator".equalsIgnoreCase(driver.getTitle())) {
			return new AddNewDrugModal(driver);
		}
		return null;
	}

	public void changeUrlToNewDCEPage() throws InterruptedException {
		String NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/medicare/member/drug-lookup/overview.html";
		String evironment = MRScenario.environment;
		// Go to DCE page
		System.out.println("dce link");
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			NewDCEUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/medicare/member/drug-lookup/overview.html";
		} else if (driver.getCurrentUrl().contains("uhcmedicaresolutions")) {
			NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/medicare/member/drug-lookup/overview.html";
		} else if (evironment.equals("team-h")) {
			NewDCEUrl = "https://team-h-werally.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		} else if (evironment.equals("stage")) {
			NewDCEUrl = "https://stage-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}

		driver.get(NewDCEUrl);
		driver.manage().window().maximize();
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		Thread.sleep(15000);
	}

	/***
	 * 
	 * @return
	 */
	public int getDrugsCount() {
		return drugs.size();
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	public void navigateToStep2() throws InterruptedException {
		validateNew(step2Pharmacy);
		step2Pharmacy.click();
		CommonUtility.waitForPageLoadNew(driver, pharmacy_form, 20);
		waitforElementNew(pharmacy_form);

	}

	/***
	 * 
	 * @param pharmacy
	 * @throws InterruptedException
	 */
	public void selectPharmacyType(String pharmacy) throws InterruptedException {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 120);
		WebElement rbtn = driver
				.findElement(By.xpath(".//*[@id='pharmacy-type']/div/label/p[contains(text(),'" + pharmacy + "')]"));
		validateNew(rbtn);
		rbtn.isDisplayed();
		if (!rbtn.isSelected()) {
			rbtn.click();
			System.out.println("RBTN " + pharmacy + " >> Selected");
		} else {
			System.out.println("RBTN " + pharmacy + " >> already selected");
		}

		Thread.sleep(5000);
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	public void select_first_pharmacy() throws InterruptedException {
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 180);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,900)", "");
		scrollToView(select_btn_first);
		validateNew(select_btn_first);
		jsClickNew(select_btn_first);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 180);
	}

	/***
	 * 
	 * @param zipcode
	 * @throws InterruptedException
	 */
	public void pharmacyInformation(String zipcode) throws InterruptedException {
		validateNew(zipcodeInput);
		sendkeysNew(zipcodeInput, zipcode);
		btnZipCodeSearch.click();
	}

	/***
	 * 
	 */
	public void validatePreferredMailServiceRD() {
		try {
			validateNew(lbPreferredMailService);
			Assert.assertTrue(lbPreferredMailService.isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertFalse(false);
		}
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	public void navigateToStep3() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		validateNew(step3);
		step3.click();
	}

	/***
	 * 
	 * @param drug
	 * @throws InterruptedException
	 */
	public void addDrug(String drug) throws InterruptedException {
		AddNewDrugModal addNewDrugModal = clickOnAddDrug();
		addNewDrugModal.typeDrugName(drug);
		Thread.sleep(2000);
		AddDrugDetails addDrugDetails = addNewDrugModal.submit();
		if (!(loadingImages.isEmpty())) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 20);
		}
		SavingsOppurtunity savingsOppurtunity = addDrugDetails.continueAddDrugDetailsModal();
		savingsOppurtunity.savedrugbutton();
		Thread.sleep(2000);

	}

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]")
	public WebElement totalDrugSavingsBox;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/span")
	public WebElement drugSavingValue;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/a")
	public WebElement editDrugListLink;

	/***
	 * 
	 * @throws InterruptedException
	 */
	public void deleteAllDrugs() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		int drugCount = getDrugsCount();
		while (getDrugsCount() != 0) {
			String deleteDrugXpath = ".//*[@id='drugdetails']/div[2]/div[" + drugCount + "]/div/div/section/ul/li[2]/a";
			WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", deleteDrug);

			deleteDrug.click();
			CommonUtility.waitForElementToDisappear(driver, loadingImage, 30);
			System.out.println("drug deleted");
			validateNew(deleteButton);
			deleteButton.click();
			drugCount--;
			Thread.sleep(5000);
		}
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	public void validateTotalEstimatedAnnualDrugCosts() throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, totDrugCost_Summary, 20);
		validateNew(totDrugCost_LeftRail);
		scrollToView(totDrugCost_Summary);
		String valTotDrugCost_Summary = totDrugCost_Summary.getText();
		scrollToView(totDrugCost_LeftRail);
		String valtotDrugCost_LeftRail = totDrugCost_LeftRail.getText();
		Assert.assertEquals(valTotDrugCost_Summary, valtotDrugCost_LeftRail);
	}

	/***
	 * 
	 */
	public void validateSwitchGenericOption() {

		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			WebElement switchGenericOption = driver.findElement(By.id("generic-drug-" + (drugscount - 1)));
			System.out.println("switch generic option" + switchGenericOption.getText());
			if (switchGenericOption.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Drug does not have switch to generic option ", false);
			}
		} else {
			Assert.fail("There are no drugs added ");
		}

	}

}
