package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsibe.ulayer" }, 
		features = { "feature/PortfolioPage/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@vppportfoliopage"})
public class RunMRAtddTestPortfolio { 

}
