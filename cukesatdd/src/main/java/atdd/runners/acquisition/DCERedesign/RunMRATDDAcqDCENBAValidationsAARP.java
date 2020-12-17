package atdd.runners.acquisition.DCERedesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCENBAValidationsAARP - Scenario for NBA validations on drug summary Page and details page
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCENBAValidationsAARP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCENBAValidationsAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCENBAValidationsAARP.json" }, tags = { "@dceNBADrugSummaryPage_AARP,@dceNBADetailPageNBA_MAPD_AARP,@dceNBADetailPageNBA_PDP_AARP,@dceNBADetailPageNBA_SNP_AARP" })
public class RunMRATDDAcqDCENBAValidationsAARP {

}
