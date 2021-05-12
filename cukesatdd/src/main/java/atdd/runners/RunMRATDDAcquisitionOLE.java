package atdd.runners;

import org.testng.annotations.Test;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },
				features = {"src/main/resources/feature/acquisition/ole"},
				monochrome = true,
				plugin = { "pretty",
						"html:reports/test-report.html",
						"json:target/cucumber-RunMRATDDAcquisitionOLE.json",
						"timeline:target" },
				tags = "@regressionAARP")


@RetryCountIfFailed(1)
public class RunMRATDDAcquisitionOLE extends BaseTestConfig {
	@Test(dataProvider = ScenarioDataProvider)
	public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}
}