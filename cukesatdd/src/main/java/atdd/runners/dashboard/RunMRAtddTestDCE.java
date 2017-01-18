/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.dce.bluelayer" }, 
		features = { "feature/dashboard/dce/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@test123"})
public class RunMRAtddTestDCE {

}

