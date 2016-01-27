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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dceVpp" }, 
		features = { "feature/dcevpp" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@dceVppTestAARP"})
public class RunMRCukesDce {

}
