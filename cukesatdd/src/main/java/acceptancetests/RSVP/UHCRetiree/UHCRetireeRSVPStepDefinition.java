/**
 * 
 */
package acceptancetests.RSVP.UHCRetiree;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.selenium.Wait.WaitTimedOutException;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.AlcatelLucentFindProviderPage;
import pages.acquisition.uhcretiree.AlcatelLucentHomePage;
import pages.acquisition.uhcretiree.AlcatelLucentSiteMapPage;
import pages.acquisition.uhcretiree.CalperFindaProviderPage;
import pages.acquisition.uhcretiree.CalpersHomePage;
import pages.acquisition.uhcretiree.CalpersSiteMapPage;
import pages.acquisition.uhcretiree.EatonHomePage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonHomePage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonProviderPage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonSiteMapPage;
import pages.acquisition.uhcretiree.NokiaHomePage;
import pages.acquisition.uhcretiree.SalesforceSitePage;
import pages.acquisition.uhcretiree.SdceraFindaProviderPage;
import pages.acquisition.uhcretiree.SdceraHomePage;
import pages.acquisition.uhcretiree.SdceraSiteMapPage;
import pages.acquisition.uhcretiree.MetlifeFindaProviderPage;
import pages.acquisition.uhcretiree.MetlifeHomePage;
import pages.acquisition.uhcretiree.MetlifeSiteMapPage;
import pages.acquisition.uhcretiree.KTRSFindaProviderPage;
import pages.acquisition.uhcretiree.KTRSHomePage;
import pages.acquisition.uhcretiree.KTRSSiteMapPage;
import pages.acquisition.uhcretiree.PfizerFindaProviderPage;
import pages.acquisition.uhcretiree.PfizerHomePage;
import pages.acquisition.uhcretiree.PfizerSiteMapPage;
import pages.acquisition.uhcretiree.NcshpFindaProviderPage;
import pages.acquisition.uhcretiree.NcshpHomePage;
import pages.acquisition.uhcretiree.NcshpSiteMapPage;
import pages.acquisition.uhcretiree.OehwfSiteMap;
import pages.acquisition.uhcretiree.RallyToolPage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.uhcretiree.SiteMapASRSPage;
import pages.acquisition.uhcretiree.SiteMapSHBPPage;
import pages.acquisition.uhcretiree.TravelersSiteMap;
import pages.acquisition.uhcretiree.UHCRetireeASRSPage;
import pages.acquisition.uhcretiree.UHCRetireeASRSProviderPage;
import pages.acquisition.uhcretiree.UHCRetireeEdisionProviderPage;
import pages.acquisition.uhcretiree.UHCRetireeEdisonPage;
import pages.acquisition.uhcretiree.UHCRetireeEdisonSiteMap;
import pages.acquisition.uhcretiree.UHCRetireeOehwfHomePage;
import pages.acquisition.uhcretiree.UHCRetireeSHBPPage;
import pages.acquisition.uhcretiree.UHCRetireeSHBPProviderPage;
import pages.acquisition.uhcretiree.UHCRetireeSiteMapPage;
import pages.acquisition.uhcretiree.UHCRetireeTravelersHomePage;
import pages.acquisition.uhcretiree.UawHomePage;
import pages.acquisition.uhcretiree.UawProviderPage;
import pages.acquisition.uhcretiree.UawSiteMapPage;
import pages.acquisition.uhcretiree.VerizonHomePage;
import pages.acquisition.uhcretiree.VerizonSiteMap;
import pages.acquisition.uhcretiree.VerizonUhcretireePage;
import pages.acquisition.uhcretiree.IllinoisFindaProviderPage;
import pages.acquisition.uhcretiree.IllinoisHomePage;
import pages.acquisition.uhcretiree.IllinoisSiteMapPage;
import pages.acquisition.uhcretiree.SanFranciscoHomePage;
import pages.acquisition.uhcretiree.SanfranciscoFindaProviderPage;
import pages.acquisition.uhcretiree.SannFranciscoSiteMapPage;
import pages.acquisition.ulayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;


/**
 * @author F&F
 *
 */


public class UHCRetireeRSVPStepDefinition {



	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	} 
	
	
	@Given("^user navigates to the Nokia Home Page$")

	public void nokiahomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		NokiaHomePage nokiahomepages = new NokiaHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.NOKIA_HOME_PAGE, nokiahomepages);

	}
	
	@Then("user clicks on get started button on RSVP tracker")
	
	public void RSVPNokia() {
		
		NokiaHomePage nokiahomepages = (NokiaHomePage)getLoginScenario().getBean(PageConstants.NOKIA_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = nokiahomepages.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}
	
	@Given("^user navigates to the Eaton Home Page$")

	public void eatonhomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		EatonHomePage eatonhomepages = new EatonHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.EATON_HOME_PAGE, eatonhomepages);

	}
	
	@Then("user clicks on get started button on RSVP tracker for Eaton group")
	
	public void RSVPEaton() {
		
		EatonHomePage eatonhomepages = (EatonHomePage)getLoginScenario().getBean(PageConstants.EATON_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = eatonhomepages.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}
		
		
	@Given("^user navigates to the SHBP Home Page$")

	public void SHBPhomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		UHCRetireeSHBPPage uhcRetireeAcqSHBPPage = new UHCRetireeSHBPPage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SHBP_PAGE, uhcRetireeAcqSHBPPage);

	}
	
	@Then("user clicks on get started button on RSVP tracker for SHBP group")
	
	public void RSVPSHBP() {
		
		UHCRetireeSHBPPage uhcRetireeAcqSHBPPage = (UHCRetireeSHBPPage)getLoginScenario().getBean(PageConstants.UHCRETIREE_ACQ_SHBP_PAGE);
		
		
		SalesforceSitePage salesforce = uhcRetireeAcqSHBPPage.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
