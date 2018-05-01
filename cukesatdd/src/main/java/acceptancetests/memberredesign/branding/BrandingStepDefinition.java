/**
 * 
 */
/**
 * @author jkuma14
 *
 */
package acceptancetests.memberredesign.branding;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;









import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
/**
 * 
 * @author jkuma14
 *
 */

public class BrandingStepDefinition{
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/** 
	 * 
	 */

@Given("^verify that correct logo is displayed on the home page$")
public void verifyCorrectLogoDisplayedOnDashboardHomePage(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String logoToBeDisplayedOnDashboard = memberAttributesMap.get("Dashboard Logo");
	Thread.sleep(3000);
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		Thread.sleep(3000);
	accountHomePage.validateImagePresent(logoToBeDisplayedOnDashboard);	
	getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);
	
}

@Then("^user clicks on benefits and coverage tab on home page$")
public void userClicksOnBenefitAndCoveragePage() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	Thread.sleep(3000);
	BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag();
	getLoginScenario().saveBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
	
}
	
@And("^verify that correct logo is displayed on the secondary page$")
public void verifyCorrectLogoDisplayedOnSecondaryPage(DataTable givenAttributes) throws Throwable {
	
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String logoToBeDisplayedOnSecondaryPage = memberAttributesMap.get("Secondary Page Logo");
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstantsMnR.BENEFITS_AND_COVERAGE_PAGE);
	benefitsCoveragePage.validateImagePresent(logoToBeDisplayedOnSecondaryPage);
}
}