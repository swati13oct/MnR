package acceptancetests.acquisition.pharmacylocator;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;

public class PharmacySearchCommonStepDefinitionNew {

    @Autowired
    MRScenario loginScenario;
    String langName;

    public MRScenario getLoginScenario() {
        return loginScenario;
    }

    /** user is on the AARP Medicare Site landing page */
    @And("^the user navigate to pharmacy search page from the navigation bar$")
    public void userNavigatesToPharmacySearchPage() {
        AcquisitionHomePage aquisitionhomepage= (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
        WebDriver wd = ( WebDriver)getLoginScenario().getBean(CommonConstants.WEBDRIVER);
        System.out.println("Unselected state on home page for more predictable result");
        String testSiteUrl = aquisitionhomepage.getTestSiteUrl();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        PharmacySearchPage pharmacySearchPage = aquisitionhomepage.navigateToPharmacyLocator();
        getLoginScenario().saveBean(PageConstants.TEST_SITE_URL, testSiteUrl);
        getLoginScenario().saveBean(PharmacySearchCommonConstants.PHARMACY_LOCATOR_PAGE, pharmacySearchPage);
    }

}
