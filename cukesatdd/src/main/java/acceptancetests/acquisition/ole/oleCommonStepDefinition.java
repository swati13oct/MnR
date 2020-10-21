package acceptancetests.acquisition.ole;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.commonpages.VisitorProfilePage;

public class oleCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Then("^the user navigates to clicks on Enroll Now from visitor profile to start OLE flow$")
	public void the_user_navgates_to_clicks_on_Enroll_Now_From_VisitorProfile_flow(DataTable planAttributes) throws Throwable {

		List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
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
		//-----------------------------------------------------------------------------------------------------
		WelcomePage welcomePage;			
			if(SiteName.contains("UHC_ACQ")){
				VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
						.getBean(PageConstants.VISITOR_PROFILE_PAGE);
				//TFN = planSummaryPage.GetTFNforPlanType();

				welcomePage = visitorProfilePage.Enroll_OLE_Plan(PlanName);

			}
			else{
				VisitorProfilePage visitorProfilePage = (VisitorProfilePage) getLoginScenario()
						.getBean(PageConstants.VISITOR_PROFILE_PAGE);
				//TFN = planSummaryPage.GetTFNforPlanType();

				welcomePage = visitorProfilePage.Enroll_OLE_Plan(PlanName);

			}
			
		//--------------------------------------------------------------------------------------------------------------------
		
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
		getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
		System.out.println("Plan Name is : "+PlanName);
		System.out.println("Plan Type is : "+PlanType);
		System.out.println("Plan Zip Code is : "+ZipCode);
		System.out.println("Plan County Name is : "+County);
		System.out.println("Plan Plan Premium is : "+PlanPremium);
		System.out.println("Plan Year is : "+PlanYear);
		System.out.println("OLE is being started from Acquisition Site : "+SiteName);

		if (welcomePage != null) {
			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
					welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Error in validating the OLE Welcome Page");
	}

}
