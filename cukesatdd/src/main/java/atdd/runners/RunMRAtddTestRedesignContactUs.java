package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.contactus.ulayer.redesign" }, 
		features = { "feature/contactus/ulayer/redesign" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@contactUsTestredesign"})
public class RunMRAtddTestRedesignContactUs {

}

