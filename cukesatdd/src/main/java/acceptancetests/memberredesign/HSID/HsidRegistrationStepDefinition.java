package acceptancetests.memberredesign.hsid;

import java.sql.Driver;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.HSIDLoginPage;
import pages.member.redesign.DeregisterPage;
import pages.redesign.HsidLoginPage;
import pages.redesign.HsidRegistrationConfirmInformation;
import pages.redesign.HsidRegistrationPersonalCreateAccount;
import pages.redesign.HsidRegistrationPersonalInformationPage;

public class HsidRegistrationStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on medicare sign in page$")
	public void the_user_is_on_medicare_sign_in_page() throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriver();
		HsidLoginPage hsidLoginPage = new HsidLoginPage(wd);
		getLoginScenario().saveBean(PageConstants.HSID_LOGIN_PAGE, hsidLoginPage);
	}

	@When("^the user clicks on Register now link$")
	public void the_user_clicks_on_Register_now_link() throws Throwable {
		
		HsidLoginPage hsidLoginPage = (HsidLoginPage) loginScenario.getBean(PageConstants.HSID_LOGIN_PAGE);
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = hsidLoginPage.clickRegister();
		getLoginScenario().saveBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE, hsidRegistrationPersonalInfoPage);
		
	}

	@When("^HSID registration page is displayed with all the fields$")
	public void hsid_registration_page_is_displayed_with_all_the_fields() throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validateFields();
		
	}

	@When("^enter first name, last name, date of birth, zip code, member id and click continue$")
	public void enter_first_name_last_name_date_of_birth_zip_code_member_id_and_click_continue(DataTable memberAttributes) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String firstName = memberAttributesMap.get("firstName");
		String lastName = memberAttributesMap.get("lastName");
		String dob = memberAttributesMap.get("dob");
		String zipcode = memberAttributesMap.get("zipcode");
		String memberId = memberAttributesMap.get("memberid");
		System.out.println("firstName: "+firstName +"lastName: "+lastName +"dob: "+dob+"memberId: "+memberId +"zipcode: " + zipcode);
		hsidRegistrationPersonalInfoPage.populatefields(firstName, lastName, dob,zipcode, memberId);
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount 
																= hsidRegistrationPersonalInfoPage.clickContinue();
		getLoginScenario().saveBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT, hsidRegistrationPersonalCreateAccount);
		
	}

	@When("^user is navigated to step two:create account page$")
	public void user_is_navigated_to_step_two_create_account_page() throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.verifyCreateAccountSection();
		
	}

	@When("^enter username, password, re-enter password, email, re-enter email$")
	public void enter_username_password_re_enter_password_email_re_enter_email(DataTable memberAttributes) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		//String userName = memberAttributesMap.get("userName");
		String password = memberAttributesMap.get("password");
		String email = memberAttributesMap.get("email");
	
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DeregisterPage deregister = new DeregisterPage(wd);
		String userName = deregister.getUserName();
		System.out.println("userName: "+userName +"password: "+password +"email: "+email);
		hsidRegistrationPersonalCreateAccount.enterUsername(userName);
		hsidRegistrationPersonalCreateAccount.enterPassword(password);
		hsidRegistrationPersonalCreateAccount.enterConfirmPassword(password);
		hsidRegistrationPersonalCreateAccount.enterEmail(email);
		hsidRegistrationPersonalCreateAccount.enterConfirmEmail(email);
		
		
	    
	}
	
	@When("^select the security type as \"([^\"]*)\"$")
	public void select_the_security_type_as(String securityType) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.selectSecurityType(securityType);
	}
	
	@When("^select security question1 as \"([^\"]*)\"$")
	public void select_security_question1_as(String question1) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.selectSecurityQuestion1(question1);
	}

	@When("^select security answer1 as \"([^\"]*)\"$")
	public void select_security_answer1_as(String answer1) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.enterSecurityAnswer1(answer1);
	}
	
	@When("^select security question2 as \"([^\"]*)\"$")
	public void select_security_question2_as(String question2) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.selectSecurityQuestion2(question2);
	}

	@When("^select security answer2 as \"([^\"]*)\"$")
	public void select_security_answer2_as(String answer2) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.enterSecurityAnswer2(answer2);
	}
	
	@When("^select security question3 as \"([^\"]*)\"$")
	public void select_security_question3_as(String question3) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.selectSecurityQuestion3(question3);
	}

	@When("^select security answer3 as \"([^\"]*)\"$")
	public void select_security_answer3_as(String answer3) throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.enterSecurityAnswer3(answer3);
	}


	@When("^check the terms and click on create my ID button$")
	public void check_the_terms_and_click_on_create_my_ID_button() throws Throwable {
		HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
				(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
		hsidRegistrationPersonalCreateAccount.clickRememberThisDeviceCheckBox();
		hsidRegistrationPersonalCreateAccount.clicktermsOfUseCheckBox();
		HsidRegistrationConfirmInformation hsidRegistrationConfirmInformation = 
										hsidRegistrationPersonalCreateAccount.clickCreateMyIDButton();
		getLoginScenario().saveBean(PageConstants.HSID_REGISTRATION_CONFIRM_INFORMATION, hsidRegistrationConfirmInformation);
		
	}


	@When("^I click on Continue button$")
	public void i_click_on_Continue_button() throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.clickContinueAndValidate();
	}

	@When("^I should see error message \"([^\"]*)\"$")
	public void i_should_see_error_message(String arg1) throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validateMainErrorMessage();
	}

	@When("^I should see error message \"([^\"]*)\" for first name$")
	public void i_should_see_error_message_for_first_name(String arg1) throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validateFirstNameErrorMessage();
	}

	@When("^I should see error message \"([^\"]*)\" for last name$")
	public void i_should_see_error_message_for_last_name(String arg1) throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validateLastNameErrorMessage();
	}

	@When("^I should see error message \"([^\"]*)\" for date of birth$")
	public void i_should_see_error_message_for_date_of_birth(String arg1) throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validatedobErrorMessage();
	}

	@When("^I should see error message \"([^\"]*)\" for zip code$")
	public void i_should_see_error_message_for_zip_code(String arg1) throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validateZipCodeErrorMessage();
	    
	}

	@When("^I should see error message \"([^\"]*)\" for member id$")
	public void i_should_see_error_message_for_member_id(String arg1) throws Throwable {
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
				(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
		hsidRegistrationPersonalInfoPage.validateMemberIDErrorMessage();
	    
	}
	
	@When("^user is navigated to Confirm email page$")
	public void user_is_navigated_to_Confirm_email_page() throws Throwable {
		HsidRegistrationConfirmInformation hsidRegistrationConfirmInformationPage = 
				(HsidRegistrationConfirmInformation) loginScenario.getBean(PageConstants.HSID_REGISTRATION_CONFIRM_INFORMATION);
		hsidRegistrationConfirmInformationPage.verifyConfirmInformationPage();
	}

	@When("^user should see a latest unread mail recieved in provided email address$")
	public void user_should_see_a_latest_unread_mail_recieved_in_provided_email_address() throws Throwable {
		HsidRegistrationConfirmInformation hsidRegistrationConfirmInformationPage = 
				(HsidRegistrationConfirmInformation) loginScenario.getBean(PageConstants.HSID_REGISTRATION_CONFIRM_INFORMATION);
		String[] mailParts = hsidRegistrationConfirmInformationPage.getConfirmRegistrationURLWithSubjectandEmailContent();
		hsidRegistrationConfirmInformationPage.setConfirmationUrl(mailParts[0]);
	}

	@Then("^user should copy the confirm email url to browser$")
	public void user_should_copy_the_confirm_email_url_to_browser() throws Throwable {
		HsidRegistrationConfirmInformation hsidRegistrationConfirmInformationPage = 
				(HsidRegistrationConfirmInformation) loginScenario.getBean(PageConstants.HSID_REGISTRATION_CONFIRM_INFORMATION);
		
		hsidRegistrationConfirmInformationPage.confirmEmail();
		
	}

	@Then("^user should be at Sign In page$")
	public void user_should_be_at_Sign_In_page(DataTable memberAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String userName = memberAttributesMap.get("userName");
		String password = memberAttributesMap.get("password");
		
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		HSIDLoginPage loginPage = new HSIDLoginPage(wd);
		loginPage.validateelements();
        AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, password);
        if (accountHomePage!= null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}


	}

	
	@Then("^I should see a Username or email address label with textbox in Sign In page$")
	public void i_should_see_a_Username_or_email_address_label_with_textbox_in_Sign_In_page() throws Throwable {

	}
	



	

}
