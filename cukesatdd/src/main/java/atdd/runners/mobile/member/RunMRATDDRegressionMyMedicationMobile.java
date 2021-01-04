package atdd.runners.mobile.member;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionMyMedicationMobile.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMyMedicationMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionMyMedicationMobile.json" }, tags = { "@F448402_Mobile" }, monochrome =true)
public class RunMRATDDRegressionMyMedicationMobile {

}
