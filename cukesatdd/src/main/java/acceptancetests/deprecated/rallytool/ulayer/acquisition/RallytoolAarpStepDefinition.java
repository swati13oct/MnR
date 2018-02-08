package acceptancetests.deprecated.rallytool.ulayer.acquisition;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gherkin.formatter.model.DataTableRow;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import acceptancetests.deprecated.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RallytoolAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;

	}

	@Given("^user navigates to the AARP Site Map Page$")
	public void aarpsitemap() {
		WebDriver wd = getLoginScenario().getWebDriver();
		SiteMapAARPPage siteMapAARPPage = new SiteMapAARPPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE,
				siteMapAARPPage);
	}

	@Then("^user clicks on the Search For a Provider link on AARP Site Map Page and site opens Rally Connect in a new window$")
	public void aarpsitemappagerallylink() {
		SiteMapAARPPage siteMapAARPPage = (SiteMapAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_SITE_MAP_PAGE);
		Rallytool_Page rallytool = siteMapAARPPage
				.providerlinkonaarpsitemapClick();
		if (rallytool != null) {
			getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
					rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}
	
	
	@Given("^the user is on the AARP Medicareplans Home page$")
	public void the_user_on_AARP_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@And("^user performs plan search using following information in AARP site$")
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

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		VPPPlanSummaryPage plansummaryPage = aquisitionhomepage.searchPlans(
				zipcode, county);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			/* Get expected data */
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
		}
	}
	
	@Then("^click on Is my Provider Covered link of MA/MAPD plans for next year plan and switch back and validate Rally Connect Get Started page$")
	public void clicks_on_Provider_link_next_year(DataTable givenAttributes) throws InterruptedException
	{	
		//WebDriver wd = getLoginScenario().getWebDriver();
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String plantype = memberAttributesMap.get("Plan Type");
		
		VPPPlanSummaryPage plansummary= (VPPPlanSummaryPage)getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummary.viewPlanSummary(plantype);
		boolean rallyGetStartedPage = plansummary.clicksOnMAProviderCoveredLink();
		if(rallyGetStartedPage){
			Assert.assertTrue(true);
		}else{
			Assert.fail(" Page not found");
		}
		
	}

}
