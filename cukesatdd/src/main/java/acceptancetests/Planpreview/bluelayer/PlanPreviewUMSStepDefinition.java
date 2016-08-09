package acceptancetests.Planpreview.bluelayer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.PlanPreviewPage;
import pages.acquisition.uhcretiree.Rallytool_Page;

/**
 * @author pgupta15
 *
 */


public class PlanPreviewUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	@Given("^the user is on the Plan Preview Page of UMS medicare site landing page$")
	public void user_is_on_UMS_site()
	{
		WebDriver wd= getLoginScenario().getWebDriver();
		PlanPreviewPage planPreview = new PlanPreviewPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE, planPreview);
	}
	
	@When("^the user validates the multicounty popup on bluelayer$")
	public void user_validates_multicounty_popup_bluelayer(DataTable givenAttributes) throws InterruptedException
	{
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
		 planpreviewPage.searchPlans(zipcode, county);
	}
	
	@When("^user select the below  plan$")
	public void user_validates_plan_selector_dropdown(DataTable givenAttributes)
	{
			List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String planName = memberAttributesMap.get("PlanName");
		String planType = memberAttributesMap.get("PlanType");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
			
		
		planpreviewPage.validatesplandropdown(planName);
	}
	@Then("^user validates the provider search and locate pharmacy link$")
	public void user_validates_provider_and_pharmacy_locator()
	{
//		List<DataTableRow> memberAttributesRow = givenAttributes
//				.getGherkinRows();
//		Map<String, String> memberAttributesMap = new HashMap<String, String>();
//		for (int i = 0; i < memberAttributesRow.size(); i++) {
//
//			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
//					.get(0), memberAttributesRow.get(i).getCells().get(1));
//		}
		
//		String plantype= memberAttributesMap.get("PlanType");
		String plantype=(String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		System.out.println(plantype);
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		
		planpreviewPage.validateprovider_pharmacylink(plantype);
	}
	
	@Then("^user clicks on locate pharmacy$")
	public void user_click_to_locate_pharmacy()
	{
		
		
		String plantype = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		if (plantype.equalsIgnoreCase("MA"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			planpreviewPage.navigatetopharmacylink(plantype);
		}
	}
	
	@Then("^user validates the plan year dropdown$")
	public void user_validates_planyear_dropdown()
	{
		PlanPreviewPage planpreviewPage = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		
		planpreviewPage.validate_planyeardropdown();
	}
	
	@And("^user click on provider link$")
	public void user_click_provider_link()
	{
		PlanPreviewPage planpreviewPage= (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		Rallytool_Page rallyPage= planpreviewPage.navigatetoRally();
		if (rallyPage==null)
		{
			Assert.fail("Issue in launching Rally tool");
			
		}
			
		
	}
	@And("^the user validate pdf links$")
	public void validate_Pdf_Links(){
		PlanPreviewPage planpreviewPage  = (PlanPreviewPage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		JSONObject planDocsPDFActualJson = planpreviewPage.getActualPdfLinksData();
		System.out.println(planDocsPDFActualJson);
		/* Get expected data */
		String fileName = "planpreviewpdf";
		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		String year = (String) getLoginScenario().getBean(VPPCommonConstants.YEAR);
		
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ VPPCommonConstants.VPP_PLAN_DETAILS_FLOW_NAME
				+ File.separator + zipcode + File.separator + county
				+ File.separator;
		System.out.println(directory);
		JSONObject planDocsPDFExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		System.out.println(planDocsPDFExpectedJson);
		
		try {
			JSONAssert.assertEquals(planDocsPDFExpectedJson,
					planDocsPDFActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
