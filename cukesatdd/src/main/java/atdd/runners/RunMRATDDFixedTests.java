package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * 
 * @author schak38
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.fixedtestcases" }, 
		features = { "feature/fixedtestcases" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@fixedTestCaseTest"})
public class RunMRATDDFixedTests {

}
