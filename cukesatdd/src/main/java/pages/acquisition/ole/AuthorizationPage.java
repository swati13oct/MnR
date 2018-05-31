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
public class AuthorizationPage extends UhcDriver{

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
	private WebElement PageHeader;

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

	//Relationship to the applicant listed Question
	
	@FindBy(id = "auhtorizedCheckI am the applicant listed on this enrollment application.")
	private WebElement ApplicantRadio;

	@FindBy(xpath = "//*[contains(text(), 'I am the authorized representative of the applicant')]/preceding-sibling::input")
	private WebElement AuthorizedRepresentativeRadio;

	//Authorized Representative Details
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_FirstName;

	@FindBy(id = "firstName0")
	private WebElement Authorized_LastName;
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_Relation;
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_Address;
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_City;
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_State;
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_ZipCode;
	
	@FindBy(id = "firstName0")
	private WebElement Authorized_PhNo;

	//Read and Agree to the Statement of Understanding
	@FindBy(id = "AgreeAgree")
	private WebElement SoU_AgreeRadio;

	@FindBy(id = "AgreeDisagree")
	private WebElement SoU_DisagreeRadio;
	
	@FindBy(xpath = "//*[contains(text(), 'sorry, you cannot complete the application without agreeing to the Statement of Understanding')]")
	private WebElement SoU_DisagreeError;
	
	@FindBy(id = "ole-force-cancel-button")
	private WebElement CancelEnrollButton;

	
	public AuthorizationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(PageHeader);
		System.out.println("Page header is Displayed : "+PageHeader.getText());	
	}

	public boolean validate_required_field() {
		boolean validation_Flag = true;
		if(!NextBtn.isEnabled()){
			System.out.println("Next Button is Disabled : Required fields present");
			SoU_DisagreeRadio.click();
			if(validate(SoU_DisagreeError) && validate(CancelEnrollButton)){
				System.out.println("Error message and Cancel Enrollment Button are displaeyd for Disagree to SoU selection");
				validation_Flag = true;
			}
			else{
				System.out.println("Error message and Cancel Enrollment Button are NOT displaeyd for Disagree to SoU selection : Validation Failed");
				validation_Flag = false;
			}
/*			if(validate(SoU_AgreeRadio)){
				SoU_AgreeRadio.click();
			}
			if(validate(AuthorizedRepresentativeRadio)){
				AuthorizedRepresentativeRadio.click();
			}*/
			SoU_AgreeRadio.click();
			AuthorizedRepresentativeRadio.click();
			if(!NextBtn.isEnabled() && validate(Authorized_FirstName) && validate(Authorized_LastName) 
					&& validate(Authorized_Relation) && validate(Authorized_Address) && validate(Authorized_City) && validate(Authorized_State)
					&& validate(Authorized_ZipCode) && validate(Authorized_PhNo)){
				System.out.println("Required Fields are displayed for Authorized Representative Details entry : Next Button is disabled");
				validation_Flag = (!validation_Flag)?false:true;
			}
			else{
				System.out.println("Next Button is enabled : Required Field Validation Failed");
				validation_Flag = false;
			}
			ApplicantRadio.click();
			if(NextBtn.isEnabled()){
				validation_Flag = (!validation_Flag)?false:true;
				System.out.println("Validation Passed : All required fields are entered");
			}
			else{
				System.out.println("All required Fields are entered : Next Button is disabled");
				validation_Flag = false;
			}
		}
		else{
			System.out.println("Next Button is enabled : Required Field Validation Failed");
			validation_Flag = false;
		}
		return validation_Flag;
	}

	public ReviewSubmitPage navigate_to_Review_Submit_Page() {
		validate(NextBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);
		
		//NextBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("review")){
			return new ReviewSubmitPage(driver);
		}
		else{
			return null;
		}
	}



}