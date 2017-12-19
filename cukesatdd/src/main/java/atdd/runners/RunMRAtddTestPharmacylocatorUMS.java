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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.bluelayer" }, 
		features = { "feature/pharmacy-locator/bluelayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, 
		tags ={"@pharmacylocator"})
//@plmapd,@errormessages
//@multicounty,@languageselection,@planType,@zipcodeEntry,@showonmap,@resultpdf,@plmapd,@plpdp,@MAplantype,@Widgets,@moreinfoPDPplantype,@moreinfoMAplantype,@chatPDPplantype,@chatMAplantype,@TFNPDPplantype,@TFNMAplantype,@pharmacysaverwidget,@Pharmacylist,@chineselanguage,@spanishlanguage,@resultpdfpharmacysaver,@moreinfopharmacysaver,@redballonpharmacysaver,@tooltippharmacysaver,@errormessages
//@pharmacylocator

//
public class RunMRAtddTestPharmacylocatorUMS {
	
	
}