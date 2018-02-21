/**
 * 
 */
package acceptancetests.deprecated.UHCRetiree;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.AlcatelLucentFindProviderPage;
import pages.acquisition.uhcretiree.AlcatelLucentHomePage;
import pages.acquisition.uhcretiree.AlcatelLucentSiteMapPage;
import pages.acquisition.uhcretiree.CalperFindaProviderPage;
import pages.acquisition.uhcretiree.CalpersHomePage;
import pages.acquisition.uhcretiree.CalpersSiteMapPage;
import pages.acquisition.uhcretiree.IllinoisFindaProviderPage;
import pages.acquisition.uhcretiree.IllinoisHomePage;
import pages.acquisition.uhcretiree.IllinoisSiteMapPage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonHomePage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonProviderPage;
import pages.acquisition.uhcretiree.JohnsonAndJohnsonSiteMapPage;
import pages.acquisition.uhcretiree.KTRSFindaProviderPage;
import pages.acquisition.uhcretiree.KTRSHomePage;
import pages.acquisition.uhcretiree.KTRSSiteMapPage;
import pages.acquisition.uhcretiree.MetlifeFindaProviderPage;
import pages.acquisition.uhcretiree.MetlifeHomePage;
import pages.acquisition.uhcretiree.MetlifeSiteMapPage;
import pages.acquisition.uhcretiree.NcshpFindaProviderPage;
import pages.acquisition.uhcretiree.NcshpHomePage;
import pages.acquisition.uhcretiree.NcshpSiteMapPage;
import pages.acquisition.uhcretiree.OehwfSiteMap;
import pages.acquisition.uhcretiree.PfizerFindaProviderPage;
import pages.acquisition.uhcretiree.PfizerHomePage;
import pages.acquisition.uhcretiree.PfizerSiteMapPage;
import pages.acquisition.uhcretiree.RallyToolPage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.uhcretiree.SanFranciscoHomePage;
import pages.acquisition.uhcretiree.SanfranciscoFindaProviderPage;
import pages.acquisition.uhcretiree.SannFranciscoSiteMapPage;
import pages.acquisition.uhcretiree.SdceraFindaProviderPage;
import pages.acquisition.uhcretiree.SdceraHomePage;
import pages.acquisition.uhcretiree.SdceraSiteMapPage;
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

public void calpersproviderlinkclick () throws InterruptedException {
	CalpersHomePage calpersproviderlink= (CalpersHomePage)getLoginScenario().getBean(PageConstants.CALPERS_HOME_PAGE);
	
	Rallytool_Page rallytool = calpersproviderlink.calpershomepageproviderclick();
	Thread.sleep(6000);
	 
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
@Then("^user again switches back to Calpers Provider page$")

public void backToCalperProviderPage() throws InterruptedException
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	CalperFindaProviderPage calperfindaprovider = rally.switchBackToCalperFindaProvider();
	
	//CommonUtility.waitForPageLoad(driver, element, timeout);
	Thread.sleep(5000);
	System.out.println("Checked");
	if(calperfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.CALPER_FIND_A_PROVIDER, calperfindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on Calpers Provider page$")

public void calperssitemapclick() throws InterruptedException {
	
	WebDriver wd = getLoginScenario().getWebDriver();
			
	CalperFindaProviderPage calpersproviderpage= (CalperFindaProviderPage)getLoginScenario().getBean(PageConstants.CALPER_FIND_A_PROVIDER);
	
	CalpersSiteMapPage calpersitemap = calpersproviderpage.calpersitemapclick();
	Thread.sleep(5000);
	
	System.out.println("Element Found");
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

@Then("^user again switches back to MetLife Provider page$")
public void backToMetlifeProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	MetlifeFindaProviderPage metlifefindaprovider = rally.switchBackToMetlifeFindaProvider();
	if(metlifefindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.METLIFE_FIND_A_PROVIDER, metlifefindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on MetLife Provider page$")
public void metlifesitemapclick() {
	MetlifeFindaProviderPage metlifeproviderpage= (MetlifeFindaProviderPage)getLoginScenario().getBean(PageConstants.METLIFE_FIND_A_PROVIDER);
	
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


@Given("^user navigates to UHC Retiree Sdcera Home Page$")

public void sdcerahomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	SdceraHomePage sdcera = new SdceraHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.SDCERA_HOME_PAGE, sdcera);

}

@And("^user clicks on the Find a Provider link on Sdcera Home Page and rally tool opens in new tab$")

public void sdceraproviderlinkclick () {
	SdceraHomePage sdceraproviderlink= (SdceraHomePage)getLoginScenario().getBean(PageConstants.SDCERA_HOME_PAGE);
	
	Rallytool_Page rallytool = sdceraproviderlink.sdcerahomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user switches back to the Sdcera Home Page$")

public void backToHomesdceraPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	SdceraHomePage sdcera = rally.switchsdceraBack();
	if(sdcera!= null){
		getLoginScenario().saveBean(PageConstants.SDCERA_HOME_PAGE, sdcera);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on the Find a Provider tab on sdcera home page$")

public void sdceraprovidertabclick () {
	SdceraHomePage sdceraprovidertab= (SdceraHomePage)getLoginScenario().getBean(PageConstants.SDCERA_HOME_PAGE);
	
	SdceraFindaProviderPage sdcerafindaprovider = sdceraprovidertab.sdceraprovidertabclick();
	if(sdcerafindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.SDCERA_FIND_A_PROVIDER,
				sdcerafindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on Sdcera Provider Page and Rally tool opens$")

public void sdcerafindphysician(){
	
	SdceraFindaProviderPage sdcerafindaproviderpage = (SdceraFindaProviderPage)getLoginScenario().getBean(PageConstants.SDCERA_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = sdcerafindaproviderpage.findaphysiciansdceraclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}
@Then("^user again switches back to Sdcera Provider page$")

public void backToSdceraProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	SdceraFindaProviderPage sdcerafindaprovider = rally.switchBackToSdceraFindaProvider();
	if(sdcerafindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.SDCERA_FIND_A_PROVIDER, sdcerafindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on Sdcera Provider page$")

public void sdcerasitemapclick() {
	SdceraFindaProviderPage sdceraproviderpage= (SdceraFindaProviderPage)getLoginScenario().getBean(PageConstants.SDCERA_FIND_A_PROVIDER);
	
	SdceraSiteMapPage sdcerasitemap = sdceraproviderpage.sdcerasitemapclick();
	if(sdcerasitemap!= null){
		getLoginScenario().saveBean(PageConstants.SDCERA_SITE_MAP,
				sdcerasitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on Sdcera Site Map Page and rally provider tool opens$")

public void sdcerasitemapproviderclick(){
	
	SdceraSiteMapPage sdcerasitemaprally= (SdceraSiteMapPage)getLoginScenario().getBean(PageConstants.SDCERA_SITE_MAP);
	Rallytool_Page rallytool = sdcerasitemaprally.findaprovidersdcerasitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}


//for KTRS group
@Given("^user navigates to UHC Retiree KTRS Home Page$")
public void KTRShomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	KTRSHomePage ktrs = new KTRSHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.KTRS_HOME_PAGE, ktrs);
	

}

@And("^user clicks on the Find a Provider link on KTRS Home Page and rally tool opens in new tab$")
public void ktrsproviderlinkclick() 
{
	KTRSHomePage ktrsproviderlink= (KTRSHomePage)getLoginScenario().getBean(PageConstants.KTRS_HOME_PAGE);
	
	Rallytool_Page rallytool = ktrsproviderlink.ktrshomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}
@Then("^user switches back to the KTRS Home Page$")
public void backToktrsHomePage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	KTRSHomePage ktrs = rally.ktrsswitchBack();
	if(ktrs!= null){
		getLoginScenario().saveBean(PageConstants.KTRS_HOME_PAGE, ktrs);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on the KTRS Find a Provider tab$")
public void ktrsprovidertabclick () 
{
	KTRSHomePage ktrsprovidertab= (KTRSHomePage)getLoginScenario().getBean(PageConstants.KTRS_HOME_PAGE);
	
	KTRSFindaProviderPage ktrsfindaprovider = ktrsprovidertab.ktrsprovidertabclick();
	if(ktrsfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.KTRS_FIND_A_PROVIDER,
				ktrsfindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}
@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on KTRS Provider Page and Rally tool opens$")
public void ktrsfindphysician(){
	
	KTRSFindaProviderPage ktrsfindaproviderpage = (KTRSFindaProviderPage)getLoginScenario().getBean(PageConstants.KTRS_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = ktrsfindaproviderpage.findaphysicianktrsclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user again switches back to KTRS Provider page$")
public void backToKtrsProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	KTRSFindaProviderPage ktrsfindaprovider = rally.switchBackToktrsFindaProvider();
	if(ktrsfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.KTRS_FIND_A_PROVIDER, ktrsfindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on KTRS Provider page$")
public void ktrssitemapclick() {
	KTRSFindaProviderPage ktrsproviderpage= (KTRSFindaProviderPage)getLoginScenario().getBean(PageConstants.KTRS_FIND_A_PROVIDER);
	
	KTRSSiteMapPage ktrssitemap = ktrsproviderpage.ktrssitemapclick();
	if(ktrssitemap!= null){
		getLoginScenario().saveBean(PageConstants.KTRS_SITE_MAP,
				ktrssitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on KTRS Site Map Page and rally provider tool opens$")
public void ktrssitemapproviderclick(){
	
	KTRSSiteMapPage ktrssitemaprally= (KTRSSiteMapPage)getLoginScenario().getBean(PageConstants.KTRS_SITE_MAP);
	Rallytool_Page rallytool = ktrssitemaprally.findaproviderktrssitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
 }
 @Given("^user navigates to UHC Pfizer Home Page$")

public void Pfizerhomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	PfizerHomePage pfizer = new PfizerHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.PFIZER_HOME_PAGE, pfizer);

}

@And("^user clicks on Find a Provider link on Pfizer Home Page and rally tool opens in new tab$")

public void pfizerproviderlinkclick () {
	PfizerHomePage pfizerproviderlink= (PfizerHomePage)getLoginScenario().getBean(PageConstants.PFIZER_HOME_PAGE);
	
	Rallytool_Page rallytool = pfizerproviderlink.pfizerhomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}
@Then("^user switches back to Pfizer Home Page$")

public void backToPfizerHomePage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	PfizerHomePage pfizer = rally.switchBackToHomePage();
	if(pfizer!= null){
		getLoginScenario().saveBean(PageConstants.PFIZER_HOME_PAGE, pfizer);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on Find a Provider tab on Pfizer Home Page$")

public void pfizerprovidertabclick () {
	PfizerHomePage pfizerprovidertab= (PfizerHomePage)getLoginScenario().getBean(PageConstants.PFIZER_HOME_PAGE);
	
	PfizerFindaProviderPage pfizerfindaprovider = pfizerprovidertab.pfizerprovidertabclick();
	if(pfizerfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.PFIZER_FIND_A_PROVIDER,
				pfizerfindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	

}

@Then("^user clicks on Find a Physician Medical Group Clinic or Facility link on Pfizer Provider Page and Rally tool opens$")
public void pfizerfindphysician(){
	
	PfizerFindaProviderPage pfizerfindaprovider = (PfizerFindaProviderPage)getLoginScenario().getBean(PageConstants.PFIZER_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = pfizerfindaprovider.findaphysicianpfizerclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user again switches back to Pfizer Provider Page$")
public void backToPfizerProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	PfizerFindaProviderPage pfizerfindaprovider = rally.switchBackToPfizerFindaProvider();
	if(pfizerfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.PFIZER_FIND_A_PROVIDER, pfizerfindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail(" Provider page not found");
	} 
           
}

@And("^user clicks on site map on Pfizer Provider Page$")
public void pfizersitemapclick() {
	PfizerFindaProviderPage pfizerproviderpage= (PfizerFindaProviderPage)getLoginScenario().getBean(PageConstants.PFIZER_FIND_A_PROVIDER);
	
	PfizerSiteMapPage pfizersitemap = pfizerproviderpage.pfizersitemapclick();
	if(pfizersitemap!= null){
		getLoginScenario().saveBean(PageConstants.PFIZER_SITE_MAP,
				pfizersitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on Pfizer Site Map Page and rally provider tool opens$")
public void pfizersitemapproviderclick(){
	
	PfizerSiteMapPage pfizersitemaprally= (PfizerSiteMapPage)getLoginScenario().getBean(PageConstants.PFIZER_SITE_MAP);
	Rallytool_Page rallytool = pfizersitemaprally.findaproviderpfizersitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Given("^user navigates to UHC North Carolina Home Page$")

public void ncshphomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	NcshpHomePage ncshp = new NcshpHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.NCSHP_HOME_PAGE, ncshp);

}

@And("^user clicks on Find a Provider link on North Carolina Home Page and rally tool opens in new tab$")

public void ncshpproviderlinkclick () {
	NcshpHomePage ncshpproviderlink= (NcshpHomePage)getLoginScenario().getBean(PageConstants.NCSHP_HOME_PAGE);
	
	Rallytool_Page rallytool = ncshpproviderlink.ncshphomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user switches back to North Carolina Home Page$")

public void backToNcshpHomePage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	NcshpHomePage ncshp = rally.switchBackToNcshpHomePage();
	if(ncshp!= null){
		getLoginScenario().saveBean(PageConstants.NCSHP_HOME_PAGE, ncshp);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on Find a Provider tab on North Carolina Home Page$")

public void ncshpprovidertabclick () {
	NcshpHomePage ncshpprovidertab= (NcshpHomePage)getLoginScenario().getBean(PageConstants.NCSHP_HOME_PAGE);
	
	NcshpFindaProviderPage ncshpfindaprovider = ncshpprovidertab.ncshpprovidertabclick();
	if(ncshpfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.NCSHP_FIND_A_PROVIDER,
				ncshpfindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	

}

@Then("^user clicks on Find a Physician Medical Group Clinic or Facility link on North Carolina Provider Page and Rally tool opens$")
public void ncshpfindphysician(){
	
	NcshpFindaProviderPage ncshpfindaprovider = (NcshpFindaProviderPage)getLoginScenario().getBean(PageConstants.NCSHP_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = ncshpfindaprovider.findaphysicianncshpclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user again switches back to North Carolina Provider Page$")
public void backToNcshpProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	NcshpFindaProviderPage ncshpfindaprovider = rally.switchBackToNcshpFindaProvider();
	if(ncshpfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.NCSHP_FIND_A_PROVIDER, ncshpfindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail(" Provider page not found");
	} 
           
}

@And("^user clicks on site map on North Carolina Provider Page$")
public void ncshpsitemapclick() {
	NcshpFindaProviderPage ncshpproviderpage= (NcshpFindaProviderPage)getLoginScenario().getBean(PageConstants.NCSHP_FIND_A_PROVIDER);
	
	NcshpSiteMapPage ncshpsitemap = ncshpproviderpage.ncshpsitemapclick();
	if(ncshpsitemap!= null){
		getLoginScenario().saveBean(PageConstants.NCSHP_SITE_MAP,
				ncshpsitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on North Carolina Site Map Page and rally provider tool opens$")
public void ncshpsitemapproviderclick(){
	
	NcshpSiteMapPage ncshpsitemaprally= (NcshpSiteMapPage)getLoginScenario().getBean(PageConstants.NCSHP_SITE_MAP);
	Rallytool_Page rallytool = ncshpsitemaprally.findaproviderncshpsitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}





@Given("^user navigates to UHC Retiree UAW Trust Home Page$")

public void uawtrusthome() {
	WebDriver wd = getLoginScenario().getWebDriver();
	UawHomePage uawhomepage = new UawHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.UAW_HOME_PAGE, uawhomepage);

} 

@And("^user clicks on the Find a Provider link on UAW Trust Home Page Home Page and rally tool opens in new tab")

public void uawfindaproviderclick() {
	
	UawHomePage uawhomepage = (UawHomePage)getLoginScenario().getBean(PageConstants.UAW_HOME_PAGE);
	Rallytool_Page rallytool= uawhomepage.uawfindaproviderclick();
	if (rallytool!= null)
	{
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		
	}
	
	else {
		Assert.fail("Page not found");
	}
	
	
	
	
	
}

@Then("^user switches back to the UAW Trust Home Page$")

public void switchbacktouawhomepage(){
	
	Rallytool_Page rallytool= (Rallytool_Page)getLoginScenario().getBean(PageConstants.RALLY_TOOL_PAGE);
	
	UawHomePage uawhomepage = rallytool.switchbackToUawHomePage();
	
	
	if(uawhomepage!= null){
		getLoginScenario().saveBean(PageConstants.UAW_HOME_PAGE, uawhomepage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
	
	
	
}

@And("^user clicks on the Find a Provider tab on UAW Trust Home Page$")

public void uawfindaprovidertab()
{
	UawHomePage uawhomepage = (UawHomePage)getLoginScenario().getBean(PageConstants.UAW_HOME_PAGE);
	
	UawProviderPage uawproviderpage = uawhomepage.uawfindaprovidertabclick();
	
	if(uawproviderpage!=null){
		
		getLoginScenario().saveBean(PageConstants.UAW_PROVIDER_PAGE,
				uawproviderpage);
		Assert.assertTrue(true);
		
	}
	
	else {
		Assert.fail("Page not found");
	}
		
	}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on UAW Trust Provider Page and Rally tool opens$")

public void uawfindaphysicianlink()
{
	UawProviderPage uawproviderpage =(UawProviderPage)getLoginScenario().getBean(PageConstants.UAW_PROVIDER_PAGE);
	
	
	
	Rallytool_Page rallytool= uawproviderpage.uawfindaphysicianclick();
	if (rallytool!= null)
	{
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		
	}
	
	else {
		Assert.fail("Page not found");
	}
	
}

@Then("^user again switches back to UAW Trust Provider Page$")

public void backtouawproviderpage()
{
	Rallytool_Page rallytool= (Rallytool_Page)getLoginScenario().getBean(PageConstants.RALLY_TOOL_PAGE);
	
	UawProviderPage uawproviderpage = rallytool.switchbacktouawproviderpage();
	
	if(uawproviderpage!= null){
		getLoginScenario().saveBean(PageConstants.UAW_PROVIDER_PAGE, uawproviderpage);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
	
	
}

@And("^user clicks on site map on UAW Trust Provider Page")

public void uawsitemaplink(){

UawProviderPage uawproviderpage =(UawProviderPage)getLoginScenario().getBean(PageConstants.UAW_PROVIDER_PAGE);

UawSiteMapPage uawsitemappage= uawproviderpage.uawsitemaplinkclick(); 

if (uawsitemappage!= null)
{
	getLoginScenario().saveBean(PageConstants.UAW_SITE_MAP_PAGE,
			uawsitemappage);
	Assert.assertTrue(true);
	
}

else {
	Assert.fail("Page not found");
}
}

@Then("^user clicks on find a provider link on UAW Trust Site Map Page and rally provider tool opens$")

public void uawsitemapfindaprovider()
{
	UawSiteMapPage uawsitemappage = (UawSiteMapPage)getLoginScenario().getBean(PageConstants.UAW_SITE_MAP_PAGE);
	Rallytool_Page rallytool = uawsitemappage.uawsitemapfindaproviderclick();
	
	if (rallytool!= null)
	{
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
		
	}
	
	else {
		Assert.fail("Page not found");
	}
	
}
	
@Given("^user navigates to UHC Retiree Illinois Home Page$")

public void illinoishomepage() {
	WebDriver wd = getLoginScenario().getWebDriver();
	IllinoisHomePage illinois = new IllinoisHomePage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


	getLoginScenario().saveBean(PageConstants.ILLINOIS_HOME_PAGE, illinois);

}

@And("^user clicks on the Find a Provider link on Illinois Home Page and rally tool opens in new tab$")

public void illinoisproviderlinkclick () {
	IllinoisHomePage illinoisproviderlink= (IllinoisHomePage)getLoginScenario().getBean(PageConstants.ILLINOIS_HOME_PAGE);
	
	Rallytool_Page rallytool = illinoisproviderlink.illinoishomepageproviderclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user switches back to the Illinois Home Page$")

public void backToHomeillinoisPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	IllinoisHomePage illinois = rally.switchillinoisBack();
	if(illinois!= null){
		getLoginScenario().saveBean(PageConstants.ILLINOIS_HOME_PAGE, illinois);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on the Find a Provider tab on illinois home page$")

public void illinoisprovidertabclick () {
	IllinoisHomePage illinoisprovidertab= (IllinoisHomePage)getLoginScenario().getBean(PageConstants.ILLINOIS_HOME_PAGE);
	
	IllinoisFindaProviderPage illinoisfindaprovider = illinoisprovidertab.illinoisprovidertabclick();
	if(illinoisfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.ILLINOIS_FIND_A_PROVIDER,
				illinoisfindaprovider);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
	
	
}

@Then("^user clicks on the Find a Physician Medical Group Clinic or Facility link on Illinois Provider Page and Rally tool opens$")

public void illinoisfindphysician(){
	
	IllinoisFindaProviderPage illinoisfindaproviderpage = (IllinoisFindaProviderPage)getLoginScenario().getBean(PageConstants.ILLINOIS_FIND_A_PROVIDER);
	
	Rallytool_Page rallytool = illinoisfindaproviderpage.findaphysicianillinoisclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}
@Then("^user again switches back to Illinois Provider page$")

public void backToIllinoisProviderPage()
{
	Rallytool_Page rally  = (Rallytool_Page) getLoginScenario()
			.getBean(PageConstants.RALLY_TOOL_PAGE);
	IllinoisFindaProviderPage illinoisfindaprovider = rally.switchBackToIllinoisFindaProvider();
	if(illinoisfindaprovider!= null){
		getLoginScenario().saveBean(PageConstants.ILLINOIS_FIND_A_PROVIDER, illinoisfindaprovider);
		Assert.assertTrue(true);
		
	} else {
		Assert.fail("Home page not found");
	} 
           
}

@And("^user clicks on site map on Illinois Provider page$")

public void illinoissitemapclick() {
	IllinoisFindaProviderPage illinoisproviderpage= (IllinoisFindaProviderPage)getLoginScenario().getBean(PageConstants.ILLINOIS_FIND_A_PROVIDER);
	
	IllinoisSiteMapPage illinoissitemap = illinoisproviderpage.illinoissitemapclick();
	if(illinoissitemap!= null){
		getLoginScenario().saveBean(PageConstants.ILLINOIS_SITE_MAP,
				illinoissitemap);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}

@Then("^user clicks on find a provider link on Illinois Site Map Page and rally provider tool opens$")

public void illinoissitemapproviderclick(){
	
	IllinoisSiteMapPage illinoissitemaprally= (IllinoisSiteMapPage)getLoginScenario().getBean(PageConstants.ILLINOIS_SITE_MAP);
	Rallytool_Page rallytool = illinoissitemaprally.findaproviderillinoissitemapclick();
	if(rallytool!= null){
		getLoginScenario().saveBean(PageConstants.RALLY_TOOL_PAGE,
				rallytool);
		Assert.assertTrue(true);
	} else {
		Assert.fail(" Page not found");
	}
}
}





	














