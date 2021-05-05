package acceptancetests.mobile.acquisition.dceredesign;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;
import pages.mobile.acquisition.dceredesign.ZipCodeAndPlanYearCapturePageMobile;

public class DCEStepDefinitionAARPMobile {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	AppiumDriver wd;
	
	@Given("^the user is on AARP medicare acquisition site landing page in mobile$")
	public void the_user_is_on_AARP_medicare_acquisition_site_landing_page_in_mobile() throws Throwable {
		wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openMobileURL();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}

	@When("^the user navigates to following AARP medicare acquisition site page in mobile$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page_in_mobile(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}*/
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : "+path);
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPage(path);
	}

	@Then("^the user validates Get Started Page in mobile$")
	public void the_user_validates_Get_Started_Page_in_mobile() {
		wd = (AppiumDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage = new ZipCodeAndPlanYearCapturePageMobile(wd);
		getLoginScenario().saveBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture, zipCodePlanYearPage);
	}

	@When("^the user clicks on Add drugs button in mobile$")
	public void the_user_clicks_on_Add_drugs_button_in_mobile() throws Throwable {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage=(ZipCodeAndPlanYearCapturePageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.clickAddDrugsBtn();
	}

	@Then("^user should be navigated to zipcode and plan year capture page for NonAEP in mobile$")
	public void user_should_be_navigated_to_zipcode_and_plan_year_capture_page_for_NonAEP_in_mobile() throws Throwable {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage=(ZipCodeAndPlanYearCapturePageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validateZipCodePlanYearCapturePageNonAEP();
	}

	@Then("^plan year dropdown should be not displayed during NonAEP in mobile$")
	public void plan_year_dropdown_should_not_be_displayed_during_AEP_in_mobile() throws Throwable {
		ZipCodeAndPlanYearCapturePageMobile zipCodePlanYearPage=(ZipCodeAndPlanYearCapturePageMobile) getLoginScenario().getBean(PageConstants.DCE_Redesign_ZipCodePlanYearCapture);
		zipCodePlanYearPage.validatePlanYearDrpDownNonAEP();
	}
}
