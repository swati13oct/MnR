package atdd.mobile.runners;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Test;

@CucumberOptions(glue = {"atdd.framework", "acceptancetests.acquisition"},
        features = {"src/main/resources/feature/acquisition/staticPages"},
        monochrome = true,
        plugin = {"pretty",
                "html:reports/test-report.html",
                "json:target/cucumber-RunMRATDDAcquisitionStaticPages.json",
                "timeline:target"},
        tags = "@regressionAARP")

@RetryCountIfFailed(1)
public class RunMRATDDAcquisitionStaticPages extends BaseTestConfig {
    @Test(dataProvider = ScenarioDataProvider)
    public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
}
