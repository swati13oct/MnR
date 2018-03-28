package acceptancetests.memberredesign.HSID;

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
//import acceptancetests.deprecated.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AssistiveRegistrationPage;
import pages.member.bluelayer.HSIDLoginPage;

/**
 * Functionality: Benefits and Coverage page
 */
public class HSIDStepDefinition {

	@Autowired
	MRScenario loginScenario;

	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
 
	


	
	@Given("^register with following details logins in the member portal and validate elements$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
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
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		loginPage.validateelements();
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) loginPage.doLoginWith(userName, pwd);
		
		
		if (assistiveregistration != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE,assistiveregistration);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Assistive Registration Page *****");
		}

	}
	
	@And("^the user validate username autofill$")
	public void validateelementassistive()
	{
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario().getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		String username = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		assistiveregistration.usernameautofill(username);
	}
	

	@And("^the user validate all fields on this page$")
	public void validateotherfields()
	{
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario().getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
		String username = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		assistiveregistration.validate_allfields();
	
	}
	
	@And("^the user validate security questions option and user answer all security questions$")
	public void validatesecurityquestions(DataTable givenAttributes)
	{
		AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
			.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	
     List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String option = memberAttributesMap.get("Option");
	String option1 = memberAttributesMap.get("Option1");
	String option2 = memberAttributesMap.get("Option2");
	String option3 = memberAttributesMap.get("Option3");
	getLoginScenario().saveBean(LoginCommonConstants.Option, option);
	getLoginScenario().saveBean(LoginCommonConstants.Option1, option1);
	getLoginScenario().saveBean(LoginCommonConstants.Option2, option2);
	getLoginScenario().saveBean(LoginCommonConstants.Option3, option3);
	assistiveregistration.validate_security1_select(option);
	System.out.println(option1);
	assistiveregistration.validate_security2_select(option1);
	assistiveregistration.validate_security2_ans();
	System.out.println(option2);
	assistiveregistration.validate_security3_select(option2);
	assistiveregistration.validate_security3_ans();
	System.out.println(option3);
	assistiveregistration.validate_security4_select(option3);
	assistiveregistration.validate_security4_ans();
	
	
	}
	
	@And("^the user check checkboxes$")
	public void validatecheckboxes()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_checkboxes();
	
}
	
	@And("^the user clicks submit button$")
	public void validatesubmitbutton()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_submitbutton();
	
}
	@And("^the user enters password and confirm password field$")
	public void validatepasswordfield()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_passwordfields();
	}
	
	@And("^the user enters email and confirm email field$")
	public void validateemailfield()
	{
	AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) getLoginScenario()
	.getBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE);
	assistiveregistration.validate_emailfields();
	}
	

	
}