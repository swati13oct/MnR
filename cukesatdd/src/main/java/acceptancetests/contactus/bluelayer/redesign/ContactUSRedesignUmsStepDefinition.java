package acceptancetests.contactus.bluelayer.redesign;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.ContactUsPage;
import pages.member.bluelayer.LoginPage;
import pages.member.redesign.NewLoginPage;
import pages.member.redesign.TestHarnessPage;

public class ContactUSRedesignUmsStepDefinition {
	/**
	 * 
	 */
		@Autowired
		MRScenario loginScenario;

		public MRScenario getLoginScenario() {
			return loginScenario;
		}
		
		@Given("^registered UMS member with following attributes$")
		public void registered_member_orderplanmaterials_ums(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get parameter username and password
			String userName = memberAttributesMap.get("UserName");
			String passWord = memberAttributesMap.get("Password");
			String category = memberAttributesMap.get("Member Type");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + passWord);
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			NewLoginPage loginPage = new NewLoginPage(wd);
			
			TestHarnessPage testHarnessPage = (TestHarnessPage) loginPage.loginWith(userName, passWord);

			if (testHarnessPage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,testHarnessPage);
				Assert.assertTrue(true);
			}
			
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
					testHarnessPage);
		}
		
		@When("^the user navigates to contact us page in UHC site$")
		public void validates_contactUs_Redesign_Page() {
			
			TestHarnessPage testHarnessPage = (TestHarnessPage) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			
			/*ContactUsPage contactUsPage = testHarnessPage.navigateToContactUsPage();
			if(contactUsPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactUsPage);*/
		}
		
		@Then("^user validates secure email widget UI in redesign contact us page$")
		public void user_validates_email_widget_UIPage()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSendUaQuestionWidget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		
		
		@Then("^user validates Group secure email widget  in redesign contact us page$")
		public void user_validates_email_widget_func()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSendUsaQuestionWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		@Then("^user validates cancel click on Group secure email widget  in redesign contact us page$")
		public void user_validates_email_widget_Cancel_Click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSendUaQuestionWidgetCancelClick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		
		@Then("^user clicks on submit question by selecting Finding a Physician option in redesign contact us page$")
		public void user_clicks_submit_question()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.submitQuestionClick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@Then("^user clicks on submit question by selecting Billing Information option in redesign contact us page$")
		public void user_clicks_submit_question_using_Billing_info()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.submitQuestionClick_by_BillingInfo_option();
			 
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@Then("^user enters invalidate alternative email ID in sendUS A question widget$")
		public void email_Validations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_Field_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@Then("^user enters invalidate Confirm email ID in sendUS A question widget$")
		public void invalidate_confirmEmailValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_confirmEmailID_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@Then("^user enters blank text  in sendUS A question  message widget$")
		public void invalidate_blankEmailMsgValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_blankText_Message_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}

		@And("^UI should be replaced by a confirmation display$")
		public void UI_should_be_replaced_by_a_confirmation_display(){
			
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			String expectedMessage = "Thank you. We value your input, and will be happy to answer your questions."
				+ " A Customer Service representative will review your question and respond to you shortly.";
			
			contactusPage.validateThankYouMessage(expectedMessage);
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
		}
		
		@Then("^user enters invalid phone number  in sendUS A question widget$")
		public void alternative_email_idError_Validations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendUsQuestion_invalid_PhoneNumber_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}

	

		

	}

