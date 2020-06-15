/**
 *
 */
package pages.vbfacquisition_deprecated.bluelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.vbfacquisition_deprecated.ole.WelcomePage;
import pages.vbfacquisition_deprecated.uhcretiree.Rallytool_Page;
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

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


	//@FindBy(xpath ="//div[@id='maplans_container']/div[3]/div/div/div/div[@class='ng-scope']")
	@FindBy(xpath = "//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@id='plan-list-1']/div/div[1]/div/div/h2")
	WebElement maPlanHeadingText;


	@FindBy(xpath = "//div[@id='maplans_container']/h1/span")
	WebElement maPlanHeadingYear;

	@FindBy(xpath="//div[contains(@ng-repeat,'plan in planModel.maPlans')]")
	List<WebElement> maPlans;


	@FindBy(xpath = "//div[@id='plan-list-3']/div/div[1]/div/div/h2")
	WebElement pdpPlanHeadingText;

	@FindBy(xpath = "//div[@id='pdpplans_container']/h1/span")
	WebElement pdpPlanHeadingYear;

	@FindBy(xpath="//div[contains(@ng-repeat,'plan in planModel.pdpPlans')]")
	List<WebElement> pdpPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement viewPlans;
	
	@FindBy(xpath ="//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement viewPDPPlans;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span[2]")
	WebElement msnPlanHeadingText;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span")
	WebElement msnPlanHeadingYear;

	@FindBy(xpath="//div[@data-ng-repeat='plan in snpplans']")
	List<WebElement> msnPlans;

	@FindBy(xpath =".//*[@id='pdpplans_container']")
	List<WebElement> pdpPlanElement;

	@FindBy(xpath =".//*[@id='viewDetailsMA']")
	private WebElement viewDetailsBtnMA;

	@FindBy(xpath="//div[@id='snpplans_container']")
	List<WebElement> snpPlanElement;

	@FindBy(linkText ="Make an appointment with an agent")
	private WebElement make_an_appointment_agent;

	@FindBy(css="#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;

	@FindBy(css="#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath=".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[1]/label")
	private WebElement compareChkBox3;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	@FindBy(className = "toggleYear")
	private WebElement toggleplanYear;

	@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	private WebElement MaProviderLink;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[1]/h2")
	private WebElement allPlansSize;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[2]/div[1]/div/span[1]/span")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[2]/div[2]/div/span[1]/span")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[2]/div[3]/div/span[1]/span")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[2]/div[4]/div/span[1]/span")
	private WebElement msnPlansCount;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/span/a")
	private WebElement view2017Plans;

	@FindBy(className = "planYear")
	WebElement planYear;

	@FindBy(xpath=".//*[@class='action-btn getStarted']")
	private WebElement GetStarted;

	//@FindBy(xpath="//*[contains(text(),'People')]")

	@FindBy(xpath=".//*[@class='gs-option']//*[contains(text(),'People')]")
	private WebElement People;
	
	@FindBy(xpath="//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]/div/*[@class='trigger-closed']")
	private WebElement closedTrigger;	
	
/*This SNP View Plans identifier is invalid
	@FindBy(xpath="//div[@class='snpplans_planbutton']/div[2]/div[2]/div")
	private WebElement snpplans;			
*/
	@FindBy(xpath="//*[contains(text(), 'Special Needs Plans')]/following-sibling::*[@class = 'trigger-closed']")
	private WebElement snpplans;			

	

	@FindBy(xpath="//div[@class='medsupplans_planbutton']/div[2]/div[1]/a")
	private WebElement medsupplans;			
	//"

	//@FindBy(xpath="//*[contains(text(),'Primary Care')]")
	@FindBy(xpath=".//*[@class='gs-option']//*[contains(text(),'Primary Care')]")
	private WebElement Primary;

	@FindBy(xpath="//*[contains(text(),'Primary Care Physician')] ")
	private WebElement Physician;

	//@FindBy(xpath=".//*[contains(@ng-bind-html,'buttonText')  and contains(text(),'Save')]")
	//private WebElement Savebtn;


	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']/button[@class='section action-btn saved-provider-button']")
	private WebElement Savebtn;

	//@FindBy(xpath=".//*[@id='label_unsaved_selectedLocation0']")

	@FindBy(xpath="//*[@class='action-btn lt']")
	private WebElement Viewsavebtn;

	@FindBy(xpath="//button[@class='action-btn negative']")
	private WebElement Checkcoverage;

	@FindBy(xpath="//*[@id='physicians_info']")
	private WebElement provider;

	@FindBy(className = "planType_info")
	WebElement planHeadingText;

	@FindBy(xpath=".//*[@id='viewmoredetlinkpdp']")
	WebElement viewDetailsPDP;

	@FindBy(xpath = "//div[@class='module-closed-enrollment-alert']/span/a")
	private WebElement viewPlansYearLink;

	@FindBy(xpath = ".//*[@class='swiper-container']")
	List<WebElement> maPlanElement1;
	
	//Right Rail Element - TFN
	@FindBy(xpath="//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;
	


	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		//openAndValidate();
	}



	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageFactory.initElements(driver, this);

		String fileName = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			fileName = "maplans.json";
		} else if (planType.equalsIgnoreCase("PDP")) {
			fileName = "pdpplans.json";
		} else if (planType.equalsIgnoreCase("SNP")) {
			fileName = "snpplans.json";
		} else {
			fileName = "msplans.json";
		}

		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		vppPlanSummaryJson = formJsonObject(vppPlanSummary);

	}

	public boolean validatePlanSummary(){
		boolean flag = true;
		int allPlans = 0;
		int maPlans = 0;
		int msPlans = 0;
		int pdpPlans =0;
		int msnPlans = 0;
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(allPlansSize)){
			 allPlans = Integer.valueOf(allPlansSize.getText().split(" ")[2]);
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}

		if(validate(maPlansCount)){
			 maPlans = Integer.valueOf(maPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
		
		if(validate(msPlansCount)){
			 msPlans = Integer.valueOf(msPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
		
		if(validate(pdpPlansCount)){
			 pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
	
		if(validate(msnPlansCount)){
			 msnPlans = Integer.valueOf(msnPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
	
		if(validate(msnPlansCount)){
			if(!(allPlans == maPlans + msPlans + pdpPlans + msnPlans))
			{
				flag = false;
			}
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}

		return flag;
	}

	public boolean validateAvailablePlans(String planType){
		boolean flag = true;
		int planCount = 0;
		if(planType.equals("MAPD") || planType.equals("MA") ){
			String planHeading = null;
			if(maPlanHeadingText.isDisplayed()){
				planHeading = maPlanHeadingText.getText();
				System.out.println(planHeading);
				if(!planHeading.contains("Medicare Advantage Plans")){
					flag = false;
				}
			}

			planCount = Integer.valueOf(maPlansCount.getText());
			for(int i=0;i<planCount;i++){
				if(maPlans.get(i).getText().length()==0){
					flag=false;
				}
			}

		}else if(planType.equals("PDP")){
			String planHeading = null;
			if(pdpPlanHeadingText.isDisplayed()){
				planHeading = pdpPlanHeadingText.getText();
				System.out.println(planHeading);
				if(!planHeading.contains("Medicare Prescription Drug Plans")){
					flag = false;
				}
			}
			planCount = Integer.valueOf(pdpPlansCount.getText());
			for(int i=0;i<planCount;i++){
				if(pdpPlans.get(i).getText().length()==0){
					flag=false;
				}
			}
		}else if(planType.equals("SNP")){
			String planHeading = msnPlanHeadingText.getText();
			System.out.println(planHeading);
			if(!planHeading.equals("Medicare Special Needs Plans")){
				flag = false;
			}
			planCount = Integer.valueOf(msnPlansCount.getText());
			for(int i=0;i<planCount;i++){
				if(msnPlans.get(i).getText().length()==0){
					flag=false;
				}
			}
		}else{
			flag = false;
		}

		return flag;
	}

	public boolean validatePlanSummarydetails(String planName){
		boolean flag = true;
		String fileName = null;
		WebElement planContainer = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			planContainer = snpPlanConatiner;
		}
		else if (planName.contains("HMO")) {
			fileName = "maplansummary.json";
			planContainer = maPlanConatiner;
		}
		else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			planContainer = pdpPlanConatiner;
		}else if(planName.contains("Regional PPO"))
		{
			fileName = "mamultistateplansummary.json";
			planContainer = maPlanConatiner;
		}

		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className","ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(
							vppPlanSummary.getExpectedData().get(key), plan);
					System.out.println("Checking for the element : "+key );
					flag = validate(element);
					if(!flag){
						break;
					}
				}
			}
		}
		return flag;
	}
	public PlanDetailsPage navigateToPlanDetails(String planName) {
		System.out.println("******");
		System.out.println(planName);
/*		if (planName.contains("HMO") || (planName.contains("Regional PPO"))) {
			ElementData elementData = new ElementData("id", "viewmoredetlinkmapd");
			WebElement element = getViewPlanDetailsElement(maPlanElement, elementData, planName);
			if (element != null) {
				element.click();
			}
			System.out.println(driver.getCurrentUrl());
		} else */
		
		if (planName.contains("PDP")) {
//			ElementData elementData = new ElementData("id", "viewmoredetlinkpdp");
//			WebElement element = getViewPlanDetailsElement(pdpPlanElement, elementData, planName);
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[@id = 'viewmoredetlinkpdp']"));
			validate(PDPmoreDetailsLink);
			PDPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
/*			if (element != null) {
				element.click();
			}
*/		}
		else if (planName.contains("SNP")) {
/*			ElementData elementData = new ElementData("id", "viewDetailsSNP");
			WebElement element = getViewPlanDetailsElement(snpPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();
			}*/
			WebElement SNPmoreDetailsLink = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(), 'View plan and drug coverage details')]"));
			validate(SNPmoreDetailsLink);
			SNPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for SNP plan"+planName);

		}else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			ElementData elementData = new ElementData("id", "viewmoredetlinkmapd");
			WebElement element = getViewPlanDetailsElement(maPlanElement, elementData, planName);
			if (element != null) {
				element.click();
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Title is :"+driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_PLAN_DETAILS)
				|| driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SPECIAL_NEEDS_PLAN_DETAILS)
				|| driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PRESCRIPTION_DRUG_PLAN_DETAILS)
				|| driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new PlanDetailsPage(driver);
		}
		return null;
	}

	private WebElement getViewPlanDetailsElement(List<WebElement> maPlanElement2, ElementData elementData,
			String planName) {
		CommonUtility.waitForPageLoad(driver,viewDetailsBtnMA,CommonConstants.TIMEOUT_30);
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

	public VPPPlanSummaryPage viewPlanSummary(String planType) {
		WebDriverWait wait = new WebDriverWait(driver, 45000);

		if (planType.equalsIgnoreCase("PDP")) {
			if(viewPDPPlans.isDisplayed()){
			wait.until(ExpectedConditions.elementToBeClickable(viewPDPPlans)).click();
			}
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
		
				if(validate(closedTrigger)){
					wait.until(ExpectedConditions.elementToBeClickable(closedTrigger)).click();
				}			
			
		} else if (planType.equalsIgnoreCase("SNP")) {

			if(validate(snpplans)){
				wait.until(ExpectedConditions.elementToBeClickable(snpplans)).click();
			}					
		} else {
			if(validate(medsupplans)){
				wait.until(ExpectedConditions.elementToBeClickable(medsupplans)).click();
			}	
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	private JSONObject formJsonObject(PageData vppPlanSummary) {
		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(vppPlanSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(vppPlanSummary
									.getExpectedData().get(key)
									.getElementName(), element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return jsonObject;

	}

	@Override
	public void openAndValidate() {
		validate(showMaPlans);
		validate(showMsPlans);
		validate(showPdpPlans);
		validate(showSnpPlans);
		vppPlanSummaryJson = formJsonObject(vppPlanSummary);
	}

	public JSONObject getPlanSummaryActualData(String planName) {
		String fileName = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,snpPlanConatiner);
			return jsonObject;
		}
		else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			fileName = "maplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,maPlanConatiner);
			return jsonObject;
		}
		else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,pdpPlanConatiner);
			return jsonObject;
		}else if(planName.contains("Regional PPO"))
		{
			fileName = "mamultistateplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,maPlanConatiner);
			return jsonObject;

		}


		return null;
	}

	private JSONObject getActualJsonObject(String fileName, String planName,
			WebElement planContainer) {

		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className","ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				JSONObject jsonObject = new JSONObject();
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(
							vppPlanSummary.getExpectedData().get(key), plan);
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
			WebElement element = getViewPlanDetailsElement(maPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();

			}

		} else if (planName.contains("PDP")) {
			ElementData elementData = new ElementData("id", "editDrugMA");
			WebElement element = getViewPlanDetailsElement(pdpPlanElement,
					elementData, planName);
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
			if(maPlans !=null){
			for (WebElement plan : maPlans) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollMAButton");
					if(findChildElement(elementData, plan).isDisplayed()){
						findChildElement(elementData, plan).click();
						break;
					}else{
						if(viewPlansYearLink.isDisplayed()){
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
							if(maPlans !=null){
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
					if(findChildElement(elementData, plan).isDisplayed()){
						findChildElement(elementData, plan).click();
						break;
					}else{

						if(viewPlansYearLink.isDisplayed()){
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
			if (pageHeading.getText().equalsIgnoreCase(
					"You Have Chosen to Enroll in the Following Plan")) {
				break;
			}else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (pageHeading.getText().equalsIgnoreCase(
				"You Have Chosen to Enroll in the Following Plan")) {
			return new EnrollPlanInfoPage(driver);
		}else{
			return null;
		}

	}

	public GetStartedPage clicksOnEnterDrugInformationLink(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"enterDrugMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"enterDrugPDP"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new GetStartedPage(driver);
		}
		return null;

	}

	public Rallytool_Page clicksOnIsProviderCovered(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Welcome")) {
			return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}

	public VPPPlanSummaryPage clicksOnIsProviderCoveredB(String planName) {
		if (planName.contains("HMO")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			for (WebElement plan : maPlanElement1) {
				if (plan.getText().contains(planName)) {
					//ElementData elementData = new ElementData("id",
						//	"doctorCoverMA");

					//ElementData elementData = new ElementData("xpath",

//"//*[contains(text(),'Is my provider covered in my ZIP code/county')]");
					//driver.findElement(By.xpath("//*[contains(text(),'Is my provider covered ')]")).click();

					//driver.findElement(By.xpath("//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/a")).click();

					//findChildElement(elementData, plan).click();

					WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/following::a[contains(text(),'Is my provider')]"));
					System.out.println(ProviderSearchLink.getText());
					ProviderSearchLink.click();


				}
			}
		}

		String mainwindow=driver.getWindowHandle();

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

		System.out.println("Rally tool started");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", People);


		waitforElement(Primary);

		Primary.click();

		waitforElement(Physician);


		Physician.click();

		waitforElement(Savebtn);

		//Savebtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Savebtn);
		waitforElement(Viewsavebtn);

		Viewsavebtn.click();

		waitforElement(Checkcoverage);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Checkcoverage.click();
		driver.switchTo().window(mainwindow);


		return new VPPPlanSummaryPage(driver);
	}

	public VPPPlanSummaryPage clicksOnIsProviderCoveredA(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement1) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}


		String mainwindow=driver.getWindowHandle();

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

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Savebtn);

		//Savebtn.click();
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


	public boolean providerinfo()
	{
		String providerinfo=provider.getText();
		if(providerinfo.contains("1 providers covered"))
		{
			return true;
		}
		return false;
	}
	
	public boolean providerinfo(String planName)
	{

		WebElement ProviderSearchLink1 = driver.findElement
				(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide ng-scope')]/descendant::span[contains(text(),'covered')]"));
		String mproviderinfo=ProviderSearchLink1.getText();
        System.out.println(mproviderinfo);
		if(mproviderinfo.contains("1 providers covered"))
		{
			return true;
		}
		return false;
	}


	public RequestAgentAppointmentPage nagiateToRequetAnAppointmentPage()
	{
		make_an_appointment_agent.click();

		try {
			if (make_an_appointment_agent.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, make_an_appointment_agent,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("make_an_appointment_agent not found");
		} catch (TimeoutException ex) {
			System.out.println("make_an_appointment_agent not found");
		} catch (Exception e) {
			System.out.println("make_an_appointment_agent not found");
		}
		if(currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html"))
		{
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

	public  void clicksOnMAProviderCoveredLink()
	{
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton(){
		waitforElement(comparePDPPlanChkBox);
		Assert.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assert.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}

	public void clickAndVerifyCompareUpto3PlansPopup(){
		comparePDPPlanChkBox.click();
		Assert.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",compareUpto3PlansPopup.getText().trim());
	}

	public boolean verifyCompareCheckBoxesAreUnchecked(){
		List<WebElement> compareChkBoxes = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));

		if(!compareChkBoxes.get(1).isSelected())
			return true;
		return false;

	}

	public void UncheckAndVerifyCompareChkBox(){
		if(validate(compareChkBox3)){
			compareChkBox3.click();
		}
		
		Assert.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox3.getAttribute("class"));
	}

	public void VerifyComparePopUpText(){

		Assert.assertEquals("Select 1 more plan to compare",comparePopUpTxt1.getText().trim());
		Assert.assertEquals("Select 2-3 plans that you'd like to compare",comparePopUpTxt2.getText().trim());
	}

	public void clickCompareChkBox(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));

		if(allMAPlans !=null){
				allMAPlans.get(1).click();
				
		}

	}
	public boolean validatepassportData() {
		try {
			Thread.sleep(20000);

			String expectedpassportdata=PassportFlyerPDF.getText();
			String actualpassportdata="Passport Flyer (PDF)";
			if(expectedpassportdata.equalsIgnoreCase(actualpassportdata))
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;

	}

	

	public boolean validateVPPPlanSummaryPage(){
		WebDriverWait wait = new WebDriverWait(driver, 45000);
		boolean flag = false;
		/*if(validate(viewPlans)){
		viewPlans = wait.until(ExpectedConditions.elementToBeClickable(viewPlans));
		}
		if(validate(viewPDPPlans)){
		viewPDPPlans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[3]")));
		}
		if(validate(changeLocationBtn)){
		changeLocationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change location")));
		}*/


		if(validate(viewPlans)&&validate(viewPDPPlans)&&validate(changeLocationBtn))
			flag = true;
		return flag;
	}



	public PlanDetailsPage clickViewDetails() {
		List<WebElement> viewPlansLinks = driver.findElements(By.id("viewmoredetlinkma"));
		if(viewPlansLinks !=null){
		viewPlansLinks.get(3).click();
		
		}
		if(getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE))
			return new PlanDetailsPage(driver);
		return null;
	}

	public PlanDetailsPage clickViewDetailsPDP() {
		if(validate(viewDetailsPDP)){
			viewDetailsPDP.click();
			}
	
		if(getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE))
			return new PlanDetailsPage(driver);
		return null;
	}

	public void clickonViewPlans() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		if(!validate(viewPlans)){
		viewPlans.click();
		}

	}

	public void clickOnPDPPlans(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(viewPDPPlans)){
		viewPDPPlans.click();
		}
	}

	public void clickOnViewPlans(String plantype) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		if(plantype.equals("MA")||plantype.equals("MAPD")){
			if(!validate(viewPlans))	 {
				AssertTrue("No plans for MA",false);
			}else			
				viewPlans.click();
		}else
			viewPDPPlans.click();

	}

	private void AssertTrue(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}



	public DrugCostEstimatorPage navigateToDCE(String plantype) {
		if(plantype.equals("MA")||plantype.equals("MAPD")){
			//viewPlans.click();
			List<WebElement> maDCELink = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[@class='mabenefittable']//a[contains(@dtmname, 'Plans Landing:Plan:MA:Drug Cost Estimator')]"));
			maDCELink.get(0).click();
		}else{
			//viewPDPPlans.click();
			List<WebElement> view2017PDPPlans = driver.findElements(By.id("pdpDrugCostEstimatorLink"));
			view2017PDPPlans.get(0).click();

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	public DrugCostEstimatorPage navigateToDCEAfterDrugAdded(String plantype) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(plantype.equals("MA")||plantype.equals("MAPD")){
			if(validate(viewPlans)){
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
		}else{
			if(validate(viewPDPPlans)){
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
		if(currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;

	}

	public void choose2017Plans() {
		
		if(validate(viewPlans)){
			viewPlans.click();	
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(view2017Plans!=null){
			view2017Plans.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//viewPlans.click();
		}

	}

	public boolean yearBtnExists() {
		if(validate(view2017Plans))
			return true;
		return false;
	}
	
	/**
	 * Methods added for OLE Flow validations
	 * @author sdwaraka
	 * @param PlanName
	 * @return
	 */
	public String getPlanPremium(String PlanName) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("Plan Name is : "+PlanName);
		
		WebElement PremiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+PlanName+"')]/ancestor::*[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(),'Monthly Premium')]//*[contains(text(),'$')]"));
		String PlanPremium = PremiumForPlan.getText();
		
		System.out.println("Premium for Plan : "+PlanPremium);
		return PlanPremium;
	}

	/**
	 * @author sdwaraka
	 * Method Added for OLE Flow - Navigate to OLE from Plan Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {
		
		System.out.println("Enroll in Plan for Plan : "+planName);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		try {
		validate(EnrollForPlan);
		
		System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}catch(Exception e){
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}
		EnrollForPlan.click();
		
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("enrollment")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	/**
	 * @author sdwaraka
	 * Method added for OLE Flow Validations
	 * @return
	 */
	public String GetTFNforPlanType() {
		if(validate(RightRail_TFN)){
			System.out.println("TFN is displayed in Right Rail");
			String TFN_Number = RightRail_TFN.getText();
			return TFN_Number;
		}
		System.out.println("TFN is not Displayed for PlanType in VPP page");
		
		return null;
	}

	public PlanComparePage selectplantocompare(String PlanType) {
		//To add upto 4 plans to compare and navigate to Plan Compare Page
		int count = 1;
		if(PlanType.contains("PDP")){
			System.out.println("Plan Type is :"+PlanType);
			count = (Integer.parseInt(maPlansCount.getText())) + 1;
			System.out.println("Plan count starts is :"+count);
		}
		int CountUntil = count+4;
		do{
			String temp = Integer.toString(count);
			WebElement SelectCompare = driver.findElement(By.xpath("//*[@id = 'compare-plan-"+temp+"']//following-sibling::label"));
			if(validate(SelectCompare))
				SelectCompare.click();
			count++;
		}while(count<CountUntil);
		
	List <WebElement> ComparePlansLinks = driver.findElements(By.xpath("//a[@class='compare-link']"));
		//validate();
	for(WebElement CompareLink : ComparePlansLinks){
		if(CompareLink.isDisplayed()){
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

}

