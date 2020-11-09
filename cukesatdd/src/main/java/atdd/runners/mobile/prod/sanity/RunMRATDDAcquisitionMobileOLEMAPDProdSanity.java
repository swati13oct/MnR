package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionMobileOLEMAPDProdSanity
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionMobileOLEMAPDProdSanity.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true,
 outputFolder = "target/RunMRATDDAcquisitionMobileOLEMAPDProdSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true, 
features = { "src/main/resources/feature/mobile/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionMobileOLEMAPDProdSanity.json" }, 
tags = { "@SNP_OLE_Mobile_MAPD" })


public class RunMRATDDAcquisitionMobileOLEMAPDProdSanity {

}


