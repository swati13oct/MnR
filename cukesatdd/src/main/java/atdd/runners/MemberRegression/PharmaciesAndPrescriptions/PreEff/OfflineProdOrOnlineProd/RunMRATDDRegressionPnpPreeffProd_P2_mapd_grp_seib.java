package atdd.runners.MemberRegression.PharmaciesAndPrescriptions.PreEff.OfflineProdOrOnlineProd;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionPnpPreeffProd_P2_mapd_grp_seib.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPnpPreeffProd_P2_mapd_grp_seib")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/pharmaciesandprescriptions" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPnpPreeffProd_P2_mapd_grp_seib.json" }, tags = { "@prod_pnpPreEff_mapd_grp_seib" })
public class RunMRATDDRegressionPnpPreeffProd_P2_mapd_grp_seib {

}
