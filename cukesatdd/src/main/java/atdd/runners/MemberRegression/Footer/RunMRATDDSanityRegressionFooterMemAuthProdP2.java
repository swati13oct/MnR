package atdd.runners.MemberRegression.Footer;

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
        jsonReport = "target/cucumber-RunMRATDDSanityRegressionFooterMemAuthProdP2.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityRegressionFooterMemAuthProdP2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
        features = { "src/main/resources/feature/memberredesign/header" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityRegressionFooterMemAuthProdP2.json" }, tags = { "@footer_prodSanity_SHIP" })
public class RunMRATDDSanityRegressionFooterMemAuthProdP2 {

}
