package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Fast and Furious User Stories in Acquisition sites
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDfastandfuriousAcquisitionTest.json",detailedReport = true, 
		detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
		outputFolder = "target/RunMRATDDfastandfuriousAcquisitionTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, 
		features = { "src/main/resources/feature/acquisition" }, 
		plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDfastandfuriousAcquisitionTest.json" }, 
		tags = {"@OLE_VPP_AARP,@OLE_VPP_UHC"})
public class RunMRATDDfastandfuriousAcquisitionTest { 
}