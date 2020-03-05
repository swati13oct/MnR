package acceptancetests.memberrdesignVBF.hsidRegistration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.LoginPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.SecurityQuestionsPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.DeregisterPage;
import pages.memberrdesignVBF.hsidRegistration.HSIDLoginPage;
import pages.memberrdesignVBF.hsidRegistration.HsidRegistrationConfirmInformation;
import pages.memberrdesignVBF.hsidRegistration.HsidRegistrationPersonalCreateAccount;
import pages.memberrdesignVBF.hsidRegistration.HsidRegistrationPersonalInformationPage;


public class HsidRegistrationStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on medicare sign in page$")
	public void the_user_is_on_medicare_sign_in_page() throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
	}

	@When("^the user clicks on Register now link$")
	public void the_user_clicks_on_Register_now_link() throws Throwable {
		
		LoginPage loginPage = (LoginPage) loginScenario.getBean(PageConstants.LOGIN_PAGE);
		HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = loginPage.clickRegister();
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
		String firstName = (String) getLoginScenario().getBean(LoginCommonConstants.Firstname);
		String lastName =  (String) getLoginScenario().getBean(LoginCommonConstants.Lastname);
		/*String firstName = memberAttributesMap.get("firstName");
		String lastName = memberAttributesMap.get("lastName");*/
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
		
		String password = memberAttributesMap.get("password");
		String email = memberAttributesMap.get("email");
		
		String userName = hsidRegistrationPersonalCreateAccount.getUserName();
		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, password);
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
		if(!mailParts[0].equals(null)){
		hsidRegistrationConfirmInformationPage.setConfirmationUrl(mailParts[0]);
		}
		else{
			Assert.fail();
		}
	}

	@Then("^user should copy the confirm email url to browser$")
	public void user_should_copy_the_confirm_email_url_to_browser() throws Throwable {
		HsidRegistrationConfirmInformation hsidRegistrationConfirmInformationPage = 
				(HsidRegistrationConfirmInformation) loginScenario.getBean(PageConstants.HSID_REGISTRATION_CONFIRM_INFORMATION);
		
		hsidRegistrationConfirmInformationPage.confirmEmail();
		
	}

	
	@Then("^user should see the email confirmation message \"[^\"]*\" in Sign In form$" ) 
	public void i_should_see_a_Username_or_email_address_label_with_textbox_in_Sign_In_page() throws Throwable {
		
		LoginPage loginPage = (LoginPage) loginScenario.getBean(PageConstants.LOGIN_PAGE);
		loginPage.emailconfirmed();
	}
	
	@Then("^user should see a latest unread mail recieved  in mail server$" ) 
	public void i_should_see_congratulations_email() throws Throwable {
		
		HsidRegistrationConfirmInformation hsidRegistrationConfirmInformationPage = 
				(HsidRegistrationConfirmInformation) loginScenario.getBean(PageConstants.HSID_REGISTRATION_CONFIRM_INFORMATION);
		
		hsidRegistrationConfirmInformationPage.getregistrationflowcompleteemail();
	}
	

	@Given("^the user connect to DB$")
	public void i_connected_to_Provisional_data_base() {
	}
	
	@And("^the user select record from database$")
	public void i_select_record_data_base(DataTable givenAttributes) throws SQLException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String firstname = memberAttributesMap.get("Firstname");
		String lastname = memberAttributesMap.get("Lastname");
		getLoginScenario().saveBean(LoginCommonConstants.Firstname, firstname);
		getLoginScenario().saveBean(LoginCommonConstants.Lastname, lastname);
		System.out.println(firstname);
		System.out.println(lastname);
		//MRScenario.getRecordsFrom_mbr_table(firstname,lastname);
		getRecordsFrom_mbr_table(firstname,lastname);
	}

	
	@And("^the user delete record from mbr_portal$")
	public void i_delete_record_data_base() throws SQLException {
		
		String firstname = (String) getLoginScenario().getBean(LoginCommonConstants.Firstname);
		String lastname =  (String) getLoginScenario().getBean(LoginCommonConstants.Lastname);
		//MRScenario.deleteRecordsFrom_mbr_prtl_table(firstname,lastname);
		deleteRecordsFrom_mbr_prtl_table(firstname,lastname);
	}

	
	@And("^the user delete record from mbr$")
	public void i_delete_record_mbrtable() throws SQLException {
		String firstname = (String) getLoginScenario().getBean(LoginCommonConstants.Firstname);
		String lastname =  (String) getLoginScenario().getBean(LoginCommonConstants.Lastname);
		//MRScenario.deleteRecordsFrom_mbr_table(firstname,lastname);
		deleteRecordsFrom_mbr_table(firstname,lastname);
	}

	@And("^the user delete record from extreme scale$")
	public void i_delete_record_extremescaletable() throws SQLException {
		
		String firstname = (String) getLoginScenario().getBean(LoginCommonConstants.Firstname);
		String lastname =  (String) getLoginScenario().getBean(LoginCommonConstants.Lastname);
		//MRScenario.deleteRecordsFrom_mbr_extrm_scl_dtl_table(firstname,lastname);
		deleteRecordsFrom_mbr_extrm_scl_dtl_table(firstname,lastname);
	}
	@Given("^the user deregister from M&R LDAP$")
	public void I_delete_user_from_mnrldap(DataTable givenAttributes)
	{
		WebDriver wd = loginScenario.getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		DeregisterPage deregisterPage = new DeregisterPage(wd);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String username = memberAttributesMap.get("Username");
		getLoginScenario().saveBean(LoginCommonConstants.Username, username);
		
		System.out.println(username);

		deregisterPage.deregisterUser(username);
		
	}


	/***
	 * 
	 * @throws InterruptedException
	 */
	@When("^registered user logs in post registration$")
	public void registered_user_logs_in(DataTable memberattributes) throws InterruptedException {
		String userName = (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		String pwd = (String) getLoginScenario().getBean(LoginCommonConstants.PASSWORD);
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
		if ("YES".equalsIgnoreCase(MRScenario.isHSIDCompatible)) {
			SecurityQuestionsPage securityQuestionsPage = (SecurityQuestionsPage) loginPage.loginWith(userName, pwd);
			if (securityQuestionsPage != null) {
				getLoginScenario().saveBean(PageConstants.SECURITY_QUESTIONS_PAGE, securityQuestionsPage);
			} else {
				Assert.fail("securityQuestionsPage is not displayed...");
			}
			i_enter_the_security_questions(memberattributes);
		} else {
			if (("YES").equalsIgnoreCase(MRScenario.isTestHarness)) {
				TestHarness testHarness = (TestHarness) loginPage.loginWithLegacy(userName, pwd);
				if (testHarness != null) {
					getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarness);
				} else {
					Assert.fail("Login not successful...");
				}
			} else {

				RallyDashboardPage rallyDashboard = (RallyDashboardPage) loginPage.loginWithLegacy(userName, pwd);
				if (rallyDashboard != null) {
					getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARD_PAGE, rallyDashboard);
				} else {
					Assert.fail("Login not successful...");
				}
			}
		}
	}

	public void i_enter_the_security_questions(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String friendname = memberAttributesMap.get("friendname");
		String favouritecolor = memberAttributesMap.get("favouritecolor");
		String PhoneNumber = memberAttributesMap.get("PhoneNumber");

		SecurityQuestionsPage securityQuestionsPage = (SecurityQuestionsPage) getLoginScenario()
				.getBean(PageConstants.SECURITY_QUESTIONS_PAGE);

		securityQuestionsPage.validateTheSecurityQues(friendname, favouritecolor, PhoneNumber);
	}

	
	
	 public static void getRecordsFrom_mbr_table(String firstName, String lastName) throws SQLException {
	    	System.out.println("Getting records from MBR table");
	  	  // Connection con = MRScenario.getPDBDBConnection(MRScenario.getProperties());
	    	Connection con = MRScenario.getPDBDBConnection();
	   	   Statement stmt = null;
	        
	          stmt = con.createStatement();
	          String sql;
	          sql = "SELECT HLTHSF_ID FROM mbr where MDM_FST_NM = '" + firstName
	 				+ "' and MDM_LST_NM = '" + lastName + "'";
	          System.out.println("SQL Query:"+sql);
	          ResultSet rs1 = stmt.executeQuery(sql);
	         // rs1.first();
	          if(rs1.first()){
	        	  System.out.println("Record exists...");
	          String HLTHSF_ID  = rs1.getString("HLTHSF_ID");
	          System.out.println("HSID: "+HLTHSF_ID);
	         
	          }else{
	        	  System.out.println("No record found!!!");
	             // Assert.fail("No record found!!!");
	          }
	          rs1.close();
	          stmt.close();
	          con.close();
	     }
	 public static void deleteRecordsFrom_mbr_extrm_scl_dtl_table(String firstName, String lastName) throws SQLException {
	 		// The following steps will return no. of selected records based on
	 		// first name and last name
		// Connection con = MRScenario.getPDBDBConnection(MRScenario.getProperties());
	 		Connection con = MRScenario.getPDBDBConnection();
		   Statement stmt = null;
	      ResultSet rs = null;
	      stmt = con.createStatement();
	      String sql;
	      sql = "SELECT HLTHSF_ID FROM mbr where MDM_FST_NM = '" + firstName
	 				+ "' and MDM_LST_NM = '" + lastName + "'";
	      
	      System.out.println("SQL Query:"+sql);
	      ResultSet rs1 = stmt.executeQuery(sql);
	      if(rs1.first()){
	      String HLTHSF_ID  = rs1.getString("HLTHSF_ID");
	      System.out.println(HLTHSF_ID);
	 		rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_extrm_scl_dtl where HLTHSF_ID = '" + HLTHSF_ID + "'");
	 		int initialrowcount = 0;
	 		while (rs.next()) {
	 			initialrowcount = rs.getInt(1);
	 		}
	 		System.out.println("Total selected records to delete from mbr_extrm_scl_dtl table are: " + initialrowcount);
	 		stmt.executeUpdate("delete from mbr_extrm_scl_dtl where HLTHSF_ID = '" + HLTHSF_ID + "'");
	 		rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_extrm_scl_dtl where HLTHSF_ID = '" + HLTHSF_ID + "'");
	 		int finalrowcount = 0;
	 		while (rs.next()) {
	 			finalrowcount = rs.getInt(1);
	 		}
	 		System.out.println("Total selected records to delete from mbr_extrm_scl_dtl table are: " + finalrowcount);
	 		if (finalrowcount == 0) {
	 			System.out.println("Records deleted successfully from table: mbr_extrm_scl_dtl");
	 		} else {
	 			System.out.println("Still Records exist in the table: mbr_extrm_scl_dtl");
	 		}
	 	}else{
	 		System.out.println("No Records found in the table: mbr_extrm_scl_dtl");
	 	}
	      rs1.close();
	      stmt.close();
	      con.close();
	 	}
	 
	 public static void deleteRecordsFrom_mbr_prtl_table(String firstName, String lastName) throws SQLException {

	 		// The following steps will return no. of selected records based on
	 		// first name and last name
		// Connection con = MRScenario.getPDBDBConnection(MRScenario.getProperties());
	  	   Connection con = MRScenario.getPDBDBConnection();
	  	   Statement stmt = null;
	         ResultSet rs = null;
	         stmt = con.createStatement();
	 		rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_prtl where MBR_PRTL_FST_NM = '" + firstName
	 				+ "' and MBR_PRTL_LST_NM = '" + lastName + "'");
	 		int initialrowcount = 0;
	 		if(rs.first()){
	 		while (rs.next()) {
	 			initialrowcount = rs.getInt(1);
	 		}
	 		System.out.println("Total selected records to delete from mbr_prtl table are: " + initialrowcount);

	 		
	 		stmt.executeUpdate("delete from mbr_prtl where MBR_PRTL_FST_NM = '" + firstName + "' and MBR_PRTL_LST_NM = '"
	 				+ lastName + "'");
	 		rs = stmt.executeQuery("SELECT COUNT(*) FROM mbr_prtl where MBR_PRTL_FST_NM = '" + firstName
	 				+ "' and MBR_PRTL_LST_NM = '" + lastName + "'");
	 		int finalrowcount = 0;
	 		while (rs.next()) {
	 			finalrowcount = rs.getInt(1);
	 		}
	 		System.out.println("Total selected records to delete from mbr_prtl table are: " + finalrowcount);
	 		if (finalrowcount == 0) {
	 			System.out.println("Records deleted successfully from table: mbr_prtl");
	 		} else {
	 			System.out.println("Still Records exist in the table: mbr_prtl");
	 		}
	 		}else{
	 			System.out.println("No Records found in the table: mbr_prtl !!!");	
	 		}
	 		rs.close();
	        stmt.close();
	        con.close();
	 	}
	 
	 public static void deleteRecordsFrom_mbr_table(String firstName, String lastName) throws SQLException {
		// Connection con = MRScenario.getPDBDBConnection(MRScenario.getProperties());  
		 Connection con = MRScenario.getPDBDBConnection();
	  	   Statement stmt = null;
	         ResultSet rs = null;
	         stmt = con.createStatement();   
	 		rs = stmt.executeQuery(
	 				"SELECT COUNT(*) FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");
	 		int initialrowcount = 0;
	 		if(rs.first()){
	 		while (rs.next()) {
	 			initialrowcount = rs.getInt(1);
	 		}
	 		System.out.println("Total selected records to delete from mbr table are: " + initialrowcount);
	 		stmt.executeUpdate(
	 				"delete from mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");

	 		rs = stmt.executeQuery(
	 				"SELECT COUNT(*) FROM mbr where MDM_FST_NM = '" + firstName + "' and MDM_LST_NM = '" + lastName + "'");
	 		int finalrowcount = 0;
	 		while (rs.next()) {
	 			finalrowcount = rs.getInt(1);
	 		}
	 		System.out.println("Total selected records to delete from mbr table are: " + finalrowcount);
	 		if (finalrowcount == 0) {
	 			System.out.println("Records deleted successfully from table: mbr");
	 		} else {
	 			System.out.println("Still Records exist in the table: mbr");
	 		}
	 		}else{
	 			System.out.println("No Records found in the table: mbr !!!");	
	 		}
	 		rs.close();
	        stmt.close();
	        con.close();
	 	} 
}
