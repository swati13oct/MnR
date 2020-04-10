/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine;

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

	String page = "Plan Recommendation Summary";

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	@FindBy(css = ".plan-overview-wrapper>div[class='overview-main']>h2")
	private WebElement planZipInfo;

	@FindBy(css = ".plan-overview-wrapper>div[class='overview-main']>div:nth-of-type(1)")
	private WebElement planBasedInfo;

	@FindBy(css = "div[data-rel='#plan-list-1']")
	private WebElement MAPlanInfo;

	@FindBy(css = "div[data-rel='#plan-list-1'] span.ng-binding")
	private WebElement MAPlanCount;

	@FindBy(css = "div[data-rel='#plan-list-1'] a")
	private WebElement MAViewPlansLink;

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

	@FindBy(css = "label[for='Gender_1']")
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

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1) h3")
	private WebElement SNP1stPlanName;

	@FindBy(css = "#plan-list-4 .swiper-container .module-plan-overview:nth-of-type(1) .enroll-details>a:nth-of-type(2)")
	private WebElement SNP1stPlanEnroll;

	@FindBy(xpath = "//h2[contains(text(),'Need Help?')]")
	private WebElement needhelptxt;

	public void resultsUI(String zip, String county, String R1, String plan, String R2, boolean tie) {
		System.out.println("Validating Results UI Page: ");
		pageloadcomplete();
		validate(planZipInfo, 60);
		Assert.assertTrue(planZipInfo.getText().contains(zip));
		Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()));
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[2]) > 0, "Total Plan count is less than 1");
		Assert.assertTrue(planBasedInfo.getText().contains("Based on"));
		String recom = "Recommendation";
		String recom1 = "#1Recommendation";
		String recom2 = "#2Recommendation";
		if (tie == false) {
			checkRecommendationCount(R1, recom1, R2, recom2);
			validateRecommendations(R1, recom1, R2, recom2);
			validateRecommendationPlan(R1, plan);
		} else {
			checkTieRecommendationCount(R1, recom, R2);
			validateRecommendations(R1, recom, R2, recom);
		}
	}

	public void validateRecommendations(String R1, String rcom1, String R2, String rcom2) {
		System.out.println("Validating Recommendations in Results Page");
		if (R1.equalsIgnoreCase("MA")) {
			Assert.assertTrue(MAPlanInfo.getText().contains(rcom1), "MA Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MAPlanCount.getText()) > 0, "MA Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("MS")) {
			Assert.assertTrue(MSPlanInfo.getText().contains(rcom1), "MS Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(MSPlanCount.getText()) > 0, "MS Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("PDP")) {
			Assert.assertTrue(PDPPlanInfo.getText().contains(rcom1), "PDP Invalid Recommendations");
			Assert.assertTrue(Integer.parseInt(PDPPlanCount.getText()) > 0, "PDP Plan count is less than 1");
		}
		if (R1.equalsIgnoreCase("SNP")) {
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
			Assert.assertTrue(R2Count == 1, "#2Recommendation presents more than once");
	}

	public void validateRecommendationPlan(String R1, String plan) {
		String currentPageUrl = driver.getCurrentUrl();
		if (R1.equalsIgnoreCase("MA")) {
			mobileUtils.mobileLocateElementClick(MAViewPlansLink);
			validate(MA1stPlanName, 60);
			Assert.assertTrue(MA1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
					"MA Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(MA1stPlanEnroll);
			clickEnrollmobile(MA1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("MS")) {
			mobileUtils.mobileLocateElementClick(MSViewPlansLink);
			submitMSform();
			validate(MS1stPlanName, 60);
			Assert.assertTrue(MS1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
					"MS Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(MS1stPlanEnroll);
			clickEnrollmobile(MS1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("PDP")) {
			mobileUtils.mobileLocateElementClick(PDPViewPlansLink);
			validate(PDP1stPlanName, 60);
			Assert.assertTrue(PDP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
					"PDP Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(PDP1stPlanEnroll);
			clickEnrollmobile(PDP1stPlanEnroll);
		}
		if (R1.equalsIgnoreCase("SNP")) {
			mobileUtils.mobileLocateElementClick(SNPViewPlansLink);
			validate(SNP1stPlanName, 60);
			Assert.assertTrue(SNP1stPlanName.getText().toUpperCase().contains(plan.toUpperCase()),
					"SNP Invalid Plan Ranking");
			// mobileUtils.mobileLocateElementClick(SNP1stPlanEnroll);
			clickEnrollmobile(SNP1stPlanEnroll);
		}
		threadsleep(5000);
		pageloadcomplete();
		Assert.assertTrue(currentPageUrl != driver.getCurrentUrl(), "Enroll Plan URL is not working");
	}

	// Filling MS form with default value
	public void submitMSform() {
		// Zip value is pre-populated by default
		mobileactionsendkeys(MSPlanDOB, "01/01/1940");
		hidekeypad();
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

	public void clickEnrollmobile(WebElement enrollButton) {
		boolean click = false;
		mobileUtils.mobileLocateElement(needhelptxt, "30%");
		for (int i = 0; i < 5; i++) {
			try {
				validate(enrollButton, 5);
				enrollButton.click();
				click = true;
				break;
			} catch (Exception e) {
				mobileswipeHorizantal("40%", 1, false);
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
		Assert.assertTrue(RCount == 2, "Recommendation is not equals to Two");
	}

}
