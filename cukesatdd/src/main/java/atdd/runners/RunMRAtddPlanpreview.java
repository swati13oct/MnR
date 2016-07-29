package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "acceptancetests.Planpreview.ulayer" }, 
		features = { "feature/PlanPreview/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@planpaarp"})

public class RunMRAtddPlanpreview {
	
	
}
