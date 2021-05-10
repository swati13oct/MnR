/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.acquisition.commonpages.GlobalWebElements;

public class PlanRecommendationEngineNewResultsPage extends GlobalWebElements {

	public PlanRecommendationEngineNewResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}
	
	String flow;
	ArrayList<String> DrugsInPRE;
	ArrayList<String> DocInPRE;
	ArrayList<String> DrugsInDCE;
	ArrayList<String> DrugsList = new ArrayList<String>();
	ArrayList<String> ModelDrugsList = new ArrayList<String>();
	static ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> vppResults = new ArrayList<String>();		
	static ArrayList<String> vppProviderResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults1 = new ArrayList<String>();
	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	public WebElement drugCoveredeVPP;
	PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Results loading page Elements

	@FindBy(css = "#loadingText")
	private WebElement resultsloadingTitle;

	@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(2)>img")
	private WebElement svgAnimation;

	@FindBy(css = "div>img[alt*='Loading Plan Recommendations']")
	private WebElement loadingImage;

//Result Page Elements
	
	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;
	
	@FindBy(css = "div[class*='resultsPre'] h1")
	private WebElement planZipInfo;
	
	@FindBy(css = "label[for*='recommendSort']")
	private WebElement sortByLabel;
	
	@FindBy(css = "#recommendSort option")
	private List<WebElement> sortByOptions;
	
	@FindBy(css = ".returnSection button.buttonLink")
	private List<WebElement> returnToBeginning;
	
	@FindBy(css = ".returnSection span#viewMorePlans")
	private List<WebElement> pagenoLabel;
	
	@FindBy(css = ".paginationSection button[class*='view-plans-prev disabled']")
	private List<WebElement> pagePreviousButton;
	
	@FindBy(css = ".paginationSection button[class*='view-plans-next disabled']")
	private List<WebElement> pageNextButton;
	
// Plan Tile Elements	
	
	@FindBy(css = "ul[class*='planTileSection'] li")
	private List<WebElement> plantile;

//Bottom Result page Elements	
	
	@FindBy(css = "div[class*='resourcesSection'] h2")
	private WebElement resourcesTitle;
	
	@FindBy(css = ".moreAboutPlansSection h2")
	private WebElement moreAboutPlanTypesTitle;
	
	@FindBy(css = ".moreAboutPlansSection p")
	private WebElement moreAboutPlanTypesPara;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] .accordion-title span")
	private WebElement mapdPlanTypesTitle;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] span[class*='accordion-arrow'] svg")
	private WebElement mapdPlanTypesFlipArrow;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] #accordion-content-2 p")
	private WebElement mapdPlanTypesPara;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] #accordion-content-2 button")
	private WebElement mapdPlanTypesLearnmoreLink;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] .accordion-title span")
	private WebElement madsupPlanTypesTitle;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] span[class*='accordion-arrow'] svg")
	private WebElement madsupPlanTypesFlipArrow;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] p")
	private WebElement madsupPlanTypesPara;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] button")
	private WebElement madsupPlanTypesLearnmoreLink;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] .accordion-title span")
	private WebElement pdpPlanTypesTitle;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] span[class*='accordion-arrow'] svg")
	private WebElement pdpPlanTypesFlipArrow;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] p")
	private WebElement pdpPlanTypesPara;
	
	@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] button")
	private WebElement pdpPlanTypesLearnmoreLink;
	
//Result Loading Page Element Verification Method 

	public void resultsloadingpage() {
		System.out.println("Validating Results loading Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(resultsloadingTitle);
		validate(svgAnimation);
		validate(loadingImage);
	}
	
//Results Page Element Verification Method	
	
	public void preResultsUI(String zip,String county) {
		System.out.println("Validating PRE Results UI Page: ");
		pageloadcomplete();
		waitForPageLoadSafari();
		validate(planZipInfo,60);
		Assert.assertTrue(planZipInfo.getText().contains(zip),"Invalid Zip");
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()),"Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[4])>0,"Total Plan count is less than 1");
		Assert.assertTrue(sortByLabel.getText().contains("Sort By :"),"Invalid Sort Text");
		Assert.assertTrue(resourcesTitle.getText().contains("Resources"),"Invalid Resources Text");
//		Assertion.assertTrue(returnToBeginning.get(0).getText().contains("Return to beginning"),"Invalid Return to beginning Text");
		Assert.assertTrue(moreAboutPlanTypesTitle.getText().contains("More About Plan Types"),"Invalid More About Plan Types Text");
		validate(moreAboutPlanTypesPara,60);
		Assert.assertTrue(mapdPlanTypesTitle.getText().contains("Medicare Advantage Plans (Part C)"),"Invalid MAPD Text");
		validate(mapdPlanTypesPara,60);
		Assert.assertTrue(mapdPlanTypesLearnmoreLink.getText().contains("Learn More About"),"Learn More About link not displayed");
		
		Assert.assertTrue(madsupPlanTypesTitle.getText().contains("Medicare Supplement Insurance Plans (Medigap)"),"Invalid MADSUP Text");
		validate(madsupPlanTypesPara,60);
		Assert.assertTrue(madsupPlanTypesLearnmoreLink.getText().contains("Learn More About"),"Learn More About link not displayed");
		
		Assert.assertTrue(pdpPlanTypesTitle.getText().contains("Medicare Prescription Drug Plans (Part D)"),"Invalid PDP Text");
		validate(pdpPlanTypesPara,60);
		Assert.assertTrue(pdpPlanTypesLearnmoreLink.getText().contains("Learn More About"),"Learn More About link not displayed");
		
		threadsleep(3000);
		mapdPlanTypesFlipArrow.click();
		validateNonPresenceOfElement(mapdPlanTypesLearnmoreLink);
		
		threadsleep(3000);
		madsupPlanTypesFlipArrow.click();
		validateNonPresenceOfElement(madsupPlanTypesLearnmoreLink);
		
		threadsleep(3000);
		pdpPlanTypesFlipArrow.click();
		validateNonPresenceOfElement(pdpPlanTypesLearnmoreLink);
	}
}
	
	