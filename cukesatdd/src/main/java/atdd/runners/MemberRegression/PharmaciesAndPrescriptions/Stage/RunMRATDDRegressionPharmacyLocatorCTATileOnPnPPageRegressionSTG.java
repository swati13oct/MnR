package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.Stage;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDRegressionPharmacyLocatorCTATileOnPnPPageRegressionSTG.json",detailedReport = true, detailedAggregatedReport = true,
		overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPharmacyLocatorCTATileOnPnPPageRegressionSTG")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
		features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/STAGE/PharmacyLocatorCTATileOnP&PPage.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPharmacyLocatorCTATileOnPnPPageRegressionSTG.json" }, tags = { "@STAGERegression" }, monochrome=true)
public class RunMRATDDRegressionPharmacyLocatorCTATileOnPnPPageRegressionSTG {
	
}