package atdd.runners.acquisition.tfn;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOrganicSearchTFNAARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOrganicSearchTFNAARP.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionOrganicSearchTFNAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = { "src/main/resources/feature/acquisition/tfn" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOrganicSearchTFNAARP.json" }, tags = {"@Scenario3_1_GoogleSearch_AARP,@Scenario3_2_BingSearch_AARP,@Scenario3_3_YahooSearch_AARP"})

public class RunMRATDDAcquisitionOrganicSearchTFNAARP {

}
