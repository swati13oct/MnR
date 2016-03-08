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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.globalfooter" }, 
		features = { "feature/global-footer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@global"})
public class RunMRCukesGlobalFooterBlueLayer {

}
