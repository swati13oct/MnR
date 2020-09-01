package acceptancetests.acquisition.globalcomponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.EnterZipCodePage;
import pages.acquisition.commonpages.AcquisitionHomePage;

public class GlobalComponentsCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@When("^user accesses global header of the Medicare Plans home page$")
	public void access_global_header_aarp() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateHeaderLinks();
		} else {
			Assert.fail("Home page not found");
		}
	}
	
	@When("^user accesses global footer of the Medicare Plans All page$")
	public void access_global_footer_aarp_all_pages() {

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateGlobalFooterLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}
	
	@When("^user verifies the logo on home page$")
	public void user_verifies_the_AARP_logo_on_home_page() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validateLogo();		
	}

	@And("^user clicks on Sign in link on home page$")
	public void click_signIn_aarp() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.signInheader();		
	}
	
	@And("^user clicks on register link on home page$")
	public void click_register_aarp() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.headerRegisterLink();
	}
	
	@Then("^user validates visitor profile on home page$")
	public void the_user_validates_visitor_profile_aarp() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.validatevisitorprofile();
	}
	
	@Given("^the user navigates to following medicare acquisition site page$")
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
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		aquisitionhomepage.navigateToPath(path);
	}
	
	@Then("^the User validates Shop for a Plan Navigation link$")
	public void the_USer_validates_Shop_for_a_Plan_Navigation_links() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavShopPlanLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}
	
	@Then("^the user validates Medicare Education Navigation link$")
	public void the_user_validates_Medicare_Education_Navigation_links() throws Throwable {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if (aquisitionhomepage != null) {
			aquisitionhomepage.validateSubNavMedEdLinks();
		} else {
			Assert.fail("Home Page not Loading");
		}
	}
	
	@Then("^the user validates TFN on the page$") 
	public void the_user_validates_TFN_on_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String tfnXpath = memberAttributesMap.get("TFNxpath");
		String tfnFlag = memberAttributesMap.get("TFNflag");

		//EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		if(tfnFlag.equalsIgnoreCase("true")) {
			aquisitionhomepage.validateTFNelement(tfnXpath);
		}
	}
	
	@Then("^the user validate ZipCode Components on the page using ZipCode \"([^\"]*)\"$") 
	public void the_user_validate_ZipCode_Components_on_page_using_ZipCode(String zipCode) throws Throwable {
		//EnterZipCodePage enterZipCodePage= new EnterZipCodePage(driver);
				AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
						.getBean(PageConstants.ACQUISITION_HOME_PAGE);
				EnterZipCodePage enterZipCodePage=aquisitionhomepage.enterZipCode();
				enterZipCodePage.validateZipComp(zipCode);
	}
}
