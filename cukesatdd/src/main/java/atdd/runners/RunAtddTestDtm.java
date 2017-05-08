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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dtmtests" }, 
		features = { "feature/dtm" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@enrollDTM"})
public class RunAtddTestDtm {
	
}
