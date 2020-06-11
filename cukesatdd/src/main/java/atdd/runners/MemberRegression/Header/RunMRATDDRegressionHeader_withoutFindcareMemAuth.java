package atdd.runners.MemberRegression.Header;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 *
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDRegressionHeader_withoutFindcareMemAuth.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionHeader_withoutFindcareMemAuth")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
        features = { "src/main/resources/feature/memberredesign/header" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionHeader_withoutFindcareMemAuth.json" }, tags = { "@memAuth_header05, @no_findcareheader_MemAuth" })
public class RunMRATDDRegressionHeader_withoutFindcareMemAuth {

}
