package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.ulayer" }, 
		features = { "feature/PortfolioPage/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report"}, tags ={"@vppportfoliopage"})
public class RunMRAtddTestPortfolio { 

}
