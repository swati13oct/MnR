package pages.dashboard.member.drugcostestimator.blayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.dashboard.member.blayer.AddDrugDetails;
import pages.dashboard.member.blayer.AddNewDrugModal;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class DrugCostEstimatorPage extends UhcDriver {

	public DrugCostEstimatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, SaveDrugPage, 10);
		String fileName = CommonConstants.SAVE_DRUG_PAGE_DATA;
		// savedrugpage = CommonUtility.readPageData(fileName,
		// CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		// openAndValidate();
	}

	private PageData savedrugpage;

	public JSONObject savedrugpageJson;

	//@FindBy(xpath = "//div[@id='drugs-tab']//a[@id='add-drug']")
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

	@FindBy(xpath = "//div[@id='pharmacy-results']/div[1]/ul[1]/li[1]/div/div[2]/a") 
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

	@FindBy(xpath = "//p[contains(text(),'STEP3:')]/following-sibling::span[p[contains(text(),'COST')]]")
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

//	@FindBy(xpath = ".//*[@id='drugdetails']/div[1]/div[1]/div/div/section/div")
//	public WebElement switchGenericOption;
//
//	@FindBy(xpath = ".//*[@id='drugdetails']/div[1]/div[1]/div/div/section/div/section/div[2]/a")
//	public WebElement switchNowLink;

	@FindBy(className = "pharmacy-container")
	public WebElement selectedPharmacy;
	
	@FindBy(xpath = ".//*[@id='drugsTabId']/a")
	public WebElement step1DrugTab;

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

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject dashoardExpectedJson = expectedDataMap.get(CommonConstants.DCEstimator);

		return dashoardExpectedJson;
	}

	public AddNewDrugModal clickOnAddDrug() throws InterruptedException {
		Thread.sleep(5000);
		waitforElement(addDrug);
		addDrug.click();
		//addDrug.click();
		System.out.println("Current Page title :: " + driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("drugcostestimatoracquisition") ||  driver.getTitle().equalsIgnoreCase("Overview")|| driver.getTitle().equalsIgnoreCase("Drug Cost Estimator")) {
			return new AddNewDrugModal(driver);
		}
		return null;
	}

	public void changeUrlToNewDCEPage() throws InterruptedException {

		String Current_url = driver.getCurrentUrl();
		String NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/medicare/member/drug-lookup/overview.html";
		String evironment = MRScenario.environment;
		/*WebElement dcelink = driver.findElement(By.linkText("Estimate Drug Costs"));
		System.out.println("dce link");
		dcelink.click();*/
		//Go to DCE page
		
/*		WebElement dcelink = driver.findElement(By.xpath("html/body/div[2]/div[4]/div[3]/div[1]/div/table/tbody/tr[11]/td[2]/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", dcelink); */
		System.out.println("dce link");
		//dcelink.click();
		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			//NewDCEUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/dashboard/home/drug-cost-estimator.html";
			NewDCEUrl = "https://member.team-b-aarpmedicareplans.uhc.com/content/medicare/member/drug-lookup/overview.html";
		} else if (driver.getCurrentUrl().contains("uhcmedicaresolutions")){
			//NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html";
			//NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/medicare/member/drug-lookup/overview.html";
			NewDCEUrl = "https://team-b-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}else if(evironment.equals("team-b")){
			NewDCEUrl = "https://team-b-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}else if(evironment.equals("team-h")){
			NewDCEUrl = "https://team-h-medicare.uhc.com/member/drug-lookup/overview.html#/drug-cost-estimator";
			//"https://team-h-werally.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
			//           https://team-h-werally.uhc.com/content/medicare/member/drug-lookup/overview.html
		}else if(evironment.equals("stage")){
			NewDCEUrl = "https://stage-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}

		driver.get(NewDCEUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
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
		try {
			WebElement loadingImage = driver.findElement(By.className("loading-dialog"));
			System.out.println("loading image isdisplayed" + loadingImage.isDisplayed());
			while (loadingImage.isDisplayed()) {
				System.out.println("DCE is loading");
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			System.out.println("No loading image");
			Thread.sleep(15000);
		}
		
		Thread.sleep(15000);
	}

	public void deleteDrugs(int i) {
		String deleteDrugXpath = "(//a[text()='Delete'])[" + "i" + "]";
		WebElement deletedrug = driver.findElement(By.xpath(deleteDrugXpath));
		deletedrug.click();

	}

	public boolean validateintroductorytext() {
		// TODO Auto-generated method stub
		if (validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator"))
			return true;
		else
			return false;
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
			//addNewDrugModal.selectDrug(drug);
			AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
			addDrugDetails.selectQnty(i + "");
			addDrugDetails.continueAddDrugDetails();
			SavingsOppurtunity savingsOppurtunity = new SavingsOppurtunity(driver);
			savingsOppurtunity.savedrugbutton();
			Thread.sleep(3000);
		}
	}

	public int getDrugsCount() {
		List<WebElement> drugs = driver
				.findElements(By.xpath("//div[@id='drugs-tab']//div[contains(@ng-repeat,'eachDrug')]"));
		return drugs.size();
	}

	public void navigateToStep2() throws InterruptedException {
		//waitforElement(step2Pharmacy);
		Thread.sleep(10000);
		step2Pharmacy.click();
		Thread.sleep(10000);
		waitforElement(pharmacy_form);

	}

	public void backwardToStep1() {
		step1DrugTab.click();
	}

	public void validatePharmacyForm() {
		Assert.assertTrue(pharmacyform.isDisplayed());
		Assert.assertTrue(rbStandardNetwork.isDisplayed());
		Assert.assertTrue(rbPharmacySaver.isDisplayed());
		Assert.assertTrue(rbPreferredMailService.isDisplayed());
		//Assert.assertTrue(rbPreferredRetail.isDisplayed());
	}

	public void pharmacyInformation(String zipcode, String radius) {
		validate(step2PharmacyTab);
		validate(zipcodeInput);
		validate(milesSelection);
		step2PharmacyTab.click();
		sendkeys(zipcodeInput, zipcode); // not sure what webelement to use
		SearchLink.click();
		Select options = new Select(milesSelection);
		options.selectByVisibleText(radius);

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
			WebElement dosagedrug = driver.findElement(By.xpath(deleteDrugXpath));
			Assert.assertFalse(true);
		} catch (NoSuchElementException e) {
			Assert.assertFalse(false);
		}

	}

	public void deleteDrugsByDosage(String dosage) throws InterruptedException {
		Thread.sleep(15000);
		String deleteDrugXpath = "//div[@id='drugs-tab']//p[contains (text(), '" + dosage
				+ "')]/following-sibling::ul//li/a[@class='delete-drug']";
		WebElement deletedrug = driver.findElement(By.xpath(deleteDrugXpath));
		deletedrug.click();
		Thread.sleep(5000);

	}

	public AddDrugDetails navigateToEditDrug(String drug) throws Exception {
		// editDrug.click();
		Thread.sleep(15000);
		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'" + drug
				+ "')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
		Thread.sleep(5000);
		return new AddDrugDetails(driver);
	}

	public boolean validateAddedDrug(String args1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		validate(driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1
				+ "')]/following-sibling::p/span[contains(text(),'" + arg2 + "')]")));

		// List<WebElement> stri =
		// driver.findElements(By.xpath("//div[@id='drugs-tab']//p[contains
		// (text(), '"+args1+"')]")).getText();
		// System.out.println("++++++++drugdetails+++++++++" + drugdetails +
		// "+++++++++++++++++" );

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
		int index = 5;
		Select options = new Select(milesSelection);
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
		
		WebElement rbtn = driver.findElement(By.xpath(".//*[@id='pharmacy-type']/div/label/p[contains(text(),'" + pharmacy + "')]"));

		rbtn.isDisplayed();
		if (!rbtn.isSelected()) {
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
		btnSearch.click();

	}

	public void verifyPharmacyResults() {
		Assert.assertTrue(pharmacyResults.isDisplayed());
	}

	public int getResultPharmacyCount() {
		return pharmacies.size();
	}

	public void validatePharmacylist() {
		//Assert.assertEquals(3, pharmacies.size());
	}

	public void select_first_pharmacy() throws InterruptedException {
		Thread.sleep(10000);
		//waitforElement(select_btn_first);
		if (select_btn_first.isDisplayed()) {
			select_btn_first.click();
		}
		Thread.sleep(5000);
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
		//Assert.assertTrue(text_total_annual_drug_cost.isDisplayed());
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
		btnZipCodeSearch.click();
	}

	public void validatePreferredMailServiceNotPresent() {
		List<WebElement> mailService = driver.findElements(By.id("mail-service-type"));
		if (mailService.get(0).isDisplayed()) {
			Assert.assertFalse("Preferred Mail Servic pharmacy type is present",true);
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
		waitforElement(step2);
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
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		// addNewDrugModal.selectDrug(drug);
		AddDrugDetails addDrugDetails = new AddDrugDetails(driver);

//		SavingsOppurtunity savingsOppurtunity = addDrugDetails.continueAddDrugDetailsModal();

		// if(addDrugDetails.continueAddDrugDetails()!=null){
		 SavingsOppurtunity savingsOppurtunity1 = new SavingsOppurtunity(driver);
		savingsOppurtunity1.savedrugbutton();
		// }
		Thread.sleep(2000);

	}

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]")
	public WebElement totalDrugSavingsBox;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/span")
	public WebElement drugSavingValue;

	@FindBy(xpath = "//div[@id='total_drugsavings']/div[2]/a")
	public WebElement editDrugListLink;

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
//			String deleteDrugXpath = ".//*[@id='drugdetails']/div[1]/div[1]/div/div/section/ul/li[2]/a";
//			WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));
//			deleteDrug.click();
//			deleteDrug();

			String deleteDrugXpath = ".//*[@id='drugdetails']/div[2]/div["+drugCount+"]/div/div/section/ul/li[2]/a";
			WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", deleteDrug);
			
			deleteDrug.click();
			System.out.println("drug deleted");
			WebElement deleteButtonXpath = driver.findElement(By.xpath(".//*[@id='drugModal']/div/div/div[2]/div/section/div/button[2]"));
			System.out.println("drug delete button");
			waitforElement(deleteButtonXpath);
			deleteButtonXpath.click();
			drugCount--;
			Thread.sleep(5000);
		}
	}
	
	public void deleteDrug() throws InterruptedException{
		
		
		String deleteDrugXpath = ".//*[@id='drugdetails']/div[2]/div[3]/div/div/section/ul/li[2]/a";
		WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));
		
		deleteDrug.click();
		WebElement deleteButtonXpath = driver.findElement(By.xpath(".//*[@id='drugModal']/div/div/div[2]/div/section/div/button[2]"));
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
		//addDrugDetails.selectQnty(60 + "");
	//	SavingsOppurtunity savingsOppurtunity = addDrugDetails.continueAddDrugDetails();
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
			Assert.assertFalse("Edit Drug Link is present",true);
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
			Assert.assertTrue("No pharmacy is selected",false);
		}
	}

	public void validatePharmacySelected() {
		// List<WebElement> selectedPharmacy =
		// driver.findElements(By.className("pharmacy-container"));
		String valselectedPharmacy = selectedPharmacy.getText();
		if (!valselectedPharmacy.equals("Select a pharmacy to see your drug costs")
				|| !valselectedPharmacy.equals(" ")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Pharmacy is selected",false);
		}
	}

	public void validateSwitchGenericOption() {

		int drugscount = getDrugsCount();
		if(drugscount>0){
			WebElement switchGenericOption = driver.findElement(By.id("generic-drug-"+ (drugscount-1)));
			System.out.println("switch generic option" + switchGenericOption.getText());
			if (switchGenericOption.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Drug does not have switch to generic option ",false);
			}
		}else{
			Assert.assertTrue("There are no drugs added ",false);
		}
		

	}

	public void validateSwitchNowLink() {
		int drugscount = getDrugsCount();
		if(drugscount>0){
			WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-"+ (drugscount-1)));
			if (switchNowLink.isDisplayed()) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Switch now link is not present",false);
			}
			
		}else{
			Assert.assertTrue("There are no drugs added ",false);
		}
		
	}

	public void validateSaveGenericMessage() {
		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			List<WebElement> saveGenericMessage = driver
					.findElements(By.id("generic-drug-saving-amount-"+(drugscount-1)));
			String valSaveGenericMessage = saveGenericMessage.get(0).getText();
			if (valSaveGenericMessage.equals("Save money")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Save money message is incorect",false);
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
					.findElements(By.id("generic-drug-saving-amount-"+(drugscount-1)));
			String valSaveGenericMessage = saveGenericMessage.get(0).getText();
			if (!valSaveGenericMessage.equals("Save money")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Save dollar amount message is incorect",false);
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
		}
		
	}

	public void clickSwitchNow() throws InterruptedException {
		int drugscount = getDrugsCount();
		if (drugscount > 0) {
			WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-"+ (drugscount-1)));
			switchNowLink.click();
			Thread.sleep(5000);

			//switchToGenericHeadingsId
			if (driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")) {
				String savingsOpputunityHeading = driver
						.findElement(By.id("switchToGenericHeadingsId")).getText();
				if (savingsOpputunityHeading.equals("SAVINGS OPPORTUNITY")) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue("Savings Oppurtunity modal popup does not show up",false);
				}
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
		}
		

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
			String[] genericDrug = lbGenericdrug.get(drugsCount-1).getText().split(" ");
			if (genericDrug[0].equalsIgnoreCase("ATORVASTATIN")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue("Branded drug is not switched to generic drug",false);
			}

		} else {
			Assert.assertTrue("There are no drugs added ", false);
		}
	}
	
	public void navigateToDCETool() throws InterruptedException {

		String Current_url = driver.getCurrentUrl();
		String NewDCEUrl;

		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			NewDCEUrl = "https://www.team-b-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/drugcostestimatoracquisition.html";
		} else {
			NewDCEUrl = "https://www.team-b-uhcmedicaresolutions.uhc.com/content/uhcmedicaresolutions/en/drugcostestimatoracquisition.html";
		}

		driver.get(NewDCEUrl);

		Thread.sleep(15000);
	}
	
	

}
