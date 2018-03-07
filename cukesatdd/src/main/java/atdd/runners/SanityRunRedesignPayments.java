package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF.payments" }, features = { "src/main/resources/feature/member-redesign-vbf/payment" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-SanityRunRedesignPayments.json" }, tags = { "@smokeTest_Payment" },monochrome = true)

public class SanityRunRedesignPayments {

}
