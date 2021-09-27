package acceptancetests.acquisition.globalcomponents;

import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import pages.acquisition.commonpages.*;


import java.util.HashMap;
import java.util.Map;

public class MedicareEducationStepDefinition {
    @Autowired
    MRScenario loginScenario;

    public MRScenario getLoginScenario() {
        return loginScenario;
    }

    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Then("^the user select state for geotargeting from dropdown$")
    public void user_select_state_for_geotargeting_from_dropdown(DataTable givenAttributes) {
        AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
                .getBean(PageConstants.ACQUISITION_HOME_PAGE);
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String geoState = memberAttributesMap.get("GeoState");
        aquisitionhomepage.selectStateForGeotargeting(geoState);
        getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
    }

    @Then("^the user navigates to new Medicare Education homepage$")
    public void the_user_navigates_to_new_Medicare_Education_homepage() {
        AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
                .getBean(PageConstants.ACQUISITION_HOME_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = aquisitionhomepage.clickLearnMoreAboutMedicareOnHomePage();
        if (learnAboutMedicareHomePageNew != null && learnAboutMedicareHomePageNew.checkAllLinks()) {
            System.out.println("New Medicare Education Homepage opened successfully");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("New Medicare Education Homepage did not opened successfully");
        }

    }

    @Then("^the user navigates to new Medicare Eligibility page$")
    public void the_user_navigates_to_new_Medicare_Eligibility_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        MedicareEligibilityPageNew eligibilityPage = learnAboutMedicareHomePageNew.clickOnMedicareEligibility();
        if (eligibilityPage != null) {
            getLoginScenario().saveBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE, eligibilityPage);
            System.out.println("Medicare Eligibility page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("Medicare Eligibility Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Medicare Eligibility Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Medicare_Eligibility_Page() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario().getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = eligibilityPage.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Eligibility page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Eligibility page is not successful");
        }
    }

    @Then("^the user navigates to new Coverage Choices page$")
    public void the_user_navigates_to_new_Coverage_Choices_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        CoverageChoicesPageNew coverageChoicesPageNew = learnAboutMedicareHomePageNew.clickOnCoverageChoices();
        if (coverageChoicesPageNew != null) {
            getLoginScenario().saveBean(PageConstants.COVERAGE_CHOICE_PAGE, coverageChoicesPageNew);
            System.out.println("New Coverage Choices page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Coverage Choices Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Coverage Choices Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Coverage_Choices_Page() {
        CoverageChoicesPageNew coverageChoicesPageNew = (CoverageChoicesPageNew) getLoginScenario().getBean(PageConstants.COVERAGE_CHOICE_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = coverageChoicesPageNew.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Coverage Choices page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Coverage Choices page is not successful");
        }
    }

    @Then("^the user navigates to new Benefits page$")
    public void the_user_navigates_to_new_Benefits_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        PrescriptionProviderBenefitsPageNew prescriptionProviderBenefitsPageNew = learnAboutMedicareHomePageNew.clickOnBenefitsLink();
        if (prescriptionProviderBenefitsPageNew != null) {
            getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, prescriptionProviderBenefitsPageNew);
            System.out.println("New Prescription Providers and Benefits page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Prescription Providers and Benefits Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Benefits Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Benefits_Page() {
        PrescriptionProviderBenefitsPageNew prescriptionProviderBenefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario().getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = prescriptionProviderBenefitsPageNew.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Benefits page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Benefits page is not successful");
        }
    }

    @Then("^the user navigates to new Cost Basics page$")
    public void the_user_navigates_to_new_Cost_Basics_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        CostBasicsPageNew costBasicsPageNew = learnAboutMedicareHomePageNew.clickOnCostBasics();
        if (costBasicsPageNew != null) {
            getLoginScenario().saveBean(PageConstants.COST_BASICS_PAGE, costBasicsPageNew);
            System.out.println("New Cost Basics page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Cost Basics Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Cost Basics Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Cost_Basics_Page() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario().getBean(PageConstants.COST_BASICS_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = costBasicsPageNew.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Cost Basics page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Cost Basics page is not successful");
        }
    }

    @Then("^the user navigates to new Enrollment page$")
    public void the_user_navigates_to_new_Enrollment_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = learnAboutMedicareHomePageNew.clickOnEnrollment();
        if (whentoEnrollinMedicarePage != null) {
            getLoginScenario().saveBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE, whentoEnrollinMedicarePage);
            System.out.println("New Enrollment page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Enrollment Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Enrollment Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Enrollment_Page() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario().getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = whentoEnrollinMedicarePage.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Enrollment page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Enrollment page is not successful");
        }
    }

    @Then("^the user navigates to new Original Medicare page$")
    public void the_user_navigates_to_new_Original_Medicare_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        OriginalMedicarePage originalMedicarePage = learnAboutMedicareHomePageNew.clickOnOriginalMedicare();
        if (originalMedicarePage != null) {
            getLoginScenario().saveBean(PageConstants.ORIGINAL_MEDICARE_PAGE, originalMedicarePage);
            System.out.println("Original Medicare page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("Original Medicare Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Original Medicare Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Original_Medicare_Page() {
        OriginalMedicarePage originalMedicarePage = (OriginalMedicarePage) getLoginScenario().getBean(PageConstants.ORIGINAL_MEDICARE_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = originalMedicarePage.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Original Medicare page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Original page is not successful");
        }
    }

    @Then("^the user navigates to new Medicare Advantage Plans page$")
    public void the_user_navigates_to_new_Medicare_Advantage_Plans_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = learnAboutMedicareHomePageNew.clickOnMAPlans();
        if (medicareAdvantagePartCPlansPageNew != null) {
            getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE, medicareAdvantagePartCPlansPageNew);
            System.out.println("New Medicare Advantage Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Medicare Advantage Plans Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Medicare Advantage Plans Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Medicare_Advantage_Plans_Page() {
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = (MedicareAdvantagePartCPlansPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = medicareAdvantagePartCPlansPageNew.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Medicare Advantage Plans page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Medicare Advantage Plans page is not successful");
        }
    }

    @Then("^the user navigates to new Medicare Supplement Plans page$")
    public void the_user_navigates_to_new_Medicare_Supplement_Plans_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = learnAboutMedicareHomePageNew.clickOnMedSupp();
        if (medicareSupplementInsurancePlansPageNew != null) {
            getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE, medicareSupplementInsurancePlansPageNew);
            System.out.println("New Medicare Supplement Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Medicare Supplement Plans Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Medicare Supplement Plans Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Medicare_Supplement_Plans_Page() {
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = (MedicareSupplementInsurancePlansPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = medicareSupplementInsurancePlansPageNew.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Medicare Supplement Plans page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Medicare Supplement Plans page is not successful");
        }
    }

    @Then("^the user navigates to new Special Needs Plans page$")
    public void the_user_navigates_to_new_Special_Needs_Plans_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        SpecialNeedsPlansPage specialNeedsPlansPage = learnAboutMedicareHomePageNew.clickOnSNPPlans();
        if (specialNeedsPlansPage != null) {
            getLoginScenario().saveBean(PageConstants.SPECIAL_NEEDS_PLANS_PAGE, specialNeedsPlansPage);
            System.out.println("New Special Needs Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Special Needs Plans Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Special Needs Plans Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Special_Needs_Plans_Page() {
        SpecialNeedsPlansPage specialNeedsPlansPage = (SpecialNeedsPlansPage) getLoginScenario()
                .getBean(PageConstants.SPECIAL_NEEDS_PLANS_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = specialNeedsPlansPage.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Special Needs Plans page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Special Needs Plans page is not successful");
        }
    }

    @Then("^the user navigates to new Medicare Prescription Drugs Plans page$")
    public void the_user_navigates_to_new_Medicare_Prescription_Drugs_Plans_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        MedicarePrescriptionDrugPartDPlansPageNew prescriptionDrugPartDPlansPageNew = learnAboutMedicareHomePageNew.clickOnPDPPlans();
        if (prescriptionDrugPartDPlansPageNew != null) {
            getLoginScenario().saveBean(PageConstants.PRESCRIPTION_DRUGS_PLANS_PAGE, prescriptionDrugPartDPlansPageNew);
            System.out.println("New Medicare Prescription Drugs Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Medicare Prescription Drugs Plans Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Medicare Prescription Drugs Plans Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Medicare_Prescription_Drugs_Plans_Page() {
        MedicarePrescriptionDrugPartDPlansPageNew prescriptionDrugPartDPlansPageNew = (MedicarePrescriptionDrugPartDPlansPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_DRUGS_PLANS_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = prescriptionDrugPartDPlansPageNew.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Medicare Prescription Drugs Plans page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Medicare Prescription Drugs Plans page is not successful");
        }
    }

    @Then("^the user navigates to new Overview of Plan Types page$")
    public void the_user_navigates_to_new_Overview_of_Plan_Types_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        OverviewofPlanTypesPage overviewofPlanTypesPage = learnAboutMedicareHomePageNew.clickOnOverviewOfPlanTypes();
        if (overviewofPlanTypesPage != null) {
            getLoginScenario().saveBean(PageConstants.OVERVIEW_OF_PLAN_TYPES, overviewofPlanTypesPage);
            System.out.println("New Overview of Plan Types Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Overview of Plan Types Page did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Overview of Plan Types Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Overview_of_Plan_Types_Page() {
        OverviewofPlanTypesPage overviewofPlanTypesPage = (OverviewofPlanTypesPage) getLoginScenario()
                .getBean(PageConstants.OVERVIEW_OF_PLAN_TYPES);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = overviewofPlanTypesPage.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Overview of Plan Types page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Overview of Plan Types page is not successful");
        }
    }

    @Then("^the user navigates to Initial Enrollment Period page$")
    public void the_user_navigates_to_Initial_Enrollment_Period_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        InitialEnrollmentPeriodPage initialEnrollmentPeriodPage = learnAboutMedicareHomePageNew.clickOnLearnMoreAboutIEP();
        if (initialEnrollmentPeriodPage != null) {
            getLoginScenario().saveBean(PageConstants.INITIAL_ENROLLMENT_PERIOD_PAGE, initialEnrollmentPeriodPage);
            System.out.println("New Initial Enrollment Period page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Initial Enrollment Period did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Initial Enrollment Period Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Initial_Enrollment_Period_Page() {
        InitialEnrollmentPeriodPage initialEnrollmentPeriodPage = (InitialEnrollmentPeriodPage) getLoginScenario()
                .getBean(PageConstants.INITIAL_ENROLLMENT_PERIOD_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = initialEnrollmentPeriodPage.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Initial Enrollment Period page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Initial Enrollment Period page is not successful");
        }
    }

    @Then("^the user navigates to new Working Past 65 page$")
    public void the_user_navigates_to_new_Working_Past_65_page() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        WorkingPast65Page workingPast65Page = learnAboutMedicareHomePageNew.clickOnLearnMoreAboutWP65();
        if (workingPast65Page != null) {
            getLoginScenario().saveBean(PageConstants.WORKING_PAST_65_PAGE, workingPast65Page);
            System.out.println("New Working Past 65 page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Working Past 65 did not loaded");
        }
    }

    @Then("^the user comes back to new Medicare Education Page from Working Past 65 Page$")
    public void the_user_comes_back_to_new_Medicare_Education_Page_from_Working_Past_65_Page() {
        WorkingPast65Page workingPast65Page = (WorkingPast65Page) getLoginScenario()
                .getBean(PageConstants.WORKING_PAST_65_PAGE);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = workingPast65Page.backtoMedicareEducationPage();
        if (learnAboutMedicareHomePageNew != null) {
            System.out.println("Returned to New Medicare Education Homepage from Working Past 65 page successful");
            getLoginScenario().saveBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE, learnAboutMedicareHomePageNew);
        } else {
            Assert.fail("Returned to New Medicare Education Homepage from Working Past 65 page is not successful");
        }
    }

    @Then("^the user validates inner links on new Medicare Eligibility Page$")
    public void the_user_validates_inner_links_on_new_Medicare_Eligibility_Page() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        eligibilityPage.checkInnerLinks();
    }

    @Then("^the user validates Learn more about enrolling in Medicare link on Eligibility Page$")
    public void the_user_validates_Learn_more_about_enrolling_in_Medicare_link_on_Eligibility_Page() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        eligibilityPage.clickonIEPlink();
    }

    @Then("^the user validates Understand your options for Medicare enrollment link on Eligibility Page$")
    public void the_user_validates_Understand_your_options_for_Medicare_enrollment_link_on_Eligibility_Page() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        eligibilityPage.clickonWP65link();
    }

    @Then("^the user validates Learn more about Medicare eligibility due to disability link on Eligibility Page$")
    public void the_user_validates_Learn_more_about_Medicare_eligibility_due_to_disability_link_on_Eligibility_Page() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        eligibilityPage.clickonDisabilityArticlelink();
    }

    @Then("^the user validates Social Security link on Eligibility Page$")
    public void the_user_validates_Social_Security_link_on_Eligibility_Page() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        eligibilityPage.clickOnSocialSecurityLink();
    }

    @Then("^the user click on Get a Plan Recommendation Button and gets back$")
    public void theuserclickonGetaPlanRecommendationButtonandgetsback() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.clickOnPlanRecommendationButton();
    }

    @Then("^the user clicks on Coverage Choice link in Next Step Section$")
    public void the_user_clicks_on_Coverage_Choice_link_in_Next_Step_Section() {
        MedicareEligibilityPageNew eligibilityPage = (MedicareEligibilityPageNew) getLoginScenario()
                .getBean(PageConstants.MEDICARE_ELIGIBILITY_PAGE);
        CoverageChoicesPageNew coverageChoicesPageNew = eligibilityPage.clickOnCoverageChoiceLink();
        if (coverageChoicesPageNew != null) {
            getLoginScenario().saveBean(PageConstants.COVERAGE_CHOICE_PAGE, coverageChoicesPageNew);
            System.out.println("New Coverage Choices page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Coverage Choices Page did not loaded");
        }
    }

    @Then("^the user clicks on Agent link from new Medicare Education Pages$")
    public void the_user_clicks_on_Agent_link_from_new_Medicare_Education_Pages(DataTable givenAttributes)
            throws InterruptedException {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String myUHCAgentURL = memberAttributesMap.get("UHC Agent URL");

        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        if (myUHCAgentURL != null) {
            learnAboutMedicareHomePageNew.clickonFindanAgentlinkfromMedEd(myUHCAgentURL);
            Assertion.assertTrue(true);
        } else
            Assertion.fail("Error in loading the UHC Agent Page");
    }

    @Then("^the user validates inner links on new Initial Enrollment Period Page$")
    public void theuservalidatesinnerlinksonnewInitialEnrollmentPeriodPage() {
        InitialEnrollmentPeriodPage initialEnrollmentPeriodPage = (InitialEnrollmentPeriodPage) getLoginScenario()
                .getBean(PageConstants.INITIAL_ENROLLMENT_PERIOD_PAGE);
        initialEnrollmentPeriodPage.checkInnerLinks();
    }

    @Then("^the user gather information through video$")
    public void the_user_gather_information_through_video() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.clickToYoutubeVideo();
        learnAboutMedicareHomePageNew.clickVideoTransciptLink();
    }

    @Then("^the user validates Find Out If You Can Delay Enrolling in Medicare link on new Initial Enrollment Period Page$")
    public void validates_Find_Out_If_You_Can_Delay_Enrolling_in_Medicare_link_on_new_Initial_Enrollment_Period_Page() {
        InitialEnrollmentPeriodPage initialEnrollmentPeriodPage = (InitialEnrollmentPeriodPage) getLoginScenario()
                .getBean(PageConstants.INITIAL_ENROLLMENT_PERIOD_PAGE);
        initialEnrollmentPeriodPage.clickOnFindDelayLink();
    }

    @Then("^the user validates See How All the Parts of Medicare Can be Combined link on new Initial Enrollment Period Page$")
    public void validates_See_How_All_the_Parts_of_Medicare_Can_be_Combined_link_on_new_Initial_Enrollment_Period_Page() {
        InitialEnrollmentPeriodPage initialEnrollmentPeriodPage = (InitialEnrollmentPeriodPage) getLoginScenario()
                .getBean(PageConstants.INITIAL_ENROLLMENT_PERIOD_PAGE);
        initialEnrollmentPeriodPage.clickOnPartsCombinedLink();
    }

    @Then("^the user validates Enrollment Date Calculator$")
    public void the_user_validates_Enrollment_Date_Calculator() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.checkEDCTab1();
        learnAboutMedicareHomePageNew.checkEDCTab2();
        learnAboutMedicareHomePageNew.checkEDCTab3();
    }

    @Then("^the user validates email form component on new Medicare Education Page$")
    public void the_user_validates_email_form_component_on_new_Medicare_Education_Page(DataTable givenAttributes) {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String endpoint = memberAttributesMap.get("Endpoint");
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.validateEmailComponent(endpoint);
    }

    @Then("^the user clicks on How to Enroll link in Read Next section$")
    public void the_user_clicks_on_How_to_Enroll_link_in_Read_Next_section() {
        InitialEnrollmentPeriodPage initialEnrollmentPeriodPage = (InitialEnrollmentPeriodPage) getLoginScenario()
                .getBean(PageConstants.INITIAL_ENROLLMENT_PERIOD_PAGE);
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = initialEnrollmentPeriodPage.clickOnHowToEnrollLink();
        if (howtoEnrollinMedicarePage != null) {
            getLoginScenario().saveBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE, howtoEnrollinMedicarePage);
            System.out.println("How to Enroll in Medicare Page loaded");
        } else {
            Assert.fail("How to Enroll in Medicare Page not loaded");
        }
    }

    @Then("^the user validates inner links on new Coverage Choices Page$")
    public void the_user_validates_inner_links_on_new_Coverage_Choices_Page() {
        CoverageChoicesPageNew coverageChoicesPageNew = (CoverageChoicesPageNew) getLoginScenario()
                .getBean(PageConstants.COVERAGE_CHOICE_PAGE);
        coverageChoicesPageNew.checkInnerLinks();
    }

    @Then("^the user check plans link on new Coverage Choices Page$")
    public void the_user_check_plans_link_on_new_Coverage_Choices_Page() {
        CoverageChoicesPageNew coverageChoicesPageNew = (CoverageChoicesPageNew) getLoginScenario()
                .getBean(PageConstants.COVERAGE_CHOICE_PAGE);
        coverageChoicesPageNew.checkPlansLinks();
    }

    @Then("^the user clicks on Prescriptions Providers and Benefits link in Read Next Section$")
    public void the_user_clicks_on_Prescriptions_Providers_Benefits_link_in_Read_Next_Section() {
        CoverageChoicesPageNew coverageChoicesPageNew = (CoverageChoicesPageNew) getLoginScenario()
                .getBean(PageConstants.COVERAGE_CHOICE_PAGE);
        PrescriptionProviderBenefitsPageNew benefitsPageNew = coverageChoicesPageNew.clickOnBenifitsLink();
        if (benefitsPageNew != null) {
            getLoginScenario().saveBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE, benefitsPageNew);
            System.out.println("New Prescription Providers and Benefits page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Prescription Providers and Benefits Page did not loaded");
        }
    }

    @Then("^the user validates inner links on new Benefits Page$")
    public void the_user_validates_inner_links_on_new_Benefits_Page() {
        PrescriptionProviderBenefitsPageNew benefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        benefitsPageNew.checkInnerLinks();
    }

    @Then("^the user clicks on DCE link on new Medicare Education Page$")
    public void the_user_clicks_on_DCE_link_on_new_Medicare_Education_Page() {
        PrescriptionProviderBenefitsPageNew benefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        benefitsPageNew.clickOnEstimateYourDrugCosts();
    }

    @Then("^the user clicks on Look up Provider link on new Medicare Education Page$")
    public void the_suser_clicks_on_Look_up_Provider_link_on_new_Medicare_Education_Page() {
        PrescriptionProviderBenefitsPageNew benefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        benefitsPageNew.clickOnLookUpProvider();
    }

    @Then("^the user clicks on Medicare Annual Enrollment link on new Benefits Page$")
    public void the_user_clicks_on_Medicare_Annual_Enrollment_link_on_new_Benefits_Page() {
        PrescriptionProviderBenefitsPageNew benefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        benefitsPageNew.clickMedicareAnnualEnrollment();
    }

    @Then("^the user clicks on Medicare Advantage Plans link on new Benefits Page$")
    public void the_user_clicks_on_Medicare_Advantage_Plans_link_on_new_Benefits_Page() {
        PrescriptionProviderBenefitsPageNew benefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        benefitsPageNew.clickonMAPlansLinks();
    }

    @Then("^the user clicks on Cost Basics link in Read Next Section$")
    public void the_user_clicks_on_Cost_Basics_link_in_Read_Next_Section() {
        PrescriptionProviderBenefitsPageNew benefitsPageNew = (PrescriptionProviderBenefitsPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_PROVIDER_BENEFITS_PAGE);
        CostBasicsPageNew costBasicsPageNew = benefitsPageNew.clickOnCostBasicsLink();
        if (costBasicsPageNew != null) {
            getLoginScenario().saveBean(PageConstants.COST_BASICS_PAGE, costBasicsPageNew);
            System.out.println("New Cost Basics page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Cost Basics Page did not loaded");
        }
    }

    @Then("^the user validates inner links on new Cost Basics Page$")
    public void theuservalidatesinnerlinksonnewCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.checkInnerLinks();
    }

    @Then("^the user validates Learn more about the specific costs for Medicare Part A and Part B link on Cost Basics Page$")
    public void theuservalidatesLearnmoreaboutthespecificcostsforMedicarePartAandPartBlinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnOriginalMedicareLink();
    }

    @Then("^the user validates Learn more about Medicare Prescription Drug plan costs link on Cost Basics Page$")
    public void theuservalidatesLearnmoreaboutMedicarePrescriptionDrugplancostslinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnEstimatePDPLink();
    }

    @Then("^the user validates Learn how to get help with prescription drug costs link on Cost Basics Page$")
    public void theuservalidatesLearnhowtogethelpwithprescriptiondrugcostslinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnExtraHelpLink();
    }

    @Then("^the user validates Learn more about Medicaid and Dual Eligibility link on Cost Basics Page$")
    public void theuservalidatesLearnmoreaboutMedicaidandDualEligibilitylinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnDualEligibilityLink();
    }

    @Then("^the user validates Find out if you qualify for Medicare Savings Programs link on Cost Basics Page$")
    public void theuservalidatesMedicareSavingsProgramslinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnSavingProgramLink();
    }

    @Then("^the user validates Get more information about PACE link on Cost Basics Page$")
    public void theuservalidatesPACElinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnPACELink();
    }

    @Then("^the user validates Medicare Special Enrollment Period link on Cost Basics Page$")
    public void theuservalidatesSpecialEnrollmentPeriodlinkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnMedicareSEPLink();
    }

    @Then("^the user validates Learn More about Working Past 65 link on Cost Basics Page$")
    public void theuservalidatesWP65linkonCostBasicsPage() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        costBasicsPageNew.clickOnWP65Link();
    }

    @Then("^the user clicks on Learn more about Medicare Advantage Plans link in Read Next Section$")
    public void theuserclicksonLearnmoreaboutMedicareAdvantagePlanslinkinReadNextSection() {
        CostBasicsPageNew costBasicsPageNew = (CostBasicsPageNew) getLoginScenario()
                .getBean(PageConstants.COST_BASICS_PAGE);
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = costBasicsPageNew.clickOnReadNextMAPlanLink();
        if (medicareAdvantagePartCPlansPageNew != null) {
            getLoginScenario().saveBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE, medicareAdvantagePartCPlansPageNew);
            System.out.println("New Medicare Advantage Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Medicare Advantage Plans Page did not loaded");
        }
    }

    @Then("^the user validates Get more information about Special Needs Plans link on Medicare Advantage Plans Page$")
    public void theuservalidatesGetmoreinformationaboutSpecialNeedsPlanslinkonMedicareAdvantagePlansPage() {
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = (MedicareAdvantagePartCPlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE);
        medicareAdvantagePartCPlansPageNew.clickOnSNPLink();
    }

    @Then("^the user validates Learn more about these Medicare Advantage plans here on Medicare Advantage Plans Page$")
    public void theuservalidatesLearnmoreabouttheseMedicareAdvantageplanshereonMedicareAdvantagePlansPage() {
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = (MedicareAdvantagePartCPlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE);
        medicareAdvantagePartCPlansPageNew.clickOnVeteranLink();
    }

    @Then("^the user validates See how Medicare costs may work with these Medicare coverage examples link on Medicare Advantage Plans Page$")
    public void theuservalidatesSeehowMedicarecostsmayworkwiththeseMedicarecoverageexampleslinkonMedicareAdvantagePlansPage() {
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = (MedicareAdvantagePartCPlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE);
        medicareAdvantagePartCPlansPageNew.clickOnCoverageExampleLink();
    }

    @Then("^the user validates Learn more about Medicare Supplement insurance plans on Medicare Advantage Plans Page$")
    public void theuservalidatesLearnmoreaboutMedicareSupplementinsuranceplansonMedicareAdvantagePlansPage() {
        MedicareAdvantagePartCPlansPageNew medicareAdvantagePartCPlansPageNew = (MedicareAdvantagePartCPlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_ADVANTAGE_PART_C_PLANS_PAGE);
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = medicareAdvantagePartCPlansPageNew.clickOnReadNextMedSuppPlanLink();
        if (medicareSupplementInsurancePlansPageNew != null) {
            getLoginScenario().saveBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE, medicareSupplementInsurancePlansPageNew);
            System.out.println("New Medicare Supplement Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Medicare Supplement Plans Page did not loaded");
        }
    }

    @Then("^the user clicks on Shop Now button on new Medicare Supplement Plans page$")
    public void theuserclicksonShopNowbuttononnewMedicareSupplementPlanspage() {
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = (MedicareSupplementInsurancePlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE);
        medicareSupplementInsurancePlansPageNew.clickShopNowButton();
    }


    @Then("^the user validates Learn more about costs associated with Medicare supplement plans link on Medicare Supplement Plans page$")
    public void theuservalidatesLearnmoreaboutcostsassociatedwithMedicaresupplementplanslinkonMedicareSupplementPlanspage() {
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = (MedicareSupplementInsurancePlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE);
        medicareSupplementInsurancePlansPageNew.clickOnMSCostLink();
    }

    @Then("^the user validates See how Medicare costs may work with these Medicare coverage examples link on Medicare Supplement Plans page$")
    public void theuservalidatesSeehowMedicarecostsmayworkwiththeseMedicarecoverageexampleslinkonMedicareSupplementPlansPage() {
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = (MedicareSupplementInsurancePlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE);
        medicareSupplementInsurancePlansPageNew.clickOnCoverageExampleLink();
    }

    @Then("^the user validates Learn more about the Medicare Supplement Enrollment Period link on Medicare Supplement Plans page$")
    public void theuservalidatesLearnmoreabouttheMedicareSupplementEnrollmentPeriodlinkonMedicareSupplementPlanspage() {
        MedicareSupplementInsurancePlansPageNew medicareSupplementInsurancePlansPageNew = (MedicareSupplementInsurancePlansPageNew)
                getLoginScenario().getBean(PageConstants.MEDICARE_SUPPLEMENT_PLANS_PAGE);
        medicareSupplementInsurancePlansPageNew.clickOnMedicareSEPLink();
    }

    @Then("^the user validates Medicare Advantage Plans link on new Medicare Prescription Drugs Plans page$")
    public void theuservalidatesMedicareAdvantagePlanslinkonnewMedicarePrescriptionDrugsPlanspage() {
        MedicarePrescriptionDrugPartDPlansPageNew prescriptionDrugPartDPlansPageNew = (MedicarePrescriptionDrugPartDPlansPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_DRUGS_PLANS_PAGE);
        prescriptionDrugPartDPlansPageNew.clickOnMAPlansLink();
    }

    @Then("^the user validates the Extra Help program links on new Medicare Prescription Drugs Plans page$")
    public void theuservalidatestheExtraHelpprogramlinksonnewMedicarePrescriptionDrugsPlanspage() {
        MedicarePrescriptionDrugPartDPlansPageNew prescriptionDrugPartDPlansPageNew = (MedicarePrescriptionDrugPartDPlansPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_DRUGS_PLANS_PAGE);
        prescriptionDrugPartDPlansPageNew.clickOnExtraHelpLink();
    }


    @Then("^the user validates See how Medicare costs may work with these Medicare coverage examples links on new Medicare Prescription Drugs Plans page$")
    public void theuservalidatesSeehowMedicarecostsmayworkwiththeseMedicarecoverageexampleslinksonnewMedicarePrescriptionDrugsPlanspage() {
        MedicarePrescriptionDrugPartDPlansPageNew prescriptionDrugPartDPlansPageNew = (MedicarePrescriptionDrugPartDPlansPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_DRUGS_PLANS_PAGE);
        prescriptionDrugPartDPlansPageNew.clickOnCoverageExampleLink();
    }

    @Then("^the user validates Learn more about how to enroll on Medicare Advantage Plans Page$")
    public void theuservalidatesLearnmoreabouthowtoenrollonMedicareAdvantagePlansPage() {
        MedicarePrescriptionDrugPartDPlansPageNew prescriptionDrugPartDPlansPageNew = (MedicarePrescriptionDrugPartDPlansPageNew) getLoginScenario()
                .getBean(PageConstants.PRESCRIPTION_DRUGS_PLANS_PAGE);
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = prescriptionDrugPartDPlansPageNew.clickOnHowToEnroll();
        if (howtoEnrollinMedicarePage != null) {
            getLoginScenario().saveBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE, howtoEnrollinMedicarePage);
            System.out.println("How to Enroll in Medicare Page loaded");
        } else {
            Assert.fail("How to Enroll in Medicare Page not loaded");
        }
    }

    @Then("^the user validates Learn more about Dual Special Needs coverage on Special Needs Plans Page$")
    public void theuservalidatesLearnmoreaboutDualSpecialNeedscoverageonSpecialNeedsPlansPage() {
        SpecialNeedsPlansPage specialNeedsPlansPage = (SpecialNeedsPlansPage) getLoginScenario()
                .getBean(PageConstants.SPECIAL_NEEDS_PLANS_PAGE);
        specialNeedsPlansPage.clickOnDSNPCoverage();
    }

    @Then("^the user validates Medicare Enrollment on Special Needs Plans Page$")
    public void theuservalidatesMedicareEnrollmentonSpecialNeedsPlansPage() {
        SpecialNeedsPlansPage specialNeedsPlansPage = (SpecialNeedsPlansPage) getLoginScenario()
                .getBean(PageConstants.SPECIAL_NEEDS_PLANS_PAGE);
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = specialNeedsPlansPage.clickOnMedicareEnrollment();

        if (whentoEnrollinMedicarePage != null) {
            getLoginScenario().saveBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE, whentoEnrollinMedicarePage);
            System.out.println("New Enrollment page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Enrollment Page did not loaded");
        }

    }


    @Then("^the user validates inner links on new Enrollment Page$")
    public void theuservalidatesinnerlinksonnewEnrollmentPage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.checkInnerLinks();
    }

    @Then("^the user validates the Initial Enrollment Period links on new Enrollment page$")
    public void theuservalidatestheInitialEnrollmentPeriodlinksonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonIEPlink();
    }

    @Then("^the user validates the creditable link on new Enrollment page$")
    public void theuservalidatesthecreditablelinkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonCreditablelink();
    }

    @Then("^the user validates the Understand your Medicare enrollment options when working past 65 link on new Enrollment page$")
    public void theuservalidatestheUnderstandyourMedicareenrollmentoptionswhenworkingpast65linkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonWP65link();
    }

    @Then("^the user validates the Learn more about the Special Enrollment Period when working past 65 link on new Enrollment page$")
    public void theuservalidatestheLearnmoreabouttheSpecialEnrollmentPeriodwhenworkingpast65linkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonSEPlink();
    }

    @Then("^the user validates the Learn more about Medicare penalties link on new Enrollment page$")
    public void theuservalidatestheLearnmoreaboutMedicarepenaltieslinkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonSEPlink();
    }

    @Then("^the user validates the Learn how to enroll in Medicare coverage link on new Enrollment page$")
    public void theuservalidatestheLearnhowtoenrollinMedicarecoveragelinkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonHowToEnrolllink();
    }

    @Then("^the user validates the Learn how to enroll in Medicare with a qualifying disability, ALS or ESRD link on new Enrollment page$")
    public void theuservalidatestheLearnhowtoenrollinMedicarewithaqualifyingdisabilityALSorESRDlinkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        whentoEnrollinMedicarePage.clickonDisabilitylink();
    }

    @Then("^the user validates the Learn how to change Medicare plans link on new Enrollment page$")
    public void theuservalidatestheLearnhowtochangeMedicareplanslinkonnewEnrollmentpage() {
        WhentoEnrollinMedicarePage whentoEnrollinMedicarePage = (WhentoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.WHEN_TO_ENROLL_IN_MEDICARE_PAGE);
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = whentoEnrollinMedicarePage.clickOnNextHowToEnrollLink();

        if (howtoEnrollinMedicarePage != null) {
            getLoginScenario().saveBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE, howtoEnrollinMedicarePage);
            System.out.println("How to Enroll in Medicare Page loaded");
        } else {
            Assert.fail("How to Enroll in Medicare Page not loaded");
        }
    }

    @Then("^the user validates the Learn more about getting prescription drug coverage link on new Original Medicare page$")
    public void theuservalidatestheLearnmoreaboutgettingprescriptiondrugcoveragelinkonnewOriginalMedicarepage() {
        OriginalMedicarePage originalMedicarePage = (OriginalMedicarePage) getLoginScenario().
                getBean(PageConstants.ORIGINAL_MEDICARE_PAGE);
        originalMedicarePage.clickonPDPlink();

    }

    @Then("^the user validates the Learn how to get coverage for dental, vision and other benefits with Medicare link on new Original Medicare page$")
    public void theuservalidatestheLearnhowtogetcoveragefordentalvisionandotherbenefitswithMedicarelinkonnewOriginalMedicarepage() {
        OriginalMedicarePage originalMedicarePage = (OriginalMedicarePage) getLoginScenario().
                getBean(PageConstants.ORIGINAL_MEDICARE_PAGE);
        originalMedicarePage.clickonArticleCoveragelink();

    }

    @Then("^the user validates the Types of Medicare and Medigap Insurance Plans link on new Original Medicare page$")
    public void theuservalidatestheTypesofMedicareandMedigapInsurancePlanslinkonnewOriginalMedicarepage() {
        OriginalMedicarePage originalMedicarePage = (OriginalMedicarePage) getLoginScenario().
                getBean(PageConstants.ORIGINAL_MEDICARE_PAGE);
        OverviewofPlanTypesPage overviewofPlanTypesPage = originalMedicarePage.clickonNextPlanOverviewLink();
        if (overviewofPlanTypesPage != null) {
            getLoginScenario().saveBean(PageConstants.OVERVIEW_OF_PLAN_TYPES, overviewofPlanTypesPage);
            System.out.println("New Overview of Plan Types Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            System.out.println("New Overview of Plan Types Page did not loaded");
        }

    }

    @Then("^the user validates all the plans links on new Overview of Plan Types page$")
    public void theuservalidatesalltheplanslinksonnewOverviewofPlanTypespage() {
        OverviewofPlanTypesPage overviewofPlanTypesPage = (OverviewofPlanTypesPage) getLoginScenario()
                .getBean(PageConstants.OVERVIEW_OF_PLAN_TYPES);
        overviewofPlanTypesPage.clickonMAlink();
        overviewofPlanTypesPage.clickonMedSupplink();
        overviewofPlanTypesPage.clickonPDPlink();
        overviewofPlanTypesPage.clickonSNPlink();
    }

    @Then("^the user validates the Learn about my Initial Enrollment Period & Medicare choices link on new Working Past 65 page$")
    public void theuservalidatestheLearnaboutmyInitialEnrollmentPeriodMedicarechoiceslinkonnewWorkingPast65page() {
        WorkingPast65Page workingPast65Page = (WorkingPast65Page) getLoginScenario()
                .getBean(PageConstants.WORKING_PAST_65_PAGE);
        workingPast65Page.clickonIEPlink();
    }

    @Then("^the user validates the Find your Special Enrollment Period dates link on new Working Past 65 page$")
    public void theuservalidatestheFindyourSpecialEnrollmentPerioddateslinkonnewWorkingPast65page() {
        WorkingPast65Page workingPast65Page = (WorkingPast65Page) getLoginScenario()
                .getBean(PageConstants.WORKING_PAST_65_PAGE);
        workingPast65Page.clickonIEPlink();
    }

    @Then("^the user validates wizard component on new Medicare Education Page$")
    public void theuservalidateswizardcomponentonnewMedicareEducationPage() {
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.validateWizardComponent();
    }

    @Then("^the user validates inner links on new How to Enroll Page$")
    public void theuservalidatesinnerlinksonnewHowtoEnrollPage() {
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = (HowtoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE);
        howtoEnrollinMedicarePage.checkInnerLinks();
    }

    @Then("^the user validates Social Security links on new How to Enroll Page$")
    public void theuservalidatesSocialSecuritylinksonnewHowtoEnrollPage() {
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = (HowtoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE);
        howtoEnrollinMedicarePage.clickOnSocialSecurityLinks();
    }

    @Then("^the user validates Medicare Gov links on new How to Enroll Page$")
    public void theuservalidatesMedicareGovlinksonnewHowtoEnrollPage() {
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = (HowtoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE);
        howtoEnrollinMedicarePage.clickOnMedicareGovLinks();
    }

    @Then("^the user validates View Different Plans links on new How to Enroll Page$")
    public void theuservalidatesViewDifferentPlanslinksonnewHowtoEnrollPage() {
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = (HowtoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE);
        howtoEnrollinMedicarePage.clickOnViewPlansLinks();
    }

    @Then("^the user validates Changing Plan link on new How to Enroll Page$")
    public void theuservalidatesChaningPlanlinkonnewHowtoEnrollPage() {
        HowtoEnrollinMedicarePage howtoEnrollinMedicarePage = (HowtoEnrollinMedicarePage) getLoginScenario()
                .getBean(PageConstants.HOW_TO_ENROLL_IN_MEDICARE_PAGE);
        ChangingMedicarePlansPage changingMedicarePlansPage = howtoEnrollinMedicarePage.clickOnChangingPlans();
        if (changingMedicarePlansPage != null) {
            getLoginScenario().saveBean(PageConstants.CHANGING_MEDICARE_PLAN_PAGE, changingMedicarePlansPage);
            System.out.println("New Changing Medicare Plans page loaded");
            Assertion.assertTrue(true);
        } else {
            Assert.fail("New Changing Medicare Plans Page did not loaded");
        }
    }

    @Then("^the user validates inner links on new Chaning Plan Page$")
    public void theuservalidatesinnerlinksonnewChaningPlanPage() {
        ChangingMedicarePlansPage changingMedicarePlansPage = (ChangingMedicarePlansPage) getLoginScenario()
                .getBean(PageConstants.CHANGING_MEDICARE_PLAN_PAGE);
        changingMedicarePlansPage.checkInnerLinks();
    }

    @Then("^the user validates Learn more here link on new Chaning Plan Page$")
    public void theuservalidatesLearnmoreherelinkonnewChaningPlanPage() {
        ChangingMedicarePlansPage changingMedicarePlansPage = (ChangingMedicarePlansPage) getLoginScenario()
                .getBean(PageConstants.CHANGING_MEDICARE_PLAN_PAGE);
        changingMedicarePlansPage.clickonArticleDecideChangePlanlink();
    }


    @Then("^the user validates Tips for the Medicare Annual Enrollment Period link on new Chaning Plan Page$")
    public void theuservalidatesTipsfortheMedicareAnnualEnrollmentPeriodlinkonnewChaningPlanPage() {
        ChangingMedicarePlansPage changingMedicarePlansPage = (ChangingMedicarePlansPage) getLoginScenario()
                .getBean(PageConstants.CHANGING_MEDICARE_PLAN_PAGE);
        changingMedicarePlansPage.clickonArticleAEPlink();
    }


    @Then("^the user validates Medicare When Working Past Age 65 Next link on new Chaning Plan Page")
    public void theuservalidatesMedicareWhenWorkingPastAge65NextlinkonnewChaningPlanPage() {
        ChangingMedicarePlansPage changingMedicarePlansPage = (ChangingMedicarePlansPage) getLoginScenario()
                .getBean(PageConstants.CHANGING_MEDICARE_PLAN_PAGE);
        WorkingPast65Page workingPast65Page = changingMedicarePlansPage.clickOnLearnMoreAboutWP65();
        if (workingPast65Page != null) {
            getLoginScenario().saveBean(PageConstants.WORKING_PAST_65_PAGE, workingPast65Page);
            System.out.println("New Working Past 65 page loaded");
            Assertion.assertTrue(true);
        } else {
            Assert.fail("New Working Past 65 did not loaded");
        }

    }

    @Then("^the user navigates to following sub page$")
    public void theusernavigatestofollowingsubpage(DataTable givenAttributes) throws Throwable {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String path = memberAttributesMap.get("PagePath");
        path = path.replace("!", "#");
        System.out.print("Path to page : " + path);
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.navigateToPath(path);
    }

    @Then("^the user validates Download PDF link$")
    public void theuservalidatesDownloadPDFlink(DataTable givenAttributes) throws Throwable {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String header = memberAttributesMap.get("Header");
        String pdfName = memberAttributesMap.get("PDFName");
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.validateDownloadLink(header, pdfName);
    }

    @Then("^the user validates PDF Viewer on the page$")
    public void theuservalidatesPDFVieweronthepage(DataTable givenAttributes) throws Throwable {
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String pdfName = memberAttributesMap.get("PDFName");
        LearnAboutMedicareHomePageNew learnAboutMedicareHomePageNew = (LearnAboutMedicareHomePageNew) getLoginScenario()
                .getBean(PageConstants.LEARN_ABOUT_MEDICARE_PAGE);
        learnAboutMedicareHomePageNew.validatePDFViewer();
        learnAboutMedicareHomePageNew.validatePdfMenuDownloadLink(pdfName);
        learnAboutMedicareHomePageNew.validatePdfMenuPrintLink();


    }

    @Then("^the user validate the state selected is correct$")
    public void the_user_validate_the_state_selected_is_correct(DataTable givenAttributes) {
        AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
                .getBean(PageConstants.ACQUISITION_HOME_PAGE);
        Map<String, String> memberAttributesMap = new HashMap<String, String>();
        memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String geoState = memberAttributesMap.get("GeoState");
        String stateSelected= aquisitionhomepage.getSelectedState();

        if (!geoState.equalsIgnoreCase(stateSelected)){
            Assert.fail("State selected is not correct: "+stateSelected);
        }
        else {
            System.out.println("State selected is correct: "+ stateSelected);
            getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
        }
    }
}