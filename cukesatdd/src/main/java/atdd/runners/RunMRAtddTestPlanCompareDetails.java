package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.plancomparedetails" }, 
		features = { "feature/plan-compare-details" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@planCompareTest"})

public class RunMRAtddTestPlanCompareDetails {
	
	
}
