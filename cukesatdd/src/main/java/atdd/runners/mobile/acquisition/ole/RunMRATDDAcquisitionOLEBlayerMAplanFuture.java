package atdd.runners.mobile.acquisition.ole;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEBlayerMAplanFuture.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEBlayerMAplanFuture")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },monochrome=true, features = { "src/main/resources/feature/mobile/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEBlayerMAplanFuture.json" }, tags = { "@MA_OLE_UHC_Future" })


public class RunMRATDDAcquisitionOLEBlayerMAplanFuture {

}
