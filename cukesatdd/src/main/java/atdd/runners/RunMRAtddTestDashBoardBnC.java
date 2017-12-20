package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage.bluelayer" }, 
		features = { "feature/plan-benefits-and-coverage/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@dashboardfr"})
public class RunMRAtddTestDashBoardBnC {

}
