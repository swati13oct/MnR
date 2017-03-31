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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.member.bluelayer" }, 
		features = { "feature/pharmacy-locator/member/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report", "json:target/cucumber.json" }, tags ={"@bluePharmacymultilang"})

public class RunMRAtddTestPharmacylocator {

}

