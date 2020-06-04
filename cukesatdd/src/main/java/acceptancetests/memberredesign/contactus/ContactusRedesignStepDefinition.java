package acceptancetests.memberredesign.contactus;



import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * Functionality Contact Us UHC site
 *
 */
public class ContactusRedesignStepDefinition {
	/**
	 * 
	 */
	@Autowired
	MRScenario loginScenario;

	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	 * 		@toDO : user login with the registered member
	 *//*
		@Given("^registered UMS member with following attributes$")
		public void registered_member_orderplanmaterials_ums(DataTable givenAttributes) throws InterruptedException {

			 Reading the given attribute from feature file 
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
			List<String> desiredAttributes = new ArrayList<String>();
			for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
				{
					String key = iterator.next();
					if (!memberAttributesMap.get(key).isEmpty()) {
						desiredAttributes.add(memberAttributesMap.get(key));
					}
				}
			}
			System.out.println("desiredAttributes.." + desiredAttributes);
			Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
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

			LoginPage loginPage = new LoginPage(wd);


			{
				loginPage.navigateToNewDashboardUrl();
				getLoginScenario().saveBean(PageConstantsMnR.LOGIN_PAGE, loginPage);
				AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
				Assert.assertTrue(true);
			}
		}*/

	/**
	 *  @toDO : the user navigate to the contact us page
	 */
	@When("^the user navigates to contact us page in UHC site$")
	public void validates_contactUs_Redesign_Page() {
		System.out.println("*****the user navigates to contact us page in UHC site*****");
			ContactUsPage contactUsPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness) && (MRScenario.environment.equalsIgnoreCase("stage")|| 
				MRScenario.environment.equalsIgnoreCase("offline-stage") || MRScenario.environment.equalsIgnoreCase("team-h"))) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			contactUsPage  = testHarness.navigateToContactUsPageFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			contactUsPage = accountHomePage.navigateToContactUsPage();
		}
		if(contactUsPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactUsPage);
	}

	/**  DIANE
	 * @toDo : user validates static phone number on contact us page
	 */

	@Then("^user should see a static phone number for tech support in redesign contact us page$")
	public void user_should_see_a_static_phone_number_for_tech_support_in_redesign_contact_us_page(DataTable givenAttributes) {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String expectedTFN = memberAttributesMap.get("Expected TFN");

		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateTFN(expectedTFN);



		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}


	/**
	 *  @toDO : the user validates cancel link on secure email widget on contact us page
	 */
	@Then("^user should see Help With This Website and Help With Your Plan sections$")
	public void user_should_see_Help_With_This_Website_and_Help_With_Your_Plan_sections()
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validatelabelAndLinks();

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}
	
	@Then("^validates labels on the contactUS page for SHIP member$")
	public void validates_labels_on_the_contactUS_page_for_SHIP_member()
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateSHIPlabelAndLinks();

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}
	
	@Then("^the user validates the labels and contact numebers on the page$")
	public void validates_labels_on_the_contactUS_page_for_PCP_Medica_member()
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validatePCPMedicalabelAndLinks();

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}
	
	/**
	 *  @toDO : the user validates cancel link on secure email widget on contact us page
	 */
	@Then("^user validates cancel click on secure email widget in redesign contact us page$")
	public void user_validates_cancel_click_on_secure_email_widget_in_redesign_contact_us_page(DataTable givenAttributes)
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateSecureEmailUsWidgetSection(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}
	
	/**
	 *  @toDO : the user validates cancel link on secure email widget on contact us page
	 */
	@Then("^prod user validates cancel click on secure email widget in redesign contact us page$")
	public void prod_user_validates_cancel_click_on_secure_email_widget_in_redesign_contact_us_page(DataTable givenAttributes)
	{ System.out.println("*****prod user validates cancel click on secure email widget in redesign contact us page*****");
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.prodvalidateSecureEmailUsWidgetSection(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}
	
	@Then("^the user click on view questions button and validate the questions links$")
	public void Click_on_view_questions_Link_and_validate_Links(DataTable givenAttributes)throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String plantype = memberAttributesMap.get("Plan Type");
		System.out.println("Plan type is - "+plantype);
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateviewQuestions(plantype);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}
	}

	/**
	 *  @toDO : the user fills the fill out contact form and submit on contact us page
	 */
	@Then("^user fill all the details of Email a question widget and submit$")
	public void user_fill_all_the_details_of_Email_a_question_widget_and_submit(DataTable givenAttributes)
	{
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateEmailAQuestionWidget(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}

	/**
	 * @toDO : the user validate the confirmation message after successful submission 
	 */
	@And("^UI should be replaced by a confirmation display$")
	public void UI_should_be_replaced_by_a_confirmation_display(DataTable givenAttributes){

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		String expectedMessage = memberAttributesMap.get("Expected Message");

		contactusPage.validateThankYouMessage(expectedMessage);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}

	/**
	 * @toDO : the user validate the confirmation message after successful submission 
	 */
	@And("^UI should be replaced by a success confirmation display$")
	public void UI_should_be_replaced_by_a_success_confirmation_display(DataTable givenAttributes){

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		String expectedMessage = memberAttributesMap.get("Expected Message");
		String phoneNumber = memberAttributesMap.get("Format Phone Number");

		contactusPage.validateRequestACallSuccessMessage(expectedMessage, phoneNumber);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}

	/**
	 * @toDO : the user validate invalid phone number
	 */
	@Then("^user fill all the invalid details of Email a question widget and submit$")
	public void alternative_email_idError_Validations(DataTable givenAttributes)
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.fillInvalidDetailsInEmailAQuestionWidget(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}

	/**
	 * @toDO : the user validate the confirmation message after successful submission 
	 */
	@And("^UI should be replaced by error messages$")
	public void UI_should_be_replaced_by_error_messages(DataTable givenAttributes){

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateFiledValidationErrorMessages(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}

	/**
	 * @toDO : the user validates go to inbox
	 */
	@Then("^user validates go To Inbox button in redesign contact us page$")
	public void user_validates_go_To_Inbox_button_in_redesign_contact_us_page()
	{
		ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactus.validateGoToInbox();

	}

	/**
	 * @toDO : the user validates request to call button
	 */
	@Then("^user validates clickToCallButton display on contactUS redesign page$")
	public void validates_clickToCall_widget()
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validates_clickToCall_widget();

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}

	/**
	 * @toDO : the user validates request to call confirmation
	 */
	@And("^user clicks on cancel button on Request a call widget$")
	public void user_clicks_on_cancel_button_on_Request_a_call_widget(DataTable givenAttributes)
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.reqACall_Cancel(givenAttributes);
	}

	/**
	 * @toDO : the user validates request to call confirmation
	 */
	@And("^user clicks on Request Confirmation Click$")
	public void RequestcallConfimration_click(DataTable givenAttributes)
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.reqACall(givenAttributes);

	}

	/**
	 * @toDO : the user validates header display for PDP member
	 */
	@Then("^user validates PDP page display in redesign contact us page$")
	public void PdpPageDisplay()
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.PdpPageDisplay();

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}

	/**
	 *  @toDO : the user fills the Email form and submit on contact us page
	 */
	@Then("^user fill all the email Form details and submit$")
	public void user_fill_all_the_email_Form_details_and_submit(DataTable givenAttributes)
	{
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateEmailFormWidget(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}

	/**
	 * @toDO : the user validate the confirmation message after successful submission in Email Form
	 */
	@And("^UI should be replaced by success request received$")
	public void UI_should_be_replaced_by_success_request_received(DataTable givenAttributes){

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		String expectedMessage = memberAttributesMap.get("Expected Message");

		contactusPage.validateEmailUsSuccessMessage(expectedMessage);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);
	}

	/***
	 * 
	 */
	@Then("^user should only see the Technical Support and Plan Support components$")
	public void user_should_only_see_the_Technical_Support_and_Plan_Support_components() {
		ContactUsPage contactusPage = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactusPage.validateWidgetsForTerminatedMembers();
	}

	@Then("^The user validates the connector model group TFN number$")
	public void the_user_validates_the_TFNNumber()
	{
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateConnectroModelTFNNumber();

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}

	/**
	 * @author sdwaraka
	 * Added for May2 2019 Release
	 * Added to validate Secure email, send a message and Secure Message page as part of validation for F282564
	 * @throws Throwable
	 */

	@Then("^user click on send a message in the secure email widget in redesign contact us page$")
	public void user_click_on_send_a_message_in_the_secure_email_widget_in_redesign_contact_us_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ContactUsPage contactus = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactus.clickOnSendMessage_SecureEmail();
	}
	
	@Then("^user click on account Profile dropdown and click the messages link$")
	public void user_click_on_account_Profile_dropdown_and_click_the_messages_link() throws Throwable {
		System.out.println("****user click on account Profile dropdown and click the messages link*****");
		ContactUsPage contactus = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactus.clickonmessagesLink();
	}
	
	@Then("^user navigate to rally dashboard page and click on account Profile dropdown$")
	public void user_navigate_to_rally_dashboard_page_and_clickonaccount_Profile_dropdown() throws Throwable {
		System.out.println("****user navigate to rally dashboard page and click on account Profile dropdown*****");
		ContactUsPage contactus = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactus.NavigateRallyandclickonmessagesLink();
	}
	
	
	@Then("^the user validates that the SSO secure message Page opens in a new window$")
	public void the_user_validates_that_the_SSO_secure_message_Page_opens_in_a_new_window() throws Throwable {
		System.out.println("the user validates that the SSO secure message Page opens in a new window");
		ContactUsPage contactus = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactus.validateSSOInbox();
	}
	
	@Then("^the user validates SSO secure message Page via messages link from secondry pages opens in a new window$")
	public void the_user_validates_SSO_secure_message_Page_via_messages_link_from_secondry_pages_opens_in_a_new_window() throws Throwable {
		System.out.println("the user validates that the SSO secure message Page opens in a new window");
		ContactUsPage contactus = (ContactUsPage) getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactus.validateSSOInboxViaMessengerLink();
	}
	
	@Then("^the user validates the CHAT section$")
	public void validate_Chat_Section() {	
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
		contactusPage.validateChatWithUs();		
	}
	
	/**
	 *  @toDO : the user validates cancel link on secure email widget on contact us page
	 */
	@Then("^On contactUs page the user should see Help With This Website and Help With Your Plan sections$")
	public void On_contactUs_page_the_user_should_see_Help_With_This_Website_and_Help_With_Your_Plan_sections(DataTable givenAttributes)
	{
		System.out.println("*****On contactUs page the user should see Help With This Website and Help With Your Plan sections****");
		ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);

		contactusPage.validateALLlabelAndLinks(givenAttributes);

		if(contactusPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
					contactusPage);

	}
	
	
	
}

