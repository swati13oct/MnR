package atdd.runners.mobile.acquisition.ole;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionMobileOLESNP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionMobileOLESNP.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true,
 outputFolder = "target/RunMRATDDAcquisitionMobileOLESNP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true, 
features = { "src/main/resources/feature/mobile/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionMobileOLESNP.json" }, 
tags = { "@SNP_OLE_Mobile" })


public class RunMRATDDAcquisitionMobileOLESNP {

}


