package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsibe.ulayer" }, 
		features = { "feature/mobileResponsive/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@planSummaryPage"})
public class RunMRATddTestResponsiveVPP {

}
