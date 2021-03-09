package atdd.runners.mobile.acquisition.ole;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEUlayerStandaloneFutureMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEUlayerStandaloneFutureMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
 outputFolder = "target/RunMRATDDAcquisitionOLEUlayerStandaloneFutureMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },
monochrome=true, features = { "src/main/resources/feature/mobile/acquisition/ole" }, 
plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEUlayerStandaloneFutureMobile.json" }, 
tags = { "@MA_OLE_Ulayer_standaloneFuture" }, dryRun=false)



public class RunMRATDDAcquisitionOLEUlayerStandaloneFutureMobile {

}
