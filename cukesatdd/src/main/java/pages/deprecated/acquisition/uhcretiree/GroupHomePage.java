package pages.deprecated.acquisition.uhcretiree;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class GroupHomePage extends UhcDriver { 

	@Override
	public void openAndValidate() {

	//	start(UHCRETIREE_ACQISITION_PAGE_URL);

	}


	public JSONObject browserCheckJson;
	private PageData browserCheckData;

	private static String UHCRETIREE_ACQISITION_PAGE_URL = MRConstants.UHCRETIREE_URL;

	public GroupHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.GR_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
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
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}


}