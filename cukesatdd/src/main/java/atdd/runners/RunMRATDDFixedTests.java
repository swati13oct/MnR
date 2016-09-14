package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * 
 * @author schak38
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.enrollinplan.ulayer" }, 
		features = { "feature/enroll-in-plan" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@fixedTestCase"})
public class RunMRATDDFixedTests {

}
