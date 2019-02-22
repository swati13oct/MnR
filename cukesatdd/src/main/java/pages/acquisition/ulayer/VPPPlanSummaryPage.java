/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;
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
		if (planName.contains("HMO")) {
			isSpecificPlanInfoPresent = getSpecificPlanSummary(maPlanList, planName);

		}/* else if (planName.contains("PDP")) {
			//ElementData elementData = new ElementData("id", "viewDetailsPDP");
			 element = getSpecificPlanSummary(findChildElements(elementData, pdpPlanList), planName);
		} 
		else if (planName.contains("Regional PPO")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			 element = getSpecificPlanSummary(findChildElements(elementData, maPlanList), planName);
		} else if (planName.contains("PPO SNP")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			 element = getSpecificPlanSummary(findChildElements(elementData, snpPlanList), planName);
		}*/
		
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


}

	
