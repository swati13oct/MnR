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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dcevpp" }, 
		features = { "feature/dcevpp" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@dceVpp"})
public class RunMRCukesDce {

}
