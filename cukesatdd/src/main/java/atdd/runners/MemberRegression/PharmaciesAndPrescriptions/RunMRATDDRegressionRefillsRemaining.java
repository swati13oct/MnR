package atdd.runners.MemberRegression.PharmaciesAndPrescriptions;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionRefillsRemaining.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionRefillsRemaining")
@CucumberOptions(
glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/RefillsRemaining.feature" },
plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionRefillsRemaining.json" },
tags = { "@F479509" }, monochrome =true)
public class RunMRATDDRegressionRefillsRemaining {

}
