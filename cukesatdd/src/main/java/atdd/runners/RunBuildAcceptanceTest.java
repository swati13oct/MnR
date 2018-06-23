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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunBuildAcceptanceTest.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunBuildAcceptanceTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.vbfacquisition" }, features = { "src/main/resources/feature/vbfacquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunBuildAcceptanceTest.json" }, tags = { "@BAT_CommunityMeetings,@BAT_AgentAppointment,@BAT_acq_pharmacylocator" })
public class RunBuildAcceptanceTest {

	//@BAT_AgentAppointment,@BAT_acq_dce,@BAT_acq_providersearch,@BAT_acq_pharmacylocator,@BAT_CommunityMeetings,
}
