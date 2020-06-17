package atdd.runners.MemberRegression.Profile;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 *
 * @author Tamzid
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDRegressionProfileP12_MemAuthProd.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionProfileP12_MemAuthProd")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
        features = { "src/main/resources/feature/memberredesign/profileandpreferences/" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionProfileP12_MemAuthProd.json" }, tags = { "@prod_accountProfile12" })


public class RunMRATDDRegressionProfileP12_MemAuthProd {

}
