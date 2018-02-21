/**
 * 
 */
package acceptancetests.deprecated.RSVP.UHCRetiree;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.acquisition.uhcretiree.EatonHomePage;
import pages.acquisition.uhcretiree.IllinoisHomePage;
import pages.acquisition.uhcretiree.MetlifeHomePage;
import pages.acquisition.uhcretiree.NcshpHomePage;
import pages.acquisition.uhcretiree.NokiaHomePage;
import pages.acquisition.uhcretiree.NonCustomHomePage;
import pages.acquisition.uhcretiree.OELocal12HomePage;
import pages.acquisition.uhcretiree.PEEHIPHomePage;
import pages.acquisition.uhcretiree.SalesforceSitePage;
import pages.acquisition.uhcretiree.UHCRetireeSHBPPage;
import pages.acquisition.uhcretiree.UawHomePage;
import pages.acquisition.uhcretiree.UniversityofMissouriHomePage;
import pages.acquisition.uhcretiree.WellsFargohomepage;


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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
