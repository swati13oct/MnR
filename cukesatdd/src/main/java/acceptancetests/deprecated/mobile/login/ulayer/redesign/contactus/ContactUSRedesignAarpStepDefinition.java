package acceptancetests.deprecated.mobile.login.ulayer.redesign.contactus;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.mobile.member.PageConstants;
import acceptancetests.deprecated.mobile.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.mobile.member.ulayer.BenefitsSummaryPage;
import pages.mobile.member.ulayer.ContactUsPage;
import pages.mobile.member.ulayer.LoginPage;
public class ContactUSRedesignAarpStepDefinition {
	/**
	 * 
	 */

		@Autowired
		MRScenario loginScenario;

		public MRScenario getLoginScenario() {
			return loginScenario;
		}
		
		@Given("^AArp member validation on redesigned site$")
		public void ulayer_registered_member_with_following_attributes(
				DataTable memberAttributes) {

			/* Reading the given attribute from feature file */
			/* Reading the given attribute from feature file */
			List<DataTableRow> memberAttributesRow = memberAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
			List<String> desiredAttributes = new ArrayList<String>();
			for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
					.hasNext();) {
				{
					String key = iterator.next();
					desiredAttributes.add(memberAttributesMap.get(key));
				}

			}
			desiredAttributes.add("mobile");
			System.out.println("desiredAttributes.." + desiredAttributes);

			Map<String,String> loginCreds = loginScenario
					.getAMPMemberWithDesiredAttributes(desiredAttributes);
			
			//q2_jun_ulayer175
			String userName = "";
			String pwd = "";
			if (loginCreds == null) {
				// no match found
				System.out.println("Member Type data could not be setup !!!");
				Assert.fail("unable to find a "+ desiredAttributes + " member");
			} else {
				userName = loginCreds.get("user");
				pwd = loginCreds.get("pwd");
				System.out.println("User is..." + userName);
				System.out.println("Password is..." + pwd );
				getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
				getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			}
			
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			LoginPage loginPage = new LoginPage(wd);
			getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);
			
			loginPage = (LoginPage)getLoginScenario().getBean(PageConstants.LOGIN_PAGE);
			loginPage.openAndValidate();
			
			BenefitsSummaryPage benefitsSummaryPage = loginPage.loginWith(userName, pwd);		

			
			if(benefitsSummaryPage !=null)
				getLoginScenario().saveBean(PageConstants.BENEFITS_SUMMARY_PAGE,
						benefitsSummaryPage);
		}

		/*@When("^the user navigates to redesign contact us page in AARP site$")
		public void views_order_materials_in_redesignUms_site() {
			BenefitsSummaryPage beneFitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
			ContactUsPage contactUsPage = beneFitsSummaryPage
					.navigateToContactusRedesignPage();
			if (contactUsPage != null) {

				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactUsPage);

			}

		}
		*/
		
		@When("^the user validates the contact us redesign  page in AARP site$")
		public void validates_plan_materials_plan_document_section_redesignums() {
			
			BenefitsSummaryPage beneFitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
					.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
			ContactUsPage contactUsPage = beneFitsSummaryPage
					.navigateToContactusRedesignPage();
			if(contactUsPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactUsPage);
		}
		
		@Then("^user validates secure email widget UI in redesign contact us page$")
		public void user_validates_email_widget_UIPage()
		{
			ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactus.validateEmailWidgetSection();
			
		}
		
		@Then("^user validates secure email widget functionality in redesign contact us page$")
		public void user_validates_email_widget_func()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateEmailWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		@Then("^user validates secure email widget functionality using Email Address on File radio button$")
		public void user_validates_email_widget_func_byEmailAddress_Radio_button()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateEmailby_Email_Address_RadioButton();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		@Then("^user validates secure Messaging Model$")
		public void user_validates_SecureMessagingModel()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSecureEmailModelfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
			
		}
		
		@Then("^user validates secure Messaging Model Cancel link$")
		public void user_validates_SecureMessagingModel_Cancel()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSecureEmailModel_Cancellink_Click();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
			
		}
		@Then("^user validates secure Messaging Model Prescription link click on SecureEmail Model$")
		public void user_validates_SecureMessagingModel_prescription_link()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSecureEmailModel_PreScripionDruglinkClick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
			
		}
		
		@Then("^user validates go To Inbox button  in redesign contact us page$")
		public void user_validates_goToInBoxDiaplay()
		{
			ContactUsPage contactus=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactus.goToInBoxButtonDisplay();
			
		}
		
		@Then("^user validates clickToCallButton display on contactUS redesign page$")
		public void validates_clickToCall_widget()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validates_clickToCall_widget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		@And("^user clicks on send a Request button on Click to call widget$")
		public void Requestcall_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.sendAreqclick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		@And("^user clicks on Request Confirmation Click$")
		public void RequestcallConfimration_click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.reqCallclickConfrimation();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}

		@Then("^user validates sendUS A question Widget in redesign contact us page$")
		public void user_validates_sendUsQuestion_Widget()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSendUsAQuestionWidget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		@Then("^user validates PDP page display in redesign contact us page$")
		public void PdpPageDisplay()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.PdpPageDisplay();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}

	}

