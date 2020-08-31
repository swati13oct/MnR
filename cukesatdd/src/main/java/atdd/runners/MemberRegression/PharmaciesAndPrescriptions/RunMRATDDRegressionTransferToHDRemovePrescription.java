package atdd.runners.MemberRegression.PharmaciesAndPrescriptions;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionTransferToHDRemovePrescription.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionTransferToHDRemovePrescription")
@CucumberOptions(
glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions" },
plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionTransferToHDRemovePrescription.json" },
tags = { "@F484059" }, monochrome =true)
public class RunMRATDDRegressionTransferToHDRemovePrescription {

}
