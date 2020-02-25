/**
 * 
 */
package pages.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ZipcodeSelectionHomePage extends UhcDriver {

	private PageData zipSelectionhome;

	public JSONObject zipSelectionhomeJson;

	public ZipcodeSelectionHomePage(WebDriver driver) {
		super(driver);
		String fileName = CommonConstants.ZIPCODE_SELECTION_HOME_PAGE_DATA;
		zipSelectionhome = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : zipSelectionhome.getExpectedData().keySet()) {
			WebElement element = findElement(zipSelectionhome.getExpectedData()
					.get(key));
			if (null != element) {
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
		zipSelectionhomeJson = jsonObject;
	}
}
