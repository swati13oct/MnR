package acceptancetests.memberredesign.memberAuth;

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
import com.mysql.jdbc.Driver;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard_deprecated.memberAuth.MemberAuthLoginPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.memberauth.MemberAuthPage;
import pages.regression.memberauth.MemberInformationPage;
import pages.regression.memberauth.MemberSearchPage;
import pages.regression.payments.ConfirmOneTimePaymentPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.payments.ReviewAutomaticPage;
import pages.regression.payments.ReviewOneTimePaymentPage;
import pages.regression.payments.UpdateReviewPage;
import pages.regression.profileandpreferences.CommunicationPreferencePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;

/**
 * 
 * @author pdas101
 *
 */


public class MemberAuthStepDefinition{
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/** 
	 * @todo :user to login for member auth
	 */
	@Given("^the user is on member auth login page$")
	public void the_user_is_on_member_auth_login_page(){
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		MemberAuthLoginPage memberauth = new MemberAuthLoginPage(wd);
		memberauth.navigateToLoginURL();

		if(memberauth!=null){
			getLoginScenario().saveBean(MRConstants.MEMBER_AUTH, memberauth);
		}
	}
	/*public void uhc_login_page(){
        WebDriver wd = getLoginScenario().getWebDriver();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

       // LoginPage loginPage = new LoginPage(wd);
        MemberAuthLoginPage memberauth = new MemberAuthLoginPage(wd);
        getLoginScenario().saveBean(MRConstants.MEMBER_AUTH, memberauth);*/

	//}

	/** 
	 * @todo :user to validate errors for member login with valid user and pwd 
	 */
	@Then ("^the member tries to login with invalid username and correct password and verify the error message$")
	public void member_tries_to_login_with_credentials(DataTable profileAttributes) throws InterruptedException{


		MemberAuthLoginPage memberauth = (MemberAuthLoginPage) getLoginScenario().getBean(MRConstants.MEMBER_AUTH);

		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		//MemberAuthLoginPage memberauth =  (MemberAuthLoginPage);

		memberauth.validateErrorMessage(profileAttributesMap.get("Username") ,profileAttributesMap.get("Password"), profileAttributesMap.get("Error Message"));
		//memberauth.validateErrorMessage(loginname, loginpassword);

	}
	
	
	@Given("^the user is on member auth login flow page$")
	public void member_auth_login_flow_page(){
		WebDriver wd = getLoginScenario().getWebDriverNew();	
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		MemberAuthPage memberauth = new MemberAuthPage(wd);
		memberauth.navigateToLoginURL();

		if(memberauth!=null){
			getLoginScenario().saveBean(MRConstants.MEMBER_AUTH, memberauth);
		}
	}
	
	@When ("^the member is able to login with correct username and password$")
	public void member_logins_with_credentials(DataTable profileAttributes) throws InterruptedException{


		MemberAuthPage memberauth = (MemberAuthPage) getLoginScenario().getBean(MRConstants.MEMBER_AUTH);

		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}		

		memberauth.FirstLogin(profileAttributesMap.get("Username") ,profileAttributesMap.get("Password"));
		
		if(memberauth!=null){
			getLoginScenario().saveBean(PageConstants.Member_Auth_Login, memberauth);
		}

	}
	
	@And("^Member Enters the Username he wants to search$")
	public void member_enters_username_and_searches(DataTable profileAttributes) throws InterruptedException{


		MemberAuthPage memberauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_Login);

		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}		

		MemberAuthPage mauthPage = memberauth.MainMemberLogin(profileAttributesMap.get("MemUsername"));
		
		if(mauthPage!=null){
			getLoginScenario().saveBean(PageConstants.Member_Auth_PopUp, mauthPage);
		} else {
			System.out.println("mauthPage is null");
		}

	}
	
	@And("^Member Enters the memberid and dob he wants to search$")
	public void member_enters_memberidanddob_and_searches(DataTable givenAttributes) throws InterruptedException{


		MemberAuthPage memberauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_Login);

		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String memberid = memberAttributesMap.get("Member ID");
		String month  = memberAttributesMap.get("Month");
		String day = memberAttributesMap.get("Day");
		String year  = memberAttributesMap.get("Year");
	
		MemberAuthPage mauthPage =  memberauth.enterMemberIDAndDob(memberid, month, day, year);
		if(mauthPage!=null){
			getLoginScenario().saveBean(PageConstants.Member_Auth_PopUp, mauthPage);
		} else {
			System.out.println("mauthPage is null");
		}
	}
	
	@And("^User Clicks on the Pop up displayed$")
	public void member_clicks_popup() throws InterruptedException{


		MemberAuthPage popupMauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_PopUp);
		AccountHomePage NewWindow =  popupMauth.PopupClick();
		
		if(NewWindow!=null){
			getLoginScenario().saveBean(PageConstants.DashPage, NewWindow);
		} else {
			System.out.println("NewWindow is null");
		}
	}
	
	/*@And("^User switches to new Tab opened$")
	public void Switch_To_New_Tab() throws InterruptedException{


		MemberAuthPage NewTab = (MemberAuthPage) getLoginScenario().getBean(PageConstants.New_Window);
		MemberAuthPage PayLink =  NewTab.NewTabValidation();
		
		if(NewWindow!=null){
			getLoginScenario().saveBean(PageConstants.New_Window, NewWindow);
		}
	
	}*/
	
	@When("^I search for a member$")
	public void i_search_for_a_member(DataTable givenAttributes) {
		
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		// get parameter Member
		String member = memberAttributesMap.get("Member");
		
		MemberSearchPage memberSearchPage = (MemberSearchPage) getLoginScenario().getBean(PageConstants.MEMBER_AUTHS_SEARCH_PAGE);
		
		MemberInformationPage memberInformationPage = memberSearchPage.memberSearch(member);
		
		if(memberInformationPage != null)				
			getLoginScenario().saveBean(PageConstants.MEMBER_AUTH_INFORMATION_PAGE,
					memberInformationPage);
	}
	
	@Then("^click on the member displayed in the search list$")
	public void click_on_the_member_displayed_in_the_search_list()
	{
		MemberInformationPage memberInformationPage = (MemberInformationPage) getLoginScenario().getBean(PageConstants.MEMBER_AUTH_INFORMATION_PAGE);
		
		AccountHomePage accountHomePage = memberInformationPage.loginAsMember();
		
		if(accountHomePage != null)				
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
	}
	
	@Then("^I will see the disclaimer text at top of the page$")
	public void i_will_see_the_disclaimer_text_at_top_of_the_page(DataTable givenAttributes)
	{
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		// get parameter Disclaimer
		String disclaimer = memberAttributesMap.get("Disclaimer");
		
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		
		ContactUsPage contactUsPage = accountHomePage.navigateToContactUsPage();
		
		Assert.assertEquals(disclaimer, contactUsPage.getDisclaimerTextForMemberAuth());
		
		if(contactUsPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactUsPage);
	}
	
	@Then("^all SUBMIT buttons display message when clicked on contact us page$")
	public void all_SUBMIT_buttons_display_message_when_clicked_on_contact_us_page(DataTable givenAttributes)
	{
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		// get parameter message
		String message = memberAttributesMap.get("Message");
		
		ContactUsPage contactUsPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		
		Assert.assertEquals(message, contactUsPage.getMemberAuthNotAuthorizedToSendUsQuestionMessage());
		
	}
	
	@Then("^request a call access should not be done and display message when clicked$")
	public void request_a_call_access_should_not_be_done_and_display_message_when_clicked(DataTable givenAttributes)
	{
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
		    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		// get parameter message
		String message = memberAttributesMap.get("Message");
		
		ContactUsPage contactUsPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		
		Assert.assertEquals(message, contactUsPage.getMemberAuthNotAuthorizedToSendUsQuestionMessage());
		
	}
	
	@And("^user clicks on member to select$")
	public void member_clicks_on_user_to_select() throws InterruptedException{
		MemberAuthPage memberAuthPage = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_PopUp);
		AccountHomePage accountHomePage =  memberAuthPage.userSelectsMemberEntered();
		
		if(accountHomePage!=null){
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}
		else{
			System.out.println("==================CSR Page for Member not displayed======================");
			Assert.fail();
		}
	}
	
	@And("^memberauth user navigates to Payment Overview Page$")
	public void memberauth_user_navigatesto_paymentoverview() throws InterruptedException{
		AccountHomePage accountHomePage;
		accountHomePage = (AccountHomePage) getLoginScenario()
							.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
					PaymentHistoryPage paymentHistoryPage = accountHomePage.navigateToPaymentHistoryPage();
					if (paymentHistoryPage != null) {
						getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
						System.out.println("User is on Payment overview screen");
					}
		
	}
	
	
	@Then ("^the user click on EOB link and navigates to EOB page$")
	public void the_user_click_on_EOB_link_navigates_t0_EOB_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		EOBPage eobPage = accountHomePage.navigateDirectToEOBPag();
		getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
		
	}
	
	@Then("^the user navigates to profile and preference page$")
	public void the_user_navigates_to_profile_and_preference_page() throws Throwable {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ProfileandPreferencesPage profilePreferencePage = accountHomePage.navigateDirectToProfilePage();
		if(profilePreferencePage!=null){
			getLoginScenario().saveBean(PageConstants.ProfilePreferencesPage, profilePreferencePage);
		}else{
			System.out.println("==================Profile and preference page not displayed======================");
			Assert.fail();
		}
  	}
	

	@Then("^the user validates the profile page and the preference page and navigates to claims page in prod$")
	public void the_user_validates_profile_and_preference_page(DataTable attributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = attributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String planType = memberAttributesMap.get("Plan Type");
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		profilePreferencePage.validatePlanNavTabs(planType);
		profilePreferencePage.validatePlanNameMemberidNameAccountProfile();
		CommunicationPreferencePage communicationPreferencePage = profilePreferencePage.navigateToCommunicationPreferencePage();
		ClaimsSummaryPage claimsSummaryPage = communicationPreferencePage.navigateToClaimsPage();
		getLoginScenario().saveBean(PageConstants.CLAIM_SUMMARY_PAGE, claimsSummaryPage);
  	}

	@And("^the user validates the save preference functionality WRT member auth$")
	public void the_user_validates_the_save_preference_functionality_WRT_member_auth(DataTable  errorText){
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("Error Mesage");
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		profilePreferencePage.validateSavePreferenceWithMemberAuth(errorMessageExpected);
	}
	
	@And("^the user validates edit temproray address functionality WRT member auth$")
	public void the_user_validates_edit_temproray_address_functionality_WRT_member_auth(DataTable  errorText) {
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("Error Mesage");
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		profilePreferencePage.validateTemproraryAddressWithMemberAuth(errorMessageExpected);
 	}

	@And("^the user validates edit alternative address functionality WRT member auth$")
	public void the_user_validates_edit_alternative_address_functionality_WRT_member_auth(DataTable  errorText) {
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("Error Mesage");
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		profilePreferencePage.validateAlternativeAddressWithMemberAuth(errorMessageExpected);
 	}

	@And("^the user validates edit email functionality WRT member auth$")
	public void the_user_validates_edit_email_functionality_WRT_member_auth(DataTable  errorText){
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("Error Mesage");
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);	
		profilePreferencePage.validateEditEmailWithMemberAuth(errorMessageExpected);
		
	}

	@And("^the user validates edit phone functionality WRT member auth$")
	public void the_user_validates_edit_phone_functionality_WRT_member_auth(DataTable  errorText) {
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("Error Mesage");
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		profilePreferencePage.validateEditPhoneWithMemberAuth(errorMessageExpected);
 	}
	
	@And("^Member Searches for the Username as per the membertype provided$")
	public void member_searches_MemberType(DataTable memberAttributes) throws InterruptedException{

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
		if (desiredAttributes.size() > 1) {
			getLoginScenario().saveBean(LoginCommonConstants.MEMBERTYPE,
					desiredAttributes.get(1));
		}

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
			System.out.println("Member to search for in Member Auth is..." + userName);
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
		}

		MemberAuthPage memberauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_Login);
		MemberAuthPage mauthPage = memberauth.MainMemberLogin(userName);
		
		if(mauthPage!=null){
			getLoginScenario().saveBean(PageConstants.Member_Auth_PopUp, mauthPage);
		} else {
			System.out.println("mauthPage is null");
		}

	}
	

	@Then("^user navigates to Member Auth One Time payment overview and validates error message for Make one time payemnt$")
	public void user_navigates_to_MemberAuth_OneTime_SubmitsPayment_ValidatesError(DataTable  errorText)
			throws Throwable {
		
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("CSR Error");

		ReviewOneTimePaymentPage reviewOneTimePaymentsPage = (ReviewOneTimePaymentPage) getLoginScenario()
				.getBean(PageConstants.Review_OneTime_Payments_Page);
		boolean Validation_Flag = reviewOneTimePaymentsPage
				.Validate_Error_selectAgreeAndClickOnMakePayment(errorMessageExpected);
		if(!Validation_Flag){
			System.out.println("Error Message not displayed for Review Paymenst Page");
			Assert.fail("Member Auth Paymnets - One Time payment - Error Message failed");
		}	
	}
	
	@Then("^user navigates to Member Auth Recurring payment overview and validates error message for Make one time payemnt$")
	public void user_navigates_to_MemberAuth_Recurring_SubmitsPayment_ValidatesError(DataTable  errorText)
			throws Throwable {
		
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("CSR Error");

		ReviewAutomaticPage reviewAutomaticPage = (ReviewAutomaticPage) getLoginScenario()
				.getBean(PageConstants.Review_Automatic_Page);
		boolean Validation_Flag = reviewAutomaticPage
				.Validate_Error_selectAgreeAndClickOnMakePayment(errorMessageExpected);
		if(!Validation_Flag){
			System.out.println("Error Message not displayed for Review Paymenst Page");
			Assert.fail("Member Auth Paymnets - Recurring payment - Error Message failed");
		}	
	}
	
	@Then("^user navigates to Member Auth Update Review Page and validates error message for Submit or Continue$")
	public void user_navigates_to_MemberAuth_Update_ReviewPayment_ValidatesError(DataTable  errorText)
			throws Throwable {
		
		List<DataTableRow> memberAttributesRow = errorText
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String errorMessageExpected = memberAttributesMap.get("CSR Error");

		UpdateReviewPage updateReviewPage = (UpdateReviewPage) getLoginScenario()
				.getBean(PageConstants.Update_Review_Page);
		boolean Validation_Flag = updateReviewPage
				.Validate_Error_selectAgreeAndClickOnMakePayment(errorMessageExpected);
		if(!Validation_Flag){
			System.out.println("Error Message not displayed for Review Paymenst Page");
			Assert.fail("Member Auth Paymnets - Payment Update Review- Error Message failed");
		}	
	}
	
	@Then("^the user validates the claims page and navigates to eob page in prod$")
	public void the_user_validates_claims_page(DataTable  data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String claimSystem = "medical";
		String claimSystem2 ="prescription drug";
		String claimPeriod = memberAttributesMap.get("Claim Period");
		String planType = memberAttributesMap.get("Plan Type");
		
		ClaimsSummaryPage claimsSummaryPage = (ClaimsSummaryPage) getLoginScenario().getBean(PageConstants.CLAIM_SUMMARY_PAGE);
		claimsSummaryPage.validatePlanNavTab(planType);
		claimsSummaryPage.searchClaimsByTimePeriodClaimType(planType,claimPeriod,claimSystem);
		claimsSummaryPage.validateClaimsTableExists(false);
		claimsSummaryPage.searchClaimsByTimePeriodClaimType(planType,claimPeriod,claimSystem2);
		claimsSummaryPage.validateClaimsTableExists(false);
		EOBPage eobPage = claimsSummaryPage.navigateToEOBPage(planType);
		getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
  	}
	
	@Then("^the user validates the EOB page and navigates to benefits and coverage page in prod$")
	public void the_user_validates_eob_page(DataTable  data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		String eobTypeData = "Medical";
		String dateRange = memberAttributesMap.get("Date Range");
		String planType = memberAttributesMap.get("Plan Type");
		eobPage.validatePlanNavTab(planType);
		eobPage.selectEobType(planType, eobTypeData); 
		eobPage.selectDateRange(planType, dateRange,eobTypeData); 
		eobPage.validateEachEOBonUI();
		BenefitsAndCoveragePage bncPage = eobPage.navigateToBncPage();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, bncPage);
	}
	
	@Then("^the user validates the benefits and coverage page in prod$")
	public void the_user_validates_bnc_page(DataTable  data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.validatePlanNavTab(planType);
		bncPage.validateBncPageSections(planType);

	}
	
	@Then("^the user navigates to the documents and resources page and validates PDFs in prod$")
	public void the_user_validates_docs_resources_page(DataTable  data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		
		BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.navigateToDocumentsAndResourcesPage(planType);
		bncPage.validatePlanNavTabOrderMaterialsPage(planType);
		bncPage.validatePdfLinks(planType);
	}
	
	@Then("^the user navigates to the order plan materials page and validates in prod$")
	public void the_user_validates_order_materials_page(DataTable  data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		bncPage.navigateToOrderPlanMaterialsPage();
		bncPage.validatePlanNavTab(planType);
		bncPage.validateOrderPlanMaterialsPage(planType);
	}
	
	@Then("^the user navigates to payments page and validates in prod$")
	public void the_user_validates_payments_page(DataTable  data) throws Throwable {
		List<DataTableRow> memberAttributesRow = data
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		BenefitsAndCoveragePage bncPage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		PaymentHistoryPage paymentsHistoryPage = bncPage.navigateToPaymentsPage();
		paymentsHistoryPage.validatePlanNavTab(planType);
		
		getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE, paymentsHistoryPage);
	
	}
	
}
