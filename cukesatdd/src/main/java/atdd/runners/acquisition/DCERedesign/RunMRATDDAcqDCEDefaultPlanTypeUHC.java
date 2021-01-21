package atdd.runners.acquisition.DCERedesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEDefaultPlanTypeUHC - Scenario to validate default plan type for Drug summary
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEDefaultPlanTypeUHC.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEDefaultPlanTypeUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEDefaultPlanTypeUHC.json" }, tags = { "@drugSummary_DefaultPlanType_UHC" })


public class RunMRATDDAcqDCEDefaultPlanTypeUHC {

}
