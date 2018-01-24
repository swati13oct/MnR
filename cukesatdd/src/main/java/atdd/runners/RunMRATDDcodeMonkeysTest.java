package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for codeMonkeys with tag id @codeMonkeys
 */


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDcodeMonkeysTest.json",detailedReport = true, detailedAggregatedReport = true, 
	overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDcodeMonkeysTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesign" }, 
features = { "src/main/resources/feature/memberrdesign" }, plugin = {"pretty", "html:reports/test-report", 
		"json:target/cucumber-RunMRATDDcodeMonkeys.json" }, tags = { "@codeMonkeys" })

public class RunMRATDDcodeMonkeysTest {

}
