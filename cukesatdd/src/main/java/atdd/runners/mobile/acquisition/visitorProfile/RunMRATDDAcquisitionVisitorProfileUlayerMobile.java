package atdd.runners.mobile.acquisition.visitorProfile;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVisitorProfileUlayerMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionVisitorProfileUlayerMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVisitorProfileUlayerMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = { "src/main/resources/feature/mobile/acquisition/visitorProfile" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionVisitorProfileUlayerMobile.json" }, tags = { "@VisitorProfile_AARP_mobile2" })
public class RunMRATDDAcquisitionVisitorProfileUlayerMobile { 
 
}
