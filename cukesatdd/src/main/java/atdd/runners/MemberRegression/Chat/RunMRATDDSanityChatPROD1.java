package atdd.runners.MemberRegression.Chat;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author pminhas
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", 
jsonReport = "target/cucumber-RunMRATDDSanityChatPROD1.json", detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityChatPROD1")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/Chat/ChatPROD.feature" }, plugin = {
		"pretty", "html:reports/test-report","json:target/cucumber-RunMRATDDSanityChatPROD1.json" }, tags = {"@sanityMemberPROD1"})
public class RunMRATDDSanityChatPROD1 {

	
	
	
}
