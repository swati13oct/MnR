package atdd.runners.enrollInPlan;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author bpilli10
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.enrollinplan.ulayer" }, 
		features = { "feature/enroll-in-plan/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@enrollInPlanulayer"})

public class RunMRAtddTestEnrollInPlanUlayer {

}
