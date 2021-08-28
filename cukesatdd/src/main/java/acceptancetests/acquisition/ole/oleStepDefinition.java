package acceptancetests.acquisition.ole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.ole.*;

/**
 * @author sdwaraka Functionality:OLE Common Tool for both AAPR and UHC
 *         acquisition sites
 */
public class oleStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * @author sdwaraka
	 * 
	 * @param planAttributes
	 * @throws Throwable
	 */
	private Scenario scenario;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}


	@Given("^the user lands on OLE Welcome Page wity following Plan Details$")
	public void the_user_lands_on_OLE_Welcome_Page_wity_following_Plan_Details(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		String PlanName = givenAttributesMap.get("Plan Name");
		String PlanPremium = givenAttributesMap.get("Premium");
		String County = givenAttributesMap.get("County Name");
		String ZipCode = givenAttributesMap.get("Zip Code");
		String PlanType = givenAttributesMap.get("Plan Type");
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String SiteName = "AARP_ACQ";
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);

		// Hard Coding OLE Welcome Page URL for Build Validation Test
		String OLE_URL = "https://www.team-f-aarpmedicareplans.ose-elr-core.optum.com/content/aarpmedicareplans/en/enrollment.html";

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		WelcomePage welcomePage = new WelcomePage(wd, OLE_URL);
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	/**
	 * @author sdwaraka To start Enroll Now and land on Welcome Page from Plan
	 *         Summary Page of VPP
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the user clicks on Enroll Now for AARP site to start the OLE flow$")
	public void the_user_clicks_on_Enroll_Now_to_start_the_OLE_flow(DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String PlanName = givenAttributesMap.get("Plan Name");
		
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String PlanPremium = "";
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName;
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		// -----------------------------------------------------------------------------------------------------
		WelcomePage welcomePage;
		if (SiteName.contains("UHC_ACQ")) {
			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		//	TFN = planSummaryPage.GetTFNforPlanType();

			
			welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName, PlanType);
			PlanPremium=planSummaryPage.GetMonthlyPremiumValue();

		} else {
			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			/*
			 * ,(new VPPPlanSummaryPage((WebDriver)getLoginScenario()
			 * .getBean(CommonConstants.WEBDRIVER))));
			 */
		//	TFN = planSummaryPage.GetTFNforPlanType();

			// PlanPremium = planSummaryPage.getPlanPremium(PlanName);
			welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName, PlanType);
			PlanPremium=planSummaryPage.GetMonthlyPremiumValue();

		} // --------------------------------------------------------------------------------------------------------------------

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
	//	getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
	//	System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);

		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	@Then("^the user navigates to clicks on Enroll Now for AARP site to start the OLE flow$")
	public void the_user_navgates_to_clicks_on_Enroll_Now_to_start_the_OLE_flow(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String PlanName = givenAttributesMap.get("Plan Name");
		
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String PlanPremium = "";
		String ZipCode = givenAttributesMap.get("Zip Code");
		String County = givenAttributesMap.get("County Name");
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName;
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		// -----------------------------------------------------------------------------------------------------
		WelcomePage welcomePage;
		if (SiteName.contains("UHC_ACQ")) {
			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		//	TFN = planSummaryPage.GetTFNforPlanType();
			welcomePage = planSummaryPage.Enroll_OLE_Plan_campaign_uhc(PlanName, PlanType);

		} else {
			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		//	TFN = planSummaryPage.GetTFNforPlanType();
			welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName, PlanType);

		} // --------------------------------------------------------------------------------------------------------------------

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
	//	getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
	//	System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);

		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	@Then("^the user navigates to clicks on Enroll Now from visitor profile to start the OLE flow$")
	public void the_user_navgates_to_clicks_on_Enroll_Now_From_VisitorProfile_flow(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String PlanName = givenAttributesMap.get("Plan Name");
		String PlanType = givenAttributesMap.get("Plan Type");
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String SiteName;
		String PlanPremium = "";
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		System.out.println("Site Name is : " + SiteName);
		// -----------------------------------------------------------------------------------------------------
		WelcomePage welcomePage;
		if (SiteName.contains("UHC_ACQ")) {
			VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
					.getBean(PageConstants.VISITOR_PROFILE_PAGE);
			// TFN = planSummaryPage.GetTFNforPlanType();

			welcomePage = visitorProfilePage.Enroll_OLE_Plan(PlanName);

		} else {
			VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
					.getBean(PageConstants.VISITOR_PROFILE_PAGE);
			// TFN = planSummaryPage.GetTFNforPlanType();

			welcomePage = visitorProfilePage.Enroll_OLE_Plan(PlanName);

		}

		// --------------------------------------------------------------------------------------------------------------------

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);

		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	/**
	 * @author sdwaraka To start Enroll Now and land on Welcome Page from Plan
	 *         Details Page of VPP
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the user clicks on Enroll Now in Plan Details Page to start the OLE flow$")
	public void the_user_clicks_on_Enroll_Now_in_Plan_Details_Page_to_start_the_OLE_flow() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);

		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName;
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);

		WelcomePage welcomePage;
		if (SiteName.contains("UHC_ACQ")) {

			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			TFN = vppPlanDetailsPage.GetTFNforPlanType();
			welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		} else {
			PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
			TFN = vppPlanDetailsPage.GetTFNforPlanType();
			welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		}
		String PlanPremium = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	@Then("^the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow$")
	public void the_user_get_Plan_Details_for_the_following_Plan(DataTable planAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String PlanName = givenAttributesMap.get("Plan Name");		
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String PlanPremium = "";
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		WelcomePage welcomePage;
		if(PlanType.contains("MAPD")){
			ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);
			welcomePage  = comparePlansPage.Enroll_OLE_Plan_Compare_MAPD(PlanName);
			PlanPremium=comparePlansPage.GetMonthlyPremiumValue();
		}else {
			ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);

			welcomePage  = comparePlansPage.Enroll_OLE_Plan_Compare_PDP(PlanName);
			PlanPremium=comparePlansPage.GetMonthlyPremiumValue();
		}

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		// getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("Plan Year is : " + PlanYear);
		// System.out.println("OLE is being started from Acquisition Site : "+SiteName);
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");

	}

	/**
	 * @author sdwaraka To Validate the Plan Details carried forward from VPP on
	 *         Welcome Page of VPP
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the user validates the Plan details on OLE$")
	public void the_user_validates_the_Plan_details_on_OLE() throws Throwable {
	//	scenario.log("Sai - Change made 06/15 - Validate planname, year,zipcode,county,premium");
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));
		//String Premium = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
		String Premium;
		//String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		PlanDetailsMap.put("Plan Type", (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE));
		boolean Validation_Status = welcomePage.validate_plan_details(PlanDetailsMap);
	//	boolean Validation_Status = welcomePage.validate_plan_details_CSNP(PlanDetailsMap);
		Premium = welcomePage.GetMonthlyPremiumValue();
		if (Validation_Status) {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status + " - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
		//	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanDetailsMap.get("Plan Premium"));
			getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, Premium);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status);
			Assertion.fail();
		}
	}

	@Then("^the user validates TFN on Welcome OLE Page$")
	public void the_user_validates_TFN_on_Welcome_OLE_Page(DataTable planAttributes) throws Throwable {
		scenario.log("Sai - Change made 06/15 - Validate TFN on Welcome OLE Page");
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
	//	Map<String, String> PlanDetailsMap = new HashMap<String, String>();
	//	PlanDetailsMap.put("TFN", (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN));
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		String ExpectedTFNNo = givenAttributesMap.get("TFN No");	
	//	String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
		boolean Validation_Status = welcomePage.ValidateTFNonWelcomeOLE(ExpectedTFNNo);
		if (Validation_Status) {
			System.out.println("TFN, Wunderman Validation in OLE PAGE : " + Validation_Status + " - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("TFN, Wunderman Validation in OLE PAGE : " + Validation_Status);
			Assertion.fail();
		}
		}
	}

/*	<<<<<<<<------------Removed the below step definition as per new OLE Redesign--------------------->>>>>>>>>>>>>>
 	@Then("^the user validates Learn more modal for Welcome OLE$")
	public void the_user_validates_Learn_more_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		LearnMoreModal learnMoremodal = welcomePage.OpenLearnMore();
		if (learnMoremodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					learnMoremodal);
			System.out.println("OLE Learn More Modal is Displayed");
		} else
			Assertion.fail("OLE Learn More Modal is NOT Displayed");

		welcomePage = (WelcomePage) learnMoremodal.returntoOLE();
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - Welcome Page is NOT Displayed");
	}

	@Then("^the user validates cancellation modal for Welcome OLE$")
	public void the_user_validates_cancellation_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		CancelOLEModal cancelOLEmodal = welcomePage.OpenCancelOLE();
		if (cancelOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
		} else
			Assertion.fail("OLE Cancellation Modal is NOT Displayed");

		welcomePage = (WelcomePage) cancelOLEmodal.returntoOLE();
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - Welcome Page is NOT Displayed");
	}

	@Then("^the user validates Leave OLE modal for Welcome OLE$")
	public void the_user_validates_Leave_OLE_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		LeavingOLEmodal leaveOLEmodal = welcomePage.OpenLeaveOLEmodal();
		if (leaveOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					leaveOLEmodal);
			System.out.println("Leave OLE modal - Back to OLE ");
		} else
			Assertion.fail("Leave OLE Modal is NOT Displayed");

		welcomePage = (WelcomePage) leaveOLEmodal.returntoOLE();
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("Back to OLE Application page - Welcome Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - Welcome Page is NOT Displayed");

	}

	<<<<<<<<------------Removed the step definition as per new OLE Redesign--------------------->>>>>>>>>>>>>>*/

	@Then("^the user validates the required fields for CSNP plans on Medicare Information Page$")
	public void the_user_validates_requierd_fields_for_Medicare_Information_Page_CSNP(DataTable arg1) throws Throwable {


		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		String PlanName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		medicareInfoPage.validate_Required_Fields_CSNP(MemberDetailsMap, PlanName);

		//------------Added for CSNP plans-------

		getLoginScenario().saveBean(oleCommonConstants.DIABETES_QUESTION_1, MemberDetailsMap.get("diabetesQuestion1"));
		getLoginScenario().saveBean(oleCommonConstants.DIABETES_QUESTION_2, MemberDetailsMap.get("diabetesQuestion2"));
		getLoginScenario().saveBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_1, MemberDetailsMap.get("chronicHeartFailure1"));
		getLoginScenario().saveBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_2, MemberDetailsMap.get("chronicHeartFailure2"));
		getLoginScenario().saveBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_3, MemberDetailsMap.get("chronicHeartFailure3"));
		getLoginScenario().saveBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_1,MemberDetailsMap.get("cardioVasculardisorder1"));
		getLoginScenario().saveBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_2,MemberDetailsMap.get("cardioVasculardisorder2"));
		getLoginScenario().saveBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_3,MemberDetailsMap.get("cardioVasculardisorder3"));
		getLoginScenario().saveBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_4,MemberDetailsMap.get("cardioVasculardisorder4"));
		getLoginScenario().saveBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_5,MemberDetailsMap.get("cardioVasculardisorder5"));
		getLoginScenario().saveBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_6,MemberDetailsMap.get("cardioVasculardisorder6"));
		Assertion.assertTrue(true);

		// ------------Added for CSNP plans-------
	}

	@Then("^the user navigates to Medicare Information Page$")
	public void the_user_navigates_to_Medicare_Information_Page() throws Throwable {
		PersonalInformationPage personalInfoPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		MedicareInformationPage medicareInfoPage = personalInfoPage.navigate_to_medicare_info_page();
		if (medicareInfoPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page is Displayed");
			Assertion.assertTrue(true);
		}
		else
			Assertion.fail("OLE Medicare Information Page is NOT Displayed");
	}

	@Then("^the user navigates to Medicare Information Page for PDP$")
	public void the_user_navigates_to_Medicare_Information_Page_PDP() throws Throwable {
		PersonalInformationPage personalInfoPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		MedicareInformationPage medicareInfoPage = personalInfoPage.navigate_to_medicare_info_page();
		if (medicareInfoPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page is Displayed");
			Assertion.assertTrue(true);
		}
		else
			Assertion.fail("OLE Medicare Information Page is NOT Displayed");
	}

	@Then("^the user validates Medicare Information Page required fields$")
	public void the_user_validates_Medicare_Information_Page_required_fields() throws Throwable {
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean Validation_Status = medicareInfoPage.validate_required_fields();
		if(Validation_Status){
			System.out.println("Medicare Information Page required fields : "+Validation_Status);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medicareInfoPage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("Medicare Information Page required fields : "+Validation_Status);
			Assertion.fail();
		}
	}

	@Then("^the user enters following required Medicare Informations$")
	public void the_user_enters_Medicare_Details_in_medicare_info_pages(DataTable planAttributes) throws Throwable {
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(planAttributes);
		String CardType = MedicareDetailsMap.get("Card Type");

		Random rnd = new Random();
		int n = 100000000 + rnd.nextInt(900000000);
		String MedicareNumber = Integer.toString(n) + "C";
		MedicareDetailsMap.put("Medicare Number", MedicareNumber);


		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		boolean isInformationFilled = medicareInfoPage.enter_required_Medicare_details(MedicareDetailsMap);
		if (isInformationFilled) {

			getLoginScenario().saveBean(oleCommonConstants.MEDICARE_NUMBER, MedicareDetailsMap.get("Medicare Number"));
			getLoginScenario().saveBean(oleCommonConstants.CARD_TYPE, MedicareDetailsMap.get("Card Type"));
			//getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			//getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_FLAG, MedicareDetailsMap.get("SSN Flag"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_NUMBER, MedicareDetailsMap.get("SSN Number"));

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page, Medicare Info is entered and Next Button is enabled");
			Assertion.assertTrue(true);
		}
		else
			Assertion.fail("Medicare Info data entry failed");
	}

	@Then("^the user enters following required Medicare Information$")
	public void the_user_enters_Medicare_Details_in_medicare_info_page(DataTable planAttributes) throws Throwable {
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String CardType = MedicareDetailsMap.get("Card Type");
		if (CardType.contains("HICN")) {
			Random rnd = new Random();
			int n = 100000000 + rnd.nextInt(900000000);
			String MedicareNumber = Integer.toString(n) + "C";
			MedicareDetailsMap.put("Medicare Number", MedicareNumber);

		} else if (CardType.contains("RRID")) {
			Random rnd = new Random();
			int n = 100000000 + rnd.nextInt(900000000);
			String MedicareNumber = "RID" + Integer.toString(n);
			MedicareDetailsMap.put("Medicare Number", MedicareNumber);

		}
		String SSNflag = MedicareDetailsMap.get("SSN Flag");
		if (SSNflag.contains("true")) {
			MedicareDetailsMap.put("SSN Number", "123456789");
		}
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		boolean isInformationFilled = medicareInfoPage.enter_required_Medicare_details(MedicareDetailsMap);
		if (isInformationFilled) {

			//	getLoginScenario().saveBean(oleCommonConstants.FIRST_NAME, MedicareDetailsMap.get("First Name"));
			//	getLoginScenario().saveBean(oleCommonConstants.LAST_NAME, MedicareDetailsMap.get("Last Name"));
			//getLoginScenario().saveBean(oleCommonConstants.PAPERLESS_DELIVERY, MedicareDetailsMap.get("Go Green"));
			getLoginScenario().saveBean(oleCommonConstants.MEDICARE_NUMBER, MedicareDetailsMap.get("Medicare Number"));
			getLoginScenario().saveBean(oleCommonConstants.CARD_TYPE, MedicareDetailsMap.get("Card Type"));
			//	getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			//	getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_FLAG, MedicareDetailsMap.get("SSN Flag"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_NUMBER, MedicareDetailsMap.get("SSN Number"));
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page, Medicare Info is entered and Next Button is enabled");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Medicare Info data entry failed");
	}

	@Then("^the user validates TFN in Medicare Info OLE Right Rail$")
	public void the_user_validates_TFN_in_Medicare_Info_OLE_Right_Rail() throws Throwable {
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
		boolean Validation_Status = MedicareInfoPage.ValidateTFNMedicareInfo(TFN);
		if(Validation_Status){
			System.out.println("TFN, Wunderman Validation in OLE Medicare Information Page : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, MedicareInfoPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("TFN, Wunderman Validation in OLE Medicare Information Page : " + Validation_Status);
			Assertion.fail();
		}
	}

	@Then("^the user validates the Plan details in Medicare Info OLE Right Rail")
	public void the_user_validates_the_Plan_details_in_Medicare_Info_OLE_Right_Rail() throws Throwable {
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

		boolean Validation_Status = MedicareInfoPage.validate_plan_details(PlanDetailsMap);
		if (Validation_Status) {
			System.out.println("Plan Details Validation in OLE Medicare Information  PAGE : " + Validation_Status
					+ " - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, MedicareInfoPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Plan Details Validation in OLE Medicare Information PAGE : " + Validation_Status);
			Assertion.fail();
		}
	}

	@Then("the user validates error messages for Negative values and required fields on Medicare Info Page")
	public void user_validates_negative_scenarios_medicare_info_page(){
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean Validation_Status = MedicareInfoPage.validate_negative_values();
		if(Validation_Status){
			System.out.println("Invalid Entry Validation for required fields in OLE Medicare Information  PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, MedicareInfoPage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("Invalid Entry Validation for required fields in OLE Medicare Information PAGE : "+Validation_Status);
			Assertion.fail();
		}
	}

	@Then("^the user validates Learn more modal for Medicare Information Page$")
	public void the_user_validates_Learn_more_Medicare_Info_for_Welcome_OLE() throws Throwable {
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		LearnMoreModal learnMoremodal = MedicareInfoPage.OpenLearnMore();
		if (learnMoremodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					learnMoremodal);
			System.out.println("OLE Learn More Modal is Displayed");
		} else
			Assertion.fail("OLE Learn More Modal is NOT Displayed");

		MedicareInfoPage = (MedicareInformationPage) learnMoremodal.returntoOLE();
		if (MedicareInfoPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					MedicareInfoPage);
			System.out.println("Back to OLE Application page - OLE Medicare Information Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page -OLE Medicare Information Page is NOT Displayed");

	}

	@Then("^the user validates Leave OLE modal for Medicare Information Page$")
	public void the_user_validates_Leave_OLE_modal_for_Medicare_Info_OLE() throws Throwable {
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		LeavingOLEmodal leaveOLEmodal = MedicareInfoPage.OpenLeaveOLEmodal();
		if (leaveOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEAVING_MODAL_PAGE,
					leaveOLEmodal);
			System.out.println("Leave OLE modal - Back to OLE ");
		} else
			Assertion.fail("Leave OLE Modal is NOT Displayed");

		MedicareInfoPage = (MedicareInformationPage) leaveOLEmodal.returntoOLE();
		if (MedicareInfoPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, MedicareInfoPage);
			System.out.println("Back to OLE Application page - OLE Medicare Information Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - OLE Medicare Information Page is NOT Displayed");

	}

	@Then("^the user validates cancellation modal for Medicare Information Page$")
	public void the_user_validates_cancellation_modal_for_Medicare_Info_OLE() throws Throwable {
		MedicareInformationPage MedicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		CancelOLEModal cancelOLEmodal = MedicareInfoPage.OpenCancelOLE();
		if (cancelOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
		} else
			Assertion.fail("OLE Cancellation Modal is NOT Displayed");

		MedicareInfoPage = (MedicareInformationPage) cancelOLEmodal.returntoOLE();
		if (MedicareInfoPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					MedicareInfoPage);
			System.out.println("Back to OLE Application page - OLE Medicare Information Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - OLE Medicare Information Page is NOT Displayed");

	}

	@Then("^the user navigates to Preliminary Questions Page$")
	public void the_user_navigates_to_Preliminary_Questions_Page() throws Throwable {
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		PrelimineryQuestionsPage prelimineryQuestionsPage = medicareInfoPage.navigate_to_Preliminary_Questions_page();
		if (prelimineryQuestionsPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE,prelimineryQuestionsPage);
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"false");
			System.out.println("OLE Preliminary Questions Page is Displayed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"false");


			Assertion.assertTrue(true);
		} else {
			boolean Validation_Status = medicareInfoPage.validate_alreadyEnrolled_ErrorMessage();
			if(Validation_Status){
				System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medicareInfoPage);
				getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
				Assertion.assertTrue(true);

			}
			else{
				System.out.println("Already Enrolled Error message is NOT Displayed in OLE Medicare Information PAGE : "+Validation_Status);
				Assertion.fail("Already Enrolled Error message is NOT Displayed in OLE Medicare Information PAGE : "+Validation_Status);
			}

		}
	}

	@Then("^the user navigates to Diabetic Preliminary Questions Page$")
	public void the_user_navigates_to_Preliminary_Diabetic_Questions_Page() throws Throwable {
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		PrelimineryQuestionsPage prelimineryQuestionsPage = medicareInfoPage.navigate_to_Preliminary_Diabetes_Questions_page();
		if (prelimineryQuestionsPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE,
					prelimineryQuestionsPage);
			System.out.println("OLE Preliminary Questions Page is Displayed");
			Assertion.assertTrue(true);
		}

	}

	@Then("^the user validates requierd fields for Preliminary Questions Pages$")
	public void the_user_validates_requierd_fields_for_Preliminary_Questions_Pages(DataTable Flags) throws Throwable {

		Map<String, String> PreliminaryFlagsMap = new HashMap<String, String>();
		PreliminaryFlagsMap = DataTableParser.readDataTableAsMaps(Flags);
	

		String MedicaidNumber = PreliminaryFlagsMap.get("MedicaidNumber");
		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		String plantype = PreliminaryFlagsMap.get("plan_type");

		PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
		boolean Validation_Status = prelimineryQuestionsPage.validate_Required_Fields(PlanType, MedicaidNumber);
		if(Validation_Status){
			System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Passed : "+Validation_Status);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE, prelimineryQuestionsPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println(
					"Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Failed : "
							+ Validation_Status);
			Assertion.fail();
		}

	}
/*<<<<<<<<<<<---------------------ESRD Question------------------------->>>>>>>>>>
	@Then("^the user validates requierd ESRD on Medicare Info Page$")
	public void the_user_validates_requierd_fields_for_Preliminary_Questions_Page(DataTable Flags) throws Throwable {

		Map<String, String> PreliminaryFlagsMap = new HashMap<String, String>();
		PreliminaryFlagsMap = DataTableParser.readDataTableAsMaps(Flags);
		String MedicaidNumber = PreliminaryFlagsMap.get("MedicaidNumber");
		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
		// String planyear = (String)getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String planYear = PreliminaryFlagsMap.get("Plan Year");

		MedicareInformationPage medInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean Validation_Status = medInfoPage.validate_Required_Fields(PlanType, MedicaidNumber,planName,planYear);
		if(Validation_Status){
			System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Passed : "+Validation_Status);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medInfoPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println(
					"Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Failed : "
							+ Validation_Status);
			Assertion.fail();
		}
		// }
	}
<<<<<<<<<<<---------------------ESRD Question------------------------->>>>>>>>>>*/
	@Then("^the user validates Medicare Number and not required ESRD question on Medicare Info Page$")
	public void the_user_validates_not_requierd_fields_for_ESRD_Medicare_Questions_Page(DataTable Flags) throws Throwable {

		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(Flags);
		
		String medicaidNumber = MedicareDetailsMap.get("MedicaidNumber");
		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
		//String planyear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		//String planYear = MedicareDetailsMap.get("Plan Year");
		String planYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);

		MedicareInformationPage medInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean Validation_Status = medInfoPage.validate_notRequired_ESRD_Fields(PlanType, medicaidNumber,planName,planYear);
		if(Validation_Status){
			System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Passed : "+Validation_Status);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medInfoPage);
			//getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER,  MedicaidNumber);
			getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER,medicaidNumber);
			getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR,planYear);
			System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Passed : "+medicaidNumber);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("Preliminary Questions Validation for required fields in OLE Preliminary Questions PAGE - Validation Failed : "+Validation_Status);
			Assertion.fail();
		}
		// }
	}

	@Then("^the user enters provider details in Use and Disclosure Authorization page for CSNP and navidates to Personal information page$")
	public void user_navigates_to_use_and_disclosure_page(DataTable planAttributes) throws Throwable {
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String diclsoureCheckbox="true";
		//	String diclsourestate ="AK";

		UseAndDisclosureAuthorizationPage useranddisclosure = (UseAndDisclosureAuthorizationPage) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_User_And_Disclosure_PAGE);
		getLoginScenario().saveBean(OLE_PageConstants.PROVIDER_NAME, MedicareDetailsMap.get("Provider Name"));
		getLoginScenario().saveBean(OLE_PageConstants.PROVIDER_ADDRESS, MedicareDetailsMap.get("Provider Street Address"));
		getLoginScenario().saveBean(OLE_PageConstants.CITY, MedicareDetailsMap.get("City"));
		getLoginScenario().saveBean(OLE_PageConstants.ZIP, MedicareDetailsMap.get("Zip"));
		getLoginScenario().saveBean(OLE_PageConstants.PROVIDER_NUMBER, MedicareDetailsMap.get("Provider Phone Number"));

		/*	PersonalInformationPage personalInformationPage = useranddisclosure.Validate_and_Enter_Details_for_YourProvide_Section( MedicareDetailsMap);
		getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
				personalInformationPage);*/

		SpecialElectionPeriodPage specialElectionPeriodPage = useranddisclosure.Validate_and_Enter_Details_for_YourProvide_Section( MedicareDetailsMap);
		getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
				specialElectionPeriodPage);

		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_CHECKBOX, diclsoureCheckbox);
		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_NAME, MedicareDetailsMap.get("Provider Name"));
		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_STREET_ADDRESS, MedicareDetailsMap.get("Provider Street Address"));
		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_CITY, MedicareDetailsMap.get("City"));
		//getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_STATE, diclsourestate);
		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_ZIP, MedicareDetailsMap.get("Zip"));
		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_PHONENUMBER, MedicareDetailsMap.get("Provider Phone Number"));
		getLoginScenario().saveBean(oleCommonConstants.DISCLOSURE_PROVIDER_STATE, MedicareDetailsMap.get("Mailing_State"));
	}

	/**
	 * @toDo:user fill following information in Preliminary Questions Page
	 */
	@And("^the user fills following information in Preliminary Questions page$")
	public void user_fill_information_Preliminary_Questions_page(DataTable personalAttributes) {
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		personalAttributesMap = DataTableParser.readDataTableAsMaps(personalAttributes);
		
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assertion.assertTrue(true);
		}
		else{
			String medicaidnumber = personalAttributesMap.get("MedicaidNumber");
			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			prelimineryQuestionsPage.entersPrelimQuesInformation(medicaidnumber);

			if (prelimineryQuestionsPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE,
						prelimineryQuestionsPage);
				System.out.println("OLE Preliminary Questions Page is Displayed : Medicaid Number is entered");
				Assertion.assertTrue(true);
			}
			else
				Assertion.fail("OLE Preliminary Questions Page is NOT Displayed");
		}
	}

	@Then("^the user validates the Plan details in Preliminary Questions Pag OLE Right Rail$")
	public void the_user_validates_the_Plan_details_in_Preliminary_Questions_Pag_OLE_Right_Rail() throws Throwable {
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assertion.assertTrue(true);
		}
		else{
			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			Map<String, String> PlanDetailsMap = new HashMap<String, String>();
			PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
			PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
			PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
			PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
			PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

			boolean Validation_Status = prelimineryQuestionsPage.validate_plan_details(PlanDetailsMap);
			if(Validation_Status){
				System.out.println("Plan Details Validation in OLE Premliminary Questions PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE, prelimineryQuestionsPage);
				Assertion.assertTrue(true);
			}
			else{
				System.out.println("Plan Details Validation in OLE Premliminary Questions PAGE : "+Validation_Status);
				Assertion.fail();
			}
		}
	}

	@Then("^the user validates TFN in Right Rail on Preliminary Questions Page$")
	public void the_user_validates_TFN_in_Right_Rail_Prelim_Questions_page() throws Throwable {
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assertion.assertTrue(true);
		}
		else{

			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
			boolean Validation_Status = prelimineryQuestionsPage.ValidateTFNMedicareInfo(TFN);
			if(Validation_Status){
				System.out.println("TFN, Wunderman Validation in OLE Preliminary Questions PAGE : "+Validation_Status+" - Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE, prelimineryQuestionsPage);
				Assertion.assertTrue(true);
			}
			else{
				System.out.println("TFN, Wunderman Validation in OLE Preliminary Questions PAGE : "+Validation_Status);
				Assertion.fail();
			}
		}
	}

	@Then("^the user validates Leave OLE modal for Preliminary Questions Page$")
	public void the_user_validates_Leave_OLE_modal_for_Preliminary_Questions_Page() throws Throwable {
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assertion.assertTrue(true);
		}
		else{
			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			LeavingOLEmodal leaveOLEmodal = prelimineryQuestionsPage.OpenLeaveOLEmodal();
			if (leaveOLEmodal != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_LEAVING_MODAL_PAGE,
						leaveOLEmodal);
				System.out.println("Leave OLE modal - Back to OLE ");
			}
			else
				Assertion.fail("Leave OLE Modal is NOT Displayed");

			prelimineryQuestionsPage = (PrelimineryQuestionsPage) leaveOLEmodal.returntoOLE();
			if (prelimineryQuestionsPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE,
						prelimineryQuestionsPage);
				System.out.println("Back to OLE Application page - OLE Preliminary Questions Page is Displayed");
			}
			else
				Assertion.fail("Back to OLE Application page - OLE Preliminary Questions Page is NOT Displayed");
		}

	}

	@Then("^the user validates Learn more modal for Preliminary Questions Page$")
	public void the_user_validates_Learn_more_modal_for_Preliminary_Questions_Page() throws Throwable {
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assertion.assertTrue(true);
		} else {

			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			LearnMoreModal learnMoremodal = prelimineryQuestionsPage.OpenLearnMore();
			if (learnMoremodal != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
						learnMoremodal);
				System.out.println("OLE Learn More Modal is Displayed");
			} else
				Assertion.fail("OLE Learn More Modal is NOT Displayed");
			prelimineryQuestionsPage = (PrelimineryQuestionsPage) learnMoremodal.returntoOLE();
			if (prelimineryQuestionsPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE,
						prelimineryQuestionsPage);
				System.out.println("Back to OLE Application page - OLE Preliminary Questions Page is Displayed");
			} else
				Assertion.fail("Back to OLE Application page -OLE Preliminary Questions Page is NOT Displayed");
		}
	}

	@Then("^the user validates cancellation modal for Preliminary Questions Page$")
	public void the_user_validates_cancellation_modal_for_Preliminary_Questions_Page() throws Throwable {
		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
		boolean alreadyEnrolled_Flag = (alreadyEnrolled.contentEquals("true"))?true:false;
		if(alreadyEnrolled_Flag){
			System.out.println("Already Enrolled Error message is Displayed in OLE Medicare Information  PAGE : "+alreadyEnrolled+"  :  "+alreadyEnrolled_Flag+" - Validation Passed");
			getLoginScenario().saveBean(oleCommonConstants.ALREADY_ENROLLED_FLAG,"true");
			Assertion.assertTrue(true);
		}
		else{
			PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
			CancelOLEModal cancelOLEmodal = prelimineryQuestionsPage.OpenCancelOLE();
			if (cancelOLEmodal != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
						cancelOLEmodal);
				System.out.println("OLE Cancellation Modal is Displayed");
			} else
				Assertion.fail("OLE Cancellation Modal is NOT Displayed");

			prelimineryQuestionsPage = (PrelimineryQuestionsPage) cancelOLEmodal.returntoOLE();
			if (prelimineryQuestionsPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE,
						prelimineryQuestionsPage);
				System.out.println("Back to OLE Application page - OLE Preliminary Questions Page is Displayed");
			} else
				Assertion.fail("Back to OLE Application page - OLE Preliminary Questions Page is NOT Displayed");

		}
	}

	@Then("^the user navigates to Personal Information Page$")
	public void the_user_navigates_to_Personal_Information_Page() throws Throwable {
		//scenario.log("Sai - Change made 06/15 - navigate to personal information OLE Page");

		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		PersonalInformationPage personalInformationPage = welcomePage.navigate_to_Personal_Information_page();

		if (personalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("OLE Personal Information Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Personal Information Page is NOT Displayed");
		// }
	}

	@Then("^the user navigates to Use and Disclosure Page$")
	public void the_user_navigates_to_Use_and_Disclosure_page() throws Throwable {

		PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
		PersonalInformationPage personalInformationPage = prelimineryQuestionsPage.Validate_use_and_disclosure_page();

		if (personalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("OLE Personal Information Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Personal Information Page is NOT Displayed");
	}

	@Then("^the user enters following required information in Personal Information Page$")
	public void the_user_enters_following_required_information_in_Personal_Information_Page(DataTable arg1)
			throws Throwable {
		scenario.log("Sai - Change made 06/15 - Validate to personal information OLE Page from 1 to 4 --Aug Release");
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		

	//	String Perm_Aptno = "155";
	//	String Mailing_Aptno = "166";
	//	String Middle_Name="";

		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		boolean isFormFilled = personalInformationPage.enter_member_details(MemberDetailsMap);
		if (isFormFilled) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("OLE Personal Information Page - All required Member Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.FIRST_NAME, MemberDetailsMap.get("First Name"));
			getLoginScenario().saveBean(oleCommonConstants.LAST_NAME, MemberDetailsMap.get("Last Name"));
			getLoginScenario().saveBean(oleCommonConstants.DOB, MemberDetailsMap.get("DOB"));
			getLoginScenario().saveBean(oleCommonConstants.GENDER, MemberDetailsMap.get("Gender"));
			getLoginScenario().saveBean(oleCommonConstants.PERM_STREET, MemberDetailsMap.get("Perm_Street"));
			getLoginScenario().saveBean(oleCommonConstants.PERM_APARTMENT_NUMBER,MemberDetailsMap.get("Perm_AptNo")); 
			getLoginScenario().saveBean(oleCommonConstants.PERM_CITY, MemberDetailsMap.get("Perm_city"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_QUESTION, MemberDetailsMap.get("Mailing Address Question"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_STREET, MemberDetailsMap.get("Mailing_Street"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_APARTMENT_NUMBER,MemberDetailsMap.get("Mailing_AptNo"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_CITY, MemberDetailsMap.get("Mailing_City"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_STATE, MemberDetailsMap.get("Mailing_State"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_ZIP, MemberDetailsMap.get("Mailing_Zip"));
			getLoginScenario().saveBean(oleCommonConstants.EMAIL, MemberDetailsMap.get("Email"));
			getLoginScenario().saveBean(oleCommonConstants.PRIMARY_PHONE_NUMBER, MemberDetailsMap.get("Home Number"));
			getLoginScenario().saveBean(oleCommonConstants.MOBILE_NUMBER, MemberDetailsMap.get("Mobile Number"));
			getLoginScenario().saveBean(oleCommonConstants.MIDDLE_NAME, MemberDetailsMap.get("Middle Name"));
			getLoginScenario().saveBean(oleCommonConstants.EMAIL_CONFIRMATION, MemberDetailsMap.get("Email Confirmation"));
			getLoginScenario().saveBean(oleCommonConstants.PAPERLESS_DELIVERY, MemberDetailsMap.get("Go Green"));
			getLoginScenario().saveBean(oleCommonConstants.Go_Green, MemberDetailsMap.get("Go Green"));
			//getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER, MemberDetailsMap.get("MedicaidNumber"));			
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Personal Information Page - Adding Member Details Failed");
		// }
	}

	/*@Then("^the user enters following information in Personal Information Page$")
	public void the_user_enters_following__information_in_Personal_Information_Page(DataTable arg1) throws Throwable {

		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		boolean isFormFilled = personalInformationPage.enter_member_details_Other(MemberDetailsMap);
		if (isFormFilled) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("OLE Personal Information Page - All required Member Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.EMAIL, MemberDetailsMap.get("Email"));
			getLoginScenario().saveBean(oleCommonConstants.PRIMARY_PHONE_NUMBER, MemberDetailsMap.get("Home Number"));
			getLoginScenario().saveBean(oleCommonConstants.MOBILE_NUMBER, MemberDetailsMap.get("Mobile Number"));
			getLoginScenario().saveBean(oleCommonConstants.MIDDLE_NAME, MemberDetailsMap.get("Middle Name"));
			getLoginScenario().saveBean(oleCommonConstants.EMAIL_CONFIRMATION, MemberDetailsMap.get("Email Confirmation"));
			getLoginScenario().saveBean(oleCommonConstants.Go_Green, MemberDetailsMap.get("Go Green"));

			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Personal Information Page - Adding Member Details Failed");
		// }
	}
*/
	@Then("^the user enters following information in Personal Information Page SNP Plans$")
	public void the_user_enters_following__information_in_Personal_Information_Page_SNP_plans(DataTable arg1)
			throws Throwable {
		scenario.log("Sai - Change made 06/15 - Validate to personal information OLE Page from 1 to 4 --Aug Release");
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		boolean isFormFilled = personalInformationPage.enter_member_details_SNP_Plans(MemberDetailsMap);
		if (isFormFilled) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("OLE Personal Information Page - All required Member Details are entered for SNP Plans");
			getLoginScenario().saveBean(oleCommonConstants.FIRST_NAME, MemberDetailsMap.get("First Name"));
			getLoginScenario().saveBean(oleCommonConstants.LAST_NAME, MemberDetailsMap.get("Last Name"));
			getLoginScenario().saveBean(oleCommonConstants.DOB, MemberDetailsMap.get("DOB"));
			getLoginScenario().saveBean(oleCommonConstants.GENDER, MemberDetailsMap.get("Gender"));
			getLoginScenario().saveBean(oleCommonConstants.PERM_STREET, MemberDetailsMap.get("Perm_Street"));
			getLoginScenario().saveBean(oleCommonConstants.PERM_APARTMENT_NUMBER,MemberDetailsMap.get("Perm_AptNo")); 
			getLoginScenario().saveBean(oleCommonConstants.PERM_CITY, MemberDetailsMap.get("Perm_city"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_QUESTION, MemberDetailsMap.get("Mailing Address Question"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_STREET, MemberDetailsMap.get("Mailing_Street"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_APARTMENT_NUMBER,MemberDetailsMap.get("Mailing_AptNo"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_CITY, MemberDetailsMap.get("Mailing_City"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_STATE, MemberDetailsMap.get("Mailing_State"));
			getLoginScenario().saveBean(oleCommonConstants.MAILING_ZIP, MemberDetailsMap.get("Mailing_Zip"));
			getLoginScenario().saveBean(oleCommonConstants.EMAIL, MemberDetailsMap.get("Email"));
			getLoginScenario().saveBean(oleCommonConstants.PRIMARY_PHONE_NUMBER, MemberDetailsMap.get("Home Number"));
			getLoginScenario().saveBean(oleCommonConstants.MOBILE_NUMBER, MemberDetailsMap.get("Mobile Number"));
			getLoginScenario().saveBean(oleCommonConstants.MIDDLE_NAME, MemberDetailsMap.get("Middle Name"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Personal Information Page - Adding Member Details Failed for SNP Plans");
	
	}

	@Then("^the user validates the Plan details in Personal Information Page OLE Right Rail$")
	public void the_user_validates_the_Plan_details_in_Personal_Information_Page_OLE_Right_Rail() throws Throwable {
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

		boolean Validation_Status = personalInformationPage.validate_plan_details(PlanDetailsMap);
		if(Validation_Status){
			System.out.println("Plan Details Validation in OLE Personal Information PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE, personalInformationPage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("Plan Details Validation in OLE Personal Information PAGE : "+Validation_Status);
			Assertion.fail();
		}
	
	}

	@Then("^the user validates the Member details dynamic display in Personal Information Page$")
	public void the_user_validates_the_Member_details_in_Personal_Information_Page_OLE_Right_Rail() throws Throwable {
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap.put("First Name", (String) getLoginScenario().getBean(oleCommonConstants.FIRST_NAME));
		MemberDetailsMap.put("Last Name", (String) getLoginScenario().getBean(oleCommonConstants.LAST_NAME));
		MemberDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		MemberDetailsMap.put("Mailing_State", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STATE));
		boolean Validation_Status = personalInformationPage.validate_member_details(MemberDetailsMap);
		if (Validation_Status) {
			System.out.println("Member Details Validation in OLE Personal Information PAGE : - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE, personalInformationPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Member Details Validation in OLE Personal Information PAGE : - Validation Failed");
			Assertion.fail();
		}
		// }
	}

	@Then("^the user validates TFN in Right Rail on Personal Information Page$")
	public void the_user_validates_TFN_in_Right_Rail_on_Personal_Information_Page() throws Throwable {		String alreadyEnrolled = (String) getLoginScenario().getBean(oleCommonConstants.ALREADY_ENROLLED_FLAG);
	
	PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
	String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
	boolean Validation_Status = personalInformationPage.ValidateTFNMedicareInfo(TFN);
	if(Validation_Status){
		System.out.println("TFN, Wunderman Validation in OLE Personal Information PAGE : "+Validation_Status+" - Validation Passed");
		getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE, personalInformationPage);
		Assertion.assertTrue(true);
	} else {
		System.out.println("TFN, Wunderman Validation in OLE Personal Information PAGE : " + Validation_Status);
		Assertion.fail();
	}
	// }
	}

	@Then("^the user validates Leave OLE modal for Personal Information Page$")
	public void the_user_validates_Leave_OLE_modal_for_Personal_Information_Page() throws Throwable {
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		LeavingOLEmodal leaveOLEmodal = personalInformationPage.OpenLeaveOLEmodal();
		if (leaveOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEAVING_MODAL_PAGE,
					leaveOLEmodal);
			System.out.println("Leave OLE modal - Back to OLE ");
		} else
			Assertion.fail("Leave OLE Modal is NOT Displayed");

		personalInformationPage = (PersonalInformationPage) leaveOLEmodal.returntoOLE();
		if (personalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("Back to OLE Application page - OLE Personal Information Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - OLE Personal Information Page is NOT Displayed");
		// }
	}

	@Then("^the user validates Learn more modal for Personal Information Page$")
	public void the_user_validates_Learn_more_modal_for_Personal_Information_Page() throws Throwable {
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		LearnMoreModal learnMoremodal = personalInformationPage.OpenLearnMore();
		if (learnMoremodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					learnMoremodal);
			System.out.println("OLE Learn More Modal is Displayed");
		} else
			Assertion.fail("OLE Learn More Modal is NOT Displayed");
		personalInformationPage = (PersonalInformationPage) learnMoremodal.returntoOLE();
		if (personalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("Back to OLE Application page - OLE Personal Information Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page -OLE Personal Information Page is NOT Displayed");
		// }
	}

	@Then("^the user validates cancellation modal for Personal Information Page$")
	public void the_user_validates_cancellation_modal_for_Personal_Information_Page() throws Throwable {
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);

		CancelOLEModal cancelOLEmodal = personalInformationPage.OpenCancelOLE();
		if (cancelOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
		} else
			Assertion.fail("OLE Cancellation Modal is NOT Displayed");

		personalInformationPage = (PersonalInformationPage) cancelOLEmodal.returntoOLE();
		if (personalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("Back to OLE Application page - OLE Personal Information Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - OLE Personal Information Page is NOT Displayed");
		// }
	}

	@Then("^the user navigates to Confirm your Eligibility Page$")
	public void the_user_navigates_to_Confirm_your_Eligibility_Page(DataTable Medicareoptions) throws Throwable {
		
		scenario.log("Sai - Change made 06/17 - Validate Confirm your eligibility Page");

		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(Medicareoptions);
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		ConfirmYourEligibilityPage confirmYourEligibilityPage = personalInformationPage.navigate_to_ConfirmYourEligibility_page(MedicareDetailsMap);
		if (confirmYourEligibilityPage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRM_YOUR_ELIGIBILITY_PAGE,
					confirmYourEligibilityPage);
			System.out.println("OLE Confirm your Eligibility Page is Displayed");

			getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER, MedicareDetailsMap.get("MedicaidNumber"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Confirm your Eligibility Page is NOT Displayed");
	}

	@Then("^the user validates the Plan details in SEP Page OLE Right Rail$")
	public void the_user_validates_the_Plan_details_in_SEP_Page_OLE_Right_Rail() throws Throwable {
		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);

		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

		boolean Validation_Status = specialElectionPeriodPage.validate_plan_details(PlanDetailsMap);
		if(Validation_Status){
			System.out.println("Plan Details Validation in OLE SEP PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE, specialElectionPeriodPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Plan Details Validation in OLE SEP PAGE : " + Validation_Status);
			Assertion.fail();
		}
		// }
	}

	@Then("^the user validates TFN in Right Rail on SEP Page$")
	public void the_user_validates_TFN_in_Right_Rail_on_SEP_Page() throws Throwable {
		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
		boolean Validation_Status = specialElectionPeriodPage.ValidateTFNMedicareInfo(TFN);
		if(Validation_Status){
			System.out.println("TFN, Wunderman Validation in OLE SEP PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE, specialElectionPeriodPage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("TFN, Wunderman Validation in OLE SEP PAGE : "+Validation_Status);
			Assertion.fail();
		}
		// }
	}

	@Then("^the user validates Leave OLE modal for SEP Page$")
	public void the_user_validates_Leave_OLE_modal_for_SEP_Page() throws Throwable {
		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		LeavingOLEmodal leaveOLEmodal = specialElectionPeriodPage.OpenLeaveOLEmodal();
		if (leaveOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEAVING_MODAL_PAGE,
					leaveOLEmodal);
			System.out.println("Leave OLE modal - Back to OLE ");
		} else
			Assertion.fail("Leave OLE Modal is NOT Displayed");

		specialElectionPeriodPage = (SpecialElectionPeriodPage) leaveOLEmodal.returntoOLE();
		if (specialElectionPeriodPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);
			System.out.println("Back to OLE Application page - OLE SEP Page is Displayed");
		}
		else
			Assertion.fail("Back to OLE Application page - OLE SEP Page is NOT Displayed");
		// }
	}

	@Then("^the user validates Learn more modal for SEP Page$")
	public void the_user_validates_Learn_more_modal_for_SEP_Page() throws Throwable {
		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		LearnMoreModal learnMoremodal = specialElectionPeriodPage.OpenLearnMore();
		if (learnMoremodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					learnMoremodal);
			System.out.println("OLE Learn More Modal is Displayed");
		}
		else
			Assertion.fail("OLE Learn More Modal is NOT Displayed");

		specialElectionPeriodPage = (SpecialElectionPeriodPage) learnMoremodal.returntoOLE();
		if (specialElectionPeriodPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);
			System.out.println("Back to OLE Application page - OLE SEP Page is Displayed");
		}
		else
			Assertion.fail("Back to OLE Application page -OLE SEP Page is NOT Displayed");
		// }
	}

	@Then("^the user validates cancellation modal for SEP Page$")
	public void the_user_validates_cancellation_modal_for_SEP_Page() throws Throwable {

		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);

		CancelOLEModal cancelOLEmodal = specialElectionPeriodPage.OpenCancelOLE();
		if (cancelOLEmodal != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
		}
		else
			Assertion.fail("OLE Cancellation Modal is NOT Displayed");
		specialElectionPeriodPage = (SpecialElectionPeriodPage) cancelOLEmodal.returntoOLE();
		if (specialElectionPeriodPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);
			System.out.println("Back to OLE Application page - OLE SEP Page is Displayed");
		} else
			Assertion.fail("Back to OLE Application page - OLE SEP Page is NOT Displayed");

		// }
	}
	
	@Then("^the user navigates to SEP Page$")
	public void the_user_navigates_to_SEP_Page() {
		
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		SpecialElectionPeriodPage specialElectionPeriodPage = personalInformationPage.validate_SEPPage();
			if (specialElectionPeriodPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,specialElectionPeriodPage);
				System.out.println("OLE SEP Page is Displayed");
			} else
				Assertion.fail("Back to OLE Application page - OLE SEP Page is NOT Displayed");
		}
	
	@Then("^the user validates SEP options and Required Fields for PlanType in SEP Page$")
	public void the_user_validates_SEP_options_and_Required_Fields_for_PlanType_in_SEP_Page() throws Throwable {
		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		boolean Validation_Status = specialElectionPeriodPage.validate_SEPoptions_for_planType(PlanType);
		if(Validation_Status){
			System.out.println("Plan Type Options Validation in OLE SEP PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE, specialElectionPeriodPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Plan Type Options in OLE SEP PAGE : " + Validation_Status);
			Assertion.fail();
		}
	}

	@Then("^the user selects the following options for SEP Page$")
	public void the_user_selects_the_following_options_for_SEP_Page(DataTable SEPoptions) throws Throwable {
		
		scenario.log("Sai - Change made 06/17 - Validate SEP on OLE Page");

		Map<String, String> SEPoptionsFlagMap = new HashMap<String, String>();
		SEPoptionsFlagMap = DataTableParser.readDataTableAsMaps(SEPoptions);
		
		String Selectoptions = SEPoptionsFlagMap.get("Select Options");
		String optionsData = SEPoptionsFlagMap.get("Option Data");
		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		specialElectionPeriodPage = specialElectionPeriodPage.select_option_and_enter_data(Selectoptions, optionsData, PlanType);
		if (specialElectionPeriodPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);
			System.out.println("OLE SEP page Options Selected : Next Button enabled");
		} else
			Assertion.fail("OLE SEP page Options NOT Selected : Next Button NOT enabled");

		// }
	}

	/*@Then("^the user navigates to Coverage and Health Information Page$")
	public void the_user_navigates_to_Coverage_and_Health_Information_Page() throws Throwable {
		
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		CoverageInformationPage coverageInformationPage = specialElectionPeriodPage.navigate_to_Coverage_Information_page();
		if (coverageInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_COVERAGE_INFO_PAGE,
					coverageInformationPage);
			System.out.println("OLE Coverage and Health Information Page is Displayed");
		} else
			Assertion.fail("OLE Coverage and Health Information Page is NOT Displayed");
		// }
	}*/

	@Then("^the user validates the dispalyed sections for the Plan Type in Medicare Information Page$")
	public void the_user_validates_the_dispalyed_sections_for_the_Plan_Type_in_Coverage_and_Health_Information_Page() throws Throwable {
		
		MedicareInformationPage medInformationPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		boolean Validation_Status = medInformationPage.validate_CoverageInfo_Questions_for_planType(PlanType);
		if(Validation_Status){
			System.out.println("Plan Type Questions Validation in OLE Coverage and Health PAGE : Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medInformationPage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("Plan Type Questions Validation in OLE Coverage and Health PAGE : Validation Failed");
			Assertion.fail();
		}
		// }
	}

	@Then("^the user answers following questions in Medicare Information Page$")
	public void the_user_answers_following_questions_in_Coverage_and_Health_Information_Page(DataTable arg1) throws Throwable {
		
		Map<String, String> QuestionMap = new HashMap<String, String>();
		QuestionMap = DataTableParser.readDataTableAsMaps(arg1);
		
		String PDPquestionFlag = QuestionMap.get("PDP Question");
		String LongTermQuestionFlag = QuestionMap.get("LongTerm Question");

		MedicareInformationPage medInformationPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean areQuestionsAnswered = medInformationPage.answer_following_questions(QuestionMap);
		if (areQuestionsAnswered) {
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_DRUG, PDPquestionFlag);
			getLoginScenario().saveBean(oleCommonConstants.HEALTH_INSURANCE, LongTermQuestionFlag);
			System.out.println("Coverage and Health Information Page : Data entered");
		}
		else
			Assertion.fail("Coverage and Health Information Page : Data entry FAILED");
		// }

	}

	@Then("^the user navigates to Proposed Effective Date Page$")
	public void the_user_navigates_to_Proposed_Effective_Date_Page() throws Throwable {

		SpecialElectionPeriodPage sepPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		ProposedEffectiveDatePage proposedEffectiveDatePage = sepPage.navigate_to_Proposed_Effective_Date_Page();
		if (proposedEffectiveDatePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE,
					proposedEffectiveDatePage);
			System.out.println("OLE Proposed Effective Date Page is Displayed");
		} else
			Assertion.fail("OLE Proposed Effective Date Page is NOT Displayed");
		// }
	}

	@Then("^the user validates Proposed Effective Date is Displayed$")
	public void the_user_validates_proposed_effective_date_display() throws Throwable {
		ProposedEffectiveDatePage proposedEffectiveDatePage  = (ProposedEffectiveDatePage) getLoginScenario().getBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE);

		boolean Validation_Status = proposedEffectiveDatePage.validate_proposed_effective_date_options();
		if(Validation_Status){
			System.out.println("Proposed Effective Date display : Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE, proposedEffectiveDatePage);
			String proposedEffectiveDate = proposedEffectiveDatePage.get_proposed_effective_date();
			getLoginScenario().saveBean(oleCommonConstants.PROPOSED_EFF_DATE, proposedEffectiveDate);

			Assertion.assertTrue(true);
		} else {
			System.out.println("Proposed Effective Date display : Validation Failed");
			Assertion.fail();
		}
		// }
	}

	@Then("^the user navigates to PCP Page and validates PCP page is not displayed for PDP$")
	public void the_user_navigates_to_PCP_Page() throws Throwable {
		
		ProposedEffectiveDatePage proposedEffectiveDatePage = (ProposedEffectiveDatePage) getLoginScenario().getBean(OLE_PageConstants.OLE_PROPOSED_EFF_DATE_PAGE);
		String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		if(planType.contentEquals("PDP")){
			PlanPremiumPage  planPremiumPage = (PlanPremiumPage) proposedEffectiveDatePage.navigate_to_PCP_Page(planType);
			if (planPremiumPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE,
						planPremiumPage);
				System.out.println("PCP Page is not Displayed : OLE Monthly Plan Premium Page is Displayed for Plantype : "+planType);
			}
			else
				Assertion.fail("OLE Monthly Plan Premium Page is NOT Displayed for Plantype : "+planType);
		}
		else{
			PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) proposedEffectiveDatePage.navigate_to_PCP_Page(planType);
			if (pcpPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE,
						pcpPage);
				System.out.println("OLE PCP Page is Displayed for Plantype : "+planType);
			}
			else
				Assertion.fail("OLE PCP Page is NOT Displayed for Plantype : "+planType);
		}
		// }
	}

	@Then("^the user validates PCP page for MA and MAPD PFFS plans$")
	public void the_user_validates_PCP_page_for_MD_and_MAPD_PFFS_plans() throws Throwable {
	
		PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);
		String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		String planName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
		if(!planType.contentEquals("PDP") && planName.contains("PFFS") && !MRScenario.environment.contains("stage-0")){
			System.out.println("Validating Provider Contact Information for PFFS plans");
			boolean Validation_Status = pcpPage.validate_provider_contact_info_in_PCP();
			if(Validation_Status){
				System.out.println("PFFS plan Provider Contact Information Section : Validation Passed");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE,
						pcpPage);
				Assertion.assertTrue(true);
			}
			else{
				System.out.println("PFFS plan Provider Contact Information Section : Validation Failed");
				Assertion.fail();
			}
		}
		// }
	}

	@Then("^the user validates Look up Provider for MA MAPD and DSNP plans\\.$")
	public void the_user_validates_Look_up_Provider_for_MA_MAPD_and_DSNP_plans() throws Throwable {
		
		String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);
		String planName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
		if(!planType.contentEquals("PDP") && !planName.contains("PFFS")
				//Amey: Adding the environment logic since gate is failing because of a Rally issue.
				// An incident is logged with the external Rally team. Remove this condition once fixed.
				&& !MRScenario.environment.contains("mnr-acq-ci")&& !MRScenario.environment.contains("stage-0")){
			System.out.println("Validating Provider Look Up Provider for MA, MAPD, DSNP non-PFFS plans");
			boolean Validation_Status = pcpPage.validate_provider_Lookup(planType);
			if(Validation_Status){
				System.out.println("Provider Look Up : Validation Passed for PlanType - "+planType);
				getLoginScenario().saveBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE,
						pcpPage);
				ArrayList<String> pcp_Info = pcpPage.getPCPInfo() ;
				getLoginScenario().saveBean(oleCommonConstants.PCP_NAME,pcp_Info.get(0));
				getLoginScenario().saveBean(oleCommonConstants.PCP_NUMBER,pcp_Info.get(1));
				getLoginScenario().saveBean(oleCommonConstants.PCP_RECENTLY_VISITED,pcp_Info.get(2));
				Assertion.assertTrue(true);
			}
			else{
				System.out.println("Provider Look Up : Validation FAILED for PlanType - "+planType);
				Assertion.fail();
			}
		}
		// }
		// Write code here that turns the phrase above into concrete actions
	}

	@Then("^the user navigates to Monthly Plan Premium Page$")
	public void the_user_navigates_to_Monthly_Plan_Premium_Page() throws Throwable {
		
		String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);

		if(!planType.contentEquals("PDP")){
			PlanPremiumPage  planPremiumPage = (PlanPremiumPage) pcpPage.navigate_to_Plan_Premium_Page();
			if (planPremiumPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE,
						planPremiumPage);
				System.out.println("PCP Page is not Displayed : OLE Monthly Plan Premium Page is Displayed for Plantype : "+planType);
			}
			else
				Assertion.fail("OLE Monthly Plan Premium Page is NOT Displayed for Plantype : "+planType);

		}
	}

	@Then("^the user navigates to Optional Benefits Page for following plans with available Riders$")
	public void the_user_navigates_to_optional_rider_Page(DataTable Flags) {
		

		Map<String, String> RiderFlagMap = new HashMap<String, String>();
		RiderFlagMap = DataTableParser.readDataTableAsMaps(Flags);

		
		String RiderFlag = RiderFlagMap.get("Rider Flag");
		if(RiderFlag.contains("true")){
			PlanPremiumPage  planPremiumPage = (PlanPremiumPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE);
			SupplementalBenefitsPage ridersPage = planPremiumPage.navigate_to_Supplemental_Riders_Page();
			if (ridersPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_SUPPLEMENTAL_BENEFITS_PAGE,
						ridersPage);
				System.out.println("OLE Supplemental Benefits page is Displayed");
			} else
				Assertion.fail("OLE Supplemental Benefits page is NOT Displayed");

		}
		// }
	}

	@Then("^the user navigates to Authorization Page$")
	public void the_user_navigates_to_authorization() {
		
		scenario.log("Sai - Change made 07/27- Navigate to Authorization page--Aug Release");
		
			PlanPremiumPage  planPremiumPage = (PlanPremiumPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE);
			AuthorizationPage authorizationPage = planPremiumPage.navigate_to_Authorization_Page();
			if (authorizationPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE,
						authorizationPage);
				System.out.println("OLE Authorization page is Displayed for Plan without Rider");
			} else
				Assertion.fail("OLE Authorization page is NOT Displayed for Plan without Rider");
		}
		

	@Then("^the user validates required fields for Authorization Page$")
	public void the_user_validates_required_fields_for_Authorization_Page() throws Throwable {
		
		AuthorizationPage authorizationPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
		boolean Validation_Status = authorizationPage.validate_required_field();
		if(Validation_Status){
			System.out.println("Authorization Page : Required fields Validated, Required data entered");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE,
					authorizationPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Authorization Page : Required fields NOT validated");
			Assertion.fail("Authorization Page : Required fields NOT validated");
		}
		// }
	}

	@Then("^the user validates required fields for Authorization Page Representative$")
	public void the_user_validates_required_fields_for_Authorization_Page_Representative(DataTable arg1) throws Throwable {
		
		scenario.log("Sai - Change made 07/27- Validate Authorization page--Aug Release");
		
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		AuthorizationPage authorizationPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
		boolean Validation_Status = authorizationPage.validate_required_field_representative(MemberDetailsMap);
		if(Validation_Status){
			getLoginScenario().saveBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE,
					authorizationPage);
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_FIRST_NAME, MemberDetailsMap.get("authorizationFirstname"));
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_LAST_NAME, MemberDetailsMap.get("authorizationLastname"));
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_ADDRESS, MemberDetailsMap.get("authorizationAddress"));

			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_APARTMENT_SUITE, MemberDetailsMap.get("authorizationApartmentSuite"));
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_CITY, MemberDetailsMap.get("authorizationCity"));

			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_ZIP, MemberDetailsMap.get("authorizationZip"));

			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_PHONE_NO, MemberDetailsMap.get("authorizationPhoneNo"));
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_STATE_DISPLAY, MemberDetailsMap.get("authorizationStateDisplay"));
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_RELATIONSHIP, MemberDetailsMap.get("authorizationRelationship"));

			//getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_AGREE, MemberDetailsMap.get("authorizationAgree"));

			Assertion.assertTrue(true);
		} else {
			System.out.println("Authorization Page : Required fields NOT validated");
			Assertion.fail("Authorization Page : Required fields NOT validated");
		}
		// }
	}

	@Then("^the user navigates to Review and Submit Page$")
	public void the_user_navigates_to_Review_and_Submit_Page() throws Throwable {
		
		AuthorizationPage authorizationPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
		ReviewSubmitPage reviewSubmitPage = authorizationPage.navigate_to_Review_Submit_Page();
		if (reviewSubmitPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE,
					reviewSubmitPage);
			System.out.println("OLE Review and Submit page is Displayed");
		} else
			Assertion.fail("OLE Review and Submit page is NOT Displayed");
		// }
	}


	@Then("^the user clicks on Submit Enrollment to complete enrollment$")
	public void the_user_clicks_on_Submit_Enrollment_to_complete_enrollment() throws Throwable {
		
		String ConfirmationNumber="";
		if (!(MRScenario.environment.equalsIgnoreCase("offline")
				|| MRScenario.environment.equalsIgnoreCase("prod"))) {
			ReviewSubmitPage reviewSubmitPage = (ReviewSubmitPage) getLoginScenario()
					.getBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE);
			OLEconfirmationPage oleConfirmationPage = reviewSubmitPage.submitEnrollment();
			if (oleConfirmationPage != null) {

				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, oleConfirmationPage);
				getLoginScenario().saveBean(OLE_PageConstants.CONFIRMATION_NUMBER,ConfirmationNumber);
				getLoginScenario().saveBean(oleCommonConstants.CONFIRMATION_NUMBER,ConfirmationNumber);

				System.out.println("OLE Confirmation Page is Displayed with Confirmation No" +ConfirmationNumber);
				scenario.log("OLE Confirmation Page is Displayed with Confirmation No" +ConfirmationNumber); 
			} else {
				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, oleConfirmationPage);
				getLoginScenario().saveBean(OLE_PageConstants.CONFIRMATION_NUMBER,ConfirmationNumber);
				getLoginScenario().saveBean(oleCommonConstants.CONFIRMATION_NUMBER,ConfirmationNumber);

				System.out.println("OLE Confirmation Page is NOT Displayed : OLE Submission Failed");				}
		} else {
			System.out.println("Skipping the submit functionality in Offline-Prod environment");
		}
		// }
	}

	@Then("^the user validates Plan and Member Details on Confirmation Page$")
	public void the_user_validates_Plan_and_Membber_Details_on_Confirmation_Page() throws Throwable {
		
		if (!(MRScenario.environment.equalsIgnoreCase("offline")
				|| MRScenario.environment.equalsIgnoreCase("prod"))) {
			OLEconfirmationPage oleConfirmationPage = (OLEconfirmationPage) getLoginScenario()
					.getBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE);
			if (oleConfirmationPage != null) {

				Map<String, String> DetailsMap = new HashMap<String, String>();
				DetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
				DetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
				DetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
				DetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
				DetailsMap.put("Plan Premium",
						(String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

				boolean Validation_Status = oleConfirmationPage.validate_plan_details(DetailsMap);
				if (Validation_Status) {
					System.out.println("OLE Confirmation Page : All Plan Details Validated");
					getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, oleConfirmationPage);
					Assertion.assertTrue(true);
				} else {
					System.out.println("Review and Submit Page : All Plan and Member Details  NOT validated");
					Assertion.fail("Review and Submit Page : All Plan and Member Details  NOT validated");
				}
			} else {
				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, oleConfirmationPage);
				System.out.println("OLE Confirmation Page is NOT Displayed : OLE Submission Failed");
				Assertion.fail("OLE Confirmation Page is NOT Displayed : OLE Submission Failed");
			}
		} else {
			System.out.println("Skipping the Confirmation functionality in Offline-Prod/Prod environment");
		}
		// }
	}

	@Then("^the user Validates Next Steps in Confirmation Page for the Plan Type\\.$")
	public void the_user_Validates_Next_Steps_in_Confirmation_Page_for_the_Plan_Type() throws Throwable {
		

		OLEconfirmationPage oleConfirmationPage = (OLEconfirmationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE);
		if (oleConfirmationPage != null) {

			String PlanType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);

			boolean Validation_Status = oleConfirmationPage.validate_nextSteps_for_Plantype(PlanType);
			if(Validation_Status){
				System.out.println("OLE Confirmation Page : Next Steps Validated");
				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE,
						oleConfirmationPage);
				Assertion.assertTrue(true);
			} else {
				System.out.println("Review and Submit Page : Next Steps  NOT validated");
				Assertion.fail();
			}
		}
		else{
			getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE,
					oleConfirmationPage);
			System.out.println("OLE Confirmation Page is NOT Displayed : Already Enrolled or Enrollment Failed due to Service error");
		}
		// }
	}

	@Then("^the user validates the presence for Preliminary Questions on Page$")
	public void the_user_validates_the_presence_for_Preliminary_Questions_on_Page(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		

		String planname = givenAttributesMap.get("Plan Name");
		PrelimineryQuestionsPage prelimineryQuestionsPage = (PrelimineryQuestionsPage) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_PRELIM_QUESTIONS_PAGE);
		prelimineryQuestionsPage.VerifyPreliminaryQuestions(planname);
	}

	@Then("^the user Validates Ancillary benfit widget for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_Validates_Ancillary_benfit_widget_for_and(String DentalFlag, String VisionFlag,
			String FitnesFlag, String HearingFlag) throws Throwable {

		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		if (planType.equals("PDP")) {
			System.out.println("Ancillary Benefits Widget is not availble for PDP plan");
		} else {
			welcomePage.validate_Ancillary_Benefits(DentalFlag, VisionFlag, FitnesFlag, HearingFlag);
		}

	}

	@Then("^user selects Optional Rider Benfits Dental \"([^\"]*)\"or fitness \"([^\"]*)\" Riders$")
	public void user_selects_Optional_Rider_Benfits_Dental_or_fitness_Riders(String Dentalrider, String FitnessRider)
			throws Throwable {
		SupplementalBenefitsPage ridersPage = (SupplementalBenefitsPage) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_SUPPLEMENTAL_BENEFITS_PAGE);
		ridersPage.select_riders(Dentalrider, FitnessRider);
		if (ridersPage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SUPPLEMENTAL_BENEFITS_PAGE, ridersPage);
		} else
			Assertion.fail("OLE Supplemental Benefits page is NOT Displayed");

	}

	@Then("^the user Validates Ancillary benfit widget for \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" for selected riders$")
	public void the_user_Validates_Ancillary_benfit_widget_for_and_for_selected_riders(String DentalRiderFlag, String VisionFlag,
			String FitnesRiderFlag, String HearingFlag) throws Throwable {

		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		String planType = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_TYPE);
		if (planType.equals("PDP")) {
			System.out.println("Ancillary Benefits Widget is not availble for PDP plan");
		} else {
			welcomePage.validate_Ancillary_Benefits(DentalRiderFlag, VisionFlag, FitnesRiderFlag, HearingFlag);
		}

	}

	/** user Lands on the OLe Testharness Page */
	@Given("^the user is on OLE TestHarness page$")
	public void validateUserIsOnOLETestharnessPage(DataTable inputAttributes) {
		Map<String, String> inputAttributesMap = parseInputArguments(inputAttributes);
		String siteName = inputAttributesMap.get("Site Name");
		String TestharnessPage = inputAttributesMap.get("TestHarnessPage");
		WebDriver wd = getLoginScenario().getWebDriverNew();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, siteName, TestharnessPage);
		String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
		getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
		OLETestHarnessPage oleTestHarnessPage = (OLETestHarnessPage) aquisitionhomepage.GetOLETestHarnessPage();
		getLoginScenario().saveBean(PageConstants.OLE_TESTHARNESS_PAGE, oleTestHarnessPage);

	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(memberAttributes);
		
		return memberAttributesMap;
	}

	@When("^the user navigates to OLE WelcomePage using following information$")
	public void user_navigates_toOLEWelcomePageusingfollowinginformation(DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String SiteId = givenAttributesMap.get("SiteId");
		String PBPNumber = givenAttributesMap.get("PBPNumber");
		String ClientCode = givenAttributesMap.get("ClientCode");
		String SegmentId = givenAttributesMap.get("SegmentId");
		String PlanTypeTH = givenAttributesMap.get("PlanTypeTH");
		String TFN = givenAttributesMap.get("TFN");
		String psc = givenAttributesMap.get("psc");
		String PlanYear = givenAttributesMap.get("Plan Year");
		String env = givenAttributesMap.get("env");
		String FipsCode = givenAttributesMap.get("FipsCode");
		String CMScode = givenAttributesMap.get("CMScode");
		String HNumber = givenAttributesMap.get("HNumber");
		String PlanType = givenAttributesMap.get("Plan Type");
		String PlanName = givenAttributesMap.get("Plan Name");
		String County = givenAttributesMap.get("County Name");
		String ZipCode = givenAttributesMap.get("Zip Code");
		String IsMultiCounty = givenAttributesMap.get("Is Multi County");
		String StateCode = givenAttributesMap.get("StateCode");
		String RiderFlag = givenAttributesMap.get("Rider Flag");
		String PrefferedPlanId = givenAttributesMap.get("PrefferedPlan Id");
		String PlanCode = givenAttributesMap.get("Plan Code");
		String mapsPlanType = givenAttributesMap.get("maps PlanType");
		String OLEisCNS = givenAttributesMap.get("OLEis CNS");
		String clientProdCode = givenAttributesMap.get("client ProdCode");
		String OLEisCSNP = givenAttributesMap.get("OLEis CSNP");
		String Fitness = givenAttributesMap.get("Fitness");
		String Vision = givenAttributesMap.get("Vision");
		String Hearing = givenAttributesMap.get("Hearing");
		String Dental = givenAttributesMap.get("Dental");
		String salesagentid = givenAttributesMap.get("salesagent id");
		String PlanPremium = givenAttributesMap.get("Premium");
		String lineOfBusiness = givenAttributesMap.get("lineOf Business");

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteId);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);

		// String PlanPremium = "";
		// String TFN;
		// String SiteName;
		String SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);
		// -----------------------------------------------------------------------------------------------------
		WelcomePage welcomePage;
		if (SiteName.contains("uhc")) {
			OLETestHarnessPage oleTestHarnessPage = (OLETestHarnessPage) loginScenario
					.getBean(PageConstants.OLE_TESTHARNESS_PAGE);

			welcomePage = oleTestHarnessPage.navigateFromOLETestharnessToWelcomeOLE(SiteId, ClientCode, PlanTypeTH,
					PlanName, PlanYear, ZipCode, County, StateCode, HNumber, PBPNumber, SegmentId, TFN, psc, env,
					FipsCode, CMScode, RiderFlag, PrefferedPlanId, PlanCode, mapsPlanType, OLEisCNS, clientProdCode,
					lineOfBusiness, OLEisCSNP, Fitness, Vision, Hearing, Dental, salesagentid, PlanPremium);

		} else if (SiteName.contains("aarp")) {
			OLETestHarnessPage oleTestHarnessPage = (OLETestHarnessPage) loginScenario
					.getBean(PageConstants.OLE_TESTHARNESS_PAGE);
			welcomePage = oleTestHarnessPage.navigateFromOLETestharnessToWelcomeOLE(SiteId, ClientCode, PlanTypeTH,
					PlanName, PlanYear, ZipCode, County, StateCode, HNumber, PBPNumber, SegmentId, TFN, psc, env,
					FipsCode, CMScode, RiderFlag, PrefferedPlanId, PlanCode, mapsPlanType, OLEisCNS, clientProdCode,
					lineOfBusiness, OLEisCSNP, Fitness, Vision, Hearing, Dental, salesagentid, PlanPremium);
		} else {
			OLETestHarnessPage oleTestHarnessPage = (OLETestHarnessPage) loginScenario
					.getBean(PageConstants.OLE_TESTHARNESS_PAGE);
			welcomePage = oleTestHarnessPage.navigateFromOLETestharnessToWelcomeOLE(SiteId, ClientCode, PlanTypeTH,
					PlanName, PlanYear, ZipCode, County, StateCode, HNumber, PBPNumber, SegmentId, TFN, psc, env,
					FipsCode, CMScode, RiderFlag, PrefferedPlanId, PlanCode, mapsPlanType, OLEisCNS, clientProdCode,
					lineOfBusiness, OLEisCSNP, Fitness, Vision, Hearing, Dental, salesagentid, PlanPremium);

		}
		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	/**
	 * @param planName
	 * @toDo:navigate to pcp page in OLE and validates the PCP providers listed in
	 *                UHC VPP page are same
	 */
	@Then("^the User navigates to PCP Page and validates PCP Providers listed in the VPP displayed$")
	//public void the_User_navigates_to_PCP_Page_and_validates_PCP_Providers_listed_in_the_VPP_displayed(DataTable givenAttributes, String planName) {
	public void the_User_navigates_to_PCP_Page_and_validates_PCP_Providers_listed_in_the_VPP_displayed(DataTable givenAttributes) {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String planName = givenAttributesMap.get("PlanName");
		String plantype = givenAttributesMap.get("Plan Type");

		PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);
		ArrayList<String> pcpproviders = pcpPage.pcpinforetreive(plantype);
		Assertion.assertFalse("Providers not added",pcpproviders.isEmpty());
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ArrayList<String> vppproviders = null;
		Map<String, ArrayList<String>> map = planSummaryPage.getMap();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			if(key.equalsIgnoreCase("Provider")) {
				vppproviders = entry.getValue();
			}
		}
		System.out.println("List of providers in VPP page is: "+ vppproviders);
		System.out.println("List of providers in PCP page is: "+ pcpproviders);

		if(vppproviders.size()<=9)
		{
			Assertion.assertTrue("Providers does not match", vppproviders.equals(pcpproviders));
		}
		else {
			for(String provider : pcpproviders){
				if(vppproviders.contains(provider)){
					continue;
				}else{
					Assertion.assertTrue("Providers does not match", false);
				}
			}
		}

	}

	/**
	 * @toDo: Select the provider in PCP and continue to OLE Flow
	 */

	/**
	 * @param planName
	 * @toDo:navigate to pcp page in OLE and validates the PCP providers listed in AARP VPP page are same
	 */
	@Then("^the User navigates to PCP Page and validates PCP Providers listed in the AARP VPP displayed$")
	//public void the_User_navigates_to_PCP_Page_and_validates_PCP_Providers_listed_in_the_VPP_displayed(DataTable givenAttributes, String planName) {
	public void the_User_navigates_to_PCP_Page_and_validates_PCP_Providers_listed_in_the_AARP_VPP_displayed(DataTable givenAttributes) {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String planName = givenAttributesMap.get("PlanName");
		String plantype = givenAttributesMap.get("Plan Type");

		PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);
		ArrayList<String> pcpproviders = pcpPage.pcpinforetreive(plantype);
		Assertion.assertFalse("Providers not added", pcpproviders.isEmpty());
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ArrayList<String> vppproviders = null;
		Map<String, ArrayList<String>> map = planSummaryPage.getMap();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.equalsIgnoreCase("Provider")) {
				vppproviders = entry.getValue();
			}
		}
		System.out.println("List of providers in VPP page is: " + vppproviders);
		System.out.println("List of providers in PCP page is: " + pcpproviders);

		if(vppproviders.size()<=9)
		{
			Assertion.assertTrue("Providers does not match", vppproviders.equals(pcpproviders));
		}
		else {
			for(String provider : pcpproviders){
				if(vppproviders.contains(provider)){
					continue;
				} else {
					Assertion.assertTrue("Providers does not match", false);
				}
			}
		}
	}

	@Then("^the user select providers from the PCP page and continue to OLE Flow$")
	public void the_user_select_providers_from_the_PCP_page_and_continue_to_OLE_Flow() throws Throwable {
		PrimaryCarePhysicianPage pcpPage = (PrimaryCarePhysicianPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PRIMARY_CARE_PHYSICIAN_PAGE);
		PrimaryCarePhysicianPage pcpproviderPage = pcpPage.navigate_PCPPage();

	}

	/**
	 * 
	 * To Validate the OLE WELCOME Page Marketing bullets
	 * 
	 * @param planAttributes
	 * @throws Throwable
	 */
	@Then("^the User Validates Marketing Bullets for Welcome OLE$")
	public void the_User_Validates_Marketing_Bullets_for_Welcome_OLE(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String planName = givenAttributesMap.get("PlanName");
		// String plantype = givenAttributesMap.get("Plan Type");

		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		ArrayList<String> marketingBullets = welcomePage.validate_marketing_details(planName);
		Assertion.assertFalse("Providers not added", marketingBullets.isEmpty());

		System.out.println("List of MarketingBullets in OLE page is: " + marketingBullets);

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ArrayList<String> vppmarketingBullets = null;
		Map<String, ArrayList<String>> map = planSummaryPage.getMap();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.equalsIgnoreCase("MarketingBullet")) {
				vppmarketingBullets = entry.getValue();
			}
		}
		vppmarketingBullets.replaceAll(String::trim);

		System.out.println("List of MarketingBullets in VPP page is: " + vppmarketingBullets);

		Assertion.assertTrue("MarketingBullets does not match", vppmarketingBullets.equals(marketingBullets));

	}

	@Then("^the User Validates Marketing Bullets for Welcome OLE Blayer$")
	public void the_User_Validates_Marketing_Bullets_for_Welcome_OLE_Blayer(DataTable givenAttributes)
			throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */

		String planName = givenAttributesMap.get("PlanName");
		// String plantype = givenAttributesMap.get("Plan Type");

		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		ArrayList<String> marketingBullets = welcomePage.validate_marketing_details(planName);
		Assertion.assertFalse("Providers not added", marketingBullets.isEmpty());

		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		ArrayList<String> vppmarketingBullets = null;
		Map<String, ArrayList<String>> map = planSummaryPage.getMap();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			if (key.equalsIgnoreCase("MarketingBullet")) {
				vppmarketingBullets = entry.getValue();
			}
		}

		System.out.println("List of MarketingBullets in VPP page is: " + vppmarketingBullets);

		Assertion.assertTrue("MarketingBullets does not match", vppmarketingBullets.equals(marketingBullets));

	}

	@Then("^the User validates RadioButtons option in SEP Page$")
	public void the_User_validates_RadioButtons_option_in_SEP_Page() throws Throwable {
		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		boolean Validation_Status = specialElectionPeriodPage.validate_SEP_RadioButton_options();
		if(Validation_Status){
			System.out.println("Radio Button Options Validation in OLE SEP PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE, specialElectionPeriodPage);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Radio Button Options in OLE SEP PAGE : " + Validation_Status);
			Assertion.fail();
		}
	}

	@Then("^the user navigates to Medicare Information Page for DSNP$")
	public void the_user_navigates_to_Medicare_Information_Page_for_DSNP() throws Throwable {
		
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		MedicareInformationPage medicalInformationPage = welcomePage.navigate_to_medicare_info_page();
		if (medicalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					medicalInformationPage);
			System.out.println("OLE medical Information Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Medical Information Page is NOT Displayed");
		// }
	}

	@Then("^the user enters following required Medicare Informations for DSNP$")
	public void the_user_enters_Medicare_Details_in_medicare_info_pages_DSNP(DataTable planAttributes)
			throws Throwable {
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String CardType = MedicareDetailsMap.get("Card Type");

		Random rnd = new Random();
		int n = 100000000 + rnd.nextInt(900000000);
		String MedicareNumber = Integer.toString(n) + "C";
		MedicareDetailsMap.put("Medicare Number", MedicareNumber);

		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		boolean isInformationFilled = medicareInfoPage.enter_required_Medicare_details_dsnp(MedicareDetailsMap);
		if (isInformationFilled) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Medicare Information Page, Medicare Info is entered and Next Button is enabled");
			getLoginScenario().saveBean(oleCommonConstants.FIRST_NAME, MedicareDetailsMap.get("First Name"));
			getLoginScenario().saveBean(oleCommonConstants.LAST_NAME, MedicareDetailsMap.get("Last Name"));
			getLoginScenario().saveBean(oleCommonConstants.MEDICARE_NUMBER, MedicareDetailsMap.get("Medicare Number"));
			getLoginScenario().saveBean(oleCommonConstants.CARD_TYPE, MedicareDetailsMap.get("Card Type"));
			//	getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			//	getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_FLAG, MedicareDetailsMap.get("SSN Flag"));
			getLoginScenario().saveBean(oleCommonConstants.SSN_NUMBER, MedicareDetailsMap.get("SSN Number"));

			Assertion.assertTrue(true);
		} else
			Assertion.fail("Medicare Info data entry failed");
	}

	

	@Then("^the user validates the long term questions in Medicare Information Page$")
	public void the_user_validates_the_long_term_questions_in_Medicare_Information_Page(DataTable arg1) throws Throwable {
		
		scenario.log("Sai - Change made 07/27- Validate ong term questions page--Aug Release");
		
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean medicareInfoPageLongTerm = medicareInfoPage.answer_following_questionsLongTerm(MemberDetailsMap);
		if (medicareInfoPageLongTerm) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Other Insurance Questions in Medicare Information Page - All required Member Details are entered");
			
			getLoginScenario().saveBean(oleCommonConstants.HEALTH_INSURANCE, MemberDetailsMap.get("LongTerm Question"));
			getLoginScenario().saveBean(oleCommonConstants.HEALTH_INSURANCE_NAME, MemberDetailsMap.get("Health Insurance Name"));
			getLoginScenario().saveBean(oleCommonConstants.GROUP_NUMBER, MemberDetailsMap.get("Group Number"));
			getLoginScenario().saveBean(oleCommonConstants.MEMBER_NUMBER, MemberDetailsMap.get("Member Number"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Other Insurance Questions in Medicare Information Page - Adding Member Details Failed");
	}

	@Then("^the user validates the Prescription drug coverage questions in Medicare Information Page$")
	public void the_user_validates_the_Prescription_drugcoverage_questions_in_Medicare_Information_Page(DataTable arg1)
			throws Throwable {

		scenario.log("Sai - Change made 07/27- Validate to Predscription drug Coverage page   --Aug Release");
		
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean medicareInfoPageLongTerm = medicareInfoPage.answer_following_questions_PrescriptionCoverage(MemberDetailsMap);
		if (medicareInfoPageLongTerm) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Prescription drug coverage Questions in Medicare Information Page - All required Member Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_DRUG, MemberDetailsMap.get("PDP Question"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_COVERAGE_NAME, MemberDetailsMap.get("Prescription Name"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER, MemberDetailsMap.get("PD Group Number"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_MEMBER_NUMBER, MemberDetailsMap.get("PD Member Number"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_RXBIN_NUMBER, MemberDetailsMap.get("RX BIN Number"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Other Insurance Questions in Medicare Information Page - Adding Member Details Failed");
	}

	@SuppressWarnings("unchecked")
	@Then("^the user validates the OLE Submission Details in GPS$")
	public void the_user_validates_the_OLE_Submission_Details_in_GPS(DataTable arg1) throws Throwable {

		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		String plantype = MemberDetailsMap.get("Plan Type");
		String AuthorizationRiderFlag = MemberDetailsMap.get("Auth Flag");
		String MailingAddressQuestion = MemberDetailsMap.get("Mailing Address Question");
		String[] dateArray = null;

		if (!(MRScenario.environment.equalsIgnoreCase("offline")
				|| MRScenario.environment.equalsIgnoreCase("prod")|| MRScenario.environment.equalsIgnoreCase("mnr-acq-ci1") || MRScenario.environment.equalsIgnoreCase("stage-0")|| MRScenario.environment.equalsIgnoreCase("stage")|| MRScenario.environment.equalsIgnoreCase("offline-stage")|| MRScenario.environment.equalsIgnoreCase("team-acme"))) {

			OLEconfirmationPage OLEGPSValidation = (OLEconfirmationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE);
			if (OLEGPSValidation != null) {

				System.out.println("--------------------Creating a map to store Expected Data for Comparison----------------------");
				Map<String, String> DetailsMap = new HashMap<String, String>();

				System.out.println("--------------------Storing Data for VPP Page Started----------------------");


				//VPP Page
				String PlanName = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME);
				//-------------------------------------------------------------------------------------
				/*DetailsMap.put("Plan Name", PlanName.toUpperCase());
				DetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));	
				String county = (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY);
				DetailsMap.put("County", county.toUpperCase());
				 */
				DetailsMap.put("Confirmation No", (String) getLoginScenario().getBean(oleCommonConstants.CONFIRMATION_NUMBER));

				System.out.println("--------------------Storing Data for Confirmation Number----------------------");

				// ------------------------------------------------------------------------------------------------------------------------------------------------

						System.out.println("--------------------Storing Data for Personal Information Page Started----------------------");

						// Personal Information
						String firstName = (String) getLoginScenario().getBean(oleCommonConstants.FIRST_NAME);
						DetailsMap.put("First Name", firstName.toUpperCase());
						String lastName = (String) getLoginScenario().getBean(oleCommonConstants.LAST_NAME);
						DetailsMap.put("Last Name", lastName.toUpperCase());
						String middleName = (String) getLoginScenario().getBean(oleCommonConstants.MIDDLE_NAME);
						DetailsMap.put("MiddleInitial", middleName.toUpperCase());
						String dob = (String) getLoginScenario().getBean(oleCommonConstants.DOB);
						dob = OLEGPSValidation.converttogpsDate(dob);
						DetailsMap.put("DOB", dob);

						//Gender
						String gender= (String) getLoginScenario().getBean(oleCommonConstants.GENDER);
						gender=gender.substring(0, 1);
						DetailsMap.put("Gender",gender);

						// Primary Address
						String perm_Street = (String) getLoginScenario().getBean(oleCommonConstants.PERM_STREET);
						DetailsMap.put("Perm_Street", perm_Street.toUpperCase());
						//	String perm_Address = (String) getLoginScenario().getBean(oleCommonConstants.PERM_APARTMENT_NUMBER);
						DetailsMap.put("Perm_Apartment", (String) getLoginScenario().getBean(oleCommonConstants.PERM_APARTMENT_NUMBER));
						// DetailsMap.put("Perm_Apartment", "");
						String perm_city = (String) getLoginScenario().getBean(oleCommonConstants.PERM_CITY);
						DetailsMap.put("Perm_city", perm_city.toUpperCase());
						// TODO: Need to check and add Permanent State
						DetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));

						//Mailing Address
						/*<----------Mailing question is not showing up GPS----------------
				String mailing_Question = (String) getLoginScenario().getBean(oleCommonConstants.MAILING_QUESTION);
				DetailsMap.put("Mailing_Question", mailing_Question.toUpperCase());
				----------Mailing question is not showing up GPS---------------->*/
						if(MailingAddressQuestion.equalsIgnoreCase("no")) {
							String mailing_Street = (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STREET);
							DetailsMap.put("Mailing_Street", mailing_Street.toUpperCase());
							String mailing_City = (String) getLoginScenario().getBean(oleCommonConstants.MAILING_CITY);
							DetailsMap.put("Mailing Apartment Number", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_APARTMENT_NUMBER));
							DetailsMap.put("Mailing_City", mailing_City.toUpperCase());
							String mailing_State = (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STATE);
							DetailsMap.put("Mailing_State", mailing_State.toUpperCase());
							DetailsMap.put("Mailing_Zip", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_ZIP));
						}
						
						//Phone Number
						DetailsMap.put("Home Number", (String) getLoginScenario().getBean(oleCommonConstants.PRIMARY_PHONE_NUMBER));
						DetailsMap.put("Mobile Number", (String) getLoginScenario().getBean(oleCommonConstants.MOBILE_NUMBER));

						//Email
						//DetailsMap.put("Email Confirmation", (String) getLoginScenario().getBean(oleCommonConstants.EMAIL_CONFIRMATION)); 1-6-This is not mentioned in GPS query so commented it
						String email = (String) getLoginScenario().getBean(oleCommonConstants.EMAIL);
						DetailsMap.put("Email", email.toUpperCase());

						if(PlanName.contains("Chronic") || PlanName.contains("Gold") ||PlanName.contains("Silver") || PlanName.contains("D-SNP")) {
							DetailsMap.put("Paperless Delivery", "N");
						} else {
							String paperless= ((String) getLoginScenario().getBean(oleCommonConstants.PAPERLESS_DELIVERY));
							System.out.println("--------------------Storing Data for paperless delivery" +paperless);
							paperless=paperless.toUpperCase().substring(0, 1);
							DetailsMap.put("Paperless Delivery",paperless);
							//	DetailsMap.put("Paperless Delivery", (String) getLoginScenario().getBean(oleCommonConstants.Go_Green));	
						}
						DetailsMap.put("Language", "1");

						System.out.println("--------------------Storing Data for Personal Information Page Ended----------------------");

						// ------------------------------------------------------------------------------------------------------------------------------------------------

						System.out.println("--------------------Storing Data for Medicare Information Page Started----------------------");

						// Medicare Information Page

						//Medicare and Medicaid Number
						String medicareNumber= (String) getLoginScenario().getBean(oleCommonConstants.MEDICARE_NUMBER);
						medicareNumber=medicareNumber.replaceAll("-", "").toUpperCase();
						DetailsMap.put("Medicare Number", medicareNumber);

						DetailsMap.put("Medicaid Number", (String) getLoginScenario().getBean(OLE_PageConstants.MEDICAID_NUMBER));
						String ssnFlag = (String) getLoginScenario().getBean(oleCommonConstants.SSN_FLAG);
						if(ssnFlag.equalsIgnoreCase("true")) {
							String SSN = (String) getLoginScenario().getBean(oleCommonConstants.SSN_NUMBER);
							DetailsMap.put("SSN Number", SSN);
						} else {
							DetailsMap.put("SSN Number", "");

						}

						//Other Health Insurance
						if(!plantype.contains("PDP")) {
							String healthInsurance = (String) getLoginScenario().getBean(oleCommonConstants.HEALTH_INSURANCE);
							DetailsMap.put("Health Insurance", healthInsurance.substring(0, 1).toUpperCase());
							String otherHealthInsuranceeName = (String) getLoginScenario().getBean(oleCommonConstants.HEALTH_INSURANCE_NAME);
							DetailsMap.put("Health Insurance Name", otherHealthInsuranceeName.toUpperCase());
							String groupNumber = (String) getLoginScenario().getBean(oleCommonConstants.GROUP_NUMBER);
							DetailsMap.put("Group Number", groupNumber.toUpperCase());
							DetailsMap.put("Member Number", (String) getLoginScenario().getBean(oleCommonConstants.MEMBER_NUMBER));
						}
						else {
							DetailsMap.put("Health Insurance", "N");
							/*	DetailsMap.put("Health Insurance Name", "");
					DetailsMap.put("Group Number", "");		
					DetailsMap.put("Member Number", "");	*/
						}
						System.out.println("--------------------Storing Data for PCP Page Ended----------------------");

						// Prescription Drug Coverage
						String prescriptionDrug = (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_DRUG);
						DetailsMap.put("Prescription Drug", prescriptionDrug.substring(0, 1).toUpperCase());
						String prescriptionCoverageName = (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_COVERAGE_NAME);
						// prescriptionCoverageName=prescriptionCoverageName.toUpperCase()+"+"+"PRESCRIPTIONCOVERAGE";
						prescriptionCoverageName=prescriptionCoverageName.toUpperCase()+'"'+'+'+'"'+prescriptionCoverageName.toUpperCase();
						DetailsMap.put("Prescription Name", prescriptionCoverageName);
						String pdGroupNumber = (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER);
						DetailsMap.put("PD Group Number", pdGroupNumber.toUpperCase());
						DetailsMap.put("PD Member Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_MEMBER_NUMBER));
						DetailsMap.put("RX BIN Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_RXBIN_NUMBER));
						System.out.println("--------------------Storing Data for Medicare Information Page Ended----------------------");

						// ------------------------------------------------------------------------------------------------------------------------------------------------

						System.out.println("--------------------Storing Data for Eligibility Page Started----------------------");

						// Eligibility Page
						String partAEffective = (String) getLoginScenario().getBean(oleCommonConstants.PARTA_EFFECTIVE);
						partAEffective = OLEGPSValidation.converttogpsDate(partAEffective);
						DetailsMap.put("PartA Date", partAEffective);
						String partBEffective = (String) getLoginScenario().getBean(oleCommonConstants.PARTB_EFFECTIVE);
						partBEffective = OLEGPSValidation.converttogpsDate(partBEffective);
						DetailsMap.put("PartB Date", partBEffective);

						System.out.println("--------------------Storing Data for Eligibility Page Ended----------------------");

						// ------------------------------------------------------------------------------------------------------------------------------------------------

						System.out.println("--------------------Storing Data for SEP Page Started----------------------");

						//SEP Page
						/*String note = "Q:I am losing coverage I had from an employer. A:09012020";
				DetailsMap.put("Note", note);
						 */

						System.out.println("--------------------Storing Data for SEP Page Ended----------------------");

						// ------------------------------------------------------------------------------------------------------------------------------------------------

						System.out.println("--------------------Storing Data for PCP Page Started----------------------");

						//PCP Page
						if(!plantype.contains("PDP")) {
							String pcpName = (String) getLoginScenario().getBean(oleCommonConstants.PCP_NAME);
							DetailsMap.put("PCP Name", pcpName.replaceAll("-", "").toUpperCase());

							String pcpNumber = (String) getLoginScenario().getBean(oleCommonConstants.PCP_NUMBER);
							DetailsMap.put("PCP Number", pcpNumber.toUpperCase());

							String pcpRecentlyVisited = (String) getLoginScenario().getBean(oleCommonConstants.PCP_RECENTLY_VISITED);
							pcpRecentlyVisited = pcpRecentlyVisited.substring(0, 1);
							DetailsMap.put("PCP Recently Visited", pcpRecentlyVisited.toUpperCase());
						}
						else {
							DetailsMap.put("PCP Name", "");
							DetailsMap.put("PCP Number", "");
							DetailsMap.put("PCP Recently Visited", "N");
						}
						System.out.println("--------------------Storing Data for PCP Page Ended----------------------");

						//------------------------------------------------------------------------------------------------------------------------------------------------
						//Payment type
						System.out.println("--------------------Storing Data for Plan Premium Page ----------------------");
						String paymentPlan = (String) getLoginScenario().getBean(oleCommonConstants.PAYMENT_METHOD);
						if(paymentPlan.equalsIgnoreCase("Pay By Mail")) {
							DetailsMap.put("payment type is Pay by mail: ", "0");
						}
						else if(paymentPlan.equalsIgnoreCase("Social Security or Railroad Retirement Benefit")) {
							DetailsMap.put("payment type is SSN: ", "1");	
						}
						else {
							DetailsMap.put("payment type is Credit Card: ", "2");		
						}

						//Credit Card Details
						System.out.println("--------------------Storing Data for Credit Card Started----------------------");
						String creditCardNumber = (String) getLoginScenario().getBean(oleCommonConstants.CREDIT_CARD_NUMBER);
						DetailsMap.put("Credit Card Number", creditCardNumber);
						String creditCardNameOnCreditCard = (String) getLoginScenario().getBean(oleCommonConstants.CREDIT_CARD_NAME_ON_CARD);
						DetailsMap.put("Credit Card Name On Card", creditCardNameOnCreditCard);
						String creditCardExpirationDate = (String) getLoginScenario().getBean(oleCommonConstants.CREDIT_CARD_EXPIRATION_DATE);
						DetailsMap.put("Credit Card Expiration Date", creditCardExpirationDate);
						System.out.println("--------------------Storing Data for Credit Card Ended----------------------");

						//Proposed Effective Date
						System.out.println("--------------------Storing Data for Proposed Effective Date Started----------------------");

						String proposedEffectiveDate = (String) getLoginScenario().getBean(oleCommonConstants.PROPOSED_EFF_DATE);
						proposedEffectiveDate = proposedEffectiveDate.substring(0, 10);
						System.out.println("--------------------Storing Data for Proposed Effective Date Ended----------------------" +proposedEffectiveDate);
						proposedEffectiveDate=OLEGPSValidation.converttogpsDate1(proposedEffectiveDate);
						DetailsMap.put("Proposed Effective date", proposedEffectiveDate);

						System.out.println("--------------------Storing Data for Proposed Effective Date Ended----------------------" +proposedEffectiveDate);

						// ------------------------------------------------------------------------------------------------------------------------------------------------

						System.out.println("--------------------Storing Data for Authorization Page Started----------------------");

						// Authorization Page
						DetailsMap.put("Authorization Agree", "Y");

						if(AuthorizationRiderFlag.contains("true")) {
							String authorizationFirstName = (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_FIRST_NAME);
							DetailsMap.put("Authorization First Name", authorizationFirstName.toUpperCase());
							String authorizationLastName = (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_LAST_NAME);
							DetailsMap.put("Authorization last Name", authorizationLastName.toUpperCase());
							DetailsMap.put("Auth Representative Indicator", "Y");
							String authorizationRelationship = (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_RELATIONSHIP);
							DetailsMap.put("Authorization Relationship", authorizationRelationship.toUpperCase());
							DetailsMap.put("Authorization Address", (String) getLoginScenario().getBean(oleCommonConstants. AUTHORIZATION_ADDRESS));
							DetailsMap.put("Authorization Apartment Suite", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_APARTMENT_SUITE));
							DetailsMap.put("Authorization City", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_CITY));
							DetailsMap.put("Authorization State", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_STATE_DISPLAY));
							DetailsMap.put("Auth Zip Display", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_ZIP));
							String authorizationPhoneNumber= (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_PHONE_NO);
							authorizationPhoneNumber=authorizationPhoneNumber.replaceAll("-", "").toUpperCase();
							DetailsMap.put("Authorization Phone No", authorizationPhoneNumber);

							System.out.println("--------------------Storing Data for Authorization Page Ended----------------------");
						}
						
						//------------------------------------------------------------------------------------------------------------------------------------------------

						//-----------Adding for CSNP-----------------//
						if(PlanName.contains("Chronic") || PlanName.contains("Gold") ||PlanName.contains("Silver")){
							String diabetesquestion1= (String) getLoginScenario().getBean(oleCommonConstants.DIABETES_QUESTION_1);
							diabetesquestion1=diabetesquestion1.substring(0, 1);
							DetailsMap.put("Diabetes Question 1",diabetesquestion1.toUpperCase());
							String diabetesquestion2= (String) getLoginScenario().getBean(oleCommonConstants.DIABETES_QUESTION_2);
							diabetesquestion2=diabetesquestion2.substring(0, 1);
							DetailsMap.put("Diabetes Question 2",diabetesquestion2);

							String chronicheartfailurequestion1= (String) getLoginScenario().getBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_1);
							chronicheartfailurequestion1=chronicheartfailurequestion1.substring(0, 1);
							DetailsMap.put("Chronic Heart Failure Question 1",chronicheartfailurequestion1);
							String chronicheartfailurequestion2= (String) getLoginScenario().getBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_2);
							chronicheartfailurequestion2=chronicheartfailurequestion2.substring(0, 1);
							DetailsMap.put("Chronic Heart Failure Question 2",chronicheartfailurequestion2);				
							String chronicheartfailurequestion3= (String) getLoginScenario().getBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_3);
							chronicheartfailurequestion3=chronicheartfailurequestion3.substring(0, 1);
							DetailsMap.put("Chronic Heart Failure Question 3",chronicheartfailurequestion3);

							String cardiovasculardisorderquestion1= (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_1);
							cardiovasculardisorderquestion1=cardiovasculardisorderquestion1.substring(0, 1);
							DetailsMap.put("Cardio Vascular Disorder Question 1",cardiovasculardisorderquestion1);
							String cardiovasculardisorderquestion2= (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_2);
							cardiovasculardisorderquestion2=cardiovasculardisorderquestion2.substring(0, 1);
							DetailsMap.put("Cardio Vascular Disorder Question 2",cardiovasculardisorderquestion2);
							String cardiovasculardisorderquestion3= (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_3);
							cardiovasculardisorderquestion3=cardiovasculardisorderquestion3.substring(0, 1);
							DetailsMap.put("Cardio Vascular Disorder Question 3",cardiovasculardisorderquestion3);
							String cardiovasculardisorderquestion4= (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_4);
							cardiovasculardisorderquestion4=cardiovasculardisorderquestion4.substring(0, 1);
							DetailsMap.put("Cardio Vascular Disorder Question 4",cardiovasculardisorderquestion4);
							String cardiovasculardisorderquestion5= (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_5);
							cardiovasculardisorderquestion5=cardiovasculardisorderquestion5.substring(0, 1);
							DetailsMap.put("Cardio Vascular Disorder Question 5",cardiovasculardisorderquestion5);
							String cardiovasculardisorderquestion6= (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_6);
							cardiovasculardisorderquestion6=cardiovasculardisorderquestion6.substring(0, 1);
							DetailsMap.put("Cardio Vascular Disorder Question 6",cardiovasculardisorderquestion6);

							String disclosurecheckbox = (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_CHECKBOX);
							if(disclosurecheckbox.equalsIgnoreCase("true")) {
								DetailsMap.put("Disclosure Checkbox", "Y");
							}
							else {
								DetailsMap.put("Disclosure Checkbox", "N");
							}
							String disclosureprovidername = (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_NAME);
							DetailsMap.put("Disclosure Provider Name", disclosureprovidername.toUpperCase());

							
							String disclosureprovidercity = (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_CITY);
							
							String disclosureproviderstate = (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_STATE);
							String disclosureproviderzip = (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_ZIP);
							

							String disclosureProviderPhoneNumber= (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_PHONENUMBER);
							disclosureProviderPhoneNumber=disclosureProviderPhoneNumber.replaceAll("-", "").toUpperCase();
							DetailsMap.put("Disclosure Provider PhoneNumber", disclosureProviderPhoneNumber);

							String disclosureprovideraddress = (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_STREET_ADDRESS);
							disclosureprovideraddress=disclosureprovideraddress.toUpperCase()+','+disclosureprovidercity.toUpperCase()+','+disclosureproviderstate.toUpperCase()+','+disclosureproviderzip;
							DetailsMap.put("Disclosure Provider Address", disclosureprovideraddress);
							System.out.println("--------------------Storing Data for Preliminary questions and Use and disclosure  Ended----------------------"+disclosureprovideraddress);
						}
						//---------------------------------------------------//	
						//------------Added for Jenkins Report---------------//
						List<String> testNote=new ArrayList<String>();
						// testNote.add("===================================================");

						// testNote.add("\tValidation for able to print all the values from the GPS");

						Map <String, String> matched = new HashMap<>();
						Map <String, String> mismatched = new HashMap<>();
						//------------Added for Jenkins Report---------------//	
						boolean Validation_Status = OLEGPSValidation.validate_GPS_for_Plantype(DetailsMap,matched,mismatched);
						if (Validation_Status) {
							System.out.println("OLE Confirmation Page : All Plan Details Validated in GPS");
							getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, OLEGPSValidation);

							// getLoginScenario().saveBean(oleCommonConstants.TEST_RESULT_NOTE,testNote1);
							Assertion.assertTrue(true);
							// testNote.addAll(matched);

						} else {
							System.out.println("OLE Confirmation Page : All Plan and Member Details  NOT validated in GPS");
							Assertion.fail("OLE Confirmation Page : All Plan and Member Details  NOT validated in GPS");

						}
			} else {
				getLoginScenario().saveBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE, OLEGPSValidation);
				System.out.println("OLE Confirmation Page is NOT Displayed : OLE Submission Failed");
				Assertion.fail("OLE Confirmation Page is NOT Displayed : OLE Submission Failed");
			}
		} else {
			System.out.println("Skipping the Confirmation functionality in Offline-Prod/Prod environment environment");
		}

	}

	@Then("^the user validates the Online Enrollment details on Review and Submit Page$")
	public void the_user_validates_the_online_Enrollment_details_on_Review_and_Submit_Page() throws Throwable {
		
		ReviewSubmitPage reviewSubmitPage = (ReviewSubmitPage) getLoginScenario().getBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE);
		Map<String, String> DetailsMap = new HashMap<String, String>();
	//	String planYear = (String)getLoginScenario().getBean(VPPCommonConstants.PLAN_YEAR);
		DetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		DetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		DetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		DetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		DetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));
		DetailsMap.put("First Name", (String) getLoginScenario().getBean(oleCommonConstants.FIRST_NAME));
		DetailsMap.put("Last Name", (String) getLoginScenario().getBean(oleCommonConstants.LAST_NAME));
		DetailsMap.put("Middle Name", (String) getLoginScenario().getBean(oleCommonConstants.MIDDLE_NAME));
		DetailsMap.put("Card Type", (String) getLoginScenario().getBean(oleCommonConstants.CARD_TYPE));
		DetailsMap.put("Medicare Number", (String) getLoginScenario().getBean(oleCommonConstants.MEDICARE_NUMBER));
	//	DetailsMap.put("PartA Date", (String) getLoginScenario().getBean(oleCommonConstants.PARTA_EFFECTIVE));
		//DetailsMap.put("PartB Date", (String) getLoginScenario().getBean(oleCommonConstants.PARTB_EFFECTIVE));
		String partAEffective = (String) getLoginScenario().getBean(oleCommonConstants.PARTA_EFFECTIVE);
		partAEffective = reviewSubmitPage.converttoReviewDate(partAEffective);
		DetailsMap.put("PartA Date", partAEffective);
		String partBEffective = (String) getLoginScenario().getBean(oleCommonConstants.PARTB_EFFECTIVE);
		partBEffective = reviewSubmitPage.converttoReviewDate(partBEffective);
		DetailsMap.put("PartB Date", partBEffective);
		String DoB = (String) getLoginScenario().getBean(oleCommonConstants.DOB);
		DoB = reviewSubmitPage.converttoReviewDate(DoB);
		DetailsMap.put("DOB", DoB);
		//DetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
	//	DetailsMap.put("DOB", (String) getLoginScenario().getBean(oleCommonConstants.DOB));

		DetailsMap.put("Gender", (String) getLoginScenario().getBean(oleCommonConstants.GENDER));
		DetailsMap.put("Perm_Street", (String) getLoginScenario().getBean(oleCommonConstants.PERM_STREET));
		DetailsMap.put("Perm_Aptno", (String) getLoginScenario().getBean(oleCommonConstants.PERM_APARTMENT_NUMBER));
		DetailsMap.put("Perm_city", (String) getLoginScenario().getBean(oleCommonConstants.PERM_CITY));
		DetailsMap.put("MAILING_QUESTION", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_QUESTION));
		DetailsMap.put("Mailing_Street", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STREET));
		DetailsMap.put("Mailing_City", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_CITY));
		DetailsMap.put("Mailing_State", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_STATE));
		DetailsMap.put("Mailing_Zip", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_ZIP));
		DetailsMap.put("Email", (String) getLoginScenario().getBean(oleCommonConstants.EMAIL));

		DetailsMap.put("Prescription Name", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_COVERAGE_NAME));
		DetailsMap.put("PD Group Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER));
		DetailsMap.put("PD Member Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_MEMBER_NUMBER));
		DetailsMap.put("Health Insurance Name", (String) getLoginScenario().getBean(oleCommonConstants.HEALTH_INSURANCE_NAME));
		DetailsMap.put("Group Number", (String) getLoginScenario().getBean(oleCommonConstants.GROUP_NUMBER));
		DetailsMap.put("Member Number", (String) getLoginScenario().getBean(oleCommonConstants.MEMBER_NUMBER));
		DetailsMap.put("RX BIN Number", (String) getLoginScenario().getBean(oleCommonConstants.PRESCRIPTION_RXBIN_NUMBER));

		DetailsMap.put("Health Insurance", (String) getLoginScenario().getBean(oleCommonConstants.HEALTH_INSURANCE));
		DetailsMap.put("Prescription Drug", (String) getLoginScenario().getBean(oleCommonConstants. PRESCRIPTION_DRUG));
		DetailsMap.put("PCP Name", (String) getLoginScenario().getBean(oleCommonConstants.PCP_NAME));
		DetailsMap.put("PCP Number", (String) getLoginScenario().getBean(oleCommonConstants.PCP_NUMBER));
		DetailsMap.put("PCP Recently Visited", (String) getLoginScenario().getBean(oleCommonConstants.PCP_RECENTLY_VISITED));
		DetailsMap.put("Medicaid Number", (String) getLoginScenario().getBean(OLE_PageConstants.MEDICAID_NUMBER));

		DetailsMap.put("Proposed Effective date", (String) getLoginScenario().getBean(oleCommonConstants.PROPOSED_EFF_DATE));
		DetailsMap.put("Mailing Apartment Number", (String) getLoginScenario().getBean(oleCommonConstants.MAILING_APARTMENT_NUMBER));
		DetailsMap.put("Home Number", (String) getLoginScenario().getBean(oleCommonConstants. PRIMARY_PHONE_NUMBER));
		DetailsMap.put("Mobile Number", (String) getLoginScenario().getBean(oleCommonConstants.MOBILE_NUMBER));
		DetailsMap.put("Email Confirmation", (String) getLoginScenario().getBean(oleCommonConstants.EMAIL_CONFIRMATION));
		DetailsMap.put("Paperless Delivery", (String) getLoginScenario().getBean(oleCommonConstants.Go_Green));

		DetailsMap.put("Authorization First Name", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_FIRST_NAME));
		DetailsMap.put("Authorization last Name", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_LAST_NAME));
		DetailsMap.put("Authorization Address", (String) getLoginScenario().getBean(oleCommonConstants. AUTHORIZATION_ADDRESS));
		DetailsMap.put("Authorization Apartment Suite", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_APARTMENT_SUITE));
		DetailsMap.put("Authorization City", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_CITY));
		DetailsMap.put("Authorization Phone No", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_PHONE_NO));
		DetailsMap.put("Authorization Agree", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_AGREE));
		DetailsMap.put("Authorization Relationship", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_RELATIONSHIP));
		DetailsMap.put("Authorization State", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_STATE_DISPLAY));
		DetailsMap.put("Auth Zip Display", (String) getLoginScenario().getBean(oleCommonConstants.AUTHORIZATION_ZIP));


		//-----------------Added for CSNP validation-----------------//
		DetailsMap.put("Diabetes Question 1", (String) getLoginScenario().getBean(oleCommonConstants.DIABETES_QUESTION_1));
		DetailsMap.put("Diabetes Question 2", (String) getLoginScenario().getBean(oleCommonConstants.DIABETES_QUESTION_2));
		DetailsMap.put("Chronic Heart Failure Question 1", (String) getLoginScenario().getBean(oleCommonConstants. CHRONIC_HEART_FAILURE_QUESTION_1 ));
		DetailsMap.put("Chronic Heart Failure Question 2", (String) getLoginScenario().getBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_2));
		DetailsMap.put("Chronic Heart Failure Question 3", (String) getLoginScenario().getBean(oleCommonConstants.CHRONIC_HEART_FAILURE_QUESTION_3));
		DetailsMap.put("Cardio Vascular Disorder Question 1", (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_1));
		DetailsMap.put("Cardio Vascular Disorder Question 2", (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_2));
		DetailsMap.put("Cardio Vascular Disorder Question 3", (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_3));
		DetailsMap.put("Cardio Vascular Disorder Question 4", (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_4));
		DetailsMap.put("Cardio Vascular Disorder Question 5", (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_5));
		DetailsMap.put("Cardio Vascular Disorder Question 6", (String) getLoginScenario().getBean(oleCommonConstants.CARDIO_VASCULAR_DISORDER_QUESTION_6));


		DetailsMap.put("Disclosure Checkbox", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_CHECKBOX));
		DetailsMap.put("Disclosure Provider Name", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_NAME));
		DetailsMap.put("Disclosure Provider Street Address", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_STREET_ADDRESS));
		DetailsMap.put("Disclosure Provider City", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_CITY));
		DetailsMap.put("Disclosure Provider State", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_STATE));
		DetailsMap.put("Disclosure Provider Zip", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_ZIP));
		DetailsMap.put("Disclosure Provider PhoneNumber", (String) getLoginScenario().getBean(oleCommonConstants.DISCLOSURE_PROVIDER_PHONENUMBER));
		DetailsMap.put("Optional Rider", (String) getLoginScenario().getBean(oleCommonConstants.OPTIONAL_RIDER_TEXT));

		//--------------------------Added for payment plan--------------------------------------------------------------

		DetailsMap.put("Payment Plan", (String) getLoginScenario().getBean(oleCommonConstants.PAYMENT_PLAN));
	//	if(planYear.contains("current")) {
		boolean Validation_Status = reviewSubmitPage.OnlineEnrollment_Review_Page_details(DetailsMap);
		if(Validation_Status){
			System.out.println("Review and Submit Page : All Plan and Member Details Validated");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE,
					reviewSubmitPage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("Review and Submit Page : All Plan and Member Details  NOT validated");
			Assertion.fail();
		}
		//}
	}

	@Then("^the user validates Medicaid Number in OLE Page$")
	public void the_user_validates_Medicaid_Number_OLE_Page(DataTable arg1) throws Throwable {
		
		scenario.log("Sai - Change made 06/17 - Validate Medicaid Number on OLE Page--Aug Release");

		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		getLoginScenario().saveBean(OLE_PageConstants.MEDICAID_NUMBER, MemberDetailsMap.get("MedicaidNumber"));
		boolean MedicaidInformationStatus = medicareInfoPage.validate_Medicaid_Number_CEP(MemberDetailsMap);
		if (MedicaidInformationStatus) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE, medicareInfoPage);
			System.out.println("OLE Medicaid Questions in Medicare Information Page - Medicaid Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER, MemberDetailsMap.get("MedicaidNumber"));
			getLoginScenario().saveBean(OLE_PageConstants.MEDICAID_NUMBER, MemberDetailsMap.get("MedicaidNumber"));

			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Medicaid Questions in Medicare Information Page -  Medicaid Member Details Failed");
	}

	@Then("^the user navigates to confirm Your Eligibility Page for Medicaid and Effective date$")
	public void the_user_navigates_to_confirm_Your_Eligibility_Page_Medicaid_Effective_Date(DataTable Medicareoptions) throws Throwable {
	
		scenario.log("Sai - Change made 06/17 - Validate confirm Your Eligibility on OLE Page for DSNP");
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(Medicareoptions);
	
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		ConfirmYourEligibilityPage confirmYourEligibilityPage = personalInformationPage.navigate_to_ConfirmYourEligibility_page_Medicaid(MedicareDetailsMap);
		if (confirmYourEligibilityPage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					confirmYourEligibilityPage);
			System.out.println("OLE confirm Your Eligibility Page is Displayed");

			getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER, MedicareDetailsMap.get("MedicaidNumber"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE confirm Your Eligibility Page is NOT Displayed");
	}

	@Then("^the user clicks on save and return later to profile page$")
	public void the_user_clicks_on_save_and_return_later_to_profile_page() {

		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		VisitorProfilePage visitorProfilePage = personalInformationPage.saveAndReturnLater();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE,visitorProfilePage);
	}

	@Then("^the user clicks on Enroll Now to start the OLE flow from plandetails page$")
	public void the_user_clicks_on_Enroll_Now_to_start_the_OLE_flow_plan_details_page(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		String PlanName = givenAttributesMap.get("Plan Name");
		//String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);

		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);
		String PlanPremium = "";
		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		String SiteName;
		SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		//-----------------------------------------------------------------------------------------------------
		WelcomePage welcomePage;
		if (SiteName.contains("UHC_ACQ")) {
			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			TFN = planSummaryPage.GetTFNforPlanType();

			// PlanPremium = planSummaryPage.getPlanPremium(PlanName);
			welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName, PlanType);

		} else {
			VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
					.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
			/*
			 * ,(new VPPPlanSummaryPage((WebDriver)getLoginScenario()
			 * .getBean(CommonConstants.WEBDRIVER))));
			 */
			TFN = planSummaryPage.GetTFNforPlanType();

			// PlanPremium = planSummaryPage.getPlanPremium(PlanName);
			welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName, PlanType);

		} // --------------------------------------------------------------------------------------------------------------------

		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
		System.out.println("Plan Year is : " + PlanYear);
		System.out.println("OLE is being started from Acquisition Site : " + SiteName);

		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}

	@Then("^the user navigates to Disclosure Authorization Page for Medicaid and Effective date CSNP Plans$")
	public void the_user_navigates_to_Disclosure_Authorization_Page_Medicaid_Effective_Date_CSNP_Plans(
			DataTable Medicareoptions) throws Throwable {
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(Medicareoptions);
		/*
		 * List<DataTableRow> givenAttributesRow = Medicareoptions.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * MedicareDetailsMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		UseAndDisclosureAuthorizationPage useranddisclosure = personalInformationPage.navigate_to_SEP_page_CSNP(MedicareDetailsMap);
		if (useranddisclosure != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_User_And_Disclosure_PAGE,
					useranddisclosure );
			System.out.println("OLE Use and Disclosure Authorization Page is Displayed");

			getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			//getLoginScenario().saveBean(oleCommonConstants.MEDICAID_NUMBER, MedicareDetailsMap.get("MedicaidNumber"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Use and Disclosure Authorization Page is NOT Displayed");
	}

	@Then("^the user validate on Review Page and click on Edit information for Medicare Information Page$")
	public void the_user_navigates_to_Review_and_Submit_Page_clickon_Edit_Medicare_Page(DataTable Medicareoptions)
			throws Throwable {
		scenario.log("Sai - Change made 07/27- Edit from Review Page --Aug Release");
		Map<String, String> MedicareDetailsMap = new HashMap<String, String>();
		MedicareDetailsMap = DataTableParser.readDataTableAsMaps(Medicareoptions);

		String CardType = MedicareDetailsMap.get("Card Type");
		
		String MedicareNumber1 = MedicareDetailsMap.get("Medicare Number1");
		
		ReviewSubmitPage reviewSubmitPage = (ReviewSubmitPage) getLoginScenario().getBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE);
		//AuthorizationPage authorizationPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
		//MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);

		boolean medicareInfoPage = reviewSubmitPage.Review_page_enter_required_Medicare_details(MedicareDetailsMap);
		if (medicareInfoPage) {

			getLoginScenario().saveBean(oleCommonConstants.MEDICARE_NUMBER, MedicareDetailsMap.get("Medicare Number1"));
			getLoginScenario().saveBean(oleCommonConstants.CARD_TYPE, MedicareDetailsMap.get("Card Type"));
			//getLoginScenario().saveBean(oleCommonConstants.PARTA_EFFECTIVE, MedicareDetailsMap.get("PartA Date"));
			//getLoginScenario().saveBean(oleCommonConstants.PARTB_EFFECTIVE, MedicareDetailsMap.get("PartB Date"));
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_REVIEW_SUBMIT_PAGE,
					reviewSubmitPage);
			System.out.println("OLE Medicare Information Page, Medicare Info is entered and navigated back to Review Page");
			Assertion.assertTrue(true);
		}
		else
			Assertion.fail("Medicare Info data entry failed and user not navigated back to Review Page");
	}

	@Then("^the user validates cancellation and Save Return Later modal for OLE Page$")
	public void the_user_validates_cancellation_save_return_later_for_OLE_pages() throws Throwable {
		scenario.log("Sai - Change made 07/27- Validate to cancellation and save return --Aug Release");
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		medicareInfoPage.OpenCancelOLEPages();
		medicareInfoPage.OpensavereturnOLEPages();
		System.out.println("OLE cancellation and Save Return Later modal on OLE Pages");
		}
	}
	@Then("^the user validates logo image on OLE Pages$")
	public void the_user_validates_logo_image_for_OLE_pages() throws Throwable {
		
		scenario.log("Sai - Change made 07/27 - Validate logo image --Aug Release");
		PersonalInformationPage personalInformationPage = (PersonalInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE);
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		personalInformationPage.OpenLogoOLEPages();
		System.out.println("OLE logo image is clicked on OLE Pages");
		}
	}
	// note: added code to print test results note in jenkins report at the end of
	// test for successful cases
	@After
	public void testResultNote(Scenario scenario) {
		if (null != getLoginScenario().getBean(oleCommonConstants.TEST_RESULT_NOTE)) {
			@SuppressWarnings("unchecked")
			List<String> testNote1 = (List<String>) getLoginScenario().getBean(oleCommonConstants.TEST_RESULT_NOTE);
			for (String s : testNote1) {
				// scenario.write(s);
				scenario.log(s);
			}
			testNote1.clear();
		}
	}

	@Then("^the user cancels enrollment and navigates to homepage$")
	public void the_user_cancels_enrollment() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		CancelOLEModal cancelOLEmodal = welcomePage.OpenCancelOLE();
		if (cancelOLEmodal != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_LEARNMORE_MODAL_PAGE,
					cancelOLEmodal);
			System.out.println("OLE Cancellation Modal is Displayed");
			cancelOLEmodal.leaveApplication();
		}
		else
			Assertion.fail("OLE Cancellation Modal is NOT Displayed");
	}

	@And("^the user clicks on the heart icon on ole confirmation page$")
	public void the_user_clicks_on_the_shopping_cart_icon_on_Drug_details_page() {
		OLEconfirmationPage oleConfirmationPage = (OLEconfirmationPage) getLoginScenario()
				.getBean(OLE_PageConstants.OLE_CONFIRMATION_PAGE);
		VisitorProfilePage visitorProfilePage = oleConfirmationPage.clickOnShoppingCart();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@Then("^the user navigates to clicks on Enroll Now from Plan details page to start the OLE flow$")
	public void the_user_navgates_to_clicks_on_Enroll_Now_plandetails_page_to_start_the_OLE_flow(
			DataTable planAttributes) throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		
		// String PlanName = givenAttributesMap.get("Plan Name");
		String PlanType = givenAttributesMap.get("Plan Type");
		//String SiteName = (String) getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);
		PlanDetailsPage vppPlanDetailsPage= (PlanDetailsPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		WelcomePage welcomeOLEPage= vppPlanDetailsPage.NavigateToOLEEnrollDSNPPlanDetails(PlanType);

		if (welcomeOLEPage != null) {
			getLoginScenario().saveBean(PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomeOLEPage);
		} else {
			Assertion.fail("Error Loading Welcome Page for OLE");
		}
	}

	@Then("^the user selects payment type$")
	public void  the_user_selects_payment_type(DataTable arg1) throws Throwable {
		scenario.log("Sai - Change made 06/15 - Validate Payment Page on  OLE Page--Aug Release");
		boolean flag = false;
		Map<String, String> paymentInformationMap = new HashMap<String, String>();
		paymentInformationMap = DataTableParser.readDataTableAsMaps(arg1);
		
		String payType = paymentInformationMap.get("Payment Type");
		String cardNo = paymentInformationMap.get("Card No");
		getLoginScenario().saveBean(oleCommonConstants.CREDIT_CARD_NUMBER, cardNo);   //.substring(cardNo.length()-4));
		String cardExpirationMonth = paymentInformationMap.get("Card Expiration Month");
		String cardExpirationYear =  paymentInformationMap.get("Card Expiration Year");
		String cardExpirationDate = cardExpirationMonth + cardExpirationYear;
		getLoginScenario().saveBean(oleCommonConstants.CREDIT_CARD_EXPIRATION_DATE, cardExpirationDate);
		String cardHolderFirstName = paymentInformationMap.get("Card Holder First Name");
		String cardHolderLastName = paymentInformationMap.get("Card Holder Last Name");
		String cardHolderName = cardHolderFirstName+" "+cardHolderLastName;
		getLoginScenario().saveBean(oleCommonConstants.CREDIT_CARD_NAME_ON_CARD, cardHolderName);
		System.out.println("The payment type selected is "+payType);
		PlanPremiumPage planPremiumPage = (PlanPremiumPage) getLoginScenario().getBean(OLE_PageConstants.OLE_PLAN_PREMIUM_PAGE);
		getLoginScenario().saveBean(oleCommonConstants.PAYMENT_PLAN, payType);
		getLoginScenario().saveBean(oleCommonConstants.PAYMENT_METHOD, payType);
		paymentInformationMap.put("PlanPremium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));
		System.out.println("validate premium value");
		boolean result = planPremiumPage.validatePremiumValue(paymentInformationMap);
		if(!result)	{
			if(payType.equalsIgnoreCase("Pay by Mail")) {
				flag = planPremiumPage.validatePayByMail();
			}else if(payType.equalsIgnoreCase("Credit Card")) {
				flag = planPremiumPage.validateCreditCard(cardNo, cardExpirationMonth, cardExpirationYear, cardHolderName);	
			}else if(payType.equalsIgnoreCase("Social Security or Railroad Retirement Benefit")) {
				flag = planPremiumPage.validateSocialSecurity();	
			}
			if (flag) {
				System.out.println("Payment is passed");
				Assertion.assertTrue(true);
			}
			else {
				System.out.println("Payment is failed");
				Assertion.fail("Payment is failed");
			}


		}
		else {
			
		//	flag = planPremiumPage.validateNoMonthlyPremium();
			flag = planPremiumPage.validateNoPremium();
			if (flag) {
				System.out.println("No Monthly Premium validation is passed");
			//	Assertion.assertTrue(true);
			}
			else {
				System.out.println("No Monthly Premium validation is failed");
			//	Assertion.fail("No Monthly Premium validation is failed");
			}
		}
	}

	@Then("^the user validates TFN in Welcome OLE Right Rail PlanCompare$")
	public void the_user_validates_TFN_in_Right_Rail_PlanCompare() throws Throwable {
		/*WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		String TFN ="";
		boolean Validation_Status = welcomePage.ValidateTFN(TFN);

		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);

		if(Validation_Status){
			System.out.println("TFN, Wunderman Validation in OLE PAGE : "+Validation_Status+" - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("TFN, Wunderman Validation in OLE PAGE : "+Validation_Status);
			Assertion.fail();
		}*/
	}

	@Then("^the user validates Footer links on Welcome OLE Page$")
	public void the_user_validates_footer_links_welcome_OLE_Page() throws Throwable {
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
			WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
			//	String TFN = (String) getLoginScenario().getBean(oleCommonConstants.OLE_TFN);
			welcomePage.ValidateFooterEnrollmentChecklistLink();
			welcomePage.ValidateFooterListaVerificationLink();
		}
	}
	
	@Then("^the user validates Save Return Later modal for OLE Page$")
	public void the_user_validates_save_return_later_for_OLE_pages() throws Throwable {
		scenario.log("Sai - Change made 06/15 - Validate Save and Return Later  on OLE Pages");
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
	//	MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		welcomePage.OpensavereturnOLEPages();
		System.out.println("OLE cancellation and Save Return Later modal on OLE Pages");
		}
	}
	@Then("^the user validates Optional Benefits Page for following plans with available Riders in welcome page$")
	public void the_user_validate_optional_rider_welcome_OLE_Page(DataTable Flags) {
		scenario.log("Sai - Added on 06/15 - Validate optional Riders on Welcome OLE Page--Aug Release");
		Map<String, String> RiderFlagMap = new HashMap<String, String>();
		RiderFlagMap = DataTableParser.readDataTableAsMaps(Flags);
		String RiderFlag = RiderFlagMap.get("Rider Flag");
		if(RiderFlag.contains("true_yes") || RiderFlag.contains("true_no")){
			WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
			HashMap outputmap = new HashMap<Boolean,String>();
			outputmap = (HashMap) welcomePage.validate_Supplemental_Riders(RiderFlag);
			if (outputmap.containsKey(true)) {
				String optionalRider = outputmap.get(true).toString();
				getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
				getLoginScenario().saveBean(oleCommonConstants.OPTIONAL_RIDER_TEXT, optionalRider);
				Assertion.assertTrue(true);
				System.out.println("OLE Supplemental Benefits are displayed on welcome OLE Page");
			} else
				Assertion.fail("OLE Supplemental Benefits are not displayed on welcome OLE Page");

			}
	
	}
	
	@Then("^the user validates Statement of Understanding Page$")
	public void the_user_validates_SOA_Page(DataTable arg1) throws Throwable {
		scenario.log("Sai - Added on 06/15 - Validate SOA on OLE Page--Aug Release");
		
		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		AuthorizationPage sOAPage = (AuthorizationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_AUTHORIZATION_PAGE);
		boolean Validation_Status = sOAPage.validate_SOA_Page(MemberDetailsMap);
		if(Validation_Status){
		//	getLoginScenario().saveBean(OLE_PageConstants.OLE_SOA_PAGE,sOAPage);
			getLoginScenario().saveBean(oleCommonConstants.AUTHORIZATION_AGREE, MemberDetailsMap.get("soAAgree"));
			getLoginScenario().saveBean(oleCommonConstants.SOA_AGREE, MemberDetailsMap.get("soAAgree"));
			Assertion.assertTrue(true);
		} else {
			System.out.println("SOA Page : Required fields NOT validated");
			Assertion.fail("SOA Page : Required fields NOT validated");
		}
		// }
	}
	
	@Then("^the user navigate to Use and Disclosure Authorization page for CSNP Plans$")
	public void the_user_navigate_Use_Disclosure_Page() throws Throwable {
		scenario.log("Sai - Added on 06/22 - Validate Use and Disclosure Authorization on OLE Page--Aug Release");
		
		MedicareInformationPage useanddisclosurePage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		UseAndDisclosureAuthorizationPage useranddisclosure = useanddisclosurePage.navigate_to_usedisclosure_Page();		
		
		if (useranddisclosure != null) {
		getLoginScenario().saveBean(OLE_PageConstants.OLE_User_And_Disclosure_PAGE, useranddisclosure);
			System.out.println("OLE Use and Disclosure Page is Displayed");
			Assertion.assertTrue(true);
		} else {
			System.out.println("Use and Disclosure Page : Required fields NOT validated");
			Assertion.fail("Use and Disclosure Page : Required fields NOT validated");
		}
	
	}
	
	@Then("^the user validates the Plan details on OLE CSNP Plans$")
	public void the_user_validates_the_Plan_details_on_OLE_CSNP() throws Throwable {
		scenario.log("Sai - Change made 06/15 - Validate to Plan details --Aug Release");
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));		
		String Premium;	
		PlanDetailsMap.put("Plan Type", (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE));	
		boolean Validation_Status = welcomePage.validate_plan_details(PlanDetailsMap);
	//	boolean Validation_Status = welcomePage.validate_plan_details_CSNP(PlanDetailsMap);
		Premium = welcomePage.GetMonthlyPremiumValue();
		if (Validation_Status) {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status + " - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, Premium);
			Assertion.assertTrue(true);
		} else {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status);
			Assertion.fail();
		}
	}
	
	@Then("^the user validates Logo Image on Welcome OLE$")
	public void the_user_validates_Leave_OLE_modal_for_OLE() throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		welcomePage.ValidateLogoonWelcomeOLE();
		System.out.println("Click on LogoImage ->> Leave Online Application Back Buttons are displayed on welcome Pages");
		}
	}
	
	@Then("^the user validates the Prescription drug coverage questions in Medicare Information Page for PDP Plans$")
	public void the_user_validates_the_Prescription_drugcoverage_questions_in_Medicare_Information_Page_PDP_Plans(DataTable arg1)
			throws Throwable {

		Map<String, String> MemberDetailsMap = new HashMap<String, String>();
		MemberDetailsMap = DataTableParser.readDataTableAsMaps(arg1);
		
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		boolean medicareInfoPageLongTerm = medicareInfoPage.answer_following_questions_PrescriptionCoverage_PDP_Plans(MemberDetailsMap);
		if (medicareInfoPageLongTerm) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE,
					medicareInfoPage);
			System.out.println("OLE Prescription drug coverage Questions in Medicare Information Page - All required Member Details are entered");
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_DRUG, MemberDetailsMap.get("PDP Question"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_COVERAGE_NAME, MemberDetailsMap.get("Prescription Name"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_GROUP_NUMBER, MemberDetailsMap.get("PD Group Number"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_MEMBER_NUMBER, MemberDetailsMap.get("PD Member Number"));
			getLoginScenario().saveBean(oleCommonConstants.PRESCRIPTION_RXBIN_NUMBER, MemberDetailsMap.get("RX BIN Number"));
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Other Insurance Questions in Medicare Information Page - Adding Member Details Failed");
	}
	
	@Then("^the user validate widgets on Welcome OLE Page$")
	public void the_user_validates_widgtes_welcome_OLE(DataTable planAttributes) throws Throwable {
		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		String ExpectedTFNNo = givenAttributesMap.get("TFN No");	
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		welcomePage.ValidateWidgetsonWelcomeOLE(ExpectedTFNNo);
		System.out.println("Widgets are displayed on welcome Pages");
		}
	}
	@Then("^the user validate widgets on OLE Pages$")
	public void the_user_validates_widgtes_OLE_Pages(DataTable planAttributes) throws Throwable {
		MedicareInformationPage medicareInfoPage = (MedicareInformationPage) getLoginScenario().getBean(OLE_PageConstants.OLE_MEDICARE_INFO_PAGE);
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		String ExpectedTFNNo = givenAttributesMap.get("TFN No");	
		if (!(MRScenario.environment.equalsIgnoreCase("team-acme"))) {
		medicareInfoPage.ValidateWidgetsonOLEPages(ExpectedTFNNo);
	System.out.println("Widgets are displayed on welcome Pages");
	}
	}
	
	@Then("^the user selects the following options for new medicare SEP Page$")
	public void the_user_selects_the_following_options_for_NewMedicare_page(DataTable SEPoptions) throws Throwable {

		Map<String, String> SEPoptionsFlagMap = new HashMap<String, String>();
		SEPoptionsFlagMap = DataTableParser.readDataTableAsMaps(SEPoptions);

		String Selectoptions = SEPoptionsFlagMap.get("Select Options");
		String optionsData = SEPoptionsFlagMap.get("Option Data");

		SpecialElectionPeriodPage specialElectionPeriodPage = (SpecialElectionPeriodPage) getLoginScenario().getBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE);
		specialElectionPeriodPage = specialElectionPeriodPage.select_new_medicare_option(Selectoptions, optionsData);
		if (specialElectionPeriodPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_SPECIAL_ELECTION_PERIOD_PAGE,
					specialElectionPeriodPage);
			System.out.println("OLE SEP page Options Selected : Next Button enabled");
		} else
			Assertion.fail("OLE SEP page Options NOT Selected : Next Button NOT enabled");


	}
}