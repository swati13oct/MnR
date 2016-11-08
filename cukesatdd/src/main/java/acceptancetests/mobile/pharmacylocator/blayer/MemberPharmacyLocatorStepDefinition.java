/**
 * 
 */
package acceptancetests.mobile.pharmacylocator.blayer;

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
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;


import pages.mobile.member.blayer.BenefitsSummaryPage;
import pages.mobile.member.blayer.LoginPage;
import pages.mobile.member.blayer.PharmacyLocator;
import pages.mobile.member.blayer.PharmacyLocatorPage;
<<<<<<< HEAD
import pages.mobile.member.ulayer.PharmacyLocatorFilterPage;
import pages.mobile.member.ulayer.PharmacyLocatorFilterPage.ToolTip;
=======
>>>>>>> remotes/origin/develop
import acceptancetests.atdd.data.mobile.member.PageConstants;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.mobile.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.annotation.en_scouse.An;
import cucumber.table.DataTable;

/**
 * @author pjaising
 *
 */
public class MemberPharmacyLocatorStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the UHC medicare site mobile login page$")
	public void user_login_page()
	{
		WebDriver wd = getLoginScenario().getMobileWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}
	
	@When("^the user logs in with a registered UMS with following details in UHC site$")
	public void user_logs_in(DataTable memberAttributes)
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
		
		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
		
		
	}
		
	/*//	Get expected data
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
}*/
	
	@And("^the user validates plan and member details on benefits summary page in UHC site$")
	public void log_in_successful()
	{
		JSONObject benefitsSummaryActualJson = (JSONObject)getLoginScenario().getBean(LoginCommonConstants.BENEFITS_SUMMARY_ACTUAL);
		getLoginScenario().getBean(LoginCommonConstants.BENEFITS_SUMMARY_ACTUAL);
		System.out.println("benefitsSummaryActualJson----->"+benefitsSummaryActualJson);
		
		JSONObject benefitsSummaryExpectedJson = (JSONObject)getLoginScenario().getBean(LoginCommonConstants.BENEFITS_SUMMARY_EXPECTED);
		System.out.println("benefitsSummaryExpectedJson----->"+benefitsSummaryExpectedJson);
		
		try {
			JSONAssert.assertEquals(benefitsSummaryExpectedJson, benefitsSummaryActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage)getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		benefitsSummaryPage.logout();
		
	}
	
	@And("^user Clicks on Menu tab and click Pharmacy locator$")
	public void memberNavigatesToPharmacyLocator(){
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage)getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		PharmacyLocatorPage pharmacyLocatorPage = benefitsSummaryPage.navigateToPharmacyLocatorPage();
		getLoginScenario().saveBean(PageConstants.PHARMACY_LOCATOR_PAGE, pharmacyLocatorPage);	
 	}
	
	@Then("^user clicks on pharmacy locator link and validates the scenarios$")
	public void memberValidatesRequirement(){
	 	PharmacyLocatorPage pharmacyLocatorPage = (PharmacyLocatorPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_PAGE);
	 	pharmacyLocatorPage.narrowSearchValidation();
 	}
	
	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		// wd.close();
		wd.quit();
		getLoginScenario().flushBeans();
	}
	
	@Then("^the user navigates to Pharmacy Locator Landing Page page and Click on \"([^\"]*)\"$")
	public void navigateToPharmacyLocatorPage(String view){
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage)getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
 		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
		PharmacyLocatorPage pharmacyLocatorPage = benefitsSummaryPage.getPharmacyLocator(view);
		getLoginScenario().saveBean(PageConstants.PHARMACY_LOCATOR_PAGE, pharmacyLocatorPage);
		
	}
	
	@Then("^the user navigates to Pharmacy Locator Landing Page page$")
	public void navigateToPharmacyLocatorPage(){
		BenefitsSummaryPage benefitsSummaryPage = (BenefitsSummaryPage)getLoginScenario().getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
 		getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE, benefitsSummaryPage);
		PharmacyLocatorPage pharmacyLocatorPage = benefitsSummaryPage.getPharmacyLocator();
		getLoginScenario().saveBean(PageConstants.PHARMACY_LOCATOR_PAGE, pharmacyLocatorPage);
		
	}
	
	@And("^the user validates the red balloon markers will display for Preferred Pharmacy$")
	public void validatePreferredPharmacy(){
		PharmacyLocatorPage pharmacyLocatorPage = (PharmacyLocatorPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_PAGE);
		pharmacyLocatorPage.validatePreferredPharmacyNetwork();
	}
	@And("^the user validates the red markers will display for Pharmacy Saver$")
	public void validatePharmacySaver(){
		PharmacyLocatorPage pharmacyLocatorPage = (PharmacyLocatorPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_PAGE);
		pharmacyLocatorPage.validatePharmacySaverPharmacy();
	}
	@And("^the user validates the blue markers will display for Standard Network Pharmacy$")
	public void validateStandardPharmacy(){
		PharmacyLocatorPage pharmacyLocatorPage = (PharmacyLocatorPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_PAGE);
		pharmacyLocatorPage.validateStandardNetworkPharmacy();
	}
	
	@And("^the user validate the first pharmacy results$")
	public void validateFirstPharmacyResult(){
		PharmacyLocatorPage pharmacyLocatorPage = (PharmacyLocatorPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_PAGE);
		pharmacyLocatorPage.firstPharmacyResult();
	}
	
	@And("^the user clicks on filter button on the page$")
	public void clickOnFilter(){
	
		PharmacyLocatorPage pharmacyLocatorPage = (PharmacyLocatorPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_PAGE);
		PharmacyLocatorFilterPage pharmacyLocatorFilterPage = pharmacyLocatorPage.clickOnFilterButton();
		getLoginScenario().saveBean(PageConstants.PHARMACY_LOCATOR_FILTER_PAGE, pharmacyLocatorFilterPage);
	}
	
	@And("^validates the two tool tips$")
	public void validateToolTipsOnFilterPage(){
		PharmacyLocatorFilterPage pharmacyLocatorFilterPage = (PharmacyLocatorFilterPage) getLoginScenario().getBean(PageConstants.PHARMACY_LOCATOR_FILTER_PAGE);
		pharmacyLocatorFilterPage.validateToolTip(ToolTip.PHARMACY_SAVER);
	}
}
