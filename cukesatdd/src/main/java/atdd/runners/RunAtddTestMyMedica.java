package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mymedicaregistration" }, 
		features = { "feature/mymedica" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@mymedicaregistration"})
public class RunAtddTestMyMedica {

}
