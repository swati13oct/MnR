package atdd.runners.MemberRegression.guestPayments;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 *
 * @author akapoo18
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDRegressionGuestPaymentsP11.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionGuestPaymentsP11")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
        features = { "src/main/resources/feature/memberredesign/guestPayments" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionGuestPaymentsP11.json" }, tags = { "@guestPayment11" })
public class RunMRATDDRegressionGuestPaymentsP11 {

}
