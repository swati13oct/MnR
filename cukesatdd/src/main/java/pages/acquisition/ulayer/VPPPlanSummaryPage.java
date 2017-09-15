/**
 * 
 */
package pages.acquisition.ulayer;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.DrugCostEstimatorPage;

/**
 * @author 
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
	private WebElement showMaPlans;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[1]/div/span/span[@class='ng-binding']")
	private WebElement maPlansNumber;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[1]//span[@class='trigger-closed']")
	private WebElement maPlansViewLink;
	
	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;
	
	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='ng-binding']")
	private WebElement msPlansNumber;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='trigger-closed']")
	private WebElement msPlansViewLink;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansNumber;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='trigger-closed']")
	private WebElement pdpPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-main']/span/h2")
	private WebElement vppTop;
	
	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hideMaPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']")
	private WebElement vppplansummarypage;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/span[3]")
	private WebElement showMsPlans;
	

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[3]")
	private WebElement showPdpPlans;
	
	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hidePdpPlans;

	@FindBy(xpath = "//div[@class='enabled ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
	List<WebElement> pdpPlanElement;
	
	@FindBy(id = "medicalinsursectionheading")
	private WebElement pageHeading;

	@FindBy(id = "editDrugMA")
	private WebElement editDrugListLink;
	
	@FindBy(linkText = "All Primary Care Physicians")
	private WebElement allPrimaryCarePhysicians;
	
	@FindBy(linkText = "Complete my list")
	private WebElement completeMyList;
	
	@FindBys(value = { @FindBy(className = "firstTierFilterItem") })
	private List<WebElement> physcianSearchTypes;
	
	@FindBys(value = { @FindBy(xpath = "//div[@id='providerResultsContainer']/div") })
	private List<WebElement> providerNameList;
	
	
	@FindBy(id = "allplanssise")
	private WebElement allPlansSize;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[1]/span")
	private WebElement maPlansCount;
	
	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[1]/p")
	private WebElement msPlansCount;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[1]/span")
	private WebElement pdpPlansCount;
	
	@FindBy(id = "pageHeader")
	private WebElement pageHeader;
	
	@FindBy(id = "providerSearchFrame")
	private WebElement providerSearchIframe;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div")
	private WebElement viewPlans;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]")
	private WebElement viewPDPPlans;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[3]/div/div/span[1]/label")
	private WebElement maplan1;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[2]/div[3]/div/div/span[1]/label")
	private WebElement maplan2;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[1]/label")
	private WebElement maplan3;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[3]/div/div/span[3]")
	private WebElement maChkboxMessage1;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[2]/div[3]/div/div/span[3]")
	private WebElement maChkboxMessage2;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[3]")
	private WebElement maChkboxMessage3;
	
	
	@FindBy(xpath = ".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[3]/a")
	private WebElement compareLink;
	
	@FindBy(className = "switchPlanYear")
	private WebElement toggleplanYear;
	
	//@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	@FindBy(xpath=".//*[@id='doctorCoverMA']")
	private WebElement MaProviderLink;
	
	@FindBy(xpath="//div[@id='mainWrapper']/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[3]/div/div[1]/a")
	private WebElement previousYearLink;


	@FindBy(css="#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;
	
	@FindBy(id="pdpplans")
	private WebElement pdpShowPlansLnk;
	
	@FindBy(css="#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//span[@class='cpcheckbox']/input")
	private WebElement compareChkBox;
	
	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;
	
	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	@FindBy(xpath=".//div[@id='pdpplans_container']/div[3]/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement PDPEnrolllink;

	
	@FindBy (xpath=".//div[@id='maplans_container']/div[3]/div[1]/div/div[1]/div[1]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement MAEnrolllink;
	
	@FindBy (xpath=".//*[@id='next']")
	private WebElement stayOnthisPopup;
	
	
	@FindBy(xpath="//div[@class='tab-contents']/span[contains(text(),'Medicare Advantage Plans')]/following-sibling::span[text()='View Plans'][2]")
	private WebElement viewMAPlansC;
	
	@FindBy(xpath="//button[contains(text(),'Get Started')]")
	private WebElement GetStarted;
	

	@FindBy(xpath="//h3[text()='People']/preceding::div[1]/img")
	private WebElement People;
	
	@FindBy(xpath="//h3[text()='Primary Care']")
	private WebElement Primary;
	
	
	@FindBy(xpath="//a[contains(text(),'Primary Care Physician (PCP')]")
	private WebElement Physician;

	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']/button[not(contains(@class,'hidden'))]/span")
	private WebElement Savebtn;

	@FindBy(xpath="//*[@class='action-btn lt']")
	private WebElement Viewsavebtn;

	@FindBy(xpath="//button[@class='action-btn negative']")
	private WebElement Checkcoverage;
	
	@FindBy(xpath="//p/span[@class='ng-binding']")
	private WebElement provider;
	
	@FindBy(xpath = ".//*[@class='swiper-container']")
	List<WebElement> maPlanElement1;
	
	@FindBy(name = "emailWidgetForm")
	private WebElement emailWidgetForm;
	
	

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, vppplansummarypage, CommonConstants.TIMEOUT_30);
		
	/*	String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ); */
		openAndValidate();
	}

	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	

	private WebElement getViewPlanDetailsElement(
			List<WebElement> planElement, ElementData elementData,
			String planName) {
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {

				WebElement element = findChildElement(elementData,
						plan);

				return element;

			}
		}
		return null;
	}
	
	private WebElement getSpecificPlanSummary(
			List<WebElement> planElement,
			String planName) {
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {

				return plan;

			}
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		/*validate(showMaPlans);
		validate(showMsPlans);
		validate(showPdpPlans);*/
		// vppPlanSummaryJson = formJsonObject(vppPlanSummary);
	}

	
	
	public boolean validateTimeoutPopup()
	{
		boolean validatePopup=false;
		try{
			
			Thread.sleep(600000);
			validatePopup=validate(stayOnthisPopup);
			stayOnthisPopup.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return validatePopup;
}


	public VPPPlanSummaryPage viewPlanSummary(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			pdpPlansViewLink.click();
			//validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			maPlansViewLink.click();
			//validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			msPlansViewLink.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}
	
	public VPPPlanSummaryPage viewPlanSummaryButton(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
			validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			//showMaPlans.click();
			//viewMAPlans.click();
			viewMAPlansC.click();
			validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			showMsPlans.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}
	
	public VPPPlanSummaryPage clicksOnIsProviderCovered(String planName) {
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
					
					WebElement ProviderSearchLink = driver.findElement(By.xpath("//h2[contains(text(),'"+planName+"')]/following::a[contains(text(),'Is')][1]"));
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
		People.click();
				
		
		
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
		
		Checkcoverage.click();
		driver.switchTo().window(mainwindow);

		
		return new VPPPlanSummaryPage(driver);
	}
	
	public void wAitt()
	{
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean providerinfo(String planName)
	{
		String providerinfo=provider.getText();
		
		WebElement ProviderSearchLink1 = driver.findElement
				(By.xpath("//h2[contains(text(),'"+planName+"')]/following::span[contains(text(),'covered')][1]"));
		String mproviderinfo=ProviderSearchLink1.getText();
        System.out.println(mproviderinfo);
		if(providerinfo.contains("1 providers covered"))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean selectPlanType(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
			return validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			showMaPlans.click();
			return  validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			showMsPlans.click();
		}
		return false;
		//return new VPPPlanSummaryPage(driver, planType);
	}



	public String togglePlan() {
		String currentYearFlag = "false";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

	public boolean clicksOnMAProviderCoveredLink() {
		previousYearLink.click();
		validate(MaProviderLink);
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Welcome")) {
			return true;
		}
		return false;
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton(){
		
		Assert.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assert.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}
	
	public void clickAndVerifyCompareUpto3PlansPopup(){
		comparePDPPlanChkBox.click();
		Assert.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",compareUpto3PlansPopup.getText().trim());
	}
	
	public void verifyCompareCheckBoxesAreUnchecked(){
		
		Assert.assertEquals("compare_checkbox ng-scope ng-pristine ng-valid", compareChkBox.getAttribute("class"));
		
	}
	
	public void UncheckAndVerifyCompareChkBox(){
		compareChkBox.click();
		Assert.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox.getAttribute("class"));
	}
	
	public void VerifyComparePopUpText(){
		
		Assert.assertEquals("Select 1 more plan to compare",comparePopUpTxt1.getText().trim());
		Assert.assertEquals("Select 2-3 plans that you'd like to compare",comparePopUpTxt2.getText().trim());
	}
	
	public void clickCompareChkBox(){
		waitforElement(compareChkBox);
		compareChkBox.click();

	}
		
	public boolean plantitlematch(String planname, String plantype) {
		if ((plantype.equalsIgnoreCase("MA") && planname.contains("HMO"))||(plantype.equalsIgnoreCase("PDP") && planname.contains("PDP"))) {
			return true;
		} else 
		return false;
	}
	
	public boolean verifyandclickenrolllink(String plantype)
	{
		if(plantype.equals("PDP"))
		{
			if(validate(PDPEnrolllink))
			{
			PDPEnrolllink.click();
			driver.navigate().back();
			togglePlan();
			PDPEnrolllink.click();
			driver.navigate().back();
			return true;
			}
		}
		else if(plantype.equals("MA"))
		{
			if(validate(MAEnrolllink))
			{
			MAEnrolllink.click();
			driver.navigate().back();
			togglePlan();
			MAEnrolllink.click();
			driver.navigate().back();
			return true;
			}
		}
		return false;
	}
	
	

	public boolean validatepassportData() {
		try {
			Thread.sleep(15000);

			String expectedpassportdata = PassportFlyerPDF.getText();
			System.out.println("expectedpassportdata"+expectedpassportdata);
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

	public boolean getSpecificPlanInfo(String planName) {
		WebElement element = null;
		ElementData elementData = new ElementData("className",
				"module-plan-overview");
		if (planName.contains("HMO")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			 element = getSpecificPlanSummary(findChildElements(elementData, maPlanList), planName);

		} else if (planName.contains("PDP")) {
			//ElementData elementData = new ElementData("id", "viewDetailsPDP");
			 element = getSpecificPlanSummary(findChildElements(elementData, pdpPlanList), planName);
		} 
		else if (planName.contains("Regional PPO")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			 element = getSpecificPlanSummary(findChildElements(elementData, maPlanList), planName);
		}
		
		return validate(element);
	}

	public boolean validatePlansNumber() {
		
		int allPlans = Integer.valueOf(allPlansSize.getText().replace(" ", ""));
		int maPlans = Integer.valueOf(maPlansCount.getText().replace(" Plans", ""));
		int msPlans = Integer.valueOf(msPlansCount.getText().replace(" Plans", ""));
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText().replace(" Plans", ""));

			
		if(allPlans == maPlans + msPlans + pdpPlans)
		{
			return true;
		}
		return false;
	}

	public boolean validatePlanNames(String planType) {

		ElementData elementData = new ElementData("className",
				"module-plan-overview");

		if (planType.equalsIgnoreCase("PDP")) {

			int pdpPlans = Integer.valueOf(pdpPlansNumber.getText());
			return pdpPlans == findChildElements(elementData, pdpPlanList)
					.size();

		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {

			int maPlans = Integer.valueOf(maPlansNumber.getText());
			 //driver.findElement(By.className("module-plan-overview"));
			return maPlans == findChildElements(elementData, maPlanList).size();
		}
		return false;
	}
	
	@FindBy(linkText = "Change location")
	private WebElement changeLocationBtn;
	
	public boolean validateVPPPlanSummaryPage() {

		validate(vppTop);
		validate(maPlansNumber);
		validate(msPlansNumber);
		validate(pdpPlansNumber);

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12));
		int maPlans = Integer.valueOf(maPlansNumber.getText());
		int msPlans = Integer.valueOf(msPlansNumber.getText());
		int pdpPlans = Integer.valueOf(pdpPlansNumber.getText());

		if (allPlans == maPlans + msPlans + pdpPlans) {
			return true;
		}
		return false;

	}
	public IntroductionInformationPage clicksOnEnrollInplanLink(String planName) {
		 
		int pdpValue = Integer.parseInt(pdpPlansNumber.getText());
		int maValue = Integer.parseInt(maPlansNumber.getText());
		
		if (planName.contains("HMO")) {
			System.out.println("Entered the plan");
			for(int i=1; i<=maValue; i++){
				WebElement maPlanElement= driver.findElement(By.xpath(".//*[@id='plan-list-1']/div/div[2]/div/div["+i+"]"));
				if (maPlanElement.getText().contains(planName)) {
					ElementData elementData = new ElementData("linkText", "Enroll in plan");//("id", "enrollMA");
					System.out.println("***Element Data is: "+elementData);
					findChildElement(elementData, maPlanElement).click();
					System.out.println("Clicked on the Enroll Link");
					break;
				}
				
			}
		} else if (planName.contains("PDP")) {
			for(int i=1; i<=pdpValue; i++){
				WebElement pdpPlanElement= driver.findElement(By.xpath(".//*[@id='plan-list-3']/div/div[2]/div/div["+i+"]"));
				if (pdpPlanElement.getText().contains(planName)) {
					ElementData elementData = new ElementData("linkText", "Enroll in plan");//("id", "enrollPDP"); // TODO:
					System.out.println("***Element Data is: "+elementData);													// Re-check
					findChildElement(elementData, pdpPlanElement).click();
					System.out.println("Clicked on the Enroll Link");
					break;
				}
				
			}
			
		}
		return new IntroductionInformationPage(driver);
	}
	
	public PlanDetailsPage navigateToPlanDetails(String planName, String planType) {

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			ElementData elementData = new ElementData("id", "viewmoredetlinkmapd");
			WebElement element = getViewPlanDetailsElement(maPlanElement, elementData, planName);
			if (element != null) {
				element.click();

			}

		} else if (planType.equalsIgnoreCase("PDP")) {
			ElementData elementData = new ElementData("linkText", "View more details");
			WebElement element = getViewPlanDetailsElement(pdpPlanElement, elementData, planName);
			if (element != null) {
				element.click();

			}

		}
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Plan Details | AARP® Medicare Plans from UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase("Plan Detail")) {
			return new PlanDetailsPage(driver, planType);
		}

		return null;
	}
	
	public void clickonViewPlans() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewPlans.click();
		
	}
	
	public void clickOnPDPPlans(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewPDPPlans.click();
	}
	
	
	public void checkAllMAPlans(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maplan1.click();
		maplan2.click();
		maplan3.click();
		
	}
	
	public ComparePlansPage clickOnComapreLink(){
		compareLink.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;
	}
	
	public boolean validateAllPlansChecked() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(maChkboxMessage1)&&validate(maChkboxMessage2)&&validate(maChkboxMessage3))
			return true;
		return false;
	}
	
	public DrugCostEstimatorPage navigateToDCE(String plantype) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(plantype.equals("MA")||plantype.equals("MAPD")){
			viewPlans.click();
			List<WebElement> view2017Plans = driver.findElements(By.id("maDCELink"));
			view2017Plans.get(0).click();
		}else{
			viewPDPPlans.click();
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
	

}

	
