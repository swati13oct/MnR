package atdd.runners.acquisition.tfn;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionCampaignTFNExternalAARPUAT
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionCampaignTFNExternalAARPUAT.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionCampaignTFNExternalAARPUAT")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = { "src/main/resources/feature/acquisition/tfn/tfn_UAT_Updated/CampaignTFN-AARP-UAT.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionCampaignTFNExternalAARPUAT.json" }, tags = {"@Scenario_1_2_DirectTraffic_Email_UAT,@Scenario_9_External_Link_UAT,@Scenario_8_External_Link_PDP_UAT"})

public class RunMRATDDAcquisitionCampaignTFNExternalAARPUAT {

}
