/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.sanity.ulayer" }, 
		features = { "feature/sanity_ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRAtddTestSanityUlayer-cucumber.json" }, tags ={"@pdpInquiryKit"})
public class RunMRAtddTestPDPInquiryKit {

}
