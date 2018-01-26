package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisitionvbf" }, features = { "src/main/resources/feature/acquisitionvbf" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber.json" }, tags = { "@enrollInPlanulayer,@pharmacylocatorulayer,@pharmacylocatorblayer,@enrollInPlanblayer,@vppUlayer,@vppBlayer,@AcqProviderSearchUlayer,@BlayerProviderSearch,@AcqSEO,@acq_drug_cost_estimator,@acq_dce_UHC,@ssllabs,@agentAppointment,@attendCommunity" })
public class RunMRATDDFixedTests {

}
