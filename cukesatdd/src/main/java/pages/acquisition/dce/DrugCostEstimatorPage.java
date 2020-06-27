package pages.acquisition.dce;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.ulayer.PlanDetailsPage;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class DrugCostEstimatorPage extends UhcDriver {

	public DrugCostEstimatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, SaveDrugPage, 10);
		//String fileName = CommonConstants.SAVE_DRUG_PAGE_DATA;
		// savedrugpage = CommonUtility.readPageData(fileName,
		// CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		// openAndValidate();
	}

	private PageData savedrugpage;

	public JSONObject savedrugpageJson;

	// @FindBy(xpath = "//div[@id='drugs-tab']//a[@id='add-drug']")
	@FindBy(id = "add-drug")
	public WebElement addDrug;

	@FindBy(id = "pharmacyTabId")	public WebElement step2;

	@FindBy(id = "drugsTabId")
	public WebElement step1;
	
	
	@FindBy(xpath = ".//*[@id='drugsTabId']/a/span/p")
	public WebElement step1DrugsTab;

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
	public WebElement zipcodeBtn; //zipcode on acq home page

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
	
	 @FindBy(id = "zipcode-button")
     public WebElement SearchLink; // is it the same thing?

	@FindBy(id = "pharmacy-form")
	public WebElement pharmacy_form;

	@FindBy(id = "pharmacy-results")
	public WebElement pharmacyResults;

	@FindBy(xpath = "//div[@id='pharmacy-results']//span[contains(@class,'pharmacy-name')]")
	public List<WebElement> pharmacies;
	               
	@FindBy(xpath = ".//*[@id='pharmacy-results']/div[2]/ul[1]/li[1]/div/div[2]/button")
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

	@FindBy(id = "costsTabId")
	public WebElement step3;

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

	
	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]")
    public WebElement totalDrugSavingsBox;
	
	// @FindBy(xpath =
	// ".//*[@id='drugdetails']/div[1]/div[1]/div/div/section/div")
	// public WebElement switchGenericOption;
	//
	// @FindBy(xpath =
	// ".//*[@id='drugdetails']/div[1]/div[1]/div/div/section/div/section/div[2]/a")
	// public WebElement switchNowLink;

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

	@FindBy(xpath = "//*[@id='acqsummary']/div[1]/div/h2")
	public WebElement summary;

	@FindBy(xpath = "//a[contains(text(),'Drugs')]")
	public WebElement drugsLink;

	//@FindBy(xpath = ".//*[@id='acqsummary']/div[2]/div[2]/a/p")
	//@FindBy(xpath = "//p[contains(text(),'Pharmacy')]")
	@FindBy(xpath = "//div[2]/a/p")
	public WebElement pharmacyLink;

	//@FindBy(xpath = ".//*[@id='acqsummary']/div[2]/div[4]/div/a")
	//@FindBy(xpath = "//div[@id='acqsummary']/div[2]/div[4]/div/div/a")
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
	
	//@FindBy(xpath = ".//*[@id='costs-tab']/div/div[1]/div[2]/div/a")
	@FindBy(xpath = "//a[contains(text(),'Return to plans')]")
	public WebElement returnToPlans;
	
	@FindBy(id = "step3DisclaimerVPP")
	public WebElement step3DisclaimerVPP;

	@FindBy(id = "dce")
	public WebElement getStarted;

	@FindBy(id = "zipcode-costs")
	public WebElement zipCodeTextBox;

	@FindBy(xpath = ".//*[@id='acqsummary']/div[2]/div[3]/div/div[1]/a/p")
	public WebElement findPlansButton;

	@FindBy(name = "county")
	List<WebElement> counties;

	@FindBy(id = "zipcodebtn")
	public WebElement zipcodeFindPlans;
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
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

	@FindBy(xpath = ".//*[@id='drugspharmacy']/div[3]/div[1]/div/button[1]")
	public WebElement previousEnterYourDrugs;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/span")
	public WebElement drugSavingValue;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/a")
	public WebElement editDrugListLink;
	
	@FindBy(id = "generic-drug-switch-btn-0")
	private WebElement switchNowBtn;
	
	@FindBy(id="switchToGenericBtnId")
	private WebElement updateBtn;
	
	@FindBy(xpath = ".//*[@id='acqsummary']/div[3]/div[4]/div/p")
	private WebElement costText;
	
	@FindBy(xpath = "//a[contains(text(), 'Enroll in plan')]")
	private WebElement enrollInPlanBtn;

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : savedrugpage.getExpectedData().keySet()) {
			WebElement element = findElement(savedrugpage.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		savedrugpageJson = jsonObject;

		System.out.println("savedrugpageJson----->" + savedrugpageJson);
	}


	public AddNewDrugModal clickOnAddDrug() throws InterruptedException {
		//Thread.sleep(10000);
		waitforElementNew(addDrug,20);
		addDrug.click();

if (driver.getTitle().equalsIgnoreCase("estimate-drug-costs") || driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_DRUG_COSTS)) {
			return new AddNewDrugModal(driver);
		}
		return null;
	}

	public void changeUrlToNewDCEPage() throws InterruptedException {

		
		String NewDCEUrl;

		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			NewDCEUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/drug-cost-estimator.html";
		} else {
			NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html";
		}

		driver.get(NewDCEUrl);

		// try{
		// Alert alert = driver.switchTo().alert();
		// alert.accept();
		// }catch(NoAlertPresentException e){
		//
		// }

		// driver.manage().window().maximize();
		// try {
		// //CommonUtility.waitForPageLoad(driver, SaveDrugPage, 10);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

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
			Assert.assertTrue(true);
		else
			Assert.assertTrue("Drug Cost Estimator is not present", false);
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
			AddNewDrugModal addNewDrugModal = clickOnAddDrug();
			if ((getDrugsCount()) == 25 || i == 26) {
				System.out.println("Exceeded the limit");
				addNewDrugModal.verifyExceededError();
				break;
			}
			addNewDrugModal.typeDrugName(drug);
			addNewDrugModal.submit();
			// addNewDrugModal.selectDrug(drug);
			AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
			addDrugDetails.selectQnty(i + "");
			addDrugDetails.continueAddDrugDetails();
			SavingsOppurtunity savingsOppurtunity = new SavingsOppurtunity(driver);
			savingsOppurtunity.savedrugbutton();
			Thread.sleep(3000);
		}
	}

	public int getDrugsCount() {
	/*	List<WebElement> drugs = driver
				.findElements(By.xpath("//div[@id='drugs-tab']//div[contains(@ng-repeat,'eachDrug')]"));*/
		
		List<WebElement> drugs = driver.findElements(By.xpath(".//*[@id='acqsummary']/div[3]/div[1]"));
		return drugs.size();
	}

	public void navigateToStep2() throws InterruptedException {
		Thread.sleep(5000);
		//waitforElement(step2);
		step2.click();
		Thread.sleep(5000);

	}

	public void backwardToStep1() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(315, 0)");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		step1DrugsTab.click();
		System.out.println("step 1 click");
	}
	
	public void BacktoEnterYourDrugs(){
		previousEnterYourDrugs.click();
	}

	public void validatePharmacyForm() {
		Assert.assertTrue(pharmacyform.isDisplayed());
		// Assert.assertTrue(rbStandardNetwork.isDisplayed());
		// Assert.assertTrue(rbPharmacySaver.isDisplayed());
		// Assert.assertTrue(rbPreferredMailService.isDisplayed());
		// Assert.assertTrue(rbPreferredRetail.isDisplayed());
	}

	public void pharmacyInformation(String zipcode, String radius) {
		validate(step2);
		validate(zipcodeInput);
		validate(milesSelection);
sendkeys(zipcodeInput, zipcode); // not sure what webelement to use
		SearchLink.click();
		// Select options = new Select(milesSelection);
		// options.selectByVisibleText(radius);
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
		Assert.assertTrue(Enter_drug_text.isDisplayed());
	}

	public void validatesummaryheading() {

		Assert.assertTrue(SummaryHeader.isDisplayed());
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
			Assert.assertFalse(true);
		} catch (NoSuchElementException e) {
			Assert.assertFalse(false);
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

	public EditDrugDetails navigateToEditDrug(String drug) throws Exception {
		// editDrug.click();
		Thread.sleep(10000);
		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'" + drug
				+ "')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
		Thread.sleep(15000);
		return new EditDrugDetails(driver);
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
		Assert.assertEquals(miles, actualList);
	}

	public void validateZipcode(String zipcode) {
		Assert.assertEquals(zipcode, zipcodeInput.getText());
	}

	public void selectRadius() {
		
		 new Select(milesSelection);
		//options.selectByIndex(index);
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
		// Assert.assertEquals(zipcode,zipcodeInput.getText());

		WebElement selected_pharmacy_type = driver
				.findElement(By.xpath("//label[contains(text(),'" + pharmacy_type + "')]/parent::div/input"));
		Assert.assertTrue(selected_pharmacy_type.isSelected());
		Select options = new Select(milesSelection);

		WebElement selected_miles = driver
				.findElement(By.xpath(".//*[@id='dce-pharmacy-radius']/option[contains(text(),'" + radius + "')]"));
		Assert.assertTrue(selected_miles.isSelected());
		// String str = options.getAllSelectedOptions().toString();
		// str.toString();
		System.out.println("--------options.getAllSelectedOptions()-----------" + options.getAllSelectedOptions()
				+ "----------------");
		// System.out.println("--------str-----------"+ str +
		// "----------------");
		// Assert.assertEquals(pharmacy_type,str);

	}

	public void selectPharmacyType(String pharmacy) throws InterruptedException {

		WebElement rbtn = driver		
				.findElement(By.xpath(".//*[@id='pharmacy-type']/div[1]/label//p[contains(text(),'" + pharmacy + "')]"));

		rbtn.isDisplayed();
		if (!rbtn.isSelected()) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(316, 0)");
			Thread.sleep(3000);
			rbtn.click();
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

	public void verifyPharmacyResults() {
		Assert.assertTrue(pharmacyResults.isDisplayed());
	}

	public int getResultPharmacyCount() {
		return pharmacies.size();
	}

	public void validatePharmacylist() {
		Assert.assertEquals(3, pharmacies.size());
	}

	public void select_first_pharmacy() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(10000);

		//waitforElement(select_btn_first);
		System.out.println("first pharmacy");
		if (select_btn_first.isDisplayed()) {
			select_btn_first.click();
		}
		System.out.println("first pharmacy 2");
		Thread.sleep(10000);
	}

	public void validate_cost_saving_present(String pharmacy_type) {
		if (pharmacy_type == "Standard Network") {
			validate_cost_saving_not_present();
		} else if (pharmacy_type == "Pharmacy Saver") {
			Assert.assertTrue(card_promo_blue_saver.isDisplayed());
		} else if (pharmacy_type == "Preferred Mail Service") {
			Assert.assertTrue(card_promo_blue_mail.isDisplayed());
		} else if (pharmacy_type == "Preferred Retail") {
			Assert.assertTrue(card_promo_blue_retail.isDisplayed());
		}
	}

	public void validate_cost_saving_not_present() { // Need refactoring
		Assert.assertFalse(card_promo_blue_saver.isDisplayed());
		Assert.assertFalse(card_promo_blue_mail.isDisplayed());
		Assert.assertFalse(card_promo_blue_retail.isDisplayed());
	}

	public boolean validate_pharmacy_type_saver_not_present() {
		// Assert.assertFalse(pharmacy_saver_type.isEnabled());

		try {
			driver.findElement(By.id("saver-type"));
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}

	public void validate_pharmacy_saver_result() {
		// Assert.assertTrue(text_total_annual_drug_cost.isDisplayed());
		// text_total_annual_drug_cost.getSize()
	}

	public boolean validate_selected_pharmacy_type(String pharmacy_type) {
		if (pharmacy_type == "Preferred Retail") {
			Assert.assertTrue(pharmacy_type + "is not selected", pharmacy_retail_type.isSelected());
			return true;
		} else if (pharmacy_type == "Pharmacy Saver") {
			Assert.assertTrue(pharmacy_type + "is not selected", pharmacy_saver_type.isSelected());
			return true;
		} else if (pharmacy_type == "Standard Network") {
			Assert.assertTrue(pharmacy_type + "is not selected", pharmacy_standard_type.isSelected());
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
			Assert.assertFalse("Preferred Mail Servic pharmacy type is present", true);
		} else {
			Assert.assertFalse(false);
		}
	}

	public void validatePreferredMailServiceRD() {
		try {
			Assert.assertTrue(lbPreferredMailService.isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertFalse(false);
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
		Assert.assertTrue("Expected Summary cost is  not present" + summary_tot_cost.getText(),
				summary_tot_cost.getText().equalsIgnoreCase(total_cost));

	}

	public void verify_summary_saving(String total_saving) throws InterruptedException {
		Thread.sleep(5000);
		waitforElement(summary_saving);
		Assert.assertTrue("Expected" + total_saving + " Total saving is not present" + summary_saving.getText(),
				summary_saving.getText().contains(total_saving));
	}

	public void verify_deductible(String deductible) {
		waitforElement(left_rail_deductible);
		Assert.assertTrue("Expected Deductible is not present", left_rail_deductible.getText().contains(deductible));
	}

	public void verify_leftrail_cost(String total_cost) throws InterruptedException {
		Thread.sleep(10000);
		waitforElement(left_rail_tot_cost);
		Assert.assertTrue("Expected Left rail Total Cost is not present",
				left_rail_tot_cost.getText().contains(total_cost));
	}

	public void verify_leftrail_saving(String total_saving) {
		waitforElement(left_rail_tot_saving);
		Assert.assertTrue("Expected Left rail Total Savings is not present",
				left_rail_tot_saving.getText().contains(total_saving));
	}

	public void verify_leftrail_drug_saving(String drug_saving) {
		waitforElement(left_rail_drug_saving);
		Assert.assertTrue("Expected Drug Saving is not present", left_rail_drug_saving.getText().contains(drug_saving));
	}

	public void verify_leftrail_pharmacy_saving(String pharmacy_saving) {
		waitforElement(left_rail_pharmacy_saving);
		Assert.assertTrue("Expected Pharmacy saving is not present",
				left_rail_pharmacy_saving.getText().contains(pharmacy_saving));
	}

	public void navigateToStep3() throws InterruptedException {
		Thread.sleep(10000);
		step3.click();
		Thread.sleep(10000);
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

	public void addDrug(String drug) throws InterruptedException {

		AddNewDrugModal addNewDrugModal = clickOnAddDrug();
		AddDrugDetails addDrugDetails = addNewDrugModal.clickonSearchButton(drug);
		SavingsOppurtunity savingsOppurtunity = addDrugDetails.continueAddDrugDetailsModal();
		savingsOppurtunity.savedrugbutton();
		Thread.sleep(2000);

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
		AddNewDrugModal addNewDrugModal = clickOnAddDrug();
		if ((getDrugsCount()) == 25) {
			addNewDrugModal.verifyExceededError();
			// break;
		}
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		// addNewDrugModal.selectDrug(drug);
		AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
		// addDrugDetails.selectQnty(60 + "");
		addDrugDetails.continueAddDrugDetails();
		SavingsOppurtunity savingsOppurtunity1 = new SavingsOppurtunity(driver);
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
			Assert.assertEquals(valTotDrugCost_Summary, valtotDrugCost_LeftRail);
			Assert.assertEquals(totalAnnualDrugCost, valTotDrugCost_Summary);
			Assert.assertEquals(totalAnnualDrugCost, valtotDrugCost_LeftRail);
		} else {
			Assert.assertTrue(false);
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
			Assert.assertEquals(valTotAvailableSav_Summary, valTotAvailableSav_LeftRail);
			Assert.assertEquals(totalAvailableSavings, valTotAvailableSav_Summary);
			Assert.assertEquals(totalAvailableSavings, valTotAvailableSav_LeftRail);

		} else {
			Assert.assertTrue(false);
		}

	}

	public void validateDrugSavings(String drugSavings) {
		List<WebElement> totDrugSavings = driver.findElements(By.xpath(".//*[@id='total_drugsavings']/div[2]/span"));

		if (totDrugSavings.size() > 0) {
			String valTotDrugSavings = totDrugSavings.get(0).getText();
			// System.out.println("totDrugSavings value "+ valTotDrugSavings);
			Assert.assertEquals(drugSavings, valTotDrugSavings);

		} else {
			Assert.assertTrue(false);
		}

	}

	public void validatePharmacySavings(String pharmacySavings) {
		List<WebElement> totPharmacySavings = driver
				.findElements(By.xpath(".//*[@id='total_pharmacysavings']/div[2]/span"));

		if (totPharmacySavings.size() > 0) {
			String valTotPharmacySavings = totPharmacySavings.get(0).getText();
			// System.out.println("totPharmacySavings value "+
			// valTotPharmacySavings);
			Assert.assertEquals(pharmacySavings, valTotPharmacySavings);
		} else {
			Assert.assertTrue(false);
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
			Assert.assertEquals(drugCoverage, valInitialDrugCoverage);
			Assert.assertEquals(drugCoverage, valCoverageGapStage);
			Assert.assertEquals(drugCoverage, valCatastrophicCoverageStage);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void validateEditDrugAndPharmacyLinks() {
		Assert.assertTrue(elementFound(lkEditDrugsList));
		Assert.assertTrue(elementFound(lkEditPharmacyList));
	}

	public void validateEditDrugLinkNotPresent() {
		List<WebElement> editDrugLink = driver.findElements(By.xpath(".//*[@id='total_drugsavings']/div[2]/a"));
		// String valEditDrugLink = editDrugLink.get(0).getText();
		if (!editDrugLink.get(0).isDisplayed()) {
			Assert.assertFalse(false);
		} else {
			Assert.assertFalse("Edit Drug Link is present", true);
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
		Assert.assertTrue("Annual Deductible Stage heading is not present",
				all_text.contains("Annual Deductible Stage"));
		Assert.assertTrue("Initial Coverage Stage heading is not present", all_text.contains("Initial Coverage Stage"));
		Assert.assertTrue("Catastrophic Coverage Stage heading is not present",
				all_text.contains("Catastrophic Coverage Stage"));
	}

	public void verifyTiersTexts(String year, String layer, String plan) {

		String all_text = tierTexts.getText();
		Assert.assertTrue(year + " is not present", all_text.contains(year));
		Assert.assertTrue(layer + " is not present", all_text.contains(layer));
		Assert.assertTrue(plan + " is not present", all_text.contains(plan));
	}

	public void selectPharmacyMailServicePharmacy() throws InterruptedException {

		// String all_text = pharmacyResults.getText();

		if (pharmacyResults.getText().contains("Preferred Mail Service")) {
			mail_service_select_btn.click();

			Thread.sleep(4000);

			Assert.assertTrue("Preferred Mail Service Pharmacy is not selected",
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
		Assert.assertTrue(content + "is not present", homeDeliveryContent.getText().contains(content));
	}

	public void isPharmacySelected() {
		// List<WebElement> selectedPharmacy =
		// driver.findElements(By.className("pharmacy-container"));
		String valselectedPharmacy = selectedPharmacy.getText();
		if (valselectedPharmacy.equals("Select a pharmacy to see your drug costs") || valselectedPharmacy.equals(" ")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("No pharmacy is selected", false);
		}
	}

	public void validatePharmacySelected() {
		// List<WebElement> selectedPharmacy =
		// driver.findElements(By.className("pharmacy-container"));
		/*
		 * String valselectedPharmacy = selectedPharmacy.getText(); if
		 * (!valselectedPharmacy.
		 * equals("Select a pharmacy to see your drug costs") ||
		 * !valselectedPharmacy.equals(" ")) { Assert.assertTrue(true); } else {
		 * Assert.assertTrue("Pharmacy is selected",false); }
		 */
		// .//*[@id='drugspharmacy']/div[3]/ul[2]/li/div/div[2]/span

		List<WebElement> selectedPharmacy = driver
				.findElements(By.xpath(".//*[@id='drugspharmacy']/div[3]/ul[2]/li/div/div[2]/span"));
		System.out.println("selectedPharmacy size" + selectedPharmacy.size());
		if (selectedPharmacy.get(0).isDisplayed()) {
			Assert.assertTrue("Pharmacy is selected", false);
		} else {
			Assert.assertTrue(true);
		}
	}

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
			Assert.assertTrue("There are no drugs added ", false);
		}

	}

	public void validateSwitchNowLink() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-" + (drugscount - 1)));
			if (switchNowLink.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Switch now link is not present", false);
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
		}

	}

	public void validateSaveGenericMessage() {
		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			List<WebElement> saveGenericMessage = driver
					.findElements(By.id("generic-drug-saving-amount-" + (drugscount - 1)));
			String valSaveGenericMessage = saveGenericMessage.get(0).getText();
			if (valSaveGenericMessage.equals("Save money")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Save money message is incorect", false);
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
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
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Save dollar amount message is incorect", false);
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
		}

	}
	

	
	public void clickSwitchNow() throws InterruptedException {
		Thread.sleep(5000);
		String brandedCost = costText.getText();
		System.out.println(brandedCost);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", switchNowBtn);
		Thread.sleep(8000);
		updateBtn.click();
		Thread.sleep(6000);
		String genericCost = costText.getText();System.out.println(genericCost);
		if(brandedCost.equals(genericCost))
			Assert.fail("Error in calculating costs after switching to generic");
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
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Branded drug is not switched to generic drug", false);
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
		}
	}

	public void validateStep1Item() {
		//validateintroductorytext();
		Assert.assertTrue("returnLink is not present", returnLink.isDisplayed());
		Assert.assertTrue("description text is not present", description.isDisplayed());
		Assert.assertTrue("step1 text is not present", step1.isDisplayed());
		Assert.assertTrue("step2 text is not present", step2.isDisplayed());
		Assert.assertTrue("step3 text is not present", step3.isDisplayed());

	}

	public void validateStep1Disclaimer() throws InterruptedException {
		Assert.assertTrue(step1Disclaimers.isDisplayed());
		step1Disclaimers.click();
		waitforElement(step1Disclaimers);
		Assert.assertTrue("disclaimerContent is not present", step1DisclaimerContent.isDisplayed());
		step1Disclaimers.click();
		Thread.sleep(5000);
		Assert.assertFalse("disclaimerContent is present", step1DisclaimerContent.isDisplayed());
	}

	public void validateStep2Disclaimer() throws InterruptedException {
		Assert.assertTrue(step2Disclaimers.isDisplayed());
		step2Disclaimers.click();
		waitforElement(step2DisclaimerContent);
		Assert.assertTrue("disclaimerContent is not present", step2DisclaimerContent.isDisplayed());
		step2Disclaimers.click();
		Thread.sleep(5000);
		Assert.assertFalse("disclaimerContent is present", step2DisclaimerContent.isDisplayed());
	}

	public boolean isDrugPresent(String drugName) {
		boolean isPresent = false;
		List<WebElement> drugNamesList = driver.findElements(By.id("drugDosageStrengthId"));

		for (WebElement drugNames : drugNamesList) {
			System.out.println("drug name: " + drugNames.getText());
			if (drugName.equalsIgnoreCase(drugNames.getText())) {
				isPresent = true;
			}
		}
		return isPresent;
	}

	public void navigateToDCEToolFromHome() throws InterruptedException {

		/*
		 * String Current_url = driver.getCurrentUrl(); String NewDCEUrl;
		 * 
		 * if (driver.getCurrentUrl().contains("aarpmedicareplans")) { NewDCEUrl
		 * =
		 * "https://www.team-b-aarpmedicareplans.uhc.com/drugcostestimatoracquisition.html#/drug-cost-estimator";
		 * 
		 * //https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/
		 * home/drug-cost-estimator.html } else { NewDCEUrl =
		 * "https://www.team-b-uhcmedicaresolutions.uhc.com/content/uhcmedicaresolutions/en/drugcostestimatoracquisition.html";
		 * }
		 * 
		 * driver.get(NewDCEUrl);
		 */
		driver.manage().window().maximize();
		getStarted.click();

		Thread.sleep(15000);
	}

	public void navigateToDCEToolFromvpp(String zipcode) throws InterruptedException {

		/*
		 * String Current_url = driver.getCurrentUrl(); String NewDCEUrl;
		 * 
		 * if (driver.getCurrentUrl().contains("aarpmedicareplans")) { NewDCEUrl
		 * =
		 * "https://www.team-b-aarpmedicareplans.uhc.com/drugcostestimatoracquisition.html#/drug-cost-estimator";
		 * 
		 * //https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/
		 * home/drug-cost-estimator.html } else { NewDCEUrl =
		 * "https://www.team-b-uhcmedicaresolutions.uhc.com/content/uhcmedicaresolutions/en/drugcostestimatoracquisition.html";
		 * }
		 * 
		 * driver.get(NewDCEUrl);
		 */
		driver.manage().window().maximize();
		zipcodeBtn.sendKeys(zipcode);
		zipcodeFindPlans.click();

		Thread.sleep(15000);

		viewPlans.click();
		Thread.sleep(10000); 
		List<WebElement> enterDrugInformation = driver.findElements(By.linkText("Enter drug information"));		enterDrugInformation.get(0).click();
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
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Summary heading does not show up", false);
		}
	}

	public void validateDrugs() {
		String drugActual = drugsLink.getText();
		if(drugActual.contains("Drugs")){
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Drugs link does not show up",false);
		}
		drugsLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(step1Text.getText().contains("Create a list")){
			step3.click();
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue("Unable to navigate to Step 1",false);
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
		
		if(pharmacyActual.equalsIgnoreCase("Pharmacy")){
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Pharmacy link does not show up",false);
		}	
		pharmacyLink.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(step2Text.getText().contains("Find a pharmacy")){
			step3.click();
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue("Unable to navigate to Step 2",false);
		}

	}

	public void validateCosts() {
		String costsActual = costs.getText();
		if(costsActual.contains("Costs")){
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Costs link does not show up",false);
		}
		
		returnToPlans.click();
		if(driver.getCurrentUrl().contains("health-plans.html")){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue("Unable to navigate to VPP page from DCE tool",false);
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
		if(findAPlanActual.contains("Find a Plan")){
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Find a Plan link does not show up",false);
		}

	}

	public void validateDisclaimers() {
		String disclaimersActual = step3DisclaimerHome.getText();
		String disclaimersActual1 = step3DisclaimerVPP.getText();
		if(disclaimersActual.contains("Disclaimer")){
			step3DisclaimerHome.click();
		} else if(disclaimersActual1.contains("Disclaimer")){
			step3DisclaimerVPP.click();
		}
	}

	public void validateMultiCountyPopup(String zipcode, String county) {
		zipCodeTextBox.sendKeys(zipcode);
		findPlansButton.click();
		//String myWindowHandle = driver.getWindowHandle();
		//driver.switchTo().window("drugModalPharmacy");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(step3searchButton));
		
		if(counties.size()>1)
		{
			for(WebElement countyElement :counties)
			{
				String elementId = countyElement.getAttribute("id");
				if(elementId.contains(county))
				{
					countyElement.click();
					System.out.println("county clicked");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}			
			step3searchButton.click();
		}
		/*try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//To select a county
		//countySelection.click();
		//To search for plans in that county
		/*step3searchButton.click();
		if(driver.getTitle().contains("Our Medicare Plans")){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue("Unable to navigate to VPP page",false);
		}*/
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
		Assert.assertTrue("Initially left pagination arrow is not disabled", leftPaginationDisabled.isDisplayed());
		for (int i = 0; i < pagesize; i++) {
			rightPaginationArrow.click();
			Thread.sleep(4000);
		}
		Assert.assertTrue("After reaching the last pagination right arrow is not disabled",
				rightPaginationDisabled.isDisplayed());

		for (int i = 0; i < pagesize; i++) {
			leftPaginationArrow.click();
			Thread.sleep(4000);
		}
		Assert.assertTrue("After moving to first pagination left arrow is not disabled",
				leftPaginationDisabled.isDisplayed());

	}

	public void validateMapIcon() {
		List<WebElement> mapNumber = driver.findElements(By.id("pharmacyIndex"));
		waitforElement(mapIcon);

		if (mapIcon.getAttribute("src").contains("images/icon-svgs/mapmarker-pin-blue.svg")) {
			System.out.println("-----------mapIcon.getAttribute()-----" + mapIcon.getAttribute("src"));
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		Assert.assertTrue("1 map number is not present", mapNumber.get(0).getText().contains("1"));
		System.out.println("----mapNumber.get(0).getText()--------" + mapNumber.get(0).getText());
		Assert.assertTrue("2 map number is not present", mapNumber.get(1).getText().contains("2"));
		System.out.println("----mapNumber.get(1).getText()--------" + mapNumber.get(1).getText());
		Assert.assertTrue("3 map number is not present", mapNumber.get(2).getText().contains("3"));
		System.out.println("----mapNumber.get(2).getText()--------" + mapNumber.get(2).getText());
		Assert.assertTrue("4 map number is not present", mapNumber.get(3).getText().contains("4"));
		System.out.println("----mapNumber.get(3).getText()--------" + mapNumber.get(3).getText());
	}

	public void validateNearestPharOrder() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> miles = driver.findElements(By.xpath("//div[@id='pharMileId']/div[2]/span"));
		if (Float.parseFloat(miles.get(0).getText().substring(0, 4).trim()) <= Float
				.parseFloat(miles.get(1).getText().substring(0, 4).trim())
				&& Float.parseFloat(miles.get(1).getText().substring(0, 4).trim()) <= Float
						.parseFloat(miles.get(2).getText().substring(0, 4).trim())) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue("Not in Nearest Order", false);
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
			Assert.assertTrue(true);
		} else
			Assert.assertTrue("Not following A to Z order", false);
	}

	public void validateZtoAorder() {
		List<WebElement> pharmnames = driver.findElements(By.xpath("//div[@id='pharInfoId']/span"));
		int comparisonResult = verboseCompare(pharmnames.get(0).getText(), pharmnames.get(1).getText());
		if (comparisonResult > 0) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue("Not following Z to A order", false);
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
		if(step3drugInfo.getText().contains(drug))
			return true;
		return false;
		
	}
	
	public PlanDetailsPage clickOnReturnLink() {
		waitTillElementClickableInTime(returnLink,10);
		returnLink.click();	
		validateNew(enrollInPlanBtn);
		if(currentUrl().contains("#/details")){
			return new PlanDetailsPage(driver);
		}
		return null;
	}
	@FindBy(xpath = ".//*[@id='borderContainer']/div/div[2]/div[2]/button[1]")
	private WebElement btn2017;
	
	@FindBy(xpath = ".//*[@id='drugspharmacy']/div[3]/ul[1]/li")
	private WebElement selectedPharmSection;

	public void switchYear(){
		btn2017.click();
		
	}
	
	public boolean yearBtnExists(){
		if(validate(btn2017))
			return true;
		return false;
	}
	
	public boolean isPharmacyStillSelected(){
		if(validate(selectedPharmSection))
			return true;
		return false;
	}
	public VPPPlanSummaryPage navigateBackToPlanSummaryPage() {	
		
		//WebElement returnToPlanSummaryLink = driver.findElement(By.xpath(".//*[@id='returnLink']"));	
		WebElement returnToPlanSummaryLink = driver.findElement(By.xpath("//*[@id='returnLink']"));	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", returnToPlanSummaryLink);
		//returnToPlanSummaryLink.click();
		
	/*}
	catch (Exception e){
		WebElement returnToPlanSummaryLink = driver.findElement(By.id("returnLink"));
		returnToPlanSummaryLink.click();
	}
	//
*/		
	CommonUtility.checkPageIsReadyNew(driver);
	if (driver.getCurrentUrl().contains("plan-summary")) {
	return new VPPPlanSummaryPage(driver);	
			}
			return null;
		}

}
