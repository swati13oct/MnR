package atdd.runners.uhcretiree;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ayifru on 9/7/2016.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.UHCRetiree.PharmacyLocator" },
        features = { "feature/uhc-retiree" },
        format = {
                "pretty", "html:reports/test-report" ,"json:target/RunMRAtddTestUHCRetireePharmacyLocator-cucumber.json" }, tags ={"@pharmacylocator"})

public class RunMRAtddTestUHCRetireePharmacyLocator {
}
