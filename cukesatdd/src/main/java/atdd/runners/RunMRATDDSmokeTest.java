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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDSmokeTest.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSmokeTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.vbfacquisition" }, features = { "src/main/resources/feature/vbfacquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSmokeTest.json" }, tags = { "@vppBlayerSmoke,@vppUlayerSmoke,@agentAppointmentUlayerSmoke,@agentAppointmentBlayerSmoke,@loginAarpSmoke,@loginUHCSmoke,@PharmacyLocatorBlayerSmoke,@pharmacylocatorulayerSmoke" })
public class RunMRATDDSmokeTest {

}