package atdd.runners.mobile.acquisition.ole;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEMedSupUlayerMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEMedSupUlayerMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEMedSupUlayerMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" },monochrome=true,
features = { "src/main/resources/feature/mobile/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEMedSupUlayerMobile.json" }, tags = { "@MedSupp_OLE_Common_AARP" },
				dryRun=false)
public class RunMRATDDAcquisitionOLEMedSupUlayerMobile { 
 
}
