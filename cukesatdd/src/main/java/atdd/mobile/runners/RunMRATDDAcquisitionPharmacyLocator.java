package atdd.mobile.runners;

import org.testng.annotations.Test;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },
				features = {"src/main/resources/feature/acquisition/pharmacylocator"},
				monochrome = true,
				plugin = { "pretty",
						"html:reports/test-report.html",
						"json:target/cucumber-RunMRATDDAcquisitionPharmacyLocator.json",
						"timeline:target" },
				tags = "@lang", dryRun=false)

@RetryCountIfFailed(1)
public class RunMRATDDAcquisitionPharmacyLocator extends BaseTestConfig {
	@Test(dataProvider = ScenarioDataProvider)
	public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}
}
