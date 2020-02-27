/**
 * 
 */
package pages.acquisition.ole;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class ReviewSubmitPage extends UhcDriver{

	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(xpath = "//button[contains(@class,'confirm-button')]")
	private WebElement SubmitApplicationBtn;

	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@class = 'cancel-button modal-link' or @id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-review')]")
	private WebElement PageHeader;
	
	@FindBy(xpath = "//*[contains(@id,'ole-form-submitted')]")
	private WebElement confirmationForm;

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

	//Plan Details Display
	@FindBy(xpath = "//*[contains(@class, 'plan-information')]//h3")
	private WebElement PlanYear_NameDisplay;

	@FindBy(xpath = "//*[contains(@class, 'plan-information')]//li")
	private WebElement PlanZipDisplay;

	//Member Details Display
	@FindBy(xpath = "//*[contains(text(), 'First Name')]//following-sibling::*")
	private WebElement FirstNameDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Last Name')]//following-sibling::*")
	private WebElement LastNameDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Medicare Claim Number') or contains(text(), 'Medicare (Claim) Number')]//following-sibling::*")
	private WebElement MedicareClaimNumberDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Medicare Number')]//following-sibling::*")
	private WebElement MedicareNumberDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Hospital (Part A) Effective Date')]//following-sibling::*")
	private WebElement PartADisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Medical (Part B) Effective Date')]//following-sibling::*")
	private WebElement PartBDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Birth Date')]//following-sibling::*")
	private WebElement DOBDisplay;

	@FindBy(xpath = "//*[contains(text(), 'Gender')]//following-sibling::*")
	private WebElement GenderDisplay;

	//Permanent Address Display
	@FindBy(xpath = "//*[contains(text(), 'Street Address')]//following-sibling::*")
	private List <WebElement> StreetDisplays;

	@FindBy(xpath = "//*[contains(text(), 'City')]//following-sibling::*")
	private List <WebElement> CityDisplays;


	//Mailing Address Display
	@FindBy(xpath = "//*[contains(text(), 'Is your mailing address the same as')]//following-sibling::*")
	private WebElement MailingQiuestionDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'mailing address')]/ancestor::*[contains(@class, 'review-step')]//*[contains(text(), 'State')]//following-sibling::*")
	private WebElement MailStateDisplay;
	
	@FindBy(xpath = "//*[contains(text(), 'Zip Code')]//following-sibling::*")
	private WebElement MailZipDisplay;
	
	//Submit Application Disclaimer
	@FindBy(xpath = "//*[contains(@class, 'submit-disclaimer')]")
	private WebElement Submit_Disclaimer;
	
	@FindBy(xpath = "//*[@class = 'default-ul']")
	private WebElement Enrollment_Disclaimer_Text;
	
	@FindBy(xpath = "//*[@id = 'ole-form-submitted']")
	private WebElement Form_Sumbitted_ConfirmationPage;
	
	
	public ReviewSubmitPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, SubmitApplicationBtn, 30);
		validateNew(PageHeader);
		System.out.println("Page header is Displayed : "+PageHeader.getText());	
	}

	public boolean all_plan_and_member_details(Map<String, String> detailsMap) {

		String DOB = detailsMap.get("DOB");
		String Gender = detailsMap.get("Gender");
		String Perm_Street = detailsMap.get("Perm_Street");
		String Perm_city = detailsMap.get("Perm_city");
		String MailingQuestion = detailsMap.get("MAILING_QUESTION");
		String Mailing_Street = detailsMap.get("Mailing_Street");
		String Mailing_City = detailsMap.get("Mailing_City");
		String Mailing_State = detailsMap.get("Mailing_State");
		String Mailing_Zip = detailsMap.get("Mailing_Zip");
		String EmailAddress = detailsMap.get("Email");
		String FirstName = detailsMap.get("First Name");
		String LastName = detailsMap.get("Last Name");
		String MedicareNumber = detailsMap.get("Medicare Number");
		String PartAeffectiveDate = detailsMap.get("PartA Date");
		String PartBeffectiveDate = detailsMap.get("PartB Date");
		String CardType = detailsMap.get("Card Type");
		String Expected_PlanName = detailsMap.get("Plan Name");
		String Expected_PlanYear = detailsMap.get("Plan Year");
		String Expected_ZipCode = detailsMap.get("Zip Code");
		String Expected_County = detailsMap.get("County");
		String Expected_PlanPremium = detailsMap.get("Plan Premium");

		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		boolean flag = true;
		validateNew(PlanYear_NameDisplay);
		String PlanNameDisplayed = PlanYear_NameDisplay.getText();
		if(PlanNameDisplayed.contains(Expected_PlanName)){
			flag = (!flag)?false:true;
			System.out.println(Expected_PlanName+" : "+PlanNameDisplayed+" : "+flag);
		}else flag =false;
		String PlanZipDisplayed = PlanZipDisplay.getText();
		if(PlanZipDisplayed.contains(Expected_ZipCode)){
			flag = (!flag)?false:true;
			System.out.println(Expected_ZipCode+" : "+PlanZipDisplayed+" : "+flag);
		}else flag =false;
		
		String FirstNameDisplayed = FirstNameDisplay.getText();
		if(FirstNameDisplayed.contains(FirstName)){
			flag = (!flag)?false:true;
			System.out.println(FirstName+" : "+FirstNameDisplayed+" : "+flag);
		}else flag =false;
		String LastNameDisplayed = LastNameDisplay.getText();
		if(LastNameDisplayed.contains(LastName)){
			flag = (!flag)?false:true;
			System.out.println(LastName+" : "+LastNameDisplayed+" : "+flag);
		}else flag =false;

		if(CardType.contains("HICN") || CardType.contains("RRID") ){
			String MedicareNumberDisplayed = MedicareClaimNumberDisplay.getText().replaceAll("-", "");
			if(MedicareNumberDisplayed.contains(MedicareNumber)){
				flag = (!flag)?false:true;
				System.out.println(MedicareNumber+" : "+MedicareNumberDisplayed+" : "+flag);
			}else flag =false;
		}
		else{
			String MedicareNumberDisplayed = MedicareNumberDisplay.getText().replaceAll("-", "");
			if(MedicareNumberDisplayed.contains(MedicareNumber)){
				flag = (!flag)?false:true;
				System.out.println(MedicareNumber+" : "+MedicareNumberDisplayed+" : "+flag);
			}else flag =false;

		}
		String PartADisplayed = PartADisplay.getText().replaceAll("-", "");
		if(PartADisplayed.contains(PartAeffectiveDate)){
			flag = (!flag)?false:true;
			System.out.println(PartAeffectiveDate+" : "+PartADisplayed+" : "+flag);
		}else flag =false;
		
		String PartBDisplayed = PartBDisplay.getText().replaceAll("-", "");
		if(PartBDisplayed.contains(PartBeffectiveDate)){
			flag = (!flag)?false:true;
			System.out.println(PartBeffectiveDate+" : "+PartBDisplayed+" : "+flag);
		}else flag =false;

		String DOBDisplayed = DOBDisplay.getText().replaceAll("-", "");
		if(DOBDisplayed.contains(DOB)){
			flag = (!flag)?false:true;
			System.out.println(DOB+" : "+DOBDisplayed+" : "+flag);
		}else flag =false;
		
		String GenderDisplayed = GenderDisplay.getText();
		if(GenderDisplayed.contains(Gender)){
			flag = (!flag)?false:true;
			System.out.println(Gender+" : "+GenderDisplayed+" : "+flag);
		}else flag =false;
		
		String PermStreetDisplayed = StreetDisplays.get(0).getText();
		if(PermStreetDisplayed.contains(Perm_Street)){
			flag = (!flag)?false:true;
			System.out.println(Perm_Street+" : "+PermStreetDisplayed+" : "+flag);
		}else flag =false;
		
		String PermCityDisplayed = CityDisplays.get(0).getText();
		if(PermCityDisplayed.contains(Perm_city)){
			flag = (!flag)?false:true;
			System.out.println(Perm_city+" : "+PermCityDisplayed+" : "+flag);
		}else flag =false;

		
		String MailAddQuestionDisplayed = MailingQiuestionDisplay.getText();
		if(MailAddQuestionDisplayed.contains(MailingQuestion)){
			flag = (!flag)?false:true;
			System.out.println(MailingQuestion+" : "+MailAddQuestionDisplayed+" : "+flag);
		}else flag =false;

		if(MailingQuestion.equalsIgnoreCase("no")){
			String StateDisplayed = MailStateDisplay.getText();
			if(StateDisplayed.contains(Mailing_State)){
				flag = (!flag)?false:true;
				System.out.println(Mailing_State+" : "+StateDisplayed+" : "+flag);
			}else flag =false;
			
			String ZipDisplayed = MailZipDisplay.getText();
			if(ZipDisplayed.contains(Mailing_Zip)){
				flag = (!flag)?false:true;
				System.out.println(Mailing_Zip+" : "+ZipDisplayed+" : "+flag);
			}else flag =false;
			
			String MailStreetDisplayed = StreetDisplays.get(1).getText();
			if(MailStreetDisplayed.contains(Mailing_Street)){
				flag = (!flag)?false:true;
				System.out.println(Mailing_Street+" : "+MailStreetDisplayed+" : "+flag);
			}else flag =false;

			String MailCityDisplayed = CityDisplays.get(1).getText();
			if(MailCityDisplayed.contains(Mailing_City)){
				flag = (!flag)?false:true;
				System.out.println(Mailing_City+" : "+MailCityDisplayed+" : "+flag);
			}else flag =false;

		}

		if(validate(Submit_Disclaimer) && validate(Enrollment_Disclaimer_Text)){
			if(Enrollment_Disclaimer_Text.getText().contains("Submitting your enrollment application electronically")){
				flag = (!flag)?false:true;
				System.out.println("Submit Enrollment Disclaimer is Displayed  : "+flag);
			}
			else flag = false;
		}else flag = false;

		if(validate(SubmitApplicationBtn)){
			if(SubmitApplicationBtn.isEnabled()){
				flag = (!flag)?false:true;
				System.out.println("Submit Application Button is displayed and Enabled : "+flag);
			}
			else flag = false;
		}else flag = false;

		
		return flag;
	}

	public OLEconfirmationPage submitEnrollment() {
		

		validateNew(SubmitApplicationBtn);
		SubmitApplicationBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		//waitforElementDisapper(By.xpath("//button[contains(@class,'confirm-button')]"), 60);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitApplicationBtn);*/
		//waitforElementDisapper(By.xpath("//*[@class = 'cta-button confirm-button']"), 45);
/*		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class = 'cta-button confirm-button']")));*/
		//validateNew(confirmationForm,30);
		if(driver.getCurrentUrl().contains("/confirmation")){
			System.out.println("OLE Enrollment Submission Confirmation Page is Displayed");
			return new OLEconfirmationPage(driver);
		}
		else if(validate(SubmitApplicationBtn)){
			SubmitApplicationBtn.click();
			if(driver.getCurrentUrl().contains("confirmation")){
				System.out.println("OLE Enrollment Submission Confirmation Page is Displayed");
				return new OLEconfirmationPage(driver);
			}

		}
		return null;	
		}

}
