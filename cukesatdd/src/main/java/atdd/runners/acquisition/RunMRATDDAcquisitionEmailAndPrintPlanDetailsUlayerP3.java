package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Email and Print plan details on VPP 
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP3.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, features = { "src/main/resources/feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP3.json" }, tags = { "@VppEmailandPrintCommon_AARP_3"})//"@emailAndPrint_AARP","@emailAndPrintplanSummary" })
public class RunMRATDDAcquisitionEmailAndPrintPlanDetailsUlayerP3 {
}
