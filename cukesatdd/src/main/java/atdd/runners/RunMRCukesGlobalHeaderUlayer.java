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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.globalheader.ulayer" }, 
		features = { "feature/global-header" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@headerULayerTest"})
public class RunMRCukesGlobalHeaderUlayer {

}