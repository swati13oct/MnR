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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.registration.bluelayer" }, 
		features = { "feature/registration/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json",  }, tags ={"@registration1"})
public class RunMRAtddTestRegistration {

}
