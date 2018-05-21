/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PrimaryCarePhysicianPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement PCPPageHeader;

	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;
	
	//Provider Contact Information Section - PFFS plans Only
	@FindBy(xpath = "//*[contains(text(), 'Provider Contact Information')]")
	private WebElement ProviderINfoHeader;
	
	//Doctor INfo section 1

	@FindBy(id = "doctorsFullName1")
	private WebElement Doctor1_Name;
	
	@FindBy(id = "phoneNo1")
	private WebElement Doctor1_Ph;
	
	@FindBy(id = "city1")
	private WebElement Doctor1_City;
	
	@FindBy(id = "state1")
	private WebElement Doctor1_State;
	
	@FindBy(id = "zip1")
	private WebElement Doctor1_Zip;

	//Doctor INfo section 2

	@FindBy(id = "doctorsFullName2")
	private WebElement Doctor2_Name;
	
	@FindBy(id = "phoneNo2")
	private WebElement Doctor2_Ph;
	
	@FindBy(id = "city2")
	private WebElement Doctor2_City;
	
	@FindBy(id = "state2")
	private WebElement Doctor2_State;
	
	@FindBy(id = "zip2")
	private WebElement Doctor2_Zip;
	
	//Hospital INfo section 2

	@FindBy(id = "hsptlname")
	private WebElement Hospital_Name;
	
	@FindBy(id = "hsptlPhno")
	private WebElement Hospital_Ph;
	
	@FindBy(id = "hsptlCity")
	private WebElement Hospital_City;
	
	@FindBy(id = "state")
	private WebElement Hospital_State;
	
	@FindBy(id = "hsptlZip")
	private WebElement Hospital_Zip;

	public PrimaryCarePhysicianPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(PCPPageHeader);
		System.out.println("Page header is Displayed"+PCPPageHeader.getText());	
	}

	public boolean validate_provider_contact_info_in_PCP() {
		boolean validation_Flag;
		if(validate(ProviderINfoHeader) && validate(Doctor1_Name) && validate(Doctor1_Ph) && validate(Doctor1_City) && validate(Doctor1_State) && validate(Doctor1_Zip)
				 && validate(Doctor2_Name) && validate(Doctor2_Ph) && validate(Doctor2_City) && validate(Doctor2_State) && validate(Doctor2_Zip)
				 && validate(Hospital_Name) && validate(Hospital_Ph) && validate(Hospital_City) && validate(Hospital_State) && validate(Hospital_Zip)){
			System.out.println("Provider Contact Information Section - Displayed for PFFS plans");
			 validation_Flag = true;
		}
		else
			validation_Flag = false;
		return validation_Flag;
	}

	public PlanPremiumPage navigate_to_Plan_Premium_Page() {

		validate(NextBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("monthly-premium")){
			System.out.println("OLE Monthly Plan Premium Page is Displayed");
			return new PlanPremiumPage(driver);
		}
		else{
			System.out.println("OLE Monthly Plan Premium Page is Not Displayed");
			return null;
		}
	}

}