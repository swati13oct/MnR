package atdd.runners.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionHeader
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionHeaderAARP.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionHeaderAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/globalComponents" }, plugin = {
<<<<<<< HEAD
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionHeaderAARP.json" }, tags = { "@globalheaderULayer" })
=======
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionHeaderAARP.json" }, tags = { "@globalheader_AARP" })
>>>>>>> branch 'feature-F513647' of https://github.optum.com/Consumer-Portals/MRATDD.git
public class RunMRATDDAcquisitionHeaderAARP {

}
