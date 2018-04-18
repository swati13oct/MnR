/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

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
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(xpath = "//*[@class = 'cta-button next-button']")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//*[@class = 'cancel-button modal-link']")
	private WebElement CancelEnrollmentLink;
	
	// WebElements for Welcome Page
	@FindBy(xpath = "//*[@class = 'only-intro']")
	private WebElement WelcomePageHeader;
	
	@FindBy(xpath="//a[contains(text(), 'Our Plans')]")
	private WebElement OurPlansLink;
	
	@FindBy(xpath = "//*[contains(text(), 'chosen to enroll in:')]/following-sibling::h3")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[contains(text(), 'ZIP:')]/..")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[contains(text(), 'Premium:')]/..")
	private WebElement PremiumDisplay;
	
	@FindBy(xpath = "//*[@id='ole-form-content']/div/div[3]/p[2]/a")
	private WebElement LearnMoreButton;
	
	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']/following-sibling::label")
	private WebElement AgreeCheckBx;
	
		
	public WelcomePage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
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

		//validate(WelcomePageHeader);
		//validate(PlanYear_PlanName);
		
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
		if(PlanYear_PlanName_Text.contains(Expected_PlanName) && 
				PlanYear_PlanName_Text.contains(Expected_PlanYear) && 
				Zip_County_Text.contains(Expected_County)&& 
				Zip_County_Text.contains(Expected_ZipCode) && 
				Premium.contains(Expected_PlanPremium)){
			System.out.println("All Plan Details are Validated");
			return true;
			
		}
		return false;
	}



}