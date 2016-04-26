/**
 * 
 */
package acceptancetests.UHCRetiree;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.CalperFindaProviderPage;
import pages.acquisition.uhcretiree.CalpersHomePage;
import pages.acquisition.uhcretiree.CalpersSiteMapPage;
import pages.acquisition.uhcretiree.OehwfSiteMap;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.uhcretiree.TravelersSiteMap;
import pages.acquisition.uhcretiree.UHCRetireeOehwfHomePage;
import pages.acquisition.uhcretiree.UHCRetireeTravelersHomePage;
import pages.acquisition.uhcretiree.VerizonHomePage;
import pages.acquisition.uhcretiree.VerizonSiteMap;
import pages.acquisition.uhcretiree.VerizonUhcretireePage;
import pages.acquisition.ulayer.LoginAssistancePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;


/**
 * @author F&F
 *
 */


public class UHCRetireeStepDefinition {



	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	} 


	@Given("^user navigates to the UHCRetiree Home Page$")

	public void uhcretiree_homepage() {
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage uhcRetireeAcqHomePage = new AcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE, uhcRetireeAcqHomePage);
	}



	@Then("^user clicks on the Look up my provider link and site opens new provider search tool in a new window$")

	public void click_lookupprovider() {
		AcquisitionHomePage uhcRetireeAcqHomePage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);


		Rallytool_Page rallytool = uhcRetireeAcqHomePage.lookupproviderclick();
		if(rallytool!= null){
			getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
					rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}
	}

		@And("^user navigates to the Verizon find a Provider Page$")

	public void verizonfindprovider() {
			WebDriver wd = getLoginScenario().getWebDriver();
			VerizonUhcretireePage verizonproviderpage = new VerizonUhcretireePage(wd);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


			getLoginScenario().saveBean(PageConstants.VERIZON_PROVIDER_PAGE_URL, verizonproviderpage);

		}
		
		@Then("^user clicks on the Find a physician link and site opens new provider search tool in a new window$")
		
		public void clickverizonfindapysician(){
			VerizonUhcretireePage verizonproviderpage = (VerizonUhcretireePage)getLoginScenario().getBean(PageConstants.VERIZON_PROVIDER_PAGE_URL);
			Rallytool_Page rallytool = verizonproviderpage.findaphysicianverizonclick();
			if(rallytool!= null){
				getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
						rallytool);
				Assert.assertTrue(true);
			} else {
				Assert.fail(" Page not found");
			}
			
			
		}
@And("^user navigates to the Verizon Home Page$")

public void verizonhomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	VerizonHomePage verizonhomepages = new VerizonHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.VERIZON_HOME_PAGE_URL, verizonhomepages);

}

@Then("^user clicks on the Find a provider link and site opens new provider search tool in a new window")

public void verizonfindaproviderclick() {
	VerizonHomePage verizonproviderrally= (VerizonHomePage)getLoginScenario().getBean(PageConstants.VERIZON_HOME_PAGE_URL);
	Rallytool_Page rallytool = verizonproviderrally.findaproviderverizonclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@And("^user navigates to the Verizon Site Map Page$")

public void verizonsitemap() {
	WebDriver wd = getLoginScenario().getWebDriver();
	VerizonSiteMap versitemaprally = new VerizonSiteMap(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.VERIZON_SITE_MAP_URL, versitemaprally);

}
@Then("^user clicks on the Find a provider link on verizon site map page and site opens new provider search tool in a new window$")

public void verizonsitemapproviderclick() {
	VerizonSiteMap verizonproviderrally= (VerizonSiteMap)getLoginScenario().getBean(PageConstants.VERIZON_SITE_MAP_URL);
	
	Rallytool_Page rallytool = verizonproviderrally.verizonsitemapproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Given("^user navigates to UHC Retiree Calpers Home Page$")

public void calpershomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	CalpersHomePage calpers = new CalpersHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.CALPERS_HOME_PAGE, calpers);

}

@And("^user clicks on the Find a Provider link on Calpers Home Page and rally tool opens in new tab$")

public void calpersproviderlinkclick () {
	CalpersHomePage calpersproviderlink= (CalpersHomePage)getLoginScenario().getBean(PageConstants.CALPERS_HOME_PAGE);
	
	Rallytool_Page rallytool = calpersproviderlink.calpershomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user switches back to the Calpers Home Page$")

public void backToHomePage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	CalpersHomePage calpers = rally.switchBack();
	if(calpers!= null){
		getLoginScenario().saveBean(PageConstants.CALPERS_HOME_PAGE, calpers);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on the Find a Provider tab$")

public void calpersprovidertabclick () {
	CalpersHomePage calpersprovidertab= (CalpersHomePage)getLoginScenario().getBean(PageConstants.CALPERS_HOME_PAGE);
	
	CalperFindaProviderPage calperfindaprovider = calpersprovidertab.calperprovidertabclick();
	if(calperfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.CALPER_FIND_A_PROVIDER,
				calperfindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on Calpers Provider Page and Rally tool opens$")

public void calpersfindphysician(){
	
	CalperFindaProviderPage calpersfindaproviderpage = (CalperFindaProviderPage)getLoginScenario().getBean(PageConstants.CALPER_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = calpersfindaproviderpage.findaphysiciancalipersclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}
@Then("^user again switches back to Calpers Home page$")

public void backToCalperProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	CalperFindaProviderPage calpers = rally.switchBackToCalperFindaProvider();
	if(calpers!= null){
		getLoginScenario().saveBean(PageConstants.CALPERS_HOME_PAGE, calpers);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on Calpers Home page$")

public void calperssitemapclick() {
	CalperFindaProviderPage calpersproviderpage= (CalperFindaProviderPage)getLoginScenario().getBean(PageConstants.CALPERS_HOME_PAGE);
	
	CalpersSiteMapPage calpersitemap = calpersproviderpage.calpersitemapclick();
	if(calpersitemap!= null){
		getLoginScenario().saveBean(PageConstants.CALPERS_SITE_MAP,
				calpersitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on Calpers Site Map Page and rally provider tool opens$")

public void calpersitemapproviderclick(){
	
	CalpersSiteMapPage calpersitemaprally= (CalpersSiteMapPage)getLoginScenario().getBean(PageConstants.CALPERS_SITE_MAP);
	Rallytool_Page rallytool = calpersitemaprally.findaprovidercalpersitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Given("^user navigates to the UHCRetiree oehwf Home Page$")

public void click_oehwfdrugsearch() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	UHCRetireeOehwfHomePage uhcRetireeAcqOehwfHomePage = new UHCRetireeOehwfHomePage(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_OEHWF_HOME_PAGE, uhcRetireeAcqOehwfHomePage);
}

@And("^click on the Find a provider link on the UHCRetiree oehwf Home Page and site opens new provider search Rally tool in a new window$")

public void click_travelersFindaprovider() {
	UHCRetireeOehwfHomePage uhcRetireeAcqHomePage = (UHCRetireeOehwfHomePage)getLoginScenario().getBean(PageConstants.UHCRETIREE_ACQ_OEHWF_HOME_PAGE);


	Rallytool_Page rallytool = uhcRetireeAcqHomePage.Findaproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}


	
@Given("^user navigates to the UHCRetiree oehwf - Site Map Page$")

public void oehwf_sitemappage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	OehwfSiteMap OehwfsiteMapPage = new OehwfSiteMap(wd);

	getLoginScenario().saveBean(PageConstants.OEHWF_SITE_MAP_URL, OehwfsiteMapPage);
}



@And("^user clicks on the Find a provider link on the UHCRetiree oehwf - Site Map Page and site opens new provider search Rally Connect tool in a new window.$")

public void click_SitemapFindaprovider() {
OehwfSiteMap uhcRetireeAcqHomePage = (OehwfSiteMap)getLoginScenario().getBean(PageConstants.OEHWF_SITE_MAP_URL);


Rallytool_Page rallytool = uhcRetireeAcqHomePage.oehwfsitemapproviderclick();
if(rallytool!= null){
	getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
			rallytool);
	Assert.assertTrue(true);
} else {
	Assert.fail(" Page not found");
}
}

@Given("^user navigates to the UHCRetiree Travelers Home Page$")

public void click_drugsearch() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	UHCRetireeTravelersHomePage uhcRetireeAcqTravelersHomePage = new UHCRetireeTravelersHomePage(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_TRAVELERS_ACQ_HOME_PAGE, uhcRetireeAcqTravelersHomePage);
}

@And("^click on the Find a provider link on the UHCRetiree Travelers Home Page and site opens new provider search Rally tool in a new window$")

public void click_Findaprovider() {
	UHCRetireeTravelersHomePage uhcRetireeAcqHomePage = (UHCRetireeTravelersHomePage)getLoginScenario().getBean(PageConstants.UHCRETIREE_TRAVELERS_ACQ_HOME_PAGE);


	Rallytool_Page rallytool = uhcRetireeAcqHomePage.Findaproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}


	
@And("^user navigates to the UHCRetiree Travelers - Site Map Page$")

public void travelers_sitemappage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	TravelersSiteMap TravelerssiteMapPage = new TravelersSiteMap(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_TRAVELERS_SITE_MAP_PAGE, TravelerssiteMapPage);
}


@Then("^user clicks on the Find a provider link on the UHCRetiree Travelers - Site Map Page and site opens new provider search Rally Connect tool in a new window.$")

public void click_SitemaptravelersFindaprovider() {
TravelersSiteMap uhcRetireeAcqHomePage = (TravelersSiteMap)getLoginScenario().getBean(PageConstants.UHCRETIREE_TRAVELERS_SITE_MAP_PAGE);


Rallytool_Page rallytool = uhcRetireeAcqHomePage.travelerssitemapproviderclick();
if(rallytool!= null){
	getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
			rallytool);
	Assert.assertTrue(true);
} else {
	Assert.fail(" Page not found");
}
}
}








	

















	









