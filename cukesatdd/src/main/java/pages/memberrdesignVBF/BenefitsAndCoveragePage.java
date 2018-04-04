/**
 * 
 */
package pages.memberrdesignVBF;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.memberrdesignVBF.RallyDashboardPage;

/**
 * @author njain112
 *
 */
public class BenefitsAndCoveragePage extends UhcDriver {

	private PageData benefitsCoverage;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;

	@FindBy(xpath = "//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;

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
		//CT team created an empty method. Need to follow up on this with them 
	}

	/***
	 * 
	 */
	public void validatePlanOverview() {
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
