package atdd.runners.acquisition.tfn;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOrganicSearchTFNAARPUAT
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOrganicSearchTFNAARPUAT.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionOrganicSearchTFNAARPUAT")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = { "src/main/resources/feature/acquisition/tfn/tfn_UAT_Updated/CampaignTFN-OrganicSearch_AARP-UAT.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOrganicSearchTFNAARPUAT.json" }, tags = {"@Scenario3_1_GoogleBingSearch_AARP_UAT,@Scenario_5_1to8_Precedence_1_AARP_UAT,@Scenario4_1_ExternalLink_AARP_UAT"})

public class RunMRATDDAcquisitionOrganicSearchTFNAARPUAT {

}
