package atdd.runners.acquisition.DCERedesign;


import org.junit.runner.RunWith;		


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqDCEUATscenario1AARP - Scenario to validate UAT end-2-end scenario1 for DCE on AARP site
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqDCEUATscenario1AARP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqDCEUATscenario1AARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqDCEUATscenario1AARP.json" }, tags = { "@DCE_E2E_Scenario1_UAT_AARP" })

public class RunMRATDDAcqDCEUATscenario1AARP {

}
