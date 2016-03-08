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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.acquisitionhome" }, 
		features = { "feature/acquisitionhome" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@homeTestAARP"})
public class RunMRCukesAcquistionUlayerHome {

}
