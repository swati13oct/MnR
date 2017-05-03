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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.member.ulayer" }, 
		features = { "feature/pharmacy-locator/member/ulayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@pharmacyprpnwidget,@pharmacysearchresult,@pharmacysearch"})
public class RunMRAtddTestPharmacylocator {

}

