/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class ResultsMobilePage extends UhcDriver {

	public ResultsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.resultsPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	@FindBy(css = "#selectCounty p>a")
	private List<WebElement> selectMultiZip;
	
	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;
	
	@FindBy(css = ".plan-overview-wrapper>div[class='overview-main']>h2")
	private WebElement planZipInfo;

	@FindBy(css = ".plan-overview-wrapper>div[class='overview-main']")
	private WebElement planBasedInfo;

	@FindBy(css = "div[data-rel='#plan-list-1']")
	private WebElement MAPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-1'] span.ng-binding")
	private WebElement MAPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-1'] a")
	private WebElement MAViewPlansLink;

	@FindBy(css = "div[data-rel='#plan-list-1'] .title small")
	private WebElement MAViewPlansTab;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview h3")
	private List<WebElement> MAPlansName;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview div.plan-name-div")
	private List<WebElement> MAPlansId;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement MA1stPlan;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement MA1stPlanName;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) .enroll-details>a:nth-of-type(2)")
	private WebElement MA1stPlanEnroll;

	@FindBy(css = "div[data-rel='#plan-list-2']")
	private WebElement MSPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-2'] span.ng-binding")
	private WebElement MSPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-2'] a")
	private WebElement MSViewPlansLink;

	@FindBy(css = "#msVppDOB")
	private WebElement MSPlanDOB;

	@FindBy(xpath = "//form/div/div[@class='inputcomponent section'][3]//label[contains(text(),'Male')]")
	private WebElement MSPlanGender;

	@FindBy(css = "#mpaed-month")
	private WebElement MSPlanPartAMonth;

	@FindBy(css = "#mpaed-year")
	private WebElement MSPlanPartAYear;

	@FindBy(css = "#mpbed-month")
	private WebElement MSPlanPartBMonth;

	@FindBy(css = "#mpbed-year")
	private WebElement MSPlanPartBYear;

	@FindBy(css = "#msVppdpsd")
	private WebElement MSPlanStartMonth;

	@FindBy(css = "button[class*='viewPlans']")
	private WebElement MSViewPlanButton;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement MS1stPlan;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1) h2")
	private WebElement MS1stPlanName;

	@FindBy(css = "#mainBody .swiper-container .module-plan-overview:nth-of-type(1) .swiper-content>a")
	private WebElement MS1stPlanEnroll;

	@FindBy(css = "div[data-rel='#plan-list-3']")
	private WebElement PDPPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-3'] span.ng-binding")
	private WebElement PDPPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-3'] a")
	private WebElement PDPViewPlansLink;

	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement PDP1stPlan;

	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview h3")
	private List<WebElement> PDPPlansName;
	
	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview h3")
	private List<WebElement> PDPPlansId;
	
	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement PDP1stPlanName;

	@FindBy(css = "#plan-list-3 .swiper-container .module-plan-overview:nth-of-type(1) .enrollment>div>a")
	private WebElement PDP1stPlanEnroll;

	@FindBy(css = "div[data-rel='#plan-list-4']")
	private WebElement SNPPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-4'] span.ng-binding")
	private WebElement SNPPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-4'] a")
	private WebElement SNPViewPlansLink;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1)")
	private WebElement SNP1stPlan;
	
	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview h3")
	private List<WebElement> SNPPlansName;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview div.plan-name-div")
	private List<WebElement> SNPPlansId;
	
	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement SNP1stPlanName;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1) .enroll-details>a:nth-of-type(2)")
	private WebElement SNP1stPlanEnroll;

	@FindBy(xpath = "//div[@class='uhc-container']//h2[contains(text(),'Need Help?')]")
	private WebElement needhelptxt;
	
	@FindBy(xpath = "//div[@class='uhc-container']//h4[contains(text(),'Need Help?')]")
	private WebElement needhelptxtMS;

	@FindBy(css = "input#cta-zipcode")
	private WebElement homePageZiptxt;

	@FindBy(css = "button#zipcodebtn")
	private WebElement homePageFindPlans;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a.add-provider")
	private WebElement enterProvidersInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a[id*='provider-title']")
	private WebElement providersInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) div[id*='ProviderName']")
	private List<WebElement> providersListMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a.add-drug")
	private WebElement enterDrugInfoMA1stPlan;

	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) a[id*='drug-list-title']")
	private WebElement drugsInfoMA1stPlan;
	
	@FindBy(css = "#plan-list-1 .swiper-container .module-plan-overview:nth-of-type(1) div[id*='DrugName']")
	private List<WebElement> drugsListMA1stPlan;
	
	@FindBy(css = "a#selector")
	private WebElement startnowButton;
	
	@FindBy(css = "#plan-list-3 button#editMyAnswers")
	private WebElement pdpstartoverButton;
	
	@FindBy(css = "#startoverPopUp button:nth-of-type(2)")
	private WebElement modalstartoverButton;
	
	@FindBy(css = "#plan-list-3 a.emailsummary")
	private WebElement pdpemailList;
	
	@FindBy(css = "#plan-list-1 a.emailsummary")
	private WebElement maemailList;
	
	@FindBy(css = "#plan-list-4 a.emailsummary")
	private WebElement snpemailList;
	
	@FindBy(css = "#emailPlanSummaryPopUp #email")
	private WebElement emailText;
	
	@FindBy(css = "#emailPlanSummaryPopUp button[type='submit']")
	private WebElement emailSendButton;
	
	@FindBy(css = "#emailSuccessSummaryMsgPopUp #emailSuccess")
	private WebElement emailSuccess;
	
	@FindBy(css = "#emailSuccessSummaryMsgPopUp button")
	private WebElement emailCloseButton;
	
	@FindBy(css = "a.back-to-plans")
	private WebElement backtoPlans;
	
	public void resultsUI(String zip, String county, String R1, String R2, boolean tie) {
		System.out.println("Validating Results UI Page: ");
		plansLoader();
		Assert.assertTrue(planZipInfo.getText().contains(zip),"Invalid Zip");
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()),"Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[2]) > 0, "Total Plan count is less than 1");
		String recom = "Recommended";
		String recom1 = "#1 Recommendation";
		String recom2 = "#2 Recommendation";
		if (tie == false) {
			checkRecommendationCount(R1, recom1, R2, recom2);
			validateRecommendations(R1, recom1, R2, recom2);
			validateRecommendationPlan(R1);
		} else {
			if (R1.isEmpty()) {
				checkTieRecommendationCount("", recom1, "");
			} else if (R2.isEmpty()) {
				checkTieRecommendationCount(R1, recom1, "");
				validateRecommendations(R1, recom1, "", "");
			} else {
				checkTieRecommendationCount(R1, recom, R2);
				validateRecommendations(R1, recom, R2, recom);
			}
		}
	}

	public void validateRecommendations(String R1, String rcom1, String R2, String rcom2) {
		System.out.println("Validating Recommendations in Results Page");
		if (R1.equalsIgnoreCase("MA")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Advantage"));
			Assert.assertTrue(MAPlanInfo.getText().contains(rcom1), "MA Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MAPlanCount.getText()) > 0, "MA Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("MS")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Supplement"));
			Assert.assertTrue(MSPlanInfo.getText().contains(rcom1), "MS Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MSPlanCount.getText()) > 0, "MS Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("PDP")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Prescription Drug"));
			Assert.assertTrue(PDPPlanInfo.getText().contains(rcom1), "PDP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(PDPPlanCount.getText()) > 0, "PDP Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("SNP")) {
			Assert.assertTrue(planBasedInfo.getText().contains("Medicare Special Needs"));
			Assert.assertTrue(SNPPlanInfo.getText().contains(rcom1), "SNP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(SNPPlanCount.getText()) > 0, "SNP Plan count is less than 1");
		}
		// Verify 2nd Recommendation
		if (R2.equalsIgnoreCase("MA")) {
			Assert.assertTrue(MAPlanInfo.getText().contains(rcom2), "MA Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MAPlanCount.getText()) > 0, "MA Plan count is less than 1");
		}
		if (R2.equalsIgnoreCase("MS")) {
			Assert.assertTrue(MSPlanInfo.getText().contains(rcom2), "MS Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MSPlanCount.getText()) > 0, "MS Plan count is less than 1");
		}
		if (R2.equalsIgnoreCase("PDP")) {
			Assert.assertTrue(PDPPlanInfo.getText().contains(rcom2), "PDP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(PDPPlanCount.getText()) > 0, "PDP Plan count is less than 1");
		}
		if (R2.equalsIgnoreCase("SNP")) {
			Assert.assertTrue(SNPPlanInfo.getText().contains(rcom2), "SNP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(SNPPlanCount.getText()) > 0, "SNP Plan count is less than 1");
		}
	}

	public void checkRecommendationCount(String R1, String rcom1, String R2, String rcom2) {
		System.out.println("Verifying Recommendation counts");
		int R1Count = 0, R2Count = 0;
		if (MAPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (MSPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (PDPPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (SNPPlanInfo.getText().contains(rcom1))
			R1Count++;
		if (MAPlanInfo.getText().contains(rcom2))
			R2Count++;
		if (MSPlanInfo.getText().contains(rcom2))
			R2Count++;
		if (PDPPlanInfo.getText().contains(rcom2))
			R2Count++;
		if (SNPPlanInfo.getText().contains(rcom2))
			R2Count++;
		Assert.assertTrue(R1Count == 1, "#1Recommendation presents more than once");
		if (R2.isEmpty() || R2 == "")
			Assert.assertTrue(R2Count == 0, "#2Recommendation presents");
		else
			Assert.assertTrue(R2Count == 1, "#2Recommendation presents more than once or not available");
	}

	public void validateRecommendationPlan(String R1) {
		String currentPageUrl = driver.getCurrentUrl();
		boolean isDSNP=true;
		if (R1.equalsIgnoreCase("MA")) {
			mobileUtils.mobileLocateElementClick(MAViewPlansLink);
			validate(MA1stPlanName, 60);
			//Assert.assertTrue(MA1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
			//		"MA Invalid Plan Ranking");
			clickEnrollmobile(MA1stPlanEnroll,needhelptxt);
		}
		if (R1.equalsIgnoreCase("MS")) {
			mobileUtils.mobileLocateElementClick(MSViewPlansLink);
			submitMSform();
			validate(MS1stPlanName, 60);
			//Assert.assertTrue(MS1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
			//		"MS Invalid Plan Ranking");
			clickEnrollmobile(MS1stPlanEnroll,needhelptxtMS);
		}
		if (R1.equalsIgnoreCase("PDP")) {
			mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
			validate(PDP1stPlanName, 60);
			//Assert.assertTrue(PDP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
			//		"PDP Invalid Plan Ranking");
			clickEnrollmobile(PDP1stPlanEnroll,needhelptxt);
		}
		if (R1.equalsIgnoreCase("SNP")) {
			mobileUtils.mobileLocateElementClick(SNPViewPlansLink);
			validate(SNP1stPlanName, 60);
			//Assert.assertTrue(SNP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
			//		"SNP Invalid Plan Ranking");
			//System.out.println("Ranking Plan Name : "+SNP1stPlanName.getText());
			if(SNP1stPlanName.getText().toUpperCase().contains("D-SNP")) 
				clickEnrollmobile(SNP1stPlanEnroll,needhelptxt);
			else
				isDSNP=false;
		}
		threadsleep(5000);
		pageloadcomplete();
		if(isDSNP)
			Assert.assertTrue(currentPageUrl != driver.getCurrentUrl(), "Enroll Plan URL is not working");
	}

	// Filling MS form with default value
	public void submitMSform() {
		// Zip value is pre-populated by default
		mobileactionsendkeys(MSPlanDOB, "01/01/1940");
		hidekeypad();
		mobileUtils.mobileLocateElementClick(MSPlanGender);
		threadsleep(8000);
		mobileUtils.mobileLocateElementClick(MSPlanGender);
		Select temp = new Select(MSPlanPartAMonth);
		mobileSelectOption(temp, "January 1");
		temp = new Select(MSPlanPartAYear);
		mobileSelectOption(temp, "2021");
		temp = new Select(MSPlanPartBMonth);
		mobileSelectOption(temp, "January 1");
		temp = new Select(MSPlanPartBYear);
		mobileSelectOption(temp, "2021");
		temp = new Select(MSPlanStartMonth);
		mobileSelectOption(temp, "January 1, 2021");
		mobileUtils.mobileLocateElementClick(MSViewPlanButton);
	}

	public void clickEnrollmobile(WebElement enrollButton,WebElement needhelp) {
		boolean click = false;
		boolean needswipe=true;
		for (int i = 0; i < 5; i++) {
			try {
				validate(enrollButton, 5);
				enrollButton.click();
				click = true;
				break;
			} catch (Exception e) {
				if(!needswipe)//MA plans will be in Horizontal view if drugs added Hence this swipe needed
					mobileswipeHorizantal("40%", 1, false);
				if(needswipe) {
					mobileUtils.mobileLocateElement(needhelp, "20%");
					needswipe=false;
				}
			}
		}
		Assert.assertTrue(click, "Unable to click the Enroll button");
	}

	public void checkTieRecommendationCount(String R1, String rcom, String R2) {
		int RCount = 0;
		if (MAPlanInfo.getText().contains(rcom))
			RCount++;
		if (MSPlanInfo.getText().contains(rcom))
			RCount++;
		if (PDPPlanInfo.getText().contains(rcom))
			RCount++;
		if (SNPPlanInfo.getText().contains(rcom))
			RCount++;
		if(R1=="")
			Assert.assertTrue(RCount == 0, "Recommendation Count is not equal to Zero");
		else if(R2=="")
			Assert.assertTrue(RCount == 1, "Recommendation Count is not equal to One");
		else
			Assert.assertTrue(RCount == 2, "Recommendation is not equals to Two");
	}

	public void navigateVPP(HashMap<String, String> inputdata) {
		validate(homePageZiptxt,60);
		mobileactionsendkeys(homePageZiptxt, inputdata.get("Zip Code"));
		hidekeypad();
		mobileUtils.mobileLocateElementClick(homePageFindPlans);
		if (inputdata.get("Is Multi County").equalsIgnoreCase("yes")) {
			if(selectMultiZip.get(0).getText().toUpperCase().contains(inputdata.get("County Name").toUpperCase()))
				selectMultiZip.get(0).click();
				//mobileUtils.mobileLocateElementClick(selectMultiZip.get(0));
			else if(selectMultiZip.get(1).getText().toUpperCase().contains(inputdata.get("County Name").toUpperCase()))
				selectMultiZip.get(1).click();
				//mobileUtils.mobileLocateElementClick(selectMultiZip.get(1));
		}
		validate(planZipInfo, 60);
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		threadsleep(5000);// Plan loader
		Assert.assertTrue(planZipInfo.getText().contains(inputdata.get("Zip Code")),"Invalid Zip");
	}
	
	static ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> vppProviderResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	static ArrayList<String> vppDrugsResults = new ArrayList<String>();
	DoctorsMobilePage docmobile = new DoctorsMobilePage(driver);
	int count = 1;
	
	public void addProviderVPP(String name,String multi) {
		mobileUtils.mobileLocateElementClick(MAViewPlansLink);
		String curdriverhandle = driver.getWindowHandle();
		mobileUtils.mobileLocateElementClick(enterProvidersInfoMA1stPlan);
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		werallyResults=docmobile.validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", name, count);	
		ArrayList<String> vppResults = getProvidersVPP();
		Assert.assertTrue(vppResults.size()==count,"Providers count mismatch in VPP");
	}
	
	public ArrayList<String> getProvidersVPP() {
		threadsleep(5000);
		mobileUtils.mobileLocateElementClick(providersInfoMA1stPlan);
		vppProviderResults = new ArrayList<String>();
		for(WebElement e:providersListMA1stPlan) {
			vppProviderResults.add(e.getText().trim());
		}	
		return vppProviderResults;
	}
	
	public void verifyProviderVPP() {
		containsname(werallyResults,vppProviderResults);
	}
	
	public boolean containsname(ArrayList<String> werallypreproviders, ArrayList<String> vppprovider) {
		boolean result = true;
		for (int i = 0; i < werallypreproviders.size(); i++) {
			String wname[] = werallypreproviders.get(i).toUpperCase().replace(",", "").replace(".", "").split(" ");
			List<String> wnam = Arrays.asList(wname);
			for (int j = 0; j < vppprovider.size(); j++) {
				String dname[] = vppprovider.get(j).toUpperCase().replace(",", "").replace(".", "").split(" ");
				List<String> dnam = Arrays.asList(dname);
				if (wnam.containsAll(dnam)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		System.out.println("Content validation Result : " + result);
		Assert.assertTrue(result,"Content mismatch");
		return result;
	}
	
	public void getProvidersPRE(String multi) {
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		confirmationResults=docmobile.getConfimationPopupResults(count);
	}
	
	public void verifyProvidersSession(String multi) {
		if(multi.equalsIgnoreCase("Yes"))
			count = 3;
		docmobile.verifyConfirmationmodalResults(count, werallyResults, confirmationResults);
		docmobile.nextPageValidationDoctor();
	}
	
	public void navigatePRE() {
		mobileUtils.mobileLocateElementClick(startnowButton);
		pageloadcomplete();
		Assert.assertTrue(driver.getCurrentUrl().contains("plan-recommendation-engine.html"));
		//driver.navigate().refresh();
		//pageloadcomplete();
	}

	public void navigateVPPPRE() {
		System.out.println("Navigate from VPP to PRE using Startnow : ");
		plansLoader();
		mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
		mobileUtils.mobileLocateElementClick(startnowButton);
		pageloadcomplete();
		Assert.assertTrue(driver.getCurrentUrl().contains("plan-recommendation-engine.html"));
	}
	
	public void navigateVPPPREStartover() {
		System.out.println("Navigate from VPP to PRE using Startnow : ");
		plansLoader();
		mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
		mobileUtils.mobileLocateElementClick(pdpstartoverButton);
		modalstartoverButton.click();
		pageloadcomplete();
		Assert.assertTrue(driver.getCurrentUrl().contains("plan-recommendation-engine.html"));
	}
	
	public void verifyProviderPREVPP() {
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		threadsleep(5000);// Plan loader
		mobileUtils.mobileLocateElementClick(MAViewPlansLink);
		getProvidersVPP();
		containsname(DoctorsMobilePage.confirmationProviderResults,vppProviderResults);
	}
	
	public ArrayList<String> getDrugsVPP() {
		threadsleep(5000);
		mobileUtils.mobileLocateElementClick(drugsInfoMA1stPlan);
		vppDrugsResults = new ArrayList<String>();
		for(WebElement e:drugsListMA1stPlan) {
			vppDrugsResults.add(e.getText().replace("\n", " ").replace("  ", " ").trim());
		}	
		return vppDrugsResults;
	}
	
	public void verifyDrugPREVPP() {
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		threadsleep(5000);// Plan loader
		mobileUtils.mobileLocateElementClick(MAViewPlansLink);
		getDrugsVPP();
		containsname(vppDrugsResults,DrugMobilePage.addedDrugNames);
	}

	public void plansLoader() {
		pageloadcomplete();
		validate(planLoaderscreen,60);
		waitforElementInvisibilityInTime(planLoaderscreen,60);
		validate(planZipInfo, 60);
		threadsleep(5000);// Plan loader
	}
	
	public void validateRankingPlans(String Recom,String plans) {
		System.out.println("Validating Plans Ranking : ");
		plansLoader();
		if (Recom.equalsIgnoreCase("MA")) {
			mobileUtils.mobileLocateElementClick(MAViewPlansLink);
			validate(MA1stPlanName, 60);
			mobileUtils.mobileLocateElement(MA1stPlanEnroll);
			verifyRankings(MAPlansName,plans);
		}
		if (Recom.equalsIgnoreCase("MS")) {
			Assert.assertTrue(false,"MS Plans ranking is not Implemented");
		}
		if (Recom.equalsIgnoreCase("PDP")) {
			mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
			validate(PDP1stPlanName, 60);
			mobileUtils.mobileLocateElement(PDP1stPlanEnroll);
			verifyRankings(PDPPlansName,plans);
			}
		if (Recom.equalsIgnoreCase("SNP")) {
			mobileUtils.mobileLocateElementClick(SNPViewPlansLink);
			validate(SNP1stPlanName, 60);
			mobileUtils.mobileLocateElement(SNP1stPlanEnroll);
			verifyRankings(SNPPlansName,plans);
		}
	}
	
	public void verifyRankings(List<WebElement> plansName, String plansOrder) {
		
		String givenPlans[] = plansOrder.split(":");
		// List<String> userPlans = Arrays.asList(givenPlans);
		List<String> vppPlans = new ArrayList<String>();
		// System.out.println(userPlans);
		// System.out.println(userPlans.size());
		System.out.println(plansName.size());
		for (WebElement e : plansName)
			vppPlans.add(getplanName(e));
		for (int i = 0; i < givenPlans.length; i++) {
			Assert.assertTrue(vppPlans.get(i).toUpperCase().contains(givenPlans[i].toUpperCase()),
					"Invalid Plan Ranking/Recommendation type : " + vppPlans.get(i) + "<-> " + givenPlans[i]);
		}
		System.out.println("Plan Ranking Successful");
	}

	public String getplanName(WebElement plan) {
		String planName = "";
		int i = 0;
		while (i < 5) {
			planName = plan.getText().trim();
			System.out.println(planName);
			if (planName.isEmpty()) {
				mobileswipeHorizantal("80%", 1, false);
				i++;
			} else
				break;
		}
		Assert.assertTrue(planName.length()>1, "--- Unable to get the Plan name ---");
		return planName;
	}

	public void sendEmail(String plan, String email) {
		System.out.println("Email Plan list from VPP : ");
		plansLoader();
		if (plan.equalsIgnoreCase("PDP")) {
			mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
			mobileUtils.mobileLocateElementClick(pdpemailList);
		} else if (plan.equalsIgnoreCase("MA")) {
			mobileUtils.mobileLocateElementClick(MAViewPlansLink);
			mobileUtils.mobileLocateElementClick(maemailList);

		} else if (plan.equalsIgnoreCase("SNP")) {
			mobileUtils.mobileLocateElementClick(SNPViewPlansLink);
			mobileUtils.mobileLocateElementClick(snpemailList);

		} else {
			Assert.assertTrue(false, "Print Email is not configured for the given Plan :" + plan);
		}
		mobileactionsendkeys(emailText, email);
		hidekeypad();
		emailSendButton.click();
		validate(emailSuccess, 15);
		emailCloseButton.click();
	}

	public void validateUIAPIRecommendations() {
		System.out.println("Validating UI vs API Plans Recommendation : ");
		plansLoader();

		String rankingJSON = returnDriverStorageJS("Session Storage", "ucp_planRecommendationResults");
		String MAPriority = getAPIPlansRecommendation(rankingJSON, "MA");
		String MSPriority = getAPIPlansRecommendation(rankingJSON, "MS");
		String PDPPriority = getAPIPlansRecommendation(rankingJSON, "PDP");
		String SNPPriority = getAPIPlansRecommendation(rankingJSON, "SNP");
		String R1 = "", R2 = "";
		int totalcount = 0;
		if (MAPriority.length() == 1) {
			totalcount++;
			if (MAPriority.equals("1"))
				R1 = "MA";
			else
				R2 = "MA";
		}
		if (MSPriority.length() == 1) {
			totalcount++;
			if (MSPriority.equals("1"))
				R1 = "MS";
			else
				R2 = "MS";
		}
		if (PDPPriority.length() == 1) {
			totalcount++;
			R1 = "PDP";
		}
		if (SNPPriority.length() == 1) {
			totalcount++;
			R1 = "SNP";
		}

		if (totalcount > 2)
			Assert.assertTrue(false, "Recommendation Count should not exceeds 2");

		String recom = "Recommended";
		String recom1 = "#1 Recommendation";
		String recom2 = "#2 Recommendation";
		if (R1.equals("1") && R2.equals("2"))
			validateRecommendations(R1, recom1, R2, recom2);
		if (R1.length() == 1 && R2.length() == 0)
			validateRecommendations(R1, recom1, "", "");
		if (R1.equals(R2) && R1.length() == 1)
			validateRecommendations(R1, recom, R2, recom);
		System.out.println("API vs UI Plan Recommendation Successful");
	}	
	
	public void validateUIAPIRankingPlans() {
		System.out.println("Validating UI vs API Plans Ranking : ");
		plansLoader();
		String rankingJSON = returnDriverStorageJS("Session Storage", "ucp_planRecommendationResults");
		List<String> maAPIRankings = getAPIPlansRanking(rankingJSON,"MA");
		if(maAPIRankings.size()>0) {
		mobileUtils.mobileLocateElementClick(MAViewPlansTab);
		validate(MA1stPlanName, 60);
		mobileUtils.mobileLocateElement(MA1stPlanEnroll);
		verifyAPIRankings(MAPlansId,maAPIRankings);
		//mobileFindElement(backtoPlans,3,false);
		//backtoPlans.click();
		driver.navigate().refresh();
		plansLoader();
		}
		List<String> pdpAPIRankings = getAPIPlansRanking(rankingJSON,"PDP");
		mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
		validate(PDP1stPlanName, 60);
		mobileUtils.mobileLocateElement(PDP1stPlanEnroll);
		verifyAPIRankings(PDPPlansId,pdpAPIRankings);
		//mobileFindElement(backtoPlans,3,false);
		//backtoPlans.click();
		driver.navigate().refresh();
		plansLoader();
		List<String> snpAPIRankings = getAPIPlansRanking(rankingJSON,"SNP");
		if(snpAPIRankings.size()>0) {
		mobileUtils.mobileLocateElementClick(SNPViewPlansLink);
		validate(SNP1stPlanName, 60);
		mobileUtils.mobileLocateElement(SNP1stPlanEnroll);
		verifyAPIRankings(SNPPlansId,snpAPIRankings);
		}
	}

	
	public List<String> getAPIPlansRanking(String rankingJSON, String givenPlanType) {

		List<String> rankingOrder = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		JSONArray jarray= new JSONArray();;
		try {
			jarray = (JSONArray) parser.parse(rankingJSON);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObj = new JSONObject();
		System.out.println(jarray.size());
		System.out.println("GivenPlanType : " + givenPlanType);

		for (int i = 0; i < jarray.size(); i++) {
			// System.out.println(jarray.get(i));
			jsonObj = (JSONObject) jarray.get(i);
			String playtype = (String) jsonObj.get("planType");
			// System.out.println("playtype : " + playtype);

			if (playtype.equalsIgnoreCase(givenPlanType)) {
				String priority = (String) jsonObj.get("priority");
				System.out.println("priority : " + priority);
				jarray = (JSONArray) jsonObj.get("planResponses");
				System.out.println("Total Plans : " + jarray.size());
				if(jarray.size()==0)
					break;
				int j = 0;
				while (j < jarray.size()) {
					System.out.println(jarray.get(j));
					jsonObj = (JSONObject) jarray.get(j);
					String apiRank = (String) jsonObj.get("rank");
					System.out.println("Rank : " + apiRank);

					if (Integer.parseInt(apiRank) == j + 1) {
						String planID = (String) jsonObj.get("planId");
						System.out.println(planID);
						rankingOrder.add((String) jsonObj.get("planId"));
						j++;
					}
				}
				break;
			}
		}
		return rankingOrder;
	}

	
	public String getAPIPlansRecommendation(String rankingJSON, String givenPlanType) {
		JSONParser parser = new JSONParser();
		JSONArray jarray = new JSONArray();
		try {
			jarray = (JSONArray) parser.parse(rankingJSON);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObj = new JSONObject();
		String recom = "";
		//System.out.println(jarray.size());
		System.out.println("GivenPlanType : " + givenPlanType);
		for (int i = 0; i < jarray.size(); i++) {
			jsonObj = (JSONObject) jarray.get(i);
			String playtype = (String) jsonObj.get("planType");
			if (playtype.equalsIgnoreCase(givenPlanType)) {
				recom = (String) jsonObj.get("priority");
				System.out.println("priority : " + recom);
				break;
			}
		}
		return recom.trim();
	}
	
	public void verifyAPIRankings(List<WebElement> plansId, List<String> APIRankings) {
		
		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansId.size());
		for (WebElement e : plansId)
			vppPlans.add(getplanId(e));
		for (int i = 0; i < APIRankings.size(); i++) {
			Assert.assertTrue(vppPlans.get(i).toUpperCase().contains(APIRankings.get(i).toUpperCase()),
					"Invalid Plan Ranking between API and UI : " + vppPlans.get(i) + "<-> " + APIRankings.get(i));
		}
		System.out.println("API vs UI Plan Ranking Successful");
	}

	public String getplanId(WebElement plan) {
		String planName = "";
		String planId="";
		int i = 0;
		while (i < 5) {
			planName = plan.getText().trim();
			planId = plan.getAttribute("id");
			System.out.println(planName);
			if (planName.isEmpty()) {
				mobileswipeHorizantal("80%", 1, false);
				i++;
			} else
				break;
		}
		Assert.assertTrue(planId.length()>1, "--- Unable to get the Plan Id ---");
		System.out.println("UI Plan ID : "+planId);
		return planId;
	}

}