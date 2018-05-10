package acceptancetests.memberredesign.contactus;



import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.redesign.ContactUsPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
		 */
		@Given("^registered UMS member with following attributes$")
		public void registered_member_orderplanmaterials_ums(DataTable givenAttributes) throws InterruptedException {

			/* Reading the given attribute from feature file */
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
		}
		
		/**
		 *  @toDO : the user navigate to the contact us page
		 */
		@When("^the user navigates to contact us page in UHC site$")
		public void validates_contactUs_Redesign_Page() {
			
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			
			ContactUsPage contactUsPage = accountHomePage.navigateToContactUsPage();
			if(contactUsPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactUsPage);
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

	}

