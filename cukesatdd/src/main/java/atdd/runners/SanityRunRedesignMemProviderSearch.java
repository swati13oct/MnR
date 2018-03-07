package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberrdesignVBF.provider" }, features = { "src/main/resources/feature/member-redesign-vbf/provider-search" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-SanityRunRedesignMemProviderSearch.json" }, tags = { "@smokeTest_ProviderSearch" },monochrome = true)


public class SanityRunRedesignMemProviderSearch {

}
