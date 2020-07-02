package atdd.runners.MemberRegression.ContactUs;

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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionContactUsPart3.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionContactUsPart3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome=true,
features = { "src/main/resources/feature/memberredesign/contactu/ContactUsStage/ContactUsStagePart3.features" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionContactUsPart3.json" }, tags = { "@regressionMember" })
public class RunMRATDDRegressionContactUsPart3 {

}
