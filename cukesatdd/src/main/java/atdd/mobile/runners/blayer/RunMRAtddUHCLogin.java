/**
 * 
 */
package atdd.mobile.runners.blayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.login.blayer" }, 
features = { "feature/mobile/bluelayer" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@plandetails"})
public class RunMRAtddUHCLogin {

}
