package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.Stage;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDRegressionOTCCTATileOnPnPPageRegressionSTG.json",detailedReport = true, detailedAggregatedReport = true,
		overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionOTCCTATileOnPnPPageRegressionSTG")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
		features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/STAGE/OTCTileOnP&PPage.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionOTCCTATileOnPnPPageRegressionSTG.json" }, tags = { "@STAGERegression" }, monochrome=true)
public class RunMRATDDRegressionOTCCTATileOnPnPPageRegressionSTG {
	
}






