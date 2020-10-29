package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.OfflineProdandProd;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDRegressionChangeAddPaymentMethodPROD.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionChangeAddPaymentMethodPROD")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, features = {
		"src/main/resources/feature/memberredesign/pharmaciesandprescriptions/OfflineProd&Prod/ChangeAddPaymentMethod.feature" }, plugin = {
				"pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDRegressionChangeAddPaymentMethodPROD.json" }, tags = {
						"@Regression" }, monochrome = true)
public class RunMRATDDRegressionChangeAddPaymentMethodPROD {

}