/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator" }, 
		features = { "feature/pharmacy-locator" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@pharmacylocatorTest"})
public class RunMRCukesPharmacylocatorTest {

}

