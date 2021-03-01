package acceptancetests.acquisition.learnAboutMedicare;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import junit.framework.Assert;
import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.LearnAboutMedicareHomePage;
import pages.acquisition.bluelayer.MedicareAdvantagePartCPlansPage;
import pages.acquisition.bluelayer.MedicareEligibilityPage;
import pages.acquisition.bluelayer.MedicarePrescriptionDrugPartDPlansPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;

/**
 * Functionality: Medicare flow
 */

@SuppressWarnings("deprecation")
public class LearnAboutMedicareStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;

	/**
	 * @toDo:user is on the uhcmedicaresolutions site landing page
	 */
	@Given("^user is on uhcmedicaresolutions site landing page$")
	public void the_user_on_UHC_Medicaresolutions_Site() {
		wd = getLoginScenario().getWebDriver();

		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
	
	
	@And("^verifies header, links under Learn About Medicare dropList on uhc site$")
	public void user_checks_header_links_of_Learn_About_Medicare_dropList() {

		LearnAboutMedicareHomePage learnAboutMedicareHomePage = new LearnAboutMedicareHomePage(wd);
				

		learnAboutMedicareHomePage.checkMedicareMenuHeaders();

		getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);
	}
	
	@And("^verifies accessibility of links using tabkey, back button on every page navigable from homepage on uhc site$")
	public void page_back_button_on_every_page_navigable_from_homepage() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.checktabKeyMedBacklink();

	}
	
	@And("^verifies navigation to learn about medicare homePage on uhc site$")
	public void verifies_links_and_page_back_button() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.pagebackButton();

	}
	
	
	
	@Given("^user clicks on learn about medicare link on uhc site$")
	public void user_clicks_on_learn_about_medicare_link() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) aquisitionhomepage
				.openLearnAboutMedicarePage();

		getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePage);

	}

	

	@And("^verifies URL, title of pages navigable from menu on uhc site$")
	public void user_navigates_to_medicare_pages() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		learnAboutMedicareHomePage.checkMedicareURLAndTitle();

	}

	

	@SuppressWarnings("deprecation")
	@And("^app navigates to medicare eligibility page on uhc site$")
	public void navigates_to_medicare_eligibility_page() {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);

		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) learnAboutMedicareHomePage
				.navigateToMedicareEligibility();

		Assert.assertTrue("Medicare Eligibility page isn't loaded",
				medicareEligibilityPage.getHdrMedicareEligibility().isDisplayed());

		getLoginScenario().saveBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE, medicareEligibilityPage);

	}

	@And("^verifies default value of state drop down on uhc site$")
	public void verifies_default_value_of_state_drop_down() {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);

		medicareEligibilityPage.defaultValueDropDown();

		/*
		 * MedicareEligibilityPage medicareEligibilityPage = new
		 * MedicareEligibilityPage(wd);
		 * getLoginScenario().saveBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE,
		 * medicareEligibilityPage);
		 */

	}

	@And("^verifies presence of video, sideLinks, back button and next button on medicare eligibility page on uhc site$")
	public void verifies_presence_of_video_sideLinks_back_button_and_next_button_on_medicare_eligibility_page() {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
		medicareEligibilityPage.medicareEligibilityElements();
		/*
		 * MedicareEligibilityPage medicareEligibilityPage = new
		 * MedicareEligibilityPage(wd);
		 * getLoginScenario().saveBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE,
		 * medicareEligibilityPage);
		 */

	}

	@SuppressWarnings("deprecation")
	@And("^verifies links under Types of UnitedHealthcare Insurance Company Plans on uhc site$")
	public void verifies_links_under_Types_of_UnitedHealthcare_Insurance_Company_Plans() {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);

		medicareEligibilityPage.defaultTypeOfUnitedHealthcareInsuranceCompanyPlans();

	}

	@SuppressWarnings("deprecation")
	@And("^then user selects Minnesota from the dropDown on uhc site$")
	public void user_selects_Minnesota_from_the_dropDown(DataTable attributes) {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
		List<List<String>> data = attributes.raw();
		String State = data.get(0).get(1).toString();
		medicareEligibilityPage.stateSelection(State);

	}

	@And("^verifies links under Types of UnitedHealthcare Insurance Company Plans for minnesota on uhc site$")
	public void verifies_links_under_Types_of_UnitedHealthcare_Insurance_Company_Plans_for_minnesota() {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);

		medicareEligibilityPage.typeOfUnitedHealthcareInsuranceCompanyPlans();
	}

	@And("^then user selects Alabama from the dropDown on uhc site$")
	public void user_selects_Albama_from_the_dropDown(DataTable attributes) {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
		List<List<String>> data = attributes.raw();
		String State = data.get(0).get(1).toString();
		medicareEligibilityPage.stateSelection(State);

	}

	@And("^verifies links under Types of UnitedHealthcare Insurance Company Plans for Alabama on uhc site$")
	public void verifies_links_under_Types_of_UnitedHealthcare_Insurance_Company_Plans_for_Albama() {
		MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
				.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);

		medicareEligibilityPage.typeOfUnitedHealthcareInsuranceCompanyPlans();
	}

	@And("^verifies plan search with a valid zipcode on uhc site$")
	public void verifies_plan_search_with_a_valid_zipcode(DataTable attributes) {

		List<List<String>> data = attributes.raw();
		String zipCode = data.get(0).get(1).toString();
		String option = data.get(1).get(1).toString();
		if (option.contains("ME")) {
			MedicareEligibilityPage medicareEligibilityPage = (MedicareEligibilityPage) getLoginScenario()
					.getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
			 medicareEligibilityPage.planSearch(zipCode);
		} else if (option.contains("MA")) {
			MedicareAdvantagePartCPlansPage medicareAdvantagePartCPlansPage = (MedicareAdvantagePartCPlansPage) getLoginScenario()
					.getBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE);
			 medicareAdvantagePartCPlansPage.planSearch(zipCode);
		}

		else if (option.contains("PDP")) {
			MedicarePrescriptionDrugPartDPlansPage medicarePrescriptionDrugPartDPlansPage = (MedicarePrescriptionDrugPartDPlansPage) getLoginScenario()
					.getBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE);
			 medicarePrescriptionDrugPartDPlansPage.planSearch(zipCode);
		}

	}

	@And("^verifies Shop For a Plan Homepage on uhc site$")
	public void verifies_Shop_For_a_Plan_Homepage() {
		VPPPlanSummaryPage vpp = new VPPPlanSummaryPage(wd);
		vpp.openAndValidate();
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vpp);
	}

	@And("^views plan of a particular type on uhc site$")
	public void clicks_on_medicare_advantage_tab(DataTable attributes) {
		 VPPPlanSummaryPage vpp = (VPPPlanSummaryPage)
		 getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		wd.navigate().refresh();
		List<List<String>> data = attributes.raw();
		String planType = data.get(0).get(1).toString();
		vpp.viewPlanSummary(planType);
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vpp);
		
		
	}
	
	@And("^verifies plantype on uhc site$")
	public void verifies_plantype_on_aarp_site(DataTable attributes) {
		List<List<String>> data = attributes.raw();
		String planType = data.get(0).get(1).toString();
		VPPPlanSummaryPage vpp = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);

		if (planType.equals("MA")) {

			vpp.clickOnViewPlans(planType);

		} else if (planType.equals("PDP")) {

			vpp.clickOnViewPlans(planType);

		}

	}
	
	

	/* Medicare Advantage */
	@SuppressWarnings("deprecation")
	@And("^user selects a plan from the learn about medicare dropList on uhc site$")
	public void user_selects_plan_from_the_learn_about_medicare_dropList(DataTable attributes) {
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
		List<List<String>> data = attributes.raw();
		String planType = data.get(0).get(1).toString();

//		learnAboutMedicareHomePage
//				.navigateToMedicareMenuLinks(learnAboutMedicareHomePage.getLstLearnAboutMedicareTitle().get(1));

		if (planType.equals("MA")) {
//			Assert.assertTrue("Medicare Advantage link isn't displayed",
//					learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(4).getText().contains("Advantage"));

			learnAboutMedicareHomePage
					.navigateToMedicareMenuLinks(learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(4));
		}
		if (planType.equals("PDP")) {
			learnAboutMedicareHomePage.navigateToMedicareMenuLinks(learnAboutMedicareHomePage.getLstLearnAboutMedicareTitle().get(1));
			if (learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(6).getText().contains("Prescription")) {
				Assert.assertTrue("Medicare Prescription Drug Plan link isn't displayed",
						learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(6).isDisplayed());
				learnAboutMedicareHomePage
						.navigateToMedicareMenuLinks(learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(6));
			} else {
				Assert.assertTrue("Medicare Prescription Drug Plan link isn't displayed",
						learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(5).isDisplayed());
				learnAboutMedicareHomePage
						.navigateToMedicareMenuLinks(learnAboutMedicareHomePage.getLstLearnAboutMedicare().get(5));
			}

		}
	}

	@And("^clicks on plans available option on uhc site$")
	public void clicks_on_plans_available_option(DataTable attributes) {
		List<List<String>> data = attributes.raw();
		String planType = data.get(0).get(1).toString();
		if (planType.equals("MA")) {
			MedicareAdvantagePartCPlansPage medicareAdvantagePartCPlansPage = new MedicareAdvantagePartCPlansPage(wd);
			medicareAdvantagePartCPlansPage.plansAvailableInYourArea();
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE, medicareAdvantagePartCPlansPage);
		}

		if (planType.equals("PDP")) {
			MedicarePrescriptionDrugPartDPlansPage medicarePrescriptionDrugPartDPlansPage = new MedicarePrescriptionDrugPartDPlansPage(
					wd);
			medicarePrescriptionDrugPartDPlansPage.plansAvailableInYourArea();
			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE,
					medicarePrescriptionDrugPartDPlansPage);

		}

	}

	@And("^user selects a plan from the learn about medicare homePage on uhc site$")
	public void user_selects_a_plan_from_the_learn_about_medicare_homePage(DataTable attributes) {
		List<List<String>> data = attributes.raw();
		String planType = data.get(0).get(1).toString();
		LearnAboutMedicareHomePage learnAboutMedicareHomePage = (LearnAboutMedicareHomePage) getLoginScenario()
				.getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);

		learnAboutMedicareHomePage.getLnkLearnAboutMedicare().click();

		if (planType.equals("MA")) {

			MedicareAdvantagePartCPlansPage medicareAdvantagePartCPlansPage = (MedicareAdvantagePartCPlansPage) learnAboutMedicareHomePage
					.planSelectionMA();
			getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PLANS_PAGE, medicareAdvantagePartCPlansPage);
		} else if (planType.equals("PDP")) {

			MedicarePrescriptionDrugPartDPlansPage medicarePrescriptionDrugPartDPlansPage = (MedicarePrescriptionDrugPartDPlansPage) learnAboutMedicareHomePage
					.planSelectionPDP();

			getLoginScenario().saveBean(PageConstants.MEDICARE_PRESCRIPTION_DRUG_PLANS_PAGE,
					medicarePrescriptionDrugPartDPlansPage);
		}

	}
	
	

}
