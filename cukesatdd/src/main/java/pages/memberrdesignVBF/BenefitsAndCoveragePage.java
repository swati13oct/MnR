/**
 * 
 */
package pages.memberrdesignVBF;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author njain112
 *
 */
public class BenefitsAndCoveragePage extends UhcDriver {

	@FindBy(className = "atdd-need-help")
	private WebElement NeedHelpHeader;

	@FindBy(className = "atdd-needhelp-disclaimer-text")
	private WebElement disclaimersLink;

	@FindBy(className = "atdd-bnc-drgcvrgeinfo")
	private WebElement DrugCoveragetext;

	@FindBy(className = "atdd-bnc-drugcoverage-title")
	private WebElement DrugCoverageHeader;

	@FindBy(className = "atdd-bnc-lookupdrugbtn")
	private WebElement LookUpDrugsButton;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-title")
	private WebElement DrugCopayHeader;

	@FindBy(className = "atdd-bnc-drgcopaysdiscounts-info")
	private WebElement DrugCopayText;

	@FindBy(id = "drug-costs")
	private WebElement DrugCostDropdown;

	@FindBy(className = "atdd-bnc-drgpricingtiers")
	private WebElement Learnmoretierslink;

	@FindBy(className = "atdd-bnc-drgstgtiers")
	private WebElement Learnmorestagelink;

	@FindBy(className = "atdd-bnc-locatephrmcy-info")
	private WebElement locateapharmacysection;

	@FindBy(className = "atdd-bnc-locatepharmacybtn")
	private WebElement locateapharmacybutton;

	@FindBy(id = "viewTextAtdd")
	private WebElement view_label;

	@FindBy(xpath = "(//div[@id='plan_benefit_documents']/section[2]//ul/li[not (contains(@class,'ng-hide'))])[1]")
	private WebElement documents_label;

	@FindBy(xpath = "//div[@id='planBenefitsAppSum']/section//div/span[contains(@class,'atdd-benefitsoverview-plantitle')]")
	private WebElement planName;

	@FindBy(className = "atdd-benefitsoverview-membernamelabel")
	private WebElement nameLabel;

	@FindBy(className = "atdd-benefitsoverview-memberidlabel")
	private WebElement memberID;

	@FindBy(className = "atdd-benefitsoverview-effectivedatelabel")
	private WebElement effective_Date;

	@FindBy(xpath = "//div[@class='page-header--left']/h1[contains(.,'Benefits Summary')]")
	private WebElement BenefitsSummaryHeader;

	@FindBy(xpath = "//span[contains(text(),'Medical Copays or Coinsurance')]")
	private WebElement Copayscoinsuranceheader;

	@FindBy(className = "atdd-hospitalvisits-title")
	private WebElement HospitalVisits;
	@FindBy(className = "atdd-officevisits-title")
	private WebElement OfficeVisits;

	@FindBy(className = "atdd-outpatientsurgery-title")
	private WebElement OutpatientSurgeryCenter;

	@FindBy(xpath = "//div[@id='pcpCard']/header/span[contains(text(),'PRIMARY CARE PROVIDER')]")
	private WebElement YourPrimaryCareProvider;

	@FindBy(className = "changepcp-atdd")
	private WebElement ChangeYourPcpButton;

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

	@FindBy(xpath = "//div[@class='tabs-desktop']/ul[@class='nav nav-tabs']/li")
	private List<WebElement> tabsForComboMember;

	@FindBy(xpath = "//*[@class='table-body']/div[2]/div[2]")
	private WebElement memberId;

	@FindBy(className = "atdd-claims-header")
	private WebElement shipClaimsSupportHeader;

	@FindBy(className = "drugCopaysAndDiscounts")
	private WebElement drugCopaysAndDiscount;

	@FindBy(xpath = "//span[contains(@class,'atdd-benefitsoverview-membernamelabel')]/parent::div/following-sibling::div")
	private WebElement memberNameValue;

	@FindBy(xpath = "//span[contains(@class,'atdd-benefitsoverview-memberidlabel')]/parent::div/following-sibling::div")
	private WebElement memberIDValue;

	@FindBy(xpath = "//span[contains(@class,'atdd-benefitsoverview-effectivedatelabel')]/parent::div/following-sibling::div")
	private WebElement effectiveDateValue;

	@FindBy(xpath = "//div[@id='oopInNetowrk']/section//h1")
	private WebElement INNETWORKValue;

	@FindBy(xpath = "//div[@id='oopOutNetowrk']/section//h1")
	private WebElement OUTOFNETWORKValue;

	@FindBy(xpath = ".//*[@id='officeVisitTileAtdd']/div/section/div[1]")
	private WebElement pcpValue;

	@FindBy(xpath = "//*[@id='officeVisitTileAtdd']/div/section/span")
	private WebElement specialistValue;

	@FindBy(className = "atdd-bnc-standrdretailpharmcytable")
	private WebElement drugTableNonLisMember;

	@FindBy(id = "standard_ads-header")
	private List<WebElement> annualDeductibleColumnFederal;

	@FindBy(id = "standard_ics-header")
	private List<WebElement> initialCoverageColumnFederal;

	@FindBy(id = "standard_cgp-header")
	private List<WebElement> coverageGaStageColumnFederal;

	@FindBy(id = "standard_ccs-header")
	private List<WebElement> catastrophicCoverageStageColumnFederal;

	@FindBy(xpath = "//table[@class='table-white atdd-bnc-standrdretailpharmcytable']/tbody/tr[2]/td[3]")
	private WebElement federalValueIC;

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	public void validateFieldsOnBenefitsAndCoveragePage() {
		if (!tabsForComboMember.isEmpty()) {
			ValidatesBenefitsForCombo();
		} else {
			validatePlanOverview();
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
		// CT team created an empty method. Need to follow up on this with them
	}

	/***
	 * 
	 */
	public void validatePlanOverview() {
		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);

		//validateTextUsingRegex(memberNameValue, "\\w+");
		//validateTextUsingRegex(memberIDValue, "\\d{9,10}.+");
		//validateTextUsingRegex(effectiveDateValue, "\\d{2}\\/\\d{2}\\/\\d{4}");
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
	//	validateTextUsingRegex(INNETWORKValue, "([NA]{1})|(\\$\\d{1,3}\\,\\d+\\.\\d{2})");
		//validateTextUsingRegex(OUTOFNETWORKValue, "([NA]{1})|(\\$\\d{1,3}\\,\\d+\\.\\d{2})");
	}

	public void ValidatesBenefitsForCombo() {
		int numberOfTabsForCombo;
		numberOfTabsForCombo = tabsForComboMember.size();
		if (2 == numberOfTabsForCombo) {
			String memberid1 = null;
			for (int currentTab = 0; currentTab < numberOfTabsForCombo; currentTab++) {
				tabsForComboMember.get(currentTab).click();
				validateNew(memberId);
				memberid1 = memberId.getText();
				if (memberid1.contains("-11")) {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,900)", "");
					System.out.println("User is on ship page");
					validateNew(shipClaimsSupportHeader);
				} else {
					validateNew(drugCopaysAndDiscount);
				}
			}

		} else {
			Assert.fail("!!! Please check test data as number of plans are not 2 !!!");
		}
	}

	public void validateOfficeVisitssection() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");

		validateNew(OfficeVisits);
		validateNew(pcpValue);
		validateNew(specialistValue);
		//validateTextUsingRegex(pcpValue, "\\$\\d{1,4}\\.\\d{2}");
		//validateTextUsingRegex(specialistValue, "\\$\\d{1,4}\\.\\d{2}");

	}

	public void validateCopayCoinsuranceInDrugTable() {
		validateNew(drugTableNonLisMember);

		if (annualDeductibleColumnFederal.size() > 0 && initialCoverageColumnFederal.size() > 0
				&& coverageGaStageColumnFederal.size() > 0 && catastrophicCoverageStageColumnFederal.size() > 0) {
			Assert.assertTrue("The columns are correct in Drug Costs table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in drug Costs table", true);
		}

		validateNew(federalValueIC);
		//validateTextUsingRegex(federalValueIC, "\\$\\d{1,4}\\.\\d{2}");
	}
}
