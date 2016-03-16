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

@Cucumber.Options(glue = { "atdd.framework","acceptancetests.claims" }, 
		features = { "feature/claims" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@drugClaimsUms"})
public class RunMRCukesClaimsTest {

}
