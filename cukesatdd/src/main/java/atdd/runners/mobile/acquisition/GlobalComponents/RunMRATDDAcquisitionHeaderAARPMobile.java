package atdd.runners.mobile.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionHeaderAARPMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionHeaderAARPMobile.json",detailedReport = true, 
detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionHeaderAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition"  }, 
features = { "src/main/resources/feature/mobile/acquisition/globalComponents" }, plugin = {
				"pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionHeaderAARPMobile.json" }, tags = { "@globalheader_AARP" })
public class RunMRATDDAcquisitionHeaderAARPMobile {

}
