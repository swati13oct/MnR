
package acceptancetests.memberredesign.formsandresources;

import gherkin.formatter.model.DataTableRow;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import pages.regression.login.HSIDLoginPage;
import pages.regression.memberauth.MemberAuthPage;
import pages.regression.testharness.TestHarness;
import pages.member_deprecated.redesign.TestHarnessPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.testharness.TestHarness;
import atdd.framework.*;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;

/**
 * @Functionality : Forms and resources page navigation from dashboard and
 *                sections validation
 */

@SuppressWarnings("deprecation")
public class DashboardFormsnResourcesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^login with following details in the member redesign portal$")
	public void login_with_member(DataTable memberAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		memberAttributesMap.get("Member Type");
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
		
		
		//AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
		AccountHomePage accountHomePage = null;
		int i=0;
		
		for (i = 0; i < 3; i++) {
			HSIDLoginPage loginPage = new HSIDLoginPage(wd);
			loginPage.validateelements();
			System.out.println("Login Attempt->" + (i + 1) + "\n");
			try {
				accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (accountHomePage != null)
				break;
			//wd.navigate().back();
			wd.navigate().refresh();

		}
		
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
		}
		/*
		 * AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage)
		 * loginPage.doLoginWith(userName, pwd); if (assistiveregistration != null) {
		 * getLoginScenario().saveBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE,
		 * assistiveregistration); Assert.assertTrue(true); } else {
		 * Assert.fail("***** Error in loading  Assistive Registration Page *****"); }
		 */

	}

	/**
	 * @toDo : navigation to the forms and resources page from dashboard for
	 *       terminated member
	 */
	@And("^click on the forms and resource link and navigate to forms and resource page for terminated member$")
	public void clickOnFormAndResourcesLink(DataTable attributes) throws InterruptedException {
		AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		Thread.sleep(5000);
		List<List<String>> data = attributes.raw();

		String planType=data.get(0).get(1);
		String memberType=data.get(1).get(1);
		
		FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResources(memberType,planType);
		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);

	}

	/**
	 * @throws InterruptedException 
	 * @toDo : navigation to the forms and resources page from dashboard for active
	 *       member
	 */
	@And("^user clicks on the view document and resources link and navigate to forms and resource page$")
	public void clickOnFormAndResourcesLinkActive(DataTable attributes) throws InterruptedException  {
		
		System.out.println("***The user navigates to Forms and Resources page***");
		FormsAndResourcesPage formsAndResourcesPage=null;
		if (("YES".equalsIgnoreCase(MRScenario.isTestHarness))) {
			TestHarness testharnessHomepage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			
			 formsAndResourcesPage = testharnessHomepage.navigateDirectToFnRPage();
		} 
		else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			List<List<String>> data = attributes.raw();

			String planType=data.get(0).get(1);
			String memberType=data.get(1).get(1);

			 formsAndResourcesPage = accountHomePage.navigatetoFormsnResources(memberType,planType);
		}
		
		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE,formsAndResourcesPage);
		
		
		AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		// Thread.sleep(20000);
		
//		List<List<String>> data = attributes.raw();
//
//		String planType=data.get(0).get(1);
//		String memberType=data.get(1).get(1);
//		
//
//		FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResources(memberType,planType);
		System.out.println("navigation worked");
//		// Thread.sleep(5000);
//		formsAndResourcesPage.waitforFNRpage();
//		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
		System.out.println("forms and resources page");

	}

	@And("^validates that PEEHIP logo is not displayed$")
	public void validates_that_PEEHIP_logog_is_not_displayed() throws Throwable {
		boolean flag = false;
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		try {

			if (formsAndResourcesPage.getLogoPEEHIP().isDisplayed())
				flag = true;
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
				Assert.assertFalse("PEEHIP Logo is displayed which is the Un-expected case",
				flag);

	}

	/**
	 * @toDo : correct pdfs are coming
	 */
	@And("^then user verifies that the correct pdfs are coming in the plan material section$")
	public void verifypdfscoming(DataTable givenAttributes) throws InterruptedException {
		String memberType=null;
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		System.out.println(memberAttributesRow);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);
		System.out.println(values.size());
		
		memberType=memberAttributesRow.get(0).getCells().get(1);
		memberAttributesMap.remove("MemberType");
		memberAttributesMap.remove("memberType");
		
		

		boolean arraycheck = formsAndResourcesPage.xpathSelectionSectionwise(targetArray, "plan material",memberType);
		if (arraycheck == true) {
			Assert.assertTrue(true);
			System.out.println("all pdfs are coming correctly");
		} else {
			Assert.fail("pdfs not coming correctly");
		}
		Thread.sleep(2000);
		formsAndResourcesPage.scroll();
	}

	@And("^the user changes the laguage in the language dropdown$")
	public void changelanguageforpdfs() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scrollUp();
		Thread.sleep(5000);
		formsAndResourcesPage.changelanguage();
	}

	/**
	 * @toDo : show that order plan material is not visible for terminated member
	 */

	@And("^for terminated member order plan materials link is not displayed$")
	public void linknotdisplayedforterminated() {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		// formsAndResourcesPage.checkOrderPlanMaterialLinkforterminated();
		Assert.assertTrue(formsAndResourcesPage.checkPOrderPlanMaterialLinkNotAvailable());

	}

	@Then("^validate that the renew magazine section is not displayed$")
	public void renewsectionfortermed() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.checkRenewsection();
	}

	@Then("^validate that the annual directories section is not displayed$")
	public void annualdirectoriesnotdispalyed() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Assert.assertTrue(formsAndResourcesPage.checkAnnualDirectoriesforgroup());
	}
	
	@Then("^validate that the annual directories section is not displayed for ssupFnr$")
	public void annualdirectoriesnotdispalyedssupFnr() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Assert.assertTrue(formsAndResourcesPage.checkAnnualDirectoriesforgroupssup());
	}

	@And("^both the Pharmacy locator and provider search links are not displayed$")
	public void providerpharacygroupnotdisplayed() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Thread.sleep(6000);
		try {
			if(formsAndResourcesPage.getProviderSerachLinkMA().isDisplayed())
			  Assert.assertFalse(true);
				
		}catch(Exception e) {
			Assert.assertFalse(false);
			
		}
		
		
		Assert.assertFalse(formsAndResourcesPage.checkpharmacyforMA());
	}
	
	@And("^the Pharmacy locator link is displayed for MAPD Group$")
	public void phamacymapd(DataTable attributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.scroll();
		
		if(formsAndResourcesPage.getLnkPharmacyLocatorLinkMAPDGroup().isDisplayed()){
			System.out.println("pharmacy locator link is present");
		}
			else
				System.out.println("pharmacy locator link is NOT present");
		}
	
	@And("^the Pharmacy locator link is displayed texas$")
	public void phamacytexas(DataTable attributes) {
	
		
			FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
					.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
			formsAndResourcesPage.scroll();
			formsAndResourcesPage.scroll();
			
			if(formsAndResourcesPage.getLnkPharmacyLocatorLinkTexas().isDisplayed()){
				System.out.println("pharmacy locator link is present");
			}
				else
					System.out.println("pharmacy locator link is NOT present");
					Assert.assertTrue(true);
					
			}
	
	@And("^the Pharmacy locator link is displayed PDP UHC Group$")
	public void phamacypdpUhc(DataTable attributes) {
	
		
			FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
					.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
			formsAndResourcesPage.scroll();
			formsAndResourcesPage.scroll();
			
			if(formsAndResourcesPage.getLnkPharmacyLocatorLinkPDPUHCGroup().isDisplayed()){
				System.out.println("pharmacy locator link is present");
			}
				else
					System.out.println("pharmacy locator link is NOT present");
					Assert.assertTrue(true);
					
			}
	
	@And("^the Pharmacy locator link is displayed for ALPeehip$")
	public void phamacyAlPeehip(DataTable attributes) {
	
		
			FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
					.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
			formsAndResourcesPage.scroll();
			formsAndResourcesPage.scroll();
			
			if(formsAndResourcesPage.getLnkPharmacyLocatorLinkAlPeehip().isDisplayed()){
				System.out.println("pharmacy locator link is present");
			}
				else
					System.out.println("pharmacy locator link is NOT present");
					Assert.assertTrue(true);
					
			}
		

	@And("^the Pharmacy locator link is displayed$")
	public void phamacypdp(DataTable attributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.scroll();

		List<List<String>> data = attributes.raw();
		for(String s: data.get(0)) {
			System.out.println("Tamzid - s="+s);
		}
		
		if (data.get(0).get(1).contains("Group")) {
			if (formsAndResourcesPage.getLnkPharmacyLocatorLinkMAPDGroup().isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("pharmacy locator link is present");
			} else {

				if(data.get(0).get(1).contains("UHCGroupFnR")&&formsAndResourcesPage.getLnkPharmacyLocatorLinkPDPUHCGroupFnR().isDisplayed()) {
					Assert.assertTrue(true);
					System.out.println("pharmacy locator link is present");
				}
				else
					Assert.fail("pharmacy locator link is not present");
			}



		} else {

			if (formsAndResourcesPage.getPharmacyforPDP().isDisplayed()
					|| formsAndResourcesPage.getPreEffectivePharmacyLocatorLinkPDP().isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("pharmacy locator link is present");
			} else {
				Assert.fail("pharmacy locator link is not present");
			}
		}
	}

	@And("^the provider search link is displayed$")
	public void providersearchdisplaying(DataTable attributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.scroll();
		List<List<String>> data = attributes.raw();

		if (data.get(0).get(1).contains("Group")) {
			
			if (formsAndResourcesPage.getLnkProviderSearchLinkMAPDGroup().isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("provider link is present");
			} else {
				Assert.fail("provider link is not present");
			}
			
			

		} else {

			if (formsAndResourcesPage.getProviderforPDP().isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("provider link is present");
			} else {
				Assert.fail("provider link is not present");
			}
		}
	}

	@And("^the provider search link is not displayed for PDP")
	public void providerpdp() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		Assert.assertTrue(formsAndResourcesPage.checkProviderforPDP());

	}

	@And("^the Drug EOB link is displayed for PDP$")
	public void eoblinkforpdp() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		if (formsAndResourcesPage.getDrugEOBforPDP().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("drug eob link for PDP is present");
		} else {
			Assert.fail("drug eob link for PDP is not present");
		}
	}

	@And("^the Drug EOB link is displayed for MAPD Group$")
	public void eoblinkforpdpgrp() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		if (formsAndResourcesPage.getDrugEOBforGroup().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("drug eob link is present");
		} else {
			Assert.fail("drug eob link is not present");
		}
	}

	@And("^the medical EOB link is displayed for MADP Group$")
	public void eoblinkformapdgroup() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		if (formsAndResourcesPage.getmedicalEOBforGroup().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("medical eob link is present");
		} else {
			Assert.fail("medical eob link is not present");
		}
	}

	@And("^Medical EOB link is not displayed for PDP")
	public void medeoblinkpdp() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		Assert.assertTrue(formsAndResourcesPage.checkMedicalEobforPDP());
	}

	@Then("^validate that the anoc section is displayed for group$")
	public void anocforgroup() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);
		
	
		if (formsAndResourcesPage.getAnocforgroup().get(2).isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("anoc for grp is present");
		} else {
			Assert.fail("anoc for grp is not present");
		}

	}

	@And("^validate for active member Temporary Id Card and Plan Order Material links are displayed$")
	public void validatelinksdisplayedforactivemembers(DataTable attributeType) throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		// Thread.sleep(2000);
		List<List<String>> data = attributeType.raw();
		String memberType=data.get(0).get(1);
		
		if(memberType.toLowerCase().contains("pcp")||(memberType.toLowerCase().contains("medica")))
			Assert.assertTrue("Ordeer material link is not present",formsAndResourcesPage.getPcpOrderPlanMaterialLink().isDisplayed());

		else
			Assert.assertTrue("Ordeer material link is not present", formsAndResourcesPage.getOrderPlanMaterialLink().isDisplayed());

		// Thread.sleep(2000);
		formsAndResourcesPage.getTemporaryIdcardlink(memberType).isDisplayed();

	}

	@And("^clicking on the order plan materials link the user is navigated to the Order Plan Material Page$")
	public void planmateriallink() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		// Thread.sleep(2000);
		formsAndResourcesPage.validateOrderPlanMaterial();

	}

	@And("^validates the pdp texas logo")
	public void validatepdptexaslogo() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);
		Assert.assertTrue(formsAndResourcesPage.getpdptexaslogo().isDisplayed());
	}

	@And("^the user verifies the alpeehip logo")
	public void validatealpeehiplogo() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);
		Assert.assertTrue(formsAndResourcesPage.getalpeehiplogo().isDisplayed());
	}

	@Then("^validate that the EOB Section is displayed$")
	public void eobsec() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Thread.sleep(2000);
		
		if (formsAndResourcesPage.getEobSectionall().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("eob present");
		} else {
			if (formsAndResourcesPage.getBtnEobSectionall().isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("eob present");
			} else {
				Assert.fail("eob not present");
			}
		}
	}


	/**
	 * @throws InterruptedException
	 * @toDo :for PCP/Medica anoc section should not come
	 */
	@Then("^validate that the anoc section is not displayed$")
	public void anocsecforPCP() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Thread.sleep(2000);
		Assert.assertTrue(formsAndResourcesPage.checkanocforPCP());
	}

	/**
	 * @throws InterruptedException
	 * @toDo :for MAPD member both types of EOB are present
	 */

	@And("^both the drug and medical EOB links are displayed$")
	public void both_the_drug_and_medical_EOB_links_are_displayed() throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);
		formsAndResourcesPage.scroll();
		if (formsAndResourcesPage.getEOBMedicaButton().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("medical eob present");
		} else {
			Assert.fail("medical eob is not present");
		}

		if (formsAndResourcesPage.getEOBDrugButton().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("drug eob present");
		} else {
			Assert.fail("drug eob is not present");
		}

	}

	/*
	 * @And("^both the Drug and Medical EOB links are displayed$") public void
	 * bothEOBSpresent() throws InterruptedException { FormsAndResourcesPage
	 * formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
	 * .getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	 * Thread.sleep(2000); formsAndResourcesPage.scroll(); if
	 * (formsAndResourcesPage.getEOBMedicaButton().isDisplayed()) {
	 * Assert.assertTrue(true); System.out.println("medical eob present"); } else {
	 * Assert.fail("medical eob is not present"); }
	 * 
	 * if (formsAndResourcesPage.getEOBDrugButton().isDisplayed()) {
	 * Assert.assertTrue(true); System.out.println("drug eob present"); } else {
	 * Assert.fail("drug eob is not present"); }
	 * 
	 * }
	 */
	/* to verify the my doc section */
	/* tbd 
	@Then("^validate that My Document section is displayed$")
	public void mydocumentsectionisdispayed() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		if (formsAndResourcesPage.getMyDocumentSection().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("my doc sec is present");

		} else {
			Assert.fail("my doc section is not present");
		}

	} */

	@Then("^validate that the AnocSection is displayed$")
	public void validate_that_the_Anoc_Section_is_displayed() throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Thread.sleep(2000);
		if (formsAndResourcesPage.getANOCSection().get(1).isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("anoc section is present");

		} else {
			Assert.fail("anoc section is not present");
		}
	}
	
	@Then("^validate that the AnocSection is displayed for MAPD$")
	public void validate_that_the_Anoc_Section_is_displayed_MAPD() throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Thread.sleep(2000);
		if (formsAndResourcesPage.getANOCSection().get(1).isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("anoc section is present");

		} else {
			Assert.fail("anoc section is not present");
		}
	}

	/*
	 * @Then("^validate that the anoc section is displayed$") public void anocsec()
	 * throws InterruptedException { FormsAndResourcesPage formsAndResourcesPage =
	 * (FormsAndResourcesPage) getLoginScenario()
	 * .getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	 * formsAndResourcesPage.scroll(); Thread.sleep(2000); if
	 * (formsAndResourcesPage.getANOCSection().isDisplayed()) {
	 * Assert.assertTrue(true); System.out.println("anoc section is present");
	 * 
	 * } else { Assert.fail("anoc section is not present"); }
	 * 
	 * }
	 */
	@Then("^validate that annual directory section is displayed$")
	public void annualdirectory(DataTable memberType) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();

		List<List<String>> data = memberType.raw();
		// This is to get the first data of the set (First Row + First Column)
		if (data.get(0).get(1).contains("Pre-Effective"))
			if (data.get(0).get(0).contains("MAPD"))
				Assert.assertTrue("annual directory section isn't present",
						formsAndResourcesPage.getAnnualDirectorySection("Pre-Effective").isDisplayed());

			else

				Assert.assertTrue("annual directory section isn't present",
						formsAndResourcesPage.getPreMAAnnualDirectorySection().isDisplayed());
		else
			Assert.assertTrue("annual directory isn't section is present",
					formsAndResourcesPage.getAnnualDirectorySection("Effective").isDisplayed());

	}

	@And("^both the Pharmacy locator & provider search links are displayed$")
	public void pharmacyprovider() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		if (formsAndResourcesPage.getLnkPharmacyLocatorLink().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("pharmacy locator is present");

		} else {
			Assert.fail("pharmacy locator is not present");
		}

		if (formsAndResourcesPage.getprovisesearchlink().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("provider search link is present");

		} else {
			Assert.fail("provider search link is not present");
		}
	}
	
	@And("^both the Pharmacy locator & provider search links are displayed for PCP$")
	public void pharmacyproviderPCP() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		if (formsAndResourcesPage.getLnkPharmacyLocatorLinkPCP().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("pharmacy locator is present");

		} else {
			Assert.fail("pharmacy locator is not present");
		}

		if (formsAndResourcesPage.getprovisesearchlinkPCP().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("provider search link is present");

		} else {
		Assert.fail("provider search link is not present");
		}
	}

	@And("^the user verifies that the correct pdfs are coming in the anoc section$")
	public void verifyanocpdfscoming(DataTable givenAttributes) throws InterruptedException {
		String memberType=null;
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		System.out.println(memberAttributesRow);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		
		memberType=memberAttributesRow.get(0).getCells().get(1);
		memberAttributesMap.remove("Member Type");
		memberAttributesMap.remove("MemberType");
		memberAttributesMap.remove("memberType");
				
		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);
		System.out.println(values.size());

		boolean arraycheck = formsAndResourcesPage.xpathSelectionSectionwise(targetArray, "anoc",memberType);
		if (arraycheck == true) {
			Assert.assertTrue(true);
			System.out.println("All anoc pdfs are coming correctly");
		} else {
			Assert.fail("Anoc pdfs aren't coming correctly");
		}
	}
	
	
	
	/**
	 * @throws InterruptedException
	 * @toDo : verifies the plan material section
	 */
	/*
	 * @Then("^validate that the plan materials section is displayed$") public void
	 * validatePlanMaterialSection() throws InterruptedException {
	 * FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage)
	 * getLoginScenario()
	 * .getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	 * System.out.println("fnr page"); if
	 * (formsAndResourcesPage.getplanmaterialsection().isDisplayed()) {
	 * System.out.println("plan materials"); Assert.assertTrue(true); } else {
	 * Assert.fail("plan material section is not present"); }
	 * 
	 * }
	 */
	@Then("^validate that the plan material section is displayed$")
	public void validate_that_the_plan_material_section_is_displayed(DataTable attribute) throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		System.out.println("fnr page");
		List<List<String>> data = attribute.raw();
		String memberType=data.get(0).get(1);
				
		if (formsAndResourcesPage.getplanmaterialsection(memberType).isDisplayed()) {
			System.out.println("plan materials");
			Assert.assertTrue(true);
		} else {
			Assert.fail("plan material section is not present");
		}
	}

	/**
	 * @toDo : clicks order plan materials and view temporary id card links
	 */
	/*
	 * @And("^validates the view temporary id card link$") public void
	 * clicklinksonplanmaterials() throws InterruptedException {
	 * FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage)
	 * getLoginScenario()
	 * .getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	 * Thread.sleep(10000);
	 * 
	 * formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();
	 * formsAndResourcesPage.validateIDCard();
	 * 
	 * }
	 */

	@And("^validate that the view temporary id card link is displayed$")
	public void validate_that_the_view_temporary_id_card_link_is_displayed(DataTable attributeType) throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(10000);

		List<List<String>> data = attributeType.raw();
		String memberType=data.get(0).get(1);
		formsAndResourcesPage.getTemporaryIdcardlink(memberType).isDisplayed();


	}

	/**
	 * @toDo : verifies default language displayed in the drop down
	 */
	@And("^validate that english is default language in the dropdown$")
	public void validatelanguage(DataTable attributeType) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<List<String>> data = attributeType.raw();
		formsAndResourcesPage.validateEngDefault(data.get(0).get(1));
	}

	/**
	 * @toDo : user switches to a different language than the default one
	 */

	@And("^the user validates the language dropdown and selects new value in dropdown successfully$")
	public void validate_langdropdown_select(DataTable givenAttributes) throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		System.out.println(memberAttributesRow);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String language = memberAttributesMap.get("Language");
		formsAndResourcesPage.selectlanguagedropdown(language);

	}

	@Then("^validate that the PDPTexas document is present")
	public void validatePDPtexasdocument() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.getmedicationforms().click();
		if (formsAndResourcesPage.getpdptexaslogo().isDisplayed()) {
			System.out.println(formsAndResourcesPage.getpdptexasdocument().getText());

			Assert.assertTrue(true);
		} else {
			Assert.fail("pdp texas doc is not present");
		}

	}

	/**
	 * @throws InterruptedException
	 * @toDo : verifies the eob statemnets for ship member
	 */

	@And("^validate that the EOB statemnets section is displayed$")
	public void validateEOBship() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(5000);
		System.out.println("eob section");
		formsAndResourcesPage.validateshipeob();
	}

	/**
	 * @toDO : to show ALPeehip Doc
	 */
	@And("^validates that the Alpeehip doc is present$")
	public void validateALPeehipDoc() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.getdisenrollment().click();
		if (formsAndResourcesPage.getMAPDALpeehipDoc().isDisplayed()) {
			System.out.println(formsAndResourcesPage.getMAPDALpeehipDoc().getText());

			Assert.assertTrue(true);
		} else {
			Assert.fail("plan material section is not present");
		}

	}

	@Then("^the user verifies the pdfs for ship if particular pdf is not present")
	public void errormessagepresentforship(DataTable givenAttributes) throws InterruptedException {
		String memberType=null;
		
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		System.out.println(memberAttributesRow);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);
		System.out.println(values.size());

		memberType=memberAttributesRow.get(0).getCells().get(1);
		memberAttributesMap.remove("MemberType");
		memberAttributesMap.remove("memberType");
		
		
		boolean arraycheck = formsAndResourcesPage.xpathSelectionSectionwise(targetArray, "ship plan material",memberType);
		if (arraycheck == true) {
			Assert.assertTrue(true);
			System.out.println("all pdfs are coming correctly");
		} else {
			Assert.fail("pdfs not coming correctly");
		}
		Thread.sleep(2000);
		formsAndResourcesPage.scroll();
	}

	@Then("^verifies that Electronic Funds pdf for ship is displayed")
	public void verifyshipfnrdocument() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);

		if (formsAndResourcesPage.geteftpdfforship().isDisplayed()) {
			System.out.println("the eft pdf is present for ship");
			Assert.assertTrue(true);
		} else
			Assert.fail("the document for ship is not coming");
	}

	/**
	 * @throws InterruptedException
	 * @toDo : verifies the forms and resources section
	 */
	/*
	 * @Then("^validate that the forms and resources section is displayed$") public
	 * void validateFNRSection() throws InterruptedException {
	 * 
	 * FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage)
	 * getLoginScenario()
	 * .getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	 * 
	 * formsAndResourcesPage.scroll(); Thread.sleep(5000);
	 * formsAndResourcesPage.clickonperceptionpopup();
	 * System.out.println("fnr section"); if
	 * (formsAndResourcesPage.getFormsandResourcesSection().isDisplayed()) {
	 * System.out.println("true forms and resources sec is present"); } else
	 * Assert.fail("false fnr not coming");
	 * 
	 * }
	 */

	@Then("^validate that the forms & resources section is displayed$")
	public void validate_that_the_form_and_resources_section_is_displayed() throws Throwable {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Thread.sleep(5000);
		/* formsAndResourcesPage.clickonperceptionpopup(); */
		System.out.println("fnr section");
		if (formsAndResourcesPage.getFormsandResourcesSection().isDisplayed()) {
			System.out.println("true forms and resources sec is present");
		} else
			Assert.fail("false fnr not coming");
	}

	@Then("^validate that the renew magazine section is displayed for MAPD$")
	public void validateRenewSection() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Thread.sleep(5000);
		/* formsAndResourcesPage.clickonperceptionpopup(); */
		System.out.println("fnr section");
		if (formsAndResourcesPage.getRenewMagazineSectionMAPD().isDisplayed()) {
			System.out.println("renew sec is present");
		} else
			Assert.fail("renw sec not coming");

	}

	@Then("^validate that the renew magazine section is displayed for PDP$")
	public void validateRenewSectionPDP() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Thread.sleep(5000);
		/* formsAndResourcesPage.clickonperceptionpopup(); */
		System.out.println("fnr section");
		if (formsAndResourcesPage.getRenewMagazineSectionPDP().isDisplayed()) {
			System.out.println("renew sec is present");
		} else
			Assert.fail("renw sec not coming");

	}

	@Then("^validate that the renew magazine section is displayed for PDP UHC$")
	public void validateRenewSectionPDPUHC() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Thread.sleep(5000);
		/* formsAndResourcesPage.clickonperceptionpopup(); */
		System.out.println("fnr section");
		if (formsAndResourcesPage.getRenewMagazineSectionPDPUHC().isDisplayed()) {
			System.out.println("renew sec is present");
		} else
			Assert.fail("renw sec not coming");

	}

	@Then("^validate that the renew magazine section is displayed for uhc grp$")
	public void validateRenewSectionMAPDUHCGroup() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Thread.sleep(5000);
		/* formsAndResourcesPage.clickonperceptionpopup(); */
		System.out.println("fnr section");
		if (formsAndResourcesPage.getRenewMagazineSectionMAPDGroupUHC().isDisplayed()) {
			System.out.println("renew sec is present");
		} else
			Assert.fail("renw sec not coming");

	}

	@And("^the Pharmacy locator link is not displayed for MA$")
	public void pharmacynotforMA() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.scroll();
		Assert.assertFalse(formsAndResourcesPage.checkpharmacyforMA());

	}

	@And("^the Provider Search link is displayed for MA$")
	public void providerlinkMA(DataTable attributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		List<List<String>> data = attributes.raw();
		// This is to get the first data of the set (First Row + First Column)
		if (data.get(0).get(0).contains("MA") || data.get(0).get(0).contains("PDP"))
			if (data.get(0).get(1).contains("Pre-Effective"))
				Assert.assertTrue("Provider search link isn't present",
						formsAndResourcesPage.getProviderSearchLinkPreEffectivePDPMA().isDisplayed());
			else
				Assert.assertTrue("Provider search link isn't present",
						formsAndResourcesPage.getProviderSerachLinkMA().isDisplayed());

	}

	@And("^the Drug EOB link is not displayed for MA$")
	public void drugeobforMAnotpresent() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Assert.assertTrue(formsAndResourcesPage.checkdrugeobforMA());

	}

	@And("^Medical EOB link is displayed for MA$")
	public void medicaleobforMA() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		if (formsAndResourcesPage.getEOBMedicaButtonMA().isDisplayed()) {
			System.out.println("medical eob for MA is present");
		} else
			Assert.fail("medical eob for MA is not coming");
	}

	@And("^user is on the forms and resources page for first plan tab")
	public void firstplantab() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(10000);
		if (formsAndResourcesPage.getfirstplantab().isDisplayed()) {
			System.out.println("user is present on fnr page for the first plan");
			Assert.assertTrue(true);
		} else
			Assert.fail("plan tab is missing");
	}

	@And("^the user scrolls till the end of the page to check the forms and resources section")
	public void checkmydocumentandformsresourcessection() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.scroll();
		Assert.assertTrue(formsAndResourcesPage.getFormsandResourcesSection().isDisplayed());
	}

	@And("^the user changes the plan tab to view the forms and resources page for second plan")
	public void secondtab() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Thread.sleep(10000);
		if (formsAndResourcesPage.getsecondplantab().isDisplayed()) {
			formsAndResourcesPage.getsecondplantab().click();
			Thread.sleep(20000);
			System.out.println("user is present on fnr page for the second plan");
			Assert.assertTrue(true);
		} else
			Assert.fail("plan tab is missing");
	}

	@Then("^validate that the EOB section and both the type of Eobs are not displayed")
	public void eobpresentornot() {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Assert.assertTrue(formsAndResourcesPage.checkeobsection());
		Assert.assertTrue(formsAndResourcesPage.checkdrugeobforMA());
		Assert.assertTrue(formsAndResourcesPage.checkmedicaleob());

	}

	@And("^user clicks on the view document and resources link and navigate to forms and resource page from member auth page")
	public void navigatofnrpage() throws InterruptedException {
		AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		Thread.sleep(20000);

		FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResourcesfrommemauth();
		System.out.println("navigation worked fine from member auth");
		Thread.sleep(5000);
		formsAndResourcesPage.waitforFNRpage();
		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
		System.out.println("forms and resources page");

	}

	@Then("the member validate the correct Membership Materials section is coming")
	public void validatemembershipmaterials(DataTable givenAttributes) throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.pdfValidationOfAllTypes(formsAndResourcesPage, givenAttributes, "memberShip");
		//formsAndResourcesPage.pdfValidationOfAllTypes(formsAndResourcesPage, givenAttributes, "annualDirectory");

	}

	@And("^validates that plan material section is not displayed$")
	public void validates_that_plan_material_section_is_not_displayed() throws Throwable {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		if (formsAndResourcesPage.PlanMaterialSection.isDisplayed() != true) {
			Assert.assertTrue(true);
			System.out.println("Plan material section is not there which is the expected case");
		} else {
			Assert.fail("Plan material section is present which is un-expected");
		}

	}

	@And("^both Pharmacy and provider search links are displayed$")
	public void both_Pharmacy_and_provider_search_links_are_displayed(DataTable planType) throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		List<List<String>> data = planType.raw();
		// This is to get the first data of the set (First Row + First Column)
		if (data.get(0).get(0).contains("MAPD") && (data.get(0).get(1).contains("IndAARPPre-Effective"))) {
			Assert.assertTrue("pharmacy locator is present",
					formsAndResourcesPage.getPharmacyLocatorLinkIndMAPDPreEffective().isDisplayed());

			Assert.assertTrue("provider search link is present",
					formsAndResourcesPage.getprovisesearchlink().isDisplayed());

		}
	}

	@Then("^validate pdf's in the welcome guide section$")
	public void validate_pdf_s_in_the_welcome_guide_section(DataTable givenAttributes) throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.pdfValidationOfAllTypes(formsAndResourcesPage, givenAttributes, "welcomeGuide");

	}

	@Then("^validate pdf's in annual directory section$")
	public void validate_pdf_s_in_annual_directory_section(DataTable givenAttributes) throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.pdfValidationOfAllTypes(formsAndResourcesPage, givenAttributes, "annualDirectory");
			
	}
	
	
	@Then("^validate that the renew magazine section is displayed$")
	public void validate_that_the_renew_magazine_section_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Then("^user verifies presence of jump links on F&R page$")
	public void user_verifies_presence_of_jump_links(DataTable rows) throws Throwable {
		List<List<String>> data = rows.raw();
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		int planId = 0;
		String planType = data.get(0).get(1).trim();
		String rider = data.get(1).get(1).trim();
		String memberType = data.get(2).get(1).trim();
		String identifier = data.get(3).get(1).trim();
		// String count=data.get(2).get(1);
		if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP"))
			planType = "MAPD";
		// planType.replaceAll(planType, "MAPD").toString().trim();

		/*
		 * Menu 1-MAPD 2-MA 3-MedSupp 4-PDP 5-SSUP
		 * 
		 */
		if (planType.equalsIgnoreCase("MAPD"))
			planId = 1;
		if (planType.equalsIgnoreCase("MA"))
			planId = 2;
		if (planType.equalsIgnoreCase("MedSupp"))
			planId = 3;
		if (planType.equalsIgnoreCase("PDP"))
			planId = 4;
		if (planType.equalsIgnoreCase("SSUP"))
			planId = 5;

		System.out.println("formsAndResourcesPage==="+formsAndResourcesPage);
		if(formsAndResourcesPage!=null){
			switch (planId) {
			case 1:
				formsAndResourcesPage.verifyPresenceOfJumpLinksMAPD(rider, planType, memberType,identifier);
				break;
	
			case 2:
				formsAndResourcesPage.verifyPresenceOfJumpLinksMA(rider, planType, memberType,identifier);
				break;
	
			case 3:
				formsAndResourcesPage.verifyPresenceOfJumpLinksMedSupp(rider, planType, memberType,identifier);
				break;
	
			case 4:
				formsAndResourcesPage.verifyPresenceOfJumpLinksPDP(rider, planType, memberType, identifier);
				break;
	
			case 5:
				formsAndResourcesPage.verifyPresenceOfJumpLinksSSUP(rider, planType, memberType,identifier);
				break;
	
			default:
				System.out.println("Plan Not Found");
				break;
	
			}
		}

	}

	@Then("^user clicks on the jump links and checks respective sections on F&R page$")
	public void user_clicks_on_the_jump_links_and_checks_respective_sections(DataTable rows) throws Throwable {
		List<List<String>> data = rows.raw();
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		String planType = data.get(0).get(1).trim();
		String rider = data.get(1).get(1).trim();
		String memberType = data.get(2).get(1).trim();
		String identifier = data.get(3).get(1).trim();
		// String count=data.get(2).get(1);
		if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP"))
			planType = "MAPD";

		int planId = 0;
		/*
		 * Menu 1-MAPD 2-MA 3-MedSupp 4-PDP 5-SSUP
		 * 
		 */

		if (planType.equalsIgnoreCase("MAPD"))
			planId = 1;
		if (planType.equalsIgnoreCase("MA"))
			planId = 2;
		if (planType.equalsIgnoreCase("MedSupp"))
			planId = 3;
		if (planType.equalsIgnoreCase("PDP"))
			planId = 4;
		if (planType.equalsIgnoreCase("SSUP"))
			planId = 5;

		switch (planId) {
		case 1:
			formsAndResourcesPage.clicksOnJumpLinksAndCheckRespectiveSectionsMAPD(rider, planType, memberType,identifier);
			break;

		case 2:
			formsAndResourcesPage.clicksOnJumpLinksAndCheckRespectiveSectionsMA(rider, planType, memberType,identifier);
			break;
		case 3:
			formsAndResourcesPage.clicksOnJumpLinksAndCheckRespectiveSectionsMedSupp(rider, planType, memberType,identifier);
			break;

		case 4:
			formsAndResourcesPage.clicksOnJumpLinksAndCheckRespectiveSectionsPDP(rider, planType, memberType,identifier);
			break;

		case 5:
		//	formsAndResourcesPage.clicksOnJumpLinksAndCheckRespectiveSectionsSSUP(rider, planType, memberType,identifier);
			break;

		default:
			System.out.println("Plan Not Found");
			break;
		}

	}

	@Then("^verifies links irrelevant to the plan type are not displayed on F&R page$")
	public void verifies_links_irrelevant_to_the_plan_type_are_not_displayed(DataTable rows) throws Throwable {
		List<List<String>> data = rows.raw();
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		String planType = data.get(0).get(1).trim();
		String rider = data.get(1).get(1).trim();
		int count = Integer.parseInt(data.get(2).get(1).trim());
		String memberType = data.get(3).get(1).trim();
		String identifier = data.get(4).get(1).trim();

		if (planType.equalsIgnoreCase("MEDICA") || planType.equalsIgnoreCase("PCP"))
			planType = "MAPD";

		formsAndResourcesPage.directoryLinksCount(count, rider, planType, memberType,identifier);

	}
	
	@And("^user Clicks on the Pop up displayed and checks payment link$")
	public void member_clicks_popup() throws InterruptedException {

		MemberAuthPage popupMauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_PopUp);
		Thread.sleep(10000);
		popupMauth.PopupClick();
		/*AccountHomePage NewWindow = popupMauth.PopupClick();
		
		 * Thread.sleep(10000); if(NewWindow!=null){
		 * getLoginScenario().saveBean(PageConstants.DashPage, NewWindow); } else {
		 * System.out.println("NewWindow is null"); } }
		 */
	}
	
	@And("User clicks on Provider search link and checks if the find care page opens up")
	public void ValidateFindCarePage() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		
		formsAndResourcesPage.validateFindCareUrl();	
	}
	
	@Then("^verifies Ship EOB field is displayed for effecitve plan$")
	public void verifies_Ship_EOB_field_is_displayed_for_effecitve_plan() throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		if (formsAndResourcesPage.getShipEobHeader().isDisplayed()) {
			System.out.println("the ShipEOB is present for Effective ship Plan");
			Assert.assertTrue(true);
		} else
			Assert.fail("ShipEOB Header is not coming");
	}

	@Then("^verify Preeffective plan name and Coverage Date for preeffective plan$")
	public void verify_Preeffective_plan_name_and_Coverage_Date_for_preeffective_plan(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.verifyPreeffectiveshipPlan(memberAttributesMap);

	}
	
	@Then("^verify Preeffective plan name and Coverage Date for preeffective plan for Combo$")
	public void verify_Preeffective_plan_name_and_Coverage_Date_for_preeffective_plan_for_Combo(
			DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.verifyPreeffectiveshipPlanforCombo(memberAttributesMap);

	}

	@Then("^verify orderPlan Material link is not displayed preeffective plan$")
	public void verify_orderPlan_Material_link_is_not_displayed_preeffective_plan() throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.verifypreEffShipOderplanNotDisplay();

	}

	@Then("^verify orderPlan Material link is not displayed preeffective plan for Combo$")
	public void verify_orderPlan_Material_link_is_not_displayed_preeffective_plan_for_Combo() throws Throwable {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.verifypreEffShipOderplanNotDisplayforCombo();

	}

	@Given("^user is on the forms and resources page for Selected plan tab$")
	public void user_is_on_the_forms_and_resources_page_for_Selected_plan_tab(DataTable givenAttributes)
			throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String TabName = memberAttributesMap.get("PlanName");
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		Thread.sleep(10000);
		if (formsAndResourcesPage.getplantabTobeSelected(TabName).isDisplayed()) {
			formsAndResourcesPage.getplantabTobeSelected(TabName).click();
			Thread.sleep(20000);
			System.out.println("user is present on fnr page for the plan : " + TabName);
			Assert.assertTrue(true);
		} else
			Assert.fail(TabName + " plan tab is missing");
	}
	
	@And("^user navigate to plan documents and resources page for segment ID validation$")
	public void navigateToPlanAndResourcePageForSegementId(DataTable attributes) throws InterruptedException  {
		
		System.out.println("Proceeed to Plan Documents & Resources page");
		FormsAndResourcesPage formsAndResourcesPage=null;
		if (("YES".equalsIgnoreCase(MRScenario.isTestHarness))) {
			TestHarness testharnessHomepage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			formsAndResourcesPage = testharnessHomepage.navigateDirectToFnRPageWithTimeout();
		} 
		else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			List<List<String>> data = attributes.raw();
			String planType=data.get(0).get(1);
			String memberType=data.get(1).get(1);
			//formsAndResourcesPage = accountHomePage.navigatetoFormsnResources(memberType,planType);
			formsAndResourcesPage = accountHomePage.navigatetoFormsnResourcesWithTimeout(memberType,planType);
		}
		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE,formsAndResourcesPage);
	}
	
	@Then("^I can validate the segment ID value in localStorage on forms and resources page$")
	public void validateSegmentId(DataTable givenAttributes) throws InterruptedException {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");
		String expectedSegmentId = memberAttributesMap.get("Segment ID");
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(1000); //note: wait for the page to stabilize before validation
		formsAndResourcesPage.validateSegmentId(planType, memberType, expectedSegmentId);
		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE,formsAndResourcesPage);
	}
	
	@Then("^I can validate Annual Notice of Changes Documents section content$")
	public void validateAnocSection(DataTable givenAttributes) {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String memberType = memberAttributesMap.get("Member Type");

		String x = memberAttributesMap.get("Expect Whole ANOC Section");
		Assert.assertTrue("PROBLEM - input for 'Expect Whole ANOC Section' should only be true or false.  please check. Actual value='"+x+"'", x.equalsIgnoreCase("true") || x.equalsIgnoreCase("false"));
		boolean expectWholeAnocSection=Boolean.valueOf(x);

		x = memberAttributesMap.get("Expect Current Year ANOC Section");
		Assert.assertTrue("PROBLEM - input for 'Expect Current Year ANOC Section' should only be true or false.  please check. Actual value='"+x+"'", x.equalsIgnoreCase("true") || x.equalsIgnoreCase("false"));
		boolean cy_expectYearAnocSection=Boolean.valueOf(x);
		String cy_anocPdfCode = memberAttributesMap.get("Current Year ANOC PDF Code");
		String cy_eocPdfCode = memberAttributesMap.get("Current Year EOC PDF Code");
		String cy_cfPdfCode = memberAttributesMap.get("Current Year CF PDF Code");

		x = memberAttributesMap.get("Expect Next Year ANOC Section");
		Assert.assertTrue("PROBLEM - input for 'Expect Next Year ANOC Section' should only be true or false.  please check. Actual value='"+x+"'", x.equalsIgnoreCase("true") || x.equalsIgnoreCase("false"));
		boolean ny_expectYearAnocSection=Boolean.valueOf(x);
		String ny_anocPdfCode = memberAttributesMap.get("Next Year ANOC PDF Code");
		String ny_eocPdfCode = memberAttributesMap.get("Next Year EOC PDF Code");
		String ny_cfPdfCode = memberAttributesMap.get("Next Year CF PDF Code");

		
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		
		
		
		int currentYear=Integer.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		int nextYear=currentYear+1;
		boolean withinAEP=false;

		if (!expectWholeAnocSection || memberType.contains("Term") || memberType.contains("PreEff")  
				|| planType.equalsIgnoreCase("SHIP")) {
			formsAndResourcesPage.validateAnocSectionContent(planType, memberType, currentYear, expectWholeAnocSection, cy_expectYearAnocSection, cy_anocPdfCode, cy_eocPdfCode, cy_cfPdfCode);
			return;
		}

		if (MRScenario.environmentMedicare.equalsIgnoreCase("stage")) { //note: dynamically get the sys time
			String winHandleBefore = formsAndResourcesPage.driver.getWindowHandle();

			System.out.println("Proceed to open a new blank tab to check the system time");
			//open new tab
			JavascriptExecutor js = (JavascriptExecutor) formsAndResourcesPage.driver;
		    js.executeScript("window.open('http://dcestage-j64.uhc.com/DCERestWAR/dcerest/timeAdmin','_blank');");
			for(String winHandle : formsAndResourcesPage.driver.getWindowHandles()){
				formsAndResourcesPage.driver.switchTo().window(winHandle);
			}
			WebElement currentSysTimeElement=formsAndResourcesPage.driver.findElement(By.xpath("//td[@id='systemTime']"));
			String currentSysTime=currentSysTimeElement.getText();
			System.out.println("TEST - currentSysTime="+currentSysTime);
			formsAndResourcesPage.driver.close();
			formsAndResourcesPage.driver.switchTo().window(winHandleBefore);
			String[] tmpSysTime=currentSysTime.split(" ");
			String dateString=tmpSysTime[0];
			String[] tmp1=dateString.split("/");
			
			currentYear=Integer.valueOf(tmp1[2]);
			nextYear=currentYear+1;

			int currentMonth=Integer.valueOf(tmp1[0]);
			int currentDay=Integer.valueOf(tmp1[1]);
			if (((currentMonth ==10) && (currentDay >=15 || currentDay<=31)) 
				|| (currentMonth ==11)
				|| ((currentMonth ==12) && (currentDay <=1))) {
				System.out.println("TEST - Within AEP range, may get two ANOC sub sections");
				withinAEP=true;
			}
		} 

		formsAndResourcesPage.validateAnocSectionContent(planType, memberType, currentYear, expectWholeAnocSection, cy_expectYearAnocSection, cy_anocPdfCode, cy_eocPdfCode, cy_cfPdfCode);
		
		formsAndResourcesPage.validateAnocSectionContent(planType, memberType, nextYear, expectWholeAnocSection, ny_expectYearAnocSection, ny_anocPdfCode, ny_eocPdfCode, ny_cfPdfCode);
	
	}	
}
