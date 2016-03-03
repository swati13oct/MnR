/**
 * 
 */
package acceptancetests.header.ulayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.DisclaimersAARPPage;
import pages.acquisition.ulayer.LoginAssistancePage;
import pages.acquisition.ulayer.RegistrationHomePage;
import pages.member.ulayer.AccountHomePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

/**
 * @author rkodumur
 *
 */
public class BrandSectionAARPStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user is on acquisition home page of AARP Site$")
	public void the_user_on_AARP_Medicareplans_Site() {
		WebDriver wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}
	
	@When("^user accesses brand section of the AARP Medicare Plans home page$")
	public void access_brand_section() {
		
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		JSONObject globalFooterActual = aquisitionhomepage.accessBrandSection();
		/* Get expected data */
		String fileName = "headerexpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject globalFooterExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.HEADER_ACTUAL,
				globalFooterActual);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.HEADER_EXPECTED,
				globalFooterExpectedJson);
	
	}
	
	@Then("^user validates all the links in brand section$")
	public void validate_all_links_brand_section(){
		
		JSONObject headerActualJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HEADER_ACTUAL);

		JSONObject headerExpectedJson = (JSONObject) getLoginScenario()
				.getBean(AcquistionCommonConstants.HEADER_EXPECTED);

		System.out.println("headerActualJson---->" + headerActualJson);
		System.out.println("headerExpectedJson---->" + headerExpectedJson);
		try {
			JSONAssert.assertEquals(headerExpectedJson, headerActualJson,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^user clicks on Important Disclosures link of AARP Medicare Plans home page$")
	public void click_importantDisclosures() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		DisclaimersAARPPage  disclaimersAARPPage= aquisitionhomepage.importantDisclosuresClick();
		if(disclaimersAARPPage!= null){
			getLoginScenario().saveBean(PageConstants.AARP_DISCLAIMERS_PAGE,
					disclaimersAARPPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Disclaimers page not found");
		}
	}
	
	@And("^user clicks on AARP logo on Disclaimer page$")
	public void click_logo() {
		DisclaimersAARPPage  disclaimersAARPPage  = (DisclaimersAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_DISCLAIMERS_PAGE);
		AcquisitionHomePage aquisitionhomepage = disclaimersAARPPage.logoClick();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Home page not found");
		}
	}
	
	@And("^user clicks on visit AARP org link of Home page$")
	public void click_visitAARP_org() {
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean pagefound = aquisitionhomepage.visitAARPOrgClick();
		if(pagefound!=null && pagefound==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Home page not found");
		}
				
	}
	
	@After
    public void tearDown() {
           WebDriver wd = (WebDriver) getLoginScenario().getBean(
                        CommonConstants.WEBDRIVER);
           wd.quit();
           getLoginScenario().flushBeans();
    }

	@When("^the header is rendered, the Already a Member button should display in it's inactive state on the Brand section of AARP site$")
	public void validate_button_inactive()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = aquisitionhomepage.validate_alreadyPlanMemberButton_inactive();
		if(state!=null && state==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button is not inactive");
		}
	}
	
	@And("^user clicks on Already a member button in its inactive state on the Brand section of AARP site$")
	public void click_alreadyPlanMember()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean state = aquisitionhomepage.validate_alreadyPlanMemberButton_active();
		//getting actual json object 
		JSONObject alreadyPlanMemberActualJson = aquisitionhomepage.getAlreadyPlanMemberJSON();
		/* Get expected data */
		String fileName = "alreadyPlanMemberExpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject alreadyPlanMemberExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL,
				alreadyPlanMemberActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED,
				alreadyPlanMemberExpectedJson);
		
		if(state!=null && state==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Already a Member button dropdown is not displayed");
		}
	}
	
	@And("^user clicks on user name, password text field in the Already a plan member drop down of AARP site$")
	public void click_field()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value=aquisitionhomepage.validate_textField();
		if(value!=null && value==true ){
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}
		
	}
	
	@And("^user clicks on forgot your username or password link of AARP site$")
	public void click_forgotUsernamePassword()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		LoginAssistancePage loginAssistancePage =aquisitionhomepage.forgotUsernamePasswordClick();
		if(loginAssistancePage!= null){
			getLoginScenario().saveBean(PageConstants.LOGIN_ASSISTANCE_PAGE,
					loginAssistancePage);
			Assert.assertTrue(true);
			
		} else {
			Assert.fail("Login Assistance page not found");
		}
			
	}
	
	@And("^user switches back to acquisition home page of AARP Site$")
	public void backToHomePage()
	{
		LoginAssistancePage loginAssistancePage  = (LoginAssistancePage) getLoginScenario()
				.getBean(PageConstants.LOGIN_ASSISTANCE_PAGE);
		AcquisitionHomePage aquisitionhomepage = loginAssistancePage.switchBack();
		if(aquisitionhomepage!= null){
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
			
		} else {
			Assert.fail("Home page not found");
		}
		
	}
	
	@And("^user clicks on register here link of AARP site$")
	public void click_registerHere()
	{
		AcquisitionHomePage aquisitionhomepage  = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		RegistrationHomePage registrationHomePage=aquisitionhomepage.registerHereLinkClick();
		if(registrationHomePage!= null){
			Assert.assertTrue(true);
		} else {
			Assert.fail("Registration page not found");
		}
		
	}
	
	@Then("^user validates all the elements in the Already a plan member drop down of AARP site$")
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
	
	
	@When("^the user clicks on Already a member button on the Brand section of AARP site$")
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
	
	@And("^user enters invalid user name, password text field in the Already a plan member drop down of AARP site$")
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
	
	@Then("^user clicks on sign in button and validate the error message in Already a plan member drop down of AARP site$")
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
	
	@And("^user enters valid user name, password text field in the Already a plan member drop down of AARP site$")
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
	
	@Then("^user clicks on sign in button and validates if it is landed on member my account home page of AARP site$")
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
	
	@Then("^user clicks on sign in button and validates if the cookie is created in Acquisition AARP site$")
	public void clickSignInForCookieValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage = aquisitionhomepage.cookieValid();
		if (aquisitionhomepage != null) {
			getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
					aquisitionhomepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
	
	@And("^user reloads the AARP site page and accesses Already a member dropdown$")
	public void alreadyMemberActiveStateValidation() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean value = aquisitionhomepage.alreadyMemberActiveValid();
		
		JSONObject alreadyPlanMemberActualJson = aquisitionhomepage.getAlreadyPlanMemberJSON();
		/* Get expected data */
		String fileName = "alreadyPlanMemberExpected";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator
				+ AcquistionCommonConstants.HEADER_FLOW_NAME
				+ File.separator;
		JSONObject alreadyPlanMemberExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);

		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_ACTUAL,
				alreadyPlanMemberActualJson);
		getLoginScenario().saveBean(
				AcquistionCommonConstants.ALREADY_PLAN_MEMBER_EXPECTED,
				alreadyPlanMemberExpectedJson);
		
		if (value != null && value) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed");
		}

	}
}
