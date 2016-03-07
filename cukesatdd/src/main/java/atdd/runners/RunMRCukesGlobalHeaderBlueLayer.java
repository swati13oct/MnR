/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author saduri
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.globalheader.bluelayer" }, 
		features = { "feature/global-header" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@global"})
public class RunMRCukesGlobalHeaderBlueLayer {

}
