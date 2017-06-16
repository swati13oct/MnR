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
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
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

			String userName = "q2_jun_grp142";
			String pwd = "Password@1";
			/*if (loginCreds == null) {
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
			}*/ 

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
		
		@Then("^user validates Group secure email widget UI in redesign contact us page$")
		public void user_validates_email_widget_func()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSendUaQuestionWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
	/*	@Then("^user validates secure email widget functionality using Email Address on File radio button$")
		public void user_validates_email_widget_func_byEmailAddress_Radio_button()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailby_Email_Address_RadioButton();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@Then("^user validates secure Messaging Model$")
		public void user_validates_SecureMessagingModel()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSecureEmailModelfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
			
		}
		
		@Then("^user validates secure Messaging Model Cancel link$")
		public void user_validates_SecureMessagingModel_Cancel()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSecureEmailModel_Cancellink_Click();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
			
		}
		
		@Then("^user validates go To Inbox button  in redesign contact us page$")
		public void user_validates_goToInBoxDiaplay()
		{
			ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactus.goToInBoxButtonDisplay();
			
		}
		
		@Then("^user validates clickToCallButton display on contactUS redesign page$")
		public void validates_clickToCall_widget()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validates_clickToCall_widget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@And("^user clicks on send a Request button on Click to call widget$")
		public void Requestcall_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.sendAreqclick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@And("^user clicks on Request Confirmation Click$")
		public void RequestcallConfimration_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.reqCallclickConfrimation();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}*/

		/*@After
		public void tearDown() {
			WebDriver wd = (WebDriver) getLoginScenario().getBean(
					CommonConstants.WEBDRIVER);
			if(wd!=null){
				wd.quit();
			}
			getLoginScenario().flushBeans();
		}*/

	}

