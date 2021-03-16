package atdd.runners.mobile.acquisition.ole;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEUlayerPREFutureMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEUlayerPREFutureMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEUlayerPREFutureMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true, 
features = { "src/main/resources/feature/mobile/acquisition/ole/oleFuture" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEUlayerPREFutureMobile.json" }, 
tags = { "@PRE_E2E_AARP_future" }, dryRun=false)



public class RunMRATDDAcquisitionOLEUlayerPREFutureMobile {

}
