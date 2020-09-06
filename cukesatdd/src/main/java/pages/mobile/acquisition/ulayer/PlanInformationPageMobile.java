/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PlanInformationPageMobile extends UhcDriver {
		
	@FindBy(id = "enrollment.medicareBeneficiary.hasEndStateRenalDisease1")
	private WebElement noRadioButton;
	
	@FindBy(id = "enrollment.medicareBeneficiary.hasEndStateRenalDisease2")
	private WebElement yesRadioButton;
	
	@FindBy(id = "enrollmentNext")
	private WebElement enrollmentNext;
	
	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h2")
	private WebElement pageHeading;
	
	private PageData planInformation;

	public JSONObject planInformationJson;

	public PlanInformationPageMobile(WebDriver driver,String planName) {
		super(driver);
		PageFactory.initElements(driver, this);
		if(planName.contains("HMO"))
		{
			String fileName = CommonConstants.MA_PLAN_INFORMATION_PAGE_DATA;
			planInformation = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		}
		if(planName.contains("PDP"))
		{
			String fileName = CommonConstants.PDP_PLAN_INFORMATION_PAGE_DATA;
			planInformation = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		}
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		validate(noRadioButton);
		validate(yesRadioButton);
		validate(enrollmentNext);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : planInformation.getExpectedData().keySet()) {
			WebElement element = findElement(planInformation.getExpectedData()
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
		planInformationJson = jsonObject;
		
	}

	public void asnwersESRDQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			noRadioButton.click();
		}
		else{
			yesRadioButton.click();
		}
		
	}

	public BeneficiaryInformationPageMobile navigateToNextStep() {
		enrollmentNext.click();
		if(pageHeading.getText().equalsIgnoreCase("Step 2: Beneficiary Information"))
		{
			return new BeneficiaryInformationPageMobile(driver);
		}
		return null;
		
	}
	
}
