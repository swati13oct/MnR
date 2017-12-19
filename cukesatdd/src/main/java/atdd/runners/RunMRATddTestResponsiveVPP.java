package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.ulayer" }, 
		features = { "feature/responsive/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRATddTestResponsiveVPP-cucumber.json" }, tags ={"@planSummaryPage"})
public class RunMRATddTestResponsiveVPP {

}