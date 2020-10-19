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
jsonReport = "target/cucumber-RunMRATDDSanityChatPROD2.json", detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityChatPROD2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/Chat/ChatPROD.feature" }, plugin = {
		"pretty", "html:reports/test-report","json:target/cucumber-RunMRATDDSanityChatPROD2.json" }, tags = {"@sanityMemberPROD2"})
public class RunMRATDDSanityChatPROD2 {

	
	
	
}
