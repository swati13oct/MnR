package acceptancetests.memberredesign.profilePageHsid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
//import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.LoginPage2;
import pages.member.bluelayer.ProfilePageHsid;
import pages.regression.accounthomepage.AccountHomePage;




public class profilePageHsidStepDefinition {

	@Autowired
	MRScenario loginScenario;

	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo : The user logs in to the member Redesign Portal
	 */
	
	@Given("^registered member with following details$")
	public void registered_member_with_following_details(DataTable memberAttributes){
		
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
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

			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage2 loginPage = new LoginPage2(wd);
		
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWithHsid(userName, pwd);
		
		if (accountHomePage != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
			
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}

	   
	   
	}
	/**
	 * @toDo : The user enters the security questions
	 */
	
	@When("^I enter the security questions$")
	public void i_enter_the_security_questions(DataTable givenAttributes)
	{
        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < memberAttributesRow.size(); i++) {
               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
                            memberAttributesRow.get(i).getCells().get(1));
        }
        String friendname = memberAttributesMap.get("friendname");
        String favouritecolor = memberAttributesMap.get("favouritecolor");
        String PhoneNumber = memberAttributesMap.get("PhoneNumber");
        
        AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		accountHomePage.validateTheSecurityQues(friendname,favouritecolor,PhoneNumber);


		
	}
	
	/**
	 * @toDo : The user navigates to the account setting page
	 */

	@When("^I navigate to the Account Settings page$")
	public void i_navigate_to_the_Account_Settings_page() throws InterruptedException{
		
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		ProfilePageHsid profilePageHsid = accountHomePage.navigateDirectToProfilePageHsid();

		if (profilePageHsid!= null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID, profilePageHsid);
		
		}
		else
        {
			System.out.println("Pnp page object is Null Here");
		}

	  
	}
	
	/**
	 * @toDo : The user clicks on health safe Id password
	 */

	@When("^I click the HEALTHSAFE ID PASSWORD link$")
	public void i_click_the_HEALTHSAFE_ID_PASSWORD_link() throws InterruptedException{
		
	
		
		ProfilePageHsid profilePageHsid = (ProfilePageHsid) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID);
		System.out.println("testlink"+profilePageHsid);


		profilePageHsid.validateHealthSafeIdLink();
	}
	
	/**
	 * @toDo : The user should see the breadcrumb in the upper left side
	 */

	@Then("^I should see the breadcrumb  in the upper left side of the page$")
	public void i_should_see_the_breadcrumb_in_the_upper_left_side_of_the_page() throws InterruptedException{
	
		ProfilePageHsid profilePageHsid = (ProfilePageHsid) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID);

		profilePageHsid.validateBreadCrumb();
	 
	}

	/**
	 * @toDo : The functionality of Bread crumb
	 */
	@And("^clicking the link should lead me back to the Account Settings page of the member site$")
	public void clicking_the_link_should_lead_me_back_to_the_Account_Settings_page_of_the_Medica_member_site(){
		ProfilePageHsid profilePageHsid = (ProfilePageHsid) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID);

		profilePageHsid.validateBreadCrumbClick();

	}
	/**
	 * @toDo : The functionality of health safe Id account recovery
	 */

	@Then("^I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link$")
	public void i_click_the_HEALTHSAFE_ID_ACCOUNT_RECOVERY_AND_SECURITY_link() throws InterruptedException{
		ProfilePageHsid profilePageHsid = (ProfilePageHsid) getLoginScenario()
				.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE_HSID);

		profilePageHsid.validateHealthSafeAccountLink();
	  
	
	}
	
	
}
