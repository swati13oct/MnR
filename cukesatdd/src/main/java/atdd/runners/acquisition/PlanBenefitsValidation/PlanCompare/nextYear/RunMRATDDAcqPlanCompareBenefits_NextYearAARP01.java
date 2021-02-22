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
        jsonReport = "target/cucumber-RunMRATDDAcqPlanCompareBenefits_NextYearAARP01.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        toPDF = true,
        outputFolder = "target/RunMRATDDAcqPlanCompareBenefits_NextYearAARP01")
@CucumberOptions(
        glue = { "atdd.framework", "acceptancetests.acquisition.vpp" },
        monochrome = true,
        features = { "src/main/resources/feature/acquisition/vpp" },
        plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqPlanCompareBenefits_NextYearAARP01.json" },
        tags = { "@next_year","@planCompareBenefits_NextYearAARP01" })
public class RunMRATDDAcqPlanCompareBenefits_NextYearAARP01 {
}