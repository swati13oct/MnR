package atdd.runners.mobile.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionGlobalComponentsShopBlog3UHCmobile.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionGlobalComponentsShopBlog3UHCmobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, 
features = { "src/main/resources/feature/mobile/acquisition/globalComponents" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionGlobalComponentsShopBlog3UHCmobile.json" }, 
tags = { "@ShopBlog_TFN_UHC_10,@ShopBlog_TFN_UHC_11,@ShopBlog_TFN_UHC_12" })

public class RunMRATDDAcquisitionGlobalComponentsShopBlog3UHCmobile {

}
