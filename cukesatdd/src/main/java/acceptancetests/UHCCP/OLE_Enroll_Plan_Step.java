package acceptancetests.UHCCP;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.OLE_PageConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UHCCP.Contact_Us_Page;
import pages.UHCCP.OLE_Enroll_Plan_Page;
import pages.UHCCP.PlanDetailsPage;
import pages.UHCCP.PlanSummaryPage;
import pages.acquisition.ole.PersonalInformationPage;
import pages.acquisition.ole.WelcomePage;

public class OLE_Enroll_Plan_Step {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public WebDriver driver;

	@When("the user clicks on Enroll in Plan and validates Welcome to OLE Page")
	public void the_user_clicks_on_enroll_in_plan_and_validates_welcome_to_ole_page() {
		String planName = (String) getLoginScenario().getBean(UHCCPCommonConstants.PLAN_NAME);
		String zipcode = (String) getLoginScenario().getBean(UHCCPCommonConstants.ZIPCODE);
		String county =(String) getLoginScenario().getBean(VPPCommonConstants.COUNTY);
		
		PlanDetailsPage planDetailsPage = (PlanDetailsPage) getLoginScenario()
				.getBean(PageConstants.UHCCP_PLAN_DETAILS_PAGE);
		OLE_Enroll_Plan_Page welcomePage = planDetailsPage.enrollInPlan(planName,zipcode);
		
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_ZIPCODE, zipcode);
		getLoginScenario().saveBean(oleCommonConstants.OLE_COUNTY, county);
		
		if (welcomePage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_WELCOME_PAGE, welcomePage);
			System.out.println("OLE Welcome Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("Error in validating the OLE Welcome Page");
	}
	
	@Then("^the user navigates to OLE Personal Information Page$")
	public void the_user_navigates_to_OLE_Personal_Information_Page() throws Throwable {

		OLE_Enroll_Plan_Page welcomePage = (OLE_Enroll_Plan_Page) getLoginScenario().getBean(OLE_PageConstants.OLE_WELCOME_PAGE);
		PersonalInformationPage personalInformationPage = welcomePage.navigate_to_Personal_Information_page();

		if (personalInformationPage != null) {

			getLoginScenario().saveBean(OLE_PageConstants.OLE_PERSONAL_INFO_PAGE,
					personalInformationPage);
			System.out.println("OLE Personal Information Page is Displayed");
			Assertion.assertTrue(true);
		} else
			Assertion.fail("OLE Personal Information Page is NOT Displayed");
	}	
}
