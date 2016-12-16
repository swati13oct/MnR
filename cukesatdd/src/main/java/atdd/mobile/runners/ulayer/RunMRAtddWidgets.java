package atdd.mobile.runners.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.vpp.ulayer" }, 
features = { "feature/mobile/ulayer/VPP" }, 
format = {
"pretty", "html:reports/test-report" }, tags ={"@VppWidgets"})
public class RunMRAtddWidgets {

}
