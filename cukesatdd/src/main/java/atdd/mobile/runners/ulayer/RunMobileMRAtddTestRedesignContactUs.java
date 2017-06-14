package atdd.mobile.runners.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.login.ulayer.redesign.contactus" }, 
features = { "feature/mobile/ulayer/contactus/redesign" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@contactUsTestredesignMob"})

public class RunMobileMRAtddTestRedesignContactUs {

}
