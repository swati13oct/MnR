package acceptancetests.mobile.acquisition.ole;

import gherkin.formatter.model.DataTableRow;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ole.WelcomePage;
import pages.mobile.acquisition.ulayer.VPPPlanSummaryPageMobile;
import pages.mobile.acquisition.bluelayer.AcquisitionHomePageMobile;
import pages.mobile.acquisition.planrecommendationengine.CoverageOptionsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;
import pages.mobile.acquisition.planrecommendationengine.HeaderFooterMobile;
import pages.mobile.acquisition.planrecommendationengine.LandingAndZipcodeMobilePage;
import pages.mobile.acquisition.planrecommendationengine.LoadingMobilePage;
import pages.mobile.acquisition.planrecommendationengine.PharmacyMobilePage;
import pages.mobile.acquisition.planrecommendationengine.ResultsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.SpecialNeedsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.TravelMobilePage;
import pages.mobile.acquisition.planrecommendationengine.AdditionalServicesMobilePage;
import pages.mobile.acquisition.planrecommendationengine.CommonutilitiesMobile;
import pages.mobile.acquisition.planrecommendationengine.CostPreferencesMobilePage;
import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OLEStepDefinitionMobile {

	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	AppiumDriver wd;


@Then("^the user clicks on Enroll Now for AARP site to start the OLE flow on Mobile$")
public void the_user_clicks_on_Enroll_Now_to_start_the_OLE_flow_Mobile(DataTable planAttributes) throws Throwable {
/*
	List<DataTableRow> givenAttributesRow = planAttributes.getGherkinRows();
	Map<String, String> givenAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < givenAttributesRow.size(); i++) {

		givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
				givenAttributesRow.get(i).getCells().get(1));
	}
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
	if(SiteName.contains("UHC_ACQ")){
		pages.mobile.acquisition.bluelayer.VPPPlanSummaryPage planSummaryPage = (pages.mobile.acquisition.bluelayer.VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		TFN = planSummaryPage.GetTFNforPlanType();

		//PlanPremium = planSummaryPage.getPlanPremium(PlanName);
		welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName,PlanType);

	}
	else{
		VPPPlanSummaryPageMobile planSummaryPage = (VPPPlanSummaryPageMobile) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		TFN = planSummaryPage.GetTFNforPlanType();

		//PlanPremium = planSummaryPage.getPlanPremium(PlanName);
		welcomePage = planSummaryPage.Enroll_OLE_Plan(PlanName,PlanType);

	} //--------------------------------------------------------------------------------------------------------------------
	
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, PlanName);
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, PlanType);
	getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, ZipCode);
	getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, County);
	getLoginScenario().saveBean(oleCommonConstants.ACQ_SITE_NAME, SiteName);
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, PlanYear);
	getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_PREMIUM, PlanPremium);
	getLoginScenario().saveBean(oleCommonConstants.OLE_TFN, TFN);
	System.out.println("Plan Name is : "+PlanName);
	System.out.println("Plan Type is : "+PlanType);
	System.out.println("Plan Zip Code is : "+ZipCode);
	System.out.println("Plan County Name is : "+County);
	System.out.println("Plan Plan Premium is : "+PlanPremium);
	System.out.println("TFN for Plan Type is : "+TFN);
	System.out.println("Plan Year is : "+PlanYear);
	System.out.println("OLE is being started from Acquisition Site : "+SiteName);

	if (welcomePage != null) {
		getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE,
				welcomePage);
		System.out.println("OLE Welcome Page is Displayed");
		Assert.assertTrue(true);
	}
	else
		Assert.fail("Error in validating the OLE Welcome Page");*/
}
}