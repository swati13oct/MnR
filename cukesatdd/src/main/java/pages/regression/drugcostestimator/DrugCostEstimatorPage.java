/**
 * 
 */
package pages.regression.drugcostestimator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * Functionality: Covers all elements and methods for Drug cost estimator Page
 */
public class DrugCostEstimatorPage extends UhcDriver {

	public DrugCostEstimatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, SaveDrugPage, 10);
		// savedrugpage = CommonUtility.readPageData(fileName,
		// CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		// openAndValidate();
	}

	private PageData savedrugpage;

	public JSONObject savedrugpageJson;

	//@FindBy(xpath = "//div[@id='drugs-tab']//a[@id='add-drug']")
	@FindBy(id = "add-drug")
	//@FindBy(xpath="//div[@id='add-drug']//a")
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

	@FindBy(xpath = "//*[contains(@id,'select-pharmacy-buttons')]")
	public WebElement first_pharmacy_select_LNK;

	@FindBy(id = "select-pharmacy-buttons_1")
	public WebElement first_pharmacy_select_btn;

	@FindBy(xpath = "//ul[@class='pharmacy-list']/li[@class='selected']")
	public WebElement pharmacy_selected;

	@FindBy(xpath = "//div[@id='pharInfoId_1']/span")
	public WebElement first_pharmacy_name;

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

	@FindBy(xpath = "//li[@id='costsTabId']/a")
	public WebElement costTab;

	@FindBy(id = "total_annauldeductible")
	public WebElement left_rail_deductible;

	@FindBy(xpath = "//div[@id='drugcontainer_0']//a[@class='delete-drug']")
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

	@FindBy(id = "switchToGenericBtnId")
	public WebElement btnSwitchUpd;

	@FindBy(xpath = "//div[@id='switchdesc_id']//h3")
	public WebElement genericDrugText;

	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private WebElement iPerceptionAutoPopUp;

	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;

	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;

	@FindBy(xpath = "//div[@class='dce-nav-btns']/button[2]")
	public WebElement delDrgConfirm;

	@FindBy(xpath = "//div[@class='loading-dialog']")
	public WebElement overlay;

	@FindBy(xpath="//div[@class='loading-dialog' and contains(@style,'none')]")
	public WebElement overlay_disappeared;

	@FindBy(xpath="//a[@role='button' and contains(@class,'pharmacy-tab-show')]")
	public WebElement nextSelectPharmacyBtn;

	@FindBy(xpath="//*[@id='plan-name-div']/div/div/div/p/a")
	public WebElement formularypdf;

	@Override
	public void openAndValidate() {

		//		JSONObject jsonObject = new JSONObject();
		//		for (String key : savedrugpage.getExpectedData().keySet()) {
		//			WebElement element = findElement(savedrugpage.getExpectedData().get(key));
		//			validate(element);
		//			try {
		//				jsonObject.put(key, element.getText());
		//			} catch (JSONException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//
		//		}
		//		savedrugpageJson = jsonObject;
		//
		//		System.out.println("savedrugpageJson----->" + savedrugpageJson);

		dceValidate(validateIntroductoryText,0);
		System.out.println("You are on DCE page now ");
	}

	public void feebackpopupClose() throws InterruptedException
	{ 
		if (dceValidate(iPerceptionframe,0)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject dashoardExpectedJson = expectedDataMap.get(CommonConstants.DCEstimator);

		return dashoardExpectedJson;
	}

	/** Click on add drug link
	 * 
	 */
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
	/**TODO: Need clean up lot of hard coded items
	 * 
	 */
	public void changeUrlToNewDCEPage() throws InterruptedException {


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
		}else if(evironment.equals("stage") || evironment.equals("awe-stage")){
			NewDCEUrl = "https://stage-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}else if(evironment.equals("test-a") || evironment.equals("awe-test-a")){
			NewDCEUrl = "https://test-a-medicare.uhc.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
		}
		else if(evironment.equals("team-ci1")){
			NewDCEUrl = "https://team-ci1-medicare.ose-elr-core.optum.com/content/medicare/member/drug-lookup/overview.html#/drug-cost-estimator";
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

	/** 
	 * validate introductory text
	 */
	public boolean validateintroductorytext() {
		// TODO Auto-generated method stub
		if (validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator"))
			return true;
		else
			return false;
	}

	/** 
	 * validate drug heading
	 */
	public boolean validatedrugheading() {
		// TODO Auto-generated method stub
		if (validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator"))
			return true;
		else
			return false;
	}

	/** 
	 * Click Edit Drug link for particular drug
	 */
	public void navgateToEditDrug(String drug) {

		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'" + drug
				+ "')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
	}

	/** 
	 * To add drugs 
	 * TODO : Need clean up 
	 */
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

	/** 
	 * To get drugs count
	 */
	public int getDrugsCount() {
		List<WebElement> drugs = driver.findElements(By.xpath("//div[@id='drugs-tab']//div[contains(@ng-repeat,'eachDrug')]"));
		return drugs.size();
	}

	/** 
	 * Navigate to step 2 pharmacy tab
	 */
	public void navigateToStep2() throws InterruptedException {

		Thread.sleep(5000);
		checkModelPopup(driver,1);
		CommonUtility.waitForPageLoad(driver, step2Pharmacy, 20);
		step2Pharmacy.click();

		CommonUtility.waitForPageLoad(driver, pharmacy_form, 20);
		checkModelPopup(driver,1);

	}

	/** 
	 * Click on to step 1 drug tab
	 */
	public void backwardToStep1() {
		checkModelPopup(driver,1);
		step1DrugTab.click();
		checkModelPopup(driver,1);
	}

	public void validatePharmacyForm() {
		Assert.assertTrue(pharmacyform.isDisplayed());
		Assert.assertTrue(rbStandardNetwork.isDisplayed());
		Assert.assertTrue(rbPharmacySaver.isDisplayed());
		Assert.assertTrue(rbPreferredMailService.isDisplayed());
		//Assert.assertTrue(rbPreferredRetail.isDisplayed());
	}

	/** 
	 * validate pharmacy information step 2 tab, zipcode, miles selection, search link
	 */
	public void pharmacyInformation(String zipcode, String radius) {
		if (dceValidate(zipcodeInput)) {
			Assert.assertTrue(true);
		} else Assert.assertTrue("zipcodeInput is not present", false);	


		if (dceValidate(milesSelection)) {
			Assert.assertTrue(true);
		} else Assert.assertTrue("milesSelection is not present", false);	

		sendkeys(zipcodeInput, zipcode);
		if (dceValidate(btnSearch)) {
			btnSearch.click();
			Assert.assertTrue(true);
		} else Assert.assertTrue("btnSearch is not present", false);
		Select options = new Select(milesSelection);
		options.selectByVisibleText(radius);

	}

	/** 
	 * validate message more drugs other text
	 */
	public boolean validatemesgmoredrugsothertext(String otherscount) {
		// TODO Auto-generated method stub

		System.out.println("--------------" + mesgMoreDrugsOther.getText());
		if (mesgMoreDrugsOther.getText().contentEquals(otherscount))
			// mesgMoreDrugsOther.getText().contentEquals(cs)
			return true;
		else
			return false;
	}

	/** 
	 * validate enter drug text
	 */
	public void validateenterdrugtext() {
		Assert.assertTrue(Enter_drug_text.isDisplayed());
	}

	/** 
	 * validate summary heading
	 */
	public void validatesummaryheading() {

		Assert.assertTrue(SummaryHeader.isDisplayed());
	}

	/** 
	 * validate tab drug heading
	 */
	public boolean validatetabdrugheading() {
		// TODO Auto-generated method stub

		if (drugTab.getText().equalsIgnoreCase("DRUGS")) {

			return true;
		} else
			return false;
	}

	/** 
	 * validate Drugs not Present
	 */
	public void validateDrugsnotPresent(String dosage) {

		String deleteDrugXpath = "//div[@id='drugs-tab']//p[contains (text(), '" + dosage + "')]";
		try {
			driver.findElement(By.xpath(deleteDrugXpath));
			Assert.assertFalse(true);
		} catch (NoSuchElementException e) {
			Assert.assertFalse(false);
		}

	}

	/** 
	 * Delete drugs by dosage
	 */
	public void deleteDrugsByDosage(String dosage) throws InterruptedException {
		Thread.sleep(15000);

		//String deleteDrugXpath = "//div[@id='drugs-tab']//p[contains (text(), '" + dosage+ "')]/following-sibling::ul//li/a[@class='delete-drug']";
		String deleteDrugXpath = "//*[@id='drugcontainer_0']/div/section/ul/li[2]/a";
		WebElement deletedrug = driver.findElement(By.xpath(deleteDrugXpath));
		deletedrug.click();
		CommonUtility.waitForPageLoad(driver, delDrgConfirm, 10);
		delDrgConfirm.click();
		waitForloader(driver, overlay, 30);
	}

	/** 
	 * Navigate to Edit Drug modal on clicking edit drug link
	 * 
	 * return new AddDrugDetails
	 */
	public AddDrugDetails navigateToEditDrug(String drug) throws Exception {
		// editDrug.click();
		Thread.sleep(15000);
		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'" + drug
				+ "')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
		CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
		return new AddDrugDetails(driver);
	}

	/** 
	 * Validate the drug is added or not by sending drug name and dosage 
	 */
	public boolean validateAddedDrug(String args1, String arg2, String arg3) {
		// TODO Auto-generated method stub


		dceValidate(driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1+ "')]")));

		// List<WebElement> stri =
		// driver.findElements(By.xpath("//div[@id='drugs-tab']//p[contains
		// (text(), '"+args1+"')]")).getText();
		// System.out.println("++++++++drugdetails+++++++++" + drugdetails +
		// "+++++++++++++++++" );

		driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1 + "')]")).getText()
		.contains(arg2);
		driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '" + args1 + "')]")).getText()
		.contains(arg3);
		try {
			Thread.sleep(2000);
			driver.manage().window().maximize();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElements(By.xpath("//div[@id='drugs-tab']//p[contains
		// (text(), '"+args1+"')]).gettext();
		return true;
	}

	/** 
	 * Validate drug and dosage text 
	 */
	public boolean validatedrugdosagetext(String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		if (drugndosage1.getText().equalsIgnoreCase(arg1) && drugndosage2.getText().equalsIgnoreCase(arg2)
				&& drugndosage3.getText().equalsIgnoreCase(arg3))
			return true;
		else
			return false;
	}

	/** 
	 * Verifies miles drop down list 
	 */
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

	/** 
	 * Validate entered zipcode
	 */
	public void validateZipcode(String zipcode) {
		Assert.assertEquals(zipcode, zipcodeInput.getText());
	}

	/** 
	 * Select radius in miles drop down
	 */
	public void selectRadius() {

		//Select options = new Select(milesSelection);
		//options.selectByIndex(index);
		// options.getAllSelectedOptions();
	}

	/* 
	 * Validate miles dropdown selections
	 */
	public void validateselectRadius() throws InterruptedException {
		Select options = new Select(milesSelection);
		for (int i = 0; i < 6; i++) {
			options.selectByIndex(i);
			Thread.sleep(5000);
			// options.getAllSelectedOptions();

		}
	}

	/** 
	 * Enter zipcode 
	 */
	public void selectZipcode(String zipcode) {
		sendkeys(zipcodeInput, zipcode);
	}

	/** 
	 * Validate default step 2 elements : Zipcode, pharmacy type, miles
	 */
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

	/** 
	 * select Pharmacy Type
	 */
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

	/** 
	 * validate selection of Pharmacy Type
	 */
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

	/** 
	 * Click on step2 search button
	 */
	public void clickstep2Search() throws InterruptedException {
		Thread.sleep(12000);
		btnSearch.click();

	}

	/** 
	 * Verify Pharmacy results
	 */
	public void verifyPharmacyResults() {
		Assert.assertTrue(pharmacyResults.isDisplayed());
	}

	/** 
	 * Get pharmacy result count
	 * return pharmacies   count
	 */
	public int getResultPharmacyCount() {
		return pharmacies.size();
	}

	/** 
	 * TODO: Need Clean up
	 */
	public void validatePharmacylist() {
		//Assert.assertEquals(3, pharmacies.size());
	}

	/** 
	 * Select first pharmacy from pharmacy result
	 * 
	 */
	public void select_first_pharmacy() throws InterruptedException {
		Thread.sleep(10000);
		//waitforElement(select_btn_first);
		if (select_btn_first.isDisplayed()) {
			select_btn_first.click();
		}
		Thread.sleep(5000);
	}

	/** 
	 * validate cost saving present
	 * TODO: Need clean up
	 */
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

	/** 
	 * validate cost saving not present
	 * TODO: Need clean up
	 */
	public void validate_cost_saving_not_present() { // Need refactoring
		Assert.assertFalse(card_promo_blue_saver.isDisplayed());
		Assert.assertFalse(card_promo_blue_mail.isDisplayed());
		Assert.assertFalse(card_promo_blue_retail.isDisplayed());
	}

	/** 
	 * Validate pharmacy type saver is not present
	 */
	public boolean validate_pharmacy_type_saver_not_present() {
		// Assert.assertFalse(pharmacy_saver_type.isEnabled());

		try {
			driver.findElement(By.id("saver-type"));
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
	}

	/** 
	 * TODO: Need clean up -- to be removed
	 */
	public void validate_pharmacy_saver_result() {
		//Assert.assertTrue(text_total_annual_drug_cost.isDisplayed());
		// text_total_annual_drug_cost.getSize()
	}

	/** 
	 * Validate selected Pharmacy type conditionally as per pharmacy_type passed
	 * 
	 */
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

	/** 
	 * Validate Pharmacy type not present conditionally as per pharmacy_type passed
	 * 
	 */
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

	/** 
	 * verifies preferred retail pharmacy result
	 * TODO -Need clean up checks for first pharmacy record with hardcoded values
	 */
	public boolean verify_preferred_retail_pharmacy_result() {
		String first_phar_result_record = first_pharmacy_record.getText();
		if (first_phar_result_record.contains("Walgreens") && first_phar_result_record.contains("3320 Chino Hills Pkwy")
				&& first_phar_result_record.contains("2.81 mi.")) {
			return true;
		}

		else
			return false;
	}

	/** 
	 * validate pharmacy Information - enter zipcode and search
	 */
	public void pharmacyInformation(String zipcode) {
		dceValidate(zipcodeInput);
		sendkeys(zipcodeInput, zipcode);
		btnZipCodeSearch.click();
	}

	/** 
	 * validate Preferred Mail Service pharmacy type Not Present
	 */
	public void validatePreferredMailServiceNotPresent() {
		List<WebElement> mailService = driver.findElements(By.id("mail-service-type"));
		if (mailService.get(0).isDisplayed()) {
			Assert.assertFalse("Preferred Mail Servic pharmacy type is present",true);
		} else {
			Assert.assertFalse(false);
		}
	}

	/** 
	 * validate Preferred Mail Service label
	 */
	public void validatePreferredMailServiceRD() {
		try {
			Assert.assertTrue(lbPreferredMailService.isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Assert.assertFalse(false);
		}
	}

	/** 
	 * select first pharmacy result
	 */
	public void select_first_pharmacy_result() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
		CommonUtility.waitForPageLoad(driver, first_pharmacy_select_LNK, 20);
		Thread.sleep(2000);

		String temp_pharm = first_pharmacy_name.getText();

		System.out.println("------------temp_pharm-----"+ temp_pharm);
		System.out.println("--------first_pharmacy_select_btn.click----------------"+ first_pharmacy_select_btn.getText());
		//first_pharmacy_select_btn.click();
		jsClickNew(first_pharmacy_select_btn);
		CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
		Assert.assertTrue("expected Pharmacy is not selected", pharmacy_selected.getText().contains(temp_pharm));
	}


	public void verifycost() { 

		waitforElement(left_rail_tot_cost);
		System.out.println("left_rail_tot_cost-------------------"+left_rail_tot_cost.getText());
		if(left_rail_tot_cost.getText().contentEquals(summary_tot_cost.getText())){
			Assert.assertTrue(true);
		}
		else Assert.assertTrue("total cost and summary cost is not matching", false);

	}

	/** 
	 * verifies summary cost
	 */
	public void verify_summary_cost(String total_cost) { // waitforElement(summary_tot_cost);
		// String temp =
		// validateIntroductoryText.getText().equalsIgnoreCase("Drug
		// Cost Estimator")
		Assert.assertTrue("Expected Summary cost is  not present" + summary_tot_cost.getText(),
				summary_tot_cost.getText().equalsIgnoreCase(total_cost));

	}

	/** 
	 * verifies summary saving
	 */
	public void verify_summary_saving(String total_saving) throws InterruptedException {
		Thread.sleep(5000);
		waitforElement(summary_saving);
		Assert.assertTrue("Expected" + total_saving + " Total saving is not present" + summary_saving.getText(),
				summary_saving.getText().contains(total_saving));
	}

	/** 
	 * verifies left rail deductible
	 */
	public void verify_deductible(String deductible) {
		waitforElement(left_rail_deductible);
		Assert.assertTrue("Expected Deductible is not present", left_rail_deductible.getText().contains(deductible));
	}

	/** 
	 * verifies left rail total cost
	 */
	public void verify_leftrail_cost(String total_cost) throws InterruptedException {
		Thread.sleep(10000);
		waitforElement(left_rail_tot_cost);
		Assert.assertTrue("Expected Left rail Total Cost is not present",
				left_rail_tot_cost.getText().contains(total_cost));
	}


	/** 
	 * verifies left rail total saving
	 */
	public void verify_leftrail_saving(String total_saving) {
		waitforElement(left_rail_tot_saving);
		Assert.assertTrue("Expected Left rail Total Savings is not present",
				left_rail_tot_saving.getText().contains(total_saving));
	}

	/** 
	 * verifies left rail drug saving
	 */
	public void verify_leftrail_drug_saving(String drug_saving) {
		waitforElement(left_rail_drug_saving);
		Assert.assertTrue("Expected Drug Saving is not present", left_rail_drug_saving.getText().contains(drug_saving));
	}

	/** 
	 * verifies left rail pharmacy saving
	 */
	public void verify_leftrail_pharmacy_saving(String pharmacy_saving) {
		waitforElement(left_rail_pharmacy_saving);
		Assert.assertTrue("Expected Pharmacy saving is not present",
				left_rail_pharmacy_saving.getText().contains(pharmacy_saving));
	}

	/** 
	 * Navigates to step 3 
	 */
	public void navigateToStep3() throws InterruptedException {
		waitforElement(costTab);
		Thread.sleep(2000);
		costTab.click();
		//	jsClick(costTab);
		Thread.sleep(5000);
		System.out.println("on cost tab step 3 ");
	}

	/** 
	 * Delete all drug
	 */
	public void delete_all_drugs() throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
		while (driver.findElements(By.className("delete-drug")).size() > 0) {
			System.out.println("Proceed to delete drug...");
			CommonUtility.waitForPageLoad(driver, nextSelectPharmacyBtn, 5);
			moveMouseToElement(nextSelectPharmacyBtn);
			System.out.println("Moved mouse to nextSelectPharmacyBtn");
			CommonUtility.waitForPageLoad(driver, first_delete_link, 10);
			first_delete_link.click();
			System.out.println("Clicked first_delete_link");
			Thread.sleep(1000);
			CommonUtility.waitForPageLoad(driver, delDrgConfirm, 10);
			delDrgConfirm.click();
			System.out.println("Clicked delDrgConfirm");
			Assert.assertTrue("PROBLEM - delDrgConfirm button should disappear after clicking", !validate(delDrgConfirm,5));
			CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
		}
	}

	/** 
	 * Selects standard network pharmacy
	 */
	public void fillPharmacyInfo() {
		// rbStandardNetwork.click();// select pharmacy type standard network
		if (select_btn_first.isDisplayed()) {
			select_btn_first.click();// select a pharmacy
		}
	}

	/** 
	 * Add branded drug
	 */
	public void addDrug(String drug) throws InterruptedException {

		AddNewDrugModal addNewDrugModal = clickOnAddDrug();
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		//addNewDrugModal.selectDrug(drug);
		addNewDrugModal.continueAddNewDrugModal();
		AddDrugDetails addDrugDetails = new AddDrugDetails(driver);

		addDrugDetails.continueAddDrugDetails();

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

	/** 
	 * Validates drug savings info
	 */
	public void validateDrugSavingInfo() {
		if (totalDrugSavingsBox.isDisplayed()) {

			if (drugSavingValue.isDisplayed() && editDrugListLink.isDisplayed()) {
				System.out.println("All of the info for drug savings is displayed under the box on the left rail");
			}

		} else
			System.out.println("The Drug Cost Savings Info on the left rail is not displayed");
	}


	/** 
	 * Click on edit drug list link
	 */
	public void clickOnEditDrugListLink() {
		editDrugListLink.click();
	}

	/** 
	 * Deletes all drugs
	 */
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

	/** 
	 * Deletes, added drugs
	 */
	public void deleteDrug() throws InterruptedException{


		String deleteDrugXpath = ".//*[@id='drugdetails']/div[2]/div[3]/div/div/section/ul/li[2]/a";
		WebElement deleteDrug = driver.findElement(By.xpath(deleteDrugXpath));

		deleteDrug.click();
		WebElement deleteButtonXpath = driver.findElement(By.xpath(".//*[@id='drugModal']/div/div/div[2]/div/section/div/button[2]"));
		waitforElement(deleteButtonXpath);
		deleteButtonXpath.click();
		Thread.sleep(5000);
	}

	/** 
	 * Adds generic drug of its branded drug
	 */
	public void addGenericDrug(String drug) throws InterruptedException {
		AddNewDrugModal addNewDrugModal = clickOnAddDrug();
		if ((getDrugsCount()) == 25) {
			addNewDrugModal.verifyExceededError();
			// break;
		}
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		// addNewDrugModal.selectDrug(drug);
		//AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
		//addDrugDetails.selectQnty(60 + "");
		//	SavingsOppurtunity savingsOppurtunity = addDrugDetails.continueAddDrugDetails();
		SavingsOppurtunity savingsOppurtunity1 = new SavingsOppurtunity(driver);
		savingsOppurtunity1.switchToGeneric();
		savingsOppurtunity1.savedrugbutton();
		Thread.sleep(3000);

	}

	/** 
	 * Validates Total Estimated Annual Drug Costs
	 */
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

	/** 
	 * Validates Total available savings
	 */
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

	/** 
	 * Validates drug savings
	 */
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

	/** 
	 * Validate pharmacy savings
	 */
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

	/** 
	 * Validate drug coverage on the page
	 */
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

	/** 
	 * Validate edit drug and pharmacy links on the page
	 */
	public void validateEditDrugAndPharmacyLinks() {
		Assert.assertTrue(elementFound(lkEditDrugsList));
		Assert.assertTrue(elementFound(lkEditPharmacyList));
	}

	/** 
	 * Validate edit drug link not present on the page
	 */
	public void validateEditDrugLinkNotPresent() {
		List<WebElement> editDrugLink = driver.findElements(By.xpath(".//*[@id='total_drugsavings']/div[2]/a"));
		// String valEditDrugLink = editDrugLink.get(0).getText();
		if (!editDrugLink.get(0).isDisplayed()) {
			Assert.assertFalse(false);
		} else {
			Assert.assertFalse("Edit Drug Link is present",true);
		}
	}

	/** 
	 * selects pharmacy if not selected from pharmacy results
	 */
	public void select_pharmacy_if_not_selected() throws InterruptedException {
		if (pharmacyContainer.getText().contains("Selected")) {
			System.out.println("One of the Pharmacy is already selected");
		}

		else
			select_first_pharmacy_result();

	}

	/** 
	 * Click on learn more tiers link
	 */
	public void clicklearnmoreTiersLink() throws InterruptedException {
		System.out.println("learnmoreTiers.getClass()---------"+learnmoreTiers.getAttribute("aria-expanded"));
		System.out.println("learnmoreTiers.gettext()---------"+learnmoreTiers.getText());
		learnmoreTiers.getAttribute("class");
		Assert.assertTrue("learnmoreTiers is not expanded", learnmoreTiers.getAttribute("aria-expanded").toString().contentEquals("false"));
		learnmoreTiers.click();
		Thread.sleep(2000);
		System.out.println("learnmoreTiers.getClass()---------"+learnmoreTiers.getAttribute("aria-expanded"));
		Assert.assertTrue("learnmoreTiers is not expanded", learnmoreTiers.getAttribute("aria-expanded").toString().contentEquals("true"));
	}


	/** 
	 * Click on learn more stages link
	 */
	public void clicklearnmoreStagesLink() throws InterruptedException {
		Assert.assertTrue("learnmoreStages is not expanded", learnmoreStages.getAttribute("aria-expanded").toString().contentEquals("false"));
		learnmoreStages.click();
		Thread.sleep(3000);
		Assert.assertTrue("learnmoreStages is not expanded", learnmoreStages.getAttribute("aria-expanded").toString().contentEquals("true"));
	}

	/** 
	 * Verifies stages text are present on the page
	 */
	public void verifystagesTexts() {

		String all_text = stagesTexts.getText();
		Assert.assertTrue("Annual Deductible Stage heading is not present",
				all_text.contains("Annual Deductible Stage"));
		Assert.assertTrue("Initial Coverage Stage heading is not present", all_text.contains("Initial Coverage Stage"));
		Assert.assertTrue("Catastrophic Coverage Stage heading is not present",
				all_text.contains("Catastrophic Coverage Stage"));
	}

	/** 
	 * Validates tiers text such as year layer and plan 
	 */
	public void verifyTiersTexts(String year, String layer, String plan) {

		String all_text = tierTexts.getText();
		Assert.assertTrue(year + " is not present", all_text.contains(year));
		Assert.assertTrue(layer + " is not present", all_text.contains(layer));
		Assert.assertTrue(plan + " is not present", all_text.contains(plan));
	}

	/** 
	 * select Preferred Mail Service Pharmacy 
	 */
	public void selectPharmacyMailServicePharmacy() throws InterruptedException {

		// String all_text = pharmacyResults.getText();

		if (pharmacyResults.getText().contains("Preferred Mail Service")) {
			mail_service_select_btn.click();

			Thread.sleep(4000);

			Assert.assertTrue("Preferred Mail Service Pharmacy is not selected",
					SelectedName.getText().contains("Preferred Mail Service Pharmacy"));
		}

	}

	/** 
	 * Validates Learn More Home Delivery Link 
	 */
	public void click_learnMoreHomeDeliveryLink() throws InterruptedException

	{
		learnMoreHomeDelivery.click();
		Thread.sleep(3000);
	}

	/** Validates Learn More Delivery Content 
	 * 
	 */
	public void verifyLearnMoreDeliveryContent(String content) {
		homeDeliveryContent.getText().contains(content);
		Assert.assertTrue(content + "is not present", homeDeliveryContent.getText().contains(content));
	}

	/** Validates pharmacy is selected on the page
	 * @TODO: Need Cleanup
	 */
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

	/** Validates pharmacy is selected on the page
	 * 
	 */
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

	/** Validates drug with switch to generic option present on the page
	 * 
	 */
	public void validateSwitchGenericOption() {

		WebElement switchGenericOption = driver.findElement(By.id("generic-drug-switch-btn-0"));
		System.out.println("switch generic option" + switchGenericOption.getText());
		if (switchGenericOption.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Drug does not have switch to generic option ",false);
		}


	}

	/** Validates switch now link on the page
	 * 
	 */
	public void validateSwitchNowLink() {
		/*	int drugscount = getDrugsCount();
		System.out.println("drugscount==="+drugscount);

		if(drugscount>0){
		 */	WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-0"));
		 if (switchNowLink.isDisplayed()) {
			 Assert.assertTrue(true);
		 } else {
			 Assert.assertTrue("Switch now link is not present",false);
		 }

		 /*}else{
			//System.out.println("0 drugs");
			Assert.assertTrue("There are no drugs added ",false);
		}*/

	}

	/** Validates save money generic message
	 * 
	 */
	public void validateSaveGenericMessage() {
		int drugscount = getDrugsCount();
		/*if (drugscount > 0) {*/
		List<WebElement> saveGenericMessage = driver
				.findElements(By.id("generic-drug-saving-amount-0"));
		String valSaveGenericMessage = saveGenericMessage.get(0).getText();
		if (valSaveGenericMessage.contains("Save")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Save money message is incorect",false);
		}

		/*} else {
			Assert.assertTrue("There are no drugs added ", false);
		}*/

	}


	/** Validates Save Dollar Value Message
	 * TODO: Need clean up validateSaveGenericMessage duplicate to this.
	 */
	public void validateSaveDollarValueMessage() throws InterruptedException {
		int drugscount = getDrugsCount();

		List<WebElement> saveGenericMessage = driver
				.findElements(By.id("generic-drug-saving-amount-0"));
		String valSaveGenericMessage = saveGenericMessage.get(0).getText();
		Assert.assertTrue("Save dollar amount message is incorect. Expect element not to have the text 'Save money' | Actual: "
				+ "valSaveGenericMessage="+valSaveGenericMessage, 
				!valSaveGenericMessage.contains("Save money"));
	}

	/** click on switch now button
	 * 
	 */
	public void clickSwitchNow() throws InterruptedException {
		Dimension dim = new Dimension(1280,1024);
		driver.manage().window().setSize(dim);


		WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-0"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", switchNowLink);
		//switchNowLink.click();
		Thread.sleep(3000);

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




	}

	/** click on switch to generic button
	 * 
	 */
	public void clickSwitchToGeneric() throws InterruptedException {
		if(dceValidate(btnSwitchUpd))
		{
			btnSwitchUpd.click();
			CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
			Assert.assertTrue(true);
		}
		else Assert.assertTrue("update switch to generic button is not present", false);
	}

	/** Validates whether branded drug switched to generic drug ATORVASTATIN
	 * 
	 */
	public void isGeneric() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> lbGenericdrug = driver.findElements(By.xpath("//p[@class='subtitle drugdosagestrength ng-binding']"));  
		String[] genericDrug = lbGenericdrug.get(0).getText().split(" ");
		if (genericDrug[0].equalsIgnoreCase("ATORVASTATIN")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue("Branded drug is not switched to generic drug",false);
		}
	}

	/** Navigates to  DCE page
	 * Todo - Need clean up to remove this hard code stuff
	 */
	public void navigateToDCETool() throws InterruptedException {


		String NewDCEUrl;

		if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
			NewDCEUrl = "https://www.team-b-aarpmedicareplans.uhc.com/content/aarpmedicareplans/en/drugcostestimatoracquisition.html";
		} else {
			NewDCEUrl = "https://www.team-b-uhcmedicaresolutions.uhc.com/content/uhcmedicaresolutions/en/drugcostestimatoracquisition.html";
		}

		driver.get(NewDCEUrl);
		CommonUtility.waitForPageLoad(driver, overlay_disappeared, 10);
	}

	/** 
	 * Add branded drug
	 */
	public void addBrandedDrug(String drug, String dosage, String quantity, String frequency ) throws InterruptedException {
		this.clickOnAddDrug();
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(driver);
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
		addDrugDetails.selectDosage(dosage);
		addDrugDetails.selectQnty(quantity);
		addDrugDetails.selectFrequency(frequency);

		addDrugDetails.continueAddDrugDetailsBranded();

		SavingsOppurtunity savings_oppurtunity = new SavingsOppurtunity(driver);
		savings_oppurtunity.savedrugbutton();
	}

	/** 
	 * Add Generic drug
	 */
	public void addGenricDrug(String drug, String dosage, String quantity, String frequency ) throws InterruptedException {
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(driver);
		this.clickOnAddDrug();
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
		addDrugDetails.selectDosage(dosage);
		addDrugDetails.selectQnty(quantity);
		addDrugDetails.selectFrequency(frequency);
		addDrugDetails.continueAddDrugDetailsGeneric();
	}

	public void switchToGenericDrug(String branddosage, String gendosage) throws InterruptedException{

		//*[@id="generic-drug-switch-btn-1"]
		System.out.println("branddosage=="+branddosage);

		System.out.println("gendosage=="+gendosage);
		//WebElement switchNowLink = driver.findElement(By.xpath("//p[contains(text(), '"+ branddosage+"')]/ancestor::section//a[contains(text(), 'SWITCH NOW')]"));
		//p[contains(text(), 'Exelon Transdermal Patch DIS 9.5MG/24')]/ancestor::section//a[contains(text(), 'SWITCH NOW')]
		//CommonUtility.waitForPageLoad(driver, switchNowLink, 20);

		Dimension dim = new Dimension(1280,1024);
		driver.manage().window().setSize(dim);


		WebElement switchNowLink = driver.findElement(By.id("generic-drug-switch-btn-1"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", switchNowLink);
		//switchNowLink.click();
		//Thread.sleep(3000);

		/*	if (validate(switchNowLink)){
				switchNowLink.click();

			}	
			else Assert.assertTrue("Unable to see switch now link", false);
		 */
		CommonUtility.waitForPageLoad(driver, genericDrugText, 20);
		//	waitForPageLoad(WebDriver driver, WebElement element, long timeout)

		Assert.assertEquals("Generic drug is not matching", gendosage, genericDrugText.getText());
		clickSwitchToGeneric();

	}




	public static void waitForloader(WebDriver driver, WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			WebElement elementExpected = wait.until(ExpectedConditions.visibilityOf(element));

			System.out.println("----waitForloader---elementExpected======"+elementExpected);


			if ((elementExpected.getAttribute("style").isEmpty() || elementExpected.getText() == null)) {
				timeout = timeout - 5;
				if (timeout > 0) {
					waitForloader(driver, element, timeout);
				}
			}

		} catch (Exception e) {
			timeout = timeout - 5;
			if (timeout > 0) {
				waitForloader(driver, element, timeout);
			} else {
				System.out.println("Not able to locate this " + element + " on page");
				return;
			}
		}

	}

	public boolean validateOptumRxPage() {
		if(driver.getCurrentUrl().contains("optumrx.com/public/sso-landing"))
			return true;
		return false;
	}

	public void addDrug(String drug, String dosage, String quantity, String frequency ) throws InterruptedException {
		this.clickOnAddDrug();
		AddNewDrugModal addNewDrugModal = new AddNewDrugModal(driver);
		addNewDrugModal.typeDrugName(drug);
		addNewDrugModal.submit();
		AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
		//addDrugDetails.selectDosage(dosage);
		addDrugDetails.selectQnty(quantity);
		addDrugDetails.selectFrequency(frequency);
		addDrugDetails.continueAddDrugDetailsGeneric();

	}

	@FindBy(xpath = "//a[contains(@class,'cta-button pharmacy-tab-show ng-scope')]") 
	public WebElement Slect_PharmacyBttn; 

	@FindBy(xpath = "//a[contains(@id,'select-pharmacy-buttons_0')]") 
	public WebElement Selct_Button;

	@FindBy(xpath = "//a[contains(@dtmname,'dce:step 2 pharmacy:select pharmacy:next:view costs')]") 
	public WebElement view_CostButtn;

	@FindBy(xpath = "//a[contains(@href,'Step_Therapy_PWAG')]") 
	public WebElement stepTherpayPDFLink;

	@FindBy(xpath = "//a[contains(@href,'Step_Therapy_PWAG')]") 
	public WebElement priorAuthPDFLink;

	public void viewSTandPALink() {
		Slect_PharmacyBttn.click();
		validateNew(Selct_Button);
		Selct_Button.click();
		validateNew(view_CostButtn);
		view_CostButtn.click();
		validateNew(stepTherpayPDFLink);
		if(stepTherpayPDFLink.isDisplayed()) {
			Assert.assertTrue("Step Therapy PDF Link Displayed",true);
		} else {
			Assert.assertTrue("Step Therapy PDF Link DID NOT Displayed",false);
		}
		if(priorAuthPDFLink.isDisplayed()) {
			Assert.assertTrue("Prior Authorization PDF Link Displayed",true);
		} else {
			Assert.assertTrue("Prior Authorization PDF Link DID NOT Displayed",false);
		}


	}

	public void openPAandSTPDF() {

		stepTherpayPDFLink.click();
		switchToNewTab();
		if(driver.getCurrentUrl().contains("Step_Therapy_PWAG_2019.pdf")) {
			System.out.println("The PDF page opened");
		}

		driver.switchTo().defaultContent();

		priorAuthPDFLink.click();
		switchToNewTab();
		if(driver.getCurrentUrl().contains("Step_Therapy_PWAG_2019.pdf")) {
			System.out.println("The PDF page opened");
		}
	}


	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean dceValidate(WebElement element) {
		long timeoutInSec=0;
		return dceValidate(element, timeoutInSec);
	} 

	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean dceValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public boolean isformularyPDF() {

		if(validate(formularypdf)){
			return true;
		}else{
			return false;
		}
	}

	public void openFormularyPDF() {

		formularypdf.click();
		switchToNewTab();
		if(driver.getCurrentUrl().contains(".pdf")) {
			System.out.println("The PDF page opened");
		}

	}

}



