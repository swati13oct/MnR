package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author snagpa4
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.globalheader.OurPlans.ulayer" }, 
		features = { "feature/global-header/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@headerOurPlansNavULayer"})

public class RunMRCukesOurPlansDropDownUlayer {

}
