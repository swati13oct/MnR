package atdd.runners;

import atdd.framework.BaseTestConfig;
import atdd.framework.RetryCountIfFailed;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Test;

@CucumberOptions(glue = {"atdd.framework", "acceptancetests.AEM"},
        features = {"src/main/resources/feature/AEM"},
        monochrome = true,
        plugin = {"pretty",
                "html:reports/test-report.html",
                "json:target/cucumber-RunMRATDDAcquisitionAEMDataLayer.json",
                "timeline:target"},
        tags = "@AEM_DataLayer")

@RetryCountIfFailed(0)
public class RunMRATDDAcquisitionAEMDataLayer extends BaseTestConfig {
    @Test(dataProvider = ScenarioDataProvider)
    public void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
}
