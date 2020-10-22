package atdd.runners.MemberRegression.MyDocuments;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * 
 * @author akapoo18
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityRegressionMyDocuments_MemAuthProd_Regular.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityRegressionMyDocuments_MemAuthProd_Regular")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/myDocuments" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityRegressionMyDocuments_MemAuthProd_Regular.json" }, tags = { "@prodSanity_Individual_MyDocuments" })
public class RunMRATDDSanityRegressionMyDocuments_MemAuthProd_Regular {

}
