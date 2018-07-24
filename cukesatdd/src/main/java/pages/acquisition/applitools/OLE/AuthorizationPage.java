/**
 * 
 */
package pages.acquisition.applitools.OLE;

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

	@FindBy(id = "lastName0")
	private WebElement Authorized_LastName;
	
	@FindBy(id = "authorizedPersonRelationship0")
	private WebElement Authorized_Relation;
	
	@FindBy(id = "address10")
	private WebElement Authorized_Address;
	
	@FindBy(id = "city0")
	private WebElement Authorized_City;
	
	@FindBy(id = "state0")
	private WebElement Authorized_State;
	
	@FindBy(xpath = "//*[@id = 'Zip0' or @id = 'zipCode0']")
	private WebElement Authorized_ZipCode;
	
	@FindBy(id = "authorizedPersonPhone0")
	private WebElement Authorized_PhNo;

	//Read and Agree to the Statement of Understanding
	@FindBy(id = "AgreeAgree")
	private WebElement SoU_AgreeRadio;

	@FindBy(id = "AgreeDisagree")
	private WebElement SoU_DisagreeRadio;
	
	@FindBy(id= "icon-alert-sign")
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

	public void enter_required_fields() {
			SoU_AgreeRadio.click();
			ApplicantRadio.click();

	}

	public ReviewSubmitPage navigate_to_Review_Submit_Page() {
		
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