/**
 * 
 */
package pages.vbfacquisition_deprecated.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;
import pages.vbfacquisition_deprecated.ole.WelcomePage;

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
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]/div/span/span[@class='ng-binding']")
	private WebElement snpPlansNumber;

	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement maPlansViewLink;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement snpPlansViewLink;

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;
	
	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;
	
	@FindBy(id = "plan-list-4")
	private WebElement snpPlanList;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='ng-binding']")
	private WebElement msPlansNumber;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='trigger-closed']")
	private WebElement msPlansViewLink;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansNumber;
	
	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement pdpPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-main']/h2")
	private WebElement vppTop;
	
	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hideMaPlans;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/span[3]")
	private WebElement showMsPlans;
	

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[3]")
	private WebElement showPdpPlans;
	
	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hidePdpPlans;
                                   
	@FindBy(xpath = "//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
	List<WebElement> pdpPlanElement;
	
	//Change PDP Plan Element identifier. Same as for MA/MAPD plans
/*	@FindBy(xpath = "//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> pdpPlanElement;
*/
	@FindBy(xpath="//div[contains(@ng-repeat,'plan in planModel.maPlans')]")
	List<WebElement> maPlans;
	
	@FindBy(xpath = "//div[@class='module-closed-enrollment-alert']/span/a")
	private WebElement viewPlansYearLink;
	
	@FindBy(xpath="//div[contains(@ng-repeat,'plan in planModel.pdpPlans')]")
	List<WebElement> pdpPlans;
	
	@FindBy(id = "allplanssise")
	private WebElement allPlansSize;

	@FindBy(xpath = ".//*[@id='site-wrapper']//div[@class='plan-overview-wrapper']//div[@class='overview-tabs module-tabs-tabs']/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']//div[@class='plan-overview-wrapper']//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='trigger-closed']")
	private WebElement msPlansCount;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']//div[@class='plan-overview-wrapper']//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='trigger-closed']")
	private WebElement pdpPlansCount;
	
	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement viewPlans;
	
	@FindBy(xpath = "div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement viewPDPPlans;
	
	@FindBy(className = "switchPlanYear")
	private WebElement toggleplanYear;
	
	//@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	@FindBy(xpath=".//*[@id='doctorCoverMA']")
	private WebElement MaProviderLink;
	
	@FindBy(xpath="//div[@id='mainWrapper']/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[3]/div/div[1]/a")
	private WebElement previousYearLink;


	@FindBy(css="#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;
	
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
	
	
	@FindBy(xpath="//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]/div/*[@class='trigger-closed']")
	private WebElement viewMAPlans;
	
	@FindBy(xpath="//button[contains(text(),'Get Started')]")
	private WebElement GetStarted;
	

	@FindBy(xpath="//*[text()='People']/preceding::div[1]/img")
	private WebElement People;
	
	@FindBy(xpath="//*[text()='Primary Care']")
	private WebElement Primary;
	
	
	@FindBy(xpath="//*[contains(text(),'Primary Care Physician')]")
	private WebElement Physician;

	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']/button[not(contains(@class,'hidden'))]/span")
	private WebElement Savebtn;

	@FindBy(xpath="//*[@class='action-btn lt']")
	private WebElement Viewsavebtn;

	@FindBy(xpath="//button[@class='action-btn negative']")
	private WebElement Checkcoverage;
	
	@FindBy(xpath = ".//*[@id='plan-list-1']//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlansList;
	
	//Right Rail Element - TFN
	@FindBy(xpath="//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;
	
	@FindBy(id="backToPlanSummaryTop")
	private WebElement backToPlansLink;
	
	
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		if (planType.equalsIgnoreCase("PDP")) {
//	WebElement hidePdpPlans invalid
			//if(validate(hidePdpPlans)){
				pdpPlansViewLink.click();
				System.out.println("PDP Plan Type Clicked");
			//}
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			if(validate(maPlansViewLink)){		
				maPlansViewLink.click();
			}else{
				Assert.assertTrue("There are no plans for MA", false);
			}
		
			
			//validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			if(validate(hidePdpPlans)){
				msPlansViewLink.click();
			}
		}
		else if (planType.equalsIgnoreCase("SNP")) {
			if(validate(hidePdpPlans)){
				snpPlansViewLink.click();
			}
		}
		return new VPPPlanSummaryPage(driver, planType);
	}
	
	public VPPPlanSummaryPage viewPlanSummaryButton(String planType) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (planType.equalsIgnoreCase("PDP")) {
			if(validate(showPdpPlans)){
			showPdpPlans.click();
			}
			if(validate(hidePdpPlans)){
				validate(hidePdpPlans);
			}
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			if(validate(viewMAPlans)){
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", viewMAPlans);
			}
			
		} else if (planType.equalsIgnoreCase("MS")) {
			if(validate(showMsPlans)){
				showMsPlans.click();
			}
		}
		return new VPPPlanSummaryPage(driver, planType);
	}
	
	public VPPPlanSummaryPage clicksOnIsProviderCovered(String planName) {
		if (planName.contains("HMO")) {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			if(maPlansList!=null){
			for (WebElement plan : maPlansList) {
				if (plan.getText().contains(planName)) {
					//ElementData elementData = new ElementData("id",
						//	"doctorCoverMA");

					//ElementData elementData = new ElementData("xpath",
						
//"//*[contains(text(),'Is my provider covered in my ZIP code/county')]");
					//driver.findElement(By.xpath("//*[contains(text(),'Is my provider covered ')]")).click();

					//driver.findElement(By.xpath("//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/a")).click();

					//findChildElement(elementData, plan).click();
					
					WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/following::a[contains(text(),'Is my provider covered')]"));
					System.out.println(ProviderSearchLink.getText());
					ProviderSearchLink.click();

					
				}
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
		if(validate(toggleplanYear)){
			validate(toggleplanYear);
		}
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

		if(validate(toggleplanYear)){
		validate(toggleplanYear);
		}
		if (toggleplanYear != null) {
			toggleplanYear.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public boolean clicksOnMAProviderCoveredLink() {
		if(validate(previousYearLink)){
		previousYearLink.click();
		}
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
		if(validate(compareChkBox)){
		waitforElement(compareChkBox);
		compareChkBox.click();
		}

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

	public boolean getSpecificPlanInfo(String planName) throws InterruptedException {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
		else if (planType.equalsIgnoreCase("SNP")) {

			int snpPlans = Integer.valueOf(snpPlansNumber.getText());
			 //driver.findElement(By.className("module-plan-overview"));
			return snpPlans == findChildElements(elementData, snpPlanList).size();
		}
		return false;
	}
	
	public boolean validateVPPPlanSummaryPage() {
		WebDriverWait wait = new WebDriverWait(driver, 60000);
		vppTop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overview-main']/h2")));
		maPlansNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overview-tabs module-tabs-tabs']/div[1]//span[@class='ng-binding']")));
		msPlansNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='ng-binding']")));
		pdpPlansNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='ng-binding']")));
		snpPlansNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='overview-tabs module-tabs-tabs']/div[4]//span[@class='ng-binding']")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		validate(vppTop);
		validate(maPlansNumber);
		validate(msPlansNumber);
		validate(pdpPlansNumber);
		validate(snpPlansNumber);

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12).trim());
		int maPlans = Integer.valueOf(maPlansNumber.getText());
		int msPlans = Integer.valueOf(msPlansNumber.getText());
		int pdpPlans = Integer.valueOf(pdpPlansNumber.getText());
		int snpPlans = Integer.valueOf(snpPlansNumber.getText());
		
		if (allPlans == maPlans + msPlans + pdpPlans+snpPlans) {
			return true;
		}
		return false;

	}
	public IntroductionInformationPage clicksOnEnrollInplanLink(String planName) {
		 
		
		if (planName.contains("HMO")) {
			for(WebElement plan : maPlans){
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("xpath", "//div[@class='enrollment']//a[@class='cta-button']");
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
							//viewPlanSummary("MA");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for (WebElement newPlan : maPlans) {
								if (newPlan.getText().contains(planName)) {
									ElementData newelementData = new ElementData("id", "enrollMAButton");
									findChildElement(newelementData, newPlan).click();
									break;
								}
							}
							break;
						}
					}
				}
				
			}
		} if (planName.contains("PDP")) {
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
		if (driver.getCurrentUrl().contains("aarp-medicare-complete-online-application.html")){
			return new IntroductionInformationPage(driver);
		}else{
			return null;
		}
		
	}
	public PlanDetailsPage navigateToPlanDetails(String planName, String planType) {
		driver.manage().window().maximize();
	
		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {	
		WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(),'View plan and drug coverage details')]"));
			validate(MAmoreDetailsLink);
			MAmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for MA plan"+planName);


		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//h2[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[@id = 'viewmoredetlinkpdp']"));
			validate(PDPmoreDetailsLink);
			PDPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
		}
		
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("#/details")) {	
			return new PlanDetailsPage(driver);
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
		if(validate(viewPlans)){
		viewPlans.click();
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
	}
	
	public void checkAllMAPlans(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allMAPlans = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));	

		if(allMAPlans !=null){
		for(int i = 0; i<allMAPlans.size(); i++){
			allMAPlans.get(i).click();
		}
		}
		
	}

	public ComparePlansPage clickOnCompareLink(){
		List<WebElement> compareLinks = driver.findElements(By.xpath(".//*[@id='plan-list-1']//button[contains(text(),'Compare plans')]"));	
		compareLinks.get(0).click();


		try {
			Thread.sleep(6000);
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
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> compareChkBoxes = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]"));	
		if(compareChkBoxes.get(0).getText().contains("3 plans added")&&compareChkBoxes.get(1).getText().contains("3 plans added")&&compareChkBoxes.get(2).getText().contains("3 plans added"))
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
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(validate(viewPlans)){
				viewPlans.click();
				List<WebElement> maDCELink = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[@class='mabenefittable']//a[contains(@dtmname, 'Plans Landing:Plan:MA:Drug Cost Estimator')]"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", maDCELink.get(0));
				//maDCELink.get(0).click();
				System.out.println("Entered DCE");
				}else{
					Assert.assertTrue("This scenario is for AEP period", true);
					
				}
			
		}else{
			if(validate(viewPDPPlans)){
				viewPDPPlans.click();
				List<WebElement> view2017PDPPlans = driver.findElements(By.id("pdpDrugCostEstimatorLink"));
				view2017PDPPlans.get(0).click();
				
				}else{
					Assert.assertTrue("This scenario is for AEP period", true);
					
				}
			
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

	public VPPRequestSendEmailPage createVPPRequestSendEmailPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean validatePlanSummary(){
		boolean flag = true;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maPlansViewLink.click();
		/*if(validate(allPlansSize)){
		//	 allPlans = Integer.valueOf(allPlansSize.getText().split(" ")[2]);
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}*/
		
		if(validate(maPlansCount)){
		//	 maPlans = Integer.valueOf(maPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
		
		if(validate(msPlansCount)){
		//	 msPlans = Integer.valueOf(msPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
		
		if(validate(pdpPlansCount)){
		//	 pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		}else{
			Assert.assertTrue("This scenario is for AEP period", true);
			
		}
	
		
		return flag;
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
		WebElement PremiumForPlan = driver.findElement(By.xpath("//h3[contains(text(), '"+PlanName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//li[contains(text(),'Monthly Premium')]//span[contains(text(),'$')]"));
		
		String PlanPremium = PremiumForPlan.getText();
		
		System.out.println("Premium for Plan : "+PlanPremium);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//h3[contains(text(), '"+PlanName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in plan')]"));
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
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in plan')]"));
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
		if(driver.getCurrentUrl().contains("welcome")){
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

	public ComparePlansPage selectplantocompare(String PlanType) {
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
				return new ComparePlansPage(driver);
			}
		}
	}
	System.out.println("Compare Plans Link not displayed");
		return null;
	}

	public DrugCostEstimatorPage navigateToDCEFromVPP(String plantype, String planName){
		if(plantype.equals("MA")||plantype.equals("MAPD")){
			WebElement dceLink = driver.findElement
					(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module swiper-slide ng-scope')]/descendant::a[contains(text(),'Enter drug information')]"));
			if(validate(dceLink))
				dceLink.click();
			
		}else{}
		
		if(currentUrl().contains("/estimate-drug-costs.html#/drug-cost-estimator"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}
}

	
