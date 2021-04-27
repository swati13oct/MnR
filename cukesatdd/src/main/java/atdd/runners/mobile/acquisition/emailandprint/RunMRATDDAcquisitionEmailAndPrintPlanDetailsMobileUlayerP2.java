package atdd.runners.mobile.acquisition.emailandprint;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Email and Print plan details on VPP 
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsMobileUlayerP2.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionEmailAndPrintPlanDetailsMobileUlayerP2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = { "src/main/resources/feature/mobile/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionEmailAndPrintPlanDetailsMobileUlayerP2.json" }, 
tags = { "@VppEmailandPrintCommon_AARP_1"})//"@emailAndPrint_AARP","@emailAndPrintplanDetails" })
public class RunMRATDDAcquisitionEmailAndPrintPlanDetailsMobileUlayerP2 {
}
