/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * 
 * @author apriyad4
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.eob" }, 
		features = { "feature/dashboard/eob" }, 
		format = { 
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@eob"})
public class RunMRAtddTestEob {

}
