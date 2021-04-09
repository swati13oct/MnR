package atdd.runners;

import org.testng.annotations.Test;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;


@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },
				features = {"src/main/resources/feature/acquisition/vpp/PlanBenefitsValidation"},
				monochrome = true,
				plugin = { "pretty",
						"html:reports/test-report.html",
						"json:target/cucumber-RunMRATDDPlanSummaryBenefits.json",
						"timeline:target" },
				tags = "@planSummaryBenefits")

@RetryCountIfFailed(0)
public class RunMRATDDPlanSummaryBenefits extends BaseTestConfig {
	@Test(dataProvider = ScenarioDataProvider)
	public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}
}
