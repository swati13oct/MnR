/**
 * 
 */
/**
 * @author jkuma14
 *
 */
package acceptancetests.memberredesign.sso;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;


//import pages.member_deprecated.bluelayer.AccountHomePage;
//import pages.member_deprecated.bluelayer.ProfilePageHsid;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.sso.CQLoginPage;
import pages.regression.sso.bswiftPage;
import pages.regression.sso.ssoTestHarnessPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import pages.regression.profileandpreferences.ProfileandPreferencesPage;
/**
 * 
 * @author jkuma14
 *
 */


public class ssoStepDefinition{
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/** 
	 * @todo :user to login for sso from CQ5 page
	 */
@Given("^the user access AEM Test Harness Page and enters his AEM Stage username and password and click on signin button$")
	    public void the_user_is_on_member_auth_login_page(DataTable givenAttributes) throws InterruptedException{
		WebDriver wd = getLoginScenario().getWebDriver();	

		CQLoginPage cqloginpage = new CQLoginPage(wd);
		cqloginpage.navigateToLoginURL();
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String userName = memberAttributesMap.get("CQ UserName");
		String passWord  = memberAttributesMap.get("CQ Password");
		
						
		// create SSO Test Harness page context by signing in on CQ Page
		ssoTestHarnessPage ssoTestHarnessPage = cqloginpage.enterValuesAndSubmit(userName, passWord);
		getLoginScenario().saveBean(PageConstants.SSO_TEST_HARNESS_PAGE, ssoTestHarnessPage);
	    }


	

@Given("^the user enters details of member on the SSO test harness page and click submit$")

public void the_user_is_on_member_auth_login(DataTable givenAttributes) throws InterruptedException{
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String ssopartner = memberAttributesMap.get("SSO Partner");
	String firstname  = memberAttributesMap.get("First Name");
	String lastname = memberAttributesMap.get("Last Name");
	String dob  = memberAttributesMap.get("DOB");
	String uhcid = memberAttributesMap.get("UHCID");
	String eaid = memberAttributesMap.get("EAID");
	String empnumber = memberAttributesMap.get("EmpNumber");
	
	ssoTestHarnessPage ssoTestHarnessPage = (ssoTestHarnessPage) getLoginScenario().getBean(PageConstants.SSO_TEST_HARNESS_PAGE);
	Thread.sleep(5000);
	System.out.println("Title of new page : "+ssoTestHarnessPage.getTitle());

	ssoTestHarnessPage.selectBenefitFocusFromSSOPartnerDropdown(ssopartner);
	ssoTestHarnessPage.enterFirstName(firstname);
	ssoTestHarnessPage.enterLastName(lastname);
	ssoTestHarnessPage.enterDOB(dob);
	ssoTestHarnessPage.enterUHCID(uhcid);
	ssoTestHarnessPage.enterEAID(eaid);
	ssoTestHarnessPage.enterEmpNumber(empnumber);
	ssoTestHarnessPage.clickSubmit();
}

@Given("^user click on SSO link generated on the page$")
public void user_click_on_SSO_link_generated_on_the_page() throws Throwable {
	ssoTestHarnessPage ssoTestHarnessPage = (ssoTestHarnessPage) getLoginScenario().getBean(PageConstants.SSO_TEST_HARNESS_PAGE);
	ssoTestHarnessPage.clickSSOLink();
	Thread.sleep(3000);
	AccountHomePage accountHomePage = new AccountHomePage(ssoTestHarnessPage.driver);
	getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
	
}

@Then("^user should be navigated to home page of rally dashboard$")
public void user_should_be_navigated_to_home_page_of_rally_dashboard() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	accountHomePage.verifyPageTitle();	
	Thread.sleep(2000);
	}

@And("^user clicks on account setting link$")
public void user_clicks_on_account_setting_link() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	ProfileandPreferencesPage profilePageHsid = accountHomePage.navigatedirectToProfilePageurl();

	if (profilePageHsid!= null) {
		getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID, profilePageHsid);
	
	}
	else
    {
		System.out.println("Pnp page object is Null Here");
	}  
}

@Then("^security and password reset link should not be visible$")
public void security_and_password_reset_link_should_not_be_visible() throws Throwable {
	ProfileandPreferencesPage profilePageHsid = (ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID);
	profilePageHsid.validateHealthSafePasswordLinkNOTPresent();
	System.out.println("Health Safe Password Link was not present as expected");
	profilePageHsid.validateHealthSafeAccountLinkNOTPresent();
	System.out.println("Health Safe Account Link was not present as expected");
}
/** 
 * @todo :SSO for bswift client with CE group MAPD plan 
 */
@Given("^CE MAPD group member lands on the SSO test harness page$")
public void the_user_is_pingFederate_Testharness_Page() throws InterruptedException{
	WebDriver wd = getLoginScenario().getWebDriver();
	bswiftPage bswiftpage = new bswiftPage(wd);
	bswiftpage.navigateToLoginURL1();
	getLoginScenario().saveBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift, bswiftpage);	
}
/** 
 * @todo :bswift CE testharness page elements  
 */
@And("^testharness page is displayed with all the fields$")
public void thetestharness_pageis_displayed(){
	bswiftPage bswiftpage = (bswiftPage) loginScenario.getBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift);
	bswiftpage.validatePageElements();
} 

/** 
 * @todo :bswift CE testharness page enter member details  
 */
@Given("^on testharness I enter the member details and click continue$")
public void the_user_is_on_testharnessPage(DataTable givenAttributes) throws InterruptedException{
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String ssopartner = memberAttributesMap.get("SSO Partner");
	String firstname  = memberAttributesMap.get("First Name");
	String lastname = memberAttributesMap.get("Last Name");
	String dob  = memberAttributesMap.get("DOB");
	String mbi = memberAttributesMap.get("MBI");
	String url = memberAttributesMap.get("Target URL");
	System.out.println("firstName: "+firstname +"lastName: "+lastname +"dob: "+dob+"MIB: "+mbi);
	bswiftPage bswiftpage = (bswiftPage) getLoginScenario().getBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift);
	Thread.sleep(5000);
	System.out.println("Title of new page : "+bswiftpage.getTitle());
	bswiftpage.enterssopartner(ssopartner);
	bswiftpage.enterFirstName1(firstname);
	bswiftpage.enterLastName1(lastname);
	bswiftpage.enterDOB1(dob);
	bswiftpage.enterMBI(mbi);
	bswiftpage.enterURL(url);
	//bswiftpage.clickSubmit1();
}
/** 
 * @todo :bswift CE member lands on Dashboard after clicking Submit
 */
 @Given("^user is navigated to the Dashboard$")
 public void user_navigatedTo_Dashboard() throws InterruptedException{
	 bswiftPage bswiftpage = (bswiftPage) getLoginScenario().getBean(PageConstants.STAGE_SSO_TESTHANESS_URL_bswift);
	 bswiftpage.clickSubmit1();
     Thread.sleep(3000);
  AccountHomePage accountHomePage = new AccountHomePage(bswiftpage.driver);
  getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
  accountHomePage.validatebswiftSSO();
}
}