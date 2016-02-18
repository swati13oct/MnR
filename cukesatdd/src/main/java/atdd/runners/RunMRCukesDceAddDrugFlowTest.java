package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "cukes.framework","acceptancetests.dcevpp" }, 
		features = { "feature/dcevpp" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@dceVppAddDrugTest"})
		public class RunMRCukesDceAddDrugFlowTest {

}
