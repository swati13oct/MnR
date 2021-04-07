package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

import pages.mobile.acquisition.commonpages.ComparePlansPageBlayerMobile;

public class DrugCostEstimatorPageMobile extends UhcDriver {

	public DrugCostEstimatorPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@FindBy(xpath ="//div[@id='plan-name-div']/div/div/div/p")
	private WebElement dceplanname;

	// @FindBy(xpath = "//div[@id='drugs-tab']//a[@id='add-drug']")
	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement addDrug;

	@FindBy(xpath = "//*[contains(@id,'build-your-drug-list')]")
	public WebElement step2;

	@FindBy(xpath = "//*[contains(@id,'get-started')]")
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

	@FindBy(xpath = "//input[contains(@id,'drugsearch')]")
	public WebElement drugsearchinput;

	@FindBy(id = "drugcostestimatorHeading") // [contains(text(),'Cost')][contains(text(),'Estimator')]")
	public WebElement validateIntroductoryText;

	@FindBy(id = "drug-alt-search-button")
	public WebElement continueButton;

	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")
	public WebElement SaveDrugPage;

	@FindBy(id = "dce-pharmacy-radius")
	public WebElement milesSelection;

	@FindBy(id = "zipcode")
	public WebElement zipcodeInput; // zipcode in step 2 in dce flow

	@FindBy(id = "cta-zipcode")
	public WebElement zipcodeBtn; // zipcode on acq home page

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
	public WebElement zipSearchBtn;

	@FindBy(id = "pharmacy-form")
	public WebElement pharmacy_form;

	@FindBy(id = "pharmacy-results")
	public WebElement pharmacyResults;

	@FindBy(xpath = "//div[@id='pharmacy-results']//span[contains(@class,'pharmacy-name')]")
	public List<WebElement> pharmacies;

	@FindBy(xpath = ".//*[@id='select-pharmacy-button' or @id='select-pharmacy-button-0']")
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

	@FindBy(xpath = "//*[contains(@id,'review-drug-costs')]")
	public WebElement step3;

	@FindBy(id = "drugcosts")
	private WebElement step3Info;

	@FindBy(id = "drug-cost-card-acq")
	private WebElement drugCostCard;

	@FindBy(xpath = "//*[@id='acqsummary']//div[contains(@class,'dce-acq-step-3-costsection')]")
	private WebElement step3DrugSummaryInfo;

	@FindBy(xpath = "//*[@id='acqsummary']//div[contains(@class,'dce-acq-step-3-pharmacy')]")
	private WebElement step3PharmacySummaryInfo;

	@FindBy(id = "total_annauldeductible")
	public WebElement left_rail_deductible;

	@FindBy(xpath = "//div[@id='drugdetails']/div[1]/div[1]//a[@class='delete-drug']")
	public WebElement first_delete_link;

	@FindBy(xpath = ".//*[@id='mail-service-select']")
	public WebElement btnMailServiceSelect;

	@FindBy(id = "mail-service-type")
	public WebElement lbPreferredMailService;

	@FindBy(xpath = ".//*[@id='total_drugsavings']/div[2]/a")
	public WebElement lkEditDrugsList;

	@FindBy(xpath = ".//*[@id='total_pharmacysavings']/div[2]/a")
	public WebElement lkEditPharmacyList;

	@FindBy(xpath = "//*[@id='atddEditPharmacyList']")
	public WebElement lnkEditPharmacyList;

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

	@FindBy(xpath = "//div[@class='dce-nav-btns']/button[contains(text(),'Delete')]")
	public WebElement confdelpopup_del_button;

	@FindBy(id = "returnLink")
	public WebElement returnLink;

	@FindBy(id = "drugcostestimatorDetails")
	public WebElement description;

	@FindBy(id = "disclaimersHeading")
	public WebElement step1Disclaimers;

	@FindBy(xpath = "//div[@id='collapseDisclaimer']/div/div/div/p")
	public WebElement step1DisclaimerContent;

	@FindBy(xpath = ".//*[@id='disclaimerstep2']/div/div/div/a")
	public WebElement step2Disclaimers;

	@FindBy(id = "collapseDisclaimerStep2")
	public WebElement step2DisclaimerContent;

	@FindBy(id = "show-pharmacy-list")
	public WebElement step3searchButton;

	@FindBy(xpath = ".//*[@id='zip-radios']/div[2]/label")
	public WebElement countySelection;
	
	@FindBy(xpath = "//*[contains(@id,'drugModalPharmacy')]")
	public WebElement countyPopup;

	@FindBy(xpath = "//*[@id='acqsummary']/div[1]/div/h2")
	public WebElement summary;

	@FindBy(xpath = "//a[contains(text(),'Drugs')]")
	public WebElement drugsLink;

	@FindBy(xpath = "//div[2]/a/p")
	public WebElement pharmacyLink;

	@FindBy(xpath = "//a[contains(text(),'Costs')]")
	public WebElement costs;

	@FindBy(xpath = "//a[contains(text(),'Find a Plan')]")
	public WebElement findAPlan;

	@FindBy(id = "step3DisclaimerHome")
	public WebElement step3DisclaimerHome;

	@FindBy(xpath = ".//*[@id='drugdetails']/div[1]/div/div/div/p")
	public WebElement step1Text;

	@FindBy(xpath = ".//*[@id='pharmacymilestext']")
	public WebElement step2Text;

	@FindBy(xpath = "//a[contains(text(),'Return to plans')]")
	public WebElement returnToPlans;

	@FindBy(id = "step3DisclaimerVPP")
	public WebElement step3DisclaimerVPP;

	@FindBy(xpath = ".//*[@id='colhowdoesthiswork_dce']//*[@itemprop='significantLink']/*[@class='cta-button secondary']")
	public WebElement getStarted;

	@FindBy(id = "zipcode-costs")
	public WebElement zipCodeTextBox;

	@FindBy(xpath = ".//*[@id='acqsummary']//a[contains(@class,'show-pharm-selector')]/p")
	public WebElement findPlansButton;
	
	@FindBy(xpath="(//*[@id='zip-radios']/div/label)[1]")
	public WebElement findPlansRadioButton;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	public WebElement SearchButton;
	
	@FindBy(xpath = "//*[contains(@name,'county')]")
	List<WebElement> counties;

	@FindBy(id = "zipcodebtn")
	public WebElement zipcodeFindPlans;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]")
	public WebElement viewPlans;

	@FindBy(xpath = "//nav/ul[@class='uhc-pagination']/li[1]")
	public WebElement pagination_text;

	@FindBy(xpath = "//nav/ul[@class='uhc-pagination']/li[2][@class='disabled']")
	public WebElement leftPaginationDisabled;

	@FindBy(xpath = "//nav/ul[@class='uhc-pagination']/li[3][@class='disableGreyRgtIcon']")
	public WebElement rightPaginationDisabled;

	@FindBy(xpath = "//nav/ul[@class='uhc-pagination']/li[3]/a")
	public WebElement rightPaginationArrow;

	@FindBy(xpath = "//nav/ul[@class='uhc-pagination']/li[2]/a")
	public WebElement leftPaginationArrow;

	@FindBy(xpath = "//li[1]//div[@id='pharInfo']/img")
	public WebElement mapIcon;

	@FindBy(id = "ascOrderPharmacySortId")
	public WebElement AtoZtab;

	@FindBy(id = "descOrderPharmacySortId")
	public WebElement ZtoAtab;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]")
	public WebElement totalDrugSavingsBox;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/span")
	public WebElement drugSavingValue;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/a")
	public WebElement editDrugListLink;

	@FindBy(xpath = ".//*[@id='generic-drug-switch-btn-0']")
	private WebElement switchNowBtn;

	@FindBy(id = "switchToGenericBtnId")
	private WebElement updateBtn;

	@FindBy(id = "total_annualcost_acq")
	private WebElement costText;

	@FindBy(id = "ghn_lnk_2")
	public WebElement ourPlansTab;

	@FindBy(id = "nav-zipcode")
	public WebElement enterZipcode;

	@FindBy(xpath = ".//*[@id='subnav_2']//button[@class='zip-button']")
	public WebElement findPlans;

	@FindBy(id = "atddEditDrugList")
	public WebElement step3EditDrugsList;

	@FindBy(xpath = "//div[@class='loading-dialog'][not (contains(@style,'display: none;'))]")
	public List<WebElement> loadingBlock;

	@FindBy(xpath = "//div[contains(@class,'page__header')]//h1[contains(text(),'Drug')]")
	public WebElement pageHeading;

	@FindBy(id = "drugDosageStrengthId")
	public List<WebElement> drugNamesList;

	@FindBy(id = "pharInfoId-0")
	public WebElement firstPharmacyName;

	@FindBy(xpath = "//div[contains(@class,'pharmacy-list')]//div[contains(@class,'selected')]//address/span")
	public WebElement selectedPharmacyName;

	@FindBy(id = "map")
	public WebElement map;

	@FindBy(id = "showhideMapId")
	public WebElement mapToggle;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public WebElement proactiveChatExitBtn;

	@FindBy(xpath = "//*[contains(@class,'cta-button pharmacy-tab-show')]")
	private WebElement btnNextPickAPharmacy;

	@FindBy(xpath = "//*[contains(@class,'pharmacy-name')]")
	private List<WebElement> lstPharmacyNames;

	@FindBy(xpath = "//button[contains(@id,'select-pharmacy')]")
	private List<WebElement> lstSelectPharmacy;

	@FindBy(xpath = "//*[contains(@dtmname,'view costs')]")
	private WebElement btnViewCost;

	@FindBy(xpath = "//*[contains(text(),'Find a pharmacy within')]")
	private WebElement lblFindAPharmacy;

	@FindBy(xpath = "//*[@id='drugdetails']//p[contains(text(),'drugs to')]")
	private WebElement lblCreateAListOfThePrescriptionDrug;

	@FindBy(xpath = "//*[contains(@id,'drugDosageStrengthId')]//following::a[contains(@id,'generic-drug-switch-btn')]")
	private List<WebElement> lstlinkSwitchNow;

	@FindBy(xpath = "//*[contains(@class,'message-block')]//div[contains(@class,'message-block-body')]//div[2]/div")
	private List<WebElement> lblGenericMsgBox;

	@FindBy(xpath = "//*[@id='atddBackToPlans']")
	private WebElement btnBackToPlans;

	@FindBy(xpath = "//*[contains(@class,'drugName')]")
	private List<WebElement> hdrDrugName;

	@FindBy(xpath = "//*[contains(@class,'margin-large generic-name')]")
	private WebElement lblGenericDrugName;

	@FindBy(id = "backToPlanSummaryTop")
	private WebElement lnkBackToAllPlans;

	@FindBy(xpath = "//*[contains(@src,'loader')]")
	public WebElement imgLoadingIndicator;

	@FindBy(xpath = "//td[contains(@class,'estimatedrugcost')][1]//div")
	public WebElement VerifyEstimatedDrugCost;
	
	@FindBy(xpath = "(//p[text()='Drug Costs from Formulary']//ancestor::th/parent::tr//td[1]//span[@class='ng-scope'])[2]")
	public WebElement planCompareVerifyEstimatedDrugCostValue;
	

	@FindBy(xpath = "//button[contains(@class,'costs-tab-show') and contains(text(),'rofile')]")
	private WebElement btnReturnToProfile;

//	@FindBy(xpath = "//img[@alt='Shopping Cart' and @dtmid='acq_visitor_profile']")
//	private WebElement shoppingCartIcon;
	
	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	public WebElement getImgLoadingIndicator() {
		return imgLoadingIndicator;
	}

	public WebElement getLnkBackToAllPlans() {
		return lnkBackToAllPlans;
	}

	public List<WebElement> getHdrDrugName() {
		CommonUtility.waitForPageLoadNew(driver, step3EditDrugsList, 45);
		return hdrDrugName;
	}

	public WebElement getCostText() {
		return costText;
	}

	public WebElement getBtnBackToPlans() {
		return btnBackToPlans;
	}

	/* Message on drug container, already added drugs */
	public List<WebElement> getLblGenericMsgBox() {
		return lblGenericMsgBox;
	}

	public List<WebElement> getLstlinkSwitchNow() {
		return lstlinkSwitchNow;
	}

	public WebElement getLblCreateAListOfThePrescriptionDrug() {
		return lblCreateAListOfThePrescriptionDrug;
	}

	public WebElement getStep3EditDrugsList() {
		return step3EditDrugsList;
	}

	public WebElement getLblFindAPharmacy() {
		return lblFindAPharmacy;
	}

	public WebElement getBtnViewCost() {
		return btnViewCost;
	}

	public List<WebElement> getLstSelectPharmacy() {
		return lstSelectPharmacy;
	}

	public List<WebElement> getLstPharmacyNames() {
		return lstPharmacyNames;
	}

	public WebElement getMilesSelection() {
		return milesSelection;
	}

	public WebElement getBtnNextPickAPharmacy() {
		return btnNextPickAPharmacy;
	}

	public WebElement getDrugCostCard() {
		return drugCostCard;
	}

	public WebElement getLnkEditPharmacyList() {
		return lnkEditPharmacyList;
	}

	@Override
	public void openAndValidate() {

		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		else
			checkModelPopup(driver, 10);
		validateNew(addDrug);
		validateNew(step1,3);
//		validateNew(step2,3);
//		validateNew(step3,3);

	}

	public AddNewDrugModalMobile clickOnAddDrug() throws InterruptedException {
		addDrug.click();
		if (validateNew(drugsearchinput)) {
			return new AddNewDrugModalMobile(driver);
		}
		return null;
	}

	public void validateAddedDrug(String drug) throws InterruptedException {
		WebElement drugHeading = driver.findElement(By.xpath("//*[contains(@id,'drugDosageStrengthId_')]"));
		Assertion.assertTrue("Drug name not visible", drugHeading.getText().contains(drug.toUpperCase()));
	}

	public void validateAddedDrugNew(String drug) throws InterruptedException {
		if (driver.findElement(By.xpath(
				"//*[starts-with(@id,'drugDosageStrengthId_')][contains(text(),'" + drug.split(" ")[0].trim() + "')]"))
				.isDisplayed())
			Assertion.assertTrue(true);
		else
			Assertion.assertFalse(true);
		// Assertion.assertTrue("Drug name not visible", validateNew(drugHeading));
	}

	public void changeUrlToNewDCEPage() throws InterruptedException {

		String NewDCEUrl;

		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			NewDCEUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/drug-cost-estimator.html";
		} else {
			NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html";
		}

		driver.get(NewDCEUrl);

		Thread.sleep(15000);
	}

	public void deleteDrugs(int i) {
		String deleteDrugXpath = "(//a[text()='Delete'])[" + "i" + "]";
		WebElement deletedrug = driver.findElement(By.xpath(deleteDrugXpath));
		deletedrug.click();

	}

	public void validateintroductorytext() {
		// TODO Auto-generated method stub
		if (validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator."))
			Assertion.assertTrue(true);
		else
			Assertion.assertTrue("Drug Cost Estimator is not present", false);
	}

	public boolean validatedrugheading() {
		// TODO Auto-generated method stub
		if (validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator"))
			return true;
		else
			return false;
	}

	public void navgateToEditDrug(String drug) {
		// editDrug.click();
		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'" + drug
				+ "')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
	}

	public void addDrugs(int count, String drug) throws InterruptedException {
		for (int i = 1; i <= count; i++) {
			AddNewDrugModalMobile addNewDrugModal = clickOnAddDrug();
			if ((getDrugsCount()) == 25 || i == 26) {
				System.out.println("Exceeded the limit");
				addNewDrugModal.verifyExceededError();
				break;
			}
			addNewDrugModal.typeDrugName(drug);
			addNewDrugModal.submit();
			// addNewDrugModal.selectDrug(drug);
			AddDrugDetailsMobile addDrugDetails = new AddDrugDetailsMobile(driver);
			addDrugDetails.selectQnty(i + "");
			addDrugDetails.continueAddDrugDetails();
			SavingsOppurtunityMobile savingsOppurtunity = new SavingsOppurtunityMobile(driver);
			savingsOppurtunity.savedrugbutton();
			Thread.sleep(3000);
		}
	}

	public int getDrugsCount() {
		/*
		 * List<WebElement> drugs = driver .findElements(By.xpath(
		 * "//div[@id='drugs-tab']//div[contains(@ng-repeat,'eachDrug')]"));
		 */

		List<WebElement> drugs = driver.findElements(By.xpath(".//*[@id='acqsummary']/div[3]/div[1]"));
		return drugs.size();
	}

	public void navigateToStep2() throws InterruptedException {
		validateNew(step2);
		step2.click();

	}

	public void backwardToStep1() {
		step1.click();
	}

	public void validatePharmacyForm() {
		Assertion.assertTrue(pharmacyform.isDisplayed());
		// Assertion.assertTrue(rbStandardNetwork.isDisplayed());
		// Assertion.assertTrue(rbPharmacySaver.isDisplayed());
		// Assertion.assertTrue(rbPreferredMailService.isDisplayed());
		// Assertion.assertTrue(rbPreferredRetail.isDisplayed());
	}

	public void pharmacyInformation(String zipcode, String radius) {
		CommonUtility.waitForPageLoadNew(driver, zipcodeInput, 30);
		sendkeys(zipcodeInput, zipcode);
		zipSearchBtn.click();
		CommonUtility.waitForPageLoadNew(driver, zipcodeInput, 45);
		Select options = new Select(milesSelection);
		options.selectByVisibleText(radius);

		CommonUtility.waitForPageLoadNew(driver, firstPharmacyName, 45);
		validateNew(mapToggle);
	}
	
	/**
	 * @toDo: verify the plan name is coming or not
	 * @param plantype
	 * @return
	 */
	public DrugCostEstimatorPageMobile verifyplanname(String planname) {

		if(dceplanname.equals(planname)){
				return new DrugCostEstimatorPageMobile(driver);
		}else{

			return null;
			}

	}

	public boolean validatemesgmoredrugsothertext(String otherscount) {
		// TODO Auto-generated method stub

		System.out.println("--------------" + mesgMoreDrugsOther.getText());
		if (mesgMoreDrugsOther.getText().contentEquals(otherscount))
			// mesgMoreDrugsOther.getText().contentEquals(cs)
			return true;
		else
			return false;
	}

	public void validateenterdrugtext() {
		Assertion.assertTrue(Enter_drug_text.isDisplayed());
	}

	public void validatesummaryheading() {

		Assertion.assertTrue(SummaryHeader.isDisplayed());
	}

	public boolean validatetabdrugheading() {
		// TODO Auto-generated method stub

		if (drugTab.getText().equalsIgnoreCase("DRUGS")) {

			return true;
		} else
			return false;
	}

	public void validateDrugsnotPresent(String dosage) {

		String deleteDrugXpath = "//div[@id='drugs-tab']//p[contains (text(), '" + dosage + "')]";
		try {
			driver.findElement(By.xpath(deleteDrugXpath));
			Assertion.assertFalse(true);
		} catch (NoSuchElementException e) {
			Assertion.assertFalse(false);
		}

	}

	public void deleteDrugsByDosage(String dosage) throws InterruptedException {
		Thread.sleep(5000);
		String deleteDrugXpath = "//div[@id='drugs-tab']//p[contains (text(), '" + dosage
				+ "')]/following-sibling::ul//li/a[@class='delete-drug']";
		WebElement deletedrug = driver.findElement(By.xpath(deleteDrugXpath));
		deletedrug.click();
		Thread.sleep(3000);
		waitforElement(confdelpopup_del_button);
		confdelpopup_del_button.click();
		Thread.sleep(3000);

	}

	public EditDrugDetailsMobile navigateToEditDrug(String drug) throws Exception {
		// editDrug.click();
		Thread.sleep(10000);
		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'" + drug
				+ "')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
		Thread.sleep(15000);
		return new EditDrugDetailsMobile(driver);
	}

	public boolean validateAddedDrug(String args1, String arg2, String arg3) {

		validate(driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1
				+ "')]/following-sibling::p/span[contains(text(),'" + arg2 + "')]")));

		driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1 + "')]")).getText()
				.contains(arg2);
		driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1 + "')]")).getText()
				.contains(arg3);

		// driver.findElements(By.xpath("//div[@id='drugs-tab']//p[contains
		// (text(), '"+args1+"')]).gettext();
		return true;
	}

	public boolean validatedrugdosagetext(String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		if (drugndosage1.getText().equalsIgnoreCase(arg1) && drugndosage2.getText().equalsIgnoreCase(arg2)
				&& drugndosage3.getText().equalsIgnoreCase(arg3))
			return true;
		else
			return false;
	}

	public void verifyPhamaciesRadisInfo(List<String> miles) {
		System.out.println("Expected List is : " + miles);
		Select select = new Select(milesSelection);
		List<WebElement> elements = select.getOptions();
		List<String> actualList = new ArrayList<String>();
		for (WebElement element : elements) {
			actualList.add(element.getText());
		}
		System.out.println("Acutal List is : " + actualList);
		Assertion.assertEquals(miles, actualList);
	}

	public void validateZipcode(String zipcode) {
		Assertion.assertEquals(zipcode, zipcodeInput.getText());
	}

	public void selectRadius() {
		int index = 5;
		Select options = new Select(milesSelection);
		options.selectByIndex(index);
		// options.getAllSelectedOptions();
	}

	public void validateselectRadius() throws InterruptedException {
		Select options = new Select(milesSelection);
		for (int i = 0; i < 6; i++) {
			options.selectByIndex(i);
			Thread.sleep(5000);
			// options.getAllSelectedOptions();

		}
	}

	public void selectZipcode(String zipcode) {
		sendkeys(zipcodeInput, zipcode);
	}

	public void validateDefaultStep2(String zipcode, String radius, String pharmacy_type) {
		System.out.println("--------zipcodeInput.getText()-----------" + zipcodeInput.getText());
		// Assertion.assertEquals(zipcode,zipcodeInput.getText());

		WebElement selected_pharmacy_type = driver
				.findElement(By.xpath("//label[contains(text(),'" + pharmacy_type + "')]/parent::div/input"));
		Assertion.assertTrue(selected_pharmacy_type.isSelected());
		Select options = new Select(milesSelection);

		WebElement selected_miles = driver
				.findElement(By.xpath(".//*[@id='dce-pharmacy-radius']/option[contains(text(),'" + radius + "')]"));
		Assertion.assertTrue(selected_miles.isSelected());
		// String str = options.getAllSelectedOptions().toString();
		// str.toString();
		System.out.println("--------options.getAllSelectedOptions()-----------" + options.getAllSelectedOptions()
				+ "----------------");
		// System.out.println("--------str-----------"+ str +
		// "----------------");
		// Assertion.assertEquals(pharmacy_type,str);

	}

	@SuppressWarnings("unchecked")
	public void selectPharmacyType(String pharmacy) throws InterruptedException {

		List<WebElement> rbtn = driver
				.findElements(By.xpath(".//*[@id='pharmacy-type']//*[contains(text(),'" + pharmacy + "')]"));

		WebElement rbtnValue = rbtn.get(0);
		rbtnValue.isDisplayed();
		if (!rbtnValue.isSelected()) {
			jsClickNew(rbtnValue); // kept to get rid of overlay issue
			validateNonPresenceOfElement(getImgLoadingIndicator());
			// rbtnValue.click();
			System.out.println("RBTN " + pharmacy + " >> Selected");
		} else {
			System.out.println("RBTN " + pharmacy + " >> already selected");
		}

		Thread.sleep(5000);
	}

	public void validateselectPharmacyType() throws InterruptedException {
		for (int i = 1; i < 5; i++) {
			WebElement rbtn = driver.findElement(By.xpath(".//*[@id='pharmacy-type']/div[" + i + "]/label"));
			rbtn.isDisplayed();
			if (!rbtn.isSelected()) {
				rbtn.click();
				Thread.sleep(2000);
				System.out.println("RBTN " + i + " >> Selected");
			} else
				System.out.println("RBTN " + i + " >> already selected");
		}

	}

	public void clickstep2Search() throws InterruptedException {
		Thread.sleep(12000);
		zipSearchBtn.click();

	}

	public void verifyPharmacyResults() throws InterruptedException {
		Assertion.assertTrue(pharmacyResults.isDisplayed());
		Thread.sleep(5000);
	}

	public int getResultPharmacyCount() {
		return pharmacies.size();
	}

	public void validatePharmacylist() {
		Assertion.assertEquals(3, pharmacies.size());
	}

	public void select_first_pharmacy() throws InterruptedException {
		String firstPharmacyText = firstPharmacyName.getText().trim();
		validateNew(select_btn_first);
		System.out.println("first pharmacy");
		jsClickNew(select_btn_first);
		validateNew(selectedPharmacyName);
		String selectedPharmacyText = selectedPharmacyName.getText().trim();
		Assertion.assertTrue("Selected Pharmacy name not matches", firstPharmacyText.contains(selectedPharmacyText));
	}

	public void validate_cost_saving_present(String pharmacy_type) {
		if (pharmacy_type == "Standard Network") {
			validate_cost_saving_not_present();
		} else if (pharmacy_type == "Pharmacy Saver") {
			Assertion.assertTrue(card_promo_blue_saver.isDisplayed());
		} else if (pharmacy_type == "Preferred Mail Service") {
			Assertion.assertTrue(card_promo_blue_mail.isDisplayed());
		} else if (pharmacy_type == "Preferred Retail") {
			Assertion.assertTrue(card_promo_blue_retail.isDisplayed());
		}
	}

	public void validate_cost_saving_not_present() { // Need refactoring
		Assertion.assertFalse(card_promo_blue_saver.isDisplayed());
		Assertion.assertFalse(card_promo_blue_mail.isDisplayed());
		Assertion.assertFalse(card_promo_blue_retail.isDisplayed());
	}

	public boolean validate_pharmacy_type_saver_not_present() {
		// Assertion.assertFalse(pharmacy_saver_type.isEnabled());

		try {
			driver.findElement(By.id("saver-type"));
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}

	public void validate_pharmacy_saver_result() {
		// Assertion.assertTrue(text_total_annual_drug_cost.isDisplayed());
		// text_total_annual_drug_cost.getSize()
	}

	public boolean validate_selected_pharmacy_type(String pharmacy_type) {
		if (pharmacy_type == "Preferred Retail") {
			Assertion.assertTrue(pharmacy_type + "is not selected", pharmacy_retail_type.isSelected());
			return true;
		} else if (pharmacy_type == "Pharmacy Saver") {
			Assertion.assertTrue(pharmacy_type + "is not selected", pharmacy_saver_type.isSelected());
			return true;
		} else if (pharmacy_type == "Standard Network") {
			Assertion.assertTrue(pharmacy_type + "is not selected", pharmacy_standard_type.isSelected());
			return true;
		} else
			return false;
	}

	public boolean validate_pharmacy_type_not_present(String pharmacy_type) {
		if (pharmacy_type == "Preferred Retail") {
			if (driver.findElements(By.id("pharmacy_retail_type")).size() < 1)
				return true;
			else
				return false;
		} else if (pharmacy_type == "Pharmacy Saver") {
			if (driver.findElements(By.id("pharmacy_saver_type")).size() < 1)
				return true;
			else
				return false;
		} else if (pharmacy_type == "Standard Network") {
			if (driver.findElements(By.id("pharmacy_standard_type")).size() < 1)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean verify_preferred_retail_pharmacy_result() {
		String first_phar_result_record = first_pharmacy_record.getText();
		if (first_phar_result_record.contains("Walgreens") && first_phar_result_record.contains("3320 Chino Hills Pkwy")
				&& first_phar_result_record.contains("2.81 mi.")) {
			return true;
		}

		else
			return false;
	}

	public void pharmacyInformation(String zipcode) {
		validate(zipcodeInput);
		sendkeys(zipcodeInput, zipcode);
		zipSearchBtn.click();
	}

	public void validatePreferredMailServiceNotPresent() {
		List<WebElement> mailService = driver.findElements(By.id("mail-service-type"));
		if (mailService.get(0).isDisplayed()) {
			Assertion.assertFalse("Preferred Mail Servic pharmacy type is present", true);
		} else {
			Assertion.assertFalse(false);
		}
	}

	public void validatePreferredMailServiceRD() {
		try {
			Assertion.assertTrue(lbPreferredMailService.isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assertion.assertFalse(false);
		}
	}

	public void select_first_pharmacy_result() throws InterruptedException {
		// waitforElement(first_pharmacy_select_btn);
		Thread.sleep(10000);
		first_pharmacy_select_btn.click();
		Thread.sleep(15000);
	}

	public void verify_summary_cost(String total_cost) { // waitforElement(summary_tot_cost);
															// String temp =
															// validateIntroductoryText.getText().equalsIgnoreCase("Drug
															// Cost Estimator")
		Assertion.assertTrue("Expected Summary cost is  not present" + summary_tot_cost.getText(),
				summary_tot_cost.getText().equalsIgnoreCase(total_cost));

	}

	public void verify_summary_saving(String total_saving) throws InterruptedException {
		Thread.sleep(5000);
		waitforElement(summary_saving);
		Assertion.assertTrue("Expected" + total_saving + " Total saving is not present" + summary_saving.getText(),
				summary_saving.getText().contains(total_saving));
	}

	public void verify_deductible(String deductible) {
		waitforElement(left_rail_deductible);
		Assertion.assertTrue("Expected Deductible is not present", left_rail_deductible.getText().contains(deductible));
	}

	public void verify_leftrail_cost(String total_cost) throws InterruptedException {
		Thread.sleep(10000);
		waitforElement(left_rail_tot_cost);
		Assertion.assertTrue("Expected Left rail Total Cost is not present",
				left_rail_tot_cost.getText().contains(total_cost));
	}

	public void verify_leftrail_saving(String total_saving) {
		waitforElement(left_rail_tot_saving);
		Assertion.assertTrue("Expected Left rail Total Savings is not present",
				left_rail_tot_saving.getText().contains(total_saving));
	}

	public void verify_leftrail_drug_saving(String drug_saving) {
		waitforElement(left_rail_drug_saving);
		Assertion.assertTrue("Expected Drug Saving is not present", left_rail_drug_saving.getText().contains(drug_saving));
	}

	public void verify_leftrail_pharmacy_saving(String pharmacy_saving) {
		waitforElement(left_rail_pharmacy_saving);
		Assertion.assertTrue("Expected Pharmacy saving is not present",
				left_rail_pharmacy_saving.getText().contains(pharmacy_saving));
	}

	public void navigateToStep3() throws InterruptedException {

		if (!(loadingBlock.isEmpty())) {
			waitforElementDisapper(By.className("loading-dialog"), 60);
		}
		validateNew(step3);
		step3.click();
	}

	public void delete_all_drugs() throws InterruptedException {

		while (driver.findElements(By.className("delete-drug")).size() > 0) {
			first_delete_link.click();
			Thread.sleep(2000);
		}
	}

	public void fillPharmacyInfo() {
		// rbStandardNetwork.click();// select pharmacy type standard network
		if (select_btn_first.isDisplayed()) {
			select_btn_first.click();// select a pharmacy
		}
	}

	public AddDrugDetailsMobile addDrug(String drug) throws InterruptedException {

		AddNewDrugModalMobile addNewDrugModal = clickOnAddDrug();
		return addNewDrugModal.searchDrugWithoutAutoComplete(drug);
		/*
		 * addNewDrugModal.closeModalWindow(); clickOnAddDrug();
		 * addNewDrugModal.searchDrugWithAutoComplete(drug);
		 */
		// return new AddDrugDetails(driver); //commented because two times reference is
		// written, rectified the issue
	}

	public void validateDrugSavingInfo() {
		if (totalDrugSavingsBox.isDisplayed()) {

			if (drugSavingValue.isDisplayed() && editDrugListLink.isDisplayed()) {
				System.out.println("All of the info for drug savings is displayed under the box on the left rail");
			}

		} else
			System.out.println("The Drug Cost Savings Info on the left rail is not displayed");
	}

	public void clickOnEditDrugListLink() {
		editDrugListLink.click();
	}

	public void deleteAllDrugs() throws InterruptedException {

		int drugCount = getDrugsCount();
		while (getDrugsCount() != 0) {
			// String deleteDrugXpath =
			// ".//*[@id='drugdetails']/div[1]/div[1]/div/div/section/ul/li[2]/a";
			// WebElement deleteDrug =
			// driver.findElement(By.xpath(deleteDrugXpath));
			// deleteDrug.click();
			// deleteDrug();

			String deleteDrugXpath = ".//*[@id='drugdetails']/div[2]/div[" + drugCount + "]/div/div/section/ul/li[2]/a";
			WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));

			deleteDrug.click();
			WebElement deleteButtonXpath = driver
					.findElement(By.xpath(".//*[@id='drugModal']/div/div/div[2]/div/section/div/button[2]"));
			waitforElement(deleteButtonXpath);
			deleteButtonXpath.click();
			drugCount--;
			Thread.sleep(5000);
		}
	}

	public void deleteDrug() throws InterruptedException {

		String deleteDrugXpath = ".//*[@id='drugdetails']/div[2]/div[3]/div/div/section/ul/li[2]/a";
		WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));

		deleteDrug.click();
		WebElement deleteButtonXpath = driver
				.findElement(By.xpath(".//*[@id='drugModal']/div/div/div[2]/div/section/div/button[2]"));
		waitforElement(deleteButtonXpath);
		deleteButtonXpath.click();
		Thread.sleep(5000);
	}

	public void addGenericDrug(String drug) throws InterruptedException {
		AddNewDrugModalMobile addNewDrugModal = clickOnAddDrug();
		if ((getDrugsCount()) == 25) {
			addNewDrugModal.verifyExceededError();
			// break;
		}
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		// addNewDrugModal.selectDrug(drug);
		AddDrugDetailsMobile addDrugDetails = new AddDrugDetailsMobile(driver);
		// addDrugDetails.selectQnty(60 + "");
		addDrugDetails.continueAddDrugDetails();
		SavingsOppurtunityMobile savingsOppurtunity1 = new SavingsOppurtunityMobile(driver);
		savingsOppurtunity1.switchToGeneric();
		savingsOppurtunity1.savedrugbutton();
		Thread.sleep(3000);

	}

	public void validateTotalEstimatedAnnualDrugCosts(String totalAnnualDrugCost) throws InterruptedException {
		Thread.sleep(10000);
		Thread.sleep(5000);
		List<WebElement> totDrugCost_Summary = driver.findElements(By.xpath(".//*[@id='summary_totalCost']"));
		List<WebElement> totDrugCost_LeftRail = driver.findElements(By.xpath(".//*[@id='total_annualcost']"));

		if (totDrugCost_Summary.size() > 0 & totDrugCost_LeftRail.size() > 0) {
			String valTotDrugCost_Summary = totDrugCost_Summary.get(0).getText();
			String valtotDrugCost_LeftRail = totDrugCost_LeftRail.get(0).getText();
			// System.out.println("given value "+totalAnnualDrugCost);
			// System.out.println("summary value "+valTotDrugCost_Summary);
			// System.out.println("left rail value "+ valtotDrugCost_LeftRail);
			Assertion.assertEquals(valTotDrugCost_Summary, valtotDrugCost_LeftRail);
			Assertion.assertEquals(totalAnnualDrugCost, valTotDrugCost_Summary);
			Assertion.assertEquals(totalAnnualDrugCost, valtotDrugCost_LeftRail);
		} else {
			Assertion.assertTrue(false);
		}

	}

	public void validatetotalAvailableSavings(String totalAvailableSavings) {
		List<WebElement> totAvailableSav_Summary = driver.findElements(By.xpath(".//*[@id='summary_savings']/span"));
		List<WebElement> totAvailableSav_LeftRail = driver
				.findElements(By.xpath(".//*[@id='total_availablesavings']/section/span"));

		if (totAvailableSav_Summary.size() > 0 & totAvailableSav_LeftRail.size() > 0) {
			String valTotAvailableSav_Summary = totAvailableSav_Summary.get(0).getText();
			String valTotAvailableSav_LeftRail = totAvailableSav_LeftRail.get(0).getText();
			// System.out.println("totAvailableSav summary value "+
			// valTotAvailableSav_Summary);
			// System.out.println("totAvailableSav left rail value "+
			// valTotAvailableSav_LeftRail);
			Assertion.assertEquals(valTotAvailableSav_Summary, valTotAvailableSav_LeftRail);
			Assertion.assertEquals(totalAvailableSavings, valTotAvailableSav_Summary);
			Assertion.assertEquals(totalAvailableSavings, valTotAvailableSav_LeftRail);

		} else {
			Assertion.assertTrue(false);
		}

	}

	public void validateDrugSavings(String drugSavings) {
		List<WebElement> totDrugSavings = driver.findElements(By.xpath(".//*[@id='total_drugsavings']/div[2]/span"));

		if (totDrugSavings.size() > 0) {
			String valTotDrugSavings = totDrugSavings.get(0).getText();
			// System.out.println("totDrugSavings value "+ valTotDrugSavings);
			Assertion.assertEquals(drugSavings, valTotDrugSavings);

		} else {
			Assertion.assertTrue(false);
		}

	}

	public void validatePharmacySavings(String pharmacySavings) {
		List<WebElement> totPharmacySavings = driver
				.findElements(By.xpath(".//*[@id='total_pharmacysavings']/div[2]/span"));

		if (totPharmacySavings.size() > 0) {
			String valTotPharmacySavings = totPharmacySavings.get(0).getText();
			// System.out.println("totPharmacySavings value "+
			// valTotPharmacySavings);
			Assertion.assertEquals(pharmacySavings, valTotPharmacySavings);
		} else {
			Assertion.assertTrue(false);
		}
	}

	public void validateDrugCoverage(String drugCoverage) {
		List<WebElement> initialDrugCoverage = driver.findElements(
				By.xpath(".//*[@id='drugcosts']/div[2]/div[2]/div/div[2]/div/div/section/div[2]/div[2]/p/span"));
		List<WebElement> coverageGapStage = driver.findElements(
				By.xpath(".//*[@id='drugcosts']/div[2]/div[2]/div/div[2]/div/div/section/div[2]/div[3]/p/span"));
		List<WebElement> catastrophicCoverageStage = driver.findElements(
				By.xpath(".//*[@id='drugcosts']/div[2]/div[2]/div/div[2]/div/div/section/div[2]/div[4]/p/span"));
		if (initialDrugCoverage.size() > 0 && coverageGapStage.size() > 0 && catastrophicCoverageStage.size() > 0) {
			String valInitialDrugCoverage = initialDrugCoverage.get(0).getText();
			String valCoverageGapStage = coverageGapStage.get(0).getText();
			String valCatastrophicCoverageStage = catastrophicCoverageStage.get(0).getText();
			// System.out.println("valInitialDrugCoverage value
			// "+valInitialDrugCoverage);
			Assertion.assertEquals(drugCoverage, valInitialDrugCoverage);
			Assertion.assertEquals(drugCoverage, valCoverageGapStage);
			Assertion.assertEquals(drugCoverage, valCatastrophicCoverageStage);
		} else {
			Assertion.assertTrue(false);
		}
	}

	public void validateEditDrugAndPharmacyLinks() {
		Assertion.assertTrue(elementFound(lkEditDrugsList));
		Assertion.assertTrue(elementFound(lkEditPharmacyList));
	}

	public void validateEditDrugLinkNotPresent() {
		List<WebElement> editDrugLink = driver.findElements(By.xpath(".//*[@id='total_drugsavings']/div[2]/a"));
		// String valEditDrugLink = editDrugLink.get(0).getText();
		if (!editDrugLink.get(0).isDisplayed()) {
			Assertion.assertFalse(false);
		} else {
			Assertion.assertFalse("Edit Drug Link is present", true);
		}
	}

	public void select_pharmacy_if_not_selected() throws InterruptedException {
		if (pharmacyContainer.getText().contains("Selected")) {
			System.out.println("One of the Pharmacy is already selected");
		}

		else
			select_first_pharmacy_result();

	}

	public void clicklearnmoreTiersLink() throws InterruptedException {
		learnmoreTiers.click();
		Thread.sleep(3000);
	}

	public void clicklearnmoreStagesLink() throws InterruptedException {
		learnmoreStages.click();
		Thread.sleep(3000);
	}

	public void verifystagesTexts() {

		String all_text = stagesTexts.getText();
		Assertion.assertTrue("Annual Deductible Stage heading is not present",
				all_text.contains("Annual Deductible Stage"));
		Assertion.assertTrue("Initial Coverage Stage heading is not present", all_text.contains("Initial Coverage Stage"));
		Assertion.assertTrue("Catastrophic Coverage Stage heading is not present",
				all_text.contains("Catastrophic Coverage Stage"));
	}

	public void verifyTiersTexts(String year, String layer, String plan) {

		String all_text = tierTexts.getText();
		Assertion.assertTrue(year + " is not present", all_text.contains(year));
		Assertion.assertTrue(layer + " is not present", all_text.contains(layer));
		Assertion.assertTrue(plan + " is not present", all_text.contains(plan));
	}

	public void selectPharmacyMailServicePharmacy() throws InterruptedException {

		// String all_text = pharmacyResults.getText();

		if (pharmacyResults.getText().contains("Preferred Mail Service")) {
			mail_service_select_btn.click();

			Thread.sleep(4000);

			Assertion.assertTrue("Preferred Mail Service Pharmacy is not selected",
					SelectedName.getText().contains("Preferred Mail Service Pharmacy"));
		}

	}

	public void click_learnMoreHomeDeliveryLink() throws InterruptedException

	{
		learnMoreHomeDelivery.click();
		Thread.sleep(3000);
	}

	public void verifyLearnMoreDeliveryContent(String content) {
		homeDeliveryContent.getText().contains(content);
		Assertion.assertTrue(content + "is not present", homeDeliveryContent.getText().contains(content));
	}

	public void isPharmacySelected() {
		// List<WebElement> selectedPharmacy =
		// driver.findElements(By.className("pharmacy-container"));
		String valselectedPharmacy = selectedPharmacy.getText();
		if (valselectedPharmacy.equals("Select a pharmacy to see your drug costs") || valselectedPharmacy.equals(" ")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("No pharmacy is selected", false);
		}
	}

	public void validatePharmacySelected() {
		// List<WebElement> selectedPharmacy =
		// driver.findElements(By.className("pharmacy-container"));
		/*
		 * String valselectedPharmacy = selectedPharmacy.getText(); if
		 * (!valselectedPharmacy. equals("Select a pharmacy to see your drug costs") ||
		 * !valselectedPharmacy.equals(" ")) { Assertion.assertTrue(true); } else {
		 * Assertion.assertTrue("Pharmacy is selected",false); }
		 */
		// .//*[@id='drugspharmacy']/div[3]/ul[2]/li/div/div[2]/span

		List<WebElement> selectedPharmacy = driver
				.findElements(By.xpath(".//*[@id='drugspharmacy']/div[3]/ul[2]/li/div/div[2]/span"));
		System.out.println("selectedPharmacy size" + selectedPharmacy.size());
		if (selectedPharmacy.get(0).isDisplayed()) {
			Assertion.assertTrue("Pharmacy is selected", false);
		} else {
			Assertion.assertTrue(true);
		}
	}

	public void validateSwitchGenericOption() {

		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			WebElement switchGenericOption = driver.findElement(By.id("generic-drug-" + (drugscount - 1)));
			System.out.println("switch generic option" + switchGenericOption.getText());
			if (switchGenericOption.isDisplayed()) {
				Assertion.assertTrue(true);
			} else {
				Assertion.assertTrue("Drug does not have switch to generic option ", false);
			}
		} else {
			Assertion.assertTrue("There are no drugs added ", false);
		}

	}

	public void validateSwitchNowLink() {
		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-" + (drugscount - 1)));
			if (switchNowLink.isDisplayed()) {
				Assertion.assertTrue(true);
			} else {
				Assertion.assertTrue("Switch now link is not present", false);
			}

		} else {
			Assertion.assertTrue("There are no drugs added ", false);
		}

	}

	public void validateSaveGenericMessage() {
		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			List<WebElement> saveGenericMessage = driver
					.findElements(By.id("generic-drug-saving-amount-" + (drugscount - 1)));
			String valSaveGenericMessage = saveGenericMessage.get(0).getText();
			if (valSaveGenericMessage.equals("Save money")) {
				Assertion.assertTrue(true);
			} else {
				Assertion.assertTrue("Save money message is incorect", false);
			}

		} else {
			Assertion.assertTrue("There are no drugs added ", false);
		}

	}

	public void validateSaveDollarValueMessage() throws InterruptedException {
		int drugscount = getDrugsCount();
		Thread.sleep(10000);
		if (drugscount > 0) {
			List<WebElement> saveGenericMessage = driver
					.findElements(By.id("generic-drug-saving-amount-" + (drugscount - 1)));
			String valSaveGenericMessage = saveGenericMessage.get(0).getText();
			if (!valSaveGenericMessage.equals("Save money")) {
				Assertion.assertTrue(true);
			} else {
				Assertion.assertTrue("Save dollar amount message is incorect", false);
			}

		} else {
			Assertion.assertTrue("There are no drugs added ", false);
		}

	}

	public void clickSwitchNow() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, costText, 30);
		String brandedCost = costText.getText();
		step3EditDrugsList.click();
		System.out.println(brandedCost);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", switchNowBtn);
		CommonUtility.waitForPageLoad(driver, updateBtn, 60);
		js.executeScript("arguments[0].click();", updateBtn);
		navigateToStep3();
		if (!(loadingBlock.isEmpty())) {
			CommonUtility.waitForElementToDisappear(driver, loadingBlock.get(0), 60);
		}
		Thread.sleep(3000);
		String genericCost = costText.getText();
		System.out.println(genericCost);
		if (brandedCost.equals(genericCost))
			Assertion.fail("Error in calculating costs after switching to generic");
	}

	public void clickSwitchToGeneric() throws InterruptedException {
		WebElement btnSwitchToGeneric = driver.findElement(By.id("switchToGenericBtnId"));
		btnSwitchToGeneric.click();
		Thread.sleep(3000);
	}

	public void isGeneric() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> lbGenericdrug = driver.findElements(By.id("drugDosageStrengthId"));
		int drugsCount = getDrugsCount();
		if (drugsCount > 0) {
			String[] genericDrug = lbGenericdrug.get(drugsCount - 1).getText().split(" ");
			if (genericDrug[0].equalsIgnoreCase("ATORVASTATIN")) {
				Assertion.assertTrue(true);
			} else {
				Assertion.assertTrue("Branded drug is not switched to generic drug", false);
			}

		} else {
			Assertion.assertTrue("There are no drugs added ", false);
		}
	}

	public void validateStep1Item() {
		validateintroductorytext();
		Assertion.assertTrue("returnLink is not present", returnLink.isDisplayed());
		Assertion.assertTrue("description text is not present", description.isDisplayed());
		Assertion.assertTrue("step1 text is not present", step1.isDisplayed());
		Assertion.assertTrue("step2 text is not present", step2.isDisplayed());
		Assertion.assertTrue("step3 text is not present", step3.isDisplayed());

	}

	public void validateStep1Disclaimer() throws InterruptedException {
		Assertion.assertTrue(step1Disclaimers.isDisplayed());
		step1Disclaimers.click();
		waitforElement(step1Disclaimers);
		Assertion.assertTrue("disclaimerContent is not present", step1DisclaimerContent.isDisplayed());
		step1Disclaimers.click();
		Thread.sleep(5000);
		Assertion.assertFalse("disclaimerContent is present", step1DisclaimerContent.isDisplayed());
	}

	public void validateStep2Disclaimer() throws InterruptedException {
		Assertion.assertTrue(step2Disclaimers.isDisplayed());
		step2Disclaimers.click();
		waitforElement(step2DisclaimerContent);
		Assertion.assertTrue("disclaimerContent is not present", step2DisclaimerContent.isDisplayed());
		step2Disclaimers.click();
		Thread.sleep(5000);
		Assertion.assertFalse("disclaimerContent is present", step2DisclaimerContent.isDisplayed());
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

	public void navigateToDCEToolFromHome() throws InterruptedException {

		//driver.manage().window().maximize();
		getStarted.click();

	}

	public void navigateToDCEToolFromvpp(String zipcode) throws InterruptedException {

		/*
		 * String Current_url = driver.getCurrentUrl(); String NewDCEUrl;
		 * 
		 * if (driver.getCurrentUrl().contains("aarpmedicareplans")) { NewDCEUrl =
		 * "https://www.team-b-aarpmedicareplans.uhc.com/drugcostestimatoracquisition.html#/drug-cost-estimator";
		 * 
		 * //https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/
		 * home/drug-cost-estimator.html } else { NewDCEUrl =
		 * "https://www.team-b-uhcmedicaresolutions.uhc.com/content/uhcmedicaresolutions/en/drugcostestimatoracquisition.html";
		 * }
		 * 
		 * driver.get(NewDCEUrl);
		 */
		//driver.manage().window().maximize();
		zipcodeBtn.sendKeys(zipcode);
		zipcodeFindPlans.click();

		Thread.sleep(15000);

		viewPlans.click();
		Thread.sleep(5000);
		List<WebElement> enterDrugInformation = driver.findElements(By.id("maDCELink"));
		enterDrugInformation.get(0).click();
		Thread.sleep(1000);

	}

	public void validateSummary() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String summaryActual = summary.getText();
		if (summaryActual.contains("Summary")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Summary heading does not show up", false);
		}
	}

	public void validateDrugs() {
		String drugActual = drugsLink.getText();
		if (drugActual.contains("Drugs")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Drugs link does not show up", false);
		}
		drugsLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (step1Text.getText().contains("Create a list")) {
			step3.click();
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Unable to navigate to Step 1", false);
		}
	}

	public void validatePharmacy() {
		String pharmacyActual = pharmacyLink.getText();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, pharmacyLink, 60);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(pharmacyLink));

		if (pharmacyActual.equalsIgnoreCase("Pharmacy")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Pharmacy link does not show up", false);
		}
		pharmacyLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (step2Text.getText().contains("Find a pharmacy")) {
			step3.click();
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Unable to navigate to Step 2", false);
		}

	}

	public void validateCosts() {
		String costsActual = costs.getText();
		if (costsActual.contains("Costs")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Costs link does not show up", false);
		}

		returnToPlans.click();
		if (driver.getCurrentUrl().contains("health-plans.html")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Unable to navigate to VPP page from DCE tool", false);
		}

	}

	public void validateFindAPlan() {
		String findAPlanActual = findAPlan.getText();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (findAPlanActual.contains("Find a Plan")) {
			Assertion.assertTrue(true);
		} else {
			Assertion.assertTrue("Find a Plan link does not show up", false);
		}

	}

	public void validateDisclaimers() {
		String disclaimersActual = step3DisclaimerHome.getText();
		String disclaimersActual1 = step3DisclaimerVPP.getText();
		if (disclaimersActual.contains("Disclaimer")) {
			step3DisclaimerHome.click();
		} else if (disclaimersActual1.contains("Disclaimer")) {
			step3DisclaimerVPP.click();
		}
	}

	public VPPPlanSummaryPageMobile validateMultiCountyPopup(String zipCode, String county) {
		checkModelPopup(driver);
		sendkeys(zipCodeTextBox, zipCode);
		findPlansButton.click();
		

		if (validate(countyPopup)&& counties.size() > 1) {
			for (WebElement countyElement : counties) {
				String elementId = countyElement.getAttribute("id");
				if (elementId.contains(county)) {
					countyElement.click();
					System.out.println("county clicked");
				}
			}
			step3searchButton.click();
		}
		CommonUtility.waitForPageLoadNew(driver, maPlansCount, 60);
		return new VPPPlanSummaryPageMobile(driver);
		
	}

	public void populateZipCode(String zipcode) {
		sendkeys(zipcodeInput, zipcode);
		zipSearchBtn.click();
	}

	public int getPaginationText() {
		String pgText = pagination_text.getText();
		int page = Integer.parseInt(pgText.substring(9).trim());
		return page;
	}

	public void validatePaginationPresent() {
		waitforElement(pagination_text);
	}

	public void validatePagination() throws InterruptedException {
		int pagesize = getPaginationText();
		Assertion.assertTrue("Initially left pagination arrow is not disabled", leftPaginationDisabled.isDisplayed());
		for (int i = 0; i < pagesize; i++) {
			rightPaginationArrow.click();
			Thread.sleep(4000);
		}
		Assertion.assertTrue("After reaching the last pagination right arrow is not disabled",
				rightPaginationDisabled.isDisplayed());

		for (int i = 0; i < pagesize; i++) {
			leftPaginationArrow.click();
			Thread.sleep(4000);
		}
		Assertion.assertTrue("After moving to first pagination left arrow is not disabled",
				leftPaginationDisabled.isDisplayed());

	}

	public void validateMapIcon() {
		List<WebElement> mapNumber = driver.findElements(By.id("pharmacyIndex"));
		validateNew(mapIcon);

		if (mapIcon.getAttribute("src").contains("images/icon-svgs/mapmarker-pin-blue.svg")) {
			System.out.println("-----------mapIcon.getAttribute()-----" + mapIcon.getAttribute("src"));
			Assertion.assertTrue(true);
		} else
			Assertion.assertTrue(false);

		Assertion.assertTrue("1 map number is not present", mapNumber.get(0).getText().contains("1"));
		System.out.println("----mapNumber.get(0).getText()--------" + mapNumber.get(0).getText());
		Assertion.assertTrue("2 map number is not present", mapNumber.get(1).getText().contains("2"));
		System.out.println("----mapNumber.get(1).getText()--------" + mapNumber.get(1).getText());
		Assertion.assertTrue("3 map number is not present", mapNumber.get(2).getText().contains("3"));
		System.out.println("----mapNumber.get(2).getText()--------" + mapNumber.get(2).getText());
		Assertion.assertTrue("4 map number is not present", mapNumber.get(3).getText().contains("4"));
		System.out.println("----mapNumber.get(3).getText()--------" + mapNumber.get(3).getText());
	}

	public void validateNearestPharOrder() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> miles = driver.findElements(By.xpath("//div[@id='pharMileId']/div[2]/span"));
		if (Float.parseFloat(miles.get(0).getText().substring(0, 4).trim()) <= Float
				.parseFloat(miles.get(1).getText().substring(0, 4).trim())
				&& Float.parseFloat(miles.get(1).getText().substring(0, 4).trim()) <= Float
						.parseFloat(miles.get(2).getText().substring(0, 4).trim())) {
			Assertion.assertTrue(true);
		} else
			Assertion.assertTrue("Not in Nearest Order", false);
	}

	public int verboseCompare(String s1, String s2) {
		System.out.println("Comparing \"" + s1 + "\" to \"" + s2 + "\"...");
		int comparisonResult = s1.compareTo(s2);
		return comparisonResult;
	}

	public void validateAtoZorder() {
		List<WebElement> pharmnames = driver.findElements(By.xpath("//div[@id='pharInfoId']/span"));
		int comparisonResult = verboseCompare(pharmnames.get(0).getText(), pharmnames.get(1).getText());
		if (comparisonResult < 0) {
			Assertion.assertTrue(true);
		} else
			Assertion.assertTrue("Not following A to Z order", false);
	}

	public void validateZtoAorder() {
		List<WebElement> pharmnames = driver.findElements(By.xpath("//div[@id='pharInfoId']/span"));
		int comparisonResult = verboseCompare(pharmnames.get(0).getText(), pharmnames.get(1).getText());
		if (comparisonResult > 0) {
			Assertion.assertTrue(true);
		} else
			Assertion.assertTrue("Not following Z to A order", false);
	}

	public void clickAtoZtab() {
		AtoZtab.click();
	}

	public void clickZtoAtab() {
		ZtoAtab.click();

	}

	@FindBy(xpath = ".//*[@id='acqsummary']/div[3]/div[1]")
	private WebElement step3drugInfo;

	public boolean validateDrugOnStep3(String drug) {
		System.out.println(step3Info.getText());
		if (step3Info.getText().contains(drug.toUpperCase()) && validateNew(drugCostCard))
			return true;
		return false;

	}

	public boolean validateStep3FromHomePage(String drug) {
		CommonUtility.waitForPageLoadNew(driver, step3DrugSummaryInfo, 30);
		validateNew(step3PharmacySummaryInfo);
		if (step3DrugSummaryInfo.getText().contains(drug))
			return true;
		return false;

	}

	public PlanDetailsPageMobile clickOnReturnLink() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", returnLink);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPageMobile(driver);
		return null;
	}

	@FindBy(xpath = ".//*[@id='borderContainer']/div/div[2]/div[2]/button[1]")
	private WebElement btn2017;

	@FindBy(xpath = ".//*[@id='drugspharmacy']/div[3]/ul[1]/li")
	private WebElement selectedPharmSection;

	public void switchYear() {
		if (btn2017 != null)
			btn2017.click();

	}

	public boolean yearBtnExists() {
		if (validate(btn2017))
			return true;
		return false;
	}

	public boolean isPharmacyStillSelected() {
		if (validate(selectedPharmSection))
			return true;
		return false;
	}

	public VPPPlanSummaryPageMobile mouseHoverOurPlans(String zipCode) {
		if (ourPlansTab.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ourPlansTab).build().perform();
			enterZipcode.sendKeys(zipCode);
			findPlans.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.navigate().refresh();
			return new VPPPlanSummaryPageMobile(driver);
		} else {
			System.out.println("====================Our Plans tab not displayed================");
			return null;
		}
	}

	public void validateDceLandingPage() {
		CommonUtility.waitForPageLoad(driver, step1, 30);
		validateNew(step1);
		validateNew(step2);
		validateNew(step3);
	}

	public VPPPlanSummaryPageMobile enterZipcodeAndNavigateToPlanSummary(String zipCode) {
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, zipCodeTextBox, 60);
		sendkeys(zipCodeTextBox, zipCode);
		CommonUtility.waitForPageLoadNewForClick(driver, findPlansButton, 60);
		findPlansButton.click();
		CommonUtility.waitForPageLoadNew(driver, maPlansCount, 60);
		return new VPPPlanSummaryPageMobile(driver);
	}

	public void pickAPharmacy() {
		validateNew(getBtnNextPickAPharmacy());
		getBtnNextPickAPharmacy().click();
		CommonUtility.waitForPageLoadNew(driver, getLblFindAPharmacy(), 60);
	}

	/* selecting radius */
	public void selectRadius(WebElement dropDownID, String value) {
		selectFromDropDownByText(driver, dropDownID, value);
	}

	public void clickButtonViewCost() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(getBtnViewCost());
		// scrollToView(btnViewCost);
		jsClickNew(getBtnViewCost());
		validateNew(getDrugCostCard());
	}

	public void clickEditPharmacy() {
		validateNew(getLnkEditPharmacyList());
		getLnkEditPharmacyList().click();
		validateNew(getLblFindAPharmacy());

	}

	public void clickEditDrugList() {
		validateNew(getStep3EditDrugsList());
		getStep3EditDrugsList().click();
		validateNew(getLblCreateAListOfThePrescriptionDrug());

	}

	public void clickSwitchNowLink(WebElement lnkSwitchNow) throws InterruptedException {

		scrollToView(lnkSwitchNow);
		jsClickNew(lnkSwitchNow);
		CommonUtility.waitForPageLoad(driver, updateBtn, 60);
	}

	public void clickUpdateButton() throws InterruptedException {
		jsClickNew(updateBtn);
	}

	public void clickSwitchNUpdate(WebElement lnkSwitchNow) throws InterruptedException {
		clickSwitchNowLink(lnkSwitchNow);
		clickUpdateButton();
	}

	public void clickSwitchNUpdateAll() throws InterruptedException {
		int count = 0;
		for (int i = 0; i < getLstlinkSwitchNow().size(); i++) {

			if (getLstlinkSwitchNow().get(i).isDisplayed()) {
				try {
					clickSwitchNowLink(getLstlinkSwitchNow().get(i));
					clickUpdateButton();
					count = 1;
				} catch (Exception e) {
				}

			}

			/*
			 * if(count==1) i=0;
			 */

		}
	}

	public ComparePlansPageMobile clickBtnBackToPlancompare() throws InterruptedException {
		validateNew(getBtnBackToPlans());
		getBtnBackToPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, VerifyEstimatedDrugCost, 60);
		return new ComparePlansPageMobile(driver);

	}
	
	public ComparePlansPageMobile clickBtnBackTonewPlancomparenew() throws InterruptedException {
		validateNew(getBtnBackToPlans());
		getBtnBackToPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, planCompareVerifyEstimatedDrugCostValue, 60);
		return new ComparePlansPageMobile(driver);

	}

	/* Navigation from DCE to VPP */
	public void clickBtnBackToPlans() throws InterruptedException {
		validateNew(getBtnBackToPlans());
		getBtnBackToPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, maPlansCount, 60);

	}

	/* Navigation from DCE to details page */
	public void clickBtnBackToPlansNavigateToDetails() throws InterruptedException {
		validateNew(getBtnBackToPlans());
		getBtnBackToPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, getLnkBackToAllPlans(), 60);

	}

	public String genericDrugName(WebDriver wd) throws InterruptedException {
		String DrugName = wd.findElement(By.xpath("//*[contains(@class,'margin-large generic-name')]")).getText()
				.toLowerCase();
		return DrugName;
	}

	public VisitorProfilePageMobile retrunToProfile() {
		btnReturnToProfile.click();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VisitorProfilePageMobile clickOnShoppingCart() {
		validate(shoppingCartIcon, 20);
		jsClickNew(shoppingCartIcon);
		//shoppingCartIcon.click();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public VPPPlanSummaryPageMobile clickReturnToSummaryLink() {
		validateNew(returnLink, 20);
		jsClickNew(returnLink);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;

	}
	
	public ComparePlansPageBlayerMobile clickBtnBackToPlancomparenew() throws InterruptedException {
		validateNew(getBtnBackToPlans());
		getBtnBackToPlans().click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, planCompareVerifyEstimatedDrugCostValue, 60);
		return new ComparePlansPageBlayerMobile(driver);

	}
	

	public void validateLocalStorage(Map<String, String> dCEAttributesMap) {
		
		
		validateNew(getBtnBackToPlans());
		getBtnBackToPlans().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CommonUtility.checkPageIsReadyNew(driver);

		String ZipCode = dCEAttributesMap.get("Zip Code");
		String DrugName1 = dCEAttributesMap.get("Drug Name1");
		String DrugName2 = dCEAttributesMap.get("Drug Name2");
		String DrugName3 = dCEAttributesMap.get("Drug Name3");
		String PharmacyName = dCEAttributesMap.get("Pharmacy Name");
		System.out.println(ZipCode);
		System.out.println(DrugName1);
		System.out.println(DrugName2);
		System.out.println(DrugName3);
		System.out.println(PharmacyName);
	
		String DCE_aarpacquisition = ReturnDriverStorage(driver, "localStorage","ucp_aarpacquisition" );
		System.out.println("AARP ACQ info from Local Storage");
		System.out.println(DCE_aarpacquisition);
		boolean validation_Flag=false;
		boolean Validate_ZipPharmacy = false;
		if(DCE_aarpacquisition.contains(DrugName1) && DCE_aarpacquisition.contains(DrugName2) 
				&& DCE_aarpacquisition.contains(DrugName3) && DCE_aarpacquisition.contains(PharmacyName)) {
			Validate_ZipPharmacy = true;
			validation_Flag=true;
			System.out.println("AARP ACQ info from Local Storage validated : "+Validate_ZipPharmacy);
		}
		
		String DCEDrugList = ReturnDriverStorage(driver, "localStorage","ucp_drugList" );
		System.out.println("AARP DrugList from Local Storage");
		System.out.println(DCEDrugList);
		boolean Validate_DrugList = false;
		if(DCEDrugList.contains(DrugName1) && DCEDrugList.contains(DrugName2) 
				&& DCEDrugList.contains(DrugName3) && DCEDrugList.contains(PharmacyName)
				 && DCEDrugList.contains(ZipCode)) {
			Validate_DrugList = true;
			validation_Flag = (validation_Flag)?true:false;
			System.out.println("AARP DrugList from Local Storage validated : "+Validate_DrugList);
		}
		System.out.println("AARP Local Storage Validation Status : "+validation_Flag);
		Assertion.assertTrue("AARP Local Storage Validation Failed",validation_Flag);		
	}
}
