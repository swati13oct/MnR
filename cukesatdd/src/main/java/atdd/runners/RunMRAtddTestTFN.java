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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.tollfreenumber" }, 
		features = { "feature/toll-free-number" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@tfn"})
public class RunMRAtddTestTFN {

}
