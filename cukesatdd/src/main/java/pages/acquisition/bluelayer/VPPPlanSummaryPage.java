/**
 *
 */
package pages.acquisition.bluelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.bluelayer.ComparePlansPageBlayer;
import pages.acquisition.ulayer.PageTitleConstants;

//import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.bluelayer.ProviderSearchPage;
import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.vppforaep.AepVppPlanSummaryPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;

	@FindBy(id = "change-location")
	private WebElement changeLocationBtn;

	@FindBy(xpath = ".//*[@id='maplans2']")
	private WebElement showMaPlans;

	@FindBy(xpath = ".//*[@id='pdpplans2']")
	private WebElement showPdpPlans;

	@FindBy(xpath = "//div[@class='snpplans_planbutton']/div[2]/div[2]/div")
	private WebElement showSnpPlans;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div[1]/a")
	private WebElement showMsPlans;

	@FindBy(xpath = "//div[@id='chooseplan']/div/div/h3")
	private WebElement pageHeading;

	@FindBy(xpath = "//div[@id='maplans_container']")
	WebElement maPlanConatiner;

	@FindBy(xpath = "//div[@id='pdpplans_container']")
	WebElement pdpPlanConatiner;

	@FindBy(xpath = "//div[@id='snpplans_container']")
	WebElement snpPlanConatiner;

	// @FindBy(xpath
	// ="//div[@id='maplans_container']/div[3]/div/div/div/div[@class='ng-scope']")
	@FindBy(xpath = "//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@id='plan-list-1']/div/div[1]/div/div/h2")
	WebElement maPlanHeadingText;

	@FindBy(xpath = "//div[@id='maplans_container']/h1/span")
	WebElement maPlanHeadingYear;

	@FindBy(xpath = "//div[contains(@ng-repeat,'plan in planModel.maPlans')]")
	List<WebElement> maPlans;

	@FindBy(xpath = "//div[@id='plan-list-3']/div/div[1]/div/div/h2")
	WebElement pdpPlanHeadingText;

	@FindBy(xpath = "//div[@id='pdpplans_container']/h1/span")
	WebElement pdpPlanHeadingYear;

	@FindBy(xpath = "//div[contains(@ng-repeat,'plan in planModel.pdpPlans')]")
	List<WebElement> pdpPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement viewPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement viewPDPPlans;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span[2]")
	WebElement msnPlanHeadingText;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span")
	WebElement msnPlanHeadingYear;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in snpplans']")
	List<WebElement> msnPlans;

	@FindBy(xpath = ".//*[@id='pdpplans_container']")
	List<WebElement> pdpPlanElement;

	@FindBy(xpath = ".//*[@id='plan-list-1']//a[contains(@class,'view-more-link']")
	List<WebElement> viewDetailsBtnMA;

	@FindBy(xpath = "//div[@id='snpplans_container']")
	List<WebElement> snpPlanElement;

	@FindBy(linkText = "Make an appointment with an agent")
	private WebElement make_an_appointment_agent;

	@FindBy(css = "#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;

	@FindBy(css = "#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[1]/label")
	private WebElement compareChkBox3;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;

	@FindBy(xpath = "//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	@FindBy(xpath = ".//*[@id='togglenextYear']/a")
	private WebElement toggleplanYear;

	@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	private WebElement MaProviderLink;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[1]/h2")
	private WebElement allPlansSize;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[1]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[2]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[3]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs')]/div[4]/div[contains(@class,'tab-contents')]/span[contains(@class,'title')]/span")
	private WebElement snpPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[2]/div[4]/div/span[1]/span")
	private WebElement msnPlansCount;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/span/a")
	private WebElement view2017Plans;

	@FindBy(id = "drugsTabId")
	public WebElement step1;

	@FindBy(className = "planYear")
	WebElement planYear;

	@FindBy(xpath = ".//*[@class='action-btn getStarted']")
	private WebElement GetStarted;

	@FindBy(xpath=".//*[@class='gs-option']//*[contains(text(),'People')]")
	private WebElement People;

	@FindBy(id = "change-location")
	private WebElement ChangeLocationLink;
	
	@FindBy(id = "submit")
	private WebElement FIndPlansButton;
	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]/div/*[@class='trigger-closed']")
	private WebElement closedTrigger;

	@FindBy(xpath = "//*[contains(text(), 'Special Needs Plans')]/following-sibling::*[@class = 'trigger-closed']")
	private WebElement snpplans;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div[1]/a")
	private WebElement medsupplans;
	// "

	// @FindBy(xpath="//*[contains(text(),'Primary Care')]")
	@FindBy(xpath = ".//*[@class='gs-option']//*[contains(text(),'Primary Care')]")
	private WebElement Primary;

	@FindBy(xpath = "//*[contains(text(),'Primary Care Physician')] ")
	private WebElement Physician;

	// @FindBy(xpath=".//*[contains(@ng-bind-html,'buttonText') and
	// contains(text(),'Save')]")
	//private WebElement Savebtn;

	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']//button")

	private WebElement Savebtn;

	@FindBy(id = "label_unsaved_selectedLocation0")
	private WebElement firstLocation;

	//@FindBy(xpath="//button[@class='action-btn']")
	@FindBy(xpath="//*[@id='skip-to-main-content']/div/div[1]/div[1]/location-result/div/div/div/div[2]/div[2]/div[1]/div/div/div[3]/toggle-saved-provider/button/span")
	private WebElement secondSaveBtn;

	@FindBy(xpath = "//*[contains(text(),'View Saved')]")
	private WebElement Viewsavebtn;

	@FindBy(xpath = "//button[@class='action-btn negative']")
	private WebElement Checkcoverage;

	@FindBy(xpath = "//*[@id='physicians_info']")
	private WebElement provider;

	@FindBy(className = "planType_info")
	WebElement planHeadingText;

	@FindBy(xpath = ".//*[@id='viewmoredetlinkpdp']")
	WebElement viewDetailsPDP;

	@FindBy(xpath = "//div[@class='module-closed-enrollment-alert']/span/a")
	private WebElement viewPlansYearLink;

	@FindBy(xpath = ".//*[@class='swiper-container']")
	List<WebElement> maPlanElement1;

	// Right Rail Element - TFN
	@FindBy(xpath = "//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;

	@FindBy(xpath = "//*[@id='togglecurrentYear']/a")
	private WebElement YearToggle;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;
	
	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;
	
	@FindBy(id = "zipcode")
	private WebElement ZipCodeTxtBx;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//a[@class='trigger-closed'][text()='View Plans']")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='pdpviewplans']/following-sibling::a")
	private WebElement pdpPlansViewLink;

	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;

	@FindBy(xpath = "//div[@id='responsiveplan']")
	private List<WebElement> medSuppPlanList;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]//a[@class='trigger-closed']")
	private WebElement snpPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-main']/h2")
	private WebElement vppTop;

	@FindBy(xpath = "//div[contains(@class,'plan-overview-list')]//div[contains(@id,'plan-list-')][not (contains(@class,'ng-hide'))]//div[contains(@class,'module-plan-overview')]//div[contains(@class,'content-secondary')]//input[contains(@id,'compare-plan-')]/following-sibling::label")
	private List<WebElement> planCompareList;

	@FindBy(xpath = "//label[contains(text(),'Added to compare')]/ancestor::div[contains(@class,'module-plan-overview')]//div[not (contains(@class,'ng-hide'))]/a[contains(@class,'view-more-link')]")
	private WebElement ViewPlanLink_AddedToCompare;
	
	@FindBy(xpath = "//div[contains(@class,'plan-overview-list')]//div[contains(@id,'plan-list-')][not (contains(@class,'ng-hide'))]//div[contains(@class,'module-plan-overview')]//div[not (contains(@class,'ng-hide'))]/a[contains(@class,'view-more-link')]")
	private WebElement ViewPlanLink;

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;
	
	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/p[contains(text(),'drugs covered')])[1]")
	private WebElement drugCoveredInfo;
	
	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost')])[1]")
	private WebElement estimatedAnnualDrigCostLabel;
	
	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))])[1]")
	private WebElement estimatedAnnualDrigCostValue;
	
	
	
	
	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
		}

	public boolean validatePlanSummary() {
		boolean flag = true;
		int allPlans = 0;
		int maPlans = 0;
		int msPlans = 0;
		int pdpPlans = 0;
		int msnPlans = 0;
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (validate(allPlansSize)) {
			allPlans = Integer.valueOf(allPlansSize.getText().split(" ")[2]);
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(maPlansCount)) {
			maPlans = Integer.valueOf(maPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(msPlansCount)) {
			msPlans = Integer.valueOf(msPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(pdpPlansCount)) {
			pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		if (validate(msnPlansCount)) {
			msnPlans = Integer.valueOf(msnPlansCount.getText());
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}
	
		if(validate(msnPlansCount)){
			if (!(allPlans == maPlans + msPlans + pdpPlans + msnPlans)) {
				flag = false;
			}
		} else {
			Assert.assertTrue("This scenario is for AEP period", true);

		}

		return flag;
	}

	public boolean validateAvailablePlans(String planType) {
		boolean flag = true;
		int planCount = 0;
		if (planType.equals("MAPD") || planType.equals("MA")) {
			String planHeading = null;
			if (maPlanHeadingText.isDisplayed()) {
				planHeading = maPlanHeadingText.getText();
				System.out.println(planHeading);
				if (!planHeading.contains("Medicare Advantage Plans")) {
					flag = false;
				}
			}

			planCount = Integer.valueOf(maPlansCount.getText());
			for (int i = 0; i < planCount; i++) {
				if (maPlans.get(i).getText().length() == 0) {
					flag = false;
				}
			}

		} else if (planType.equals("PDP")) {
			String planHeading = null;
			if (pdpPlanHeadingText.isDisplayed()) {
				planHeading = pdpPlanHeadingText.getText();
				System.out.println(planHeading);
				if (!planHeading.contains("Medicare Prescription Drug Plans")) {
					flag = false;
				}
			}
			planCount = Integer.valueOf(pdpPlansCount.getText());
			for (int i = 0; i < planCount; i++) {
				if (pdpPlans.get(i).getText().length() == 0) {
					flag = false;
				}
			}
		} else if (planType.equals("SNP")) {
			String planHeading = msnPlanHeadingText.getText();
			System.out.println(planHeading);
			if (!planHeading.equals("Medicare Special Needs Plans")) {
				flag = false;
			}
			planCount = Integer.valueOf(msnPlansCount.getText());
			for (int i = 0; i < planCount; i++) {
				if (msnPlans.get(i).getText().length() == 0) {
					flag = false;
				}
			}
		} else {
			flag = false;
		}

		return flag;
	}

	public boolean validatePlanSummarydetails(String planName) {
		boolean flag = true;
		String fileName = null;
		WebElement planContainer = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			planContainer = snpPlanConatiner;
		} else if (planName.contains("HMO")) {
			fileName = "maplansummary.json";
			planContainer = maPlanConatiner;
		} else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			planContainer = pdpPlanConatiner;
		} else if (planName.contains("Regional PPO")) {
			fileName = "mamultistateplansummary.json";
			planContainer = maPlanConatiner;
		}

		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className","ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(vppPlanSummary.getExpectedData().get(key), plan);
					System.out.println("Checking for the element : "+key );
					flag = validate(element);
					if (!flag) {
						break;
					}
				}
			}
		}
		return flag;
	}

	public PlanDetailsPage navigateToPlanDetails(String planName, String planType) {

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan')]"));
			CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
			MAmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for MA plan" + planName);

		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//h2[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//*[@id = 'viewmoredetlinkpdp']"));
			CommonUtility.waitForPageLoadNew(driver, PDPmoreDetailsLink, 30);
			PDPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
		} else if (planType.equalsIgnoreCase("SNP")) {
			WebElement SNPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'View plan')]"));
			CommonUtility.waitForPageLoadNew(driver, SNPmoreDetailsLink, 30);
			SNPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for SNP plan"+planName);

		}else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(),'View plan and drug coverage details')]"));
			//CommonUtility.waitForPageLoad(driver, MAmoreDetailsLink, 30);	
					validate(MAmoreDetailsLink);
					
					MAmoreDetailsLink.click();
					System.out.println("View Plan Details Link is clicked for MA plan"+planName);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {	
			return new PlanDetailsPage(driver,planType);
		}
		return null;
	}

	private WebElement getViewPlanDetailsElement(List<WebElement> maPlanElement2, ElementData elementData,
			String planName) {

		for (WebElement plan : maPlanElement2) {
			System.out.println(plan.getText());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (plan.getText().contains(planName)) {

				WebElement element = findChildElement(elementData, plan);

				return element;

			}
		}
		return null;
	}

	public void viewPlanSummary(String planType) {

		if (planType.equalsIgnoreCase("PDP")) {
			CommonUtility.waitForPageLoadNew(driver, pdpPlansViewLink, 30);
			pdpPlansViewLink.click();
			System.out.println("PDP Plan Type Clicked");
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			CommonUtility.waitForPageLoadNew(driver, maPlansViewLink, 30);
			maPlansViewLink.click();
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);

		} else if (planType.equalsIgnoreCase("MS")) {
			CommonUtility.waitForPageLoadNew(driver, msPlansViewLink, 30);
			msPlansViewLink.click();
			CommonUtility.waitForPageLoadNew(driver, medSuppPlanList.get(0), 30);
		} else if (planType.equalsIgnoreCase("SNP")) {
			CommonUtility.waitForPageLoadNew(driver, snpPlansViewLink, 30);
			snpPlansViewLink.click();
			CommonUtility.waitForPageLoadNew(driver, planListContainer, 30);
			}					
			}	

	@Override
	public void openAndValidate() {
		validateVPPPlanSummaryPage();
	}

	public JSONObject getPlanSummaryActualData(String planName) {
		String fileName = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, snpPlanConatiner);
			return jsonObject;
		} else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			fileName = "maplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanConatiner);
			return jsonObject;
		} else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, pdpPlanConatiner);
			return jsonObject;
		} else if (planName.contains("Regional PPO")) {
			fileName = "mamultistateplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanConatiner);
			return jsonObject;

		}

		return null;
	}

	private JSONObject getActualJsonObject(String fileName, String planName, WebElement planContainer) {

		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className", "ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				JSONObject jsonObject = new JSONObject();
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(vppPlanSummary.getExpectedData().get(key), plan);
					validate(element);
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				return jsonObject;

			}
		}
		return null;

	}

	public String viewplans(String planName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EstimateDrugCostPage navigateToSummaryPage(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		}
		return new EstimateDrugCostPage(driver);
	}

	public ManageDrugPage navigateToEditDrugList(String planName) {

		if (planName.contains("HMO")) {
			ElementData elementData = new ElementData("id", "editDrugMA");
			WebElement element = getViewPlanDetailsElement(maPlanElement, elementData, planName);
			if (element != null) {
				element.click();

			}

		} else if (planName.contains("PDP")) {
			ElementData elementData = new ElementData("id", "editDrugMA");
			WebElement element = getViewPlanDetailsElement(pdpPlanElement, elementData, planName);
			if (element != null) {
				element.click();

			}

		}
		CommonUtility.checkPageIsReady(driver);
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		}

		return null;
	}

	public EnrollPlanInfoPage clicksOnEnrollInplanLink(String planName) {
		if (planName.contains("HMO")) {
			if (maPlans != null) {
				for (WebElement plan : maPlans) {
					if (plan.getText().contains(planName)) {
						ElementData elementData = new ElementData("id", "enrollMAButton");
						if (findChildElement(elementData, plan).isDisplayed()) {
							findChildElement(elementData, plan).click();
							break;
						} else {
							if (viewPlansYearLink.isDisplayed()) {
								viewPlansYearLink.click();
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								viewPlanSummary("MA");
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								if (maPlans != null) {
									for (WebElement newPlan : maPlans) {
										if (newPlan.getText().contains(planName)) {
											ElementData newelementData = new ElementData("id", "enrollMAButton");
											findChildElement(newelementData, newPlan).click();
											break;
										}
									}
								}
								break;
							}
						}
					}
				}
			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlans) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollPDPButton"); // TODO:
					// Re-check
					if (findChildElement(elementData, plan).isDisplayed()) {
						findChildElement(elementData, plan).click();
						break;
					} else {

						if (viewPlansYearLink.isDisplayed()) {
							viewPlansYearLink.click();
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							viewPlanSummary("PDP");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (WebElement newPlan : pdpPlans) {
								if (newPlan.getText().contains(planName)) {
									ElementData newelementData = new ElementData("id", "enrollPDPButton");
									findChildElement(newelementData, newPlan).click();
									break;
								}
							}
							break;
						}

					}
				}
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for( int i = 0; i<10; i++){
			if (pageHeading.getText().equalsIgnoreCase("You Have Chosen to Enroll in the Following Plan")) {
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (pageHeading.getText().equalsIgnoreCase("You Have Chosen to Enroll in the Following Plan")) {
			return new EnrollPlanInfoPage(driver);
		} else {
			return null;
		}

	}

	public GetStartedPage clicksOnEnterDrugInformationLink(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enterDrugMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enterDrugPDP"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new GetStartedPage(driver);
		}
		return null;

	}

	public Rallytool_Page clicksOnIsProviderCovered(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase("Welcome")) {
			return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

	public ProviderSearchPage clicksOnIsProviderCoveredUms(String planName) {

		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'Is my provider covered')]"));
		switchToNewTabNew(ProviderSearchLink);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
				}
		return null;
			}

	public VPPPlanSummaryPage clicksOnIsProviderCoveredA(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement1) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}

		String mainwindow = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {

			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);

			}
		}

		driver.manage().window().maximize();
		waitforElement(GetStarted);
		GetStarted.click();

		waitforElement(People);

		People.click();

		waitforElement(Primary);

		Primary.click();

		waitforElement(Physician);

		Physician.click();

		waitforElement(Savebtn);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Savebtn);

		// Savebtn.click();
		waitforElement(Viewsavebtn);

		Viewsavebtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		waitforElement(Checkcoverage);
		CommonUtility.waitForPageLoad(driver, Checkcoverage, 10);
		Checkcoverage.click();
		driver.switchTo().window(mainwindow);

		return new VPPPlanSummaryPage(driver);

	}

	public boolean providerinfo() {
		String providerinfo=provider.getText();
		if (providerinfo.contains("1 providers covered")) {
			return true;
		}
		return false;
	}
	
	public boolean providerinfo(String planName) {

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/ancestor::div[contains(@class, 'module-plan-overview module')]/descendant::span[contains(text(),'covered')]"));
		String mproviderinfo=ProviderSearchLink.getText();
        System.out.println(mproviderinfo);
		if (mproviderinfo.contains("1 providers covered")) {
			return true;
		}
		return false;
	}

	public RequestAgentAppointmentPage nagiateToRequetAnAppointmentPage() {
		make_an_appointment_agent.click();

		try {
			if (make_an_appointment_agent.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, make_an_appointment_agent, CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("make_an_appointment_agent not found");
		} catch (TimeoutException ex) {
			System.out.println("make_an_appointment_agent not found");
		} catch (Exception e) {
			System.out.println("make_an_appointment_agent not found");
		}
		if (currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html")) {
			return new RequestAgentAppointmentPage(driver);
		}

		return null;

	}

	public String togglePlan() {
		String currentYearFlag = "false";
		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
			currentYearFlag = "true";
		}
		return currentYearFlag;
	}

	public VPPPlanSummaryPage togglePlanYear(String planType) {

		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public void clicksOnMAProviderCoveredLink() {
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton() {
		waitforElement(comparePDPPlanChkBox);
		Assert.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assert.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}

	public void clickAndVerifyCompareUpto3PlansPopup() {
		comparePDPPlanChkBox.click();
		Assert.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",
				compareUpto3PlansPopup.getText().trim());
	}

	public boolean verifyCompareCheckBoxesAreUnchecked(){
		if (!planCompareList.get(0).isSelected())
			return true;
		return false;

	}

	public void UncheckAndVerifyCompareChkBox() {
		if (validate(compareChkBox3)) {
			compareChkBox3.click();
		}

		Assert.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox3.getAttribute("class"));
	}

	public void VerifyComparePopUpText() {

		Assert.assertEquals("Select 1 more plan to compare", comparePopUpTxt1.getText().trim());
		Assert.assertEquals("Select 2-3 plans that you'd like to compare", comparePopUpTxt2.getText().trim());
	}

	public void clickCompareChkBox(){
		for(int currentCheckboxIndex = 0; currentCheckboxIndex < planCompareList.size(); currentCheckboxIndex ++) {
		if(planCompareList.get(currentCheckboxIndex).getText().trim().equalsIgnoreCase("Add to compare")){
			planCompareList.get(currentCheckboxIndex).click();
				Assert.assertTrue("Text not changed after checking checkbox", planCompareList.get(currentCheckboxIndex)
						.getText().trim().equalsIgnoreCase("Added to compare"));
		break;
			} else {
			continue;
		}
		}

	}

	public void clickCompareChkBoxPDP() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-3']//label[contains(text(),'Add to compare')]"));

		if (allMAPlans != null) {
			allMAPlans.get(0).click();

		}

	}

	public boolean validatepassportData() {
		try {
			Thread.sleep(20000);

			String expectedpassportdata = PassportFlyerPDF.getText();
			String actualpassportdata = "Passport Flyer (PDF)";
			if (expectedpassportdata.equalsIgnoreCase(actualpassportdata)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;

	}

	public boolean validateVPPPlanSummaryPage() {

		CommonUtility.waitForPageLoad(driver, vppTop, 30);

		validateNew(maPlansCount);
		validateNew(msPlansCount);
		validateNew(pdpPlansCount);
		validateNew(snpPlansCount);
		validateNew(changeLocationBtn);

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12).trim());
		int maPlans = Integer.valueOf(maPlansCount.getText());
		int msPlans = 0;
		try {
			msPlans = Integer.valueOf(msPlansCount.getText());
		} catch (NumberFormatException e) {
			msPlans = 0;
		}
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		int snpPlans = Integer.valueOf(snpPlansCount.getText());

		if (allPlans == maPlans + msPlans + pdpPlans + snpPlans) {
			return true;
		}
		return false;

	}

	public PlanDetailsPage clickViewDetails_AddedToCompare() {

		validateNew(ViewPlanLink_AddedToCompare);
		ViewPlanLink_AddedToCompare.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	public PlanDetailsPage clickViewDetails() {

		validateNew(ViewPlanLink);
		ViewPlanLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	public PlanDetailsPage clickViewDetailsPDP() {
		if (validate(viewDetailsPDP)) {
			viewDetailsPDP.click();
		}

		if (currentUrl().contains("#/details"))
			return new PlanDetailsPage(driver);
		return null;
	}

	public void clickonViewPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validate(viewPlans)) {
			viewPlans.click();
		}

	}

	public void clickOnPDPPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validate(viewPDPPlans)) {
			viewPDPPlans.click();
		}
	}

	public void clickOnViewPlans(String plantype) {
		CommonUtility.waitForPageLoad(driver, viewPlans, 30);
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			viewPlans.click();
		} else
			viewPDPPlans.click();

	}

	public DrugCostEstimatorPage navigateToDCE(String plantype) {
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			List<WebElement> maDCELink = driver.findElements(By.xpath(
					".//*[@id='plan-list-1']//div[@class='mabenefittable']//a[contains(@dtmname, 'Plans Landing:Plan:MA:Drug Cost Estimator')]"));
			maDCELink.get(0).click();
		} else {
			List<WebElement> view2017PDPPlans = driver.findElements(By.id("pdpDrugCostEstimatorLink"));
			view2017PDPPlans.get(0).click();

		}
		CommonUtility.waitForPageLoad(driver, step1, 30);
		if (currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	public DrugCostEstimatorPage navigateToDCEAfterDrugAdded(String plantype) {
		CommonUtility.waitForPageLoad(driver, viewPlans, 30);
		if (plantype.equals("MA") || plantype.equals("MAPD")) {
			if (validate(viewPlans)) {
				viewPlans.click();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> view2017Plans = driver.findElements(By.linkText("Edit drug list"));
			view2017Plans.get(0).click();
		} else {
			if (validate(viewPDPPlans)) {
				viewPDPPlans.click();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> view2017PDPPlans = driver.findElements(By.linkText("Edit drug list"));
			view2017PDPPlans.get(0).click();

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	public void choose2017Plans() {

		if (validate(viewPlans)) {
			viewPlans.click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (view2017Plans != null) {
			view2017Plans.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// viewPlans.click();
		}

	}

	public boolean yearBtnExists() {
		if (validate(view2017Plans))
			return true;
		return false;
	}

	/**
	 * Methods added for OLE Flow validations
	 * 
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 */
	public String getPlanPremium(String PlanName) {

		System.out.println("Plan Name is : "+PlanName);
		
		WebElement PremiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + PlanName
				+ "')]/ancestor::*[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(),'Monthly Premium')]//*[contains(text(),'$')]"));
		CommonUtility.waitForPageLoadNew(driver, PremiumForPlan, 30);
		String PlanPremium = PremiumForPlan.getText();

		System.out.println("Premium for Plan : " + PlanPremium);
		return PlanPremium;
	}

	/**
	 * @author sdwaraka Method Added for OLE Flow - Navigate to OLE from Plan
	 *         Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {

		System.out.println("Enroll in Plan for Plan : " + planName);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		validateNew(EnrollForPlan);
		EnrollForPlan.click();

		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		if (validateNew(RightRail_TFN)) {
			System.out.println("TFN is displayed in Right Rail");
			String TFN_Number = RightRail_TFN.getText();
			return TFN_Number;
		}
		System.out.println("TFN is not Displayed for PlanType in VPP page");

		return null;
	}

	public PlanComparePage selectplantocompare(String PlanType) {
		// To add upto 4 plans to compare and navigate to Plan Compare Page
		int count = 1;
		if (PlanType.contains("PDP")) {
			System.out.println("Plan Type is :" + PlanType);
			count = (Integer.parseInt(maPlansCount.getText())) + 1;
			System.out.println("Plan count starts is :" + count);
		}
		int CountUntil = count + 4;
		do {
			String temp = Integer.toString(count);
			WebElement SelectCompare = driver
					.findElement(By.xpath("//*[@id = 'compare-plan-" + temp + "']//following-sibling::label"));
			if(validate(SelectCompare))
				SelectCompare.click();
			count++;
		} while (count < CountUntil);

		List<WebElement> ComparePlansLinks = driver.findElements(By.xpath("//a[@class='compare-link']"));
		// validate();
		for (WebElement CompareLink : ComparePlansLinks) {
			if (CompareLink.isDisplayed()) {
				CompareLink.click();
				CommonUtility.checkPageIsReady(driver);
				if (driver.getCurrentUrl().contains("plan-compare")) {
					return new PlanComparePage(driver);
				}
			}
		}
		System.out.println("Compare Plans Link not displayed");
		return null;
	}

	public String EnrollmentValidation(String PlanName) {

		try {
			Thread.sleep(5000);
			try {
			if(YearToggle.getText().contains("View 2019 Plans"))
				YearToggle.click();
			Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Toggle Not found");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Plan Name is : " + PlanName);

		if (PlanName.equalsIgnoreCase("UnitedHealthcare Medicare Silver (Regional PPO SNP)")) {
			WebElement EnrollmentButton = driver
					.findElement(By.xpath("(//*[@class='enrollment']/div[@class='swiper-content ng-scope']/a)[5]"));
			String Enrollment = EnrollmentButton.getText();
			if (EnrollmentButton.isDisplayed())
				EnrollmentButton.click();
			System.out.println("Enrollment Button present and clicked");
			return Enrollment;
		} else {
		try{
				WebElement EnrollmentButton = driver
						.findElement(By.xpath("//*[@class='enrollment']/div[@class='acqplans ng-scope']/div/a/span"));
		String Enrollment = EnrollmentButton.getText();
		if(EnrollmentButton.isDisplayed())
			EnrollmentButton.click();
		System.out.println("Enrollment Button present and clicked");
		return Enrollment;
			} catch (Exception e) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,800)", "");
				WebElement EnrollmentButton = driver.findElement(By.xpath(
						"(//*[@class='module-plan-overview module swiper-slide ng-scope'])[9]//div[@class='enrollment']//a/span"));
			String Enrollment = EnrollmentButton.getText();
			if(EnrollmentButton.isDisplayed())
				EnrollmentButton.click();
			System.out.println("Enrollment Button present and clicked");
			return Enrollment;
		}
		}
			}

public WelcomePage EnrollmentValidationChronic(String PlanName) throws InterruptedException {
	
			
		try {
			Thread.sleep(5000);	
		if(YearToggle.getText().contains("View 2019 Plans"))
			YearToggle.click();
		Thread.sleep(5000);
			} catch (Exception e) {
			System.out.println("Toggle Not found");
		}

	System.out.println("Plan Name is : "+PlanName);	
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollBy(0,-10)", "");
		 */
		Thread.sleep(2000);
		WebElement EnrollmentButton = driver
				.findElement(By.xpath("(//*[@class='enrollment']/div[@class='swiper-content ng-scope']/a/span)[5]"));
	if(EnrollmentButton.isDisplayed())
		EnrollmentButton.click();
	System.out.println("Enrollment Button present and clicked");
	Thread.sleep(2000);
	return new WelcomePage(driver);
	
		}

	public AepVppPlanSummaryPage validate_aepPlanYearLinks(String currentYear, String nextYear) {
		System.out.println("Next Year : " + nextYear);
		System.out.println("Current Year : " + currentYear);

		WebElement CurrentYearLink = driver.findElement(By.xpath("//a[contains(text(), '"+currentYear+"')]"));
		System.out.println("Current Year link on VPP Page : "+CurrentYearLink.getText());

		List <WebElement> NextYearHeadings = driver.findElements(By.xpath("//*[contains(text(), '"+nextYear+"')]"));
		if( validate(CurrentYearLink) && NextYearHeadings.size()>0){
			System.out.println("Current and Next year toggle displayed for AEP");
			return new AepVppPlanSummaryPage(driver);
		} else {
			System.out.println("Current and Next year toggle NOT displayed for AEP");
		}

		// TODO Auto-generated method stub
		return null;
	}

public ComparePlansPageBlayer clickOnCompareLink(){
		
		List<WebElement> compareLinks = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//button[contains(text(),'Compare plans')]"));
		compareLinks.get(1).click();



		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageBlayer(driver);
		return null;
	}

public boolean validateAllPlansChecked() {
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		List<WebElement> compareChkBoxes = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));
		if (compareChkBoxes.get(0).getText().contains("3 plans added")
				&& compareChkBoxes.get(1).getText().contains("3 plans added")
				&& compareChkBoxes.get(2).getText().contains("3 plans added"))
		return true;
	return false;
}

	public void checkAllMAPlans() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));

		if (allMAPlans != null) {
			for (int i = 0; i < allMAPlans.size(); i++) {
				allMAPlans.get(i).click();
			}
		}

	}

	public boolean getSpecificPlanInfo(String planName) throws InterruptedException {
		boolean isSpecificPlanInfoPresent = false;
		if (planName.contains("HMO")) {
			isSpecificPlanInfoPresent = getSpecificPlanSummary(maPlanList, planName);
		}
		return isSpecificPlanInfoPresent;
	}
	
	private boolean getSpecificPlanSummary(WebElement element, String planName) {
		if (element.getText().contains(planName)) {
			return true;
		} else {
			return false;
		}
	}
	public void validateMedicalBenefitDrugSection() {
		validateNew(drugCoveredInfo);
		validateNew(estimatedAnnualDrigCostLabel);
		validateNew(estimatedAnnualDrigCostValue);
	}

public MultiCountyModalPage VPP_ChangeLocationValidateMultiCOuntyPopUp(String zipcode) {
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	validate(ChangeLocationLink);
	ChangeLocationLink.click();
	validate(ZipCodeTxtBx);
	ZipCodeTxtBx.click();
	ZipCodeTxtBx.clear();
	ZipCodeTxtBx.sendKeys(zipcode);
	validate(FIndPlansButton);
	FIndPlansButton.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	if (countyModal.isDisplayed()) {
		return new MultiCountyModalPage(driver);
	}
	return null;
}


}
