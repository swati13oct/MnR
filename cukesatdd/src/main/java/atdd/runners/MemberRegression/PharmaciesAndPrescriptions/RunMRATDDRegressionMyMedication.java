package atdd.runners.MemberRegression.PharmaciesAndPrescriptions;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionMyMedication.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMyMedication")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/MyMedication.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionMyMedication.json" }, tags = { "@Testing" }, monochrome =true)
public class RunMRATDDRegressionMyMedication {

}
