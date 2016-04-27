/**
 * 
 */
package acceptancetests.UHCRetiree;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.AlcatelLucentFindProviderPage;
import pages.acquisition.uhcretiree.AlcatelLucentHomePage;
import pages.acquisition.uhcretiree.AlcatelLucentSiteMapPage;
import pages.acquisition.uhcretiree.CalperFindaProviderPage;
import pages.acquisition.uhcretiree.CalpersHomePage;
import pages.acquisition.uhcretiree.CalpersSiteMapPage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonHomePage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonProviderPage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonSiteMapPage;
import pages.acquisition.uhcretiree.MetlifeFindaProviderPage;
import pages.acquisition.uhcretiree.MetlifeHomePage;
import pages.acquisition.uhcretiree.MetlifeSiteMapPage;
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
import pages.acquisition.uhcretiree.VerizonHomePage;
import pages.acquisition.uhcretiree.VerizonSiteMap;
import pages.acquisition.uhcretiree.VerizonUhcretireePage;
import pages.acquisition.uhcretiree.SanFranciscoHomePage;
import pages.acquisition.uhcretiree.SanfranciscoFindaProviderPage;
import pages.acquisition.uhcretiree.SannFranciscoSiteMapPage;
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

@And("^user selects Alcatel-lucent group from select group dropdown$")

public void selectAlcatelgroup(){
	
	AcquisitionHomePage uhcRetireeAcqHomePage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
	AlcatelLucentHomePage alcatelLucentHomePage = uhcRetireeAcqHomePage.selectAlcatelLucent_dropdown();
	if(alcatelLucentHomePage!=null){
		
		getLoginScenario().saveBean(PageConstants.ALCATEL_LUCENT_HOME_PAGE,
				alcatelLucentHomePage);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Alcatel Home Page not found");
	}
	
}
@And("^user clicks on find a provider link from Alcatel-lucent home page$")
public void clickFindProviderLink(){
	
	AlcatelLucentHomePage alcatelLucentHomePage = (AlcatelLucentHomePage)getLoginScenario().getBean(PageConstants.ALCATEL_LUCENT_HOME_PAGE);
	Rallytool_Page rallytool = alcatelLucentHomePage.findProviderLinkClick();
	if(rallytool!=null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Rally tool Page not found");
		}	
}

@And("^user switches back to Alcatel-lucent home page$")

public void switchBackToPreviousPage(){
	
	Rallytool_Page rallytool = (Rallytool_Page)getLoginScenario().getBean(PageConstants.RALLY_TOOL_PAGE);
	AlcatelLucentHomePage alcatelLucentHomePage = rallytool.switchBackToAlcatelLucentHomePage();
	if(alcatelLucentHomePage!=null){
		getLoginScenario().saveBean(PageConstants.ALCATEL_LUCENT_HOME_PAGE,
				alcatelLucentHomePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Alcatel Home Page not found");
		}	
}

@And("^user clicks on Find a provider tab from the header of Alcatel-lucent home page$")

public void clickFindProviderTab(){
	AlcatelLucentHomePage alcatelLucentHomePage = (AlcatelLucentHomePage)getLoginScenario().getBean(PageConstants.ALCATEL_LUCENT_HOME_PAGE);
	AlcatelLucentFindProviderPage alcatelLucentFindProviderPage= alcatelLucentHomePage.findProviderTabClick();
	if(alcatelLucentFindProviderPage!=null){
		getLoginScenario().saveBean(PageConstants.ALCATEL_LUCENT_FIND_PROVIDER_PAGE,
				alcatelLucentFindProviderPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Find Provider Page not found");
		}		
}

@And("^user clicks on Find a Physician Medical Group Clinic or Facility link from Alcatel-lucent find_a_provider page$")

public void clickFindPhysicianLink(){
	AlcatelLucentFindProviderPage alcatelLucentFindProviderPage = (AlcatelLucentFindProviderPage)getLoginScenario().getBean(PageConstants.ALCATEL_LUCENT_FIND_PROVIDER_PAGE);
	Rallytool_Page rallytool= alcatelLucentFindProviderPage.findPhysicianLinkClick();
	if(rallytool!=null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Rally tool Page not found");
		}	
	
}

@And("^user switches back to Alcatel-lucent Find Provider page$")

public void switchBackToFindProviderPage(){
	
	Rallytool_Page rallytool = (Rallytool_Page)getLoginScenario().getBean(PageConstants.RALLY_TOOL_PAGE);
	AlcatelLucentFindProviderPage alcatelLucentFindProviderPage = rallytool.switchBackToAlcatelLucentFindProviderPage();
	if(alcatelLucentFindProviderPage!=null){
		getLoginScenario().saveBean(PageConstants.ALCATEL_LUCENT_FIND_PROVIDER_PAGE,
				alcatelLucentFindProviderPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Alcatel Find provider Page not found");
		}	
}

@And("^user clicks on site map link from the footer of Alcatel-lucent Find Provider page$")

public void clickSiteMapLink(){
	AlcatelLucentFindProviderPage alcatelLucentFindProviderPage = (AlcatelLucentFindProviderPage)getLoginScenario().getBean(PageConstants.ALCATEL_LUCENT_FIND_PROVIDER_PAGE);
	AlcatelLucentSiteMapPage alcatelLucentSiteMapPage= alcatelLucentFindProviderPage.siteMapLinkClick();
	if(alcatelLucentSiteMapPage!=null){
		getLoginScenario().saveBean(PageConstants.ALCATEL_LUCENT_SITE_MAP_PAGE,
				alcatelLucentSiteMapPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}	
	
}

@And("^user clicks on Find a provider link from Alcatel-lucent site map page$")

public void clickSiteMapFindProviderLink(){
	AlcatelLucentSiteMapPage alcatelLucentSiteMapPage = (AlcatelLucentSiteMapPage)getLoginScenario().getBean(PageConstants.ALCATEL_LUCENT_SITE_MAP_PAGE);
	Rallytool_Page rallytool= alcatelLucentSiteMapPage.siteMapFindProviderLinkClick();
	if(rallytool!=null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
			Assert.assertTrue(true);
		} else {
			Assert.fail(" Page not found");
		}	
}


@Given("^user navigates to Johnson & Johnson Home Page in UHC Retiree$")
public void johnsonAndJohnsonHomePage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	JohnsonAndJohnsonHomePage johnsonAndJohnsonHomePage = new JohnsonAndJohnsonHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.JOHNSONANDJOHNSON_HOME_PAGE, johnsonAndJohnsonHomePage);

}

@And("^user clicks on the Find a Provider link on Johnson & Johnson Home Page and rally tool opens in new tab in UHC Retiree$")
public void johnsonAndJohnsonProviderLinkClick () {
	JohnsonAndJohnsonHomePage johnsonAndJohnsonHomePage= (JohnsonAndJohnsonHomePage)getLoginScenario().getBean(PageConstants.JOHNSONANDJOHNSON_HOME_PAGE);
	
	Rallytool_Page rallytool = johnsonAndJohnsonHomePage.johnsonAndJohnsonProviderClick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@And("^user switches back to the Johnson & Johnson Home Page and clicks on the Find a Provider tab on Johnson & Johnson in UHC Retiree$")
public void backToJnJHomePage()
{
	JohnsonAndJohnsonHomePage johnsonAndJohnsonHomePage  = (JohnsonAndJohnsonHomePage) getLoginScenario()
			.getBean(PageConstants.JOHNSONANDJOHNSON_HOME_PAGE);
	JohnsonAndJohnsonProviderPage johnsonAndJohnsonProviderPage = johnsonAndJohnsonHomePage.switchAndClickProvider();
	if(johnsonAndJohnsonProviderPage!= null){
		getLoginScenario().saveBean(PageConstants.JOHNSONANDJOHNSON_PROVIDER_PAGE, johnsonAndJohnsonProviderPage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("JnJ Provider page not found");
	} 
           
}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on Johnson & Johnson Provider Page and Rally tool opens in UHC Retiree$")
public void jnJFindPhyscian(){
	JohnsonAndJohnsonProviderPage johnsonAndJohnsonProviderPage = (JohnsonAndJohnsonProviderPage)getLoginScenario()
			.getBean(PageConstants.JOHNSONANDJOHNSON_PROVIDER_PAGE);
	Rallytool_Page rallytool = johnsonAndJohnsonProviderPage.jnJFindPhyscianClick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@And("^user switches back to Johnson & Johnson Provider Page and clicks on site map on Johnson & Johnson Home page in UHC Retiree$")
public void jnJSiteMapPage(){
	JohnsonAndJohnsonProviderPage johnsonAndJohnsonProviderPage = (JohnsonAndJohnsonProviderPage)getLoginScenario()
			.getBean(PageConstants.JOHNSONANDJOHNSON_PROVIDER_PAGE);
	JohnsonAndJohnsonSiteMapPage johnsonAndJohnsonSiteMapPage = johnsonAndJohnsonProviderPage.jnJSiteMapClick();
	if(johnsonAndJohnsonSiteMapPage!= null){
		getLoginScenario().saveBean(PageConstants.JOHNSONANDJOHNSON_SITE_MAP_PAGE,
				johnsonAndJohnsonSiteMapPage);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
}

@Then("^user clicks on find a provider link on Johnson & Johnson Site Map Page and rally provider tool opens in UHC Retiree$")
public void jnJSiteMapProviderLink(){
	JohnsonAndJohnsonSiteMapPage johnsonAndJohnsonSiteMapPage = (JohnsonAndJohnsonSiteMapPage)getLoginScenario()
			.getBean(PageConstants.JOHNSONANDJOHNSON_SITE_MAP_PAGE);
	Rallytool_Page rallytool = johnsonAndJohnsonSiteMapPage.jnJSiteMapProviderLinkClick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Given("^user navigates to UHC Retiree MetLife Home Page$")
public void Metlifehomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	MetlifeHomePage metlife = new MetlifeHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.METLIFE_HOME_PAGE, metlife);
	

}


@And("^user clicks on the Find a Provider link on Metlife Home Page and rally tool opens in new tab$")
public void metlifeproviderlinkclick() 
{
	MetlifeHomePage metlifeproviderlink= (MetlifeHomePage)getLoginScenario().getBean(PageConstants.METLIFE_HOME_PAGE);
	
	Rallytool_Page rallytool = metlifeproviderlink.metlifehomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user switches back to the MetLife Home Page$")
public void backToMetlifeHomePage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	MetlifeHomePage metlife = rally.metlifeswitchBack();
	if(metlife!= null){
		getLoginScenario().saveBean(PageConstants.METLIFE_HOME_PAGE, metlife);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on the metlife Find a Provider tab$")
public void metlifeprovidertabclick () 
{
	MetlifeHomePage metlifeprovidertab= (MetlifeHomePage)getLoginScenario().getBean(PageConstants.METLIFE_HOME_PAGE);
	
	MetlifeFindaProviderPage metlifefindaprovider = metlifeprovidertab.metlifeprovidertabclick();
	if(metlifefindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.METLIFE_FIND_A_PROVIDER,
				metlifefindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on MetLife Provider Page and Rally tool opens$")
public void metlifefindphysician(){
	
	MetlifeFindaProviderPage metlifefindaproviderpage = (MetlifeFindaProviderPage)getLoginScenario().getBean(PageConstants.METLIFE_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = metlifefindaproviderpage.findaphysicianmetlifeclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user again switches back to MetLife Home page$")
public void backToMetlifeProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	MetlifeFindaProviderPage metlife = rally.switchBackToMetlifeFindaProvider();
	if(metlife!= null){
		getLoginScenario().saveBean(PageConstants.METLIFE_HOME_PAGE, metlife);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on MetLife Home page$")
public void metlifesitemapclick() {
	MetlifeFindaProviderPage metlifeproviderpage= (MetlifeFindaProviderPage)getLoginScenario().getBean(PageConstants.METLIFE_HOME_PAGE);
	
	MetlifeSiteMapPage metlifesitemap = metlifeproviderpage.metlifeitemapclick();
	if(metlifesitemap!= null){
		getLoginScenario().saveBean(PageConstants.METLIFE_SITE_MAP,
				metlifesitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on MetLife Site Map Page and rally provider tool opens$")
public void metlifesitemapproviderclick(){
	
	MetlifeSiteMapPage metlifesitemaprally= (MetlifeSiteMapPage)getLoginScenario().getBean(PageConstants.METLIFE_SITE_MAP);
	Rallytool_Page rallytool = metlifesitemaprally.findaprovidermetlifesitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}
@Given("^user navigates to UHC Retiree San Francisco Home Page$")	

	public void sanfranciscohomepage(){
		WebDriver wd = getLoginScenario().getWebDriver();
		SanFranciscoHomePage sanfrancisco = new SanFranciscoHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		getLoginScenario().saveBean(PageConstants.SAN_FRANCISCO_HOME_PAGE, sanfrancisco);
	}



@And("^user clicks on the Find a Provider link on San Francisco Home Page and rally tool opens in new tab$")

public void sanfranciscoproviderlinkclick () {
	SanFranciscoHomePage sanfranciscoproviderlink= (SanFranciscoHomePage)getLoginScenario().getBean(PageConstants.SAN_FRANCISCO_HOME_PAGE);
	
	Rallytool_Page rallytool = sanfranciscoproviderlink.sanfranciscohomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user switches back to the San Francisco Home Page$")

public void backToSanFranciscoPage()
{
	Rallytool_Page rally = (Rallytool_Page) getLoginScenario().getBean(PageConstants.RALLY_TOOL_PAGE);
	SanFranciscoHomePage sanfrancisco = rally.switchBackToSanFranciscoHome();
	if(sanfrancisco!= null){
		getLoginScenario().saveBean(PageConstants.SAN_FRANCISCO_HOME_PAGE, sanfrancisco);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on the Find a Provider tab on San francisco Home page$")

public void sanfranciscoprovidertabclick () {
	SanFranciscoHomePage sanfranciscoprovidertab= (SanFranciscoHomePage) getLoginScenario().getBean(PageConstants.SAN_FRANCISCO_HOME_PAGE);
	
	SanfranciscoFindaProviderPage sanfranciscofindaprovider = sanfranciscoprovidertab.sanfranciscoprovidertabclick();
	if(sanfranciscofindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.SAN_FRANCISCO_FIND_A_PROVIDER,
				sanfranciscofindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on San Francisco Provider Page and Rally tool opens$")

public void sanfranciscofindphysician(){
	
	SanfranciscoFindaProviderPage sanfranciscofindaproviderpage = (SanfranciscoFindaProviderPage)getLoginScenario().getBean(PageConstants.SAN_FRANCISCO_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = sanfranciscofindaproviderpage.findaphysiciansanfranciscoclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}
@Then("^user switches back to the San Francisco Provider Page$")

public void backToSanFranciscoProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page)getLoginScenario().getBean(PageConstants.RALLY_TOOL_PAGE);
	SanfranciscoFindaProviderPage sanfranciscoproviderpage= rally.switchBackToSanFrancisoFindaProvider();
	if(sanfranciscoproviderpage!= null){
		getLoginScenario().saveBean(PageConstants.SAN_FRANCISCO_FIND_A_PROVIDER, sanfranciscoproviderpage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on San Francisco Provider Page$")

public void sanfranciscositemapclick() {
	SanfranciscoFindaProviderPage sanfranciscoproviderpage= (SanfranciscoFindaProviderPage)getLoginScenario().getBean(PageConstants.SAN_FRANCISCO_FIND_A_PROVIDER);
	
	SannFranciscoSiteMapPage sanfranciscositemap = sanfranciscoproviderpage.sanfranciscositemapclick();
	if(sanfranciscositemap!= null){
		getLoginScenario().saveBean(PageConstants.SAN_FRANCISCO_SITE_MAP,
				sanfranciscositemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on San Francisco Site Map Page and rally provider tool opens$")

public void sanfranciscositemapproviderclick(){
	
	SannFranciscoSiteMapPage sanfranciscositemap= (SannFranciscoSiteMapPage)getLoginScenario().getBean(PageConstants.SAN_FRANCISCO_SITE_MAP);
	Rallytool_Page rallytool = sanfranciscositemap.findaprovidersanfranciscositemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Given("^user navigates to the UHCRetiree Home Page$")

public void user_navigates_home_page() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	AcquisitionHomePage uhcRetireeAcqHomePage = new AcquisitionHomePage(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE, uhcRetireeAcqHomePage);
}

@And("^user clicks on site map to navigate on site map page$")

public void user_clicks_site_map() {
	
	AcquisitionHomePage uhcRetireeAcqHomePage = (AcquisitionHomePage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);	
	
	UHCRetireeSiteMapPage uhcretireesitemappage = uhcRetireeAcqHomePage.clicksitemap();
	
	if(uhcretireesitemappage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SITE_MAP_PAGE,
				uhcretireesitemappage);
		Assert.assertTrue(true);
	} else {
		Assert.fail("UHCRetiree Site Map page not found");
	}
	
}	
	
@Then("^user clicks on the find a provider link and rally tool opens in a new window$")	

public void user_clicks_find_a_provider() {
	
	UHCRetireeSiteMapPage uhcretireesitemappage = (UHCRetireeSiteMapPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_SITE_MAP_PAGE);	
	
	RallyToolPage rallytool = uhcretireesitemappage.clickfindaprovider();
	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("UHCRetiree Site Map page not found");
		}
	
}

		
@Given("^user navigates to UHC Retiree ASRS Page$")	

public void user_navigates_to_ASRS_Page() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	
	UHCRetireeASRSPage uhcRetireeAcqASRSPage = new UHCRetireeASRSPage(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_ASRS_PAGE, uhcRetireeAcqASRSPage);
}

@And("^user clicks on the Find a Provider link and rally tool opens in new tab$")

public void user_clicks_Find_a_Provider() {
	
	UHCRetireeASRSPage uhcRetireeAcqASRSPage = (UHCRetireeASRSPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_ASRS_PAGE);	
	
	RallyToolPage rallytool = uhcRetireeAcqASRSPage.clickfindaprovider();
	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("Rally Page not found");
		}
	
}

@Then("^user switches back to the Home Page$")

public void user_switch_back() {
	
	RallyToolPage rallytool = (RallyToolPage) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);	
	
	UHCRetireeASRSPage uhcRetireeAcqASRSPage = rallytool.userswitchback();
	
	if(uhcRetireeAcqASRSPage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_ASRS_PAGE,
				uhcRetireeAcqASRSPage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}
		
}

@And("^user clicks on the Find a Provider link$")

public void user_clicks_Provider() {
	
	UHCRetireeASRSPage uhcRetireeAcqASRSPage = (UHCRetireeASRSPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_ASRS_PAGE);	
	
	UHCRetireeASRSProviderPage uhcretireeasrsproviderpage = uhcRetireeAcqASRSPage.clickfindaphysician();	
	
	if(uhcretireeasrsproviderpage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_ASRS_PROVIDER_PAGE,
				uhcretireeasrsproviderpage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page is not found");
	}
	
}



@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link and Rally tool opens$")

public void user_clicks_find_a_Physician_link() {

	UHCRetireeASRSProviderPage uhcretireeasrsproviderpage = (UHCRetireeASRSProviderPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_ASRS_PROVIDER_PAGE);
	
	RallyToolPage rallytool = uhcretireeasrsproviderpage.clickfindaphysician();	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("UHCRetiree Site Map page not found");
		}
	
	
}
	
@Then("^user again switches back to previous page$")

public void user_navigates_back_again() {
	
	RallyToolPage rallytool = (RallyToolPage) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);	
	
	UHCRetireeASRSProviderPage uhcretireeasrsproviderpage = rallytool.userswitchesback();
	
	if(uhcretireeasrsproviderpage != null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_ASRS_PROVIDER_PAGE,
				uhcretireeasrsproviderpage );
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}
	
}

@And("^user clicks on site map on ASRS page$")

public void user_clicks_sitemap() {
	
	UHCRetireeASRSProviderPage uhcretireeasrsproviderpage = (UHCRetireeASRSProviderPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_ASRS_PROVIDER_PAGE);
	
	SiteMapASRSPage sitemappage = uhcretireeasrsproviderpage.sitemapclick();
	
	if(sitemappage != null){
		getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE_ASRS,
				sitemappage );
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Site Map Page not found");
	}
		
}

@Then("^user clicks on find a provider link and rally provider tool opens$")

public void user_clicks_findprovider() {
	
	SiteMapASRSPage sitemappage  = (SiteMapASRSPage) getLoginScenario()
			.getBean(PageConstants.SITE_MAP_PAGE_ASRS);
	
	RallyToolPage rallytool = sitemappage.clickfindproviderlink();	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("UHCRetiree Site Map page not found");
		}
	
}

@Given("^user navigates to UHC Retiree EDISON page$")

public void user_navigates_UHCRetireePage() {
	
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	
	UHCRetireeEdisonPage uhcRetireeedisonPage = new UHCRetireeEdisonPage(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_EDISON_PAGE, uhcRetireeedisonPage);
}

@And("^user clicks on the Find a Provider Link and Rally TOOL Opens up$")

public void user_navigates_on_find_a_provider() {
	
	UHCRetireeEdisonPage uhcRetireeedisonPage  = (UHCRetireeEdisonPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_EDISON_PAGE);
	
	RallyToolPage rallytool = uhcRetireeedisonPage.clickfindprovider();
	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("UHCRetiree Site Map page not found");
		}	
}

@Then("^user navigates back to the previous page$")

public void user_navigates_on_back_page() {
	
	RallyToolPage rallytool = (RallyToolPage) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);	
	
	UHCRetireeEdisonPage uhcRetireeedisonPage = rallytool.usersnavigatesback();
	
	if(uhcRetireeedisonPage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_EDISON_PAGE,
				uhcRetireeedisonPage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}		
}

@And("^user clicks on Find a Provider link$")

public void user_clicks_findprovider_link() {
	
	UHCRetireeEdisonPage uhcRetireeedisonPage  = (UHCRetireeEdisonPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_EDISON_PAGE);
	
	UHCRetireeEdisionProviderPage uhcedisonproviderpage = uhcRetireeedisonPage.clickfindaprovider();
	
	if(uhcedisonproviderpage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_EDISON_PROVIDER_PAGE,
				uhcedisonproviderpage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}			
}

@And("^user clicks on find a physician link and RALLY TOOL opens up in new tab$")

public void user_clicks_findphysician_link() {
	
	UHCRetireeEdisionProviderPage uhcedisonproviderpage  = (UHCRetireeEdisionProviderPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_EDISON_PROVIDER_PAGE);
	

	RallyToolPage rallytool = uhcedisonproviderpage.clickfindaphysician();
	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("Rally page not found");
		}			
}

@Then("^user navigates back to previous page$")

public void user_naviagtes_back_again() {
	
	RallyToolPage rallytool = (RallyToolPage) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);	
	
	UHCRetireeEdisionProviderPage uhcedisonproviderpage = rallytool.usernavigatesbackagain();
	
	if(uhcedisonproviderpage != null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_EDISON_PROVIDER_PAGE,
				uhcedisonproviderpage );
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}
	
	
}

@And("^user clicks on site map on UHC Retiree Provider page$")

public void user_clicks_on_sitemap() {
	
	UHCRetireeEdisionProviderPage uhcedisonproviderpage  = (UHCRetireeEdisionProviderPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_EDISON_PROVIDER_PAGE);
	
	UHCRetireeEdisonSiteMap uhcretireeedisonsitemap = uhcedisonproviderpage.clicksitemap();
	
	if(uhcretireeedisonsitemap != null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_EDISON_SITEMAP_PAGE,
				uhcretireeedisonsitemap );
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}
	
}

@Then("^user clicks on find a provider and RALLY TOOL Opens up$")

public void user_clicks_find_a_Physician() {
	
	UHCRetireeEdisonSiteMap uhcretireeedisonsitemap = (UHCRetireeEdisonSiteMap) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_EDISON_SITEMAP_PAGE);
	
	RallyToolPage rallytool = uhcretireeedisonsitemap.findaproviderLink();	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("Page not found");
		}


}

@Given("^user navigates to UHC Retiree SHBP page$")	

public void user_navigates_to_SHBP_Page() {
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	
	UHCRetireeSHBPPage uhcRetireeAcqSHBPPage = new UHCRetireeSHBPPage(wd);

	getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SHBP_PAGE, uhcRetireeAcqSHBPPage);
}

@And("^user navigates to the Find a Provider Link and Rally TOOL Opens up$")

public void user_clicks_Find_Provider() {
	
	UHCRetireeSHBPPage uhcRetireeAcqSHBPPage = (UHCRetireeSHBPPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_SHBP_PAGE);	
	
	RallyToolPage rallytool = uhcRetireeAcqSHBPPage.clickfindaprovider();
	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("Rally Page not found");
		}
	
}


@Then("^user navigates back to UHC Retiree SHBP page$")

public void user_switchback() {
	
	RallyToolPage rallytool = (RallyToolPage) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);	
	
	UHCRetireeSHBPPage uhcRetireeAcqSHBPPage = rallytool.usernavigateback();
	
	if(uhcRetireeAcqSHBPPage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SHBP_PAGE,
				uhcRetireeAcqSHBPPage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}
		
}

@And("^user clicks on Find a Provider link on UHC Retiree SHBP page$")

public void user_clicksProvider() {
	
	UHCRetireeSHBPPage uhcRetireeAcqSHBPPage = (UHCRetireeSHBPPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_SHBP_PAGE);	
	
	UHCRetireeSHBPProviderPage uhcretireeshbpproviderpage = uhcRetireeAcqSHBPPage.clickfindaphysician();	
	
	if(uhcretireeshbpproviderpage!= null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SHBP_PROVIDER_PAGE,
				uhcretireeshbpproviderpage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page is not found");
	}
	
}



@Then("^user clicks on find a physician link UHC Retiree SHBP provider page and RALLY TOOL opens up in new tab$")

public void user_clicks_find_aPhysician_link() {

	UHCRetireeSHBPProviderPage uhcretireeshbpproviderpage = (UHCRetireeSHBPProviderPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_SHBP_PROVIDER_PAGE);
	
	RallyToolPage rallytool = uhcretireeshbpproviderpage.clickfindphysician();	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("UHCRetiree Site Map page not found");
		}
	
	
}
	
@Then("^user navigates back to UHC Retiree SHBP provider page$")

public void user_navigatesback_again() {
	
	RallyToolPage rallytool = (RallyToolPage) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);	
	
	UHCRetireeSHBPProviderPage uhcretireeshbpproviderpage = rallytool.userswitchesbackagain();
	
	if(uhcretireeshbpproviderpage != null){
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SHBP_PROVIDER_PAGE,
				uhcretireeshbpproviderpage );
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Page not found");
	}
	
}

@And("^user clicks on site map on UHC Retiree SHBP provider page$")

public void user_clickssitemap() {
	
	UHCRetireeSHBPProviderPage uhcretireeshbpproviderpage = (UHCRetireeSHBPProviderPage) getLoginScenario()
			.getBean(PageConstants.UHCRETIREE_ACQ_SHBP_PROVIDER_PAGE);
	
	SiteMapSHBPPage sitemapshbppage = uhcretireeshbpproviderpage.sitemaplinkclick();
	
	if(sitemapshbppage != null){
		getLoginScenario().saveBean(PageConstants.SITE_MAP_PAGE_SHBP,
				sitemapshbppage );
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Site Map Page not found");
	}
		
}

@Then("^user clicks on find a provider UHC Retiree SHBP site map page and RALLY TOOL Opens up$")

public void user_clicksfindprovider() {
	
	SiteMapSHBPPage sitemapshbppage  = (SiteMapSHBPPage) getLoginScenario()
			.getBean(PageConstants.SITE_MAP_PAGE_SHBP);
	
	RallyToolPage rallytool = sitemapshbppage.clickfindaproviderlink();	
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		} else {
		Assert.fail("UHCRetiree Site Map page not found");
		}
	
}





}


