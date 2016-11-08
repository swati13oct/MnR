/**
 * 
 */
package atdd.mobile.runners.blayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.pharmacylocator.blayer" }, 
features = { "feature/mobile/bluelayer/pharmacylocator" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@pharmacy"})
public class RunMRAtddUHCPharmacyLocator {

}
