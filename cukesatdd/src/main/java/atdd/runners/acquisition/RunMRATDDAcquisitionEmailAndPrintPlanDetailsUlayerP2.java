package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Email and Print plan details on VPP 
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP2.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP2.json" }, tags = { "@VppEmailandPrintCommon_AARP_2"})//"@emailAndPrint_AARP","@emailAndPrintplanDetails" })
public class RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP2 {
}
