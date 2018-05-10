/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(xpath = "//*[@class = 'only-intro']")
	private WebElement WelcomePageHeader;
	
	@FindBy(xpath="//a[contains(text(), 'Our Plans')]")
	private WebElement OurPlansLink;

	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(id = "ole-cancel-confirm")
	private WebElement CancellationModal;
	
	@FindBy(id = "sample-linkrouter")
	private WebElement LeavingOLEmodal;
	
	@FindBy(xpath = "//*[contains(text(), 'chosen to enroll in:')]/following-sibling::h2")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[contains(text(), 'ZIP:')]/..")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[contains(text(), 'Premium:')]/..")
	private WebElement PremiumDisplay;
	
	@FindBy(id = "learn-more")
	private WebElement LearnMoreButton;
	
	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
/*	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']")
	private WebElement DisclaimerAgreeCheckBx;
	*/
	//@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']/following-sibling::label")
	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']")
	private WebElement DisclaimerAgreeSelect;
	
	//Right Rail Elements
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
		
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
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(WelcomePageHeader);
		validate(PlanYear_PlanName);
	}

	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		boolean flag = false;
		
		if(PlanYear_PlanName_Text.contains(Expected_PlanName)){
			flag = true;
			System.out.println("Plan Name is Validated : "+flag);
		}else flag =false;
		if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Year is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_County)){
			flag = (flag==false)?false:true;
			System.out.println("Plan County is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_ZipCode)){
			flag = (flag==false)?false:true;
			System.out.println("Plan ZIP CODE is Validated : "+flag);
		}else flag =false;
		if(Premium.contains(Expected_PlanPremium)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Premium is Validated : "+flag);
		}else flag =false;
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

	public boolean validateDisclaimerCheckBox() {
		
		boolean flag = false;
		
		boolean Disclaimer_Flag = (DisclaimerAgreeSelect.isSelected())?true:false;
		boolean NextBtn_Flag = (NextBtn.isEnabled())?true:false;
		if(!Disclaimer_Flag){
			if(!NextBtn_Flag){
				System.out.println("Disclaimer Agree checkbox is not checked and Next button is disabled  : Validation Passed");
				flag = true;
			}
			else
			{
				System.out.println("Disclaimer Agree checkbox is not checked and Next button is ENABLED : Validation failed");
				flag = false;
			}
		}
		DisclaimerAgreeSelect.click();
		
		Disclaimer_Flag = (DisclaimerAgreeSelect.isSelected())?true:false;
		NextBtn_Flag = (NextBtn.isEnabled())?true:false;
		if(Disclaimer_Flag){
			if(NextBtn_Flag){
				System.out.println("Disclaimer Agree checkbox is checked and Next button is enabled : Validation Passed");
				flag = true;
			}
			else
			{
				System.out.println("Disclaimer Agree checkbox is checked and Next button is DISABLED : Validation failed");
				flag = false;

			}
		}
		return flag;
	}

	public MedicareInformationPage navigate_to_medicare_info_page() {
		
		validate(NextBtn);
		NextBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("medicare-information")){
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		return null;
	}

	public LearnMoreModal OpenLearnMore() {
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
}