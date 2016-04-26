/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pnampall
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.browsercheckmember" }, 
		features = { "feature/browsercheck-member" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@memberBrowserCheck"})
public class RunMRAtddTestMemberUnsupportedBrowsers {
	
	

}
