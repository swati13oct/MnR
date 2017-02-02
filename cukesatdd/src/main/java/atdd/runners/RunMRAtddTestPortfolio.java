package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsibe.ulayer" }, 
		features = { "feature/Portfolio/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@vppportfoliopage"})
public class RunMRAtddTestPortfolio {

}
