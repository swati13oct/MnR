package acceptancetests.memberredesign.benefitandcoverage;

import java.util.ArrayList;
import java.util.Collection;
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
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.member_deprecated.bluelayer.LoginPage2;
import pages.redesign_deprecated.BenefitsCoveragePage;
import pages.redesign_deprecated.RedesignLoginPage;
import pages.redesign_deprecated.UlayerHomePage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.benefitandcoverage.ValueAddedServicepage;
import pages.regression.testharness.TestHarness;

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

		WebDriver wd = getLoginScenario().getWebDriverNew();
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

	@Then("^The user navigates to Benefits and Coverage page$")
    public void user_views_BenefitsAndCoveragejenkins1(DataTable memberAttributes) {

           //Sardar Start
           BenefitsAndCoveragePage benefitsCoveragePage;
           //Sardar End

           System.out.println("***The user navigates to Benefits and Coverage page***");
           List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
           Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
           for (int i = 0; i < memberAttributesRow.size(); i++) {
                  memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
                               memberAttributesRow.get(i).getCells().get(1));
           }
           String plantype = memberAttributesMap.get("Plan Type");
           Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
           List<String> desiredAttributes = new ArrayList<String>();
           for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
                  {
                        String key = iterator.next();
                        desiredAttributes.add(memberAttributesMap.get(key));
                  }
           }

     //Sardar Start
           if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
        	   TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
        	   benefitsCoveragePage= testHarness.navigateDirectToBnCPagFromTestharnessPage();
           }else {
        	   //Sardar end
        	   AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
        	   //Sardar Start commented try catch and added "}" for End of else
        	   //try {
        	   //Thread.sleep(10000);
        	   //} catch (InterruptedException e) {
        	   // TODO Auto-generated catch block
        	   //e.printStackTrace();
        	   //}
        	   benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag(plantype);
           }
           //Sardar End
           if (benefitsCoveragePage != null) {
        	   getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
           }
           else

           {
        	   System.out.println("Benefits and Coverage page object is Null ");
           }
	}


	@Then("^The user navigate to Benefits and Coverage page$")
	public void user_views_BenefitsAndCoveragejenkins1() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		System.out.println("***The user navigates to Benefits and Coverage page***");
		BenefitsAndCoveragePage benefitsCoveragePage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			benefitsCoveragePage = testHarness.navigateDirectToBnCPag();
		}else{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag();	
		}
		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
			if (memberType.toUpperCase().contains("COMBO")) 
				benefitsCoveragePage.goToSpecificComboTab(planType);
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
			System.out.println("User is.." + userName);
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

	//            @Then("^The user navigates to Benefits and Coverage page$")
	//            public void user_views_BenefitsAndCoveragejenkins(DataTable memberAttributes) {
	//                           List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
	//                           Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	//                           for (int i = 0; i < memberAttributesRow.size(); i++) {
	//
	//                                          memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	//                                                                        memberAttributesRow.get(i).getCells().get(1));
	//                           }
	//
	//                           String plantype = memberAttributesMap.get("Plan Type");
	//                           Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
	//                           List<String> desiredAttributes = new ArrayList<String>();
	//                           for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
	//                                          {
	//                                                         String key = iterator.next();
	//                                                         desiredAttributes.add(memberAttributesMap.get(key));
	//                                          }
	//
	//                           }
	//                           AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	//
	//                           BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag(plantype);
	//
	//                           if (benefitsCoveragePage != null) {
	//                                          getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
	//                           }
	//                           else
	//
	//                           {
	//                                          System.out.println("Benefits and Coverage page object is Null ");
	//                           }
	//
	//            }

	@Then("^user navigates to Benefits coverage page$")
	public void user_views_BenefitsAndCoveragejenkins() {
		/*		System.out.println("***user navigates to Benefits coverage page***");

		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		pages.regression.benefitandcoverage.BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateToBandCPage();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);

		}

		else

		{
			System.out.println("Benefits and Coverage page object is Null ");
		}
*/
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



	@Then("^the user validates Needhelp section")
	public void validateneedhelpheaderPDPGroup() {
		System.out.println("***the user validates Needhelp section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
	}

	/** 
	 * @toDo : The user validates the Contact us link in Need help section
	 */

	@Then("^the user validates contactus section")
	public void validatecontactussection() {
		System.out.println("***the user validates contactus section***");
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
		System.out.println("***the user clicks on More Information link***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnmoreinformation();
	}

	@Then("^the user clicks on More Information link for ship$")
	public void the_user_clicks_on_Disclaimers_link_ship() {
		System.out.println("the user clicks on More Information link");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnmoreinformationship();
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
		System.out.println("***the user validates view and document label***");
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
		System.out.println("***the user validates spanish and chinese should not display in dropdown***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.languagevalidation();

	}

	@And("the user validates Default drug cost drop down value")
	public void user_validates_default_dropDwnOption() {
		System.out.println("***the user validates Default drug cost drop down value***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugCostDropdown_select();

	}
	
	@And("the Individual user validates Default drug cost drop down value")
	public void user_validates_default_dropDwnOptionIndi() {
		System.out.println("***the Individual user validates Default drug cost drop down value***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugCostDropdownzIndividualMAPD_select();

	}
	
	@And("the user validates View all Benefits link and Prescription drug cost section")
	public void user_validates_values_on_Rally() throws InterruptedException {
		System.out.println("***the Individual user validates Default drug cost drop down value***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.rally_dashboardValues();

	}
	
	/** 
	 * @toDo : The user validates the language dropdown in Documents section and make a selection in the dropdown
	 */

	@And("^the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully$")
	public void validate_languagedropdown(DataTable givenAttributes) {
		System.out.println("***the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully***");
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
		benefitsCoveragePage.validate_langdropdown_select(language);
	}
	@And("^the user select the documents language$")
	public void Select_languagedropdown(DataTable givenAttributes) {
		System.out.println("***the user select the documents language***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String language = memberAttributesMap.get("Language");
		getLoginScenario().saveBean(LoginCommonConstants.Language, language);
		benefitsCoveragePage.Select_langdropdown_selection(language);
	}
	
	

	/** 
	 * @toDo : The user validates the language dropdown in Documents section and validates the default selected language
	 */
	@And("the user validates the language dropdown and the value displayed by default should be English")
	public void user_validates_englishlanguage() {
		System.out.println("***the user validates the language dropdown and the value displayed by default should be English***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_langdropdown_first_selection();
	}

	/** 
	 * @toDo : The user validates the Hearing section of Ancillary
	 */

	@Then("^the user validates Hearing section$")
	public void user_validates__Hearing_section() {
		System.out.println("***the user validates Hearing section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.HearingSection();

	}
	/** 
	 * @toDo : The user validates the Hearing aid section of Ancillary Benefits
	 */

	@And("^the user validates the Hearing Aid section$")
	public void user_validates__Hearing_Aid_section() {
		System.out.println("***the user validates the Hearing Aid section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.HearingAid();
	}


	/** 
	 * @toDo : The user validates the Vision  section of Ancillary Benefits
	 */

	@And("^the user validates the Vision section$")
	public void user_validates__Vision_section() {
		System.out.println("***the user validates the Vision section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Vision();
	}

	/** 
	 * @toDo : The user validates the Dental  section of Ancillary Benefits
	 */


	@And("^the user validates the Dental section$")
	public void user_validates__Dental_section() {
		System.out.println("***the user validates the Dental section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Dental();
	}

	/** 
	 * @toDo : The user validates the Header  section 
	 */

	@And("^the user validates Header section$")
	public void user_validates__Header_section() {
		System.out.println("***the user validates Header section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Header();

	}
	/** 
	 * @toDo : The user validates the chiropractic  section  of Ancillary benefits
	 */


	@And("^the user validates chiropractic section$")
	public void user_validates__chiropractic_section() {
		System.out.println("***the user validates chiropractic section***");
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

	@And("^user validates ADDITIONAL BENEFITS Section$")
	public void VIEW_ALL_ANCILLARY_BENEFITS() throws InterruptedException {
;
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.VIEW_ALL_ANCILLARY_BENEFITS();
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
	 *//*

	@And("^user validates the Leaving  popup$")
	public void user_validates__leavingpopup() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Leavingpopup();

	}


	*//** 
	 * @toDo : The user validates the cancel button  of the leaving popup in  Ancillary section
	 *//*

	@And("^user validates and click on Cancel button$")
	public void user_validates__cacenbutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Cancelbutton();
	}
	*//** 
	 * @toDo : The user validates the proceed button  of the leaving popup in  Ancillary section
	 *//*


	@And("^user validates and clicks on Proceed button and navigate to heathnavigationpage$")
	public void user_validates__proceedbutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.Proceedbutton();
	}


*/	/** 
	 * @toDo : The user validates the DrugCoverage section headers and text
	 */
	@And("^the user validates Drug coverage header and text under the section")
	public void user_validates_drugcoverage_section() {
		System.out.println("***the user validates Drug coverage header and text under the section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcoverageheaderandtext();
	}

	@And("^the pdp lis user validates Drug coverage header and text under the section")
	public void user_validates_drugcoverage_section_pdpUsers() {
		System.out.println("***the user validates Drug coverage header and text under the section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcoverageheaderandtext_pdplis();
	}

	@And("^the user validates group Drug coverage header and text under the section")
	public void user_validates__groupdrugcoverage_section() {
		System.out.println("***the user validates group Drug coverage header and text under the section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcoverageheaderandtextgroup();
	}

	/** 
	 * @toDo : Validates the text for the Look Up Drugs section
	 */

	@And("^the user validates text for the Look Up Drugs section")
	public void user_validates__lookupdrugs_section() {
		System.out.println("***the user validates text for the Look Up Drugs section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_lookupdrugstext();
	}
	/** 
	 * @toDo : Validates Look Up Drugs button in  the DrugCosts  section
	 */

	@And("^the user validates Look Up Drugs button should be visible")
	public void user_validates_lookupdrugsbuuton(DataTable memberAttributes ) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatelookupdrugsbutton(plantype);
	}

	@And("^the user validates group Look Up Drugs button should be visible$")
	public void user_validates_grouplookupdrugs()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validategrouplookupdrugsbutton();
	}



	/** 
	 * @toDo : Validates the headers in DrugCopays and Discount section
	 */

	@And("^the user view the Drug Copays & Discounts header")
	public void user_view_drugcopayanddiscountheader() {
		System.out.println("***the user view the Drug Copays & Discounts header***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_drugcopayheaderntext();

	}

	/** 
	 * @toDo : Validates the headers in DrugCopays and Discount section for a Lis member
	 */
	@And("the user view the LIS Drug Copays & Discounts header")
	public void user_validate_lisdrugcopaydiscounttable() {
		System.out.println("***the user view the LIS Drug Copays & Discounts header***");
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
		System.out.println("***the user validates text for the Locate a Pharmacy section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locatepharmacy();
	}

	/** 
	 * @toDo : Validates the Locate a Pharmacy button 
	 */
	@And("^the user validates Locate a Pharmacy button should be visible")
	public void user_validate_locatepharmacybutton(DataTable memberAttributes) {
		System.out.println("***the user validates Locate a Pharmacy button should be visible***");
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locateapharmacysection(plantype);
	}
	@And("^user validates Locate a Pharmacy button should be visible")
	public void user_validate_locatepharmacybutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_locateapharmacysection1();
	}
	/** 
	 * @toDo : Validates the Learnmore tiers links for a Lis member
	 */

	@And("^the user validates tier link should not display")
	public void user_validate_tierinkshouldnotdisplay() {
		System.out.println("***the user validates tier link should not display***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_tierlinknotdisplay();
	}

	/** 
	 * @toDo : Validates the Pharmacy selection dropdown  for a non Lis member
	 */

	@And("^the user validates dropdown selection functionality")
	public void user_validate_dropdwonvalues() {
		System.out.println("***the user validates dropdown selection functionality***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		// JSONObject
		// benefitsandcoverageExectedJson=(JSONObject)loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.validate_drugCostDropdownoptions();
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
		System.out.println("***the user validates the Learn More section for stage and tier***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_learnmoreaboutlink();
	}

	/** 
	 * @throws InterruptedException 
	 * @toDo : Validates the Learn More links for a  Lis member
	 */
	@And("^the user validates the Learn More section link for stage")
	public void user_validate_stagelink() throws InterruptedException {
		System.out.println("***the user validates the Learn More section link for stage***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnLearnmoreaboutlinkstage();
	}

	/** 
	 * @throws InterruptedException 
	 * @toDo : Validates that the learnmore links expand and collapse on clicking on the links one after one
	 */
	@And("^the user validates the user click on the link it expands and when user clicks it again it should collapse")
	public void user_validate_linksworking() throws InterruptedException {
		System.out.println("***the user validates the user click on the link it expands and when user clicks it again it should collapse***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		// JSONObject benefitsandcoverageExectedJson = (JSONObject)
		// loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.clickOnLearnmoreaboutlinkstage();
		benefitsCoveragePage.clickOnLearnmoreaboutlinktier();
	}

	@And("^the lis user validates the user click on the link it expands and when user clicks it again it should collapse")
	public void user_validate_linksworkinglis() throws InterruptedException {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.clickOnLearnmoreaboutlinkstage();
	}

	/** 
	 * @toDo : Validates the Drug costs table  for  a Non Lis member
	 */
	@And("the user should see drug copay and discount table")
	public void user_validate_drugcopaydiscounttable(DataTable givenAttributes ) {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String updatedLanguage = memberAttributesMap.get("Updated Language");
		String DisplayFlag  = memberAttributesMap.get("Display Flag");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		boolean flag = benefitsCoveragePage.Validate_Catastrophic_Stage_Language(updatedLanguage,DisplayFlag);
		System.out.println("Updated Language validated - "+flag);


		if (flag) {
			System.out.println(" Coverage Gap Stage Value validation Passed");
			Assert.assertTrue(true);
		} 
		else{
			Assert.fail("ERROR Validating Coverage Gap  Stage Value");
		}

		//benefitsCoveragePage.tabledynamicdata();




	}

	/** 
	 * @toDo : Validates the Drug costs table  for  a  Lis member
	 */

	@And("the user should see drug cost table for Lis members")
	public void user_validate_drugcosttable() {
		System.out.println("***the user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttable();
	}
	
	@And("the user MAPD LIS should see drug cost table for Lis members")
	public void user_validate_drugcosttableMapdLIS() throws InterruptedException {
		System.out.println("***the user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttableMapdLIS();
	}
	
	
	@And("the Group PDP LIS1 user should see drug cost table for Lis members")
	public void user_validate_drugcosttablePDP_LIS1_Group() {
		System.out.println("***the Group PDP LIS1 user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttablePDPGroupLIS1();
	}
	
	@And("the NON-LIS PDP group user should see drug cost table for Lis members")
	public void user_validate_drugcosttablePDP_NONLIS_Group() {
		System.out.println("***the NON-LIS PDP group user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttablePDPGroup_NONLIS();
	}
	
	@And("the PDP individual NON-LIS  user should see drug cost table for Lis members")
	public void user_validate_drugcosttablePDP_NONLIS_Indi() throws InterruptedException {
		System.out.println("***the PDP individual NON-LIS  user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttablePDPIndi_NONLIS();
	}
	
	@And("the MAPD group user should see drug cost table for Lis members")
	public void user_validate_drugcosttableGroup() {
		System.out.println("***the MAPD group user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttableMAPDLIS4();
	}
	@And("the PDP individual user should see drug cost table for Lis members")
	public void user_validate_drugcosttablePdpIndi() {
		System.out.println("***the MAPD group user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttablePDPLIS3();
	}
	@And("the MAPD NON-LIS group user should see drug cost table for Lis members")
	public void user_validate_drugcosttableGroup_NONLIS() {
		System.out.println("***the MAPD NON-LIS group user should see drug cost table for Lis members***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatedrugcosttableMAPD_NONLIS();
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
	@And("the user validates plan overview section for group")
	public void user_validate_planOverview() {
		System.out.println("***the user validates plan overview section for group***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewgroup();
	}
	
	/** 
	 * @toDo : Validates the  Plan overview section for  a Non lis member individual 
	 */
	@And("the user validates plan overview section for individual")
	public void user_validate_planOverviewIndi() {
		System.out.println("***the user validates plan overview section for group***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewNonLISIndi();
	}
	
	@And("the NON LIS user validates plan overview section for group")
	public void user_validate_planOverviewNoNLIS() {
		System.out.println("***the NON LIS user validates plan overview section for group***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewgroupNONLIS();
	
	}
	
	
	/** 
	 * @toDo : Validates the  Plan overview section for  a Non lis member Ind Member
	 */
	@And("the user validates Ind plan overview")
	public void user_validate_IndplanOverviewsection(DataTable givenAttributes) {
		System.out.println("***the user validates Ind plan overview***");
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String membername = memberAttributesMap.get("Name");
		String memberid  = memberAttributesMap.get("Member ID");
		String effectivedate = memberAttributesMap.get("Effective Date");
		String monthlypremium = memberAttributesMap.get("Monthly premium");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsCoveragePage.validatePlanOverviewInd(membername,memberid,effectivedate,monthlypremium);
	}


	/**
	 * @toDo :Validate plan overview section for Individual members NON LIS 
	 */
	@And("^section the user validates Ind plan overview$")
	public void user_validate_IndplanOverviewsectionformembers() {
		System.out.println("***the user validates Ind plan overview  section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewSectionForMembers();
	}


	/** 
	 * @toDo : Validates the Drug Look up link 
	 */
	@And("^the user validated the Look up Drugs link$")
	public void user_validate_druglookuplink(){ 
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_druglookuplink();
	}
	/** 
	 * @toDo : The user validates the headers in Need help section
	 */

	@Then("^the user validates Need help header")
	public void validateneedhelpheaderPDP() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader1();
	}

	/** 
	 * @toDo : Validates the  Plan overview section for Ind Member with LEP amount 
	 */
	@And("^the user validates Ind plan overview LEP amount and payment due$")

	public void user_validate_IndplanOverviewsectionLEPAmount() throws InterruptedException {
		System.out.println("***the user validates Ind plan overview LEP amount and payment due***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePlanOverviewLEP();

	}
	/***
	 * 
	 */
	@Then("^the user validates Needhelp header and disclaimer link$")
	public void validateneedhelpheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
	}
	/** 
	 * @toDo : Validates the  Plan overview section for  a lis member
	 */
	@And("the user validates Lis member plan overview section")
	/*public void user_validate_LisplanOverview() {
                              BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
                                                            .getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
                              benefitsCoveragePage.validatePlanOverviewLis();
               }*/
	public void user_validate_IndplanOverviewsectionlis(DataTable givenAttributes) {
		System.out.println("***the user validates Lis member plan overview section***");
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String membername = memberAttributesMap.get("Name");
		String memberid  = memberAttributesMap.get("Member ID");
		System.out.println(memberid);
		String effectivedate = memberAttributesMap.get("Effective Date");
		String monthlypremium = memberAttributesMap.get("Monthly premium");
		String extrahelp =memberAttributesMap.get("Extra Help");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		benefitsCoveragePage.validatePlanOverviewIndlis(membername,memberid,effectivedate,monthlypremium,extrahelp);
	}

	/** 
	 * @toDo : Validates the  headers section for individual members
	 */
	@And("the user validates headers on Bnc page for indi members")
	public void user_validate_Headers(DataTable memberAttributes) {
		System.out.println("***the user validates headers on Bnc page for indi members***");
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeaders(plantype);
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
	public void user_validate_PrimaryCareProv(DataTable memberAttributes) {
		System.out.println("***the user validates the Primarycare Provider section***");
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProvider(plantype);
	}
	/** 
	 * @toDo : Validates the  Primary care provider section for group members
	 */


	@And("the user validates the Group Primarycare Provider section")
	public void user_validate_PrimaryCareProvForHmo() {
		System.out.println("***the user validates the Group Primarycare Provider section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProviderForGroup();
	}

	/** 
	 * @toDo : Validates the Out Of Pocket Maximum section
	 */


	@And("the user validates the Out of Pocket Max section")
	public void user_validate_OutofPocket() {
		System.out.println("***the user validates the Out of Pocket Max section***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateOutofPocketMax();
	}

	

	/** 
	 * @toDo : Validates the headers for ship members
	 */

	@And("^the user validates plan overview and summary on Bnc page for ship members$")
	public void user_validate_Headers_Ship(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String benefitsExpectedCount = memberAttributesMap.get("Benefits Expected");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateHeadersShip(benefitsExpectedCount);
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

	@And("the user validates additional information on Bnc page for ship members")
	public void user_validate_learnmorebutton() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.learnmorebutton();
	}
	/** 
	 * @toDo : Validates the Need help headers of the Need help section
	 */

	@Then("^the user validates the Needhelp section")
	public void validateneedhelpheaderFED() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
	}

	/** 
	 * @toDo : Validates the static links in pdf section mapd non lis
	 */
	@Then("^the user validates static links")
	public void validatestaticlinks(DataTable memberAttributes ) {
		System.out.println("***the user validates static links***");
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatestaticlinksinpdf(plantype);
	}

	/** 
	 * @toDo : Validates the group drug table
	 */
	@Then("^the user able to see table and values in it")
	public void validategroupdrugtable(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) 
		{
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.grouptabledynamicdata(plantype);
	}

	/** 
	 * @toDo : Validates the fed drug table
	 */
	@Then("^the user able to see drug table for fed and values in it")
	public void validategroupdrugtable() {
		System.out.println("***the user able to see drug table for fed and values in it***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.fedtabledata();
	}
	
	@Then("^the indi MAPD user able to see drug table and values in it")
	public void validategroupdrugtableMAPD() throws InterruptedException {
		System.out.println("***the indi MAPD user able to see drug table and values in it***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validategroupdrugtableMAPD();
	}
	
	@Then("^the Medica user able to see drug table and values in it")
	public void validategroupdrugtableMedica() throws InterruptedException {
		System.out.println("***the Medica user able to see drug table and values in it***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validategroupdrugtableMedica();
	}
	
	@Then("^the PCP user able to see drug table and values in it")
	public void validategroupdrugtablePCP() throws InterruptedException {
		System.out.println("***the PCP user able to see drug table and values in it***");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validategroupdrugtablePCP();
	}
	
	/** 
	 * @toDo : Validates the group drug table
	 */
	@Then("^the user able to see drug table for pdp and values in it")
	public void validatepdpdrugtable() {
		System.out.println("***the user able to see drug table for pdp and values in it***");

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.fedpdptabledata();
	}




	@Then("^the user validate vas tiles on vas page")
	public void validatevastiles()
	{
		ValueAddedServicepage valueaddedservices = (ValueAddedServicepage) getLoginScenario()
				.getBean(PageConstantsMnR.VALUE_ADDED_SERVICES);
		valueaddedservices.vastiles();

	}

	/** 
	 * @toDo : Validates the static links in pdf section pdp non lis
	 */
	@Then("^the user validates links for pdp in pdf section")
	public void validatestaticlinkspdp(DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String plantype = memberAttributesMap.get("Plan Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatestaticlinksinpdfpdp(plantype);
	}



	/** 
	 * @toDo : Validates the Value added services page  for ship members
	 */

	@And("^the user validate Value Add Service page on clicking additional info button$")
	public void validate_Value_Add_page()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		ValueAddedServicepage valueaddedservices= benefitsCoveragePage.navigateToValueAddService();
		if (valueaddedservices!= null) {
			getLoginScenario().saveBean(PageConstantsMnR.VALUE_ADDED_SERVICES, valueaddedservices);
		}
	}

	@And("^the user validate Value Add Service page comes on clicking additional info button$")
	public void validate_Value_Add_pagetest()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		ValueAddedServicepage valueaddedservices= benefitsCoveragePage.navigateToValueAddServicetest();
		if (valueaddedservices!= null) {
			getLoginScenario().saveBean(PageConstantsMnR.VALUE_ADDED_SERVICES, valueaddedservices);
		}
	}

	@And("^the user validate view more link$")
	public void validate_link()
	{
		ValueAddedServicepage valueaddedservices = (ValueAddedServicepage) getLoginScenario()
				.getBean(PageConstantsMnR.VALUE_ADDED_SERVICES);
		valueaddedservices.validateviewmorelink();
		valueaddedservices.validateviewmorelinkexpand();

	}



	@And("^the user validates pdfs and link for ship$")
	public void validate_pdf_links_ship()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.navigateToValueAddService();

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
	 * To validate pdfs in plan document section
	 * @author njain112
	 */

	@And("^the user verifies that the correct pdfs are there in the plan material section of benefits page$")
	public void verifypdfscoming(DataTable givenAttributes) throws InterruptedException   {
		System.out.println("***the user verifies that the correct pdfs are there in the plan material section of benefits page***");

		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));

		}
		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);

		boolean arraycheck = benefitsnCoveragepage.verifypdfname(targetArray);
		System.out.println(arraycheck);
		Assert.assertTrue("PROBLEM - not getting expected number and/or name of PDFs", arraycheck);
		System.out.println("number and/or name of PDFs are coming correctly");
		
		boolean contentCheck = benefitsnCoveragepage.verifyDocContent(targetArray);
		System.out.println(contentCheck);
		Assert.assertTrue("PROBLEM - PDF content is either null or empty", contentCheck);
		System.out.println("There is content in PDF docs");
		
	}


	//note: Dec2018 - update the step text
	//@And("^the user verifies that the correct pdfs are coming in the plan material section for ship$")
	@And("^the user verifies that the correct pdfs are coming in the plan material section$")
	public void verifypdfscomingship(DataTable givenAttributes) throws InterruptedException   {

		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));

		}
		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);
		System.out.println(values.size());

		boolean arraycheck = benefitsnCoveragepage.verifypdfname(targetArray);
		System.out.println(arraycheck);
		if (arraycheck == true)
		{
			Assert.assertTrue(true);
			System.out.println("all pdfs are coming correctly");
		}
		else 
		{
			Assert.fail();
			System.out.println("pdfs not coming correctly");
		}
	}

	/**
	 * To validate text in table for village members
	 * @author njain112
	 */
	@And("^the Village user validates text in table$")
	public void validatevillagetabletext() throws InterruptedException   {
		System.out.println("***the Village user validates text in table***");
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsnCoveragepage.validatevillagetabletext();

	}
	
	
	@And("^the user validates copay and CoInsurance section$")
	public void validatevillageCopaySection() throws InterruptedException   {
		System.out.println("***the user validates copay and CoInsurance section***");
		BenefitsAndCoveragePage benefitsnCoveragepage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsnCoveragepage.validatevillageCopaySection();

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
		System.out.println("***the user navigates to Benefits and Coverage page***");
		AccountHomePage accountHomePagew = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);

		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
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

	@And("^the user validates the Vas section on benefits and coverage page is not displayed$")

	public void vas_not_displayed() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		System.out.println("Passed");

		Assert.assertTrue(benefitsCoveragePage.vasnotdisplayed());
	}




	/** 
	 * @toDo : Validates the Drug costs table  for  a City Of Hartford group member
	 * @author mrani101
	 */
	@And("the user validates City of Hartford prescription Drug Benefits table")
	public void user_validate_hartfort_prescription_drugtable() {
		System.out.println("***the user validates City of Hartford prescription Drug Benefits table***");         
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
		System.out.println("***the user verifies the Retail Cost sharing table***");

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateRetailCostSharingdrugtable();

	}
	@And("the user verifies the Mail Order Cost sharing table")
	public void user_validate_MailOrderCostSharing_Drugtable() throws InterruptedException {
		System.out.println("***the user verifies the Mail Order Cost sharing table***");

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateMailOrderCostSharing_Drugtable();

	}

	@And("the user validates the Office Visits section")
	public void user_validate_OfficeVisitssection() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateOfficeVisitssection();
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);


	}


	@And("user validates the Office Visits section widgets")
	public void validate_OfficeVisit_Section_Widgets(){                           
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateOfficeVisitssectionWidget();

	}
	@And("the user without providertier validates the Outpatient Surgery Center Visits section")
	public void outpatientcenterwithoutprovidertier(){                           
		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.outpatientcenterwithoutprovidertier();

	}
	
	@And("the user validates the Outpatient Surgery Center Visits section")
	public void user_validate_outpatientSurgeryVisitssection() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateoutpatientsurgerycenterVisitssection();

	}
	@And("the user with providerTier validates the Outpatient Surgery Center Visits section")
	public void OutpatientSurgeryCentervisits_withprovidertiering() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.OutpatientSurgeryCentervisits_withprovidertiering();

	}
	@And("the user validates the ways to save section")
	public void userValidateWaysToSaveSection() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		String memberType = (String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		String planType = (String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		planBenefitsCoverage.validateWaysToSaveSection(planType, memberType);

	}

	@And("the user validates the Benefits for Peehip member")
	public void userValidatesPeehipsection() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.ValidatePeehipsection();

	}

	//note: added argument to support SSUP case
	@And("the user validates the Benefits for MA member")
	public void userValidatesMAsection(DataTable rows) {
		List<List<String>> data = rows.raw();                                                      

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		//planBenefitsCoverage.ValidateMAsection();
		planBenefitsCoverage.validateBncPageSections(data.get(0).get(1));

	}


	@And("the user validates the copay coinsurance in drug costs table")
	public void userValidatesCopayCoinsuranceindrugTable() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validateCopayCoinsuranceInDrugTable();

	}

	@And("the user validates the benefits for a combo member")
	public void userValidatesBenefitsForCombo() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.ValidatesBenefitsForCombo();

	}


	@And("^the user validates the Add Rider functionality$")
	public void theUserValidatesTheAddRiderFunctionality()  {


		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		planBenefitsCoverage.validatesAddRider();

	}


	@Then("^the user validates the remove Rider functionality$")
	public void theUserValidatesTheRemoveRiderFunctionality() {

		BenefitsAndCoveragePage planBenefitsCoverage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
			planBenefitsCoverage.validatesRemoveRider();
	}

	@Then("^verify ancillary benefit section is not displayed$")
	public void ancillary_not_displayed() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue(benefitsCoveragePage.ancillarynotdisplayed());
	}

	@Then("^user validates the Optum Rx link in Benefits and Coverage page$")
	public void user_validates_the_Optum_Rx_link_in_Benefits_and_Coverage_page() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue(benefitsCoveragePage.optumRxLinkdisplayed());                             
	}

	@And("^the user validates the UpdatedText$")
	public void user_validates_the_updated_Text() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue(benefitsCoveragePage.ValidatePDFTextSection());
	}

	@Then("^user verifies presence of jump links$")
	public void user_verifies_presence_of_jump_links(DataTable rows) throws Throwable {
		List<List<String>> data = rows.raw();
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		int planId=0;
		String planType=data.get(0).get(1).trim();
		String rider=data.get(1).get(1).trim();
		String memberType=data.get(2).get(1).trim();
		String identifier=data.get(3).get(1).trim();
		//String count=data.get(2).get(1);
		if(planType.equalsIgnoreCase("MEDICA")||planType.equalsIgnoreCase("PCP"))
			planType="MAPD";
		//planType.replaceAll(planType, "MAPD").toString().trim();

		/*     Menu                                                     
		 * 1-MAPD
		 * 2-MA
		 * 3-MedSupp
		 * 4-PDP
		 * 5-SSUP
		 *  
		 */
		if(planType.equalsIgnoreCase("MAPD"))
			planId=1;
		if(planType.equalsIgnoreCase("MA"))
			planId=2;
		if(planType.equalsIgnoreCase("MedSupp") || planType.equalsIgnoreCase("HIP"))
			planId=3;
		if(planType.equalsIgnoreCase("PDP"))
			planId=4;
		if(planType.equalsIgnoreCase("SSUP"))
			planId=5;


		switch (planId) { 
		case 1: 
			benefitsCoveragePage.verifyPresenceOfJumpLinksMAPD(rider,planType,memberType);
			break; 

		case 2: 
			benefitsCoveragePage.verifyPresenceOfJumpLinksMA(rider,planType,memberType);
			break; 

		case 3: 
			benefitsCoveragePage.verifyPresenceOfJumpLinksMedSupp(rider,planType,memberType);
			break;

		case 4: 
			benefitsCoveragePage.verifyPresenceOfJumpLinksPDP(rider,planType,memberType,identifier);
			break;

		case 5: 
			benefitsCoveragePage.verifyPresenceOfJumpLinksSSUP(rider,planType,memberType);
			break;


		default: 
			System.out.println("Plan Not Found");
			break;


		}

	}

	@Then("^user clicks on the jump links and checks respective sections$")
	public void user_clicks_on_the_jump_links_and_checks_respective_sections(DataTable rows) throws Throwable {
		List<List<String>> data = rows.raw();
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);


		String planType=data.get(0).get(1).trim();
		String rider=data.get(1).get(1).trim();
		String memberType=data.get(2).get(1).trim();
		String identifier=data.get(3).get(1).trim();
		//String count=data.get(2).get(1);
		if(planType.equalsIgnoreCase("MEDICA")||planType.equalsIgnoreCase("PCP"))
			planType="MAPD";

		int planId=0;
		/*     Menu                                                     
		 * 1-MAPD
		 * 2-MA
		 * 3-MedSupp
		 * 4-PDP
		 * 5-SSUP
		 *  
		 */

		if(planType.equalsIgnoreCase("MAPD"))
			planId=1;
		if(planType.equalsIgnoreCase("MA"))
			planId=2;
		if(planType.equalsIgnoreCase("MedSupp"))
			planId=3;
		if(planType.equalsIgnoreCase("PDP"))
			planId=4;
		if(planType.equalsIgnoreCase("SSUP"))
			planId=5;

		switch (planId) { 
		case 1: 
			benefitsCoveragePage.clicksOnJumpLinksAndCheckRespectiveSectionsMAPD(rider,planType,memberType);
			break; 

		case 2: 
			benefitsCoveragePage.clicksOnJumpLinksAndCheckRespectiveSectionsMA(rider,planType,memberType);
			break;  

		case 3: 
			benefitsCoveragePage.clicksOnJumpLinksAndCheckRespectiveSectionsMedSupp(rider,planType,memberType);
			break;

		case 4: 
			benefitsCoveragePage.clicksOnJumpLinksAndCheckRespectiveSectionsPDP(rider,planType,memberType,identifier);
			break;  

		case 5: 
			benefitsCoveragePage.clicksOnJumpLinksAndCheckRespectiveSectionsSSUP(rider,planType,memberType);
			break;

		default: 
			System.out.println("Plan Not Found");
			break;
		}


	}

	@Then("^verifies links irrelevant to the plan type are not displayed$")
	public void verifies_links_irrelevant_to_the_plan_type_are_not_displayed(DataTable rows) throws Throwable {
		List<List<String>> data = rows.raw();
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);

		String planType=data.get(0).get(1).trim();
		String rider=data.get(1).get(1).trim();
		int count=Integer.parseInt(data.get(2).get(1).trim());
		String memberType=data.get(3).get(1).trim();

		if(planType.equalsIgnoreCase("MEDICA")||planType.equalsIgnoreCase("PCP"))
			planType="MAPD";

		benefitsCoveragePage.directoryLinksCount(count,rider,planType,memberType);

	}

	//Added by Fast and Furious for medical Deductible Validation for MA and MAPD Group Members on Benefits and Coverage Page 
	@Then("^the user validates the deductible card for no deductible member$")
	public void the_user_validates_the_deductible_card_for_no_deductible_member() throws Throwable {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue("**** Validation Failed for Group Member - No Medical Deductible ****",benefitsCoveragePage.ValidateBnCNoDeductible());

	}

	@Then("^the user validates the deductible card for Single deductible member$")
	public void the_user_validates_the_deductible_card_for_Single_deductible_member(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String deductibleAmount1 = memberAttributesMap.get("DeductibleAmount1");
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue("**** Validation Failed for Group Member - Single Medical Deductible ****",benefitsCoveragePage.ValidateBnCSingleDeductible(deductibleAmount1));

	}

	@Then("^the user validates the deductible card for Dual deductible member$")
	public void the_user_validates_the_deductible_card_for_Dual_deductible_member(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String deductibleAmount1 = memberAttributesMap.get("DeductibleAmount1");
		String deductibleAmount2 = memberAttributesMap.get("DeductibleAmount2");

		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue("**** Validation Failed for Group Member - Dual Medical Deductible ****",benefitsCoveragePage.ValidateBnC_DualDeductible(deductibleAmount1, deductibleAmount2));

	}
	
	@And("^the user validates the access your drug benefits block$")
	public void the_user_validates_the_access_your_drug_benefits_block() throws Throwable {
		
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue("**** Validation Failed for Group-University Of Kentucky - Access Your Drug Benefits ****",benefitsCoveragePage.validateAccessDrugsBenfitsBlock());
	}
	
	@And("^the user validates the site leaving pop up and click cancel$")
	public void the_user_validates_the_site_leaving_pop_up_and_click_cancel() throws Throwable {
		
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertFalse("**** Validation Failed for Group-University Of Kentucky - site leaving popup cancel flow****",benefitsCoveragePage.validateSiteLeavingPopUpCancelFlow());
		
	}
	
	@And("^the user validates the site leaving pop up and click proceed$")
	public void the_user_validates_the_site_leaving_pop_up_and_click_proceed() throws Throwable {
		
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		Assert.assertTrue("**** Validation Failed for Group-University Of Kentucky - site leaving popup proceed flow ****",benefitsCoveragePage.validateSiteLeavingPopUpProceedFlow());
	}
	@And("^the user validates the providersearch link$")
	public void the_user_validates_the_provider_search_link()
	{
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validate_provider_search_link();
	}

	@And("the user just validates the fields in Primarycare Provider section")
	public void validatePrimaryCareProviderSection() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatePrimaryCareProviderSection();
	}

}//end of class
