package atdd.runners.mobile.acquisition.ole;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayerSNPplanFutureMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEBlayerSNPplanFutureMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEBlayerSNPplanFutureMobile")

@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true, 
features = { "src/main/resources/feature/mobile/acquisition/ole/oleFuture/OLE-PlanSummary-SNP.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEBlayerSNPplanFutureMobile.json" }, 
tags = { "@SNP_OLE_UHC_Future" }, dryRun=false)



public class RunMRATDDAcquisitionOLEBlayerSNPplanFutureMobile {

}
