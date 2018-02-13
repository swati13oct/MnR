package acceptancetests.deprecated.mobile.login.blayer.redesign.contactus;




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

import pages.member.bluelayer.AccountHomePage;
import pages.mobile.member.blayer.BenefitsSummaryPage;
import pages.mobile.member.blayer.ContactUsPage;
import pages.mobile.member.blayer.LoginPage;
import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.mobile.member.PageConstants;
import acceptancetests.deprecated.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUSRedesignUhcStepDefinition {
	/**
	 * 
	 */

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user logs in with a registered UMS with following details in UHC site$")
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

	
	
	
	@When("^the user validates the contact us redesign  page in UHC site$")
	public void validates_plan_materials_plan_document_section_redesignums() {
		
		BenefitsSummaryPage beneFitsSummaryPage = (BenefitsSummaryPage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_SUMMARY_PAGE);
		ContactUsPage contactUsPage = beneFitsSummaryPage
				.navigateToContactusRedesignPage();
		if(contactUsPage != null)				
			getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
					contactUsPage);
	}
	
		
		@Then("^user validates secure email Group widget UI in redesign contact us page$")
		public void user_validates_email_widget_UIPage()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSendUaQuestionWidget();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		
		@Then("^user validates Group secure email widget  in redesign contact us page$")
		public void user_validates_email_widget_func()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSendUsaQuestionWidgetfunctionality();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		@Then("^user validates cancel click on Group secure email widget  in redesign contact us page$")
		public void user_validates_email_widget_Cancel_Click()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.validateSendUaQuestionWidgetCancelClick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		
		@Then("^user clicks on submit question by selecting Finding a Physician option in redesign contact us page$")
		public void user_clicks_submit_question()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.submitQuestionClick();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		@Then("^user enters invalidate alternative email ID in sendUS A question widget$")
		public void email_Validations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.sendUsQuestion_Field_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		@Then("^user enters invalidate Confirm email ID in sendUS A question widget$")
		public void invalidate_confirmEmailValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.sendUsQuestion_confirmEmailID_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		@Then("^user enters blank text  in sendUS A question  message widget$")
		public void invalidate_blankEmailMsgValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.sendUsQuestion_Message_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		@Then("^user enters invalid phone number  in sendUS A question widget$")
		public void invalidate_PhoneValidations()
		{
			ContactUsPage contactusPage=(ContactUsPage)getLoginScenario().getBean(PageConstants.CONTACTUS_PAGE);
			
			contactusPage.sendUsQuestion_invalid_PhoneNumber_Validations();
			
			if(contactusPage != null)				
				getLoginScenario().saveBean(PageConstants.CONTACTUS_PAGE,
						contactusPage);
			
		}
		
		
	}

