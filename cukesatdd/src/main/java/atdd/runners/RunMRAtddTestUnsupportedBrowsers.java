package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pemmadi
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.browsercheck" }, 
		features = { "feature/browsercheck/blayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@browsercheck"})
public class RunMRAtddTestUnsupportedBrowsers {

}
