/**
 * 
 */
package pages.acquisition.bluelayer;

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
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class AdditionalInformationPage extends UhcDriver{

	@FindBy(id = "enrollmentNext")
	private WebElement enrollmentNext;

	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h3")
	private WebElement pageHeading;

	@FindBy(id = "enrollmentPeriodType2")
	private WebElement nospecialelectionRadioButton;

	@FindBy(id = "enrollmentPeriodType1")
	private WebElement yesspecialelectionRadioButton;
	
	@FindBy(id = "enrollment.otherCoverageInfo.prescriptionDrugCoverage2")
	private WebElement noprescriptiondrugcoverageRadioButton;
	
	@FindBy(id = "enrollment.otherCoverageInfo.prescriptionDrugCoverage1")
	private WebElement yesprescriptiondrugcoverageRadioButton;
	
	@FindBy(id = "enrollment.medicaidAndInstitutionInfo.extendedCareInstitutionResident2")
	private WebElement nolongtermcareRadioButton;
	
	@FindBy(id = "enrollment.medicaidAndInstitutionInfo.extendedCareInstitutionResident1")
	private WebElement yeslongtermcareRadioButton;
	
	@FindBy(id = "enrollment.medicaidAndInstitutionInfo.stateMedicaidEnrollee2")
	private WebElement nomedicaidprogramRadioButton;
	
	@FindBy(id = "enrollment.medicaidAndInstitutionInfo.stateMedicaidEnrollee1")
	private WebElement yesmedicaidprogramRadioButton;
	
	@FindBy(id = "enrollment.otherCoverageInfo.otherHealthInsuranceCoverage2")
	private WebElement nootherhealthinsuranceRadioButton;

	@FindBy(id = "enrollment.otherCoverageInfo.otherHealthInsuranceCoverage1")
	private WebElement yesotherhealthinsuranceRadioButton;
	
	@FindBy(id = "enrollment.selectedRiders1")
	private WebElement nodentalsupplementaryRadioButton;

	@FindBy(id = "enrollment.selectedRiders2")
	private WebElement yesdentalsupplementaryRadioButton;
	
	@FindBy(id = "enrollment.additionalPlanOptionsInfo.monthlyDeductionFromSSEnabled2")
	private WebElement nopaymentoptionsRadioButton;
	
	@FindBy(id = "enrollment.additionalPlanOptionsInfo.monthlyDeductionFromSSEnabled1")
	private WebElement yespaymentoptionsRadioButton;
	
	@FindBy(id = "enrollment.brokerId")
	private WebElement brokerIdTextfield;
	
	@FindBy(className = "look_up_physician")
	private WebElement providerSearchlink;
	
	@FindBy(className = "plan-bar-name")
	private WebElement providerSearchpageTitle;
	
	private PageData additionalInformation;

	public JSONObject additionalInformationJson;

	public AdditionalInformationPage(WebDriver driver, String planName) {
		super(driver);
		PageFactory.initElements(driver, this);
		if (planName.contains("HMO")) {
			String fileName = CommonConstants.MA_ADDITIONAL_INFORMATION_PAGE_DATA;
			additionalInformation = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		}
		if (planName.contains("PDP")) {
			String fileName = CommonConstants.PDP_ADDITIONAL_INFORMATION_PAGE_DATA;
			additionalInformation = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		}

		openAndValidate();
	}

	public boolean validateAdditionalInformationPage(JSONObject additionalinfoObject, String planName, String zipCountInfo){
		boolean flag = true;
		try {

			if(!additionalinfoObject.get("planName").toString().contains(planName))
				flag = false;
			if(!additionalinfoObject.get("zipCountyInfo").toString().equals(zipCountInfo))
				flag = false;
			if(!additionalinfoObject.get("premium").toString().contains("$"))
				flag = false;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return flag;
	}

	@Override
	public void openAndValidate() {

		validate(enrollmentNext);
		JSONObject jsonObject = new JSONObject();
		for (String key : additionalInformation.getExpectedData().keySet()) {
			WebElement element = findElement(additionalInformation.getExpectedData()
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
		additionalInformationJson = jsonObject;

	}

	public void answerSpecialElectionQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			nospecialelectionRadioButton.click();
		}
		else{
			yesspecialelectionRadioButton.click();
		}
	}
	

	public void answerPrescriptionDrugCoverageQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			noprescriptiondrugcoverageRadioButton.click();
		}
		else{
			yesprescriptiondrugcoverageRadioButton.click();
		}
	}
	
	public void answerLongTermCareQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			nolongtermcareRadioButton.click();
		}
		else{
			yeslongtermcareRadioButton.click();
		}
	}
	
	public void answerMedicaidProgramQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			nomedicaidprogramRadioButton.click();
		}
		else{
			yesmedicaidprogramRadioButton.click();
		}
	}
	
	public void answerOtherHealthInsuranceQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			nootherhealthinsuranceRadioButton.click();
		}
		else{
			yesotherhealthinsuranceRadioButton.click();
		}
	}

	
	public void answerDentalSupplementQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			nodentalsupplementaryRadioButton.click();
		}
		else{
			yesdentalsupplementaryRadioButton.click();
		}
	}
	

	public void answerPaymentOptionsQuestion(String answer) {
		if(answer.equalsIgnoreCase("No"))
		{
			nopaymentoptionsRadioButton.click();
		}
		else{
			yespaymentoptionsRadioButton.click();
		}
		
	}
	
	public void provideBrokerid(String brokerId){
		sendkeys(brokerIdTextfield, brokerId);
	}
	
	public boolean validateProviderSearch(String planName){
		boolean flag = true;
		String winHandleBefore = driver.getWindowHandle();
		providerSearchlink.click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		String text = providerSearchpageTitle.getText();
		System.out.println(text);
		if(!providerSearchpageTitle.getText().equalsIgnoreCase(PageTitleConstants.BLAYER_PRIMARY_CARE_PROVIDER_SELECTION+planName))
			flag = false;
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return flag;
	}

	public ReviewApplicationPage navigatesToNextStep(String planName) {
		enrollmentNext.click();
		if (pageHeading.getText().equalsIgnoreCase(
				PageTitleConstants.BLAYER_PRIMARY_CARE_PROVIDER_SELECTI)) {
			return new ReviewApplicationPage(driver,planName);
		}
		return null;

	}

}
