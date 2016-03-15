package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.plancompare" }, 
		features = { "feature/plan-compare" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@planCompareTest"})

public class RunMRCukesPlanCompare {
	
	
}
