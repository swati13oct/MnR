/**
 * 
 */
package pages.member.bluelayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.member.ulayer.ValueAddedServicepage;

/**
 * @author njain112
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
	
	 @FindBy(xpath = ".//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	 private WebElement planName1;
	
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

	@FindBy(id = "lang-select-2")
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

	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	private WebElement DrugCoveragetext;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;

    @FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement lisDrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement lisDrugCopayText;

	@FindBy(className = "atdd-bnc-lookupdrugs-info")
	private WebElement LookupDrugstext;

	@FindBy(className = "atdd-bnc-lookupdrugbtn")
	private WebElement LookUpDrugsButton;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement DrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement DrugCopayText;

	@FindBy(id = "drug-costs")
	private WebElement DrugCostDropdown;
	
	@FindBy(className = "atdd-bnc-drugcostsheading")
	private WebElement DrugCostHeader;
	
	@FindBy(className = "atdd-bnc-phrmcytext")
	private WebElement DrugCostheadertext;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	private WebElement DrugCostheaderandtext;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[3]/div/div/div[2]/p")
	private WebElement Pharmacycontent;

	@FindBy(xpath = ".//*[@id='waystosave']/div/div/div[1]/div/h1")
	private WebElement TextWaystoSave;

	@FindBy(className = "atdd-bnc-drgpricingtiers")
	private WebElement Learnmoretierslink;

	@FindBy(className = "atdd-bnc-drgstgtiers")
	private WebElement Learnmorestagelink;

	@FindBy(xpath = "atdd-bnc-locatephrmcy-info")
	private WebElement locateapharmacysection;

	@FindBy(className = "atdd-bnc-locatepharmacybtn")
	private WebElement locateapharmacybutton;

	@FindBy(id = "mapdPageNonLis")
	private WebElement drugcopaytable;

	@FindBy(id = "mapdPageLis")
	private WebElement RetailDrugCost_Table;


	@FindBy(id = "waystosave")
	private WebElement waysToSave;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section[2]/div/div[2]/div/form/span[1]")
	private WebElement view_label;

	@FindBy(className = "atdd-document-text")
	private WebElement documents_label;

	@FindBy(className = "atdd-benefitsoverview-plantitle")
	private WebElement planName;

	@FindBy(className = "atdd-benefitsoverview-membernamelabel")
	private WebElement nameLabel;

	@FindBy(className = "atdd-benefitsoverview-memberidlabel")
	private WebElement memberID;

	@FindBy(className = "atdd-benefitsoverview-effectivedatelabel")
	private WebElement effective_Date;

	@FindBy(className = "atdd-benefitsoverview-monthlypremium-label")
	private WebElement Monthly_Premium;
	
	@FindBy(className = "atdd-benefitsoverview-groupidlabel")
	private WebElement GroupId;
	
	@FindBy(className = "atdd-benefitsoverview-extrahelplevel-ma-label")
	private WebElement ExtraHelp;

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

	
	@FindBy(id = "pcpCard")
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
	
	@FindBy(className = "atdd-bncsummary-primarycareprvdrheader")
	private WebElement PrimaryCareProviderHeader;
	
	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[6]/div/div[1]/div/h2")
	private WebElement PrimaryCareProviderHeaderInd;

   @FindBy(className= "atdd-bncsummary-primarycareprvdrheader")
   private WebElement PrimaryCareProviderHeaderHMO;
   
   @FindBy(xpath= ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/p")
   private WebElement PCPtext;
   
   @FindBy(xpath= ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[5]/div/div[1]/div/div/div/div/h3/span")
   private WebElement OutofPocketMaximum;
   
   @FindBy(xpath= ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[5]/div/div[1]/div/div/div/div/p")
   private WebElement OutofPocketMaximumText;
   
   @FindBy(id = "oopInNetowrk")
   private WebElement INNETWORK;
   
   @FindBy(id= "oopOutNetowrk")
   private WebElement OUTOFNETWORK;

  @FindBy(xpath = "//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
  private WebElement accountToggleDropdown;

  @FindBy(xpath = "//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
  private WebElement accountSettingOption;
  
  @FindBy(className = "atdd-gopaperless")
  private WebElement gopaperlessbutton;
  
	@FindBy(className = "atdd-bnc-anclry-disclaimer")
	private WebElement Exclusivedisclaimer;
	
	@FindBy(className = "atdd-exclsvehearing-arrowdwn")
	private WebElement Disclaimertext;
	
	@FindBy(className = "atdd-bnc-ancilry-learnmorbtn")
	private WebElement LearnmoreButton;

	@FindBy(className = "atdd-bnc-exclusivehrng-leavingpopuptxt")
	private WebElement popup;
	
	@FindBy(className = "atdd-anclrysection-leavingpopup-proceedbtn")
	private WebElement ProceedButton;
	
	@FindBy(className = "atdd-anclrysection-leavingpopup-cancelbtn")
	private WebElement cancelbutton;
	
	@FindBy(className = "atdd-exclusivehearing-levngpopup-topcancelbtn")
	private WebElement cancelbutton1;
	
	@FindBy(className = "atdd-bnc-handimg")
	private WebElement handimage;

	@FindBy(className = "atdd-bnc-discountsubtitle")
	private WebElement textdiscountservices;

	@FindBy(className = "atdd-bnc-specialdscnt-desc")
	private WebElement textdiscountservices1;

	@FindBy(className = "atdd-bnc-discounttitle")
	private WebElement headerdiscountservices;
	
	@FindBy(xpath = ".//*[@id='planBenefitsApp']/div/div/div/div/div/div[2]/a")
	private WebElement learnmorebutton;
	
	@FindBy(className = "atdd-need-help")
	private WebElement NeedhelpShip;

	@FindBy(className = "atdd-tech-header")
	private WebElement TechnicalSupportShip;

	@FindBy(className = "atdd-general-header")
	private WebElement GeneralQuestionShip;

	@FindBy(className = "atdd-claims-header")
	private WebElement ClaimsSupportShip;
   

	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		openAndValidate();
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
			validate(planName);

			validate(memberId);

			validate(memberName);

			validate(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsCoverage.getExpectedData().get(key));
			/*
			 * if (elements.size() == 1) { validate(elements.get(0)); try {
			 * jsonObject.put(key, elements.get(0).getText());
			 * //System.out.println("Text"+elements.get(0).getText()); } catch
			 * (JSONException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } else if (elements.size() > 1) {
			 */
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

		System.out.println("BenefitsCoverageJson----->" + benefitsandcoverageJson);

	}

	public void PlanDocumentssection() {

		try {
			validate(planBenefitsDocuments);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}
	
	public void validateNeedhelpheader() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
			validate(NeedHelpHeader);
			
			
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
	                if (Contactussection.getText().contains("See more ways to contact us")) {
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
		validate(contactUslink);
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
		validate(disclaimersLink);
		disclaimersLink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public boolean getview_label() {
		return validate(view_label);
	}

	public boolean getdocuments_label() {
		return validate(documents_label);
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
				System.out.println("Text"+langdropdwn.getFirstSelectedOption().getText());
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
			validate(Hearingsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void HearingAid() {

		try {
			validate(Hearingaid);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void Vision() {

		try {
			validate(Visionsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void Dental() {

		try {
			validate(Dentalsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void Header() {

		try {
			validate(Headersection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void chiropracticsection() {

		try {
			validate(chiropracticsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}
	
	public void ExclusiveDisclaimers() {

		try {
			validate(Exclusivedisclaimer);
			Exclusivedisclaimer.click();
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			validate(Disclaimertext);
			System.out.println("text" + Disclaimertext.getText());
			
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}
	public void Exclusivelearnmore() {
		try{
		validate(LearnmoreButton);
		LearnmoreButton.click();
	
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//validate(disclaimersLink);
		System.out.println("text" + LearnmoreButton.getText());
	} catch(Exception e) {
		System.out.println("Elements is not found ...");
	}
	}
		/*//LearnmoreButton.click();
		WebElement TxtBoxContent = driver.findElement(By.className(LearnmoreButton));
		TxtBoxContent.getText();
		LearnmoreButton.click();
		System.out.println("Printing "+TxtBoxContent);*/
		//LearnmoreButton.click();
		/*if (LearnmoreButton.isDisplayed()) {
			Assert.assertTrue(true);
			} else
			Assert.fail("Button not displayed");*/
		/*if (driver.getCurrentUrl().contains("www.hihealthinnovations.com/medicare")) {
			return;
			} else {
			Assert.fail("The element " + ProceedButton.getText() + "is not found");
			}*/
		//LearnmoreButton.click();
		
	public void Leavingpopup() {

		try {
			validate(popup);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}
	public boolean Proceedbutton() {
		//LearnmoreButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LearnmoreButton.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(ProceedButton);
		ProceedButton.click();
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("hihealthinnovations.com/medicare")) {
		Assert.assertTrue(true);
		} 
		else {
		Assert.fail("The element " + ProceedButton.getText() + "is not found");
		}
		return true;
		}
	public void Cancelbutton() {

		try {
			validate(cancelbutton );
			validate(cancelbutton1 );
			cancelbutton.click();
			
			System.out.println("text" + cancelbutton.getText());
			
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void validatedrugcoverageheaderandtext() {
		validate(DrugCoverageHeader);
		validate(DrugCoveragetext);
	}

	public void validatelookupdrugsbutton() {
		if (LookUpDrugsButton.isDisplayed()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Button not displayed");
	}

	public void validate_lookupdrugstext() {
		validate(LookupDrugstext);

	}

	public void validate_drugcopayheaderntext() {
		validate(DrugCopayHeader);
		validate(DrugCopayText);

	}

	public void validate_drugcostheaderntext() {
		validate(DrugCostheaderandtext);

	}

	public void validate_locateapharmacysection() {
		validate(locateapharmacysection);
		validate(locateapharmacybutton);

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
		

	}

	public void validate_drugcostdropdownoptions()

	{
	    validate(DrugCostDropdown);
	    validate(DrugCostHeader);
               
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
		validate(Learnmoretierslink);
		validate(Learnmorestagelink);

	}

	public void validate_learnmoreaboutstagelink() {

		validate(Learnmorestagelink);

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
		validate(lisDrugCopayHeader);
		validate(lisDrugCopayText);

	}


	public void validatedrugcopaytable() {
		// Select langdropdwn = new Select(langdropdown);

		validate(drugcopaytable);

	}

	public void validatedrugcosttable() {
		// TODO Auto-generated method stub
		validate(RetailDrugCost_Table);

	}

	public void validateWaystoSave() {
		validate(waysToSave);
		validate(TextWaystoSave);

		System.out.println(TextWaystoSave.getText());
		// Assert.assertEquals(, );

	}

	public void validatePlanOverview() {
		// TODO Auto-generated method stub

		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		validate(Monthly_Premium);
		validate(GroupId);

	}

	public void validatePlanOverviewLis() {
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		validate(Monthly_Premium);
		validate(ExtraHelp);

	}

	public void validateHeaders() {
		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);

	}

	public void validateHeadersGroup() {
		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(EmergencyHeader);
		validate(AmbulanceHeader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);

	}

	public void validatePrimaryCareProvider() {

		validate(PrimaryCareProviderHeaderInd);
		validate(YourPrimaryCareProvider);
		validate(ChangeYourPcpButton);
		//validateNew(SearchforaPhysician);
		validate(StartSearch);

	}

	public void validatePrimaryCareProviderForGroup() {
	
		validate(PrimaryCareProviderHeaderHMO);
		validate(PCPtext);
		
		
	}
	
	public void validateOutofPocketMax() {
		validate(OutofPocketMaximum);
		validate(INNETWORK);
		validate(OUTOFNETWORK);
		validate(OutofPocketMaximumText);
		
	}
	
	public void validateBnCPag()
	   {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(planName1);
	   }

     public pages.member.bluelayer.ProfilePreferencesPage navigateDirectToProfilePagee() {
        System.out.println(driver.getTitle());
        accountToggleDropdown.click();
        validate(accountSettingOption);
        accountSettingOption.click();
        try {
               Thread.sleep(30000);
        } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        System.out.println(driver.getTitle());

        if (driver.getTitle().equalsIgnoreCase("Profile")) {
               System.out.println("Pass!");
               return new ProfilePreferencesPage(driver);
        }
        gopaperlessbutton.click();
        return null;
        
	}
     
 	public void validateHeadersShip() {
		// TODO Auto-generated method stub

		validate(BenefitsSummaryHeader);
		validate(ParticipatingHospitalStays1);
		validate(ParticipatingHospitalStays2);
		validate(TravelBenefitHeader);
		validate(BloodPackedRedBloodCellsPartA);
		validate(SkilledNursingFacilityStays);
		validate(HospiceCare);
		validate(MedicalCare);
		validate(BloodPackedRedBloodCellsPartB);
		validate(EmergencyCare);

	}
 	
 	public void handimage() {

		validate(handimage);

	}
 	
	public void vasSection() {

		validate(textdiscountservices);
		validate(textdiscountservices1);
		validate(headerdiscountservices);
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
	
	public void validateneedhelpheaderShip() {
		validate(NeedhelpShip);
		validate(TechnicalSupportShip);
		validate(GeneralQuestionShip);
		validate(ClaimsSupportShip);
	}
	
	public void validateContactUsNeedHelp() {
        try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(Seemorewaystext);

	}
	
	public void contactUslinkShip() 
	{
        try 
        {
			Thread.sleep(30000);
		} 
        catch (InterruptedException e) 
        {
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

}
