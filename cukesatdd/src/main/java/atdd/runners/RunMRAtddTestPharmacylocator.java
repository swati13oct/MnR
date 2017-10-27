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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.sanity.blayer" }, 
		features = { "feature/sanity_blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRAtddTestPharmacylocator-cucumber.json" }, tags ={"@pharmacylocator"})
public class RunMRAtddTestPharmacylocator {

}

