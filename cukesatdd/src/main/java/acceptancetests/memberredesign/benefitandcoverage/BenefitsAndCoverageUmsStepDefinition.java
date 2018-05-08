package acceptancetests.memberredesign.benefitandcoverage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
//import acceptancetests.deprecated.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.member.bluelayer.LoginPage2;

import pages.member.ulayer.ValueAddedServicepage;
import pages.redesign.BenefitsCoveragePage;
import pages.redesign.RedesignLoginPage;
import pages.redesign.UlayerHomePage;
import pages.regression.accounthomepage.AccountHomePage;
/**
 * Functionality: Benefits and Coverage page
 */
public class BenefitsAndCoverageUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	

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
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage2 loginPage = new LoginPage2(wd);
		
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
		
		if (accountHomePage != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
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
			userName = loginCreds.get("user");
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




	/*public void views_mydoument_validation_ums_site() {
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

	}*/

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
		getLoginScenario().saveBean(LoginCommonConstants.Language, language);
		//benefitsCoveragePage.validate_langdropdown_select(language);
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
	 * @toDo : Validates the  Plan overview section for  a Non lis member Ind Member
	 */
	@And("the user validates Ind plan overview")
	public void user_validate_IndplanOverviewsection() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewInd();
	}

	/** 
	 * @toDo : Validates the  Plan overview section for  a lis member
	 */
	@And("the user validates Lis member plan overview section")
	public void user_validate_LisplanOverview() {
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
	@Then("^the user validates ship the need help section")
	public void uservalidatesShipneedhelpsection() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.validateneedhelpheaderShip();

	}

	/** 
	 * @toDo : Validates the see more ways to contact us section for ship members in Need help section
	 */
	@Then("^the user validates for ship see more ways to contact us section")
	public void uservalidatesseeMoreWaysShip() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.validateContactUsNeedHelp();

	}
	/** 
	 * @toDo : Validates the contact us page on clicking on the link of contact us in Need help section
	 */

	@Then("^the user validates for ship member on clicking contact us link it should route to contact us page")
	public void uservalidatescontactus() {
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsnCoveragepage.contactUslinkShip();
	}
	
	@And("^the user can see the values for catastrophic values$")
	public void user_validates_catastrophic_values(){
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsnCoveragepage.valiadateCatastrophicCoverageValue("wotCMSValue");
	}

	
	/**
	 * @author sdwaraka
	 * To Login to redesign 
	 */
	
	@Given("^registered Redesign member for EOB with following attributes$")
	public void registered_member_EOB_redesign(
			DataTable memberAttributes) throws InterruptedException {

		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")
				|| planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

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
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		RedesignLoginPage loginPage = new RedesignLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage)loginPage.loginWith(userName, pwd);
		if (accountHomePage != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}
	}

	/**
	 * @throws InterruptedException 
	 * @author sdwaraka
	 * 
	 */
	
	@Then("^the user navigates to Benefits and Coverage page$")
	public void the_user_navigates_to_Redesign_BnC_page() throws InterruptedException{
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage planBenefitsCoverage = accountHomePage.navigateToBenefitsAndCoverage();
		if (planBenefitsCoverage != null) {
			System.out.println("EOB page Loaded");
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE,
					planBenefitsCoverage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in loading  EOB Page");
		}

	}
	
	
	/**
	 * To validate updated language in Drug Copays and Discounts, Catastrophic Stage for member as per the display flag
	 * @author sdwaraka
	 */
 	@Then("^the user validates Catastrophic Stage language for the member$")
	public void the_user_validates_updated_language_catastrophic_stage(DataTable givenAttributes) {
			List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String updatedLanguage = memberAttributesMap.get("Updated Language");
		String DisplayFlag  = memberAttributesMap.get("Display Flag");
		BenefitsCoveragePage planBenefitsCoverage = (BenefitsCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		boolean flag = planBenefitsCoverage.Validate_Catastrophic_Stage_Language(updatedLanguage,DisplayFlag);
		System.out.println("Updated Language validated - "+flag);
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE,
				planBenefitsCoverage);

		if (flag) {
			System.out.println("Catastrophic Coverage Stage Updated Language validation Passed");
				Assert.assertTrue(true);
		} 
		else{
			Assert.fail("ERROR Validating Catastrophic Coverage Stage Updated Language");
		}

 	}

@Then("^verify ancillary benefit section is not displayed$")
 	
 	public void ancillary_not_displayed() {
 		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.ancillarynotdisplayed();
 	}

 	
 	/**
	 * @toDo : The user logs in to the member Redesign Portal
	 * @author mrani101
 	 * @throws InterruptedException 
	 */
	@Given("^Registered member with following details$")
	public void registered_member_with_following_details(DataTable memberAttributes) throws InterruptedException{
		
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		
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
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);

			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		LoginPage2 loginPage = new LoginPage2(wd);
		
		AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWithHsid(userName, pwd);
		
		if (accountHomePage != null) {
			 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
			Assert.assertTrue(true);
			
		}
		else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}

	   
	   
	}
	/**
	 * @toDo : The user enters the security questions
	 * @author mrani101
	 */
	
	@When("^I Enter the security questions$")
	public void i_enter_the_security_questions(DataTable givenAttributes)
	{
        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < memberAttributesRow.size(); i++) {
               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
                            memberAttributesRow.get(i).getCells().get(1));
        }
        String friendname = memberAttributesMap.get("friendname");
        String favouritecolor = memberAttributesMap.get("favouritecolor");
        String PhoneNumber = memberAttributesMap.get("PhoneNumber");
        
        AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		accountHomePage.validateTheSecurityQues(friendname,favouritecolor,PhoneNumber);


		
	}

 	
 	/** 
	 * @toDo : User navigates to benefit and coverage page
	 * @author mrani101
	 */
	
	@Then("^The user navigates to Benefits and Coverage page$")
	public void the_user_navigates_to_Redesign_BandC_page() throws InterruptedException{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsAndCoveragePage planBenefitsCoverage = accountHomePage.navigateDirectToBnCPag();
		//getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE,planBenefitsCoverage);
		if (planBenefitsCoverage != null) {
			System.out.println("BNC page Loaded");
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE,
					planBenefitsCoverage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Error in loading  BNC Page");
		}


	}
	
	/** 
	 * @toDo : Validates the Drug costs table  for  a City Of Hartford group member
	 * @author mrani101
	 */
	@And("the user validates City of Hartford prescription Drug Benefits table")
	public void user_validate_hartfort_prescription_drugtable() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validatehartfortprescriptiondrugtable();
						
	}
	
	/** 
	 * @toDo : Validates the Drug costs table  for  a  Town Of Greenwich group member
	 * @author mrani101
	 */
	@And("the user validates Town Of Greenwich table")
	public void user_validate_TownOfGreenwich_drugtable() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateTownOfGreenwichdrugtable();
						
	}
	
	
	
	@And("the user validates the Drug costs Section")
	public void user_validate_drugCostSectionTexas() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validatedrugCostSectionTexas();
						
	}
	@And("the user verifies the Retail Cost sharing table")
	public void user_validate_RetailCostSharing_Drugtable() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateRetailCostSharingdrugtable();
						
	}
	@And("the user verifies the Mail Order Cost sharing table")
	public void user_validate_MailOrderCostSharing_Drugtable() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateMailOrderCostSharing_Drugtable();
						
	}
	
	@And("the user validates the Office Visits section")
	public void user_validate_OfficeVisitssection() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateOfficeVisitssection();
						
	}
	
	@And("the user validates the Outpatient Surgery Center Visits section")
	public void user_validate_outpatientSurgeryVisitssection() {
				
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateoutpatientsurgerycenterVisitssection();
						
	}

	
	
}
