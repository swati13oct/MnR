package atdd.runners.acquisition.ole;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEMedSupBlayer.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEMedSupBlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome=true,features = { "src/main/resources/feature/acquisition/oleMedSup/MedSupp-OLE-UHC.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEMedSupBlayer.json" }, tags = { "@OLE_Regression" })
public class RunMRATDDAcquisitionOLEMedSupBlayer { 
 
}