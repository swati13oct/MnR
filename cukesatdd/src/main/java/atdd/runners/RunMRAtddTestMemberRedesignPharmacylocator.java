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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.member.redesign" }, 
		features = { "feature/pharmacy-locator/member/redesign" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, 
		tags ={"@TeamPredators,@pharmacylocator"})


//@PharmacyDistanceDefaultZip,@PharmacyFilters,@zipcodeEntry,@Validateshowonmap,@ValidateMoreInfoMAPD,@ValidateMoreInfoPDP,@ValidateChineseLanguage,@ValidateSpanishLanguage,@ZipCodeErrorMessages
//@pharmacylocator,@zipcodeEntry,
public class RunMRAtddTestMemberRedesignPharmacylocator {
	
	
}