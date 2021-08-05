package acceptancetests.mobile.acquisition;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
import pages.mobile.acquisition.commonpages.AcquisitionHomePageMobile;

public class ClickToCallStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//AppiumDriver wd;

	
	@Given("^the user is on medicare acquisition site on mobile$")
	public void the_user_on_uhc_medicaresolutions_site_mobile() {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);
		aquisitionhomepage.openPRE("AARP");
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}



	@Given("^the user is on UHC medicare acquisition site landing page in mobile$")
	public void the_user_is_on_UHC_medicare_acquisition_site_landing_page_in_mobile() throws Throwable {
		AppiumDriver wd = getLoginScenario().getMobileDriver();
		AcquisitionHomePageMobile aquisitionhomepage = new AcquisitionHomePageMobile(wd);

		//aquisitionhomepage.openUHCURLOnMobile();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}
	/*
	@Given("^the user navigates to following medicare acquisition site page on mobile$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String path = memberAttributesMap.get("PagePath");
		path = path.replace("!", "#");
		System.out.print("Path to Acq page : "+path);
		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		//acquisitionhomepage.navigateToPath(path);
	}*/

/*	@Then("^the user clicks on the TFN and validates the popup$")
	public void the_user_clicks_on_the_TFN_and_validate_the_poup(DataTable givenAttributes) {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		List<DataTableRow> tfnAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> tfnAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < tfnAttributesRow.size(); i++) {
			tfnAttributesMap.put(tfnAttributesRow.get(i).getCells().get(0),
					tfnAttributesRow.get(i).getCells().get(1));
		}
		String tfn_xpath = tfnAttributesMap.get("TFNXpath");

		//aquisitionhomepage.validateTFN(tfn_xpath);

		aquisitionhomepage.openUHCURLOnMobile();
		aquisitionhomepage.fixPrivateConnectionMobile();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);
	}*/
	
	@Given("^the user navigates to following medicare acquisition site page on mobile$")
	public void the_user_navigates_to_following_AARP_medicare_acquisition_site_page(DataTable givenAttributes) throws Throwable {
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
		AcquisitionHomePageMobile acquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		acquisitionhomepage.navigateToPath(path);
	}

	@Then("^the user clicks on the TFN and validates the popup$")
	public void the_user_clicks_on_the_TFN_and_validate_the_poup(DataTable givenAttributes) {
		AcquisitionHomePageMobile aquisitionhomepage = (AcquisitionHomePageMobile) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		Map<String, String> tfnAttributesMap = new HashMap<String, String>();
		tfnAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> tfnAttributesRow = givenAttributes.getGherkinRows();
		for (int i = 0; i < tfnAttributesRow.size(); i++) {
			tfnAttributesMap.put(tfnAttributesRow.get(i).getCells().get(0),
					tfnAttributesRow.get(i).getCells().get(1));
		}*/
		String tfn_xpath = tfnAttributesMap.get("TFNXpath");

		aquisitionhomepage.validateTFN(tfn_xpath);


	}
}
