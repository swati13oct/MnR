package atdd.runners.pharmacylocator;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author bpilli10
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pharmacylocator.member.ulayer" }, 
		features = { "feature/pharmacy-locator/member/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@changeTeambDate"})

public class RunMRAtddTestPharmacylocatorMemberUlayer {

}
