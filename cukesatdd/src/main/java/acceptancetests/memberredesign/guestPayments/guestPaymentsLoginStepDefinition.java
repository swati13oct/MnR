package acceptancetests.memberredesign.guestPayments;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.ConfirmOneTimePaymentPage;
import pages.memberrdesignVBF.ReviewOneTimePaymentsPage;
import pages.regression.guestPayments.OneTimeGuestPaymentsPage;
import pages.regression.guestPayments.ReviewOneTimeGuestPaymentsPage;
import pages.regression.guestPayments.confirmOneTimeGuestPaymentsPage;
import pages.regression.guestPayments.guestPaymentsLogin;
import pages.regression.login.HSIDLoginPage;

/**
 * Step definitions for Guest Payments Page on the Member site.
 */
public class guestPaymentsLoginStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Given("^I am on the login screen of Guest Payments Portal$")
	public void the_user_on_LoginPage(DataTable givenAttributes) {
		wd = getLoginScenario().getWebDriver();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String siteName = memberAttributesRow.get(0).getCells().get(1);
		guestPaymentsLogin guestPaymentsLogin = new guestPaymentsLogin(wd, siteName);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE, guestPaymentsLogin);
	}

	


	@Then("^I validate all the header and page elements$")
	public void the_user_verifies_headerAndBody() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.validateHeaderAndBody();

	}

	@When("^I click on link Help me find my id link$")
	public void the_user_clicks_on_helpMeFindMYID() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.validateFindMyID();

	}

	@Then("^I will enter my Member ID and Date of birth$")
	public void the_user_entered_MemberID_DateOfBirth(DataTable memberAttributes) {

		Map<String, String> memberAttributesMap = parseInputArguments(memberAttributes);
		String memberID = memberAttributesMap.get("Member ID");
		String dob = memberAttributesMap.get("Date of Birth");

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.enterIDandBirthDate(memberID, dob);

	}

	@Then("^I will click Next to proceed to the Make a One-time payment page$")

	public void the_user_clicked_NextButton() {
		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario()
				.getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = guestPaymentsLogin.clickNext();

		Assert.assertTrue("PROBLEM - One Time Guest Payments Page is not Displayed", oneTimeGuestPaymentsPage != null);
		getLoginScenario().saveBean(PageConstants.One_Time_Guest_Payments_Page, oneTimeGuestPaymentsPage);
	}

	@Then("^I click on the sign in link and navigate to Member Portal sign in page$")

	public void the_user_clicks_SignIn() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		HSIDLoginPage HSIDLoginPage = guestPaymentsLogin.clickOnSignInLink();
		getLoginScenario().saveBean(PageConstants.HSID_LOGIN_PAGE, HSIDLoginPage);

	}

	@Then("^I will see the Logo specific to my plan and the Sign in button$")

	public void verify_logo_and_signIn(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String siteName = memberAttributesRow.get(0).getCells().get(1);
		HSIDLoginPage HSIDLoginPage = (HSIDLoginPage) getLoginScenario().getBean(PageConstants.HSID_LOGIN_PAGE);
		HSIDLoginPage.validateBrand(siteName);
		HSIDLoginPage.validateSignInButton();

	}

	@Then("^I click on Next button leaving Member ID and Date of birth blank$")

	public void the_user_Clicks_Next_Button() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.clicksNextButton();

	}

	@Then("^I will get an error message$")

	public void the_user_gets_Error() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.checkErrorMessage();

	}

	@Then("^I will get an Error that match cannot be found in GPS$")

	public void the_user_gets_match_Error() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.checkErrorMessageFromGPS();

	}
	

	@Then("^I will click on the Next Button and navigate to an Error page$")

	public void the_user_clicks_Next_to_land_Error_Page() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin = guestPaymentsLogin.clickAndLandOnErrorPage();
		Assert.assertTrue("PROBLEM - One Time Guest Payments Page is not Displayed", guestPaymentsLogin != null);
	}

	@Then("^I will click the Next Button on the login page$")

	public void the_user_clicks_On_Next_Button() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
        guestPaymentsLogin.clicksNextButton();

	}
	@Then("^I will be instructed to call the number on the back of my ID$")

	public void the_user_verifies_details_on_Error_Page() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.verifyDetailsOnErrorPage();

	}

	@Then("^I will not see the sign in link to the authenticated M&R member site$")

	public void signIn_Button_should_not_be_present() {

		guestPaymentsLogin guestPaymentsLogin = (guestPaymentsLogin) getLoginScenario().getBean(PageConstants.GUEST_PAYMENTS_HOME_PAGE);
		guestPaymentsLogin.verifySignInLinkShouldNotBePresent();

	}

	@Then("^I validate all the header and page elements on One-time payment page$")
	public void validate_header_and_PageElements() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.validateHeaderAndPageElements();

	}
	@Then("^I validate payment Amount fields for different member types $")

	public void validateAmountFields(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		boolean pastDueDisplay =Boolean.valueOf(memberAttributesMap.get("pastDue"));
		boolean currentChargesDisplay=Boolean.valueOf(memberAttributesMap.get("currentCharges"));
		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.validateAmountFields(pastDueDisplay,currentChargesDisplay);

	}

	@Then("^I select Past Amount Due and choose a Credit Debit payment Method$")
	public void validatePastAmountDueAndCC() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectAmountDueAndCreditCard();

	}
	
	@Then("^I select Credit Debit payment Method$")
	public void selectCreditDebitLink() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectCreditDebitRadioButton();
	}

	@Then("^I will enter Credit card Details$")
	public void enter_CC_Details(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		ReviewOneTimeGuestPaymentsPage ReviewOneTimeGuestPaymentsPage = oneTimeGuestPaymentsPage.enterCCDetails(memberAttributesMap);

		if (ReviewOneTimeGuestPaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.Review_OneTime_Guest_Payments_Page, ReviewOneTimeGuestPaymentsPage);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>User is on Review One time Guest Payments page<<<<<<<<<<<<<<<<<<<<<<<<,");
		}


	}

	@Then("^I validate header and and page elements on Review & Submit page$")
	public void Review_And_Submit_Header_And_Page_Elements() {

		ReviewOneTimeGuestPaymentsPage reviewOneTimeGuestPaymentsPage = (ReviewOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Review_OneTime_Guest_Payments_Page);
		reviewOneTimeGuestPaymentsPage.validateHeaderAndPageElementsOnReviewAndSubmitPage();

	}
	
	
	@Then("^I click on Change Payment Details link$")
	public void changePaymentDetails() {

		ReviewOneTimeGuestPaymentsPage reviewOneTimeGuestPaymentsPage = (ReviewOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Review_OneTime_Guest_Payments_Page);
		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = reviewOneTimeGuestPaymentsPage.clickOnChangePaymentDetailsLink();
		
		if (oneTimeGuestPaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.One_Time_Guest_Payments_Page, oneTimeGuestPaymentsPage);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>User is on One time Guest Payments page<<<<<<<<<<<<<<<<<<<<<<<<,");
		}
		else
		{
			Assert.assertTrue("PROBLEM - One Time Guest Payments Page is not Displayed", oneTimeGuestPaymentsPage != null);
		}
	
	}

	@Then("^I click on Confirm and Pay$")
	public void clickOnConfirmPay() {

		ReviewOneTimeGuestPaymentsPage reviewOneTimeGuestPaymentsPage = (ReviewOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Review_OneTime_Guest_Payments_Page);

		confirmOneTimeGuestPaymentsPage ConfirmOneTimeGuestPaymentsPage = reviewOneTimeGuestPaymentsPage.clickOnConfirmPayOnReviewPage();

		if (ConfirmOneTimeGuestPaymentsPage != null
				|| (null == ConfirmOneTimeGuestPaymentsPage && ReviewOneTimeGuestPaymentsPage.isBusinessValidation)) {
			getLoginScenario().saveBean(PageConstants.Confirm_OneTime_Guest_Payments_Page, ConfirmOneTimeGuestPaymentsPage);
			System.out.println(">>>>>>>>>>>>>User is on Review One time payments page<<<<<<<<<<<<<<<<<<");

		} else if (null == ConfirmOneTimeGuestPaymentsPage && (!ReviewOneTimePaymentsPage.isBusinessValidation)) {
			System.out.println(">>>>>>>>>>>.Error in navigation to Confirmation page!!!<<<<<<<<<<<<<");
			Assert.fail(">>>>>>>>>>>>>.Error in navigation to Confirmation page!!!<<<<<<<<<<<<<<<<<");
		}

	}

	@Then("^I navigate to Payment confirmation page and validate all the page elements$")
	public void validatePaymentConfirmationPage() {

		confirmOneTimeGuestPaymentsPage confirmOneTimeGuestPaymentsPage = (confirmOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Confirm_OneTime_Guest_Payments_Page);
		confirmOneTimeGuestPaymentsPage.validatePaymentConfirmationPage();


	}

	@Then("^I select Past Amount Due and choose a EFT Checking acc payment Method$")
	public void validatePastAmountDueAndEFTAcc() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectAmountDueAndEFTAcc();

	}

	@Then("^I will enter EFT Checking Account Details$")
	public void enter_EFTCheckingAccount_Details(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		ReviewOneTimeGuestPaymentsPage ReviewOneTimeGuestPaymentsPage = oneTimeGuestPaymentsPage.enterEFTAccountDetails(memberAttributesMap);

		if (ReviewOneTimeGuestPaymentsPage != null) {
			getLoginScenario().saveBean(PageConstants.Review_OneTime_Guest_Payments_Page, ReviewOneTimeGuestPaymentsPage);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>User is on Review One time Guest Payments page<<<<<<<<<<<<<<<<<<<<<<<<,");
		}


	}

	@Then("^I select Past Amount & current charges Due and choose a Credit Debit payment Method$")
	public void validatePastAmountcurrentchargesDueAndCC() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectAmountDueCurrentChargesAndCreditCard();

	}

	@Then("^I select Past Amount & current charges Due and choose a EFT Checking acc payment Method$")
	public void validatePastAmountCurrentChargesDueAndEFTAcc() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectAmountDueCurrentChargesAndEFTAcc();

	}

	@Then("^I select and enter other amount Due and choose a Credit Debit payment Method$")
	public void validateOtherAmountDueAndAndCC(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String otherAmount = memberAttributesRow.get(0).getCells().get(1);
		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectOtherAmountDueAndCreditCard(otherAmount);

	}

	@Then("^I select and entered other amount Due and choose a EFT Checking acc payment Method$")
	public void validateOtherAmountDueAndEFTAcc(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String otherAmount = memberAttributesRow.get(0).getCells().get(1);
		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.selectOtherAmountDueAndEFTAcc(otherAmount);

	}

	@Then("^I entered my Email address and click send button to send receipt on my Email$")
	public void enterEmailandClickSend(DataTable givenAttributes) {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		String emailAddress = memberAttributesRow.get(0).getCells().get(1);
		confirmOneTimeGuestPaymentsPage confirmOneTimeGuestPaymentsPage = (confirmOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Confirm_OneTime_Guest_Payments_Page);
		confirmOneTimeGuestPaymentsPage.enterEmailAndClickSend(emailAddress);


	}

	@Then("^I validate success Email receipt message and click send to another Email$")
	public void validateEmailSuccessAndClickAnotherEmailLink() {

		confirmOneTimeGuestPaymentsPage confirmOneTimeGuestPaymentsPage = (confirmOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Confirm_OneTime_Guest_Payments_Page);
		confirmOneTimeGuestPaymentsPage.emailSuccessAndClickEnterAnotherEmail();

	}

	@Then("^I will click on Sign in and Register Now link to navigate to Member Portal$")
	public void clickOnSignInAndRegisterNowLink() {

		confirmOneTimeGuestPaymentsPage confirmOneTimeGuestPaymentsPage = (confirmOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Confirm_OneTime_Guest_Payments_Page);
		confirmOneTimeGuestPaymentsPage.clickOnSignInLink();
		confirmOneTimeGuestPaymentsPage.clickOnRegisterNowLink();
	}

	@Then("^I will click on Print on Confirm Payment page to print my Payment Receipt$")
	public void clickAndValidatePrintReceiptLink() {

		confirmOneTimeGuestPaymentsPage confirmOneTimeGuestPaymentsPage = (confirmOneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.Confirm_OneTime_Guest_Payments_Page);
		confirmOneTimeGuestPaymentsPage.clickAndValidatePrintReceiptLink();

	}

	@Then("^I will entered other amount Due$")
	public void the_user_entered_Other_Amount_Due(DataTable memberAttributes) {

		Map<String, String> memberAttributesMap = parseInputArguments(memberAttributes);
		String otherAmount = memberAttributesMap.get("Other Amount");

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.enterOtherAmount(otherAmount);

	}

	@Then("^I will get an error message Cannot exceed annual remaining amount$")

	public void other_Amount_Exceed_Error() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.otherAmountExceedAnnualError();

	}

	@Then("^I will get an error message Amount must exceed 1.00$")

	public void other_Amount_Must_Exceed_$1_Error() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.otherAmountExceed1Error();

	}

	@Then("^I will click on Review and Submit button leaving EFT Account information blank$")

	public void reviewAndSubmitClick() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.clickReviewAndSubmit();

	}

	@Then("^I will get an error valid Account EFT information$")

	public void blank_eftAccount_info_Error() {

		OneTimeGuestPaymentsPage oneTimeGuestPaymentsPage = (OneTimeGuestPaymentsPage) getLoginScenario().getBean(PageConstants.One_Time_Guest_Payments_Page);
		oneTimeGuestPaymentsPage.blankeftAccountError();

	}

	

	
}