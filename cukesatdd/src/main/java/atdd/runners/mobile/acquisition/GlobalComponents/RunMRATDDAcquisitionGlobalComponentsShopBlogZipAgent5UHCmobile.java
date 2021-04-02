package atdd.runners.mobile.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionGlobalComponentsShopBlogZipAgent5UHCmobile.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionGlobalComponentsShopBlogZipAgent5UHCmobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, 
features = { "src/main/resources/feature/mobile/acquisition/globalComponents" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionGlobalComponentsShopBlogZipAgent5UHCmobile.json" }, 
tags = { "@ShopBlog_AgentZip_UHC_9" })

public class RunMRATDDAcquisitionGlobalComponentsShopBlogZipAgent5UHCmobile {

}
