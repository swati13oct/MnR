package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.ulayer" }, 
		features = { "feature/responsive/Ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber-sprint1.json" }, tags ={"@aprilReleaseSprint1,@aprilReleaseSprint2,@aprilReleaseSprint3,@aprilReleaseSprint4,@aprilReleaseSprint5"})
public class RunMRATDDTestRunnerFnF {

}
