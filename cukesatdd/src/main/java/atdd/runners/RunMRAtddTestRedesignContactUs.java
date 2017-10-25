package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.redesign.contactUs" }, 
		features = { "feature/contactus" }, 
		format = {"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@velocityDashers"})
public class RunMRAtddTestRedesignContactUs {

}

