/**
 * 
 */
package acceptancetests.UHCRetiree;

import java.io.File;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.OurPlansPage;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.DrugDetailsPage;
import pages.acquisition.uhcretiree.EnterDrugPage;
import pages.acquisition.uhcretiree.SelectDosagePage;
import pages.acquisition.uhcretiree.SelectFormularyPage;
import pages.acquisition.uhcretiree.UHCRetireeSiteMapPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dceretiree.data.DCERetireeCommonConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import acceptancetests.lookupzipcode.data.ZipLookupCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en_au.When;


/**
 * @author naggarw2
 *
 */


public class UHCRetireeStepDefinition {



	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	} 


	@Given("^user navigates to the UHCRetiree Site Map Page$")
	
	public void click_drugsearch() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage uhcRetireeAcqHomePage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE, uhcRetireeAcqHomePage);
	}
	
	
	
	
	
}