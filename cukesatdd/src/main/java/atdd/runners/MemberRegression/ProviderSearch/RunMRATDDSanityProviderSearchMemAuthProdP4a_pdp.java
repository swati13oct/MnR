package atdd.runners.MemberRegression.ProviderSearch;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityProviderSearchMemAuthProdP4a_pdp.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityProviderSearchMemAuthProdP4a_pdp")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/providerSearch" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityProviderSearchMemAuthProdP4a_pdp.json" }, tags = { "@prod_sanity01","@prod_providerSearch01_pdp" })
public class RunMRATDDSanityProviderSearchMemAuthProdP4a_pdp {

}
