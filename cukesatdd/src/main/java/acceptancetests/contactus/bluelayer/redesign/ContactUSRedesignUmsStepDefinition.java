package acceptancetests.contactus.bluelayer.redesign;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.ContactUsPage;
import pages.member.bluelayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

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
		public void registered_member_orderplanmaterials_ums(
				DataTable memberAttributes) {

			/* Reading the given attribute from feature file */
			List<List<String>> dataTable = memberAttributes.raw();
			List<String> desiredAttributes = new ArrayList<String>();

			for (List<String> data : dataTable) {
				desiredAttributes.add(data.get(1));
			}
			System.out.println("desiredAttributes.." + desiredAttributes);
			Map<String, String> loginCreds = loginScenario
					.getUMSMemberWithDesiredAttributes(desiredAttributes);

			String userName = "";
			String pwd = "";
			if (loginCreds == null) {
				// no match found
				System.out.println("Member Type data could not be setup !!!");
				Assert.fail("unable to find a " + desiredAttributes + " member");
			} else {
				userName = loginCreds.get("user");
				pwd = loginCreds.get("pwd");
				System.out.println("User is..." + userName);
				System.out.println("Password is..." + pwd);
				getLoginScenario()
				.saveBean(LoginCommonConstants.USERNAME, userName);
				getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			}
		WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			LoginPage loginPage = new LoginPage(wd);
			AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, pwd,"Group");
			if (accountHomePage != null) {
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
						accountHomePage);
				Assert.assertTrue(true);
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			} 

			if (accountHomePage != null) {
				getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,accountHomePage);
				Assert.assertTrue(true);
			}
			
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);

			
		}
		
		

		/*@When("^the user navigates to redesign contact us page in AARP site$")
		public void views_order_materials_in_redesignUms_site() {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			ContactUsPage contactUsPage = accountHomePage
					.navigatesToContactUsPage();
			if (contactUsPage != null) {

				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactUsPage);

			}

		}*/
		
		
		
		@When("^the user navigates to contact us page in UHC site$")
		public void validates_contactUs_Redesign_Page() {
			
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			
			ContactUsPage contactUsPage = accountHomePage.navigateToContactusRedesignPage();
			if(contactUsPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactUsPage);
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

