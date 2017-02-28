package acceptancetests.responsive.ulayer;

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
import pages.acquisition.ulayer.PortfolioPage;
import pages.acquisition.ulayer.ResponsivePlanDetails;
import pages.acquisition.ulayer.ResponsivePlanSummary;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.mobile.acquisition.ulayer.VPPAarpNeedAStepBackWidget;
import pages.mobile.acquisition.ulayer.VPPAarpNeedHelpWidgetPage;
import pages.mobile.acquisition.ulayer.VPPNeedMoreInformationWidget;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;

public class ResponsiveStepDefiniton {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the vpp portfolio page$")
	public void user_on_aarp_ourPlans_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		PortfolioPage ourPlans = new PortfolioPage(wd);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants. PORTFOLIO_PAGE, ourPlans);
	}
	
	@Then("^the user performs plan serach using zipcode$")
	public void user_planSearch_with_zipcode(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		String county = memberAttributesMap.get("County");
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario()
				.getBean(PageConstants. PORTFOLIO_PAGE);
		ResponsivePlanSummary vppPlan = portfolioPage.searchPlans(zipcode, county);
		if(vppPlan!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE, vppPlan);
		}else{
			Assert.fail();
		}
	}
	
	@And("^verifies the zipcode on VPP page$")
	public void user_validates_VPPPage(){
		 VPPPlanSummaryPage vppPlan= (VPPPlanSummaryPage) getLoginScenario()
				 .getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		 //validate with JSON
		 System.out.println("JSON validation starts");
		 /* Get expected data */
			String fileName = "vppPlanSummary";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
					+ File.separator + getLoginScenario().getBean(VPPCommonConstants.ZIPCODE) 
					+ File.separator + getLoginScenario().getBean(VPPCommonConstants.COUNTY)
					+ File.separator;
			JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
					planSummaryExpectedJson);

			/* Get actual data */
			JSONObject planSummaryActualJson = vppPlan.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);
			System.out
			.println("planSummaryActualJson---->" + planSummaryActualJson);
	System.out.println("planSummaryExpectedJson---->"
			+ planSummaryExpectedJson);

	try {
		JSONAssert.assertEquals(planSummaryExpectedJson,
				planSummaryActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}
		}
	@Then("^the user navigates to the following plan type$")
	public void planType_details_in_aarp_site(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planType = memberAttributesMap.get("Plan Type");
		System.out.println(planType);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, planType);

		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);	
		
		ResponsivePlanSummary vpp =	plansummaryPage.viewPlanSummary(planType);
		if(vpp!=null){
			getLoginScenario().saveBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE, vpp);
		}else{
			Assert.fail();
		}
	}
	//US501386 - Plan Highlights 
	@And ("^the user validates plan highlight and provider search$")
	public void user_validates_planHighlights_poviderLink(){
		ResponsivePlanSummary planSummary = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		planSummary.validatePlanHighlights();
 	}
	@Then("^user clicks on search by address link$")
	public void search_by_address() {
		PortfolioPage portfolioPage = (PortfolioPage) getLoginScenario().getBean(PageConstants. PORTFOLIO_PAGE);
		portfolioPage.searchbyaddressclick();
		portfolioPage.validate();
	}
	@And("^the user navigates to plan details page$")
	public void the_user_navigates_to_plan_details_page(DataTable givenAttributes) {
		ResponsivePlanSummary plansummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes 
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planName = memberAttributesMap.get("Plan Name");
		System.out.println(planName);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
 		ResponsivePlanDetails planDetails =  plansummaryPage.viewPlanDetails(planName);
 		getLoginScenario().saveBean(PageConstants.RESPONSIVE_DETAILS_PAGE, planDetails);
 	}
	
	@Then("^user validates county name on plan summary page$")	
	public void user_validates_county_name(){
		
		ResponsivePlanSummary responsivePlanSummaryPage = (ResponsivePlanSummary) getLoginScenario()
				.getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		System.out.println(getLoginScenario().getBean(VPPCommonConstants.COUNTY));
		String name = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		System.out.println("name"+ name );
		responsivePlanSummaryPage.validateCountyName(name);
		
	}
	@And("^the user validates Need a step back in right rail widgets$")
	public void the_user_validates_Need_step_back(){
		ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
				getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		VPPAarpNeedAStepBackWidget stepBackWidget =  planSummary.validateStepBackWidget();
		stepBackWidget.validateStepBackWidget();
	}
	@And("^the user validates chat now widget in right rail widgets$")
	 public void the_user_validates_help_widget_in_raight_rail(){
		ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
				getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		VPPAarpNeedHelpWidgetPage needHelpWidget = planSummary.validateNeedHelpWidget();
	   needHelpWidget.chatWithUsWidget();			
	}
	@And("^the user validates need more information widget in right rail widgets$")
	 public void the_user_validates_needInformation_widget_in_raight_rail(){
		ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
				getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		VPPNeedMoreInformationWidget needMoreInfo = planSummary.validateNeedMoreInformationWidget();
		needMoreInfo.moreInformationWidget();
	}
	@When("^the user moved to the email update widget in selected plan section in AARP site$")
	 public void the_user_validates_email_widget_in_raight_rail(){
		ResponsivePlanSummary planSummary= (ResponsivePlanSummary) 
				getLoginScenario().getBean(PageConstants.RESPONSIVE_PLAN_SUMMARY_PAGE);
		VPPRequestSendEmailPage emailRequest = planSummary.validateEmailWidget();
		if (emailRequest != null) {
			getLoginScenario().saveBean(PageConstants.VPP_REQUEST_SEND_EMAIL_PAGE,emailRequest);
		}	
		
	}
	@And ("^the user enter information to Get Email Update widget and submit in AARP site$")
	public void vpp_user_request_send_email(DataTable personalAttributes) {
		List<DataTableRow> personalAttributesRow = personalAttributes.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {
			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		String firstName = personalAttributesMap.get("First Name");
		String lastName = personalAttributesMap.get("Last Name");
		String emailAddress =personalAttributesMap.get("Email Address");
		getLoginScenario().saveBean(VPPCommonConstants.FIRST_NAME, firstName);
		getLoginScenario().saveBean(VPPCommonConstants.LAST_NAME, lastName);
		getLoginScenario().saveBean(VPPCommonConstants.EMAIL_ADDRESS, emailAddress);		
		VPPRequestSendEmailPage requestSendEmailPage= (VPPRequestSendEmailPage)getLoginScenario()
				.getBean(PageConstants.VPP_REQUEST_SEND_EMAIL_PAGE);
		requestSendEmailPage.sendEmailByClickSummbitButtonOnEmailWidget(firstName, lastName, emailAddress);	
	}
	
	
}
