/**
 * 
 */
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
public class BenefitsAndCoveragePage extends UhcDriver {

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

	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	private WebElement DrugCoveragetext;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div[2]/div/div/h2")
	private WebElement lisDrugCopayHeader;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[1]/div/div/div/div[2]/div/div/p")
	private WebElement lisDrugCopayText;

	@FindBy(xpath = ".//*[@id='drug-benefits']/div/section/div[7]/div[1]/div/div/div/div/p")
	private WebElement LookupDrugstext;

	@FindBy(className = "atdd-bnc-lookupdrugbtn")
	private WebElement LookUpDrugsButton;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement DrugCopayHeader;

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

	@FindBy(className = "atdd-bnc-drgpricingtiers")
	private WebElement Learnmoretierslink;

	@FindBy(className = "atdd-bnc-drgstgtiers")
	private WebElement Learnmorestagelink;

	@FindBy(className = "atdd-bnc-locatephrmcy-info")
	private WebElement locateapharmacysection;

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

	@FindBy(xpath = "//div[@class='page-header--left']/h1[contains(.,'Benefits Summary')]")
	private WebElement BenefitsSummaryHeader;

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

	@FindBy(className = "atdd-bncsummary-primarycareprvdrheader")
	private WebElement PrimaryCareProviderHeaderHMO;

	@FindBy(xpath = "//div[@id='benefitsMain']//span[contains(text(),'Out-of-Pocket Maximum')]")
	private WebElement OutofPocketMaximum;

	@FindBy(className = "atdd-innetwrk-title")
	private WebElement INNETWORK;

	@FindBy(className = "atdd-outnetwrktitle")
	private WebElement OUTOFNETWORK;

	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
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
	}

/***
 * 
 */
	public void validateNeedhelpheader() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateNew(NeedHelpHeader);
	}

/***
 * 
 */
	public void clickOnDisclaimers() {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateNew(disclaimersLink);
		disclaimersLink.click();
	}
/***
 * 
 * @return
 */
	public boolean getview_label() {
		return validateNew(view_label);
	}
/***
 * 
 * @return
 */
	public boolean getdocuments_label() {
		CommonUtility.waitForPageLoadNew(driver, documents_label, 15);
		return validateNew(documents_label);
	}

/***
 * 
 */
	public void validatedrugcoverageheaderandtext() {
		validateNew(DrugCoverageHeader);
		validateNew(DrugCoveragetext);
	}
/***
 * 
 */
	public void validatelookupdrugsbutton() {
		if (LookUpDrugsButton.isDisplayed()) {
			Assert.assertTrue(true);
		} else
			Assert.fail("Button not displayed");
	}

/***
 * 
 */
	public void validate_drugcopayheaderntext() {
		validateNew(DrugCopayHeader);
		validateNew(DrugCopayText);

	}

/***
 * 
 */
	public void validate_locateapharmacysection() {
		validateNew(locateapharmacysection);
		validateNew(locateapharmacybutton);

	}

/***
 * 
 */
	public void validate_drugcostdropdownoptions()

	{
		validateNew(DrugCostDropdown);
	}
/***
 * 
 */
	public void validate_learnmoreaboutlink() {
		validateNew(Learnmoretierslink);
		validateNew(Learnmorestagelink);

	}

/***
 * 
 */
	public void validatedrugcopaytable() {
	}

/***
 * 
 */
	public void validatePlanOverview() {
		// TODO Auto-generated method stub

		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);

	}

/***
 * 
 */
	public void validateHeaders() {
		validateNew(BenefitsSummaryHeader);
		validateNew(Copayscoinsuranceheader);
		validateNew(HospitalVisits);
		validateNew(OfficeVisits);
		validateNew(OutpatientSurgeryCenter);

	}

/***
 * 
 */
	public void validatePrimaryCareProvider() {

		validateNew(PrimaryCareProviderHeader);
		validateNew(YourPrimaryCareProvider);
		validateNew(ChangeYourPcpButton);

	}
/***
 * 
 */
	public void validatePrimaryCareProviderForGroup() {

		validateNew(PrimaryCareProviderHeaderHMO);

	}
/***
 * 
 */
	public void validateOutofPocketMax() {
		validateNew(OutofPocketMaximum);
		validateNew(INNETWORK);
		validateNew(OUTOFNETWORK);

	}

}
