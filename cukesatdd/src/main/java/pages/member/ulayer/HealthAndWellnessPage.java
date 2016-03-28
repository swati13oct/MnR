/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
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
 * @author pjaising
 *
 */
public class HealthAndWellnessPage extends UhcDriver {
	
	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData healthAndWelless;

	public JSONObject healthAndWellessJson;

	public HealthAndWellnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.HEALTH_AND_WELLNESS_PAGE_DATA;
		healthAndWelless = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : healthAndWelless.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(healthAndWelless
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(key, element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
		healthAndWellessJson = jsonObject;
		
		System.out.println("healthAndWellessJson----->"+healthAndWellessJson);

	}
	
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject healthAndWellnessExpectedJson = expectedDataMap
				.get(CommonConstants.HEALTH_AND_WELLNESS);
		healthAndWellnessExpectedJson = CommonUtility.mergeJson(
				healthAndWellnessExpectedJson, globalExpectedJson);
		return healthAndWellnessExpectedJson;

	}

	public void logout() {
		logOut.click();
		
	}

}
