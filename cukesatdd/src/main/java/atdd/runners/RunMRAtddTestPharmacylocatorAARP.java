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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.ulayer" }, 
		features = { "feature/pharmacy-locator/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@pharmacylocator"})
public class RunMRAtddTestPharmacylocatorAARP {

}

