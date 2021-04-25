package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVisitorProfileUlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionVisitorProfileUnAuthenticated.json",detailedReport = true,
		detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVisitorProfileUnAuthenticated")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/visitorProfile/visitorProfile_UnAuthenticated.feature" }, plugin = {
				"pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionVisitorProfileUnAuthenticated.json" }, tags = {
						"@VisitorProfile_AARP" })
public class RunMRATDDAcquisitionVisitorProfileUnAuthenticated { 
 
}
