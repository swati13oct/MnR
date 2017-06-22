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
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@pharmacyprpnwidget,@pharmacysearchresult,@pharmacysearch,@pharmacyprpnwidget,@pharmacyresultpdf,@pharmacyshowmap,@pharmacyaep,@pharmacysearchresult,@pharmacymultilang,@pharmacynonaep,@pharmacysearchandballon"})
public class RunMRAtddTestPharmacylocator {
	
	
}

