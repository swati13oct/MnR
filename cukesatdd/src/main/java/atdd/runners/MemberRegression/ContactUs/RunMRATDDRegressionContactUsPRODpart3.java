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
jsonReport = "target/cucumber-RunMRATDDRegressionContactUsPRODpart3.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionContactUsPRODpart3")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome=true,
features = { "src/main/resources/feature/memberredesign/contactus/ContactUsPROD.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionContactUsPRODpart3.json" }, tags = { "@regressionMemberPROD3" })
public class RunMRATDDRegressionContactUsPRODpart3 {

}
