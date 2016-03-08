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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.addplan" }, 
		features = { "feature/addplan" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@addPlan"})
public class RunMRCukesAddPlanTest {

}
