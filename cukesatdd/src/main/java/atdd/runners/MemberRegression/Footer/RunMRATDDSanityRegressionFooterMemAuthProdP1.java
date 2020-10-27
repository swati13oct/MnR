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
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDSanityRegressionFooterMemAuthProdP1.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityRegressionFooterMemAuthProdP1")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
        features = { "src/main/resources/feature/memberredesign/footer" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityRegressionFooterMemAuthProdP1.json" }, tags = { "@footer_prodSanity_IndMAPDUHC" })
public class RunMRATDDSanityRegressionFooterMemAuthProdP1 {

}
