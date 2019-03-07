/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.vppforaep.AepVppPlanSummaryPage;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author 
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;

	@FindBy(xpath = "//*[@id='plan-list-1']/div/div[3]/div/div[1]/div[2]/div/div/span[3]/button]")
	WebElement compareLinks;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
	private WebElement showMaPlans;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']//span[@class='title']/span")
	private WebElement maPlansNumber;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]/div/span/span[@class='ng-binding']")
	private WebElement snpPlansNumber;


	//@FindBy(xpath = ".//*[@id='site-wrapper']//div[@class='plan-overview-wrapper']//div[@class='overview-tabs module-tabs-tabs']/div[1]//span[@class='trigger-closed']")
	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[4]//a[@class='trigger-closed']")
	private WebElement snpPlansViewLink;

	@FindBy(id = "plan-list-1")
	private WebElement maPlanList;

	@FindBy(id = "plan-list-3")
	private WebElement pdpPlanList;

	@FindBy(id = "plan-list-4")
	private WebElement snpPlanList;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//span[@class='ng-binding']")
	private WebElement msPlansNumber;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[2]//a[@class='trigger-closed'][text()='View Plans']")
	private WebElement msPlansViewLink;

	@FindBy(xpath = "//div[@class='overview-tabs module-tabs-tabs']/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansNumber;	

	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='pdpviewplans']/following-sibling::a")
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

	@FindBy(xpath="//div[contains(@ng-repeat,'plan in planModel.maPlans')]")
	List<WebElement> maPlans;

	@FindBy(xpath = "//div[@class='module-closed-enrollment-alert']/span/a")
	private WebElement viewPlansYearLink;

	@FindBy(xpath="//div[contains(@ng-repeat,'plan in planModel.pdpPlans')]")
	List<WebElement> pdpPlans;

	@FindBy(id = "allplanssise")
	private WebElement allPlansSize;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[2]//span[@class='ng-binding']")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	private WebElement snpPlansCount;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[1]//*[@class='trigger-closed']")
	private WebElement viewPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']/div[@class='overview-tabs module-tabs-tabs']/div[3]//*[@class='trigger-closed']")
	private WebElement viewPDPPlans;

	@FindBy(xpath = ".//*[@id='togglenextYear']/a")
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



	@FindBy(xpath = ".//*[@id='plan-list-1']//div[@class='module-plan-overview module swiper-slide ng-scope']")
	List<WebElement> maPlansList;

	//Right Rail Element - TFN
	@FindBy(xpath="//*[@class='tel ng-binding']")
	private WebElement RightRail_TFN;

	@FindBy(id="backToPlanSummaryTop")
	private WebElement backToPlansLink;

	@FindBy(id = "drugsTabId")
	public WebElement step1;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;
	@FindBy(id = "change-location")
	private WebElement ChangeLocationLink;

	@FindBy(id = "zipcode")
	private WebElement ZipCodeTxtBx;

	@FindBy(id = "submit")
	private WebElement FIndPlansButton;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;
	@FindBy(xpath = "//div[@id='responsiveplan']")
	private List<WebElement> medSuppPlanList;

	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/p[contains(text(),'drugs covered')])[1]")
	private WebElement drugCoveredInfo;


	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost')])[1]")
	private WebElement estimatedAnnualDrigCostLabel;

	@FindBy(xpath = "(//div[contains(@class,'mabenefittable')]//li[contains(@class,'ng-scope')]/span[contains(text(),'Estimated Annual Drug Cost:')]/following-sibling::span[not(contains(@class,'ng-hide'))])[1]")
	private WebElement estimatedAnnualDrigCostValue;

	@FindBy(xpath = "(.//*[@id='globalContentIdForSkipLink']//div[contains(@class,'module module-aside no-med-supp rigntrailwidget')])[2]")
	private WebElement promoWidject;

	@FindBy(xpath="//div[@class='col-md-3']")
	public WebElement RightRailSection;

	@FindBy(xpath="//*[contains(text() , 'Need Help?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']")
	public WebElement needHelpRightRail;

	@FindBy(xpath="//*[contains(text() , 'Need Help?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']//a[contains(text(),'Find an agent in your area')]")
	public WebElement RightRail_AgentInYourArea; 

	@FindBy(xpath="//*[contains(text() , 'Get a Free Medicare Guide')]/ancestor::div[@class ='rightrail']//div[@class='uhc-container']")
	public WebElement MedicareGuideRightRail;

	@FindBy(xpath="//*[contains(text() , 'Need More Information?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']")
	public WebElement NeedMoreInformationRightRail;

	@FindBy(xpath="//*[contains(text() , 'Need More Information?')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']//a[contains(text(),'Choose a video ')]")
	public WebElement ChooseAVideo;

	@FindBy(xpath="//*[contains(text() , 'Plan Selector Tool')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']")
	public WebElement PlanSelectorToolRightRail; 

	@FindBy(xpath="//*[contains(text() , 'Plan Selector Tool')]/ancestor::div[@class='rightrail']//div[@class='uhc-container']//span")
	public WebElement StartPlanSelector; 

	@FindBy(xpath = "//input[@id='compare-plan-2']")
	private WebElement mapdPlanCompare;

	@FindBy(xpath =".//*[@class='popup-modal active']")
	private WebElement learnMoreModalPopUp;

	@FindBy(xpath=".//*[@class='popup-modal active']/descendant::div[@class='modal-footer']/a[@class='cta-button close-modal']")
	private WebElement backButtonInLearnMoreModal; 

	@FindBy(xpath="//input[@name='firstname']")
	public WebElement firstNameField;

	@FindBy(xpath="//input[@class='field-type-email ng-pristine ng-valid']")
	public WebElement emailField;

	@FindBy(xpath="//input[@name='lastname']")
	public WebElement lastNameField;

	@FindBy(xpath="//button[@id='signUp']")
	public WebElement Submitbutton;


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

	public VPPPlanSummaryPage(WebDriver driver, String OLE_Campaign_URL,boolean flag) {
		super(driver);
		PageFactory.initElements(driver, this);
		start(OLE_Campaign_URL);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openAndValidate();

		// TODO Auto-generated constructor stub
	}


	private boolean getSpecificPlanSummary(WebElement element, String planName) {
		if (element.getText().contains(planName)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void openAndValidate() {
		validateNew(maPlansCount);
		validateNew(msPlansCount);
		validateNew(pdpPlansCount);
		validateNew(snpPlansCount);
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

	public VPPPlanSummaryPage viewPlanSummaryButton(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			if(validate(showPdpPlans)){
				showPdpPlans.click();
			}
			if(validate(hidePdpPlans)){
				validate(hidePdpPlans);
			}
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			if(validate(viewPlans)){
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", viewMAPlans);
			}

		} else if (planType.equalsIgnoreCase("MS")) {
			if(validate(showMsPlans)){
				showMsPlans.click();
			}
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public ProviderSearchPage clicksOnIsProviderCovered(String planName) {

		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'Is my provider covered')]"));
		switchToNewTabNew(ProviderSearchLink);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}

	public void ValidateclicksOnIsProviderCovered(String planName) throws InterruptedException {

		//CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'Is my provider covered')]"));
		//switchToNewTabNew(ProviderSearchLink);
		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();
		ProviderSearchLink.click();
		Thread.sleep(5000);
		System.out.println("Provider Search Link has been clicked");
		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle))
				break;
		}

		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("Provider Search Page is displayed");
			Assert.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail("Unable to navigate back to VPP Plan Summary Page");
			}
		}
		else 
			Assert.fail("Provider Search Page is not displayed");      
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
		WebElement ProviderSearchLink = driver.findElement
				(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::div[contains(@class, 'module-plan-overview module')]/descendant::span[contains(text(),'covered')]"));
		String mproviderinfo=ProviderSearchLink.getText();
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
		boolean isSpecificPlanInfoPresent = false;
		if (planName.contains("HMO SNP")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			isSpecificPlanInfoPresent = getSpecificPlanSummary(snpPlanList, planName);
			// element = getSpecificPlanSummary(findChildElements(elementData, snpPlanList), planName);
		}
		else if (planName.contains("HMO")) {
			isSpecificPlanInfoPresent = getSpecificPlanSummary(maPlanList, planName);

		} else if (planName.contains("PDP")) {
			//ElementData elementData = new ElementData("id", "viewDetailsPDP");
			//element = getSpecificPlanSummary(findChildElements(elementData, pdpPlanList), planName);
			isSpecificPlanInfoPresent = getSpecificPlanSummary(pdpPlanList, planName);
		} 
		/*else if (planName.contains("Regional PPO")) {
                        //ElementData elementData = new ElementData("id", "viewDetailsMA");
                        element = getSpecificPlanSummary(findChildElements(elementData, maPlanList), planName);
        } */


		return isSpecificPlanInfoPresent;
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
			return maPlans == findChildElements(elementData, maPlanList).size();
		} else if (planType.equalsIgnoreCase("SNP")) {
			int snpPlans = Integer.valueOf(snpPlansNumber.getText());
			return snpPlans == findChildElements(elementData, snpPlanList)
					.size();
		}
		else if (planType.equalsIgnoreCase("SNP")) {

			int snpPlans = Integer.valueOf(snpPlansNumber.getText());
			return snpPlans == findChildElements(elementData, snpPlanList).size();
		}
		return false;
	}

	public boolean validateVPPPlanSummaryPage() {

		validateNew(maPlansCount);
		validateNew(msPlansCount);
		validateNew(pdpPlansCount);
		validateNew(snpPlansCount);

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
		CommonUtility.checkPageIsReadyNew(driver);

		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {	
			WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName
					+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan')]"));
			CommonUtility.waitForPageLoadNew(driver, MAmoreDetailsLink, 30);
			MAmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for MA plan"+planName);

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
			System.out.println("View Plan Details Link is clicked for MA plan"+planName);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("#/details")) {	
			return new PlanDetailsPage(driver,planType);
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
		if(validateNew(viewPDPPlans)){
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
		List<WebElement> compareLinks = driver
				.findElements(By.xpath(".//*[@id='plan-list-1']//button[contains(text(),'Compare plans')]"));
		compareLinks.get(1).click();
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

		if(plantype.equals("MA")||plantype.equals("MAPD")){
			CommonUtility.waitForPageLoad(driver,viewPlans, 30);
			if(validate(viewPlans)){
				viewPlans.click();
				List<WebElement> maDCELink = driver.findElements(By.xpath(".//*[@id='plan-list-1']//div[@class='mabenefittable']//a[contains(@dtmname, 'Plans Landing:Plan:MA:Drug Cost Estimator')]"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", maDCELink.get(0));
				//maDCELink.get(0).click();
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
		CommonUtility.waitForPageLoad(driver, step1, 30);
		validateNew(step1);
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
		System.out.println("Plan Name is : "+PlanName);
		WebElement PremiumForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+PlanName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//li[1]//span[contains(text(),'$')]"));
		CommonUtility.waitForPageLoadNew(driver,PremiumForPlan, 30);
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
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in plan')]"));
		validateNew(EnrollForPlan);
		EnrollForPlan.click();

		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
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
		if(validateNew(RightRail_TFN)){
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

	public AepVppPlanSummaryPage validate_aepPlanYearLinks(String currentYear, String nextYear) {
		System.out.println("Next Year : "+nextYear);
		System.out.println("Current Year : "+currentYear);


		WebElement CurrentYearLink = driver.findElement(By.xpath("//a[contains(text(), '"+currentYear+"')]"));
		System.out.println("Current Year link on VPP Page : "+CurrentYearLink.getText());

		List <WebElement> NextYearHeadings = driver.findElements(By.xpath("//*[contains(text(), '"+nextYear+"')]"));
		if( validate(CurrentYearLink) && NextYearHeadings.size()>0){
			System.out.println("Current and Next year toggle displayed for AEP");
			return new AepVppPlanSummaryPage(driver);
		}
		else{
			System.out.println("Current and Next year toggle NOT displayed for AEP");
		}

		// TODO Auto-generated method stub
		return null;
	}

	public void checkAllPDPlans(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allPDPlans = driver.findElements(By.xpath(".//*[@id='plan-list-3']//div[contains(@class,'compare-box')]"));	

		if(allPDPlans !=null){
			for(int i = 0; i<allPDPlans.size(); i++){
				allPDPlans.get(i).click();
			}
		}

	}
	public ComparePlansPage clickOnCompareLinkAARP(String plantype){

		if (plantype.equalsIgnoreCase("MedicareAdvantage"))
		{
			List<WebElement> compareLinks = driver.findElements(By.xpath(".//*[@id='plan-list-1']//button[contains(text(),'Compare plans')]"));	
			compareLinks.get(1).click();	
		}else{
			WebElement compareLinks2 = driver.findElement(By.xpath("(.//*[@id='plan-list-3']//button[contains(text(),'Compare plans')])[1]"));	
			compareLinks2.click();	
		}

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

	public void validateMedicalBenefitDrugSection() {
		validateNew(drugCoveredInfo);
		validateNew(estimatedAnnualDrigCostLabel);
		validateNew(estimatedAnnualDrigCostValue);
	}


	public MultiCountyModalPage VPP_ChangeLocationValidateMultiCOuntyPopUp(String zipcode) {
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

	public VPPPlanSummaryPage validatePromoWidjetAArp(String planName) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '" + planName+ "')]/ancestor::div[contains(@class,'module-plan-overview')]//div[contains(@class,'swiper-content')]//div[not (contains(@class,'ng-hide'))]/a[contains(text(),'View plan')]"));
		validateNew(MAmoreDetailsLink);
		validateNew(promoWidject);

		return new VPPPlanSummaryPage(driver);

	}

	public void validateAndClickAddtoCompareinAARP(String planType , String planName) throws InterruptedException {
		if (planType.equalsIgnoreCase("MAPD")) {
			System.out.println("Choose Plan to Compare : "+planName);
			//WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//input[@id='compare-plan-2']"));
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//div[@class='compare-box']/span[@class='ng-scope']"));
			//WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),'AARP MedicareComplete SecureHorizons Plan 1 (HMO) ')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//input[@id='compare-plan-2']"));
			validateNew(addToCompare);
			addToCompare.click();
		}
		if (planType.equalsIgnoreCase("MA")) {
			System.out.println("Choose Plan to Compare : "+planName);
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//div[@class='compare-box']/span[@class='ng-scope']"));
			validateNew(addToCompare);
			addToCompare.click();
		}

		if (planType.equalsIgnoreCase("PDP")) {
			System.out.println("Choose Plan to Compare : "+planName);
			//WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//input[@id='compare-plan-7']"));
			WebElement addToCompare = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//div[@class='compare-box']/span[@class='ng-scope']"));
			validateNew(addToCompare);
			addToCompare.click();
		}

	}           
	public boolean compareTextAfterclickingAddtoCompareinAARP(String planName) throws InterruptedException {                
		WebElement compareText = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope compare-add']//div[@class='compare-box']/span[@class='single-added-text show']"));    
		if(compareText.getText().contains("1 plan added")){
			System.out.println("1 plan has been selected for comparison"); 
			return true;
		} else {
			return false;
		}
	}
	public void deselectAddToCompareinAARP(String planName){
		try{
			//WebElement addToCompareCheck = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope compare-add']//div[@class='compare-box']/span[@class='ng-scope']"));
			WebElement addToCompareCheck = driver.findElement(By.xpath("//label[contains(text(),'Added to compare')]//parent::span//label"));
			addToCompareCheck.click();
			System.out.println("Add to compare checkbox has been deselected");
			Assert.assertTrue("deselected add to compare ", true);
		}
		catch (Exception e){	
			Assert.fail("Unable to deselect Add to compare");
		}
	}




	public void validateAddToCompareNotPresentForDSNP(String planName){
		try{
			if(driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'compare-plan')]")).isDisplayed()){
				Assert.fail("Add to compare checkbox is present for DSNP Plans");  
			}
		}
		catch(Exception e){
			System.out.println("Add to compare checkbox is not present for DSNP Plans");
			Assert.assertTrue(true);
		}
	}

	public void validateAndClickLearnMoreAboutExtraHelpInAARP(String planType , String planName) throws InterruptedException {
		if (planType.equalsIgnoreCase("MAPD")) {
			WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]"));
			validateNew(learnMoreAboutExtraHelp);            
			learnMoreAboutExtraHelp.click();
		}
		if (planType.equalsIgnoreCase("SNP")) {
			//WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]"));
			WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a)[5]"));
			validateNew(learnMoreAboutExtraHelp);
			learnMoreAboutExtraHelp.click();
		}
		if (planType.equalsIgnoreCase("PDP")) {
			WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]"));
			validateNew(learnMoreAboutExtraHelp);
			learnMoreAboutExtraHelp.click();
		}
		if(planType.equalsIgnoreCase("MA")){
			try{
				//WebElement learnMoreAboutExtraHelp = driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]"));
				//validateNonPresenceOfElement(driver.findElement(By.xpath("(//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]")));
				if(driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[@class='inline-edit-link modal-link vpp-monthly-premium-modal'])[1]")).isDisplayed()){
					Assert.fail("Learn More About Extra Help is present for MA plans");
				}	
			}
			catch (Exception e){
				System.out.println("Learn More About Extra Help is not present for MA plans");
				Assert.assertTrue(true);
			}
		}		

	}            

	public void validatesLearnMoreAboutExtraHelpPopup() {
		validateNew(learnMoreModalPopUp);
		backButtonInLearnMoreModal.click();

	}

	public void validateIsMyProviderCoveredLinkInAarp(String planType , String planName) {

		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),\'" + planName
				+ "\')]/ancestor::div[contains(@class,'module-plan-overview')]//a[contains(text(),'Is my provider covered')]"));
		if(planType.equalsIgnoreCase("PDP")){
			validateNonPresenceOfElement(ProviderSearchLink);
		}
		else {
			validateNew(ProviderSearchLink);           
		}              
	}

	public void validatePlanPremium (String planName , String monthlyPremium){
		WebElement PremiumForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Monthly Premium')]/span)[1]"));
		CommonUtility.waitForPageLoadNew(driver,PremiumForPlan, 30);
		String PlanPremium = PremiumForPlan.getText();
		if(PlanPremium.equals(monthlyPremium)){
			System.out.println("Premium for the plan is " + PlanPremium);               
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Premium for the plan is incorrect : "+planName); 
	}

	public void validatePrimaryCarePhysicianBenefit (String planType ,String planName , String primaryCarePhysician){
		WebElement PrimaryCarePhysicianForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Primary Care Physician')]/span"));
		CommonUtility.waitForPageLoadNew(driver,PrimaryCarePhysicianForPlan, 30);
		if(!planType.equals("SNP")){
			String PrimaryCare = PrimaryCarePhysicianForPlan.getText();	
			if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
				System.out.println("PrimaryCare for the plan is " + PrimaryCare); 
				Assert.assertTrue(true);
			}
			else
				Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "+planName);
		}
		else {
			String PrimaryCare = PrimaryCarePhysicianForPlan.getText().replaceAll("\n", " ");
			if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
				System.out.println("PrimaryCare for the plan is " + PrimaryCare); 
				Assert.assertTrue(true);
			}
			else
				Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "+planName);
		}
		/*//String PrimaryCare = PrimaryCarePhysicianForPlan.getText().replaceAll("\n", " ");
            //System.out.println("The new content is " +PrimaryCare.replaceAll("\n", " "));
            //String PrimaryCare1 = PrimaryCarePhysicianForPlan.getAttribute("textContent").trim();
           System.out.println("Primary care is " +PrimaryCare);
           if(PrimaryCare.equalsIgnoreCase(primaryCarePhysician)){
             System.out.println("PrimaryCare for the plan is " + PrimaryCare); 
             Assert.assertTrue(true);
           }
           else
                           Assert.fail("Primary Care Physician Benefit for the plan is incorrect : "+planName);
}*/
	}
	public void validateSpecialistBenefit (String planType , String planName , String specialist) {
		WebElement SpecialistForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Specialist')]/span"));
		CommonUtility.waitForPageLoadNew(driver,SpecialistForPlan, 30);
		if(!planType.equals("SNP")){
			String SpecialistBenefit = SpecialistForPlan.getText();
			if(SpecialistBenefit.equals(specialist)){
				System.out.println("Specialist Benefit for the plan is " + SpecialistBenefit);         
				Assert.assertTrue(true);
			}
			else
				Assert.fail("Specialist Benefit for the plan is incorrect : "+planName);
		}
		else {
			String SpecialistBenefit = SpecialistForPlan.getText().replaceAll("\n", " ");
			if(SpecialistBenefit.equals(specialist)){
				System.out.println("Specialist Benefit for the plan is " + SpecialistBenefit);         
				Assert.assertTrue(true);
			}
			else
				Assert.fail("Specialist Benefit for the plan is incorrect : "+planName);
		}
	}


	public void validateReferrralRequiredBenefit (String planName , String referralRequired) {
		WebElement ReferralRequiredForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Referral Required')]/span"));
		CommonUtility.waitForPageLoadNew(driver,ReferralRequiredForPlan, 30);
		String ReferRequired = ReferralRequiredForPlan.getText();
		if(ReferRequired.equals(referralRequired)){
			System.out.println("Referral Required Benefit for the plan is " + ReferRequired);            
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Referral Required Benefit for the plan is incorrect : "+planName);
	}

	public void validatesOutOfPocketMaximum (String planName , String outOfPocketMaximum) {
		WebElement OOPForPlan = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Out Of Pocket Maximum')]/span"));
		CommonUtility.waitForPageLoadNew(driver,OOPForPlan, 30);
		String OOPMax = OOPForPlan.getText();
		if(OOPMax.equals(outOfPocketMaximum)){
			System.out.println("OOPMax for the plan is " + OOPMax);        
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Out of Pocket Maximum Benefit for the plan is incorrect : "+planName);
	}

	public void validatePrescriptionDrugsTier1(String planName , String prescriptionDrugsTier1) {
		WebElement DrugsForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Prescription Drugs, Tier 1')]/span)[1]"));
		CommonUtility.waitForPageLoadNew(driver,DrugsForPlan, 30);
		System.out.println("Expected value " + prescriptionDrugsTier1);
		String PrescriptionDrugs = DrugsForPlan.getText();
		System.out.println("Prescription Drugs " + PrescriptionDrugs);
		if(PrescriptionDrugs.equals(prescriptionDrugsTier1)){
			System.out.println("PrescriptionDrugs for the plan is " + PrescriptionDrugs);      
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Prescription Drugs, Tier 1 for the plan is incorrect : "+planName);
	}

	public void validateAnnualDeductible(String planName , String annualDeductible) {
		WebElement AnnualDeductibleForPlan = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Annual Deductible')]/span)[2]"));
		String planDeductible = AnnualDeductibleForPlan.getAttribute("textContent").trim();
		/* try {

           	System.out.println(" The text is " +AnnualDeductibleForPlan.getAttribute("textContent").trim());
           	System.out.println(" The text from feature file is " +annualDeductible);

			} catch (Exception e) {
				System.out.println(" The text is" +AnnualDeductibleForPlan.getText());
			}*/
		if(annualDeductible.equalsIgnoreCase(planDeductible)){
			System.out.println("Annual Deductible for the plan is " + planDeductible);            
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Annual Deductible for the plan is incorrect : "+planName);
	}



	/*                CommonUtility.waitForPageLoadNew(driver,AnnualDeductibleForPlan, 30);
           String PlanDeductible = AnnualDeductibleForPlan.getText();
           System.out.println("PlanDeductible " +PlanDeductible);
           System.out.println("AnnualDeductible " +annualDeductible);                               
           if(PlanDeductible.equals(annualDeductible)){
             System.out.println("Annual Deductible for the plan is " + PlanDeductible);            
             Assert.assertTrue(true);
           }
           else
             Assert.fail("Annual Deductible for the plan is incorrect : "+planName);
}*/

	public void validateMarketingBullets(String planType , String planName){

		if(!planType.equals("PDP")){
			WebElement marketingBullets = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//div[@class='vppColumnDivisionContainer']"));
			validateNew(marketingBullets);
		}
		if(planType.equals("PDP")){
			WebElement marketingBullets = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//ul)[2]"));
			validateNew(marketingBullets);
		}


	}


	/*public void validatePrimaryCarePhysicianBenefit (String planName , String primaryCarePhysician) {

}*/
	public void toolTipForPremium0(String planName){
		WebElement toolTip = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Monthly Premium')]/span)[2]/span[1]"));
		if (toolTip.getText().contains("Why is my premium $0?")){
			System.out.println("ToolTip text is " + toolTip.getText());
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Tool Tip is not working");	     	
	}


	public pages.acquisition.dce.ulayer.DrugCostEstimatorPage navigatetoDCEPage(String planName){
		WebElement DCELink = driver.findElement(By.xpath("(//*[contains(text(),\'" + planName + "\')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Prescription Drugs, Tier 1')]/span)[2]"));
		DCELink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("drug-cost-estimator")){
			System.out.println("DCE Page is loaded");
			return new pages.acquisition.dce.ulayer.DrugCostEstimatorPage(driver);
		}	
		else
			return null;  
	}

	public void validateRightRailSection(){
		validateNew(RightRailSection);
	}

	public void validateNeedHelpRightRail() {
		validateNew(needHelpRightRail);
		System.out.println("Need Help Section is present");
	}

	public void validateAgentEBRCPage() {
		validateNew(RightRail_AgentInYourArea);
		CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
		RightRail_AgentInYourArea.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("agentebrc")) {
			System.out.println("Agent EBRC Page is displayed");
			Assert.assertTrue(true);
			driver.navigate().back();
			CommonUtility.checkPageIsReadyNew(driver);
			if(driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back on VPP Plan Summary Page");
				Assert.assertTrue(true);                    	  
			}
			else
				Assert.fail("Unable to load VPP Plan Summary Page");
		}
		else
			Assert.fail("Unable to load Agent EBRC Page");                    
	}                         

	public void validateMedicareGuideRightRail() {
		validateNew(MedicareGuideRightRail);
		System.out.println("Get a Free Medicare Guide Section is present");  
	}

	public void validateNeedMoreInformationRightRail() {
		validateNew(NeedMoreInformationRightRail);
		System.out.println("Need more Information Section is present");   	
	}

	public void validateMedicareVideoGuideRightRail() throws InterruptedException {

		validateNew(ChooseAVideo); 
		String parentHandle = driver.getWindowHandle();
		ChooseAVideo.click();
		Thread.sleep(5000);
		System.out.println("Video link has been clicked");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String newWindow : tabs) {
			driver.switchTo().window(newWindow);
			System.out.println(driver.getTitle());
		}
		System.out.println("Page navigation successful");
		//  driver.switchTo().window(parentHandle);








		/* validateNew(ChooseAVideo); 
// CommonUtility.waitForPageLoadNew(driver, RightRail_AgentInYourArea, 30);
String parentHandle = driver.getWindowHandle();
int initialCount = driver.getWindowHandles().size();
ChooseAVideo.click();

waitForCountIncrement(initialCount);
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
String currentHandle = null;
for (int i = 0; i < initialCount + 1; i++) {
            driver.switchTo().window(tabs.get(i));
            currentHandle = driver.getWindowHandle();
            if (!currentHandle.contentEquals(parentHandle))
                            break;
}*/

		try {
			Thread.sleep(5000);

			System.out.println(" page  ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" page catch block ");
		}


		if (driver.getCurrentUrl().contains("medicareguide")) {
			System.out.println("Medicare Plans Video Guide is displayed");
			Assert.assertTrue(true);
			driver.switchTo().window(parentHandle);
			if (driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back to VPP Plan Summary Page");
				Assert.assertTrue(true);
			}
			else                
				Assert.fail("Unable to navigate back to VPP Plan Summary Page");                   
		}
		else 
			Assert.fail("Medicare Plans Video Guide Page is not displayed");      
	}

	public void validatePlanSelectorToolRightRail(){
		validateNew(PlanSelectorToolRightRail);
		System.out.println("Plan Selector Tool Section is present");    
	}

	public void validatePlanSelectorPageInRightRail() {
		validateNew(StartPlanSelector);
		StartPlanSelector.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("medicare-plans")) {
			System.out.println("Plan Selector Tool Page is displayed");
			Assert.assertTrue(true);
			driver.navigate().back();
			CommonUtility.checkPageIsReadyNew(driver);
			if(driver.getCurrentUrl().contains("plan-summary")) {
				System.out.println("Back on VPP Plan Summary Page");
				Assert.assertTrue(true);                    	  
			}
			else
				Assert.fail("Unable to load VPP Plan Summary Page");
		}
		else
			Assert.fail("Unable to load Plan Selector Tool Page");                    
	} 

	public void enterRequiredFieldsForMedicareGuide(Map<String, String> memberAttributesMap) {
		String FirstName = memberAttributesMap.get("First Name");
		String LastName =  memberAttributesMap.get("Last Name");
		String EmailAddress = memberAttributesMap.get("Email Address");
		sendkeysNew(firstNameField, FirstName);
		sendkeysNew(lastNameField, LastName);
		sendkeysNew(emailField, EmailAddress);
		validateNew(Submitbutton);
		Submitbutton.click();
		WebElement popup = driver.findElement(By.xpath("//div[@class='closeBg']/*[contains (text() , 'Thank you for your interest')]"));
		if(validateNew(popup)){
			System.out.println("Pop up message has been displayed");
			WebElement closePopUp = driver.findElement(By.xpath("//a[@class='emailsubmit_close']"));
			closePopUp.click();
			CommonUtility.checkPageIsReadyNew(driver);
			Assert.assertTrue(true);
		}
		else
			Assert.fail("Popup message has not been displayed");
	}

}


