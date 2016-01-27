package pages.member.bluelayer;

/*@author pagarwa5*/

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MyPrefPage extends UhcDriver {

	@FindBy(id = "govt_delivery_preference_table")
	WebElement docTable;

	@FindBy(linkText = "update preferences")
	WebElement updatePrefButton;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData myPreferences;

	public JSONObject myPreferencesJson;

	public MyPrefPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PREFERENCES_PAGE_DATA;
		myPreferences = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public String getDocDeliveryPrefs() {
		return docTable.getText();
	}

	public void editDocDetails(Map<String, String> profileAttributesMap) {
		List<WebElement> allRows = docTable.findElements(By.tagName("tr"));
		for (int i = 1; i < allRows.size(); i++) {
			List<WebElement> cells = allRows.get(i).findElements(
					By.tagName("td"));
			WebElement documentElement = cells.get(0);

			if (profileAttributesMap.get("Document Name").equalsIgnoreCase(
					documentElement.getText())) {
				WebElement deliveryPrefElement = cells.get(1);
				List<WebElement> prefList = deliveryPrefElement.findElements(By
						.tagName("li"));

				for (WebElement deliveryPref : prefList) {
					System.out.println(deliveryPref.getText());
					if (deliveryPref.getText().equalsIgnoreCase(
							profileAttributesMap.get("Delivery Preferences"))) {
						deliveryPref.findElement(By.name("preference0"))
								.click();
						break;
					}
				}

			}
		}

	}

	public void clickUpdatePref() {
		updatePrefButton.click();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			boolean isUpdate) {

		/* get MY PREFERENCES expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject commonPrefExpectedJson = expectedDataMap
				.get(CommonConstants.PREFERENCES_COMMON);

		JSONObject myPreferencesExpectedJson = expectedDataMap
				.get(isUpdate ? CommonConstants.MY_PREFERENCES_AFTER_UPDATE
						: CommonConstants.MY_PREFERENCES_BEFORE_UPDATE);
		myPreferencesExpectedJson = CommonUtility.mergeJson(
				myPreferencesExpectedJson, globalExpectedJson);
		myPreferencesExpectedJson = CommonUtility.mergeJson(
				myPreferencesExpectedJson, commonPrefExpectedJson);

		return myPreferencesExpectedJson;

	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : myPreferences.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(myPreferences
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (elementFound(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (int i = 1; i < elements.size(); i++) {
					validate(elements.get(i));
					try {
						List<WebElement> columns = elements.get(i)
								.findElements(By.tagName("td"));
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put("documentName", columns.get(0).getText());
						List<WebElement> prefList = columns.get(1)
								.findElements(By.tagName("li"));
						for (WebElement pref : prefList) {
							if (pref.findElement(By.tagName("input"))
									.isSelected()) {
								/*
								 * String prefName = pref.findElement(
								 * By.tagName("label")).getText();
								 */
								jsonObjectForArray.put("selectedPreference",
										pref.getText());
								break;
							}
						}

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
		myPreferencesJson = jsonObject;

	}

	public void logOut() {
		logOut.click();
	}
}
