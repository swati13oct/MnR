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
jsonReport = "target/cucumber-RunMRATDDSanityBrandingPROD1.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityBrandingPROD1")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/branding" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityBrandingPROD1.json" }, tags = { "@sanityMemberPROD1" })
public class RunMRATDDSanityBrandingPROD1 {

}