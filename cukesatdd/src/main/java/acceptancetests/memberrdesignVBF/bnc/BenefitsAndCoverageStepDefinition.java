package acceptancetests.memberrdesignVBF.bnc;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.BenefitsAndCoveragePage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoverageStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 */
	@Then("^the user validates Needhelp header and disclaimer link")
	public void validateneedhelpheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validateNeedhelpheader();
	}

	/***
	 * 
	 */
	@Then("^the user clicks on Disclaimers link$")
	public void the_user_clicks_on_Disclaimers_link() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.clickOnDisclaimers();
	}

	/***
	 * 
	 */
	@And("^the user validates view and document label$")
	public void user_validates_view_and_document_label() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);

		benefitsCoveragePage.getdocuments_label();
		benefitsCoveragePage.getview_label();

	}

	/***
	 * 
	 */
	@And("^the user validates Drug coverage header and text under the section")
	public void user_validates__drugcoverage_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validatedrugcoverageheaderandtext();
	}

	/***
	 * 
	 */
	@And("^the user validates Look Up Drugs button should be visible")
	public void user_validates_lookupdrugsbuuton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validatelookupdrugsbutton();
	}

	/***
	 * 
	 */
	@And("^the user view the Drug Copays & Discounts header")
	public void user_view_drugcopayanddiscountheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validate_drugcopayheaderntext();

	}

	/***
	 * 
	 */
	@And("^the user validates Locate a Pharmacy button should be visible")
	public void user_validate_locatepharmacybutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validate_locateapharmacysection();
	}

	/***
	 * 
	 */
	@And("^the user validates dropdown selection functionality")
	public void user_validate_dropdwonvalues() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validate_drugcostdropdownoptions();
	}

	/***
	 * 
	 */
	@And("^user validates the Learn More section link for stage and tier")
	public void user_validate_links() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validate_learnmoreaboutlink();
	}

	/***
	 * 
	 */
	@And("the user should see drug copay and discount table")
	public void user_validate_drugcopaydiscounttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validatedrugcopaytable();
	}

	/***
	 * 
	 */
	@And("the user validates plan overview section")
	public void user_validate_planOverview() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validatePlanOverview();
	}

	/***
	 * 
	 */
	@And("the user validates headers on Bnc page for indi members")
	public void user_validate_Headers() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validateHeaders();
	}

	/***
	 * 
	 */
	@And("the user validates the Primarycare Provider section")
	public void user_validate_PrimaryCareProv() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validatePrimaryCareProvider();
	}

	/***
	 * 
	 */
	@And("user validates the Primarycare Provider section for Group")
	public void user_validate_PrimaryCareProvForHmo() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validatePrimaryCareProviderForGroup();
	}

	/***
	 * 
	 */
	@And("the user validates the Out of Pocket Max section")
	public void user_validate_OutofPocket() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		benefitsCoveragePage.validateOutofPocketMax();
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user navigates to Rally Dashboard Page for bnc$")
	public void user_navigates_to_RallyDashboardPage_Page() throws InterruptedException {
		BenefitsAndCoveragePage benefitsCoveragePage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			benefitsCoveragePage = testHarness.navigateDirectToBnCPag();
		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			benefitsCoveragePage = rallyDashboardPage.navigateDirectToBnCPag();
		}

		if (null == benefitsCoveragePage) {
			System.out.println("Benefits and Coverage page is not loaded!!!");
			Assert.fail("Benefits and Coverage page is not loaded!!!");
		} else {
			getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF, benefitsCoveragePage);
		}

	}

	@And("the user validates the Office Visits section")
	public void user_validate_OfficeVisitssection() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		planBenefitsCoverage.validateOfficeVisitssection();
	}

	@And("the user validates the copay coinsurance in drug costs table")
	public void userValidatesCopayCoinsuranceindrugTable() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE_VBF);
		planBenefitsCoverage.validateCopayCoinsuranceInDrugTable();

	}
}
