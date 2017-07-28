package atdd.runners.enrollInPlan;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author bpilli10
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.enrollinplan.bluelayer" }, 
		features = { "feature/enroll-in-plan/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@OLEBlayerMapd"})

public class RunMRAtddTestEnrollInPlanBluelayer {

}
