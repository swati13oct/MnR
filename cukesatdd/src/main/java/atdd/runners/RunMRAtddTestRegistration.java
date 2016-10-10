/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.registration" }, 
		features = { "feature/registration/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@registration"})
public class RunMRAtddTestRegistration {

}
