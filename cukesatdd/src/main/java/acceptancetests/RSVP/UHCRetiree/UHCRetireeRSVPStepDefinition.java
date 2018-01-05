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
import pages.acquisition.uhcretiree.NonCustomHomePage;
import pages.acquisition.uhcretiree.OELocal12HomePage;
import pages.acquisition.uhcretiree.PEEHIPHomePage;
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
import pages.acquisition.uhcretiree.UniversityofMissouriHomePage;
import pages.acquisition.uhcretiree.VerizonHomePage;
import pages.acquisition.uhcretiree.VerizonSiteMap;
import pages.acquisition.uhcretiree.VerizonUhcretireePage;
import pages.acquisition.uhcretiree.IllinoisFindaProviderPage;
import pages.acquisition.uhcretiree.IllinoisHomePage;
import pages.acquisition.uhcretiree.IllinoisSiteMapPage;
import pages.acquisition.uhcretiree.SanFranciscoHomePage;
import pages.acquisition.uhcretiree.SanfranciscoFindaProviderPage;
import pages.acquisition.uhcretiree.SannFranciscoSiteMapPage;
import pages.acquisition.uhcretiree.WellsFargohomepage;
import pages.acquisition.ulayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


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
		
	@Given("^user navigates to the NCSHP Home Page$")

	public void NCSHPhomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		NcshpHomePage ncshp = new NcshpHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.NCSHP_HOME_PAGE, ncshp);

	}
	
	@Then("user clicks on get started button on RSVP tracker for NCSHP group")
	
	public void RSVPNcshp() {
		
		NcshpHomePage ncshp = (NcshpHomePage)getLoginScenario().getBean(PageConstants.NCSHP_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = ncshp.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
		
	@Given("^user navigates to the OELocal12 Home Page$")

	public void OELocal12homepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		OELocal12HomePage oelocal12 = new OELocal12HomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.OELOCAL12_HOME_PAGE, oelocal12);

	}
	
	@Then("user clicks on get started button on RSVP tracker for OELocal12 group")
	
	public void RSVPOELocal12() {
		
		OELocal12HomePage oelocal12 = (OELocal12HomePage)getLoginScenario().getBean(PageConstants.OELOCAL12_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = oelocal12.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
	
	@Given("^user navigates to the PEEHIP Home Page$")

	public void PEEHIPhomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		PEEHIPHomePage peehip = new PEEHIPHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.PEEHIP_HOME_PAGE, peehip);

	}
	
	@Then("user clicks on get started button on RSVP tracker for OELocal12 group")
	
	public void RSVPPEEHIP() {
		
		PEEHIPHomePage peehip = (PEEHIPHomePage)getLoginScenario().getBean(PageConstants.PEEHIP_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = peehip.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
			
	@Given("^user navigates to the NonCustom Home Page$")

	public void NonCustomhomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		NonCustomHomePage noncustom = new NonCustomHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.NONCUSTOM_HOME_PAGE, noncustom);

	}
	
	@Then("user clicks on get started button on RSVP tracker for NonCustom group")
	
	public void RSVPNONCUSTOM() {
		
		NonCustomHomePage peehip = (NonCustomHomePage)getLoginScenario().getBean(PageConstants.PEEHIP_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = peehip.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
		
	@Given("^user navigates to the UniversityofMissouri Home Page$")

	public void UniversityofMissourihomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		UniversityofMissouriHomePage UniversityofMissouri = new UniversityofMissouriHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.UNIVERSITYOFMISSOURI_HOME_PAGE, UniversityofMissouri);

	}
	
	@Then("user clicks on get started button on RSVP tracker for UniversityofMissouri group")
	
	public void RSVPUMSYSTEM() {
		
		UniversityofMissouriHomePage UniversityofMissouri = (UniversityofMissouriHomePage)getLoginScenario().getBean(PageConstants.UNIVERSITYOFMISSOURI_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = UniversityofMissouri.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
	
	@Given("^user navigates to the UAW Home Page$")

	public void UAWhomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		UawHomePage uawhomepage = new UawHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.UAW_HOME_PAGE, uawhomepage);

	}
	
	@Then("user clicks on get started button on RSVP tracker for UAW group")
	
	public void RSVPUAW() {
		
		UawHomePage UniversityofMissouri = (UawHomePage)getLoginScenario().getBean(PageConstants.UAW_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = UniversityofMissouri.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
	
	@Given("^user navigates to the Wells Fargo Home Page$")

	public void WellsFargohomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		WellsFargohomepage wellsfargopage = new WellsFargohomepage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.WELLSFARGO_HOME_PAGE, wellsfargopage);

	}
	
	@Then("user clicks on get started button on RSVP tracker for Wells Fargo group")
	
	public void RSVPWellsFargo() {
		
		WellsFargohomepage wellsfargopage = (WellsFargohomepage)getLoginScenario().getBean(PageConstants.WELLSFARGO_HOME_PAGE);
		
		
		SalesforceSitePage salesforce = wellsfargopage.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
	
	@Given("^user navigates to the Illinios Home Page$")

	public void Illinioshomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		IllinoisHomePage illinois = new IllinoisHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.ILLINOIS_HOME_PAGE, illinois);

	}
	
	@Then("user clicks on get started button on RSVP tracker for Illinios group")
	
	public void RSVPIllinios() {
		
		IllinoisHomePage illinois = (IllinoisHomePage)getLoginScenario().getBean(PageConstants.ILLINOIS_HOME_PAGE);
			
		SalesforceSitePage salesforce = illinois.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
	
	
	@Given("^user navigates to the Metlife Home Page$")

	public void Metlifehomepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		MetlifeHomePage metlife = new MetlifeHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.METLIFE_HOME_PAGE, metlife);

	}
	
	@Then("user clicks on get started button on RSVP tracker for Metlife group")
	
	public void RSVPMetlife() {
		
		MetlifeHomePage metlife = (MetlifeHomePage)getLoginScenario().getBean(PageConstants.METLIFE_HOME_PAGE);
			
		SalesforceSitePage salesforce = metlife.clickgetstarted();
		
		if(salesforce!= null){
			getLoginScenario().saveBean(PageConstants.Salesforce_PAGE,
					salesforce);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
