package acceptancetests.memberredesign.contactus;



import java.util.ArrayList;
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
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member.redesign.ContactUsPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;

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
			String planType = memberAttributesMap.get("Plan Type");
			String businessType = null;
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
		 *  @toDO : the user validates secure email widget on contact us page
		 */
		@Then("^user validates secure email widget in contact us page$")
		public void user_validateSendUaQuestionWidget_UIPage()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		
		/**
		 *  @toDO : the user validates group secure email widget on contact us page
		 */
		@Then("^user validates Group secure email widget  in redesign contact us page$")
		public void user_validates_email_widget_func()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 *  @toDO : the user validates cancel link on secure email widget on contact us page
		 */
		@Then("^user validates cancel click on Group secure email widget  in redesign contact us page$")
		public void user_validates_email_widget_Cancel_Click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailWidgetSection();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 *  @toDO : the user fills the fill out contact form and submit on contact us page
		 */
		@Then("^user clicks on submit question by selecting Finding a Physician option in redesign contact us page$")
		public void user_clicks_submit_question()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.submitQuestionClick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 * @toDO : the user validate the invalid alternative email Id
		 */
		@Then("^user enters invalidate alternative email ID in sendUS A question widget$")
		public void email_Validations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_Field_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 * @toDO : the user validate the invalid confirm alternative email Id
		 */
		@Then("^user enters invalidate Confirm email ID in sendUS A question widget$")
		public void invalidate_confirmEmailValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_confirmEmailID_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 * @toDO : the user validate the blank text for alternative email Id
		 */
		@Then("^user enters blank text  in sendUS A question  message widget$")
		public void invalidate_blankEmailMsgValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_blankText_Message_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}

		/**
		 * @toDO : the user validate the confirmation message after successful submission 
		 */
		@And("^UI should be replaced by a confirmation display$")
		public void UI_should_be_replaced_by_a_confirmation_display(){
			
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			String expectedMessage = "Thank you for your inquiry. We value your input, and would be happy to answer your questions."
				+ " A Customer Service Advocate will review your question and respond to you shortly.";
			
			contactusPage.validateThankYouMessage(expectedMessage);
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
		}
		
		/**
		 * @toDO : the user validate invalid phone number
		 */
		@Then("^user enters invalid phone number  in sendUS A question widget$")
		public void alternative_email_idError_Validations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_invalid_PhoneNumber_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}

		/**
		 * @toDO : the user validate secure email widget section
		 */
		@Then("^user validates secure email widget UI in redesign contact us page$")
		public void user_validates_secure_email_widget_UI_in_redesign_contact_us_page()
		{
			ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactus.validateEmailWidgetSection();
			
		}
		
		/**
		 * @toDO : the user validate secure email widget functionality
		 */
		@Then("^user validates secure email widget in redesign contact us page$")
		public void user_validates_secure_email_widget_functionality_in_redesign_contact_us_page()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 * @toDO : the user validate secure email widget functionality with new email address
		 */
		@Then("^user validates secure email widget functionality using Email Address on File radio button$")
		public void user_validates_email_widget_func_byEmailAddress_Radio_button()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailby_Email_Address_RadioButton();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		/**
		 * @toDO : the user validate secure email messaging model
		 */
		@Then("^user validates secure Messaging Model$")
		public void user_validates_SecureMessagingModel()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSecureEmailModelfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
			
		}
		/**
		 * @toDO : the user validate cancel link on secure email widget section 
		 */
		@Then("^user validates secure Messaging Model Cancel link$")
		public void user_validates_SecureMessagingModel_Cancel()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSecureEmailModel_Cancellink_Click();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
			
		}
		
		/**
		 * @toDO : the user validates go to inbox
		 */
		@Then("^user validates go To Inbox button  in redesign contact us page$")
		public void user_validates_goToInBoxDiaplay()
		{
			ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactus.goToInBoxButtonDisplay();
			
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
		 * @toDO : the user validates cancel link after clicking request to call button
		 */
		@And("^user clicks on send a Request button on Click to call widget$")
		public void Requestcall_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendAreqclick();
			
		}
		
		/**
		 * @toDO : the user validates request to call confirmation
		 */
		@And("^user clicks on Request Confirmation Click$")
		public void RequestcallConfimration_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.reqCallclickConformation();
			
		}
		
		/**
		 * @toDO : the user validates send us a question widget
		 */
		@Then("^user validates sendUS A question Widget in redesign contact us page$")
		public void user_validates_sendUsQuestion_Widget()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSendUsAQuestionWidget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
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

	}

