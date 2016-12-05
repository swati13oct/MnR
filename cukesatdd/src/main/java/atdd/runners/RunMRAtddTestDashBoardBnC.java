package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage" }, 
		features = { "feature/plan-benefits-and-coverage" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@bncUlayer"})
public class RunMRAtddTestDashBoardBnC {

}
