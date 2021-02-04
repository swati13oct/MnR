package acceptancetests.acquisition.campaignExternalLinkE2E;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import gherkin.formatter.model.DataTableRow;

/**
 * Functionality: Validate different Campaign External Links
 */

public class CampaignExternalLinkStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	WebDriver wd;
	
	@Given("^user access the campaign external link$")
	public void user_access_the_campaign_external_link(DataTable givenAttributes) throws Throwable {
		wd = getLoginScenario().getWebDriverNew();
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String site = memberAttributesMap.get("External Site");
	}
}
