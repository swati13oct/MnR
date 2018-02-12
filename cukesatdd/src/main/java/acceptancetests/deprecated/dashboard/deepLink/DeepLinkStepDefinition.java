package acceptancetests.deprecated.dashboard.deepLink;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.deepLink.DeepLink;

public class DeepLinkStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am an registered user and clicks on deeplink$")
	public void registered_user(DataTable givenAttributes){
		
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

 		String deepLinkURL = memberAttributesMap.get("DeepLinkURL");
 		
 		getLoginScenario().saveBean(PageConstants.DeepLink_url, deepLinkURL);

		WebDriver wd = getLoginScenario().getWebDriver();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        
        DeepLink deepLinkPag = new DeepLink(wd);
        deepLinkPag.enterDesiredURL(deepLinkURL);
        if (deepLinkPag!=null) {
        	getLoginScenario().saveBean(PageConstants.DeepLink_Page, deepLinkPag);
		}
        
	}
	
	
	@And("^then upon successful sign-in, directed to the desired page")
	public void then_user_validated_desired_page(DataTable givenAttributes){
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
				}

			String deepLinkPage = memberAttributesMap.get("DeepLinkPage");
			String userName = memberAttributesMap.get("UserName");
			DeepLink deepLinkPag = (DeepLink) getLoginScenario().getBean(PageConstants.DeepLink_Page);
			String deepLinkUrl = (String) getLoginScenario().getBean(PageConstants.DeepLink_url);
			deepLinkPag.loginToDashboardPage(userName);
			deepLinkPag.validateDeepLinkPage(deepLinkPage, deepLinkUrl);
 	}
}
