package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Email and Print plan details on VPP 
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsBlayerP3.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionEmailAndPrintPlanDetailsBlayerP3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsBlayerP3.json" }, tags = { "@VppEmailandPrintCommon_UHC_3"})//"@emailAndPrint_UHC","@emailAndPrintplanSummary" })
public class RunMRATDDAcquisitionEmailAndPrintPlanDetailsBlayerP3 {
}
