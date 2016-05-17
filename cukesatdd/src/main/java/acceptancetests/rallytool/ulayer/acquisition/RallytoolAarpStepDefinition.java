package acceptancetests.rallytool.ulayer.acquisition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.ulayer.PrivacyPolicyAARPPage;
import pages.acquisition.ulayer.SiteMapAARPPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

public class RallytoolAarpStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	

}
	@Given("^user navigates to the AARP Site Map Page$")
	
	

	public void aarpsitemap() {
		WebDriver wd = getLoginScenario().getWebDriver();
		SiteMapAARPPage siteMapAARPPage = new SiteMapAARPPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.AARP_SITE_MAP_PAGE,
				siteMapAARPPage);
	}
	
	@Then("^user clicks on the Search For a Provider link on AARP Site Map Page and site opens Rally Connect in a new window$")
	
	public void aarpsitemappagerallylink(){
		SiteMapAARPPage siteMapAARPPage  = (SiteMapAARPPage) getLoginScenario()
				.getBean(PageConstants.AARP_SITE_MAP_PAGE);
		Rallytool_Page rallytool = siteMapAARPPage.providerlinkonaarpsitemapClick();
		if(rallytool!= null){
			getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
					rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}

	}
	
	
