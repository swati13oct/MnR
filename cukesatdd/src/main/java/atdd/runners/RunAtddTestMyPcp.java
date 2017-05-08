package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mypcpregistration" }, 
		features = { "feature/mypcp" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@mypcp"})
public class RunAtddTestMyPcp {

}
