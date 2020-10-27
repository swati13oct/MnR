package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.OfflineProdandProd;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
		jsonReport = "target/cucumber-RunMRATDDRegressionDrugLookupCTATileOnPnPPageRegressionPROD.json",detailedReport = true, detailedAggregatedReport = true,
		overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionDrugLookupCTATileOnPnPPageRegressionPROD")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
		features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions/OfflineProd&Prod/DrugLookupCTATileOnP&PPage.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionDrugLookupCTATileOnPnPPageRegressionPROD.json" }, tags = { "@Sanity" }, monochrome=true)
public class RunMRATDDRegressionDrugLookupCTATileOnPnPPageRegressionPROD {
	
}







