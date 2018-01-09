/**
 * 
 */
package atdd.mobile.runners.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.pharmacylocator.ulayer" }, 
features = { "feature/mobile/ulayer/pharmacylocator" }, 
format = {
"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@pharmacyLocator"})
public class RunMRAtddPharmacyLocator {

}
