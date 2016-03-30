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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.drx" }, 
		features = { "feature/drx" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@drxDrugSearch"})
public class RunAtddTestDrx {
	
}
