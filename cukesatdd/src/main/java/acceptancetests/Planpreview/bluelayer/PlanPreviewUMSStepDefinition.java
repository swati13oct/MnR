package acceptancetests.Planpreview.bluelayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.bluelayer.PlanPreviewPage;

/**
 * @author pgupta15
 *
 */


public class PlanPreviewUMSStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	@Given("^the user is on the Plan Preview Page of UMS medicare site landing page$")
	public void user_is_on_UMS_site()
	{
		WebDriver wd= getLoginScenario().getWebDriver();
		PlanPreviewPage planPreview = new PlanPreviewPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE, planPreview);
	}
	
	@When("^the user validates the multicounty popup on bluelayer$")
	public void user_validates_multicounty_popup_bluelayer(DataTable givenAttributes) throws InterruptedException
	{
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String zipcode = memberAttributesMap.get("Zip Code");
		String county = memberAttributesMap.get("County Name");
		getLoginScenario().saveBean(VPPCommonConstants.ZIPCODE, zipcode);
		getLoginScenario().saveBean(VPPCommonConstants.COUNTY, county);

		PlanPreviewPage planpreviewPage= (PlanPreviewPage)getLoginScenario()
				.getBean(PageConstants.ACQUISITION_PLANPREVIW_PAGE);
		 planpreviewPage.searchPlans(zipcode, county);
	}
	
	
	
}
