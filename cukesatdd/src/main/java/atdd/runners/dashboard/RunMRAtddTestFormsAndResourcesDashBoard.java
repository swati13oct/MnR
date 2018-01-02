package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.formsandresources" }, 
		features = { "feature/forms-and-resources/dashboard" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/dashBoardFormsAndResources-cucumber.json"  }, tags ={"@dashBoardFormsAndResources"})
public class RunMRAtddTestFormsAndResourcesDashBoard {

}
