package atdd.runners;

import org.testng.annotations.Test;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(glue = { "atdd.framework", "acceptancetests.UHCCP" , "acceptancetests.acquisition"},
				features = {"src/main/resources/feature/UHCCP"},
				monochrome = true,
				plugin = { "pretty",
						"html:reports/test-report.html",
						"json:target/cucumber-RunMRATDDUhcCommunityPlan.json",
						"timeline:target" },
				tags = "@uhccp")

@RetryCountIfFailed(0)
public class RunMRATDDUhcCommunityPlan extends BaseTestConfig {

	@Test(dataProvider = ScenarioDataProvider)
	public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}
}

