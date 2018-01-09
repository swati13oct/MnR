/**
 * 
 */
package acceptancetests.mobile.plandetail.blayer;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.mobile.member.blayer.BenefitDetailsPage;
import pages.mobile.member.blayer.BenefitsSummaryPage;
import pages.mobile.member.blayer.LoginPage;
import pages.mobile.member.blayer.PreferredDrugBenefitsDetailPage;
import acceptancetests.atdd.data.mobile.member.PageConstants;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.mobile.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pjaising
 *
 */
public class PlanDetailUhcStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the UHC medicare site mobile login page$")
	public void user_login_page_UHC()
	{
		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@When("^the user logs in with a registered UMS with following details in UHC site$")
	public void UHC_user_logs_in(DataTable memberAttributes)
	{
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		desiredAttributes.add("mobile");
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String,String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a "+ desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd );
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}
		
		LoginPage loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
		
		BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);
		
		/*Get expected data*/
		Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject benefitsSummaryExpectedJson = benefitsSummaryPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_SUMMARY_EXPECTED, benefitsSummaryExpectedJson);
		
		JSONObject benefitsSummaryActualJson =  null;
		if (benefitsSummaryPage != null) {
			getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
			benefitsSummaryActualJson = benefitsSummaryPage.benefitsSummaryJson;
			getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_SUMMARY_ACTUAL, benefitsSummaryActualJson);
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	}
	
@And("^the user navigates to benefits and coverage details of Annual Deductible UHC page$")
	
	public void UHC_user_navigates_to_details_page()
	
	{
	
	BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
	.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
	
	BenefitDetailsPage benefitsDetailPage = benefitsSummaryPage.clickviewdrugdetails();
	
	Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
	JSONObject benefitsDetailExpectedJson = benefitsDetailPage.getExpectedData(expectedDataMap);
	getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);
	
	JSONObject benefitsDetailActualJson =  null;
	if (benefitsDetailPage != null) {
		getLoginScenario().saveBean(PageConstants.BENEFITS_DETAIL_PAGE, benefitsDetailPage);
		benefitsDetailActualJson = benefitsDetailPage.benefitsDetailJson;
		getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
	}

	getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	
	}

@And("^the user navigates to benefits and coverage details of UHC page with the initial coverage stage$")

public void user_navigates_to_details_UHC_page_initial_coverage_stage()
{
	BenefitDetailsPage benefitsDetailPage = (BenefitDetailsPage) getLoginScenario()
.getBean(PageConstants.BENEFITS_DETAIL_PAGE);

 benefitsDetailPage.click2ndstagearrow();
 
 benefitsDetailPage.validateInitialCoverageStage();

Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
JSONObject benefitsDetailExpectedJson = benefitsDetailPage.getExpectedData(expectedDataMap);
getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);

JSONObject benefitsDetailActualJson =  null;
if (benefitsDetailPage != null) {
	getLoginScenario().saveBean(PageConstants.BENEFITS_DETAIL_PAGE, benefitsDetailPage);
	benefitsDetailActualJson = benefitsDetailPage.benefitsDetailJson;
	getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
}

getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);

}

@And("^the user navigates to benefits and coverage details of UHC page with the coverage gap stage$")

public void user_navigates_to_details_UHC_page_coverage_gap_stage()

{

	BenefitDetailsPage benefitsDetailPage = (BenefitDetailsPage) getLoginScenario()
.getBean(PageConstants.BENEFITS_DETAIL_PAGE);

benefitsDetailPage.click2ndstagearrow();

benefitsDetailPage.validateCoverageStageGap();

Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
JSONObject benefitsDetailExpectedJson = benefitsDetailPage.getExpectedData(expectedDataMap);
getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);

JSONObject benefitsDetailActualJson =  null;
if (benefitsDetailPage != null) {
getLoginScenario().saveBean(PageConstants.BENEFITS_DETAIL_PAGE, benefitsDetailPage);
benefitsDetailActualJson = benefitsDetailPage.benefitsDetailJson;
getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
}

getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);


}

@And("^the user navigates to benefits and coverage details of UHC page with the catastrophic coverage stage$")

public void user_navigates_to_details_UHC_page_catastrophic_coverage_stage()
{
	BenefitDetailsPage benefitsDetailPage = (BenefitDetailsPage) getLoginScenario()
.getBean(PageConstants.BENEFITS_DETAIL_PAGE);

benefitsDetailPage.click2ndstagearrow();

benefitsDetailPage.validateCatastrophicCoverageStage();

Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
JSONObject benefitsDetailExpectedJson = benefitsDetailPage.getExpectedData(expectedDataMap);
getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);

JSONObject benefitsDetailActualJson =  null;
if (benefitsDetailPage != null) {
getLoginScenario().saveBean(PageConstants.BENEFITS_DETAIL_PAGE, benefitsDetailPage);
benefitsDetailActualJson = benefitsDetailPage.benefitsDetailJson;
getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
}

getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
}	


	@And("^the user navigates to my preferred drug benefits of Annual Deductible UHC preferred drug details page$")
	public void UHC_user_navigates_to_Preferred_Details_Page()
	{
		
	BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
	.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
	
	PreferredDrugBenefitsDetailPage benefitsDetail_PreferredPage = benefitsSummaryPage.clickPreferredDrugViewDetails();
	
	Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
	JSONObject benefitsDetailExpectedJson = benefitsDetail_PreferredPage.getExpectedData(expectedDataMap);
	getLoginScenario().saveBean(LoginCommonConstants.PREFERRED_DRUG_BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);
	
	JSONObject benefitsDetailActualJson =  null;
	if (benefitsDetail_PreferredPage != null) {
		getLoginScenario().saveBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE, benefitsDetail_PreferredPage);
		benefitsDetailActualJson = benefitsDetail_PreferredPage.benefitsDetailJson;
		getLoginScenario().saveBean(LoginCommonConstants.PREFERRED_DRUG_BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
	}
	
	getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	
	}

	@And("^the user navigates to benefits and coverage details of UHC preferred drug details page with the initial coverage stage$")

	public void user_navigates_to_details_UHC_Preferred_Details_Page_initial_coverage_stage()

	{

		PreferredDrugBenefitsDetailPage benefitsDetail_PreferredPage = (PreferredDrugBenefitsDetailPage) getLoginScenario()
	.getBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE);

		benefitsDetail_PreferredPage.click2ndstagearrow();
		
		benefitsDetail_PreferredPage.validateInitialCoverageStage();

	Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
	JSONObject benefitsDetailExpectedJson = benefitsDetail_PreferredPage.getExpectedData(expectedDataMap);
	getLoginScenario().saveBean(LoginCommonConstants.PREFERRED_DRUG_BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);

	JSONObject benefitsDetailActualJson =  null;
	if (benefitsDetail_PreferredPage != null) {
		getLoginScenario().saveBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE, benefitsDetail_PreferredPage);
		benefitsDetailActualJson = benefitsDetail_PreferredPage.benefitsDetailJson;
		getLoginScenario().saveBean(LoginCommonConstants.PREFERRED_DRUG_BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
	}

	getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);


	}

	@And("^the user navigates to benefits and coverage details of UHC preferred drug details page with the coverage gap stage$")

	public void user_navigates_to_details_UHC_Preferred_Details_Page_coverage_gap_stage()

	{

	PreferredDrugBenefitsDetailPage benefitsDetail_PreferredPage = (PreferredDrugBenefitsDetailPage) getLoginScenario()
	.getBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE);

	benefitsDetail_PreferredPage.click2ndstagearrow();
	
	benefitsDetail_PreferredPage.validateCoverageStageGap();

	Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
	JSONObject benefitsDetailExpectedJson = benefitsDetail_PreferredPage.getExpectedData(expectedDataMap);
	getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);
	System.out.println("benefitsDetailExpectedJson----->"+benefitsDetailExpectedJson);
	JSONObject benefitsDetailActualJson =  null;
	if (benefitsDetail_PreferredPage != null) {
	getLoginScenario().saveBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE, benefitsDetail_PreferredPage);
	benefitsDetailActualJson = benefitsDetail_PreferredPage.benefitsDetailJson;
	getLoginScenario().saveBean(LoginCommonConstants.PREFERRED_DRUG_BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
	}

	getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);


	}

	@And("^the user navigates to benefits and coverage details of UHC preferred drug details page with the catastrophic coverage stage$")

	public void user_navigates_to_details_UHC_Preferred_Details_Page_catastrophic_coverage_stage()

	{

	PreferredDrugBenefitsDetailPage benefitsDetail_PreferredPage = (PreferredDrugBenefitsDetailPage) getLoginScenario()
	.getBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE);

	benefitsDetail_PreferredPage.click2ndstagearrow();
	
	benefitsDetail_PreferredPage.validateCatastrophicCoverageStage();

	Map<String,JSONObject> expectedDataMap = loginScenario.getExpectedJson(getLoginScenario().getBean(LoginCommonConstants.USERNAME).toString());
	JSONObject benefitsDetailExpectedJson = benefitsDetail_PreferredPage.getExpectedData(expectedDataMap);
	getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_EXPECTED, benefitsDetailExpectedJson);

	JSONObject benefitsDetailActualJson =  null;
	if (benefitsDetail_PreferredPage != null) {
	getLoginScenario().saveBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE, benefitsDetail_PreferredPage);
	benefitsDetailActualJson = benefitsDetail_PreferredPage.benefitsDetailJson;
	getLoginScenario().saveBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL, benefitsDetailActualJson);
	}
	getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP, expectedDataMap);
	}

	@Then("^the user validates plan and member details on benefits details page in UHCM site$")
	public void UHC_log_successful()
	{
		JSONObject benefitsDetailActualJson = (JSONObject)getLoginScenario().getBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL);
		System.out.println("benefitsDetailActualJson----->"+benefitsDetailActualJson);
		
		BenefitDetailsPage benefitsDetailPage = (BenefitDetailsPage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_DETAIL_PAGE);
		try {
			Assert.assertEquals(benefitsDetailPage.getPlanName().getText(), benefitsDetailActualJson.getJSONArray("planName").getJSONObject(0).get("planName"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^the user validates plan and member details on preferred drug details page in UHCM site$")
	public void preferred_Drug_Benefits_UHC_log_successful()
	{
		JSONObject benefitsDetailActualJson = (JSONObject)getLoginScenario().getBean(LoginCommonConstants.BENEFITS_DETAIL_ACTUAL);
		System.out.println("benefitsDetailActualJson----->"+benefitsDetailActualJson);
		
		PreferredDrugBenefitsDetailPage benefitsDetail_PreferredPage = (PreferredDrugBenefitsDetailPage) getLoginScenario()
				.getBean(PageConstants.PREFERRED_DRUG_BENEFITS_DETAIL_PAGE);
		try {
			Assert.assertEquals(benefitsDetail_PreferredPage.getPlanName().getText(), benefitsDetailActualJson.getJSONArray("planName").getJSONObject(0).get("planName"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	