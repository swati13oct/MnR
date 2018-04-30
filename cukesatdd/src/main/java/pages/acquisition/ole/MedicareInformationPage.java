/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
		
	@FindBy(xpath = "//*[@class = 'cta-button next-button']")
	private WebElement NextBtn;
		
	@FindBy(xpath = "//*[@class = 'cancel-button modal-link']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[@class = 'ole-form-header']")
	private WebElement MedicalInfoPageHeader;
	
	//Select Medicare Card Type - A 0r B
	
	@FindBy(id="card-typeA")
	private WebElement SelectCardA;
	
	@FindBy(id="card-typeB")
	private WebElement SelectCardB;
	
	@FindBy(id="card-type-before")
	private WebElement RadioCardA;
	
	@FindBy(id="card-type-after")
	private WebElement RadioCardB;

	//Medicare Information fields
	@FindBy(id="First")
	private WebElement firstNameField;
	
	@FindBy(id = "Middle")
	private WebElement middleInitialField;
	
	@FindBy(id = "Last")
	private WebElement lastNameField;
	
	@FindBy(id = "claimNumber")
	private WebElement claimNumberField;
	
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
			
			System.out.println("Medicare Information Fields are Displayed when Card Type is not selected");
			flag = (flag==false)?false:true;
		}
		
		
		return flag;
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
			System.out.println("OLE Preliminary Questions Page is Displayed");
			return new PrelimineryQuestionsPage(driver);
		}
		return null;
	}


}