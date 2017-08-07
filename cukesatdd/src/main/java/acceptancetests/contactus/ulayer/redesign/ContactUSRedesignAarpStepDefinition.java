package acceptancetests.contactus.ulayer.redesign;



import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.contactus.data.ContactUsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.member.ulayer.ClaimSummarypage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.ContactUsPage;
import pages.member.ulayer.LoginPage;
public class ContactUSRedesignAarpStepDefinition {
	/**
	 * 
	 */

		@Autowired
		MRScenario loginScenario;

		public MRScenario getLoginScenario() {
			return loginScenario;
		}
		
		@Given("^registered UMS member with following attributes$")
		public void ulayer_registered_member_with_following_attributes(
				DataTable memberAttributes) {

			/* Reading the given attribute from feature file */
			/*List<List<String>> dataTable = memberAttributes.raw();
			List<String> desiredAttributes = new ArrayList<String>();

			for (List<String> data : dataTable) {
				desiredAttributes.add(data.get(0));
			}
			System.out.println("desiredAttributes.." + desiredAttributes);
			Map<String, String> loginCreds = loginScenario
					.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
			} */
			List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get parameter username and password
			String userName = memberAttributesMap.get("UserName");
			String passWord = memberAttributesMap.get("Password");
			String category = memberAttributesMap.get("Member Type");
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			LoginPage loginPage = new LoginPage(wd);
			AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginWith(userName, passWord);


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
		
		
		
		@When("^the user validates the contact us redesign  page in AARP site$")
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
			ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactus.validateEmailWidgetSection();
			
		}
		
		@Then("^user validates secure email widget functionality in redesign contact us page$")
		public void user_validates_email_widget_func()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateEmailWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
		
		@Then("^user validates secure email widget functionality using Email Address on File radio button$")
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
			
			/*if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);*/
			
		}
		
		@And("^user clicks on Request Confirmation Click$")
		public void RequestcallConfimration_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.reqCallclickConformation();
			
			/*if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);*/
			
		}
		
		@Then("^user validates sendUS A question Widget in redesign contact us page$")
		public void user_validates_sendUsQuestion_Widget()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACT_US_PAGE);
			
			contactusPage.validateSendUsAQuestionWidget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE,
						contactusPage);
			
		}
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

