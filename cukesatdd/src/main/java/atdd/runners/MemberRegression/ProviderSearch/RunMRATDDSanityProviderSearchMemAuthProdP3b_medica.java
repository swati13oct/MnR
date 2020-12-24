package atdd.runners.MemberRegression.ProviderSearch;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityProviderSearchMemAuthProdP3b_medica.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityProviderSearchMemAuthProdP3b_medica")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/providerSearch" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityProviderSearchMemAuthProdP3b_medica.json" }, tags = { "@prod_sanity02","@prod_sanity_providerSearch01_medica_pcp" })
public class RunMRATDDSanityProviderSearchMemAuthProdP3b_medica {

}
