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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.globalheaderfooter" }, 
		features = { "feature/global-header" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@headerFooterTest"})
public class RunMRCukesHeaderFooter {

}
