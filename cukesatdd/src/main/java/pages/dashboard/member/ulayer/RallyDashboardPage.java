package pages.dashboard.member.ulayer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import javafx.scene.control.ScrollToEvent;
import pages.dashboard.eob.EOBPage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.DrugCostEstimatorPage;
import pages.member.bluelayer.HealthAndWellness;
import pages.member.bluelayer.ProfilePreferencesPage;
import pages.member.redesign.ContactUsPage;
import pages.member.ulayer.OrderplanmaterialsPage;
import pages.member.ulayer.PaymentsOverview;
import pages.redesign.PharmacySearchPage;
import pages.dashboard.member.ulayer.*;
public class RallyDashboardPage extends UhcDriver{

	
	
	@FindBy(xpath="(//nav[@id='main-nav']//a[contains(text(),'Find Care')])[1]")
	private WebElement panelFindCareCost;
	
	@FindBy(xpath="(//nav[@id='main-nav']//a[contains(text(),'Premium Payments')])[1]")
	private WebElement panelPremiumPayment;
	
	@FindBy(xpath="(//nav[@id='main-nav']//a[contains(text(),'Home')])[1]")
	private WebElement panelHome;
	

	@FindBy(xpath="(//nav[@id='main-nav']//a[contains(text(),'Claims')])[1]")
	private WebElement panelClaims;
	
	@FindBy(xpath="(//nav[@id='main-nav']//a[contains(text(),'Health')])[1]")
	private WebElement panelHealth;
	
	@FindBy(xpath="//button[@id='dropdown-toggle--1']/span[contains(text(),'Profile')]")
	private WebElement accountToggleDropdown;
	
	@FindBy(xpath="//a[@class='dropdown-option' and contains(text(),'Account Settings')]")
	private WebElement accountSettingOption;
	
	@FindBy(xpath="//header//h1")
	private WebElement heading;
	
	@FindBy(xpath="//div[@id='ui-view-page']//span[contains(text(),'Look up Drugs')]")
	private WebElement DCE_Dashboard;
	
	@FindBy(xpath="//div[@id='ui-view-page']//span[contains(text(),'Claims')]")
	private WebElement Claims_Dashboard;
	
	@FindBy(xpath="//div[@id='ui-view-page']//span[contains(text(),'Find a Provider')]")
	private WebElement provider_Dashboard;

	
	
	@FindBy(xpath="//span[contains(text(),'Locate a Pharmacy')]/ancestor::a/img")
	private WebElement PharmacyLocator_Dashboard;
	
	@FindBy(className="view-id-link")
	private WebElement IDLinkDashboard;
	
	@FindBy(xpath="//div[@id='ui-view-page']//a[@track='VIEW_DOCUMENTS_AND_RESOURCES']")
	private WebElement formsResources_Dashboard;
	
	@FindBy(xpath="//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterials_Dashboard;
	
	@FindBy(xpath="//div[@id='ui-view-page']//a[@track='EOB_SEARCH']")
	private WebElement EOB_Dashboard;
	
	@FindBy(xpath="//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement OrderMaterial_Dashboard;
	
	@FindBy(className="promo-tile")
	private WebElement promoTile_Dashboard;
	
	
	@FindBy(xpath = "//h1[@class='h4 margin-none']")
	private WebElement orderplanHeadertxt;

	@FindBy(xpath="//sticky[@id='sticky-nav']//nav[@id='main-nav']//a[contains(text(),'Coverage & Benefits')]")
	private WebElement BnClink;

	@FindBy(xpath="(//nav[@id='utility-nav']//a/span[contains(text(),'Help')])[1]")
	private WebElement ContactUsLink;
	
	@FindBy(id="ordermaterials")
	private WebElement OrderPlanMaterialslnk;

	
	@FindBy(id="hello-person")
	private WebElement HelloMessage;
	
	@FindBy(id = "claimsummaryC1")
	private WebElement claimSummary;
	
	@FindBy(id = "eobC1")
	private WebElement explainationOfBenefits;
	
	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageBenefits;
	
	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;
	
	@FindBy(id = "formsandresourcesC1")
	private WebElement formsAndResources;
	
	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;
	
	@FindBy(id = "premiumpayment_3")
	private WebElement premiumPayment;
	
	@FindBy(id = "healthwellness_3")
	private WebElement healthWellness;
	
	@FindBy(id = "Help")
	private WebElement help;
	
	@FindBy(id = "accountprofile")
	private WebElement accountProfile;

	@FindBy(className = "menuL1")
	private WebElement header;
	
	@FindBy(id = "arcade-footer")
	private WebElement footerSection;
	
	@FindBy(xpath = "//*[@id='IPEinvL']/map/area[3]")
	private static WebElement FeedbackModal;
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'no']")
	private static List<WebElement> FeedbackModalList;
	
	@FindBy(linkText = "Help & Contact Us")
	private WebElement helpnContactUs;
	
	@FindBy(linkText = "Legal Notices & Disclosures")
	private WebElement legalNotices;
	
	@FindBy(linkText = "Account Settings")
	private WebElement accountnSettings;
	
	@FindBy(linkText = "Saved")
	private WebElement saved;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	@FindBy(linkText = "About UnitedHealthcare")
	private WebElement aboutUHC;
	
	@FindBy(linkText = "Legal Entity Disclosure")
	private WebElement legalDisclosures;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicy;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUse;

	@FindBy(partialLinkText = "Language Assistance | Non-Discrimination Notice")
	private WebElement languageAssistanceEnglish;
	
	@FindBy(partialLinkText = "Asistencia de Idiomas | Aviso de no Discriminación (PDF)")
	private WebElement languageAssistanceSpanish;
	
	@FindBy(xpath = "//a[starts-with(@id,'ACCdropdown_') and contains(text(),'Log Out')]")
	private WebElement NavAccountProfSignOut;

	@FindBy(xpath = "//a[starts-with(@id,'ACCdropdown_') and contains(text(),'Account Settings')]")
	private WebElement NavAccountProfSetting;
	
	@FindBy(xpath = "//h2[text() = 'Common Services & Costs']")
	private WebElement CommonCostServiceHeading;
	
	@FindBy(className = "cost-col")
	private WebElement CommonCostTable;
	
	
	
	
	// Page URL
	//private static String PAGE_URL = MRConstants.TeamH_ULayer_Member_URL;
	
	public RallyDashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		CommonUtility.waitForPageLoad(driver, panelHome, 60);		
		validate(panelClaims);
		validate(panelHome);
		validate(HelloMessage);
	}	
	
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException
	{
		System.out.println("Inside navigateToPaymentOverview functions");
/*		waitforElement(panelFindCareCost, 60);
		if(panelClaims.isEnabled()){
			panelClaims.click();*/
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//waitforElement(panelPremiumPayment, 60);
			validate(panelPremiumPayment);
			panelPremiumPayment.click();
			CommonUtility.checkPageIsReady(driver);
			if (driver.getTitle().equalsIgnoreCase("Overview")) {
				return new PaymentsOverview(driver);	
			}			
		//}
		return null;
	}
	public pages.member.bluelayer.ProfilePreferencesPage navigateDirectToProfilePage() {
		System.out.println(driver.getTitle());
		validate(accountToggleDropdown);
		accountToggleDropdown.click();
		validate(accountSettingOption);
		accountSettingOption.click();
		CommonUtility.checkPageIsReady(driver);
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			 System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
		}
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");*/
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}
	
	public BenefitsAndCoveragePage navigateDirectToBnCPag() {
		
		validate(BnClink);
		BnClink.click();

		 CommonUtility.checkPageIsReady(driver);
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}

	public ContactUsPage navigateToContactUsPage() {
		validate(ContactUsLink);
		ContactUsLink.click();
		CommonUtility.waitForPageLoad(driver, heading, 10);
		if(driver.getTitle().equalsIgnoreCase("Overview"))
		{
			return new ContactUsPage(driver);
		}
		return null;
	}
	
	public DrugCostEstimatorPage navigateToDCEPage() throws InterruptedException {
		validate(DCE_Dashboard);
		DCE_Dashboard.click();
		CommonUtility.checkPageIsReady(driver);
	    //Thread.sleep(10000);
		if (driver.getTitle().contains("Overview")) {
			return new DrugCostEstimatorPage(driver);
		}
		return null;
	}
	
	public HealthAndWellness clickHealthnWellnessTab(){
		validate(panelHealth);
			panelHealth.click();
			CommonUtility.checkPageIsReady(driver);
			/*try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			if (driver.getTitle().contains("Health")) {
				return new HealthAndWellness(driver);
			}
			return null;

	}
	public OrderplanmaterialsPage navigateToOrderPlanMaterialsPage() {
		//driver.navigate().to("https://"+MRScenario.environment+"-medicare.uhc.com/content/medicare/member/order-materials/overview.html");
		/*validate(BnClink);
		BnClink.click();*/
		validate(OrderMaterial_Dashboard);
		OrderMaterial_Dashboard.click();
		//CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, orderplanHeadertxt, 30);
		if (orderplanHeadertxt.isDisplayed()) {
			return new OrderplanmaterialsPage(driver);
		}
		return null;
	}
	public PharmacySearchPage navigateToPharmacyLocator() throws InterruptedException {
				
				CommonUtility.checkPageIsReady(driver);
				PharmacyLocator_Dashboard.click();
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				CommonUtility.checkPageIsReady(driver);

				System.out.println(driver.getTitle());
				
				if (driver.getTitle().contains("Pharmacy")) {
					return new PharmacySearchPage(driver);
				}
				return null;
	}
	
	public ClaimSummarypage navigateToClaimsSummaryPage() {
		CommonUtility.checkPageIsReady(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		validate(Claims_Dashboard);
		Claims_Dashboard.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummarypage(driver);	
		}
		return null;
	}	
	
	public void validateHomeTab() {
		CommonUtility.checkPageIsReady(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		scrollToView(panelHome);
/*		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-200)", "");*/
		panelHome.click();
		CommonUtility.checkPageIsReady(driver);
		validate(HelloMessage);
	}	
	public ProviderSearchPage validateFindCareCostTab() {
		CommonUtility.checkPageIsReady(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		panelFindCareCost.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().contains("Find Care")) {
			return new ProviderSearchPage(driver);	
		}
		return null;
	}	
	public pages.dashboard.member.ulayer.ClaimSummarypage panelNavigateToClaimsSummaryPage() {
		CommonUtility.checkPageIsReady(driver);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		panelClaims.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new pages.dashboard.member.ulayer.ClaimSummarypage(driver);	
		}
		return null;
	}	
	
	public void validateClaimsL2Tabs(){
		
			Assert.assertTrue("claimSummary is not displayed", claimSummary.isDisplayed());
			Assert.assertTrue("explainationOfBenefits is not displayed", explainationOfBenefits.isDisplayed());
		}
	
	public void validateEobL2Tab(){
		validate(explainationOfBenefits);
		explainationOfBenefits.click();
		CommonUtility.checkPageIsReady(driver);
		if (!(driver.getTitle().equalsIgnoreCase("EOB Search"))) {
		Assert.fail("EOB page not getting displayed");	
		}
	}
	public void validateCoverageBenefitsL2Tabs(){
		validate(coverageBenefits);
			Assert.assertTrue("benefitsSummary is not displayed", benefitsSummary.isDisplayed());
			Assert.assertTrue("formsAndResources is not displayed", formsAndResources.isDisplayed());
			Assert.assertTrue("orderMaterials is not displayed", orderMaterials.isDisplayed());
		}
	
public BenefitsAndCoveragePage validateBnCNaviation() {
		
		//driver.navigate().to(PAGE_URL);
		validate(coverageBenefits);
		coverageBenefits.click();
        validate(benefitsSummary);
        benefitsSummary.click();
		CommonUtility.checkPageIsReady(driver);
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		if (driver.getTitle().equalsIgnoreCase("Benefits Overview")) {
			return new BenefitsAndCoveragePage(driver);
		}
		return null;
	}

public PaymentsOverview validatePremiumPaymentPage() throws InterruptedException
{
	System.out.println("Inside navigateToPaymentOverview functions");
/*		waitforElement(panelFindCareCost, 60);
	if(panelClaims.isEnabled()){
		panelClaims.click();*/
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		validate(premiumPayment);
		premiumPayment.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Overview")) {
			return new PaymentsOverview(driver);	
		}			
	//}
	return null;
}

public void validateContactUsPage() {
	validate(help);
}

public void validateAccountProfile(){
	Assert.assertTrue("Account/Profile tab is not displayed", accountProfile.isDisplayed());
	accountProfile.click();
	validate(NavAccountProfSignOut);
	validate(NavAccountProfSetting);
	scrollToView(accountProfile);
			accountProfile.click();
}

public OrderplanmaterialsPage validateOrderPlanMaterialsPage() {
	orderMaterials.click();
	CommonUtility.checkPageIsReady(driver);
	if (orderplanHeadertxt.isDisplayed()) {
		return new OrderplanmaterialsPage(driver);
	}
	return null;
}

public HealthAndWellness validateHealthnWellnessPage(){
	validate(healthWellness);
	healthWellness.click();
	CommonUtility.checkPageIsReady(driver);
		/*try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if (driver.getTitle().contains("Health")) {
			return new HealthAndWellness(driver);
		}
		return null;

}

public void validateFooterSection(){
	JavascriptExecutor jse = (JavascriptExecutor) driver; 
	jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
	validate(footerSection);
	Assert.assertTrue("Footer section is not displayed", footerSection.isDisplayed());
}

public void validateMemberSupport(){
//	List<WebElement> footerColumn = driver.findElements(By.id("memberSupportID"));
//	System.out.println(footerColumn.size());
//	String memberSupportText = footerColumn.get(0).getText();
//	Assert.assertTrue("Member Support is not displayed", memberSupportText.contains("Member Support"));
//	Assert.assertTrue("Help & Contact Us link is not displayed", memberSupportText.contains("Help & Contact Us"));
//	Assert.assertTrue("Legal Notices & Disclosures link is not displayed", memberSupportText.contains("Legal Notices & Disclosures"));
	JavascriptExecutor jse = (JavascriptExecutor) driver; 
	jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
	validate(helpnContactUs);
	Assert.assertTrue("Help & Contact Us link is not clickable", helpnContactUs.isDisplayed());
	Assert.assertTrue("legal notices and disclaimer link is not clickable", legalNotices.isDisplayed());
	validateMemberSupportFooterLinks();
}

public void validateMemberSupportFooterLinks(){
//	List<WebElement> footerlinksColumn = driver.findElements(By.id("footerLinksID"));
//	System.out.println(footerlinksColumn.size());
//	String memberSupportFooterLinkText = footerlinksColumn.get(0).getText();
	//System.out.println(memberSupportFooterLinkText);
	Assert.assertTrue("About link is not displayed", aboutUHC.isDisplayed());
	Assert.assertTrue("Legal Disclosures link is not displayed", legalDisclosures.isDisplayed());
	Assert.assertTrue("Privacy Policy link is not displayed", privacyPolicy.isDisplayed());
	Assert.assertTrue("Terms of Use link is not displayed", termsOfUse.isDisplayed());
}

public void validateQuickLinksFooterLinks(){
//	List<WebElement> footerlinksColumn = driver.findElements(By.id("footerLinksID"));
//	System.out.println(footerlinksColumn.size());
//	String quickLinksFooterLinkText = footerlinksColumn.get(1).getText();
	//System.out.println(quickLinksFooterLinkText);
	Assert.assertTrue("Language Assistance english link is not displayed", languageAssistanceEnglish.isDisplayed());
	Assert.assertTrue("Language Assistance Spanish is not displayed", languageAssistanceSpanish.isDisplayed());
	
}

public void validateQuickLinks(){
//	List<WebElement> footerColumn = driver.findElements(By.id("memberSupportID"));
//	System.out.println(footerColumn.size());
//	String quickLinksText = footerColumn.get(1).getText();
//	System.out.println(quickLinksText);
//	Assert.assertTrue("Quick Links is not displayed", quickLinksText.contains("Quick Links"));
//	Assert.assertTrue("Account and settings link is not displayed", quickLinksText.contains("ACCOUNT SETTINGS"));
//	Assert.assertTrue("Saved is not displayed", quickLinksText.contains("SAVED"));
//	Assert.assertTrue("Logout link is not displayed", quickLinksText.contains("LOG OUT"));
	Assert.assertTrue("Account and Settings link is not clickable", accountnSettings.isDisplayed());
	Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
	Assert.assertTrue("Logout link is not clickable", logout.isDisplayed());
	validateQuickLinksFooterLinks();
}

public static void checkModelPopup(WebDriver driver) {
		int counter =0;

		System.out.println("Initial value of conter: "+counter);
	//	WebDriverWait wait = new WebDriverWait(driver, 15);
		/*try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='IPEinvL']/map/area[3]")));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='IPEinvL']/map/area[3]")));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
	//	String ParentHandle = driver.getWindowHandle();
		do{
			
			System.out.println("current value of conter: "+counter);
			
			if(driver.findElements(By.xpath("//area[@href='javascript:clWin()'][@alt = 'no']")).isEmpty()){
			//if(driver.findElements(By.xpath("//*[@id='IPEinvL']/map/area[3]")).isEmpty()){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				
			}
		
			else{
				System.out.println("FeedBack Modal Present and counter value is:"+counter);
				try {Thread.sleep(2000);
					WebElement NoThanks = driver.findElement(By.xpath("//*[@id='IPEinvL']/map/area[3]"));
					JavascriptExecutor js = (JavascriptExecutor)driver;
		    		js.executeScript("arguments[0].scrollIntoView();", NoThanks);
		    		js.executeScript("arguments[0].click();", NoThanks);
		    		//driver.switchTo().window(ParentHandle);
		    		break;
				//driver.findElement(By.xpath("//area[@href='javascript:clWin()'][@alt = 'no']")).click();				
					//Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			counter++;
		}
		while(counter<1);
}

public void validateSavedLink(){
	Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
}

public EOBPage navigateToEOBPage() {
	validate(EOB_Dashboard);
	EOB_Dashboard.click();
	CommonUtility.checkPageIsReady(driver);
	if (!(driver.getTitle().equalsIgnoreCase("EOB Search"))) {
	Assert.fail("EOB page not getting displayed");	
	return null;
	}
	else{
		CommonUtility.waitForPageLoad(driver, heading, 10);
		return new EOBPage(driver);
	}
}

public ProviderSearchPage navigateToProviderSearch(){
	CommonUtility.checkPageIsReady(driver);
	CommonUtility.waitForPageLoad(driver, provider_Dashboard, 60);
	validate(provider_Dashboard);
	provider_Dashboard.click();
	CommonUtility.checkPageIsReady(driver);
	if (driver.getTitle().contains("Find Care")) {
		return new ProviderSearchPage(driver);	
	}
	return null;
}

public void validateDashboardElements(String Category){
	CommonUtility.checkPageIsReady(driver);
	if(!(("Ship").equalsIgnoreCase(Category))){
	validate(panelFindCareCost);
	}
	if(!(("GroupRetireeMapd").equalsIgnoreCase(Category))){
	validate(panelPremiumPayment);
	}
	validate(panelClaims);
	validate(panelHealth);
	validate(accountToggleDropdown);
	validate(Claims_Dashboard);
	validate(IDLinkDashboard);
	validate(CommonCostServiceHeading);
	validate(CommonCostTable);
	validate(formsResources_Dashboard);
	validate(OrderMaterials_Dashboard);
	validate(promoTile_Dashboard);
	validate(ContactUsLink);
	validate(HelloMessage);
	validate(helpnContactUs);
	validate(accountnSettings);
	
}

}