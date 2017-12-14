package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.contactus.bluelayer.redesign" }, 
		features = { "feature/contactus/bluelayer/redesign" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@contactUsTestredesignBlue"})
public class RunMRAtddBlueLayerTestRedesignContactus {

}
