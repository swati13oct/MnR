package acceptancetests.mobile.acquisition.ole;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.acquisition.ole.WelcomePage;
import pages.mobile.acquisition.commonpages.PlanDetailsPageMobile;
import pages.mobile.acquisition.commonpages.VisitorProfilePageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;

public class oleCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user navigates to clicks on Enroll Now from visitor profile to start OLE flow$")
	public void the_user_navgates_to_clicks_on_Enroll_Now_From_VisitorProfile_flow(DataTable planAttributes)
			throws Throwable {

		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planAttributes);
		/*
		 * List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
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
		WelcomePageMobile welcomePage;
		if (SiteName.contains("UHC_ACQ")) {
			VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
					.getBean(PageConstants.VISITOR_PROFILE_PAGE);
			// TFN = planSummaryPage.GetTFNforPlanType();

			welcomePage = visitorProfilePage.Enroll_OLE_Plan(PlanName);

		} else {
			VisitorProfilePageMobile visitorProfilePage = (VisitorProfilePageMobile) getLoginScenario()
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

	@Then("^the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site$")
	public void the_user_clicks_on_Enroll_Now_in_Plan_Details_Page_to_start_the_OLE_flow() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);

		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		// (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = "";
		// (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		String PlanType = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_TYPE);
		String TFN;
		// String SiteName= (String)
		// getLoginScenario().getBean(oleCommonConstants.ACQ_SITE_NAME);

		/*
		 * WelcomePage welcomePage; if(SiteName.contains("UHC_ACQ")){ PlanDetailsPage
		 * vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
		 * .getBean(PageConstants.VPP_PLAN_DETAILS_PAGE); TFN =
		 * vppPlanDetailsPage.GetTFNforPlanType(); welcomePage =
		 * vppPlanDetailsPage.Enroll_OLE_Plan(PlanName); } else{
		 */
		PlanDetailsPageMobile vppPlanDetailsPage = (PlanDetailsPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		TFN = vppPlanDetailsPage.GetTFNforPlanType();
		WelcomePageMobile welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		// }
		String PlanPremium = "";
		// (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		// getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
		System.out.println("Plan Name is : " + PlanName);
		System.out.println("Plan Type is : " + PlanType);
		System.out.println("Plan Zip Code is : " + ZipCode);
		System.out.println("Plan County Name is : " + County);
		System.out.println("Plan Plan Premium is : " + PlanPremium);
		System.out.println("TFN for Plan Type is : " + TFN);
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




}
