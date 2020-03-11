package atdd.runners.tobeDeleted;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for velocityDashers team with tag id @velocityDashers
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDvelocityDashersTest.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDvelocityDashersTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/contactus" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDvelocityDashersTest.json" }, tags = { "@TFNforTechSupport" })
public class RunMRATDDvelocityDashersTest {

}