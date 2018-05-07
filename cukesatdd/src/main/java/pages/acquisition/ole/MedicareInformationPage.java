/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class MedicareInformationPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	//Progress Bar Elements 
	@FindBy(xpath = "//*[@class = 'progress-legend']")
	private WebElement ProgressBarText;

	@FindBy(xpath = "//*[@class = 'form-current-progress']")
	private WebElement ProgressBarPercentageIndicator;

	//Page Navigation Elements
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "cancel-enrollment")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement MedicalInfoPageHeader;
	
	//Select Medicare Card Type - A 0r B
	
	@FindBy(xpath="//*[@id='card-typeA']/label")
	private WebElement SelectCardA;
	
	@FindBy(xpath="//*[@id='card-typeB']/label")
	private WebElement SelectCardB;
	
	@FindBy(id="card-type-before")
	private WebElement RadioCardA;
	
	@FindBy(id="card-type-after")
	private WebElement RadioCardB;

	//Medicare Information fields
	@FindBy(id="FirstName")
	private WebElement firstNameField;
	
	@FindBy(id = "Middle")
	private WebElement middleInitialField;
	
	@FindBy(id = "Last")
	private WebElement lastNameField;
	
	@FindBy(id = "claimNumber")
	private WebElement claimNumberField;
	
	@FindBy(id = "SSN")
	private WebElement SSNField;
	
	@FindBy(id = "partAdate")
	private WebElement partAStartDateField;
	
	@FindBy(id = "partBdate")
	private WebElement partBStartDateField;
	
	public MedicareInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		System.out.println("Validating Medicare Information for OLE");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(MedicalInfoPageHeader);
		validate(SelectCardA);
		validate(SelectCardB);
	}

	public boolean validate_required_fields() {
		boolean flag = false;
		
		if(!RadioCardA.isSelected() && !RadioCardA.isSelected()){
			if(!NextBtn.isEnabled() && !validate(firstNameField)&& !validate(lastNameField) && !validate(claimNumberField)
					&& !validate(partAStartDateField)&& !validate(partBStartDateField)){
				System.out.println("Medicare Information Fields are not Displayed when Card Type is not selected");
				flag= true;
			}
			else{
				System.out.println("Validation for Required Medicare Card Type Selection failed ");
				flag= false;
			}
		}
		SelectCardA.click();
		if(validate(firstNameField)&& validate(lastNameField) && validate(claimNumberField)
				&& validate(partAStartDateField)&& validate(partBStartDateField)){
			
			System.out.println("Medicare Information Fields are Displayed when Card Type is selected");
			flag = (flag==false)?false:true;
		}
		
		
		return flag;
	}

	public MedicareInformationPage enter_required_Medicare_details(Map<String, String> MedicareDetailsMap){
		String FirstName = MedicareDetailsMap.get("First Name");
		String LastName = MedicareDetailsMap.get("Last Name");
		String MedicareNumber = MedicareDetailsMap.get("Medicare Number");
		String PartAeffectiveDate = MedicareDetailsMap.get("PartA Date");
		String PartBeffectiveDate = MedicareDetailsMap.get("PartB Date");
		String CardType = MedicareDetailsMap.get("Card Type");
		String SSNflag = MedicareDetailsMap.get("SSN Flag");
		WebElement MedicareNumberLabel = driver.findElement(By.xpath(".//*[@id='claimNumber']/preceding-sibling::label"));
		if(CardType.contains("HICN")){
			SelectCardA.click();
			if(MedicareNumberLabel.getText().contains("Medicare Claim Number")){
				System.out.println("Correct Label 'Medicare Claim Number' displayed for CARD A");
			}
			else{
				System.out.println("Correct Label not displayed for CARD A");
				return null;
			}
		}
		if(CardType.contains("MBI")){
			SelectCardB.click();
			if(MedicareNumberLabel.getText().contains("Medicare Number")){
				System.out.println("Correct Label 'Medicare Number' displayed for CARD B");
			}
			else{
				System.out.println("Correct Label not displayed for CARD B");
				return null;
			}
		}

		if(validate(firstNameField)){
			firstNameField.sendKeys(FirstName);
			System.out.println("First Name entered : "+FirstName);
		}
		else{
			System.out.println("First Name field is not dispaleyd");
			return null;
		}
		if(validate(lastNameField)){
			lastNameField.sendKeys(LastName);
			System.out.println("Last Name entered : "+LastName);
		}
		else{
			System.out.println("Last Name field is not dispaleyd");
			return null;
		}
		if(validate(claimNumberField)){
			claimNumberField.sendKeys(MedicareNumber);
			System.out.println("Medicare Number entered : "+MedicareNumber);
		}
		else{
			System.out.println("Medicare Number field is not dispaleyd");
			return null;
		}

		claimNumberField.sendKeys(MedicareNumber);
		if(SSNflag.contains("true")){
			String SSNnumber = MedicareDetailsMap.get("SSN Number");
			if(validate(SSNField)){
				System.out.println("SSN field is Displayed for NC M&R DSNP");
				SSNField.sendKeys(SSNnumber);
			}
		}
		
		partAStartDateField.sendKeys(PartAeffectiveDate);
		partBStartDateField.sendKeys(PartBeffectiveDate);
		System.out.println("All Medicare Details are entered");
		if(NextBtn.isEnabled()){
			System.out.println("Next Button is enabled to navigate to Next Page");
			return new MedicareInformationPage(driver);
		}
		else
			System.out.println("Next Button is disabled, Required Medicare Details are not provided");
		return null;
	}
	
	public PrelimineryQuestionsPage navigate_to_Preliminary_Questions_page() {
		
		validate(NextBtn);
		NextBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("preliminary-questions")){
			System.out.println("OLE Preliminary Questions page is Displayed");
			return new PrelimineryQuestionsPage(driver);
		}
		return null;
	}


}