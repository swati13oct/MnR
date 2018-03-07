/**
 * 
 */
package pages.deprecated.member.bluelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.RallyDashboardPage;

/**
 * @author njain112
 *
 */
public class BenefitsAndCoveragePage1 extends UhcDriver {

	public PageData benefitsCoverage;

	public JSONObject benefitsandcoverageJson;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;
	
	@FindBy(className = "atdd-contact-us")
	private WebElement contactUslink;
	
	@FindBy(xpath = "html/body/div[2]/div[4]/div[1]/div[2]/section[2]/div/div[3]/div/p")
	private WebElement Seemorewaystext;
	
	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(xpath = "html/body/div[2]/div[4]/div[1]/div[2]/section[2]/div/div[3]/div/p")
	private WebElement Contactussection;

        //private WebElement Contactussection;

	@FindBy(className = "atdd-needhelp-disclaimer-text")
	private WebElement disclaimersLink;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[1]/div")
	private WebElement planBenefitsDocuments;

	@FindBy(xpath = ".//*[@id='lang-select-2']")
	private WebElement langdropdown;

	@FindBy(xpath = ".//*[@id='ancillary']/div[2]/div[1]/div")
	private WebElement Hearingsection;

	@FindBy(xpath = ".//*[@id='ancillary']/div[2]/div[2]/div/div/div")
	private WebElement Hearingaid;

	@FindBy(xpath = ".//*[@id='ancillary']/div[2]/div[3]/div[1]/div")
	private WebElement Visionsection;

	@FindBy(xpath = ".//*[@id='ancillary']/div[2]/div[3]/div[2]/div")
	private WebElement Dentalsection;

	@FindBy(xpath = ".//*[@id='ancillary']/div[1]/div")
	private WebElement Headersection;

	@FindBy(xpath = ".//*[@id='ancillary']/div[2]/div[4]/div/div")
	private WebElement chiropracticsection;

/*	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[6]/div/span/div/div/div/div/p")
	private WebElement DrugCoveragetext;*/
	
	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	private WebElement DrugCoveragetext;
	
	

	/*@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[6]/div/span/div/div/div/div/h3/span")
	private WebElement DrugCoverageHeader;*/
	
	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;
	

        @FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div[2]/div/div/h2")
	private WebElement lisDrugCopayHeader;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div[2]/div/div/p")
	private WebElement lisDrugCopayText;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[1]/div/div/div/div/p")
	private WebElement LookupDrugstext;

	/*@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[1]/a")
	private WebElement LookUpDrugsButton;*/
	
	@FindBy(className = "atdd-bnc-lookupdrugbtn")
	private WebElement LookUpDrugsButton;
	
	/*@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div/div/div/h2")
	private WebElement DrugCopayHeader;*/
	
	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement DrugCopayHeader;

/*	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div/div/div/p")
	private WebElement DrugCopayText;*/
	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement DrugCopayText;
	
	@FindBy(id = "drug-costs")
	private WebElement DrugCostDropdown;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	private WebElement DrugCostheaderandtext;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[3]/div/div/div[2]/p")
	private WebElement Pharmacycontent;

	@FindBy(xpath = ".//*[@id='waystosave']/div/div/div[1]/div/h1")
	private WebElement TextWaystoSave;

/*	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[4]/div/div/div/div/div[1]/div/a")
	private WebElement Learnmoretierslink;*/
	
	@FindBy(className = "atdd-bnc-drgpricingtiers")
	private WebElement Learnmoretierslink;
	

	/*@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[4]/div/div/div/div/div[2]/div/a")
	private WebElement Learnmorestagelink;*/
	
	@FindBy(className = "atdd-bnc-drgstgtiers")
	private WebElement Learnmorestagelink;

	/*@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[2]/div/div/div/div/p")
	private WebElement locateapharmacysection;*/
	
	@FindBy(className = "atdd-bnc-locatephrmcy-info")
	private WebElement locateapharmacysection;
	
	/*@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[2]/a")
	private WebElement locateapharmacybutton;*/
	
	@FindBy(className = "atdd-bnc-locatepharmacybtn")
	private WebElement locateapharmacybutton;
	

	@FindBy(id = "mapdPageNonLis")
	private WebElement drugcopaytable;

	@FindBy(id = "mapdPageLis")
	private WebElement RetailDrugCost_Table;


	@FindBy(id = "waystosave")
	private WebElement waysToSave;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[1]")
	private WebElement view_label;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[2]")
	private WebElement documents_label;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	private WebElement planName;

	@FindBy(className = "atdd-benefitsoverview-membernamelabel")
	private WebElement nameLabel;

	@FindBy(className = "atdd-benefitsoverview-memberidlabel")
	private WebElement memberID;

	@FindBy(className = "atdd-benefitsoverview-effectivedatelabel")
	private WebElement effective_Date;

	@FindBy(className = "atdd-benefitsoverview-monthlypremium-label")
	private WebElement Monthly_Premium;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[2]/div[1]/div/div[1]/div/span")
	private WebElement ExtraHelp;

/*	@FindBy(className = "atdd-benefitssummary-headertitle")
	private WebElement BenefitsSummaryHeader;*/
	
	@FindBy(xpath = "//div[@class='page-header--left']/h1[contains(.,'Benefits Summary')]")
	private WebElement BenefitsSummaryHeader;
	/*@FindBy(className = "atdd-benefitssummary-subheadertitle")
	private WebElement Copayscoinsuranceheader;
*/
	@FindBy(xpath = "//span[contains(text(),'Medical Copays or Coinsurance')]")
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

	
	/*@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div[1]/div[6]/div/div[2]/div[1]/div/header/span")
	private WebElement YourPrimaryCareProvider;*/
	@FindBy(xpath = "//div[@id='pcpCard']/header/span[contains(text(),'PRIMARY CARE PROVIDER')]")
	private WebElement YourPrimaryCareProvider;
	
	
	@FindBy(className = "changepcp-atdd")
	private WebElement ChangeYourPcpButton;
	
	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div[1]/div[6]/div/div[2]/div[2]/div")
	private WebElement SearchforaPhysician;
	
	@FindBy(className = "start-search-atdd")
	private WebElement StartSearch;
	
	@FindBy(className = "primary-heading")
	private WebElement PrimaryCareProviderHeader;

   @FindBy(className= "atdd-bncsummary-primarycareprvdrheader")
	private WebElement PrimaryCareProviderHeaderHMO;
   
  /* @FindBy(xpath= "//*[@id='planBenefitsApp']/div[1]/div/div[4]/div/div[1]/div/div/div/div/div/h3/span")
 	private WebElement OutofPocketMaximum;*/
   @FindBy(xpath= "//div[@id='benefitsMain']//span[contains(text(),'Out-of-Pocket Maximum')]")
	private WebElement OutofPocketMaximum;
   
   @FindBy(className = "atdd-innetwrk-title")
 	private WebElement INNETWORK;

  @FindBy(className= "atdd-outnetwrktitle")
 	private WebElement OUTOFNETWORK;
    
	
	

	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	public BenefitsAndCoveragePage1(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		//String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		//benefitsCoverage = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		//openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get PHR expected data */
		JSONObject benefitsExpectedJson = expectedDataMap.get(CommonConstants.BENEFITS_AND_COVERAGE);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		// JSONObject globalExpectedJson =
		// expectedDataMap.get(CommonConstants.GLOBAL);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);
		// benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson,
		// commonExpectedJson);

		return benefitsExpectedJson;

	}

	public void validateFieldsOnBenefitsAndCoveragePage() {

		try {
			validateNew(planName);

			validateNew(memberId);

			validateNew(memberName);

			validateNew(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	public void openAndValidate() {
		validateFieldsOnBenefitsAndCoveragePage();
		/*JSONObject jsonObject = new JSONObject();
		for (String key : benefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsCoverage.getExpectedData().get(key));
			
			 * if (elements.size() == 1) { validate(elements.get(0)); try {
			 * jsonObject.put(key, elements.get(0).getText());
			 * //System.out.println("Text"+elements.get(0).getText()); } catch
			 * (JSONException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } else if (elements.size() > 1) {
			 
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {

				// validate(element);
				try {
					JSONObject jsonObjectForArray = new JSONObject();
					jsonObjectForArray.put(benefitsCoverage.getExpectedData().get(key).getElementName(),
							element.getText());
					jsonArray.put(jsonObjectForArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		benefitsandcoverageJson = jsonObject;

		System.out.println("BenefitsCoverageJson----->" + benefitsandcoverageJson);*/

	}

	public void PlanDocumentssection() {

		try {
			validateNew(planBenefitsDocuments);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}
	
	public void validateNeedhelpheader() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
			validateNew(NeedHelpHeader);
			
			
	}


	public void validatecontactussection() 
        {
                        try {
			Thread.sleep(20000);
		        } 
                        catch (InterruptedException e) 
                        {
			// TODO Auto-generated catch block
                       // TODO Auto-generated catch block
			e.printStackTrace();
		        }
	                if (Contactussection.getText().contains("more ways to contact us")) {
				System.out.println("contactus section is coming ");
				Assert.assertTrue(true);
			} else
			{
				Assert.fail("Contactussection.getText() >>>>>>" + Contactussection.getText());
			} 
		
	}
	
		public void  contactUslink() {
                try {
			Thread.sleep(20000);
		        } 
                        catch (InterruptedException e) 
                        {
			// TODO Auto-generated catch block
                       // TODO Auto-generated catch block
			e.printStackTrace();
		        }
		validateNew(contactUslink);
                try {
			Thread.sleep(20000);
		        } 
                        catch (InterruptedException e) 
                        {
			// TODO Auto-generated catch block
                       // TODO Auto-generated catch block
			e.printStackTrace();
		        }
		contactUslink.click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            System.out.println("Title is " + getTitle());
	    Assert.assertTrue(getTitle().equalsIgnoreCase("Contact Us"));
		
	
		
	}


	public void clickOnDisclaimers(JSONObject benefitsandcoverageExectedJson) {
		// TODO Auto-generated method stub

		disclaimersLink.click();
		// Thread.sleep(15000);
		String finalPath;
		String table_data;

		// validate(disclaimertextarea_xpath);
		try {
			finalPath = disclaimertextarea_xpath + "/p[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("1stline"), table_data);
			// to validate amount Billed
			finalPath = disclaimertextarea_xpath + "/p[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("2ndline"), table_data);
			// to validate amount Paid
			finalPath = disclaimertextarea_xpath + "/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("3rdline"), table_data);
			// to validate paid Date
			finalPath = disclaimertextarea_xpath + "/p[4]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("4thline"), table_data);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnDisclaimers() {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateNew(disclaimersLink);
		disclaimersLink.click();
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}


	public boolean getview_label() {
		return validateNew(view_label);
	}

	public boolean getdocuments_label() {
		CommonUtility.waitForPageLoadNew(driver, documents_label, 15);
		return validateNew(documents_label);
	}

	public void languagevalidation() {
		if (langdropdown.isDisplayed()) {
			List<String> listActual = new ArrayList<String>();
			Select dropdown = new Select(langdropdown);
			List<WebElement> webElements = dropdown.getOptions();
			for (WebElement element : webElements) {

				if (element.getText().equals("SPANISH") || element.getText().equals("CHINESE")) {
					Assert.fail("The element" + element.getText() + "should not display");
					System.out.println("The element " + element.getText() + "should not display");
				} else {
					Assert.assertTrue(true);
				}
			}
		}

	}

	public void validate_langdropdown_first_selection() {
		// WebElement langdropdown;
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

	public void HearingSection() {

		try {
			validateNew(Hearingsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void HearingAid() {

		try {
			validateNew(Hearingaid);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void Vision() {

		try {
			validateNew(Visionsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void Dental() {

		try {
			validateNew(Dentalsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void Header() {

		try {
			validateNew(Headersection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void chiropracticsection() {

		try {
			validateNew(chiropracticsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void validatedrugcoverageheaderandtext() {
		validateNew(DrugCoverageHeader);
		validateNew(DrugCoveragetext);
	}

	public void validatelookupdrugsbutton() {
		if (LookUpDrugsButton.isDisplayed()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Button not displayed");
	}

	public void validate_lookupdrugstext() {
		validateNew(LookupDrugstext);

	}

	public void validate_drugcopayheaderntext() {
		validateNew(DrugCopayHeader);
		validateNew(DrugCopayText);

	}

	public void validate_drugcostheaderntext() {
		validateNew(DrugCostheaderandtext);

	}

	public void validate_locateapharmacysection() {
		validateNew(locateapharmacysection);
		validateNew(locateapharmacybutton);

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
                try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (DrugCostDropdown.isDisplayed()) {
			Assert.fail("The element" + DrugCostDropdown.getText() + "should not display");
			System.out.println("The element " + DrugCostDropdown.getText() + "should not display");
		} else {
			Assert.assertTrue(true);
		}
		if (DrugCostDropdown.isDisplayed()) {
			Assert.fail("The element" + DrugCostDropdown.getText() + "should not display");
			System.out.println("The element " + DrugCostDropdown.getText() + "should not display");
		} else {
			Assert.assertTrue(true);
		}

	}

	public void validate_drugcostdropdownoptions()

	{
	    validateNew(DrugCostDropdown);
               
            /*if (DrugCostDropdown.isDisplayed()) {
                try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		}*/
	}


	public void validate_learnmoreaboutlink() {
		validateNew(Learnmoretierslink);
		validateNew(Learnmorestagelink);

	}

	public void validate_learnmoreaboutstagelink() {

		validateNew(Learnmorestagelink);

	}

	public void clickOnLearnmoreaboutlinktier() {
		// TODO Auto-generated method stub
			Learnmoretierslink.click();
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String finalPath;
		String table_data;
		
			finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[1]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 1 Drugs", table_data);
			// to validate amount Billed
			finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Nulla ea veniam nostrud reprehenderit eiusmod excepteur adipisicing nulla cupidatat cupidatat. Excepteur amet exercitation minim sint nulla occaecat dolor anim duis proident ad ea voluptate do enim consequat ea.", table_data);
			// to validate amount Paid
			finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 2 Drugs", table_data);
			// to validate paid Date
			finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[5]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 3 Drugs", table_data);
			finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[7]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 4 Drugs", table_data);
			finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[9]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Tier 5 Drugs", table_data);
			
			Learnmoretierslink.click();*/
			
		
		 
	}

	public void clickOnLearnmoreaboutlinkstage() {
		// TODO Auto-generated method stub

		Learnmorestagelink.click();
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Thread.sleep(15000);
		String finalPath;
		String table_data;

		
			finalPath = learnmorestagetext_xpath+"/div/div[1]/div/div/p[3]/b";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Annual Deductible Stage", table_data);
			// to validate amount Billed
			finalPath = learnmorestagetext_xpath+"/div/div[1]/div/div/p[5]/b";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Initial Coverage Stage", table_data);
			// to validate amount Paid
			finalPath = learnmorestagetext_xpath+"/div/div[1]/div/div/p[7]/b";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Coverage Gap Stage", table_data);
			// to validate paid Date
			finalPath = learnmorestagetext_xpath+"/div/div[1]/div/div/p[9]/b";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals("Catastrophic Coverage Stage", table_data);

			Learnmorestagelink.click();*/
		
	}


        public void validate_lisdrugcopayheaderntext() {
		validateNew(lisDrugCopayHeader);
		validateNew(lisDrugCopayText);

	}


	public void validatedrugcopaytable() {
		// Select langdropdwn = new Select(langdropdown);

		//validate(drugcopaytable);

	}

	public void validatedrugcosttable() {
		// TODO Auto-generated method stub
		validateNew(RetailDrugCost_Table);

	}

	public void validateWaystoSave() {
		validateNew(waysToSave);
		validateNew(TextWaystoSave);

		System.out.println(TextWaystoSave.getText());
		// Assert.assertEquals(, );

	}

	public void validatePlanOverview() {
		// TODO Auto-generated method stub

		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);
		//validate(Monthly_Premium);

	}

	public void validatePlanOverviewLis() {
		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);
		validateNew(Monthly_Premium);
		// validate(ExtraHelp);

	}

	public void validateHeaders() {
		validateNew(BenefitsSummaryHeader);
		validateNew(Copayscoinsuranceheader);
		validateNew(HospitalVisits);
		validateNew(OfficeVisits);
		validateNew(OutpatientSurgeryCenter);

	}

	public void validateHeadersGroup() {
		validateNew(BenefitsSummaryHeader);
		validateNew(Copayscoinsuranceheader);
		validateNew(EmergencyHeader);
		validateNew(AmbulanceHeader);
		validateNew(HospitalVisits);
		validateNew(OfficeVisits);
		validateNew(OutpatientSurgeryCenter);

	}

	public void validatePrimaryCareProvider() {

		validateNew(PrimaryCareProviderHeader);
		validateNew(YourPrimaryCareProvider);
		validateNew(ChangeYourPcpButton);
		//validate(SearchforaPhysician);
		//validate(StartSearch);

	}

	public void validatePrimaryCareProviderForGroup() {
	
		validateNew(PrimaryCareProviderHeaderHMO);
		
		
	}
	
	public void validateOutofPocketMax() {
		validateNew(OutofPocketMaximum);
		validateNew(INNETWORK);
		validateNew(OUTOFNETWORK);
		
	}

}
