/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.home" }, 
		features = { "feature/home" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@homeTestUMS"})
public class RunMRCukesAcquistionBlayerHome {

}
