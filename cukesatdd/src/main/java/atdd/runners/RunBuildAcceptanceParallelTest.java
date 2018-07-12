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
@ExtendedCucumberOptions(threadsCount=15, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunBuildAcceptanceParallelTest.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunBuildAcceptanceParallelTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.vbfacquisition" }, features = { "src/main/resources/feature/vbfacquisition" }, plugin = {
		"html:reports/test-report", "json:target/cucumber-RunBuildAcceptanceParallelTest.json" }, tags = { "@globalfooter,@AcqProviderSearchUlayer,@pharmacylocatorblayer,@pharmacylocatorUHC,@OLE_Ulayer,@OLE_UHC,@BAT_CommunityMeetings,@BAT_AgentAppointment" })
public class RunBuildAcceptanceParallelTest {

	//@BAT_acq_dce,@BAT_acq_providersearch,@BAT_acq_pharmacylocator,@BAT_CommunityMeetings,
}
