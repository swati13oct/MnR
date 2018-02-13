package acceptancetests.memberredesign.benefitandcoverage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.deprecated.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.DashboardPage;
import pages.member.bluelayer.LoginPage2;
import pages.member.ulayer.ValueAddedServicepage;

/**
 * Functionality: Benefits and Coverage page
 */
public class BenefitsAndCoverageUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	private String userName = null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}


	/**
	 * @toDo : The user logs in to the member Redesign Portal
	 */
	@Given("^registered member with following details logins in the member portal$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			this.userName = userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		// MRScenario.keyEvent(wd);

		LoginPage2 loginPage = new LoginPage2(wd);
		{
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
		Assert.assertTrue(true);
		}
		

	}

	/** 
	 * @toDo : The user navigates to Benefits and coverage page from Rally Dashboard
	 */

	@Then("^the user navigates to Benefits and coverage page$")
	public void user_views_BenefitsAndCoveragejenkins1() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
		}
		else

		{
			System.out.println("Benefits and Coverage page object is Null ");
		}

	}
	/** 
	 * @toDo : The user logs in to legacy site  in Mobile view 
	 */

	@Given("^registered UHC with following details for plan benefits and coverage flow in UMS site Mobile view$")
	public void login_with_memberMobile(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			this.userName = userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		// MRScenario.keyEvent(wd);

		LoginPage2 loginPage = new LoginPage2(wd);

		AccountHomePage accountHomePage = (AccountHomePage) loginPage.loginMobile(userName, pwd, category);

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
		}
	}


	/** 
	 * @toDo : The user navigates to Benefits and coverage page from Rally Dashboard
	 */

	@Then("^the user navigates to Benefits coverage page$")
	public void user_views_BenefitsAndCoveragejenkins() {

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.dashboardPage);

		BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

		}

		else

		{
			System.out.println("Benefits and Coverage page object is Null ");
		}

	}


	/** 
	 * @toDo : The user validates the PlanDocuments Section
	 */


	@Then("^the user validates Plan Documents section")
	public void validateContentOnBenefitsAndCoveragePage1() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.PlanDocumentssection();
	}


	/** 
	 * @toDo : The user validates the headers in Need help section
	 */



	@Then("^the user validates Needhelp header")
	public void validateneedhelpheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
	}

	/** 
	 * @toDo : The user validates the Contact us link in Need help section
	 */

	@Then("^the user validates contactus section")
	public void validatecontactussection() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatecontactussection();
		benefitsCoveragePage.contactUslink();
	}

	/** 
	 * @toDo : The user checks the More Information link in the Need help section
	 */


	@Then("^the user clicks on More Information link$")
	public void the_user_clicks_on_Disclaimers_link() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnDisclaimers();
	}




	public void views_mydoument_validation_ums_site() {
		try {

			JSONObject actual = (JSONObject) loginScenario
					.getBean(PlanBenefitsAndCoverageCommonConstants.MYDOCUMENT_ACTUAL);

			JSONObject expected = (JSONObject) loginScenario
					.getBean(PlanBenefitsAndCoverageCommonConstants.MYDOCUMENT_EXPECTED);

			if (actual != null && expected != null) {
				JSONAssert.assertEquals(expected, actual, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/** 
	 * @toDo : The user checks the view and Document labels in Documents section
	 */

	@And("^the user validates view and document label$")
	public void user_validates_view_and_document_label() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsCoveragePage.getdocuments_label();
		benefitsCoveragePage.getview_label();

	}

	/** 
	 * @toDo : The user validates the language dropdown in Documents section
	 */

	@And("the user validates spanish and chinese should not display in dropdown")
	public void user_validates_spanish_chinese_notvisible() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.languagevalidation();

	}


	/** 
	 * @toDo : The user validates the language dropdown in Documents section and make a selection in the dropdown
	 */

	@And("^the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully$")
	public void validate_languagedropdown(DataTable givenAttributes) {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_langdropdown_first_selection();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String language = memberAttributesMap.get("Language");
		getLoginScenario().saveBean(PlanBenefitsAndCoverageCommonConstants.Language, language);
		benefitsCoveragePage.validate_langdropdown_select(language);
	}


	/** 
	 * @toDo : The user validates the language dropdown in Documents section and validates the default selected language
	 */
	@And("the user validates the language dropdown and the value displayed by default should be English")
	public void user_validates_englishlanguage() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_langdropdown_first_selection();
	}

	/** 
	 * @toDo : The user validates the Hearing section of Ancillary
	 */

	@Then("^the user validates Hearing section$")
	public void user_validates__Hearing_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.HearingSection();

	}
	/** 
	 * @toDo : The user validates the Hearing aid section of Ancillary Benefits
	 */

	@And("^the user validates the Hearing Aid section$")
	public void user_validates__Hearing_Aid_section() {

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.HearingAid();
	}


	/** 
	 * @toDo : The user validates the Vision  section of Ancillary Benefits
	 */

	@And("^the user validates the Vision section$")
	public void user_validates__Vision_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Vision();
	}

	/** 
	 * @toDo : The user validates the Dental  section of Ancillary Benefits
	 */


	@And("^the user validates the Dental section$")
	public void user_validates__Dental_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Dental();
	}

	/** 
	 * @toDo : The user validates the Header  section 
	 */

	@And("^the user validates Header section$")
	public void user_validates__Header_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Header();

	}
	/** 
	 * @toDo : The user validates the chiropractic  section  of Ancillary benefits
	 */


	@And("^the user validates chiropractic section$")
	public void user_validates__chiropractic_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.chiropracticsection();
	}

	/** 
	 * @toDo : The user validates the Disclaimers link under Exclusive hearing section  of Ancillary benefits
	 */


	@And("^user validates and clicks on Disclaimers link under Exclusive hearing$")
	public void user_validates__disclaimerlink() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.ExclusiveDisclaimers();
	}

	/** 
	 * @toDo : The user validates the Learn more button under Exclusive hearing section  of Ancillary benefits
	 */


	@And("^user validates and clicks on Learn More button under Exclusive hearing section$")
	public void user_validates__learnmorebutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Exclusivelearnmore();
	}
	/** 
	 * @toDo : The user validates the Leaving popup in  Ancillary section
	 */

	@And("^user validates the Leaving  popup$")
	public void user_validates__leavingpopup() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Leavingpopup();

	}


	/** 
	 * @toDo : The user validates the cancel button  of the leaving popup in  Ancillary section
	 */

	@And("^user validates and click on Cancel button$")
	public void user_validates__cacenbutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Cancelbutton();
	}
	/** 
	 * @toDo : The user validates the proceed button  of the leaving popup in  Ancillary section
	 */


	@And("^user validates and clicks on Proceed button and navigate to heathnavigationpage$")
	public void user_validates__proceedbutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Proceedbutton();
	}


	/** 
	 * @toDo : The user validates the DrugCoverage section headers and text
	 */
	@And("^the user validates Drug coverage header and text under the section")
	public void user_validates__drugcoverage_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcoverageheaderandtext();
	}
	/** 
	 * @toDo : Validates the text for the Look Up Drugs section
	 */

	@And("^the user validates text for the Look Up Drugs section")
	public void user_validates__lookupdrugs_section() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_lookupdrugstext();
	}
	/** 
	 * @toDo : Validates Look Up Drugs button in  the DrugCosts  section
	 */

	@And("^the user validates Look Up Drugs button should be visible")
	public void user_validates_lookupdrugsbuuton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatelookupdrugsbutton();
	}

	/** 
	 * @toDo : Validates the headers in DrugCopays and Discount section
	 */

	@And("^the user view the Drug Copays & Discounts header")
	public void user_view_drugcopayanddiscountheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugcopayheaderntext();

	}

	/** 
	 * @toDo : Validates the headers in DrugCopays and Discount section for a Lis member
	 */
	@And("the user view the LIS Drug Copays & Discounts header")
	public void user_validate_lisdrugcopaydiscounttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_lisdrugcopayheaderntext();
	}

	/** 
	 * @toDo : Validates the Drug Cost header and text
	 */
	@And("^the user view the Drug Cost header and text")
	public void user_view_drugcostheaderandtext() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugcostheaderntext();
	}

	/** 
	 * @toDo : Validates the text in locate a pharmacy section
	 */
	@And("^the user validates text for the Locate a Pharmacy section")
	public void user_validate_textforlocatepharmacy() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locateapharmacysection();
	}

	/** 
	 * @toDo : Validates the Locate a Pharmacy button in locate a pharmacy section
	 */
	@And("^the user validates Locate a Pharmacy button should be visible")
	public void user_validate_locatepharmacybutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locateapharmacysection();
	}

	/** 
	 * @toDo : Validates the Learnmore tiers links for a Lis member
	 */

	@And("^the user validates tier link should not display")
	public void user_validate_tierinkshouldnotdisplay() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_tierlinknotdisplay();
	}

	/** 
	 * @toDo : Validates the Pharmacy selection dropdown  for a non Lis member
	 */

	@And("^the user validates dropdown selection functionality")
	public void user_validate_dropdwonvalues() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		// JSONObject
		// benefitsandcoverageExectedJson=(JSONObject)loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.validate_drugcostdropdownoptions();
	}


	/** 
	 * @toDo : Validates the Pharmacy  selection dropdown for a Lis member
	 */


	@And("the drugcost dropdown should not display")
	public void user_validate_dropdownshouldnotdisplay() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_dropdownnotdisplay();
	}

	/** 
	 * @toDo : Validates the Learn More links for a Non Lis member
	 */
	@And("^the user validates the Learn More section for stage and tier")
	public void user_validate_links() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_learnmoreaboutlink();
	}

	/** 
	 * @toDo : Validates the Learn More links for a  Lis member
	 */
	@And("^the user validates the Learn More section link for stage")
	public void user_validate_stagelink() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_learnmoreaboutstagelink();
	}

	/** 
	 * @toDo : Validates that the learnmore links expand and collapse on clicking on the links one after one
	 */
	@And("^the user validates the user click on the link it expands and when user clicks it again it should collapse")
	public void user_validate_linksworking() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		// JSONObject benefitsandcoverageExectedJson = (JSONObject)
		// loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.clickOnLearnmoreaboutlinkstage();
		benefitsCoveragePage.clickOnLearnmoreaboutlinktier();
	}

	/** 
	 * @toDo : Validates the Drug costs table  for  a Non Lis member
	 */
	@And("the user should see drug copay and discount table")
	public void user_validate_drugcopaydiscounttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcopaytable();
	}
	/** 
	 * @toDo : Validates the Drug costs table  for  a  Lis member
	 */

	@And("the user should see drug cost table for Lis members")
	public void user_validate_drugcosttable() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttable();
	}

	/** 
	 * @toDo : Validates the  Ways to save section
	 */
	@And("the user should see Ways to save Option")
	public void user_validate_waysToSave() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateWaystoSave();
	}

	/** 
	 * @toDo : Validates the  Plan overview section for  a Non lis member 
	 */
	@And("the user validates plan overview section")
	public void user_validate_planOverview() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverview();
	}

	/** 
	 * @toDo : Validates the  Plan overview section for  a lis member
	 */
	@And("the user validates plan overview section for a Lis member")
	public void user_validate_planOverviewLis() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewLis();
	}

	/** 
	 * @toDo : Validates the  headers section for individual members
	 */
	@And("the user validates headers on Bnc page for indi members")
	public void user_validate_Headers() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeaders();
	}

	/** 
	 * @toDo : Validates the  headers section for group members
	 */
	@And("the user validates headers on Bnc page for group members")
	public void user_validate_Headers_Group() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeadersGroup();
	}
	/** 
	 * @toDo : Validates the  Primary care provider section
	 */

	@And("the user validates the Primarycare Provider section")
	public void user_validate_PrimaryCareProv() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProvider();
	}
	/** 
	 * @toDo : Validates the  Primary care provider section for group members
	 */


	@And("the user validates the Primarycare Provider section for Group")
	public void user_validate_PrimaryCareProvForHmo() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProviderForGroup();
	}

	/** 
	 * @toDo : Validates the Out Of Pocket Maximum section
	 */


	@And("the user validates the Out of Pocket Max section")
	public void user_validate_OutofPocket() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateOutofPocketMax();
	}

	/** 
	 * @toDo : Validates the headers for ship members
	 */

	@And("the user validates headers on Bnc page for ship members")
	public void user_validate_Headers_Ship() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeadersShip();
	}

	/** 
	 * @toDo : Validates the Value added services section for ship members
	 */
	@And("^the user validates the Vas section on benefits and coverage page$")
	public void validate_VAS_section()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.vasSection();
	}

	/** 
	 * @toDo : Validates the hand image in  discount and services section for ship members
	 */

	@And("^the user validates hand image under discount and services section$")
	public void validate_hand_image()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.handimage();
	}

	/** 
	 * @toDo : Validates the Learnmore Button for ship members
	 */

	@And("the user validates learnmorebutton on Bnc page for ship members")
	public void user_validate_learnmorebutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.learnmorebutton();
	}
	/** 
	 * @toDo : Validates the Need help headers of the Need help section
	 */

	@Then("^the user validates the Needhelp header")
	public void validateneedhelpheaderFED() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
	}

	/** 
	 * @toDo : Validates the Value added services page  for ship members
	 */

	@And("^the user validate Value Add Service page$")
	public void validate_Value_Add_page()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		ValueAddedServicepage valueaddedservices= benefitsCoveragePage.navigateToValueAddService();
		if (valueaddedservices!= null) {
			getLoginScenario().saveBean(PageConstantsMnR.VALUE_ADDED_SERVICES, valueaddedservices);
		}
	}

	/** 
	 * @toDo : Validates the Need help section headers for a ship member
	 */
	@Then("^the user validates the need help section for ship")
	public void uservalidatesneedhelpsectionShip() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.validateneedhelpheaderShip();

	}

	/** 
	 * @toDo : Validates the see more ways to contact us section for ship members in Need help section
	 */
	@Then("^the user validates see more ways to contact us section for ship")
	public void uservalidatesseeMoreWaysShip() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.validateContactUsNeedHelp();

	}
	/** 
	 * @toDo : Validates the contact us page on clicking on the link of contact us in Need help section
	 */

	@Then("^the user validates on clicking contact us link it should route to contact us page for ship member")
	public void uservalidatescontactus() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.contactUslinkShip();
	}


}
