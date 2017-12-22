/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.eob" }, 
		features = { "feature/dashboard/eob" }, 
		format = { 
				
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@EOBSep"})
public class RunMRAtddEob {

}