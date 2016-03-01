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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.loginassistance" }, 
		features = { "feature/login-assistance" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@loginAssistanceTest"})
public class RunMRCukesLoginAssistanceTest {

}
