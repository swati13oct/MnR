package pages.member.ulayer;

/*@author pagarwa5*/

import java.util.List;
import java.util.Map;

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

public class MyPreferencesPage extends UhcDriver{

	@FindBy(id = "govt_delivery_preference_table")
	WebElement docTable;

	@FindBy(id = "updatePref")
	WebElement updatePrefButton;
	
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

	public void editDocDetails(Map<String, String> profileAttributesMap) {
		List<WebElement> allRows = docTable.findElements(By.tagName("tr"));
		for (int i=1;i<allRows.size();i++) {
			List<WebElement> cells = allRows.get(i).findElements(By.tagName("td"));
			WebElement documentElement = cells.get(0);

			if (profileAttributesMap.get("Document Name").equalsIgnoreCase(
					documentElement.getText())) {
				WebElement deliveryPrefElement = cells.get(1);
				List<WebElement> prefList = deliveryPrefElement.findElements(By
						.tagName("li"));
				for (WebElement deliveryPref : prefList) {
					if (deliveryPref
							.findElement(By.tagName("label"))
							.getText()
							.equalsIgnoreCase(
									profileAttributesMap
											.get("Delivery Preferences"))) {
						deliveryPref
								.findElement(
										By.tagName("input"))
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

	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : myPreferences.getExpectedData().keySet()) {
			WebElement element = findElement(myPreferences.getExpectedData()
					.get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		myPreferencesJson = jsonObject;
		
	}
	
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myProfilesPageExpectedJson = expectedDataMap
				.get(CommonConstants.MY_PREFERENCES);
		myProfilesPageExpectedJson = CommonUtility.mergeJson(
				myProfilesPageExpectedJson, globalExpectedJson);
		return myProfilesPageExpectedJson;
	}

	public MyPreferencesPage updatesDeliveryPreference(Map<String, String> prefAttributesMap) {
		
		String documentName = prefAttributesMap.get("Document Name");
		String deliveryPreference = prefAttributesMap
				.get("Delivery Preferences");

		List<WebElement> allRows = docTable.findElements(By.tagName("tr"));
		for (int i = 1; i < allRows.size(); i++) {
			List<WebElement> cells = allRows.get(i).findElements(
					By.tagName("td"));
			WebElement documentElement = cells.get(0);

			if (documentName.equalsIgnoreCase(documentElement.getText())) {
				WebElement deliveryPrefElement = cells.get(1);
				List<WebElement> prefList = deliveryPrefElement.findElements(By
						.tagName("li"));
				for (WebElement deliveryPref : prefList) {
					if (deliveryPref.findElement(By.tagName("label")).getText()
							.equalsIgnoreCase(deliveryPreference)) {
						deliveryPref.findElement(By.tagName("input")).click();
						break;
					}
				}

			}
		}

		updatePrefButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		if(currentUrl().contains("my-preferences"))
		{
			return new MyPreferencesPage(driver);
		}
		return null;
	
	}

}
