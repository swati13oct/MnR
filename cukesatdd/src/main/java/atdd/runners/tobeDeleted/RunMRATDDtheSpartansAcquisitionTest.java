package atdd.runners.tobeDeleted;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * For Acquisition only
 * this file is to run test cases for spartans team with tag id @theSpartans
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDtheSpartansAcquisitionTest.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDtheSpartansAcquisitionTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, 
features = { "src/main/resources/feature/acquisition" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDtheSpartansAcquisitionTest.json" }, tags = { "@F365255" })
public class RunMRATDDtheSpartansAcquisitionTest {

}
