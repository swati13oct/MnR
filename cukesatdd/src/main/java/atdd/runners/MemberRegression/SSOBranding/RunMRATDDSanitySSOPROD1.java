package atdd.runners.MemberRegression.SSOBranding;

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
jsonReport = "target/cucumber-RunMRATDDSanitySSOPROD1.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanitySSOPROD1")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 

features = { "src/main/resources/feature/memberredesign/sso" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanitySSOPROD1.json" }, tags = { "@sanityMemberPROD" })
public class RunMRATDDSanitySSOPROD1 {

}