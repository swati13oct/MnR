package atdd.runners.acquisition.RequestPlanInformation;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCE
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionRequestPlanInformationUlayer.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionRequestPlanInformationUlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/agentflow" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionRequestPlanInformationUlayer.json" }, tags = { "@requestPlanInformationUlayer" })
public class RunMRATDDAcquisitionRequestPlanInformationUlayer { 
 
}
