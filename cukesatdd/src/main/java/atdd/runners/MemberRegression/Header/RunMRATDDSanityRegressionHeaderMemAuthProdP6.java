package atdd.runners.MemberRegression.Header;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDSanityRegressionHeaderMemAuthProdP6.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityRegressionHeaderMemAuthProdP6")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
        features = { "src/main/resources/feature/memberredesign/header" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityRegressionHeaderMemAuthProdP6.json" }, tags = { "@header_prodSanity_Terminated" })
public class RunMRATDDSanityRegressionHeaderMemAuthProdP6 {

}
