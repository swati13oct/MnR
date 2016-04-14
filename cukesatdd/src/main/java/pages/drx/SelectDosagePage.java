/**
 * 
 */
package pages.drx;

import java.util.List;

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
 * @author pagarwa5
 *
 */
public class SelectDosagePage extends UhcDriver {
	
	@FindBy(id = "dosageQuantity")
	WebElement quantityField;
	
	@FindBy(id = "addDrugToList")
	WebElement addToDrugListButton;	

	public JSONObject drugDosageJson;
	
	private PageData drugDosageInfo;
	
	public SelectDosagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, quantityField,
				CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.DRUG_DOSAGE_PAGE_DATA;
		drugDosageInfo = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_DRX);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(quantityField);
		validate(addToDrugListButton);
		JSONObject jsonObject = new JSONObject();
		for (String key : drugDosageInfo.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(drugDosageInfo
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					if (elements.get(0).getText() != null
							&& !elements.get(0).getText().isEmpty()) {
						jsonObject.put(key, elements.get(0).getText());
					} else if (elements.get(0).getAttribute("placeholder") != null
							&& !elements.get(0).getAttribute("placeholder").isEmpty()) {
						jsonObject.put(key,
								elements.get(0).getAttribute("placeholder"));
					}
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
						jsonObjectForArray.put(key, element.getText());
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
		drugDosageJson = jsonObject;
		System.out.println("drugDosageJson----->" + drugDosageJson);

		
	}

}
