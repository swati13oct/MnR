/**
 * 
 */
package pages.acquisition.ole;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class WelcomePage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']//img")
	private WebElement SiteLogo;
	
	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;
	
	//@FindBy(xpath = "//*[@class = 'cancel-button modal-link']")
	@FindBy(id = "cancel-enrollment")
	private WebElement CancelEnrollmentLink;
	
	// WebElements for Welcome Page
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class, 'only-intro')]")
	private WebElement WelcomePageHeader;

	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;
	
	@FindBy(id = "leavingSite-linkrouter")
	private WebElement LeavingOLEmodal;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[contains(text(), 'Zip:')]/..")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[contains(text(), 'Premium:')]/..")
	private WebElement PremiumDisplay;
	
	@FindBy(xpath = "//*[@id = 'learn-more' or @id = 'learnmorebtn']")
	private WebElement LearnMoreButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Medicare Insurance Information')]")
	private WebElement welcomepageHeader;
	
/*	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']")
	private WebElement DisclaimerAgreeCheckBx;
	*/
	//@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']/following-sibling::label")
	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']")
	private WebElement DisclaimerAgreeSelect;
	
	//Right Rail Elements
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[text()='Coverage Details']")
	private WebElement CoverageDetailswdt;
	
	@FindBy(xpath = "//li[contains(text(), normalize-space('Dental'))]//img")
	private WebElement DentalImg;
	
	@FindBy(xpath = "//li[contains(text(), normalize-space('Vision'))]//img")
	private WebElement VisionImg;
	
	@FindBy(xpath = "//li[contains(text(), normalize-space('Fitness'))]//img")
	private WebElement FitnessImg;
	
	@FindBy(xpath = "//li[contains(text(), normalize-space('Hearing'))]//img")
	private WebElement HearingImg;
		
	public WelcomePage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public WelcomePage(WebDriver driver, String OLE_URL) {
		super(driver);
		PageFactory.initElements(driver, this);
		start(OLE_URL);
		
		openAndValidate();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		
		System.out.println("Validating Welcome Page for OLE");
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver,45);
		else 
			checkModelPopup(driver,10);
		validateNew(WelcomePageHeader);
		validateNew(PlanYear_PlanName);
	}

	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		//String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		//String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		boolean flag = false;
		
		if(PlanYear_PlanName_Text.contains(Expected_PlanName)){
			flag = true;
			System.out.println("Plan Name is Validated : "+flag);
		}else flag =false;
		//Plan Year commented for AEP validation
/*		if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Year is Validated : "+flag);
		}else flag =false;*/
		if(Zip_County_Text.contains(Expected_County)){
			flag = (flag==false)?false:true;
			System.out.println("Plan County is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_ZipCode)){
			flag = (flag==false)?false:true;
			System.out.println("Plan ZIP CODE is Validated : "+flag);
		}else flag =false;
/*		if(Premium.contains(Expected_PlanPremium)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Premium is Validated : "+flag);
		}else flag =false;*/
		System.out.println("Plan Details are Validated : "+flag);
		return flag;
	}


	public boolean ValidateTFN(String TFN) {
		
		if(validate(RightRailTFN)){
			String TFN_OLE = RightRailTFN.getText();
			if(TFN_OLE.contains(TFN)){
				System.out.println("TFN is validated in OLE Welcome Page"+TFN);
				return true;
			}
			else{
				System.out.println("TFN does not match");
				System.out.println("TFN in VPP page : "+TFN);
				System.out.println("TFN in OLE Right Rail : "+TFN_OLE);
				return false;
			}
		}
		System.out.println("TFN not displayed in OLE right rail");
		return false;
	}

	public PersonalInformationPage navigate_to_Personal_Information_page() {
		
		validateNew(NextBtn);
		NextBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Personal')]")))){			
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPage(driver);
		}
		return null;
	}

	public MedicareInformationPage navigate_to_medicare_info_page_PDP() {
		
		validateNew(NextBtn);
		NextBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(welcomepageHeader)){ 
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		return null;
	}

	public LearnMoreModal OpenLearnMore() {
		checkModelPopup(driver);
		validate(LearnMoreButton);
		LearnMoreButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(LearnMore_Modal)){
			System.out.println("OLE Learn More Modal is Displayed");
			return new LearnMoreModal(driver);
		}
		return null;
	}

	public CancelOLEModal OpenCancelOLE() {
		validate(CancelEnrollmentLink);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelEnrollmentLink);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click;", CancelEnrollmentLink);
		
		//CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(validate(CancellationModal)){
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			return new CancelOLEModal(driver);
		}
		return null;
	}

	public LeavingOLEmodal OpenLeaveOLEmodal() {
		validate(SiteLogo);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SiteLogo);
		//SiteLogo.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(validate(LeavingOLEmodal)){
			System.out.println("Leaving OLE modal is Displayed");
			return new LeavingOLEmodal(driver);
		}
		return null;
	}
	
	public void validateBenefits(boolean riderFlag, WebElement riderBenefit) throws Exception {

		if (riderFlag) {
			for (int i = 0; i <= 5; i++) {
				try {
					waitforElement(riderBenefit);
					validate(riderBenefit);
					Assert.assertTrue("Rider Benefit is not available for this plan",
							riderBenefit.getAttribute("class").contains("benefitAvailable"));
					System.out.println("Benfit is Available");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("TestWarning: Unable to find element : Retry Count - " + i);
			}

		} else {
			for (int i = 0; i <= 5; i++) {
				try {
					waitforElement(riderBenefit);
					validate(riderBenefit);
					Assert.assertTrue("Rider Benefit is available for this plan",
							riderBenefit.getAttribute("class").contains("benefitUnavailable"));
					System.out.println("Benfit is UnAvailable");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("TestWarning: Unable to find element : Retry Count - " + i);
			}
		}
	}

	
	public void validate_Ancillary_Benefits(String DentalFlag, String VisionFlag,String FitnessFlag,String HearingFlag) throws Exception {
		boolean di = Boolean.parseBoolean(DentalFlag);
		boolean vi = Boolean.parseBoolean(VisionFlag);
		boolean fi = Boolean.parseBoolean(FitnessFlag);
		boolean hi = Boolean.parseBoolean(HearingFlag);
		
		waitforElement(CoverageDetailswdt);
		validate(CoverageDetailswdt);
		validateBenefits(di, DentalImg);		
		validateBenefits(vi, VisionImg);
		validateBenefits(fi, FitnessImg);
		validateBenefits(hi, HearingImg);	
	}
	
	public boolean validateNextButtonIsClickable() {
		
		boolean enrollInNotPossible = false;
		try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	        wait.until(ExpectedConditions.elementToBeClickable(NextBtn));
	        enrollInNotPossible = true;
	        return enrollInNotPossible;
	    }
	    catch (Exception e)
	    {
	        return enrollInNotPossible;
	    }		
	}
	
public ArrayList<String> validate_marketing_details(String planName) {
		
        ArrayList<String> marketingBulletDetails = new ArrayList<String>();
		List<WebElement> marketingBullets = driver.findElements(By.xpath("//*[@id='ole-form-content']//*[@class='bullet-div']//*[@id='bullets-sub-header']//following-sibling::div//ul[@class='marketing-bullets']//li"));
		
		for(WebElement element:marketingBullets)
		{
			String marketingDetails = element.getText();
			marketingBulletDetails.add(marketingDetails);
		}
			
		return marketingBulletDetails;
	
	}
	
public MedicareInformationPage navigate_to_medicare_info_page() {
		
		validateNew(NextBtn);
		NextBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Medicare')]")))){			
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		return null;
	}
}