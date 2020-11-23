package atdd.runners.MemberRegression;

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
jsonReport = "target/cucumber-RunMRATDDRegressionOfflineProdeeplink.json", detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionOfflineProdeeplink")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/HSID/offlinePRODdeeplinkSignin.feature" }, plugin = {
		"pretty", "html:reports/test-report","json:target/cucumber-RunMRATDDRegressionOfflineProdeeplink.json" }, tags = { "@regressionMemberPROD" })
public class RunMRATDDRegressionOfflineProdeeplink {

	
	
	
}
