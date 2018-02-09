/**
 * 
 */
package pages.redesign;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PharmacyResultPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath = "//*[@class='pharmacy-info']")
	private List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	private WebElement PharmacyFoundCount;

	private PageData pharmacyResult;

	public JSONObject pharmacyResultJson;

	public PharmacyResultPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PHARMACY_RESULT_PAGE_DATA;
		pharmacyResult = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validate(logOut);
		JSONObject jsonObject = new JSONObject();
		for (String key : pharmacyResult.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(pharmacyResult
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(pharmacyResult.getExpectedData()
								.get(key).getElementName(), element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		pharmacyResultJson = jsonObject;
		
		System.out.println("pharmacyResultJson----->"+pharmacyResultJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject pharmacyResultExpectedJson = expectedDataMap
				.get(CommonConstants.PHARMACY_RESULT);
		pharmacyResultExpectedJson = CommonUtility.mergeJson(
				pharmacyResultExpectedJson, globalExpectedJson);
		return pharmacyResultExpectedJson;
	}
	
	

}
