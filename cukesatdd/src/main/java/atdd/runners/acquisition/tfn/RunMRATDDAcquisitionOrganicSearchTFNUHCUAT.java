package atdd.runners.acquisition.tfn;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOrganicSearchTFNUHCUAT
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOrganicSearchTFNUHCUAT.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionOrganicSearchTFNUHCUAT")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = { "src/main/resources/feature/acquisition/tfn/tfn_UAT_Updated/CampaignTFN-OrganicSearch_UHC-UAT.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOrganicSearchTFNUHCUAT.json" }, tags = {"@Scenario3_1_GoogleBingSearch_UHC_UAT,@Scenario_4_1to8_Precedence_1_UHC_UAT"})

public class RunMRATDDAcquisitionOrganicSearchTFNUHCUAT {

}
