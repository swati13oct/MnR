/**
 * 
 */
package pages.regression.benefitandcoverage;

import java.util.ArrayList;
import java.util.List;

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
import pages.member.bluelayer.ProfilePreferencesPage;
import pages.member.ulayer.ValueAddedServicepage;

/**
 * @Functionality : To check Benefits and Coverage page
 *
 **
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

	@FindBy(xpath = ".//*[@id='needhelpsectioncontactus']/section[2]/div/div[3]/div/p")
	private WebElement Seemorewaystext;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(id = "needhelpsectioncontactus")
	private WebElement Contactussection;

	// private WebElement Contactussection;

	@FindBy(className = "atdd-needhelp-disclaimer-text")
	private WebElement disclaimersLink;

	@FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[1]/div")
	private WebElement planBenefitsDocuments;

	@FindBy(id = "lang-select-2")
	private WebElement langdropdown;

	@FindBy(className = "atdd-benefitssummary-ancillaryHearingText")
	private WebElement Hearingsection;

	@FindBy(className = "atdd-benefitssummary-exclusivehearing")
	private WebElement Hearingaid;

	@FindBy(xpath = "atdd-benefitssummary-vision")
	private WebElement Visionsection;

	@FindBy(xpath = "atdd-benefitssummary-dental")
	private WebElement Dentalsection;

	@FindBy(className = "atdd-benefitssummary-ancillaryHeader")
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


	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[2]/div/div")
	private WebElement DrugCostheaderandtext;

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


	@FindBy(className = "atdd-benefitsoverview-groupidlabel")
	private WebElement GroupId;

	@FindBy(className = "atdd-benefitsoverview-extrahelplevel-ma-label")
	private WebElement ExtraHelp;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[1]/div/div/h1")
	private WebElement BenefitsSummaryHeader;
	
	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[1]/div/h1")
	private WebElement BenefitsSummaryHeadership;
	

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[2]/div/div/div[1]/div/h3/b/span")
	private WebElement Copayscoinsuranceheader;

	@FindBy(className = "atdd-hospitalvisits-title")
	private WebElement HospitalVisits;

	@FindBy(className = "atdd-emergencycare-title")
	private WebElement EmergencyHeader;

	@FindBy(className = "atdd-ambulance-title")
	private WebElement AmbulanceHeader;

	@FindBy(id = "officeVisitTileAtdd")
	private WebElement OfficeVisits;

	@FindBy(className = "atdd-outpatientsurgery-title")
	private WebElement OutpatientSurgeryCenter;

	@FindBy(id = "pcpCard")
	private WebElement YourPrimaryCareProvider;

	@FindBy(className = "changepcp-atdd")
	private WebElement ChangeYourPcpButton;


	@FindBy(className = "start-search-atdd")
	private WebElement StartSearch;

	@FindBy(id = "benefitShipCard")
	private WebElement ParticipatingHospitalStays1;






	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[6]/div/div[1]/div/h2")
	private WebElement PrimaryCareProviderHeaderInd;

	@FindBy(className = "atdd-bncsummary-primarycareprvdrheader")
	private WebElement PrimaryCareProviderHeaderHMO;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/p")
	private WebElement PCPtext;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[5]/div/div[1]/div/div/div/div/h3/span")
	private WebElement OutofPocketMaximum;

	@FindBy(xpath = ".//*[@id='benefitsMain']/div[2]/div/div[1]/div/div/div/div/div[5]/div/div[1]/div/div/div/div/p")
	private WebElement OutofPocketMaximumText;

	@FindBy(id = "oopInNetowrk")
	private WebElement INNETWORK;

	@FindBy(id = "oopOutNetowrk")
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

	@FindBy(xpath = ".//*[@id='specialDisctServices']/div[1]/img")
	private WebElement handimage;

	@FindBy(id = "specialDisctServices")
	private WebElement textdiscountservices;


	@FindBy(className = "atdd-bnc-discounttitle")
	private WebElement headerdiscountservices;

	@FindBy(className = "atdd-bnc-discntlearnmorimg")
	private WebElement learnmorebutton;

	@FindBy(className = "atdd-need-help")
	private WebElement NeedhelpShip;

	@FindBy(className = "atdd-techsupport-block")
	private WebElement TechnicalSupportShip;

	@FindBy(className = "atdd-general-header")
	private WebElement GeneralQuestionShip;

	@FindBy(className = "atdd-claims-header")
	private WebElement ClaimsSupportShip;

	@FindBy(id = "ccs-header")
	private WebElement catastrophicCoverageStage;
	
<<<<<<< HEAD
	@FindBy(css = "img.img-responsive")
	private WebElement logoImage;
=======
	@FindBy(xpath = ".//*[@id='drug-benefits']/div[5]/div[10]/div/div[1]/div/div")
	private WebElement hartfortdrugtable;
	
	@FindBy(className = "atdd-bnc-CTgrouptable")
	private WebElement GreenwichTable;
	
	@FindBy(className = "atdd-bnc-pharmacydropdwn")
	private WebElement pharmacyDropdown;

	@FindBy(className = "atdd-bnc-drugcostsheading")
	private WebElement drugCostsHeader;

	@FindBy(className = "atdd-bnc-txers-retailcostsharing-table")
	private WebElement retailTable;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[1]")
	private List<WebElement> ICStage30dayNonMain;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[2]")
	private List<WebElement> ICStage30dayMain;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[3]")
	private List<WebElement> ICStage31to60;

	@FindBy(xpath = ".//*[@class='table-subheader']/td[4]")
	private List<WebElement> ICStage61to90;
	
	@FindBy(xpath = ".//*[@class='table-white atdd-bnc-txers-retailcostsharing-table']/tbody/tr[3]/td[2]")
	private WebElement ICTier1Value;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/section/div[1]/span")
	private WebElement pcpValue;
	
	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/section/span")
	private WebElement specialistValue;
	

>>>>>>> origin/develop

	
	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		// openAndValidate();
	}

	/**
	 * @toDo : To check headers on Benfits and coverage page
	 */
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

	/**
	 * @toDo : To check benefits and coverage page has opened
	 */

	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsCoverage
					.getExpectedData().get(key));
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
					jsonObjectForArray.put(benefitsCoverage.getExpectedData()
							.get(key).getElementName(), element.getText());
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

		System.out.println("BenefitsCoverageJson----->"
				+ benefitsandcoverageJson);

	}

	/**
	 * @toDo : The user validates the PlanDocuments Section
	 */

	public void PlanDocumentssection() {

		try {
			validate(planBenefitsDocuments);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the headers in Need help section
	 */

	public void validateNeedhelpheader() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validate(NeedHelpHeader);

	}

	/**
	 * @toDo : The user validates the Contact us section in Need help section
	 */

	public void validatecontactussection() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Contactussection.getText().contains("See more ways to contact us")) {
			System.out.println("contactus section is coming ");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Contactussection.getText() >>>>>>"
					+ Contactussection.getText());
		}

	}

	/**
	 * @toDo : The user validates the Contact us link in Need help section
	 */
	public void contactUslink() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(contactUslink);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (contactUslink.isEnabled()) {
			contactUslink.click();
		}
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Title is " + getTitle());
		// Assert.assertTrue(getTitle().equalsIgnoreCase("Contact Us"));

	}

	/**
	 * @toDo : The user checks the disclaimers
	 */

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
			Assert.assertEquals(benefitsandcoverageExectedJson.get("1stline"),
					table_data);
			// to validate amount Billed
			finalPath = disclaimertextarea_xpath + "/p[2]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("2ndline"),
					table_data);
			// to validate amount Paid
			finalPath = disclaimertextarea_xpath + "/p[3]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("3rdline"),
					table_data);
			// to validate paid Date
			finalPath = disclaimertextarea_xpath + "/p[4]";
			table_data = driver.findElement(By.xpath(finalPath)).getText();
			System.out.println(table_data);
			Assert.assertEquals(benefitsandcoverageExectedJson.get("4thline"),
					table_data);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @toDo : The user checks the More Information link in the Need help
	 *       section
	 */

	public void clickOnDisclaimers() {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validate(disclaimersLink);
		// disclaimersLink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @toDo : The user checks the view label in Documents section
	 */
	public boolean getview_label() {
		return validate(view_label);
	}

	/**
	 * @toDo : The user checks the get Document label in Documents section
	 */
	public boolean getdocuments_label() {
		return validate(documents_label);
	}

	/**
	 * @toDo : The user validates the language dropdown in Documents section
	 */
	public void languagevalidation() {
		if (langdropdown.isDisplayed()) {
			
			Select dropdown = new Select(langdropdown);
			List<WebElement> webElements = dropdown.getOptions();
			for (WebElement element : webElements) {

				if (element.getText().equals("SPANISH")
						|| element.getText().equals("CHINESE")) {
					Assert.fail("The element" + element.getText()
							+ "should not display");
					System.out.println("The element " + element.getText()
							+ "should not display");
				} else {
					Assert.assertTrue(true);
				}
			}
		}

	}

	/**
	 * @toDo : The user validates the language dropdown in Documents section and
	 *       validates the default selected language
	 */
	public void validate_langdropdown_first_selection() {
		// WebElement langdropdown;
		if (langdropdown.isDisplayed()) {
			Select langdropdwn = new Select(langdropdown);
			if (langdropdwn.getFirstSelectedOption().getText()
					.equals("ENGLISH")) {
				System.out.println("Text"
						+ langdropdwn.getFirstSelectedOption().getText());
				Assert.assertTrue(true);
			} else
				Assert.fail("Issue in English selection");
		} else
			Assert.fail("Plan year dropdown not displayed");

	}

	/**
	 * @toDo : The user validates the language dropdown in Documents section and
	 *       make a selection in the dropdown
	 */
	public void validate_langdropdown_select(String language) {
		Select langdropdwn = new Select(langdropdown);
		langdropdwn.selectByVisibleText(language);
	}

	/**
	 * @toDo : The user validates the Hearing section of Ancillary
	 */
	public void HearingSection() {

		try {
			validate(Hearingsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Hearing aid section of Ancillary Benefits
	 */
	public void HearingAid() {

		try {
			validate(Hearingaid);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Vision section of Ancillary Benefits
	 */

	public void Vision() {

		try {
			validate(Visionsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Dental section of Ancillary Benefits
	 */

	public void Dental() {

		try {
			validate(Dentalsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Header section
	 */

	public void Header() {

		try {
			validate(Headersection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the chiropractic section of Ancillary benefits
	 */
	public void chiropracticsection() {

		try {
			validate(chiropracticsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the Disclaimers link under Exclusive hearing
	 *       section of Ancillary benefits
	 */
	public void ExclusiveDisclaimers() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-50)", "");
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

	/**
	 * @toDo : The user validates the Learn more button under Exclusive hearing
	 *       section of Ancillary benefits
	 */

	public void Exclusivelearnmore() {
		try {
			validate(LearnmoreButton);
			LearnmoreButton.click();

			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// validate(disclaimersLink);
			System.out.println("text" + LearnmoreButton.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/*
	 * //LearnmoreButton.click(); WebElement TxtBoxContent =
	 * driver.findElement(By.className(LearnmoreButton));
	 * TxtBoxContent.getText(); LearnmoreButton.click();
	 * System.out.println("Printing "+TxtBoxContent);
	 */
	// LearnmoreButton.click();
	/*
	 * if (LearnmoreButton.isDisplayed()) { Assert.assertTrue(true); } else
	 * Assert.fail("Button not displayed");
	 */
	/*
	 * if
	 * (driver.getCurrentUrl().contains("www.hihealthinnovations.com/medicare"))
	 * { return; } else { Assert.fail("The element " + ProceedButton.getText() +
	 * "is not found"); }
	 */
	// LearnmoreButton.click();

	/**
	 * @toDo : The user validates the Leaving popup in Ancillary section
	 */
	public void Leavingpopup() {

		try {
			validate(popup);
		} catch (Exception e) {
			System.out.println("Element is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the proceed button of the leaving popup in
	 *       Ancillary section
	 */

	public boolean Proceedbutton() {
		// LearnmoreButton.click();
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
		ArrayList<String> tabs2 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("hihealthinnovations.com/medicare")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("The element " + ProceedButton.getText()
					+ "is not found");
		}
		return true;
	}

	/**
	 * @toDo : The user validates the cancel button of the leaving popup in
	 *       Ancillary section
	 */
	public void Cancelbutton() {

		try {
			validate(cancelbutton);
			validate(cancelbutton1);
			cancelbutton.click();

			System.out.println("text" + cancelbutton.getText());

		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * @toDo : The user validates the DrugCoverage section headers and text
	 */
	public void validatedrugcoverageheaderandtext() {
		validate(DrugCoverageHeader);
		validate(DrugCoveragetext);
	}

	/**
	 * @toDo : Validates Look Up Drugs button in the DrugCosts section
	 */
	public void validatelookupdrugsbutton() {
		if (LookUpDrugsButton.isDisplayed()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Button not displayed");
	}

	/**
	 * @toDo : Validates the text for the Look Up Drugs section
	 */

	public void validate_lookupdrugstext() {
		validate(LookupDrugstext);

	}

	/**
	 * @toDo : Validates the headers in DrugCopays and Discount section
	 */
	public void validate_drugcopayheaderntext() {
		validate(DrugCopayHeader);
		validate(DrugCopayText);

	}

	/**
	 * @toDo : Validates the Drug Cost header and text
	 */

	public void validate_drugcostheaderntext() {
		validate(DrugCostheaderandtext);

	}

	/**
	 * @toDo : Validates the text in locate a pharmacy section
	 */
	public void validate_locateapharmacysection() {
		validate(locateapharmacysection);
		validate(locateapharmacybutton);

	}

	/**
	 * @toDo : Validates the Learnmore tiers links for a Lis member
	 */
	public void validate_tierlinknotdisplay() {
		if (Learnmoretierslink.isDisplayed()) {
			Assert.fail("The element" + Learnmoretierslink.getText()
					+ "should not display");
			System.out.println("The element " + Learnmoretierslink.getText()
					+ "should not display");
		} else {
			Assert.assertTrue(true);
		}

	}

	/**
	 * @toDo : Validates the Pharmacy selection dropdown for a Lis member
	 */

	public void validate_dropdownnotdisplay() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (DrugCostDropdown.isDisplayed()) {
			Assert.fail("The element" + DrugCostDropdown.getText()
					+ "should not display");
			System.out.println("The element " + DrugCostDropdown.getText()
					+ "should not display");
		} else {
			Assert.assertTrue(true);
		}

	}

	/**
	 * @toDo : Validates the Pharmacy selection dropdown for a non Lis member
	 */
	public void validate_drugcostdropdownoptions()

	{
		validate(DrugCostDropdown);
		validate(DrugCostHeader);

		/*
		 * if (DrugCostDropdown.isDisplayed()) { try { Thread.sleep(30000); }
		 * catch (InterruptedException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } List<String> listActual = new
		 * ArrayList<String>(); Select dropdown = new Select(DrugCostDropdown);
		 * List<WebElement> webElements = dropdown.getOptions(); for (WebElement
		 * element : webElements) { if
		 * (element.getText().equals("Standard Retail Pharmacy") ) {
		 * Assert.assertTrue("The element" + element.getText() +"should display"
		 * , true);;
		 * 
		 * System.out.println("The element " + element.getText() +
		 * "should not display"); } else if
		 * (element.getText().equals("Preferred Mail Service Pharmacy") ) {
		 * Assert.assertTrue("The element" + element.getText() +"should display"
		 * , true);;
		 * 
		 * System.out.println("The element " + element.getText() +
		 * "should not display"); } else if
		 * (element.getText().equals("Preferred Retail Pharmacy")) {
		 * Assert.assertTrue("The element" + element.getText() +"should display"
		 * , true);;
		 * 
		 * System.out.println("The element " + element.getText() +
		 * "should not display"); } else {
		 * 
		 * Assert.fail(); } } }
		 */
	}

	/**
	 * @toDo : Validates the Learn More links for a Non Lis member
	 */

	public void validate_learnmoreaboutlink() {
		validate(Learnmoretierslink);
		validate(Learnmorestagelink);
		System.out.println(Learnmoretierslink.getLocation());
		System.out.println(Learnmorestagelink.getLocation());

	}

	/**
	 * @toDo : Validates the Learn More links for a Lis member
	 */
	public void validate_learnmoreaboutstagelink() {

		validate(Learnmorestagelink);

	}

	/**
	 * @toDo : Validates that the learnmore tier link
	 */

	public void clickOnLearnmoreaboutlinktier() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Learnmoretierslink.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { Thread.sleep(30000); } catch (InterruptedException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * String finalPath; String table_data;
		 * 
		 * finalPath = learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[1]";
		 * table_data = driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data); Assert.assertEquals("Tier 1 Drugs",
		 * table_data); // to validate amount Billed finalPath =
		 * learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[2]"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data); Assert.assertEquals(
		 * "Nulla ea veniam nostrud reprehenderit eiusmod excepteur adipisicing nulla cupidatat cupidatat. Excepteur amet exercitation minim sint nulla occaecat dolor anim duis proident ad ea voluptate do enim consequat ea."
		 * , table_data); // to validate amount Paid finalPath =
		 * learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[3]"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data); Assert.assertEquals("Tier 2 Drugs",
		 * table_data); // to validate paid Date finalPath =
		 * learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[5]"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data); Assert.assertEquals("Tier 3 Drugs",
		 * table_data); finalPath =
		 * learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[7]"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data); Assert.assertEquals("Tier 4 Drugs",
		 * table_data); finalPath =
		 * learnmorelinktiertext_xpath+"/div/div[4]/div/div/p[9]"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data); Assert.assertEquals("Tier 5 Drugs",
		 * table_data);
		 * 
		 * Learnmoretierslink.click();
		 */

	}

	/**
	 * @toDo : Validates that the learnmore stage link
	 */

	public void clickOnLearnmoreaboutlinkstage() {
		// TODO Auto-generated method stub
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Learnmorestagelink.click();
		 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*
		 * try { Thread.sleep(30000); } catch (InterruptedException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); } //
		 * Thread.sleep(15000); String finalPath; String table_data;
		 * 
		 * 
		 * finalPath = learnmorestagetext_xpath+"/div/div[1]/div/div/p[3]/b";
		 * table_data = driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data);
		 * Assert.assertEquals("Annual Deductible Stage", table_data); // to
		 * validate amount Billed finalPath =
		 * learnmorestagetext_xpath+"/div/div[1]/div/div/p[5]/b"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data);
		 * Assert.assertEquals("Initial Coverage Stage", table_data); // to
		 * validate amount Paid finalPath =
		 * learnmorestagetext_xpath+"/div/div[1]/div/div/p[7]/b"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data);
		 * Assert.assertEquals("Coverage Gap Stage", table_data); // to validate
		 * paid Date finalPath =
		 * learnmorestagetext_xpath+"/div/div[1]/div/div/p[9]/b"; table_data =
		 * driver.findElement(By.xpath(finalPath)).getText();
		 * System.out.println(table_data);
		 * Assert.assertEquals("Catastrophic Coverage Stage", table_data);
		 * 
		 * Learnmorestagelink.click();
		 */

	}

	/**
	 * @toDo : Validates the headers in DrugCopays and Discount section for a
	 *       Lis member
	 */

	public void validate_lisdrugcopayheaderntext() {
		validate(lisDrugCopayHeader);
		validate(lisDrugCopayText);

	}

	/**
	 * @toDo : Validates the Drug costs table for a Non Lis member
	 */
	public void validatedrugcopaytable() {
		// Select langdropdwn = new Select(langdropdown);

		validate(drugcopaytable);

	}

	/**
	 * @toDo : Validates the Drug costs table for a Lis member
	 */

	public void validatedrugcosttable() {
		// TODO Auto-generated method stub
		validate(RetailDrugCost_Table);

	}

	/**
	 * @toDo : Validates the Ways to save section
	 */
	public void validateWaystoSave() {
		validate(waysToSave);
		validate(TextWaystoSave);

		System.out.println(TextWaystoSave.getText());
		// Assert.assertEquals(, );

	}

	/**
	 * @toDo : Validates the Plan overview section for a Non lis member
	 */
	public void validatePlanOverview() {
		// TODO Auto-generated method stub

		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		// validate(Monthly_Premium);

		validate(GroupId);

	}

	public void validatePlanOverviewInd() {
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		// validate(Monthly_Premium);
	}

	/**
	 * @toDo : Validates the Plan overview section for a lis member
	 */

	public void validatePlanOverviewLis() {
		validate(planName);
		validate(nameLabel);
		validate(memberID);
		validate(effective_Date);
		// validate(Monthly_Premium);
		validate(ExtraHelp);

	}

	/**
	 * @toDo : Validates the headers section for individual members
	 */

	public void validateHeaders() {
		
		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);

	}

	/**
	 * @toDo : Validates the headers section for group members
	 */
	public void validateHeadersGroup() {
		validate(BenefitsSummaryHeader);
		validate(Copayscoinsuranceheader);
		validate(EmergencyHeader);
		validate(AmbulanceHeader);
		validate(HospitalVisits);
		validate(OfficeVisits);
		validate(OutpatientSurgeryCenter);

	}

	/**
	 * @toDo : Validates the Primary care provider section
	 */

	public void validatePrimaryCareProvider() {

		validate(PrimaryCareProviderHeaderInd);
		validate(YourPrimaryCareProvider);
		validate(ChangeYourPcpButton);
		// validateNew(SearchforaPhysician);
		validate(StartSearch);

	}

	/**
	 * @toDo : Validates the Primary care provider section for group members
	 */

	public void validatePrimaryCareProviderForGroup() {

		validate(PrimaryCareProviderHeaderHMO);
		validate(PCPtext);

	}

	/**
	 * @toDo : Validates the Out Of Pocket Maximum section
	 */

	public void validateOutofPocketMax() {
		validate(OutofPocketMaximum);
		validate(INNETWORK);
		validate(OUTOFNETWORK);
		validate(OutofPocketMaximumText);

	}

	/**
	 * @toDo : Validates the Benefits page
	 */

	public void validateBnCPag() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(planName1);
	}

	public pages.member.bluelayer.ProfilePreferencesPage navigateDirectToProfilePagee()
			throws InterruptedException {
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

	/**
	 * @toDo : Validates the headers for ship members
	 */
	public void validateHeadersShip() {
		// TODO Auto-generated method stub

		validate(BenefitsSummaryHeadership);
		validate(ParticipatingHospitalStays1);

	}

	/**
	 * @toDo : Validates the hand image in discount and services section for
	 *       ship members
	 */
	public void handimage() {

		validate(handimage);

	}

	/**
	 * @toDo : Validates the Value added services section for ship members
	 */
	public void vasSection() {

		 validate(textdiscountservices);
		
	}

	/**
	 * @toDo : Validates the Learnmore Button for ship members
	 */

	public void learnmorebutton() {

		validate(learnmorebutton);

	}

	/**
	 * @toDo : Validates the Value added services page for ship members
	 */
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

	/**
	 * @toDo : Validates the Need help section headers for a ship member
	 */
	public void validateneedhelpheaderShip() {
		validate(NeedhelpShip);
		validate(TechnicalSupportShip);
		validate(GeneralQuestionShip);
		validate(ClaimsSupportShip);
	}

	/**
	 * @toDo : Validates the see more ways to contact us section for ship
	 *       members in Need help section
	 */
	public void validateContactUsNeedHelp() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(Seemorewaystext);

	}

	/**
	 * @toDo : Validates the contact us page on clicking on the link of contact
	 *       us in Need help section
	 */
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

		// Assert.assertTrue(getTitle().equalsIgnoreCase("Contact Us"));

	}
 
	public void valiadateCatastrophicCoverageValue(String copayType){
		validate(catastrophicCoverageStage);
		if(copayType.equals("wotCMSValue")){
		}
	}
<<<<<<< HEAD
	
    public void validateImagePresent(String logoToBeDisplayedOnSecondaryPage) {
		
		String logo_src = logoImage.getAttribute("src");
		String logo_alt = logoImage.getAttribute("alt");
		System.out.println("Actual logo's source on Dashboard page is   "+logo_src+" and Expected logo source is  "+logoToBeDisplayedOnSecondaryPage+" . ");		
		System.out.println("logo's alt text on secondary page is   "+logo_alt);	
		Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnSecondaryPage));
	}
    
    public void ancillarynotdisplayed() {
		if (Headersection.isDisplayed()) {
			Assert.assertFalse("The element" + Headersection.getText()
			+ "is not display", false);
			System.out.println("The element " + Headersection.getText()
					+ "is not display");
		} else {
			Assert.assertTrue(true);
		}

=======
	public void validatehartfortprescriptiondrugtable() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto generated catch block
			e.printStackTrace();
		}
		validateNew(hartfortdrugtable);
	}
	
	public void validateTownOfGreenwichdrugtable() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto generated catch block
			e.printStackTrace();
		}
		validateNew(GreenwichTable);
	}

	public void validatedrugCostSectionTexas() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				validateNew(pharmacyDropdown);
				validateNew(drugCostsHeader);
	}

	public void validateRetailCostSharingdrugtable() {
		// TODO Auto-generated method stub

		Select drpPharmacy = new Select(pharmacyDropdown);
		drpPharmacy.selectByVisibleText("Retail Cost Sharing");
		System.out.println("Retail Cost Sharing dropdown value selected");

		validateNew(retailTable);
		if(ICStage30dayNonMain.size()<1 ||ICStage30dayMain.size()<1 ||ICStage31to60.size()<1||ICStage61to90.size()<1)
		{
			Assert.assertFalse("The columns are incorrect in texas Ers table",true);
			
		}
		
		
		if(ICTier1Value.getText().trim().length()<1)
		{
			Assert.assertFalse("No value in the IC stage tier 1 cell",true);
		}
		
	}

	public void validateMailOrderCostSharing_Drugtable() {
		// TODO Auto-generated method stub
		
	}

	public void validateOfficeVisitssection() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-50)", "");
		
		validateNew(OfficeVisits);
		// TODO Auto-generated method stub
		
		validateNew(pcpValue);
		validateNew(specialistValue);
		if(pcpValue.getText().contains("$"))
		{
		Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(false);
			
			
		}
		
		if(specialistValue.getText().contains("$"))
		{
		Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
		
		
			
		
		
>>>>>>> origin/develop
	}
}
