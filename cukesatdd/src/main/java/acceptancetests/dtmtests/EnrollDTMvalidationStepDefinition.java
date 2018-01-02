package acceptancetests.dtmtests;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AdditionalInformationPage;
import pages.acquisition.ulayer.BeneficiaryInformationPage;
import pages.acquisition.ulayer.IntroductionInformationPage;
import pages.acquisition.ulayer.PlanInformationPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.enrollinplan.data.EnrollInPlanCommonConstants;
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

public class EnrollDTMvalidationStepDefinition {
 
	@Autowired
	MRScenario loginScenario; 
	private Object beneficiaryInformationPage;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the AARP site landing page$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();
		
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd); 
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	@When("^user performs plan search using following information on AARP site$")
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

			/*try {
				JSONAssert.assertEquals(planSummaryExpectedJson,
						planSummaryActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	@And("^the user views plans of the below plan type on AARP site$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_TYPE, plantype);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

		if (plansummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE,
					plansummaryPage);
			/* Get actual data */
			JSONObject planSummaryActualJson = plansummaryPage.vppPlanSummaryJson;
			getLoginScenario().saveBean(
					VPPCommonConstants.VPP_PLAN_SUMMARY_ACTUAL,
					planSummaryActualJson);

			/* Get expected data */
			String fileName = null;
			if (plantype.equalsIgnoreCase("MA")
					|| plantype.equalsIgnoreCase("MAPD")) {
				fileName = "maplans";
			} else {
				fileName = plantype.toLowerCase() + "plans";
			}
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);
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

			try {
				JSONAssert.assertEquals(planSummaryExpectedJson,
						planSummaryActualJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	@And("^the user click on enroll link  for the below plan on AARP site$")
	public void user_clicks_on_enroll_link(DataTable planAttributes)
	{
		String planName = planAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(EnrollInPlanCommonConstants.PLAN_NAME,
				planName);
		
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		IntroductionInformationPage introInformationPage= planSummaryPage.navigatetoEnrollInplanLinkpage(planName);
		if (introInformationPage!=null)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail("Error in loading Step 1");
		}
		
		
		getLoginScenario().saveBean(PageConstants.INTRODUCTION_INFORMATION_PAGE,introInformationPage);
	}
	
	

	@When("^user accesses global footer of the AARP home page$")
	public void access_global_footer() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject globalFooterActual = aquisitionhomepage.accessGlobalFooter();
		/* Get expected data */
		String fileName = "globalfooterexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_FOOTER_FLOW_NAME
				+ File.separator;
		JSONObject globalFooterExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_FOOTER_ACTUAL,
				globalFooterActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_FOOTER_EXPECTED,
				globalFooterExpectedJson);
		
		try {
			JSONAssert.assertEquals(globalFooterActual, globalFooterActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Then("^the user validates the DTM tags for links in footer section of the AARP home page$")
	public void validates_dtm_tags_in_footer_section()
	{
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject actaulFooterDTMjson = aquisitionhomepage.validatesDTMTags();
		
		/* Get expected data */
		String fileName = "dtm_globalfooterexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator +CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_FOOTER_FLOW_NAME
				+ File.separator;
		JSONObject expectedFooterDTMjson = MRScenario.readExpectedJson(
				fileName, directory);
		
		try {
			JSONAssert.assertEquals(expectedFooterDTMjson, actaulFooterDTMjson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	@And("^the user fill following information in introduction information step on AARP site$")
	public void user_fill_information_introduction_information_aarp(
			DataTable personalAttributes) {

		List<DataTableRow> personalAttributesRow = personalAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells().get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
		introInformationPage.entersmedicareinsuranceInformation(personalAttributesMap);
		//introInformationPage.navigatesToNextStep();
			getLoginScenario().saveBean(PageConstants.INTRODUCTION_INFORMATION_PAGE,introInformationPage);
			

	}
	
	@And("^the user navigates to beneficiary information step in AARP site$")
	public void the_user_navigates_beneficiary_information_step_aarp() {
		/*IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
	
		BeneficiaryInformationPage beneficiaryInformationPage = introInformationPage.navigatesToNextStep();
		 getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,beneficiaryInformationPage);*/
		
		IntroductionInformationPage introInformationPage = (IntroductionInformationPage) getLoginScenario()
				.getBean(PageConstants.INTRODUCTION_INFORMATION_PAGE);
	
		BeneficiaryInformationPage beneficiaryInformationPage = introInformationPage.navigatesToNextStep();
		 getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,beneficiaryInformationPage);
	
		if (beneficiaryInformationPage != null) {
			/* Get actual data */
			JSONObject beneficiaryInformationActual = beneficiaryInformationPage.beneficiaryInformationJson;

			/* Get expected data */
			String planName = (String) getLoginScenario().getBean(
					EnrollInPlanCommonConstants.PLAN_NAME);

			String fileName = planName;
			String zipcode = (String) getLoginScenario().getBean(
					VPPCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					VPPCommonConstants.COUNTY);

			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_ULAYER
					+ File.separator
					+ VPPCommonConstants.ENROLL_IN_PLAN_FLOW_NAME
					+ File.separator
					+ EnrollInPlanCommonConstants.BENEFICIARY_INFORMATION
					+ File.separator + zipcode + File.separator + county
					+ File.separator;
			JSONObject beneInformationExpected = MRScenario.readExpectedJson(fileName, directory);

		//	beneInformationExpected = mergeWithCommonExpectedData(fileName, beneInformationExpected);

			System.out.println("introInformationExpected:::"
					+ beneInformationExpected);
			System.out.println("introInformationActual:::"
					+ beneficiaryInformationActual);

			try {
				JSONAssert.assertEquals(beneInformationExpected,
						beneficiaryInformationActual, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Assert.fail("ERROR loading BeneficiaryInformationPage");
		}

	}
	@And("^the user validate DTM object  on beneficiary information$")
	public void dtmobject_validation_on_beneficiary_information_step_aarp() {
		BeneficiaryInformationPage beneficiaryInformationPage=(BeneficiaryInformationPage) getLoginScenario().getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		 
			JSONObject actualOleDTMjson = beneficiaryInformationPage.validatesDTMobj();
			
			System.out.println("actualOleDTMjson::"+actualOleDTMjson);
			/* Get expected data */
			String fileName = "dtm_ole";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator +CommonConstants.SITE_ULAYER
					+ File.separator
					+ AcquistionCommonConstants.OLE_DTM_FLOW_NAME
					+ File.separator;
			JSONObject expectedOleDTMjson = MRScenario.readExpectedJson(
					fileName, directory);
			System.out.println("expectedOleDTMjson::"+expectedOleDTMjson);
			try {
				JSONAssert.assertEquals(expectedOleDTMjson, actualOleDTMjson,
						true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		
		
	}
	@And("^the user fill following information in beneficiary information step on AARP site$")
	public void user_fill_information_beneficiary_information_aarp(
			DataTable personalAttributes) {

		List<DataTableRow> personalAttributesRow = personalAttributes
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		beneficiaryInformationPage.entersPersonalInformation(personalAttributesMap);
		
		getLoginScenario().saveBean(PageConstants.BENEFICIARY_INFORMATION_PAGE,	beneficiaryInformationPage);
		
		

	}
	@And("^the user is on the special election period page$")
	public void user_is_on_() {
		BeneficiaryInformationPage beneficiaryInformationPage = (BeneficiaryInformationPage) getLoginScenario()
				.getBean(PageConstants.BENEFICIARY_INFORMATION_PAGE);
		String planName = (String) getLoginScenario().getBean(
				EnrollInPlanCommonConstants.PLAN_NAME);
		
		
		
		AdditionalInformationPage additionalInformation = beneficiaryInformationPage.navigatesToStep2Part2(planName);
		getLoginScenario().saveBean(PageConstants.ADDITIONAL_INFORMATION_PAGE,
				additionalInformation);
		
		JSONObject actualOleDTMjsonPart2 = additionalInformation.validatesDTMobjPart2();
		
		
		/* Get expected data */
		String fileName = "dtm_ole_part2";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator +CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.OLE_DTM_FLOW_NAME
				+ File.separator;
		JSONObject expectedOleDTMjson = MRScenario.readExpectedJson(
				fileName, directory);
		System.out.println("expectedOleDTMjson::"+expectedOleDTMjson);
		System.out.println("actualOleDTMjsonPart2::"+actualOleDTMjsonPart2);
		try {
			JSONAssert.assertEquals(expectedOleDTMjson, actualOleDTMjsonPart2,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}  
	}

}
