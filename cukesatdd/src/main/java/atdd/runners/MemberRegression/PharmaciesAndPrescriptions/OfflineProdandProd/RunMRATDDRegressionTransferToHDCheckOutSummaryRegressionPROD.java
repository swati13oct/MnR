package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.OfflineProdandProd;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionTransferToHDCheckOutSummaryRegressionPROD.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionTransferToHDCheckOutSummaryRegressionPROD")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/OfflineProd&Prod/RefillCheckOutSummary.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionTransferToHDCheckOutSummaryRegressionPROD.json" }, tags = { "@Regression" }, monochrome=true)

public class RunMRATDDRegressionTransferToHDCheckOutSummaryRegressionPROD {

}
