package pages.member_deprecated.ulayer;

/*@author pagarwa5*/

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MyPreferencesPage extends UhcDriver {

	@FindBy(id = "govt_delivery_preference_table")
	private WebElement docTable;

	@FindBys(value = { @FindBy(xpath = "//table[@id='govt_delivery_preference_table']/tbody/tr") })
	List<WebElement> preferencetable;

	@FindBy(id = "updatePref")
	private WebElement updatePrefButton;

	@FindBy(xpath = "//div[@class='myProfileMid']/div/form/div/div/div/div[2]/div/div[2]/h3")
	private WebElement preferencesPageHeading;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData myPreferences;

	public JSONObject myPreferencesJson;

	public MyPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PREFERENCES_PAGE_DATA;
		myPreferences = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public String getDocDeliveryPrefs() {
		return docTable.getText();
	}

	public void logOut() {
		logOut.click();

	}

	public void editDocDetails(String preferences) {

		String[] prefArray = preferences.split(",");

		for (String perference : prefArray) {

			String[] preferenceArray = perference.split(":");

			String documentName = preferenceArray[0];
			String preferenceName = preferenceArray[1];

			for (int i = 1; i < preferencetable.size(); i++) {

				WebElement prefNameElement = findChildElement(new ElementData(
						"className", "leftsidetd"), preferencetable.get(i));
				WebElement onlinePrefElement = findChildElement(
						new ElementData("className", "eleclink"),
						preferencetable.get(i));
				WebElement mailPrefElement = findChildElement(new ElementData(
						"className", "paperlink"), preferencetable.get(i));

				if (documentName.equalsIgnoreCase(prefNameElement.getText())) {
					if (preferenceName.equalsIgnoreCase("Online")) {
						findChildElement(new ElementData("tagName", "input"),
								onlinePrefElement).click();

					}
					if (preferenceName.equalsIgnoreCase("U.S. Mail")) {
						findChildElement(new ElementData("tagName", "input"),
								mailPrefElement).click();
					}

				}

			}

		}

	}

	public void clickUpdatePref() {
		updatePrefButton.click();
	}

	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : myPreferences.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(myPreferences
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
				elements.remove(0); // Removing first element as we have nothing
				// to do with it
				for (WebElement element : elements) {

					WebElement prefNameElement = findChildElement(
							new ElementData("className", "leftsidetd"), element);
					WebElement onlinePrefElement = findChildElement(
							new ElementData("className", "eleclink"), element);
					WebElement mailPrefElement = findChildElement(
							new ElementData("className", "paperlink"), element);

					String prefType = null;
					if (findChildElement(new ElementData("tagName", "input"),
							onlinePrefElement).isSelected()) {
						prefType = findChildElement(
								new ElementData("tagName", "label"),
								onlinePrefElement).getText();

					}
					if (findChildElement(new ElementData("tagName", "input"),
							mailPrefElement).isSelected()) {
						prefType = findChildElement(
								new ElementData("tagName", "label"),
								mailPrefElement).getText();

					}

					JSONObject jsonObjectForArray = new JSONObject();
					try {
						jsonObjectForArray.put("documentName",
								prefNameElement.getText());
						jsonObjectForArray.put("deliveryPreference", prefType);

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
		
		System.out.println("myPreferencesJson----->"+myPreferencesJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String key) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myPreferencesExpectedJson = expectedDataMap
				.get(CommonConstants.MY_PREFERENCES);
		try {
			myPreferencesExpectedJson = (JSONObject) myPreferencesExpectedJson
					.get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myPreferencesExpectedJson = CommonUtility.mergeJson(
				myPreferencesExpectedJson, globalExpectedJson);
		return myPreferencesExpectedJson;
	}

	public MyPreferencesPage updatesDeliveryPreference() {
		updatePrefButton.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, preferencesPageHeading, 10);
		if (currentUrl().contains("my-preferences")) {
			return new MyPreferencesPage(driver);
		}
		return null;

	}

	public MyPreferencesPage resetPreferences(JSONObject myPreferencesJson) {

		JSONArray myPreferencesArrayJson = null;
		try {
			myPreferencesArrayJson = (JSONArray) myPreferencesJson
					.get("preferences");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int j = 0; j < myPreferencesArrayJson.length(); j++) {

			String documentName = null;
			String preferenceName = null;
			try {

				documentName = (String) myPreferencesArrayJson.getJSONObject(j)
						.get("documentName");
				preferenceName = (String) myPreferencesArrayJson.getJSONObject(
						j).get("deliveryPreference");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 1; i < preferencetable.size(); i++) {

				WebElement prefNameElement = findChildElement(new ElementData(
						"className", "leftsidetd"), preferencetable.get(i));
				WebElement onlinePrefElement = findChildElement(
						new ElementData("className", "eleclink"),
						preferencetable.get(i));
				WebElement mailPrefElement = findChildElement(new ElementData(
						"className", "paperlink"), preferencetable.get(i));

				if (documentName.equalsIgnoreCase(prefNameElement.getText())) {
					if (preferenceName.equalsIgnoreCase("Online")) {
						findChildElement(new ElementData("tagName", "input"),
								onlinePrefElement).click();

					}
					if (preferenceName.equalsIgnoreCase("U.S. Mail")) {
						findChildElement(new ElementData("tagName", "input"),
								mailPrefElement).click();
					}

				}

			}

		}

		updatePrefButton.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoad(driver, preferencesPageHeading, 10);
		if (currentUrl().contains("my-preferences")) {
			return new MyPreferencesPage(driver);
		}
		return null;

	}

}
