package atdd.runners.acquisition.PlanBenefitsValidation.PlanCompare.nextYear;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * this file is to run plan benefits validations on plan Compare page
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(
        retryCount=0,
        screenShotSize="",
        screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDAcqPlanCompareBenefits_NextYear_AARP_ProdCheckout_2.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        toPDF = true,
        outputFolder = "target/RunMRATDDAcqPlanCompareBenefits_NextYear_AARP_ProdCheckout_2")
@CucumberOptions(
        glue = { "atdd.framework", "acceptancetests.acquisition.vpp" },
        monochrome = true,
        features = { "src/main/resources/feature/acquisition/vpp" },
        plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanCompareBenefits_NextYear_AARP_ProdCheckout_2.json" },
        tags = {"@planCompareBenefits_NextYear_AARP_ProdCheckout_2" })
public class RunMRATDDAcqPlanCompareBenefits_NextYear_AARP_ProdCheckout_2 {
}
