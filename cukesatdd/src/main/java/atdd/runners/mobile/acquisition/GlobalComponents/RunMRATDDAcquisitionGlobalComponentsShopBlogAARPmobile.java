package atdd.runners.mobile.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionGlobalComponentsShopBlogAARPmobile.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionGlobalComponentsShopBlogAARPmobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, 
features = { "src/main/resources/feature/mobile/acquisition/globalComponents" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionGlobalComponentsShopBlogAARPmobile.json" }, 
tags = { "@ShopBlog_TFN_AARP_1,@ShopBlog_TFN_AARP_2,@ShopBlog_TFN_AARP_3" })

public class RunMRATDDAcquisitionGlobalComponentsShopBlogAARPmobile {

}
