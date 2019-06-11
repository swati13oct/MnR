package atdd.runners.Feature_ATDD;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author jkuma14
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunFeatureATDDMemberRedesignPreEffective.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunFeatureATDDMemberRedesignPreEffective")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/preEffective" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunFeatureATDDMemberRedesignPreEffective.json" }, tags = { "@preEffectiveVBF" })
public class RunFeatureATDDMemberRedesignPreEffective {

}
