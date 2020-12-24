package atdd.runners.acquisition.DCERedesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCENBAValidationsUHC - Scenario for NBA validations on drug summary Page and details page
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCENBAValidationsUHC.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCENBAValidationsUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCENBAValidationsUHC.json" }, tags = { "@dceNBADrugSummaryPage_UHC,@dceNBADetailPageNBA_MAPD_UHC,@dceNBADetailPageNBA_PDP_UHC,@dceNBADetailPageNBA_SNP_UHC" })
public class RunMRATDDAcqDCENBAValidationsUHC {

}
