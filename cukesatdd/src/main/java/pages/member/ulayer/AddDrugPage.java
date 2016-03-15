/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class AddDrugPage extends UhcDriver {

	@FindBys(value = { @FindBy(xpath = "//div[@class='autoCompleteDrugs']") })
	private List<WebElement> drugListElements;

	@FindBys(value = { @FindBy(xpath = "//div[@class='drugDropDownList']/div") })
	private List<WebElement> drugListElements1;

	@FindBy(className = "drugDropDownList")
	private WebElement drugDropDownList;

	private PageData addDrug;

	public JSONObject addDrugJson;

	public AddDrugPage(WebDriver driver) {
		super(driver);
		String fileName = CommonConstants.ADD_DRUG_ULAYER_PAGE_DATA;
		addDrug = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		openAndValidate();
	}

	public DrugDosagePage selectDrug(String drugName) {

		String drugXpath = "//*[contains(text(),'" + drugName + "')]";

		ElementData elementData = new ElementData("xpath", drugXpath);
		findElement(elementData).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
			return new DrugDosagePage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : addDrug.getExpectedData().keySet()) {
			WebElement element = findElement(addDrug.getExpectedData().get(key));
			if (null != element) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		addDrugJson = jsonObject;
		
		System.out.println("addDrugJson----->"+addDrugJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String drugInitials) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject addDrugExpectedJson = null;
		try {
			addDrugExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.ADD_DRUG).get(drugInitials);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addDrugExpectedJson = CommonUtility.mergeJson(addDrugExpectedJson,
				globalExpectedJson);
		return addDrugExpectedJson;
	}

}
