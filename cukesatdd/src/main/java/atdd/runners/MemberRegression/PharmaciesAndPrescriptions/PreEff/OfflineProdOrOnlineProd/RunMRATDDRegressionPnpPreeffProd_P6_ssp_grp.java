package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.PreEff.OfflineProdOrOnlineProd;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionPnpPreeffProd_P6_ssp_grp.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPnpPreeffProd_P6_ssp_grp")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPnpPreeffProd_P6_ssp_grp.json" }, tags = { "@prod_pnpPreEff_ssp_grp" })
public class RunMRATDDRegressionPnpPreeffProd_P6_ssp_grp {

}
