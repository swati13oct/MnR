package atdd.runners.mobile.acquisition.ole;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionMobileOLEMAPD
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionMobileOLEMAPD.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true,
 outputFolder = "target/RunMRATDDAcquisitionMobileOLEMAPD")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true, 
features = { "src/main/resources/feature/mobile/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionMobileOLEMAPD.json" }, 
tags = { "@SNP_OLE_Mobile_MAPD" })


public class RunMRATDDAcquisitionMobileOLEMAPD {

}


