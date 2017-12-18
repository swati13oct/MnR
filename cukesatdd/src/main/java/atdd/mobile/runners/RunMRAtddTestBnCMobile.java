package atdd.mobile.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * Created by ayifru on 9/7/2016.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoveragemobile" },
        features = { "feature/plan-benefits-and-coverage.mobile" },
        format = {
                "pretty", "html:reports/test-report" }, tags ={"@bnc-mobile"})

public class RunMRAtddTestBnCMobile {
}
