package atdd.runners.Feature_ATDD;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionAgentFlow
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunFeatureATDDAcquisitionAgentFlow.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunFeatureATDDAcquisitionAgentFlow")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/agentflow" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunFeatureATDDAcquisitionAgentFlow.json" }, tags = { "@agentAppointmentUlayerSmoke, @agentAppointmentBlayerSmoke" })
public class RunFeatureATDDAcquisitionAgentFlowVBF {

}
