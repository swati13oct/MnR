/**
 * 
 */
package acceptancetests.globalheader.bluelayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.DisclaimersPage;
import pages.acquisition.bluelayer.LoginAssistancePage;
import pages.acquisition.bluelayer.RegistrationHomePage;
import pages.member.bluelayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author saduri
 *
 */
public class GlobalHeaderUmsStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the user is on the UHC Medicaresolutions Site$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user accesses global header UHC Medicaresolutions Site$")
	public void the_user_accesses_GlobalHeader_UHC_Medicaresolutions_Site() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(aquisitionhomepage != null){
		JSONObject globalHeaderActual = aquisitionhomepage
				.accessingGlobalHeader();

		/* Get expected data */
		String fileName = "globalheaderexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator
				+ AcquistionCommonConstants.GLOBAL_HEADER_FLOW_NAME
				+ File.separator;
		JSONObject globalHeaderExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_HEADER_ACTUAL,
				globalHeaderActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.GLOBAL_HEADER_EXPECTED,
				globalHeaderExpectedJson);
		Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in Home page");
		}

	}
	
	@And("^user clicks on the Important Disclosures link on UHC Medicaresolutions Site page$")
	public void user_clicks_ImportantDisclaimers_link_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersPage disclaimersPage = aquisitionhomepage.importantDisclaimersClick();
		if(disclaimersPage != null){
			getLoginScenario().saveBean(PageConstants.DISCLAIMERS_PAGE,
					disclaimersPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on the UnitedHealthCare logo on UHC Medicaresolutions Site page$")
	public void user_clicks_UnitedHealthCare_logo_ums() {
		
		DisclaimersPage disclaimersPage = (DisclaimersPage) getLoginScenario()
				.getBean(PageConstants.DISCLAIMERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = disclaimersPage.unitedHealthCareLogoClick();
		if(aquisitionhomepage != null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@And("^user clicks on home link in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_HomeLink_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage = aquisitionhomepage.navigationSectionHomeLinkClick();
		if(aquisitionhomepage != null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
/*	
	@And("^user clicks on Our Plans link in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_OurPlans_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		OurPlansPage ourPlansPage = aquisitionhomepage.navigationSectionOurPlansLinkClick();
		if(ourPlansPage != null){
			getLoginScenario().saveBean(PageConstants.OUR_PLANS_PAGE,
					ourPlansPage);
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}*/
	
		
	@And("^user clicks text  in global search field in navigation section on UHC Medicaresolutions Site page$")
	public void user_clicks_GlobalSearchField_navigation_ums() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean searchResult = aquisitionhomepage.navigationSectionEnterSearchClick();
		
		
		if(searchResult != null && searchResult){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Error in disclaimers page");
		}
	}
	
	@Then("^user validates the Brand Section items on UHC Medicaresolutions Site page$")
	public void user_validate_BrandSection_links_ums() {

		JSONObject globalHeaderActual = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_HEADER_ACTUAL);

		JSONObject globalHeaderExpected = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.GLOBAL_HEADER_EXPECTED);

		System.out.println("globalHeaderActual---->" + globalHeaderActual);
		System.out.println("globalHeaderExpected---->" + globalHeaderExpected);
		try {
			JSONAssert.assertEquals(globalHeaderExpected, globalHeaderActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@When("^the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of UMS site$")
	public void access_brand_section() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = acquisitionHomePage
				.validate_alreadyPlanMemberButton_inactive();
		if (state != null && state == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button is not inactive");
		}

	}

	@And("^user clicks on Already a member button in its inactive state on the Brand section of UMS site$")
	public void click_alreadyPlanMember() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = acquisitionHomePage
				.validate_alreadyPlanMemberButton_active();
		// getting actual json object
		JSONObject alreadyPlanMemberActualJson = acquisitionHomePage
				.getAlreadyPlanMemberJSON();
		/* Get expected data */
		String fileName = "alreadyPlanMemberExpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER
				+ File.separator + AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject alreadyPlanMemberExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL,
				alreadyPlanMemberActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED,
				alreadyPlanMemberExpectedJson);

		if (state != null && state == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button dropdown is not displayed");
		}
	}

	@And("^user clicks on user name, password text field in the Already a plan member drop down of UMS site$")
	public void click_field() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = acquisitionHomePage.validate_textField();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}

	@And("^user clicks on forgot your username or password link of UMS site$")
	public void click_forgotUsernamePassword() {
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LoginAssistancePage loginAssistancePage = acquisitionHomePage
				.forgotUsernamePasswordClick();
		if (loginAssistancePage != null) {
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
					loginAssistancePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Login Assistance page not found");
		}

	}

	@And("^user switches back to acquisition home page of UMS Site$")
	public void backToHomePage() {
		LoginAssistancePage loginAssistancePage = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		AcquisitionHomePage acquisitionHomePage = loginAssistancePage
				.switchBack();
		if (acquisitionHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					acquisitionHomePage);
			Assert.assertTrue(true);

		} else {
			Assert.fail("Home page not found");
		}

	}
	
	@And("^user clicks on register here link of UMS site$")
	public void click_registerHere()
	{
		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RegistrationHomePage registrationHomePage=acquisitionHomePage.registerHereLinkClick();
		if(registrationHomePage!= null){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Registration page not found");
		}
		
	}
	@Then("^user validates all the elements in the Already a plan member drop down of UMS site$")
	public void validate_allElements()
	{
		JSONObject alreadyPlanMemberActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL);

		JSONObject alreadyPlanMemberExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED);

		System.out.println("alreadyPlanMemberActualJson---->" + alreadyPlanMemberActualJson);
		System.out.println("alreadyPlanMemberExpectedJson---->" + alreadyPlanMemberExpectedJson);
		try {
			JSONAssert.assertEquals(alreadyPlanMemberExpectedJson, alreadyPlanMemberActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@When("^the user clicks on Already a member button on the Brand section of UMS site$")
	public void click_alreadyMember()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean alreadyMemberFlag=aquisitionhomepage.validate_alreadyPlanMemberButton_active();
		if(alreadyMemberFlag!= null && alreadyMemberFlag){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already member dropdown not displayed");
		}
		
	}
	
	@And("^user enters invalid user name, password text field in the Already a plan member drop down of UMS site$")
	public void entersInvalidCredentials() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();*/
		Boolean value = aquisitionhomepage.enterInvalidUserNamePassword();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user clicks on sign in button and validate the error message in Already a plan member drop down of UMS site$")
	public void clickSignInForInvalidCreds() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.checkErrorMessage();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@And("^user enters valid user name, password text field in the Already a plan member drop down of UMS site$")
	public void entersValidCredentials() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();*/
		Boolean value = aquisitionhomepage.enterValidUserNamePassword();
		if (value != null && value == true) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user clicks on sign in button and validates if it is landed on member my account home page of UMS site$")
	public void clickSignInForValidCreds() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		AccountHomePage accountHomePage = aquisitionhomepage.signInValid();
		if (accountHomePage != null) {
			getLoginScenario().saveBean(acceptancetests.atdd.data.member.PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@And("^user reloads the UMS site page and accesses, validates  active state of Already a member dropdown and checks for cookie timer and cookie in browser of UMS site$")
	public void alreadyMemberActiveStateValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.alreadyMemberActiveValid();
		if (value != null && value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user waits for the time mentioned in the cookie timer and validates if the already member dropdown is inactive in UMS site$")
	public void cookietimerValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.cookieTimerValid();
		if (value != null && !value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@Then("^user clicks on the page and validates if the timer has stopped in browser of UMS site$")
	public void timerStopValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.stopTimerValid();
		if (value != null && value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}

}
