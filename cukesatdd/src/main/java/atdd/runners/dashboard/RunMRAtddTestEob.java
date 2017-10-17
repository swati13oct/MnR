/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.eob" }, 
		features = { "feature/dashboard/eob" }, 
		format = { 
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@US819098"})
public class RunMRAtddTestEob {

}
