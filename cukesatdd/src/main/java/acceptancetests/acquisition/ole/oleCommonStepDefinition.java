package acceptancetests.acquisition.ole;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Then;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.ole.WelcomePage;

public class oleCommonStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site$")
	public void the_user_clicks_on_Enroll_Now_in_Plan_Details_Page_to_start_the_OLE_flow() throws Throwable {
		String PlanName = (String) getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME);
		String PlanYear = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR);

		String ZipCode = (String) getLoginScenario().getBean(VPPCommonConstants.ZIPCODE);
		String County = (String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
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
		PlanDetailsPage vppPlanDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_DETAILS_PAGE);
		TFN = vppPlanDetailsPage.GetTFNforPlanType();
		WelcomePage welcomePage = vppPlanDetailsPage.Enroll_OLE_Plan(PlanName);
		// }
		String PlanPremium = (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM);
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
			Assert.assertTrue(true);
		} else
			Assert.fail("Error in validating the OLE Welcome Page");

	}

	@Then("^The User validates the Plan details on OLE page$")
	public void the_user_validates_the_Plan_details_on_OLE() throws Throwable {

		WelcomePage welcomePage = (WelcomePage) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		Map<String, String> PlanDetailsMap = new HashMap<String, String>();
		PlanDetailsMap.put("Plan Name", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_NAME));
		PlanDetailsMap.put("Plan Year", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_YEAR));
		PlanDetailsMap.put("Zip Code", (String) getLoginScenario().getBean(oleCommonConstants.OLE_ZIPCODE));
		PlanDetailsMap.put("County", (String) getLoginScenario().getBean(oleCommonConstants.OLE_COUNTY));
		PlanDetailsMap.put("Plan Premium", (String) getLoginScenario().getBean(oleCommonConstants.OLE_PLAN_PREMIUM));

		boolean Validation_Status = welcomePage.validate_plan_details(PlanDetailsMap);
		if (Validation_Status) {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status + " - Validation Passed");
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			Assert.assertTrue(true);
		} else {
			System.out.println("Plan Details Validation in OLE PAGE : " + Validation_Status);
			Assert.fail();
		}
	}

}
