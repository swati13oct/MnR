/**
 * 
 */
package atdd.mobile.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.login" }, 
features = { "feature/mobile/login" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@login"})
public class RunMRAtddLogin {

}
