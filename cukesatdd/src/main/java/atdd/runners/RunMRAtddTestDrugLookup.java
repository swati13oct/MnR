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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.druglookup" }, 
		features = { "feature/druglookup" }, 
		
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@druglookup_pharmacysaver"})
public class RunMRAtddTestDrugLookup {

}
