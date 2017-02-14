package atdd.mobile.runners;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

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
