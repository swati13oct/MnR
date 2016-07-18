/**
 * 
 */
package acceptancetests.Planpreview.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.HealthCentersPage;
import pages.acquisition.ulayer.HealthLivingPage;
import pages.acquisition.ulayer.HealthManagementProgramPage;
import pages.acquisition.ulayer.HealthToolsPage;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;
import pages.acquisition.ulayer.ExploreChangingPlansPage;
import pages.acquisition.ulayer.LearnAboutMedicarePage;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PlanPreviewPage;
import pages.acquisition.ulayer.PrepareforInitialEnrollmentPage;
import pages.acquisition.ulayer.PrescriptionDrugPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.RegistrationHomePage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pgrover1
 *
 */
public class PlanPreviewAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the Plan Preview Page of AARP medicare site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();
		System.out.println("reached");
		PlanPreviewPage planPreviewpage= new PlanPreviewPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE,planPreviewpage);
		
	}

	@When("^the user validates the multicounty popup on ulayer$")
	public void zipcode_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		PlanPreviewPage planpreviewPage= (PlanPreviewPage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		VPPPlanSummaryPage plansummaryPage = planpreviewPage.searchPlans(
				zipcode, county);

//		if (plansummaryPage != null) {
//			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
//					plansummaryPage);
//			/* Get expected data */
//			String fileName = "vppPlanSummary";
//			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
//					+ File.separator + CommonConstants.SITE_ULAYER
//					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
//					+ File.separator + zipcode + File.separator + county
//					+ File.separator;
//			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
//					fileName, directory);
//			getLoginScenario().saveBean(
//					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
//					planSummaryExpectedJson);
//
//			/* Get actual data */
//			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
//			getLoginScenario().saveBean(
//					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
//					planSummaryActualJson);
		}
	}

	
	
			


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
