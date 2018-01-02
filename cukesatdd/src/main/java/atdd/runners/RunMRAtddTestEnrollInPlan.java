/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.enrollinplan.ulayer" }, 
		features = { "feature/enroll-in-plan" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@OLE_MA"})
public class RunMRAtddTestEnrollInPlan {

}

