package acceptancetests.pharmacylocator.member.bluelayer;

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

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.PharmacyResultPage;
import pages.member.bluelayer.PharmacySearchPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.pharmacylocator.data.PharmacySearchCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */
public class PharmacyLocatorMemberUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member to verify locate a pharmacy in UMS Site$")
	public void registered_member_located_pharmacy_ums(
			DataTable memberAttributes) {

		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String category = memberAttributesMap.get("Member Type");

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

		
		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
		//JSONObject accountHomeActualJson = null;
		
		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);*/

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			/*Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;*/
		}

		/*try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/
	}

	@When("^the user navigates to pharmacy search page in UMS site$")
	public void user_views_pharmacy_locator() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacyLocator();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}
	
	@Then("^the user searches for pharmaciy search results available in UMS site$")
	public void user_views_pharmacy_search_result_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacyLocatorSearchResults();	
	}
	
	@Then("^the user validate Pharmacy Saver pharmacies and red balloon marker available in UMS site$")
	public void user_views_pharmacy_saver_pharmacies_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPharmacySaverPharmaciesSearchResults();	
	}
	
	@Then("^the user validate multiple language dropdown menu in UMS site$")
	public void user_views_multiple_language_dropdown_result_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateTomultipleLanguageDropdownResultsearch();		
	}
	
	@Then("^the user validates the Preferred Mail service Pharmacy widget available in UMS site$")
	public void user_views_prefered_mail_service_widget_available_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPreferedMailServiceWidgetResult();		
	}
	
	@Then("^the user validates the PRPN search result and red balloon marker available in UMS site$")
	public void user_views_prpn_search_result_ballon_marker_available_ums() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage
				.navigateToPrpnSearchAndBallonMarkerResult();		
	}
	
	@Then("^the user validate ninty days filter available in UMS site$")
	public void user_views_ninty_days_available_result_ums() {
try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.PHARMACYSEARCH_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.PHARMACYSEARCH_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@And("^the user validates Non AEP plan year and type in pharmaciy search results available in UMS site$")
	public void user_views_non_aep_available_in_ums() {
try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.PHARMACYSEARCH_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.PHARMACYSEARCH_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@And("^the user validates AEP plan year and type in pharmaciy search results available in UMS site$")
	public void user_views_aep_available_in_ums() {
try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.PHARMACYSEARCH_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.PHARMACYSEARCH_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the user validates Search checkbox displayed dynamically related to the pharmacy network$")
	public void validates_Pharmacy_Network_Displayed_Dynamically_UMS(){
		PharmacySearchPage PharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage.clickOnShowPharmaciesForTheseServices();		
		
		//PharmacySearchPage.logOut();
		
	}
	

	@And("^the user search pharmacies using the below information in UMS site$")
	public void user_enters_zipcode_distance_details(DataTable zipAttributes) {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage
				.enterZipDistanceDetails(zipAttributesMap);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}
	@And("^the user clicks espanolLink in UMS Site$")
	public void click_espanol() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickEspanol();   //story 261070
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	
	@And("^the user clicks chineseLink in UMS Site$")
	public void click_chinese() {

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
		
	}

	@And("the user chooses a plan from dropdown in UMS site")
	public void user_chooses_plan_dropdown_ums_site(DataTable planAttributes)
	{
		List<DataTableRow> planAttributesRow = planAttributes.getGherkinRows();
		String planName = planAttributesRow.get(0).getCells().get(3);

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		
		pharmacySearchPage = pharmacySearchPage
				.selectsPlanName(planName);
		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.searchesPharmacy();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}
	
	@And("^the user clicks create pdf  in UMS Site$")
	public void click_create_pdf() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickCreatePdf();
	}
	

	@And("^the user searches for pharmacies available in UMS site$")
	public void user_pharmacy_available_aarp() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String[] pharmacyTypeArray = (String[]) getLoginScenario().getBean(
				PageConstants.PHARMACY_TYPES);
		String expectedObjectkey = pharmacySearchPage
				.getExpectedKey(pharmacyTypeArray);
		System.out.println("pharmacyTypeArray"+pharmacyTypeArray);

		PharmacyResultPage pharmacyResultPage = pharmacySearchPage
				.searchesPharmacy();
		
		/* Get expected data */
		JSONObject pharmacyResultActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject pharmacyResultExpectedJson = pharmacyResultPage
				.getExpectedData(expectedDataMap, expectedObjectkey);
		getLoginScenario().saveBean(
				PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
				pharmacyResultExpectedJson);

		/* Actual data */
		if (pharmacyResultPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE,
					pharmacyResultPage);
			Assert.assertTrue(true);
			pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
		}
		getLoginScenario().saveBean(
				PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
				pharmacyResultActualJson);
	}

	@And("^the user selects pharmacy type in UMS site$")
	public void user_selects_pharmacy_type_aarp_site(
			DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		String[] pharmacyTypeArray = pharmacyAttributesRow.get(0).getCells()
				.get(0).split(",");
		getLoginScenario().saveBean(PageConstants.PHARMACY_TYPES,
				pharmacyTypeArray);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage
				.selectsPharmacy(pharmacyTypeArray);
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);

	}

	@Then("^the user validates the pharmacies available in UMS site$")
	public void user_validates_pharmacies_available_aarp() {
		PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_RESULT_PAGE);
		JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
		JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

		System.out.println("pharmacyResultActualJson=====>"
				+ pharmacyResultActualJson.toString());
		System.out.println("pharmacyResultExpectedJson===>"
				+ pharmacyResultExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(pharmacyResultExpectedJson,
					pharmacyResultActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		pharmacyResultPage.logOut();

	}

	@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}



/* Scenario for MAPD should show Preferred Retail Pharmacies */


@Given("^login with MAPD member on Blue layer$")
public void mapd_member_UMS(DataTable memberAttributes){
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = memberAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	
	String category = memberAttributesMap.get("MemberType");

	Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
	List<String> desiredAttributes = new ArrayList<String>();
	for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
			.hasNext();) {
		{
			String key = iterator.next();
			desiredAttributes.add(memberAttributesMap.get(key));
		}

	}
	System.out.println("desiredAttributes.." + desiredAttributes);

	Map<String, String> loginCreds = loginScenario
			.getUMSMemberWithDesiredAttributes(desiredAttributes);

	String userName = null;
	String pwd = null;
	if (loginCreds == null) {
		// no match found
		System.out.println("Member Type data could not be setup !!!");
		Assert.fail("unable to find a " + desiredAttributes + " member");
	} else {
		userName = loginCreds.get("user");
		pwd = loginCreds.get("pwd");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + pwd);
		getLoginScenario()
				.saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
	}

	getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

	WebDriver wd = getLoginScenario().getWebDriver();

	LoginPage loginPage = new LoginPage(wd);
	AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
	if (accountHomePage != null) {
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);
	}
	
}

@And("^the user search pharmacies using the below information in Blue layer site$")
public void user_enter_zipcode_distance_details(DataTable zipAttributes) {
	List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
	Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < zipAttributesRow.size(); i++) {

		zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
				zipAttributesRow.get(i).getCells().get(1));
	}

	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	pharmacySearchPage = pharmacySearchPage
			.enterZipDistanceDetails(zipAttributesMap);

	if (pharmacySearchPage != null) {
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
		Assert.assertTrue(true);
	} else {
		Assert.fail("Failed to load Pharmacy search page");
	}

}

@When("^the user navigates to pharmacy search page in Blue layer site$")
public void user_view_pharmacy_locator() {

	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
			.getBean(PageConstants.ACCOUNT_HOME_PAGE);
	PharmacySearchPage pharmacySearchPage = accountHomePage
			.navigateToPharmacyLocator();
	if (pharmacySearchPage != null) {
		getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
				pharmacySearchPage);
		Assert.assertTrue(true);
	} else {
		Assert.fail("Failed to load Pharmacy search page");
	}

}

@And("^the user searches for pharmacies available in Blue layer site$")
public void user_search_pharmacy_available_aarp() {
	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	String[] pharmacyTypeArray = (String[]) getLoginScenario().getBean(
			PageConstants.PHARMACY_TYPES);
	String expectedObjectkey = pharmacySearchPage
			.getExpectedKey(pharmacyTypeArray);

	PharmacyResultPage pharmacyResultPage = pharmacySearchPage
			.searchesPharmacy();
	
	/* Get expected data */
	/*JSONObject pharmacyResultActualJson = null;
	@SuppressWarnings("unchecked")
	Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
	JSONObject pharmacyResultExpectedJson = pharmacyResultPage
			.getExpectedData(expectedDataMap, expectedObjectkey);
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
			pharmacyResultExpectedJson);*/

	/* Actual data */
	if (pharmacyResultPage != null) {
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE,
				pharmacyResultPage);
		Assert.assertTrue(true);
		//pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
	}
	/*getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
			pharmacyResultActualJson);*/
}
@And("^the user opts for spanish content in pharmacy search page$")
public void user_opts_spanish_page() {
	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	String[] pharmacyTypeArray = (String[]) getLoginScenario().getBean(
			PageConstants.PHARMACY_TYPES);
	String expectedObjectkey = pharmacySearchPage
			.getExpectedKey(pharmacyTypeArray);

	/*PharmacyResultPage pharmacyResultPage = pharmacySearchPage
			.searchesPharmacy();
	*/
	PharmacyResultPage pharmacyResultPage = pharmacySearchPage
			.navigateSpanishContent();
	
	/* Get expected data */
	JSONObject pharmacyResultActualJson = null;
	@SuppressWarnings("unchecked")
	Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
	JSONObject pharmacyResultExpectedJson = pharmacyResultPage
			.getExpectedData(expectedDataMap,expectedObjectkey);
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
			pharmacyResultExpectedJson);

	/* Actual data */
	if (pharmacyResultPage != null) {
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE,
				pharmacyResultPage);
		Assert.assertTrue(true);
		pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
	}
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
			pharmacyResultActualJson);
}

@And("^the user opts for chinese content in pharmacy search page$")
public void user_opts_chinese_page() {
	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	String[] pharmacyTypeArray = (String[]) getLoginScenario().getBean(
			PageConstants.PHARMACY_TYPES);
	String expectedObjectkey = pharmacySearchPage
			.getExpectedKey(pharmacyTypeArray);

	/*PharmacyResultPage pharmacyResultPage = pharmacySearchPage
			.searchesPharmacy();
	*/
	PharmacyResultPage pharmacyResultPage = pharmacySearchPage
			.navigateChineseContent();
	
	/* Get expected data */
	JSONObject pharmacyResultActualJson = null;
	@SuppressWarnings("unchecked")
	Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
	JSONObject pharmacyResultExpectedJson = pharmacyResultPage
			.getExpectedData(expectedDataMap,expectedObjectkey);
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
			pharmacyResultExpectedJson);

	/* Actual data */
	if (pharmacyResultPage != null) {
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE,
				pharmacyResultPage);
		Assert.assertTrue(true);
		pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
	}
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
			pharmacyResultActualJson);
}
@And("^user validates Ballon Mappers$")
public void user_validates_Ballon_Mappers() {
	PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_RESULT_PAGE);
	boolean balonflagvalue=pharmacyResultPage.validateBallonMappers();
	if(balonflagvalue)
		Assert.assertTrue(true);
	else
		Assert.assertTrue(false);
	/*JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
	JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

	System.out.println("pharmacyResultActualJson=====>"
			+ pharmacyResultActualJson.toString());
	System.out.println("pharmacyResultExpectedJson===>"
			+ pharmacyResultExpectedJson.toString());
	 Validations 
	try {
		JSONAssert.assertEquals(pharmacyResultExpectedJson,
				pharmacyResultActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}

	pharmacyResultPage.logOut();*/

}
	

@Then("^the user validates the spanish pdf content$")
public void user_validates_spanish_pdf_content() {
	PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_RESULT_PAGE);
	String spanishurl=pharmacyResultPage.getSpanishPdfUrl();
	if(spanishurl.contains("es"))
	Assert.assertTrue(true);
	else
	Assert.assertTrue(false);
	/*JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
	JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

	System.out.println("pharmacyResultActualJson=====>"
			+ pharmacyResultActualJson.toString());
	System.out.println("pharmacyResultExpectedJson===>"
			+ pharmacyResultExpectedJson.toString());
	 Validations 
	try {
		JSONAssert.assertEquals(pharmacyResultExpectedJson,
				pharmacyResultActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}

	pharmacyResultPage.logOut();
*/
}

@Then("^the user validates the chinese pdf content$")
public void user_validates_chinese_pdf_content() {
	PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_RESULT_PAGE);
	String chineseUrl=pharmacyResultPage.getChinesePdfUrl();
	System.out.println("chineseUrl"+chineseUrl);
	if(chineseUrl.contains("zh_cn"))
	Assert.assertTrue(true);
	else
	Assert.assertTrue(false);	
	/*JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
	JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

	System.out.println("pharmacyResultActualJson=====>"
			+ pharmacyResultActualJson.toString());
	System.out.println("pharmacyResultExpectedJson===>"
			+ pharmacyResultExpectedJson.toString());
	 Validations 
	try {
		JSONAssert.assertEquals(pharmacyResultExpectedJson,
				pharmacyResultActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}
*/
	//pharmacyResultPage.logOut();


}
@Then("^user validates the English pdf content$")
public void user_validates_English_pdf_content() {
	PharmacyResultPage pharmacyResultPage = (PharmacyResultPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_RESULT_PAGE);
	String EnglishPdfUrl=pharmacyResultPage.getEnglishPdfUrl();
	System.out.println("EnglishPdfUrl"+EnglishPdfUrl);
	if(EnglishPdfUrl.contains("en_us"))
	{
	System.out.println("true");	
	Assert.assertTrue(true);
	}
	else
	{
	System.out.println("false");
	Assert.assertTrue(false);
	}
	/*JSONObject pharmacyResultActualJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL);
	JSONObject pharmacyResultExpectedJson = (JSONObject) getLoginScenario()
			.getBean(PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED);

	System.out.println("pharmacyResultActualJson=====>"
			+ pharmacyResultActualJson.toString());
	System.out.println("pharmacyResultExpectedJson===>"
			+ pharmacyResultExpectedJson.toString());*/
	/* Validations */
	/*try {
		JSONAssert.assertEquals(pharmacyResultExpectedJson,
				pharmacyResultActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}
*/
	try {
		Thread.sleep(15000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//pharmacyResultPage.logOut();
}




@Given("^registered member to verify locate a pharmacy page in UMS Site$")
public void registered_member_located_pharmacy_bluelayer(
		DataTable memberAttributes) {

	List<DataTableRow> memberAttributesRow = memberAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	
	String category = memberAttributesMap.get("MemberType");

	Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
	List<String> desiredAttributes = new ArrayList<String>();
	for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
			.hasNext();) {
		{
			String key = iterator.next();
			desiredAttributes.add(memberAttributesMap.get(key));
		}

	}
	System.out.println("desiredAttributes.." + desiredAttributes);

	Map<String, String> loginCreds = loginScenario
			.getUMSMemberWithDesiredAttributes(desiredAttributes);

	String userName = null;
	String pwd = null;
	if (loginCreds == null) {
		// no match found
		System.out.println("Member Type data could not be setup !!!");
		Assert.fail("unable to find a " + desiredAttributes + " member");
	} else {
		userName = loginCreds.get("user");
		pwd = loginCreds.get("pwd");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + pwd);
		getLoginScenario()
				.saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
	}

	getLoginScenario().saveBean(CommonConstants.CATEGORY, category);

	
	WebDriver wd = getLoginScenario().getWebDriver();

	LoginPage loginPage = new LoginPage(wd);
	AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,category);
	//JSONObject accountHomeActualJson = null;
	
	/*Get expected data*/ 
	Map<String, JSONObject> expectedDataMap = loginScenario
			.getExpectedJson(userName);
	/*JSONObject accountHomeExpectedJson = accountHomePage
			.getExpectedData(expectedDataMap);*/

	/* get actual data */
	if (accountHomePage != null) {
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
				accountHomePage);
		
		//accountHomeActualJson = accountHomePage.accountHomeJson;
	}


	/*try {
		JSONAssert.assertEquals(accountHomeExpectedJson,
				accountHomeActualJson, true);
	} catch (JSONException e) {
		e.printStackTrace();
	}
	*/

	getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
			expectedDataMap);
}


@And("^the user searches for pharmacy available in UMS site$")
public void user_pharmacy_available_aarps() throws InterruptedException {
	PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
			.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
	/*String[] pharmacyTypeArray = (String[]) getLoginScenario().getBean(
			PageConstants.PHARMACY_TYPES);
	String expectedObjectkey = pharmacySearchPage
			.getExpectedKey(pharmacyTypeArray);
	System.out.println("pharmacyTypeArray"+pharmacyTypeArray);*/

	PharmacyResultPage pharmacyResultPage = pharmacySearchPage
			.searchesPharmacy();
	
	/* Get expected data */
	JSONObject pharmacyResultActualJson = null;
	@SuppressWarnings("unchecked")
	Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
			.getBean(CommonConstants.EXPECTED_DATA_MAP);
	JSONObject pharmacyResultExpectedJson = pharmacyResultPage
			.getExpectedDataWithOutPharmacyType(expectedDataMap/*, expectedObjectkey*/);
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_EXPECTED,
			pharmacyResultExpectedJson);

	/* Actual data */
	if (pharmacyResultPage != null) {
		getLoginScenario().saveBean(PageConstants.PHARMACY_RESULT_PAGE,
				pharmacyResultPage);
		Assert.assertTrue(true);
		pharmacyResultActualJson = pharmacyResultPage.pharmacyResultJson;
	}
	getLoginScenario().saveBean(
			PharmacySearchCommonConstants.PHARMACY_RESULT_ACTUAL,
			pharmacyResultActualJson);
}
}




