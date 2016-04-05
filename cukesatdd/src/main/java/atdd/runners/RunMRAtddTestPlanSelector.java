/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.planselector" }, 
		features = { "feature/planselector" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@acqPlanSelector"})
public class RunMRAtddTestPlanSelector {
																																																										
}
