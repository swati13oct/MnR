package acceptancetests.memberredesign.memberAuth;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.memberAuth.MemberAuthLoginPage;
import pages.memberrdesignVBF.RallyDashboardPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.memberauth.MemberAuthPage;
import pages.regression.memberauth.MemberInformationPage;
import pages.regression.memberauth.MemberSearchPage;
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
		WebDriver wd = getLoginScenario().getWebDriver();	

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
		}

	}
	
	@And("^User Clicks on the Pop up displayed$")
	public void member_clicks_popup() throws InterruptedException{


		MemberAuthPage popupMauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_PopUp);
		AccountHomePage NewWindow =  popupMauth.PopupClick();
		
		if(NewWindow!=null){
			getLoginScenario().saveBean(PageConstants.DashPage, NewWindow);
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
			getLoginScenario().saveBean(PageConstants.DashPage, accountHomePage);
		}
	
	}
	@Then ("^the user click on EOB link and navigates to EOB page$")
	public void the_user_click_on_EOB_link_navigates_t0_EOB_page(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.DashPage);
		EOBPage eobPage = accountHomePage.navigateDirectToEOBPag();
		getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
		
	}
	
	@Then("^the user navigates to profile and preference page$")
	public void the_user_navigates_to_profile_and_preference_page() throws Throwable {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.DashPage);
		ProfileandPreferencesPage profilePreferencePage = accountHomePage.navigateDirectToProfilePage();
		if(profilePreferencePage!=null){
			getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		}else{
			System.out.println("==================Profile and preference page not displayed======================");
			Assert.fail();
		}
  	}

	@And("^the user validates the save preference functionality WRT member auth$")
	public void the_user_validates_the_save_preference_functionality_WRT_member_auth() throws Throwable {
		ProfileandPreferencesPage profilePreferencePage = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.ProfilePreferencesPage);
		
	}
	
	@And("^the user validates edit temproray address functionality WRT member auth$")
	public void the_user_validates_edit_temproray_address_functionality_WRT_member_auth() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
 	}

	@And("^the user validates edit alternative address functionality WRT member auth$")
	public void the_user_validates_edit_alternative_address_functionality_WRT_member_auth() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
 	}

	@And("^the user validates edit email functionality WRT member auth$")
	public void the_user_validates_edit_email_functionality_WRT_member_auth() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
 	}

	@And("^the user validates edit phone functionality WRT member auth$")
	public void the_user_validates_edit_phone_functionality_WRT_member_auth() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
 	}

}
