package atdd.runners.MemberRegression.Profile;


import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *
 * @author Tamzid
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDSanityRegressionProfileMemAuthProdP1.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityRegressionProfileMemAuthProdP1")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
        features = { "src/main/resources/feature/memberredesign/profileandpreferences/" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityRegressionProfileMemAuthProdP1.json" }, tags = { "@prodSanity_MAPD_Groups" })


public class RunMRATDDSanityRegressionProfileMemAuthProdP1 {

}
