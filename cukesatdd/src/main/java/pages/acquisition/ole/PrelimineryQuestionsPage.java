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
public class PrelimineryQuestionsPage extends UhcDriver{
	
	
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
	
	@FindBy(xpath = "//*[@class='cta-button primary force-cancel-button modal-link show']")
	private WebElement CancelEnrollmentBtn;


	//Preliminery Page header
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement PrelimPageHeader;

	// Medicaid Questions
	@FindBy(id = "medicaid")
	private WebElement MedicaidquestionRadio;

	@FindBy(id = "medicaidNumber")
	private WebElement MedicaidNumberField;
	
	@FindBy(xpath = "//*[@id='esrd-msg-block']//p[1]")
	private WebElement Medicaid_ErrorMessage;
	
	//ESRD question

	@FindBy(id = "renalstage")
	private WebElement ESRDquestionRadio;
	
	@FindBy(xpath = "//*[@id='esrd-msg-block']//p']")
	private WebElement ESRD_ErrorMessage;

	
	public PrelimineryQuestionsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(PrelimPageHeader);
		validate(PrelimPageHeader);
	}

	public PersonalInformationPage navigate_to_Personal_Information_page() {
		
		validate(NextBtn);
		NextBtn.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("personal-information")){
			System.out.println("OLE Personal Information Page is Displayed");
			return new PersonalInformationPage(driver);
		}
		return null;
	}
	

}