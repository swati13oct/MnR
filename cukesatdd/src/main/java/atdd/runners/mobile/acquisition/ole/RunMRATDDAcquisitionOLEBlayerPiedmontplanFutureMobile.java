package atdd.runners.mobile.acquisition.ole;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayerPiedmontplanFutureMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEBlayerPiedmontplanFutureMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEBlayerPiedmontplanFutureMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true, features = { "src/main/resources/feature/mobile/acquisition/ole/oleFuture" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEBlayerPiedmontplanFutureMobile.json" }, 
tags = { "@Piedmont_OLE_UHC_Future" }, dryRun=false)



public class RunMRATDDAcquisitionOLEBlayerPiedmontplanFutureMobile {

}
