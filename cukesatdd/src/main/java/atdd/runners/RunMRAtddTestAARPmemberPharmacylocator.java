/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author sdwaraka
 *
 */


@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.member.ulayer" }, 
		features = { "feature/pharmacy-locator/member/ulayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, 
		tags ={"@PharmacyFilters,@PharmacyDistance"})



//@pharmacylocator,@pharmacysearch,@pharmacysearchresult,@pharmacyshowmap,@pharmacymultilang,@pharmacyprpnwidget,@pharmacynonaep,@pharmacyaep,@pharmacysearchandballon
//@pharmacylocator,@pharmacysearch,@pharmacysearchresult,@pharmacyshowmap,@pharmacymultilang,@pharmacyprpnwidget,@pharmacynonaep,@pharmacyaep,@pharmacysearchandballon,

//
public class RunMRAtddTestAARPmemberPharmacylocator {
	
	
}