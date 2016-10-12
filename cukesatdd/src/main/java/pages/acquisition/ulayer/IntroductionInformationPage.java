/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class IntroductionInformationPage extends UhcDriver{
	
	@FindBy(xpath = "//input[@id='firstnametextbox']")
	private WebElement firstNameField;
	
	@FindBy(id = "middlenametextbox")
	private WebElement middleInitialField;
	
	@FindBy(id = "lastnametextbox")
	private WebElement lastNameField;
	
	@FindBy(id = "medicalclaimnumtext")
	private WebElement claimNumberField;
	
	@FindBy(id = "part-a")
	private WebElement partAStartDateField;
	
	@FindBy(id = "part-b")
	private WebElement partBStartDateField;
	
	@FindBy(id = "enrollmentdisclaimerstep1btn")
	private WebElement viewEnrollDisclaimer;
	
	@FindBy(id="disclaimerAgreeBtndisclaimer")
	private WebElement disclaimeragreebtn;
	
	@FindBy(xpath = "//*[@id='beginOnlineEnrollmentbtn']")
	private WebElement enrollmentNext;
	
	@FindBy(xpath = "//div[@id='disclaimer']/div/p")
	private WebElement disclaimerHeading;
	
	private PageData introductionInformation;

	public JSONObject  introductionInformationJson;

	public JSONObject enrollPlanInfoJson;

	public IntroductionInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.INTRODUCTION_INFORMATION_PAGE_DATA;
		introductionInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		validate(firstNameField);
		validate(middleInitialField);
		validate(lastNameField);
		validate(claimNumberField);
		validate(partAStartDateField);
		validate(partBStartDateField);
		validate(viewEnrollDisclaimer);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : introductionInformation.getExpectedData().keySet()) {
			WebElement element = findElement(introductionInformation.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		introductionInformationJson = jsonObject;

		
	}

	public void entersmedicareinsuranceInformation(
			Map<String, String> personalAttributesMap) {
		
		String firstName = personalAttributesMap.get("First Name");
		String middleName = personalAttributesMap.get("Middle Initial");
		String lastName = personalAttributesMap.get("Last Name");
		String medicareClaimNumber = personalAttributesMap.get("Medicare Claim Number").replaceAll("-", "");
		String partAStartDate = personalAttributesMap.get("Hospital (Part A) Effective Date").replaceAll("[/-]", "");
		String partBStartDate = personalAttributesMap.get("Medical (Part B) Effective Date").replaceAll("[/-]", "");
		
		sendkeys(firstNameField, firstName);
		sendkeys(middleInitialField, middleName);
		sendkeys(lastNameField, lastName);

		sendkeys(claimNumberField, medicareClaimNumber);
		sendkeys(partAStartDateField,partAStartDate);
		sendkeys(partBStartDateField,partBStartDate);
		viewEnrollDisclaimer.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			disclaimeragreebtn.click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public BeneficiaryInformationPage navigatesToNextStep() {
		enrollmentNext.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new BeneficiaryInformationPage(driver);
	}
}