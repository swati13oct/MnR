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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.bluelayer" }, 
		features = { "feature/pharmacy-locator/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRAtddTestPharmacylocator-cucumber.json" }, tags ={"@pharmacylocator"})
public class RunMRAtddTestPharmacylocator {

}

