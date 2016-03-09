/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author rkodumur
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.globalfooter" }, 
		features = { "feature/global-footer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@global"})

public class RunMRAtddTestGlobalFooterUlayer {

}


