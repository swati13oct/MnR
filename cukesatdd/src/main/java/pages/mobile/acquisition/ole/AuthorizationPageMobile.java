/**
 * 
 */
package pages.mobile.acquisition.ole;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class AuthorizationPageMobile extends UhcDriver{

	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(xpath= "//*[contains(@id,'ole-form-next-button')]")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
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
	
	@FindBy(xpath = "//*[contains(@id,'auhtorizedCheckI am the applicant listed on this enrollment application.')]")
	//@FindBy(css = ".ng-untouched > .field > .field:nth-child(1)")
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
	
	@FindBy(id = "address20")
	private WebElement Authorized_Apartment;

	//Read and Agree to the Statement of Understanding
	@FindBy(xpath= "//input[contains(@id,'Agree')]")
	private WebElement SoU_AgreeRadio;

	@FindBy(xpath = "//input[contains(@id,'Disagree')]")
	private WebElement SoU_DisagreeRadio;
	
	@FindBy(xpath= "//*[contains(@id,'icon-alert-sign')]")
	private WebElement SoU_DisagreeError;
	
	@FindBy(xpath = "//*[contains(@id,'cancel-button')]")
	private WebElement CancelEnrollButton;

	
	public AuthorizationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, PageHeader,30);
		if(PageHeader.getText().contains("Authorization"))
			System.out.println("Page header is Displayed : "+PageHeader.getText());
		else
			Assert.fail("Error in validating the Authorization page loaded");
			
	}

	public boolean validate_required_field() throws InterruptedException {
		boolean validation_Flag = true;
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is Enabled : Required fields present");
			//validateNew(SoU_DisagreeRadio);
			jsClickNew(SoU_DisagreeRadio);
			if(validateNew(SoU_DisagreeError) && validateNew(CancelEnrollButton)){
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
			jsClickNew(SoU_AgreeRadio);
			AuthorizedRepresentativeRadio.click();
			if(NextBtn.isEnabled() && validate(Authorized_FirstName) && validate(Authorized_LastName) 
					&& validate(Authorized_Relation) && validate(Authorized_Address) && validate(Authorized_City) && validate(Authorized_State)
					&& validate(Authorized_ZipCode) && validate(Authorized_PhNo)){
				System.out.println("Required Fields are displayed for Authorized Representative Details entry : Next Button is enabled");
				validation_Flag = (!validation_Flag)?false:true;
			}
			else{
				System.out.println("Next Button is enabled : Required Field Validation Failed");
				validation_Flag = false;
			}
			//CommonUtility.waitForPageLoad(driver, ApplicantRadio, 30);
			Thread.sleep(6000);
			jsClickNew(ApplicantRadio);
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

	public ReviewSubmitPageMobile navigate_to_Review_Submit_Page() {
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Review & Submit Application')]")))){
			return new ReviewSubmitPageMobile(driver);
		}
		else{
			return null;
		}
	}
	
public boolean validate_required_field_representative(Map<String, String> MemberDetailsMap) throws InterruptedException {
		
		
		String AuthorizationFirstname = MemberDetailsMap.get("authorizationFirstname");
		String AuthorizationLastname = MemberDetailsMap.get("authorizationLastname");
		String AuthorizationAddress = MemberDetailsMap.get("authorizationAddress");
		String AuthorizationApartmentSuite = MemberDetailsMap.get("authorizationApartmentSuite");
		String AuthorizationCity = MemberDetailsMap.get("authorizationCity");
		String AuthorizationZip = MemberDetailsMap.get("authorizationZip");
		String AuthorizationPhoneNo = MemberDetailsMap.get("authorizationPhoneNo");
		String AuthorizationRelationship = MemberDetailsMap.get("authorizationRelationship");
		String AuthorizationStateDisplay= MemberDetailsMap.get("authorizationStateDisplay");
		
		
		boolean validation_Flag = true;
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is Enabled : Required fields present");
			//validateNew(SoU_DisagreeRadio);
			jsClickNew(SoU_DisagreeRadio);
			if(validateNew(SoU_DisagreeError) && validateNew(CancelEnrollButton)){
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
			jsClickNew(SoU_AgreeRadio);
			AuthorizedRepresentativeRadio.click();
			if(NextBtn.isEnabled() && validate(Authorized_FirstName) && validate(Authorized_LastName) 
					&& validate(Authorized_Relation) && validate(Authorized_Address) && validate(Authorized_City) && validate(Authorized_State)
					&& validate(Authorized_ZipCode) && validate(Authorized_PhNo)){
				System.out.println("Required Fields are displayed for Authorized Representative Details entry : Next Button is enabled");
				validation_Flag = (!validation_Flag)?false:true;
			}
			else{
				System.out.println("Next Button is enabled : Required Field Validation Failed");
				validation_Flag = false;
			}
			//CommonUtility.waitForPageLoad(driver, ApplicantRadio, 30);
			Thread.sleep(6000);
			//jsClickNew(ApplicantRadio);
			
			jsClickNew(AuthorizedRepresentativeRadio);
			
			Authorized_FirstName.sendKeys(AuthorizationFirstname);
			Authorized_LastName.sendKeys(AuthorizationLastname);
			Authorized_Relation.sendKeys(AuthorizationRelationship);
			Authorized_Address.sendKeys(AuthorizationAddress);
			Authorized_City.sendKeys(AuthorizationCity);
			Select SelectState = new Select(Authorized_State);
			SelectState.selectByValue(AuthorizationStateDisplay);
			//sendkeys(Authorized_State,AuthorizationStateDisplay);
			Authorized_ZipCode.sendKeys(AuthorizationZip);
			Authorized_PhNo.sendKeys(AuthorizationPhoneNo);
			Authorized_Apartment.sendKeys(AuthorizationApartmentSuite);
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




}