package atdd.mobile.runners.vpp.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.vpp" }, 
		features = { "feature/mobile/vpp/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@VppRequestSendEmail"})

public class RunMRAtddTestVppRequestSendEmailUpdate {

}
