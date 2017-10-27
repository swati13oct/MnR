/**
 * 
 */
package pages.member.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.JsonObject;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.AcquisitionHomePage;

/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoveragePage extends UhcDriver {

	public PageData benefitsCoverage;

	public JSONObject benefitsandcoverageJson;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;

	@FindBy(className = "start-search-atdd")
	private WebElement startSerch;

	@FindBy(className = "changepcp-atdd")
	private WebElement changePcp;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[1]/div/div[2]/div[2]/div[2]/div/div/div/div/button")
	private WebElement addRiderButton;

	@FindBy(xpath = "//*[@id='addBenefitModal']/div/div/div[3]/input")
	private WebElement addRiderPopupButton;

	@FindBy(xpath = "//a[contains(.,'CANCEL')]")
	private WebElement cancelButton;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[1]/div/div[2]/div[1]/div[2]/div/div/div/div/button")
	private WebElement removeRiderButton;

	@FindBy(xpath = "//*[@id='removeBenefitModal']/div/div/div[3]/input")
	private WebElement removeRiderPopupButton;

	@FindBy(className = "btn_repalceRider_atdd ")
	private WebElement replacceRiderPopupButton;

	@FindBy(xpath = "//a[contains(.,'contact us')]")
	private WebElement contactUsLink;

	 @FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[1]")
	private WebElement pdfsectionviewlabel;

	@FindBy(className = "atdd-document-text")
	private WebElement pdfsectiondocumentlabel;
	
	@FindBy(className = "atdd-language-dropdown")
	private WebElement langdropdown;

	@FindBy(xpath = ".//*[@id='drug-costs']")
	private WebElement preselected;
	
	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	private WebElement DrugCostheaderandtext;

	@FindBy(id = "drug-costs")
	private WebElement DrugCostDropdown;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[2]/div/div/div/div/p")
	private WebElement locateapharmacysection;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[2]/a")
	private WebElement locateapharmacybutton;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[6]/div/span/div/div/div/div/p")
	private WebElement DrugCoverageText;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[6]/div/span/div/div/div/div/h3/span")
	private WebElement DrugCoverageHeader;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[1]/div/div/div/div/p")
	private WebElement LookupDrugstext;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[1]/a")
	private WebElement LookUpDrugsButton;
	
	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[4]/div/div/div/div/div[1]/div/a")
	private WebElement Learnmoretierslink;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[4]/div/div/div/div/div[2]/div/a")
	private WebElement Learnmorestagelink;

	@FindBy(id = "mapdPageNonLis")
	private WebElement drugcopaytable;
	
	@FindBy(xpath = ".//*[@id='coPaySection']/div/section/div/div[4]/div/div[1]/div")
	private WebElement learnoreContent;

	@FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[1]/div")
	private WebElement drugheader;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div/div/div/h2")
	private WebElement DrugCopayHeader;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div/div/div/p")
	private WebElement DrugCopayText;

        @FindBy(id = "drug-costs")
	private WebElement pharmacydropdown;

	@FindBy(id = "mapdPageLis")
	private WebElement RetailDrugCost_Table;

	@FindBy(className = "atdd-benefitssummary-headertitle")
	private WebElement BenefitsSummaryHeader;

	@FindBy(className = "atdd-benefitssummary-subheadertitle")
	private WebElement Copayscoinsuranceheader;

	@FindBy(className = "atdd-hospitalvisits-title")
	private WebElement HospitalVisits;

	@FindBy(className = "atdd-emergencycare-title")
	private WebElement EmergencyHeader;

	@FindBy(className = "atdd-ambulance-title")
	private WebElement AmbulanceHeader;

	@FindBy(className = "atdd-officevisits-title")
	private WebElement OfficeVisits;

	@FindBy(className = "atdd-outpatientsurgery-title")
	private WebElement OutpatientSurgeryCenter;
	
	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div[1]/div[6]/div/div[1]/div/h2/p")
	private WebElement PrimaryCareProviderHeader;
	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div[1]/div[6]/div/div[2]/div[1]/div/header/span")
	private WebElement YourPrimaryCareProvider;
	@FindBy(className = "changepcp-atdd")
	private WebElement ChangeYourPcpButton;
	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div[1]/div[6]/div/div[2]/div[2]/div")
	private WebElement SearchforaPhysician;
	@FindBy(className = "start-search-atdd")
	private WebElement StartSearch;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[3]/div/div/div/header/span")
	private WebElement ParticipatingHospitalStays1;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[4]/div/div/div/header/span")
	private WebElement ParticipatingHospitalStays2;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[5]/div/div/div/header")
	private WebElement TravelBenefitHeader;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[6]/div/div/div/header/span")
	private WebElement BloodPackedRedBloodCellsPartA;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[7]/div/div/div/header/span")
	private WebElement SkilledNursingFacilityStays;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[8]/div/div/div/header/span")
	private WebElement HospiceCare;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[9]/div/div/div/header/span")
	private WebElement MedicalCare;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[10]/div/div/div/header/span")
	private WebElement BloodPackedRedBloodCellsPartB;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div[2]/div[11]/div/div/div/header/span")
	private WebElement EmergencyCare;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement nameLabel;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberID;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[1]/div/div[3]/div[1]/span")
	private WebElement effective_Date;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[4]/span[2]")
	private WebElement Monthly_Premium;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedhelpShip;

	@FindBy(className = "atdd-tech-header")
	private WebElement TechnicalSupportShip;

	@FindBy(className = "atdd-general-header")
	private WebElement GeneralQuestionShip;

	@FindBy(className = "atdd-claims-header")
	private WebElement ClaimsSupportShip;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[1]")
	private WebElement view_label;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[2]")
	private WebElement documents_label;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[2]/div[1]/div/div[1]/div/span")
	private WebElement ExtraHelp;

        @FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[4]/button")
	private WebElement MakePaymentButton;

	@FindBy(xpath = ".//*[@id='planBenefitsApp']/div/div/div/div/div/div[2]/a")
	private WebElement learnmorebutton;

        @FindBy(className = "atdd-contact-us")
	private WebElement contactUslink;
	
	@FindBy(xpath = "html/body/div[2]/div[4]/div[1]/div[2]/section[2]/div/div[3]/div/p")
	private WebElement Seemorewaystext;
	
	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(xpath = "html/body/div[2]/div[4]/div[1]/div[2]/section[2]/div/div[3]/div/p")
	private WebElement Contactussection;

	@FindBy(className = "atdd-needhelp-disclaimer-text")
	private WebElement disclaimersLink;

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	@FindBy(className = "atdd-bnc-handimg")
	private WebElement handimage;

	@FindBy(className = "atdd-bnc-discountsubtitle")
	private WebElement textdiscountservices;

	@FindBy(className = "atdd-bnc-specialdscnt-desc")
	private WebElement textdiscountservices1;

	@FindBy(className = "atdd-bnc-discounttitle")
	private WebElement headerdiscountservices;

	@FindBy(xpath = ".//*[@id='planBenefitsApp']/div/div/div/div/div/div[2]")
	private WebElement vassection;


	@FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[1]/div/div/h2")
	private WebElement Header;

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";
	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get PHR expected data */
		JSONObject benefitsExpectedJson = expectedDataMap.get(CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, globalExpectedJson);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);

		return benefitsExpectedJson;

	}

	public void validateFieldsOnBenefitsAndCoveragePage() {

		try {
			validate(planName);

			validate(memberId);

			validate(memberName);

			validate(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	@Override
	public void openAndValidate() {

		/*
		 * JSONObject jsonObject = new JSONObject(); for (String key :
		 * benefitsCoverage.getExpectedData().keySet()) { List<WebElement>
		 * elements = findElements(benefitsCoverage.getExpectedData().get(key));
		 * if (elements.size() == 1) { validate(elements.get(0)); try {
		 * jsonObject.put(key, elements.get(0).getText()); } catch
		 * (JSONException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } else if (elements.size() > 1) { JSONArray
		 * jsonArray = new JSONArray(); for (WebElement element : elements) {
		 * 
		 * validate(element); try { JSONObject jsonObjectForArray = new
		 * JSONObject();
		 * jsonObjectForArray.put(benefitsCoverage.getExpectedData().get(key).
		 * getElementName(), element.getText());
		 * jsonArray.put(jsonObjectForArray); } catch (JSONException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } } try {
		 * jsonObject.put(key, jsonArray); } catch (JSONException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * } benefitsandcoverageJson = jsonObject;
		 * 
		 * System.out.println("BenefitsCoverageJson----->" +
		 * benefitsandcoverageJson);
		 */
	}

	public void navigateToRallySearchWindow() {
		// TODO Auto-generated method stub
		validate(startSerch);
		startSerch.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void navigateToContactUsPage() {
		// TODO Auto-generated method stub
		validate(changePcp);
		changePcp.click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnAddRider() {
		// TODO Auto-generated method stub
		System.out.println("testng");
		try {
			Thread.sleep(30000);
			validate(addRiderButton);
			addRiderButton.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BenefitsAndCoveragePage validateAddRiderPopup() throws Exception {

		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
			validate(addRiderPopupButton);
			validate(cancelButton);
			// Thread.sleep(3000);
			System.out.println("Add this rider button to be clicked");
			addRiderPopupButton.click();

		}
		return null;
	}

	public void clickOnRemoveRider() {
		// TODO Auto-generated method stub
		validate(removeRiderButton);
		removeRiderButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BenefitsAndCoveragePage validateRemoveRiderPopup() throws Exception {

		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
			validate(removeRiderPopupButton);
			validate(cancelButton);
			Thread.sleep(3000);
			removeRiderPopupButton.click();
		}
		return null;
	}

	public BenefitsAndCoveragePage validateReplaceRiderPopup() throws Exception {

		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);
			}
			validate(replacceRiderPopupButton);
			validate(cancelButton);
			Thread.sleep(3000);
			addRiderPopupButton.click();
		}
		return null;
	}



	public ContactUsPage navigatesToContactUsPage() {

		contactUsLink.click();

		System.out.println("title is " + getTitle());
		if (getTitle().equalsIgnoreCase("AARP Medicare Plans | Contact Us")) {
			return new ContactUsPage(driver);
		}
		return null;

	}

	public void validatelabels() {
		validate(pdfsectionviewlabel);
		validate(pdfsectiondocumentlabel);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validate_langdropdown_first_selection() {
		if (langdropdown.isDisplayed()) {
			Select langdropdwn = new Select(langdropdown);
			if (langdropdwn.getFirstSelectedOption().getText().equals("ENGLISH")) {
				Assert.assertTrue(true);
			} else
				Assert.fail("Issue in English selection");
		} else
			Assert.fail("Plan year dropdown not displayed");

	}

	public void validate_langdropdown_select(String language) {
		Select langdropdwn = new Select(langdropdown);
		langdropdwn.selectByVisibleText(language);
	}

        
        public void Validate_dce_Section() {

		
			validate(drugheader);
		
	}

	public void validate_drugcopayheaderntext() {
		validate(DrugCopayHeader);
		validate(DrugCopayText);

	}

	public void validatedrugcoverageheaderandtext() {
		validate(DrugCoverageHeader);
		validate(DrugCoverageText);
	}

	public void ValidatelocatephrmacySection() {

		validate(locateapharmacysection);
		validate(locateapharmacybutton);
	}

	public void LookupDrugbutton() {

		validate(LookupDrugstext);
                validate(LookUpDrugsButton);
	}

       public void validatedrugcopaytable() {
		// Select langdropdwn = new Select(langdropdown);

		validate(drugcopaytable);

	}

       public void validateLearnmoreLinkstage() {
		// TODO Auto-generated method stub
		validate(Learnmorestagelink);
	}
	
	public void validate_tierlinknotdisplay() {
		if (Learnmoretierslink.isDisplayed()) {
			Assert.fail("The element" + Learnmoretierslink.getText() + "should not display");
			System.out.println("The element " + Learnmoretierslink.getText() + "should not display");
		} else {
			Assert.assertTrue(true);
		}

	} 
 
       public void validate_dropdownnotdisplay() {
		if (DrugCostDropdown.isDisplayed()) {
			Assert.fail("The element" + DrugCostDropdown.getText() + "should not display");
			System.out.println("The element " + DrugCostDropdown.getText() + "should not display");
		} else {
			Assert.assertTrue(true);
		}

	}

	public void validateLearnmoreLink() {
		// TODO Auto-generated method stub
		validate(Learnmorestagelink);
		validate(Learnmoretierslink);
	}

	public void clickOnLearnmoreaboutlinktier(JSONObject benefitsandcoverageExectedJson) {
		// TODO Auto-generated method stub
			Learnmoretierslink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String finalPath;
		String table_data;
		
			finalPath = learnmorelinktiertext_xpath + "/p[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 1 Drugs", table_data);
			// to validate amount Billed
			finalPath = learnmorelinktiertext_xpath + "/p[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Nulla ea veniam nostrud reprehenderit eiusmod excepteur adipisicing nulla cupidatat cupidatat. Excepteur amet exercitation minim sint nulla occaecat dolor anim duis proident ad ea voluptate do enim consequat ea.", table_data);
			// to validate amount Paid
			finalPath = learnmorelinktiertext_xpath + "/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 2 Drugs", table_data);
			// to validate paid Date
			finalPath = learnmorelinktiertext_xpath + "/p[5]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 3 Drugs", table_data);
			finalPath = learnmorelinktiertext_xpath + "/p[7]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("ier 4 Drugs", table_data);
			finalPath = learnmorelinktiertext_xpath + "/p[9]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 5 Drugs", table_data);
			
			Learnmoretierslink.click();
			
		
		 
	}

	public void clickOnLearnmoreaboutlinkstage(JSONObject benefitsandcoverageExectedJson) {
		// TODO Auto-generated method stub

		Learnmorestagelink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Thread.sleep(15000);
		String finalPath;
		String table_data;
	

		
			finalPath = learnmorestagetext_xpath + "/p[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Annual Deductible Stage", table_data);
			// to validate amount Billed
			finalPath = learnmorestagetext_xpath + "/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Initial Coverage Stage", table_data);
			// to validate amount Paid
			finalPath = learnmorestagetext_xpath + "/p[5]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Coverage Gap Stage", table_data);
			// to validate paid Date
			finalPath = learnmorestagetext_xpath + "/p[7]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Catastrophic Coverage Stage", table_data);

			Learnmorestagelink.click();
		
	}


	public void Validate_drugheader_section() {

		try {
			validate(drugheader);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void validate_drugcostheaderntext() {
		validate(DrugCostheaderandtext);

	}

	public void validate_preselectedPharmacy() {
		validate(preselected);

	}

	public void validate_drugcostdropdownoptions()

	{
		if (DrugCostDropdown.isDisplayed()) {
			List<String> listActual = new ArrayList<String>();
			Select dropdown = new Select(DrugCostDropdown);
			List<WebElement> webElements = dropdown.getOptions();
			for (WebElement element : webElements) {
                    if (element.getText().equals("Standard Retail Pharmacy") )
                    {
                    	Assert.assertTrue("The element" + element.getText() +"should display" , true);;
					
					System.out.println("The element " + element.getText() + "should not display");
				} 
                    else if (element.getText().equals("Preferred Mail Service Pharmacy") )
                    	 {
                    	Assert.assertTrue("The element" + element.getText() +"should display" , true);;
					
					System.out.println("The element " + element.getText() + "should not display");
				} 
                    else if (element.getText().equals("Preferred Retail Pharmacy")) 
                   	 {
                   	Assert.assertTrue("The element" + element.getText() +"should display" , true);;
					
					System.out.println("The element " + element.getText() + "should not display");
				} 
                    else
                    {
                    
					Assert.fail();
				}
			}
		}
	}


	public void Pharmacy_Dropdown() {

		try {
			validate(pharmacydropdown);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void ValidateDrugCostTableMAPD() {
		// TODO Auto-generated method stub

		validate(RetailDrugCost_Table);
		System.out.println("c");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Inside catch");
			e.printStackTrace();
		}

	}


	public void validatePlanOverview() {
		// TODO Auto-generated method stub

		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);
		// validateNew(Monthly_Premium);
		// validateNew(MakePaymentButton);

	}

	public void validateneedhelpheaderShip() {
		validateNew(NeedhelpShip);
		validateNew(TechnicalSupportShip);
		validateNew(GeneralQuestionShip);
		validateNew(ClaimsSupportShip);
	}

	public void validateContactUsNeedHelp() {
         try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(Seemorewaystext);

	}

	public void contactUslinkShip() {
                try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(contactUslink);
		contactUslink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Title is " + getTitle());

		//Assert.assertTrue(getTitle().equalsIgnoreCase("Contact Us"));

	}

	public boolean getview_label() {
		return validateNew(view_label);
	}

	public boolean getdocuments_label() {
		return validateNew(documents_label);
	}

	public void validatePlanOverviewLis() {
		// TODO Auto-generated method stub

		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);
		// validateNew(Monthly_Premium);
		validateNew(ExtraHelp);
		// validateNew(MakePaymentButton);

	}

	public void validatePlanOverviewShip() {
		// TODO Auto-generated method stub

		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);

	}

	public void validateHeadersShip() {
		// TODO Auto-generated method stub

		validateNew(BenefitsSummaryHeader);
		validateNew(ParticipatingHospitalStays1);
		validateNew(ParticipatingHospitalStays2);
		validateNew(TravelBenefitHeader);
		validateNew(BloodPackedRedBloodCellsPartA);
		validateNew(SkilledNursingFacilityStays);
		validateNew(HospiceCare);
		validateNew(MedicalCare);
		validateNew(BloodPackedRedBloodCellsPartB);
		validateNew(EmergencyCare);

	}

	
	public void validatePrimaryCareProvider() {
		// TODO Auto-generated method stub
		validateNew(PrimaryCareProviderHeader);
		validateNew(YourPrimaryCareProvider);
		validateNew(ChangeYourPcpButton);
		validateNew(SearchforaPhysician);
		validateNew(StartSearch);
		
	}
	public void validateNeedhelpheader() {

		try {
			validate(NeedHelpHeader);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,400)", "");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			validate(disclaimersLink);
			System.out.println("text" + disclaimersLink.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void validatecontactussection() {

                try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (Contactussection.getText().contains("See more ways to contact us")) {
			System.out.println("contactus section is coming ");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Contactussection.getText() >>>>>>" + Contactussection.getText());
		}

	}

	public void vasSection() {

		validate(textdiscountservices);
		validate(textdiscountservices1);
		validate(headerdiscountservices);
	}

	public void handimage() {

		validate(handimage);

	}

	public void learnmorebutton() {

		validate(learnmorebutton);

	}



	public ValueAddedServicepage navigateToValueAddService() {
		validate(learnmorebutton);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		learnmorebutton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.driver.getTitle().equalsIgnoreCase("Value Added Services")) {
			System.out.println(driver.getTitle());
			return new ValueAddedServicepage(driver);
		}
		return null;

	}

	public void validateHeaders() {
		validateNew(BenefitsSummaryHeader);
		validateNew(Copayscoinsuranceheader);
		validateNew(HospitalVisits);
		validateNew(OfficeVisits);
		validateNew(OutpatientSurgeryCenter);

	}
	
	public void clickOnDisclaimers() {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateNew(disclaimersLink);
		disclaimersLink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public ValueAddedServicepage clickOnLearnMore() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1500)", "");
		validate(learnmorebutton);
		learnmorebutton.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.driver.getTitle().equalsIgnoreCase("Value Added Services")) {
			System.out.println(driver.getTitle());
			return new ValueAddedServicepage(driver);
			
		}
		return null;
		
	}



}
