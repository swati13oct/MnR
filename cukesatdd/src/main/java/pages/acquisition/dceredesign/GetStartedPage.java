
package pages.acquisition.dceredesign;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.acquisition.dceredesign.BuildYourDrugList;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PrescriptionsProvidersBenefitsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;

public class GetStartedPage extends UhcDriver {

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]")
	public WebElement LinktoExitScenario;

	@FindBy(xpath = "//*[contains(@id,'get-started')]")
	public WebElement getStartedTab;

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//body/div[@id='overlay']")
	private WebElement overlayFilm;

	@FindBy(css = "a#visitor-profile-header")
	private WebElement lnkProfile;

	@FindBy(xpath = "//a[@class='uhc-link-button']/span")
	private WebElement breaCrumbLink;
	
	@FindBy(xpath = "//span[contains(@class,'back-to-view-all-pla')]")
	private WebElement backToHomeLink;
	
	@FindBy(xpath = "//label[text()='Search query']//following-sibling::input[1]")
	public WebElement YahooSearchField;

	@FindBy(xpath = "//a[contains(text(),'Be right back')]")
	public WebElement YahooSearchResult;
	
	@FindBy(xpath = "//h3[contains(text(),'Estimate Your Drug Costs')]")
	public WebElement googleSearchResult;
	
	@FindBy(xpath = "//button[@type='button']//following-sibling::input[1]")
	public WebElement YahooSearchBttn;
	
	@FindBy(xpath = "//*[contains(@title,'Search')]")
	public WebElement GoogleSearchField;

	@FindBy(xpath = "//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")
	public WebElement GoogleSearchButton;

	public GetStartedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		openAndValidate();
	}
	
	public GetStartedPage(WebDriver driver, boolean isSearchEngine) {
		super(driver);
		PageFactory.initElements(driver, this);
		System.out.println("dce from search engine");
	}


	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 45);
		else
			checkModelPopup(driver, 10);
		validateNew(getStartedTab);
	}

	public BuildYourDrugList clickAddsDrugs() {

		if (validate(AddMyDrugsBtn))
//			AddMyDrugsBtn.click();
			jsClickNew(AddMyDrugsBtn);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public VPPPlanSummaryPage ClickReturnToBtnToVPPSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		CommonUtility.checkPageIsReadyNew(driver);

//		while(validate(overlayFilm, 10)) {/**wait*/}
//		CommonUtility.waitForElementToDisappear(driver, overlayFilm, 75);
		waitForPageLoadSafari();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	/*public pages.acquisition.bluelayer.VPPPlanSummaryPage ClickReturnToBtnToVPPSummary_UHC() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}*/

	public VisitorProfilePage clickOnShoppingCart() {
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		threadsleep(2000);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public PrescriptionsProvidersBenefitsPage clickReturnToAcqHomePAge() {
		driver.close();
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		waitForPageLoadSafari();
		threadsleep(5000);
		if (driver.getCurrentUrl().contains("medicare-education")) {
			return new PrescriptionsProvidersBenefitsPage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage ClickReturnToPlanSummary() {
		validateNew(LinktoExitScenario);
		jsClickNew(LinktoExitScenario);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void validateBreadCrumb(String breadCrumb) {
		Assert.assertTrue("Expected breadcrumb "+ breadCrumb+" is not displayed",breaCrumbLink.getText().equals(breadCrumb));
		        }
		        
		        
public void yahooSearch(String searchParameter) {
		
		CommonUtility.waitForPageLoad(driver, YahooSearchField, 30);
		YahooSearchField.sendKeys(searchParameter);
		CommonUtility.waitForPageLoad(driver, YahooSearchBttn, 30);
		YahooSearchBttn.click();
		System.out.println("Yahoo Search entered for :"+searchParameter);

		CommonUtility.waitForPageLoad(driver, YahooSearchResult, 30);
		if(YahooSearchResult.isDisplayed())
			System.out.println("Yahoo search result found");
		else {
			System.out.println("yahoo search result not found");
			Assert.assertFalse("no yahoo search result found", false);
		}
		YahooSearchResult.click();
		System.out.println("Yahoo Results - Get started - Link Clicked");
		switchToNewTab();
		
	}
	
	public void googleSearch(String searchParameter) {
		
		

		CommonUtility.waitForPageLoad(driver, GoogleSearchField, 30);
		
		GoogleSearchField.sendKeys(searchParameter + Keys.ENTER);
		System.out.println("Google Search entered for :"+searchParameter);
		CommonUtility.waitForPageLoad(driver, googleSearchResult, 30);
		if(googleSearchResult.isDisplayed())
			System.out.println("Google search result found");
		else {
			System.out.println("Google search result not found");
			Assert.assertFalse("no Google search result found", false);
		}
		googleSearchResult.click();
		System.out.println("Google Results - Get started - Link Clicked");
		//switchToNewTab();
		
	}
	
	
	public void openUrl(String url) {
		// TODO Auto-generated method stub
		start(url);
		}
	
	public boolean homeLinkIsVisibleAndClicked() {
		
		if(backToHomeLink.isDisplayed()){
			backToHomeLink.click();
			if(driver.getTitle().contains("ARP Medicare Plans from UnitedHealthcare") || driver.getTitle().contains("Medicare Coverage Options from UnitedHealthcare")){
				return true;
			}	else{
				Assert.assertTrue("Home page is reached", false);
				return false;
			}
		}else{
			Assert.assertTrue("Return to home link is not visible", false);
			return false;
		}
		
	}

}

