package atdd.runners.mobile.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionGlobalComponentsMedEd2AARPMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionGlobalComponentsMedEd2AARPMobile.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionGlobalComponentsMedEd2AARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, features = { "src/main/resources/feature/mobile/acquisition/globalComponents" },
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionGlobalComponentsMedEd2AARPMobile.json" }, tags = { "@MedEdPages_2_GlobalCompsAARP" })
public class RunMRATDDAcquisitionGlobalComponentsMedEd2AARPMobile {

}
