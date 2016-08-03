package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author pgrover1
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "acceptancetests.Planpreview.bluelayer" }, 
		features = { "feature/PlanPreview/bluelayer" }, 
		format = {"pretty", "html:reports/test-report" }, tags ={"@planpums"})

public class RunMRAtddPlanpreview {
	
	
}
