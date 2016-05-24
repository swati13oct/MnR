package acceptancetests.rallytool.bluelayer.acquisition;

import gherkin.formatter.model.DataTableRow;

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

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.MAEnrollmentPage;
import pages.acquisition.bluelayer.MAPlanInformationAndForms;
import pages.acquisition.bluelayer.MAPrescriptionDrugTransitionProcess;
import pages.acquisition.bluelayer.MARequestMoreHelpAndInformationPage;
import pages.acquisition.bluelayer.MAResourcesAndPlanMaterialsTabpage;
import pages.acquisition.bluelayer.MARightsAndResponsibilitiesPage;
import pages.acquisition.bluelayer.OurPlansMAHowToAppointARepresentativePage;
import pages.acquisition.bluelayer.OurPlansMAHowToPayYourPremiumPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.bluelayer.SiteMapUMSPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author naggarw2
 *
 */
public class RallytoolUhcsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	
	@Given("^user navigates to MA Enrollment Information Tab of Blue Layer Acquisition site$")

	public void user_navigates_MA_Enrollment_Information_Page () {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		MAEnrollmentPage enrollmentpage = new MAEnrollmentPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.MA_ENROLLMENT_PAGE, enrollmentpage);
		
		
	
	
}
	
	@And("^click on the Look up my provider link on MA Enrollment Information Page and rally tool opens up$")
	
	public void user_clicks_providerlink_MAEnrollmentPage () {
		
		MAEnrollmentPage enrollmentpage= (MAEnrollmentPage)getLoginScenario().getBean(PageConstants.MA_ENROLLMENT_PAGE);
		
		Rallytool_Page rallytool = enrollmentpage.MAEnrollmentproviderclick();
		if(rallytool!= null){
			getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
					rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
		
		
	}
	
	
		
	@Given("^user navigates to MA PLAN INFORMATION AND FORMS of Blue Layer Acquisition site$")
	
	public void user_navigates_MA_PLAN_Information_and_forms_Page () {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		MAPlanInformationAndForms informationandforms = new MAPlanInformationAndForms(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.MA_PLAN_INFORMATION_AND_PLANS_PAGE, informationandforms);
	
	
	}	
	
	
	
	@And("^click on the Look up my provider link on MA PLAN INFORMATION AND FORMS and rally tool opens up$")
	
	public void user_clicks_providerlink_MAPlanInformationAndPlans () {
	
		MAPlanInformationAndForms informationandforms= (MAPlanInformationAndForms)getLoginScenario().getBean(PageConstants.MA_PLAN_INFORMATION_AND_PLANS_PAGE);
	
	Rallytool_Page rallytool = informationandforms.MAPlanInformationproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
	
	}	
	
	@Given("^the user is on the UHC Medicaresolutions Home page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}


@When("^user clicks on Sitemap link from home page footer UHC Medicaresolutions Site$")
public void user_clicks_Sitemap_links_ums() {
	
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	SiteMapUMSPage siteMapUMSPage = aquisitionhomepage.siteMapFooterClick();
	if(siteMapUMSPage != null){
	getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE,
			siteMapUMSPage);
	Assert.assertTrue(true);
	}else{
		Assert.fail("Error in Site map page");
		
	}
}
@Then("^user clicks on the Search for Provider/Facility link and site opens new provider search tool in a new window$")

public void click_lookupprovider() {
	SiteMapUMSPage siteMapAcqUMSPage = (SiteMapUMSPage)getLoginScenario().getBean(PageConstants.SITE_MAP_PAGE);


	Rallytool_Page rallytool = siteMapAcqUMSPage.lookupproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}



@Given("^user navigates to the UHC Home Page$")

public void uhchomepage()
{
	WebDriver wd = getLoginScenario().getWebDriver();

	AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
			aquisitionhomepage);
}

@And("^user performs plan search using following information in UHC site$")

public void zipcode_details_in_UMS_site(DataTable givenAttributes) {

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
		// Get expected data
		String fileName = "vppPlanSummary";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
				+ File.separator + zipcode + File.separator + county
				+ File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		getLoginScenario().saveBean(
				VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
				planSummaryExpectedJson);

		// Get actual data
		JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
		System.out.println("planSummaryActualJson--->"+planSummaryActualJson);
		getLoginScenario().saveBean(
				VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
				planSummaryActualJson);

	}
}
@When("user views plans of the below plan type in UMS site$")
public void user_performs_planSearch_in_UMS_site(DataTable givenAttributes) {
	List<DataTableRow> givenAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < givenAttributesRow.size(); i++) {

		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
				givenAttributesRow.get(i).getCells().get(1));
	}

	String plantype = givenAttributesMap.get("Plan Type");

	VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

	if (plansummaryPage != null) {
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
				plansummaryPage);
		// Get actual data
		JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
		System.out.println("planSummaryActualJson--->"+planSummaryActualJson);
		//planSummaryActualJson
		getLoginScenario().saveBean(
				VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
				planSummaryActualJson);

		// Get expected data
		String fileName = null;
		if (plantype.equalsIgnoreCase("MA")
				|| plantype.equalsIgnoreCase("MAPD")) {
			fileName = "maplans";
		} else if (plantype.equalsIgnoreCase("PDP")) {
			fileName = "pdpplans";
		} else if (plantype.equalsIgnoreCase("SNP")) {
			fileName = "snpplans";
		} else {
			fileName = "msplans";
		}

		String zipcode = (String) getLoginScenario().getBean(
				VPPCommonConstants.ZIPCODE);
		String county = (String) getLoginScenario().getBean(
				VPPCommonConstants.COUNTY);
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
				+ File.separator + zipcode + File.separator + county
				+ File.separator;
		JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		getLoginScenario().saveBean(
				VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED,
				planSummaryExpectedJson);
	}

}

@Then("^user validates plan count for all plan types on plan summary page in UMS site$")
public void user_validates_following_benefits_ui_UMS() {
	JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
			.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
	JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
			.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
	System.out.println("planSummaryActualJson===>"
			+ planSummaryActualJson.toString());
	System.out.println("planSummaryExpectedJson===>"
			+ planSummaryExpectedJson.toString());
	try {
		JSONAssert.assertEquals(planSummaryExpectedJson,
				planSummaryActualJson, true);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

@Then("^the user validates the available plans for selected plan types in UMS site$")
public void user_validates_available_plans_UMS() {
	JSONObject planSummaryActualJson = (JSONObject) getLoginScenario()
			.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL);
	JSONObject planSummaryExpectedJson = (JSONObject) getLoginScenario()
			.getBean(VPPCommonConstants.VPP_PLAN_SUMMARY_EXPECTED);
	System.out.println("planSummaryActualJson====>"
			+ planSummaryActualJson.toString());
	System.out.println("planSummaryExpectedJson====>"
			+ planSummaryExpectedJson.toString());
	try {
		JSONAssert.assertEquals(planSummaryExpectedJson,
				planSummaryActualJson, true);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@And("^the user validates the plan summary for the below plan in UMS site$")
public void user_validates_plan_summary_ums(DataTable planAttributes) {
	List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < givenAttributesRow.size(); i++) {

		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
				givenAttributesRow.get(i).getCells().get(1));
	}

	String planName = givenAttributesMap.get("Plan Name");
	getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
	VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	// get actual data for a particular plan
	JSONObject planSummaryActualJson = planSummaryPage
			.getPlanSummaryActualData(planName);
	System.out
			.println("planSummaryActualJson---->" + planSummaryActualJson);
	// Get expected data
	String fileName = planName;
	String zipcode = (String) getLoginScenario().getBean(
			VPPCommonConstants.ZIPCODE);
	String county = (String) getLoginScenario().getBean(
			VPPCommonConstants.COUNTY);
	String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
			+ File.separator + CommonConstants.SITE_BLUELAYER
			+ File.separator + VPPCommonConstants.VPP_PLAN_FLOW_NAME
			+ File.separator + zipcode + File.separator + county
			+ File.separator;
	JSONObject planSummaryExpectedJson = MRScenario.readExpectedJson(
			fileName, directory);
	System.out.println("planSummaryExpectedJson---->"
			+ planSummaryExpectedJson);
	try {
		JSONAssert.assertEquals(planSummaryExpectedJson,
				planSummaryActualJson, true);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

@And("^the user clicks on Is my doctors covered link in UHC site and site opens Rally Connect in a new window$")
public void enters_provider_information_aarp() {

	String planName = (String) getLoginScenario().getBean(
			VPPCommonConstants.PLAN_NAME);

	
	VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
	Rallytool_Page rallytool = planSummaryPage
			.clicksOnIsProviderCovered(planName);
	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}


@When("^the user view plan details of the above selected plan in UMS site$")
public void user_views_plandetails_selected_plan_ums() {
	String planName = (String) getLoginScenario().getBean(
			VPPCommonConstants.PLAN_NAME);
	String zipcode = (String) getLoginScenario().getBean(
			VPPCommonConstants.ZIPCODE);
	String county = (String) getLoginScenario().getBean(
			VPPCommonConstants.COUNTY);
	VPPPlanSummaryPage vppPlanSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
			.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

	PlanDetailsPage vppPlanDetailsPage = vppPlanSummaryPage
			.navigateToPlanDetails(planName);
	if (vppPlanDetailsPage != null) {
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_DETAILS_PAGE,
				vppPlanDetailsPage);
		/* Get actual data */
		JSONObject planDetailsActualJson = vppPlanDetailsPage.vppPlanDetailsJson;
		System.out.println("planDetailsActualJson---->"
				+ planDetailsActualJson);
		getLoginScenario().saveBean(
				VPPCommonConstants.VPP_PLAN_DETAIL_ACTUAL,
				planDetailsActualJson);

		/* Get expected data */
		String fileName = planName;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ VPPCommonConstants.VPP_PLAN_DETAILS_FLOW_NAME
				+ File.separator + zipcode + File.separator + county
				+ File.separator;
		JSONObject planDetailsExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		getLoginScenario().saveBean(
				VPPCommonConstants.VPP_PLAN_DETAIL_EXPECTED,
				planDetailsExpectedJson);

	}
}


@And("^the user clicks on Is my doctors covered link on Plan Details page in UHC site and site opens Rally Connect in a new window$")
public void click_plandetailssearchprovider() {
	PlanDetailsPage planDetailsPage = (PlanDetailsPage)getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);


	Rallytool_Page rallytool = planDetailsPage.lookupproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}

}

@And("^the user clicks on IS MY DOCTORS covered link on Plan Details page in UHC site and site opens Rally Connect in a new window$")
public void click_plandetailsearchprovider() {
	PlanDetailsPage planDetailsPage = (PlanDetailsPage)getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);


	Rallytool_Page rallytool = planDetailsPage.lookupaproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}

}

@Given("^user navigates to MA PrescriptionDrug Transition Process page of Blue Layer Acquisition site$")

public void user_navigates_MAPrescriptionDrugTransitionProcess () {
	
	WebDriver wd = getLoginScenario().getWebDriver();
	MAPrescriptionDrugTransitionProcess mapresdrugstransitionpage = new MAPrescriptionDrugTransitionProcess(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.MA_PRESDRUGS_TRANSITION_PAGE, mapresdrugstransitionpage);


}	



@Then("^click on the Look up my provider link on MA PrescriptionDrug Transition Process page and rally tool opens up$")

public void user_clicks_providerlink_MAHowToAppointRepresentativePage () {

	MAPrescriptionDrugTransitionProcess informationandforms= (MAPrescriptionDrugTransitionProcess)getLoginScenario().getBean(PageConstants.MA_PRESDRUGS_TRANSITION_PAGE);

Rallytool_Page rallytool = informationandforms.MAPlanInformationproviderclick();
if(rallytool!= null){
	getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
			rallytool);
	Assert.assertTrue(true);
} else {
	Assert.fail(" Page not found");
}



}


@Given("^user navigates to MA How To Appoint Representative page of Blue Layer Acquisition site$")

public void user_navigates_MAHowToAppointRepresentativePage () {
	
	WebDriver wd = getLoginScenario().getWebDriver();
	OurPlansMAHowToAppointARepresentativePage mahowtoappointrepresentativepage = new OurPlansMAHowToAppointARepresentativePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.MA_HOW_TO_APPOINT_REPR_PAGE, mahowtoappointrepresentativepage);


}	



@Then("^click on the Look up my provider link on MA How To Appoint Representative page and rally tool opens up$")

public void user_clicks_providerlink_MAPrescriptionDrugTransitionProcess () {

	OurPlansMAHowToAppointARepresentativePage informationandforms= (OurPlansMAHowToAppointARepresentativePage)getLoginScenario().getBean(PageConstants.MA_HOW_TO_APPOINT_REPR_PAGE);

Rallytool_Page rallytool = informationandforms.MAPlanInformationproviderclick();
if(rallytool!= null){
	getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
			rallytool);
	Assert.assertTrue(true);
} else {
	Assert.fail(" Page not found");
}


}







	



@Given("^user navigates to the OUR PLANS: MA HOW TO PAY YOUR PREMIUM$")

public void user_navigates_OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM () {
		
		WebDriver wd = getLoginScenario().getWebDriver();
		OurPlansMAHowToPayYourPremiumPage ourplansmahowtopayyourpremium = new OurPlansMAHowToPayYourPremiumPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM, ourplansmahowtopayyourpremium);
		
		
	
	
}
	
	@And("^user clicks on Look up provider link on OUR PLANS: MA HOW TO PAY YOUR PREMIUM then site open rally tool in new window$")
	
	public void user_clicks_providerlink_OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM () {
		
		OurPlansMAHowToPayYourPremiumPage ourplansmahowtopayyourpremium= (OurPlansMAHowToPayYourPremiumPage)getLoginScenario().getBean(PageConstants.OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM);
		
		Rallytool_Page rallytool = ourplansmahowtopayyourpremium.ourplansmahowtopayyourpremiumproviderclick();
		if(rallytool!= null){
			getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
					rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}

	

@Given("^user navigates to the OUR PLANS: MA REQUEST MORE HELP AND INFORMATION$")

public void user_navigates_OurPlans_MA_Request_More_Help_and_Information () {
	
	WebDriver wd = getLoginScenario().getWebDriver();
	MARequestMoreHelpAndInformationPage marequestmorehelpandinformationpage = new MARequestMoreHelpAndInformationPage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.MA_REQUEST_MORE_HELP_AND_INFORMATION, marequestmorehelpandinformationpage);
	
	


}

@And("^user clicks on Look up provider link on OUR PLANS: MA REQUEST MORE HELP AND INFORMATION then site open rally tool in new window$")
public void user_clicks_providerlink_MA_REQUEST_MORE_HELP_AND_INFORMATION () {
	
	MARequestMoreHelpAndInformationPage marequestmorehelpandinformationpage= (MARequestMoreHelpAndInformationPage)getLoginScenario().getBean(PageConstants.MA_REQUEST_MORE_HELP_AND_INFORMATION);
	
	Rallytool_Page rallytool = marequestmorehelpandinformationpage.MArequestmorehelpandinformationpageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}



@Given("^user navigates to the OUR PLANS: MA RESOURCES AND PLAN MATERIALS TAB$")

public void user_navigates_OurPlans_MA_Resources_And_PlanMaterials () {
	
	WebDriver wd = getLoginScenario().getWebDriver();
	MAResourcesAndPlanMaterialsTabpage maresourcesandplanmaterialstabpage = new MAResourcesAndPlanMaterialsTabpage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.MA_RESOURCES_AND_PLAN_TAB, maresourcesandplanmaterialstabpage);
	
	


}

@And("^user clicks on Look up provider link on OUR PLANS: MA RESOURCES AND PLAN MATERIALS TAB then site open rally tool in new window$") 

public void user_clicks_providerlink_MA_Resources_And_PlanMaterials () {
	
	MAResourcesAndPlanMaterialsTabpage maresourcesandplanmaterialstabpage= (MAResourcesAndPlanMaterialsTabpage)getLoginScenario().getBean(PageConstants.MA_RESOURCES_AND_PLAN_TAB);
	
	Rallytool_Page rallytool = maresourcesandplanmaterialstabpage.marequestmorehelpandinformationpageclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Given("^user navigates to MA MEMBER RIGHTS AND RESPONSIBILITIES of Blue Layer Acquisition site$")

public void user_navigates_MA_MEMBER_RIGHTS_AND_RESPONSIBILITIES () {
	
	WebDriver wd = getLoginScenario().getWebDriver();
	MARightsAndResponsibilitiesPage rightsandresponsibilities = new MARightsAndResponsibilitiesPage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.MA_RIGHTS_AND_RESPONSIBILITIES_PAGE, rightsandresponsibilities);
	
	


}

@And("^click on the Look up my provider link on MA Enrollment Information Page and rally tool opens up$")

public void user_clicks_providerlink_MARightandresponsibilitiepage () {
	
	MARightsAndResponsibilitiesPage rightsandresponsibilities= (MARightsAndResponsibilitiesPage)getLoginScenario().getBean(PageConstants.MA_RIGHTS_AND_RESPONSIBILITIES_PAGE);
	
	Rallytool_Page rallytool = rightsandresponsibilities.MAEnrollmentproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

}


	
	
		
	

