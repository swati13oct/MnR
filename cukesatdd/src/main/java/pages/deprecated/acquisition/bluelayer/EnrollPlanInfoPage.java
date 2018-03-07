/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

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
public class EnrollPlanInfoPage extends UhcDriver{

	@FindBy(xpath = "//div[@id='chooseplan']/div/div[3]/div/table/tbody/tr[1]/td[2]")
	private WebElement planName;

	@FindBy(xpath = "//div[@id='chooseplan']/div/div[3]/div/table/tbody/tr[2]/td[2]")
	private WebElement zipcode;

	@FindBy(xpath = "//div[@id='chooseplan']/div/div[3]/div/table/tbody/tr[3]/td[2]")
	private WebElement premium;

	@FindBy(id = "continueEnrollment")
	private WebElement continueEnrollmentButton;

	private PageData enrollPlanInfo;

	public JSONObject enrollPlanInfoJson;

	public EnrollPlanInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ENROLL_PLAN_INFO_PAGE_DATA;
		enrollPlanInfo = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}


	public boolean validatePlanChoosenforEnroll(String choosenPlanName,String zipCountyInfo){
		boolean flag = true;
		for (String key : enrollPlanInfo.getExpectedData().keySet()) {
			WebElement element = findElement(enrollPlanInfo.getExpectedData()
					.get(key));
			if (element != null) {
				if (validateNew(element)) {
					if (key.equals("planName")){
						System.out.println("expected "+choosenPlanName);
						if(!element.getText().equals(choosenPlanName))
							flag = false;
					}
					if (key.equals("zipCountyInfo")){
						if(!element.getText().equals(zipCountyInfo))
							flag = false;
					}
					if (key.equals("premium")){
						if(!element.getText().contains("a month"))
							flag = false;
					}
					if (key.equals("eligibilityInfo")){
						String[] eligiblityInfotexts = element.getText().split("\n");

						for(int i = 0 ; i < eligiblityInfotexts.length;i++){
							System.out.println(eligiblityInfotexts[i]);
						}
						if(choosenPlanName.contains("HMO")) {
							if(!(eligiblityInfotexts[0].equals("Eligibility") && eligiblityInfotexts[1].contains("Medicare Advantage plans") && eligiblityInfotexts[2].equals("Learn more about eligibility and when to enroll.")))
								flag = false;
						}else if(choosenPlanName.contains("PDP")) {
							if(!(eligiblityInfotexts[0].equals("Eligibility") && eligiblityInfotexts[1].contains("Medicare prescription drug plan") && eligiblityInfotexts[2].equals("Learn more about Medicare eligibility and how to enroll by phone or mail.")))
								flag = false;
						}
					}

					if(!flag)
						break;					
				}
			}
		}

		return flag;
	}
	@Override
	public void openAndValidate() {

		validateNew(continueEnrollmentButton);

		JSONObject jsonObject = new JSONObject();
		for (String key : enrollPlanInfo.getExpectedData().keySet()) {
			WebElement element = findElement(enrollPlanInfo.getExpectedData()
					.get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		enrollPlanInfoJson = jsonObject;

	}

	public PlanInformationPage continuesEnrollment(String planName) {

		continueEnrollmentButton.click();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Plan Enrollment Information | UnitedHealthcare®") || driver.getTitle().equalsIgnoreCase("Prescription Drug Plan Enrollment | UnitedHealthcare®")){
			return new PlanInformationPage(driver,planName);
		}
		return null;

	}

}