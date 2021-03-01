package atdd.runners.AEM;

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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDCQPages.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDCQPages")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests/AEM" }, features = { "src/main/resources/feature/AEM" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDCQPages.json" }, tags = { "@CQMemberPages,@CQAcqPages" })
public class RunMRATDDCQPages {

}
