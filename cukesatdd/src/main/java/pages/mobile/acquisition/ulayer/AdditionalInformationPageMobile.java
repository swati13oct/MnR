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
public class AdditionalInformationPageMobile extends UhcDriver{
	
	@FindBy(id = "enrollmentNext")
	private WebElement enrollmentNext;

	@FindBy(xpath = "//div[@class='enrollment_content']/div[2]/form/h2")
	private WebElement pageHeading;
	
	private PageData additionalInformation;

	public JSONObject additionalInformationJson;

	private JSONObject oleDTMJsonPart2;

	private PageData oleDtmObject;
	
	public AdditionalInformationPageMobile(WebDriver driver, String planName) {
		super(driver);
		PageFactory.initElements(driver, this);
		if (planName.contains("HMO")) {
			String fileName = CommonConstants.MA_ADDITIONAL_INFORMATION_PAGE_DATA;
			additionalInformation = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		}
		if (planName.contains("PDP")) {
			String fileName = CommonConstants.PDP_ADDITIONAL_INFORMATION_PAGE_DATA;
			additionalInformation = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		}

		openAndValidate();
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


	public ReviewApplicationPageMobile navigatesToNextStep(String planName) {
		enrollmentNext.click();
		if (pageHeading.getText().equalsIgnoreCase(
				"Step 4: Review Application")) {
			return new ReviewApplicationPageMobile(driver,planName);
		}
		return null;
		
	}


	public JSONObject validatesDTMobjPart2() {
		String fileName = CommonConstants.OLE_DTMOBJECT_PART2_PAGE_DATA;
		oleDtmObject = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : oleDtmObject.getExpectedData().keySet()) {
			WebElement element = findElement(oleDtmObject.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {

					JSONObject dtmObject = new JSONObject();
					if (element.getAttribute("dtmname") != null
							&& element.getAttribute("dtmid") != null) {
						try {
							dtmObject.put("dtmid", element.getAttribute("dtmid"));
							dtmObject.put("dtmname",
									element.getAttribute("dtmname"));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					
					try {
						jsonObject.put(key, dtmObject);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else{
						System.out.println("DTM id or DTM name was not found for Element:"+key);
					}
				
				}
				else{
					System.out.println("Validation failed for element::"+key);
				}
			}
		}
		
		try {
			jsonObject.put("dtmPageData", CommonUtility.checkForVariable(driver));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oleDTMJsonPart2 = jsonObject;

		return oleDTMJsonPart2;
	
		

	}

}
