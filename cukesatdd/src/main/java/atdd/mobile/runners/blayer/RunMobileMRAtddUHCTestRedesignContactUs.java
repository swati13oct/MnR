package atdd.mobile.runners.blayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.login.blayer.redesign.contactus" }, 
features = { "feature/mobile/bluelayer/contactus/redesign" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@contactUsTestredesignMob"})

public class RunMobileMRAtddUHCTestRedesignContactUs {

}
