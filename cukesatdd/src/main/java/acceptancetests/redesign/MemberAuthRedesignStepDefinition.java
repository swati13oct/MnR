package acceptancetests.redesign;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.member.redesign.ContactUsPage;
import pages.member.redesign.GoGreenSplashPage;
import pages.member.redesign.MemberAuthLoginPage;
import pages.member.redesign.MemberInformationPage;
import pages.member.redesign.MemberSearchPage;
import pages.member.redesign.TestHarnessPage;

public class MemberAuthRedesignStepDefinition {
	/**
	 * 
	 */
		@Autowired
		MRScenario loginScenario;

		public MRScenario getLoginScenario() {
			return loginScenario;
		}
		
		@Given("^I am a user of the member auth tool$")
		public void i_am_a_user_of_the_member_auth_tool(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {
			    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			// get parameter username and password
			String username = memberAttributesMap.get("UserName");
			String password = memberAttributesMap.get("Password");
			WebDriver wd = getLoginScenario().getWebDriver();
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

			MemberAuthLoginPage memberAuthLoginPage = new MemberAuthLoginPage(wd);
			
			MemberSearchPage memberSearchPage = (MemberSearchPage)memberAuthLoginPage.loginWith(username, password);

			getLoginScenario().saveBean(PageConstants.MEMBER_AUTHS_SEARCH_PAGE,memberSearchPage);
		}
		
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
			
			TestHarnessPage testHarnessPage = memberInformationPage.loginAsMember();
			
			if(testHarnessPage != null)				
				getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE,
						testHarnessPage);
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
			
			TestHarnessPage testHarnessPage = (TestHarnessPage) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
			
			ContactUsPage contactUsPage = testHarnessPage.navigateToContactUsPage();
			
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
		
	}

