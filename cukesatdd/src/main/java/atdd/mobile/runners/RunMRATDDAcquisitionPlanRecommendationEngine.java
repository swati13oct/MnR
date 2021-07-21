package atdd.mobile.runners;

import org.testng.annotations.Test;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;


@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },
				features = {"src/main/resources/feature/acquisition/PlanRecommendationEngine"},
				monochrome = true,
				plugin = { "pretty",
						"html:reports/test-report.html",
						"json:target/cucumber-RunMRATDDAcquisitionPlanRecommendationEngine.json",
						"timeline:target" },
				tags = "@regressionAARPmobile", dryRun=false)

@RetryCountIfFailed(0)
public class RunMRATDDAcquisitionPlanRecommendationEngine extends BaseTestConfig {
	@Test(dataProvider = ScenarioDataProvider)
	public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}
}
