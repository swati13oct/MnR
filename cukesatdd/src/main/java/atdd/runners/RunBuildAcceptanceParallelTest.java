package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedParallelCucumber;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedParallelCucumber.class)
@ExtendedCucumberOptions(threadsCount=15, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunBuildAcceptanceTest.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunBuildAcceptanceTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisitionvbf" }, features = { "src/main/resources/feature/acquisitionvbf" }, plugin = {
		"html:reports/test-report", "json:target/cucumber-RunBuildAcceptanceTest.json" }, tags = { "@BAT_CommunityMeetings,@BAT_AgentAppointment,@BAT_acq_providersearch,@BAT_acq_pharmacylocator" })
public class RunBuildAcceptanceParallelTest {

	//@BAT_acq_dce,@BAT_acq_providersearch,@BAT_acq_pharmacylocator,@BAT_CommunityMeetings,
}